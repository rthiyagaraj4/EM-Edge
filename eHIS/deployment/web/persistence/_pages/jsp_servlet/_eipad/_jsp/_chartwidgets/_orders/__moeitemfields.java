package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryQueryBean;
import eOR.Common.OrderEntryRecordBean;
import java.util.ResourceBundle;
import java.util.ArrayList;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eOR.OrderEntryBean;
import eOR.OrderEntryBillingQueryBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeitemfields extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoeItemFields.jsp", 1709118018600L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\nvar ordEntryFormFieldScroll;\n\nfunction initOrderFldsScroller() {\n\tordEntryFormFieldScroll = new IScroll(\'#wrapper\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tpreventDefault: false,\n\t\tdisableMouse: false,\n    disablePointer: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n}\n\nfunction StringToDate(string){\n\tvar d = new Date();\n\t//var str=\'01/07/2013 11:18:13\';\n\tvar datenum,month,year;\n\tvar hr=0, min=0, sec=0;\n\tvar datetimearr = string.split(\" \");\n\tif(datetimearr[0]){\n\t\tvar datearr = datetimearr[0].split(\"/\");\n\t\tif(datearr[0])\n\t\t\tdatenum = parseInt(datearr[0]);\n\t\tif(datearr[1])\n\t\t\tmonth = parseInt(datearr[1]);\n\t\tif(datearr[2])\n\t\t\tyear = parseInt(datearr[2]);\n\t}\n\tif(datetimearr[1]){\n\t\tvar timearr = datetimearr[1].split(\":\");\n\t\tif(timearr[0])\n\t\t\thr = parseInt(timearr[0]);\n\t\tif(timearr[1])\n\t\t\tmin = parseInt(timearr[1]);\n\t\tif(timearr[2])\n\t\t\tsec = parseInt(timearr[2]);\n\t}\n\t\n\td.setDate(datenum);\n\td.setMonth(month-1);\n\td.setFullYear(year);\n\t//if(hr!=0)\n\td.setHours(hr);\n\t//if(min!=0)\n\td.setMinutes(min);\n\t//if(sec!=0)\n\td.setSeconds(sec);\n\treturn d;\n}\n\nfunction twoDigits(num){\n\tif(num<10)\n\t\tnum = \"0\" + num;\n\treturn num;\n}\n\nfunction DMYHMSToString(dateobj){\n\tvar d = new Date();\n\tif(dateobj){\n\t\td = dateobj;\n\t}\n\t//--15/07/2013 10:45:06\n\tvar stringDate = twoDigits(d.getDate()) + \"/\" + twoDigits((d.getMonth()+1)) + \"/\" + twoDigits(d.getFullYear()) + \" \" + twoDigits(d.getHours()) + \":\" + twoDigits(d.getMinutes()) + \":\" + twoDigits(d.getSeconds());\n\treturn stringDate;\n}\n\nfunction DMYHMToString(dateobj){\n\tvar d = new Date();\n\tif(dateobj){\n\t\td = dateobj;\n\t}\n\t//--15/07/2013 10:45\n\tvar stringDate = twoDigits(d.getDate()) + \"/\" + twoDigits((d.getMonth()+1)) + \"/\" + twoDigits(d.getFullYear()) + \" \" + twoDigits(d.getHours()) + \":\" + twoDigits(d.getMinutes());\n\treturn stringDate;\n}\n\nfunction DMYToString(dateobj){\n\tvar d = new Date();\n\tif(dateobj){\n\t\td = dateobj;\n\t}\n\t//--15/07/2013\n\tvar stringDate = twoDigits(d.getDate()) + \"/\" + twoDigits((d.getMonth()+1)) + \"/\" + twoDigits(d.getFullYear());\n\treturn stringDate;\n}\n\n/* function submitOrderFields(){\n\tvar bean_id = $(\"#or_bean_id\").val();\n\tvar bean_name = $(\"#or_bean_name\").val();\n\tvar orderCatalogCode = $(\"#OrderCatalogCode\").val();\n\tvar orderTypeCode = $(\"#OrderTypeCode\").val();\n\tvar orderCategoryCode = $(\"#OrderCatCode\").val();\n\tif($.inArray(orderCatalogCode, parent.selectedOrders) == -1){\n\t\tparent.selectedOrders.push(orderCatalogCode);\n\t}\n\tvar check_box_value = getSelOrdersCsvCkPrefix(); //Catalog Codes of All the selected Orders\n\t\n\t$.ajax({\n        //url: path + \"/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value=\"+check_box_value+\"&OrderCatalogCode=\"+orderCatalogCode+\"&OrderTypeCode=\"+orderTypeCode+\"&OrderCatCode=\"+orderCategoryCode,\n        type: \"POST\",\n        url: path + \"/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value=\"+check_box_value,\n        data: $(\"#frmOrderFields\").serialize(),\n        success: function(response) {\n            //alert(\"Success \" + response);\n\t\t\tvar trimResponse = $.trim(response);\n            \n            \tparent.closeOrderFields_basepage();\n            \tparent.refreshOrderCart();\n          \n\t\t},\n\t\terror: function (xhr, ajaxOptions, thrownError) {\n\t\t\talert(\"Error in adding the order\");\n\t\t\tparent.selectedOrders.pop(orderCatalogCode);\n\t\t}\n\t\t//end ajax options\n\t});//end ajax \n\n\t//alert(parent.selectedOrders.valueOf());\n\t//alert(check_box_value);\n} */\n//Because OrderEntryStoreValues.jsp expects selected values with CK prefix\nfunction getSelOrdersCsvCkPrefix(){\n\tvar ckArray = [];\n\tfor(var i=0;i<parent.selectedOrders.length;i++){\n\t\tvar ckVal = \"ck\"+parent.selectedOrders[i];\n\t\tckArray.push(ckVal);\n\t}\n\treturn ckArray.valueOf();\n}\nfunction showOrderSetTab(ordCode){\n\tvar curTab = $(\"#CurrentOpenTab\").val();\n\t$(\"#OrderSetFieldWrap\"+curTab).hide();\n\t$(\"#OrderSetFieldWrap\"+ordCode).show();\n\t$(\"#CurrentOpenTab\").val(ordCode);\n\t$(\"#OrderSetTab\"+ordCode).removeClass(\"widgetTabNonActiveTheme\").addClass(\"widgetTabActiveTheme\");\n\t$(\"#OrderSetTab\"+curTab).removeClass(\"widgetTabActiveTheme\").addClass(\"widgetTabNonActiveTheme\");\n}\nfunction isNumberKey(evt){\n    var charCode = (evt.which) ? evt.which : event.keyCode\n    if (charCode > 31 && (charCode < 48 || charCode > 57))\n        return false;\n    return true;\n}\n/* function isDecimalNumberKey(evt){\n    var charCode = (evt.which) ? evt.which : event.keyCode\n    if (charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode > 57)))\n        return false;\n    return true;\n} */\n$(document).ready(function(){\n\tinitOrderFldsScroller()\n});\n\n</script>\n<style>\n.cstNumericTxtBox{\n\ttext-align: right;\n\twidth: calc(100% - 12px);\n\theight: calc(100% - 5px);\n\tborder: none;\n}\n\n</style>\n\n<div id=\"wrapper\" style=\"position: absolute;width: 100%;height:100%;overflow: hidden;\">\n\t<div class=\"container ordFldsScroller divAllergyContentTheme\" id=\"scroller\">\n\t\n\t\n<!-- Fields and its values are taken from OrderEntryPlaceOrderResult.jsp and OrderEntryPlaceOrderCareSetResults.jsp -->\n\n\n\n\n\t<!-- <div class=\"divParent\" data-role=\"page\" style=\"padding: 0px\"> -->\n\t\t<form name = \"frmOrderFields\" id = \"frmOrderFields\" style=\"width: 100%; height: 100%\" action=\"\">\n\t\t\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\"></div>\n\t\t\t<!-- popup container -->\n\t\t\t<div data-role=\"none\" class=\"diagSfs sfsIPTheme\" id=\"sfs\">\n\t\t\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style=\"display: block;\"\n\t\t\t\t\tscrolling=\"no\" height=\"400px\" width=\"740px\" src=\"\"></iframe>\n\t\t\t</div>\n\t\t\t<!-- popup container ends -->\n\t\t\t\n\t\t\t\t<!-- <div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\tcontainer start\t\n -->\n\t\t\t<!-- <div class=\"cstFormHeader\" data-role=\"none\">\n\t\t\t\t<span class=\"cstheaderTextTheme\" data-role=\"none\">Complaint Details</span>\n\t\t\t</div>\n\t \t\t<div class=\"cstRowDivider\"></div>\n -->\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<!-- Order Item Header Starts -->\t\n\t\t\t<div class=\"ordFldHeader\">\n  \t\t\t\t<div class=\"ordFldHdrRow\">\n\t\t\t\t    <div class=\"cell\">\n\t\t\t\t    \t<div class=\"ordFldHdrTbl\">\n\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t          \t\t<div class=\"ordFldHdrTxtCell\">\n\t\t\t\t\t\t        \t<div class=\"ordFldHdrTitleTheme\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</div>\n\t\t\t\t\t\t            <div class=\"ordFldHdrPractTbl\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrPractCell\">\n\t\t\t\t\t\t\t\t\t\t \t<div class=\"ordFldHdrPractLblTheme\">Attend. Practitioner </div>\n\t\t\t\t\t\t\t\t\t\t  \t<div class=\"ordFldHdrPractTxtTheme\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrPractCell\">\n\t\t\t\t\t\t\t\t\t\t  \t<div class=\"ordFldHdrPractLblTheme\">Ordering Practitioner </div>\n\t\t\t\t\t\t\t\t\t\t  \t<div class=\"ordFldHdrPractTxtTheme\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t            </div>\n\t\t\t\t          \t\t</div>\n\t\t\t\t          \t\t\n\t\t\t\t          \t\t\n\t\t\t\t\t          \t<div class=\"ordFldHdrIconCell\">\n\t\t\t\t\t          \t\t<div class=\"ordFldHdrIconHolder\">\n\t\t\t\t\t          \t\t<!-- Authorization Required Starts -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t              \t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t                  \t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos actionTickIcon\" id=\"AuthorizeIcon";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> <img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/Authorize24x24.png\" width=\"20\" height=\"20\" onclick=\"showAuthorizedMsg()\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos\" id=\"AuthorizeIcon";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/Authorize24x24.png\" width=\"20\" height=\"20\" onclick=\"authorizeOrder(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconPos imgGrayscale\"> <img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/Authorize24x24.png\" width=\"20\" height=\"20\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t            \n\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            <!-- Authorization Required Ends -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            <!-- Cosign Required Starts -->\n\t\t\t\t\t\t              \t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos actionTickIcon\" id=\"CosignIcon";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/Cosign24x24.png\" width=\"20\" height=\"20\" onclick=\"showCosignedMsg()\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos\" id=\"CosignIcon";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/Cosign24x24.png\" width=\"20\" height=\"20\" onclick=\"cosignOrder(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\" /> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/Cosign24x24.png\" width=\"20\" height=\"20\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t            <!-- Cosign Required Ends -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            <!-- Special Approval Required Starts -->\n\t\t\t\t\t\t              \t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t                  \t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos actionTickIcon\" id=\"SpecialApproveIcon";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/SpecialApproval24x24.png\" width=\"20\" height=\"20\" onclick=\"showSpecialApprovedMsg()\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos\" id=\"SpecialApproveIcon";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eIPAD/images/SpecialApproval24x24.png\" width=\"20\" height=\"20\" onclick=\"specialApproveOrder(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/eIPAD/images/SpecialApproval24x24.png\" width=\"20\" height=\"20\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            <!-- Special Approval Required Ends -->\n\t\t\t\t\t\t            <!-- Consent Required Starts -->\n\t\t\t\t\t\t              \t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos actionTickIcon\"> <img src=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="/eIPAD/images/Consent24x24.png\" width=\"20\" height=\"20\" onclick=\"showConsentedMessage()\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t                \t<div class=\"ordFldHdrIconPos\"> <img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eIPAD/images/Consent24x24.png\" width=\"20\" height=\"20\" onclick=\"showConsentMessage()\"/> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="/eIPAD/images/Consent24x24.png\" width=\"20\" height=\"20\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t            <!-- Consent Required Ends -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            <!-- Explanatory Text Starts -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t                  \t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="/eIPAD/images/About24x24.png\" width=\"20\" height=\"20\"  /> </div>\n\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t            \t<div class=\"ordFldHdrIconPos imgGrayscale\"> <img src=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="/eIPAD/images/About24x24.png\" width=\"20\" height=\"20\" /></div>\n\t\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t            <!-- Explanatory Text Ends -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"float: right;\">\n\t\t\t\t\t\t\t                <div class=\"cell\">\n\t\t\t\t\t\t\t                  \t<div class=\"ordFldHdrIconCircTheme\">\n\t\t\t\t\t\t\t                  \t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/eIPAD/images/SecondaryOrders24x24.png\" width=\"20\" height=\"20\" /> </div>\n\t\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"ordFldHdrIconPos imgGrayscale\"> <img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/SecondaryOrders24x24.png\" width=\"20\" height=\"20\" /> </div>\n\t\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t              \t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t \t\t\n\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t            \n\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t \t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrPrice\"> <span class=\"ordFldHdrPriceLblTheme\">Order Price:</span> <span class=\"ordFldHdrPriceTxtTheme\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</span> <span class=\"ordFldHdrPriceLblTheme\">Patient Price:</span> <span class=\"ordFldHdrPriceTxtTheme\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</span> </div>\n\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t              \t\n\t\t\t\t\t\t            </div>\n\t\t\t\t\t          \t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t      \t</div>\n\t\t\t\t    </div>\n  \t\t\t\t</div>\n  \t\t\t\t<div  class=\"row\">\n    \t\t\t\t<div class=\"ordFldHdrBorder\"> </div>\n  \t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- Order Item Header Ends -->\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<!-- Clinical Comments field Starts -->\t\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t \t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Clinical Comments\n\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t \t\t\t\t\t\t<font style=\"color: red\">*</font>\n\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"2000\"  data-role=\"none\" id=\"ClinComments\" name=\"ClinComments\" style=\"display: block\" rows=\"50\" cols=\"10\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</textarea>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\t\t\n\t\t\t<!-- Clinical Comments field Ends -->\t\n\t\t\t\t\n\t\t\t<!-- Start date field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"StartDate-";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="_Label\">Start Date<font style=\"color: red\">*</font></div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t \t\t\t\t\t\t<!-- Error Message Container for start date -->\n\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"StartDate-";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"StartDate-";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t<input id=\"StartDate-";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" name=\"StartDate-";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Validation error Message\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t                $(\"#StartDate-";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\").kendoDateTimePicker({\n\t\t\t\t\t\t\t        \t\t\tformat: \"dd/MM/yyyy HH:mm\",\n\t\t\t\t\t\t\t        \t\t\tvalue: StringToDate(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\')\n\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t        <input type=\"hidden\" id=\"hdnStartDateTime-";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" name=\"hdnStartDateTime-";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" value=\"\">\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t\t\t\t\t\n   \t    \t<!-- Start Date field Ends -->\n\t\t\t\n\t\t\t<!-- End date field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"EndDate-";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="_Label\">End Date</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\" >\n\t\t \t\t\t\t\t\t<!-- Error Message Container for onset date -->\n\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"EndDate-";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"EndDate-";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t<input id=\"EndDate-";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" name=\"EndDate-";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some validation error\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t                $(\"#EndDate-";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\").kendoDateTimePicker({\n\t\t\t\t\t\t\t        \t\t\tformat: \"dd/MM/yyyy HH:mm\",\n\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t                $(\"#EndDate-";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\").data(\"kendoDateTimePicker\").readonly();\n\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t        <input type=\"hidden\" id=\"hdnEndDateTime-";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" name=\"hdnEndDateTime-";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"\">\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- End Date field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t\n\t\t \t<!-- Order Type field Starts -->\n\t\t \t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"OrderType-";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="_Label\">Order Type</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\">\n\t\t \t\t\t\t\t\t<!-- Error Message Container for complaint code -->\n\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"OrderType-";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"OrderType-";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t</div> \n\t\t \t\t\t\t\t\t<select id=\"OrderType-";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" name=\"OrderType-";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" selected>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t$(\"#OrderType-";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t                            \t$(\"#OrderType-";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\").val(\"\");\n\t\t\t\t\t                            }\n\t\t\t\t\t                            else{\n\t\t\t\t\t                            \t$(\"#OrderType-";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\").val(this.value());\n\t\t\t\t\t                            }\n\t\t\t\t\t                          },\n\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t $(\"#OrderType-";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\").data(\"kendoComboBox\").readonly();\n\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t</script>\n\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\n\t\t\t<!-- Order Type field Ends -->\t\n\t\t\t\n\t\t\t<!-- Priority Field Starts -->\t\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Priority</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div id=\"PrioritySlider-";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" class=\"scale scaleTheme2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"PrioritySlidePointer-";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\tdata-parent = \"PrioritySlider-";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" data-numpoints=\"3\" data-drag=\"Y\" data-dragdiv=\"PriorityScaleHover-";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" \n\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"Priority-";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" data-value1=\"R\" data-value2=\"U\" data-value3=\"S\" data-defaultvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" \n\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"Priority-";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" name=\"Priority-";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"PriorityScaleHover-";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"></div>\n\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator3 scaleSeparatorTheme\"></div>\n\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<!-- <div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-1\">Normal</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 45%\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-2\">High</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-3\">Critical</div>\n\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:20px;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="-1\" data-labelval=\"1\" >Routine</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="-2\" data-labelval=\"2\" >Urgent</div>\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="-3\" data-labelval=\"3\" >Stat</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t\t<script>\n\t\t \t\t\t\t\t\t$(document).ready(function() {\n\t\t \t\t\t\t\t\t\t$(\'#PrioritySlidePointer-";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\').sliderGenericControl();\n\t\t \t\t\t\t\t\t});\n\t\t \t\t\t\t\t</script>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\t\t\t\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Priority field Ends -->\n\t\t\t\n\t\t\t<!-- Quantity field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"Quantity-";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="_Label\">Quantity<font style=\"color: red\">*</font></div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t \t\t\t\t\t\t<!-- Error Message Container for start date -->\n\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"Quantity-";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"Quantity-";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"QuantityReadOnlyYN-";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" />\n\t\t\t\t\t\t\t\t<input id=\"Quantity-";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Validation error Message\" data-mandatory=\"true\" type=\"number\" class=\"cstNumericTxtBox\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"/> \n\t\t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<!-- Unit of Measure -->\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\" class=\"cstUomTxtTheme\">\n\t\t \t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t \t\t\t\t</div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t\t\t\t\t\n   \t    \t<!-- Quantity field Ends -->\n   \t    \t\n   \t    \t<!-- Frequency field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"Frequency-";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="_Label\">Frequency</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\">\n\t\t \t\t\t\t\t\t<!-- Error Message Container for complaint code -->\n\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"Frequency-";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"Frequency-";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t<select id=\"Frequency-";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" name=\"Frequency-";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</option>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</option>\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\" disabled>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t$(\"#Frequency-";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t                            \t$(\"#Frequency-";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\").val(\"\");\n\t\t\t\t\t                            }\n\t\t\t\t\t                            else{\n\t\t\t\t\t                            \t//$(\"#Frequency\").val(this.value());\n\t\t\t\t\t                            }\n\t\t\t\t\t                          },\n\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t //$(\"#Frequency\").data(\"kendoComboBox\").readonly();\n\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t</script>\n\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\t\n\t\t\t<!-- Frequency field Ends -->\t\n\t\t\t\n\t\t\t<!-- Duration field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"Duration-";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="_Label\">Duration</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t \t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t \t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:60%\">\n\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer3\">\n \t\t\t\t\t\t\t\t\t\t\t\t<!-- Error Message Container for complaint code -->\n\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"Duration-";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"Duration-";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<select id=\"Duration-";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" name=\"Duration-";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\">\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#Duration-";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t\t                            \t$(\"#Duration-";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\").val(\"\");\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t\t                            \t//$(\"#Frequency\").val(this.value());\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                          },\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t $(\"#Duration-";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\").data(\"kendoComboBox\").readonly();\n\t\t\t\t\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\">\n\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer1 \">\n\t\t \t\t\t\t\t\t\t\t\t\t<input id=\"DurationNum-";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Validation error Message\" data-mandatory=\"true\" type=\"number\" class=\"cstNumericTxtBox\"/> \n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Duration field Ends -->\n   \t    \t\n   \t    \t<!-- Performing Location field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"PerformingLocation-";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="_Label\">Performing Location</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t \t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t \t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:50%\">\n\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer3\">\n \t\t\t\t\t\t\t\t\t\t\t\t<!-- Error Message Container for complaint code -->\n\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"PerformingLocation-";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"PerformingLocation-";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<select id=\"PerformingLocation-";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" name=\"PerformingLocation-";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\">\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\t\t\t \t\t\t<option value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</option>\t\n\t\t\t\t\t\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t\t\t\t \t\t</select>\n\t\t\t\t\t\t\t\t\t\t \t\t<input type=\"hidden\" name=\"hdnPerformingLocReadOnly-";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"hdnPerformingLocReadOnly-";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t\t\t\t\t\t\t\t\t\t \t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t \t\t\t<input type=\"hidden\" name=\"hdnPerformingLocReadOnly-";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" value=\"Y\">\n\t\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#PerformingLocation-";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                          },\n\t\t\t\t\t\t\t\t\t                          value:\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif($(\"#hdnPerformingLocReadOnly-";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\").val()==\"Y\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#PerformingLocation-";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\").data(\"kendoComboBox\").readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\">\n\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer1 \">\n\t\t \t\t\t\t\t\t\t\t\t\t<select id=\"PerformingDept-";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" name=\"PerformingDept-";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"\"\n\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Error Message\">\n\t\t \t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t\t\t\t \t\t\t\t<option value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</option>\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPerformingDeptReadOnly-";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" name=\"hdnPerformingDeptReadOnly-";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t \t\t</select>\n\t\t\t\t\t\t\t\t\t \t\t\t<input type=\"hidden\" id=\"hdnPerformingDeptReadOnly-";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" value=\"Y\">\n\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#PerformingDept-";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t\t                            \t//$(\"#PerformingLocation\").val(\"\");\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t\t                            \t//$(\"#Frequency\").val(this.value());\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                          },\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif($(\"#hdnPerformingDeptReadOnly-";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\").val()==\"Y\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#PerformingDept-";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\").data(\"kendoComboBox\").readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t //$(\"#Frequency\").data(\"kendoComboBox\").readonly();\n\t\t\t\t\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t\t\t</script> \n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Performing Location field Ends -->\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t \t\t\n\t\t \t\t\n\t\t \t\t\n\t\t \t\t\n\t\t \t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\n\t\t \t\t\n\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t \t\t<!-- <div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrPrice\"> <span class=\"ordFldHdrPriceLblTheme\">Billing Details not available</span></div>\n\t\t\t\t\t\t            </div> -->\n\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t              \t\n\t\t\t\t\t\t            </div>\n\t\t\t\t\t          \t</div>\n\t\t\t\t\t        </div>\n\t\t\t\t      \t</div>\n\t\t\t\t    </div>\n  \t\t\t\t</div>\n  \t\t\t\t<div  class=\"row\">\n    \t\t\t\t<div class=\"ordFldHdrBorder\"> </div>\n  \t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- Order Item Header Ends -->\t\n\t\t\t\n\t\t\t<!-- Clinical Comments field Starts -->\t\n\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\t\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"2000\"  data-role=\"none\" id=\"txtRemarks\" name=\"txtRemarks\" style=\"display: block\" rows=\"50\" cols=\"10\"></textarea>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\t\t\n\t\t\t<!-- Clinical Comments field Ends -->\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t<div style=\"display:table;width:100%;\" class=\"widgetTabNonActiveTheme\">\n\t\t\t\t\t<div class=\"widgetleftview\">\n\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"widgetTab widgetTabActiveTheme\" id=\"OrderSetTab";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" onclick=\"showOrderSetTab(\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\')\"><div class=\"widgetItemTxt\">";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</div></div>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"CurrentOpenTab\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\t\t\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"widgetTab widgetTabNonActiveTheme\" id=\"OrderSetTab";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</div></div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t<div style=\"display:table-cell;width:98%\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t<div id=\"OrderSetFieldWrap";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" style=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\t\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t<!-- Start date field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"StartDate-";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"  style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Validation error Message\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t                $(\"#StartDate-";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" value=\"\">\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t\t\t\t\t\n   \t    \t<!-- Start Date field Ends -->\n   \t    \t\n   \t    \t<!-- End date field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"EndDate-";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some validation error\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t                $(\"#EndDate-";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" value=\"\">\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- End Date field Ends -->\n   \t    \t\n   \t    \t<!-- Order Type field Starts -->\n\t\t \t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\').sliderGenericControl();\n\t\t \t\t\t\t\t\t});\n\t\t \t\t\t\t\t</script>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\t\t\t\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Priority field Ends -->\n   \t    \n\t\t\t<!-- Quantity field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"StartDate-";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" \n\t\t\t\t\t\t\t\t\tpattern=\"[0-9]\" ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =" readOnly=\'readonly\' ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" onkeypress=\"return isNumberKey(event)\"/> \n\t\t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<!-- Unit of Measure -->\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\" class=\"cstUomTxtTheme\">\n\t\t \t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t \t\t\t\t</div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t\t\t\t\t\n   \t    \t<!-- Quantity field Ends -->\t\n   \t    \t\n   \t    \t<!-- Frequency field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"Frequency-";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" style=\"text-align:right\" data-role=\"none\" onchange=\"\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Some Validation error Message\" data-mandatory=\"true\" type=\"number\" class=\"cstNumericTxtBox\"/> \n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Duration field Ends -->\n   \t    \t\n   \t    \t\n   \t    \t<!-- Performing Location field Starts -->\n   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"PerformingLocation-";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t\t\t\t\t\t \t\t\t\t\n\t\t\t\t\t\t\t\t\t \t\t\t\t<option value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\").data(\"kendoComboBox\").readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t //$(\"#Frequency\").data(\"kendoComboBox\").readonly();\n\t\t\t\t\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t\t\t</script> \n\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t\t</div>\n\t\t \t\t\t\t\t</div>\n\t\t \t\t\t\t</div>\n\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t \t\t\t</div>\n   \t    \t\t</div>\n   \t    \t</div>\n\n   \t    \t<div class=\"cstRowDivider\"></div>\n   \t    \t<!-- Performing Location field Ends -->\n\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\n\n\n\t\t\t\t\t\t \t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t\n\t\t\t\t\t<!-- Mandatory fields error -->\n\t\t\t\t\t<div class=\"formValErrorTheme formValError\" id=\"MandatoryFields_Error\" style=\"bottom: 10px; left: 2%; display: none\">\n\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All mandatory fields must be entered</div>\n\t\t\t\t\t</div>\n\t\t\t\t<!-- </div> -->\n\t\t\t\t<input type=\"hidden\" name=\"authorized";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" id=\"authorized";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"consented";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" id=\"consented";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"cosigned";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" id=\"cosigned";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"special_approved";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" id=\"special_approved";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" />\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"OrderCatalogCode\" id=\"OrderCatalogCode\" id=\"OrderCatalogCode\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"OrderTypeCode\" id=\"OrderTypeCode\" id=\"OrderTypeCode\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"OrderCatCode\" id=\"OrderCatCode\" id=\"OrderCatCode\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"or_bean_id\" id=\"or_bean_id\" id=\"or_bean_id\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"or_bean_name\" id=\"or_bean_name\" id=\"or_bean_name\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" />\n\t\t\t\t\n\t\t\t\t<!-- Selected Order Catalog Codes are accumulated as CSV  -->\n\t\t\t\t<input type=\"hidden\" name=\"OrderCatalogCodes\" id=\"OrderCatalogCodes\" id=\"OrderCatalogCodes\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" /> \n\t\t</form>\n\t<!-- </div> -->\n\t</div>\n\t</div>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\t\n\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );
	
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);


Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);




            _bw.write(_wl_block3Bytes, _wl_block3);
 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String locale = patientContext.getLocale();
		String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		//This variable is used for accumulating  the selected order catalog codes in the current form(CSV), useful in the case of ordersets
		String orderCatalogCodes = "";
		
		String order_catalog_code = orderCatalogCode;
		String localeName = locale;
		String order_category = orderCategoryCode;
		String patient_id = patientId;
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		OrderEntryQueryBean beanQueryObj = new OrderEntryQueryBean();
		beanQueryObj.setLanguageId(locale);
		String dateString = bean.getSysDate();
		OrderEntryRecordBean orderEntryRecordBean = (OrderEntryRecordBean) bean.getOrderEntryRecordBean();
		eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
		OrderEntryBillingQueryBean bean_qryobj = (OrderEntryBillingQueryBean)PersistenceHelper.getBeanObject("Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request) ;
		String[] billing_details = null;
		ArrayList PlaceOrderItems = null;
		String[] records = null;
		ArrayList BillChargeInfo;
		String PrivilegeApplicabilityAuth = (String)OrderEntryBean.checkForNull(bean.getAuthorisationOrOrderingYn("AUT"),"");
		ArrayList Default = null;
		String[] recordDefault = null;
		String qty_value = "";
		String qty_uom	= "";
		String qty_uom_shortdesc = "";
		String duration_value = "";
		String max_durn_value = "";
		String chk_for_max_durn_action = "";
		String frequency_val = "";
		String prompt_msg = "";
		String comments = "";
		String format_id;
		StringTokenizer stFormatID;
		String format_id_mandatory_yn = "";
		Properties properties = bean.getProperties();
		String auth_reqd				= "";
		//auth_reqd						= (String)bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
		String specialty_code = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");
		ArrayList speciality=new ArrayList();
		String practitioner_type = bean.getPractitionerType();
		String forceStatus				= bean.getForceStatus(practitioner_type,orderCategoryCode);
		String fStatus[]=forceStatus.split(":");
		String speciality_code[]=new String[3];
		ArrayList PlaceOrderType		= null;
		String[] orderTypeRecords		= null;
		String patientDischargedYn = bean.getPatientDischarged();
		ArrayList PlaceOrderFrequency	= null;
		String[] frequencyRecords	   = null;
		String[] secondaryOrders		= null;
		ArrayList performingLocationCode= null;
		String[] performingLocation		   = null;
		String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
		String rd_instal_yn				= "N";
	  	if(orderCategoryCode.equals("RD")||orderCategoryCode.equals("CS"))
			rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
	  	String fac_selected = "";
	  	ArrayList DeptLocationCode 		= null;
	  	String[] deptLocation		   = null;
	  	String show_bill_info_yn = bean.getBillingInterfaceShowYn();
	  	HashMap setBills_dtls				= null;
	  	String[] care_set_count 		= null; 
	  	String order_types_comb			= ""; 
	  	StringTokenizer stFormat		= null;
	  	String facility_name = "";
	  	
	  	ArrayList OrderFormat 	= null;
	  	
		if(!orderCategoryCode.equals("CS")){
			String order_type_catalog;
			if(!orderCatalogCode.equals("") && !orderTypeCode.equals("")){
				order_type_catalog = "'"+orderCatalogCode+"'||'"+orderTypeCode+"','1'";
			}else{
				order_type_catalog = "'1||1','1'";
			}
			order_catalog_code = "'"+orderCatalogCode+"'";
			
			String billing_interface_yn = bean.getBillingInterfaceYn();
			
			PlaceOrderItems = bean.getPlaceOrdersResult(OrderEntryBean.checkForNull(order_type_catalog,"'1||1','1'"),OrderEntryBean.checkForNull(orderCategoryCode,""),OrderEntryBean.checkForNull(order_catalog_code,"''"),"");
			
			if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
				records =(String[])PlaceOrderItems.get(0); 
				orderCatalogCodes = orderCatalogCodes + records[0] + ",";
				
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(bean.getPractitionerName()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bean.getPractitionerName()));
            _bw.write(_wl_block7Bytes, _wl_block7);

						          	//Authorization
									speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
									if(speciality.size()>0)
									{
										for(int sc=0;sc<speciality.size();sc++)
										{
												speciality_code=(String[])speciality.get(sc);
										}
									}
						            //out.println("<br>Authorizaion is required"); 
									
            _bw.write(_wl_block8Bytes, _wl_block8);

							                  	if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("authorized"+orderCategoryCode),"false").equals("true")){
												
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
							                  		}
							                  		else{
						                  		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
							                  			
							                  		}
												}
												else{
												
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
												}
									            
            _bw.write(_wl_block18Bytes, _wl_block18);

								              	//out.println("<br>cosign is required"); 
								                if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y"))  // For Cosign Required
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("cosigned"+orderCategoryCode),"false").equals("true")){
												
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 
							                  		}
							                  		else{
						                  		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
							                  			
							                  		}
												}
												else{
												
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
	
												}
									            
            _bw.write(_wl_block25Bytes, _wl_block25);

							                  	//out.println("<br>spl approval is required"); 
									            if(records[50].equalsIgnoreCase("Y")) // For Special Approval
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("special_approved"+orderCategoryCode),"false").equals("true")){
												
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
							                  		}
							                  		else{
						                  		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
							                  			
							                  		}
												}
												else{
												
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
												}
									            
            _bw.write(_wl_block31Bytes, _wl_block31);

								              	//out.println("Consent required");
									            if(records[51].equalsIgnoreCase("Y")) // For Consent
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("consented"+orderCategoryCode),"false").equals("true")){
												
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block33Bytes, _wl_block33);
 
							                  		}
							                  		else{
						                  		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
 
							                  			
							                  		}
												}
												else{
												
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
	
												}
									            
            _bw.write(_wl_block37Bytes, _wl_block37);

									            if(!bean.checkForNull(records[62],"").equals("")) 
												{
												
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);

													//out.println("<br>Explanatory Text:  "+records[62]);  //Explanatory Text is there for this catalog 
												}
									            else{
									            
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
									            }
									            
            _bw.write(_wl_block41Bytes, _wl_block41);

										            //Secondary orders
											 		secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass());
											 		if(bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
											 			//out.println("<br> Secondary orders are present");
											 			//out.println("<br> Secondary order catalog" +secondaryOrders[1]);
											 			//out.println("<br> Seondary orders startdatetime" +bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""));
							 					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);

										 		}
										 		else{
										 			//out.println("<br> No secondary orders");
										 		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);

										 		}
										 		
            _bw.write(_wl_block45Bytes, _wl_block45);
 
									Default = bean.getPlaceOrderDefault(records[0]);
									for(int j=0;j<Default.size();j++)
									{
										recordDefault	 = ((String[])Default.get(j));
										if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
						 				if(recordDefault!=null){
											qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
											if(qty_value.equals("0")) qty_value = "1";
												qty_uom			 =  bean.checkForNull(recordDefault[9],"");
												qty_uom_shortdesc=  bean.checkForNull(recordDefault[10],"");
										}else{
											qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
										}
									} 
									//out.println("<BR>StartDate  ");
									//out.println((bean.getTempvalue("start_date_time"+records[0]))==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0]));
									
            _bw.write(_wl_block46Bytes, _wl_block46);
//billing values
							 		if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && show_bill_info_yn.equals("Y"))
									{
							 			//out.println("</br> Billing applicable");
							 			BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
							 			if(BillChargeInfo!=null)
										{
							 				for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
											{
							 					billing_details 	= (String[])BillChargeInfo.get(k);
							 					setBills_dtls		= new HashMap();
							
							 					setBills_dtls.put("charged_yn"       , billing_details[1]);
							 					setBills_dtls.put("total_payable"    , billing_details[2]);
							 					setBills_dtls.put("patient_payable"  , billing_details[3]);
							 					setBills_dtls.put("quantity"         , qty_value);
							 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
							 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
							 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
												setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
												setBills_dtls.put("serv_panel_code"  , billing_details[11]);
												setBills_dtls.put("p_episode_type"	 , billing_details[13]);
												setBills_dtls.put("p_episode_id"	 , billing_details[14]);
												setBills_dtls.put("p_visit_id"		 , billing_details[15]);
												setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
												setBills_dtls.put("error_text"		 , billing_details[9]);
												setBills_dtls.put("rate"		 ,"");
												setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
												setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
												orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 
											}
										}
							 			
							 			//out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
							 			//out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
							 		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0") ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0") ));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
									}
						            
            _bw.write(_wl_block50Bytes, _wl_block50);
            _bw.write(_wl_block51Bytes, _wl_block51);

			String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
			String clinComments =  bean.checkForNull((String)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0"),"");	
			
            _bw.write(_wl_block52Bytes, _wl_block52);
if(clin_cmts_reqd_yn.equals("Y")){
            _bw.write(_wl_block53Bytes, _wl_block53);
} 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(clinComments.toString() ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.getTempvalue("start_date_time"+records[0])==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0])));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block73Bytes, _wl_block73);

		 	//Order type drop down - a disabled drop down
			PlaceOrderType = bean.getPlaceOrderType(records[0]);
		 	
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block79Bytes, _wl_block79);

								for(int j=0; j<PlaceOrderType.size(); j++)
								{
									orderTypeRecords = (String[]) PlaceOrderType.get(j);
									if(orderTypeCode.equals(orderTypeRecords[0])){
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(orderTypeRecords[1] ));
            _bw.write(_wl_block82Bytes, _wl_block82);

									}
									else{
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(orderTypeRecords[1] ));
            _bw.write(_wl_block82Bytes, _wl_block82);

									}
									orderTypeRecords = null;
								}
								PlaceOrderType = null; 
								
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("priority"+records[0]), "R") ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(records[10]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0]) ));
            _bw.write(_wl_block108Bytes, _wl_block108);

			 				if (qty_uom.equals("")) 
							{	
								out.println(records[68]);
							}					
						    else
							{
						    	out.println(qty_uom_shortdesc);
							}
						
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block112Bytes, _wl_block112);

							if(patientDischargedYn.equalsIgnoreCase("N"))
							{
							
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block115Bytes, _wl_block115);

								PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
								for(int j=0; j<PlaceOrderFrequency.size(); j++)
								{
									frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
									
									if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
									{
										//out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
								
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(frequencyRecords[1] ));
            _bw.write(_wl_block117Bytes, _wl_block117);
	}
									else
									{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(frequencyRecords[1] ));
            _bw.write(_wl_block118Bytes, _wl_block118);
	
								//out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
								}
								
            _bw.write(_wl_block119Bytes, _wl_block119);

							}
							else{
								//out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
							
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block120Bytes, _wl_block120);

							}
								
							
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block137Bytes, _wl_block137);

												//Performing location
												if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 	
										 			performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
										 			for(int j=0; j<performingLocationCode.size(); j++)
													{
										 				performingLocation	= (String[]) performingLocationCode.get(j);
										 			
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(performingLocation[0] ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(performingLocation[1] ));
            _bw.write(_wl_block140Bytes, _wl_block140);
 	} 
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block143Bytes, _wl_block143);
 
												}
										 		else{
										 			
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(bean.getPerformingFacilityName(records[5]) ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block145Bytes, _wl_block145);
 
										 		}
												
												fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?login_facility_id:bean.getTempvalue("performing_facility_id"+records[0]);
												
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(fac_selected));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block152Bytes, _wl_block152);
//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
									 		if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ||(orderCategoryCode.equals("MI"))||(orderCategoryCode.equals("PC")) || (orderCategoryCode.equals("OT"))) 
											{ 	
									 			//out.println("<br> performing department drop dowm");
									 			
									 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
									 			for(int j=0; j<DeptLocationCode.size(); j++)
												{	
									 				deptLocation	= (String[]) DeptLocationCode.get(j); 
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(deptLocation[0] ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(deptLocation[1] ));
            _bw.write(_wl_block154Bytes, _wl_block154);
	} 
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block157Bytes, _wl_block157);
 }
									 		else{
									 			//out.println("<br> performing department input field is not shown/empty in this case");
									 		
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block163Bytes, _wl_block163);

				/* out.println("<BR>OrderCategory  " + records[3]);
				out.println("<BR>OrderType  " + records[4]);
				out.println("<BR>OrderCatalogDesc " + records[1]); */
				
				
				
				
				//Priority drop down -- Selected bean.getTempvalue("priority"+records[0])
				/* out.println("<br> Priority drop down items ");
				if ( !((records[52]).equals("3"))) {
					out.println("<br> Item : Routine");
				}
				if (((records[52]).equals("")) || ((records[52]).equals("2"))) {
					out.println("<br> Item : Urgent");
				}
				if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					out.println("<br> Item : Stat");
				} */
				//Quantity -- Stored value bean.getTempvalue("quantity"+records[0]) or qty_value
				/* out.println("<br>  Quantlity Value: " +bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0]));
				if(records[10].equalsIgnoreCase("N")) {
					out.println("Quantity value is READONLY");
				}
				if (qty_uom.equals("")) 
				{	
					out.println("<br> Unit of Measure: "+records[68]);
				}					
			    else
				{
			    	out.println("<br> Unit of Measure: "+qty_uom_shortdesc);
				} */
				// Frequency drop down -- selected bean.getTempvalue("frequency_code"+records[0])
				/* if(patientDischargedYn.equalsIgnoreCase("N"))
				{
					PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
					for(int j=0; j<PlaceOrderFrequency.size(); j++)
					{
						frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
						
						if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
						{
							out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
							
						}
						else
						{
							out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
						}
					}
				}
				else{
					out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
				} */
				//NOTE: OrderEntryValidate.jsp func_mode=DURATIONVALUES populates the duration dropdown which is a disabled one
				// Inside the JS fuction setFrequency(obj,i,catalog_code,facility_id,val) they set the value of duration_code dropdown
				//QID~~D~~1~~4~~D~~Y~~O value[1] - DurationCode  value[5]=="Y" schedule mandatory
				//-----------
				
				//Duration value Text box -small text box with max length 3
				//if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
				//if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
				//if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
				//if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
				//if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
				//if(recordDefault!=null && recordDefault[0].equals("")) out.println("<br> Duration text box is readOnly");
				//out.println("<br> Duration text box value" + bean.getTempvalue("duration_value"+records[0])==null?duration_value:bean.getTempvalue("duration_value"+records[0]));
				//out.println("<br> Duration text box max_durn_value" +max_durn_value);
				//out.println("<br> Duration text box chk_for_max_durn_action" +chk_for_max_durn_action);
				//out.println("<br> Duration text box prompt_msg" +prompt_msg);
				//out.println("<br> Duration text box comments" +comments);
				//validations to be performed: js function checkMaxValue(obj,max_durn_value,chk_for_max_durn_action,prompt_msg,soft_stop_yn,row_value,catcode)
				//Only after this duration value is entered, end time is automatically computed using JS
				//0 value is not allowed
				//calculate end time JS function calculateEndDateTime(start_date_time,duration_code,duration_value,row_value,'');
				//if duration value > max value then prompt is displayed
				
				//duration dropdown populated using script
				
				/* format_id = bean.checkForNull(records[47],"");
				if(!records[47].trim().equals(""))
				{
		     		stFormatID 	= new StringTokenizer(records[47],"~");
		     		while(stFormatID.hasMoreTokens())
		     		{
		     			format_id_mandatory_yn  = stFormatID.nextToken();
		     			format_id 				= stFormatID.nextToken();
		     			//out.println("<br> formate id ??????????"+format_id);
		     		}
					stFormatID = null;// Nullifying the objects
		 		} */
		 		//out.println("<br> Format contains Mandatory Items" + format_id_mandatory_yn);
		 		
		 		//consent related code line 1478 to 1568
		 		//TODO
		 		
		 		
		 		
		 		//end date - read only textbox
		 		
		 		
		 		//Performing location
				/* if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 	
		 			//out.println("<br> performing location dropdown:");
		 			performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
		 			for(int j=0; j<performingLocationCode.size(); j++)
					{
		 				performingLocation	= (String[]) performingLocationCode.get(j);
		 				out.println("</br>dropdown items"+performingLocation[0]+"::"+performingLocation[1]);
		 				
					}
		 			if(bean.getTempvalue("performing_facility_id"+records[0])==null)//Facility was not selected
					{
		 				out.println("</br>selected facility is login facilty id " + login_facility_id);
		 				fac_selected = login_facility_id;
		 				
					}
		 			else{
		 				out.println("</br>selected facility is from bean" + bean.getTempvalue("performing_facility_id"+records[0]));
		 				fac_selected = bean.getTempvalue("performing_facility_id"+records[0]);
		 			}
		 			
				}
		 		else{
		 			
		 			out.println("<br> performing location static text:");
		 			out.println("</br> "+bean.getPerformingFacilityName(records[5])+"::"+records[5]);
		 		}
		 		
		 		//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
		 		if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ||(orderCategoryCode.equals("MI"))||(orderCategoryCode.equals("PC")) || (orderCategoryCode.equals("OT"))) 
				{ 	
		 			out.println("<br> performing department drop dowm");
		 			
		 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
		 			for(int j=0; j<DeptLocationCode.size(); j++)
					{	
		 				deptLocation	= (String[]) DeptLocationCode.get(j);
		 				out.println("<br> dropdown item: "+deptLocation[0]+"::"+deptLocation[1]+"::"+deptLocation[2]);
					}
		 			//if()
				}
		 		else{
		 			out.println("<br> performing department input field is not shown");
		 		} */
		 		
		 		
            _bw.write(_wl_block164Bytes, _wl_block164);
            _bw.write(_wl_block165Bytes, _wl_block165);
	}
			else{
				//TODO no place order items
			}
		}else if(orderCategoryCode.equals("CS")){
			
			ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
			ArrayList PlaceOrderSetItems 	= null;
			String[] care_set_group			= null;
			String order_set_order_catalog	= "";
			String order_type_catalog 		= "";
			String[] reqd_or_opt_ind		= null; // To store the value required/optional/deselected
			String[] rel_start_date_time	= null; // To store the start_date_time TODO- check if required
			String[] start_time				= null; // To store the hours(So that it can be used when the header is changed ) TODO- check if required
			
			String billing_interface_yn		= bean.getBillingInterfaceYn();
			String billing_order_set_details[] = bean.getOrderSetBillDetails(orderCatalogCode);
			String order_set_bill_yn = OrderEntryBean.checkForNull(billing_order_set_details[1],"N");
			String care_set_catalog_desc = OrderEntryBean.checkForNull(billing_order_set_details[0],"");
			String charge_yn = OrderEntryBean.checkForNull(billing_order_set_details[2],"");
			String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
			
			String displayNone = "display:none";
			
			if(charge_yn.equalsIgnoreCase("N"))
			{
				order_set_bill_yn = "N";
			}
			
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(care_set_catalog_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(bean.getPractitionerName()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bean.getPractitionerName()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block46Bytes, _wl_block46);
//billing values
						            if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT") && show_bill_info_yn.equals("Y"))
									{
							 			//out.println("</br> Billing applicable");
							 			BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
							 			if(BillChargeInfo!=null)
										{
											for( int m=0 ; m< BillChargeInfo.size() ; m++ )
											{
							 					billing_details 	= (String[])BillChargeInfo.get(m);
							 					setBills_dtls		= new HashMap();
							
							 					setBills_dtls.put("charged_yn"       , billing_details[1]);
							 					setBills_dtls.put("total_payable"    , billing_details[2]);
							 					setBills_dtls.put("patient_payable"  , billing_details[3]);
							 					setBills_dtls.put("quantity"         , qty_value);
							 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
							 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
							 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							 					setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							 					setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							 					setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							 					setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							 					setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							 					setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							 					setBills_dtls.put("rate"		 ,"");
							 					setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
							 					setBills_dtls.put("mod_physician_id"		 , billing_details[20]);

												orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code, setBills_dtls); 
												
											}
										}
							 			
							 			//out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
							 			//out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
							 		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0") ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0") ));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
									}
							 		else{
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block167Bytes, _wl_block167);

			//to determine whether clinical comments is mandatory
			String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
			if(PlaceOrdercareSetCount!=null && !clin_cmts_reqd_yn.equals("Y"))			
			{
				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					String care_set_ordcat = care_set_count[1];
					String care_set_clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, care_set_ordcat),"N");
					if(care_set_clin_cmts_reqd_yn.equals("Y")){
						clin_cmts_reqd_yn = "Y";
						break;
					}
				}
			}
			
			
			
            _bw.write(_wl_block52Bytes, _wl_block52);
if(clin_cmts_reqd_yn.equals("Y")){
            _bw.write(_wl_block53Bytes, _wl_block53);
} 
            _bw.write(_wl_block168Bytes, _wl_block168);

			/* if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT") && show_bill_info_yn.equals("Y"))
			{
				out.println("<br> Billing applicable");
				BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
				if(BillChargeInfo!=null)
				{
					for( int m=0 ; m< BillChargeInfo.size() ; m++ )
					{
	 					billing_details 	= (String[])BillChargeInfo.get(m);
	 					setBills_dtls		= new HashMap();
	
	 					setBills_dtls.put("charged_yn"       , billing_details[1]);
	 					setBills_dtls.put("total_payable"    , billing_details[2]);
	 					setBills_dtls.put("patient_payable"  , billing_details[3]);
	 					setBills_dtls.put("quantity"         , qty_value);
	 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
	 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
	 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
	 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
	 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
						setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
						setBills_dtls.put("serv_panel_code"  , billing_details[11]);
						setBills_dtls.put("p_episode_type"	 , billing_details[13]);
						setBills_dtls.put("p_episode_id"	 , billing_details[14]);
						setBills_dtls.put("p_visit_id"		 , billing_details[15]);
						setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
						setBills_dtls.put("rate"		 ,"");
						setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
						setBills_dtls.put("mod_physician_id"		 , billing_details[20]);

						//orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 
						
					}
				}
	 			
	 			out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
	 			out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
			}else{
				out.println("<br> Billing not applicable");
			}
			 */
			 
			 
			 
			 
			if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
			{
				int tabCount;
				
            _bw.write(_wl_block169Bytes, _wl_block169);

				tabCount = 0;
				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");
					format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
					 
					if(!format_id.trim().equals("") )
					{
						stFormat = new StringTokenizer(format_id,"~");
						while(stFormat.hasMoreTokens())
	 					{
	 						format_id_mandatory_yn	 	= stFormat.nextToken();
	 						format_id 	 	 			= stFormat.nextToken();
	 					}
						stFormat = null;
	 				}
	 				/* if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
	 					out.println("<br> Order Format has mandatory header items  " +care_set_count[2]);
	 				else
	 					out.println("<br> Order Format does not has mandatory header items  "+care_set_count[2]); */
	 				String time_frame = "";
	 				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
	 				
	 				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
					rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
					start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time
							
	 				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
					{
	 					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
						order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
					    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					    reqd_or_opt_ind[k]		= care_set_group[5];
					    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
					    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
					}
	 				if(order_set_order_catalog.length() > 0)
						order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
					if(order_type_catalog.length() > 0)
						order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
					
					PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"");
					if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
					{
						for(int i=0; i<PlaceOrderItems.size(); i++)
						{	
							records		= (String[])PlaceOrderItems.get(i);
							if(tabCount==0){
						
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(records[0] ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(records[1] ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(records[0] ));
            _bw.write(_wl_block174Bytes, _wl_block174);

							}
							else{
						
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(records[0] ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(records[1] ));
            _bw.write(_wl_block176Bytes, _wl_block176);
		
							}
							tabCount++;
						}
						
            _bw.write(_wl_block177Bytes, _wl_block177);

					}
					order_set_order_catalog = ""; // Remove the values
					order_type_catalog			 = ""; // Remove the values
				}
				tabCount = 0;
				
            _bw.write(_wl_block178Bytes, _wl_block178);

				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");
					format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
					 
					if(!format_id.trim().equals("") )
					{
						stFormat = new StringTokenizer(format_id,"~");
						while(stFormat.hasMoreTokens())
	 					{
	 						format_id_mandatory_yn	 	= stFormat.nextToken();
	 						format_id 	 	 			= stFormat.nextToken();
	 					}
						stFormat = null;
	 				}
	 				/* if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
	 					out.println("<br> Order Format has mandatory header items  " +care_set_count[2]);
	 				else
	 					out.println("<br> Order Format does not has mandatory header items  "+care_set_count[2]); */
	 				String time_frame = "";
	 				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
	 				
	 				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
					rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
					start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time
							
	 				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
					{
	 					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
						order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
					    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					    reqd_or_opt_ind[k]		= care_set_group[5];
					    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
					    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
					}
	 				if(order_set_order_catalog.length() > 0)
						order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
					if(order_type_catalog.length() > 0)
						order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
					
					PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"");
					if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
					{
						
						
						for(int i=0; i<PlaceOrderItems.size(); i++)
						{	
							records		= (String[])PlaceOrderItems.get(i);
							orderCatalogCodes = orderCatalogCodes + records[0] + ",";
							/* out.println("<BR>OrderCategory  " + records[3]);
							out.println("<BR>OrderType  " + records[4]);
							out.println("<BR>OrderCatalogDesc " + records[1]+"--"+records[0]);
							if(records[51].equalsIgnoreCase("Y")){
								out.println("<br> Consent required");
							}
							 */
							Default = bean.getPlaceOrderSetDefault(records[0],order_catalog_code);
							for(int j=0;j<Default.size();j++)
							{
								recordDefault	 = ((String[])Default.get(j));					
								if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
								if(recordDefault!=null){
									qty_value	 = 	bean.checkForNull(recordDefault[8],"1");
									if(qty_value.equals("0")) qty_value = "1";
									qty_uom		 =  bean.checkForNull(recordDefault[9],"");
									qty_uom_shortdesc =  bean.checkForNull(recordDefault[10],"");
								}else{
									qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
								}
							}
							/* out.println("<br> State of check box -- "+records[1]);
							if(reqd_or_opt_ind[i].equalsIgnoreCase("R"))
							{
								out.println("<br> Y CHECKED DISABLED");
							}
							else if(reqd_or_opt_ind[i].equalsIgnoreCase("O"))
							{
								out.println("<br> Y CHECKED NOTDISABLED");
							}
							else if(reqd_or_opt_ind[i].equalsIgnoreCase("D"))
							{
								out.println("<br> N NOTCHECKED NOTDISABLED");
							} */
							
							
							//out.println("<BR>StartDate  "+com.ehis.util.DateUtils.convertDate(rel_start_date_time[i],"DMYHM","en",localeName));
            _bw.write(_wl_block179Bytes, _wl_block179);
if(tabCount==0) {
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block181Bytes, _wl_block181);
}else{
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(displayNone));
            _bw.write(_wl_block183Bytes, _wl_block183);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.getTempvalue("start_date_time"+records[0])==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0])));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block188Bytes, _wl_block188);

		 	//Order type drop down - a disabled drop down
			PlaceOrderType = bean.getPlaceOrderType(records[0]);
		 	
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block79Bytes, _wl_block79);

								for(int j=0; j<PlaceOrderType.size(); j++)
								{
									orderTypeRecords = (String[]) PlaceOrderType.get(j);
									if(orderTypeCode.equals(orderTypeRecords[0])){
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(orderTypeRecords[1] ));
            _bw.write(_wl_block82Bytes, _wl_block82);

									}
									else{
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(orderTypeRecords[1] ));
            _bw.write(_wl_block82Bytes, _wl_block82);

									}
								}
								PlaceOrderType = null; 
								
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("priority"+records[0]), "R") ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(records[10]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block190Bytes, _wl_block190);
if(records[10].equals("N")){
            _bw.write(_wl_block191Bytes, _wl_block191);
}
            _bw.write(_wl_block192Bytes, _wl_block192);

			 				if (qty_uom.equals("")) 
							{	
								out.println(records[68]);
							}					
						    else
							{
						    	out.println(qty_uom_shortdesc);
							}
						
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block112Bytes, _wl_block112);

							if(patientDischargedYn.equalsIgnoreCase("N"))
							{
							
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block115Bytes, _wl_block115);

								PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
								for(int j=0; j<PlaceOrderFrequency.size(); j++)
								{
									frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
									
									if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
									{
										//out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
								
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(frequencyRecords[1] ));
            _bw.write(_wl_block117Bytes, _wl_block117);
	}
									else
									{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(frequencyRecords[1] ));
            _bw.write(_wl_block118Bytes, _wl_block118);
	
								//out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
								}
								
            _bw.write(_wl_block119Bytes, _wl_block119);

							}
							else{
								//out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
							
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block120Bytes, _wl_block120);

							}
								
							
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block137Bytes, _wl_block137);

												//Performing location
												if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) { 	
													performingLocationCode = bean.getPerformingLocation(care_set_count[1],orderTypeRecords[0],records[0]);
										 			for(int j=0; j<performingLocationCode.size(); j++)
													{
										 				performingLocation	= (String[]) performingLocationCode.get(j);
										 			
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(performingLocation[0] ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(performingLocation[1] ));
            _bw.write(_wl_block140Bytes, _wl_block140);
 	} 
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block143Bytes, _wl_block143);
 
												}
										 		else{
										 			
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(bean.getPerformingFacilityName(records[5]) ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block145Bytes, _wl_block145);
 
										 		}
												
												fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?records[5]:bean.getTempvalue("performing_facility_id"+records[0]);
												
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(fac_selected));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block152Bytes, _wl_block152);
//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
		 									if((care_set_count[1].equals("LB") )|| (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX"))||(care_set_count[1].equals("TR")) ||(care_set_count[1].equals("MI"))||(care_set_count[1].equals("PC"))) 
											{ 	
									 			//out.println("<br> performing department drop dowm");
									 			
									 			DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],orderTypeRecords[0],rd_instal_yn);
									 			for(int j=0; j<DeptLocationCode.size(); j++)
												{	
									 				deptLocation	= (String[]) DeptLocationCode.get(j);
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(deptLocation[0] ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(deptLocation[1] ));
            _bw.write(_wl_block154Bytes, _wl_block154);
	} 
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block157Bytes, _wl_block157);
 }
									 		else{
									 			//out.println("<br> performing department input field is not shown/empty in this case");
									 		
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block196Bytes, _wl_block196);
            _bw.write(_wl_block197Bytes, _wl_block197);
            _bw.write(_wl_block198Bytes, _wl_block198);

						tabCount++;
						}
					}
					order_set_order_catalog = ""; // Remove the values
					order_type_catalog			 = ""; // Remove the values
				}
			
				
					}
				}

		
		//orderCatalogCodes = orderCatalogCodes.substring(0, orderCatalogCodes.length()-1);
	/* 	if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
			for(int i=0; i<PlaceOrderItems.size(); i++)
			{	
				records		= (String[])PlaceOrderItems.get(i);
				format_id = bean.checkForNull(records[47],"");
				OrderFormat				= bean.getOrderFormat(format_id,records[3],"","","","R",bean.getSex(), bean.getDob(),login_facility_id,records[0],records[4],patient_id);
			}
		}
		 */
		


            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("authorized"+orderCategoryCode),"false")));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("consented"+orderCategoryCode),"false")));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("cosigned"+orderCategoryCode),"false")));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bean.checkForNull(bean.getTempvalue("special_approved"+orderCategoryCode),"false")));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(orderCatalogCode ));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(orderTypeCode ));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(orderCategoryCode ));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(or_bean_id ));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(or_bean_name ));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(orderCatalogCodes ));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block214Bytes, _wl_block214);

	}else{
		/* validationResponse.setValidationStatus(MOrderEntryValidationResponse.VALIDATION_ERROR); */
	}
}
catch(Exception e){
	/* validationResponse.setValidationStatus(MOrderEntryValidationResponse.VALIDATION_STATUS_FETCH_FAILURE); */
	out.println(e.getMessage());
}



            _bw.write(_wl_block215Bytes, _wl_block215);
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

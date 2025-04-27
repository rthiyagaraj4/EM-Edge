package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.model.BillReceiptSummaryBean;
import eBL.billreceipt.model.BillReceiptCustomerDetails;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.billreceipt.model.BillReceiptServiceDetails;
import eBL.billreceipt.model.BillReceiptExclusionDiscount;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.placeorder.model.BLChargePatientServiceDetailsBean;
import eBL.placeorder.response.PlaceNewOrderResponse;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.bc.PlaceOrderBC;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billreceiptexistordergroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptExistOrderGroup.jsp", 1738423917712L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n$(document).ready(function(){\n\t\n\tif($(\'#traverse\').val() == \'Y\'){\n\t\t$(\'#trProgress\').show();\n\t}else{\n\t\t$(\'#trProgress\').hide();\n\t}\n\t\n\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t$(\'#nextSpan\').show();\n\t}else{\n\t\t$(\'#nextSpan\').hide();\n\t}\n\t\n\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t$(\'#previousSpan\').show();\n\t}else{\n\t\t$(\'#previousSpan\').hide();\n\t}\n\t\n\tpayerHide(\'G\');\n\t\n\tvar total = $(\'#totalGroup\').val();\n\tif(parseInt(total)<1){\n\t\tvar pDoc = parent.BillReceiptInfo.document;\n\t\t$(pDoc).find(\'#depAdjChk\').attr(\'disabled\',\'disabled\');\n\t\t$(pDoc).find(\'#prePayChk\').attr(\'disabled\',\'disabled\');\n\t}\n\telse{\n\t\t$(pDoc).find(\'#depAdjChk\').attr(\'disabled\',\'\');\n\t\t$(pDoc).find(\'#prePayChk\').attr(\'disabled\',\'\');\n\t}\n\t\n\t$(\'td[id^=serv_grp_desc]\').each(function(){\n\t\tvar grpDesc = $(this).text();\n\t\tvar openDiv = \'<div  style=\"min-width: 220px; max-width: 220px; width: 220px; overflow: hidden;\">\';\n\t\tvar closeDiv = \'</div>\'\n\t\tif(grpDesc.length>100){\n\t\t\tvar divAppnd = openDiv+grpDesc.substring(0,40) + \' (...) \'+closeDiv;\n\t\t\t$(this).text(\'\');\n\t\t\t$(this).append(divAppnd);\n\t\t\t\n\t\t\t$(this).attr(\'title\',grpDesc);\n\t\t}\n\t});\n\t\n\t$(\'td[id^=serv_line_desc]\').each(function(){\n\t\tvar grpDesc = $(this).text();\n\t\tvar openDiv = \'<div  style=\"min-width: 220px; max-width: 220px; width: 220px; overflow: hidden;\">\';\n\t\tvar closeDiv = \'</div>\'\n\t\tif(grpDesc.length>100){\n\t\t\tvar divAppnd = openDiv+grpDesc.substring(0,40) + \' (...) \'+closeDiv;\n\t\t\t$(this).text(\'\');\n\t\t\t$(this).append(divAppnd);\n\t\t\t\n\t\t\t$(this).attr(\'title\',grpDesc);\n\t\t}\n\t});\n\t\n\t$(\'#nextSpan\').click(function(){\t\t\n\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\tshowServiceDetails(startFrom,endWith);\n\t});\n\t$(\'#previousSpan\').click(function(){\t\t\n\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\tshowServiceDetails(startFrom,endWith);\n\t});\n\t//putDecimal_Text($(\'#gross_amt1\'),17,3);\n\t//$(parent.BillReceiptExisOrderSummary.document).find(\'#summaryDiv\').show();\n\tvar noOfDecimal = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t//groupChangeDecimal(\'G\',$(\'#maxPayer\').val(),noOfDecimal);\n\tparent.BillReceiptExisOrderSummary.document.location.href = \'BillReceiptExisOrderSummary.jsp\';\n\t//findTotal();\n\n\tif($(\'#error\').val() != \'\' && $(\'#errorCheck\').val() == \'Y\'){\n\t\tif($(\'#error\').val() != undefined && $(\'#error\').val() != \'undefined\' ){\n\t\t\talert($(\'#error\').val());\n\t\t}\t\t\n\t}\n\t/* Added By Gayathri- For MMS- For Inpatient and the BillType Interim, The Package Closure window will not be displayed*/\nif( $(parent.BillReceiptInfo.document).find(\'#episode_type\').val()== \'I\' && $(parent.BillReceiptInfo.document).find(\'#ipBillType\').val()==\'I\'){\n\t\t$(\'#pkgCount\').val(\'0\');\n\t\n\t\t}\nif(parseInt($(\'#pkgCount\').val()) > 0 && $(parent.BillReceiptTab.document).find(\'#pkgAlrdPop\').val() == \'N\' && $(parent.BillReceiptInfo.document).find(\'#interfaceYn\').val() == \'N\'){\n\t\t\n\t\tpackageClosure();\n\t\tif($(parent.BillReceiptTab.document).find(\'#pkgClosedYn\').val() == \'Y\'){\n\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t}\n\t}\n\t\n});\n\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n\t{\n\t/*if (headTop < 0)\n\t{\n\t\tsaveHeadPos();\n\t\t\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}*/\n\tvar tab3=document.getElementById(\"divTitleTable23\");\n\tvar widthValue=400;\n\tvar x = document.body.scrollLeft;\n\tvar y = document.body.scrollTop;\n\tvar px = \'\';\n\tif(x > 0)\n\t{\n\t\tpx = x+\"px\";\n\t\t$(\'div[id^=fixedCols]\').each(function(){\n\t\t\t$(this).css(\'left\',px);\n\t\t\t$(this).css(\'position\',\'relative\');\n\t\t})\n\t\t\n\t\t//tab3.style.left=\n\t}\n\telse\n\t{\n\t\t//tab1.style.left=\"0px\";\n\t\t$(\'div[id^=fixedCols]\').each(function(){\n\t\t\t$(this).css(\'left\',\'0px\');\n\t\t\t$(this).css(\'position\',\'relative\');\n\t\t})\n\t\t//tab3.style.left=\"0px\";\n\t\tx=0;\n\t}\n\tif(y > 0)\n\t{\n\t\n\t\tpx = y+\"px\";\n\t\t$(\'#fixedColsHdr1\').css(\'top\',px);\n\t\t$(\'#fixedColsHdr1\').css(\'position\',\'relative\');\n\t\t//tab2.style.top=(y-4)+\"px\";\n\t\t$(\'#fixedHeaderTop\').css(\'top\',px);\n\t\t$(\'#fixedHeaderTop\').css(\'position\',\'relative\');\n\t}\n\telse\n\t{\n\t\t$(\'#fixedColsHdr1\').css(\'top\',\'0px\');\n\t\t$(\'#fixedColsHdr1\').css(\'position\',\'relative\');\n\t\t$(\'#fixedHeaderTop\').css(\'top\',\'0px\');\n\t\t$(\'#fixedHeaderTop\').css(\'position\',\'relative\');\n\t}\n\t}\n\n\tfunction saveHeadPos()\n\t{\n\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\tif (parTable != null)\n\t\t{\n\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\tFloatHead1.style.position = \"relative\";\n\t\t}\n\t}\n\t\n\tfunction lockKey()\n\t  {\n\t\t \t \n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t  }\n\n\t  function lockbackSpace()\n\t  {\n\t\t// alert(document.order_type_form.mode.value);\n\t\t   var mode = document.mode.value;\n      // alert(window.event.keyCode);\n\t\t if(mode==\'modify\' && window.event.keyCode==8)\n\t\t  {\n           //return false;\n\t\t  }\n\t  }\n\t \n\t\n\t\n</script>\n</head>\n<style>\n\n\t\tTD.YELLOW \n\t\t{\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\tTD.greyedData\n\t\t{\n\t\t\tBACKGROUND-COLOR: #A3A3A3 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tcolor : #FFFFFF;\n\t\t}\n\t\t</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onScroll=\"processScroll();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\" >\n\t<form id=\"bLChargePatientServicePriceDetails\" name=\"bLChargePatientServicePriceDetails\" >\t\n\n\n\t\n\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"   style=\"width: 200%; \" name=\"panel_categories_header_table\" id=\"panel_categories_header_table\" border=\"1\"  >\t \n\t\t<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t<td >\n\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t<span id=\'previousSpan\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t</span>\n\t\t\t\t&nbsp;\t\n\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t<span id=\'nextSpan\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t</span>\n\t\t\t</td>\t\t\n\t\t\t<td>\n\t\t\t</td>\t\t\t\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<TR >\t\n\t\t\t<td id=\'firstMainColHdr\' style=\'width: 15%; \' >\n\t\t\t\t<div id=\'fixedColsHdr1\' style=\"z-index: 100; margin-top: 0px; left:0px; position: relative;\">\n\t\t\t\t<table  border=\"1\" cellspacing=\"0\" cellpadding=\"0\"  style=\"max-height: 60px; min-height: 60px; height: 60px; width: 100%;  \"  >\n\t\t\t\t\t<tr style=\"height: 20px;\">\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  style=\"padding-left:0px; width: 146px; \"\t\talign=\"left\"\t>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  style=\"padding-left:0px; width: 220px;\"\t\talign=\"left\"\t>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t<td id=\'secondMainColHdr\' style=\'width: 85%; \' class=\'COLUMNHEADER\'>\n\t\t\t\t<div id=\'fixedHeaderTop\' >\n\t\t\t\t<table  border=\"1\" cellspacing=\"0\" cellpadding=\"0\"  style=\"width: 100%; max-height: 60px; min-height: 60px; height: 60px;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\'padding-left:0px; \' colspan=\'3\'></td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\'padding-left:0px; \' colspan=\'3\'\talign=\"center\"\tid=\"tdCashHdr\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\'padding-left:0px; \' colspan=\'3\'\talign=\"center\" id=\'payer";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="Hdr\' >\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/abt_product_btn.gif\' onmousedown=\"resizeWindow(payer";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="Hdr,";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =");\" class = \'img\' >\n\t\t\t\t\t\t\t<span id=\'payerSpan";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="Hdr\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"overflow:hidden; padding-left:0px;width: 3.5%; max-width:45px; \"\talign=\"left\"\t>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"overflow:hidden; padding-left:0px;width: 3.5%; max-width:45px; \"\talign=\"left\"\t>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"overflow:hidden; padding-left:0px;width: 3.5%; max-width:46px; \"\talign=\"left\"\t>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\n\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'tdCashTotalHdr\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'tdCashDiscValHdr\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'tdCashNetHdr\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'payer";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="TotalHdr\' >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'payer";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="DiscValHdr\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' \tstyle=\"width: 3.5%;\"\talign=\"left\"\tid=\'payer";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="DiscNetHdr\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t</td>\n\t\t\t</tr>\n\n\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\n\t\t\t<tr id=\'resultTr_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\n\t\t\t\t<td id=\'firstMainCol";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' style=\'width: 15%; \'>\n\t\t\t\t\t<div id=\'fixedCols";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t\t\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"width: 100%;\">\n\t\t\t\t\t\t<tr id=\'resultTROfFirst";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"label\"      id=\"serv_grp_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\tclass=\'\' style=\'  cursor:pointer\' onclick=\"tooltip(this,";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =",\'entGroup\');\"\tonmouseover=\"hideToolTip();\"\tname=\"serv_grp_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"\t>\n\t\t\t\t\t \t\t<div style=\"width: 140px;\">\n\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \t\t\n\t\t\t\t\t \t\t\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\t\t \t\t\n\t\t\t\t\t \t\t</div>\t\t\t\t\t \t\t\t\t\n\t\t\t\t\t \t\t</td>\t\n\t\t\t\t\t \t\t<td  class=\"label\" id=\"serv_grp_desc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\t\t\tname=\"serv_grp_desc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t \t\t<div  style=\"width: 220px;overflow: hidden;\">\n\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;\n\t\t\t\t\t \t\t\t\n\t\t\t\t\t \t\t</div>\n\t\t\t\t\t \t\t<input type=\'hidden\' name=\'hdnServGrpDesc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id = \'hdnServGrpDesc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t \t\t\t<input type=\'hidden\' name=\'acctSeqNo";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'acctSeqNo";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t \t\t\n\t\t\t\t\t \t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td id=\'secondMainCol";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' style=\'width: 85%; \'>\n\t\t\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\"  style=\"width: 100%;\" overflow: auto;\" border=\"1\">\n\t\t\t\t\t\t<tr id=\'resultTROfSecond";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t\t\t<td class=\"label\" \tstyle=\"width: 3.5%;text-align: right;  \"  id=\"gross_amt";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"\t\t\tname=\"gross_amt";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp; </td>\n\t\t\t\t\t\t\t<td class=\"label\"  style=\"width: 3.5%;text-align: right;\"  id=\"disc_amt";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"\t\t\tname=\"disc_amt";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp; </td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"label\"  style=\"width: 3.5%;text-align: right;\"  id=\"net_amt";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"\t\t\tname=\"net_amt";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp; </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t<!-- Cash Columns -->\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'cashTotal";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' name=\'cashTotal";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' >\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'cashAdhocAmount";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' name=\'cashAdhocAmount";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'cashNet";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' name=\'cashNet";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t<!-- Cash Columns -->\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer1 Columns -->\n\t\t\t\t\t<td  roundVal=\'Y\' style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer1Total";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' name=\'payer1Total";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer1DiscType";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer1AdhocAmount";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' name=\'payer1AdhocAmount";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer1Net";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' name=\'payer1Net";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t<!-- payer1 Columns -->\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer2 Columns -->\n\t\t\t\t\t<td roundVal=\'Y\'  style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer2Total";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' name=\'payer2Total";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer2DiscType";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer2AdhocAmount";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' name=\'payer2AdhocAmount";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer2Net";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' name=\'payer2Net";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t\t\t<!-- payer2 Columns -->\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer3 Columns -->\n\t\t\t\t\t<td roundVal=\'Y\'  style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer3Total";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' name=\'payer3Total";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer3DiscType";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer3AdhocAmount";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' name=\'payer3AdhocAmount";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer3Net";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' name=\'payer3Net";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t\t\t\t<!-- payer3 Columns -->\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer4 Columns -->\n\t\t\t\t\t<td roundVal=\'Y\'  style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer4Total";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' name=\'payer4Total";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer4DiscType";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer4AdhocAmount";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer4Net";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' name=\'payer4Net";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t<!-- payer4 Columns -->\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer5 Columns -->\n\t\t\t\t\t<td  roundVal=\'Y\' style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer5Total";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' name=\'payer5Total";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer5DiscType";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer5AdhocAmount";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer5Net";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' name=\'payer5Net";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t\t\t<!-- payer5 Columns -->\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer6 Columns -->\n\t\t\t\t\t<td  roundVal=\'Y\' style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer6Total";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' name=\'payer6Total";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer6DiscType";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer6AdhocAmount";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer6Net";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' name=\'payer6Net";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t\t\t<!-- payer6 Columns -->\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- payer7 Columns -->\n\t\t\t\t\t<td  roundVal=\'Y\' style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer7Total";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' name=\'payer7Total";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right; display: none;\" nowrap=\"nowrap\" class=\'label\' id=\'payer7DiscType";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer7AdhocAmount";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td   style=\"width: 3.5%;text-align: right;\" nowrap=\"nowrap\" class=\'label\' id=\'payer7Net";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' name=\'payer7Net";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t\t\t<!-- payer7 Columns -->\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\n\t</table>\n\t\n\n\t\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t<tr>\n\t\t<td class = \'button\' id=\'excludeservice\'  style=\"text-align: right;\"><a  href=\"javascript: tooltipforexcludeservice(this,";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =");\">Click here to view the excluded services</a>\n\t\t</td></tr>\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\n\t\t<input type=\'hidden\' name=\'totalGroup\' id=\'totalGroup\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\"\" />\n\t\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" />\n\t\t<input type=\'hidden\' name=\'locale\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\t\n\t\t<input type=\'hidden\' name=\'groupLineService\' id=\'groupLineService\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\t\n\t\t<input type=\'hidden\' name=\'maxPayer\' id=\'maxPayer\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\t\t<input type=\'hidden\' name=\'pkgCount\' id=\'pkgCount\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t\t<input type=\'hidden\' name=\'serviceLocation\' id=\'serviceLocation\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t<input type=\'hidden\' name=\'acctSeqNo\' id=\'acctSeqNo\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\n\t\t<input type=\'hidden\' name=\'visitTypeCode\' id=\'visitTypeCode\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t<!-- Summary Related Data -->\n\t\t<input type=\'hidden\' name=\'approx_pyr_amt\' id=\'approx_pyr_amt\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t<input type=\'hidden\' name=\'approx_pat_amt\' id=\'approx_pat_amt\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t<input type=\'hidden\' name=\'patient_amt\' id=\'patient_amt\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t<input type=\'hidden\' name=\'exemption_amt\' id=\'exemption_amt\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t\t<input type=\'hidden\' name=\'deposit_amt\' id=\'deposit_amt\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t\t<input type=\'hidden\' name=\'summ_net_amt\' id=\'summ_net_amt\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t\t<input type=\'hidden\' name=\'spl_dep_adj_amt\' id=\'spl_dep_adj_amt\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t\t<input type=\'hidden\' name=\'slmt_amt\' id=\'slmt_amt\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t\t<input type=\'hidden\' name=\'spl_dep_amt\' id=\'spl_dep_amt\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n\t\t<input type=\'hidden\' name=\'available_spl_dep_amt\' id=\'available_spl_dep_amt\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t\t<input type=\'hidden\' name=\'adjustable_spl_dep_amt\' id=\'adjustable_spl_dep_amt\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t\t<input type=\'hidden\' name=\'balance_spl_dep_amt\' id=\'balance_spl_dep_amt\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n\t\t<input type=\'hidden\' name=\'patDepAdj\' id=\'patDepAdj\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t\t<input type=\'hidden\' name=\'patDepBal\' id=\'patDepBal\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t<input type=\'hidden\' name=\'patPrepayAdj\' id=\'patPrepayAdj\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t\t<input type=\'hidden\' name=\'patPrepayBal\' id=\'patPrepayBal\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t<input type=\'hidden\' name=\'depAdjustedYn\' id=\'depAdjustedYn\'  value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t<input type=\'hidden\' name=\'preAdjustedYn\' id=\'preAdjustedYn\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\t\t\t\t\n\t\t<input type=\'hidden\' name=\'prevUnBilledAmt\' id=\'prevUnBilledAmt\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t\t<input type=\'hidden\' name=\'prevDepAdjAmt\' id=\'prevDepAdjAmt\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t<input type=\'hidden\' name=\'prevPreAdjAmt\' id=\'prevPreAdjAmt\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\n\t\t<!-- Summary Related Data -->\t\t\n\t\t<input type=\'hidden\' name=\'errorCheck\' id=\'errorCheck\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t<input type=\'hidden\' name=\'error\' id=\'error\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t\t<input type=\'hidden\' name=\'warning\' id=\'warning\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t<input type=\'hidden\' name=\'slmtErrorCheck\' id=\'slmtErrorCheck\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'slmtError\' id=\'slmtError\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'slmtWarning\' id=\'slmtWarning\'  value=\'\'>\n\t\t<input type=\'hidden\' name=\'splDepYN\' id=\'splDepYN\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n\t\t<input type=\'hidden\' name=\'ipBill\' id=\'ipBill\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t<input type=\'hidden\' name=\'billGenOpt\' id=\'billGenOpt\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t<input type=\'hidden\' name=\'billGenType\' id=\'billGenType\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n\n\t\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\'  value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t<input type=\'hidden\' name=\'payerPolDesc";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' id=\'payerPolDesc";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="/";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\t\n\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n</form>\t\n\t\n\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t<div name=\'tooltiplayer";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'tooltiplayer";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' style=\'position:absolute; width:35%; visibility:hidden; z-index: 150;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'>\n\t\t\t\t\t<table id=\'tooltiptable";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'> \n\t\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t\t<td colspan=\"2\"  class=\'LABEL\'>\n\t\t\t\t\t\t\t<span onclick=\"javascript:hideToolTip(";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =")\">Hide</span>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tPayer\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"width: 100%\"> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t\tBlng Group\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t\tPriority\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t</tr> \n\t\t\t\t\t\n\t\t\t\t\t<tr> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tPolicy Type\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t</td> \n\n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tPolicy No\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t</tr> \n\t\t\t\t\t<tr> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tEffective From\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t\t</td> \n\n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tEffective To\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t</tr> \n\t\t\t\t\t<tr> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tCredit Auth Ref\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t</td> \n\n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\tCredit Auth Date\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td width=\"25%;\" class = \'contextMenuItem\' style=\'cursor:pointer\'  nowrap >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t</tr> \n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- </td> -->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n</body>\n\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n</html>\n\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );
	
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


private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

	
private String checkForNull(String inputString)
{
	if (inputString == null) return "";
	if(inputString.equals("null")) return "";
	
	return  inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String queryString = request.getQueryString();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

System.out.println("=======================came========================");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String facilityId																			=	"";


int constCount = 50;
String nextYn = "N";
String prevYn = "N";
String traversal = "N";
String fromRcrd = "";
String toRcrd = "";
int startIndex = 0;
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
//Added By Rajesh V


String service_code																			=	"";
String service_class																			=	"";
String billing_service																			=	"";
String item																			=	"";
String ent_servGroup																			=	"";
String ent_GrpLine																			=	"";
String from_date																			=	"";
String to_date																			=	"";

String groupLineService="";
String episodeType="";
String patientId="";
String episodeId="";
String visitId="";
String locale="";
Connection conn = null;
List<BillReceiptServiceDetails> serviceDetails = new ArrayList<BillReceiptServiceDetails>();
List<BillReceiptCustomerDetails> custDetails = null;
String beanId = "BillReceiptExistOrderExclusion" ;
String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
int maxPayer = 0;
String loginUser = (String) session.getValue("login_user");
Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String client_ip_address = p.getProperty("client_ip_address");
try  
{
	sStyle 																				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																				= 	(String)session.getAttribute("LOCALE");
	facilityId																			=   (String) session.getValue( "facility_id" ) ;
	service_code																		=	checkForNull(request.getParameter("serviceCode"));
	service_class																		=	checkForNull(request.getParameter("serviceClass"));
	billing_service																		=	checkForNull(request.getParameter("billingService"));
	item																				=	checkForNull(request.getParameter("item"));
	ent_servGroup																		=	checkForNull(request.getParameter("entServGroup"));
	ent_GrpLine																			=	checkForNull(request.getParameter("entGrpLine"));
	from_date																			=	checkForNull(request.getParameter("fromDate"));
	to_date																				=	checkForNull(request.getParameter("toDate"));
	groupLineService																	=	checkForNull(request.getParameter("groupLineService"));
	episodeType																			=	checkForNull(request.getParameter("episodeType"));
	patientId																			=	checkForNull(request.getParameter("patientId"));
	episodeId																			=	checkForNull(request.getParameter("episodeId"));
	visitId																				=	checkForNull(request.getParameter("visitId"));
	locale																				=	checkForNull(request.getParameter("locale"));
	String serviceLocation = checkForNull(request.getParameter("serviceLocation"));
	String acctSeqNo = checkForNull(request.getParameter("acctSeqNo"));

	String depChkYn = checkForNull(request.getParameter("depChkYn"));
	String prePayChkYn = checkForNull(request.getParameter("prePayChkYn"));
	String splDepChkYn = checkForNull(request.getParameter("splDepChkYn"));
	String ipBill = checkForNull(request.getParameter("ipBill"));
	String billGenOpt = checkForNull(request.getParameter("billGenOpt"));
	String billGenType = checkForNull(request.getParameter("billGenType"));

	if("".equals(depChkYn)){
		depChkYn = "Y";
	}
	if("".equals(prePayChkYn)){
		prePayChkYn = "Y";	
	}
	if("".equals(splDepChkYn)){
		splDepChkYn = "Y";
	}
	System.err.println(depChkYn+prePayChkYn+splDepChkYn+ipBill+acctSeqNo);
	PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
	BillReceiptResponse responseBean = null;
	BillReceiptBC billreceiptBC = new BillReceiptBC();
	requestBean.setFacilityId(facilityId);
	requestBean.setServGroupCode(service_code);
	requestBean.setServClass(service_class);
	requestBean.setServCode(billing_service);
	requestBean.setItemCode(item);
	requestBean.setEntServGroup(ent_servGroup);
	requestBean.setEntGrpLine(ent_GrpLine);
	requestBean.setFromDate(from_date);
	requestBean.setToDate(to_date);
	requestBean.setGroupLineService(groupLineService);
	requestBean.setEpisodeType(episodeType);
	requestBean.setPatientId(patientId);
	requestBean.setEpisodeId(episodeId);
	requestBean.setVisitId(visitId);
	requestBean.setLocale(locale);
	requestBean.setProcessed("P");	
	requestBean.setServOrPanel(serviceLocation); //It Contains Service Location
	requestBean.setLoginUser(loginUser);
	requestBean.setClientIpAddress(client_ip_address);
	requestBean.setDepChkYn(depChkYn);
	requestBean.setPrePayChkYn(prePayChkYn);
	requestBean.setSplDepChkYn(splDepChkYn);
	requestBean.setIpBill(ipBill);
	requestBean.setBillGenOpt(billGenOpt);
	requestBean.setBillgenType(billGenType);

	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
	
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;

	requestBean.setStartFrom(startRcrd);
	requestBean.setEndWith(endRcrd);
	
	conn = ConnectionManager.getConnection();
	conn.setAutoCommit(false);
	exclusionBean.setFacilityId(facilityId);
	Set<String> exclusionSet = exclusionBean.getServiceExclusion();
	HashMap<String,BillReceiptExclusionDiscount> discMap = exclusionBean.getDiscountMap();
	List<BillReceiptExclusionDiscount> exclDiscList = exclusionBean.getExclDiscList();
	
	Set<String> groupExclusion = exclusionBean.getGroupExclusion();
	Set<String> lineExclusion = exclusionBean.getLineExclusion();
	if(discMap == null){
		discMap = new HashMap<String,BillReceiptExclusionDiscount>();
	}
	System.err.println("Before insert excl starts");
	billreceiptBC.insertExcludedServices(requestBean,exclusionBean, conn);
	System.err.println("Before insert excl ends");
	
	System.err.println("Before fetch folio starts");
	responseBean =	billreceiptBC.getServiceDetailsData(requestBean,conn);
	System.err.println("Before fetch folio ends");
	conn.rollback();
	serviceDetails = responseBean.getServiceList();
	custDetails = responseBean.getCustList();
	System.err.println("custDetails Size->"+custDetails.size());
	if(custDetails != null){
		maxPayer = custDetails.size();
	}
	totalRecord = responseBean.getTotalRecordCount();


            _bw.write(_wl_block8Bytes, _wl_block8);
 if(!(startRcrd<=1)){
					prevYn = "Y";
					traversal = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
					traversal = "Y";
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if("G".equals(groupLineService)){ 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
for(int py=1;py<=7;py++){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
for(int py=1;py<=7;py++){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(py ));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);

	
		String serviceIndKey = "";
		String serviceIndValue = "";
		String priceIndKey = "";
		String priceIndValue = "";
		BillReceiptExclusionDiscount discBean = null;
		int index = 0;
		int sNo = 0;
		System.err.println("Length ->"+serviceDetails);
		for(BillReceiptServiceDetails serviceBean: serviceDetails)
		{
						
			 sNo	  =		index+1;

			//System.out.println("<<<<<<<<<<<<IN getScreenServiceCriteria index>>>>>>>"+index);
			System.out.println("getActGrossAmt="+serviceBean.getActGrossAmt());
			System.out.println("getUpdDiscAmt="+serviceBean.getUpdDiscAmt());
			System.out.println("getAdhocDiscAmt="+serviceBean.getAdhocDiscAmt());
			System.out.println("getGrossAmt="+serviceBean.getGrossAmt());
			System.out.println("getGrossAmtPayer1="+serviceBean.getGrossAmtPayer1());
			System.out.println("getGrossAmtPayer2="+serviceBean.getGrossAmtPayer2());
			System.out.println("getDiscAmt="+serviceBean.getDiscAmt());
			System.out.println("getDiscAmtPayer1="+serviceBean.getDiscAmtPayer1());
			System.out.println("getDiscAmtPayer2="+serviceBean.getDiscAmtPayer2());
			System.out.println("getNetAmt="+serviceBean.getNetAmt());
			System.out.println("getNetAmtPayer1="+serviceBean.getNetAmtPayer1());
			System.out.println("getNetAmtPayer2="+serviceBean.getNetAmtPayer2());
			System.out.println("getTotalGross="+serviceBean.getNetAmt());
			System.out.println("getTotalDisc="+serviceBean.getNetAmtPayer1());
			System.out.println("getTotalNet="+serviceBean.getNetAmtPayer2());
			System.out.println("getAcctSeqNo="+serviceBean.getAcctSeqNo());
			
			
	
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
if("G".equals(groupLineService)){ 
					discBean = discMap.get(serviceBean.getBlngServCode());
					if(discBean == null){
						discBean = new BillReceiptExclusionDiscount();
					}						
				
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(index));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(serviceBean.getPrtGrpHdr()				!=null ? 	serviceBean.getPrtGrpHdr()		: 	"" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(serviceBean.getPrintGrpHdrDesc()			!=null ? 	serviceBean.getPrintGrpHdrDesc()		: 	"" ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(serviceBean.getPrintGrpHdrDesc() ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(serviceBean.getAcctSeqNo() ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(serviceBean.getGrossTotal()	 			!=null 	? 	serviceBean.getGrossTotal()		: 	"" ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(serviceBean.getDiscTotal() 			!=null 	? 	serviceBean.getDiscTotal()		: 	"" ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(serviceBean.getNetTotal()	 			!=null 	? 	serviceBean.getNetTotal()		: 	"" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
} 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmt() ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(serviceBean.getDiscAmt() ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmt() ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer1()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(index));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer1() ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer1()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer2() ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer2() ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer2() ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer3() ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer3() ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer3() ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer4() ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer4() ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer4() ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer5() ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(index));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer5() ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer5() ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer6() ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer6() ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer6() ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getGrossAmtPayer7() ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serviceBean.getDiscAmtPayer7() ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(serviceBean.getNetAmtPayer7() ));
            _bw.write(_wl_block120Bytes, _wl_block120);

			startIndex++;
			index++;
		}		
			
            _bw.write(_wl_block121Bytes, _wl_block121);
 if((exclDiscList != null) && (index == 0)) {

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block123Bytes, _wl_block123);
} 
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(queryString ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(groupLineService));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(maxPayer));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(responseBean.getGetPackageCount()));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(serviceLocation));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(acctSeqNo));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(responseBean.getServiceTypeCode()));
            _bw.write(_wl_block134Bytes, _wl_block134);
BillReceiptSummaryBean summ = responseBean.getSummBean(); 
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(summ.getApproxPayerAmt() ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(summ.getApproxPatAmt() ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(summ.getPatAmt() ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(summ.getExemptionAmt() ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(summ.getDepositAmt() ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(summ.getNetAmt() ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(summ.getSplDepAdjAmt() ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(summ.getSlmtAmt() ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(summ.getSplDepAmt() ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(summ.getAvlSplDepAmt() ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(summ.getAdjSplDepAmt() ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(summ.getBalSplDepAmt() ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(summ.getRefDepAdj() ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(summ.getRefDepBal() ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(summ.getRefprePayAdj() ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(summ.getRefprePaybal() ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(summ.getDepAjustedYn() ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(summ.getPreAjustedYn() ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(summ.getPrevUnBilledAmt() ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(summ.getPrevDepAdjAmt() ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(summ.getPrevPreAdjAmt() ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(responseBean.getErrorCheck()));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(responseBean.getError()));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(responseBean.getWarning()));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(responseBean.getSplDepYN()));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(ipBill));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(billGenOpt));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(billGenType));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block134Bytes, _wl_block134);

		int hdnIndex = 1;
		for(BillReceiptCustomerDetails custHdn: custDetails){ 
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(hdnIndex ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(hdnIndex ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(custHdn.getCustCode()));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(custHdn.getPolicyTypeCode() ));
            _bw.write(_wl_block173Bytes, _wl_block173);

		hdnIndex++;
		}
		
            _bw.write(_wl_block174Bytes, _wl_block174);

	int prtIndex = 1;
	for(BillReceiptCustomerDetails custPrt: custDetails){ 
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(prtIndex ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(prtIndex ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(prtIndex ));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(prtIndex ));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(replaceNull(custPrt.getCustCode()) ));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(replaceNull(custPrt.getBlngGrpId()) ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(replaceNull(custPrt.getPriority()) ));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(replaceNull(custPrt.getPolicyTypeCode()) ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(replaceNull(custPrt.getPolicyNo()) ));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(replaceNull(custPrt.getEffectiveFrom()) ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(replaceNull(custPrt.getEffectiveTo()) ));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(replaceNull(custPrt.getCreditAuthRef()) ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(replaceNull(custPrt.getCreditAuthDate()) ));
            _bw.write(_wl_block188Bytes, _wl_block188);

	prtIndex++;
	}
	
            _bw.write(_wl_block189Bytes, _wl_block189);

//beanId = "BillReceiptResponseBean";
/*String beanName = "eBL.billreceipt.response.BillReceiptResponse";
BillReceiptResponse responseBeanPersist = (BillReceiptResponse) getObjectFromBean(beanId, beanName, session);
if(responseBeanPersist != null){
	responseBeanPersist.setCustList(custList);
}*/
//putObjectInBean(beanId, responseBean, session);
}
catch(Exception e)
{
	System.out.println("<<<<<<<<<<<<<<Exception in AdditionalServicePriceDetails>>>>>>>>>>.jsp::"+e);
}
finally{
	if(conn!=null){
		ConnectionManager.returnConnection(conn);
	}
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block190Bytes, _wl_block190);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EnterpriseServiceGroup.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PayerOne.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }
}

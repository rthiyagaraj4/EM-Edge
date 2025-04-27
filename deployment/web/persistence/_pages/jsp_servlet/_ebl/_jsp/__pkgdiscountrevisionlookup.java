package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.pkgpricerevision.response.PkgPriceRevisionResponse;
import eBL.pkgpricerevision.request.PackagePriceBean;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import eBL.pkgpricerevision.bc.PkgPriceDisountBC;
import java.util.*;
import com.ehis.util.*;

public final class __pkgdiscountrevisionlookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDiscountRevisionLookup.jsp", 1737917457307L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="    \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Package Discount Revision</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/PkgBulkUpdate.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t$(document).ready(function(){\n\t\tif($(\'#priceType\').val() == \'S\'){\n\t\t\t$(\'td[id^=hideCust]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t$(\'#colHdrMain\').attr(\'colspan\',\'9\');\n\t\t\t$(\'#colHdr1\').attr(\'colspan\',\'4\');\n\t\t}\n\t\telse if($(\'#priceType\').val() == \'C\'){\n\t\t\t$(\'td[id^=hideBlng]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t$(\'#colHdrMain\').attr(\'colspan\',\'10\');\n\t\t\t$(\'#colHdr1\').attr(\'colspan\',\'5\');\n\t\t}\n\t\t\n\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t$(\'#trProgress\').show();\n\t\t}else{\n\t\t\t$(\'#trProgress\').hide();\n\t\t}\n\t\t\t\n\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t$(\'#nextSpan\').show();\n\t\t}else{\n\t\t\t$(\'#nextSpan\').hide();\n\t\t}\n\t\t\t\n\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t$(\'#previousSpan\').show();\n\t\t}else{\n\t\t\t$(\'#previousSpan\').hide();\n\t\t}\n\t\t\n\t\t$(\'#nextSpan\').click(function(){\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tdocument.location.href = \"PkgDiscountRevisionLookup.jsp?priceType=\"+$(\'#priceType\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngClassCode=\"+$(\'#blngClassCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngGrpCode=\"+$(\'#blngGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&custGrpCode=\"+$(\'#custGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&custCode=\"+$(\'#custCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&pkgCode=\"+$(\'#pkgCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\t\t\t\t\t\t\"&policyCode=\"+$(\'#policyCode\').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020\n\n\t\t});\n\t\t$(\'#previousSpan\').click(function(){\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\tdocument.location.href = \"PkgDiscountRevisionLookup.jsp?priceType=\"+$(\'#priceType\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngClassCode=\"+$(\'#blngClassCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngGrpCode=\"+$(\'#blngGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&custGrpCode=\"+$(\'#custGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&custCode=\"+$(\'#custCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&pkgCode=\"+$(\'#pkgCode\').val()+\n\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\t\t\t\t\t\t\"&policyCode=\"+$(\'#policyCode\').val(); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020\n\t\t});\n\t\t\n\t\t$(\'#filterBtn\').click(function(){\n\t\t\tdocument.location.href = \"PkgDiscountRevisionLookup.jsp?priceType=\"+$(\'#priceType\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngClassCode=\"+$(\'#filterBlngClass\').val()+\n\t\t\t\t\t\t\t\t\t\"&blngGrpCode=\"+$(\'#filterBlngGrp\').val()+\n\t\t\t\t\t\t\t\t\t\"&custGrpCode=\"+$(\'#filterCustGrp\').val()+\n\t\t\t\t\t\t\t\t\t\"&custCode=\"+$(\'#filterCust\').val()+\n\t\t\t\t\t\t\t\t\t\"&pkgCode=\"+$(\'#filterPkgCode\').val();\n\t\t});\n\t\t\n\t\t$(\'#resetBtn\').click(function(){\n\t\t\tvar srchDoc = parent.search.document\n\t\t\tvar pkgCode = $(srchDoc).find(\'#pkgCode\').val();\n\t\t\tif(pkgCode == \'\'){\n\t\t\t\tpkgCode = \'**\';\n\t\t\t}\n\t\t\tdocument.location.href = \"PkgDiscountRevisionLookup.jsp?priceType=\"+$(\'#priceType\').val()+\n\t\t\t\t\t\t\t\t\t\"&pkgCode=\"+pkgCode;\n\t\t});\n\t});\n\t\n\tfunction processScroll()\n\t{\n\t\tvar x = document.body.scrollLeft;\n\t\tvar y = document.body.scrollTop;\n\t\tvar px = \'\';\n\n\t\tif(y > 0)\n\t\t{\n\t\t\n\t\t\tpx = y+\"px\";\n\t\t\t$(\'#fixedHeaderTop\').css(\'top\',px);\n\t\t\t$(\'#fixedHeaderTop\').css(\'position\',\'relative\');\n\t\t\t$(\'#fixedHeaderTop1\').css(\'top\',px);\n\t\t\t$(\'#fixedHeaderTop1\').css(\'position\',\'relative\');\n\t\t\t$(\'#fixedHeaderTop2\').css(\'top\',px);\n\t\t\t$(\'#fixedHeaderTop2\').css(\'position\',\'relative\');\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t$(\'#fixedHeaderTop\').css(\'top\',\'0px\');\n\t\t\t$(\'#fixedHeaderTop\').css(\'position\',\'relative\');\n\t\t\t$(\'#fixedHeaderTop1\').css(\'top\',\'0px\');\n\t\t\t$(\'#fixedHeaderTop1\').css(\'position\',\'relative\');\n\t\t\t$(\'#fixedHeaderTop2\').css(\'top\',\'0px\');\n\t\t\t$(\'#fixedHeaderTop2\').css(\'position\',\'relative\');\n\t\t\t\n\t\t}\n\t}\n\t</script>\n</head>\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\" onScroll=\"processScroll();\">\n\t<form name=\'priceRevisionFrm\' id=\'priceRevisionFrm\' id=\'priceRevisionFrm\'>\n\t\t<table id=\'priceRevisionTbl\' name=\'priceRevisionTbl\' id=\'priceRevisionTbl\' width=\"100%\" cellpadding=\'3\'  cellspacing=0 align=\"center\" class=\'grid\' border=\"1\">\n\t\t\t<tr  id=\'fixedHeaderTop\'>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"10\" id=\'colHdrMain\' align=\"center\">\n\t\t\t\t\tDiscount Price Revision Lookup\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr  id=\'fixedHeaderTop1\'>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"6\" id=\'colHdr1\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"2\" align=\"center\">\n\t\t\t\t\tCurrent Discount\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"3\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr  id=\'fixedHeaderTop2\'>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\tSno\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap  id=\'hideBlngGroupTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap id=\'hideCustGroupTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap id=\'hideCustTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'filterBtn\' id=\'filterBtn\' id=\'filterBtn\' value=\'Search\'>\n\t\t\t\t\t&nbsp;<input type=\'button\' class=\'button\' name=\'resetBtn\' id=\'resetBtn\' id=\'resetBtn\' value=\'Reset\'>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\'text\' name=\'filterPkgCode\' id=\'filterPkgCode\' id=\'filterPkgCode\' size=\"10\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td  id=\'hideBlngGroup1\'>\n\t\t\t\t\t<input type=\'text\' name=\'filterBlngGrp\' id=\'filterBlngGrp\' id=\'filterBlngGrp\' size=\"10\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\'text\' name=\'filterBlngClass\' id=\'filterBlngClass\' id=\'filterBlngClass\' size=\"10\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td id=\'hideCustGroup1\'>\n\t\t\t\t\t<input type=\'text\' name=\'filterCustGrp\' id=\'filterCustGrp\' id=\'filterCustGrp\' size=\"10\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td  id=\'hideCustGroup1\'>\n\t\t\t\t\t<input type=\'text\' name=\'filterCust\' id=\'filterCust\' id=\'filterCust\' size=\"10\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td  nowrap=\"nowrap\">\n\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t\t<span id=\'previousSpan\'>Previous</span>\n\t\t\t\t\t</span>\n\t\t\t\t</td>\n\t\t\t\t<td  nowrap=\"nowrap\">\n\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t\t<span id=\'nextSpan\'>Next</span>\n\t\t\t\t\t</span>\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\'4\'>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<tr onclick=\"moveData(\'Discount\',";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =")\">\n\t\t\t\t<td class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" id=\'pkgCode";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<td class=\"label\" style=\"display: none\" id=\'blngGroup";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<td class=\"label\" id=\'blngGroup";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td class=\"label\" id=\'blngClassCode";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" id=\'hideCustGrp";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" id=\'hideCust";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"label\" id=\'currPrice";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" id=\'currType";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"label\" id=\'effFrom";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" id=\'effTo";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'pkgDesc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'pkgDesc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'pageId\' id=\'pageId\' id=\'pageId\' value=\'Discount\'>\n\t\t<input type=\'hidden\' name=\'priceType\' id=\'priceType\' id=\'priceType\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=\'hidden\' name=\'blngClassCode\' id=\'blngClassCode\' id=\'blngClassCode\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'blngGrpCode\' id=\'blngGrpCode\' id=\'blngGrpCode\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=\'hidden\' name=\'custGrpCode\' id=\'custGrpCode\' id=\'custGrpCode\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'custCode\' id=\'custCode\' id=\'custCode\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=\'hidden\' name=\'pkgCode\' id=\'pkgCode\' id=\'pkgCode\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'policyCode\' id=\'policyCode\' id=\'policyCode\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String priceType = checkForNull(request.getParameter("priceType"));
	String blngClass = checkForNull(request.getParameter("blngClassCode"));
	String blngGroup = checkForNull(request.getParameter("blngGrpCode"));
	String custGrpCode = checkForNull(request.getParameter("custGrpCode"));
	String custCode = checkForNull(request.getParameter("custCode"));
	String pkgCode = checkForNull(request.getParameter("pkgCode"));
	String facilityId = (String)session.getAttribute("facility_id");
	String policyCode = checkForNull(request.getParameter("policyCode")); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
	//For Traversal
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
	//For Traversal
	//Call to BC to get Lookup List
		PkgPriceDisountBC priceDiscountBC = new PkgPriceDisountBC();
		PkgPriceRevisionRequest priceRevisionRequest = new PkgPriceRevisionRequest();
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> discountList = null;
		try{
			priceRevisionRequest.setPriceType(priceType);
			priceRevisionRequest.setBlngClassCode(blngClass);
			priceRevisionRequest.setBlngGroupCode(blngGroup);
			priceRevisionRequest.setCustGroupCode(custGrpCode);
			priceRevisionRequest.setCustCode(custCode);	
			priceRevisionRequest.setPkgCode(pkgCode);
			priceRevisionRequest.setFacilityId(facilityId);
			priceRevisionRequest.setRevisionType("Discount");
			priceRevisionRequest.setPolicyCode(policyCode); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			
			//For Traversal
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

			priceRevisionRequest.setStartFrom(startRcrd);
			priceRevisionRequest.setEndWith(endRcrd);
			priceRevisionRequest.setConstCount(constCount);
			//For Traversal
			
			priceRevisionResponse = priceDiscountBC.priceDiscountRevision(priceRevisionRequest);
			discountList = priceRevisionResponse.getPriceList();
			if(discountList == null){
				discountList = new ArrayList<PackagePriceBean>();
			}
			nextYn = priceRevisionResponse.getNextYN();
			prevYn = priceRevisionResponse.getPrevYN();
			traversal = priceRevisionResponse.getTraversal();
		}
		catch(Exception e){
			System.err.println("Exception in calling priceDiscountRevision->"+e);
		}
		//Call to BC to get Lookup List

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkgCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(blngGroup));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(blngClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(custGrpCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(custCode));
            _bw.write(_wl_block18Bytes, _wl_block18);

			int tableIndex = 1;
			for(PackagePriceBean discountBean: discountList){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(startIndex ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getPkgCode()));
            _bw.write(_wl_block23Bytes, _wl_block23);
if("C".equals(priceType)){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(discountBean.getBlngGroupCode()));
            _bw.write(_wl_block26Bytes, _wl_block26);
} else{ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(discountBean.getBlngGroupCode()));
            _bw.write(_wl_block26Bytes, _wl_block26);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getBlngClassCode()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getCustGroupCode()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getCustCode()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getCurrentPriceValue()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getCurrentPriceType()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getEffectiveFrom()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discountBean.getEffectiveTo()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(discountBean.getPkgDesc()));
            _bw.write(_wl_block38Bytes, _wl_block38);

			tableIndex++;
			startIndex++;
		} 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(priceType ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(blngClass ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(blngGroup ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(custGrpCode ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(custCode ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(pkgCode ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(policyCode ));
            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageCode.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Customer.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

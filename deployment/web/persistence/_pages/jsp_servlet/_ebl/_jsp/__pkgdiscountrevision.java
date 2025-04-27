package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.pkgpricerevision.request.PackagePriceBean;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgdiscountrevision extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDiscountRevision.jsp", 1737917451182L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="    \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Package Discount Revision</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonCalendar.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/PkgBulkUpdate.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t$(document).ready(function(){\n\t\tif($(\'#priceType\').val() == \'S\'){\n\t\t\t$(\'td[id^=hideCust]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t//$(\'#colHdrMain\').attr(\'colspan\',\'11\');\n\t\t\t$(\'#colHdr1\').attr(\'colspan\',\'5\');\n\t\t\t$(\'#mandImgBlngGr\').css(\'visibility\',\'visible\');\n\t\t}\n\t\telse if($(\'#priceType\').val() == \'C\'){\n\t\t\t$(\'td[id^=hideBlngGrp]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t$(\'#colHdr1\').attr(\'colspan\',\'6\');\n\t\t}\n\t\t\n\t\tif($(\'#addNew\').val() == \'Y\'){\n\t\t\taddNewDiscount();\n\t\t}\n\t\t\n\t\t$(\"body\").on(\"keydown\", \"input:text\", function (e){\t\t\t\n\t\t\tif($(this).prop(\'readonly\') && e.which == 8){\n\t\t\t\te.preventDefault();  \n\t\t\t    return false; \n\t\t\t}\n\t\t});\n\t});\t\n\t</script>\n</head>\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\">\n\t<form name=\'priceRevisionFrm\' id=\'priceRevisionFrm\' id=\'priceRevisionFrm\'>\n\t\t<table id=\'priceRevisionTbl\' name=\'priceRevisionTbl\' id=\'priceRevisionTbl\' width=\"100%\" cellpadding=\'3\'  cellspacing=0 align=\"center\" class=\'grid\' border=\"1\">\n\t\t\t<!-- <tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"13\" id=\'colHdrMain\' align=\"center\">\n\t\t\t\t\tDiscount Price Revision\n\t\t\t\t</td>\n\t\t\t</tr>  -->\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"7\" id=\'colHdr1\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"2\" align=\"center\">\n\t\t\t\t\tCurrent Discount\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"2\" align=\"center\">\n\t\t\t\t\tRevised Revision\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap colspan=\"3\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\tSno\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap >\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap id=\'hideBlngGrpTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'mandImgBlngGr\' style=\"visibility: hidden;\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap id=\'hideCustGroupTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap id=\'hideCustTd\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\tSelect\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<tr rowValue=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'tr";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t<td class=\'label\' nowrap id=\'tdSn";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'text\' size=\'10\' readonly name=\'pkgCode";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'pkgCode";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input type=\'text\' size=\'15\' name=\'pkgDesc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'pkgDesc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' readonly >\n\t\t\t\t\t\t&nbsp; <input type=\'button\' disabled  class=\'button\' id=\'pkgLkpBtn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\'pkgLkpBtn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'?\' >\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' size=\'10\' name=\'blngGroup";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'blngGroup";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' readonly>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' size=\'10\'  name=\'blngGroup";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onblur=\'if(this.value.length>0){ callCommonLookupWoDesc(blngGroup";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",5,1); }\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t&nbsp; <input type=\'button\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" class=\'button\' id=\'blngGroupBtn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'blngGroupBtn";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\'?\' onclick=\'callCommonLookupWoDesc(blngGroup";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =",5,1);\'>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<td class=\'fields\' nowrap style=\'display:none;\' id=\'hideBlngGrpTd";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\t\t\t\t<input type=\'text\' size=\'10\'  name=\'blngGroup";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =",5,1); }\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<input type=\'text\' size=\'10\' name=\'blngClass";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'blngClass";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' readonly>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' onblur=\'if(this.value.length>0){ callCommonLookupWoDesc(blngClass";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =",6,1); }\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t&nbsp; <input ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" type=\'button\' class=\'button\' id=\'blngClassBtn";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' name=\'blngClassBtn";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\'?\' onclick=\'callCommonLookupWoDesc(blngClass";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =",6,1);\'>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<td class=\'fields\' nowrap style=\'display:none;\' id=\'hideCustGrpTd";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n\t\t\t\t\t\t<input type=\'text\'  size=\'10\' name=\'custGrp";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'custGrp";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onblur=\'if(this.value.length>0){ callCommonLookupWoDesc(custGrp";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =",2,1); }\'>\n\t\t\t\t\t\t&nbsp; <input type=\'button\' class=\'button\' id=\'custGrpLkpBtn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' name=\'custGrpLkpBtn";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' value=\'?\' onclick=\'callCommonLookupWoDesc(custGrp";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =",2,1);\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap style=\'display:none;\' id=\'hideCustTd";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t\t\t<input type=\'text\' size=\'10\' name=\'cust";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'cust";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' onblur=\'if(this.value.length>0){ callCommonLookupWoDesc(cust";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =",3,1,custGrp";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="); }\'>\n\t\t\t\t\t\t&nbsp; <input type=\'button\' class=\'button\' id=\'custBtn";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' name=\'custBtn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' value=\'?\' onclick=\'callCommonLookupWoDesc(cust";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =");\'>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t<input type=\'text\' size=\'10\' name=\'custGrp";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =",2,1); }\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t&nbsp; <input type=\'button\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" class=\'button\' id=\'custGrpLkpBtn";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =",2,1);\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<input type=\'text\' size=\'10\' name=\'cust";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="); }\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" class=\'button\' id=\'custBtn";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =");\'>\n\t\t\t\t\t</td> \n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input readonly type=\'text\' size=\'10\' maxlength=\'13\' name=\'currentValue";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'currentValue";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' onkeypress=\'return checkForSpecChars(event)\' >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<Select name=\'currentType";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'currentType";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' disabled >\n\t\t\t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">Select</option>\n\t\t\t\t\t\t\t<option value=\'R\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =">Percentage</option>\n\t\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">Amount</option>\n\t\t\t\t\t\t</Select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input type=\'text\' size=\'10\' maxlength=\'13\' name=\'revisedValue";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'revisedValue";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' onkeypress=\'return checkForSpecChars(event)\' onblur=\'checkForNumberDecimal(this);checkForPerc(revisedType";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =",this)\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<Select name=\'revisedType";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'revisedType";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' onchange=\"checkForPerc(this,revisedValue";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =")\">\n\t\t\t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =">Select</option>\n\t\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =">Amount</option>\n\t\t\t\t\t\t</Select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input type=\'text\' id=\'effFrom";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' name=\'effFrom";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' size=\'10\' onblur=\'validateDiscountDate(this,this,effTo";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =",";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =");\'>\t\t\t\t\t\t\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'effFrom_ctrl_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' onClick=\'return showCalendarLocal(1,";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =")\' />\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input type=\'text\'  id=\'effTo";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' name=\'effTo";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' size=\'10\' onblur=\'validateDiscountDate(this,effFrom";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =",this,";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =");\'>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effTo_ctrl_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' onClick=\'return showCalendarLocal(2,";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =")\' />\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t<input type=\'checkbox\' id=\'removeChk";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' name=\'removeChk";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t\t\t\t</td> \n\t\t\t\t\t<input type=\'hidden\' id=\'status";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' name=\'status";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'\tvalue=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'pageId\' id=\'pageId\' id=\'pageId\' value=\'Discount\'>\n\t\t<input type=\'hidden\' name=\'priceType\' id=\'priceType\' id=\'priceType\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t<input type=\'hidden\' name=\'lastRowIndex\' id=\'lastRowIndex\' id=\'lastRowIndex\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' />\n\t\t<input type=\'hidden\' name=\'addNew\' id=\'addNew\' id=\'addNew\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t<input type=\'hidden\' name=\'sBlngClassCode\' id=\'sBlngClassCode\' id=\'sBlngClassCode\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t<input type=\'hidden\' name=\'sCustGrpCode\' id=\'sCustGrpCode\' id=\'sCustGrpCode\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t<input type=\'hidden\' name=\'sCustCode\' id=\'sCustCode\' id=\'sCustCode\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t<input type=\'hidden\' name=\'sPkgCode\' id=\'sPkgCode\' id=\'sPkgCode\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' />\t\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String priceType = request.getParameter("priceType");
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	String addNew =  checkForNull(request.getParameter("addNew"));		
	String sBlngClassCode = checkForNull(request.getParameter("sBlngClassCode"));
	String sCustGrpCode = checkForNull(request.getParameter("sCustGrpCode"));
	String sCustCode = checkForNull(request.getParameter("sCustCode"));
	String sPkgCode = checkForNull(request.getParameter("sPkgCode"));
	String beanId = "PkgPriceRevisionRequest" ;
	String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
	PkgPriceRevisionRequest pkgPriceDiscount = null;
	List<PackagePriceBean> discountRevision = null;
	try{
		pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
		if(pkgPriceDiscount.getDiscountRevision() == null){
			pkgPriceDiscount.setDiscountRevision(new ArrayList<PackagePriceBean>());
		}
		discountRevision = pkgPriceDiscount.getDiscountRevision();
		
	}
	catch(Exception e){
		
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

			int tableIndex = 1;
			String readOnly = "";
			String disabled = "";
			for(PackagePriceBean discountBean: discountRevision){ 
				if("U".equals(discountBean.getStatus())){
					readOnly = "readonly";
					disabled = "disabled";
				}
				else{
					readOnly = "";
					disabled = "";
				}
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getPkgCode() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getPkgDesc() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block29Bytes, _wl_block29);
if("S".equals(priceType)){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
if("readonly".equalsIgnoreCase(readOnly)){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getBlngGroupCode() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getBlngGroupCode() ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
					else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getBlngGroupCode() ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);
if("readonly".equalsIgnoreCase(readOnly)){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getBlngClassCode() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getBlngClassCode() ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block50Bytes, _wl_block50);
} 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block55Bytes, _wl_block55);
if("S".equals(priceType)){ 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustGroupCode() ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustCode() ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
				else{
            _bw.write(_wl_block45Bytes, _wl_block45);
if("readonly".equalsIgnoreCase(readOnly)){ 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustGroupCode() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{ 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustGroupCode() ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block73Bytes, _wl_block73);
} 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block76Bytes, _wl_block76);
if("readonly".equalsIgnoreCase(readOnly)){ 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustCode() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{ 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCustCode() ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block78Bytes, _wl_block78);
} 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block80Bytes, _wl_block80);
} 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getCurrentPriceValue() ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf("".equals(discountBean.getCurrentPriceType())?"selected":"" ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf("R".equals(discountBean.getCurrentPriceType())?"selected":"" ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf("A".equals(discountBean.getCurrentPriceType())?"selected":"" ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getRevisedPriceValue() ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf("".equals(discountBean.getRevisedPriceType())?"selected":"" ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf("P".equals(discountBean.getRevisedPriceType())?"selected":"" ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf("A".equals(discountBean.getRevisedPriceType())?"selected":"" ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getEffectiveFrom() ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discountBean.getEffectiveTo() ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(discountBean.getStatus() ));
            _bw.write(_wl_block113Bytes, _wl_block113);

			tableIndex++;
			} 
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(priceType ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(addNew ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sBlngClassCode ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(sCustGrpCode ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(sCustCode ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(sPkgCode ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block122Bytes, _wl_block122);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDesc.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Customer.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

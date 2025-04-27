package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.text.*;
import eXH.InterfaceUtil;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __maintreatmentpackage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MainTreatmentPackage.jsp", 1742965168582L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n----------------------------------------------------------------------------------------\n1            V210622                  \t      PMG2021-COMN-CRF-0076      PalaniNarayanan\n2\t     V210730           16777\t      PMG2021-COMN-CRF-0076      Mohana Priya\n3\t         V211022           23078\t        PMG2021-COMN-CRF-0076.1      Mohana Priya\n4\t\t\t V211118\t\t   23078\t        PMG2021-COMN-CRF-0076.1      Manivel Natarajan\n5\t\t\t\t\t\t\t\t30618\t\t  PMG2021-COMN-CRF-0076.2    \t\t  Manivel N\n6\t\t\tV240131\t\t\t\t\t\tRBU-GHL-CRF-0026-US003\t\t\t\tNamrata Charate\n----------------------------------------------------------------------------------------\n-->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<style>\n#table-wrapper {\n  position:relative;\n}\n#table-scroll {\n height: 200px;\n width: 512px; \n  overflow: scroll;\n}\n\ndiv.ex1 {\n\theight: 190px;\n\twidth: 1900px;\n\toverflow: scroll;\n}\n/*\ndiv.ex2 {\n\theight: 200px;\n\twidth: 1900px;\n\toverflow: scroll;\n}\t*/\n\n#table-wrapper table {\n  width:100%;\n}\n#table-wrapper table  {\n  background:white;\n  color:black;\n}\n#table-wrapper table thead tr {\n\tposition: relative;\n\ttop: expression(offsetParent.scrollTop);\n\tz-index: 2;\n\theight: 20px;\n\twidth: 35%;\n}\n\nTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\n</style>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<!-- \n<script language=\"javascript\" src=\'../js/PkgAdhocDiscount.js\'></script> \n -->\n\n<script type=\"text/javascript\">\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\t\nfunction lockKey()\n{\t \n\tif(event.keyCode == 93)\n\t\talert(\"Welcome to eHIS\");\n}\n\nfunction lockbackSpace()\n{\n\n var mode = document.mode.value;\n\n if(mode==\'modify\' && window.event.keyCode==8)\n  {\n   \n  }\n}\n\t \n\t\n\nfunction Noprevileage()\n{\n\talert(getMessage(\"BL0938\",\"BL\"));\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>MTP</title>\n</head>\n\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onScroll=\"processScroll()\"   onSelect=\"codeArrestThruSelect();\" >\n<form name=\'frmMaintainTreat\' id=\'frmMaintainTreat\' method=\'post\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<center>\n\n\t\t\t<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"pad4side\">\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\" cellpadding=\"1\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"CAGROUPHEADING\">Package Details</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t\t\t<div class=\"ex1\">\n\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"124%\"\n\t\t\t\t\t\t\t\t\tid=\"panel_categories_header_table\"\n\t\t\t\t\t\t\t\t\tname=\"panel_categories_header_table\" id=\"panel_categories_header_table\" border=\"1\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"tableContainer\">\n\t\t\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Pkg\n\t\t\t\t\t\t\t\t\t\t\t\t\tCode</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Pkg\n\t\t\t\t\t\t\t\t\t\t\t\t\tSeq No</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'3%\' align=\"center\" nowrap>Billing\n\t\t\t\t\t\t\t\t\t\t\t\t\tClass</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Cust\n\t\t\t\t\t\t\t\t\t\t\t\t\tGrp Code</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Cust\n\t\t\t\t\t\t\t\t\t\t\t\t\tCode</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Pkg\n\t\t\t\t\t\t\t\t\t\t\t\t\tAmt</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Total\n\t\t\t\t\t\t\t\t\t\t\t\t\tDiscount</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Deposit\n\t\t\t\t\t\t\t\t\t\t\t\t\tAmt</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Addl.\n\t\t\t\t\t\t\t\t\t\t\t\t\tCharge</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Utilized\n\t\t\t\t\t\t\t\t\t\t\t\t\tAmt</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\' align=\"center\" nowrap>Eff From\n\t\t\t\t\t\t\t\t\t\t\t\t\tDate</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\' align=\"center\" nowrap>Eff To\n\t\t\t\t\t\t\t\t\t\t\t\t\tDate</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align=\"center\" nowrap>Practitioner\n\t\t\t\t\t\t\t\t\t\t\t\t\tName</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align=\"center\" nowrap>Encounter\n\t\t\t\t\t\t\t\t\t\t\t\t\tID</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\"  nowrap>Associate\n\t\t\t\t\t\t\t\t\t\t\t\t\t/ Deassociate</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\"  nowrap>Adhoc\n\t\t\t\t\t\t\t\t\t\t\t\t\tDiscount</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\" nowrap>Cancel\n\t\t\t\t\t\t\t\t\t\t\t\t\tPackage</td>\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\"  nowrap>Cancel\n\t\t\t\t\t\t\t\t\t\t\t\t\tReason</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' align=\"center\"  nowrap>Cancel\n\t\t\t\t\t\t\t\t\t\t\t\t\tUnprocessed Orders</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\' align=\"center\" nowrap>Report</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t\t\t\t\t\t\t\t\t<tr id=\'row";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' href=\"#\" name=\'package_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'package_code";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" nowrap> <a href=\"#\" onclick=\"highlightRow(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =",\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');showPackageServiceDetails(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'package_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'package_seq_no";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'package_seq_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'blng_class_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'blng_class_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_blng_class_code_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'hid_blng_class_code_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' />\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'blng_class_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_blng_class_code_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' />\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'cust_group_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'cust_group_code_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'cust_group_code_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'cust_code_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'cust_code_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'cust_code_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'package_amt";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'package_amt";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'package_amt";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'total_disc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'total_disc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap onMouseOver=\"displayToolTip(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\',this)\" onMouseOut=\'hideToolTip()\' onFocus=\"displayToolTip(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonBlur=\'hideToolTip()\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"LABEL\" name=\'doc_num";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'doc_num";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</span>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'deposit_amt1";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'deposit_amt1";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'addl_chg_value";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'addl_chg_value";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'addl_chg_value";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' name=\'utilized_amt";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'utilized_amt";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'8%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'eff_from_date";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'eff_from_date";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' size=\'10\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"  onBlur=\"isValidDateTime(this)\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"chkPrivForEffDateChange(\'eff_from_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\',\'dd/mm/yyyy\',\'hh:mm:ss\')\" name=\"eff_from";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"eff_from";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" onKeyPress=\"return lockbackSpace();\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"db_eff_from_date";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" type=\"hidden\" id=\"db_eff_from_date";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'8%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input type=\'text\' name=\'eff_to_date";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\'eff_to_date";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' size=\'10\' maxlength=\'10\' onKeyPress=\"return lockbackSpace();\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" readonly>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'10%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input type=\"text\" name=\"prac_name";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"prac_name";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" onBlur=\'if(this.value!=\"\"){Prac_lkup(this,prac_code";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =")} else{fnClearCode(prac_code";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =")}\'/><input\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"prac_code";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" type=\"hidden\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"prac_code";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"> <input  \n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"prac_btn";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" type=\"button\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"prac_btn";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" value=\"?\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"Prac_lkup(prac_name";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =",prac_code";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =")\" >\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'10%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input type=\"text\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"encounter_name";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"encounter_name";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" readonly />\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input name=\"enc_checkbox_dtl";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"checkbox\" id=\"enc_checkbox_dtl";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" checked\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"closeEncDetails(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'); \">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_enc_checkbox_dtl";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'hid_enc_checkbox_dtl";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_enc_deass_chkb_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'hid_enc_deass_chkb_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' value=\'\' />\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t  \t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input name=\"enc_checkbox_dtl";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"openEncDetails(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\');isValidEffFromDtChange(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'); \">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_enc_checkbox_dtl";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' value=\'\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap ><a href=\"#\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"adhocDisc";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" name=\"adhocDisc";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" onClick=\"displayAdhocDiscountDtls(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' ,\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\', \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\"><span id = \"adhocDiscDisp_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</span> \n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input name=\"cancel_chk";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"checkbox\" id=\"cancel_chk";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"cancelSelectedPackage(\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\')\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_cancel_pkg_YN_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'hid_cancel_pkg_YN_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' value=\'N\' />\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"cancel_resn";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"cancel_resn";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" value=\"\" onBlur=\"funReasonId(";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =");\" readonly />\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' id=\"button_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" disabled onClick=\"funReasonId(";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =");\" />\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap><input name=\"chb_cncl_unprocess_ord_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"checkbox\" id=\"chb_cncl_unprocess_ord_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"cancelUnprocessOrd(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\')\" disabled/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'hid_cncl_unprocess_ord_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' id=\'hid_cncl_unprocess_ord_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' value=\'N\' />\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'8%\' style=\"text-align: center;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tnowrap>\n\t\t\t\t\t\t\t\t\t\t\t<!--\t\t<input type=\"submit\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"Audit_Report";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"Audit_Report";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"Audit\" disabled /> &nbsp; \n\t\t\t\t\t\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"Utilization_Report";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"Utilization_Report";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" value=\"Utilization\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"displayUtilizationDtls(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\');\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"package_code";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"package_code";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"package_seq_no";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"package_seq_no";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t  \n            \t\t\t\t\t\t\t\t\t<input type=\"hidden\" \tid=\"order_catalog_yn";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" name=\"order_catalog_yn";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"   value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" \tid=\"enc_assoc_yn";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" name=\"enc_assoc_yn";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" \tid=\"across_enc_assoc_yn";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"across_enc_assoc_yn";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'/>\n            \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"package_amt";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"package_amt";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"deposit_amt";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"deposit_amt";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"operating_facility_id";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"operating_facility_id";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"cust_group_code";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"cust_group_code";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"cust_code";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"cust_code";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'cancel_code";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\'cancel_code";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' value=\'\' />\n\t\t\t\t\t\t\t\t\t<!--\t\t\t<input type=\'hidden\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ws_no\' id=\'ws_no\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n          -->\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"long_desc";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"long_desc";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"episode_type";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"episode_type";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"episode_id";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"episode_id";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"visit_id";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"visit_id";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"total_disc";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"total_disc";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' />\n\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"count1";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"count1";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_short_desc";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' id=\'pkg_short_desc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n\t\t\t\t\t\t\t\t\t\t<!--\t\t<input type=\'hidden\' name=\'patid\' id=\'patid\' value = \'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_short_desc\' id=\'pkg_short_desc\' value = \'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' value = \'-1\'>\t\t-->\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkgDetailsCombinationString1";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' id=\'pkgDetailsCombinationString1";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' value = \'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"delimAdhocDiscStr_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"delimAdhocDiscStr_";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" value=\'\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"isAdhocDiscountMod_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"isAdhocDiscountMod_";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" value=\'N\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"encAssString_";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"encAssString_";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" value=\'\' />\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hidOPYN_";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"hidOPYN_";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' />\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t\t \tparent.BLMaintaintreatmentPackageHdr.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\t\t\t\tparent.BLMaintaintreatmentPackage.location.replace(\"../../eCommon/html/blank.html\");\n\t\t\t\t\t\t\t\t\t\t\talert(\"There is no open Package for this patient.\");\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'8%\' style=\"text-align: center;\" nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\'text\' name=\'pre_eff_from_date";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\'pre_eff_from_date";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' size=\'10\' maxlength=\'10\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tdisabled> <img\n\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"pre_eff_from";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" id=\"pre_eff_from";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonClick=\'Noprevileage();\' disabled></td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' size=\'10\' maxlength=\'10\' disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"pre_eff_from";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"return showCalendar(\'pre_eff_from_date";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\',\'yyyy-mm-dd\',\'hh:mm:ss\');\" disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'8%\' style=\"text-align: center;\" nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\'text\' name=\'pre_eff_to_date";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\'pre_eff_to_date";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' size=\'10\' maxlength=\'10\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"\" disabled></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'10%\' style=\"text-align: center;\" nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" name=\"prac_name";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" value=\"\" disabled /> <input\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"prac_btn";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" title=\"?\" value=\"?\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"Prac_lkup()\" disabled></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'10%\' style=\"text-align: center;\" nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" name=\"encounter_name";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" disabled value=\"\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\" nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"enc_checkbox_dtl";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"enc_checkbox_dtl";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'); \"></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\" nowrap><a\n\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"#\" onclick=\"openDiscDetails();\">Links</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"  nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"cancel_chk";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"cancel_chk";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' style=\"text-align: center;\"  nowrap><input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" name=\"cancel_resn";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"cancel_resn";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" value=\'\' /><input type=\'button\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'?\' class=\'button\' onClick=\"funReasonId(\'C\')\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'4%\' align=\"left\" nowrap>&nbsp;</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'8%\' style=\"text-align: center;\" nowrap>\n\t\t\t\t\t\t\t\t\t\t<!--\t\t<input\n\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"submit\" name=\"Audit_Report";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"Audit_Report";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" value=\"Audit\" disabled />\n\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"submit\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"Utilization_Report";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" value=\"Utilization\" disabled /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</table>\n\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>&nbsp;&nbsp;&nbsp;</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"5\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"10%\">Package Description</td>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<span class=\"txtgray\"> \n\t\t\t\t\t\t\t\t\t\t<input name=\"Package_Description\" id=\"Package_Description\" type=\"text\"\n\t\t\t\t\t\t\t\t\t\tid=\"Package_Description\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" readonly />\n\t\t\t\t\t\t\t\t\t</span>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td colspan=\"6\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t </table>\n\t\t\t <input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' value = \'-1\'>\t\n\t\t\t <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'> \n          <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t\t  <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t\t  <input type=\"hidden\" id=\"totcount\" name=\"totcount\" value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\' />\n\t\t  <input type=\"hidden\" id=\"hdrModified\" name=\"hdrModified\" value=\'N\' />\n\t\t  <input type=\'hidden\' name=\'patid\' id=\'patid\' value = \'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\t\n\t\t  <input type=\'hidden\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t\t  <input type=\'hidden\' name=\'ws_no\' id=\'ws_no\' value=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n\t\t<input type=\'hidden\' name=\'calenderPrivileageYN\' id=\'calenderPrivileageYN\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'> \n\t\t<input type=\'hidden\' name=\'modifyPractPrivYN\' id=\'modifyPractPrivYN\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'> \n\t\t<input type=\'hidden\' name=\'assDeassEncPrivYN\' id=\'assDeassEncPrivYN\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'> \n\t\t<input type=\'hidden\' name=\'pkgServLmtDtlsPrivYN\' id=\'pkgServLmtDtlsPrivYN\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'> \n\t\t<input type=\'hidden\' name=\'adhocDiscPrivYN\' id=\'adhocDiscPrivYN\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'> \n\t\t<input type=\'hidden\' name=\'cancelPkgPrivYN\' id=\'cancelPkgPrivYN\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'> \t\n\t\t\n\t\t<input type=\'hidden\' name=\'effDateAuthStr\' id=\'effDateAuthStr\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n\t\t<input type=\'hidden\' name=\'adhocDiscAuthStr\' id=\'adhocDiscAuthStr\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n\t\t<input type=\'hidden\' name=\'cnclPackAuthStr\' id=\'cnclPackAuthStr\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n\t\t<input type=\'hidden\' name=\'assDeassAuthStr\' id=\'assDeassAuthStr\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n\t\t<input type=\'hidden\' name=\'pkgServDtlsAuthStr\' id=\'pkgServDtlsAuthStr\' value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n\t\t\n\t\t\n</center>\n</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'3\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t<!-- </td> -->\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\n</body> \n</html>\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 =" \n\t\n\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );
	
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


private String checkForNull(String inputString)
{

	return (inputString == null) ? "" :	inputString;
}

public String PkgAmtPriceFormat(String str) {
		if (str == null || str.equals("") || str.equals("E")) {
			str = "0.00";
		} else {
			str = String.format("%.2f", Float.parseFloat(str));
		}
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String patientid1 = "";
patientid1 = request.getParameter("patid");
System.err.println("200--maintreatpkg "+patientid1);
String pkg_short_desc = "";
String order_catalog_yn="";
String pkg_short_des= "";
String classval="";
//String pkg_service_long_desc = "";

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

			String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
					qtyFldDisabled = "", indicatorFldDisabled = "";
			String modifyStatus = "";

			String calenderPrivileageYN = "N", modifyPractPrivYN = "N", assDeassEncPrivYN = "N", pkgServLmtDtlsPrivYN = "N", adhocDiscPrivYN = "N", cancelPkgPrivYN = "N"; // V211118
			String facility_id = "";
			String userid = "";
			String function_id = "";
			String ws_no = "";
			String OP_YN = "N";
			String pkg_adhoc_disc_amt = "0";
			//String patientid1 = "";
			java.util.Properties p = null;
			facility_id = (String) session.getValue("facility_id");
			userid = (String) session.getValue("login_user");

			function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");
			//patientid1 = request.getParameter("patid");
			String params = request.getQueryString();
			int index = 0;
			
			// Added for PMG2021-COMN-CRF-0076.1
			String bean_id			= "bl_PkgAdhocDiscountBean" ;
			String bean_name		= "eBL.PkgAdhocDiscountBean";
			PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
			HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();
			bean.clearBean();
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
	
			try { // V211118
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				con = ConnectionManager.getConnection(request);

				String responseText = "";
				String sql = "select privlege_code, NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + userid
						+ "' and function_id = '" + function_id + "' and sysdate <= NVL(eff_to_date,sysdate) ";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					if("MODIFY_EFF_FROM_MTPKG".equals(rs.getString(1)))
						calenderPrivileageYN = checkForNull(rs.getString(2));
					else if("MODIFY_PRAC_NAME_MTPKG".equals(rs.getString(1)))
						modifyPractPrivYN = checkForNull(rs.getString(2));
					else if("MODIFY_ASSOC_DEASSOC_MTPKG".equals(rs.getString(1)))
						assDeassEncPrivYN = checkForNull(rs.getString(2));
					else if("MODIFY_PKG_SERV_LMT_DTLS_MTPKG".equals(rs.getString(1)))
						pkgServLmtDtlsPrivYN = checkForNull(rs.getString(2));	
					else if("ALLOW_ADHOC_DISC_ENTRY_MTPKG".equals(rs.getString(1)))
						adhocDiscPrivYN = checkForNull(rs.getString(2));	
					else if("ALLOW_CANCEL_PACKAGE_MTPKG".equals(rs.getString(1)))
						cancelPkgPrivYN = checkForNull(rs.getString(2));						
				}
			} catch (Exception e) {
				System.err.println(e);
			}			
			
			System.err.println("PrivileageYN:"+calenderPrivileageYN+"/"+modifyPractPrivYN+"/"+assDeassEncPrivYN+"/"+pkgServLmtDtlsPrivYN+"/"+adhocDiscPrivYN+"/"+cancelPkgPrivYN);
			
			String effDateAuthStr = "", cnclPackAuthStr = "", adhocDiscAuthStr = "", assDeassAuthStr = "", pkgServDtlsAuthStr = "";
			
			if("Y".equals(calenderPrivileageYN)){
				effDateAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(cancelPkgPrivYN)){
				cnclPackAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(adhocDiscPrivYN)){
				adhocDiscAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(assDeassEncPrivYN)){
				assDeassAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(pkgServLmtDtlsPrivYN)){
				pkgServDtlsAuthStr = userid + "##" + " " + "##" + "Y"; 
			}			

			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;

			String package_code = "";
		//	String pkg_short_desc = "";
			String package_seq_no = "";
			String eff_from_date = "";
			String eff_to_date = "";
			String package_amt = "";
			String deposit_amt = "";
			String utilized_amt = "";
			String blng_class_code = "";
			String cust_group_code = "";
			String cust_code = "";
			String cust_price = "";
			String encounter_associate_yn = "";
			String across_encounter_yn = "";
			String prac_name = "";
			String physician_id = "";
			String addl_chg_value = "";
			String operating_facility_id = "";
			String total_disc = "";
			//serv dtls
			String pkg_serv_ind = "";
			String pkg_serv_code = "";
			String rate_charge_ind = "";
			String order_catalog_code = "";
			String factor_rate_ind = "";
			int factor_rate_int = 0;//
			int qty_limit_int = 0;//
			String amt_limit_ind = "";
			int amt_limit_int = 0;//
			String group_service_ind = "";
			String incl_home_medication_yn = "";
			String replaceable_yn = "";
			String daily_limit_ind = "";
			int daily_qty_limit_int = 0;//
			int daily_amt_limit_int = 0;//
			String daily_amt_limit_gross_net = "";
			String replaceable_serv_code = "";
			String rep_serv_ord_cat_code = "";
			String refund_yn = "";
			int refund_rate_int = 0;//
			String apply_fact_for_srv_lmt_yn = "";
			String close_package_yn = "";
			int utilized_serv_qty_int = 0;//
			int utilized_serv_amt1_int = 0;//
			String auto_refund_yn1 = "";
			String split_allowed_yn = "";
			String encounter_name = "";

			String encounter_id = "";

			String useraccess = "N";

			String episode_id = "";
			String visit_id = "";
			String episode_type = "";
			String long_desc = "";
			String factor_rate = "";
			String qty_limit = "";
			String amt_limit = "";
			String daily_qty_limit = "";
			String refund_rate = "";
			String utilized_serv_qty = "";
			String utilized_serv_amt = "";
			String auto_refund_yn = "";
			String daily_amt_limit = "";
			String rowid = "";
			String defaultPkgCode = "";
			String defaultPkgSeq = "";
			String defaultEffFromDate = "";
			
	//		String hdrdetailsString="";
		
	//		ArrayList<String> pkghdrDetailsCombination = new ArrayList<String>();

	//		HashMap<String,ArrayList<String>>  pkghdrDetailsEncounters=new HashMap<String,ArrayList<String>>();
		

			ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();
			String pkgDetailsCombinationString = "";
			String pkgDetailsCombinationString12="";

			int count = 0;
			int cnt = 0;
			
			String discount_string = "";

			try {
				con = ConnectionManager.getConnection(request);
				HttpSession httpSession = request.getSession(false);
				//String facility_id = (String)httpSession.getValue("facility_id");
		
            _bw.write(_wl_block11Bytes, _wl_block11);

												try {

														String sqlstr = "select a.package_code, a.package_seq_no,to_char(a.eff_from_date, 'dd/mm/yyyy hh24:mi:ss') eff_from_date,to_char(a.eff_to_date, 'dd/mm/yyyy hh24:mi:ss') eff_to_date,"
																+ "a.package_amt,a.deposit_amt,a.utilized_amt,a.blng_class_code,a.cust_group_code,a.cust_code,a.cust_price,case when b.episode_type in ('I','E') then b.encounter_id else to_number(b.encounter_id||lpad(visit_id,4,'0')) end encounter_id,"
																+ "case when b.patient_id is not null then 'Y' else 'N' end encounter_associate_yn,a.physician_id,a.across_encounter_yn,(select am.short_name from am_practitioner am where am.practitioner_id=a.physician_id) prac_name,a.order_catalog_yn,"
																+ "a.addl_chg_value,a.operating_facility_id,a.patient_id,b.encounter_id episode_id,b.visit_id,b.episode_type,(select short_desc from bl_package_lang_vw p where p.operating_facility_id = a.operating_facility_id and p.package_code = a.package_code and upper(language_id) = upper('"
																+ locale + "')) package_short_desc,"
																+ "blpackage.get_total_discount_for_pkg(A.OPERATING_FACILITY_ID,a.PATIENT_ID,a.package_code,a.PACKAGE_SEQ_NO,a.PACKAGE_AMT,b.episode_type,b.encounter_id,b.visit_id) total_discount, blpackage.get_discount_for_pkg_str(a.operating_facility_id,a.patient_id,a.package_code,a.package_seq_no,'','',a.package_amt,b.episode_type,b.encounter_id,b.visit_id) discount_string, NVL(OP_YN,'N') OP_YN,  "
																+ " blpackage.get_adhoc_discount_for_pkg(a.operating_facility_id, a.patient_id,a.package_code,a.package_seq_no, a.package_amt, b.episode_type,b.encounter_id,b.visit_id) pkg_adhoc_disc_amt "
																+ " from bl_package_sub_hdr a, bl_package_encounter_dtls b "
																+ " where a.patient_id='" + patientid1
																+ "' AND a.OPERATING_FACILITY_ID = '"+facility_id
																+ "' and a.status = 'O' and a.operating_facility_id = b.operating_facility_id(+) and a.patient_id = b.patient_id(+) and a.package_code = b.package_code(+) and a.package_seq_no = b.package_seq_no(+) order by a.package_seq_no desc"; //V211022
System.err.println("sqlstr:"+sqlstr);
														/*String sqlstr="select a.PACKAGE_CODE,a.PACKAGE_SEQ_NO,to_char(a.EFF_FROM_DATE, 'dd/mm/yyyy hh24:mi:ss') EFF_FROM_DATE,to_char(a.EFF_TO_DATE, 'dd/mm/yyyy hh24:mi:ss') EFF_TO_DATE,"+
														"a.PACKAGE_AMT,a.DEPOSIT_AMT,a.UTILIZED_AMT,a.BLNG_CLASS_CODE,a.CUST_GROUP_CODE,a.CUST_CODE,a.CUST_PRICE,case when b.episode_type in ('I','E') then b.encounter_id else to_number(b.encounter_id||lpad(visit_id,4,'0')) end encounter_id,"+
														"case when b.patient_id is not null then 'Y' else 'N' end encounter_associate_yn,(select am.SHORT_NAME from am_practitioner am where am.PRACTITIONER_ID=a.PHYSICIAN_ID) prac_name,"+
														"a.ADDL_CHG_VALUE,A.OPERATING_FACILITY_ID,a.PATIENT_ID,b.encounter_id episode_id,b.visit_id,b.episode_type from bl_package_sub_hdr a, bl_package_encounter_dtls b "+
														"where a.patient_id='"+patientid1+"' and a.status = 'O' and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID(+) and a.patient_id = b.patient_id(+) and a.PACKAGE_CODE = b.PACKAGE_CODE(+) and a.PACKAGE_SEQ_NO = b.PACKAGE_SEQ_NO(+)
														*/
														System.err.println("sqlstr in pkg header : "+sqlstr);
														pstmt = con.prepareStatement(sqlstr);
														rs = pstmt.executeQuery();

														if (rs != null) {
															while (rs.next()) {
																package_code = checkForNull(rs.getString("package_code"));
																package_seq_no = checkForNull(rs.getString("package_seq_no"));
																eff_from_date = checkForNull(rs.getString("eff_from_date"));
																System.err.println("eff_from_date->"+eff_from_date);
																eff_to_date = checkForNull(rs.getString("eff_to_date"));
																package_amt = checkForNull(rs.getString("package_amt"));
																deposit_amt = checkForNull(rs.getString("deposit_amt"));
																utilized_amt = checkForNull(rs.getString("utilized_amt"));
																blng_class_code = checkForNull(rs.getString("blng_class_code"));
																cust_group_code = checkForNull(rs.getString("cust_group_code"));
																cust_code = checkForNull(rs.getString("cust_code"));
																cust_price = checkForNull(rs.getString("cust_price"));
																encounter_name = checkForNull(rs.getString("encounter_id"));
																encounter_associate_yn = checkForNull(rs.getString("encounter_associate_yn"));
																across_encounter_yn = checkForNull(rs.getString("across_encounter_yn"));
																prac_name = checkForNull(rs.getString("prac_name"));
																physician_id = checkForNull(rs.getString("physician_id"));
																System.err.println("physician_id->"+physician_id);
																addl_chg_value = checkForNull(rs.getString("addl_chg_value"));
																operating_facility_id = checkForNull(rs.getString("operating_facility_id"));
																total_disc = checkForNull(rs.getString("total_discount"));

																episode_id = checkForNull(rs.getString("episode_id"));
																visit_id = checkForNull(rs.getString("visit_id"));
																episode_type = checkForNull(rs.getString("episode_type"));
																pkg_short_desc = checkForNull(rs.getString("package_short_desc"));
																order_catalog_yn = checkForNull(rs.getString("order_catalog_yn"));
																OP_YN = checkForNull(rs.getString("OP_YN"));
																pkg_adhoc_disc_amt = checkForNull(rs.getString("pkg_adhoc_disc_amt"));

																System.err.println(" order_catalog_yn " + order_catalog_yn);
																System.err.println("visit_id " + visit_id);
																System.err.println(" episode_type" + episode_type);
																System.err.println("long_desc " + long_desc);
																long_desc = pkg_short_desc;

																pkgDetailsCombinationString = package_code + "|" + package_seq_no + "|" + eff_from_date;
																pkgDetailsCombinationString12=package_code;
																pkgServiceDetailsCombination.add(pkgDetailsCombinationString);
																System.err.println("pkgServiceDetailsCombination !!!!!!!!!!!!!!!!!!!!!!!!!!!"
																		+ pkgServiceDetailsCombination);
																System.err.println("count-->"+count);
																count++;
																if(count==1){
																	pkg_short_des=checkForNull(rs.getString("package_short_desc"));
																	System.err.println("pkg_short_des-->"+pkg_short_des);
																}
																classval="fields";
																
																discount_string = checkForNull(rs.getString("discount_string"));
																System.err.println("discount_string:"+discount_string);
																
																/* String totalDiscQry = "select NVL(sum((case when discount_type = 'R' then (PACKAGE_AMT*(discount/100)) else discount end)),0) total_discount from bl_package_adhoc_discount a, bl_package_sub_hdr b where a.patient_id = '"+patientid1+"' and A.PACKAGE_SEQ_NO = '"+package_seq_no+"' and a.patient_id = b.patient_id and a.package_seq_no = b.package_seq_no";

																PreparedStatement pstmtTotalDiscQry = con.prepareStatement(totalDiscQry);
																ResultSet rsTotalDiscQry = pstmtTotalDiscQry.executeQuery();
																String totAdhocDiscAmt = "0";

																while (rsTotalDiscQry.next()) {
																	totAdhocDiscAmt = rsTotalDiscQry.getString(1);
																}
																
																rsTotalDiscQry.close();
																pstmtTotalDiscQry.close(); */
																
											
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);

												if (!package_code.equals("")) {
												
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pkg_short_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block23Bytes, _wl_block23);

													}
												
            _bw.write(_wl_block24Bytes, _wl_block24);

													if (!package_seq_no.equals("")) {
												
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block23Bytes, _wl_block23);

													}
												
            _bw.write(_wl_block24Bytes, _wl_block24);

													if (!blng_class_code.equals("")) {
												
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(blng_class_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(blng_class_code != null ? blng_class_code : ""));
            _bw.write(_wl_block34Bytes, _wl_block34);

													} else {
												
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(blng_class_code != null ? blng_class_code : ""));
            _bw.write(_wl_block37Bytes, _wl_block37);

													}
												
            _bw.write(_wl_block24Bytes, _wl_block24);

													if (!cust_group_code.equals("")) {
												
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block42Bytes, _wl_block42);

													if (!cust_code.equals("")) {
												
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block42Bytes, _wl_block42);

													if (!package_amt.equals("")) {
												
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(PkgAmtPriceFormat(package_amt)));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block42Bytes, _wl_block42);

													if (!total_disc.equals("")) {
												
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(discount_string));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(discount_string));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(count));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(PkgAmtPriceFormat(total_disc)));
            _bw.write(_wl_block56Bytes, _wl_block56);

													} else {
												
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block24Bytes, _wl_block24);

													if (!deposit_amt.equals("")) {
												
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(deposit_amt));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
														System.err.println("deposit_amt,604-"+deposit_amt);
												
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block42Bytes, _wl_block42);

													if (!addl_chg_value.equals("")) {
												
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(PkgAmtPriceFormat(addl_chg_value)));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													}
												
            _bw.write(_wl_block42Bytes, _wl_block42);

													if (!utilized_amt.equals("")) {
												
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(utilized_amt));
            _bw.write(_wl_block21Bytes, _wl_block21);

													} else {
												
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);

													
													}
												
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf("N".equals(calenderPrivileageYN) ? "readonly" : ""));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(count));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(eff_to_date));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prac_name));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(physician_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(encounter_name));
            _bw.write(_wl_block89Bytes, _wl_block89);

													if (encounter_associate_yn.equals("Y")) {
												
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(encounter_associate_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_associate_yn));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_associate_yn != null ? encounter_associate_yn : ""));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count));
            _bw.write(_wl_block99Bytes, _wl_block99);

												} else {
												
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(encounter_associate_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_associate_yn != null ? encounter_associate_yn : ""));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);

													}
												
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(count));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_amt));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(count));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(PkgAmtPriceFormat(pkg_adhoc_disc_amt)));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(count));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(count));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(count));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(count));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(count));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(count));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(count));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(count));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(count));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(pkg_short_des));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(order_catalog_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(count));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(encounter_associate_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(count));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(across_encounter_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(count));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(package_amt));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(count));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(count));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(deposit_amt));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(count));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(count));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(count));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(count));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(count));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(count));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(count));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(count));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(count));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(count));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(count));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(count));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(count));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pkg_short_desc));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(pkg_short_desc));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(count));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(count));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(pkgDetailsCombinationString12));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(count));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(count));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(count));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(count));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(count));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(count));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(count));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(OP_YN));
            _bw.write(_wl_block187Bytes, _wl_block187);

												}

														}

													} catch (Exception ex) {
														ex.printStackTrace();
														System.err.println("exception in pkg details:" + ex);
													} finally {
														if (rs != null)
															rs.close();
														if (pstmt != null)
															pstmt.close();
													}
											
									/*	if(count>0){
												//System.out.println("classval"+classval+" pkg_short_desc1="+pkg_short_desc1);
												out.println("<script>");
												out.println("highlightRow(1,'"+classval+"')");
												//out.println("showPackageServiceDetails1(1)");
												out.println("</script>");
											}	*/
									if(count==0)
										{
            _bw.write(_wl_block188Bytes, _wl_block188);
}
										if (count < 7) {
											int bal = 7 - count;
											for (int i = count+1; i < bal; i++) {
											//count++;
											
            _bw.write(_wl_block189Bytes, _wl_block189);

													if (calenderPrivileageYN.equals("N")) {
												
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);

													} else {
												
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block197Bytes, _wl_block197);

													}
												
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(i));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(i));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(encounter_associate_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(i));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(i));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(i));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block212Bytes, _wl_block212);

												}
													}
											
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(pkg_short_des));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(count));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(calenderPrivileageYN));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(modifyPractPrivYN));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(assDeassEncPrivYN));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(adhocDiscPrivYN));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(cancelPkgPrivYN));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(effDateAuthStr));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(adhocDiscAuthStr));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(cnclPackAuthStr));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(assDeassAuthStr));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(pkgServDtlsAuthStr));
            _bw.write(_wl_block232Bytes, _wl_block232);

	}
	catch(Exception e )
	{ 
		//out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block233Bytes, _wl_block233);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

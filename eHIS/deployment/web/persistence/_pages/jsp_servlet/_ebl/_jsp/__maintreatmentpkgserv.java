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

public final class __maintreatmentpkgserv extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MainTreatmentpkgserv.jsp", 1742877531223L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n----------------------------------------------------------------------------------------\n1            V210622                  \t      PMG2021-COMN-CRF-0076      PalaniNarayanan\n2\t     V210730           16777\t      PMG2021-COMN-CRF-0076      Mohana Priya\n3\t\t\t V211118\t\t   23078\t        PMG2021-COMN-CRF-0076.1      Manivel Natarajan\n4\t\t\t\t\t\t\t\t30618\t\t  PMG2021-COMN-CRF-0076.2    \t\t  Manivel N\n----------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<style>\n#table-wrapper {\n\tposition: relative;\n}\n\n#table-scroll {\n\theight: 200px;\n\twidth: 512px;\n\toverflow: scroll;\n}\n\ndiv.ex1 {\n\theight: 200px;\n\twidth: 1900px;\n\toverflow: scroll;\n}\n\ndiv.ex2 {\n\theight: 200px;\n\twidth: 1900px;\n\toverflow: scroll;\n}\n\n#table-wrapper table {\n\twidth: 100%;\n}\n\n#table-wrapper table {\n\tbackground: white;\n\tcolor: black;\n}\n\n#table-wrapper table thead tr {\n\tposition: relative;\n\ttop: expression(offsetParent.scrollTop);\n\tz-index: 2;\n\theight: 20px;\n\twidth: 35%;\n}\n\nTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\n</style>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'\n\ttype=\'text/css\' />\n<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<!-- \n<script language=\"javascript\" src=\'../js/PkgAdhocDiscount.js\'></script> \n -->\n\n\n\n<script type=\"text/javascript\">\n\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\t\nfunction lockKey()\n{\n\t \nif(event.keyCode == 93)\n\talert(\"Welcome to eHIS\");\n}\n\nfunction lockbackSpace()\n{\n\n var mode = document.mode.value;\n\n if(mode==\'modify\' && window.event.keyCode==8)\n  {\n   \n  }\n}\n\t \n\t\n\n\n\nfunction Noprevileage()\n{\n\talert(getMessage(\"BL0938\",\"BL\"));\n\t}\n\t\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>MTP</title>\n</head>\n\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"\n\tonScroll=\"processScroll()\" onSelect=\"codeArrestThruSelect();\" onload=\"disableForAuthorisation(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\">\n\t<form name=\'frmMaintainTreatserv\' id=\'frmMaintainTreatserv\' method=\'post\' onload=\"disableForAuthorisation(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =");\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<center>\n\t\t\t<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"pad4side\">\n\t\t\t\t\t<table width=\"100%\" border=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\" cellpadding=\"1\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"CAGROUPHEADING\">Package Service Details</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t </td>\n\t\t\t</tr> \n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t\t<div class=\"ex2\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n\t\t\t\t\t\t\t\t\tid=\"maintainTrtPkgDtls\" name=\"maintainTrtPkgDtls\" id=\"maintainTrtPkgDtls\" border=\"1\">\n\t\t\t\t\t\t\t\t<div id=\"tableContainer\">\n\t\t\t\t\t\t\t\t\t<thead style=\"position: sticky; top: 0px;\">\n\t\t\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Indicator</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Package\n\t\t\t\t\t\t\t\t\t\t\t\tServices</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Rate\n\t\t\t\t\t\t\t\t\t\t\t\tCharge</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Order\n\t\t\t\t\t\t\t\t\t\t\t\tCatalog Code</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Rate\n\t\t\t\t\t\t\t\t\t\t\t\tIndicator</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Factor\n\t\t\t\t\t\t\t\t\t\t\t\tRate</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Qty\n\t\t\t\t\t\t\t\t\t\t\t\tLimit</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Limit\n\t\t\t\t\t\t\t\t\t\t\t\tInd</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Amount\n\t\t\t\t\t\t\t\t\t\t\t\tLimit</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Group/Service\n\t\t\t\t\t\t\t\t\t\t\t\tlevel</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Home\n\t\t\t\t\t\t\t\t\t\t\t\tMedication Group</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Replaceable</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Replaceable\n\t\t\t\t\t\t\t\t\t\t\t\tService</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Replaceable\n\t\t\t\t\t\t\t\t\t\t\t\tCatalog</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Daily\n\t\t\t\t\t\t\t\t\t\t\t\tLimit Indicator</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Daily\n\t\t\t\t\t\t\t\t\t\t\t\tQty Limit</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Daily\n\t\t\t\t\t\t\t\t\t\t\t\tAmount Limit</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Refund</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Refund\n\t\t\t\t\t\t\t\t\t\t\t\tRate</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Auto\n\t\t\t\t\t\t\t\t\t\t\t\tRefund</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Closed</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Utilized\n\t\t\t\t\t\t\t\t\t\t\t\tQty</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Utilized\n\t\t\t\t\t\t\t\t\t\t\t\tAmount</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Appl\n\t\t\t\t\t\t\t\t\t\t\t\tFactor</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Split\n\t\t\t\t\t\t\t\t\t\t\t\tAllowed</td>\n\t\t\t\t\t\t\t\t\t   <!--   \t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>Service\n\t\t\t\t\t\t\t\t\t\t\t\tLimit</td>   -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align: center;\" nowrap>&nbsp;</td>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t\t\t\t\t<tr id=\'row1";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  onclick=\"showPackageServiceDesc(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =",\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width: 150px;\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"pkg_serv_ind";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\'pkg_serv_ind";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\tonChange=\'onCustServiceTypeChange(this,\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\");grpServiceVal(this,\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\",1);\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'C\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'M\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"pkg_serv_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"pkg_serv_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" type=\"text\"  size=\"20\" value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onblur=\'if(this.value!=\"\"){servlookup(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",this,pkg_serv";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");checkduplicate(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =");}\'> \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_serv";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'pkg_serv";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_pkg_serv_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  id=\"button_pkg_serv_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=\"?\" onClick=\'servlookup(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =",pkg_serv_code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =",pkg_serv";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =");\' >\n\t\t\t       \t\t\t\t\t\t\t\t </td>\n\t\t\t        \n\t\t\t\t\t\t\t\t\t\t\t      <td  class=\"fields\" \t  >\n\t\t\t\t\t\t\t\t     \t\t\t\t<input type=\"text\"  size=\'10\'  style=\"text-align:center;\"  name=\"rate_charge_ind";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  id=\"rate_charge_ind";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" readonly />\n\t\t\t\t\t\t\t\t    \t\t\t </td>\n\t\t\t\t\t\t\t\t\t\t\t      <td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t                     <input type=\"text\" size=\'20\' style=\"text-align:center;\"  name=\"order_catalog_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"   id=\"order_catalog_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" disabled />\n\t\t\t\t\t\t\t\t              \t </td>\n\t\t\t\t\t\t\t\t           \t\t <td class=\'fields\' nowrap >\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\'factor_rate_ind";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'   id=\'factor_rate_ind";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onChange=\'onIndChange(this,\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\")\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'R\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\'factor_rate_ind";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'  id=\'factor_rate_ind";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'X\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" ></option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t               <input type=\"text\" size=\'10\' style=\"text-align:center;\"  name=\"factor_rate";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  id=\"factor_rate";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="  onfocus=\"resetAlertFlag()\">\n\t\t\t\t\t\t\t\t\t\t             </td>\n\t\t\t\t\t\t\t\t\t\t             <td  class=\"fields\" \t>\n\t\t\t\t\t\t\t\t\t\t              \t   <input type=\"text\" size=\'10\'  style=\"text-align:center;\"  name=\"qty_limit";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"   id=\"qty_limit";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">\n\t\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t\t            <td  align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'amt_limit_ind";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'amt_limit_ind";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' onChange=\'grpServiceVal(this,\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\",2);validatefactorlmt(document.forms[0].rate_charge_ind";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =",this,";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =",3);\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\'  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'U\'  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t     <td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t                 \t<input type=\"text\" style=\"text-align:center;\"  name=\"amt_limit";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"  id=\"amt_limit";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t               <td  align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'GrpsSrvind";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'  id=\'GrpsSrvind";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' onChange=\'validateGrpservInd(this,\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\");\' disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"B\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'  ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t             \t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t              \n\t\t\t\t\t\t\t\t\t\t               <td  align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'GrpsSrvind";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\");\' disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"B\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t             \t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t               <td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"incl_home_medication_yn";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"incl_home_medication_yn";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" onClick=\'chkhomemed(";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =")\'/></td>\n\t\t\t\t\t\t\t\t\t\t           \n\t\t\t\t\t\t\t\t\t               <td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"replaceable_yn";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"  id=\"replaceable_yn";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" onClick=\'chkReplacable(this,";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =");enableReplc(this,";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =");\'/></td>\n\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t               <td  class=\"fields\" \tnowrap>   \n\t\t\t\t\t\t\t\t\t              <input name=\"replaceable_serv_code";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"replaceable_serv_code";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" type=\"text\"  size=\"20\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" onblur=\'if(this.value!=\"\"){repservlookup(";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =",this,rep_pkg_serv";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =")}\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" > \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rep_pkg_serv";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'  id=\'rep_pkg_serv";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_rep_pkg_serv_code";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"button_rep_pkg_serv_code";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" value=\"?\" onClick=\'repservlookup(";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =",replaceable_serv_code";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =",rep_pkg_serv";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =")\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =">\n\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t           \t  <td  class=\"fields\" nowrap>\n\t\t\t\t\t\t\t\t              \t <input name=\"rep_serv_ord_cat_code";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"  type=\"text\" id=\"rep_serv_ord_cat_code";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" size=\"20\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" onblur=\'if(this.value!=\"\"){repOrdCatLookup(";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =",this,rep_ord_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" > \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rep_ord_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'  id=\'rep_ord_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_serv_orcat_code";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"  id=\"button_serv_orcat_code";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" value=\"?\" onClick=\'repOrdCatLookup(";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =",rep_serv_ord_cat_code";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =",rep_ord_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" >\n\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t        \n\t\t\t\t\t\t\t           \t\t<td class=\'fields\'  nowrap >\n\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:150px;\" name=\'daily_limit_ind";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'  id=\'daily_limit_ind";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" onchange=\'dailyLmtIndicatorOnChange(this,";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =")\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t\t\t             <td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t              \t<input type=\"text\" style=\"text-align:center;\" name=\"daily_qty_limit";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"  id=\"daily_qty_limit";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" />\n\t\t\t\t\t\t\t\t\t              \n\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t              <td  class=\"fields\" \t  nowrap>\n\t\t\t\t\t\t\t\t\t            \t<input type=\"text\"  style=\"text-align:center;\" name=\"daily_amt_limit";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"  id=\"daily_amt_limit";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" />\n\t\t\t\t\t\t\t\t\t             \t<select style=\"width:100px;\" name=\'GrossNet";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'  id=\'GrossNet";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' onChange=\'validateGrossNetInd(this,\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\");\' ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'  ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t              \t<input type=\"text\" style=\"text-align:center;\" name=\"daily_qty_limit";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"  ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'GrossNet";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'  onChange=\'validateGrossNetInd(this,\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t             \t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"refund_yn";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"  id=\"refund_yn";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' onClick=\'refundchk(this,";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t   <td  class=\"fields\"  nowrap>\n              \t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\" name=\"refund_rate";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"  id=\"refund_rate";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" />\n\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t              \t\t\n\t\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t               <td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"auto_refund_yn";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' checked   onClick=\'autorefundchk(";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =")\' /></td>\n\t\t\t\t\t\t\t\t\t             ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t\t            \t<td class=\"fields\" \tnowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' onClick=\'autorefundchk(";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =")\' />\n\t\t\t\t\t\t\t\t\t             &nbsp;\n\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t              ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t             ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t\t               <td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"close_package_yn";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"  id=\"close_package_yn";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' checked disabled /></td>\n\t\t\t\t\t\t\t\t\t             ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t\t\t            \t<td class=\"fields\" \t nowrap><input type=\"checkbox\" name=\"close_package_yn";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' disabled />\n\t\t\t\t\t\t\t\t\t             &nbsp;\n\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t              ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n              \t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n          \t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_qty";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"  id=\"utilized_serv_qty";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" disabled/>\n             \t\t\t\t\t\t\t\t\t </td>\n            \t\t\t\t\t\t\t\t\t <td  class=\"fields\" \t nowrap>\n            \t\t\t\t\t\t\t\t\t\t <input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_amt";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"  id=\"utilized_serv_amt";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" disabled/>\n             \t\t\t\t\t\t\t\t\t </td>\n             \t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\t\t               <td class=\'fields\' nowrap><input type=\"checkbox\" name=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"  id=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" onClick=\'applfactchk(";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =")\' disabled nowrap/></td>\n\t\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t             ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t\t\t\t            \t<td class=\"fields\" \tnowrap><input type=\"checkbox\" name=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =")\'  disabled nowrap/>\n\t\t\t\t\t\t\t\t\t\t             &nbsp;\n\t\t\t\t\t\t\t\t\t\t              </td>\n\t\t\t\t\t\t\t\t\t\t              ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n                \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t\t\t           \t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"  id=\"split_allowed_yn";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" onClick=\'splitchk(";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =")\' checked /></td>\n\t\t\t\t\t\t\t\t\t             ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t            \t<td class=\"fields\" \t nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"radio";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" id=\"radio";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"  onClick=\"selRow(";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =",this)\"  />\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" \tid=\"hdn_is_newly_added_row_YN_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" \t\t\tname=\"hdn_is_newly_added_row_YN_";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" \tid=\"hdn_row_marked_for_del_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" \t\t\tname=\"hdn_row_marked_for_del_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<a  href=\"#\" onclick=\"openDetails(";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\');\">Dtls</a>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"is_excl_mod_YN_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" name=\"is_excl_mod_YN_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"excl_string_";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" name=\"excl_string_";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" value=\'\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t              \n              \n              \t\t\t\t\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" \t\t\tname=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"   value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" \t\t\tname=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" \t\t\tname=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" \t\t\tname=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_factor_rate_ind";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" \t\t\tname=\"hdn_factor_rate_ind";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_factor_rate";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" \t\t\tname=\"hdn_factor_rate";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_qty_limit";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" \t\t\tname=\"hdn_qty_limit";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" \t\t\tname=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_amt_limit";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" \t\t\tname=\"hdn_amt_limit";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" \t\t\tname=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" \t\t\tname=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'/>\n                   \t\t\t<input type=\"hidden\" \tid=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" \t\t\tname=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_group_service_ind";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" \t\t\tname=\"hdn_group_service_ind";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_rep_serv_ord_cat_code";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" \t\t\tname=\"hdn_rep_serv_ord_cat_code";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'/>\n               \t\t\t\t<input type=\"hidden\" \tid=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" \t\t\tname=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'/>\n               \t\t\t\t<input type=\"hidden\" \tid=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" \t\t\tname=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" \t\t\tname=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'/>\n              \t          \t<input type=\"hidden\" \tid=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" \t\t\tname=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'/>\n              \t            <input type=\"hidden\" \tid=\"hdn_refund_yn";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" \t\t\tname=\"hdn_refund_yn";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_refund_rate";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" \t\t\tname=\"hdn_refund_rate";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" \t\t\tname=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_close_package_yn";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" \t\t\tname=\"hdn_close_package_yn";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" \t\t\tname=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" \t\t\tname=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" \t\t\tname=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'/>\n              \t\t\t\t\n               \t\t\t\t<input type=\"hidden\" \tid=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" \t\t\tname=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'/>\n               \t\t\t\t\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_rowid";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" \t\t\tname=\"hdn_rowid";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_package_code";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" \t\t\tname=\"hdn_package_code";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\'/>\n              \t\t\t\t<input type=\"hidden\" \tid=\"hdn_package_seq_no";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" \t\t\tname=\"hdn_package_seq_no";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\'/>\n               \t\t\t\t<input type=\"hidden\" \tid=\"pkg_service_long_desc";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" \t\t\tname=\"pkg_service_long_desc";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'/>              \t\t\t\t\n    \t\t\t\t </tr>\n\t\t             ";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t      <input type=\"hidden\" \tid=\"hdn_pack_code\" \t\t\tname=\"hdn_pack_code\" id=\"hdn_pack_code\" value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\'/>\n              <input type=\"hidden\" \tid=\"hdn_pack_seq_no\" \t\t\tname=\"hdn_pack_seq_no\" id=\"hdn_pack_seq_no\" value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'/>\n\t\t\t  <input type=\"hidden\" \tid=\"visit_id\" \t\t\tname=\"visit_id\" id=\"visit_id\" value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\'/>\n              <input type=\"hidden\" \tid=\"episode_id\" \t\t\tname=\"episode_id\" id=\"episode_id\" value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'/>\n\t\t\t  <input type=\"hidden\" \tid=\"episode_type\" \t\t\tname=\"episode_type\" id=\"episode_type\" value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'/>\n\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t\t<!-- \n\t\t         <tr>\n\t\t\t       <td  class=\'fields\' nowrap><select name=\"service11\" id=\"service11\" id=\"service11\">\n\t\t\t         <option>Service</option>\n\t\t\t         <option>Drug</option>\n\t\t\t         </select></td>\n\t\t\t       <td  class=\'fields\' nowrap><input name=\"textfield12\" id=\"textfield12\" type=\"text\" id=\"textfield12\" size=\"20\" />\n\t\t\t         <input name=\"button\" id=\"button\" type=\"button\" id=\"button\"  value=\"?\" /></td>\n\t\t\t       <td   class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap><select name=\"service2\" id=\"service2\" id=\"service2\">\n\t\t\t         <option selected=\"selected\">Standard</option>\n\t\t\t         </select></td>\n\t\t\t       <td  class=\'fields\' nowrap>1</td>\n\t\t\t       <td  class=\'fields\' nowrap>1</td>\n\t\t\t       <td  class=\'fields\' nowrap><select name=\"service21\" id=\"service21\" id=\"service21\">\n\t\t\t         </select></td>\n\t\t\t       <td  class=\'fields\' nowrap><input name=\"textfield21\" id=\"textfield21\" type=\"text\" id=\"textfield21\" size=\"15\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox2\" id=\"checkbox2\" id=\"checkbox2\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox3\" id=\"checkbox3\" id=\"checkbox3\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap><select name=\"service31\" id=\"service31\" id=\"service31\">\n\t\t\t         </select></td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap><input name=\"textfield32\" id=\"textfield32\" type=\"text\" id=\"textfield32\" size=\"15\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox4\" id=\"checkbox4\" id=\"checkbox4\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox5\" id=\"checkbox5\" id=\"checkbox5\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox6\" id=\"checkbox6\" id=\"checkbox6\" /></td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap>&nbsp;</td>\n\t\t\t       <td  class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox7\" id=\"checkbox7\" id=\"checkbox7\" /></td>\n\t\t\t       <td   class=\'fields\' nowrap><input type=\"checkbox\" name=\"checkbox8\" id=\"checkbox8\" id=\"checkbox8\" /></td>\n\t\t\t       <td   class=\'fields\' nowrap><a href=\"#\">Dtls</a></td>\n\t\t\t       <td   class=\'fields\' nowrap><input type=\"radio\" name=\"radio\" id=\"radio\" id=\"radio\" value=\"radio\" /></td>\n\t\t          </tr>\n\t\t          \n\t\t          -->\n\t\t           ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\n\t\t </tbody>\n\t\t</div>\n\t\t           \t\n\t\t        \t\n\t\t           \t <input type=\'hidden\' name=\'index\' id=\'index\'  value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\' >\n\t\t           \t\n\t        </table>\n\t\t\t</div>\n\t\t\t</div>\t\n\t\t</td>\n\t</tr>\n        \n     <tr>\n        <td>\n     \t   <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n        \t<tr>\n\t            <td width=\"15%\" >Package Service Details</td>\n\t            <td  ><span class=\"txtgray\">\n\t              <input type=\"text\" name=\"pkg_service_long_desc\"  id=\"pkg_service_long_desc\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" size=\"50\" readonly />\n\t              <input type=\"button\" name=\"Replace_Service\"  id=\"Replace_Service\" value=\"Replace Service\" disabled />\n\t            </span>\n\t\t\t\t <input type=\"button\" name=\"Add\" id=\"Add\"  value=\"Add\" onClick=\"addRow(";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="); \" />\n\t\t       \t <!-- <input type=\"button\" name=\"Delete\" id=\"Delete\" id=\"Delete\" value=\"Delete\" onClick=\"deleteRow();\" /> -->\n\t\t\t\t <input type=\"button\" name=\"Modify\" id=\"Modify\"  value=\"Modify\" onClick=\"ModifyRecords(\'pkgServDtls\');\" ";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 =" />\n\t\t\t\t</td>\n\n\t\t\t\t <td colspan=\"6\" >&nbsp;</td>\n\t\t\t   \n         \t </tr>\n          </table>\n         </td>\n       </tr>\n          <input type=\'hidden\' name=\'patientid1\' id=\'patientid1\'  value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'>\n          <input type=\'hidden\' name=\'blng_class_code\'  id=\'blng_class_code\' value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\'>\n       <!--   <input type=\"hidden\" name=\"pkg_service_long_desc\" id=\"pkg_service_long_desc\" id=\"pkg_service_long_desc\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" > -->  \n          <input type=\'hidden\' name=\'cust_group_code\'  id=\'cust_group_code\' value=\'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'>\n          <input type=\'hidden\' name=\'cust_code\' id=\'cust_code\'  value=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'> \n          <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'> \n          <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'>\n          <input type=\'hidden\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'>\n          <input type=\'hidden\' name=\'ws_no\' id=\'ws_no\'  value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\n          <input type=\'hidden\' name=\'dbcnt\' id=\'dbcnt\'  value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\'>\n\t\t  <input type=\'hidden\' name=\'cnt\' id=\'cnt\'  value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'>\n          <input type=\'hidden\' name=\'privlege_code\'  id=\'privlege_code\' value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\'>\n          <input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" >\n          <input type=\'hidden\' name=\'rowcount\' id=\'rowcount\'   value=\'\' >\n          <input type=\'hidden\' name=\'defaultPkgCode\' id=\'defaultPkgCode\'  value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n          <input type=\'hidden\' name=\'orderCatlogyn\' id=\'orderCatlogyn\'  value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\'>   \n          <input type=\'hidden\' name=\'pkgServIndLmtYN\' id=\'pkgServIndLmtYN\'  value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'> \n          <input type=\'hidden\' name=\'defaultPkgSeq\' id=\'defaultPkgSeq\'  value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'>\n          <input type=\'hidden\' name=\'defaultEffFromDate\' id=\'defaultEffFromDate\'  value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'>\n\t\t  \n          \n\t\t<input type=\'hidden\' name=\'PKG_LIMIT_IND_BY\' id=\'PKG_LIMIT_IND_BY\'  value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'>\n\n\t\t<input type=\'hidden\' name=\'indicatorFldDisabled\' id=\'indicatorFldDisabled\'  value=\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'> \n\t\t<input type=\'hidden\' name=\'amtFldDisabled\' id=\'amtFldDisabled\'  value=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'>\n\t\t<input type=\'hidden\' name=\'qtyFldDisabled\' id=\'qtyFldDisabled\'  value=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'>\n\t\t<input type=\'hidden\' name=\'grossNetDisabled\' id=\'grossNetDisabled\'  value=\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\'>\n\t\t<input type=\'hidden\' name=\'selectedItemIndex\' id=\'selectedItemIndex\'  value=\'";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\'>\n\n\t\t<input type=\'hidden\' name=\'pkg_serv_lmt_YN\' id=\'pkg_serv_lmt_YN\'  value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\'>\n\t\t<input type=\'hidden\' name=\'daily_pkg_lmt_yn\' id=\'daily_pkg_lmt_yn\'  value=\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\'>\n\t\t<input type=\'hidden\' name=\'p_daily_pkg_serv_lmt\' id=\'p_daily_pkg_serv_lmt\'  value=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\'>\n\t\t<input type=\'hidden\' name=\'p_daily_pkg_serv_lmt_ind\' id=\'p_daily_pkg_serv_lmt_ind\'  value=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'>\n\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\'  value=\'";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\'>\t\n\n\t\t<input type=\'hidden\' name=\'pkgServDtlsAuthStr\'  id=\'pkgServDtlsAuthStr\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'>\t\t  \n\t\t<input type=\'hidden\' name=\'pkgServLmtDtlsPrivYN\'  id=\'pkgServLmtDtlsPrivYN\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'> \n\n      </table>\t\t\t\t\t\n</center>                       \n</form>                         \n</body>                         \n</html>\n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =" \n\t\n\n";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );
	
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

private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}
public String PkgAmtPriceFormat(String str) {
			if (str == null || str.equals("")) {
				str = "0.00";
			} else {
				str = String.format("%.2f", Float.parseFloat(str));
			}
			return str;
		}
public String PkgqtyFormat(String str) {
			if (str == null || str.equals("")) {
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
            _bw.write(_wl_block2Bytes, _wl_block2);

System.err.println("serv jsp--");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String patientid1 = "";
patientid1 = request.getParameter("patinetId_new");
System.err.println("200--servv "+patientid1);
String pkg_short_desc = "";
String classval="fields";
String pkg_service_long_desc = "";
String pkg_service_long_des = "";
String pkgServLmtDtlsPrivYN = "N";//V211118
pkgServLmtDtlsPrivYN = request.getParameter("pkgServLmtDtlsPrivYN");
if(pkgServLmtDtlsPrivYN == null) pkgServLmtDtlsPrivYN = "N";
System.err.println("pkgServLmtDtlsPrivYN in dtls:"+pkgServLmtDtlsPrivYN);

String pkgServDtlsAuthStr = request.getParameter("pkgServDtlsAuthStr");
if(pkgServDtlsAuthStr == null) pkgServDtlsAuthStr = "";
System.err.println("pkgServDtlsAuthStr in dtls:"+pkgServDtlsAuthStr);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block11Bytes, _wl_block11);

			String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
					qtyFldDisabled = "", indicatorFldDisabled = "", grossNetDisabled="";
			//String disable="";
			//String disabled="";
			String modifyStatus = "";

			String facility_id = "";
			String userid = "";
			String function_id = "";
			String privlege_code = "";
			String ws_no = "";
			//String patientid1 = "";
			java.util.Properties p = null;
			//facility_id = (String) session.getValue("facility_id");
			userid = (String) session.getValue("login_user");

			function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			privlege_code = "MODIFY_PKG_SERV_LMT_DTLS_MTPKG";
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");
		//	String called = checkForNull(request.getParameter("calledfrom"));
		//	System.err.println("called--"+called);
			String params = request.getQueryString();
			int index = 0;
			
			// V211118
			int selectedItemIndex = 0;
			selectedItemIndex = Integer.parseInt(request.getParameter("selectedItemIndex"));
			System.err.println("selectedItemIndex:"+selectedItemIndex);



			// V211118 Ends

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;
			PreparedStatement pstmt3 = null;
			ResultSet rst3 = null;
			PreparedStatement pstmt4 = null;
			ResultSet rst4 = null;

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
			String prac_name = "";
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
			String incl_home_medication_yn1 = "";
			String home_med_enable_yn="";
			String home_med_enbl_disbl="";
			String replaceable_yn = "";
			String replaceable_yn1 = "";
			String daily_limit_ind = "";
		//	int daily_qty_limit_int = 0;
			int daily_qty_limit_int;
		//	int daily_amt_limit_int = 0;
			int daily_amt_limit_int;//
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
			String utilized_serv_qty_intg="";
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
			//String utilized_serv_qty="";
			//String utilized_serv_amt="";
			int utilized_serv_amt_int = 0;
			//int utilized_serv_amt_int =0;
			String rowid = "";
		//	String classval="";
		//	String pkg_service_long_desc = "";
			String tableid = "maintainTrtPkgDtls";
			String defaultPkgCode = "";
			String order_catalog_yn ="N";
			String across_enc_YN="";
			String defaultPkgSeq = "";
			String defaultEffFromDate = "";
			String refundchck="";
			String refndYNdisable="";
			ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();
			String pkgDetailsCombinationString =request.getParameter("pkgDetailsCombinationString") == null ? "" :request.getParameter("pkgDetailsCombinationString");
			System.err.println("pkgDetailsCombinationString->"+pkgDetailsCombinationString);
			int count = 0;
			int cnt = 0;
			int noofdecimal = 2;
			boolean pkg_serv_ind_lmt=false;
			String pkg_serv_ind_lmt_YN = "N";
			String PKG_LIMIT_IND_BY="";
			String pkg_serv_lmt_YN="N";
			boolean pkg_serv_lmt=false;
			String daily_pkg_lmt_yn="N";
			String p_daily_pkg_serv_lmt="N";
			String p_daily_pkg_serv_lmt_ind="N";
			try {
				con = ConnectionManager.getConnection(request);
				HttpSession httpSession = request.getSession(false);
				
				try{
					pkg_serv_ind_lmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_PKG_SERV_IND_LIMIT");
					System.err.println("pkg_serv_ind_lmt-->"+pkg_serv_ind_lmt);
					if (pkg_serv_ind_lmt)
						pkg_serv_ind_lmt_YN = "Y";
					else
						pkg_serv_ind_lmt_YN = "N";
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				try{
					pkg_serv_lmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_DAILY_PKG_SERV_LIMIT");
					System.err.println("pkg_serv_lmt-->"+pkg_serv_lmt);
					if (pkg_serv_lmt)
						pkg_serv_lmt_YN = "Y";
					else
						pkg_serv_lmt_YN = "N";
					
					System.err.println("pkg_serv_lmt_YN-->"+pkg_serv_lmt_YN);
				}catch(Exception e){
					e.printStackTrace();
				}	
				
				try{				
					pstmt = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");

					rs = pstmt.executeQuery();
					if (rs.next() && rs != null)
						noofdecimal = rs.getInt(1);				
				} catch (Exception e) {
					System.err.println("Exception Getting Number of Decimals. " + e.toString());
					noofdecimal = 2;
					e.printStackTrace();
				} finally {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}			
			
				//String facility_id = (String)httpSession.getValue("facility_id");
		
            _bw.write(_wl_block12Bytes, _wl_block12);

											try {

														String patinetId_new = checkForNull(request.getParameter("patinetId_new"));

														String operating_facility_id_new = checkForNull(request.getParameter("operating_facility_id_new"));
														operating_facility_id_new=operating_facility_id_new.replaceAll("\\s", "");
														facility_id=operating_facility_id_new;
														System.err.println("facility_id===>>"+facility_id+"val");
														String package_code_new = checkForNull(request.getParameter("package_code_new"));
														String package_seq_no_new = checkForNull(request.getParameter("package_seq_no_new"));
														String calledfrom = checkForNull(request.getParameter("calledfrom"));
														if(calledfrom == null) calledfrom = "";
														order_catalog_yn = checkForNull(request.getParameter("order_catalog_yn"));
														across_enc_YN = checkForNull(request.getParameter("across_enc_yn"));
														
														visit_id = checkForNull(request.getParameter("visit_id"));
														episode_id = checkForNull(request.getParameter("episode_id"));
														episode_type = checkForNull(request.getParameter("episode_type"));


														//String pkg = (String) pkgServiceDetailsCombination.get(0);
														String pkg = pkgDetailsCombinationString;
														StringTokenizer stEncList = new StringTokenizer(pkg, "|");
														//System.err.println("stEncList===>>"+stEncList);
															
															System.err.println("enc_assoc_YN===>>"+across_enc_YN);

														defaultPkgCode = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
														defaultPkgSeq = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
													//	defaultEffFromDate = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
													defaultEffFromDate =checkForNull(request.getParameter("eff_from_date"));
													
														System.err.println("defaultEffFromDate===>>"+defaultEffFromDate);
														
														try {
															pstmt3 = con.prepareStatement("select PKG_LIMIT_IND_BY from bl_parameters where operating_facility_id = ?"); //--:PARAMETER.P_PKG_LIMIT_IND_BY-- value is B - both, G - group, S - service
															System.err.println("facility_id===>>"+facility_id);
															pstmt3.setString(1,facility_id); 
															rst3 = pstmt3.executeQuery() ;
														}
														catch(Exception ex){
															ex.printStackTrace();
														}
														if( rst3 != null ) 
														{	
															while( rst3.next() )
															{  
																PKG_LIMIT_IND_BY = rst3.getString("PKG_LIMIT_IND_BY");
															//	str_charge_logic = rsst.getString(2);
															//	payerGrpBySetup  = rsst.getString(3);
															
																System.err.println("PKG_LIMIT_IND_BY===>>"+PKG_LIMIT_IND_BY);
															}
														}
														System.err.println("pkg_serv_lmt_YN,536===>>"+pkg_serv_lmt_YN);
														if(pkg_serv_lmt_YN.equals("Y")){
															try {
																/*	pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N'),pkg_serv_lmt_by,daily_pkg_lmt_by INTO p_daily_limit_chk_yn,p_daily_pkg_serv_lmt_ind,p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
																*/
																	pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N') p_daily_limit_chk_yn,pkg_serv_lmt_by p_daily_pkg_serv_lmt_ind,NVL(daily_pkg_lmt_by,'') p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
																
																	System.err.println("facility_id,395==>>"+facility_id);
																	pstmt4.setString(1,facility_id); 
																	rst4 = pstmt4.executeQuery() ;
															}catch(Exception exe){
																	exe.printStackTrace();
																}
															if( rst4 != null ) 
																{	
																while( rst4.next() )
																{  
																daily_pkg_lmt_yn = rst4.getString("p_daily_limit_chk_yn");
																p_daily_pkg_serv_lmt = rst4.getString("p_daily_pkg_serv_lmt");
																p_daily_pkg_serv_lmt_ind  = rst4.getString("p_daily_pkg_serv_lmt_ind");

																if(daily_pkg_lmt_yn.equals("")){
																	daily_pkg_lmt_yn="N";
																}
																if("".equals(p_daily_pkg_serv_lmt)){
																	p_daily_pkg_serv_lmt="B";
																}
																if("".equals(p_daily_pkg_serv_lmt_ind)){
																	p_daily_pkg_serv_lmt_ind="R";
																}
																System.err.println("daily_pkg_lmt_yn===>>"+daily_pkg_lmt_yn);
																System.err.println("p_daily_pkg_serv_lmt===>>"+p_daily_pkg_serv_lmt);
																System.err.println("p_daily_pkg_serv_lmt_ind===>>"+p_daily_pkg_serv_lmt_ind);
																}
															}
														}
														else{
															indicatorFldDisabled="disabled";
															amtFldDisabled = "disabled";
															qtyFldDisabled = "disabled"; 
															grossNetDisabled="disabled";
														} //V210901
														
														System.err.println("daily_pkg_lmt_yn,577===>>"+daily_pkg_lmt_yn);
														System.err.println("order_catalog_yn,577===>>"+order_catalog_yn);
													//	System.err.println("enc_assoc_YN,577===>>"+enc_assoc_YN);
														if(daily_pkg_lmt_yn.equals("Y") && order_catalog_yn.equals("N") && across_enc_YN.equals("N")){
															if(!p_daily_pkg_serv_lmt.equals("")){
																if(p_daily_pkg_serv_lmt_ind.equals("Q")){
																	indicatorFldDisabled="";
																	amtFldDisabled = "disabled";
																	qtyFldDisabled = ""; 
																	grossNetDisabled="";
																}else if(p_daily_pkg_serv_lmt_ind.equals("A")){
																	indicatorFldDisabled="";
																	amtFldDisabled = "";
																	qtyFldDisabled = "disabled"; 
																	grossNetDisabled="";
																}else if(p_daily_pkg_serv_lmt_ind.equals("B")){
																	indicatorFldDisabled="";
																	amtFldDisabled = "";
																	qtyFldDisabled = ""; 
																	grossNetDisabled="";
																}else{
																	indicatorFldDisabled="disabled";
																	amtFldDisabled = "disabled";
																	qtyFldDisabled = "disabled"; 
																	grossNetDisabled="disabled";
																}
															}else{
																indicatorFldDisabled="disabled";
																amtFldDisabled = "disabled";
																qtyFldDisabled = "disabled"; 
																grossNetDisabled="disabled";
															}
														}else{
															indicatorFldDisabled="disabled";
															amtFldDisabled = "disabled";
															qtyFldDisabled = "disabled"; 
															grossNetDisabled="disabled";
														}
														
														String sqlstr1 = "";
														if (!calledfrom.equals("UPDATE")) {
															System.err.println("952===>>");
															sqlstr1 = "select  pkg_serv_ind pack_serv,pkg_serv_code,rate_charge_ind,null order_catalog_code,rate_ind factor_rate_ind,factor_rate,qty_limit,amt_limit_ind,"
																	+ "amt_limit,group_service_ind,incl_home_medication_yn,replaceable_yn,daily_limit_ind,daily_qty_limit,daily_amt_limit,daily_amt_limit_gross_net,"
																	+ "replaceable_serv_code,rep_serv_ord_cat_code,refund_yn,refund_rate,apply_fact_for_srv_lmt_yn,close_package_yn,utilized_serv_qty,"
																	+ "utilized_serv_amt,auto_refund_yn,split_allowed_yn,rowid,blpackage.get_description(pkg_serv_ind,pkg_serv_code,'"
																	+ locale + "') pkg_service_long_desc from bl_package_sub_dtls" + " where patient_id = '"
																	+ patientid1 + "' and " + "operating_facility_id = '" + operating_facility_id + "' and "
																	+ "package_code = '" + defaultPkgCode + "' and package_seq_no = '" + defaultPkgSeq
																	+ "'";
														} else {
															System.err.println("453===>>");
															sqlstr1 = "select pkg_serv_ind pack_serv,pkg_serv_code,rate_charge_ind,null order_catalog_code,rate_ind factor_rate_ind,factor_rate,qty_limit,amt_limit_ind,"
																	+ "amt_limit,group_service_ind,incl_home_medication_yn,replaceable_yn,daily_limit_ind,daily_qty_limit,daily_amt_limit,daily_amt_limit_gross_net,"
																	+ "replaceable_serv_code,rep_serv_ord_cat_code,refund_yn,refund_rate,apply_fact_for_srv_lmt_yn,close_package_yn,round(utilized_serv_qty,2) utilized_serv_qty,"
																	+ "utilized_serv_amt,auto_refund_yn,split_allowed_yn,rowid,blpackage.get_description(pkg_serv_ind,pkg_serv_code,'"
																	+ locale + "') pkg_service_long_desc,blcommonproc.bl_pharm_service_yn ('en',pkg_serv_ind,pkg_serv_code) home_medication_enable_yn from bl_package_sub_dtls" + " where patient_id = '"
																	+ patinetId_new + "' and " + "operating_facility_id = '"+ operating_facility_id_new
																	+"' and " + "package_code = '" + package_code_new + "' and package_seq_no = '"
																	+ package_seq_no_new + "'";

															defaultPkgCode = package_code_new;
															defaultPkgSeq = package_seq_no_new;

															System.err.println("defaultPkgCode after update==========>>" + defaultPkgCode);
															System.err.println("defaultPkgSeq after update ==========>>" + defaultPkgSeq);
														}
														System.err.println("sqlstr1 ==========>>"+sqlstr1 );
														pstmt1 = con.prepareStatement(sqlstr1);
														rs1 = pstmt1.executeQuery();
														if (rs1 != null) {
															while (rs1.next()) {
																index = rs1.getRow();

																pkg_serv_ind = checkForNull(rs1.getString("pack_serv"));
																System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
																pkg_serv_code = checkForNull(rs1.getString("pkg_serv_code"));
																System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);
																rate_charge_ind = checkForNull(rs1.getString("rate_charge_ind"));
																System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
																order_catalog_code = checkForNull(rs1.getString("order_catalog_code"));
																System.err.println("order_catalog_code====>>488 " + order_catalog_code);
																factor_rate_ind = checkForNull(rs1.getString("factor_rate_ind"));
																System.err.println("factor_rate_ind====>>488 " + factor_rate_ind);
																amt_limit_ind = checkForNull(rs1.getString("amt_limit_ind"));
																System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
																
																group_service_ind = checkForNull(rs1.getString("group_service_ind"));
																if(group_service_ind.equals("")){
																	group_service_ind="B";
																}
																System.err.println("group_service_ind====>>488 " + group_service_ind);
																incl_home_medication_yn1 = checkForNull(rs1.getString("incl_home_medication_yn"));
																home_med_enable_yn = checkForNull(rs1.getString("home_medication_enable_yn"));
																replaceable_yn = checkForNull(rs1.getString("replaceable_yn"));
																daily_limit_ind = checkForNull(rs1.getString("daily_limit_ind"));
																System.err.println("replaceable_yn ====>> " + replaceable_yn);
																if(("Y").equals(home_med_enable_yn)){
																	home_med_enbl_disbl="";
																	if(("Y").equals(incl_home_medication_yn1)){
																			incl_home_medication_yn="checked readonly";
																	}
																	else{
																		incl_home_medication_yn="unchecked";
																	}
																	
																		//replaceable_yn="checked";
																	}
																	else{	
																		home_med_enbl_disbl="disabled";
																		//replaceable_yn="unchecked";
																	}
																	
														/*			if(("Y").equals(incl_home_medication_yn1)){
																			incl_home_medication_yn="checked readonly";
																	}
																	else{
																		incl_home_medication_yn="unchecked";
																	}
																*/	
																	System.err.println("incl_home_medication_yn1-->"+incl_home_medication_yn1);
																	if(("Y").equals(replaceable_yn)){
																		replaceable_yn="checked";
																	}
																	else{	
																		replaceable_yn="unchecked";
																	}
																System.err.println("replaceable_yn====>> " + replaceable_yn);
																
																System.err.println("daily_limit_ind====>>" + daily_limit_ind);
																
																daily_amt_limit_gross_net = checkForNull(rs1.getString("daily_amt_limit_gross_net"));
																System.err.println("daily_amt_limit_gross_net====>>" + daily_amt_limit_gross_net);
																replaceable_serv_code = checkForNull(rs1.getString("replaceable_serv_code"));
																System.err.println("replaceable_serv_code====>>" + replaceable_serv_code);
																rep_serv_ord_cat_code = checkForNull(rs1.getString("rep_serv_ord_cat_code"));
																System.err.println("rep_serv_ord_cat_code====>>" + rep_serv_ord_cat_code);
																refund_yn = checkForNull(rs1.getString("refund_yn"));
																System.err.println("refund_yn====>>" + refund_yn);
																
																apply_fact_for_srv_lmt_yn = checkForNull(rs1.getString("apply_fact_for_srv_lmt_yn"));
																System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
																close_package_yn = checkForNull(rs1.getString("close_package_yn"));
																auto_refund_yn = checkForNull(rs1.getString("auto_refund_yn"));
																split_allowed_yn = checkForNull(rs1.getString("split_allowed_yn"));
																
																daily_qty_limit = checkForNull(rs1.getString("daily_qty_limit"));
																qty_limit = checkForNull(rs1.getString("qty_limit"));
																amt_limit = checkForNull(rs1.getString("amt_limit"));
																daily_amt_limit = checkForNull(rs1.getString("daily_amt_limit"));
																refund_rate = checkForNull(rs1.getString("refund_rate"));
																factor_rate = checkForNull(rs1.getString("factor_rate"));
																System.err.println("refund_rate=="+refund_rate);
															/*	factor_rate_int = rs1.getInt("factor_rate");
																factor_rate = checkForNull(Integer.toString(factor_rate_int));
																
																	
																qty_limit_int = rs1.getInt("qty_limit");
																qty_limit = checkForNull(Integer.toString(qty_limit_int));
																amt_limit_int = rs1.getInt("amt_limit");
																amt_limit = checkForNull(Integer.toString(amt_limit_int));

																daily_qty_limit_int = rs1.getInt("daily_qty_limit");
																System.err.println("daily_qty_limit_int====>>" + daily_qty_limit_int);
																daily_qty_limit = checkForNull(Integer.toString(daily_qty_limit_int));
																daily_amt_limit_int = rs1.getInt("daily_amt_limit");
																daily_amt_limit = checkForNull(Integer.toString(daily_amt_limit_int));
																
																
																refund_rate_int = rs1.getInt("refund_rate");
																System.err.println("refund_rate_int,872====>>" + refund_rate_int);
																refund_rate = checkForNull(Integer.toString(refund_rate_int));
																System.err.println("refund_rate====>>873" + refund_rate_int);
																*/
													
																utilized_serv_qty_intg = checkForNull(rs1.getString("utilized_serv_qty"));
																utilized_serv_amt = checkForNull(rs1.getString("utilized_serv_amt"));	
																System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
															
																rowid = checkForNull(rs1.getString("rowid"));
																pkg_service_long_desc = checkForNull(rs1.getString("pkg_service_long_desc"));

																System.err
																		.println("order_catalog_code :: ======================>855>" + order_catalog_code);
																System.err.println("daily_limit_ind :: " + daily_limit_ind);

																System.err.println("amt_limit_ind :: " + amt_limit_ind);
																System.err.println("daily_amt_limit_gross_net :: " + daily_amt_limit_gross_net);
																System.err.println("daily_limit_ind :: " + daily_limit_ind);
																System.err.println("amt_limit :: " + amt_limit);
																System.err.println("daily_qty_limit :: " + daily_qty_limit);
																System.err.println("daily_amt_limit :: " + daily_amt_limit);
																System.err.println("pkg_service_long_desc :: "+pkg_service_long_desc);
																System.err.println(
																		"rowid ::=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "
																				+ rowid);
																System.err.println("classval :: "+classval+" index="+index);
																System.err.println("pkg_service_long_des-->"+pkg_service_long_desc);
																String disable="";
																String disabled="";
																
																if(replaceable_yn.equals("unchecked")) {
																	disable="disabled";
																	replaceable_yn1="N";
																}else if(replaceable_yn.equals("checked") && rep_serv_ord_cat_code.equals("")){
																	replaceable_yn1="Y";
																	disabled="disabled";
																}else{
																	replaceable_yn1="Y";
																	disable="";
																	disabled="";
																}
																System.err.println("replaceable_yn1-"+replaceable_yn1);
																System.err.println("replaceable_yn-"+replaceable_yn);
																if(("Y").equals(refund_yn)){
																		refundchck="checked";
																		refndYNdisable="";
																	}
																	else{	
																		refundchck="unchecked";
																		refndYNdisable="disabled";
																	}
																
																
																System.err.println(disabled);
																System.err.println(disable);
																cnt++;
																System.err.println("cnt-->"+cnt);
																if(cnt==1){
																	System.err.println("cnt1-->1");
																	pkg_service_long_des=checkForNull(rs1.getString("pkg_service_long_desc"));
																	System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
																}
																System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
											
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(index));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pkg_serv_ind.equals("G") ? "selected" : ""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_serv_ind.equals("C") ? "selected" : ""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pkg_serv_ind.equals("S") ? "selected" : ""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pkg_serv_ind.equals("P") ? "selected" : ""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pkg_serv_ind.equals("M") ? "selected" : ""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
 if(factor_rate_ind.equals("G") || factor_rate_ind.equals("C")){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(factor_rate_ind.equals("S")?"selected":""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(factor_rate_ind.equals("R")?"selected":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(factor_rate_ind.equals("P")?"selected":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(factor_rate_ind.equals("S")?"selected":""));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(factor_rate_ind.equals("R")?"selected":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(factor_rate_ind.equals("U")?"selected":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(factor_rate_ind.equals("P")?"selected":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(factor_rate_ind.equals("X")?"selected":""));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(index));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(factor_rate));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((amt_limit_ind.equals("A")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((amt_limit_ind.equals("P")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((amt_limit_ind.equals("U")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block76Bytes, _wl_block76);
if("Y".equals(pkg_serv_ind_lmt_YN)) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((group_service_ind.equals("B")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf((group_service_ind.equals("G")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf((group_service_ind.equals("S")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
} else{
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf((group_service_ind.equals("G")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((group_service_ind.equals("S")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
} 
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(incl_home_medication_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(home_med_enbl_disbl));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(replaceable_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(index));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(index));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rep_serv_ord_cat_code));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(index));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(index));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(index));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(index));
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
	if(!daily_limit_ind.equals("")){
														if("G".equals(daily_limit_ind) || "B".equals(daily_limit_ind)) { 
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
 } if("I".equals(daily_limit_ind) || "B".equals(daily_limit_ind)) {
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
 }
														}else{ 
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
 	}
            _bw.write(_wl_block134Bytes, _wl_block134);
	if(!daily_limit_ind.equals("")){
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(index));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(index));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(index));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(index));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
}else{
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(index));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(index));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(index));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
}
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(refundchck));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block157Bytes, _wl_block157);
 if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y"))
									              {
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
} 
									              else{
									            	  
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
  
									              }
            _bw.write(_wl_block165Bytes, _wl_block165);
 if(!close_package_yn.equals("") && close_package_yn.equals("Y"))
									              {
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(index));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(close_package_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);
} 
									              else{
									            	  
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(index));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(close_package_yn));
            _bw.write(_wl_block170Bytes, _wl_block170);
  
									              }
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(index));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(index));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block175Bytes, _wl_block175);
 if(!apply_fact_for_srv_lmt_yn.equals("") )
										              {
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(index));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(index));
            _bw.write(_wl_block179Bytes, _wl_block179);
} 
										              else{
										            	  
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(index));
            _bw.write(_wl_block181Bytes, _wl_block181);
  
										              }
            _bw.write(_wl_block182Bytes, _wl_block182);
 if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y"))
									            	   {
            										 
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(index));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(index));
            _bw.write(_wl_block186Bytes, _wl_block186);
} 
									              else{
									            	  
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(index));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
  
									              }
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(index));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(index));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(index));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(index));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(index));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(index));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(index));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(index));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(index));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(index));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(index));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(index));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(pkg_serv_ind));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(index));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(index));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(index));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(index));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(factor_rate_ind));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(index));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(factor_rate));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(index));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(index));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(amt_limit_ind));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(index));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(index));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(index));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(index));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(group_service_ind));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(index));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(rep_serv_ord_cat_code));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(index));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(daily_limit_ind));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(index));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(index));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(daily_amt_limit_gross_net));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(index));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(index));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(index));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(index));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(close_package_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(index));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(index));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(index));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(index));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(index));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(index));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(defaultPkgCode));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(index));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(defaultPkgSeq));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(index));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block261Bytes, _wl_block261);

		    
            }
		  }
		  
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(defaultPkgCode));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(defaultPkgSeq));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block267Bytes, _wl_block267);
				
     	}
		catch(Exception ex){
			ex.printStackTrace();
			System.err.println("exception in pkg serv details:"+ex);
		} 
		finally{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if (rst3 != null) rst3.close();
			if(pstmt3 != null) pstmt3.close();	
	
       }
       
/*	if(cnt>0){
		System.out.println("classval"+classval);
		out.println("<script>");
		out.println("highlightRow1(1,'"+classval+"')");
		//out.println("showPackageServiceDetails(1,pkg_short_desc1,pkg_service_long_desc1)"); pkg_short_desc1="+pkg_short_desc1+" /pkg_service_long_desc1=="+pkg_service_long_desc1
		out.println("</script>");	
		
		}	*/
 /*    	if(cnt<=0){
    	// int balc=10-count;
    	int balc=10-cnt;
			for(int i=0;i<balc;i++){
				*/
				
            _bw.write(_wl_block268Bytes, _wl_block268);
   /*
			}
		}
     
			*/
		
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(index));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(pkg_service_long_des));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(tableid));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf( "Y".equals(pkgServLmtDtlsPrivYN) ? "disabled" : ""));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(patientid1));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(blng_class_code));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(privlege_code));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(defaultPkgCode));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(order_catalog_yn));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(pkg_serv_ind_lmt_YN));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(defaultPkgSeq));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultEffFromDate));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(PKG_LIMIT_IND_BY));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(selectedItemIndex));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(pkg_serv_lmt_YN));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(daily_pkg_lmt_yn));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(p_daily_pkg_serv_lmt));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(p_daily_pkg_serv_lmt_ind));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(pkgServDtlsAuthStr));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block304Bytes, _wl_block304);

	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block305Bytes, _wl_block305);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Items.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNLIMITED.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }
}

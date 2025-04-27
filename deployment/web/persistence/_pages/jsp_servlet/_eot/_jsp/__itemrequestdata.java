package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.PkgDefBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __itemrequestdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ItemRequestData.jsp", 1709120240000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\'../js/PkgDef.js\'></script> \n\t\t<script type=\'text/javascript\' src=\'../../eOT/js/ManageQuery.js\'></script>\n\t\t<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOT/js/ItemDetails.js\"></script>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tvar headTop = -1;\n\t\tvar FloatHead1;\n//\t\talert(location.href);\n\t\tfunction processScroll()\n\t\t{\n\t\t\tif (headTop < 0)\n\t\t\t{\n\t\t\t\tsaveHeadPos();\n\t\t\t}\n\t\t\tif (headTop>0)\n\t\t\t{\n\t\t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\t\telse if (document.body)\n\t\t\t\t\ttheTop = document.body.scrollTop;\n\t\t\t\tif (theTop>headTop)\n\t\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\t\t\telse\n\t\t\t\t\tFloatHead1.style.top = \'0px\';\n\t\t\t}\n\t\t}\n\n\t\tfunction saveHeadPos()\n\t\t{\n\t\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\t\tif (parTable != null)\n\t\t\t{\n\t\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\t\tFloatHead1.style.position = \"relative\";\n\t\t\t}\n\t\t}\n\t\t</script>\n\t</head>\n\t<style>\n\t\tthead td, thead td.locked\t{\n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t</style>\n\t<body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onload=\"\" onSelect=\"codeArrestThruSelect();\">\n\t\t<form name=\'itemDetails\' id=\'itemDetails\' action=\'../../servlet/eOT.ItemDetailsServlet\' method=\"post\" target=\"messageFrame\" id=\"itemDetailsForm\">\t\n\n\t\t\t<input class=\"oldbtn\"  type=\"button\" value=\"Add\" onclick=\'javascript:addRow()\'/>\n\t\t\t<input type=\"button\" class=\"button\" name=\"print_item_dtl\" id=\"print_item_dtl\"  value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  onClick=\"printItemDetails()\">\n\n\t\t\t<table  class=\"crstaffgrid\"  border=\"1\" cellspacing=\"0\" id=\'ItemTable\' width=\"100%\" >\n\t\t\t\t<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'mode_0\' id=\'mode_0\' id=\'mode_0\' value=\"A\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'itemCode_0\' id=\'itemCode_0\' value = \'\'>\n\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'itemDesc_0\' id=\'itemDesc_0\' size=\'12\' onBlur=\"if(this.value!=\'\') searchItem(itemDesc_0, 0); else searchItem(\'\', 0);checkItemDescExist(\'0\');\"/>\n\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ItemLookUp_0\' id=\'ItemLookUp_0\' onClick=\"searchItem(itemDesc_0, 0);checkItemDescExist(\'0\');\" /> \n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'itemQuantity_0\' id=\'itemQuantity_0\'  size=\'20\' onblur=\'checkNum(0);\' maxlength=\'5\'>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input class=\"brdclr\" type=\'text\' name=\'requestedDate_0\' id=\'requestedDate_0\' size=\'11\' maxlength=\'10\' onblur=\'checkDateFormat(this)\' >\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" Onblur=\"checkDate(\'0\')\" \n\t\t\t\t\t\t\t\tonClick=\"return showCalendar(\'requestedDate_0\',\'dd/mm/y\');\">\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'itemQuantity_0\' id=\'itemQuantity_0\'  size=\'20\' value=\"1\" onblur=\'checkNum(0);\' maxlength=\'5\'> \n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input class=\"brdclr\" type=\'text\' name=\'requestedDate_0\' id=\'requestedDate_0\' size=\'11\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' maxlength=\'10\' onblur=\'checkDateFormat(this)\' >\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" Onblur=\"checkDate(\'0\')\" \n\t\t\t\t\t\t\t\tonClick=\"return showCalendar(\'requestedDate_0\',\'dd/mm/y\');\">\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<select name=\'cancel_0\' id=\'cancel_0\'>\n\t\t\t\t\t\t\t\t<option value=\"N\">No</option>\n\t\t\t\t\t\t\t\t<option value=\"Y\">Yes</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'cancelledRemark_0\' id=\'cancelledRemark_0\' size=\'10\' maxlength=\'150\' onblur=\"isSpclChar(\'CR\', 0)\"/>\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'itemSpecRemark_0\' id=\'itemSpecRemark_0\' maxlength=\'150\' size=\'10\'  onblur=\"isSpclChar(\'IR\', 0)\"/>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'mode_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'mode_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\"I\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'itemCode_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'itemCode_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'itemDesc_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'itemDesc_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onchange=\"callMode(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =");\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\'12\' onBlur=\"if(this.value!=\'\') searchItem(itemDesc_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =", ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="); else searchItem(\'\', ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =");checkItemDescExist(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =");\"/>\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ItemLookUp_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'ItemLookUp_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onClick=\"searchItem(itemDesc_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");callMode(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =");\"/>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'itemQuantity_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'itemQuantity_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  size=\'20\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onchange=\"callMode(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");\"  onblur=\'checkNum(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =");\' maxlength=\'5\'> \n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input class=\"brdclr\" type=\'text\' name=\'requestedDate_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'requestedDate_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' size=\'11\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' maxlength=\'10\' onblur=\'checkDateFormat(this)\' onchange=\"callMode(";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =");\" >\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" Onblur=\"checkDate(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" onClick=\"return showCalendar(\'requestedDate_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'dd/mm/y\');callMode(";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =");\">\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<select name=\'cancel_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'cancel_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =");\" >\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"N\">No</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"Y\" selected>Yes</option>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"N\" selected>No</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"Y\">Yes</option>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'cancelledRemark_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'cancelledRemark_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' size=\'10\' maxlength=\'150\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =");\" onblur=\"isSpclChar(\'CR\', ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\" />\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'itemSpecRemark_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'itemSpecRemark_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =");\" onblur=\"isSpclChar(\'IR\', ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =")\"/>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\t\t\t\t\t</table>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'totRec\' id=\'totRec\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'booking_no\' id=\'booking_no\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'rowIndex\' id=\'rowIndex\' value = \"\">\n\t\t\t\t\t<input type=\'hidden\' name=\'params\' id=\'params\' id=\'params\' value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"><!-- 20-Jan-14 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'booking_Date\' id=\'booking_Date\' value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\t<!-- 20-Jan-14 -->\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params		= request.getQueryString() ;

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
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 
				String strSysDate = "";
				Connection con=null;
				PreparedStatement pstmt1=null;
				ResultSet rs1=null;
				try
				{
					String locale			 = (String)session.getAttribute("LOCALE");
					String facilityId		 = (String) session.getValue( "facility_id" ) ;
					String orderId		     = request.getParameter( "orderid" ) ;
					String bookingNum		 = request.getParameter( "booking_no" );
					String bookingDate		 = request.getParameter("booking_date");
					System.err.println("bookingDate "+bookingDate);
					String strToDate="";
					String strItemDesc="";
					int  totRec = 1;
					int recordCount = 1;
					con = ConnectionManager.getConnection(request);
					strSysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale);
					String item_code="", qty="",reqDate="",canStat="",canRem="",itemSpec="",item_desc="";
					StringBuffer sqlselect = new StringBuffer();
					sqlselect.append("	SELECT mit.item_code, mit.quantity, mi.short_desc shortdesc,		");
					sqlselect.append("	TO_CHAR (mit.requested_date, 'dd/mm/yyyy') reqdate, mit.cancel_status,		");
					sqlselect.append("	mit.cancel_remarks, mit.item_spec_remarks		");
					sqlselect.append("	FROM ot_manage_item_request mit, mm_item mi		");
					sqlselect.append("	WHERE mit.booking_num = ? AND mit.item_code = mi.item_code		");

					pstmt1 = con.prepareStatement(sqlselect.toString());
					System.out.println("===bookingNum=="+bookingNum);
					pstmt1.setString(1,bookingNum);
					rs1 = pstmt1.executeQuery();

            _bw.write(_wl_block11Bytes, _wl_block11);

						if(rs1.isBeforeFirst())
						{

            _bw.write(_wl_block12Bytes, _wl_block12);

						}
						else
						{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strSysDate));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}

            _bw.write(_wl_block15Bytes, _wl_block15);

					while(rs1.next())
					{
						item_code = CommonBean.checkForNull(rs1.getString("item_code"));
						qty = CommonBean.checkForNull(rs1.getString("quantity"));
						reqDate = com.ehis.util.DateUtils.convertDate(rs1.getString("reqdate"),"DMY","en",locale);
						canStat = CommonBean.checkForNull(rs1.getString("cancel_status"));
						canRem = CommonBean.checkForNull(rs1.getString("cancel_remarks"));
						itemSpec = CommonBean.checkForNull(rs1.getString("item_spec_remarks"));
						strItemDesc = CommonBean.checkForNull(rs1.getString("shortdesc"));

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strItemDesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block47Bytes, _wl_block47);

									if(canStat != null && canStat.equalsIgnoreCase("Y"))
									{

            _bw.write(_wl_block48Bytes, _wl_block48);

									}
									else
									{

            _bw.write(_wl_block49Bytes, _wl_block49);

									}

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(canRem));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(itemSpec));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block57Bytes, _wl_block57);

						recordCount++;
					}

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totRec));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bookingNum));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(params));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bookingDate));
            _bw.write(_wl_block65Bytes, _wl_block65);

					if(rs1!=null)
						rs1.close();
					if(pstmt1!=null)
						pstmt1.close();
					if(con!=null)
						ConnectionManager.returnConnection(con,request);
				}
				catch(Exception e)
				{
					System.out.println("Exception from Package Date :"+e);
					e.printStackTrace();
				}

            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ItemDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Qty.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RequestedDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Cancel.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CancelledRemarks.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ItemSpecRem.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

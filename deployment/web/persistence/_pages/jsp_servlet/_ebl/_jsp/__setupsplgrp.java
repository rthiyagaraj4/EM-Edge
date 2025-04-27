package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __setupsplgrp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/SetupSplGrp.jsp", 1737917539710L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210118             7339  \t       \tMOHE-CRF-0050\t\t           Mohana Priya K\n2            V210216             14534 \t       \tMOHE-CRF-0050\t\t           Mohana Priya K\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/dailycashTabFrame.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<style>\n/*\nthead td, thead td.locked {\n\tbackground-color: navy;\n\tcolor: white;\n\tposition: relative;\n}\n\nthead td {\n\ttop: expression(document.getElementById ( \"tbl-container\") .scrollTop-4);\n\tz-index: 20;\n}\n\nthead td.locked {\n\tz-index: 30;\n}\n\ntd.locked, th.locked {\n\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\tposition: relative;\n\tz-index: 10;\n}\n\ntd.locked, th.locked {\n\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\tposition: relative;\n\tz-index: 10;\n}   \n\n\n\nthead td {\n    display: block;\n}\n\nthead td {\n  position: fixed;\n  height: 10px;\n}\n\t*/\n#table-wrapper {\n  position:relative;\n}\n#table-scroll {\n  height:410px; \n  overflow:auto;  \n  margin-top:20px;\n}\n#table-wrapper table {\n  width:100%;\n}\n#table-wrapper table  {\n  background:white;\n  color:black;\n}\n#table-wrapper table thead tr {\n  position:relative; \n  top: expression(offsetParent.scrollTop);\n  z-index:2;\n  height:20px;\n  width:35%;\n}\t\n\n\n</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body>\n\t<form name=\"BLrportserv\" id=\"BLrportserv\" id=\"BLrportserv\"  action=\"../../servlet/eBL.BLDailyCashServlet\" target=\"messageFrame\" method=\'post\'> \n\t\t<center>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"0\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t\t\t\t\t<div id=\"table-scroll\">\n\t\t\t\t\t\t\t\t\t  <table width=\'100%\' align=\"center\" cellpadding=\"4\"\n\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\" class=\'grid\' id=\"serviceTable1\">\n\t\t\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\"5%\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\"15%\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' >\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  align=\'center\' width=\"15%\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<tr id=\"serviceRow";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"select\" id=\"select\"\n\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"selected_serv(this)\" id=\"select";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" value=\"\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t<td><input class=\"gridDataInputLess\" type=\"text\"\n\t\t\t\t\t\t\t\t\t\t\t\tmaxlength=\"100\" style=\"width:100%;\" name=\"ServGroupCode";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"ServGroupCode";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"ServGroupCode";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" readonly></td>\n\t\t\t\t\t\t\t\t\t\t\t<td><input class=\"gridDataInputLess\" type=\"text\"\n\t\t\t\t\t\t\t\t\t\t\t\tmaxlength=\"100\" style=\"width:100%;\" name=\"LongDesc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"LongDesc";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"LongDesc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" readonly></td>\n\t\t\t\t\t\t\t\t\t\t\t<td><input class=\"gridDataInputLess\" type=\"text\"\n\t\t\t\t\t\t\t\t\t\t\t\tmaxlength=\"100\" style=\"width:100%;\" name=\"ShortDesc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"ShortDesc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"ShortDesc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" readonly></td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'center\'><input type=\"checkbox\" align=\'center\' onclick=\"return false;\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"checkboxundef";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"checkboxundef";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"checkboxundef";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" readonly onFocus=\"this.blur()\"/>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'center\'><input type=\"checkbox\"  onclick=\"return false;\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"checkboxexempt";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"checkboxexempt";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"checkboxexempt";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" readonly/>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t<tr id=\"serviceRow";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"selectbutton";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"select\" id=\"select\" onclick=\"selected_serv(this)\" id=\"select";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" /></td>\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"servgrpCodefld";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">\n\t\t\t\t\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"6\" style=\"width:100%;\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"ServGroupCode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"\" onblur=\"ChangeUpperCase( this );enableNext(this);checkDuplicate(this);\"  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="></td><!--V210216-->\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"longdescFld";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"100\" style=\"width:100%;\" name=\"LongDesc";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"\" onblur=\"shrtdesc(this);validdesc(this);enableNext(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="></td>\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"shortDescfld";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="><input class=\"gridDataInputLess\" type=\"text\" maxlength=\"100\" style=\"width:100%;\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"ShortDesc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"\" onblur=\"validdesc(this);enableNext(this);\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"checkboxundefFld";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="  align=\'center\'><input type=\"checkbox\" name=\"checkboxundef";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\"N\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"checkboxundef";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"checkUndefValid(this,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\')\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" /></td>\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"checkboxexemptFld";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="  align=\'center\'><input type=\"checkbox\" name=\"checkboxexempt";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" value=\"N\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"checkboxexempt";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"checkExemValid(this,\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" /></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t </tbody>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'RIGHT\' width=\'10%\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\'\n\t\t\t\t\t\t\t\t\t\t\t\tclass=\'BUTTON\' value=\'Add\'\n\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"AddRow()\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\' class=\'BUTTON\' id=\"save\"\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'Save\' onclick=\'saveGroupService()\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\'\n\t\t\t\t\t\t\t\t\t\t\t\tclass=\'BUTTON\' id=\'Associate\' name=\'Associate\' id=\'Associate\' value=\'Associate Services/Items\'\n\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"AssocServ(\'associate\')\"></td>  \n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</center>\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"FacilityId\" id=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"> \n\t\t<input type=\"hidden\" name=\"servGrpCode\" id=\"servGrpCode\" id=\"servGrpCode\" value=\"\"> \n\t\t<input type=\"hidden\" name=\"servGrpDesc\" id=\"servGrpDesc\" id=\"servGrpDesc\" value=\"\"> \n\t\t<input type=\"hidden\" name=\"grpSize\" id=\"grpSize\" id=\"grpSize\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"hidden\" name=\"rowval\" id=\"rowval\" id=\"rowval\" value=\"\"> \n\t\t<input type=\'hidden\' name=\'user\' id=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"hidden\" name=\"grpArrCode\" id=\"grpArrCode\" id=\"grpArrCode\" value=\"\">\n\t\t<input type=\"hidden\" name=\"called\" id=\"called\" id=\"called\" value=\"setupsplgrp\">\n\t\t<input type=\"hidden\" name=\"totrecords\" id=\"totrecords\" id=\"totrecords\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">  \n\t\t<input type=\"hidden\" name=\"countval\" id=\"countval\" id=\"countval\" value=\"\">  \n\t\t<input type=\"hidden\" name=\"exemcount\" id=\"exemcount\" id=\"exemcount\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">  \n\t\t<input type=\"hidden\" name=\"undefcount\" id=\"undefcount\" id=\"undefcount\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">  \n\t\t<input type=\"hidden\" name=\"grpsave\" id=\"grpsave\" id=\"grpsave\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\"hidden\" name=\"modeType\" id=\"modeType\" id=\"modeType\" value=\"setupSplGrp\"> \n\t\t<input type=\"hidden\" name=\"WS_NO\" id=\"WS_NO\" id=\"WS_NO\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</html>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );
	
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

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String grpsave	=	"N";
	
	try {
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		//isUserCanAcess		= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties) httpSession.getValue("jdbc");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";
		System.err.println("user-->" + strLoggedUser);

            _bw.write(_wl_block8Bytes, _wl_block8);

				String loginUser = (String) session.getValue("login_user");
				String localeLang = (String) session.getAttribute("LOCALE");
				int serSize = 0;
				String count = "";
				String exmcount = "";
				String disabled = "";
				String readonly = "";
				String onfocus = "";
				int totalrec=0;
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

											String bean_id = "";
											String bean_name = "";
											String WS_NO = p.getProperty("client_ip_address");
											bean_id = "DailyCashDeliveryReport";
											bean_name = "eBL.DailyCashDeliveryReport";
											LinkedHashMap DailyCashReprt = null;
											DailyCashDeliveryReport DailyCashDeliveryReport = null;
											DailyCashReportBean DailyCashReportBean = new DailyCashReportBean();
											DailyCashReprt = new LinkedHashMap();
											DailyCashDeliveryReport = (DailyCashDeliveryReport) PersistenceHelper.getBeanObject(bean_id, bean_name,request);
											DailyCashDeliveryReport.clearBean();

											//To get USE_FOR_UNDEFINED_ITEM count
											Connection conn = null;
											PreparedStatement pstmt = null;
											ResultSet rs = null;

											try {
												String sql = "SELECT COUNT(*) FROM BL_REPORT_SERV_GROUP WHERE USE_FOR_UNDEFINED_ITEM='Y'";
												System.err.println("Query to Fetch  " + sql);
												conn = ConnectionManager.getConnection();
												pstmt = conn.prepareStatement(sql);
												rs = pstmt.executeQuery();
												System.err.println("After Execute Query count ");
												while (rs.next()) {
													count = checkForNull(rs.getString(1));
													System.err.println("countundef value obtained--" + checkForNull(rs.getString(1)));
													}
												} catch (Exception e) {
													System.err.println("Exception in getUndefCount=" + e);
													e.printStackTrace();
												} finally {
													System.err.println("Inside Finally");
													if (rs != null) {
														System.err.println("Result Set Not Empty-getUndefCount");
														rs.close();
													}
													if (pstmt != null)
														pstmt.close();
													ConnectionManager.returnConnection(conn);
												}
												//To get USE_FOR_UNDEFINED_ITEM count ends

												//To get Exempted_receipt_yn  count
												try {
													String sql = "SELECT COUNT(*) FROM BL_REPORT_SERV_GROUP WHERE EXEMPTED_RECEIPT_YN='Y'";
													System.err.println("Query to Fetch  " + sql);
													conn = ConnectionManager.getConnection();
													pstmt = conn.prepareStatement(sql);
													rs = pstmt.executeQuery();
													System.err.println("After Execute Query count ");
													while (rs.next()) {
														exmcount = checkForNull(rs.getString(1));
														System.err.println("exmcount value obtained--" + checkForNull(rs.getString(1)));
													}
												} catch (Exception e) {
													System.err.println("Exception in exmcount=" + e);
													e.printStackTrace();
												} finally {
													System.err.println("Inside Finally");
													if (rs != null) {
														System.err.println("Result Set Not Empty-exmcount");
														rs.close();
													}
													if (pstmt != null)
														pstmt.close();
													ConnectionManager.returnConnection(conn);
												}

												DailyCashDeliveryReport.getDBValues();//Loading DB Values from Temporary table to HasMap
												String KeyValue = "";
												int limit = 1;
												int extra = 0;
												int extraID = 0;
												DailyCashReprt = (LinkedHashMap) DailyCashDeliveryReport.getDailyCashSearchValues();

												serSize = DailyCashReprt.size();
												System.err.println("serSize From Bean  " + serSize);
												totalrec=serSize;
												if (serSize < 14) {
													extra = 14 - serSize;
													System.err.println("extra size  " + extra);
												}
												if (!DailyCashReprt.isEmpty()) {
													Iterator it = DailyCashReprt.entrySet().iterator();
													while (it.hasNext()) {
														Map.Entry obj = (Entry) it.next();
														DailyCashReportBean = (DailyCashReportBean) obj.getValue();
														KeyValue = (String) obj.getKey();
														if (DailyCashReportBean != null) {
															//Service Group Code
															String ServGroupCode = DailyCashReportBean.getServGroupCode();
															ServGroupCode = (ServGroupCode == null ? "" : ServGroupCode);
															ServGroupCode=ServGroupCode.toUpperCase(); //V210216
															System.err.println("ServGroupCode From Bean  " + ServGroupCode);

															//Long Desc
															String LongDesc = DailyCashReportBean.getLongDesc();
															LongDesc = (LongDesc == null ? "" : LongDesc);
															System.err.println("LongDesc From Bean  " + LongDesc);

															//Short Desc
															String ShortDesc = DailyCashReportBean.getShortDesc();
															ShortDesc = (ShortDesc == null ? "" : ShortDesc);
															System.err.println("ShortDesc From Bean  " + ShortDesc);

															//Used For Undefined Items
															String UsedForUndefinedItems = DailyCashReportBean.getUsedForUndefinedItems();
															UsedForUndefinedItems = (UsedForUndefinedItems == null ? "" : UsedForUndefinedItems);
															//UndefArr=UsedForUndefinedItems;
															
															if (UsedForUndefinedItems.equals("Y")) {
																UsedForUndefinedItems = "checked";
															} else {
																UsedForUndefinedItems = "unchecked";
															}
															System.err.println("UsedForUndefinedItems From Bean  " + UsedForUndefinedItems);

															//Used For Exempted Receipt
															String UsedForExemptedReceipt = DailyCashReportBean.getUsedForExemptedReceipt();
															UsedForExemptedReceipt = (UsedForExemptedReceipt == null ? "" : UsedForExemptedReceipt);
															System.err.println("UsedForExemptedReceipt From Bean  " + UsedForExemptedReceipt);
															
															if (UsedForExemptedReceipt.equals("Y")) {
																UsedForExemptedReceipt = "checked";
															} else {
																UsedForExemptedReceipt = "unchecked";
															}
															
										
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ServGroupCode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(LongDesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ShortDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(UsedForUndefinedItems));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(UsedForUndefinedItems));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(UsedForExemptedReceipt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(UsedForExemptedReceipt));
            _bw.write(_wl_block34Bytes, _wl_block34);

											}
														limit++;
													}
													if (extra > 0) {
														extraID = limit;
														for (int i = 0; i < extra; i++) {
															if (i == 0) {
																disabled = "";
																readonly = "";
																onfocus = "";
															} else {
																disabled = "disabled";
																readonly = "readonly";
																onfocus = "this.blur()";
															}
										
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(exmcount));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block58Bytes, _wl_block58);

											extraID++;
														}
													}
												}
										
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(localeLang));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(serSize));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalrec));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(exmcount));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(grpsave));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(WS_NO));
            _bw.write(_wl_block68Bytes, _wl_block68);

	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in Setup Spl Group JSP::" + e);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LongDesc.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ShortDesc.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UsedForUndefItms.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UsedForExemptItms.label", java.lang.String .class,"key"));
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
}

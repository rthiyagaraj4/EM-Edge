package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.URLDecoder;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.AdditionalServiceDetailsBean;
import java.text.SimpleDateFormat;
import java.lang.Integer;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __additionalservicepreapprovalrequestdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AdditionalServicePreApprovalRequestDetails.jsp", 1727969678490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/AdditionalServiceDetailsScript.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n\t{\n\t\tif (headTop < 0)\n\t\t{\n\t\t\tsaveHeadPos();\n\t\t\t\n\t\t}\n\t\tif (headTop>0)\n\t\t{\n\t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\telse if (document.body)\n\t\t\t\ttheTop = document.body.scrollTop;\n\n\t\t\tif (theTop>headTop)\n\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\t\telse\n\t\t\t\tFloatHead1.style.top = \'0px\';\n\t\t}\n\t}\n\n\tfunction saveHeadPos()\n\t{\n\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\tif (parTable != null)\n\t\t{\n\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\tFloatHead1.style.position = \"relative\";\n\t\t}\n\t}\n\t\n\tfunction lockKey()\n\t  {\n\t\t \t \n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t  }\n\n\t  function lockbackSpace()\n\t  {\n\t\t// alert(document.order_type_form.mode.value);\n\t\t   var mode = document.mode.value;\n      // alert(window.event.keyCode);\n\t\t if(mode==\'modify\' && window.event.keyCode==8)\n\t\t  {\n           //return false;\n\t\t  }\n\t  }\n\t \n\t\n\t\n</script>\n</head>\n<style>\n\t\t\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\t\n\t\t\n\t\t</style>\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"    ; onSelect=\"codeArrestThruSelect();\">\n\t<form id=\"AdditionalServicePreApprovalRequestDetailsForm\" name=\"AdditionalServicePreApprovalRequestDetailsForm\" id=\"AdditionalServicePreApprovalRequestDetailsForm\">\t\n\n\t<table align=\'center\' cellpadding=3 cellspacing=0  width=\'100%\' id=\"panel_categories_table\" name=\"panel_categories_table\" id=\"panel_categories_table\" border=\"1\">\n\t<div id=\"tableContainer\">\n\t<thead>\n\t<tr style=\"position: sticky; top: 0; background-color: white; z-index: 1;\">\n\t\t<td class=\'COLUMNHEADER\'\t\twidth=\'4%\'\talign=\"left\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'7%\'\talign=\"left\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'7%\'\talign=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'8%\' \talign=\"left\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'6%\'\talign=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'5%\'\talign=\"left\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'5%\' \talign=\"left\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th class=\'CAFLOWSHEETLEVEL1\'\twidth=\'7%\' \talign=\"left\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t</tr>\n\t</thead>\n\t\n\t<TBODY>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t<tr onclick=\"fnViewModify(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\" >\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td class=\"fields\"\twidth=\'4%\'   id=\"srl_no";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"srl_no";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<td class=\"fields\"\twidth=\'4%\'   id=\"srl_no";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<td class=\"fields\"\twidth=\'7%\'   id=\"billing_class";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"\t\t\t\tname=\"billing_class";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\t> \t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  </td>\n\t<td>\n\t <input type=\'checkbox\' name=\'public";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'public";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' \tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \"  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" readonly></td>\n\t</td>\n\t<td>\n\t<select name=\'rateBasisInd";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'rateBasisInd";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onChange=\"\"   readonly > \n\t<option value=\'\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">---";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="---</option>\n\t<option value=\'B\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t<option value=\'C\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t<option value=\'V\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t</select>\n\t</td>\n\t<td class=\"fields\"\twidth=\'8%\'   id=\"description";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"\t\t\t\t\tname=\"description";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td> \n\t<td class=\"fields\"  width=\'6%\'   id=\"Indicator";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\t\t\t\t\tname=\"Indicator";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td> \n\t<td class=\"fields\"\twidth=\'5%\'   id=\"ip_rate";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\t\t\t\t\t\tname=\"ip_rate";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </td>\n\t<td class=\"fields\"\twidth=\'5%\'   id=\"op_rate";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\t\t\t\t\t\tname=\"op_rate";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td> \n\t<td class=\"fields\"\twidth=\'5%\'   id=\"emer_rate";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"\t\t\t\t\tname=\"emer_rate";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" </td> \n\t<td class=\"fields\"\twidth=\'5%\'   id=\"ext_rate";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"\t\t\t\t\tname=\"ext_rate";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" </td>\n\t<td class=\"fields\"\twidth=\'5%\'   id=\"dc_rate";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"\t\t \t\t\t\tname=\"dc_rate";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" </td>\n\t<td class=\"fields\"\twidth=\'7%\'   id=\"min_charge";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"\t\t \t\t\tname=\"min_charge";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td> \n\t<td class=\"fields\"\twidth=\'7%\'   id=\"max_charge\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"\t\t\t\t\tname=\"max_charge";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" </td> \n\t<td class=\"fields\"\twidth=\'5%\'   id=\"base_qty";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"\t\t \t\t\tname=\"base_qty";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"\t>\t    \t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t<td class=\"fields\"\twidth=\'8%\'   id=\"applicability";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\t\t \t\tname=\"applicability";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\t    \t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t<td class=\"fields\"\twidth=\'7%\'   id=\"apply_desc";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"\t\t \t\t\tname=\"apply_desc";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t<td class=\"fields\"\twidth=\'8%\'   id=\"valid_from";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"\t\t \t\t\tname=\"valid_from";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t<td class=\"fields\"\twidth=\'8%\'   id=\"valid_to";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"\t\t \t\t\tname=\"valid_to";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\t    \t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t<input type=\"hidden\" id=\"service_ind";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" \t\tname=\"service_ind";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" \t \t\t\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" />\n</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t</table>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\'\t\t\t\tid=\'locale\' \t \t\t\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\t\t\tid=\'facilityId\' \t\t\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t<input type=\"hidden\" \tid=\"blng_class\" \t\tname=\"blng_class\" id=\"blng_class\" \t \t \t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" /> \n\t<input type=\"hidden\" \tid=\"service_ind\" \t\tname=\"service_ind\" id=\"service_ind\" \t \t\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" />\n\t<input type=\"hidden\" \tid=\"service_code\" \t\tname=\"service_code\" id=\"service_code\" \t \t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" />\n\t<input type=\"hidden\" \tid=\"service_desc\" \t\tname=\"service_desc\" id=\"service_desc\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" />\n\t<input type=\"hidden\" \tid=\"price_ind\" \t\t\tname=\"price_ind\" id=\"price_ind\" \t \t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" />\n\t<input type=\"hidden\" \tid=\"price_code\" \t\tname=\"price_code\" id=\"price_code\"  \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" />\n\t<input type=\"hidden\" \tid=\"price_desc\" \t\tname=\"price_desc\" id=\"price_desc\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" />\n\t<input type=\"hidden\" \tid=\"policy_code\" \t\tname=\"policy_code\" id=\"policy_code\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" />\n\t<input type=\"hidden\" \tid=\"policy_desc\" \t\tname=\"policy_desc\" id=\"policy_desc\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" />\n\t<input type=\"hidden\" \tid=\"cust_code\" \t\t\tname=\"cust_code\" id=\"cust_code\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" />\n\t<input type=\"hidden\" \tid=\"cust_desc\" \t\t\tname=\"cust_desc\" id=\"cust_desc\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" />\n\t<input type=\"hidden\" \tid=\"desc_app\" \t\t\tname=\"desc_app\" id=\"desc_app\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" />\n\t<input type=\"hidden\" \tid=\"charge_type\" \t\tname=\"charge_type\" id=\"charge_type\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" />\n\t<input type=\"hidden\" \tid=\"eff_to\" \t\t\tname=\"eff_to\" id=\"eff_to\" \t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" />\n\t<input type=\"hidden\" \tid=\"eff_from\" \t\t\tname=\"eff_from\" id=\"eff_from\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" />\n\t<input type=\"hidden\" \tid=\"description\" \t\tname=\"description\" id=\"description\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" />\n\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t\n</body>\n</TBODY>\t\n\t\n\t</div>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n</html>\n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );
	
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
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}

private String decodeParam(String input){
	String output = "";
	if(input == null || "null".equals(input)){
		output = "";
	}
	else{
		output = URLDecoder.decode(input);
	}
	return output;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	//String applyMode									=	new String();
	String locale				=	"";
	String facilityId			=	"";

	String bean_id				=	"";
	String bean_name			=	"";

	//String facilityId			=	"";
	String serviceInd			=	"";
	String serviceCode			=	"";
	String serviceDescription	=	"";
	String priceInd				=	"";
	String priceCode			=	"";
	String priceDescription		=	"";
	String policyCode			=	"";
	String policyDesc			=	"";
	String custCode				=	"";
	String custDesc   			=	"";
	String billingClass   		=	"";
	String EffectiveTo   		=	"";
	String desc   				=	"";
	String EffectiveFrom   		=	"";
	String discApplicability   	=	"";
	String chargeType   		=	"";

	LinkedHashMap additionalServiceDetailsDataMap=	null;
	List<AdditionalServiceDetailsBean> policyList = null; 
	HashMap<String,List<AdditionalServiceDetailsBean>> policyMap = null;
	String prevTab = null;
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Startss 

	String basePrice="", averageCost="", computedValue="",defSelect="";
	String rateBasisInd="";

	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
	//AdditionalServiceDetailsBean additionalServiceDetailsBean		= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;

	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

try  
{
	 
	sStyle 			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 		= 	(String)session.getAttribute("LOCALE");
	facilityId	=   checkForNull(request.getParameter("facility_id")); //(String) session.getValue( "facility_id" ) ;//Added NMC-JD-CRF-0014 by shikha on 200902
	serviceInd	=	checkForNull(request.getParameter("serviceInd"));
	serviceCode	=	checkForNull(request.getParameter("serviceCode"));
	serviceDescription =	decodeParam(request.getParameter("serviceDescription"));
	priceInd		=	checkForNull(request.getParameter("priceInd"));
	priceCode		=	checkForNull(request.getParameter("priceCode"));
	priceDescription =	decodeParam(request.getParameter("priceDescription"));
	policyCode		=	checkForNull(request.getParameter("policyCode"));
	policyDesc		=	checkForNull(request.getParameter("policyDesc"));
	//decodeParam(request.getParameter("policyDesc"));
	custCode	=	checkForNull(request.getParameter("custCode"));
	custDesc		=	decodeParam(request.getParameter("custDesc"));
	billingClass	=	checkForNull(request.getParameter("billingClass"));
	EffectiveTo		=	checkForNull(request.getParameter("EffectiveTo"));
	desc			=	checkForNull(request.getParameter("desc"));
	EffectiveFrom	=	checkForNull(request.getParameter("EffectiveFrom"));

	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	discApplicability=	checkForNull(request.getParameter("discApplicability"));
	chargeType		=	checkForNull(request.getParameter("chargeType"));
	additionalServiceDetailsDataMap			=	new LinkedHashMap();
	System.err.println("<<<<<<<<<<Request Param ::::::>>>>>>>>"+request.getQueryString());
	
	bean_id			= 	"AdditionalServiceDetailsBean" ;
	bean_name		= 	"eBL.AdditionalServiceDetailsBean";
	AdditionalServiceDetailsBean additionalServiceDetailsBean		= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	//isUserCanAcess	= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	//additionalServiceDetailsDataMap									=	additionalServiceDetailsBean.getPreApprovalRequestDetailsData(serviceInd, serviceCode, serviceDescription, priceInd, priceCode,priceDescription,policyCode, facilityId, locale,custCode,policyDesc,custDesc,billingClass,EffectiveTo,desc,EffectiveFrom,discApplicability,chargeType);		
	con = ConnectionManager.getConnection(request); 
	//String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
	//String blngServDesc = "";

	
	//HashMap<String,List<AdditionalServiceDetailsBean>> fmtDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();  //checklist
	AdditionalServiceDetailsBean fmtDtlsBean = null;
	if(policyList == null || policyList.isEmpty())
	{
		String sqlCoverage = BlRepository.getBlKeyValue("DISCOUNT_DETAILS_FETCH");
			
		System.out.println("<<<<<rst IN sqlCoverage::::>>"+sqlCoverage);
		System.out.println("<<facilityId<<<rst IN sqlCoverage::::>>"+facilityId);
		System.out.println("<priceInd<serviceInd<<<rst IN sqlCoverage::::>>"+priceInd);
		System.out.println("<<priceCode<<<rst IN sqlCoverage::::>>"+priceCode);
		System.out.println("<serviceInd<<<<rst IN sqlCoverage::::>>"+serviceInd);
		System.out.println("<serviceCode<<<<rst IN sqlCoverage::::>>"+serviceCode);
		System.out.println("<EffectiveFrom<<<<rst IN sqlCoverage::::>>"+EffectiveFrom);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+custCode);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+policyCode);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+billingClass);
		pstmt = con.prepareStatement(sqlCoverage);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, serviceInd);
		pstmt.setString(3, priceInd);
		pstmt.setString(4, priceCode);
		pstmt.setString(5, serviceCode);
		//pstmt.setString(6,new Date(sdf.parse("06/04/2004").getTime());
		pstmt.setString(6, billingClass);
		pstmt.setString(7, billingClass);
		//pstmt.setString(7, EffectiveFrom);
		pstmt.setString(8, custCode);
		pstmt.setString(9, policyCode);
		if(EffectiveFrom == null || ("".equals(EffectiveFrom))){
			pstmt.setString(10, null);
		}
		else{
			pstmt.setString(10, EffectiveFrom);
		}
		//pstmt.setString(9, EffectiveFrom);
		//pstmt.setString(9, EffectiveFrom);
		rst = pstmt.executeQuery();
		System.out.println("<<<<<sql                Coverage>>"+sqlCoverage);
		//System.out.println("<<<<<rst.next() IN AdditionalServicePreApprovalRequestDetails.jsp::::>>"+rst.next());
		if(rst!=null){
			//System.out.println("<<<<<inside if nulll::::>>");
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			int rsCnt = 0;
			//System.out.println("<<<<<inside if nulll::::>>==========="+rsCnt);
			//System.out.println("<<<<<inside if nulll::::>>"+rst.getString("blng_class_code"));
			  while (rst.next()) {
				System.out.println("<<<<<rst IN AdditionalServicePreApprovalRequestDetails.jsp>>====inside===if===");
				fmtDtlsBean = new AdditionalServiceDetailsBean();
				//fmtDtlsBean.setBillingClass(rst.getString("blng_class_code"));
			//	fmtDtlsBean.setServiceInd(rst.getString("blng_serv_ind"));
			//	fmtDtlsBean.setPriceInd(rst.getString("cust_pc_ind"));
				fmtDtlsBean.setIpRate(rst.getString("ip_rate"));
				fmtDtlsBean.setOpRate(rst.getString("op_rate"));
				fmtDtlsBean.setEmerRate(rst.getString("emer_rate"));
				fmtDtlsBean.setRefRate(rst.getString("ref_rate"));
				fmtDtlsBean.setDaycareRate(rst.getString("daycare_rate"));
				fmtDtlsBean.setMinCharge(rst.getString("min_charge_amt"));
				fmtDtlsBean.setMaxCharge(rst.getString("max_charge_amt"));
				fmtDtlsBean.setBaseQty(rst.getString("base_qty"));
				fmtDtlsBean.setDescApplicability(rst.getString("gross_net_appl_ind"));
				fmtDtlsBean.setDesc(rst.getString("apply_disc_yn"));
				fmtDtlsBean.setEffectiveFrom(rst.getString("valid_from"));
				fmtDtlsBean.setEffectiveTo(rst.getString("valid_to"));
				fmtDtlsBean.setServiceInd(rst.getString("BLNG_SERV_IND"));
				fmtDtlsBean.setPriceInd(rst.getString("CUST_PC_IND"));
				fmtDtlsBean.setBillingClass(rst.getString("BLNG_CLASS_CODE"));
				//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
				fmtDtlsBean.setSt_item_public_price_chk(rst.getString("st_item_public_price_chk_yn"));
				fmtDtlsBean.setSt_item_rate_basis_ind(rst.getString("st_item_rate_basis_ind"));
				//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
				policyList.add(fmtDtlsBean);
				System.out.println("<<<<<rst IN AdditionalServicePreApprovalRequestDetails.jsp>>====inside==eennndddd=if===");
				 } 

				rsCnt++;
				if(rsCnt<1){
					policyMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
					AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
					policyList = new ArrayList<AdditionalServiceDetailsBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}
		}
		else{
			policyMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
			AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			policyList.add(titleBean);
			policyMap.put(prevTab, policyList);
		}	
			}

	/*				
			if(rsCnt<1){
				priceDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
				AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
				policyList = new ArrayList<AdditionalServiceDetailsBean>();
				policyList.add(titleBean);
				priceDetailsMap.put(prevTab, policyList);
			}
		}
		else{
			priceDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
			AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			policyList.add(titleBean);
			priceDetailsMap.put(prevTab, policyList);
		}		
		*/

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

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
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	
	System.err.println("<<<<<<<<<IN AdditionalServicePreRecordApprovalDetails.jsp policyList:size22:::::::>>>>>>"+policyList.size()); 

	int index = 0;
	int size = policyList.size();
	for(int i=0; i < size; i++)
	{
		//int index =    (Integer)iterator.next();
		int sNo	  =		index+1;			
			
		additionalServiceDetailsBean = (AdditionalServiceDetailsBean) policyList.get(index);  
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
		rateBasisInd=additionalServiceDetailsBean.getSt_item_rate_basis_ind();
			
		basePrice=("B").equals(rateBasisInd) ?"SELECTED" :"";
		averageCost=("C").equals(rateBasisInd) ?"SELECTED" :"";
		computedValue=("V").equals(rateBasisInd) ?"SELECTED" :"";
		defSelect=("").equals(rateBasisInd) ?"SELECTED" :"";
		//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends	
	

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(i==0) {
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
} else { 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(index));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(additionalServiceDetailsBean.getBillingClass()	 					!=null 	? 	additionalServiceDetailsBean.getBillingClass()			: 	"&nbsp;" ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(additionalServiceDetailsBean.getSt_item_public_price_chk()	 					!=null 	? 	additionalServiceDetailsBean.getSt_item_public_price_chk()			: 	"&nbsp;" ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(("Y").equals(additionalServiceDetailsBean.getSt_item_public_price_chk())?"checked":""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defSelect));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(basePrice));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(averageCost));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(computedValue));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(serviceDescription));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(additionalServiceDetailsBean.getPriceInd()	 					!=null 	? 	additionalServiceDetailsBean.getPriceInd()			: 	"&nbsp;" ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(additionalServiceDetailsBean.getIpRate()	 					!=null 	? 	additionalServiceDetailsBean.getIpRate()			: 	"&nbsp;" ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(additionalServiceDetailsBean.getOpRate() 					!=null 	? 	additionalServiceDetailsBean.getOpRate()			: 	"&nbsp;" ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(additionalServiceDetailsBean.getEmerRate()					!=null 	? 	additionalServiceDetailsBean.getEmerRate()			: 	"&nbsp;" ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(index));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(additionalServiceDetailsBean.getRefRate()					!=null 	? 	additionalServiceDetailsBean.getRefRate()			: 	"&nbsp;" ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(additionalServiceDetailsBean.getDaycareRate()				!=null 	? 	additionalServiceDetailsBean.getDaycareRate()		: 	"&nbsp;" ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(additionalServiceDetailsBean.getMinCharge()  				!=null 	? 	additionalServiceDetailsBean.getMinCharge()			: 	"&nbsp;" ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(index));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(additionalServiceDetailsBean.getMaxCharge()					!=null 	? 	additionalServiceDetailsBean.getMaxCharge()			: 	"&nbsp;" ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(index));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(additionalServiceDetailsBean.getBaseQty()					!=null 	? 	additionalServiceDetailsBean.getBaseQty()			: 	"&nbsp;" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(additionalServiceDetailsBean.getDescApplicability()			!=null 	? 	additionalServiceDetailsBean.getDescApplicability()	: 	"&nbsp;" ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(additionalServiceDetailsBean.getDesc()						!=null 	? 	additionalServiceDetailsBean.getDesc()				: 	"&nbsp;" ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(additionalServiceDetailsBean.getEffectiveFrom()				!=null 	? 	additionalServiceDetailsBean.getEffectiveFrom()		: 	"&nbsp;" ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(index));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(additionalServiceDetailsBean.getEffectiveTo()				!=null 	? 	additionalServiceDetailsBean.getEffectiveTo()		: 	"&nbsp;" ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(index));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(index));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(additionalServiceDetailsBean.getServiceInd()	 				!=null 	? 	additionalServiceDetailsBean.getServiceInd()			: 	"" ));
            _bw.write(_wl_block78Bytes, _wl_block78);

index++;
}		

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(billingClass						!=null 	? 	billingClass			: 	"" ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(serviceInd						!=null 	? 	serviceInd				: 	"" ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(serviceCode						!=null 	? 	serviceCode				: 	"" ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(serviceDescription 				!=null 	? 	serviceDescription		: 	"" ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(priceInd							!=null 	? 	priceInd				: 	"" ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(priceCode							!=null 	? 	priceCode				: 	"" ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(priceDescription 					!=null 	? 	priceDescription		: 	"" ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(policyCode 						!=null 	? 	policyCode				: 	"" ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(policyDesc 						!=null 	? 	policyDesc				: 	"" ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(custCode 							!=null 	? 	custCode				: 	"" ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(custDesc 							!=null 	? 	custDesc				: 	"" ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(discApplicability 				!=null 	? 	discApplicability		: 	"" ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(chargeType 						!=null 	? 	chargeType				: 	"" ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(EffectiveTo 						!=null 	? 	EffectiveTo				: 	"" ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(EffectiveFrom 					!=null 	? 	EffectiveFrom			: 	"" ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(desc 								!=null 	? 	desc					: 	"" ));
            _bw.write(_wl_block97Bytes, _wl_block97);

}
catch(Exception e)
{
	System.err.println("Exception in AdditionalServicePreApprovalRequestDetails.jsp::"+e);
}
finally{
	ConnectionManager.returnConnection(con);
	//pstmt = null;
	//rst = null;
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block98Bytes, _wl_block98);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Public.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Basis.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceIndDesc.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP_RATE.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP_RATE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EMG_RATE.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EXT_RATE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DC_RATE.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MIN_CHARGE.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MAX_CHARGE.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BASE_QTY.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_APPLICABILITY.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_APPLY.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ValidFrom.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ValidTo.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BASE_PRICE.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVERAGE_COST.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.COMPUTED_VALUE.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

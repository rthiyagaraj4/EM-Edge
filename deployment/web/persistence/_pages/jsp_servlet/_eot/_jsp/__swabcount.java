package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.lang.String;
import java.util.StringTokenizer;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.Common.*;
import eOT.*;
import java.sql.*;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __swabcount extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabCount.jsp", 1723526160000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="           \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n\t<head>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\t\t\n\t<style>\n\t    th, td { white-space: nowrap; }\n\t\tdiv.dataTables_wrapper {\n        width:95%;\n        margin: 0 auto;\n\t\t}\n\t.thwrap{\n\t\t\tposition: relative;\n            top: expression(this.offsetParent.scrollTop);\n\t\t\t/*white-space:nowrap;*/\n\t\t\t/*color:#ff0000;*/\n\t\t\tfont-size:12px;\n\t\t\twidth:auto;\t\t\n\t\t\t/*background: url(\"../images/headerSeparator.jpg\") repeat-y;*/\n\t\t\tbackground-position:right;\n\t\t\tCOLOR: white ;\n\t\t\tbackground-color:#83AAB4;\n\t\t\tborder:0px;\n\t\t\tpadding-left:3px;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 8pt;\n\t\t\t/*font-weight:bold;*/\n\t\t\tborder-collapse:collapse; \n\t\t\t/*position:absolute;*/\n\t\t\tleft:0;\n\t\t\ttop:auto;\n\t\t\t}\n\t\t\t.datawrap{\n\t\t\t/*align:center;*/\n\t}\n</style>\t\t\n\t\t<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eOT/js/SwabCount.js\' language=\'javascript\'></script> \n\t\t<Script src=\"../../eXH/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\t</head>\n<body onKeyDown = \'lockKey()\' onload=\"scrollTo();\">\n<form name=\'SwabCountForm\' id=\'SwabCountForm\' method=\'POST\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\n\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"example\">\n\t\t\t<thead>\n\t\t\t\t<tr>\n\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<th class=\"thwrap\" nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th> \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</tr>\t\n\t\t\t\t</thead>\t\t\t\t\n\t\t\t\t<tbody>\t\t\t\t\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"second_count_remarks_yn_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"second_count_remarks_yn_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"third_count_remarks_yn_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"third_count_remarks_yn_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"fourth_count_remarks_yn_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"fourth_count_remarks_yn_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"fifth_count_remarks_yn_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"fifth_count_remarks_yn_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"final_count_remarks_yn_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"final_count_remarks_yn_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_item_during_op_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"old_item_during_op_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_item_after_cc_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"old_item_after_cc_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"initial_count_val_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"initial_count_val_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_item_after_3c_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"old_item_after_3c_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_item_after_4c_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"old_item_after_4c_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_item_after_5c_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"old_item_after_5c_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input type=\"text\"  name=\"first_count_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"first_count_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  maxlength=\"3\" size=\"3\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" onBlur=\"CheckNum(this);\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"center\"  align=\"center\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"item_during_op_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"item_during_op_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="  onBlur=\"CheckSwabCountNumber(this,\'OP\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t<input type=\"text\" style=\"font:bold\"  name=\"total_count_during_op_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"total_count_during_op_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" maxlength=\"3\" size=\"3\" value=\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" disabled >\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"second_count_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"second_count_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" maxlength=\"3\" size=\"3\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" onBlur=\"CheckNum(this); changeColor(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\',this, \'OP\');checkBlank(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\',this);enable_disable(this)\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"item_after_close_cavity_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"item_after_close_cavity_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" onBlur=\"CheckSwabCountNumber(this,\'CL\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');enable_disable(this)\"> <!--PMG2017-MO-CRF-0001 [IN:063849] -->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" style=\"font:bold\" name=\"total_cavity_count_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"total_cavity_count_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" disabled>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\',this, \'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'); checkBlank(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',this);enable_disable(this)\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onBlur=\"CheckSwabCountNumber(this,\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\',\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');enable_disable(this)\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" style=\"font:bold\" maxlength=\"3\" size=\"3\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t<input type=\"text\" name=\"final_count_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"final_count_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\');checkBlank(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\',this);enable_disable(this)\">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t<label style=\"color:DARKBLUE;cursor:pointer;font:bold\" onClick=\"viewSwabCountRemarks(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\')\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="..</label>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t<label style=\"color:blue;cursor:pointer\"  onClick=\"viewSwabCountRemarks(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<label style=\"color:blue;cursor:pointer\" onClick=\"alert(\'Remarks Cannot be edited after completion of final count.\');\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</label>\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t<label style=\"color:blue;cursor:pointer\" onClick=\"openSwabCountRemarksWindow(document.SwabCountForm,\'Remarks\',\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\',500)\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"item_code_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"item_code_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"item_desc_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"item_desc_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"item_value_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"item_value_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"old_remarks_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"old_remarks_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"new_remarks_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"new_remarks_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"template_id_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"template_id_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\t\t\t\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\t\n\t\t\t</tbody>\t\t\t\n\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\"swab_serial_number\" id=\"swab_serial_number\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\"reviewed_by\" id=\"reviewed_by\" value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'no_of_records\' id=\'no_of_records\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'rownum\' id=\'rownum\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'additions_during_op_cmpl_yn_1\' id=\'additions_during_op_cmpl_yn_1\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'first_cnt_cmpl_yn_1\' id=\'first_cnt_cmpl_yn_1\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'second_cnt_cmpl_yn_1\' id=\'second_cnt_cmpl_yn_1\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'second_cnt_cmpl_yn_22\' id=\'second_cnt_cmpl_yn_22\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'second_cnt_cmpl_yn_33\' id=\'second_cnt_cmpl_yn_33\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'final_cnt_cmpl_yn_1\' id=\'final_cnt_cmpl_yn_1\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'additinal_cmpl_yn\' id=\'additinal_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\"current_item\" id=\"current_item\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"additions_during_op\" id=\"additions_during_op\" value=\"\" >\n\t\t\t\t<input type=\"hidden\" name=\"item_stage\" id=\"item_stage\" value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\"first_count_yn\" id=\"first_count_yn\"\t value=\"N\" >\t\n\t\t\t\t<input type=\'hidden\' name=\"second_count_yn\" id=\"second_count_yn\"  value=\"N\" >\t\n\t\t\t\t<input type=\'hidden\' name=\"third_count_yn\" id=\"third_count_yn\"  value=\"N\" >\t\n\t\t\t\t<input type=\'hidden\' name=\"fourth_count_yn\" id=\"fourth_count_yn\"  value=\"N\" >\t\n\t\t\t\t<input type=\'hidden\' name=\"fifth_count_yn\" id=\"fifth_count_yn\"  value=\"N\" >\t\n\t\t\t\t<input type=\'hidden\' name=\"final_count_yn\" id=\"final_count_yn\"\t value=\"N\" >\n\t\t\t\t<input type=\'hidden\' name=\'first_cnt_cmpl_yn\' id=\'first_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'additions_during_op_cmpl_yn\' id=\'additions_during_op_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'second_cnt_cmpl_yn\' id=\'second_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'additions_aft_clcav_cmpl_yn\' id=\'additions_aft_clcav_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'third_cnt_cmpl_yn\' id=\'third_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'add_after_third_count\' id=\'add_after_third_count\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'fourth_cnt_cmpl_yn\' id=\'fourth_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'add_after_fourth_count\' id=\'add_after_fourth_count\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'fifth_cnt_cmpl_yn\' id=\'fifth_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'add_after_fifth_count\' id=\'add_after_fifth_count\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'final_cnt_cmpl_yn\' id=\'final_cnt_cmpl_yn\' value=\"\" >\n\t\t\t\t<input type=\'hidden\' name=\'allwdSwabCntsVal\' id=\'allwdSwabCntsVal\' id=\"allwdSwabCntsVal\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t<!-- Added Against PMG2017-MO-CRF-0001 [IN:063849] -->\n\t\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'swab_count\' id=\'swab_count\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'total_count_during_op\' id=\'total_count_during_op\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'total_second_val_count\' id=\'total_second_val_count\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'total_final_count\' id=\'total_final_count\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'totalThirdCount\' id=\'totalThirdCount\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'totalFourthCount\' id=\'totalFourthCount\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'totalFifthCount\' id=\'totalFifthCount\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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

	/*
		NOTE: Currently First Count is Not Used. The Initial Count is renamed as First Count and the First_Count is being removed completely. But at Database level, it is not changed. 
		First_Count(earlier known as Initial_Count) at frontend --> is Initial_Count at database level
	*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String classValue="";
		Connection connection  = null;
		CallableStatement cstmt= null;
		PreparedStatement pstmt=null;
		ResultSet rst1 =null;
		PreparedStatement pstmt1=null;
		ResultSet resultset =null;
		ResultSet resultset1 =null;
		String remarks_one = "";
		String remarks_two = "";
		String remarks_initial = "";
		String sql = "",templates	= "",final_count_remarks = "",second_count_remarks = "";
		String second_count_remarks_yn = "";
		String final_count_remarks_yn = "";
		StringBuffer append_str = new StringBuffer();
		StringBuffer append_templates = new StringBuffer();
		String oper_num = request.getParameter("oper_num");
		String swab_serial_number	= request.getParameter("swab_serial_number");
		swab_serial_number=swab_serial_number==null?"1":swab_serial_number;
		swab_serial_number=swab_serial_number.equalsIgnoreCase("null")?"1":swab_serial_number;
		String facility_id	= (String) session.getValue("facility_id");
		String login_user	= request.getParameter("slate_user_id");
		String initial_disabled_surg = "";
		String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode"));	
		
		if(qry_mode.equals("YES"))
			initial_disabled_surg="disabled";
		if(oper_num==null) 
			oper_num="";
		if(oper_num.equalsIgnoreCase("null")) 
			oper_num="";
		int allwdSwabCntsVal = 0;
		LinkedHashMap headerMap = new LinkedHashMap();
		LinkedHashMap dataMap = new LinkedHashMap();

		String first_cnt_cmpl_yn = "";
		String first_cnt_disabled = "";
		String add_during_op_cmpl_yn = "";
		String during_op_disabled = "";
		String second_cnt_cmpl_yn = "";
		String second_cnt_disabled = "";
		String add_aft_clcav_cmpl_yn = "";
		String after_cavity_disabled = "";
		String third_cnt_cmpl_yn = "";
		String third_cnt_disabled = "";
		String additions_after_3c_cmpl_yn = "";
		String additions_after_3c_cmpl_yn_disabled = "";
		String fourth_cnt_cmpl_yn = "";
		String fourth_cnt_disabled = "";
		String additions_after_4c_cmpl_yn = "";
		String additions_after_4c_cmpl_yn_disabled = "";
		String fifth_cnt_cmpl_yn = "";
		String fifth_cnt_disabled = "";
		String additions_after_5c_cmpl_yn = "";
		String additions_after_5c_cmpl_yn_disabled = "";
		String final_cnt_cmpl_yn = "";
		String final_cnt_disabled = "";
		String current_item = "";

		String error_text = "";
		String status = "";
		String lang_error_text = "";
		String template_id = "";
		String item_desc = "";
		String item_code = "";
		String initial_count = "0";
		String db_initial_count = "0";
		String total_count_during_op = "";
		String total_additions_during_op = "";
		String total_cavity_count = "";
		String total_second_val_count = "";
		String add_after_cavity_count="";
		String total_final_count  = "";
		String total_second_count = "";
		int i=0;
		int z = 0;
		
		String[] getKeyVal;
		String[] getDataMapKeyVal;
		String condStr = "";
		String valToChkColor = "";
		
		StringBuffer sqlBuffer = new StringBuffer();
		String valForFinalChkBox = "";
		String valToChkForFinalCount = "";

		String thirdCount = "";
		String addDuringThirdCount = "";
		String thirdCountRemarks = "";
		String thirdCountRemarksYn = "N";
		String addtDuringThirdCountRemarks = "";
		String totalThirdCount = "";
		boolean thirdCountRemarksFlag = false;
		boolean addtDuringThirdCountRemarksFlag = false;

		String fourthCount = "";
		String addDuringFourthCount = "";
		String fourthCountRemarks = "";
		String fourthCountRemarksYn = "N";
		String addtDuringFourthCountRemarks = "";
		String totalFourthCount = "";
		boolean fourthCountRemarksFlag = false;
		boolean addtDuringFourthCountRemarksFlag = false;

		String fifthCount = "";
		String addDuringFifthCount = "";
		String fifthCountRemarks = "";
		String fifthCountRemarksYn = "N";
		String addtDuringFifthCountRemarks = "";
		String totalFifthCount = "";
		boolean fifthCountRemarksFlag = false;
		boolean addtDuringFifthCountRemarksFlag = false;
		/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
		String str_qry="";
		String swabcount="";
		int swab_count=0;
		String finalCountStyle = "";	
		int count= 0;
		/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
		try
		{
			connection = ConnectionManager.getConnection(request);
			/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
				str_qry = "select NO_OF_SWAB_COUNT_REQD from ot_param_for_facility where operating_facility_id = '"+facility_id+"'";
				pstmt=connection.prepareStatement(str_qry);
				resultset = pstmt.executeQuery();
				if(resultset!= null && resultset.next())
				{
					swabcount = resultset.getString(1);
				}
				//System.err.println("SwabCount.jsp===swabcount=========================="+swabcount);				
				if(pstmt != null) pstmt.close();
				if(resultset!=null) resultset.close();				
			/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
				
			headerMap.put(2, "eOT.SecondCount.Label~eOT.AddtSecondCount.Label~CL");
			headerMap.put(3, "eOT.ThirdCount.Label~eOT.AddtThirdCount.Label~3C");
			headerMap.put(4, "eOT.FourthCount.Label~eOT.AddtFourthCount.Label~4C");
			headerMap.put(5, "eOT.FifthCount.Label~eOT.AddtFifthCount.Label~5C");
			allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
			//System.err.println("203,=======allwdSwabCntsVal====SwabCount======"+allwdSwabCntsVal);
			swab_count = Integer.parseInt(checkForNull(swabcount));
			if(allwdSwabCntsVal == 0)
				allwdSwabCntsVal = 3;
			// Added against PMG2017-MO-CRF-0001 [IN:063849]	
			/* if(swab_count == 0)	
				swab_count = 2; */
				
			cstmt=connection.prepareCall("{call OT_SWAB_INSTR_TEMPLATES(?,?,?,?,?,null,null,?)}");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, oper_num);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.execute();
			status = cstmt.getString(4);
			error_text = cstmt.getString(5);
			lang_error_text = cstmt.getString(6);
			templates = cstmt.getString(3);
			StringTokenizer strToken = new StringTokenizer(templates,"##");
			int starting_element = 0;
			while(strToken.hasMoreTokens())
			{
				template_id = strToken.nextToken().trim();
				if(starting_element > 0)
					append_templates = append_templates.append(",");
				append_templates = append_templates.append("'"+template_id.toUpperCase()+"' ");
				starting_element = 1;
			}
			if(starting_element == 0)
				append_str = append_str.append(" WHERE B.LANGUAGE_ID='"+locale+"' AND A.ITEM_CODE=B.ITEM_CODE ");
			else
			{
				append_str = append_str.append("WHERE B.LANGUAGE_ID='"+locale+"' AND TEMPLATE_ID IN (");
				append_str = append_str.append(append_templates);		
				append_str = append_str.append(") AND A.ITEM_CODE=B.ITEM_CODE ");
			}
			append_str = append_str.append("ORDER BY A.ITEM_SRL_NO");

			sql = "SELECT A.ITEM_CODE, B.DESCRIPTION,A.INITIAL_COUNT,TEMPLATE_ID FROM OT_SWAB_INSTR_TMPL_DTL A, OT_SWAB_INSTR_ITEMS_LANG_VW B "+append_str;
			//System.err.println("=====sql=====SwabCount===="+sql);
			pstmt = connection.prepareStatement(sql);
			resultset = pstmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(allwdSwabCntsVal == 3)
					{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

					}
					else
					{
						for(z=2; z<allwdSwabCntsVal; z++)
						{
							getKeyVal = ((String) headerMap.get(z)).split("~");

            _bw.write(_wl_block14Bytes, _wl_block14);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
            int __result__tag7 = 0 ;

            if (__tag7 == null ){
                __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
            }
            __tag7.setPageContext(pageContext);
            __tag7.setParent(null);
            __tag7.setKey(getKeyVal[0]
);
            __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag7;
            __result__tag7 = __tag7.doStartTag();

            if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag7);
                return;
            }
            _activeTag=__tag7.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
            __tag7.release();
            _bw.write(_wl_block15Bytes, _wl_block15);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
            int __result__tag8 = 0 ;

            if (__tag8 == null ){
                __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
            }
            __tag8.setPageContext(pageContext);
            __tag8.setParent(null);
            __tag8.setKey(getKeyVal[1]
);
            __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag8;
            __result__tag8 = __tag8.doStartTag();

            if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag8);
                return;
            }
            _activeTag=__tag8.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
            __tag8.release();
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						}
					}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 
					if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES"))
					{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

					}

            _bw.write(_wl_block18Bytes, _wl_block18);

				first_cnt_cmpl_yn = request.getParameter("first_cnt_cmpl_yn");
				first_cnt_disabled = first_cnt_cmpl_yn.equals("N") ? "" : "disabled";
				add_during_op_cmpl_yn = request.getParameter("add_during_op_cmpl_yn");
				during_op_disabled = first_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				during_op_disabled = add_during_op_cmpl_yn.equals("Y") ? "disabled" : during_op_disabled;

				second_cnt_cmpl_yn = request.getParameter("second_cnt_cmpl_yn");
				second_cnt_disabled = add_during_op_cmpl_yn.equals("N") ? "disabled" : "";
				second_cnt_disabled = second_cnt_cmpl_yn.equals("Y") ? "disabled" : second_cnt_disabled;
				add_aft_clcav_cmpl_yn = request.getParameter("add_aft_clcav_cmpl_yn");
				after_cavity_disabled	= second_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				after_cavity_disabled	= add_aft_clcav_cmpl_yn.equals("Y") ? "disabled" : after_cavity_disabled;
				// 2nd add complete --> add_aft_clcav_cmpl_yn
				valForFinalChkBox = add_aft_clcav_cmpl_yn;

				if(allwdSwabCntsVal > 3)
				{
					third_cnt_cmpl_yn = request.getParameter("third_cnt_cmpl_yn");
					third_cnt_disabled = add_aft_clcav_cmpl_yn.equals("N") ? "disabled" : "";
					third_cnt_disabled = third_cnt_cmpl_yn.equals("Y") ? "disabled" : third_cnt_disabled;
					additions_after_3c_cmpl_yn = request.getParameter("additions_after_3c_cmpl_yn");
					additions_after_3c_cmpl_yn_disabled = third_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_3c_cmpl_yn_disabled = additions_after_3c_cmpl_yn.equals("Y") ? "disabled" : additions_after_3c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_3c_cmpl_yn;
				}

				if(allwdSwabCntsVal > 4)
				{
					fourth_cnt_cmpl_yn = request.getParameter("fourth_cnt_cmpl_yn");
					fourth_cnt_disabled = additions_after_3c_cmpl_yn.equals("N") ? "disabled" : "";
					fourth_cnt_disabled = fourth_cnt_cmpl_yn.equals("Y") ? "disabled" : fourth_cnt_disabled;
					additions_after_4c_cmpl_yn = request.getParameter("additions_after_4c_cmpl_yn");
					additions_after_4c_cmpl_yn_disabled = fourth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_4c_cmpl_yn_disabled = additions_after_4c_cmpl_yn.equals("Y") ? "disabled" : additions_after_4c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_4c_cmpl_yn;
				}

				if(allwdSwabCntsVal > 5)
				{
					fifth_cnt_cmpl_yn = request.getParameter("fifth_cnt_cmpl_yn");
					fifth_cnt_disabled = additions_after_4c_cmpl_yn.equals("N") ? "disabled" : "";
					fifth_cnt_disabled = fifth_cnt_cmpl_yn.equals("Y") ? "disabled" : fifth_cnt_disabled;
					additions_after_5c_cmpl_yn = request.getParameter("additions_after_5c_cmpl_yn");
					additions_after_5c_cmpl_yn_disabled = fifth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_5c_cmpl_yn_disabled = additions_after_5c_cmpl_yn.equals("Y") ? "disabled" : additions_after_5c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_5c_cmpl_yn;
				}

				final_cnt_cmpl_yn = request.getParameter("final_cnt_cmpl_yn");
				final_cnt_disabled = valForFinalChkBox.equals("N") ? "disabled" : "";
				final_cnt_disabled = final_cnt_cmpl_yn.equals("Y") ? "disabled" : final_cnt_disabled;
				second_cnt_disabled = final_cnt_cmpl_yn.equals("Y") ? "disabled" : second_cnt_disabled; //Added for CRF-001
				if(first_cnt_disabled.equals(""))
					current_item = "first_cnt_cmpl_yn";
				else if(during_op_disabled.equals(""))
					current_item = "add_during_op_cmpl_yn";
				else if(second_cnt_disabled.equals(""))
					current_item = "second_cnt_cmpl_yn";
				else if(after_cavity_disabled.equals(""))
					current_item = "add_aft_clcav_cmpl_yn";

				while(resultset.next())
				{
					initial_count = "";
					db_initial_count = "";  
					total_count_during_op = "";
					total_additions_during_op = "";
					total_cavity_count = "";
					total_final_count  = "";
					total_second_val_count = "";

					thirdCountRemarksFlag = false;
					addtDuringThirdCountRemarksFlag = false;
					fourthCountRemarksFlag = false;
					addtDuringFourthCountRemarksFlag = false;
					fifthCountRemarksFlag = false;
					addtDuringFifthCountRemarksFlag = false;

					i++;
					if((i%2) == 1)
						classValue = "gridData";
					else
						classValue = "gridData";			
					item_code = checkForNull(resultset.getString("ITEM_CODE"));
					item_desc = checkForNull(resultset.getString("DESCRIPTION"));
					initial_count = checkForNull(resultset.getString("INITIAL_COUNT")); 
					Boolean flag1 = true;
					template_id = resultset.getString("TEMPLATE_ID");
					total_count_during_op = initial_count;

					sql = "SELECT  NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='Y' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'  AND NVL(FINAL_COUNT_YN,'N')='N'";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();

					while(resultset1.next())
					{
						db_initial_count = checkForNull(resultset1.getString(1));
						remarks_initial = checkForNull(resultset1.getString("REMARKS"));
						flag1 = false;
					}

					if(db_initial_count == null || db_initial_count.trim().length() == 0)
						db_initial_count = initial_count;
					db_initial_count = db_initial_count.equals("0") ? "" : db_initial_count;
					if(!flag1)
						initial_count = db_initial_count;
					total_count_during_op = initial_count;
					sql = "SELECT NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'OP')='OP' AND NVL(SECOND_COUNT_YN,'N') ='N'  AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
					if(pstmt != null)
						pstmt.close();
					if(resultset1 != null)
						resultset1.close();
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();
					while(resultset1.next())
					{
						if(("").equals(total_additions_during_op))
							total_additions_during_op = checkForNull(resultset1.getString(1));
						else
							total_additions_during_op = Integer.toString(Integer.parseInt(total_additions_during_op) + Integer.parseInt(resultset1.getString(1)));
						remarks_two = checkForNull(resultset1.getString("REMARKS"));
						if(remarks_two == null || remarks_two.trim().length() == 0)
							remarks_two = "";
					}

					if(total_additions_during_op == null || total_additions_during_op.trim().length() == 0 || total_additions_during_op.equals("0"))
						total_additions_during_op = "";

					if(!initial_count.equals("") && total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(initial_count))+"";
					if(initial_count.equals("") && !total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(total_additions_during_op))+"";
					if(!initial_count.equals("") && !total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(initial_count)+Integer.parseInt(total_additions_during_op))+"";

					if(pstmt != null)
						pstmt.close();		
					if(resultset1 != null)
						resultset1.close();
					sql = "SELECT NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'CL')='CL' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();
					while(resultset1.next())
					{
						if(("").equals(total_cavity_count))
							total_cavity_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						else
							total_cavity_count = Integer.toString(Integer.parseInt(total_cavity_count) + Integer.parseInt(resultset1.getString("TOTAL_COUNT")));
						remarks_one = checkForNull(resultset1.getString("REMARKS"));
					}
					if(remarks_one == null || remarks_one.trim().length() == 0)
						remarks_one = "";
					if(total_cavity_count == null || total_cavity_count.trim().length() == 0 || total_cavity_count.equals("0"))
						total_cavity_count = "";
					if(pstmt != null) 
						pstmt.close();		
					if(resultset1 != null) 
						resultset1.close();
					sql = "SELECT ITEM_VALUE TOTAL_COUNT,REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='Y' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N' ";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,oper_num);
					pstmt.setString(3,swab_serial_number);		
					pstmt.setString(4,template_id);
					pstmt.setString(5,item_code);
					resultset1=pstmt.executeQuery();
					while(resultset1.next())
					{
						total_second_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						second_count_remarks = checkForNull(resultset1.getString("REMARKS"));
					}
					if(total_second_count == null || total_second_count.trim().length() == 0)
						total_second_count = "";
					if(second_count_remarks == null || second_count_remarks.trim().length() == 0)
						second_count_remarks = "";
					if(second_count_remarks.length() > 0)
						second_count_remarks_yn="Y";
					else
						second_count_remarks_yn="N";

					String customer_id="";
					String sql1="Select customer_id from SM_SITE_PARAM where rownum = 1";
					pstmt1=connection.prepareStatement(sql1);
					rst1=pstmt1.executeQuery();
					if(rst1 !=null && rst1.next())
						customer_id=checkForNull(rst1.getString("customer_id"));
					if(rst1!=null)
						rst1.close();
					if(pstmt1!=null)
						pstmt1.close();
					if(customer_id.equalsIgnoreCase("MOHBR") && allwdSwabCntsVal == 3)
					{
						if(!total_cavity_count.equals("") && !total_count_during_op.equals(""))
							total_second_val_count = (Integer.parseInt(total_count_during_op) + Integer.parseInt(total_cavity_count)) + "";
						else
						{
							if(!total_count_during_op.equals("")) 
								total_second_val_count = total_count_during_op;
							else
								total_second_val_count = total_cavity_count; 
						}
					}
					else
					{
						if(!total_second_count.equals("") && !total_cavity_count.equals(""))
							total_second_val_count = (Integer.parseInt(total_second_count)+Integer.parseInt(total_cavity_count))+"";
						else
						{   
							if(!total_second_count.equals("")) 
								total_second_val_count = total_second_count;
							else
								total_second_val_count = total_cavity_count; 
						}
					}

					if(add_aft_clcav_cmpl_yn.equals("Y"))
					{
						if(pstmt!=null) 
							pstmt.close();		
						if(resultset1!=null) 
							resultset1.close();
						sql = "SELECT SUM(ITEM_VALUE) TOTAL_COUNT FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'CL')='CL'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
						pstmt=connection.prepareStatement(sql);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
						pstmt.setString(3,swab_serial_number);
						pstmt.setString(4,template_id);
						pstmt.setString(5,item_code);
						resultset1=pstmt.executeQuery();
						while(resultset1.next())
							add_after_cavity_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						if(add_after_cavity_count == null || add_after_cavity_count.trim().length() == 0 || add_after_cavity_count.equals("0"))
							add_after_cavity_count = "";
						if(pstmt!=null) 
							pstmt.close();		
						if(resultset1!=null) 
							resultset1.close();
					}
					valToChkForFinalCount = total_second_val_count;
					dataMap.put(2, "second_count_" + " ~ " + total_count_during_op + " ~ " + total_second_count + " ~ " + second_cnt_disabled + " ~ " + "item_after_close_cavity_" + " ~ " + add_after_cavity_count + " ~ " + after_cavity_disabled + " ~ " + add_aft_clcav_cmpl_yn + " ~ " + "total_cavity_count_" + " ~ " + total_second_val_count);

					if(allwdSwabCntsVal > 3)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) third_count, SUM (total_count1) addt_third_count,								");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_third_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (third_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '3C' THEN item_value ELSE 0 END total_count1					");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (third_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '3C' )								");
						sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'									");
						sqlBuffer.append(" AND NVL (final_count_yn, 'N') = 'N')");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							thirdCount = checkForNull(resultset1.getString("third_count")).equals("0") ? "" : checkForNull(resultset1.getString("third_count"));
							addDuringThirdCount = additions_after_3c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_third_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_third_count")));
							totalThirdCount = checkForNull(resultset1.getString("total_third_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_third_count"));
						}
						valToChkForFinalCount = totalThirdCount;
						dataMap.put(3, "third_count_" + " ~ " + total_second_val_count + " ~ " + thirdCount + " ~ " + third_cnt_disabled + " ~ " + "add_after_third_count_" + " ~ " + addDuringThirdCount + " ~ " + additions_after_3c_cmpl_yn_disabled + " ~ " + additions_after_3c_cmpl_yn + " ~ " + "total_third_count_" + " ~ " + totalThirdCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (third_count_yn, 'N') = 'Y' THEN remarks END third_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '3C' THEN remarks END add_third_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (third_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '3C' )								");
						sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'									");
						sqlBuffer.append(" AND NVL (final_count_yn, 'N') = 'N' ");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							thirdCountRemarks = checkForNull(resultset1.getString("third_count_remarks"));
							addtDuringThirdCountRemarks = checkForNull(resultset1.getString("add_third_count_remarks"));
							if(thirdCountRemarks.trim().length() > 0)
							{
								thirdCountRemarksFlag = true;
								thirdCountRemarksYn = "Y";
							}
							if(addtDuringThirdCountRemarks.trim().length() > 0)
								addtDuringThirdCountRemarksFlag = true;
							if(thirdCountRemarksFlag && addtDuringThirdCountRemarksFlag)
								break;
						}
						if(third_cnt_disabled.equals("")){
							current_item = "third_cnt_cmpl_yn"; 
						}	
						else if(additions_after_3c_cmpl_yn_disabled.equals("")){
							current_item = "additions_after_3c_cmpl_yn"; 
						}
						 else if(final_cnt_cmpl_yn.equals("Y")){
							additions_after_3c_cmpl_yn_disabled = "disabled"; 
						} 
						
					}

					if(allwdSwabCntsVal > 4)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) fourth_count, SUM (total_count1) addt_fourth_count,							");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_fourth_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (fourth_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '4C' THEN item_value ELSE 0 END total_count1					");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' 																							");
						sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (fourth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '4C' )							");
						sqlBuffer.append("	AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N')										");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fourthCount = checkForNull(resultset1.getString("fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("fourth_count"));
							addDuringFourthCount = additions_after_4c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_fourth_count")));
							totalFourthCount = checkForNull(resultset1.getString("total_fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_fourth_count"));
						}
						valToChkForFinalCount = totalFourthCount;
						dataMap.put(4, "fourth_count_" + " ~ " + totalThirdCount + " ~ " + fourthCount + " ~ " + fourth_cnt_disabled + " ~ " + "add_after_fourth_count_" + " ~ " + addDuringFourthCount + " ~ " + additions_after_4c_cmpl_yn_disabled + " ~ " + additions_after_4c_cmpl_yn + " ~ " + "total_fourth_count_" + " ~ " + totalFourthCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (fourth_count_yn, 'N') = 'Y' THEN remarks END fourth_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '4C' THEN remarks END add_fourth_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?					");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?											");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' 																								");
						sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N'										");
						sqlBuffer.append("	AND (NVL (fourth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '4C' )								");
						sqlBuffer.append("	AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'											");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fourthCountRemarks = checkForNull(resultset1.getString("fourth_count_remarks"));
							addtDuringFourthCountRemarks = checkForNull(resultset1.getString("add_fourth_count_remarks"));
							if(fourthCountRemarks.trim().length() > 0)
							{
								fourthCountRemarksFlag = true;
								fourthCountRemarksYn = "Y";
							}
							if(addtDuringFourthCountRemarks.trim().length() > 0)
								addtDuringFourthCountRemarksFlag = true;
							if(fourthCountRemarksFlag && addtDuringFourthCountRemarksFlag)
								break;
						}
						if(fourth_cnt_disabled.equals(""))
							current_item = "fourth_cnt_cmpl_yn";
						else if(additions_after_4c_cmpl_yn_disabled.equals(""))
							current_item = "additions_after_4c_cmpl_yn";
					}

					if(allwdSwabCntsVal > 5)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) fifth_count, SUM (total_count1) addt_fifth_count,								");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_fifth_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (fifth_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '5C' THEN item_value ELSE 0 END total_count1				");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?			");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?									");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND (NVL (fifth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '5C')								");
						sqlBuffer.append("	AND NVL (final_count_yn, 'N') = 'N')																					");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fifthCount = checkForNull(resultset1.getString("fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("fifth_count"));
							addDuringFifthCount = additions_after_5c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_fifth_count")));
							totalFifthCount = checkForNull(resultset1.getString("total_fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_fifth_count"));
						}
						valToChkForFinalCount = totalFifthCount;
						dataMap.put(5, "fifth_count_" + " ~ " + totalFourthCount + " ~ " + fifthCount + " ~ " + fifth_cnt_disabled + " ~ " + "add_after_fifth_count_" + " ~ " + addDuringFifthCount + " ~ " + additions_after_5c_cmpl_yn_disabled + " ~ " + additions_after_5c_cmpl_yn + " ~ " + "total_fifth_count_" + " ~ " + totalFifthCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null)
							pstmt.close();
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (fifth_count_yn, 'N') = 'Y' THEN remarks END fifth_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '5C' THEN remarks END add_fifth_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?					");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?											");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND (NVL (fifth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '5C'								");
						sqlBuffer.append("	AND NVL (final_count_yn, 'N') = 'N')																					");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fifthCountRemarks = checkForNull(resultset1.getString("fifth_count_remarks"));
							addtDuringFifthCountRemarks = checkForNull(resultset1.getString("add_fifth_count_remarks"));
							if(fifthCountRemarks.trim().length() > 0)
							{
								fifthCountRemarksFlag = true;
								fifthCountRemarksYn = "Y";
							}
							if(addtDuringFifthCountRemarks.trim().length() > 0)
								addtDuringFifthCountRemarksFlag = true;
							if(fifthCountRemarksFlag && addtDuringFifthCountRemarksFlag)
								break;
						}
						if(fifth_cnt_disabled.equals(""))
							current_item = "fifth_cnt_cmpl_yn";
						else if(additions_after_5c_cmpl_yn_disabled.equals(""))
							current_item = "additions_after_5c_cmpl_yn";
					}
					//System.err.println("764========final_cnt_disabled======="+final_cnt_disabled);	
					/* Commented against CRF-001
						if(final_cnt_disabled.equals("")){
						current_item = "final_cnt_cmpl_yn"; System.err.println("825,final_cnt_cmpl_yn==current_item==="+current_item);
					}	 */
					sql = "SELECT ITEM_VALUE TOTAL_COUNT ,REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='Y' ";
					if(pstmt!=null) 
						pstmt.close();		
					if(resultset1!=null)
						resultset1.close();
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1=pstmt.executeQuery();
					while(resultset1.next())
					{
						total_final_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						final_count_remarks = checkForNull(resultset1.getString("REMARKS"));
					}
					if(total_final_count == null || total_final_count.trim().length() == 0 || total_final_count.equals("0"))
						total_final_count = "";
						
					if(final_count_remarks == null || final_count_remarks.trim().length() == 0)
						final_count_remarks = "";
						
					if(final_count_remarks.length() > 0)
						final_count_remarks_yn = "Y";
					else
						final_count_remarks_yn = "N";						
						

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(second_count_remarks_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(thirdCountRemarksYn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fourthCountRemarksYn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fifthCountRemarksYn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(final_count_remarks_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(total_count_during_op));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(total_second_val_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(initial_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalThirdCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalFourthCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalFifthCount));
            _bw.write(_wl_block42Bytes, _wl_block42);

					if(add_during_op_cmpl_yn.equals("N"))
						total_additions_during_op = "";

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(initial_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(first_cnt_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(total_additions_during_op));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(during_op_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(total_count_during_op));
            _bw.write(_wl_block55Bytes, _wl_block55);

						if(allwdSwabCntsVal == 3)
						{
							//System.err.println("854===total_second_count==="+total_second_count);
							//System.err.println("855===total_count_during_op==="+total_count_during_op);
							if(total_second_count.equals("") || total_count_during_op.equals(total_second_count))
								condStr = "";
							else if(!(total_second_count.equals("") && total_count_during_op.equals(total_second_count)))
							{
								if(second_cnt_disabled.equals(""))
									condStr = "style=\"color:#FF0033\"";
								else
									condStr = "style=\"color:blue;font:bold;background-color:#FF0033\"";
							}
							//Added against start PMG2017-MO-CRF-0001 [IN:063849]
							if(final_cnt_cmpl_yn.equals("Y")){
							after_cavity_disabled="disabled";
							}
							//Added against end PMG2017-MO-CRF-0001 [IN:063849]

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(total_second_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(condStr));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(second_cnt_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(add_after_cavity_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(after_cavity_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(total_second_val_count));
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
					else
					{
						for(z=2; z<allwdSwabCntsVal; z++)
						{
							//System.err.println("=933====dataMap======="+dataMap);
							getDataMapKeyVal = ((String) dataMap.get(z)).split("~");
							getKeyVal = ((String) headerMap.get(z)).split("~");
							
							//System.err.println("937=====getKeyVal======="+getKeyVal);
							
							if(z == 2)
								valToChkColor = "OP";
							else
								valToChkColor = ((String) headerMap.get(z-1)).split("~")[2];								
								
							//System.err.println("945=====valToChkColor======="+valToChkColor);
							if(getDataMapKeyVal[2].trim().length() == 0 || getDataMapKeyVal[1].trim().equals(getDataMapKeyVal[2].trim()))
								condStr = "";
							else if(!(getDataMapKeyVal[2].trim().length() == 0 && getDataMapKeyVal[1].trim().equals(getDataMapKeyVal[2].trim())))
							{
								if(getDataMapKeyVal[3].trim().length() == 0)
									condStr = "style=\"color:#FF0033\"";
								else
									condStr = "style=\"color:blue;font:bold;background-color:#FF0033\"";
							}
						 // Added Against Start PMG2017-MO-CRF-0001 [IN:063849]
									if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[3]="disabled";								
										getDataMapKeyVal[6]="disabled";								
									}
						 // Added Against End PMG2017-MO-CRF-0001 [IN:063849]			
						

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(getDataMapKeyVal[0].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(getDataMapKeyVal[0].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(getDataMapKeyVal[2].trim()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(condStr));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(getDataMapKeyVal[3].trim()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(valToChkColor));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(getDataMapKeyVal[4].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(getDataMapKeyVal[4].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(getDataMapKeyVal[5].trim()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(getDataMapKeyVal[6].trim()));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)getKeyVal[2]));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(getDataMapKeyVal[8].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(getDataMapKeyVal[8].trim()));
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(getDataMapKeyVal[9].trim()));
            _bw.write(_wl_block77Bytes, _wl_block77);

						}
					}
					if(total_final_count.equals(""))
						finalCountStyle = "";					
					else if(!(total_final_count.equals("") && total_cavity_count.equals(total_final_count)))
					{
						if(final_cnt_disabled.equals("") )
						{
							if(!total_final_count.equals(valToChkForFinalCount))
								finalCountStyle = "style=\"color:#FF0033\"";
							else
								finalCountStyle = "";							
						}
						else 
						{
							//valToChkForFinalCount="1";//total_count_during_op
							//System.err.println("1005========total_count_during_op======="+total_count_during_op);		
							// Added against start PMG2017-MO-CRF-0001 [IN:063849] (added logic for allowed count 3)
							  if(valToChkForFinalCount =="" || valToChkForFinalCount==null){
								valToChkForFinalCount = total_count_during_op;
								//System.err.println("1009========valToChkForFinalCount======="+valToChkForFinalCount);		
							} 
							// Added logic allowed count 4 2nd cout logic		
							if(total_second_val_count !="" && total_second_val_count !=null){
										valToChkForFinalCount = total_second_val_count;
							//System.err.println("1010========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							} 
							// Added logic allowed count 4 third count logic		
							if(totalThirdCount !="" && totalThirdCount !=null){
										valToChkForFinalCount = totalThirdCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							// Added logic allowed count 5th fourth count logic
							if(totalFourthCount !="" && totalFourthCount !=null){
										valToChkForFinalCount = totalFourthCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							if(totalFifthCount !="" && totalFifthCount !=null){
										valToChkForFinalCount = totalFifthCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							// Added against end PMG2017-MO-CRF-0001 [IN:063849]
							if(!total_final_count.equals(valToChkForFinalCount) &&  final_cnt_cmpl_yn.equals("Y")){
								//System.err.println("1013========total_final_count======="+total_final_count);		
								//System.err.println("1014========valToChkForFinalCount======="+valToChkForFinalCount);		
								finalCountStyle = "style=\"color:blue;font:bold;background-color:#FF0033\"";
								//System.err.println("1016========finalCountStyle======="+finalCountStyle);		
								
							}	
							else {
								finalCountStyle = "";
								//System.err.println("1021========finalCountStyle======="+finalCountStyle);		
								}
						}
					}
				//	System.err.println("==========z========="+z);
					if(allwdSwabCntsVal == 3)
						valToChkColor = "CL";
					else
						valToChkColor = ((String) headerMap.get(z-1)).split("~")[2];
				
					/*added start PMG2017-MO-CRF-0001 [IN:063849]*/
					if(first_cnt_cmpl_yn.equals("Y") && add_during_op_cmpl_yn.equals("Y")){
						count++;
					}
					if(second_cnt_cmpl_yn.equals("Y") && add_aft_clcav_cmpl_yn.equals("Y")){
					count++;
					}	
					if(third_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					if(fourth_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					if(fifth_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					
					if(swab_count == 2 && count >= 1 &&  final_cnt_cmpl_yn.equals("N"))
					{
						final_cnt_disabled = "";
					}
					if(final_cnt_cmpl_yn.equals("Y")){
							after_cavity_disabled="disabled";
					}
					/*added end PMG2017-MO-CRF-0001 [IN:063849]*/
					

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(total_final_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(final_cnt_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(finalCountStyle));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(valToChkColor));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);

					if(remarks_initial.trim().length() > 0 || remarks_one.trim().length() > 0 || remarks_two.trim().length() > 0 || second_count_remarks.trim().length() > 0 || final_count_remarks.trim().length() > 0
						|| thirdCountRemarksFlag || addtDuringThirdCountRemarksFlag)
					{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

					}
					else
					{

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

					}
					if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES"))
					{
						if(final_cnt_cmpl_yn.equals("Y"))
						{

            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

						}
						else
						{

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

						}
					}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(template_id));
            _bw.write(_wl_block103Bytes, _wl_block103);

				}

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(swab_serial_number));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(current_item));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(allwdSwabCntsVal));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(count));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(swab_count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(total_count_during_op));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(total_second_val_count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(total_final_count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalThirdCount));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(totalFourthCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalFifthCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//System.err.println("530: Caught Exception in Swab Count"+e); 
			}
			finally
			{
				if(resultset!=null) resultset.close();
				if(resultset1!=null) resultset1.close();
				if(pstmt!=null) pstmt.close();
				if(cstmt!=null) cstmt.close();
				ConnectionManager.returnConnection(connection,request);
			}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Items.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InCount.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AdditionsduringOP.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TotalCount.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SecondCount.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AddnsafterCC.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TotalCount.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TotalCount.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FinalCount.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Addns.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Addns.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}

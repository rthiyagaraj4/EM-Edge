package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __manageworkscheduleresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleResult.jsp", 1709121638730L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link> -->\n<script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkSchedule.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eRS/js/RSMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onKeyDown=\"lockKey()\" onclick=\'hidePopup();\'>\n<form name=formManageWorkScheduleResult >\n<table border=\'1\'  align=\'left\' width=\"100%\" cellpadding=\'0\'>\n<!-- Posisiton wise details -->\n<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</tr>\n<tr id=\'posit";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><td  onclick=\'javascript:expanddetails(this,\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")\' align=\"center\" width=\'2%\' class=PositionTotal><a id=view";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  href=\'\' ><b>+</b></a></td>\n<td\tclass=\'PositionTotal\' align=left width=\'14%\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<td class=\'EmptyCell\' width=\"6%\" id=\'posit";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' align=\'center\' nowrap>&nbsp;</td>\n<input type=\'hidden\' name=\'positreq";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'positreq";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' value=\'\'>\n<input type=\'hidden\' name=\'positalloc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'positalloc";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' value=\'\'>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\"6%\" id=\'posit";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' align=\'center\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t\n<input type=\'hidden\' name=\'positreq";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'positalloc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</tr>\n\t<tr id=\'posit";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' style=\'display:none;\'>\n\t\t<td\tclass=\'PositionShiftTotal\' align=\'left\' colspan=\'2\' width=\'16%\'nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" - ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positshift";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'positshiftreq";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'positshiftalloc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\"6%\" id=\'positshift";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\t\n\t\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positshift";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t<td\tclass=\'PositionShiftTotal\' align=\'left\' colspan=\'2\' width=\'16%\'nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'positoncallreq";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'positoncallalloc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffid";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'staffid";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'roletype";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'roletype";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\"6%\" onclick=\'showPopup(\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\", \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\",\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\",\"\",\"\",\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\", this);\' id=\'staff";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'staffshift";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'staffshiftcode";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\", \"\",\"\", \"\",\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' value=\'\'>\n\t\t\t\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t\t<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\", \"\",\"\", \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t\t\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' style=\'display:none;\'>\n\t\t\t\t\t<td\tclass=\'PositionShiftTotal\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t\t\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n<td class=\'EmptyCell\'  width=\"6%\" id=\'posit";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' align=\'center\' nowrap>&nbsp;\n</td>\n<input type=\'hidden\' name=\'positreq";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' value=\'\'>\n\t\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n<input type=\'hidden\' name=\'positreq";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' value=\'\'>\n\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' style=\'display:none;\'>\n<td\tclass=\'PositionShiftTotal\'  align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t<td class=\'EmptyCell\' width=\"6%\" id=\'positshift";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\t\n<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positshift";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'positshiftalloc";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' style=\'display:none;\'>\n\t\t\t\t<td\tclass=\'PositionShiftTotal\' align=\'left\' colspan=\'2\' width=\'16%\'nowrap>Oncall&nbsp;Shift\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\t\n\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="&nbsp;</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\t\n\t\t\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' style=\'display:none;\'>\n\t\t\t\t<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'staffid";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'roletype";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t<td class=\'StaffList\' width=\"6%\" onclick=\'showPopup(\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\",this);\' id=\'staff";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\",  \"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' style=\'display:none;\'>\n\t<td\tclass=\'PositionShiftTotal\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td> \t\n<input type=\'hidden\' name=\'positshiftreq";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' style=\'display:none;\'>\n<td\tclass=\'PositionShiftTotal\' align=\'left\' colspan=\'2\' width=\'16%\'nowrap>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' align=\'center\' nowrap>&nbsp;\n\t\t</td>\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\t\n<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="&nbsp;</td>\n\t\t\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t<td class=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\t\n\t<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n<td class=\'EmptyCell\' width=\"6%\" id=\'positoncall";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' align=\'center\' nowrap>&nbsp;</td>\n<input type=\'hidden\' name=\'positoncallreq";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' value=\'\'>\n<input type=\'hidden\' name=\'positoncallalloc";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' style=\'display:none;\'>\n<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\'  nowrap>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' \n\t\talign=\'center\' nowrap>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\", \"\", \"\", \"\",\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</td>\n\t\t\t<input type=\'hidden\' name=\'staffshift";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t</tr>\n\t\t<tr id=\'posit";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' style=\'display:none;\'>\n\t\t\t<td\tclass=\'StaffList\' align=left colspan=\'2\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td> \n";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name =\'staffshiftcode";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t<input type=\'hidden\' name=\'staffshiftcode";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n</tr>\n<!-- /*********************/ -->\n<div id=\"manage_menu\" onmouseover=\"over()\" onMouseout=\"out()\" onclick=\'showWindow();\'>\n<div id=\'alloc\' class=\"manage_menuitem\" value=\'A\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</div>\n<div id=\'change\' class=\"manage_menuitem\" value=\'CH\'>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</div>\n<div id=\'swap\' class=\"manage_menuitem\" value=\'S\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</div>\n<div id=\'transfer\' class=\"manage_menuitem\" value=\'T\'>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</div>\n<div id=\'ot\' class=\"manage_menuitem\" value=\'O\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</div>\n<div id=\'leave\' class=\"manage_menuitem\" value=\'L\'>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</div>\n<div id=\'cancel\' class=\"manage_menuitem\" value=\'CL\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</div>\n<div id=\'cancelleave\' class=\"manage_menuitem\" value=\'CnlL\'>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</div>\n<div id=\'view_sched\' class=\"manage_menuitem\" value=\'VS\' >";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</div>\n</div>\n\n</table>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n<input type=\'hidden\' name=\'view\' id=\'view\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\n</form>\n\n</body>\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n</html>\n\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

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
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSheduleResult.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004		
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");

String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
String view				=request.getParameter("view")==null?"":request.getParameter("view");
String from_date				=request.getParameter("new_from_date")==null?"":request.getParameter("new_from_date");
String to_date				=request.getParameter("new_to_date")==null?"":request.getParameter("new_to_date");
String productive_flag	=	request.getParameter("productive_flag")==null?"W":request.getParameter("productive_flag");
int DAYS=Integer.parseInt(request.getParameter("DAYS")==null?"0":request.getParameter("DAYS"));

//String leaveIcon ="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>" ;
String leaveIcon ="&nbsp;" ;
String classval="";
Connection con 		= null;
PreparedStatement pstmt_PositionTotal	= null;
PreparedStatement pstmt_PositionShiftTotal 		= null;
PreparedStatement pstmt_PositionOncallTotal 		= null;
PreparedStatement pstmt_StaffList 		= null;
PreparedStatement pstmt_StaffLeaveList 		= null;

ResultSet rs_PositionTotal	= null;
ResultSet rs_PositionShiftTotal	= null;
ResultSet rs_PositionOncallTotal	= null;
ResultSet rs_StaffList 		= null;
ResultSet rs_StaffLeaveList 		= null;

ArrayList StaffList		= new ArrayList() ;
ArrayList PositionShiftTotal		= new ArrayList() ;
ArrayList PositionOncallTotal		= new ArrayList() ;
ArrayList PositionTotal		= new ArrayList() ;
ArrayList StaffLeaveDays	 =	 new ArrayList();

HashMap Staff_Leave_Dtl		=	new HashMap();

int posit_req=0, posit_alloc=0, posit_cellno=0, posit_day=0,shift_day=0;
int shift_req=0, shift_alloc=0, shift_cellno=0, shift_count=0,j=0;
int staff_day=0, staff_count=0, staff_cellno=0, k=0,prev_cell=0;
int day=0;
int oncall_cellno=0, oncall_day=0, oncall_count=0, oncall_req=0, oncall_alloc=0; 

String[] record			 = null;
//String[] position_record = null;
String[] shift_record	 = null;
String[] oncall_record	 = null;
String[] staff_record	 =	null;
//String[] staff_leave_record=null;

String posit_code="", posit_desc="", prev_posit="", schedule_date="";
String posit_code1="",shift_code="", shift_desc="", shift_mnemonic="", prev_shift="";
String role_type2="", posit_code2="", staff_id2="", prev_role="", prev_staff="", shift_code2="", shift_mnemonic2="", schedule_date2="", prev_sched_date="", prev_shift2="", prev_mnemonic2="";
String staff_type2="", prev_staff_type="", staff_workplace="",prev_workplace="", staff_name="";
String onposit_code="",oncall_code="";

String sql_StaffList="";
String sql_PositionTotal="";
String sql_PositionShiftTotal="";
String sql_PositionOncallTotal="";
String sql_StaffLeaveList="";
boolean flag=false, wrk_flag=false;

con = ConnectionManager.getConnection(request);
try {

//sql_PositionTotal="select a.position_code, b.position_desc, sum(a.required_staff) required, sum(a.allocated_staff) allocated, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no from rs_work_schedule_summ a, am_position b, am_shift c where 	a.facility_id = ? and a.workplace_code = ? and a.schedule_date between to_date(?,'dd/mm/yyyy')	and to_date(?,'dd/mm/yyyy') and 	(? is null or a.position_code = ?) and a.position_code=b.position_code and a.shift_code=c.shift_code and c.shift_indicator='P' and c.productive_flag='W' group by a.position_code, b.position_desc, a.schedule_date order by a.position_code";

sql_PositionTotal="select a.position_code, b.position_desc, sum(a.required_staff) required, sum(a.allocated_staff) allocated, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no from rs_work_schedule_summ a, am_position_lang_vw b, am_shift c where  a.facility_id = ? and a.workplace_code = ? and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and  (? is null or a.position_code = ?) and a.position_code=b.position_code and a.shift_code=c.shift_code and c.shift_indicator='P' and c.productive_flag='W' and b.language_id = ? group by a.position_code, b.position_desc, a.schedule_date order by a.position_code";

//sql_PositionShiftTotal="SELECT   a.position_code, a.shift_code, a.shift_mnemonic, b.long_desc, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (  TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b  WHERE a.facility_id = ? AND a.workplace_code =? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'W' GROUP BY a.position_code, a.shift_code, b.long_desc, a.shift_mnemonic, a.schedule_date ORDER BY a.position_code, b.long_desc, a.schedule_date";
sql_PositionShiftTotal="SELECT   a.position_code, a.shift_code, a.shift_mnemonic, b.long_desc, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (  TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift_lang_vw b  WHERE a.facility_id = ? AND a.workplace_code =? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'W' and b.language_id = ? GROUP BY a.position_code, a.shift_code, b.long_desc, a.shift_mnemonic, a.schedule_date ORDER BY a.position_code, b.long_desc, a.schedule_date";

sql_PositionOncallTotal="SELECT   a.position_code, 'OOOOO' shift_code, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'O' GROUP BY a.position_code,         a.schedule_date ORDER BY position_code, cell_no";

sql_StaffList="select	a.position_code, a.role_type, a.staff_id, c.staff_name, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date,	a.shift_code, a.shift_mnemonic, to_date(a.schedule_date)-to_date(?,'dd/mm/yyyy') staff_cellno, a.staff_type, a.workplace_code, b.shift_indicator, b.productive_flag  from rs_work_Schedule a, am_shift b, am_staff_vw c where (a.role_type,a.staff_id) in (select role_type,staff_id from rs_staff_for_workplace where facility_id = ? and workplace_code = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) 	and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and	a.facility_id = ? and ( ? is null or a.role_type = ?) and ( ? is null or a.position_code = ?) 	and (? is null or a.staff_id = ?) and b.shift_code = a.shift_code and a.role_type=c.role_type and a.staff_id=c.staff_id  AND c.language_id = ? UNION ALL select b.position_code,a.role_type,a.staff_id, b.staff_name, to_char(null,'dd/mm/yyyy') schedule_date, to_char(null) shift_code, to_char(null) shift_mnemonic, to_number(null) cell_no, b.staff_type, a.workplace_code, to_char(null) shift_indicator, to_char(null) productive_flag from rs_staff_for_workplace a, am_staff_vw b where a.facility_id = ? and a.workplace_code = ? and to_date(?,'dd/mm/yyyy') between a.eff_date_from and nvl(a.eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and to_date(?,'dd/mm/yyyy') between a.eff_date_from and nvl(a.eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and (a.role_type,a.staff_id) not in (select role_type,staff_id from rs_work_schedule where facility_id = ? and workplace_code = ? and schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ) and b.role_type = a.role_type and b.staff_id = a.staff_id	and b.position_code in (select position_code from rs_work_schedule_summ where facility_id = ? AND workplace_code = ? AND schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy') ) and ( ? is null or a.role_type = ?) and (? is null or a.staff_id = ?) and (? is null or b.position_code=?) and  B.LANGUAGE_ID = ? order by 1,2,4,8";

sql_StaffLeaveList="select role_type, staff_id, leave_date - to_date(?,'dd/mm/yyyy') staff_leave_cellno from rs_staff_unavailability_log where leave_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy')  and (role_type,staff_id) in (select role_type,staff_id from rs_staff_for_workplace where facility_id = ? and workplace_code = ?) and cancel_reason_code IS NULL order by role_type,staff_id, staff_leave_cellno";


//to get the Position Wise Total
pstmt_PositionTotal=con.prepareStatement(sql_PositionTotal);
pstmt_PositionTotal.setString(1,from_date);
pstmt_PositionTotal.setString(2,facility_id);
pstmt_PositionTotal.setString(3,workplace_code);
pstmt_PositionTotal.setString(4,from_date);
pstmt_PositionTotal.setString(5,to_date);
pstmt_PositionTotal.setString(6,position_code);
pstmt_PositionTotal.setString(7,position_code);
pstmt_PositionTotal.setString(8,locale);

rs_PositionTotal=pstmt_PositionTotal.executeQuery();

while((rs_PositionTotal !=null)&&(rs_PositionTotal.next()))
{
record=new String[6];
record[0]=rs_PositionTotal.getString("position_code");
record[1]=rs_PositionTotal.getString("position_desc");
record[2]=rs_PositionTotal.getString("required");
record[3]=rs_PositionTotal.getString("allocated");
record[4]=rs_PositionTotal.getString("schedule_date");
record[5]=rs_PositionTotal.getString("cell_no");
PositionTotal.add(record);
}

if(pstmt_PositionTotal != null)
pstmt_PositionTotal.close();
if(rs_PositionTotal != null)
rs_PositionTotal.close();

//to get the Position Wise Shift Wise Total
pstmt_PositionShiftTotal=con.prepareStatement(sql_PositionShiftTotal);
pstmt_PositionShiftTotal.setString(1,from_date);
pstmt_PositionShiftTotal.setString(2,facility_id);
pstmt_PositionShiftTotal.setString(3,workplace_code);
pstmt_PositionShiftTotal.setString(4,from_date);
pstmt_PositionShiftTotal.setString(5,to_date);
pstmt_PositionShiftTotal.setString(6,position_code);
pstmt_PositionShiftTotal.setString(7,position_code);
pstmt_PositionShiftTotal.setString(8,locale);

rs_PositionShiftTotal=pstmt_PositionShiftTotal.executeQuery();
while((rs_PositionShiftTotal !=null)&&(rs_PositionShiftTotal.next()))
{
record=new String[8];
record[0]=rs_PositionShiftTotal.getString("position_code");
record[1]=rs_PositionShiftTotal.getString("shift_code");
record[2]=rs_PositionShiftTotal.getString("shift_mnemonic");
record[3]=rs_PositionShiftTotal.getString("long_desc");
record[4]=rs_PositionShiftTotal.getString("required");
record[5]=rs_PositionShiftTotal.getString("allocated");
record[6]=rs_PositionShiftTotal.getString("schedule_date");
record[7]=rs_PositionShiftTotal.getString("cell_no");
PositionShiftTotal.add(record);
}
if(pstmt_PositionShiftTotal != null)
pstmt_PositionShiftTotal.close();
if(rs_PositionShiftTotal != null)
rs_PositionShiftTotal.close();

//to get the Position Wise Shift Wise Total
pstmt_PositionOncallTotal=con.prepareStatement(sql_PositionOncallTotal);
pstmt_PositionOncallTotal.setString(1,from_date);
pstmt_PositionOncallTotal.setString(2,facility_id);
pstmt_PositionOncallTotal.setString(3,workplace_code);
pstmt_PositionOncallTotal.setString(4,from_date);
pstmt_PositionOncallTotal.setString(5,to_date);
pstmt_PositionOncallTotal.setString(6,position_code);
pstmt_PositionOncallTotal.setString(7,position_code);

rs_PositionOncallTotal=pstmt_PositionOncallTotal.executeQuery();

while((rs_PositionOncallTotal !=null)&&(rs_PositionOncallTotal.next())){
record=new String[6];
record[0]=rs_PositionOncallTotal.getString("position_code");
record[1]=rs_PositionOncallTotal.getString("shift_code");
record[2]=rs_PositionOncallTotal.getString("required");
record[3]=rs_PositionOncallTotal.getString("allocated");
record[4]=rs_PositionOncallTotal.getString("schedule_date");
record[5]=rs_PositionOncallTotal.getString("cell_no");

PositionOncallTotal.add(record);
}
if(pstmt_PositionOncallTotal != null)
pstmt_PositionOncallTotal.close();
if(rs_PositionOncallTotal != null)
rs_PositionOncallTotal.close();


//to get the Position Wise Shift Wise Staff List
pstmt_StaffList=con.prepareStatement(sql_StaffList);
pstmt_StaffList.setString(1,from_date);
pstmt_StaffList.setString(2,facility_id);
pstmt_StaffList.setString(3,workplace_code);
pstmt_StaffList.setString(4,from_date);
pstmt_StaffList.setString(5,to_date);
pstmt_StaffList.setString(6,from_date);
pstmt_StaffList.setString(7,to_date);
pstmt_StaffList.setString(8,facility_id);
pstmt_StaffList.setString(9,role_type);
pstmt_StaffList.setString(10,role_type);
pstmt_StaffList.setString(11,position_code);
pstmt_StaffList.setString(12,position_code);
pstmt_StaffList.setString(13,staff_id);
pstmt_StaffList.setString(14,staff_id);
pstmt_StaffList.setString(15,locale);
pstmt_StaffList.setString(16,facility_id);
pstmt_StaffList.setString(17,workplace_code);
pstmt_StaffList.setString(18,from_date);
pstmt_StaffList.setString(19,to_date);
pstmt_StaffList.setString(20,facility_id);
pstmt_StaffList.setString(21,workplace_code);
pstmt_StaffList.setString(22,from_date);
pstmt_StaffList.setString(23,to_date);
pstmt_StaffList.setString(24,facility_id);
pstmt_StaffList.setString(25,workplace_code);
pstmt_StaffList.setString(26,from_date);
pstmt_StaffList.setString(27,to_date);
pstmt_StaffList.setString(28,role_type);
pstmt_StaffList.setString(29,role_type);
pstmt_StaffList.setString(30,staff_id);
pstmt_StaffList.setString(31,staff_id);
pstmt_StaffList.setString(32,position_code);
pstmt_StaffList.setString(33,position_code);
pstmt_StaffList.setString(34,locale);

 
rs_StaffList=pstmt_StaffList.executeQuery();
while((rs_StaffList !=null)&&(rs_StaffList.next())){
record=new String[12];
record[0]=rs_StaffList.getString("role_type")==null?"":rs_StaffList.getString("role_type");
record[1]=rs_StaffList.getString("position_code")==null?"":rs_StaffList.getString("position_code");
record[2]=rs_StaffList.getString("staff_id")==null?"":rs_StaffList.getString("staff_id");
record[3]=rs_StaffList.getString("schedule_date")==null?"":rs_StaffList.getString("schedule_date");
record[4]=rs_StaffList.getString("shift_code")==null?"":rs_StaffList.getString("shift_code");
record[5]=rs_StaffList.getString("shift_mnemonic")==null?"":rs_StaffList.getString("shift_mnemonic");
record[6]=rs_StaffList.getString("staff_cellno")==null?"0":rs_StaffList.getString("staff_cellno");
record[7]=rs_StaffList.getString("staff_type")==null?"":rs_StaffList.getString("staff_type");
record[8]=rs_StaffList.getString("workplace_code")==null?"":rs_StaffList.getString("workplace_code");
record[9]=rs_StaffList.getString("shift_indicator")==null?"":rs_StaffList.getString("shift_indicator");
record[10]=rs_StaffList.getString("productive_flag")==null?"":rs_StaffList.getString("productive_flag");
record[11]=rs_StaffList.getString("staff_name")==null?"":rs_StaffList.getString("staff_name");
StaffList.add(record);
}
if(pstmt_StaffList != null)
pstmt_StaffList.close();
if(rs_StaffList != null)
rs_StaffList.close();

pstmt_StaffLeaveList=con.prepareStatement(sql_StaffLeaveList);
pstmt_StaffLeaveList.setString(1,from_date);
pstmt_StaffLeaveList.setString(2,from_date);
pstmt_StaffLeaveList.setString(3,to_date);
pstmt_StaffLeaveList.setString(4,facility_id);
pstmt_StaffLeaveList.setString(5,workplace_code);

rs_StaffLeaveList=pstmt_StaffLeaveList.executeQuery();
String key="";
while((rs_StaffLeaveList !=null)&&(rs_StaffLeaveList.next())){
String Lstaff_id	 =	 rs_StaffLeaveList.getString("staff_id")==null?"":rs_StaffLeaveList.getString("staff_id");
String Lrole_type	=rs_StaffLeaveList.getString("role_type")==null?"":rs_StaffLeaveList.getString("role_type");
String Lcellno = rs_StaffLeaveList.getString("staff_leave_cellno")==null?"0":rs_StaffLeaveList.getString("staff_leave_cellno");
String key1=Lrole_type+Lstaff_id;


if(!(key.equals(key1)||(key.equals("")))){
Staff_Leave_Dtl.put(key, StaffLeaveDays);
StaffLeaveDays=new ArrayList();
}
StaffLeaveDays.add(Lcellno);
key=Lrole_type+Lstaff_id;
}
Staff_Leave_Dtl.put(key, StaffLeaveDays);

if(pstmt_StaffLeaveList != null)
pstmt_StaffLeaveList.close();
if(rs_StaffLeaveList != null)
rs_StaffLeaveList.close();	

            _bw.write(_wl_block8Bytes, _wl_block8);

if(PositionTotal.size() > 0){
record=(String[])PositionTotal.get(0);
posit_code	=	record[0];			
posit_desc	=	record[1];
posit_req	=	Integer.parseInt(record[2]==null?"0":record[2]);
posit_alloc	=	Integer.parseInt(record[3]==null?"0":record[3]);
schedule_date	=	record[4];
posit_cellno	=	Integer.parseInt(record[5]);

if(posit_alloc > posit_req)
classval	=	"ABOVEOPTIMAL";
if(posit_alloc < posit_req)
classval	=	"BELOWOPTIMAL";
if(posit_alloc == posit_req)
classval	=	"OPTIMAL";
if((posit_alloc == 0)&&(posit_req == 0))
classval	=	"EmptyCell";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(posit_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

if(posit_cellno > posit_day){//condition to check the first schedule date > from_date
for(day=posit_day; day<posit_cellno;day++){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

}
posit_day=posit_cellno;
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(posit_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(posit_req));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posit_req));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posit_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
posit_day++;
prev_posit				=	posit_code;

for(int i=1;i<PositionTotal.size();i++){
//continue with the next position total
record=(String[])PositionTotal.get(i);
posit_code	=	record[0];			
posit_desc	=	record[1];
posit_req	=	Integer.parseInt(record[2]==null?"0":record[2]);
posit_alloc	=	Integer.parseInt(record[3]==null?"0":record[3]);
schedule_date	=	record[4];
posit_cellno	=	Integer.parseInt(record[5]);

//check for next position
if(!prev_posit.equals(posit_code)){
for(day=posit_day;day<DAYS;day++){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
}
//********************to display the shift total***********************\\
if(PositionShiftTotal.size() >shift_count) {

shift_record=(String[])PositionShiftTotal.get(shift_count++);

posit_code1	=	shift_record[0];	
shift_code	=shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
shift_day=0;

if(shift_alloc > shift_req)
	classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
	classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
	classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
	classval	=	"EmptyCell";

if(prev_posit.equals(posit_code1)){ 
	//check for same position in both 

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(posit_code1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block31Bytes, _wl_block31);

		if(shift_cellno > shift_day){
			//check for the first schedule date > from date
			for(day=shift_day; day<shift_cellno;day++){

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
			}
			shift_day=shift_cellno;
			
		}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

		shift_day++;
		prev_shift=shift_code;

		for(j=shift_count;j<PositionShiftTotal.size();j++)	{
		//continue with the shift data
			shift_record=(String[])PositionShiftTotal.get(j);
			posit_code1	=	shift_record[0];	
			shift_code	=	shift_record[1];
			shift_mnemonic=shift_record[2];
			shift_desc	=	shift_record[3];
			shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
			shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
			shift_cellno	=	Integer.parseInt(shift_record[7]);

			//check for next shift in the same position 
			if((!shift_code.equals(prev_shift))||(!posit_code1.equals(prev_posit))){
				//check for the same position in both
				for(day=shift_day;day<DAYS;day++){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				shift_count=j;
				shift_day=0;

//********************to display the ONCALL shift total***********************\\
				if(!posit_code1.equals(prev_posit)){
					if(PositionOncallTotal.size() >oncall_count){

						oncall_record=(String[])PositionOncallTotal.get(oncall_count++);
						onposit_code	=	oncall_record[0];	
						oncall_code	=oncall_record[1];
						oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
						oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
						oncall_cellno	=	Integer.parseInt(oncall_record[5]);
						oncall_day=0;

						if(oncall_alloc > oncall_req)
							classval	=	"ABOVEOPTIMAL";
						if(oncall_alloc < oncall_req)
							classval	=	"BELOWOPTIMAL";
						if(oncall_alloc == oncall_req)
							classval	=	"OPTIMAL";
						if((oncall_alloc == 0)&&(oncall_req == 0))
							classval	=	"EmptyCell";

						if(prev_posit.equals(onposit_code)){ 
							//check for same position in both 

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(onposit_code));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
	
								if(oncall_cellno > oncall_day){
									//check for the first schedule date > from date
									for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}
									oncall_day=oncall_cellno;
							  }

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

								oncall_day++;
								for(k=oncall_count;k<PositionOncallTotal.size();k++){
								//continue with the shift data
									oncall_record=(String[])PositionOncallTotal.get(k);
									onposit_code	=	oncall_record[0];	
									oncall_code	=oncall_record[1];
									oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
									oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
									oncall_cellno	=	Integer.parseInt(oncall_record[5]);

									//check for next shift in the same position 
									if(!(onposit_code.equals(prev_posit))){
									//check for the same position in both
										for(day=oncall_day;day<DAYS;day++){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}
									oncall_count=k;
									oncall_day=0;
									break;
								}
								if(oncall_cellno > oncall_day){
								//check for the first schedule date > from date
									for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}
									oncall_day=oncall_cellno;
								}
								if(oncall_alloc > oncall_req)
									classval	=	"ABOVEOPTIMAL";
								if(oncall_alloc < oncall_req)
									classval	=	"BELOWOPTIMAL";
								if(oncall_alloc == oncall_req)
									classval	=	"OPTIMAL";
								if((oncall_alloc == 0)&&(oncall_req == 0))
									classval	=	"EmptyCell";

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
								oncall_day++;
							}
						}
						else
							oncall_count--;
					 }

//**********Staff List ******************/
					if(StaffList.size() > staff_count){

						staff_record=(String[])StaffList.get(staff_count++);
						
						role_type2	= staff_record[0];
						posit_code2	=	staff_record[1];	
						staff_id2			=	staff_record[2];
						schedule_date2	=	staff_record[3];
						shift_code2	=staff_record[4];
						shift_mnemonic2=staff_record[5];
						staff_cellno	=	Integer.parseInt(staff_record[6]);
						staff_type2	=	staff_record[7];
						staff_workplace	=	staff_record[8];
						staff_name	=	staff_record[11];
						staff_day=0;
						classval="StaffList";
						key	=	role_type2+staff_id2;
                       
						if(prev_posit.equals(posit_code2)){ 
						//check for same position in both 
							if(Staff_Leave_Dtl.containsKey(key))
								StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
							else
								StaffLeaveDays	=	new ArrayList();

							if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
								classval="StaffOtherWP";
								wrk_flag=true;
							}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block62Bytes, _wl_block62);

							if((staff_cellno-1) > staff_day){
							   //check for the first schedule date > from date
								for(day=staff_day; day<staff_cellno-1;day++){
									if(StaffLeaveDays.contains(String.valueOf(day))){
										classval = "LeaveStaff";
										prev_mnemonic2="";
										leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
									}
									else
									{
										classval	=	"StaffList";
										leaveIcon=prev_mnemonic2;
									}

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
								staff_day=staff_cellno-1;
							}
							if(staff_workplace.equals(workplace_code)){
								if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
									if(prev_shift2.equals("")){
											prev_shift2		=	shift_code2;
											prev_mnemonic2	=	shift_mnemonic2;
									}
									else{
											prev_shift2=	prev_shift2+"|"+shift_code2;
											prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
									}
								}
								else{
										wrk_flag=false;						
										prev_shift2=shift_code2;
										prev_mnemonic2=shift_mnemonic2;
										prev_sched_date	= schedule_date2;
								}
							}
							prev_staff	=	staff_id2;
							prev_role	=	role_type2;
							prev_cell	 =	 staff_cellno;
							prev_workplace=staff_workplace;
							prev_sched_date	= schedule_date2;

							for(k=staff_count;k<StaffList.size();k++){ //continue with the shift data

								staff_record=(String[])StaffList.get(k);

								role_type2	= staff_record[0];
								posit_code2	=	staff_record[1];	
								staff_id2			=	staff_record[2];
								schedule_date2	=	staff_record[3];
								shift_code2	=staff_record[4];
								shift_mnemonic2=staff_record[5];
								staff_cellno	=	Integer.parseInt(staff_record[6]);
								staff_type2	=	staff_record[7];
								staff_workplace	=	staff_record[8];
								staff_name	=	staff_record[11];

								//check for next staff in the same position 
								if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
									//check for the same position in both
									if(prev_cell > staff_day){
										for(day=staff_day; day<(prev_cell);day++){
											if(StaffLeaveDays.contains(String.valueOf(day))){
												classval = "LeaveStaff";
												prev_mnemonic2="";
												leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
											}
											else
											{
												classval	=	"StaffList";
												leaveIcon =prev_mnemonic2;
												if(leaveIcon=="")
												leaveIcon ="&nbsp;" ;
												
											}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block77Bytes, _wl_block77);
	
										}
										staff_day=prev_cell;
									}

									for(day=staff_day;day<DAYS;day++){
										if(StaffLeaveDays.contains(String.valueOf(day))){
											classval = "LeaveStaff";
											prev_mnemonic2="";
										
											leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
    ; 
											
										}
										else{
											if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
												classval="StaffOtherWP";
												wrk_flag=true;
												leaveIcon=prev_mnemonic2;
												}
												leaveIcon=prev_mnemonic2;
													if(leaveIcon=="")
													leaveIcon ="&nbsp;" ;
										}

										if(prev_mnemonic2.equals(""))
										{
											 prev_mnemonic2="&nbsp;";
											
											 
											
										}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);

										prev_shift2="";
										prev_mnemonic2="&nbsp;";
										classval	=	"StaffList";
									}
									wrk_flag=false;
									staff_day=day;
									staff_count=k;
									if(!posit_code2.equals(prev_posit)){
										flag=true;
										prev_mnemonic2="";
										prev_shift2="";
										break ;
									}
									prev_staff	=	staff_id2;
									prev_role	=	role_type2;
									prev_staff_type	=	staff_type2;
									prev_sched_date	= schedule_date2;
									prev_cell	 =	 staff_cellno;
									prev_workplace	=	staff_workplace;
									prev_mnemonic2="";
									prev_shift2="";
									staff_day=0;
									key=role_type2+staff_id2;

									if(Staff_Leave_Dtl.containsKey(key))
										StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
									else
										StaffLeaveDays	=	new ArrayList();

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block31Bytes, _wl_block31);

								}	
								else
									staff_count--;

								if(prev_cell > staff_day){
									for(day=staff_day; day<(prev_cell);day++)	{
										if(StaffLeaveDays.contains(String.valueOf(day))){
												classval = "LeaveStaff";
												prev_mnemonic2="";
												leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
										}
										else
										{
												classval	=	"StaffList";
												leaveIcon	=	prev_mnemonic2;
												if(leaveIcon=="")
												leaveIcon ="&nbsp;" ;
										}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
									}
									staff_day=prev_cell;
									classval	=	"StaffList";
									wrk_flag=false;
								}
								if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
									if(staff_workplace.equals(workplace_code)){
										if(prev_shift2.equals("")){
											prev_shift2		=	shift_code2;
											prev_mnemonic2	=	shift_mnemonic2;
										}
										else{
													prev_shift2=	prev_shift2+"|"+shift_code2;
													prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
										}
									}
									if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
									}
								}
								else{
									if(prev_mnemonic2.equals(""))
										prev_mnemonic2="&nbsp;";
									if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
									}

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block86Bytes, _wl_block86);
	
									if(staff_workplace.equals(workplace_code)){
										prev_shift2		=	shift_code2;
										prev_mnemonic2	=	shift_mnemonic2;
										prev_sched_date	= schedule_date2;
									}
									else{
										prev_shift2		=	"";
										prev_mnemonic2	=	"";
									}
									classval="StaffList";
									wrk_flag=false;
									staff_day++;
								}

								prev_staff	=	staff_id2;
								prev_role	=	role_type2;
								prev_cell	 =	 staff_cellno;
								prev_staff_type=staff_type2;
								prev_sched_date=schedule_date2;
								prev_workplace	=	staff_workplace;
							}
							staff_count=k;
							for(day=staff_day; day<DAYS;day++){
								if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
								}
								else{
									if(wrk_flag){
										classval="StaffOtherWP";
										wrk_flag=false;
									}
									else
										classval	=	"StaffList";

									leaveIcon=prev_mnemonic2;
									if(leaveIcon=="")
									leaveIcon ="&nbsp;" ;
								}
								

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
								prev_mnemonic2="&nbsp;";
								prev_shift2	=	"";
								classval="StaffList";
								wrk_flag=false;
							}
						}
						else
							staff_count--;
					}
/***************Staff List end *****************************/
				}
				prev_shift	=	shift_code;
				prev_staff	=	staff_id2;
				prev_role	=	role_type2;
				prev_staff_type	=	staff_type2;
				prev_sched_date	=	schedule_date;
				prev_cell	 =	 staff_cellno;
				prev_mnemonic2="";
				prev_shift2="";
				posit_day=0;
				if((flag)||(staff_count == StaffList.size())||(!prev_posit.equals(posit_code1))){
					flag=false;
					break;
				}

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(posit_code1));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}	
			else 
				shift_count--;

			if(shift_cellno > shift_day){
				for(day=shift_day; day<shift_cellno;day++){
					//to complete the prevous shift cells

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				shift_day=shift_cellno;
			}

			if(shift_alloc > shift_req)
				classval	=	"ABOVEOPTIMAL";
			if(shift_alloc < shift_req)
				classval	=	"BELOWOPTIMAL";
			if(shift_alloc == shift_req)
				classval	=	"OPTIMAL";
			if((shift_alloc == 0)&&(shift_req == 0))
				classval	=	"EmptyCell";

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block94Bytes, _wl_block94);

			shift_day++;
		}
		shift_count=j;
}
}
prev_posit=posit_code;
posit_day=0;
shift_day=0;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(posit_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);

}
if(posit_cellno > posit_day){
for(day=posit_day; day<posit_cellno;day++){

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block98Bytes, _wl_block98);

}
posit_day=posit_cellno;
}
if(posit_alloc > posit_req)
classval	=	"ABOVEOPTIMAL";
if(posit_alloc < posit_req)
classval	=	"BELOWOPTIMAL";
if(posit_alloc == posit_req)
classval	=	"OPTIMAL";
if((posit_alloc == 0)&&(posit_req == 0))
classval	=	"EmptyCell";


            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(posit_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(posit_req));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posit_req));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(posit_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posit_alloc));
            _bw.write(_wl_block62Bytes, _wl_block62);
	
posit_day++;
}
for(day=posit_day;day<DAYS;day++){

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block100Bytes, _wl_block100);

}
if(PositionShiftTotal.size() >shift_count){
//to display the shift total
shift_record=(String[])PositionShiftTotal.get(shift_count++);

posit_code1	=	shift_record[0];	
shift_code	=shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
shift_day=0;

if(prev_posit.equals(posit_code1)){
//check for same position in both 

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(posit_code1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block31Bytes, _wl_block31);

if(shift_cellno > shift_day){
//check for the first schedule date > from date
for(day=shift_day; day<shift_cellno;day++){

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

}
shift_day=shift_cellno;
}

if(shift_alloc > shift_req)
classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
classval	=	"EmptyCell";


            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

shift_day++;
prev_shift=shift_code;

for(j=shift_count;j<PositionShiftTotal.size();j++)	{
//continue with the shift data
shift_record=(String[])PositionShiftTotal.get(j);
posit_code1	=	shift_record[0];	
shift_code	=	shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
//check for next shift in the same position 
if(!shift_code.equals(prev_shift)){
//check for the same position in both
	 for(day=shift_day;day<DAYS;day++){

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block100Bytes, _wl_block100);
	
	}
	shift_count=j;
	shift_day=0;
	if(!posit_code1.equals(prev_posit)){
//********************to display the ONCALL shift total***********************\\
		if(PositionOncallTotal.size() >oncall_count){

			oncall_record=(String[])PositionOncallTotal.get(oncall_count++);

			onposit_code	=	oncall_record[0];	
			oncall_code	=oncall_record[1];
			oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
			oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
			oncall_cellno	=	Integer.parseInt(oncall_record[5]);
			oncall_day=0;

			if(oncall_alloc > oncall_req)
				classval	=	"ABOVEOPTIMAL";
			if(oncall_alloc < oncall_req)
				classval	=	"BELOWOPTIMAL";
			if(oncall_alloc == oncall_req)
				classval	=	"OPTIMAL";
			if((oncall_alloc == 0)&&(oncall_req == 0))
				classval	=	"EmptyCell";

			if(prev_posit.equals(onposit_code)){ //check for same position in both 

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(onposit_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
	
				if(oncall_cellno > oncall_day){//check for the first schedule date > from date
					for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
			
					}
					oncall_day=oncall_cellno;
				}

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

				oncall_day++;
				for(k=oncall_count;k<PositionOncallTotal.size();k++){ 
				  //continue with the shift data
					oncall_record=(String[])PositionOncallTotal.get(k);

					onposit_code	=	oncall_record[0];	
					oncall_code	=oncall_record[1];
					oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
					oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
					oncall_cellno	=	Integer.parseInt(oncall_record[5]);

					//check for next shift in the same position 
					if(!(onposit_code.equals(prev_posit))){
						//check for the same position in both
						for(day=oncall_day;day<DAYS;day++){

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
						oncall_count=k;
						oncall_day=0;
						break;
					}
					if(oncall_cellno > oncall_day){
						//check for the first schedule date > from date
						for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
						}
						oncall_day=oncall_cellno;
					}
					if(oncall_alloc > oncall_req)
						classval	=	"ABOVEOPTIMAL";
					if(oncall_alloc < oncall_req)
						classval	=	"BELOWOPTIMAL";
					if(oncall_alloc == oncall_req)
						classval	=	"OPTIMAL";
					if((oncall_alloc == 0)&&(oncall_req == 0))
						classval	=	"EmptyCell";

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

					oncall_day++;
				}
			}
			else
				oncall_count--;
		}
//**********Staff List ******************/

		if(StaffList.size() > staff_count){
			staff_record=(String[])StaffList.get(staff_count++);
			role_type2	= staff_record[0];
			posit_code2	=	staff_record[1];	
			staff_id2			=	staff_record[2];
			schedule_date2	=	staff_record[3];
			shift_code2	=staff_record[4];
			shift_mnemonic2=staff_record[5];
			staff_cellno	=	Integer.parseInt(staff_record[6]);
			staff_type2	=	staff_record[7];
			staff_workplace	=	staff_record[8];
			staff_name	=	staff_record[11];
			classval="StaffList";
			wrk_flag=false;
			key	=	role_type2+staff_id2;

			if(Staff_Leave_Dtl.containsKey(key))
				StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
			else
				StaffLeaveDays	=	new ArrayList();

			if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
				classval="StaffOtherWP";
				wrk_flag=true;
			}
			if(prev_posit.equals(posit_code2)){
				//check for same position in both 

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block62Bytes, _wl_block62);

				if((staff_cellno-1) > staff_day){
					//check for the first schedule date > from date
					for(day=staff_day; day<staff_cellno;day++){
						if(StaffLeaveDays.contains(String.valueOf(day))){
								classval = "LeaveStaff";
								prev_mnemonic2="";
								leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
						}
						else
						{
								classval	=	"StaffList";
								leaveIcon	=	prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
						}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
					staff_day=staff_cellno;
				}
				if(staff_workplace.equals(workplace_code)){	
					if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
						if(prev_shift2.equals("")){
							prev_shift2		=	shift_code2;
							prev_mnemonic2	=	shift_mnemonic2;
						}
						else{
							prev_shift2=	prev_shift2+"|"+shift_code2;
							prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
						}
					}
					else{
						prev_shift2=shift_code2;
						prev_mnemonic2=shift_mnemonic2;
						prev_sched_date	= schedule_date2;
					}
				}
				prev_staff	=	staff_id2;
				prev_role	=	role_type2;
				prev_staff_type	=	staff_type2;
				prev_cell = staff_cellno;
				prev_workplace=staff_workplace;
				prev_sched_date	= schedule_date2;

				for(k=staff_count;k<StaffList.size();k++)	{
				//continue with the staff data

					staff_record=(String[])StaffList.get(k);
					role_type2	= staff_record[0];
					posit_code2	=	staff_record[1];	
					staff_id2			=	staff_record[2];
					schedule_date2	=	staff_record[3];
					shift_code2	=staff_record[4];
					shift_mnemonic2=staff_record[5];
					staff_cellno	=	Integer.parseInt(staff_record[6]);
					staff_type2	=	staff_record[7];
					staff_workplace	=	staff_record[8];
					staff_name	=	staff_record[11];

					if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
						classval="StaffOtherWP";
						wrk_flag=true;
					}

					//check for next staff in the same position 
					if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
						//check for the same position in both
						if(prev_cell > staff_day){
							for(day=staff_day; day<(prev_cell);day++)	{
								if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
								}
								else
								{
									classval	=	"StaffList";
									leaveIcon	=	prev_mnemonic2;
									if(leaveIcon=="")
									leaveIcon ="&nbsp;" ;
								}

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block100Bytes, _wl_block100);

							}
							staff_day=prev_cell;
						}
						for(day=staff_day;day<DAYS;day++){
							if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
							}
							else{
								if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
									classval="StaffOtherWP";
									wrk_flag=true;
								}
								leaveIcon=prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
							}

							if(prev_mnemonic2.equals(""))
								prev_mnemonic2="&nbsp;";

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);

							prev_shift2="";
							prev_mnemonic2="&nbsp";
							classval="StaffList";
						}
						wrk_flag=false;
						staff_day=day;
						staff_count=k;
						if(!posit_code2.equals(prev_posit)){
							flag=true;
							prev_mnemonic2="";
							prev_shift2="";
							break ;
						}
						prev_staff	=	staff_id2;
						prev_role	=	role_type2;
						prev_staff_type	=	staff_type2;
						prev_sched_date	= schedule_date2;
						prev_cell = staff_cellno;
						prev_workplace	=	staff_workplace;
						prev_mnemonic2="";
						prev_shift2="";
						staff_day=0;
						key=role_type2+staff_id2;

						if(StaffLeaveDays.contains(String.valueOf(day))){
							classval = "LeaveStaff";
							prev_mnemonic2="";
							leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
						}
						else
						{
							classval	=	"StaffList";
							leaveIcon	=	prev_mnemonic2;
							if(leaveIcon=="")
							leaveIcon ="&nbsp;" ;
						}

						if(Staff_Leave_Dtl.containsKey(key))
							StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
						else
							StaffLeaveDays	=	new ArrayList();

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}	
					if(prev_cell > staff_day){
						for(day=staff_day; day<prev_cell;day++){									
							if(StaffLeaveDays.contains(String.valueOf(day))){
								classval = "LeaveStaff";
								prev_mnemonic2="";
								leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
							}
							else
							{
								classval	=	"StaffList";
								leaveIcon	=	prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
							}

            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
						staff_day=prev_cell;
						staff_day=prev_cell;
						classval	=	"StaffList";
						wrk_flag=false;
					}
					if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
						if(staff_workplace.equals(workplace_code)){
							if(prev_shift2.equals("")){
								prev_shift2		=	shift_code2;
								prev_mnemonic2	=	shift_mnemonic2;
							}
							else{
								prev_shift2=	prev_shift2+"|"+shift_code2;
								prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
							}
						}
						if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
						}
					}
					else{

						if(prev_mnemonic2.equals(""))
							prev_mnemonic2="&nbsp;";

						 if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)) {
								classval="StaffOtherWP";
								wrk_flag=true;
						 }

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
						if(staff_workplace.equals(workplace_code)){
							prev_shift2		=	shift_code2;
							prev_mnemonic2	=	shift_mnemonic2;
							prev_sched_date	= schedule_date2;
						}
						else{
							prev_shift2		=	"";
							prev_mnemonic2	=	"";
						}	
						prev_sched_date	= schedule_date2;
						classval="StaffList";
						wrk_flag=false;
						staff_day++;
					}
					prev_staff=staff_id2;
					prev_role= role_type2;
					prev_sched_date	=	schedule_date2;
					prev_workplace=staff_workplace;
					prev_cell = staff_cellno;
				}

				staff_count=k;
				for(day=staff_day; day<DAYS;day++){

					if(StaffLeaveDays.contains(String.valueOf(day))){
						classval = "LeaveStaff";
						prev_mnemonic2="";
						leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
					}
					else{
						if(wrk_flag){
							classval="StaffOtherWP";
							wrk_flag=false;
						}
						else
							classval	=	"StaffList";

						leaveIcon=prev_mnemonic2;
						if(leaveIcon=="")
						leaveIcon ="&nbsp;" ;
					}

					if(prev_mnemonic2.equals(""))
						prev_mnemonic2="&nbsp;";

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);

					prev_mnemonic2	=	"&nbsp;";
					prev_shift2	=	"";
					classval="StaffList";
					wrk_flag=false;
				}
			}
			else
					staff_count--;
		}
/***************Staff List end *****************************/							
	}
	prev_shift=shift_code;
	shift_day=0;

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(posit_code1));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block31Bytes, _wl_block31);

}	
if(shift_cellno > shift_day){
	for(day=shift_day; day<shift_cellno;day++){

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
	shift_day=shift_cellno;
}
if(shift_alloc > shift_req)
		classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
		classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
		classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
		classval	=	"EmptyCell";


            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_req));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(shift_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(shift_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

shift_day++;
}
shift_count=j;
//to complete the prevous shift cells
if(shift_day>0){
for(day=shift_day;day<DAYS;day++){

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

}
}
}
}
//********************to display the ONCALL shift total***********************\\
if(PositionOncallTotal.size() >oncall_count){

oncall_record=(String[])PositionOncallTotal.get(oncall_count++);
onposit_code	=	oncall_record[0];	
oncall_code	=oncall_record[1];
oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
oncall_cellno	=	Integer.parseInt(oncall_record[5]);
oncall_day=0;

if(oncall_alloc > oncall_req)
classval	=	"ABOVEOPTIMAL";
if(oncall_alloc < oncall_req)
classval	=	"BELOWOPTIMAL";
if(oncall_alloc == oncall_req)
classval	=	"OPTIMAL";
if((oncall_alloc == 0)&&(oncall_req == 0))
classval	=	"EmptyCell";

if(prev_posit.equals(onposit_code)){
//check for same position in both 

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(onposit_code));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

if(oncall_cellno > oncall_day){
	//check for the first schedule date > from date
	 for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
	}
	oncall_day=oncall_cellno;
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

oncall_day++;

for(k=oncall_count;k<PositionOncallTotal.size();k++){
	//continue with the shift data
	oncall_record=(String[])PositionOncallTotal.get(k);

	onposit_code	=	oncall_record[0];	
	oncall_code	=oncall_record[1];
	oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
	oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
	oncall_cellno	=	Integer.parseInt(oncall_record[5]);
	//check for next shift in the same position 
	if(!(onposit_code.equals(prev_posit))){
		//check for the same position in both
		for(day=oncall_day;day<DAYS;day++){

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		oncall_count=k;
		oncall_day=0;
		break;
	}
	if(oncall_cellno > oncall_day){
		//check for the first schedule date > from date
		for(day=oncall_day; day<oncall_cellno;day++){

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		oncall_day=oncall_cellno;
	}
	if(oncall_alloc > oncall_req)
		classval	=	"ABOVEOPTIMAL";
	if(oncall_alloc < oncall_req)
		classval	=	"BELOWOPTIMAL";
	if(oncall_alloc == oncall_req)
		classval	=	"OPTIMAL";
	if((oncall_alloc == 0)&&(oncall_req == 0))
		classval	=	"EmptyCell";

            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_req));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(oncall_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oncall_alloc));
            _bw.write(_wl_block27Bytes, _wl_block27);

	oncall_day++;
}
}
else
oncall_count--;
}
if(oncall_day >0){
for(day=oncall_day; day<DAYS;day++){

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(oncall_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

}
}
//**************************Staff List ***************************/

if(StaffList.size() > staff_count){
staff_record=(String[])StaffList.get(staff_count++);

role_type2	= staff_record[0];
posit_code2	=	staff_record[1];	
staff_id2			=	staff_record[2];
schedule_date2	=	staff_record[3];
shift_code2	=staff_record[4];
shift_mnemonic2=staff_record[5];
staff_cellno	=	Integer.parseInt(staff_record[6]);
staff_type2	=	staff_record[7];
staff_workplace	=	staff_record[8];
staff_name	=	staff_record[11];
classval="StaffList";
wrk_flag=false;
key	=	role_type2+staff_id2;

if(Staff_Leave_Dtl.containsKey(key))
StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
else
StaffLeaveDays	=	new ArrayList();

if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
classval="StaffOtherWP";
wrk_flag=true;
}

staff_day=0;
prev_cell=0;

if(prev_posit.equals(posit_code2)){ 
//check for same position in both 

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block31Bytes, _wl_block31);

if(staff_cellno> staff_day){
	/*check for the first schedule date > from date*/
	for(day=staff_day; day<staff_cellno;day++){
		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else
		{
			classval	=	"StaffList";
			leaveIcon=prev_mnemonic2;
			if(leaveIcon=="")
			leaveIcon ="&nbsp;" ;
		}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
	staff_day=staff_cellno;
}
if(staff_workplace.equals(workplace_code)){
	if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
		if(prev_shift2.equals("")){
			prev_shift2		=	shift_code2;
			prev_mnemonic2	=	shift_mnemonic2;
		}
		else{
			prev_shift2=	prev_shift2+"|"+shift_code2;
			prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
			//System.err.println("prev_mnemonic2---->"+prev_mnemonic2);
		}
	}
	else{					
		prev_shift2		=	shift_code2;
		prev_mnemonic2	=	shift_mnemonic2;
		prev_sched_date	= schedule_date2;
	}
}
prev_staff	=	staff_id2;
prev_role	=	role_type2;
prev_staff_type= staff_type2;
prev_cell= staff_cellno;
prev_workplace=staff_workplace;
prev_sched_date	= schedule_date2;

for(k=staff_count;k<StaffList.size();k++)	{ 
	//continue with the shift data

	staff_record=(String[])StaffList.get(k);
	role_type2	= staff_record[0];
	posit_code2	=	staff_record[1];	
	staff_id2			=	staff_record[2];
	schedule_date2	=	staff_record[3];
	shift_code2	=staff_record[4];
	shift_mnemonic2=staff_record[5];
	staff_cellno	=	Integer.parseInt(staff_record[6]);
	staff_type2	=	staff_record[7];
	staff_workplace	=	staff_record[8];
	staff_name	=	staff_record[11];

	//check for next staff in the same position 
	if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
	//to complete the prevous staff cells
		if(prev_cell > staff_day){

			for(day=staff_day; day<prev_cell;day++){
				if(StaffLeaveDays.contains(String.valueOf(day))){
					classval = "LeaveStaff";
					prev_mnemonic2="&nbsp;";
					leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
				}
				else
				{
					classval	=	"StaffList";
					leaveIcon	=	prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			staff_day=prev_cell;
		}
		for(day=staff_day;day<DAYS;day++){
			if(StaffLeaveDays.contains(String.valueOf(day))){
				classval = "LeaveStaff";
				prev_mnemonic2="";
				leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
			}
			else{
				if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
					classval="StaffOtherWP";
					wrk_flag=true;
				}
				leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					 leaveIcon ="&nbsp;" ;
			}

			if(prev_mnemonic2.equals(""))
				prev_mnemonic2="&nbsp;";

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_posit));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_posit));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);

			prev_shift2="";
			prev_mnemonic2="&nbsp;";
			classval="StaffList";
		}
		wrk_flag=false;
		prev_staff	=	staff_id2;
		prev_role	=	role_type2;
		prev_staff_type	=	staff_type2;
		prev_sched_date	=	schedule_date2;
		prev_cell=staff_cellno;
		prev_workplace=staff_workplace;
		staff_day=0;
		key	=	role_type2+staff_id2;

		if(Staff_Leave_Dtl.containsKey(key))
			StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
		else
			StaffLeaveDays	=	new ArrayList();

		staff_count=k;
		//check for the same position in both
		if(!posit_code2.equals(prev_posit))	{
			staff_day=14;
			break ;										
		}

            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block173Bytes, _wl_block173);

	}	
	if(prev_cell > staff_day){
		for(day=staff_day; day<prev_cell;day++){
			if(StaffLeaveDays.contains(String.valueOf(day))){
				classval = "LeaveStaff";
				prev_mnemonic2="";
				leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
			}
			else{
				if(wrk_flag){
					classval="StaffOtherWP";
					wrk_flag=false;
					leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}
				else
				{
					classval	=	"StaffList";
					leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}
			}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
		}
		staff_day=prev_cell;
		classval	=	"StaffList";
		wrk_flag=false;
	}
	if(prev_role.equals(role_type2) && prev_staff.equals(staff_id2) && prev_sched_date.equals(schedule_date2)){
		if(staff_workplace.equals(workplace_code)){
			if(prev_shift2.equals("")){
				prev_shift2		=	shift_code2;
				prev_mnemonic2	=	shift_mnemonic2;
			}
			else{
					prev_shift2=	prev_shift2+"|"+shift_code2;
					prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
			}
		}
		if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
			classval="StaffOtherWP";
				wrk_flag=true;
		}
	}
	else{
		if(prev_mnemonic2.equals(""))
			prev_mnemonic2="&nbsp;";
		if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
			classval="StaffOtherWP";
			wrk_flag=true;
		}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(staff_day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);
		
		if(staff_workplace.equals(workplace_code)){
			prev_shift2		=	shift_code2;
			prev_mnemonic2	=	shift_mnemonic2;
			prev_sched_date	= schedule_date2;
		}
		else{
			prev_shift2		=	"";
			prev_mnemonic2	=	"";
		}
		prev_sched_date	=	schedule_date2;
		classval="StaffList";
		wrk_flag=false;
		staff_day++;
	}
	prev_staff	=	staff_id2;
	prev_role	=	role_type2;
	prev_staff_type	=	staff_type2;
	prev_sched_date	=	schedule_date2;
	prev_cell=staff_cellno;
	prev_workplace=staff_workplace;
}
if((prev_cell > staff_day)&&(staff_day>0)){
	for(day=staff_day; day<prev_cell;day++){
		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else
		{
			classval	=	"StaffList";
		}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(role_type2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_id2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(staff_type2));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(role_type2));
            out.print( String.valueOf(staff_id2));
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
	}
	staff_day=prev_cell;
}
if(staff_day >=0)
	for(day=staff_day;day<DAYS;day++){

		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else{
			if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
				classval="StaffOtherWP";
				wrk_flag=true;
			}
			leaveIcon=prev_mnemonic2;
		}

		if(prev_mnemonic2.equals(""))
			prev_mnemonic2="&nbsp;";

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(posit_code2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(prev_staff_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(leaveIcon));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_mnemonic2));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code2));
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_shift2));
            _bw.write(_wl_block27Bytes, _wl_block27);

		prev_shift2="";
		prev_mnemonic2="&nbsp;";
		classval	=	"StaffList";
	}
}
}
}
/***************Staff List end *****************************/		

            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(view));
            _bw.write(_wl_block190Bytes, _wl_block190);

}
catch ( Exception e )	{
e.printStackTrace() ;
throw e ;
}
finally{

if(pstmt_PositionShiftTotal != null) 
pstmt_PositionShiftTotal.close();

if(pstmt_PositionTotal != null) 
pstmt_PositionTotal.close();

if(pstmt_StaffList != null) 
pstmt_StaffList.close();

if(pstmt_StaffLeaveList != null) 
pstmt_StaffLeaveList.close();

if(rs_PositionShiftTotal != null) 
rs_PositionShiftTotal.close();

if(rs_PositionTotal != null) 
rs_PositionTotal.close();

if(rs_StaffList != null) 
rs_StaffList.close();

if(rs_StaffLeaveList != null) 
rs_StaffLeaveList.close();

ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block191Bytes, _wl_block191);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Oncall.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Oncall.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Allocate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.change.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Swap.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transfer.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Over.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Leave.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ManageWorkScheduleCancelLeave", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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

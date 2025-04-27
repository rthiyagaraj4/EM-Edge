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

public final class __manageworkschedulehdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleHdr.jsp", 1709121637996L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link> -->\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../js/ManageWorkSchedule.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eRS/js/RSMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n -->\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=form_ManageWorkScheduleHdr>\n\t\n\t<table width=\"100%\" border=\'0\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t\t<table border=\'0\'  align=\'left\' width=\"100%\">\n\t\t\t\t\t\t<tr><td width=\'16%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<td  align=left class=Month colspan=2 nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<td  colspan=2 align=left class=Month nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<td colspan=2 align=left class=Month nowrap>&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<td width=\'10%\' class=\'EmptyCell\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table border=\'1\' width=\'100%\' bgcolor=\'white\' cellpadding=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"16%\" nowrap class=Date><b>&nbsp;</b>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<td class=Date width=\"6%\" title=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" align=\'center\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\' id=\'\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"\' value=\'\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" align=\'center\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td  align=\"left\" class=Day width=\"6%\" nowrap><b>&nbsp;</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td class=Day width=\"6%\" title=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<!--Allocated & Requirement total -->\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td  align=\"left\" class=\'EmptyCell\' width=\"16%\" nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' width=\"6%\" id=\'w_total";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' align=\'center\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="/";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'w_totalreq";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'w_totalreq";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'w_totalalloc";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'w_totalalloc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'w_total";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' align=\'center\' nowrap>&nbsp;</td>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'w_totalreq";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'w_totalalloc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'\'>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td  align=\"left\" class=\'EmptyCell\' width=\"16%\" nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' width=\"6%\" id=\'o_total";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'o_totalreq";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'o_totalreq";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'o_totalalloc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'o_totalalloc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'o_total";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' align=\'center\' nowrap>&nbsp;</td>\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'o_totalreq";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'o_totalalloc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'u_total";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'u_totalalloc";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'u_totalalloc";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'u_total";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'u_totalalloc";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' value=\'\'>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n<!--  To display the Shift Total-->\n\t\t\t<table width=\'100%\' border=\'1\' cellpadding=\'0\'>\n\t\t\t\t<tr >\t\t\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td\tclass=\'Shift\' align=left width=\'16%\' nowrap>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" - ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'shift";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftreq";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'shiftreq";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftalloc";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'shiftalloc";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' width=\"6%\" id=\'shift";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftreq";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftalloc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'shift";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftreq";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftalloc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td\tclass=\'Shift\' align=left width=\'16%\' nowrap>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t<td class=\'EmptyCell\' width=\"6%\" id=\'total";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' align=\'center\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftreq";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'shiftalloc";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t</tr>\n\t\t</table>\n\t</table>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t<input type=\'hidden\' name=\'role_type\' id=\'role_type\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t<input type=\'hidden\' name=\'staff_type\' id=\'staff_type\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t<input type=\'hidden\' name=\'position_code\' id=\'position_code\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t<input type=\'hidden\' name=\'staff_id\' id=\'staff_id\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<input type=\'hidden\' name=\'view\' id=\'view\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t<input type=\'hidden\' name=\'groupby\' id=\'groupby\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t<input type=\'hidden\' name=\'end_ind\' id=\'end_ind\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n</form>\n<script>\t\n\tparent.frames[0].document.forms[0].p_from_date.value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\tparent.frames[0].document.forms[0].p_to_date.value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\';\n\tparent.frames[0].document.forms[0].p_end.value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\';\n\tparent.frames[2].location.href=\'../../eRS/jsp/ManageWorkScheduleResult.jsp?facility_id=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="&user_id=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&function_id=";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&workplace_code=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&locn_type=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="&role_type=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="&staff_type=";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="&position_code=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&staff_id=";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&view=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&groupby=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="&from_date=";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="&to_date=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="&new_from_date=";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="&new_to_date=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&onclick_of=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="&productive_flag=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="&DAYS=";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\';\n</script>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

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
*   File Name		:	ManageWorkScheduleHdr.jsp
*	Purpose 		:	To display the Back Button & the Navigation Buttons
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
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

//out.println("Manageworkschedule hdr jsp");
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	String groupby				=request.getParameter("groupby")==null?"":request.getParameter("groupby");
	String from_date				=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date				=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String new_fromdate=request.getParameter("new_from_date")==null?"":request.getParameter("new_from_date");
	String new_todate= request.getParameter("new_to_date")==null?"":request.getParameter("new_to_date");
	String onclick_of				=request.getParameter("onclick_of")==null?"":request.getParameter("onclick_of");
	String productive_flag=request.getParameter("productive_flag")==null?"W":request.getParameter("productive_flag");
	int DAYS=Integer.parseInt(request.getParameter("DAYS")==null?"0":request.getParameter("DAYS"));
	String classval="";

	PreparedStatement pstmt_ShiftTotal =null;
	ResultSet rs_ShiftTotal=null;
	CallableStatement cl_DayDate =null;
	ArrayList ShiftTotal	=	new ArrayList();

	String record[]=null;
	String shift_code="";
	String prev_shift="";
	String shift_mnemonic="";
	String shift_desc="";

	int allocated=0;
	int required=0;
	int cell_no=0;
	int shift_count=0;
	int day_count=0;

	//String sql_ShiftTotal="SELECT   a.shift_code, b.long_desc, a.shift_mnemonic, TRUNC (a.schedule_date) schedule_date, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated,(TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') and (? is null or a.position_code=?) and b.shift_indicator ='P'	and b.productive_flag='W' and a.shift_code=b.shift_code GROUP BY a.shift_code, a.shift_mnemonic, a.schedule_date, b.shift_code, b.long_desc ORDER BY a.shift_mnemonic";
	String sql_ShiftTotal="SELECT   a.shift_code, b.long_desc, a.shift_mnemonic, TRUNC (a.schedule_date) schedule_date, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated,(TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') and (? is null or a.position_code=?) and b.shift_indicator ='P' and b.productive_flag='W' and a.shift_code=b.shift_code and b.language_id = ? GROUP BY a.shift_code, a.shift_mnemonic, a.schedule_date, b.shift_code, b.long_desc ORDER BY a.shift_mnemonic";

    Connection con = null;
try{
		con = ConnectionManager.getConnection(request);

		cl_DayDate=con.prepareCall("{call Rs_get_sch_summ_dd_day_string(?,?,?,?,?,?,?,?,?,?,?,?)}");

		cl_DayDate.setString( 1, facility_id) ;
		cl_DayDate.setString( 2, workplace_code) ;
		cl_DayDate.setString( 3, from_date) ;
		cl_DayDate.setString( 4, to_date) ;
		cl_DayDate.setString( 5, onclick_of) ;
		cl_DayDate.setString( 6, new_fromdate) ;
		cl_DayDate.setString( 7, new_todate) ;
		cl_DayDate.registerOutParameter(8,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(9,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(10,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(11,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(12,Types.VARCHAR) ;
		cl_DayDate.execute() ;

		String date_day = cl_DayDate.getString(8)==null?"":cl_DayDate.getString(8);
		String mon_year = cl_DayDate.getString(9)==null?"":cl_DayDate.getString(9);
		String new_from_date = cl_DayDate.getString(10)==null?"":cl_DayDate.getString(10);
		String new_to_date = cl_DayDate.getString(11)==null?"":cl_DayDate.getString(11);
		String end_ind = cl_DayDate.getString(12)==null?"":cl_DayDate.getString(12);


		if(cl_DayDate != null)
			cl_DayDate.close();
		
		pstmt_ShiftTotal=con.prepareStatement(sql_ShiftTotal);

		pstmt_ShiftTotal.setString(1, new_from_date);
		pstmt_ShiftTotal.setString(2, facility_id);
		pstmt_ShiftTotal.setString(3, workplace_code);
		pstmt_ShiftTotal.setString(4, new_from_date);
		pstmt_ShiftTotal.setString(5, new_to_date);
		pstmt_ShiftTotal.setString(6, position_code);
		pstmt_ShiftTotal.setString(7, position_code);
		pstmt_ShiftTotal.setString(8, locale);

		rs_ShiftTotal=pstmt_ShiftTotal.executeQuery();
		while((rs_ShiftTotal != null)&&(rs_ShiftTotal.next())){
			record	=	new String [7];
			record[0]	=	rs_ShiftTotal.getString("shift_code");
			record[1]	=	rs_ShiftTotal.getString("long_desc");
			record[2]	=	rs_ShiftTotal.getString("shift_mnemonic");
			record[3]	=	rs_ShiftTotal.getString("schedule_date");
			record[4]	=	rs_ShiftTotal.getString("required")==null?"0":rs_ShiftTotal.getString("required");
			record[5]	=	rs_ShiftTotal.getString("allocated")==null?"0":rs_ShiftTotal.getString("allocated");
			record[6]	=	rs_ShiftTotal.getString("cell_no");
			ShiftTotal.add(record);
		}
		if(pstmt_ShiftTotal != null)
			pstmt_ShiftTotal.close();
		if(rs_ShiftTotal != null)
			rs_ShiftTotal.close();
		if (date_day==null) date_day="";
	   StringTokenizer d_token = new StringTokenizer(date_day, "~");
		int d_counter=d_token.countTokens();
		int total_days=d_counter/3;
		String d_code[]=new String[total_days];
		String d_code1[]=new String[total_days];
		String d_code2[]=new String[total_days];
		String req_w[]	 =new String[total_days];
		String alloc_w[]	 =new String[total_days];
		String req_o[]	 =new String[total_days];
		String alloc_o[]	 =new String[total_days];
		String alloc_u[]	 =new String[total_days];
		int d_track=0;

		while (d_token.hasMoreTokens()){
			d_code[d_track]=d_token.nextToken();
			StringTokenizer d_token1 = new StringTokenizer(d_code[d_track], "-");
			d_code1[d_track]	=	d_token1.nextToken();
			d_code2[d_track]	=	d_token1.nextToken();
			req_w[d_track]			=	d_token.nextToken();
			alloc_w[d_track]			=	d_token.nextToken();
			req_o[d_track]			=	d_token.nextToken();
			alloc_o[d_track]			=	d_token.nextToken();
			alloc_u[d_track]			=	d_token.nextToken();
			d_track++;
		}
		StringTokenizer mm_year = new StringTokenizer(mon_year, "|");
		int yy1=mm_year.countTokens();
		String mm_yy[]=new String[yy1];
		int d_track1=0;
		String cc4="0";
		String cc3="0";
		int d_diff1=0;
		int d_diff2=0;
		while (mm_year.hasMoreTokens()){
			mm_yy[d_track1]=mm_year.nextToken();
			d_track1++;
		}
		
		if(yy1>2){
			if(mm_yy[3] !=null){
				cc3=mm_yy[3];
				d_diff1=Integer.parseInt(cc3);
			}
		}
		if(yy1>4){
			if(mm_yy[5] !=null){
				cc4=mm_yy[5];
				d_diff2=Integer.parseInt(cc4);
			}
		}
		int d_diff=Integer.parseInt(mm_yy[1]);

            _bw.write(_wl_block8Bytes, _wl_block8);

						for(int p=0;p<30;p++){
							if( p == d_diff ){
								String te1=com.ehis.util.DateUtils.convertDate(mm_yy[0].substring(4),"YY","en",locale);
								String te2=mm_yy[0].substring(0,4)+te1;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(te2));
            _bw.write(_wl_block10Bytes, _wl_block10);
						}
							else 	if( d_diff1 !=0 && p == d_diff1){
								String te3=com.ehis.util.DateUtils.convertDate(mm_yy[2].substring(4),"YY","en",locale);
								String te4=mm_yy[2].substring(0,4)+te3;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(te4));
            _bw.write(_wl_block12Bytes, _wl_block12);
			
								} 
							else	if( d_diff2 !=0 && p == d_diff2){
								String te5=com.ehis.util.DateUtils.convertDate(mm_yy[4].substring(4),"YY","en",locale);
								String te6=mm_yy[2].substring(0,4)+te5;

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(te6));
            _bw.write(_wl_block12Bytes, _wl_block12);
			
							}
							else{

            _bw.write(_wl_block14Bytes, _wl_block14);
			
							}	
						}		

            _bw.write(_wl_block15Bytes, _wl_block15);
	
					for(int day=0;day<d_track;day++){

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(d_code2[day]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(d_code2[day]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(d_code2[day]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(d_code2[day]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_code2[day]));
            _bw.write(_wl_block21Bytes, _wl_block21);
	
					}
					for(int day=d_track;day<DAYS;day++){

            _bw.write(_wl_block22Bytes, _wl_block22);

					}

            _bw.write(_wl_block23Bytes, _wl_block23);
	
					for(int day=0;day<d_track;day++){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(d_code1[day]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(d_code1[day]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(d_code1[day]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(d_code1[day]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_code1[day]));
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					for(int day=d_track;day<DAYS;day++){

            _bw.write(_wl_block22Bytes, _wl_block22);

					}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
	
					for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_w[day]==null?"0":alloc_w[day]);
						required	=	Integer.parseInt(req_w[day]==null?"0":req_w[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(day));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(required));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(day));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(required));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(day));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block39Bytes, _wl_block39);
	
					}
					for(int day=d_track;day<DAYS;day++){

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(day));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(day));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(day));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(day));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}

            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

					for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_o[day]==null?"0":alloc_o[day]);
						required	=	Integer.parseInt(req_o[day]==null?"0":req_o[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(day));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(required));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(day));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(required));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block39Bytes, _wl_block39);

					}
					for(int day=d_track;day<DAYS;day++){

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(day));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(day));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(day));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}

            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

				for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_u[day]==null?"0":alloc_u[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(day));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(day));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block39Bytes, _wl_block39);

				}
				for(int day=d_track;day<DAYS;day++){

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(day));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(day));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(day));
            _bw.write(_wl_block58Bytes, _wl_block58);

				}

            _bw.write(_wl_block59Bytes, _wl_block59);
	
/***to display first shift first day****/
				if((ShiftTotal!=null)&&(ShiftTotal.size()>0)){
					shift_count=ShiftTotal.size();
					record=(String[])ShiftTotal.get(0);
					shift_code			=	record[0];
					shift_desc			=	record[1];
					shift_mnemonic	=	record[2];
					required				=	Integer.parseInt(record[4]);
					allocated				=	Integer.parseInt(record[5]);
					cell_no				=	Integer.parseInt(record[6]);

					if(allocated > required)
						classval	=	"ABOVEOPTIMAL";
					if(allocated < required)
						classval	=	"BELOWOPTIMAL";
					if(allocated == required)
						classval	=	"OPTIMAL";
					if((allocated == 0)&&(required == 0))
						classval	=	"EmptyCell";


            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block62Bytes, _wl_block62);
	
					if(cell_no > day_count){
						for(int day=day_count; day<cell_no;day++){

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);

						}
						day_count=cell_no;
					}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(required));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(required));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block39Bytes, _wl_block39);
		
					day_count++;
					prev_shift=shift_code;
					for(int i=1;i<shift_count;i++){
						record=(String[])ShiftTotal.get(i);
						shift_code			=	record[0];
						shift_desc			=	record[1];
						shift_mnemonic	=	record[2];
						required				=	Integer.parseInt(record[4]);
						allocated				=	Integer.parseInt(record[5]);
						cell_no				=	Integer.parseInt(record[6]);

						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";

						if(!prev_shift.equals(shift_code)){
							for(int day=day_count;day<DAYS;day++){

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);
		
							}
							prev_shift=shift_code;
							day_count=0;

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block12Bytes, _wl_block12);
		
						}	
						if(cell_no > day_count){
							for(int day=day_count; day<cell_no;day++){

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(prev_shift));
            out.print( String.valueOf(day));
            _bw.write(_wl_block43Bytes, _wl_block43);
	
							}
							day_count=cell_no;
						}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(required));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(required));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allocated));
            _bw.write(_wl_block76Bytes, _wl_block76);
	
						day_count++;
					}
					for(int day=day_count;day<DAYS;day++){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(day));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block80Bytes, _wl_block80);

					}
				}

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(view));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(groupby));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(end_ind));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(new_from_date));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(new_to_date));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(end_ind));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(view));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(groupby));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(new_from_date));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(new_to_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(onclick_of));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(DAYS));
            _bw.write(_wl_block116Bytes, _wl_block116);

	}
    catch(Exception e)
	{
		e.printStackTrace();
	} 
	finally
	{
		if(pstmt_ShiftTotal!=null) pstmt_ShiftTotal.close();
		if(cl_DayDate!=null) cl_DayDate.close();
		if(rs_ShiftTotal!=null) rs_ShiftTotal.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block117Bytes, _wl_block117);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Working.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Unproductive.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
}

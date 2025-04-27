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

public final class __masterschedulebyworkplaceresultweekly extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/MasterScheduleByWorkplaceResultWeekly.jsp", 1709121641059L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link> -->\n<script language=\"JavaScript\" src=\"../../eRS/js/MasterSchedule.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  onMouseDown=\"CodeArrest1()\" onKeyDown=\"lockKey()\" >\n\t\t<form name=formByWorkplaceResultWeekly action=\'../../servlet/eRS.MasterScheduleServlet\' method=\'POST\' target=\'messageFrame\'>\n\t\t<table border=\'1\' align=\'left\' width=\"100%\" BGCOLOR=\'WHITE\' bordercolor=\'white\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<input type=\'hidden\' name=\'shift_code_list";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' id=\'shift_code_list";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<input type=\'hidden\' name=\'shift_mnemonic_list";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'shift_mnemonic_list";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<input type=\'hidden\' name=\'totalShifts\' id=\'totalShifts\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\n<!-- Requirement Data row -->\n\t\t<tr>\n\t\t\t<td colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t<td width=\'35%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=\'center\' id=\'req_alloc_total";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'req_total";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'req_total";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'alloc_total";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'alloc_total";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t\t<td width=\'35%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' align=\'center\' id=\'oncall_total";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<input type=\'hidden\' name=\'oncall_req";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'oncall_req";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'oncall_alloc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'oncall_alloc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t<td width=\'35%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<td width=\'8%\' class=\'REQUIREMENT\' align=\'center\' id=\'unproductive_total";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t<input type=\'hidden\' name=\'unproductive_alloc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'unproductive_alloc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<tr><td colspan=\'10\'><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\t\n\t\t\t\t\t\t<tr  id=\'posit";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><td  onclick=\'javascript:expanddetails(this,\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\")\' align=\"center\" width=\'5%\'  class=\'STAFF\'><a id=view";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  href=\'\' ><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b></a></td><td colspan=\'9\' class=\'STAFF\'><b>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b></td>\n\t\t\t\t\t\t<div id=\"master_menu";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onmouseover=\"over()\" onMouseout=\"out()\" onmousedown=\'Un_Oncall_assign();\' style=\'display:none;\'>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<div id=\'Working";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' class=\"master_menuitem_hdr\" value=\'P\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</div>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<div id=\'working";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' class=\"master_menuitem\" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="|P|W\' text=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<div id=\'Oncall";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' class=\"master_menuitem_hdr\" value=\'O\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t<div id=\'oncall";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="|P|O\' text=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t<div id=\'Unproductive";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' class=\"master_menuitem_hdr\" value=\'U\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t<div id=\'unprd";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="|U\' text=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'> ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="p_shift_code_list\' id=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="p_shift_code_list\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="p_shift_mnemonic_list\' id=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="p_shift_mnemonic_list\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="u_shift_code_list\' id=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="u_shift_code_list\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="u_shift_mnemonic_list\' id=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="u_shift_mnemonic_list\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="o_shift_code_list\' id=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="o_shift_code_list\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="o_shift_mnemonic_list\' id=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="o_shift_mnemonic_list\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_shifts";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'total_shifts";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' value=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\t\n\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' style=\'display:none;\'>\n\t\t\t\t\t<td colspan=\'2\' class=\'ALOCATED\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'ALOCATED\' width=\'35%\' align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="shifts\' id=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="shifts\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\t\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' align=\'center\' id=\'req_alloc_position";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'req_position";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'req_position";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'alloc_position";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'alloc_position";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr  id=\'posit";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t\t<td align=\'center\' width=\'5%\'  class=\'STAFF\' onclick=\'javascript:clearstaff(\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\",\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\")\'> \n\t\t\t\t\t\t\t\t\t\t\t\t<a id=\'clear";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'  href=\'#\'>C</a></td>\n\t\t\t\t\t\t\t\t\t\t<td align=\'center\' width=\'5%\'  class=\'STAFF\' onclick=\'javascript:getShiftPattern(\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\",";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =")\'> \n\t\t\t\t\t\t\t\t\t\t\t<a id=\'clear";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'  href=\'#\' class=\'STAFF\'>SP\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'role_type";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'role_type";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staff_type";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'staff_type";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'position_code";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'position_code";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_pattern_id";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'shift_pattern_id";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_pattern_desc";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'shift_pattern_desc";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staff";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'staff";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td align=\'left\' width=\'35%\'  class=\'STAFF\'>&nbsp;";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\");\'><input type=\'text\' size=\'2\' maxlength=\'1\' class=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' align=\'center\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' onkeypress=\'return checkshift(";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =",\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\", \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\");\' onfocus=\'unSelect(this);\' onchange=\'checkshiftlost(this,\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"); onallocation( ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\");\' onblur=\'check(this,\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\");\'> </td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'shift_code";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' id=\'db_action";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' value=\'U\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' id=\'shift_indicator";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\'productive_flag";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\");\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' value=\'\' onkeypress=\'return checkshift(";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\");\' onchange=\'checkshiftlost(this,\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =", \"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\");\'onblur=\'check(this,\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\")\'  onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' value=\'I\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\' value=\'\'>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\");\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\'  class=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\")\' onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' value=\'U\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\");\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'TXTSTAFF\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' id=\'shift";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\");onallocation( ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\n\t<!-- ****************************************** -->\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\");\'>\n\t\t\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'TXTSTAFF\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\")\' onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' value=\'I\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr  id=\'posit";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t<td align=\'center\' width=\'5%\' class=\'STAFF\' onclick=\'javascript:clearstaff(\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\")\'> \n\t\t\t\t\t\t\t\t\t<a id=\'clear";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'  href=\'#\'>C</a></td>\n\t\t\t\t\t\t\t<td align=\'center\' width=\'5%\' class=\'STAFF\' onclick=\'javascript:getShiftPattern(\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =")\'> \n\t\t\t\t\t\t\t\t<a id=\'clear";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'  href=\'#\' class=\'STAFF\'>SP\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'role_type";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staff_type";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'position_code";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_pattern_id";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_pattern_desc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staff";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\'left\' width=\'35%\' class=\'STAFF\'>&nbsp;";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\");\'><input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\");\'onchange=\'checkshiftlost(this,\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\")\' onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' value=\'U\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\");\'>\n\t\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'TXTSTAFF\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\")\' onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' value=\'I\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'STAFF\' onclick=\'showPopup(\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\");\'>\n\t\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' name=\'shift";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' onclick=\'txtclick();\' onkeypress=\'return  checkshift(";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\")\' onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' value=\'U\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\")\'  onfocus=\'unSelect(this);\'></td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\");\'>\n\t\t\t\t\t\t<input type=\'text\' size=\'2\' maxlength=\'1\' align=\'center\' class=\'TXTSTAFF\' onclick=\'txtclick();\' name=\'shift";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' value=\'I\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_indicator";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'productive_flag";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t<tr>\n\t\t\t<td colspan=\'2\' rowspan=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\' class=\'SHIFTTOTAL\'>&nbsp;Shift&nbsp;Total&nbsp;</td>\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t<!-- Shift Requirement Rows -->\n\t\t\t\t<td class=\'SHIFTTOTAL\' width=\'19%\' align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' align=\'center\' id=\'req_alloc_shift";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'req_shift";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' id=\'req_shift";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'alloc_shift";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' id=\'alloc_shift";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\t\t\t\n\t\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\n<!-- /*********************/ -->\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n\t\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t\t<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t\t<input type=\'hidden\' name=\'requirement_id\' id=\'requirement_id\' value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'>\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\n\t\t<input type=\'hidden\' name=\'view\' id=\'view\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t\t<input type=\'hidden\' name=\'week_no\' id=\'week_no\' value=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n\n\t\t<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\n\t\t<input type=\'hidden\' name=\'role_type\' id=\'role_type\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t\t<input type=\'hidden\' name=\'staff_type\' id=\'staff_type\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\n\t\t<input type=\'hidden\' name=\'position_code\' id=\'position_code\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n\t\t<input type=\'hidden\' name=\'staff_id\' id=\'staff_id\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>\n\t\t\n\t\t</form>\n\n</body>\n";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n</html>\n\n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

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
*   File Name		:	MasterSheduleByWorkplaceResultWeekly.jsp
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id	= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	int week_no =Integer.parseInt(request.getParameter("week_no")==null?"0":request.getParameter("week_no"));
	int total_records=0;
	String classval="";
	Connection conn 		= null;

	PreparedStatement pstmt_Req_Total	= null;
	PreparedStatement pstmt_Alloc_Total	= null;
	PreparedStatement pstmt_Shiftwise_Req 		= null;
	PreparedStatement pstmt_Positionwise_Req 	= null;
	PreparedStatement pstmt_Shiftwise_Alloc 		= null;
	PreparedStatement pstmt_Positionwise_Alloc= null;
	PreparedStatement pstmt_Day_Indicator 		= null;
	PreparedStatement pstmt_Staff_List 		= null;
	PreparedStatement pstmt_Position_Desc 	= null;
	PreparedStatement pstmt_Unproductive	 =	 null;
	PreparedStatement pstmt_Oncall_Req	 =	 null;
	PreparedStatement pstmt_Unprod_Alloc	 =	 null;

	ResultSet rs_Req_Total		 		= null;
	ResultSet rs_Alloc_Total	 		= null;
	ResultSet rs_Shiftwise_Req 		= null;
	ResultSet rs_Positionwise_Req	= null;
	ResultSet rs_Shiftwise_Alloc 		= null;
	ResultSet rs_Positionwise_Alloc	= null;
	ResultSet rs_Day_Indicator 		= null;
	ResultSet rs_Staff_List 				= null;
	ResultSet rs_Position_Desc		= null;
	ResultSet rs_Unproductive			=	null;
	ResultSet rs_Oncall_Req			=	null;
	ResultSet rs_Unprod_Alloc			=	null;

	ArrayList Staff_Data		= new ArrayList() ;
	ArrayList Shift_Data		= new ArrayList() ;
	ArrayList PositionShift_Data		= new ArrayList() ;
	ArrayList req_Optimal_Values		= new ArrayList() ;
	ArrayList Oncall_Req			= new ArrayList() ;
	ArrayList Day_Indicator		= new ArrayList() ;
	ArrayList Positionwise_Req		= new ArrayList() ;
	ArrayList	Unproductive_Shift		=	new ArrayList();
	ArrayList	Oncall_Shift		=	new ArrayList();

	HashMap Positionwise_Alloc		= new HashMap() ;
	HashMap Shiftwise_Req		= new HashMap() ;
	HashMap Shiftwise_Alloc		= new HashMap() ;
	HashMap Shift_Dtl					= new HashMap() ;
	HashMap PositionShift_Dtl	= new HashMap() ;

	int Allocated_Values[] = new int[7];
	int Oncall_Allocated[] = new int[7];
	//int Oncall_Required[] = new int[7];
	int Unprod_Allocated[] = new int[7];
	int Shift_Allocated_Values[] = new int[7];
	int Posit_Allocated_Values[] = new int[7];
	int totalShifts=0;
	int day_no=0;
	int day_count=0;
	int day=0;
	int req_val=0;
	int alloc_val=0;
	int shift_count=0;

	String[] record		     = null;
	String[] position_record = null;
	String[] shift_record	 = null;
	String[] shift_req       = null;
	//String[] shift_alloc     = null;
	//String[] position_req    = null;
	String[] staff_data      = null;

	String posit_code="";
	String shift_code="";
	String prev_staff="";
	String role_typ="";
	String prev_role="";
	String staff_typ="";
	String staff_id1="";
	String staff_name="";
	String shift_cod="";
	String shift_mnemonic="";
	String prod_flag="";
	String shift_indicator="";
	String sql_staff_list="";
	String sql_unproductive_shift="";
	String p_shift_code="";
	String p_shift_mnemonic="";
	String u_shift_code="";
	String u_shift_mnemonic="";
	String o_shift_code="";
	String o_shift_mnemonic="";
	conn = ConnectionManager.getConnection(request);
	try {
		if(view.equals("aloc"))

			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code, c.productive_flag, c.shift_indicator,b.shift_mnemonic, b.day_no, d.staff_name from rs_staff_for_workplace a, rs_master_schedule b, am_shift c, am_staff_vw d where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id = ? and b.workplace_code = ? and b.requirement_id = ? and b.position_code = ? and b.week_no=? and b.role_type = a.role_type and b.staff_id = a.staff_id and c.shift_code = b.shift_code and a.staff_id=d.staff_id and a.role_type=d.role_type  and d.language_id = ? order by d.staff_name, b.day_no";

		else 
			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code,c.productive_flag, c.shift_indicator, b.shift_mnemonic, b.day_no, d.staff_name from rs_staff_for_workplace a, rs_master_schedule b, am_shift c, am_staff_vw d where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id(+) = ? and b.workplace_code(+) = ? and b.requirement_id(+) = ? and b.position_code(+) = ? and b.week_no(+)=? and b.role_type(+) = a.role_type and b.staff_id(+) = a.staff_id and c.shift_code(+) = b.shift_code and a.role_type = d.role_type and a.staff_id = d.staff_id and d.language_id = ? order by d.staff_name, b.day_no";

		//to get the Day Indicator
		String sql_day_indicator="select week_"+week_no+"_day_1 day1, week_"+week_no+"_day_2 day2, week_"+week_no+"_day_3 day3, week_"+week_no+"_day_4 day4, week_"+week_no+"_day_5 day5, week_"+week_no+"_day_6 day6,week_"+week_no+"_day_7 day7 from rs_workplace where facility_id=?and workplace_code=?";

		pstmt_Day_Indicator = conn.prepareStatement( sql_day_indicator);
		pstmt_Day_Indicator.setString(1,facility_id);
		pstmt_Day_Indicator.setString(2,workplace_code);
		rs_Day_Indicator = pstmt_Day_Indicator.executeQuery() ;
		while (rs_Day_Indicator != null && rs_Day_Indicator.next()) {
			record = new String[7];				
			record[0] = rs_Day_Indicator.getString("day1");
			record[1] = rs_Day_Indicator.getString("day2");
			record[2] = rs_Day_Indicator.getString("day3");
			record[3] = rs_Day_Indicator.getString("day4");
			record[4] = rs_Day_Indicator.getString("day5");
			record[5] = rs_Day_Indicator.getString("day6");
			record[6] = rs_Day_Indicator.getString("day7");
			Day_Indicator.add(record) ;
		}
		if(pstmt_Day_Indicator !=null)
			pstmt_Day_Indicator.close();
		if(rs_Day_Indicator !=null)
			rs_Day_Indicator.close();

		//to get the Day Totals Requirements
		String sql_req_total="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a, am_shift b  where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag ='W' ";
		pstmt_Req_Total = conn.prepareStatement( sql_req_total);
		pstmt_Req_Total.setString(1,facility_id);
		pstmt_Req_Total.setString(2,workplace_code);
		pstmt_Req_Total.setString(3,requirement_id);
		rs_Req_Total = pstmt_Req_Total.executeQuery() ;
		while (rs_Req_Total != null && rs_Req_Total.next()) {
			req_Optimal_Values.add(rs_Req_Total.getString("fr_wday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_nwday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_hday_opt")) ;
		}
		if(pstmt_Req_Total !=null)
			pstmt_Req_Total.close();
		if(rs_Req_Total !=null)
			rs_Req_Total.close();

		String sql_oncall_req="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a, am_shift b  where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag ='O' ";
		pstmt_Oncall_Req = conn.prepareStatement( sql_oncall_req);
		pstmt_Oncall_Req.setString(1,facility_id);
		pstmt_Oncall_Req.setString(2,workplace_code);
		pstmt_Oncall_Req.setString(3,requirement_id);
		rs_Oncall_Req = pstmt_Oncall_Req.executeQuery() ;
		while ((rs_Oncall_Req != null) && rs_Oncall_Req.next()) {
			Oncall_Req.add(rs_Oncall_Req.getString("fr_wday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_nwday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_hday_opt")) ;
		}
		if(pstmt_Oncall_Req !=null)
			pstmt_Oncall_Req.close();
		if(rs_Oncall_Req !=null)
			rs_Oncall_Req.close();

		//to get the Day allocated total
		String sql_allocated_total="select week_no,day_no,nvl(count(staff_id),0) no_of_staff, b.productive_flag from rs_master_schedule a, am_shift b where facility_id = ? and workplace_code = ? and requirement_id = ? and week_no=?  and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag in ('W','O')  group by week_no,day_no, b.productive_flag order by week_no,day_no";
		pstmt_Alloc_Total = conn.prepareStatement( sql_allocated_total);
		pstmt_Alloc_Total.setString(1,facility_id);
		pstmt_Alloc_Total.setString(2,workplace_code);
		pstmt_Alloc_Total.setString(3,requirement_id);
		pstmt_Alloc_Total.setString(4,String.valueOf(week_no));
		rs_Alloc_Total = pstmt_Alloc_Total.executeQuery() ;
		while (rs_Alloc_Total != null && rs_Alloc_Total.next()) {
			String p_flag =rs_Alloc_Total.getString("productive_flag");
			if((p_flag!=null)&&(p_flag.equals("W"))){
				day_no=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
				Allocated_Values[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
			}else{
				day_no=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
				Oncall_Allocated[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
			}
		}
		if(pstmt_Alloc_Total !=null)
			pstmt_Alloc_Total.close();
		if(rs_Alloc_Total !=null)
			rs_Alloc_Total.close();

		String sql_unproductive_allocated="SELECT   week_no, day_no, NVL (COUNT (staff_id), 0) no_of_staff    FROM rs_master_schedule a, am_shift b  WHERE facility_id = ?  AND workplace_code = ? AND week_no = ? AND b.shift_code = a.shift_code AND b.shift_indicator = 'U' and a.requirement_id=? GROUP BY week_no, day_no, b.shift_indicator ORDER BY week_no, day_no";
		pstmt_Unprod_Alloc = conn.prepareStatement( sql_unproductive_allocated);
		pstmt_Unprod_Alloc.setString(1,facility_id);
		pstmt_Unprod_Alloc.setString(2,workplace_code);
		pstmt_Unprod_Alloc.setString(3,String.valueOf(week_no));
		pstmt_Unprod_Alloc.setString(4,requirement_id);
		rs_Unprod_Alloc = pstmt_Unprod_Alloc.executeQuery() ;
		while (rs_Unprod_Alloc != null && rs_Unprod_Alloc.next()) {
			week_no	=	Integer.parseInt(rs_Unprod_Alloc.getString("week_no")==null?"0":rs_Unprod_Alloc.getString("week_no"));
			day=Integer.parseInt(rs_Unprod_Alloc.getString("day_no")==null?"0":rs_Unprod_Alloc.getString("day_no"));
			day_no=((week_no-1)*7)+day;
			Unprod_Allocated[day_no-1]=Integer.parseInt(rs_Unprod_Alloc.getString("no_of_staff")==null?"0":rs_Unprod_Alloc.getString("no_of_staff"));
		}
		if(pstmt_Unprod_Alloc !=null)
			pstmt_Unprod_Alloc.close();
		if(rs_Unprod_Alloc !=null)
			rs_Unprod_Alloc.close();

		//to get the Shiftwise Requirements Total
		String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND  b.language_id = ? and a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag in ('W') GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		
		//String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag in ('W') GROUP BY a.shift_code, b.mnemonic_key, b.short_desc and b.language_id = ? ORDER BY shift_code ";

		pstmt_Shiftwise_Req = conn.prepareStatement( sql_shiftwise_total);
		pstmt_Shiftwise_Req.setString(1,facility_id);
		pstmt_Shiftwise_Req.setString(2,locale);
		pstmt_Shiftwise_Req.setString(3,workplace_code);
		pstmt_Shiftwise_Req.setString(4,requirement_id);
		
		rs_Shiftwise_Req = pstmt_Shiftwise_Req.executeQuery() ;
		while (rs_Shiftwise_Req != null && rs_Shiftwise_Req.next()) {
			record = new String[3];				
			record[0] = rs_Shiftwise_Req.getString("fr_wday_opt") ;
			record[1] = rs_Shiftwise_Req.getString("fr_nwday_opt");
			record[2] = rs_Shiftwise_Req.getString("fr_hday_opt");
			Shiftwise_Req.put(rs_Shiftwise_Req.getString("shift_code"),record);
			if(!Shift_Dtl.containsKey(rs_Shiftwise_Req.getString("shift_code"))){
				String shift[] = new String[3];				
				shift[0] = rs_Shiftwise_Req.getString("shift_code");
				shift[1] = rs_Shiftwise_Req.getString("shift_mnemonic");
				shift[2] = rs_Shiftwise_Req.getString("short_desc");
				Shift_Data.add(shift) ;
				Shift_Dtl.put(shift[0],shift[1]);
			}
		}
		if(pstmt_Shiftwise_Req !=null)
			pstmt_Shiftwise_Req.close();
		if(rs_Shiftwise_Req !=null)
			rs_Shiftwise_Req.close();

		//to get the Positionwise Shiftwise Day Totals Requirements
		String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and b.language_id = ? and c.language_id = b.language_id  and a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag in ('W') group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";
		
		//String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag in ('W') group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc and b.language_id = ? and c.language_id = b.language_id order by position_desc, shift_code";

		pstmt_Positionwise_Req = conn.prepareStatement( sql_positionwise_total);
		pstmt_Positionwise_Req.setString(1,facility_id);
		pstmt_Positionwise_Req.setString(2,workplace_code);
		pstmt_Positionwise_Req.setString(3,requirement_id);
		pstmt_Positionwise_Req.setString(4,position_code);
		pstmt_Positionwise_Req.setString(5,position_code);
		pstmt_Positionwise_Req.setString(6,locale);
		rs_Positionwise_Req = pstmt_Positionwise_Req.executeQuery() ;
		while (rs_Positionwise_Req != null && rs_Positionwise_Req.next()) {
			record = new String[8];				
			record[0] = rs_Positionwise_Req.getString("position_code");
			record[1] = rs_Positionwise_Req.getString("position_desc");
			record[2] = rs_Positionwise_Req.getString("shift_code");
			record[3] = rs_Positionwise_Req.getString("mnemonic_key");
			record[4] = rs_Positionwise_Req.getString("shift_desc");
			record[5] = rs_Positionwise_Req.getString("fr_wday_opt");
			record[6] = rs_Positionwise_Req.getString("fr_nwday_opt");
			record[7] = rs_Positionwise_Req.getString("fr_hday_opt");
			Positionwise_Req.add(record) ;
		}
		if(pstmt_Positionwise_Req !=null)
			pstmt_Positionwise_Req.close();
		if(rs_Positionwise_Req !=null)
			rs_Positionwise_Req.close();

		posit_code="";
		PositionShift_Data.clear();
		PositionShift_Dtl.clear();
		for(int i=0;i<Positionwise_Req.size();i++){
			record=(String[])Positionwise_Req.get(i);
			if((!posit_code.equals(record[0]))&&(!PositionShift_Data.isEmpty())){
				PositionShift_Dtl.put(posit_code,PositionShift_Data);
				PositionShift_Data=new ArrayList();
			}
				posit_code=record[0];
				String shift[] = new String[3];				
				shift[0] = record[2];
				shift[1] = record[3];
				shift[2] = record[4];
				PositionShift_Data.add(shift) ;
		}
		PositionShift_Dtl.put(posit_code,PositionShift_Data);
		totalShifts=Shift_Data.size(); 

            _bw.write(_wl_block8Bytes, _wl_block8);
	
		for(int i=0;i<Shift_Data.size();i++){
			record=(String[])Shift_Data.get(i);

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
		}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	
		int optimal=0;
		int alloc_total=0;
		String Day_Indic[]=(String[])Day_Indicator.get(0);
		//to display the total WORKING requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){
			if(Day_Indic[day].equalsIgnoreCase("W")&&(req_Optimal_Values.size()>0))
				optimal=Integer.parseInt((String)req_Optimal_Values.get(0)==null?"0":(String)req_Optimal_Values.get(0));
			if(Day_Indic[day].equalsIgnoreCase("N")&&(req_Optimal_Values.size()>1))
				optimal=Integer.parseInt((String)req_Optimal_Values.get(1)==null?"0":(String)req_Optimal_Values.get(1));
			if(Allocated_Values.length>0)
				alloc_total=Allocated_Values[day];
			if(alloc_total < optimal)
				classval="BELOWOPTIMAL";
			if(alloc_total > optimal)
				classval="ABOVEOPTIMAL";
			if(alloc_total == optimal)
				classval="OPTIMAL";
			if((optimal == 0)&&(alloc_total == 0))
				classval="REQUIREMENT";

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(day));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}/*end of requirement display (for)..*/

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		optimal=0;
		alloc_total=0;
		Day_Indic=(String[])Day_Indicator.get(0);
		//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){

			if(Day_Indic[day].equalsIgnoreCase("W")&&(Oncall_Req.size()>0))
				optimal=Integer.parseInt((String)Oncall_Req.get(0)==null?"0":(String)Oncall_Req.get(0));
			if(Day_Indic[day].equalsIgnoreCase("N")&&(Oncall_Req.size()>1))
				optimal=Integer.parseInt((String)Oncall_Req.get(1)==null?"0":(String)Oncall_Req.get(1));
			if(Oncall_Allocated.length > 0)
				alloc_total=Oncall_Allocated[day];
			if(alloc_total < optimal)
				classval="BELOWOPTIMAL";
			if(alloc_total > optimal)
				classval="ABOVEOPTIMAL";
			if(alloc_total == optimal)
				classval="OPTIMAL";
			if((optimal == 0)&&(alloc_total == 0))
				classval="REQUIREMENT";

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(day));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(day));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(day));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}/*end of requirement display (for)..*/

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		optimal=0;
		alloc_total=0;
		Day_Indic=(String[])Day_Indicator.get(0);
		//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){

			if(Unprod_Allocated.length > 0)
				alloc_total=Unprod_Allocated[day];

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(day));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}/*end of requirement display (for)..*/

            _bw.write(_wl_block37Bytes, _wl_block37);

		if(Positionwise_Req.size()<=0){
			if(position_code !=null){
				String position_desc="";
				//String sql_possition_desc="select distinct position_desc from am_position  where position_code=? ";
				String sql_possition_desc="select position_desc from am_position_lang_vw  where position_code=? and language_id = ? ";
				pstmt_Position_Desc 	= conn.prepareStatement( sql_possition_desc);
				pstmt_Position_Desc.setString(1,position_code);
				pstmt_Position_Desc.setString(2,locale);
				rs_Position_Desc		 					= pstmt_Position_Desc.executeQuery();
				while (rs_Position_Desc != null && rs_Position_Desc.next()){
					position_desc=rs_Position_Desc.getString("position_desc");
				}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
                 if(pstmt_Position_Desc != null)
							pstmt_Position_Desc.close();
						if(rs_Position_Desc != null)
							rs_Position_Desc.close();

		}else{
/***********-------------------Position Wise Data rows --------------------------*****************/
			position_record=(String[])Positionwise_Req.get(0);
			posit_code="";
			for(int position=0;position<Positionwise_Req.size();position++){
				if(position_record != null){
					shift_code=position_record[2];
					if(!posit_code.equals(position_record[0])){
						Unproductive_Shift	 =	 new ArrayList();
						Oncall_Shift			=	new ArrayList();
						//sql_unproductive_shift="SELECT  distinct a.shift_code, a.mnemonic_key, a.productive_flag, a.short_desc FROM am_shift a, rs_workplace_requirement_dtl b WHERE a.shift_code IN (SELECT shift_code FROM am_shift_for_position WHERE position_code = ? AND shift_code IN (SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) AND (a.shift_indicator = 'U' OR (a.productive_flag = 'O' and b.requirement_id=? and a.shift_code=b.shift_code)) AND eff_status = 'E')ORDER BY shift_code";
						sql_unproductive_shift="SELECT  distinct a.shift_code, a.mnemonic_key, a.productive_flag, a.short_desc FROM am_shift_lang_vw a, rs_workplace_requirement_dtl b WHERE a.shift_code IN (SELECT shift_code FROM am_shift_for_position WHERE position_code = ? AND shift_code IN (SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) AND (a.shift_indicator = 'U' OR (a.productive_flag = 'O' and b.requirement_id=? and a.shift_code=b.shift_code)) AND eff_status = 'E') and a.language_id = ? ORDER BY shift_code";
						pstmt_Unproductive 	= conn.prepareStatement( sql_unproductive_shift);
						pstmt_Unproductive.setString(1,position_record[0]);
						pstmt_Unproductive.setString(2,facility_id);
						pstmt_Unproductive.setString(3,workplace_code);
						pstmt_Unproductive.setString(4,requirement_id);
						pstmt_Unproductive.setString(5,locale);
						rs_Unproductive		 					= pstmt_Unproductive.executeQuery();
						while (rs_Unproductive != null && rs_Unproductive.next()){
							record	= new String[3];
							String p_flag=rs_Unproductive.getString("productive_flag");
							if((p_flag != null)&&p_flag.equals("O")){
								record[0]=rs_Unproductive.getString("shift_code");
								record[1]=rs_Unproductive.getString("mnemonic_key");
								record[2]=rs_Unproductive.getString("short_desc");
								Oncall_Shift.add(record);
							}else{
								record[0]=rs_Unproductive.getString("shift_code");
								record[1]=rs_Unproductive.getString("mnemonic_key");
								record[2]=rs_Unproductive.getString("short_desc");
								Unproductive_Shift.add(record);
							}
						}
						if(pstmt_Unproductive != null)
							pstmt_Unproductive.close();
						if(rs_Unproductive != null)
							rs_Unproductive.close();

						shift_count=0;
						posit_code=position_record[0];
						PositionShift_Data=new ArrayList();
						PositionShift_Data =(ArrayList) PositionShift_Dtl.get(posit_code);
						p_shift_code="";
						p_shift_mnemonic="";
						u_shift_code="";
						u_shift_mnemonic="";
						o_shift_code="";
						o_shift_mnemonic="";
						for(int i=0;i<PositionShift_Data.size();i++){
							record=(String[])PositionShift_Data.get(i);
							if(p_shift_code.equals("")){
								p_shift_code=record[0];
								p_shift_mnemonic=record[1];
							}else{
								p_shift_code=p_shift_code+"|"+record[0];
								p_shift_mnemonic=p_shift_mnemonic+"|"+record[1];
							}
						}
						for(int i=0; i<Unproductive_Shift.size();i++){
							record=(String[])Unproductive_Shift.get(i);
							if(u_shift_code.equals("")){
								u_shift_code=record[0];
								u_shift_mnemonic=record[1];
							}else{
								u_shift_code=u_shift_code+"|"+record[0];
								u_shift_mnemonic=u_shift_mnemonic+"|"+record[1];
							}
						}

						for(int i=0; i<Oncall_Shift.size();i++){
							record=(String[])Oncall_Shift.get(i);
							if(o_shift_code.equals("")){
								o_shift_code=record[0];
								o_shift_mnemonic=record[1];
							}else{
								o_shift_code=o_shift_code+"|"+record[0];
								o_shift_mnemonic=o_shift_mnemonic+"|"+record[1];
							}
						}
						int tot_shift = PositionShift_Data.size()+Oncall_Shift.size()+Oncall_Shift.size();
						String exp_legend="-";
						if(PositionShift_Data.size()>0)
							exp_legend="+";
						else
							exp_legend="-";
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(exp_legend));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(position_record[1]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block45Bytes, _wl_block45);

						if(PositionShift_Data.size()>0){

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							for(int i=0; i<PositionShift_Data.size();i++){
								record=(String[])PositionShift_Data.get(i);

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
						}
						if(Oncall_Shift.size()>0){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							for(int i=0; i<Oncall_Shift.size();i++){
								record=(String[])Oncall_Shift.get(i);

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block48Bytes, _wl_block48);
						}
						}
						if(Unproductive_Shift.size()>0){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
		
							for(int i=0; i<Unproductive_Shift.size();i++){
								record=(String[])Unproductive_Shift.get(i);

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
						}

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_shift_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(p_shift_mnemonic));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(u_shift_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(u_shift_mnemonic));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(o_shift_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(o_shift_mnemonic));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(tot_shift));
            _bw.write(_wl_block81Bytes, _wl_block81);
 
		}
					Posit_Allocated_Values=new int[7];
					Positionwise_Alloc.clear();
					String sql_positionwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and a.position_code = ? and a.week_no = ? and a.shift_code=? group by a.shift_code, a.week_no, a.day_no order by a.shift_code";

					//to get the Positionwise Shiftwise Day Totals Requirements 
					pstmt_Positionwise_Alloc = conn.prepareStatement( sql_positionwise_alloc);
					pstmt_Positionwise_Alloc.setString(1,facility_id);
					pstmt_Positionwise_Alloc.setString(2,workplace_code);
					pstmt_Positionwise_Alloc.setString(3,requirement_id);
					pstmt_Positionwise_Alloc.setString(4,posit_code);
					pstmt_Positionwise_Alloc.setString(5,String.valueOf(week_no));
					pstmt_Positionwise_Alloc.setString(6,shift_code);
					rs_Positionwise_Alloc = pstmt_Positionwise_Alloc.executeQuery() ;
					while (rs_Positionwise_Alloc != null && rs_Positionwise_Alloc.next()){
						day_no=Integer.parseInt(rs_Positionwise_Alloc.getString("day_no")==null?"0":rs_Positionwise_Alloc.getString("day_no"));
						Posit_Allocated_Values[day_no-1]=Integer.parseInt(rs_Positionwise_Alloc.getString("allocated")==null?"0":rs_Positionwise_Alloc.getString("allocated"));
						Positionwise_Alloc.put(rs_Positionwise_Alloc.getString("shift_code"),Posit_Allocated_Values);
					}
					
					if(pstmt_Positionwise_Alloc != null)
							pstmt_Positionwise_Alloc.close();
						if(rs_Positionwise_Alloc != null)
							rs_Positionwise_Alloc.close();


            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(position_record[4]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(position_record[3]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(++shift_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
	
					Posit_Allocated_Values=new int[7];
					Posit_Allocated_Values=(int[])Positionwise_Alloc.get(shift_code);		
					Day_Indic=(String[])Day_Indicator.get(0);
					for(day=0;day<Day_Indic.length;day++){

						if(Posit_Allocated_Values != null)
							alloc_val=Posit_Allocated_Values[day];
						else 
							alloc_val=0;
						if(Day_Indic[day].equalsIgnoreCase("W"))
							req_val=Integer.parseInt(position_record[5]==null?"0":position_record[5]);
						if(Day_Indic[day].equalsIgnoreCase("N"))
							req_val=Integer.parseInt(position_record[6]==null?"0":position_record[6]);
						if(Day_Indic[day].equalsIgnoreCase("H"))
							req_val=Integer.parseInt(position_record[7]==null?"0":position_record[7]); 

						if(alloc_val < req_val)
							classval="BELOWOPTIMAL";
						if(alloc_val > req_val)
							classval="ABOVEOPTIMAL";
						if(alloc_val == req_val)
							classval="OPTIMAL";
						if((req_val==0)&&(alloc_val == 0))
							classval="ALOCATED";

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(posit_code));
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}

            _bw.write(_wl_block94Bytes, _wl_block94);

					//check for next position
					if((position+1)<Positionwise_Req.size())
						position_record=(String[])Positionwise_Req.get(position+1);
					//if next position found
					if(!posit_code.equals(position_record[0])){

						//to get the Staff List 

						Staff_Data.clear();
						pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
						pstmt_Staff_List.setString(1,facility_id);
						pstmt_Staff_List.setString(2,workplace_code);
						pstmt_Staff_List.setString(3,role_type);
						pstmt_Staff_List.setString(4,role_type);
						pstmt_Staff_List.setString(5,staff_type);
						pstmt_Staff_List.setString(6,staff_type);
						pstmt_Staff_List.setString(7,staff_id);
						pstmt_Staff_List.setString(8,staff_id);
						pstmt_Staff_List.setString(9,facility_id);
						pstmt_Staff_List.setString(10,workplace_code);
						pstmt_Staff_List.setString(11,requirement_id);
						pstmt_Staff_List.setString(12,posit_code);
						pstmt_Staff_List.setString(13,facility_id);
						pstmt_Staff_List.setString(14,workplace_code);
						pstmt_Staff_List.setString(15,requirement_id);
						pstmt_Staff_List.setString(16,posit_code);
						pstmt_Staff_List.setInt(17,week_no);
						pstmt_Staff_List.setString(18,locale);
						rs_Staff_List = pstmt_Staff_List.executeQuery() ;
						while (rs_Staff_List != null && rs_Staff_List.next()) {
							record = new String[9];				
							record[0] = rs_Staff_List.getString("role_type") ;
							record[1] = rs_Staff_List.getString("staff_type") ;
							record[2] = rs_Staff_List.getString("staff_id") ;
							record[3] = rs_Staff_List.getString("shift_code") ;
							record[4] = rs_Staff_List.getString("productive_flag") ;
							record[5] = rs_Staff_List.getString("shift_indicator") ;
							record[6] = rs_Staff_List.getString("shift_mnemonic") ;
							record[7] = rs_Staff_List.getString("day_no") ;
							record[8] = rs_Staff_List.getString("staff_name") ;
							Staff_Data.add(record);
						}
						if(pstmt_Staff_List != null)
							pstmt_Staff_List.close();
						if(rs_Staff_List != null)
							rs_Staff_List.close();

						day=0;
						day_count=0;
						prev_staff="";
						prev_role="";
						//if staff list found
						if(Staff_Data.size()>0){

							staff_data=(String[])Staff_Data.get(0);
							role_typ=staff_data[0];
							staff_typ=staff_data[1];
							staff_id1=staff_data[2];
							shift_cod=staff_data[3]==null?"":staff_data[3];
							prod_flag=staff_data[4]==null?"":staff_data[4];
							shift_indicator=staff_data[5]==null?"":staff_data[5];
							shift_mnemonic=staff_data[6]==null?"":staff_data[6];
							day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
							staff_name=staff_data[8]==null?"":staff_data[8];
							//for- to display multiple staff for position
							for(int staff=0;staff<Staff_Data.size();staff++){

								if(prod_flag.equals("O"))
									classval="TXTONCALL";
								else
									if(shift_indicator.equals("U"))
									classval="TXTUNPRODUCTIVE";
								else
									classval="TXTSTAFF";

								role_typ=staff_data[0];
								//check for next staff
								if(!(prev_staff.equalsIgnoreCase(staff_id1))||!(prev_role.equalsIgnoreCase(role_typ))){
									prev_staff=staff_id1;
									prev_role=role_typ;

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_typ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( total_records));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block115Bytes, _wl_block115);
	
									total_records++;
									day=0; day_count=0;
								} /*end if check for next staff*/
								//check to display allocated day-shift
								if(day_no==(day+1)){
									day_count++;

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_cod));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prod_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);

								}else{
									//check allocated day
									if(day_no !=0){
										//to display empty text for nonallocated days
										for(day=day_count;day<(day_no-1);day++){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

										}//end for nonallocated cells
										day_count=day+1;

            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_cod));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prod_flag));
            _bw.write(_wl_block152Bytes, _wl_block152);

									}//end if allocated day
								}//end else 
								//check for next staff 
								if((staff+1 )<Staff_Data.size())
									staff_data=(String[])Staff_Data.get(staff+1);
								role_typ=staff_data[0];
								staff_typ=staff_data[1];
								staff_id1=staff_data[2];
								shift_cod=staff_data[3]==null?"":staff_data[3];
								prod_flag=staff_data[4]==null?"":staff_data[4];
								shift_indicator=staff_data[5]==null?"":staff_data[5];
								shift_mnemonic=staff_data[6]==null?"":staff_data[6];
								day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
								staff_name=staff_data[8]==null?"":staff_data[8];

								//check for next staff
								if((!prev_staff.equals(staff_id1))||(!prev_role.equals(role_typ))){
									//check for nonallocated days with week days for prev staff
									if(day_count<7){
										//for - to display empty text for non allocateed days
										for(day=day_count;day<7;day++){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

										}
										day_count=0;

            _bw.write(_wl_block156Bytes, _wl_block156);

									}//end of weekdays
								}
							}

            _bw.write(_wl_block157Bytes, _wl_block157);
			
							if(day_count<7){
								for(day=day_count;day<7;day++){

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(day));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

								}
								day_count=0;	

            _bw.write(_wl_block163Bytes, _wl_block163);

							}
						}/*end if staff list found*/
					}/*end if next position found*/
				}/*end if position data not null*/
			}/*end for (multiple position)*/

			//to get the Staff List 

			Staff_Data.clear();
			pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
			pstmt_Staff_List.setString(1,facility_id);
			pstmt_Staff_List.setString(2,workplace_code);
			pstmt_Staff_List.setString(3,role_type);
			pstmt_Staff_List.setString(4,role_type);
			pstmt_Staff_List.setString(5,staff_type);
			pstmt_Staff_List.setString(6,staff_type);
			pstmt_Staff_List.setString(7,staff_id);
			pstmt_Staff_List.setString(8,staff_id);
			pstmt_Staff_List.setString(9,facility_id);
			pstmt_Staff_List.setString(10,workplace_code);
			pstmt_Staff_List.setString(11,requirement_id);
			pstmt_Staff_List.setString(12,posit_code);
			pstmt_Staff_List.setString(13,facility_id);
			pstmt_Staff_List.setString(14,workplace_code);
			pstmt_Staff_List.setString(15,requirement_id);
			pstmt_Staff_List.setString(16,posit_code);
			pstmt_Staff_List.setInt(17,week_no);
			pstmt_Staff_List.setString(18,locale);
			rs_Staff_List = pstmt_Staff_List.executeQuery() ;
//System.err.println("sql_staff_list="+sql_staff_list);
//System.err.println("facility_id="+facility_id+" workplace_code="+workplace_code+" role_type="+role_type+" staff_type="+staff_type+" staff_id="+staff_id+" requirement_id="+requirement_id+" posit_code"+posit_code+" week_no="+week_no);
			while (rs_Staff_List != null && rs_Staff_List.next()) {
				record = new String[9];				
				record[0] = rs_Staff_List.getString("role_type") ;
				record[1] = rs_Staff_List.getString("staff_type") ;
				record[2] = rs_Staff_List.getString("staff_id") ;
				record[3] = rs_Staff_List.getString("shift_code") ;
				record[4] = rs_Staff_List.getString("productive_flag") ;
				record[5] = rs_Staff_List.getString("shift_indicator") ;
				record[6] = rs_Staff_List.getString("shift_mnemonic") ;
				record[7] = rs_Staff_List.getString("day_no") ;
				record[8] = rs_Staff_List.getString("staff_name") ;
				Staff_Data.add(record);
			}
			if(pstmt_Staff_List != null)
				pstmt_Staff_List.close();
			if(rs_Staff_List != null)
				rs_Staff_List.close();

			prev_staff="";
			prev_role="";
			if(Staff_Data.size()>0){
				staff_data=(String[])Staff_Data.get(0);
				role_typ=staff_data[0];
				staff_typ=staff_data[1];
				staff_id1=staff_data[2];
				shift_cod=staff_data[3]==null?"":staff_data[3];
				prod_flag=staff_data[4]==null?"":staff_data[4];
				shift_indicator=staff_data[5]==null?"":staff_data[5];
				shift_mnemonic=staff_data[6]==null?"":staff_data[6];
				day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
				staff_name=staff_data[8]==null?"":staff_data[8];

				for(int staff=0;staff<Staff_Data.size();staff++){
					if(prod_flag.equals("O"))
						classval="TXTONCALL";
					else
						if(shift_indicator.equals("U"))
						classval="TXTUNPRODUCTIVE";
					else
						classval="TXTSTAFF";

					if((!prev_staff.equalsIgnoreCase(staff_id1))||(!prev_role.equals(role_typ))){
						prev_staff=staff_id1;
						prev_role=role_typ;

            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_typ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( total_records));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( total_records));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block115Bytes, _wl_block115);

						total_records++;
						day=0; day_count=0;
					}
					 /*if its same staff with shifts*/
//System.err.println("staff_id1="+staff_id1+ "day_no="+day_no+" day="+day+ "   day_count="+day_count);
					if(day_no==(day+1)){
						day_count++;

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_cod));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prod_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}else{ 
						if(day_no !=0){
							for(day=day_count;day<(day_no-1);day++){

            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

							}
							day_count=day+1;

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(role_typ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_cod));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(role_typ));
            out.print( String.valueOf(staff_id1));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prod_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
					}
					if((staff+1 )<Staff_Data.size())
						staff_data=(String[])Staff_Data.get(staff+1);
					role_typ=staff_data[0];
					staff_typ=staff_data[1];
					staff_id1=staff_data[2];
					shift_cod=staff_data[3]==null?"":staff_data[3];
					prod_flag=staff_data[4]==null?"":staff_data[4];
					shift_indicator=staff_data[5]==null?"":staff_data[5];
					shift_mnemonic=staff_data[6]==null?"":staff_data[6];
					day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
					staff_name=staff_data[8]==null?"":staff_data[8];

					if((!prev_staff.equals(staff_data[2]))||(!prev_role.equals(role_typ))){
						if(day_count<7){
							for(day=day_count;day<7;day++){

            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

							}
							day_count=0;	

            _bw.write(_wl_block198Bytes, _wl_block198);

						}
					}
				}
			
	/*******************----------------------------***********************/
		
				if(day_count<7){
					for(day=day_count;day<7;day++){

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_role));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prev_staff));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(day));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_role));
            out.print( String.valueOf(prev_staff));
            out.print( String.valueOf(day));
            _bw.write(_wl_block145Bytes, _wl_block145);

					}
					day_count=0;	

            _bw.write(_wl_block94Bytes, _wl_block94);

				}
			}
/******************************/

            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalShifts));
            _bw.write(_wl_block204Bytes, _wl_block204);

			//to display Shift Total data
			for(int shift=0;shift<totalShifts;shift++){

				Shift_Allocated_Values=new int[7];
				shift_record=(String[])Shift_Data.get(shift);
				shift_code=shift_record[0];
				//to get the Shiftwise Requirements Total
				String sql_shiftwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and shift_code=? and a.week_no = ? group by a.shift_code,a.week_no,a.day_no order by a.shift_code";
				pstmt_Shiftwise_Alloc = conn.prepareStatement( sql_shiftwise_alloc);
				pstmt_Shiftwise_Alloc.setString(1,facility_id);
				pstmt_Shiftwise_Alloc.setString(2,workplace_code);
				pstmt_Shiftwise_Alloc.setString(3,requirement_id);
				pstmt_Shiftwise_Alloc.setString(4,shift_code);
				pstmt_Shiftwise_Alloc.setString(5,String.valueOf(week_no));
				rs_Shiftwise_Alloc = pstmt_Shiftwise_Alloc.executeQuery() ;

				while (rs_Shiftwise_Alloc != null && rs_Shiftwise_Alloc.next()) {
					day_no=Integer.parseInt(rs_Shiftwise_Alloc.getString("day_no")==null?"0":rs_Shiftwise_Alloc.getString("day_no"));
					Shift_Allocated_Values[day_no-1]=Integer.parseInt(rs_Shiftwise_Alloc.getString("allocated")==null?"0":rs_Shiftwise_Alloc.getString("allocated"));
					Shiftwise_Alloc.put(rs_Shiftwise_Alloc.getString("shift_code"),Shift_Allocated_Values);
				}
				if(pstmt_Shiftwise_Alloc != null) 
			    pstmt_Shiftwise_Alloc.close() ;
			      if(rs_Shiftwise_Alloc != null) 
			     rs_Shiftwise_Alloc.close() ;

				if(Shiftwise_Req.containsKey(shift_code))
					shift_req=(String[])Shiftwise_Req.get(shift_code);
				else
					shift_req=null;
				if(Shiftwise_Alloc.containsKey(shift_code))
					Shift_Allocated_Values=(int[])Shiftwise_Alloc.get(shift_code);
				else
					Shift_Allocated_Values=null;

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(shift_record[2]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(shift_record[1]));
            _bw.write(_wl_block115Bytes, _wl_block115);

				Day_Indic=(String[])Day_Indicator.get(0);//Day_Indic.length
				for(day=0;day<Day_Indic.length;day++){
					alloc_val=0;
					req_val=0;
					if(Shift_Allocated_Values !=null)
						alloc_val=Shift_Allocated_Values[day];
					else
						alloc_val=0;
					if(Day_Indic[day].equalsIgnoreCase("W")){
						if(shift_req !=null)
							req_val=Integer.parseInt(shift_req[0]==null?"":shift_req[0]);
						else
							req_val=0;
					}
					else{
						if(Day_Indic[day].equalsIgnoreCase("N")){
							if(shift_req !=null)
								req_val=Integer.parseInt(shift_req[1]==null?"0":shift_req[1]);
							else
								req_val=0;
						}
						else{
							if(Day_Indic[day].equalsIgnoreCase("H")){
								if(shift_req !=null)
									req_val=Integer.parseInt(shift_req[2]==null?"0":shift_req[2]);
								else
									req_val=0;
							}
						}
					}
					if(alloc_val < req_val)
						classval="BELOWOPTIMAL";
					if(alloc_val >req_val)
						classval="ABOVEOPTIMAL";
					if(alloc_val == req_val)
						classval="OPTIMAL";
					if((req_val==0)&&(alloc_val == 0))
						classval="SHIFTTOTAL";

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(shift_code));
            out.print( String.valueOf(day));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}

            _bw.write(_wl_block211Bytes, _wl_block211);

			}
		}/*position exists(else part)*/

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(requirement_id));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(view));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(week_no));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block226Bytes, _wl_block226);
	
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally {

		if(pstmt_Req_Total != null) 
			pstmt_Req_Total.close() ;

		if(pstmt_Alloc_Total != null) 
			pstmt_Alloc_Total.close() ;

		if(pstmt_Shiftwise_Req != null) 
			pstmt_Shiftwise_Req.close() ;

		if(pstmt_Positionwise_Req != null) 
			pstmt_Positionwise_Req.close() ;

		if(pstmt_Shiftwise_Alloc != null) 
			pstmt_Shiftwise_Alloc.close() ;

		if(pstmt_Positionwise_Alloc != null) 
			pstmt_Positionwise_Alloc.close() ;

		if(pstmt_Day_Indicator != null) 
			pstmt_Day_Indicator.close() ;

		if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Req_Total != null) 
			rs_Req_Total.close() ;

		if(rs_Alloc_Total != null) 
			rs_Alloc_Total.close() ;

		if(rs_Shiftwise_Req != null) 
			rs_Shiftwise_Req.close() ;

		if(rs_Positionwise_Req != null) 
			rs_Positionwise_Req.close() ;

		if(rs_Shiftwise_Alloc != null) 
			rs_Shiftwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc.close() ;

		if(rs_Day_Indicator != null) 
			rs_Day_Indicator.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;

		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block227Bytes, _wl_block227);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkingShift.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.OncallShift.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.UnproductiveShift.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkingShifts.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.OncallShifts.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.UnproductiveShifts.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

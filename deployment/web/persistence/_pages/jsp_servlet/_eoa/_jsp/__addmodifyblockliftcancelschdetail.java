package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyblockliftcancelschdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/addmodifyBlockLiftCancelSchDetail.jsp", 1742299732705L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eOA/js/BlockLiftCancelSch.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n</head>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n<form name=\'BCLSchDetail_form\' id=\'BCLSchDetail_form\' action=\'../../servlet/eOA.BlockLiftCancelSchServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t   <P>\n\n<table  align=\'right\'>\n<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<td align =\'right\' id=\'prev\'><A HREF=\'javascript:prevRecs(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A></td>\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><A HREF=\'javascript:nextRecs(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</A></td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</td>\n</tr>\n</table>\n<br><br>\n</P>\n\t\t\t\t   <table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'95%\'>\n\t\t\t\t   <th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t   <th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t   <th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll(this);\'  ></th>\n\t\t\t\t   ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\n\t\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td><td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td> <td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' align=middle id=\'noofappts";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t<a href=\"javascript:show_modwin(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\" alt=\'Appointment Details\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td> \n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'no_slots_to_be_blocked";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'no_slots_to_be_blocked";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'time_table_type";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'time_table_type";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_first_visits_blocked";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'total_first_visits_blocked";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_other_visits_blocked";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'total_other_visits_blocked";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_first_visits_available";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'total_first_visits_available";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_other_visits_available";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'total_other_visits_available";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'block_time_from";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'block_time_from";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'block_time_to";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'block_time_to";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'nooffirstvisits";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'nooffirstvisits";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' value=\'0\' size=\'2\' MAXLENGTH=3 onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onblur=\'checkVisits(\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\",\"1\")\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'noofothervisits";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'noofothervisits";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' size=\'2\' MAXLENGTH=3 ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\",\"2\")\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n\t\t\t\t\t\t<input type=\'checkbox\'  name=\'checkBox\'  id=\'checkBox\' value=\'\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="disabled";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" onClick=\'check_cancel(";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =",";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =");\' title=\"Primary Bookings Exist\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'no_of_appt\' id=\'no_of_appt\'  value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'checkbox\'  name=\'checkBox\' id=\'checkBox\' value=\'\' onClick=\'check_cancel(";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =");\' disabled title=\"Primary Bookings Exist\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'no_of_appt\' id=\'no_of_appt\'  value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =");\' title=\"Primary Bookings Exist\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'no_of_appt\' id=\'no_of_appt\'  value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n\t\t\t\t\t\t\t<input type=\'checkbox\'  name=\'checkBox\' id=\'checkBox\' onClick=\'check_cancel(";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =");\' value=\'\'  >\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'no_of_appt\' id=\'no_of_appt\'  value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'vals\' id=\'vals\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="|";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'vals1\' id=\'vals1\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t<script>parent.frames[1].document.forms[0].reportbut.disabled = false;</script>\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<input type=\'hidden\' name=\'no_of_rec\' id=\'no_of_rec\'  value= \'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' >\n\t\t<input type=\'hidden\' name=\'final_vals\' id=\'final_vals\'  value= \'\' >\n\t\t<input type=\'hidden\' name=\'final_vals1\' id=\'final_vals1\'  value= \'\' >\n\t\t<input type=\'hidden\' name=\'action\' id=\'action\'  value= \'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' >\n\t\t<input type=\'hidden\' name=\'sel_rec\' id=\'sel_rec\'  value= \'\' >\n\t\t<input type=\'hidden\' name=\'eff_from\' id=\'eff_from\'  value= \'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' >\n\t\t<input type=\'hidden\' name=\'eff_to\' id=\'eff_to\'  value= \'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' >\n\t\t<input type=\'hidden\' name=\'reason\' id=\'reason\'  value= \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' >\n\t\t<input type=\'hidden\' name=\"reason_desc\" id=\"reason_desc\"  value= \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t\t<input type=\'hidden\' name=\'genrep\' id=\'genrep\'  value= \'\' ></input>\t\t\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"   value=\"OA\"></input>\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"   value=\"OAAFAPLST\"></input>\n\t\t<input type=\"hidden\" name=\"P_Facility_id\" id=\"P_Facility_id\" value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'></input>\n\t\t<input type=\"hidden\" name=\"locncode\" id=\"locncode\" value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'></input>\n\t\t<input type=\"hidden\" name=\"practitioner\" id=\"practitioner\" value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'></input>\n\t\t<input type=\"hidden\" name=\"P_Action\" id=\"P_Action\" value=\'\'></input>\n\t\t<input type=\"hidden\" name=\"P_Report_Title\" id=\"P_Report_Title\" value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'></input>\n\t\t<input type=\"hidden\" name=\"NoOfAppt\" id=\"NoOfAppt\" value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'></input>\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'></input>\n\t\t<input type=\"hidden\" name=\"resourcetype\" id=\"resourcetype\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'></input>\n\t\t<input type=\'hidden\' name=\'default_select\' id=\'default_select\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t<input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t<input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t<input type=\'hidden\' name=\'max_patients_per_day\' id=\'max_patients_per_day\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t\t<input type=\'hidden\' name=\'blk_time_from\' id=\'blk_time_from\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t<input type=\'hidden\' name=\'blk_time_to\' id=\'blk_time_to\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t<input type=\'hidden\' name=\'bulk_blocking_yn\' id=\'bulk_blocking_yn\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t\t<input type=\'hidden\' name=\'blk_schdl_with_appt_yn\' id=\'blk_schdl_with_appt_yn\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\n\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t<input type=\'hidden\' name=\'other_remarks\' id=\'other_remarks\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\n<input type=\'hidden\' name=\'currentPage\' id=\'currentPage\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
 String locale=(String)session.getAttribute("LOCALE");

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String efffrom =request.getParameter("eff_from");
	String effto =request.getParameter("eff_to");
	String action =request.getParameter("action");
	StringBuffer days =new StringBuffer("");
	String visit_limit_rule="";
	String bulk_blocking_yn="N";
	String block_time_from="00:00";
	String block_time_to="00:00";
	//String day =request.getParameter("day");
	String no_appts_booked="0";
	String day_1 =request.getParameter("day_1")==null?"":request.getParameter("day_1");
	String day_2 =request.getParameter("day_2")==null?"":request.getParameter("day_2");
	String day_3 =request.getParameter("day_3")==null?"":request.getParameter("day_3");
	String day_4 =request.getParameter("day_4")==null?"":request.getParameter("day_4");
	String day_5 =request.getParameter("day_5")==null?"":request.getParameter("day_5");
	String day_6 =request.getParameter("day_6")==null?"":request.getParameter("day_6");
	String day_7 =request.getParameter("day_7")==null?"":request.getParameter("day_7");
	String blk_time_to =request.getParameter("blk_time_to")==null?"":request.getParameter("blk_time_to");
	String blk_time_from =request.getParameter("blk_time_from")==null?"":request.getParameter("blk_time_from");

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_remarks = request.getParameter("other_remarks")==null?"":request.getParameter("other_remarks");

	boolean flag=false;
	String time_table_type="";
	if(day_1.equals("Y")){
		day_1="'MONDAY'";
		days.append(day_1);
		flag=true;
	}else{
		day_1="";
	}

	if(day_2.equals("Y")){
		day_2="'TUESDAY'";
		if(flag){
			days.append(","+day_2);
		}else{
			days.append(day_2);
		}
		flag=true;
	}else{
		day_2="";
	}

	if(day_3.equals("Y")){
		day_3="'WEDNESDAY'";
		if(flag){
			days.append(","+day_3);
		}else{
			days.append(day_3);
		}
		flag=true;
	}else{
		day_3="";
	}

	if(day_4.equals("Y")){
		day_4="'THURSDAY'";
		if(flag){
			days.append(","+day_4);
		}else{
			days.append(day_4);
		}
		flag=true;
	}else{
		day_4="";
	}

	if(day_5.equals("Y")){
		day_5="'FRIDAY'";
		if(flag){
			days.append(","+day_5);
		}else{
			days.append(day_5);
		}
		flag=true;
	}else{
		day_5="";
	}

	if(day_6.equals("Y")){
		day_6="'SATURDAY'";
		if(flag){
			days.append(","+day_6);
		}else{
			days.append(day_6);
		}
		flag=true;
	}else{
		day_6="";
	}

	if(day_7.equals("Y")){
		day_7="'SUNDAY'";
		if(flag){
			days.append(","+day_7);
		}else{
			days.append(day_7);
		}
		flag=true;
	}else{
		day_6="";
	}

	String dyas_qry="";
	if(flag){
		dyas_qry="in ("+days.toString()+")";
		//dyas_qry="=rtrim(to_char(clinic_date,'DAY'))";
	}else{
		dyas_qry="=rtrim(to_char(clinic_date,'DAY'))";
		//dyas_qry="in ("+days.toString()+")";
	}
	days.setLength(0);
	
	String practid = request.getParameter("pract_id");
	//out.println("practid::"+practid);
	String locncode = request.getParameter("locn_code");
	String reason = request.getParameter("reason");
	String reason_desc = request.getParameter("reason_desc");
	String resourcetype =request.getParameter("resourcetype");
	String locntype = request.getParameter("locntype");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int    closed=0;
	int no_slots_to_be_blocked=0;

	String blk_schdl_with_appt_yn="N";

StringBuffer strsql2=new StringBuffer();
int blockApptCount=0;
String blockApptFlag="N";
String blockApptSQL="select count(*) from oa_block_appt where FACILITY_ID=? and CLINIC_CODE=? and trunc(BLOCK_DATE)=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')= nvl(?,'X')";
   int currPage=0;


	efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	effto=DateUtils.convertDate(effto,"DMY",locale,"en");

	String care_locn_type_ind="";
	String resource_class="";
	String clinic_day1 = "";
	if(reason_desc == null || reason_desc.equals("null"))  reason_desc = "";
	String cliniccode = "";
	String practname = "";
	String pract = "";
	String max_patients_per_day="";
		String primary_yn = "";
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String clinicdate = "";
	String clinicdate_disp="";
	String noofappts = "";
	String sql = "";
	int k=0;
	String classValue="";
	String res_class="";
	String P_Report_Title = "";
	String start_time = "";
	String end_time = "";
	int total_time__blocking=0;
	String time_per_patient="";
	String time_per_slab="";
	int total_first_visits_available=0;
	int total_other_visits_available=0;
	int total_first_visits_blocked=0;
	int total_other_visits_blocked=0;
	if((blk_time_from!=null&&!blk_time_from.equals(""))&&(blk_time_to!=null&&!blk_time_to.equals(""))){
		StringTokenizer blk_time_from_token=new StringTokenizer(blk_time_from,":");
		StringTokenizer blk_time_to_token=new StringTokenizer(blk_time_to,":");
		int blk_time_from_hrs=0;
		int blk_time_from_mns=0;
		int blk_time_to_hrs=0;
		int blk_time_to_mns=0;
		bulk_blocking_yn="Y";
		while(blk_time_from_token.hasMoreElements()){
			blk_time_from_hrs=Integer.parseInt(blk_time_from_token.nextToken());
			blk_time_from_mns=Integer.parseInt(blk_time_from_token.nextToken());
		}
		while(blk_time_to_token.hasMoreElements()){
			blk_time_to_hrs=Integer.parseInt(blk_time_to_token.nextToken());
			blk_time_to_mns=Integer.parseInt(blk_time_to_token.nextToken());
		}
		if(blk_time_to_mns > blk_time_from_mns){
			total_time__blocking=((blk_time_to_hrs-blk_time_from_hrs)*60)+(blk_time_to_mns-blk_time_from_mns);
		}else{
			total_time__blocking=((blk_time_to_hrs-blk_time_from_hrs)*60)-(blk_time_from_mns-blk_time_to_mns);
		}
		
	}else{
		bulk_blocking_yn="N";
	}



    int i=1;


            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con = null;
		Statement stmt = null,stmt1=null;
		PreparedStatement pstmt=null;
		ResultSet rset = null,rset1=null,prs=null;
		ResultSet rs1=null;
		int maxRecord = 0;
		String sql_param="SELECT VISIT_LIMIT_RULE,BLK_SCHDL_WITH_APPT_YN FROM oa_param where module_id='OA'";		
	 	
	try
		{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			stmt1=con.createStatement();
			rs1= stmt.executeQuery(sql_param);
			if(rs1!=null && rs1.next()){
				visit_limit_rule=rs1.getString("VISIT_LIMIT_RULE");
				blk_schdl_with_appt_yn=rs1.getString("BLK_SCHDL_WITH_APPT_YN")==null?"N":rs1.getString("BLK_SCHDL_WITH_APPT_YN");
			}
						int start = 0 ;
						int end = 0 ;

						if ( from == null )
							start = 1 ;
						else
							start = Integer.parseInt( from ) ;

						if ( to == null )
							end = 14 ;
						else
							end = Integer.parseInt( to ) ;

			if(action.equals("B"))
			{
					
					if(bulk_blocking_yn.equals("Y")){
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql=" from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND NVL (schedule_status, '*') NOT IN  ('B', 'X') AND time_table_type in ('1', '2') and (FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID) in  (select FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+practid+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date BETWEEN TO_DATE ('"+efffrom+"', 'dd/mm/yyyy') AND TO_DATE ('"+effto+"', 'dd/mm/yyyy') AND to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND NVL (schedule_status, '*') NOT IN  ('B', 'X'))";
				
                /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql=" from oa_clinic_schedule_vw where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND NVL (schedule_status, '*') NOT IN  ('B', 'X') AND time_table_type in ('1', '2') and (FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID) in  (select FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+practid+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date BETWEEN TO_DATE ('"+efffrom+"', 'dd/mm/yyyy') AND TO_DATE ('"+effto+"', 'dd/mm/yyyy') AND to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND NVL (schedule_status, '*') NOT IN  ('B', 'X')) AND (eff_status != 'D' OR eff_status IS NULL)";
					
					
					}else{
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') and NVL(schedule_status,'X') <> nvl( 'B','X')";  
					
					/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
					sql = " from oa_clinic_schedule_vw where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') and NVL(schedule_status,'X') <> nvl( 'B','X') AND (eff_status != 'D' OR eff_status IS NULL)";  
					
					}
					sql=sql+" order by clinic_name,to_date(clinic_date,'dd/mm/yyyy')" ;
			}
			else if(action.equals("L"))
			{
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(schedule_status,'X') = nvl('B','X') and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy')  order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
				
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql = " from oa_clinic_schedule_vw  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(schedule_status,'X') = nvl('B','X') and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND (eff_status != 'D' OR eff_status IS NULL) order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
			}
			else if(action.equals("C"))
			{
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"'  and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy')  order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
					/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
					sql = " from oa_clinic_schedule_vw  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"'  and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND (eff_status != 'D' OR eff_status IS NULL) order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
			}
			if(stmt!=null)stmt.close();
			stmt=con.createStatement();
			if(reason_desc.equals(""))
			{
				rset = stmt.executeQuery("Select CONTACT_REASON from AM_CONTACT_REASON_LANG_VW Where CONTACT_REASON_CODE ='"+reason+"' and language_id = '"+locale+"'");
				if(rset.next())
					reason_desc = rset.getString("CONTACT_REASON");
			}
			if(rset !=null) rset.close();
			
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			
			//String sql2="Select time_table_type,to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT1,to_char(TIME_PER_SLAB,'hh24:mi') TIME_PER_SLAB1,MAX_FIRST_VISITS,TOTAL_FIRST_VISIT,TOTAL_FIRST_VISITS_BLOCKED,TOTAL_FOLLOW_UP, TOTAL_ROUTINE, TOTAL_SERIES, TOTAL_CONSULT,TOTAL_OTHER_VISITS_BLOCKED,MAX_OTHER_VISITS,clinic_code, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) practitioner_full_name, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_clinic_schedule.facility_id and CLINIC_CODE=oa_clinic_schedule.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC, resource_class resource_class_desc, to_char(clinic_date,'dd/mm/yyyy') clinic_date, to_char(clinic_date,'Day') clinic_day1, TO_CHAR(clinic_date, 'DAY') clinic_day,(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (clinic_date, 'DAY'))) CLINIC_DAY_NO ,  (nvl(total_slots_booked,0)+nvl(total_slots_overbooked,0)) no_of_appts, PRACTITIONER_ID, care_locn_type_ind, resource_class,to_char(START_TIME,'hh24:mi') START_TIME,to_char(END_TIME,'hh24:mi') END_TIME,MAX_PATIENTS_PER_DAY ";
			
			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			String sql2="Select time_table_type,to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT1,to_char(TIME_PER_SLAB,'hh24:mi') TIME_PER_SLAB1,MAX_FIRST_VISITS,TOTAL_FIRST_VISIT,TOTAL_FIRST_VISITS_BLOCKED,TOTAL_FOLLOW_UP, TOTAL_ROUTINE, TOTAL_SERIES, TOTAL_CONSULT,TOTAL_OTHER_VISITS_BLOCKED,MAX_OTHER_VISITS,clinic_code, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) practitioner_full_name, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_clinic_schedule_vw.facility_id and CLINIC_CODE=oa_clinic_schedule_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC, resource_class resource_class_desc, to_char(clinic_date,'dd/mm/yyyy') clinic_date, to_char(clinic_date,'Day') clinic_day1, TO_CHAR(clinic_date, 'DAY') clinic_day,(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (clinic_date, 'DAY'))) CLINIC_DAY_NO ,  (nvl(total_slots_booked,0)+nvl(total_slots_overbooked,0)) no_of_appts, PRACTITIONER_ID, care_locn_type_ind, resource_class,to_char(START_TIME,'hh24:mi') START_TIME,to_char(END_TIME,'hh24:mi') END_TIME,MAX_PATIENTS_PER_DAY ";
			
			if(action.equals("C")){
			
				
				/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule.facility_id and clinic_code=oa_clinic_schedule.clinic_code and RESOURCE_CLASS=oa_clinic_schedule.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule.clinic_date) and appt_status='A') closed";
				
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule_vw.facility_id and clinic_code=oa_clinic_schedule_vw.clinic_code and RESOURCE_CLASS=oa_clinic_schedule_vw.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule_vw.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule_vw.clinic_date) and appt_status='A') closed";
			}

			if(action.equals("B")&& (blk_time_from!=null&&!blk_time_from.equals(""))&&(blk_time_to!=null&&!blk_time_to.equals("")) ){
			        /*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule.facility_id and clinic_code=oa_clinic_schedule.clinic_code and RESOURCE_CLASS=oa_clinic_schedule.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule.clinic_date) AND to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(APPT_SLAB_TO_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi')) no_appts_booked";
			    
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
       			sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule_vw.facility_id and clinic_code=oa_clinic_schedule_vw.clinic_code and RESOURCE_CLASS=oa_clinic_schedule_vw.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule_vw.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule_vw.clinic_date) AND to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(APPT_SLAB_TO_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi')) no_appts_booked";
			}
			
			
			rset = stmt.executeQuery(sql2+sql);	
					strsql2.append(sql2+sql);
			strsql2.setLength(0);

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
			}

			//int m=1;
		while ( i<=end && rset.next()  )
		{
			if(maxRecord==0)
			{

					
				   
            _bw.write(_wl_block9Bytes, _wl_block9);
if ( !(start <=1) ){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

}
//if ( !( (start+14) > maxRecord ) )
	{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
  

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(bulk_blocking_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
				  
						cliniccode=rset.getString("clinic_code");
						practname=rset.getString("practitioner_full_name");
						pract = rset.getString("PRACTITIONER_ID");
						if(pract==null)pract="";
				
						clinicdate=rset.getString("clinic_date");
						clinicdate_disp=DateUtils.convertDate(clinicdate,"DMY","en",locale);

						clinic_day1 = rset.getString("CARE_LOCN_TYPE_DESC");
						

						care_locn_type_ind= rset.getString("care_locn_type_ind");
						resource_class= rset.getString("resource_class");
						start_time = rset.getString("start_time");
						end_time = rset.getString("end_time");
						max_patients_per_day= rset.getString("MAX_PATIENTS_PER_DAY");
						if(resource_class.equals("P"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(resource_class.equals("R"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(resource_class.equals("E"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(resource_class.equals("O"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}
						blockApptFlag="N";
						if(action.equals("B") && (blk_time_from.equals("") && blk_time_to.equals(""))){
							pstmt=con.prepareStatement(blockApptSQL);
							pstmt.setString(1,facilityId);
							pstmt.setString(2,cliniccode);
							pstmt.setString(3,clinicdate);
							pstmt.setString(4,pract);
							prs=pstmt.executeQuery();
							if(prs!=null && prs.next()){
								blockApptCount=Integer.parseInt(prs.getString(1)==null?"0":prs.getString(1));
							}
							if(blockApptCount > 0){
								blockApptFlag="Y";
							}
							if(prs!=null)prs.close();
							if(pstmt!=null)pstmt.close();
						}

						String clinic_day=rset.getString("clinic_day");
						clinic_day=clinic_day.trim();						
						if(clinic_day.equalsIgnoreCase("MONDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("TUESDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("WEDNESDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("THURSDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("FRIDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("SATURDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(clinic_day.equalsIgnoreCase("SUNDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

						noofappts = rset.getString("total_slots_booked");
						time_table_type = rset.getString("TIME_TABLE_TYPE");
						time_per_patient = rset.getString("TIME_PER_PATIENT1");
						time_per_slab = rset.getString("TIME_PER_SLAB1");
						String timeperslotslab="";
						int time_per_patient_setup=0;
						if(bulk_blocking_yn.equals("Y")){
							timeperslotslab=time_per_patient;
							int time_per_patient_hrs=0;
							int time_per_patient_mns=0;
							String time_per_patient_time="";
								StringTokenizer time_per_patient_token2=new StringTokenizer(time_per_patient_time,":");
								if(time_per_patient_token2.hasMoreElements()){
									time_per_patient_hrs=Integer.parseInt(time_per_patient_token2.nextToken());
									time_per_patient_mns=Integer.parseInt(time_per_patient_token2.nextToken());
								if(time_per_patient_hrs >0){
									time_per_patient_setup=time_per_patient_hrs*60;
								}
								time_per_patient_setup=time_per_patient_setup+time_per_patient_mns;
							}
							//no_slots_to_be_blocked=total_time__blocking/time_per_patient_setup;
							total_first_visits_available=Integer.parseInt(rset.getString("MAX_FIRST_VISITS")==null?"0":rset.getString("MAX_FIRST_VISITS"))-(Integer.parseInt(rset.getString("TOTAL_FIRST_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_FIRST_VISITS_BLOCKED"))+Integer.parseInt(rset.getString("TOTAL_FIRST_VISIT")==null?"0":rset.getString("TOTAL_FIRST_VISIT")));
							if(time_table_type.equals("2")){
								timeperslotslab=time_per_slab;
							}

							int total_follow_up=0;
							int total_routine=0;
							int total_series=0;
							int total_consult=0;
							total_other_visits_blocked=0;
							total_first_visits_blocked=0;
							int max_other_visits=0;
							total_first_visits_blocked=Integer.parseInt(rset.getString("TOTAL_FIRST_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_FIRST_VISITS_BLOCKED"));
							total_follow_up=Integer.parseInt(rset.getString("TOTAL_FOLLOW_UP")==null?"0":rset.getString("TOTAL_FOLLOW_UP"));
							total_routine=Integer.parseInt(rset.getString("TOTAL_ROUTINE")==null?"0":rset.getString("TOTAL_ROUTINE"));
							total_series=Integer.parseInt(rset.getString("TOTAL_SERIES")==null?"0":rset.getString("TOTAL_SERIES"));
							total_consult=Integer.parseInt(rset.getString("TOTAL_CONSULT")==null?"0":rset.getString("TOTAL_CONSULT"));
							total_other_visits_blocked=Integer.parseInt(rset.getString("TOTAL_OTHER_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_OTHER_VISITS_BLOCKED"));
							max_other_visits=Integer.parseInt(rset.getString("MAX_OTHER_VISITS")==null?"0":rset.getString("MAX_OTHER_VISITS"));
							if(max_other_visits > (total_follow_up+total_routine+total_series+total_consult+total_other_visits_blocked)){
								total_other_visits_available=max_other_visits-(total_follow_up+total_routine+total_series+total_consult+total_other_visits_blocked);
							}
							no_appts_booked=rset.getString("NO_APPTS_BOOKED")==null?"0":rset.getString("NO_APPTS_BOOKED");
						}
						if(bulk_blocking_yn.equals("Y")){
							String blockCount="SELECT count(*) no_of_slots_avbl FROM oa_clinic_schedule_slot_slab WHERE facility_id = '"+facilityId+"' AND clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+pract+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date = TO_DATE ('"+clinicdate+"', 'dd/mm/yyyy') AND TO_DATE (TO_CHAR (slot_slab_start_time, 'hh24:mi'),'hh24:mi') BETWEEN TO_DATE ('"+blk_time_from+"', 'hh24:mi') AND TO_DATE ('"+blk_time_to+"', 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') BETWEEN TO_DATE ('"+blk_time_from+"', 'hh24:mi') AND TO_DATE ('"+blk_time_to+"', 'hh24:mi') and  NVL(schedule_status, '*') not in ('B','X')";
							rset1=stmt1.executeQuery(blockCount);
							if(rset1!=null && rset1.next()){
								no_slots_to_be_blocked=Integer.parseInt(rset1.getString("no_of_slots_avbl")==null?"0":rset1.getString("no_of_slots_avbl"));
							}
							if(rset1!=null)rset1.close();
						}
							primary_yn = rset.getString("primary_resource_yn");
							if(action.equals("C"))
							closed=rset.getInt("closed");
						if (pract==null) pract="";
						if(bulk_blocking_yn.equals("Y"))
							noofappts=no_appts_booked;
						
						String pract1="";					
						pract1 = pract;
						if(pract1.equals("")) {
							pract1="X";
						}

						if(practname == null || practname.equals(""))
							practname = "&nbsp";
						if ( k % 2==0 )
								classValue = "QRYODD" ;
						else
								classValue = "QRYEVEN" ;
						if(noofappts==null || noofappts.equals("null"))
							noofappts="";
				if(!(noofappts.equals("0"))){	
					 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_day1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("clinic_name")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinicdate_disp));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_day));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(primary_yn.equals("Y")){
						 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinicdate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinic_day1.trim()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block34Bytes, _wl_block34);
 }else{ 
						 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_day1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("clinic_name")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinicdate_disp));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block37Bytes, _wl_block37);

						}
						 String disableFlag="";
						 if(visit_limit_rule.equals("N")){
							 disableFlag="disabled";
						 }
						 if(!noofappts.equals("0"))
							 disableFlag="disabled";
						
            _bw.write(_wl_block38Bytes, _wl_block38);
if(bulk_blocking_yn.equals("Y")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(timeperslotslab));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(no_slots_to_be_blocked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(no_slots_to_be_blocked));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(k));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(k));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(total_first_visits_blocked));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(k));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(total_other_visits_blocked));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(k));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(total_first_visits_available));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(total_other_visits_available));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(block_time_from));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(k));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(block_time_to));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(k));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(k));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(k));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disableFlag));
            _bw.write(_wl_block62Bytes, _wl_block62);
if(visit_limit_rule.equals("N")){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(no_slots_to_be_blocked));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disableFlag));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(k));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(k));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disableFlag));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
						}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
if((primary_yn.equals("N") && ! noofappts.equals("0")|| (!action.equals("B")))){
            _bw.write(_wl_block69Bytes, _wl_block69);
if(action.equals("C") && closed >0){
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(k));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else if((primary_yn.equals("Y") && ! noofappts.equals("0")) && blk_schdl_with_appt_yn.equals("N")){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(k));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else if((primary_yn.equals("Y") && ! noofappts.equals("0")) && blk_schdl_with_appt_yn.equals("Y")){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(k));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else {
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(k));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
if(action.equals("B") && (blk_time_from.equals("") && blk_time_to.equals(""))){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pract1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(clinicdate));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rset.getString("CLINIC_DAY_NO")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(blockApptFlag));
            _bw.write(_wl_block84Bytes, _wl_block84);
}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pract1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(clinicdate));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rset.getString("CLINIC_DAY_NO")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pract1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(clinicdate));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rset.getString("CLINIC_DAY_NO")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
	k++;
						i++;
						maxRecord++;
					} 
if(maxRecord == 0)
	{
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
            _bw.write(_wl_block87Bytes, _wl_block87);
}

	if ( maxRecord < 14 || (!rset.next()) ) {
	
            _bw.write(_wl_block88Bytes, _wl_block88);
 
			} else {
            _bw.write(_wl_block89Bytes, _wl_block89);
}				


		}
		catch(Exception e){
			//out.print("sum" +e);
			e.printStackTrace();
		}finally{
			try{
				if(rset != null)rset.close();
				if(rset1 != null)rset1.close();
				if(stmt != null) stmt.close();
				if(stmt1 != null) stmt1.close();
				if(rs1 != null) rs1.close();
				if(pstmt != null) pstmt.close();
				if(prs != null) prs.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(k));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(action));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(efffrom));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(effto));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(reason_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(P_Report_Title));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(resourcetype));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(default_select));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(max_patients_per_day));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(blk_time_from));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(blk_time_to));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bulk_blocking_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(blk_schdl_with_appt_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(other_remarks));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block114Bytes, _wl_block114);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourceclass.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcename.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NoOfAppts.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.timeperslotslab.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Slotstobeblocked.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.nooffirstvisits.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.noofothervisits.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}

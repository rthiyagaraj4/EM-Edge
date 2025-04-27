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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __apptdairy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ApptDairy.jsp", 1717168812106L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> \t\t\n29/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Reopened - added order_id in var params(functions callthis, rfresh, nextMonth, previousMonth, change_schedule > \t\t\t\t\t\t\t\t \n---------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="    \n<html>\n  \n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'> </script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eOA/js/ApptDiary.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<SCRIPT>\n         function callthis(obj,obj2)\n{\n\n\tif(obj.value ==\"\")\n\t{\n\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\'\n\t\tdocument.forms[0].practitioner_name.value=\"\";\n\t\tdocument.forms[0].practitioner_id.value=\"\";\n\t\tvar param=\"../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=\"+obj.value+\"&i_clinic_code=\"+obj2.value+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&i_appt_date=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&alcn_criteria=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&obook_appt_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&tfr_appt_across_catg_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&status=P1&clinic_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&res_type=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Forced=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&visit_limit_rule=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&slot_appt_ctrl=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&old_visit_type_ind1=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&old_alcn_catg_code1=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&no_of_slots_value1=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&patient_id1=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&old_pract_id1=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&old_clinic_code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&curr_month=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&rd_appt_yn=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&order_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&order_catalog_code=\"+document.forms[0].order_catalog_code.value; //--[IN027165]\n\t\t\t\tlocation.href=param\n\t}else\n\t{\n\t}\n}\n\t\tfunction nextMonth(Totnum)\n\t\t{\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\'\n\n\t\t\t\tTotnum=Totnum+1\n\t\t\t\tvar param=\"../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=\"+document.forms[0].practitioner_id.value+\"&i_clinic_code=\"+document.forms[0].clinic_code.value+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&TotNum=\"+Totnum+\"&visit_limit_rule=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&order_catalog_code=\"+document.forms[0].order_catalog_code.value; //--[IN027165]\n\t\t\t\tself.location.href=param\n\t\t}\n\n\t\tfunction previousMonth(Totnum)\n\t\t{\n\t\t\tif(Totnum>0)\n\t\t\t{\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\'\n\n\t\t\t\tTotnum=Totnum-1\n\t\t\t\tvar param=\"../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=\"+document.forms[0].practitioner_id.value+\"&i_clinic_code=\"+document.forms[0].clinic_code.value+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&clinic_type=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&status=M1&TotNum=\"+Totnum+\"&visit_limit_rule=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&order_catalog_code=\"+document.forms[0].order_catalog_code.value; //--[IN027165]\n\t\t\t\tself.location.href=param\n\t\t\t}\n\t\t}\n\n\t\tfunction rfresh(obj)\n\t\t{\n\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tvar param=\"../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&i_clinic_code=\"+obj.value+\"&visit_limit_rule=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&order_catalog_code=\"+document.forms[0].order_catalog_code.value;\n\t//--[IN027165]\n\t\t\t\tself.location.href=param\n\t\t}\n\nfunction change_schedule(obj,obj1){ \n     var res_type=document.forms[0].res_type.value;           \n\t  /*Below Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238] */\t\t\n\t\tvar param=\"../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=\"+obj.value+\"&i_clinic_code=\"+document.forms[0].clinic_code.value+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&i_team_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&over_booked=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&res_type=\"+document.forms[0].res_type.value+\"&alcn_criteria=\"+document.forms[0].alcn_criteria.value+\"&visit_limit_rule=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&practitioner_name=\"+obj1.value+\"&curr_month=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&order_catalog_code=\"+document.forms[0].order_catalog_code.value;  //--[IN027165]\n\t\tself.location.href=param\t\n        /*Below If Condition Added for this SCF ML-BRU-SCF-0240 [IN:033238] */\t\t\n\t\tif(document.forms[0].practitioner_name1.value && document.forms[0].practitioner_name1.value!=obj1.value){\t\n\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\'\t\t\n\t\t}\n}\n\n\n\t</SCRIPT>\n\t</head>\n\n\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t<form>\n\t\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'RESCHEDULE_APPOINTMENT\'>\n\t<table border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t\n\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\n\n\n\n\n<td class=\'fields\'><b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></td></tr>\n\n<tr><td class=\'label\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n<!--onBlur method If Condition Added for this SCF ML-BRU-SCF-0240 [IN:033238] */\t -->\n<td class=\'fields\'><input type=\'text\' name=\'b_loc_val\' id=\'b_loc_val\' size=\'25\' maxlength=\'25\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onBlur=\'ena_loc_lookup(this);\'><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup(this);\" class=\'button\' ></td>\n</tr>\n \t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t<tr id=\'resource_part\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t\t\t<tr><td class=\'label\' colspan=\'2\'></td></tr><tr><td class=\'label\' colspan=\'2\'></td></tr>\n\t\t\t<tr><td class=\'label\' colspan=\'2\'></td></tr><tr><td class=\'label\' colspan=\'2\'></td></tr>\n\t\t\t<tr><td class=\'white\' colspan=\'2\'>&nbsp;</td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr>\n\n\n</table>\n\t\t\t\n<table  align=\'center\' border=0 cellspacing=0 cellpadding=0 width=\'98%\'>\n\t\t\t\n\t<tr >\n\t\t\t\t<td  width=\'98%\' class=\'white\' >\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\n<table cellspacing=0 cellpadding=0  width=\'98%\' style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt\' border=\'0\'>\n\t\t\t\t\t\n\t<tr>\n\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"<---\" name=\'prev\' id=\'prev\'  onclick=previousMonth(";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =")></td>\n\t\t\t\t\n\t\t\t\t<td align=\'center\' class=\"DISPDATE\" width=\'140%\'><font size=3><b>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</b></font></td>\n\t\t\t\t\n\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"--->\" name=\'next\' onclick=nextMonth(";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =")></td>\n\t</tr>\n</table>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t</td>\n\t</tr>\n\t\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n\t\t\t<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n\t\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_alcn_catg_code\' id=\'old_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >\n\t\t\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' >\n\t\t\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n\t\t\t<input type=\'hidden\' name=\'obook_appt_yn\' id=\'obook_appt_yn\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<input type=\'hidden\' name=\'practitioner_name1\' id=\'practitioner_name1\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\'hidden\' name=\'Forced\' id=\'Forced\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' >\n\t\t\t<input type=\'hidden\' name=\'team_id\' id=\'team_id\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' >\n\t\t\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_visit_type_ind1\' id=\'old_visit_type_ind1\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_alcn_catg_code1\' id=\'old_alcn_catg_code1\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' >\n\t\t\t<input type=\'hidden\' name=\'no_of_slots_value1\' id=\'no_of_slots_value1\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' >\n\t\t\t<input type=\'hidden\' name=\'patient_id1\' id=\'patient_id1\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_pract_id1\' id=\'old_pract_id1\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_clinic_code\' id=\'old_clinic_code\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' >\n\t\t\t<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' >\n\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t\t\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t\t\t<input type=\'hidden\' name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' >\n\t\t\t</form>\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t<tr>\n\t\t\n<table width=\'96%\'  align=\'center\' cellpadding=0  style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt \'>\n\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t<th width=\'3%\' align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</th>\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\n\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t<tr>\n\t\t\t\t  \t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' align=\'center\' width=\'3%\'><font \tsize=2>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</a></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' align=\'center\' width=\'3%\'><font size=2>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</a></td>\n\t\t\t\t  \t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<td  align=\'center\' width=\'3%\'><font size=2>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t  </tr>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t</tr>\n<script>\n\n\tvar resc_type=document.forms[0].res_type.value;\n\tdocument.getElementById(\"resourceType1\").value=resc_type;\n\n</script>\n</table>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );
 int TotNum=0;

	public String getCalendarString(Connection con,String arg)
			{
				
				Statement stmt=null;
				ResultSet rs=null;
				String RetString="";
				try
				{
					
					stmt=con.createStatement();
					rs=stmt.executeQuery("select get_calendar_string('"+arg+"') calstr from dual");
					if(rs.next())
					RetString=rs.getString("calstr");
					if(rs!=null)			rs.close();
					if(stmt!=null)		stmt.close();
				}
				catch(Exception e)
				{}
				finally
				{
					try
					{
						if(stmt!=null)		stmt.close();
						if(rs!=null)			rs.close();
						
					}
					catch(Exception e){}
				}

				return RetString;
			}
			
			

			public String getCalanderStatusColor(String Facility_Id,String Clinic_Code, String Practitioner_Id, Connection con,String arg)
			{
				//Statement stmt=null;
				PreparedStatement pstmt = null;
				ResultSet rs=null;
				String RetString="";				
				String sql = "";				
				try
				{
		   			//below lined modified by Kamatchi S for security issue against COMMON-ICN-0165
					//stmt=con.createStatement();
					//rs=stmt.executeQuery("SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Practitioner_Id+"','"+arg+"') stss FROM DUAL");
					sql = " SELECT GET_CALENDAR_STATUS_COLOR (?,?,?,?) stss FROM DUAL";
					pstmt   = con.prepareStatement(sql);
					pstmt.setString(1, Facility_Id);
					pstmt.setString(2, Clinic_Code);
					pstmt.setString(3, Practitioner_Id);
					pstmt.setString(4, arg);
					//System.err.println("SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Practitioner_Id+"','"+arg+"') stss FROM DUAL");
					rs=pstmt.executeQuery();
					if(rs.next())
						RetString=rs.getString("stss");
						if(rs!=null)			rs.close();
						//if(stmt!=null)		stmt.close();
						if(pstmt!=null)		pstmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:";
				}
				
				return RetString;
			}
			
	

		public String getYearMonth(String state, int TotNum)
		{
			Calendar cal=Calendar.getInstance();
			int current=cal.get(Calendar.MONTH);

			String arg="";
			String mont="";
			if(state.equals("previous"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);

				if(cal.get(Calendar.MONTH)>=current)
					state="current";
			}

			if(state.equals("current"))
			{
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(state.equals("next"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(mont.length()==1)
					mont=0+mont;
				arg=arg+mont;
			return arg;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String Practitioner_Id=request.getParameter("i_practitioner_id");
	String clinic_code=request.getParameter("i_clinic_code");
	String practitioner_id=request.getParameter("i_practitioner_id");
	if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
	String apptrefno=request.getParameter("i_appt_ref_no");
	String obook_appt_yn=request.getParameter("obook_appt_yn");
	if( obook_appt_yn == null || obook_appt_yn.equals("null") ) obook_appt_yn="";
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	String practitioner_name=(String)request.getParameter("practitioner_name");
	if(practitioner_name ==null) practitioner_name="";
	String clinic_name1=(String)request.getParameter("clinic_name");
	if(clinic_name1 ==null) clinic_name1="";
	String old_alcn_catg_code="";
	//String clinic_name="";
	//String new_practitioner_name="";
	//String new_practitioner_id="";
	String speciality_code="";
//	String service_desc="";
	String overbookedyn=request.getParameter("over_booked");
	String visit_type_ind=request.getParameter("visit_type_ind");
	String team_id=request.getParameter("i_team_id");

	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String order_id=request.getParameter("order_id");//--[IN027165]

	String visit_limit_rule=request.getParameter("visit_limit_rule");
	String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");

	String old_visit_type_ind1=request.getParameter("old_visit_type_ind1");
	String old_alcn_catg_code1=request.getParameter("old_alcn_catg_code1");
	String no_of_slots_value1=request.getParameter("no_of_slots_value1");
	String patient_id1=request.getParameter("patient_id1");
	String old_pract_id1=request.getParameter("old_pract_id1");	
	String old_clinic_code=request.getParameter("old_clinic_code")==null?"":request.getParameter("old_clinic_code");	
	int curr_month=Integer.parseInt(request.getParameter("curr_month"));
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn");

	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";

	String Forced=request.getParameter("Forced");


	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}

	String res_class_desc="";
	if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}else if(res_type.equals("B")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
	}


	String chk_flg="N";
	if(Practitioner_Id==null || Practitioner_Id.equals("null"))Practitioner_Id="";
	if(clinic_code==null)clinic_code="";
	if(team_id==null)team_id="";
	if(visit_type_ind==null)visit_type_ind="";
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	String locale=(String)session.getAttribute("LOCALE");
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block41Bytes, _wl_block41);

			Connection con = null;
			//Statement stmt=null;//modified by Kamatchi S for security issue against COMMON-ICN-0165
			PreparedStatement pstmt = null;
	
 			ResultSet rs=null;
			int coi=0;
			String week[]=new String[7];
			String day_type1[]=new String[7];
			String day_type2[]=new String[7];
			String day_type3[]=new String[7];
			String day_type4[]=new String[7];
			String day_type5[]=new String[7];
			if(rs !=null) rs.close();
			try{

				con = ConnectionManager.getConnection(request);
				//stmt=con.createStatement();//modified by Kamatchi S for security issue against COMMON-ICN-0165
			String sql_week="select substr(DAY_OF_WEEK,1,3) dw ,DAY_TYPE dt ,DAY_NO dn,DAY_TYPE_WEEK_1,DAY_TYPE_WEEK_2,DAY_TYPE_WEEK_3,DAY_TYPE_WEEK_4,DAY_TYPE_WEEK_5 from sm_day_of_week order by DAY_NO";
				//rs=stmt.executeQuery(sql_week);//modified by Kamatchi S for security issue against COMMON-ICN-0165
				pstmt   = con.prepareStatement(sql_week);
				rs=pstmt.executeQuery();
					if(rs!=null){
					 while(rs.next()){
					  week[coi]=rs.getString("dw");
					  day_type1[coi]=rs.getString("DAY_TYPE_WEEK_1");
					  day_type2[coi]=rs.getString("DAY_TYPE_WEEK_2");
					  day_type3[coi]=rs.getString("DAY_TYPE_WEEK_3");
					  day_type4[coi]=rs.getString("DAY_TYPE_WEEK_4");
					  day_type5[coi]=rs.getString("DAY_TYPE_WEEK_5");
					  coi++;
					}
					}
						if(rs!=null)			rs.close();
			}
			catch(Exception es){
			}
			if(rs !=null) rs.close();
			// Modified against JD-CRF-0177 : added LightGreen and DarkGreen classes
			String Color_Code[]={"S","Y","G","R","B","H","L","D"}; 
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARED","OAHOLIDAY","OALIGHTGREEN","OADARKGREEN"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
			String cliniccode=request.getParameter("i_clinic_code");
			String colorclass="";
			String status=request.getParameter("status");
			String state="current";			
			if(status!=null)
			{
				if(status.equals("P1"))
					state="next";
				if(status.equals("M1"))
					state="previous";
			}
			
			

			try
			{

				if(request.getParameter("TotNum")!=null){
					TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}else{	

				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(old_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
						mon_date=mon;}
						count++;
				}
				int month_of_year=Integer.parseInt(mon_date);
				TotNum=month_of_year-curr_month;	
				if (TotNum<0)
					TotNum =month_of_year;
				}
				if(TotNum==0)
					state="current";
				else
				{
					if(TotNum > 0)
					   state="next";
				}
	if(rs !=null) rs.close();
			}
			catch(Exception e){
			//out.println(e);
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
			}
			if(rs !=null) rs.close();
			String arg=getYearMonth(state,TotNum);
			String CalString=(String)getCalendarString(con,arg);
			String ColorString=getCalanderStatusColor(fid,cliniccode,Practitioner_Id,con,arg);
			String yr=arg.substring(0,4);
			String yr_display=DateUtils.convertDate(yr,"YY","en",locale);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			String month=months[mon-1];
			String month_display="";
			if(month.equals("January"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.January.label","common_labels");
				}else if(month.equals("February"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.February.label","common_labels");
				}else if(month.equals("March"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.March.label","common_labels");
				}else if(month.equals("April"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.April.label","common_labels");
				}else if(month.equals("May"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.May.label","common_labels");
				}else if(month.equals("June"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.June.label","common_labels");
				}else if(month.equals("July"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.July.label","common_labels");
				}else if(month.equals("August"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.August.label","common_labels");
				}else if(month.equals("September"))
				{
				month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.September.label","common_labels");
				}else if(month.equals("October"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.October.label","common_labels");
				}else if(month.equals("November"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.November.label","common_labels");
				}else if(month.equals("December"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.December.label","common_labels");
				}

			StringTokenizer splitdays=new StringTokenizer(CalString,"|");
			String[] NumOfDays=new String[splitdays.countTokens()];
			StringTokenizer ColVals=new StringTokenizer(ColorString,"|");
			String colors[]=new String[ColVals.countTokens()];
			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]=splitdays.nextToken();
			for(int i=0;i<colors.length;i++)
				colors[i]=ColVals.nextToken();

				int ro=NumOfDays.length/7;
				int rodup=1;
				int ccols=7;

				String dat="";
				int act=0;

			
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

					try
					{
						
						String open_to_all_pract_yn="";
						String sql1 = "";
						//Below lines modified by Kamatchi S for security issue against COMMON-ICN-0165
						//rs = stmt.executeQuery("Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id='"+fid+"' AND a.clinic_code='"+clinic_code+"' and language_id = '"+locale+"' ");
						sql1 = "Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id=? AND a.clinic_code=? and language_id =? " ;
						pstmt   = con.prepareStatement(sql1);
						pstmt.setString(1, fid);
						pstmt.setString(2, clinic_code);
						pstmt.setString(3, locale);
						
						//System.err.println("454 ==> Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id='"+fid+"' AND a.clinic_code='"+clinic_code+"' and language_id = '"+locale+"'");
						rs=pstmt.executeQuery();
						if(rs !=null){
							while ( rs.next() )
								{
									open_to_all_pract_yn= rs.getString("open_to_all_pract_yn");
									clinic_name1= rs.getString("long_desc");	
									speciality_code=rs.getString("speciality_code");
								}
								}
								if(rs !=null) rs.close();

							if(clinic_name1==null) clinic_name1="";
							if(rs !=null) rs.close();
							if(pstmt !=null) pstmt.close();
	
            _bw.write(_wl_block44Bytes, _wl_block44);

						String my=month_display+","+yr_display;

						//String disp_clinc_pract=clinic_name;
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(clinic_name1));
            _bw.write(_wl_block48Bytes, _wl_block48);
 
		
									
						String resourceSQL ="";
						//Added by Kamatchi S for security issue against COMMON-ICN-0165
						if(res_type.equals("P")){
							//resourceSQL= "SELECT practitioner_name,practitioner_id FROM am_practitioner_lang_vw WHERE practitioner_id='"+practitioner_id+"' AND language_id='"+locale+"'";
							resourceSQL= "SELECT practitioner_name,practitioner_id FROM am_practitioner_lang_vw WHERE practitioner_id=? AND language_id=? ";
						}else if(res_type.equals("R")){
							//resourceSQL="select room_num practitioner_id, short_desc practitioner_name from am_facility_room_lang_vw where operating_facility_id ='"+fid+"' and language_id = '"+locale+"' and room_num='"+practitioner_id+"' order by short_desc ";
							resourceSQL="select room_num practitioner_id, short_desc practitioner_name from am_facility_room_lang_vw where operating_facility_id =? and language_id = ? and room_num= ? order by short_desc ";
						}else if(res_type.equals("E") || res_type.equals("O")){
							//resourceSQL="Select resource_id practitioner_id, short_desc practitioner_name from am_resource_lang_vw where facility_id = '"+fid+"' and Resource_Class ='"+res_type+"' and language_id = '"+locale+"'  and RESOURCE_ID ='"+practitioner_id+"'";
							resourceSQL="Select resource_id practitioner_id, short_desc practitioner_name from am_resource_lang_vw where facility_id = ? and Resource_Class = ? and language_id = ?  and RESOURCE_ID = ? ";
						}
						pstmt   = con.prepareStatement(resourceSQL);
						if(res_type.equals("P")){
						 pstmt.setString(1, practitioner_id);
						 pstmt.setString(2, locale);
						}else if(res_type.equals("R")){
						 pstmt.setString(1, fid);
						 pstmt.setString(2, locale);
						 pstmt.setString(3, practitioner_id);
						}else if(res_type.equals("E") || res_type.equals("O")){
						 pstmt.setString(1, fid);
						 pstmt.setString(2, res_type);
						 pstmt.setString(3, locale);
						 pstmt.setString(4, practitioner_id);
						}
						rs=pstmt.executeQuery();
						//rs = stmt.executeQuery(resourceSQL);
						if(rs !=null){
							if ( rs.next() )
								{
									
									practitioner_name= rs.getString("practitioner_name");	
									if(practitioner_name==null) practitioner_name="";
								}
								}
								if(rs !=null) rs.close();
								if(pstmt !=null) pstmt.close();
							if(practitioner_name==null) practitioner_name="";
							if(rs !=null) rs.close();

            _bw.write(_wl_block49Bytes, _wl_block49);
            {java.lang.String __page ="../../eOA/jsp/OAResourcelookupframe.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from_page"), weblogic.utils.StringUtils.valueOf("appt_dairy")},{ weblogic.utils.StringUtils.valueOf("res_type"), weblogic.utils.StringUtils.valueOf(res_type
                        )},{ weblogic.utils.StringUtils.valueOf("clinic_type"), weblogic.utils.StringUtils.valueOf(clinic_type
                        )},{ weblogic.utils.StringUtils.valueOf("open_to_all_pract_yn"), weblogic.utils.StringUtils.valueOf(open_to_all_pract_yn
                        )},{ weblogic.utils.StringUtils.valueOf("clinic_code"), weblogic.utils.StringUtils.valueOf(clinic_code
                        )},{ weblogic.utils.StringUtils.valueOf("pract_value"), weblogic.utils.StringUtils.valueOf(practitioner_name
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
chk_flg="Y"; 
            _bw.write(_wl_block51Bytes, _wl_block51);
if(chk_flg.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(my));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(old_alcn_catg_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
/*Below hidden field changed for this[IN:034988]*/
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(old_visit_type_ind1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(old_alcn_catg_code1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(no_of_slots_value1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(old_pract_id1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(old_clinic_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
if(chk_flg.equals("Y")){
            _bw.write(_wl_block84Bytes, _wl_block84);
for( int j=0;j<week.length;j++){
					String week1[]=new String[7];
						if(week[j].equals("SUN"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
		}else if(week[j].equals("MON"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
		}else if(week[j].equals("TUE"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
		}else if(week[j].equals("WED"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
		}else if(week[j].equals("THU"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
		}else if(week[j].equals("FRI"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
		}else if(week[j].equals("SAT"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
		}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(week1[j]));
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
for( int j=0;j<ro;j++)
				{
				
				
            _bw.write(_wl_block88Bytes, _wl_block88);


				  	for(int k=0;k<ccols;k++)
				  	{
						
						if(k==1)
							{
						if(day_type1[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						}

						if(k==2)
						{
						if(day_type2[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==3)
							{
						if(day_type3[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==4)
							{
						if(day_type4[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==5)
							{
						if(day_type5[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

						if(act<NumOfDays.length)
				  		{
							if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
				  				for(int i=0;i<Color_Code.length;i++)
				  				{
				  					if(Color_Code[i].equals(colors[act]))
				  						colorclass=Color_Val[i];
				  				}
				  			}
				  			else
				  			{
				  				if(rodup==(NumOfDays.length/7) && 	NumOfDays[act].equals("0"))
				  				{
				  					dat="&nbsp";
				  					break;
				  				}
				  				else{
				  					dat="&nbsp";
									
								}

				  			}
				  		}
				  		else{
				  			dat="&nbsp";
						}
						
				  			String anch=" ";
							String title=dat+"/"+mon+"/"+yr;
				  			act++;

				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
                            if (colorclass.equals("OARED"))
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";

							else
							anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"','"+colorclass+"') title='"+title+"'  >";
                     
							}
					if(allow_click){							 
						if(colorclass.equals("OAHOLIDAY")){
							
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block91Bytes, _wl_block91);

							}
						else{
							
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block91Bytes, _wl_block91);

						}
					}
					else{
						if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY")){
							
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}
							else{
							
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}
						}
						else{
							
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block93Bytes, _wl_block93);

				  		}
					}
					colorclass="";
					}
				  	
            _bw.write(_wl_block95Bytes, _wl_block95);
rodup++;
			}
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block8Bytes, _wl_block8);

			
		if(rs!=null)			rs.close();
		//if(stmt!=null)		stmt.close();
		if(pstmt!=null)		pstmt.close();
	}catch(Exception e){
			//out.println("ERROR@2"+e);
			e.printStackTrace();
			}finally
				{
					if(con!=null)	ConnectionManager.returnConnection(con,request);
						
				}
			
            _bw.write(_wl_block97Bytes, _wl_block97);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
}

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
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __setupdailyscheduleheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SetUpDailyScheduleHeader.jsp", 1742300078266L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n\t<script language=\"javascript\" src=\"../../eOA/js/SetUpDailySchedule.js\">\t\t</script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> \t\t</script>\n\t<script language=\"javascript\" src=\"../../eOA/js/Scheduling.js\"></script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t <script>\n\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';</script> \n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t\t\t<!-- \t<script>alert(getMessage(\'NO_OPER_STN_FOR_USER\',\'Common\'));</script> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<html>\n\t\t\t<head>\n\t\t\t</head>\n\t\t\t<body   onload=\'chkmandatory();check_Forced();\'OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' >\n\n\n<FORM name=\'SetUpDailySchedule\' id=\'SetUpDailySchedule\' method=\'post\' action=\'../../servlet/eOA.SetUpDailyScheduleServlet\' target=\'messageFrame\'>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\' align=\'center\'>\n\t\t\t\n\t\t<th nowrap align=\'left\' colspan=\'9\' class=\'COLUMNHEADER\' style=\"color:white\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\n\t\t<tr>\n\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TD>\n\t\t\t\n\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<SELECT name=\'location_type\' id=\'location_type\' width=\'6%\' onChange=\"javascript:populateLocations(this);changeResource(this);\">\n\t\t\t\t<option>------ ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="------</option>\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<input type=\'text\' name=\'location_type1\' id=\'location_type1\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  size=\'15\'   readOnly maxlength=\'15\'>\n\t\t\t\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<TD class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TD>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td class=\'fields\' nowrap colspan=\'3\'>\n\t\t\t\t\t<!--<SELECT name=\'location\' id=\'location\'  onChange=\"javascript:checkinIdentification(this)\">\n\t\t\t\t\t<option>----------------------- ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="------------------------</option></SELECT>-->\n\t\t\t\t\t<input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'\' onblur=\"ena_loc_lookup(this);\"><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup()\" class=\'button\'><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t\t<input type=\"hidden\" name=\"location\" id=\"location\" value=\"\">\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td class=\'fields\' colspan=\'3\'>\n\t\t\t\t\t<!--<SELECT name=\'location\' id=\'location\'  onChange=\"javascript:populatePractitioner(this);\">\n\t\t\t\t\t<option>------------------ ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="------------------</option>\t</SELECT><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>-->\n\t\t\t\t\t<input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'\' onblur=\"ena_loc_lookup(this);\" ><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup()\" class=\'button\'><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t\t<input type=\"hidden\" name=\"location\" id=\"location\" value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<TD class=\"label\"  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</TD>\n\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t<input type=\'text\' name=\'location1\' id=\'location1\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  size=\'15\'   readOnly maxlength=\'15\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'location\' id=\'location\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<TD class=\"label\" nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\n\t\t\t\t<td   class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<SELECT name=\'resourceType\' id=\'resourceType\' disabled onchange=\"enable_dsiable_res(this)\">\n\t\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="----- </option>\n\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t\t<option value=\'P\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </option>\n\t\t\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </option>\n\t\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </option>\n\t\t\t\t\t</SELECT><img src = \'../../eCommon/images/mandatory.gif\'> \n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<input type=\"text\" size=\"18\" name=\"resourceType1\" id=\"resourceType1\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly>\n\t\t\t\t\t<input type=\"hidden\" name=\"resourceType\" id=\"resourceType\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t\t\t<!-- <td   class=\'fields\'><input type=text name=\'practitioner_name\' id=\'practitioner_name\' disabled onblur=\'onblurcheck(this,practitioner_name)\' size=\'30\' maxlength=\'30\'  ><input type=hidden name=\'practitioner\' id=\'practitioner\'  size=\'30\' maxlength=\'30\' ></input><input type=\'button\' class=\'button\' value=\'?\'  disabled name=\'search_pract\' id=\'search_pract\' onClick=\"callPractSearch(this,practitioner_name,\'setUp\');\"  >\n\t\t\t\t\t<img id = \'practMandatory\' src = \'../../eCommon/images/mandatory.gif\'>  -->\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<TD class=\"label\" nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t<td class=\'fields\' nowrap >\n\t\t\t\t\t<input type=\'text\' name=\'practitioner1\' id=\'practitioner1\'   value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  size=\'30\' readOnly maxlength=\'30\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t</TD>\n\n\t</TR>\n\t\t\t\n\t\t\t<th nowrap align=\'left\' colspan=\'9\'class=\'COLUMNHEADER\' style=\"color:white\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</th>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<tr>\t\t\n\t\t<TD class=\"label\"  nowrap colspan=\'4\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\n\t\t<TD class=\"fields\"  nowrap ><INPUT align=\'\'TYPE=CHECKBOX name=\'b_roster_reqd\' id=\'b_roster_reqd\' VALUE=\'Y\' disabled onClick=\'javascript:rostertype()\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="></TD>\n\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n\t<TR>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\t\n\t\t\t<TD class=\"label\" nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</TD>\n\n\t\t\t<TD class=\"fields\" nowrap >\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<input type=\'text\'  name=\'clinic_date\' id=\'clinic_date\' value=\'\'   size=\'10\' maxLength=\'10\' onBlur=\'validateClinicDate(this,location,practitioner);\'><img  style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\" document.getElementById(\'clinic_date\').select();return showCalendar(\'clinic_date\');\"><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<input type=\'text\' name=\'clinic_date\' id=\'clinic_date\'  size=\'10\'  value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'   maxLength=\'10\' readOnly><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" \n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n\t\t\t\t<TD class =\"label\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</TD>\n\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<TD class=\"fields\" >\n\t\t\t\t<SELECT name=\'b_day\' id=\'b_day\' onChange=\"/*javascript:checkDuplicate()*/\">\n\t\t\t\t<option>----";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="----\n\t\t\t\t<option value=\'*A\'>*All\n\t\t\t\t</SELECT><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t</TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<TD class=\"fields\" ><input type=\'text\' name=\'b_day\' id=\'b_day\'  size=\'10\'  value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'   maxLength=\'10\' readOnly><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img><input type=\'hidden\' name=\'day_no_modify\' id=\'day_no_modify\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD>\n\n\t\t\t<TD class=\"fields\" nowrap colspan=\'3\' >\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t<SELECT name=\'time_table_type\' id=\'time_table_type\'   onChange=\"javascript:check_loc(this);\">\n\t\t\t\t\t\t<OPTION value=\'\'>------";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="----\n\t\t\t\t\t\t<OPTION value=\'1\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</option>\n\t\t\t\t\t\t<OPTION value=\'2\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</option>\n\t\t\t\t\t\t<OPTION value=\'3\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</option>\n\t\t\t\t\t\t</SELECT><img  src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'time_table_type\' id=\'time_table_type\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'time_table_type1\' id=\'time_table_type1\' value=\'Slot\'   readOnly size=\'10\' maxlength=\'10\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'time_table_type1\' id=\'time_table_type1\' value=\'Slab\'   readOnly size=\'10\' maxlength=\'10\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'time_table_type1\' id=\'time_table_type1\' value=\'Free Format\'  readOnly size=\'10\' maxlength=\'10\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t   ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t</TD>\n\t\t</TR>\n\t\t\n\t\t<TR>\n\t\t\t\t<TD class=\"label\" >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</TD>\n\n\t\t\t\t<TD class=\"fields\"  nowrap >\n\t\t\t\t\t<INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name=\'start_time\' id=\'start_time\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'  onKeyUp=\"javascript:formatTimePerPatient(this)\" onBlur=\"/*javascript:chkStartTime(this);*/timeValidation(this,\'S\',\'SetUpDailySchedule";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');\" onChange=\"//clearMaxFirstVisit(this);\" ><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t\t</TD>\n\t\t\t\t\n\t\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</TD>\n\n\t\t\t<TD class=\"fields\"  nowrap>\n\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" \n\t\t\t\t\t<input type=text size=5 maxlength=5 name=\'end_time\' id=\'end_time\'    value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'  readOnly  onKeyUp=\"javascript:formatTimePerPatient(this)\" onBlur=\"/*javascript:chkEndTime(this);*/timeValidation(this,\'E\',\'SetUpDailySchedule";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\')\" onChange=\"clearMaxFirstVisit(this)\" >\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t<input type=text size=5 maxlength=5 name=\'end_time\' id=\'end_time\'    value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'     onKeyUp=\"javascript:formatTimePerPatient(this)\" onBlur=\"/*javascript: chkEndTime(this,end_appt_time,block_end_time);*/timeValidation(this,\'E\',\'SetUpDailySchedule";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\');\" onChange=\"javascript:clearMaxFirstVisit(this);\">\n\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" \n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t</TD>\n\n\t\t\t<!--Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112-->\n\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<td class=label id=\"scheduleextendyn\" style=\"display:none\" nowrap colspan=\'2\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t<input type=checkbox name=\"schedule_extend_yn\" id=\"schedule_extend_yn\" onClick=\'ScheduleExtendYN(this);\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="></td>\n\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\n\t</tr>\n\n\t\t\t<th nowrap colspan=\'6\' align=\'left\' class=\'COLUMNHEADER\' style=\"color:white\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="/";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</th>\n\t\t\t\t\n\t\t\t\n\t\t\n\t<tr>\n\n\t\t\t<TD class=\"label\" id = time_per_pat >";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</TD>\n\n\t\t\t<TD class=\"fields\"  >\n\t\t\t\t<input name=\'time_per_patient\' id=\'time_per_patient\' type=text size=5 maxlength=5    value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'  onBlur=\"TimePerPatientValid(this);\" ><img id=\'t_per_pat\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t</TD>\n\n\t\t\t</td>\n\n\t\t\t<TD class=\"label\" nowrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</TD>\n\n\t\t\t<TD class=\"fields\" nowrap colspan=\'3\'>\n\t\t\t\t<INPUT name=\'b_max_slots_per_day\' id=\'b_max_slots_per_day\' disabled TYPE=TEXT SIZE=5 MAXLENGTH=3 \n\t\t\t\tonKeyPress=\'return  allowValidNumber(this,event,3,0);\'value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t\t\t</TD>\t\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'l_max_pat_per_slot\' id=\'l_max_pat_per_slot\'>\n</TR>\n\n<TR>\n\t\t\t<TD class=\"label\" >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</TD>\n\n\t\t\t<TD class=\"fields\"><input name=\'time_per_slab\' id=\'time_per_slab\' type=text size=5 maxlength=5  value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'   onKeyUp=\"javascript:formatTimePerSlab()\" onBlur=\"javascript:TimePerSlab(this);\"><img id=\'t_per_slab\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t</TD>\n\n\t\t\t\n\n\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</TD>\n\n\t\t\t<TD class=\"fields\" colspan=\'3\'>\n\t\t\t<input name=\'max_patients_per_slab\' id=\'max_patients_per_slab\' type=text size=5 maxlength=3  value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' onBlur=\"javascript:MaxPatPerSlab(this);\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'><img id=\'mx_per_slab\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t</TD>\n\n    </TR>\n\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\n\t<TR>\t\n\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</TD>\n\t\t\n\t\t\t<TD class=\"fields\" nowrap colspan=\'3\'>\n\t\t\t\t<INPUT name=\'max_patients_per_day\' id=\'max_patients_per_day\' TYPE=TEXT SIZE=5 MAXLENGTH=3    value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onBlur=\"javascript:ChkNumber(this);MaxPatPerDay(this);\" >\n\n\t\t\t\t<INPUT name=\'old_max_patients_per_day\' id=\'old_max_patients_per_day\' TYPE=hidden value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' ><img id=\'mx_pat_per_day\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t</TD>\n\n\t\t\t<!--Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1-->\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t<td class=label id=\"allslots\" style=\"display:none\" nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t<input type=checkbox name=\"ext_all_slots_yn\" id=\"ext_all_slots_yn\" onClick=\'ExtAllSlotsYN(this);\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =">\n\t\t\t\t</td>\n\n\t\t\t\t<td class=\"fields\" id=\"StartMidEnd\" style=\"display:none\" nowrap>\n\t\t\t\t\t<input name=\'ext_start_slots\' id=\'ext_start_slots\' type=text size=3 maxlength=3 onKeyPress=\'return allowValidNumber(this,event,3,0);\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t<input name=\'ext_mid_slots\' id=\'ext_mid_slots\' type=text size=3 maxlength=3 onKeyPress=\'return allowValidNumber(this,event,3,0);\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t<input name=\'ext_end_slots\' id=\'ext_end_slots\' type=text size=3 maxlength=3 onKeyPress=\'return allowValidNumber(this,event,3,0);\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\t\t\t\n\t\t\t\t\t<td  >&nbsp;</td>\n\t\t\t\t\t<td  >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\n\t</TR>\n\n\t\t\t<th nowrap colspan=\'1\' align=\'left\' class=\'COLUMNHEADER\' style=\"color:white\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</th><th class =COLUMNHEADER  id = \'slot_or_pat_id1\' COLSPAN=\'5\' style=\"color:white\" nowrap>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</th>\n\t\t\t<TR>\n\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</TD>\n\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\n\t\t\t<TD class=\"fields\"  nowrap>\n\t\t\t<input name=\'max_first_visit\' id=\'max_first_visit\' type=text size=5 maxlength=3    value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' onBlur=\"javascript:MaxFirstVisit(this);chkMaximumFirstVisit(this,first_visit_cnt)\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\n\t\t\t</td>\n\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\n\t\t\t<TD class=\"fields\" nowrap colspan=\'3\'>\n\t\t\t<INPUT name=\'max_other_visits\' id=\'max_other_visits\' TYPE=TEXT SIZE=5 MAXLENGTH=3 \n\t\t\tonblur = \'maxothervisit()\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\n\t\t\t\n\t\t\t</td>\n\t\t\t\n\n\n\t\t\t<INPUT name=\'b_max_slots_for_first_visit\' id=\'b_max_slots_for_first_visit\' TYPE=hidden value=\'0\'></input>\n\t</tr>\n\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t<tr id=\'entitledPatRow\' style =\'display:\'>\n\t\t\t<td class=\"label\"  nowrap>Max New Patients</td>\n\t\t\t<td class=\"fields\"  nowrap>\n\t\t\t<input name=\'max_new_patients\' id=\'max_new_patients\' type=text size=5 maxlength=3    value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' onBlur=\"javascript:NewOldPatValidation(this)\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'>\n\t\t\t</td>\n\t\t\t<td class=\"label\"  nowrap>Max Old Patients</td>\n\t\t\t<td class=\"fields\"  nowrap>\n\t\t\t<input name=\'max_old_patients\' id=\'max_old_patients\' type=text size=5 maxlength=3    value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' onBlur=\"javascript:NewOldPatValidation(this)\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'>\n\t\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t<tr>\n\t\t\t\t\n\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</TD>\n\n\t\t\t<TD class=\"fields\" colspan=\'3\'>\n\t\t\t<input name=\'max_over_bookings\' id=\'max_over_bookings\' type=text size=5 maxlength=3    value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' onBlur=\"javascript:MaxOverBookings(this,\'setUp\');chkMaximumOverBooking(this,overbook_cnt);\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\t\t\n\t\t\t</TD>\n\t\t\t\t\n\t\t\t<td  >&nbsp;</td>\n\t\t\t<td  >&nbsp;</td>\n\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t</TR>\n\t\n\t\t\t\n\t\t\t<th nowrap  align=\'left\' class=\'COLUMNHEADER\' COLSPAN=\'6\' style=\"color:white\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</th>\n\t\t\n\t\t<TR>\n\t\t\t\t<TD class=\"label\" WIDTH=\'25%\' nowrap>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</TD>\n\n\t\t\t\t<TD class=\"fields\" WIDTH=\'25%\'><input type=\"checkbox\" name=\"forced_book_YN\" id=\"forced_book_YN\" onclick=\"check_Forced()\" ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="></TD>\n\n\t\t\t\n\n\t\t\t\t<td class = label id = \'slot_or_pat_id3\'nowrap>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\n\t\t\t<TD class=\"fields\" colspan=\'3\'>\n\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t<input type=\"text\" name=\"no_of_forced_booking\" id=\"no_of_forced_booking\" size=5 maxlength=3 value=\"\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t<input ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" type=\"text\" name=\"no_of_forced_booking\" size=5 maxlength=3 value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'> \n\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\n\t\t\t<img id=\'forced\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\' ></img>\n\t\t\t\n\t\t\t\n\t</TR>\t\n\t<TR>\n\t\t\n\t\t\t<TD class=\"label\"  nowrap>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</TD>\n\t\t\n\t\t\t<TD class=\"fields\" colspan=\'3\' >\t\n\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t<input type=\"text\"  name=\"no_of_global_booking\" id=\"no_of_global_booking\" size=5 maxlength=3 value=\"\" onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t<input  type=\"text\" ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="  name=\"no_of_global_booking\" size=5 maxlength=3 value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"   onKeyPress=\'return  allowValidNumber(this,event,3,0);\'>\n\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t<td class=\'button\' nowrap colspan=\'2\'><input type=\'button\' name=\'AllocationDetails\' id=\'AllocationDetails\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'  class=\"BUTTON\" onclick=\'showAalocation()\'></td>\n\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t<td >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\n\t</TR>\t\t\n\t\t\t\t\n\t<TR>\n\t\t\t<TD class=\"label\" >";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</TD>\n\n\t\t\t<TD class=\"fields\" COLSPAN=\'5\'>\n\t\t\t<input name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" type=text size=60  onblur = \'return makeValidString(this)\'   maxlength=60 ></TD>\n\t</tr>\n\t\t\t</table>\t\t\n\t\t\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'  align=\'center\'>\n\t\t\t<th align=\'left\' class=\'COLUMNHEADER\' colspan=\'5\' style=\"color:white\">";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</th>\n\t\t\t\t<tr><td colspan=\'4\'></td>\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\"label\" align=\'right\' width=\'34%\'>&nbsp;</td>\n\t\t\t<td class=\"label\"  width=\'8%\' >";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\t\t\n\t\t\t<td class=\"label\" align=\'right\' width=\'10%\'>&nbsp;</td>\n\t\t\t<td class=\"label\"  width=\'6%\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</td>\n\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\n\t\t\t\t<TR>\n\t\t\t\t\t<TD class=\"label\">&nbsp;</TD>\n\n\t\t\t\t\t<TD class=\"fields\">\n\t\t\t\t\t\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'from_time";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' id=\'from_time";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' onKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\")\' onBlur=\'ChkTime(this);CallFromBreakTimeValidation(this,\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\");\'>\n\t\t\t\t\t</TD>\n\n\t\t\t\t\t<TD class=\"label\" >&nbsp;</TD>\n\n\t\t\t\t\t<TD class=\"fields\" >\n\t\t\t\t\t\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'to_time";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' id=\'to_time";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'  onKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\")\' onBlur=\'ChkTime(this);CallToBreakTimeValidation(this,\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"); \'>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t<TD class=\"label\" align=\'right\' width=\'33%\'>&nbsp;&nbsp;</TD>\n\t\t\t\t\t<TD class=\"fields\" width=\'8%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t \n\t\t\t\t\t  <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'from_time";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' VALUE=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'\n\t\t\t\t\t  onKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\");\'>\n\t\t\t\t\t  </TD>\n\n\t\t\t\t\t<TD class=\"label\"  width=\'10%\'>&nbsp;</TD>\n\t\t\t\t\t<TD class=\"fields\" width=\'6\' >\n\t\t\t\t\n\t\t\t\t\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'to_time";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\");\'>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\n\t\t\t\t<tr><td colspan=\'5\'>&nbsp;</td>\t</tr>\n\t\t\t\t<input type=\'hidden\' name=\'ftotstr\' id=\'ftotstr\' value=\'\'>\n\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'fmode\' id=\'fmode\' value=\'insert\'>\n\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'fmode\' id=\'fmode\' value=\'modify\'>\n\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\n\t\t\t</table>\n\t\t\t\n\n\t\t<input type=\'hidden\' name=\'start_appt_time\' id=\'start_appt_time\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' >\n\t\t<input type=\'hidden\' name=\'end_appt_time\' id=\'end_appt_time\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' >\n\t\t<input type=\'hidden\' name=\'block_start_time\' id=\'block_start_time\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' >\n\t\t<input type=\'hidden\' name=\'block_end_time\' id=\'block_end_time\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' >\n\t\t<input type=\'hidden\' name=\'overbook_cnt\' id=\'overbook_cnt\'  value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' >\n\t\t<input type=\'hidden\' name=\'first_visit_cnt\' id=\'first_visit_cnt\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' >\n\t\t<input type=\'hidden\' name=\'other_visit_cnt\' id=\'other_visit_cnt\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' >\n\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' >\n\t\t<input type=\'hidden\' name=\'final_alcn_criteria\' id=\'final_alcn_criteria\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' >\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' >\n\t\t<input type=\'hidden\' name=\'insert_detail\' id=\'insert_detail\' value=\'N\' >\t\n\t\t<input type=\'hidden\' name=\'final_values\' id=\'final_values\' value=\'\' >\t\t\n\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' >\n\t\t<input type=\'hidden\' name=\'alcn_basis\' id=\'alcn_basis\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' >\n\t\t<input type=\'hidden\' name=\'practid\' id=\'practid\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' >\t\t\n\t   \t<input type=\'hidden\' name=\'final_string\' id=\'final_string\'  value=\'\'>\n\t   \t<input type=\'hidden\' name=\'final_string1\' id=\'final_string1\'  value=\"DFLT\">\n\t   \t<input type=\'hidden\' name=\'allocation_changed\' id=\'allocation_changed\'  value=\'N\'>\n\t\t<input type=\'hidden\' name=\'day_no\' id=\'day_no\'  value=\'1\'>\n\t\t<input type=\'hidden\' name=\'max_patients1\' id=\'max_patients1\'  value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_time_table_type\' id=\'p_time_table_type\'  value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n\t\t<input type=\'hidden\' name=\'p_start_time\' id=\'p_start_time\'  value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n\t\t<input type=\'hidden\' name=\'p_end_time\' id=\'p_end_time\'  value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\t\t<input type=\'hidden\' name=\'function_mode\' id=\'function_mode\'  value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n\t\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\t\t<input type=\'hidden\' name=\'hddDur\' id=\'hddDur\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'defStartTime\' id=\'defStartTime\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t\t<input type=\'hidden\' name=\'defEndTime\' id=\'defEndTime\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n\t\t<input type=\'hidden\' name=\'l_ident_at_checkin\' id=\'l_ident_at_checkin\'>\n\t\t<input type=\'hidden\' name=\'l_fi_visit_type_appl_yn\' id=\'l_fi_visit_type_appl_yn\'>\n\t\t<INPUT TYPE=\'hidden\' name=\'l_open_to_all_pract_yn\' id=\'l_open_to_all_pract_yn\' SIZE=\'10\'>\n\t\t<INPUT type=\'hidden\' name=\'DaysForClinic\' id=\'DaysForClinic\' value=\'\'>\n\t\t<INPUT type=\'hidden\' name=\'function_type\' id=\'function_type\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n\t\t<INPUT type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n\t\t\t<input type=\'HIDDEN\' name=\'CurrentDatetm\' id=\'CurrentDatetm\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' >\n\t\t<input type=\'HIDDEN\' name=\'CurrentDate\' id=\'CurrentDate\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' >\n\t\t<input type=\'HIDDEN\' name=\'result\' id=\'result\' value=\'\' >\n\t\t<input type=\'HIDDEN\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' >\n\n\t\t<!--Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112-->\n\t\t<input type=\'hidden\' name=\'isScheduleExtendAppl\' id=\'isScheduleExtendAppl\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\' >\n\t\t<input type=\'hidden\' name=\'schedule_extend_param\' id=\'schedule_extend_param\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' >\n\n\t\t<!--Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1-->\n\t\t<input type=\'hidden\' name=\'isSlotStartMidEndAppl\' id=\'isSlotStartMidEndAppl\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' >\n\t\t<input type=\'hidden\' name=\'old_ext_all_slots_yn\' id=\'old_ext_all_slots_yn\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' >\n\t\t<input type=\'hidden\' name=\'old_ext_start_slots\' id=\'old_ext_start_slots\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' >\n\t\t<input type=\'hidden\' name=\'old_ext_mid_slots\' id=\'old_ext_mid_slots\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\' >\n\t\t<input type=\'hidden\' name=\'old_ext_end_slots\' id=\'old_ext_end_slots\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' >\n\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t//Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 \n\t\t\t\t\t\t\t//document.forms[0].time_per_patient.readOnly=true; \n\t\t\t\t\t\t\tdocument.forms[0].max_patients_per_day.readOnly=true;\n\t\t\t\t\t\t\tdocument.forms[0].b_max_slots_per_day.disabled=true;\n\t\t\t\t\t\t\tdocument.forms[0].t_per_pat.style.visibility=\'visible\'\n\t\t\t\t\t\t\tdocument.forms[0].mx_pat_per_day.style.visibility=\'visible\'\n\t\t\t\t\t\t\tdocument.forms[0].t_per_slab.style.visibility=\'hidden\'\n\t\t\t\t\t\t\tdocument.forms[0].mx_per_slab.style.visibility=\'hidden\'\n\t\t\t\t\t\t\tdocument.forms[0].time_per_slab.readOnly=true;\n\t\t\t\t\t\t\tdocument.forms[0].max_patients_per_slab.readOnly=true;\t\n\t\t\t\t\t\t\tif (document.forms[0].visit_limit_rule.value==\"N\")\n\t\t\t{\n\t\t\t\t document.forms[0].max_first_visit.readOnly=true;\n\t\t\t\t document.forms[0].max_other_visits.readOnly=true;\n\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =" \n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t/*Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 starts here */\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].time_per_slab.readOnly=true;\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=true;\t\n\t\t\t\t\t\t\t/*Ends here*/\n\t\t\t\t\t\t\tdocument.getElementById(\'t_per_slab\').style.visibility=\'visible\'\n\t\t\t\t\t\t\tdocument.getElementById(\'mx_per_slab\').style.visibility=\'visible\'\n\t\t\t\t\t\t\tdocument.getElementById(\'t_per_pat\').style.visibility=\'hidden\'\n\t\t\t\t\t\t\tdocument.getElementById(\'mx_pat_per_day\').style.visibility=\'hidden\'\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].time_per_patient.readOnly=true;\n\t\t\t\t\t\t\tdocument.forms[0].max_patients_per_day.readOnly=true;\n\t\t\t\t\t\t\tif (document.forms[0].visit_limit_rule.value==\"N\")\n\t\t\t{\n\t\t\t\t document.forms[0].max_first_visit.readOnly=true;\n\t\t\t\t document.forms[0].max_other_visits.readOnly=true;\n\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].time_per_slab.readOnly=true;\n\t\t\t\t\t\t\tdocument.forms[0].max_patients_per_slab.readOnly=true;\n\t\t\t\t\t\t\tdocument.forms[0].time_per_patient.readOnly=true;\n\t\t\t\t\t\t\t/*Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 starts here */\n\t\t\t\t\t\t\t//document.forms[0].max_patients_per_day.disabled=true;\t\t\n\t\t\t\t\t\t\t//document.forms[0].time_per_patient.readOnly=true;\n\t\t\t\t\t\t\t//document.forms[0].time_per_slab.readOnly=true;\n\t\t\t\t\t\t\t//document.forms[0].max_patients_per_slab.readOnly=true;\n\t\t\t\t\t\t\t/*Ends here*/\n\t\t\t\t\t\t\tdocument.getElementById(\'mx_pat_per_day\').style.visibility=\'visible\';\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'t_per_pat\').style.visibility=\'hidden\'\n\t\t\t\t\t\t\tdocument.getElementById(\'t_per_slab\').style.visibility=\'hidden\'\n\t\t\t\t\t\t\tdocument.getElementById(\'mx_per_slab\').style.visibility=\'hidden\'\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif (document.forms[0].visit_limit_rule.value==\"N\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t document.forms[0].max_first_visit.readOnly=true;\n\t\t\t\t\t\t\t\tdocument.forms[0].max_other_visits.readOnly=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" \n\t\t\t<script>\n\t\t\thidemand();       \n\t\t\tparent.frames[1].document.getElementById(\'slot_or_pat_id1\').innerText = \"           \";\n\t\t\t//parent.frames[1].document.getElementById(\'slot_or_pat_id2\').innerText = \"           \";\n\t\t\t//parent.frames[1].document.getElementById(\'slot_or_pat_id3\').innerText = \"           \";\n\t\t\tdocument.getElementById(\'imgpract\').style.visibility=\'hidden\';\n\t\t\t\n\t\t\tif (document.forms[0].visit_limit_rule.value==\"N\")\n\t\t\t{\n\t\t\t\t document.forms[0].max_first_visit.readOnly=true;\n\t\t\t\t document.forms[0].max_other_visits.readOnly=true;\n\t\t\t}\n\t\t\t</script> \n\t\t\t<script>\n\t\t\t\tdocument.forms[0].forced_book_YN.disabled=true;\n\t\t\t\tdocument.forms[0].no_of_forced_booking.disabled=true;\n\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\n\t\t</form>\n\t\t</body>\t\t\n\t\t</html>\n";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
  
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection conn=null; 
			Statement stmtn = null;
			Statement stmtnAlcn = null;
			Statement stmtnAlcn1 = null;
			Statement stmtn1 = null;
			Statement stmtn2 = null;	
	//		Statement stsql2 = null;	
	//		Statement stsql1 = null;	
			Statement st_valstart = null;
			Statement st_blkappt = null;
	//		Statement chk_time=null;
			ResultSet rs_valstart=null;
			ResultSet rs_blkappt=null;
			ResultSet rspop_sch=null;
			ResultSet rspop_break=null;
			ResultSet rsLoc=null;
		//	ResultSet rssql1=null;
		//	ResultSet rssql2=null;
			Statement st= null;
			ResultSet rsSet=null;
			ResultSet rsAlcn=null;
			ResultSet rsAlcn1=null;
			String alcn_basis="";
			String startTime="";
			String endTime="";

			PreparedStatement pstmt=null;
			
			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			Boolean isScheduleExtendAppl = false;
			String schedule_extend_param = "N";
			String schedule_extend_yn = "N";
			String schedule_extend_yn_chk = "";

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			Boolean isSlotStartMidEndAppl = false;
			String ext_all_slots_yn = "N";
			String ext_all_slots_yn_chk = "";
			String ext_start_slots = "";
			String ext_mid_slots = "";
			String ext_end_slots = "";
try
{ 
			conn = ConnectionManager.getConnection(request);

			isScheduleExtendAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "SCHEDULE_EXTEND");//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			stmtn = conn.createStatement();
			 stmtn1 = conn.createStatement();
			 stmtn2 = conn.createStatement();	
	//		 stsql2 = conn.createStatement();	
	//		 stsql1 = conn.createStatement();	
			 st_valstart = conn.createStatement();
			 st_blkappt = conn.createStatement();
	//		 chk_time=conn.createStatement();
			  st= conn.createStatement();
			String locale=(String)session.getAttribute("LOCALE");
			String facilityid=(String)session.getValue("facility_id");
			java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
		//	String fid=p.getProperty( "login_user" ) ;
			String function_mode=request.getParameter("function_mode");
			if( function_mode == null) function_mode="";
			
			String p_clinic_code = request.getParameter("clinic_code");
			if( p_clinic_code == null) p_clinic_code="";
			String  practid= request.getParameter("practid");
			if(practid ==null || practid.equals(" ") || practid.equals("null")) practid="";
			String clinic_date = request.getParameter("clinic_date");
			if( clinic_date == null) clinic_date="";
			String clinic_date_display=DateUtils.convertDate(clinic_date,"DMY","en",locale);
			if( clinic_date_display == null) clinic_date_display="";


			String timetabletype = request.getParameter("timetabletype");
			if( timetabletype == null) timetabletype="";
			String locn_care_ind=  request.getParameter("locn_care_ind");
			if( locn_care_ind == null) locn_care_ind="";
			String resource_class=  request.getParameter("resource_class");
			if( resource_class == null) resource_class="";
			String function_type=request.getParameter("function_type");
			if(function_type ==null) function_type="";
			
			String dayno = request.getParameter("dayno");
			if( dayno == null) dayno="";
						 
			String alcnCode="";
			String alcnDesc="";
			//	String alcnSlotNo="";

			int alcnSlotNo =0;
			String finalalcnString="";
			String day_of_week="";
			String start_appt_time="";
			String end_appt_time="";
			String block_start_time ="";
			String block_end_time="";
			String overbook_cnt="0";
			String first_visit_cnt="";
			String other_visit_cnt="";
			String alcncriteria = "";
			String slot_appt_ctrl="";
			String visit_limit_rule="";		 
			String p_max_slots_per_day="";		 
			String p_max_other_visits="";		 
			String slot_or_pat="";
			String time_per_pat_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeperSlot.label","oa_labels");
			String p_clinic_name="";
			String p_practitioner_name="";
			String p_remarks="";
			String p_start_time="";
			String p_end_time="";
			String p_time_table_type="";
			//int p_max_patients_per_day = 0;
			String p_max_patients_per_day="0";
			String p_max_pat_per_day="";
			String p_time_per_slab="";
			String p_max_patients_per_slab="";
			String p_max_first_visits="";
			String p_max_over_booking="";
			String p_practitioner_code="";
			String p_time_per_patient="";
			String forcedNo="0";
			String globalNo="0";
			String res_class_desc="";
			String care_locn_desc="";
			String oper_stn_id="";
			String chk 	= "unchecked" ;
			String p_roster_checked="";
			String CurrentDatetm="";
			String CurrentDate="";
			String res_class="";
			String rule_appl_yn="";
			String max_new_patients="";
			String max_old_patients="";

			String sql1="select visit_limit_rule,slot_appt_ctrl,alcn_criteria,alcn_basis,to_char(SYSDATE,'dd/mm/yyyy hh24:mi') dttm,to_char(sysdate,'dd/mm/yyyy') dt,rule_appl_yn, schedule_extend_yn from oa_param ";

			oper_stn_id = request.getParameter("oper_stn_id");

			


		rs_valstart = st_valstart.executeQuery(sql1) ;
		if(rs_valstart!=null && rs_valstart.next())
			{
				alcncriteria	 = rs_valstart.getString("alcn_criteria");
				if(alcncriteria ==null) alcncriteria="";
				alcn_basis		 = rs_valstart.getString("alcn_basis");
				if(alcn_basis ==null)	 alcn_basis="";
				slot_appt_ctrl	 = rs_valstart.getString("slot_appt_ctrl");
				visit_limit_rule = rs_valstart.getString("visit_limit_rule");
				CurrentDatetm=rs_valstart.getString("dttm");
				 CurrentDate=rs_valstart.getString("dt");
				 rule_appl_yn	 = rs_valstart.getString("rule_appl_yn")==null?"N":rs_valstart.getString("rule_appl_yn");
				 //Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
				 schedule_extend_param	 = rs_valstart.getString("schedule_extend_yn")==null?"N":rs_valstart.getString("schedule_extend_yn");
			}else
			{
				out.println("<script>alert(getMessage('OA_PARAM_NOT_FOUND','OA'))</script>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
		if (rs_valstart!=null) rs_valstart.close();

	if( function_mode.equals("modify") && function_type.equals("") )
	{			 

			//rs_valstart=st_valstart.executeQuery("select to_char(min(appt_slab_from_time),'hh24:mi') str_appt_time, to_char(max(appt_slab_to_time) ,'hh24:mi') end_appt_time from oa_appt where facility_id='"+facilityid+"'  and clinic_code='"+p_clinic_code+"'  and nvl(practitioner_id,'x') = nvl('"+practid+"','x') and appt_date= to_date('"+clinic_date+"','dd/mm/yyyy') ");
			String sql2 = "select to_char(min(appt_slab_from_time),'hh24:mi') str_appt_time, to_char(max(appt_slab_to_time) ,'hh24:mi') end_appt_time from oa_appt where facility_id=?  and clinic_code=?  and nvl(practitioner_id,'x') = nvl(?,'x') and appt_date= to_date(?,'dd/mm/yyyy') ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,clinic_date);
			rs_valstart = pstmt.executeQuery();
			while(rs_valstart.next())
				{
					start_appt_time= rs_valstart.getString("str_appt_time");
					if( start_appt_time == null) start_appt_time="";		
					end_appt_time = rs_valstart.getString("end_appt_time");
					if( end_appt_time == null) end_appt_time="";	
				}	
			//String sql_chk="select to_char(min(effective_from_date_time),'hh24:mi') block_start_time, to_char(max(effective_to_date_time),'hh24:mi') block_to_time from oa_block_appt where facility_id='"+facilityid+"'  and clinic_code='"+p_clinic_code+"'  and nvl(practitioner_id,'x') = nvl('"+practid+"','x') and block_date= to_date('"+clinic_date+"','dd/mm/yyyy') ";
			//rs_blkappt=st_blkappt.executeQuery(sql_chk);
			String sql_chk="select to_char(min(effective_from_date_time),'hh24:mi') block_start_time, to_char(max(effective_to_date_time),'hh24:mi') block_to_time from oa_block_appt where facility_id=?  and clinic_code=?  and nvl(practitioner_id,'x') = nvl(?,'x') and block_date= to_date(?,'dd/mm/yyyy') ";
			pstmt = conn.prepareStatement(sql_chk);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,clinic_date);
			rs_blkappt = pstmt.executeQuery();
			while(rs_blkappt.next())
				{
					block_start_time = rs_blkappt.getString("block_start_time");
					if( block_start_time == null) block_start_time="";
					
					block_end_time = rs_blkappt.getString("block_to_time");
					if( block_end_time == null) block_end_time="";
				}	
	
}

 
	//String populate_schedule	="Select total_overbooked, nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name,clinic_code, clinic_date , srl_no , practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type ,remarks , to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time,	to_char(time_per_patient,'hh24:mi') time_per_patient,	max_patients_per_day , to_char(time_per_slab,'hh24:mi' ) time_per_slab , max_patients_per_slab,	max_first_visits,max_over_booking,max_slots_per_day,max_other_visits,nvl(MAX_FORCED_IN_BOOKING,0) MAX_FORCED_IN_BOOKING ,nvl(MAX_GLOBAL_BOOKING,0) MAX_GLOBAL_BOOKING,nvl(RESOURCE_TYPE,'P') RESOURCE_TYPE,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,'"+locale+"','1')care_locn_type_ind_desc , resource_class,null resource_class_desc,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, to_char(org_end_time,'hh24:mi') org_end_time, org_max_patients_per_day, org_max_first_visits, org_max_slots_per_day, org_max_other_visits, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots From oa_clinic_schedule where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and Nvl(PRACTITIONER_ID,'X')= nvl('"+practid+"' ,'X') and care_locn_type_ind='"+locn_care_ind+"' and resource_class='"+resource_class+"' ";
	String populate_schedule	="Select total_overbooked, nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name,clinic_code, clinic_date , srl_no , practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type ,remarks , to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time,	to_char(time_per_patient,'hh24:mi') time_per_patient,	max_patients_per_day , to_char(time_per_slab,'hh24:mi' ) time_per_slab , max_patients_per_slab,	max_first_visits,max_over_booking,max_slots_per_day,max_other_visits,nvl(MAX_FORCED_IN_BOOKING,0) MAX_FORCED_IN_BOOKING ,nvl(MAX_GLOBAL_BOOKING,0) MAX_GLOBAL_BOOKING,nvl(RESOURCE_TYPE,'P') RESOURCE_TYPE,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,?,'1')care_locn_type_ind_desc , resource_class,null resource_class_desc,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, to_char(org_end_time,'hh24:mi') org_end_time, org_max_patients_per_day, org_max_first_visits, org_max_slots_per_day, org_max_other_visits, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots From oa_clinic_schedule where facility_id=? and Clinic_code=? and clinic_date =to_date(?,'dd/mm/yyyy') and Nvl(PRACTITIONER_ID,'X')= nvl(? ,'X') and care_locn_type_ind=? and resource_class=? ";
	//System.out.println("populate_schedule  ==>"+populate_schedule);
			
	//String time_table_sch ="select clinic_code,clinic_name,CARE_LOCN_TYPE_DESC,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week,practitioner_id,nvl(practitioner_full_name,'')practitioner_name,time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient,nvl(max_patients_per_day,'')max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab,nvl(max_patients_per_slab,'')max_patients_per_slab,nvl(max_first_visits,'')max_first_visits,nvl(max_over_booking,'')max_over_booking,nvl(max_slots_for_first_visit,'')max_slots_for_first_visit,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks,max_slots_per_day,max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots from oa_clinic_time_table_vw where facility_id = '"+facilityid+"' and clinic_code = '"+p_clinic_code+"' and nvl(practitioner_id,'X') = nvl('"+practid.trim()+"','X') and day_no = '"+dayno+"' and time_table_type = '"+timetabletype+"' and resource_class='"+resource_class+"' ";
	String time_table_sch ="select clinic_code,clinic_name,CARE_LOCN_TYPE_DESC,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week,practitioner_id,nvl(practitioner_full_name,'')practitioner_name,time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient,nvl(max_patients_per_day,'')max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab,nvl(max_patients_per_slab,'')max_patients_per_slab,nvl(max_first_visits,'')max_first_visits,nvl(max_over_booking,'')max_over_booking,nvl(max_slots_for_first_visit,'')max_slots_for_first_visit,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks,max_slots_per_day,max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots from oa_clinic_time_table_vw where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') = nvl(?,'X') and day_no = ? and time_table_type = ? and resource_class=? ";
	//System.out.println("time_table_sch ==>"+time_table_sch);
		
	//String populate_tim_table_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_break Where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"'  and day_no = '"+dayno+"'  and Nvl(practitioner_id,'X')= nvl( '"+practid+"' ,'X') Order by break_start_time ";
	String populate_tim_table_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_break Where facility_id=? and Clinic_code=?  and day_no = ?  and Nvl(practitioner_id,'X')= nvl( ? ,'X') Order by break_start_time ";

	//String populate_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_schedule_break Where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"'  and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')  and Nvl(practitioner_id,'X')= nvl( '"+practid+"' ,'X') Order by break_start_time ";
	String populate_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_schedule_break Where facility_id=? and Clinic_code=?  and clinic_date =to_date(?,'dd/mm/yyyy')  and Nvl(practitioner_id,'X')= nvl( ? ,'X') Order by break_start_time ";


	if( function_mode.equals("modify"))
	{
		if(function_type.equals(""))
		{			
		//rspop_sch = stmtn1.executeQuery(populate_schedule);
		pstmt = conn.prepareStatement(populate_schedule);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locale);
		pstmt.setString(7,facilityid);
		pstmt.setString(8,p_clinic_code);
		pstmt.setString(9,clinic_date);
		pstmt.setString(10,practid);
		pstmt.setString(11,locn_care_ind);
		pstmt.setString(12,resource_class);
		rspop_sch = pstmt.executeQuery();
		//rspop_break = stmtn2.executeQuery(populate_break);
		//if(pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(populate_break);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,clinic_date);
		pstmt.setString(4,practid);
		rspop_break = pstmt.executeQuery();
		}else{	
			
		//rspop_sch = stmtn1.executeQuery(time_table_sch);
		//if(pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(time_table_sch);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,practid.trim());
		pstmt.setString(4,dayno);
		pstmt.setString(5,timetabletype);
		pstmt.setString(6,resource_class);
		rspop_sch = pstmt.executeQuery();
		//if(pstmt != null) pstmt.close();
		//rspop_break = stmtn2.executeQuery(populate_tim_table_break);
		pstmt = conn.prepareStatement(populate_tim_table_break);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,dayno);
		pstmt.setString(4,practid);
		rspop_break = pstmt.executeQuery();
		}
			while( rspop_sch.next())
			{
					if(function_type.equals(""))
				{
					overbook_cnt = rspop_sch.getString("total_overbooked");
					if( overbook_cnt == null) overbook_cnt="0";

					first_visit_cnt = rspop_sch.getString("total_first_visit");

					other_visit_cnt = rspop_sch.getString("total_other_visits");

					p_clinic_name=rspop_sch.getString("clinic_name");
					p_practitioner_name=rspop_sch.getString("practitioner_name");
					if( p_practitioner_name == null) p_practitioner_name="";

					p_practitioner_code =rspop_sch.getString("practitioner_id");
					if( p_practitioner_code == null) p_practitioner_code="";

					//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
					schedule_extend_yn = rspop_sch.getString("schedule_extend_yn")==null?"N":rspop_sch.getString("schedule_extend_yn");
					if(schedule_extend_yn.equals("Y"))
						schedule_extend_yn_chk = "checked";
					
					if(schedule_extend_yn.equals("Y"))
					{
						p_end_time = rspop_sch.getString("org_end_time");
						p_max_patients_per_day = rspop_sch.getString("org_max_patients_per_day");
						if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
							p_max_patients_per_day = "0";
						p_max_first_visits = rspop_sch.getString("org_max_first_visits");
						if( p_max_first_visits == null) p_max_first_visits="";
						p_max_slots_per_day = rspop_sch.getString("org_max_slots_per_day");
						if( p_max_slots_per_day == null) p_max_slots_per_day="";
						p_max_other_visits = rspop_sch.getString("org_max_other_visits");
						if( p_max_other_visits == null) p_max_other_visits="";
					}else
					{
						p_end_time = rspop_sch.getString("end_time");
						p_max_patients_per_day = rspop_sch.getString("max_patients_per_day");
						if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
							p_max_patients_per_day = "0";
						p_max_first_visits = rspop_sch.getString("max_first_visits");
						if( p_max_first_visits == null) p_max_first_visits="";
						p_max_slots_per_day = rspop_sch.getString("max_slots_per_day");
						if( p_max_slots_per_day == null) p_max_slots_per_day="";
						p_max_other_visits = rspop_sch.getString("max_other_visits");
						if( p_max_other_visits == null) p_max_other_visits="";
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					ext_all_slots_yn = rspop_sch.getString("ext_all_slots_yn")==null?"N":rspop_sch.getString("ext_all_slots_yn");
					if(ext_all_slots_yn.equals("Y"))
						ext_all_slots_yn_chk = "checked";
					ext_start_slots = rspop_sch.getString("ext_start_slots");
						if( ext_start_slots == null) ext_start_slots = "";
					ext_mid_slots = rspop_sch.getString("ext_mid_slots");
						if( ext_mid_slots == null) ext_mid_slots = "";
					ext_end_slots = rspop_sch.getString("ext_end_slots");
						if( ext_end_slots == null) ext_end_slots = "";

					p_remarks=rspop_sch.getString("remarks");       
					if( p_remarks == null) p_remarks="";
					p_start_time=rspop_sch.getString("start_time");         
					p_time_table_type=rspop_sch.getString("time_table_type");
					p_time_per_slab=rspop_sch.getString("time_per_slab");        
					if( p_time_per_slab == null )p_time_per_slab="";
					p_max_patients_per_slab	=rspop_sch.getString("max_patients_per_slab");
					if( p_max_patients_per_slab == null )p_max_patients_per_slab="";
					p_max_over_booking=rspop_sch.getString("max_over_booking");	
					if( p_max_over_booking == null) p_max_over_booking="";
					p_clinic_code = rspop_sch.getString("clinic_code");
					if( p_clinic_code == null) p_clinic_code="";
					p_time_per_patient = rspop_sch.getString("time_per_patient");
					if( p_time_per_patient == null) p_time_per_patient="";
										
					forcedNo=rspop_sch.getString("MAX_FORCED_IN_BOOKING");
					globalNo=rspop_sch.getString("MAX_GLOBAL_BOOKING");
					max_new_patients=rspop_sch.getString("MAX_NEW_PATIENTS")==null?"":rspop_sch.getString("MAX_NEW_PATIENTS");
					max_old_patients=rspop_sch.getString("MAX_OLD_PATIENTS")==null?"":rspop_sch.getString("MAX_OLD_PATIENTS");
					res_class= rspop_sch.getString("resource_class");
					if( res_class == null) res_class="";

				if(res_class.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_class.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_class.equals("R"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_class.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

					care_locn_desc= rspop_sch.getString("care_locn_type_ind_desc");
					if( care_locn_desc == null) care_locn_desc="";
					 
				}else
				{
					
					p_start_time=rspop_sch.getString("start_time");         
					p_end_time=rspop_sch.getString("end_time");        
					p_time_table_type=rspop_sch.getString("time_table_type");
					day_of_week =rspop_sch.getString("day_of_week");
					care_locn_desc= rspop_sch.getString("CARE_LOCN_TYPE_DESC");
					if( care_locn_desc == null) care_locn_desc="";
					res_class_desc= rspop_sch.getString("resource_class_desc");
					if( res_class_desc == null) res_class_desc="";
					p_remarks=rspop_sch.getString("remarks");       
					if( p_remarks == null) p_remarks="";
					p_max_patients_per_slab	= 	rspop_sch.getString("max_patients_per_slab") ;
					if(p_max_patients_per_slab == null) p_max_patients_per_slab="";

					//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
					schedule_extend_yn = rspop_sch.getString("schedule_extend_yn")==null?"N":rspop_sch.getString("schedule_extend_yn");
					if(schedule_extend_yn.equals("Y"))
						schedule_extend_yn_chk = "checked";

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					ext_all_slots_yn = rspop_sch.getString("ext_all_slots_yn")==null?"N":rspop_sch.getString("ext_all_slots_yn");
					if(ext_all_slots_yn.equals("Y"))
						ext_all_slots_yn_chk = "checked";
					ext_start_slots = rspop_sch.getString("ext_start_slots");
						if( ext_start_slots == null) ext_start_slots = "";
					ext_mid_slots = rspop_sch.getString("ext_mid_slots");
						if( ext_mid_slots == null) ext_mid_slots = "";
					ext_end_slots = rspop_sch.getString("ext_end_slots");
						if( ext_end_slots == null) ext_end_slots = "";

					p_max_first_visits	=	rspop_sch.getString("max_first_visits") ;
					if(p_max_first_visits == null) p_max_first_visits="";
					p_max_patients_per_day 	=rspop_sch.getString("max_patients_per_day");
					if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
						p_max_patients_per_day = "0";
					p_max_over_booking	=	rspop_sch.getString("max_over_booking") ;
					if(p_max_over_booking == null) p_max_over_booking="";

					p_time_per_patient	=	rspop_sch.getString("time_per_patient" );
					if(p_time_per_patient == null) p_time_per_patient="";

					p_time_per_slab	= 	rspop_sch.getString("time_per_slab") ;
					if(p_time_per_slab == null) p_time_per_slab="";

					p_max_other_visits	= 	rspop_sch.getString("max_other_visits") ;
					if(p_max_other_visits == null) p_max_other_visits="";

					p_max_slots_per_day = 	rspop_sch.getString("max_slots_per_day") ;
					if(p_max_slots_per_day == null) p_max_slots_per_day="";

					p_clinic_name=rspop_sch.getString("clinic_name");
					p_practitioner_name=rspop_sch.getString("practitioner_name");
					if( p_practitioner_name == null) p_practitioner_name="";

					p_clinic_code=rspop_sch.getString("clinic_code");

					forcedNo	= 	rspop_sch.getString("NO_OF_FORCED_IN_APPT") ;
					if(forcedNo == null) forcedNo="0";
					globalNo	= 	rspop_sch.getString("NO_OF_GLOBAL_APPT_FOR_REF") ;
					max_new_patients	= 	rspop_sch.getString("MAX_NEW_PATIENTS")==null?"":rspop_sch.getString("MAX_NEW_PATIENTS");
					max_old_patients	= 	rspop_sch.getString("MAX_OLD_PATIENTS")==null?"":rspop_sch.getString("MAX_OLD_PATIENTS");
					if(globalNo == null) globalNo="0";
			
						p_roster_checked = rspop_sch.getString("phys_roster_reqd_yn") ;

						if (p_roster_checked.equals("Y"))
						{
							chk 	= "checked" ;
						}
						else
						{
							chk 	= "unchecked" ;
						}
					
				}
					if (timetabletype.equals("1"))
					{
						if (slot_appt_ctrl.equals("S")){
							slot_or_pat =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Slot.label","common_labels");
							time_per_pat_prompt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeperSlot.label","oa_labels");
						}
						else
							slot_or_pat =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels");
					}
					else
					slot_or_pat ="&nbsp;";
			}
	  }

	if( function_mode.equals("modify"))
	{
			//rsSet=st.executeQuery("Select to_char(working_day_start_time,'hh24:mi') stm,to_char(working_day_end_time,'hh24:mi') etm,to_char(base_slot_slab_time,'hh24:mi') dur from op_clinic where facility_id='"+facilityid+"' and clinic_type='"+locn_care_ind+"' and clinic_code='"+p_clinic_code+"'");
			//if(pstmt != null) pstmt.close();
			pstmt = conn.prepareStatement("Select to_char(working_day_start_time,'hh24:mi') stm,to_char(working_day_end_time,'hh24:mi') etm,to_char(base_slot_slab_time,'hh24:mi') dur from op_clinic where facility_id=? and clinic_type=? and clinic_code=?");
			pstmt.setString(1,facilityid);
			pstmt.setString(2,locn_care_ind);
			pstmt.setString(3,p_clinic_code);
			rsSet = pstmt.executeQuery();	
			if (rsSet.next())
			{
				startTime=rsSet.getString("stm");         
				endTime=rsSet.getString("etm");
				if (startTime==null) startTime="";
				if (endTime==null) endTime="";
			}

			if (rsSet!=null)    rsSet.close();
			if (st !=null) st.close();

			stmtnAlcn=conn.createStatement();
			
			//String sqlAlcn="select a.ALCN_CATG_CODE,b.STAT_GRP_DESC,a.ALCN_PATIENT from oa_clinic_alcn a,AM_STAT_GROUP b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id='"+facilityid+"' and a.clinic_code='"+p_clinic_code+"' and NVL(a.PRACTITIONER_ID,'X')=NVL('"+practid+"','X') and a.day_no='"+dayno+"' and a.TIME_TABLE_TYPE='"+timetabletype+"'";
			//rsAlcn=stmtnAlcn.executeQuery(sqlAlcn);
			String sqlAlcn="select a.ALCN_CATG_CODE,b.STAT_GRP_DESC,a.ALCN_PATIENT from oa_clinic_alcn a,AM_STAT_GROUP b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id=? and a.clinic_code=? and NVL(a.PRACTITIONER_ID,'X')=NVL(?,'X') and a.day_no=? and a.TIME_TABLE_TYPE=?";
			//if(pstmt != null) pstmt.close();
			pstmt = conn.prepareStatement(sqlAlcn);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,dayno);
			pstmt.setString(5,timetabletype);
			rsAlcn = pstmt.executeQuery();		

			int count=0;
			int alcn_patientCnt=0;
			while (rsAlcn!=null && rsAlcn.next()){
				alcnCode=rsAlcn.getString("ALCN_CATG_CODE");
				alcnDesc=rsAlcn.getString("STAT_GRP_DESC");
				alcnSlotNo=rsAlcn.getInt("ALCN_PATIENT");
				alcn_patientCnt=alcn_patientCnt+alcnSlotNo;
				if(count==0){
					finalalcnString=alcnCode+"$"+alcnSlotNo+"$"+alcnDesc;
				}else{
					finalalcnString=finalalcnString+"|"+alcnCode+"$"+alcnSlotNo+"$"+alcnDesc;
				}
				count++;
			}
			int intval = 0;			
			 intval = (Integer.parseInt(p_max_patients_per_day)-alcn_patientCnt);
			if(finalalcnString!=null && !finalalcnString.equals("")){
				finalalcnString=finalalcnString+"|OTH$"+intval+"$Others";

			}else{
				finalalcnString=finalalcnString+"|OTH$"+intval+"$Others";


					}

			if(finalalcnString!=null)
				{		
							
							stmtnAlcn1=conn.createStatement();

							//String sqlAlcn1="SELECT a.alcn_catg_code ALCN_CATG_CODE, b.stat_grp_desc STAT_GRP_DESC,a.MAX_PATIENTS  MAX_PATIENTS FROM oa_clinic_schedule_dtl a, am_stat_group b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id='"+facilityid+"' and a.clinic_code='"+p_clinic_code+"' and  clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')";
							//rsAlcn1=stmtnAlcn1.executeQuery(sqlAlcn1);
							String sqlAlcn1="SELECT a.alcn_catg_code ALCN_CATG_CODE, b.stat_grp_desc STAT_GRP_DESC,a.MAX_PATIENTS  MAX_PATIENTS FROM oa_clinic_schedule_dtl a, am_stat_group b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id=? and a.clinic_code=? and  clinic_date =to_date(?,'dd/mm/yyyy')";
							

						//	if(pstmt != null) pstmt.close();
							pstmt = conn.prepareStatement(sqlAlcn1);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,p_clinic_code);
							pstmt.setString(3,clinic_date);
							rsAlcn1 = pstmt.executeQuery();
							int count1=0;
			int alcn_patientCnt1=0;

			String alcnCode1 ="";
			String alcnDesc1 ="";
			int MAX_PATIENTS =0;

			int al_no = 0;

			while (rsAlcn1!=null && rsAlcn1.next()){
				alcnCode1=rsAlcn1.getString("ALCN_CATG_CODE");
				alcnDesc1=rsAlcn1.getString("STAT_GRP_DESC");
				MAX_PATIENTS=rsAlcn1.getInt("MAX_PATIENTS");

				alcn_patientCnt1 = MAX_PATIENTS;

				if(count1==0){
					finalalcnString=alcnCode1+"$"+alcn_patientCnt1+"$"+alcnDesc1;
					al_no = al_no+alcn_patientCnt1;

				}else{
					finalalcnString=finalalcnString+"|"+alcnCode1+"$"+alcn_patientCnt1+"$"+alcnDesc1;
				
					al_no = alcn_patientCnt1+al_no;
					
				}
				count1++;

			}
			int  intval1=0;


			intval1= (Integer.parseInt(p_max_patients_per_day)-al_no);

			if(finalalcnString!=null && !finalalcnString.equals("")){

				finalalcnString=finalalcnString+"|OTH$"+intval1+"$Others";


			}else{
								finalalcnString=finalalcnString+"|OTH$"+intval1+"$Others";

					}
				}

	}

				/*
						Commented for PE by Suresh on 24/06/2010
					rssql2=stsql2.executeQuery("SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+fid+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
						
					if (rssql2!=null && rssql2.next())
						{
							oper_stn_id=rssql2.getString("oper_stn_id");
							if(oper_stn_id == null) oper_stn_id="";
						
						}else{
					*/		
						
            _bw.write(_wl_block10Bytes, _wl_block10);

						//}
			

			
	
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!function_mode.equals("modify")) { 
				rsLoc = stmtn.executeQuery("Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id = '"+locale+"' and locn_type in ('C','E','Y') order by 2");
				String short_desc="";
				String clinic_type="";
				
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

					while (rsLoc.next()) 
					{
						short_desc=rsLoc.getString("short_desc");
						clinic_type=rsLoc.getString("care_locn_type_ind");
						
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(care_locn_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_care_ind));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

								if(!function_mode.equals("modify")) 
			{ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(function_type.equals("")) {
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}else {
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_clinic_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_clinic_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
if(!function_mode.equals("modify")) 
				{ 
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}else
				{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(!function_mode.equals("modify")) 
				{ 
            _bw.write(_wl_block47Bytes, _wl_block47);
            {java.lang.String __page ="../../eOA/jsp/OAResourcelookupframe.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from_page"), weblogic.utils.StringUtils.valueOf("schedule")},{ weblogic.utils.StringUtils.valueOf("pract_value"), weblogic.utils.StringUtils.valueOf("")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block48Bytes, _wl_block48);
 } else { 
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(p_practitioner_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
if(!function_type.equals("")) { 
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
if(function_type.equals("")) { 
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
 
					
				if(!function_mode.equals("modify")) 
				{ 
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(clinic_date_display));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
}else {
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
 
					
				if(!function_mode.equals("modify")) 
				{ 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
}else{
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(day_of_week));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(dayno));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(!function_mode.equals("modify"))
					{ 
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(p_time_table_type));
            _bw.write(_wl_block80Bytes, _wl_block80);
 if( p_time_table_type.equals("1")) 
						{ 
            _bw.write(_wl_block81Bytes, _wl_block81);
} else if( p_time_table_type.equals("2")) 
						{
            _bw.write(_wl_block82Bytes, _wl_block82);
} else  if( p_time_table_type.equals("3"))
						{
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(p_start_time));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(function_mode));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
 if( ! overbook_cnt.equals("0")) 
				{ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(p_end_time));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(function_mode));
            _bw.write(_wl_block92Bytes, _wl_block92);
  } else 
				{ 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(p_end_time));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(function_mode));
            _bw.write(_wl_block95Bytes, _wl_block95);
 } 
            _bw.write(_wl_block96Bytes, _wl_block96);
if(isScheduleExtendAppl && schedule_extend_param.equals("Y")){
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(schedule_extend_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(schedule_extend_yn_chk));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(time_per_pat_prompt));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(p_time_per_patient));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(p_max_slots_per_day));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(p_time_per_slab));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(p_max_patients_per_slab));
            _bw.write(_wl_block111Bytes, _wl_block111);

		if(!p_max_patients_per_day.equals("0")) {
			p_max_pat_per_day = p_max_patients_per_day;
		}
	
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(p_max_pat_per_day));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(p_max_patients_per_day));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(isSlotStartMidEndAppl){
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(ext_all_slots_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ext_all_slots_yn_chk));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(ext_start_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(ext_mid_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(ext_end_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(slot_or_pat));
            _bw.write(_wl_block125Bytes, _wl_block125);
if (visit_limit_rule.equals("E"))
			{
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
}else {
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(p_max_first_visits));
            _bw.write(_wl_block129Bytes, _wl_block129);
if (visit_limit_rule.equals("E")){
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
}else {
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(p_max_other_visits));
            _bw.write(_wl_block131Bytes, _wl_block131);
if(rule_appl_yn.equals("Y")){
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(max_new_patients));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(max_old_patients));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(p_max_over_booking));
            _bw.write(_wl_block137Bytes, _wl_block137);

							
				String	chked="";
				String dsib="disabled";
				if (Integer.parseInt(forcedNo)>0)
				{
					chked="checked";
					dsib="";
							

				}else{
					forcedNo="";

				}
				String dsib1="disabled";

				if (Integer.parseInt(globalNo)>=0)
				{
					dsib1="";
				}else {
					globalNo="";
				}
				if(Integer.parseInt(globalNo)==0)
				{
					globalNo="";
				}
				
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(chked));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
 if(!function_mode.equals("modify")) 
			{ 
            _bw.write(_wl_block143Bytes, _wl_block143);
}else{
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dsib));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(forcedNo));
            _bw.write(_wl_block146Bytes, _wl_block146);
}
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
 
			
			if(!function_mode.equals("modify")) 
			{ 
            _bw.write(_wl_block149Bytes, _wl_block149);
}else{
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(dsib1));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(globalNo));
            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block153Bytes, _wl_block153);
if(!alcncriteria.equals("")){
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
}else{
            _bw.write(_wl_block156Bytes, _wl_block156);
}
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(p_remarks));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
	
			if(!function_mode.equals("modify"))
			{
				int i = 1; 
				for( i=1;i<6;i++)
				{
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
			}else
			{
				int i = 1;
				String fr="";
				String to="";
				boolean bool=true;
			  for( i=1;i<6;i++)
			  {
					
            _bw.write(_wl_block172Bytes, _wl_block172);

					  if(rspop_break.next() && bool)
					  {
					   	fr=rspop_break.getString("break_start_time");
					   	to=rspop_break.getString("break_end_time");
					  }else
					  {
					   	fr="";
					   	to="";
					   	bool=false;
					   }
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(fr));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(to));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
}//for loop
			}
            _bw.write(_wl_block178Bytes, _wl_block178);
 if(!function_mode.equals("modify")) 
				{ 
            _bw.write(_wl_block179Bytes, _wl_block179);
 } else
				{ 
            _bw.write(_wl_block180Bytes, _wl_block180);
 } 
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(start_appt_time));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(end_appt_time));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(block_start_time));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(block_end_time));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(overbook_cnt));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(first_visit_cnt));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(other_visit_cnt));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(alcncriteria));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(finalalcnString));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(alcn_basis));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(p_time_table_type));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(p_start_time));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(p_end_time));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(function_mode));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(function_type));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(CurrentDatetm));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(CurrentDate));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(isScheduleExtendAppl));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(schedule_extend_param));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ext_all_slots_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(ext_start_slots));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ext_mid_slots));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(ext_end_slots));
            _bw.write(_wl_block215Bytes, _wl_block215);
 if(function_mode.equals("modify"))
		{ 
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(p_time_table_type.equals("1"))
					{ 
            _bw.write(_wl_block216Bytes, _wl_block216);
}else if( p_time_table_type.equals("2"))
				  { 
            _bw.write(_wl_block217Bytes, _wl_block217);
 } else if(p_time_table_type.equals("3"))
				{
            _bw.write(_wl_block218Bytes, _wl_block218);
 }
            _bw.write(_wl_block219Bytes, _wl_block219);
}else
		{
            _bw.write(_wl_block220Bytes, _wl_block220);
}
            _bw.write(_wl_block221Bytes, _wl_block221);
 
	if(rsAlcn !=null) rsAlcn.close();

	if(rs_valstart !=null) rs_valstart.close();
	if(rs_valstart !=null) rs_valstart.close();
	if(rs_blkappt !=null) rs_blkappt.close();
	if(rspop_sch !=null) rspop_sch.close();
	if(rspop_break !=null) rspop_break.close();
	if(rsLoc !=null) rsLoc.close();
//	if(rssql1 !=null) rssql1.close();
//	if(rssql2 !=null) rssql2.close();
	if(stmtnAlcn !=null) stmtnAlcn.close();
	if(stmtn !=null) stmtn.close();
	if(stmtn1 !=null) stmtn1.close();
//	if(stsql1 !=null) stsql1.close();
	if(stmtn2 !=null) stmtn2.close();
//	if(stsql2 !=null) stsql2.close();
	if(st_valstart !=null) st_valstart.close();
	if(st_blkappt !=null) st_blkappt.close();
//	if(chk_time !=null)chk_time.close();
	if(stmtnAlcn1 !=null)stmtnAlcn1.close();
	if(rsAlcn1 !=null)rsAlcn1.close();
	
} catch(Exception e ){
	e.printStackTrace();
	//out.println("hre:"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.LocationResourceDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.DayTimeDetails.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.RosterRequired.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TimeTableType.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Slot.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.slab.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FreeFormat.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ExtendTillDayEnd.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SlotDetails.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SlabDetails.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.FreeFormatDetails.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.maxslotsperday.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.timeperslab.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.maxpatperslab.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.maxpatperday.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.AllSlots.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Start.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mid.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.End.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.VisitOverBookingDetails.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.nooffirstvisits.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.maxfirstvisits.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.noofothervisits.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.MaxOtherVisits.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.maxob.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ForcedinBookingsallowed.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NoofForcedinBookingday.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.noofglobalbookingperday.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BreakTime.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }
}

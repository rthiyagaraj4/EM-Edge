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

public final class __appointmentgroupselect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AppointmentGroupSelect.jsp", 1722230859013L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="                  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>  \n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n        <script language=\'javascript\' src=\'../../eOA/js/OAResourceComponent.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"> </script>\n\t\t<script src=\'../../eOA/js/BookAppointment.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n       </head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n \n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onunload=\"clear_from_sess()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t    \t<form name=\'groupApptForm\' id=\'groupApptForm\' action=\'../../servlet/eOA.BookAppointmentServlet\' method=\'post\' target=\'messageFrame\'>\n\n\t\t\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' ><tr><td>\n\n\t\t\t\t\n\t<tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\n\t\t\t\t\t<td class=\'fields\'  nowrap><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b><input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=\'10\' maxlength=\'10\'>&nbsp;<input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' readonly value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" size=\'3\' maxlength=\'5\'  onKeyUp=\"javascript:formatTimePerPatient(this)\"> - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" readonly size=\'3\' maxlength=\'5\'  onKeyUp=\"javascript:formatTimePerPatient(this)\"></td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\' colspan=2>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\n\t</tr>\n\t<!--<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>-->\n\n\t<tr>\n\t\t\t<td  class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td  class=\'fields\'  nowrap ><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b><b>/";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b>\n\t\t\t<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' size=\'15\' maxlength=\'4\'  >\n\t\t\t</td>\n\n\t\t\t<td  class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td  class=\'fields\'  nowrap ><select name = \'sel_service_code\' id = \'sel_service_code\'><option value=\"\">----------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="---------</option>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' == 1)\n\t\t\t\t\t   document.forms[0].sel_service_code.options[1].selected = true;\n\t\t\t\t\t</script>\n\t\t\t</select>\n\t\t\t</td>\t\t\t\n</tr>\n\n\t<!--<tr><td  colspan=4>&nbsp;</td></tr>-->\n\t<tr>\n      \t\t\n\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t<td class=\'fields\' nowrap><select name=\'visit_type_short_desc\' id=\'visit_type_short_desc\'  >\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ---\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="~";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' selected>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\tvis_code_Array[";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="]\t\t= \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\t\n\t\t\t\tmax_dur_Array[";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="]\t\t\t= \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\t\tmax_appt_slots_Array[";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="]  = \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\t\n\n\t\t\t<td  class=\'label\'nowrap >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\n\t\t\t\n\t\t\t<td class=\'fields\' nowrap><b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="/</b><b>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</b>\n\t\t\t\t<input type=\'hidden\' name=\'pame\' id=\'pame\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' size=\'15\' maxlength=\'15\'  > \n\t\t\t\t<input type=\'hidden\' name=\'practitioner_name\' id=\'practitioner_name\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' size=\'15\' maxlength=\'15\'  > \n\t\t\t</td>\n\t</tr>\n\t<tr>\t\t\t\t\n\t\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"fields\" nowrap colspan=1><select name = \'priorty\'><option value=\"\">----------";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="---------</option>\n\t\t\t\t\t<option value=\"U\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\n\t\t\t\t\t<option value=\"N\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option></select>\t\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\n\t\t\t\t<tr>\n\t\t<td class = \'label\'  nowrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t<td  class=\'fields\' colspan=\"3\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_id\" id=\"group_id\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"min_patient\" id=\"min_patient\" id=\"min_patient\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"max_patient\" id=\"max_patient\" id=\"max_patient\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Existing_Group_Members\" id=\"Existing_Group_Members\" id=\"Existing_Group_Members\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_location_id\" id=\"group_location_id\" id=\"group_location_id\" >\t\t\t\t\n\t\t\t\t\t\t<input type=\"text\" name=\"group_name\" id=\"group_name\" id=\"group_name\"  onblur=\'if(this.value!=\"\"){callgroupname(this,document.forms[0].group_name)}else{clearValues();}\'><input type=\"button\" name=\"group_name_lookup\" id=\"group_name_lookup\" value=\"?\" class=\"button\" onclick=\"callgroupname(this,document.forms[0].group_name)\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t<span id=\"TdLocationResult\"></span>\n\t\t\t\t\t</td>\n\t\t</tr>\n\t\t<!--<tr><td  colspan=4>&nbsp;</td></tr>-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</td>\n\t\t\t\t\t<td class=\'fields\' nowrap width=\'28%\'><input type=\"text\" name=\"reason\" id=\"reason\" onblur=\"onblurcheck(this,reason,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" size=\'35\' maxlength=\'30\'  ><input type=hidden name=\'reason_for_contact\' id=\'reason_for_contact\'  size=\'30\' maxlength=\'30\' ></input><input type=\'button\' class=\'button\' value=\'?\'  name=\'search_reason\' id=\'search_reason\' onClick=\"callReasonSearch(this,reason,\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\"  >\n\t\t\t\t\t<img id = \'reason_mand\' src = \'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t</td>\t\n\n\t\t\t\t\t<td  class=\'label\' width=\'23%\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'23%\'><input type=\"text\"  name=\"rec_date\" id=\"rec_date\" maxlength=\"16\" size=\"13\"   value=\'\' onblur=\"validateDateTime(this)\"><img  style=\"cursor:pointer\" name= \"dob1\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].rec_date.select();return showCalendar(\'rec_date\',null,\'hh:mm\');\" >\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddDTTM\" id=\"hddDTTM\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddDate\" id=\"hddDate\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddBDate\" id=\"hddBDate\" value=\"\">\n\t\t\t\t\t</td>\n\n\t\t\t\t</tr>\n\n<!--<tr><td  colspan=4>&nbsp;</td></tr>-->\n\t\t\t\t<tr>\n                  <td  class=\'label\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\n\t\t\t\t  <td  class=\'fields\'><input type=\'text\' name=\'remarks\' id=\'remarks\' value=\"\" size=\'40\' maxlength=\'60\' onblur=\'makeValidString(this);\' ></td>\n\n\t\t\t\t  <td  class=\'label\'  >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t\t  \n\t\t\t\t   <td  class=\'fields\'><select name=\'mode\' id=\'mode\' >\n\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<option value=\'T\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<option value=\'I\' selected>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t</select>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<input type=\'hidden\' name=\'apptdate\' id=\'apptdate\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t<input type=\'hidden\' name=\'practitionerid\' id=\'practitionerid\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t<input type=\'hidden\' name=\'cliniccode\' id=\'cliniccode\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\n\t<input type=\'hidden\' name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\t\n\t<input type=\"hidden\" name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<input type=\"hidden\" name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t<input type=\"hidden\" name=\"order_catalog_criteria\" id=\"order_catalog_criteria\" value =\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t<input type=\"hidden\" name=\"time_table_type\" id=\"time_table_type\" value =\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t<input type=\"hidden\" name=\"entitlement_by_pat_cat_yn\" id=\"entitlement_by_pat_cat_yn\" value =\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value =\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value =\"GROUPAPPT\" >\n\t<input type=\'hidden\' name=\'style\' id=\'style\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t<input type=\"hidden\" name=\"p_resource_class\" id=\"p_resource_class\" value =\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t<input type=\"hidden\" name=\"max_patients_per_slab\" id=\"max_patients_per_slab\" value =\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t<input type=\"hidden\" name=\"p_care_locn_type_ind\" id=\"p_care_locn_type_ind\" value =\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t<input type=\"hidden\" name=\"spec_code\" id=\"spec_code\" value =\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t<input type=\"hidden\" name=\"calling_mode\" id=\"calling_mode\" value =\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' />\n\t<input type=\'hidden\' name=\'max_other_visits\' id=\'max_other_visits\' id=\'max_other_visits\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' />\n\t<input type=\'hidden\' name=\'total_other_visits\' id=\'total_other_visits\' id=\'total_other_visits\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' />\n\t<input type=\'hidden\' name=\'max_first_visits\' id=\'max_first_visits\' id=\'max_first_visits\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' />\n\t<input type=\'hidden\' name=\'total_first_visit\' id=\'total_first_visit\' id=\'total_first_visit\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' />\n\t\n\t\n</form>\n<script>\nfunction callgroupname(obj,target){\n\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=\"\";\t   \n\ttit=getLabel(\"Common.GroupName.label\",\'Common\');\n\tsql =\"select distinct a.group_id code, a.group_name description from oa_group_hdr a ,oa_group_dtls b where eff_status=\'E\' and locn_code = \'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' and a.group_id=b.group_id and upper(a.group_id) like upper(?) and upper(a.group_name) like upper(?) order by 2\";\t\t\t\t\n\t\n\targumentArray[0] =sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK;\n\targumentArray[7] = DESC_CODE;\n\tretVal = CommonLookup(tit, argumentArray);\t\n\tif(retVal != null && retVal != \"\" ) {\n              var ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t    document.forms[0].group_name.value=arr[1];\t\n\t    document.forms[0].group_id.value=arr[0];\t\n\t\tcallGroupLocation(arr[0])\n\t   // document.getElementById(\"PatientSearchContainer\").style.display=\"inline\";\n          } else {\n        \t  clearValues();\n    }\n}\n\nfunction callGroupLocation(GroupId){  \n\tvar apptdate\t=  document.forms[0].appt_date.value;\n\tvar fromtime\t=  document.forms[0].From_timeval.value;\n\tvar totime\t\t=  document.forms[0].To_timeval.value;\n\tvar cliniccode\t=  document.forms[0].cliniccode.value;\n\tvar practitionerid\t=  document.forms[0].practitionerid.value;\n\t $.ajax({  \n      url:\'../../eOA/jsp/GetGroupLocation.jsp\',  \n      type:\'post\',  \n      data:{\'GroupId\':GroupId,\'apptdate\':apptdate,\'fromtime\':fromtime,\'totime\':totime,\'cliniccode\':cliniccode,\'practitionerid\':practitionerid,\'action\':\'get_slap_overlap_count\',\'action1\':\'get_available_slaps_count\'},\n      dataType: \'json\',\n      success: function(data) {  \n     \t if(data.isJsonResults==1){\n     \t\tvar ResultString\t= \"\";     \t\t\n     \t\tResultString+=\"<span style=\'margin-left:10px;\'class=\'label\'>\"+getLabel(\'Common.MIN.label\',\'Common\')+\" \"+getLabel(\'Common.patient.label\',\'Common\')+\" : \"+data.MIN_PATIENTS+\"</span>\";\n     \t\tResultString+=\"<span style=\'margin-left:10px;\' class=\'label\'>\"+getLabel(\'Common.Max.label\',\'Common\')+\" \"+getLabel(\'Common.patient.label\',\'Common\')+\" : \"+data.MAX_PATIENTS+\"</span>\";\n     \t\tif(data.TotMemberInGroup > 0){\n     \t\t\tResultString+=\"<span style=\'margin-left:10px;\' class=\'label\'>\"+getLabel(\'eOA.TotalPatientsLinkedInGroup.label\',\'OA\')+\" : \"+data.TotMemberInGroup+\"</span>\";\n     \t\t}\n     \t\t$(\"#min_patient\").val(data.MIN_PATIENTS);\n     \t\t$(\"#max_patient\").val(data.MAX_PATIENTS);\n     \t\t$(\"#Existing_Group_Members\").val(data.TotMemberInGroup);\n     \t\t$(\"#group_location_id\").val(data.LOCN_CODE);\n     \t\t$(\"#TdLocationResult\").html(ResultString);\n     \t\tvar Available_Slabs\t= data.AVAILABLE_SLAP_COUNT;\n\t\t\tif(data.TotMemberInGroup < data.MIN_PATIENTS){\t\t\n\t\t\t   var error = getMessage(\"PAT_ASSGRP_LESS_MINPAT\",\"OA\")\n\t\t\t\t// error = error.replace(\"$\",data.TotMemberInGroup)\n\t\t\t\t// error = error.replace(\"#\",data.MIN_PATIENTS)\n\t\t\t     alert(error)\n\t\t\t     clearValues();\n\t\t\t   return false;\n\t\t   }\n\t\t   if(Available_Slabs < data.TotMemberInGroup && Available_Slabs > 0){\n\t\t\t\tvar error = getMessage(\"PATCNT_GREAT_SLOTS\",\"OA\");\n\t\t\t\t// error = error.replace(\"$\",data.TotMemberInGroup)\n\t\t\t\t// error = error.replace(\"#\",Available_Slabs)\n\t\t\t\t alert(error)\n\t\t\t\t clearValues();\n\t\t\t\t return false;\n\t\t   }\n\n\t\t   \n\t\t   if(data.SLAP_OVERLAP_COUNT > 0){\n\t\t\t   alert(getMessage(\"APPT_OVERLAP\",\"OA\"));\n\t\t   }\n     \t }\n      } ,\n      error: function(jqXHR, textStatus, errorThrown) {\n          alert(\"incoming Text \" + jqXHR.responseText);\n      }\n  });  \n}\n\nfunction clearValues(){\n\tdocument.forms[0].group_name.value = \"\";\t\n\t$(\"#min_patient\").val(\"\");\n\t$(\"#max_patient\").val(\"\");\n\t$(\"#Existing_Group_Members\").val(\"\");\n\t$(\"#group_location_id\").val(\"\");\n\t$(\"#TdLocationResult\").html(\"\");\n\t//parent.frames[2].location.href = \"../../eCommon/html/blank.html\";\n}\n</script>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\n</body>\n</html>\n\n \n\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");	
	String facilityid=(String)session.getValue("facility_id");
	
	
	
	String Resource_type="";
	String sql5="";
	String visitcode="";
	String visitdesc="";
	String visitind="";	
	String practid="";
	String practname="";
	String apptdate="";
	String fromtime="";
	String totime="";
	String spec_code="";
	String age_group_code="";
	String care_locn_ind_desc="";
	String service_code="";
	String allow_referral_yn = "";
	String allow_non_referral_yn = "";
	String locale ="";		
	
	String sydate_time="";
	String sys_date_time="";
	String starttime="";
    String endtime="";
    String srl_no="";
	
	
	

	String max_patients_per_slab =checkForNull(request.getParameter("max_patients_per_slab"),"0"); 
	
	String res_type=checkForNull(request.getParameter("res_type"),"P");
	String cliniccode=checkForNull(request.getParameter("i_clinic_code"));
	int visit_ind_count=0;	
	String visit_type_ind=checkForNull(request.getParameter("visit_type_ind"));	
	String clinic_type=checkForNull(request.getParameter("clinic_type"),"C");
	String clinicname=request.getParameter("clinic_name");
	practname=checkForNull(request.getParameter("i_practitioner_name"));
	practid=checkForNull(request.getParameter("i_practitioner_id"));
	
	String or_catalogue_code=request.getParameter("or_catalogue_code");
	if(or_catalogue_code ==null || or_catalogue_code.equals("null")) or_catalogue_code="";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null || order_id.equals("null") )order_id ="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null || order_line_num.equals("null")) order_line_num="";
	String order_catalog_code=request.getParameter("order_catalog_code");//From Pending order schedule
	if(order_catalog_code ==null || order_catalog_code.equals("null")) order_catalog_code="";
	String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));	
	String i_patient_id=checkForNull(request.getParameter("i_patient_id"));
	String time_table_type=checkForNull(request.getParameter("i_time_table_type"));
	String entitlement_by_pat_cat_yn	= checkForNull(request.getParameter("entitlement_by_pat_cat_yn"));
	String calling_mode	= checkForNull(request.getParameter("calling_mode"));
	
	StringBuffer sql_srl_no= new StringBuffer("");
	
	
	
	if(locale.equals("en")){
		practname=java.net.URLDecoder.decode(practname);
	}
	apptdate= checkForNull(request.getParameter("i_appt_date"));
	fromtime=request.getParameter("i_from_time");
	if(fromtime!=null){
		fromtime=fromtime.trim();
	}
	totime=request.getParameter("i_to_time");
	if(totime!=null){
		totime=totime.trim();
	}		
	
	
	Connection conn = null;
	Statement stmt_visit_type=null;
	Statement stmt_service=null;	
	ResultSet rs1=null;	
	ResultSet rsas=null;
	ResultSet rs_service=null;
	ResultSet rs =null;	
	ResultSet obc=null;
	PreparedStatement pstmt =null;	
	Statement stmtt=null;
	ResultSet rst=null;
	String visit_limit_rule		= "";
	int max_other_visits		= 0;
	int total_other_visits		= 0;
	int max_first_visits		= 0;
	int total_first_visit		= 0;
	
	
	if(clinic_type.equals("C")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}
	String res_class_desc="";
	int visit_type_cnt=0;
	
	if(res_type.equals("P")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
	
		
	try{
		conn = ConnectionManager.getConnection(request);
		locale = (String)session.getAttribute("LOCALE");
					

            _bw.write(_wl_block9Bytes, _wl_block9);

java.lang.StringBuffer strbfr_sql1=new java.lang.StringBuffer();
if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}	
if(rs1 !=null)rs1.close();

if(res_type.equals("P")){
	sql5  = "select pract_type res_type,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1')practname from am_practitioner where practitioner_id= ? and practitioner_id is not null" ;
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
}else if(res_type.equals("R")){
	sql5  = "select room_type res_type,AM_GET_DESC.AM_FACILITY_ROOM(OPERATING_FACILITY_ID, room_num,?,'1')practname from am_facility_room where room_num =? and OPERATING_FACILITY_ID=? and room_num is not null";
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
	pstmt.setString(3,facilityid);
}else{
	sql5  = "select resource_type res_type,AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'1')practname from am_resource where resource_id = ? and facility_id= ? and resource_Class=? and resource_id is not null" ;
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
	pstmt.setString(3,facilityid);
	pstmt.setString(4,res_type);
}
rs1=pstmt.executeQuery();
if(rs1!=null && rs1.next()){
	Resource_type = rs1.getString("res_type") ;
	practname = rs1.getString("practname") ;
}
if(pstmt!=null)	pstmt.close();
if(rs1 !=null)rs1.close();	
pstmt=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') dttm,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual");
rs1=pstmt.executeQuery();
if(rs1!=null && rs1.next()){
sydate_time=rs1.getString("dttm");
sys_date_time=rs1.getString("sys_date_time");
}
if(pstmt!=null)	pstmt.close();
if(rs1 !=null)rs1.close();	
	
		pstmt=conn.prepareStatement("select speciality_code,service_code, allow_referral_yn, allow_non_referral_yn,age_group_code,long_desc  from op_clinic_lang_vw  where facility_id=?  and clinic_code =? and language_id=?");
		pstmt.setString(1,facilityid);
		pstmt.setString(2,cliniccode);
		pstmt.setString(3,locale);
		rsas=pstmt.executeQuery();
		if(rsas!=null && rsas.next()){
			clinicname=rsas.getString("long_desc");
			service_code=rsas.getString("service_code");
			allow_referral_yn = rsas.getString("allow_referral_yn");
			allow_non_referral_yn = rsas.getString("allow_non_referral_yn");
			spec_code=rsas.getString("SPECIALITY_CODE");
			age_group_code=rsas.getString("age_group_code");
			if(age_group_code==null) age_group_code="";
		}
		if(pstmt!=null){
			pstmt.close();
		}
			if(apptdate!=null && !(apptdate.equals(""))){
			stmtt=conn.createStatement();
			sql_srl_no.setLength(0);		
			
			//sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
			sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no,visit_limit_rule,NVL (total_first_visit_slots_booked, 0) total_first_visit_slots_booked,NVL (max_slots_for_first_visit, 0) max_slots_for_first_visit,NVL (total_first_visit, 0) total_first_visit,NVL (max_other_visits, 0) max_other_visits,  NVL (total_follow_up, 0)+ NVL (total_routine, 0)+ NVL (total_series, 0)+ NVL (total_consult, 0)+ NVL (total_emergency, 0) total_other_visits,NVL (max_first_visits, 0) max_first_visits from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
			if(practid.equals("")){
				sql_srl_no.append(" and practitioner_id is null");
			}else{
				sql_srl_no.append(" and practitioner_id = '"+practid+"'");
			}
			rst=stmtt.executeQuery(sql_srl_no.toString());
			System.err.println("sql_srl_no.toString()=====>"+sql_srl_no.toString());
			sql_srl_no.setLength(0);
			if(rst != null && rst.next()){
				starttime=rst.getString("start_time");
				endtime=rst.getString("end_time");
				srl_no=rst.getString("srl_no");
				visit_limit_rule	= (rst.getString("visit_limit_rule")==null || rst.getString("visit_limit_rule").equals(""))?"N":rst.getString("visit_limit_rule");
				max_other_visits	= rst.getInt("max_other_visits");
				total_other_visits	= rst.getInt("total_other_visits");
				max_first_visits	= rst.getInt("max_first_visits");
				total_first_visit	= rst.getInt("total_first_visit");
			 /*
			   String sqlquery="select substr(to_date('"+apptdate+" "+totime+"','dd/mm/yyyy HH24:mi')- sysdate,0,1) diff, to_char(sysdate,'dd/mm/yyyy') toDate , to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual";
			   System.err.println("sqlquery==>"+sqlquery);
			
				obc =stmtt.executeQuery(sqlquery);
				  if(obc!=null && obc.next()){
					obtm=obc.getString("diff");
					currentDate=obc.getString("toDate");
					sys_date_time=obc.getString("sys_date_time");
				}
				*/
			}
		}

		
		//book appointment
		
		
		
		
	
	
	
            _bw.write(_wl_block10Bytes, _wl_block10);

			String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinicname));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinicname));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);


			stmt_service=conn.createStatement();
			int serviceCount = 0;
			String service_sql="select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status='E' and service_code in(select service_code from op_clinic where clinic_code ='"+cliniccode+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+cliniccode+"' AND b.facility_id='"+facilityid+"')";
			rs_service=stmt_service.executeQuery(service_sql);
			while(rs_service!=null && rs_service.next()){
				serviceCount++;
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs_service.getString("service_code")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs_service.getString("short_desc")));
            _bw.write(_wl_block26Bytes, _wl_block26);
}		 
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(serviceCount));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			
			
			String max_appt_slots="";
			stmt_visit_type=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");
			
			//strbfr_sql1.append("SELECT short_desc, a.visit_type_code, a.visit_type_ind,NVL (b.max_appt_slots, 1) max_appt_slots,NVL (b.max_appt_duration, 1) max_appt_dur FROM op_visit_type_lang_vw a, op_visit_type_for_clinic b WHERE a.visit_type_code = '"+visit_type_ind+"' AND a.visit_type_code = b.visit_type_code AND a.facility_id = b.facility_id AND a.facility_id = '"+facilityid+"' AND b.clinic_code = '"+cliniccode+"' AND a.language_id = '"+locale+"'");
			System.out.println("strbfr_sql1.toString()==>"+strbfr_sql1.toString());
			rs1=stmt_visit_type.executeQuery(strbfr_sql1.toString());
			rs1.last();
			visit_type_cnt = rs1.getRow();
			rs1.beforeFirst();
			strbfr_sql1.setLength(0)	;
			
			if(visit_type_cnt > 1)
			{
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
			while(rs1!=null && rs1.next()){
			visitcode=rs1.getString("visit_type_code");
			visitdesc=rs1.getString("short_desc");
			visitind=rs1.getString("visit_type_ind");
			max_appt_slots=rs1.getString("max_appt_slots");
			if (max_appt_slots==null) max_appt_slots="";
			int max_dur = rs1.getInt("max_appt_dur");
			if(visit_type_cnt<1)
			{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(visitcode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visitcode+"~"+visitind));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(max_dur));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else { 
			
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(visitcode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visitcode+"~"+visitind));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(max_dur));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
			visit_ind_count++;
			}
			if(rs1 !=null)rs1.close();
				
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sydate_time));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

			
	       
			
    		if(rs1!=null) rs1.close();
    		
    		if(rsas!=null) rsas.close();
    		
			
			
			if(stmt_visit_type !=null) stmt_visit_type.close();
			if(stmt_service !=null) stmt_service.close();

			if(pstmt!=null){
				pstmt.close();
			}


	

///// ---
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i_patient_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(max_patients_per_slab));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(total_other_visits));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(total_first_visit));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block93Bytes, _wl_block93);
            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiurgent.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupName.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivingDateTime.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mode.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telephone.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fax.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InPerson.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Web.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
}

package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __cancelvisitframe2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CancelVisitFrame2.jsp", 1742273379350L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--  Function Name Cancel Visit\n  Created by M.Sathis Kumar on 28/02/2000 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n  <head>\n     <meta http-equiv=\"Expires\" content=\"0\"> \n  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n     <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n     <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>    \n     <Script src=\"../../eOP/js/CancelVisit.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n   \n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n  </head>\n  <body class=\'content\' onMouseDown=\"CodeArrest();\"onload=\"Focusing(\'cancel_case_yn\')\" topmargin=\'0\' bottommargin=\'0\' onKeyDown =\'lockKey()\' >\n    <form name=\"CancelVisitFrame2\" id=\"CancelVisitFrame2\" method=\'post\' action=\'../../servlet/eOP.CancelVisitServlet\' target=\"messageFrame\">\n      <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>       \n        <tr>\n          <th class=\'columnheader\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>          \n        </tr>\n\t  </table>  \n\t  <table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n\t\t<tr>\n          <td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n          <td class=\'querydata\' width=\'60%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n          </td>        \n        </tr>        \n        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n        <tr><!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->\n          <td class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n          <td class=\'querydata\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t  <!-- CRF end SS-CRF-0010 [IN034516] -->\n\t\t   </tr>\n        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n        <tr>\n          <td class=\'label\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>        \n          <td class=\'fields\'><input type=\"checkbox\" name=\"appt_case_yn_disp\" id=\"appt_case_yn_disp\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" disabled>\n          </td>\n        </tr>\n        <tr>\n          <td class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n          </td>\n        </tr> \n        <tr>\n          <td class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="            \n          </td>\n        </tr>        \n     <!--   <tr>\n          <td   class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n          <td  class=\'data\' colspan=3>\n            <input type=\"checkbox\" name=\"new_op_episode_yn\" id=\"new_op_episode_yn\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" disabled>\n          </td>\n\t\t</tr>\n\t\t\t<tr>\n          <td   class=\"label\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n          <td  align=\"left\" class=\'data\' colspan=3><b>          \n            ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b>\n          </td>\n        </tr> -->         \n      \n   ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  \n \n\t\t</table>  \n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n        <tr>\n          <td class=\'columnheader\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>    \n        </tr>\n\t\t</table>  \n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n        <tr><td class=\'querydata\' colspan=\'2\'>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n        </tr>    \n        <tr>\n            <td class=label width=\'40%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\t\n            <td class=\'fields\' width=\'60%\'><input type=checkbox name=delink_referral id=delink_referral value=C  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ></td>\t\t\t\t\n        </tr>\t\n         \n    \n\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n        </table>  \n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>       \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>          \n\t\t\t\t</tr>\n\t\t     </table> \n\t\t\t <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'97%\' align=\'center\'>       \n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t  \n\t\t\t\t\t  \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t  <td class=\'querydata\' width=\'60%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>   \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t   <td class=\'querydata\' width=\'60%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t  <td class=\'querydata\' width=\'60%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>        \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>        \n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n        <tr>\n          <th class=\'columnheader\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</th>\n        </tr>\n\t\t</table>  \n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n        <tr>\n\t\t  <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n          <td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>        \n          <td class=\'fields\' width=\'60%\'><input type=\"checkbox\" name=\"cancel_case_yn\" id=\"cancel_case_yn\" value=\"Y\"  checked  onClick=\"cancel_reason_code.disabled=!this.checked;cancel_reason_code.value=\'\';reason.value=\'\'; displayRemarksForOtherReason(cancel_reason_code);\"  >\n          </td>\n        </tr>\n\n    <tr>\n\t\t   <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n           <td class= \'label\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n           <td class=\'fields\'><select name=\'cancel_reason_code\' id=\'cancel_reason_code\' onChange=\"javascript:(this.value!=\'\')?reason.value=this.options[selectedIndex].text:reason.value=\'\'; displayRemarksForOtherReason(cancel_reason_code);\" ><option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" --------&nbsp;</option>\n ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="          \n            </select>\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n           </td>\n    </tr>  \n\t\n\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t<tr>\n\t\t<td class=label id=\'remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<td class=\"fields\" id=\'remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\"></textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'remarks_img\' style=\'visibility:hidden\'></td>\n\t</tr>\n\t<!--End ML-MMOH-CRF-1114-->\n\n      </table>\n\t  <input type=\'hidden\' name=\'module_id\' id=\'module_id\' value = \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'> \n      <input type=\'hidden\' name=\'reason\' id=\'reason\' value = \'\'>    \n\t  <input type=\'hidden\' name=\'query_string\' id=\'query_string\' value = \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>    \n\n\t  <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n      <input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>      \n      <input type=\'hidden\' name=\'funct_name\' id=\'funct_name\' value=\'modify\'>\n      <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >      \n      <input type=\'hidden\' name=\'appt_case_yn\' id=\'appt_case_yn\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>            \n      <input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>                  \n      <input type=\'hidden\' name=\'subservice_code\' id=\'subservice_code\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>                  \n                    \n      <input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>                  \n      <input type=\'hidden\' name=\'assign_care_locn_type\' id=\'assign_care_locn_type\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n      <input type=\'hidden\' name=\'assign_care_locn_code\' id=\'assign_care_locn_code\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>      \n      <input type=\'hidden\' name=\'visit_adm_type\' id=\'visit_adm_type\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n     \n      <input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n      <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n      <input type=\'hidden\' name=\'op_episode_visit_num\' id=\'op_episode_visit_num\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n      <input type=\'hidden\' name=\'visit_type_ind\' id=\'visit_type_ind\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>   \n      <input type=\'hidden\' name=\'count1\' id=\'count1\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n      <input type=\'hidden\' name=\'appointment_no\' id=\'appointment_no\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t  <input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'CANCEL_VISIT\'>\n\t  <input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t  <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t  <input type=\'hidden\' name=\'others_id\' id=\'others_id\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n      \n    ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n    <input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<input type=\'hidden\' name=\'arrive_data_time\' id=\'arrive_data_time\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t<input type=\'hidden\' name=\'vital_signs_date_time\' id=\'vital_signs_date_time\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t<input type=\'hidden\' name=\'queue_num\' id=\'queue_num\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t <input type=\'hidden\' name=\'qms_interfaced_yn\' id=\'qms_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t <input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n  </form>   \n  </body>\n</html>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
   
	 request.setCharacterEncoding("UTF-8");
	 String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

      Connection con    = null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  //Statement stmt_ref=null;
      //Statement stmt_bl_yn = null;
      //ResultSet rset_bl_yn =null;

	  try{
      con    = ConnectionManager.getConnection(request);
      String facility_id      = (String) session.getValue("facility_id");   
	  
      String encounter_id     = request.getParameter("encounter_id");
      //String queue_date       = request.getParameter("queue_date");  
	  String locale = (String)session.getValue("LOCALE");
      String module_id        = request.getParameter("module_id");
      String bl_interfaced_yn        = request.getParameter("bl_interfaced_yn")==null?"":request.getParameter("bl_interfaced_yn");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
      String room_desc="";
	  /*CRF end SS-CRF-0010 [IN034516]*/

	  /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		String others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
	  
     // String queueStatus        = request.getParameter("queueStatus");
	   String function_name        = request.getParameter("function_name")==null?"":request.getParameter("function_name");
	   String qms_interfaced_yn="N";
	   String multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-198
	  if((module_id==null) || (module_id.equals("null")) || (module_id=="") || (module_id.equals(""))) module_id		= "OP"; 
	 
	    String referral_id="";
        String referral_details="";
        String status="";
		String status_enabled="";
		String episode_type = "";
		String arrive_data_time="";
		String vital_signs_date_time="";
		String queue_num="";
		String ref_dtl_line = "";
        
        //stmt_ref=con.createStatement();
		//stmt_bl_yn=con.createStatement();
      
 //     String bl_interfaced_yn="";
      int count1 = 0;
      
      //String policy_type_code="";
      //String cust_code="";

      String patient_id           = "";
      String appt_case_yn         = "";
      String visit_adm_type       = "";
      String visit_type_desc      = "";
      String visit_type_ind       = "";
    
      String episode_id           = "";
      String op_episode_visit_num = "";
      String new_op_episode_yn    = "";      
      
      String assign_care_locn_code  = "";
      String assign_care_locn_type  = "";
      String attend_practitioner_id = "";
      String service_code           = "";
      String service_short_desc     = "";      
      String subservice_code        = "";
      String subservice_short_desc  = "";            
      String new_op_episode_yn_property = "";
      String appt_case_yn_property      = "";      
      
      String queue_status           = "";
      String queue_date_time        = ""; 
	  String queue_date_time_display = "";
	  String appointment_no        = ""; 
	  String room_num="";
	  String treatment_area_desc="";
	  String ae_bed_no="";
	  String priority_zone="";
	 /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	  String sql              ="";
	  String color            ="";
	  String green            ="";
	  String red              ="";
      String yellow           ="";
      String unassigned       ="";
 	/* CRF  SKR-CRF-0021 [IN028173] end  */
	  
	  StringBuffer sqlPrEnc = new StringBuffer();
	  
    try{   
    
      /*sqlPrEnc.append("select   encounter.patient_id,encounter.referral_id referral_id, nvl(encounter.appt_case_yn,'W') appt_case_yn, ");
        sqlPrEnc.append("encounter.Visit_adm_type, visit_type.visit_type_ind, visit_type.short_desc visit_type_desc,  ");
        sqlPrEnc.append("decode(visit_type_ind,'F','First','L','Follow-up','R','Routine','E', ");
        sqlPrEnc.append("'Emergency','S','Series','C','Referral for Consult') visit_type_ind_desc, ");
        sqlPrEnc.append("episode_id,op_episode_visit_num, new_op_episode_yn, ");
        sqlPrEnc.append("encounter.assign_care_locn_type, encounter.assign_care_locn_code, ");
        sqlPrEnc.append("encounter.attend_practitioner_id,  ");
        sqlPrEnc.append("service.service_code, service.service_short_desc service_short_desc, "); 
        sqlPrEnc.append("subservice.subservice_code, subservice.subservice_short_desc subservice_short_desc ,  ");
        sqlPrEnc.append("patient_type.short_desc patient_type_short_desc ,encounter.assign_room_num " );
        sqlPrEnc.append("from pr_encounter encounter, op_visit_type visit_type, ");
        sqlPrEnc.append("am_facility_service_vw service, am_facility_subsrvc_vw subservice, ");
        sqlPrEnc.append("am_patient_type patient_type ");
        sqlPrEnc.append("where  visit_type.visit_type_code    = encounter.visit_adm_type ");
        sqlPrEnc.append("and    visit_type.facility_id        = encounter.facility_id ");
        sqlPrEnc.append("and    encounter.encounter_id        = '"+encounter_id+"' ");
        sqlPrEnc.append("and    encounter.facility_id         = '"+facility_id+"' ");
        sqlPrEnc.append("and    service.service_code(+)       = encounter.service_code ");
        sqlPrEnc.append("and    service.operating_facility_id(+)        = encounter.facility_id ");
        sqlPrEnc.append("and    subservice.service_code(+)    = encounter.service_code ");
        sqlPrEnc.append( "and    subservice.subservice_code(+) = encounter.subservice_code ");
        sqlPrEnc.append("and    subservice.operating_facility_id(+)     = encounter.facility_id ");
        sqlPrEnc.append("and    patient_type.patient_type(+)  = encounter.patient_type");*/

		/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		sqlPrEnc.append("SELECT encounter.patient_id, encounter.referral_id referral_id, NVL(encounter.appt_case_yn,'W') appt_case_yn, encounter.Visit_adm_type, encounter.VISIT_ADM_TYPE_IND visit_type_ind, op_get_desc.OP_VISIT_TYPE(facility_id,encounter.visit_adm_type,'"+locale+"',2) visit_type_desc, encounter.VISIT_ADM_TYPE_IND visit_type_ind_desc, episode_id, op_episode_visit_num, new_op_episode_yn, encounter.assign_care_locn_type, encounter.assign_care_locn_code, encounter.attend_practitioner_id, encounter.service_code, am_get_desc.am_service(encounter.service_code,'"+locale+"',2) service_short_desc, encounter.subservice_code, am_get_desc.am_subservice(encounter.service_code,encounter.subservice_code,'"+locale+"',2) subservice_short_desc  ,am_get_desc.AM_PATIENT_TYPE(encounter.patient_type,'"+locale+"',2)patient_type_short_desc, encounter.assign_room_num,  am_get_desc.am_facility_room (encounter.facility_id, encounter.assign_room_num, '"+locale+"', 2) room_desc,(select multi_speciality_yn from op_clinic where CLINIC_CODE=encounter.assign_care_locn_code and FACILITY_ID='"+facility_id+"') multi_speciality_yn FROM pr_encounter encounter WHERE encounter.encounter_id = '"+encounter_id+"' AND encounter.facility_id = '"+facility_id+"'"); 	
       /*CRF end SS-CRF-0010 [IN034516]*/		
		
		pstmt =con.prepareStatement(sqlPrEnc.toString());
		rs = pstmt.executeQuery();
      
	 	  
	  if (rs!= null)
      {
        while(rs.next())
        {
          patient_id           = rs.getString("patient_id");
          appt_case_yn         = rs.getString("appt_case_yn");
		 
          visit_adm_type       = rs.getString("visit_type_ind");
          visit_type_desc      = rs.getString("visit_type_desc");
          visit_type_ind       = rs.getString("visit_type_ind_desc");
		  if(visit_type_ind.equals("F"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		  else if(visit_type_ind.equals("L"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		  else if(visit_type_ind.equals("R"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		  else if(visit_type_ind.equals("E"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		  else if(visit_type_ind.equals("S"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		  else if(visit_type_ind.equals("C"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		  else if(visit_type_ind == null)
			  visit_type_ind=""; 
		  
		  op_episode_visit_num = rs.getString("op_episode_visit_num");
          new_op_episode_yn    = rs.getString("new_op_episode_yn");
		  if( new_op_episode_yn==null || new_op_episode_yn.equals("null"))
			  new_op_episode_yn="";
		  

          assign_care_locn_code  = rs.getString("assign_care_locn_code");
          assign_care_locn_type  = rs.getString("assign_care_locn_type");
          attend_practitioner_id = rs.getString("attend_practitioner_id");
          if(attend_practitioner_id==null)
              attend_practitioner_id="";
          service_code           = rs.getString("service_code");
          service_short_desc     = rs.getString("service_short_desc");
		  subservice_code        = rs.getString("subservice_code");
          subservice_short_desc  = rs.getString("subservice_short_desc");
          
          //added by shubha
          episode_id        = rs.getString("episode_id");
          //added by smitha
          room_num = rs.getString("assign_room_num");
	      /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		  room_desc=rs.getString("room_desc")== null?"":rs.getString("room_desc");/*Modified by Suresh M Against IN057475 on 14th Sept 2015*/
		  /*CRF end SS-CRF-0010 [IN034516]*/
		  referral_id = rs.getString("referral_id") == null?"":rs.getString("referral_id");
		  multi_speciality_yn = rs.getString("multi_speciality_yn") == null?"N":rs.getString("multi_speciality_yn");//Added for the crf - Bru-HIMS-CRF 198

        }
      }
    qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(assign_care_locn_code,facility_id,con);
	if(qms_interfaced_yn==null || qms_interfaced_yn.equals("")){
	qms_interfaced_yn="N";
	}
	 if(rs != null )rs.close();
	 if(pstmt !=null )pstmt.close();
 
     sqlPrEnc.setLength(0);

    }catch(Exception e) { 
		
		e.printStackTrace();}
       
	sqlPrEnc.setLength(0);

	StringBuffer sqlOPPatQ = new StringBuffer();

	try{
			/*sqlOPPatQ.append("select decode(Queue_Status,'01','Checked In','02',");
			sqlOPPatQ.append("'Arrived At Nursing Station','03', 'Initial Check-Up/Vital Signs Recorded',");
			sqlOPPatQ.append("'04','Consultation Progress','05', 'Undergoing Treatment/Investigation',");
			sqlOPPatQ.append("'06','Returned from investigation') queue_status,");
			sqlOPPatQ.append( "to_char (decode(queue_Status,'01',check_in_date_time,'02',arrive_date_time,");
			sqlOPPatQ.append("'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',null,");
			sqlOPPatQ.append("'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME ");
			sqlOPPatQ.append("from   op_patient_queue where patient_id = '"+patient_id+"' ");
			sqlOPPatQ.append("and  facility_id ='"+facility_id+"' and trunc(queue_date) = to_date('"+queue_date+"','dd/mm/yyyy') ");
			sqlOPPatQ.append("and    locn_type   ='"+assign_care_locn_type+"' ");
			sqlOPPatQ.append("and  locn_code   ='"+assign_care_locn_code+"' ");
			sqlOPPatQ.append("and  practitioner_id = nvl('"+attend_practitioner_id+"','*ALL') ");
			sqlOPPatQ.append("and    queue_shift='*ALL' and encounter_id = "+encounter_id);*/

			if (module_id.equals("AE"))
			{
				episode_type ="E";

				sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME, PRIORITY_ZONE, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(FACILITY_ID,LOCN_CODE,treatment_area_code,'"+locale+"' ,'2') treatment_area_desc,AE_BED_NO,(select BILLING_INTERFACED_YN from ae_param where operating_facility_id='"+facility_id+"') bl_interfaced_yn ");

				if(!referral_id.equals("")) {
					sqlOPPatQ.append(" , GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') ref_dtl_line ");
				}
				
				sqlOPPatQ.append(" FROM ae_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'");
			} else {

				episode_type ="O";

				sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME,queue_num "); 

				if(!referral_id.equals("")) {
					sqlOPPatQ.append(" , GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') ref_dtl_line ");
				}
				
				sqlOPPatQ.append(" FROM op_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 
			}

			//sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id   ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME FROM op_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 

			//sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time,   ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME FROM ae_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 
		  
		  pstmt =con.prepareStatement(sqlOPPatQ.toString());
		  rs = pstmt.executeQuery();
          if (rs!= null && rs.next())
          {
			  queue_status    = rs.getString(1);
			 
			  if(queue_status.equals("01"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
			  else if(queue_status.equals("02"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
			  else if(queue_status.equals("03"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
			  else if(queue_status.equals("04"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
			  else if(queue_status.equals("05"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
			  else if(queue_status.equals("06"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");

			  if (module_id.equals("AE")) {
				  queue_date_time = rs.getString(2);
				  arrive_data_time= rs.getString("ARRIVE_DATE_TIME");
				  vital_signs_date_time=rs.getString("VITAL_SIGNS_DATE_TIME");
				  treatment_area_desc=rs.getString("treatment_area_desc");
				  if(treatment_area_desc == null) treatment_area_desc = "";
				  ae_bed_no=rs.getString("ae_bed_no");
				   if(ae_bed_no == null) ae_bed_no = "";
				  priority_zone=rs.getString("priority_zone");
				  bl_interfaced_yn=rs.getString("bl_interfaced_yn");
				   if(bl_interfaced_yn == null) bl_interfaced_yn = "";

			  } else {
				  queue_date_time = rs.getString(2);
				  appointment_no  = rs.getString(3);
				  arrive_data_time= rs.getString("ARRIVE_DATE_TIME");
				  vital_signs_date_time=rs.getString("VITAL_SIGNS_DATE_TIME");
				  queue_num=rs.getString("queue_num");
			  }

			  if(!referral_id.equals("")) {
				ref_dtl_line = rs.getString("ref_dtl_line") == null?"":rs.getString("ref_dtl_line");
				String check = ref_dtl_line.substring(0,13);
                        
				if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND")) {
					referral_details = "";
				} else {
                    status = ref_dtl_line.substring(0,1);
                    referral_details = ref_dtl_line.substring(2,ref_dtl_line.length());
                }
			  }
		  }

		  if(rs != null   )rs.close();
	      if(pstmt !=null )pstmt.close();

		  sqlOPPatQ.setLength(0);

		  queue_date_time_display = DateUtils.convertDate(queue_date_time,"DMYHM","en",locale);

    }catch(Exception e) {
		e.printStackTrace();}
   
	//if(referral_id == null) referral_id="";
	// out.println("refer"+referral_id);

		/*
		if(!referral_id.equals(""))
        {
          
		      
			String from="FROM";
            String sql1 = "select  GET_REFERRAL_DETAIL_LINE('"+referral_id+"', '"+from+"','"+locale+"') from dual    " ;  
            String check="";
			ResultSet csrs=stmt_ref.executeQuery(sql1) ;
                if(csrs!=null)
                {
                    while(csrs.next())
                    {
                        check=csrs.getString(1).substring(0,13);
                        //out.println(check);
						if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND"))
                        referral_details="";
                        else
                        {
                            status=csrs.getString(1).substring(0,1);
                            referral_details=csrs.getString(1).substring(2,csrs.getString(1).length());
                        }
                    }
                }

				//out.println(referral_details);
				if(csrs != null) csrs.close();
				if(stmt_ref != null) stmt_ref.close();

		}
		*/
		
	// The following conditions were added by Smita Unnikrishnan on 21-04-04  as the Delink referral checkbox had to be disabled if the Patient was an appointment case
	if(!appt_case_yn.equals("A"))
		  {
	 if(status.equals("C")){ status_enabled="";}
    else if(status.equals("O")) {status_enabled="disabled";}
		  }
		  else
		  {
			status_enabled="disabled";
		  }
	
      if (new_op_episode_yn.equals("Y"))
         new_op_episode_yn_property = " checked ";
              
      if (appt_case_yn.equals("A"))
         appt_case_yn_property = " checked ";
         
      if (service_short_desc == null)
            service_short_desc = "";

      if (subservice_short_desc == null)
            subservice_short_desc = "";
        
      if(appointment_no == null || appointment_no.equals("null"))  appointment_no = "";	
/*
    try
    {

	
		String sql_bl ="";
		if (module_id.equals("AE"))
        {
            sql_bl="select BILLING_INTERFACED_YN from ae_param where operating_facility_id='"+facility_id+"'  ";
	       
			rset_bl_yn = stmt_bl_yn.executeQuery(sql_bl);
            if(rset_bl_yn!=null )
            {
              while(rset_bl_yn.next())
                {
                    bl_interfaced_yn=rset_bl_yn.getString("BILLING_INTERFACED_YN");
                }
            }
		}	   
	   if (rset_bl_yn != null) rset_bl_yn.close();
	 // if(bl_interfaced_yn.equals("Y"))
      //{
         	 // String sql = "";
			 // if (module_id.equals("AE"))
             // {
			
           //     sql="select count(*) count1 from bl_patient_charges_folio where (module_id != 'AE'  and episode_id='"+episode_id+"' and visit_id='"+op_episode_visit_num+"' and nvl(trx_status,'A')!='C') or(module_id!='AE' and episode_id='"+episode_id+"'  and visit_id='"+op_episode_visit_num+"'  and nvl(trx_status,'A')!='C' and nvl(billed_flag,'N')='Y' and nvl(trx_posted_ind,'N') ='Y')";

			//  }else{
    			
				
				//sql="select count(*) count1 from bl_patient_charges_folio where (module_id != 'OP'  and episode_id='"+episode_id+"' and visit_id='"+op_episode_visit_num+"' and nvl(trx_status,'A')!='C') or(module_id!='OP' and episode_id='"+episode_id+"'  and visit_id='"+op_episode_visit_num+"'  and nvl(trx_status,'A')!='C' and nvl(billed_flag,'N')='Y' and nvl(trx_posted_ind,'N') ='Y')";
			
		//	}
			//rset_bl_yn= stmt_bl_yn.executeQuery(sql);
          //  rset_bl_yn.next();
           // count1 = rset_bl_yn.getInt("count1");
			
			//if (rset_bl_yn != null) rset_bl_yn.close();
	// }     

   }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
   */
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(queue_date_time_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

        if(room_num != null)
        {
        
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appt_case_yn_property));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(service_short_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(subservice_short_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(visit_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(new_op_episode_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(new_op_episode_yn_property));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block29Bytes, _wl_block29);

    //out.println("ssss"+referral_details);

         if(!referral_details.equals(""))
          {
       
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(referral_details));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(status_enabled));
            _bw.write(_wl_block34Bytes, _wl_block34);

         }
         
            _bw.write(_wl_block35Bytes, _wl_block35);

			 /*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
						Modified by Suresh M
						Starts
			*/
			 if (module_id.equals("AE")) {
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

					  /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
					  
//					  StringBuffer sb = new StringBuffer();
	                  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				  color      =rs.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")) {red=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")) {yellow=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")) {unassigned=rs.getString("PRIORITY_ZONE_DESC");}
				}
		    
			
		   if(rs != null   )rs.close();
	       if(pstmt !=null )pstmt.close();
					  
            _bw.write(_wl_block39Bytes, _wl_block39);
if(priority_zone.equals("U")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(unassigned));
            _bw.write(_wl_block41Bytes, _wl_block41);
} else if(priority_zone.equals("R")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(red));
            _bw.write(_wl_block38Bytes, _wl_block38);
} else if(priority_zone.equals("Y")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block38Bytes, _wl_block38);
} else if(priority_zone.equals("G")) {
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(green));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
			
/* CRF  SKR-CRF-0021 [IN028173] end  */			
			
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ae_bed_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
 } 
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
               


	    //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where nvl(cancel_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;

		pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason_lang_vw where language_id='"+locale+"' and nvl(cancel_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;
	    rs = pstmt.executeQuery();
	    if( rs != null )
	    {
	      while( rs.next() )
	      {                      
			String Value  = rs.getString(1);
			String Label  = rs.getString(2);
                    	out.println( "<option value='" + Value + "' >" + Label );
              }
                               
         }
			if(rs != null )rs.close();
			if(pstmt !=null )pstmt.close();

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(subservice_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(appointment_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(others_id));
            _bw.write(_wl_block73Bytes, _wl_block73);

		/*
		
	int epid=Integer.parseInt(episode_id.substring(4));
     
    if (op_episode_visit_num==null) op_episode_visit_num ="0";
    if (op_episode_visit_num.length() > 4)
    op_episode_visit_num = op_episode_visit_num.substring(0,3);
    
  if(bl_interfaced_yn.equals("Y"))
  {
    try{
		 
		String bl_fin ="";
        if (module_id.equals("AE"))
        {
		episode_type ="E";
        bl_fin ="select policy_type_code,cust_code from bl_visit_fin_dtls where operating_facility_id='"+facility_id+"' and  episode_id='"+epid+"' and EPISODE_TYPE='E' and PATIENT_ID='"+patient_id+"' and visit_id='"+op_episode_visit_num+"' ";

		}else{
		episode_type ="O";
		bl_fin ="select policy_type_code,cust_code from bl_visit_fin_dtls where  operating_facility_id='"+facility_id+"' and episode_id='"+epid+"' and EPISODE_TYPE='O' and PATIENT_ID='"+patient_id+"' and visit_id='"+op_episode_visit_num+"'";

		}
        rset_bl_yn= stmt_bl_yn.executeQuery(bl_fin);
        if (rset_bl_yn.next())
        { 
            
            policy_type_code=rset_bl_yn.getString("policy_type_code") == null ? "" :rset_bl_yn.getString("policy_type_code");
            cust_code=rset_bl_yn.getString("cust_code")== null ? "" :rset_bl_yn.getString("cust_code");
        }

      if (rset_bl_yn != null) rset_bl_yn.close();
	  if(stmt_bl_yn != null ) stmt_bl_yn.close();
	 
    }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
    
  }
  */
    
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(arrive_data_time));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(vital_signs_date_time));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(qms_interfaced_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);

}catch(Exception e){
		e.printStackTrace();}
    finally{

		try
		{
			//if (rset_bl_yn != null) rset_bl_yn.close();
			if( rs != null) rs.close();
			//if(stmt_bl_yn != null ) stmt_bl_yn.close();
			if(pstmt != null) pstmt.close();

		}catch (Exception e){
			e.printStackTrace();
		}

		if(con!=null) ConnectionManager.returnConnection(con,request);
   }
    

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Appointment.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.NewEpisode.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.EpisodeNoVisitNo.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.DelinkReferral.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}

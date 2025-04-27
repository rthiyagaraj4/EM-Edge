package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyrecordinpatientleave extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addmodifyRecordInpatientLeave.jsp", 1744287803802L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n    \n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\t\n\t<script src=\"../js/RecordInpatientLeave.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\" onLoad=\"imageInvisible();\">\n<form name=\'recordinpatientleave_form\' id=\'recordinpatientleave_form\' action=\'../../servlet/eIP.RecordInpatientLeaveServlet\' method=\'post\' target=\'messageFrame\' > \n<TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<TR>\n\t\t<TD width=\"25%\">&nbsp;</TD>\n\t\t<TD width=\"25%\">&nbsp;</TD>\n\t\t<TD width=\"25%\">&nbsp;</TD>\n\t\t<TD width=\"25%\">&nbsp;</TD>\n\t</TR>\t \n\t<TR>\n\t\t<TD  class=\'label\' id= \"loadChk\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TD><td colspan=\"3\" class=\'fileds\'>\n\t\t\t<select name=\"record_status\" id=\"record_status\" onChange=\"disableAllFields();\">\n\t\t\t<option value=\"01\" selected>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</option>\n\t\t\t<option value=\"02\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n\n\t\t<TR><TD colspan=\"4\"></TD></TR>  \t    \n\t<tr>\n\t\t  <TD   class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\n\t\t  <TD class=\'fileds\'><input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' name=\'practid\' ><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' readOnly=true size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onChange=\"getPractitionerLocal(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' disabled=true value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" ><img id = \"img1\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t  </TD>\n\t\t  <TD  class=\'label\' nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>         \n\t\t  <TD  class=\'querydata\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TD>\n\t</TR>\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<TR><TD colspan=\"4\"></TD></TR>\n\t<TR>\n\t\t<TD   class=\'label\' id= \"loadChk1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TD>     \t  \n\t\t<td class=\'fileds\'><input type=\"checkbox\" name=\"release_bed\" id=\"release_bed\" value=\"Y\" onClick=\"getPseudoBed(this);\" id=\"check1\" ></td>\n\t\t<td class=\'label\'  id= \"loadChk2\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td class=\'fileds\'><input type=\"text\" name=\"pseudo_bed\" id=\"pseudo_bed\" size=8 maxlength=8 readonly onBlur=\"ChangeUpperCase(this);\" id=\"txt1\" onKeyPress=\'return CheckForSpecChars(event)\' ><input id=\"button1\" name=\"pseudo_button\" id=\"pseudo_button\" type=\"button\" class=\"button\" value=\"?\" onclick=\"callBedAvailChart();\"><img id=\"img5\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t</td>\n\t</TR>\n<TR><TD colspan=\"4\"></TD></TR>\n\t\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<TR><TD colspan=\"4\">&nbsp;</TD></TR>\n\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n \n\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' id=\'amend_dtl\'></td>\n\t    </tr>\n\n<TR><TD colspan=\"4\" class=\'label\'></TD></TR>\n \t<TR>\n\t\t<TD  class=\'label\' colspan=\'\' nowrap id=\'date_dtl\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\n\t\t<TD  class=\'fileds\' nowrap > \n\t\t<!-- Below Two Line is commented by Akhilesh for unexpected code of JS Function \'TestDateDiff\'-->\n\t\t<!--<input type =\'text\' name = \'fromdate\' size = \'15\' id=\"fromdate\"  maxlength =\'16\'  onBlur=\'chkFromToTime1(this);TestDateDiff(document.getElementById(\"todate\").value,fromdate.value)\' value =\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\'>-->\n\t\t<input type =\'text\' name = \'fromdate\' size = \'15\' id=\"fromdate\"  maxlength =\'16\'  onBlur=\'chkFromToTime1(this);\' value =\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\'><img name=\'frmdt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'fromdate\').select();return showCalendar(\'fromdate\',null,\'hh:mm\');\"/><img id=\"img2\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</TD> \t  \n\t\t<TD id=\'lbl1\'  class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t<td class=\'fileds\'>\n\t\t\n\n\t\t\t<!--<input type =\'text\'  name = \'todate\' id=\"todate\" size = \'15\' maxlength =\'16\' onBlur=\"chkFromToTime2(this);TestDateDiff(document.getElementById(\"fromdate\").value,todate.value)\" value =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  onKeyPress=\'return(ChkNumberInput1(this,event,2))\'>-->\n\t\t<input type =\'text\'  name = \'todate\' id=\"todate\" size = \'15\' maxlength =\'16\' onBlur=\"chkFromToTime2(this); ValidateFromToDateTime(fromdate,this)\" value =\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  onKeyPress=\'return(ChkNumberInput1(this,event,2))\'><img name=\'prefdt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'todate\').select();return showCalendar(\'todate\',null,\'hh:mm\');\" id=\"imgr\"/>\t\n\t\t<img id=\"img3\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</TD>\n\t</TR>  \n\t<TR><TD colspan=\"4\"></TD></TR>\n\t<TR>\n\t\t<TD  class=\'label\' colspan = \'\' valign = \'center\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</TD>\n\t\t<TD colspan = \'3\' class=\'fileds\'> <textarea style=\"resize:none\" name=\'Remarks\' id=\'Remarks\' rows=\'4\' cols=\'60\' onBlur=\'checkMaxLimit1(this,500)\' onKeyPress = \"\" ></textarea><img id=\"img4\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></TD>\t\n\t </TR>\n\t <!--Reported To <TR> Added by kishore on 4/16/2004-->\n\t <tr>\n\t\t<td id=\'lbl2\' class=\'label\'  nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td colspan=\'3\' class=\'fileds\'><textarea style=\"resize:none\" id=\'txtarea2\' rows=\'4\' cols=\'60\' name=\'reported_to\' disabled onBlur=\'makeValidString(this);checkMaxLimit1(this,200);\'>\n\t\t</textarea></td>\n\t</tr> \n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' id=\'infmd_detl\'></td>\n\t       </tr>\n\n<TR><TD colspan=\"4\"></TD></TR>\n<TR><TD colspan=\"4\" style=\"height:18;\" class=\"LABEL\">\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</td></tr>\n<!--above line added for leave17633 Thursday, December 24, 2009  -->\n<TR>\n\t<td id=\'lastrow\' width=\'100%\' class=\'label\' colspan=\"6\"  nowrap>\n \t</td>\n</TR>\n<TR><TD colspan=\"4\"></TD></TR>\n<TR>\n\t<TD class=\'label\'>&nbsp;</TD>\n\t<TD class=\'label\'>&nbsp;</TD>\n\t<TD class=\'label\'>&nbsp;</TD>\n\t<TD class=\'fileds\'><input type=\"button\" class = \'button\' name =\"confirm\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\'ButVal(this)\'><input type=\"button\" class = \'button\' name =\"clear\"   value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'   onClick=\'ButVal(this)\'><input type=\"button\" class = \'button\' name =\"cancel\"  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  onClick=\'ButVal(this)\'></TD> \t  \t\t\t\t  \t\n</TR>\n<TR><TD colspan=\"4\"></TD></TR>\n<script>\n\tif (parseInt(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\")== 1)\n\t{\n\t\tdocument.getElementById(\"practid\").value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t}\n\n</script>\n</table>\n   \t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t<input type=\'hidden\' name=\'admdate\' id=\'admdate\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t\t<input type=\'hidden\' name =\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\'hidden\' name =\'currdate\' id=\'currdate\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\'hidden\' name=\'encounterid\' id=\'encounterid\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" > \t\n\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" > \n\t\t<input type=\'hidden\' name=\'admndate\' id=\'admndate\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" > \n\t\t<input type=\'hidden\' name=\'overrideyn\' id=\'overrideyn\'value=\'N\' name=\'overrideyn\' > \n\t\t<input type=\'hidden\' name = \'warn_or_error_max_leave\' id= \'warn_or_error_max_leave\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t<input type=\'hidden\' name = \'max_allowed_lv_period\' id= \'max_allowed_lv_period\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \t\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> \t\n\t\t<input type=\"hidden\" name=\"bed_class_code\" id=\"bed_class_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> \t\n\t\t<input type=\"hidden\" name=\"bed_type_code\" id=\"bed_type_code\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"> \t\n\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> \t\n\t\t<input type=\"hidden\" name=\"room_no\" id=\"room_no\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"> \t\n\t\t<input type=\'hidden\' name=\'generate_pseudo_bed\' id=\'generate_pseudo_bed\' value=\'N\' >\n\t\t<input type=\'hidden\' name=\'spl_code\' id=\'spl_code\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t<input type=\'hidden\' name=\'hdnBedNo\' id=\'hdnBedNo\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t<input type=\'hidden\' name=\'hdnPatientId\' id=\'hdnPatientId\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t<input type=\'hidden\' name=\'hdnleave_to_date\' id=\'hdnleave_to_date\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t<input type=\'hidden\' name=\'hdd_peudobed_val\' id=\'hdd_peudobed_val\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'hdd_temp_for_dhck\' id=\'hdd_temp_for_dhck\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'deactivate_pseudoBed\' id=\'deactivate_pseudoBed\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t<input type=\'hidden\' name=\'locale1\' id=\'locale1\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t<input type=\'hidden\' name=\'release_reserve_bed_yn\' id=\'release_reserve_bed_yn\' value=\'N\'>\n\t\t<input type=\'hidden\' name=\'no_of_record\' id=\'no_of_record\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t<!-- 17633 below line added for 17633  on dateThursday, December 24, 2009-->\n\t\t<input type=\'hidden\' name=\'ip_Trn_Date\' id=\'ip_Trn_Date\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t<input type=\'hidden\' name=\'Sdate_converted\' id=\'Sdate_converted\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t<input type=\'hidden\' name=\'leave_to_date_converted\' id=\'leave_to_date_converted\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\'hidden\' name=\'specialtycode\' id=\'specialtycode\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=\'hidden\' name=\'bedno\' id=\'bedno\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\n</form>\n\n<script>\n// Added by Sridhar R on 16 JUNE 2004\n// IF release Bed Chk box is Painted on screen then the Psedo Button will be Disabled initially...\n\n\tif(document.getElementById(\"release_bed\"))\n\t{\n\t\tdocument.getElementById(\"pseudo_button\").disabled\t= true;\n\t\tdocument.getElementById(\"img5\").style.visibility=\"hidden\";\t\n\t}\n</script>\n</BODY>\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n</HTML>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

	// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	String facilityID		= (String)session.getValue("facility_id");
	String spl_code			= "";
	String strPatientId		= checkForNull(request.getParameter("PatientId"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	Connection con 		= null;
	Statement  stmt		= null;
	ResultSet  rs 		= null;
	Statement AbsStmt	= null;
	ResultSet rset 		= null;
	String warn_or_error_max_leave 	= "";
	String ip_Trn_Date="";
	String system_date_time_trn="";

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		
		String encounterID		= checkForNull(request.getParameter("EncounterId"));
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		java.sql.Timestamp dt	= new Timestamp(System.currentTimeMillis()) ;

		String Sdate = dateFormat.format(dt) ;
		String Sdate_converted	= "";
        // commented by  munisekhar for  [IN:048759]
		//if(!(Sdate==null || Sdate.equals("")))
			//Sdate_converted = DateUtils.convertDate(Sdate,"DMYHM","en",locale);
		String adDateval		= "";
		String adm_date_display = "";
		String leave_to_date 	= "";
		String max_leave_period = "";
		String allow_release 	= "";
		String to_date 			= "";
		String nursing_unit		= "";
		String patient_id = "" ;
		String bed_class_code = "" ;
		String bed_type_code = "" ;
		String service_code = "" ;
		String room_num = "" ;
		String practid			= "";
		String NU_relVal		= "";
		String PARAM_relVal		= "";
		String setup_bl_dtls_in_ip_yn   = "";
		String deactivate_pseudoBed		= "";
		String patient_class			= ""; 
		String leave_to_date_converted = "";
		String contact1_name	= "";
		String contact2_name	= "";
		int p_pract_cnt = 0;
		int no_of_record = 0;

/* Commented and merged with below query for PE - 10/05/2010

		StringBuffer RelSql = new StringBuffer();
		RelSql.append(" select deactivate_pseudo_bed_yn, max_allowed_lv_period, allow_release_bed_on_lv, warn_or_error_max_leave, to_char((sysdate+max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod, setup_bl_dtls_in_ip_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time from IP_PARAM where facility_id ='"+facilityID+"' ");
		rs= stmt.executeQuery( RelSql.toString() );
		if(rs.next())
		{
			max_leave_period = rs.getString(1);
			if(max_leave_period == null) max_leave_period = "0";

			allow_release	 = rs.getString(2);	
			if(allow_release == null ) allow_release = "N";		

			warn_or_error_max_leave = rs.getString("warn_or_error_max_leave");
				if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";			

			leave_to_date = checkForNull(rs.getString("def_leave_to_preriod"));
			
			if(!(leave_to_date==null || leave_to_date.equals("")))
				leave_to_date_converted = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

			system_date_time_trn= rs.getString("system_date_time");
			deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
		}
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();

		if (RelSql.length() > 0)	RelSql.delete(0, RelSql.length());
				RelSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				stmt = con.createStatement();
				rs		= stmt.executeQuery(RelSql.toString());

				if ( (rs !=null)&&(rs.next()))
				{
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time_trn= rs.getString("system_date_time");
				}
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (RelSql.length() > 0) RelSql.delete(0, RelSql.length());
*/

		String practitioner_name = "", practitioner_id = "";
		String strBedNo = "";
		String srl_no = "";
		String allow_pseudo_bed_yn ="";
		StringBuffer admDate = new StringBuffer();

		admDate.append("select (select to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"') ip_Trn_Date, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, a.nursing_unit_code, a.specialty_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1 ) practitioner_name, a.ATTEND_PRACTITIONER_ID, a.bed_num bed_no, a.patient_class, b.release_bed_on_leave_yn, b.ALLOW_PSEUDO_BED_YN, (SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE)) no_of_record, c.contact1_name, c.contact2_name, d.deactivate_pseudo_bed_yn, d.allow_release_bed_on_lv, d.warn_or_error_max_leave, to_char((sysdate+d.max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod, d.setup_bl_dtls_in_ip_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time,(SELECT MAX (srl_no + 1) FROM ip_adt_trn WHERE facility_id ='"+facilityID+"' AND encounter_id = '"+encounterID+"') srl_no ,a.patient_id, a.bed_class_code, a.bed_type_code,a.service_code,a.room_num,d.max_allowed_lv_period max_leave_period from ip_open_encounter a, ip_nursing_unit b, mp_pat_rel_contacts c, ip_param d where a.encounter_id='"+encounterID+"' and a.facility_id = '"+facilityID+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.patient_id = c.patient_id and a.facility_id = d.facility_id ");
		stmt = con.createStatement();
	
		rs = stmt.executeQuery(admDate.toString());

		if(rs != null)
		{
			if(rs.next())
			{
				
				room_num			= checkForNull(rs.getString("room_num"));
				ip_Trn_Date			= checkForNull(rs.getString("ip_trn_date"));
				service_code			= checkForNull(rs.getString("service_code"));
				bed_type_code			= checkForNull(rs.getString("bed_type_code"));
				bed_class_code			= checkForNull(rs.getString("bed_class_code"));
				patient_id			= checkForNull(rs.getString("patient_id"));
		        adDateval			= checkForNull(rs.getString("ADMISSION_DATE_TIME"));
				nursing_unit		= checkForNull(rs.getString("NURSING_UNIT_CODE"));
				practitioner_id		= checkForNull(rs.getString("ATTEND_PRACTITIONER_ID"));
				practitioner_name	= checkForNull(rs.getString("PRACTITIONER_NAME"));
				spl_code			= checkForNull(rs.getString("SPECIALTY_CODE"));
				strBedNo			= checkForNull(rs.getString("BED_NO"));
				patient_class       = checkForNull(rs.getString("patient_class"));
		        NU_relVal			= checkForNull(rs.getString("release_bed_on_leave_yn"));
		        PARAM_relVal			= checkForNull(rs.getString("allow_release_bed_on_lv"));
				allow_pseudo_bed_yn = rs.getString("allow_pseudo_bed_yn");
			    if(allow_pseudo_bed_yn == null || allow_pseudo_bed_yn.equals("N"))
				  allow_pseudo_bed_yn="N";
				no_of_record		= rs.getInt("no_of_record");
				contact1_name		= checkForNull(rs.getString("contact1_name"));
				contact2_name		= checkForNull(rs.getString("contact2_name"));
				max_leave_period	= rs.getString("max_leave_period");
				if(max_leave_period == null) max_leave_period = "0";

				allow_release	 = rs.getString(2);	
				if(allow_release == null ) allow_release = "N";		

				warn_or_error_max_leave = rs.getString("warn_or_error_max_leave");
					if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";			

				leave_to_date = checkForNull(rs.getString("def_leave_to_preriod"));
				
				if(!(leave_to_date==null || leave_to_date.equals("")))
					leave_to_date_converted = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

				system_date_time_trn= rs.getString("system_date_time");
				// code added by  munisekhar for  [IN:048759]
			    if(!(system_date_time_trn==null || system_date_time_trn.equals("")))
			    Sdate_converted=DateUtils.convertDate(system_date_time_trn,"DMYHM","en",locale);
				deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
				srl_no= checkForNull(rs.getString("srl_no"));
			}		
		}
		
		if(!(adDateval==null || adDateval.equals("")))
			adm_date_display = DateUtils.convertDate(adDateval,"DMYHM","en",locale);
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();

		if (admDate.length() > 0) admDate.delete(0, admDate.length());
		

		/*
		Commented the below queries and merged with above query for PE - 10/05/2010

		String allow_pseudo_bed_yn ="";
		StringBuffer RelBedSql = new StringBuffer();
		RelBedSql.append(" select a.deactivate_pseudo_bed_yn, b.release_bed_on_leave_yn, a.allow_release_bed_on_lv,b.ALLOW_PSEUDO_BED_YN from IP_PARAM a, IP_NURSING_UNIT b where a.facility_id = '"+facilityID+"' and a.facility_id = b.facility_id and b.nursing_unit_code='"+nursing_unit+"' ");
		stmt = con.createStatement();    
		rs = stmt.executeQuery(RelBedSql.toString());
		if(rs != null)
		{
			while(rs.next())
			{
		        deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
		        NU_relVal			= checkForNull(rs.getString("release_bed_on_leave_yn"));
		        PARAM_relVal		= checkForNull(rs.getString("allow_release_bed_on_lv"));
				allow_pseudo_bed_yn = rs.getString("allow_pseudo_bed_yn");
			     if(allow_pseudo_bed_yn == null || allow_pseudo_bed_yn.equals("N")) 
				  allow_pseudo_bed_yn="N";

			}		
		}
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (RelBedSql.length() > 0)
				RelBedSql.delete(0, RelBedSql.length());
		
		
		StringBuffer reserve_Bed_Sql = new StringBuffer();
		try
		{
			reserve_Bed_Sql.append(" SELECT Count(*)  no_of_record FROM  IP_RESERVED_BED_DTL WHERE facility_id='"+facilityID+"' AND encounter_id='"+encounterID+"'    AND  RESERVED_TO_TIME IS NULL ");

			stmt = con.createStatement();    
			rs = stmt.executeQuery(reserve_Bed_Sql.toString());

				if(rs != null && rs.next())
				{
					no_of_record= rs.getInt("no_of_record");
				}
		}
		catch(Exception e)
		{
			//out.println("Exception in getting reserve bed sql:"+e.toString());
			e.printStackTrace();
		}	
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (reserve_Bed_Sql.length() > 0)
				reserve_Bed_Sql.delete(0, reserve_Bed_Sql.length());
		

		StringBuffer mp_pat_rel_contacts = new StringBuffer();
		try
		{
			mp_pat_rel_contacts.append(" select contact1_name,contact2_name from mp_pat_rel_contacts where patient_id ='"+strPatientId+"' ");

			stmt = con.createStatement();    
			rs = stmt.executeQuery(mp_pat_rel_contacts.toString());

				if(rs != null && rs.next())
				{
					contact1_name	=	checkForNull(rs.getString("contact1_name"));
					contact2_name	=	checkForNull(rs.getString("contact2_name"));
				}
		}
		catch(Exception e)
		{
			//out.println("Exception in getting mp_pat_rel_contacts:"+e.toString());
			e.printStackTrace();
		}	
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (mp_pat_rel_contacts.length() > 0)
				mp_pat_rel_contacts.delete(0, mp_pat_rel_contacts.length());
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
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(adm_date_display));
            _bw.write(_wl_block18Bytes, _wl_block18);

	
		if((NU_relVal.equals("Y")) && (PARAM_relVal.equals("Y"))){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Sdate_converted));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Sdate_converted));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(leave_to_date_converted));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(leave_to_date_converted));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            {java.lang.String __page ="../../eIP/jsp/InformedDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(strPatientId
                        )},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("record_leave")},{ weblogic.utils.StringUtils.valueOf("system_date_time"), weblogic.utils.StringUtils.valueOf(Sdate
                        )},{ weblogic.utils.StringUtils.valueOf("admissiondatetime"), weblogic.utils.StringUtils.valueOf(adDateval
                        )},{ weblogic.utils.StringUtils.valueOf("encounterID"), weblogic.utils.StringUtils.valueOf(encounterID
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_pract_cnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(adDateval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(adDateval));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(warn_or_error_max_leave));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(max_leave_period));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(spl_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strBedNo));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(leave_to_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(deactivate_pseudoBed));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(no_of_record));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ip_Trn_Date));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Sdate_converted));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(leave_to_date_converted));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(contact2_name));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(spl_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strBedNo));
            _bw.write(_wl_block71Bytes, _wl_block71);

		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (rset   != null) rset.close();
		if (AbsStmt  != null) AbsStmt.close();

	}catch(Exception e){
		//out.println(e);
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block72Bytes, _wl_block72);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Leave.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Abscond.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReleaseBed.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PseudoBed.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdatetime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ToDateTime.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReportedTo.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

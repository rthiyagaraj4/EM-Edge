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
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifybedbookingtransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyBedBookingTransfer.jsp", 1725272128512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \t<!--\n\tDeveloped by \t:\tChitra \n\tCreated on \t:\t24/08/2001\n\tModule\t\t:\tip\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n    <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eIP/js/BedBookingTransfer.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n\t\n</head>\n\t<body onLoad= \"getOnload_tfrDtls();focusFirst();setDesable_tfrDtls();checkform();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!--\n\t@Name: Added by kishore on 4/26/2004\n\t-->\n\t<script language=\"JavaScript\">\n\n\tfunction checkform()\n\t{\n\n\t\t\tvar mother_status = document.forms[0].mother_status.value;\n\t\t\tvar transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;\n\t\t\tif (mother_status != \'0\')\n\t\t\t{\t\t\t\t\n\t\t\t\tif(transfer_wo_delink_yn==\'N\'){\n\t\t\t\t\tif(confirm(getMessage(\'DELINK_BABY_YN\',\'IP\')))\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n\t}\n\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<form name=\"BedBookingTransfer_form\" id=\"BedBookingTransfer_form\"  method=\"post\" action=\"../../servlet/eIP.BedBookingTransferServlet\" target=\"parent.frames[1];\">\n\n\t<table border=\'0\' width=\"100%\" cellpadding=\'2\' cellspacing=0>\n\t<tr>\n\t\t<td class=\'BLANKROWSmallPt\' colspan=4>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</td>\n\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td> \n\t</tr>\n\t<tr>\n\t\t<td class=\'BLANKROWSmallPt\' colspan=4>&nbsp;\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\'fields\' ><input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t</td>\n\t\t<td  class=\"label\"  nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\"fields\" >\n\t\t\t<select name=\"transfer_type\" id=\"transfer_type\">\n\t\t\t\t<option value=\"\">---&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;---\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</select>\n\t\t\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t</td>\n\t</tr>\t\t\n\t<tr>\n\t\t<td class=\'BLANKROWSmallPt\' colspan=4>&nbsp;\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<!--\n\t\t@coded by kishore on 4/23/2004\n\t\t-->\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<td  class=\"label\" >\n\t\t\t\t\t</td>\n\t\t\t\t<td >\n\t\t\t\t\t</td>\n\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<td class=\'fields\'><select name=\"priority\" id=\"priority\" onChange=\"\">\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</select>\n\t\t\t\t<input type=\"hidden\" name=\"exp_date_time\" id=\"exp_date_time\" value=\"\">\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<td class=\"label\" ></td>\n\t\t\t<td >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\n\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td><td  class=\'fields\'><INPUT TYPE=\"text\" name=\"pref_date_time\" id=\"pref_date_time\" id=\"prefDate\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onblur=\"compareSystemDate(this);\"  onKeyPress=\'return(ChkNumberInput(this,event,2))\'><img name=\'beddt\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].pref_date_time.focus();return showCalendar(\'prefDate\',null,\'hh:mm\');\" align=\'center\'/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td> \n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\n\t<!--10/20/2008 FS102IPSRRCRF0228V2.0-->\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t</tr>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'><INPUT TYPE=\"checkbox\" name=\"reserved_bed_yn\" id=\"reserved_bed_yn\" onClick=\"setReserveBedDtls();\"><input type=\"hidden\" name=\"is_reserved_bed_checked\" id=\"is_reserved_bed_checked\"  value=\"N\"></TD>\n\t</TR>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'>\n\t<select name=\'reason_for_reserved_bed\' id=\'reason_for_reserved_bed\' ><option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;-----</option>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'reserved_bed_img\' style=\'visibility:hidden\'></img >\n\t</TD>\n\t</TR>\n\t</table>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<!---->\n\t\n\t<input type=\"hidden\" name=\"confirmValue\" id=\"confirmValue\" value=\"Y\">\n\t<input type=\"hidden\" name=\"reqRadioBtn\" id=\"reqRadioBtn\" value=\"\"><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"TFR_REQ_TYPE\" id=\"TFR_REQ_TYPE\" value=\"RT\">\n\t\n\t<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<input type=\"hidden\" name=\"TFR_REQ_STATUS\" id=\"TFR_REQ_STATUS\" value=1>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t<input type=\"hidden\" name=\"TFR_REQ_STATUS\" id=\"TFR_REQ_STATUS\" value=0>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<!--End-->\n\t<input type=\"hidden\" name=\"cnt_pririty\" id=\"cnt_pririty\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\t\n\t<input type=\"hidden\" name=\"sysdate\" id=\"sysdate\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"change_bed_class_yn\" id=\"change_bed_class_yn\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"oper_stn_bed_class_yn\" id=\"oper_stn_bed_class_yn\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"Request_Trasnfer\">\t\n\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"\">\n\t<input type=\"hidden\" name=\"p_oper_stn_id\" id=\"p_oper_stn_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"bl_operational\" id=\"bl_operational\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'patientgender\' id=\'patientgender\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\'hidden\' name=\'dateofbirth\' id=\'dateofbirth\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\'hidden\' name=\'res_bed_no\' id=\'res_bed_no\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\'hidden\' name=\'res_room_no\' id=\'res_room_no\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\'hidden\' name=\'res_nursing_unit\' id=\'res_nursing_unit\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\'hidden\' name=\'r_bed_no\' id=\'r_bed_no\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\'hidden\' name=\'r_room_no\' id=\'r_room_no\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\'hidden\' name=\'r_nursing_unit\' id=\'r_nursing_unit\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\'hidden\' name=\'allow_transfer\' id=\'allow_transfer\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\'hidden\' name=\'allow_multiple_bed_for_resv_yn\' id=\'allow_multiple_bed_for_resv_yn\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\'hidden\' name=\'reserve_bed_on_tfr_yn\' id=\'reserve_bed_on_tfr_yn\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\'hidden\' name=\'max_trn_date_time\' id=\'max_trn_date_time\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\'hidden\' name=\'r_nursing_unit_desc\' id=\'r_nursing_unit_desc\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\'hidden\' name=\'pseudo_bed\' id=\'pseudo_bed\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"deact_pseudo_bed\" id=\"deact_pseudo_bed\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"reserved_bed_cont\" id=\"reserved_bed_cont\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"transfer_wo_delink_yn\" id=\"transfer_wo_delink_yn\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"><!-- Added for the CRF - HSA-CRF-0035 -->\n\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t<input type=\'hidden\' name=\'transfer_chargeable_yn\' id=\'transfer_chargeable_yn\' value=\'Y\'>\n\t\t<input type=\'hidden\' name=\'transfer_serv_charge\' id=\'transfer_serv_charge\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'surgery_reqd_yn\' id=\'surgery_reqd_yn\' value=\'Y\'>\n\t\t<input type=\'hidden\' name=\'addnl_dep_amt\' id=\'addnl_dep_amt\' value=\'\'>\n\t\t<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\'\'>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t<table border=\'0\' width=\'100%\'  cellpadding=2 cellspacing=0 align=\"right\">\n\t\n\t<tr><td align=right>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<input type=\"hidden\" class=\"button\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" name =\'compute\' onclick=\"ComputeBlDtl();\"><input type=\"button\" class=\"button\" id =\'confirm\'  name =\'confirm\'  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" onclick=\"submitForm();\">\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<input type=\"button\" class=\"button\" name =\'confirm\' id =\'confirm\'  value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" onclick=\"submitForm(); \">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="<input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" onclick=\"cancel();\"></td>\n\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t</tr>\n\t</table>\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\n</form>\t \n</body>\n</html>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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

	request.setCharacterEncoding("UTF-8");
	String locale			= "";
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rset			= null;
	Statement stmt1			= null;
	ResultSet rset1			= null;
	Statement stmt_bl		= null;
	ResultSet rs_bl			= null;	
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;	
	String countpriority	= "";
	String facilityId		= "";
	String bl_operational	= "";
	String bl_interfaced_yn	= "";
	String priotity_status	= "";
	String change_bed_class_yn	= "";
	String deactivate_pseudo_bed_yn	= "";

try
{
	con						= ConnectionManager.getConnection(request);
   	stmt					= con.createStatement();
	locale					= (String)session.getAttribute("LOCALE");
	facilityId				= (String)session.getValue("facility_id");
	bl_operational			= (String)session.getValue("bl_operational");

	String autoCnrmTfrReq	= eIP.IPCommonBean.getAutoCnrmTfrReqParam(con,facilityId);//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617

	bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
	priotity_status			= checkForNull(request.getParameter("priotity_status"));
	change_bed_class_yn		= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String transfer_wo_delink_yn	= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String frbedno				= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";   
	String frspecialitydesc		= "";
	String frbedclass			= ""; 
	String frbedclassdesc		= ""; 
	String frnursingunitdesc	= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String age					= "";
	String gender				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmeddesc			= "";
	String frmedid				= "";
	String d_converted			= "";
	String reserved_bed			= "";
	String reserved_room		= "";
	String reserved_nursing_unit			= "";
	String r_bed				= "";
	String r_room				= "";
	String r_nursing_unit		= "";
	String allow_emerg_trf_yn		= "";
	String allow_multiple_bed_for_resv_yn		= "";
	String reserve_bed_on_tfr_yn		= "";
	String r_nursing_unit_desc		= "";
	String pseudo_bed_yn			= "";

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		
		java.text.SimpleDateFormat dateFormat	= null ;
		java.util.Date dt						= null ;
		String d								= "";
		String patientid						= "";
		String eid								= "";
		String loginUser						= "";

		dateFormat				= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		dt						= new java.util.Date();
		d						= dateFormat.format( dt ) ;
		d						= d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
		if(!(d==null || d.equals("")))
				d_converted		= DateUtils.convertDate(d,"DMYHM","en",locale);	
		
		patientid				= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		eid						= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		long    encounterid		= Long.parseLong(eid);
		session.putValue("patientid",patientid);
		session.putValue("encounter_id",eid);
		String admissiondate	= "";
		String admissiontype	= "";
		String admissiondesc	= "";
		String frnursingunitcode= "";
		String p_oper_stn_id	= "";
		loginUser				= (String)session.getValue("login_user");
		String sdate			= "";
		String oper_stn_bed_class_yn	= "";
		String admissiondate_converted	= "";
		String sdate_converted	= "";
		String MAX_TRN_DATE_TIME= "";
		int mother_status		= 0;
		int reserved_bed_cont	= 0;
		
		/*StringBuffer sdatsql = new StringBuffer();

		sdatsql.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual");    
		rset    = stmt.executeQuery(sdatsql.toString());
		if(rset != null)
		{
		if(rset.next())
		   {
			sdate = rset.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
		   }  
		   if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		}*/
		
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, a.oper_stn_id  OPER_STN_ID, a.BED_CLASS_CHANGE_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString());

		if (rs_opn != null && rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id")== null ? "" : rs_opn.getString("oper_stn_id");
			oper_stn_bed_class_yn = rs_opn.getString("BED_CLASS_CHANGE_YN")== null ? "" : rs_opn.getString("BED_CLASS_CHANGE_YN");
			sdate = rs_opn.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
			if(rs_opn   != null)   rs_opn.close();
			if(stmt_opn   != null)   stmt_opn.close();
		}
		
		
		
		
		StringBuffer sql2 = new StringBuffer();

/*10/9/2008 for FS102IPSRRCRF0228 */
		sql2.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, a.admission_type, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, a.nursing_unit_code, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.specialty_code, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2 ) specialty_short_desc, a.attend_practitioner_id practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1) practitioner_name, a.bed_num bed_no, a.room_num room_no, a.bed_class_code, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, null dly_charge, a.bed_type_code, ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) BED_TYPE_SHORT_DESC, b.sex gender, to_char(b.date_of_birth,'dd/mm/rrrr') DATE_OF_BIRTH, a.service_code, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, SUBSERVICE_CODE, am_get_desc.am_subservice(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_SHORT_DESC, a.PATIENT_CLASS, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_desc,a.reserved_bed_no,a.reserved_room_no,a.reserved_nurs_unit_code,ip_get_desc.ip_nursing_unit (a.facility_id, a.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc, c.ALLOW_EMERG_TRF_YN, (SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = a.facility_id AND ENCOUNTER_ID = a.encounter_id) MAX_TRN_DATE_TIME, (select count(*) from ip_nursing_unit_bed where facility_id = a.facility_id and nursing_unit_code = a.nursing_unit_code and main_bed_no = a.bed_num and occupying_patient_id is not null) m_status");
		/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
		sql2.append(",(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn  ");
		/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
		sql2.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
		sql2.append(", d.allow_multiple_bed_for_resv_yn, d.reserve_bed_on_tfr_yn from ip_open_encounter a, mp_patient b, ip_nursing_unit c, ip_param d where a.facility_id = '"+facilityId+"' and a.encounter_id ='"+encounterid+"' and a.patient_id = b.patient_id and a.facility_id = c.facility_id and a.nursing_unit_code = c.nursing_unit_code and a.facility_id = d.facility_id");
		stmt = con.createStatement() ;
		
		rset = stmt.executeQuery(sql2.toString()) ;
		if(rset != null)
		{
			if(rset.next())
				admissiondate		= checkForNull(rset.getString("admission_date"));
				if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
				admissiontype		= checkForNull(rset.getString("admission_type"));
				admissiondesc		=checkForNull(rset.getString("admission_short_desc"));
				frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code")); 
				
				frbedno				= checkForNull(rset.getString("bed_no"));
				frpractitionerid	= checkForNull(rset.getString("practitioner_id")); 
				frpractdesc			= checkForNull(rset.getString("practitioner_name"));
				frspecialitycode	= checkForNull(rset.getString("specialty_code"));   
				frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
				frbedclass			= checkForNull(rset.getString("bed_class_code"));  
				frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc")); 
				frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc")); 
				frroomno			= checkForNull(rset.getString("room_no"));
				frbedtype			= checkForNull(rset.getString("bed_type_code")); 
				frbedtypedesc		= checkForNull(rset.getString("bed_type_short_desc"));
				frdailycharge		= rset.getInt("dly_charge");
				age					= checkForNull(rset.getString("date_of_birth"));
				gender				= checkForNull(rset.getString("gender"));
				frservicecode		= checkForNull(rset.getString("service_code"));
				frservicedesc		= checkForNull(rset.getString("service_short_desc"));
				frsubservcode		= checkForNull(rset.getString("SUBSERVICE_CODE"));
				frsubservdesc		= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
				patient_class		= checkForNull(rset.getString("PATIENT_CLASS"));
				frmeddesc			= checkForNull(rset.getString("TEAM_DESC"));
				frmedid				= checkForNull(rset.getString("TEAM_ID"));
				/*10/9/2008 for CRF 3698*/
				r_bed				= checkForNull(rset.getString("reserved_bed_no"));
				r_room				= checkForNull(rset.getString("reserved_room_no"));
				r_nursing_unit		= checkForNull(rset.getString("reserved_nurs_unit_code"));
				r_nursing_unit_desc	= checkForNull(rset.getString("res_nursing_unit_short_desc"));
				allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				MAX_TRN_DATE_TIME	= rset.getString("MAX_TRN_DATE_TIME");
				MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
				mother_status = rset.getInt("m_status");
				allow_multiple_bed_for_resv_yn = checkForNull(rset.getString("allow_multiple_bed_for_resv_yn"));
				reserve_bed_on_tfr_yn = checkForNull(rset.getString("reserve_bed_on_tfr_yn"));
				pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
				reserved_bed_cont		= rset.getInt("reserved_bed_cont");
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
		}

/*10/20/2008 FS102IPSRRCRF0228V2.0 */

			 /*commented the below queries & merged with above query for PE - 11/05/2010
			String sql_nu	= " select ALLOW_EMERG_TRF_YN  from IP_NURSING_UNIT_VW where nursing_unit_code='"+frnursingunitcode+"' and facility_id ='"+facilityId+"' ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_nu.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				 }
				if(rset!=null) rset.close();
			

		String sql_param	= " select allow_multiple_bed_for_resv_yn ,reserve_bed_on_tfr_yn from IP_PARAM where  facility_id ='"+facilityId+"' ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_param.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_multiple_bed_for_resv_yn = checkForNull(rset.getString("allow_multiple_bed_for_resv_yn"));
					reserve_bed_on_tfr_yn = checkForNull(rset.getString("reserve_bed_on_tfr_yn"));
				 }
				if(rset!=null) rset.close();

			String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+encounterid+"'";
			rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
				}
			}
			if(rset!=null)rset.close();
			
		MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
		

		//int mother_status=0;
		StringBuffer mother_bed = new StringBuffer();
		
		mother_bed.append("select count(*) m_status from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+frnursingunitcode+"' ");
		stmt = con.createStatement();
		rset = stmt.executeQuery(mother_bed.toString());
			if(rset != null)
			{
				if(rset.next())
				{
					mother_status = rset.getInt("m_status");
				}
				
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
			}*/

if(bl_operational.equals("Y"))
	{
		StringBuffer bl_elig = new StringBuffer();		
		bl_elig.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"'");
		stmt  = con.createStatement();
		rset = stmt.executeQuery(bl_elig.toString());
		while(rset.next())
		{
			billing_group_id = rset.getString("BLNG_GRP_ID");
			billing_group_desc = rset.getString("SHORT_DESC");
		}
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
	}	
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiondesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(d));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(d_converted));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					stmt = con.createStatement();
					//rset = stmt.executeQuery("select transfer_type_code,short_desc from IP_TRANSFER_TYPE_LANG_VW where language_id='"+locale+"'  and  eff_status = 'E' order by short_desc");
					rset = stmt.executeQuery("SELECT transfer_type_code , ip_get_desc.ip_transfer_type(transfer_type_code,'"+locale+"',2) short_desc FROM ip_transfer_type WHERE eff_status = 'E' ORDER BY short_desc");
					if(rset != null)
					{
						while(rset.next())
						{
							String desc = rset.getString("short_desc")== null ? "" : rset.getString("short_desc");
							String code = rset.getString("transfer_type_code")==null ? "":rset.getString("transfer_type_code");
							out.print("<option value='"+code+"' >"+desc );
						}
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
					}
				
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		if(priotity_status.equals("Y"))
		{
			String code1= "";
			String desc1= "";
			String code = "";
			String desc = "";

			stmt = con.createStatement();
			//rset = stmt.executeQuery(" select a.priority_code,a.short_desc from IP_TRANSFER_PRIORITY_LANG_VW a where a.language_id='"+locale+"' and eff_status = 'E' and a.facility_id='"+facilityId+"' and priority_code in (select b.dflt_priority_for_tfr_req from IP_PARAM b where b.facility_id='"+facilityId+"') order by 2 ");
			rset = stmt.executeQuery(" SELECT a.priority_code, ip_get_desc.ip_transfer_priority (a.facility_id,a.priority_code,'"+locale+"','2')short_desc FROM  ip_transfer_priority a  WHERE eff_status = 'E' AND a.facility_id = '"+facilityId+"' AND priority_code IN (SELECT b.dflt_priority_for_tfr_req FROM ip_param b  WHERE b.facility_id = '"+facilityId+"') ORDER BY 2  ");

			if (rset == null && !rset.next())
			{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
			else
			{
				if (rset!= null)
				{
					while(rset.next())
					{
						code1 = checkForNull(rset.getString("PRIORITY_CODE"));
						desc1 = checkForNull(rset.getString("short_desc"));
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
				
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block24Bytes, _wl_block24);

				stmt = con.createStatement();
				//rset = stmt.executeQuery(" Select a.PRIORITY_CODE,a.short_desc from IP_TRANSFER_PRIORITY_LANG_VW a where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.eff_status='E' and PRIORITY_CODE not in (select b.DFLT_PRIORITY_FOR_TFR_REQ from ip_param b where b.facility_id='"+facilityId+"') order by short_desc ");
				rset = stmt.executeQuery(" SELECT a.priority_code, ip_get_desc.ip_transfer_priority (a.facility_id,a.priority_code,'"+locale+"','2')short_desc FROM ip_transfer_priority a WHERE a.facility_id = '"+facilityId+"'  AND a.eff_status = 'E'  AND priority_code NOT IN (SELECT b.dflt_priority_for_tfr_req FROM ip_param b  WHERE b.facility_id = '"+facilityId+"') ORDER BY short_desc ");
				if (rset != null)
				{
					while(rset.next())
					{
						code = checkForNull(rset.getString("PRIORITY_CODE"));
						desc = checkForNull(rset.getString("short_desc"));
						out.print("<option value='"+code+"' >"+desc );
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
				
            _bw.write(_wl_block25Bytes, _wl_block25);
	}	
		
		
		}
		else
		{	
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sdate_converted));
            _bw.write(_wl_block29Bytes, _wl_block29);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("Request_Trasnfer")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitcode"), weblogic.utils.StringUtils.valueOf(frnursingunitcode
                        )},{ weblogic.utils.StringUtils.valueOf("frbedno"), weblogic.utils.StringUtils.valueOf(frbedno
                        )},{ weblogic.utils.StringUtils.valueOf("frpractitionerid"), weblogic.utils.StringUtils.valueOf(frpractitionerid
                        )},{ weblogic.utils.StringUtils.valueOf("frpractdesc"), weblogic.utils.StringUtils.valueOf(frpractdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitycode"), weblogic.utils.StringUtils.valueOf(frspecialitycode
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitydesc"), weblogic.utils.StringUtils.valueOf(frspecialitydesc
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclass"), weblogic.utils.StringUtils.valueOf(frbedclass
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclassdesc"), weblogic.utils.StringUtils.valueOf(frbedclassdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitdesc"), weblogic.utils.StringUtils.valueOf(frnursingunitdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frroomno"), weblogic.utils.StringUtils.valueOf(frroomno
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtype"), weblogic.utils.StringUtils.valueOf(frbedtype
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtypedesc"), weblogic.utils.StringUtils.valueOf(frbedtypedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frdailycharge"), weblogic.utils.StringUtils.valueOf(frdailycharge
                        )},{ weblogic.utils.StringUtils.valueOf("age"), weblogic.utils.StringUtils.valueOf(age
                        )},{ weblogic.utils.StringUtils.valueOf("gender"), weblogic.utils.StringUtils.valueOf(gender
                        )},{ weblogic.utils.StringUtils.valueOf("frservicecode"), weblogic.utils.StringUtils.valueOf(frservicecode
                        )},{ weblogic.utils.StringUtils.valueOf("frservicedesc"), weblogic.utils.StringUtils.valueOf(frservicedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservcode"), weblogic.utils.StringUtils.valueOf(frsubservcode
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservdesc"), weblogic.utils.StringUtils.valueOf(frsubservdesc
                        )},{ weblogic.utils.StringUtils.valueOf("patient_class"), weblogic.utils.StringUtils.valueOf(patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("frmeddesc"), weblogic.utils.StringUtils.valueOf(frmeddesc
                        )},{ weblogic.utils.StringUtils.valueOf("frmedid"), weblogic.utils.StringUtils.valueOf(frmedid
                        )},{ weblogic.utils.StringUtils.valueOf("ch_bed_class_param"), weblogic.utils.StringUtils.valueOf(change_bed_class_yn
                        )},{ weblogic.utils.StringUtils.valueOf("deact_pseudo_bed"), weblogic.utils.StringUtils.valueOf(deactivate_pseudo_bed_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block33Bytes, _wl_block33);
if(reserve_bed_on_tfr_yn.equals("Y")){
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!allow_emerg_trf_yn.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

		try{
			
			stmt = con.createStatement();
			// The  query changed for SRR20056-SCF-7627 [IN : 27703] by Jayashree on 5/7/2011
			String sqlQuery	= " SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ";
			
			
			String reason_code="";
			String reason_desc="";
			rset = stmt.executeQuery(sqlQuery);
			if( rset != null )
				{
				  while( rset.next() )
				  {
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				}
			}catch(Exception e) {out.println(e.toString());}
		
	
            _bw.write(_wl_block39Bytes, _wl_block39);
}}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
 if(autoCnrmTfrReq.equals("Y")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
 }else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
 } 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(countpriority));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oper_stn_bed_class_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(oper_stn_bed_class_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(age));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(reserved_bed));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(reserved_room));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(reserved_nursing_unit));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(r_bed));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(r_room));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(r_nursing_unit));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(allow_emerg_trf_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(MAX_TRN_DATE_TIME));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(r_nursing_unit_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(reserved_bed_cont));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);

	if(bl_interfaced_yn.equals("Y"))
	{
	
            _bw.write(_wl_block74Bytes, _wl_block74);

	}
	
            _bw.write(_wl_block75Bytes, _wl_block75);

		if(bl_interfaced_yn.equals("Y")) {
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")));
            _bw.write(_wl_block78Bytes, _wl_block78);
} else {
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block84Bytes, _wl_block84);

		if(rs_bl	!= null)   rs_bl.close();
		if(rset		!= null)   rset.close();
		if(rset1!= null)   rset1.close();
		if(stmt   != null)   stmt.close();
		if(stmt1   != null)   stmt1.close();
		if(rs_opn   != null)   rs_opn.close();
		if(stmt_opn   != null)   stmt_opn.close();
		if(stmt_bl   != null)   stmt_bl.close();

	}catch(Exception e){
		out.println(e.toString());
	}
	finally {
		ConnectionManager.returnConnection(con,request);
	}
	 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block86Bytes, _wl_block86);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferBookingDate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreferredDateTime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBedDetails.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBed.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforReserveBed.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}

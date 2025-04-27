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
import eCommon.XSSRequestWrapper;

public final class __addmodifyemergencytransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyEmergencyTransfer.jsp", 1725982122956L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t\t\n\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<!--<script src=\"../js/EmergencyTransfer.js\" language=\"javascript\"></script>-->\n\t<script src=\"../js/PatientEmergencyTransfer.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<script>\n\nfunction validateBackDate(tfrDate)\n{\n\t\n\tvar systemdate=document.forms[0].sdate.value\n\tvar max_trn_date_time = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\tvar CurrentDate = getCurrentDate(\"DMYHM\",\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\")\n\t\t\n\tif (tfrDate.value != \"\"  || tfrDate.value != \'\')\n\t{\n\t\tif(!validDateObj(tfrDate,\"DMYHM\",localeName))\n\t\t{\n\t\t\treturn ;\n\t\t}\n\t\tvar greg_tfrDateTime = convertDate(tfrDate.value,\'DMYHM\',localeName,\'en\');\n\t\tvar greg_maxtfrDateTime = convertDate(max_trn_date_time,\'DMYHM\',localeName,\'en\');\n\n\tif(!isBefore(document.forms[0].admission_date.value,greg_tfrDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\'Common\'));\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}\n\t\t\n\t\telse if(isAfterNow(greg_tfrDateTime,CurrentDate,\'DMYHM\',\'en\'))//Modified by Suresh on 17th August 2015 against IN:056949\n\t\t//else if(CurrentDate<greg_tfrDateTime)\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_GT_DATE2\',\'IP\');\n\t\t\t\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.SystemDateTime.label\",\'Common\'));\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}//modified for 12/15/2008 6021  MF-SCF-0051\n\t\telse if(!isBefore(greg_maxtfrDateTime,convertDate(document.forms[0].transfer_date.value,\'DMYHM\',localeName,\'en\'),\'DMYHM\',\'en\')){\n\t\t\t\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t//var last_encounter = getLabel(\"Common.Last.label\",\"Common\")+\" \"+getLabel(\"Common.encounterdate.label\",\"Common\");\n\t\t\t/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/\n\t\t\tvar last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\"ip_labels\");\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',last_encounter);\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}//\n\t}\n}\n\nfunction checkform()\n{\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\tvar error\t= getMessage(\'ONLY_ONE_REQ_BKG\',\'IP\');\n\t\terror\t\t= error.replace(\'$\',getLabel(\"eIP.RequestTransfer.label\",\'IP\'));\n\t\talert(error);\t\n\t\twindow.close();\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\tvar error = getMessage(\'ONLY_ONE_REQ_BKG\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"eIP.RequestTransfer.label\",\'IP\'));\n\t\t\talert(error);\t\n\t\t\twindow.close();\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n\tvar mother_status = document.forms[0].mother_status.value;\n\tvar transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;\n\tif (mother_status != \'0\')\n\t{\t\t\n\t\tif(transfer_wo_delink_yn==\'N\'){//Added for the CRF HSA-CRF-0035 \n\t\t\tif(confirm(getMessage(\'DELINK_BABY_YN\',\'IP\')))\n\t\t\t{\n\t\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n\t\t\t\twindow.close();\n\t\t\t}\n\t\t}else{\n\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t}\n\t}\n\telse\n\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n}\n</script>\n</head>\n\n\n<body onload=\'checkform();focusFirst();setDesable_tfrDtls();getOnload_tfrDtls();seDef();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"Emergency_Transfer_form\" id=\"Emergency_Transfer_form\"  method=\"post\"  action=\"../../servlet/eIP.PatientEmergencyTransferServlet\"  target=\"parent.frames[1]\">\n\t<table border=0 width=\"100%\" cellpadding=2 cellspacing=0>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!-- <br><br><br> -->\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<!-- <tr><td class=\'BLANKROW1PT\' colspan=4></td></tr> -->\n\t\t<tr>\n\t\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t <td  class=\'querydata\' width=\'24%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td  class=\"label\" width=\'24%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td  class=\'querydata\' width=\'28%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\"label\" width=\'23%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\n\t\t\t<!-- <td class=\'querydata\' width=\'24%\' ><input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td> -->\n\t\t<td class=\'fields\'><input type=text name=\'transfer_date\' id=\'transfer_date\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\'transfer_date_id\' maxlength=\"16\" size=\"16\" onBlur=\"validateBackDate(this);\" onKeyPress=\'return(ChkNumberInput(this,event,2));\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'ondate1\'  onClick=\"document.forms[0].transfer_date.select();return showCalendar(\'transfer_date_id\',null,\'hh:mm\');\"/>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</td>\n\n\n\t\t\t<td  class=\"label\" width=\'26%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td  width=\'28%\'>\n\t\t\t\t<select name=\"transfer_type\" id=\"transfer_type\"  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t\t\t<option value=\"\">----";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="----\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<input type=\"hidden\" name=\"transfer_type_code\" id=\"transfer_type_code\"  value=\"\">\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\n\t\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t<td class = \'label\' width=\'25%\'></td>\n\t</tr>\n\t <tr>\n\t\t<td class=\'label\' width=\'25%\'></td>\n\t\t<td align=\'right\' colspan=\'3\'>\n\t\t<input type=\"button\" class=\"button\" name=\"confirm\" id=\"confirm\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  onclick=\"Confirm();\"><input type=\"button\" class=\"button\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onclick=\"cancel();\"></td>\n\t</tr>\n\t\n\t</table>\t\n\t\t\t<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start -->\n\t\t<input type = \'hidden\' name = \'bl_adm_remarks\' id = \'bl_adm_remarks\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_request\' id = \'bl_bed_request\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_type_code\' id = \'bl_bed_type_code\' value=\"\">\n\t\t<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End -->\n\t\t\t\n\t\t<input type=\"hidden\" name=\"sdate\" id=\"sdate\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id1\" id=\"encounter_id1\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"fr_bed_type1\" id=\"fr_bed_type1\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\" name=\"tobedtype\" id=\"tobedtype\" value=\"\">\n\t\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"open_enctr_gender\" id=\"open_enctr_gender\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n \t\t<input type=\"hidden\" name=\"open_enctr_age\" id=\"open_enctr_age\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> \n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"EMERGENCY_TRANSFER\">\t\n\t\t<input type=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" value=\"\">\n\t\t<input type=\'hidden\' name = \'bl_operational\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\" name=\"def_max_period\" id=\"def_max_period\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\n\t\t<input type=\"hidden\" name=\"change_bed_class_yn\" id=\"change_bed_class_yn\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\" name=\"counter\" id=\"counter\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"\">\n\t\t<input type=\"hidden\" name=\"override_yn\" id=\"override_yn\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"bed_class_chk\" id=\"bed_class_chk\" value=\"Y\">\n\t\t<input type=\"hidden\" name=\"reserve_nurs_unit_code\" id=\"reserve_nurs_unit_code\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_room_no\" id=\"reserve_room_no\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_no\" id=\"reserve_bed_no\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_specialty_code\" id=\"reserve_specialty_code\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_practitioner_id\" id=\"reserve_practitioner_id\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_type_code\" id=\"reserve_bed_type_code\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_service_code\" id=\"reserve_service_code\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_class_code\" id=\"reserve_bed_class_code\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type=\"hidden\" name=\"confirm_yn\" id=\"confirm_yn\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"remove_bed\" id=\"remove_bed\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"is_to_bed_equals_reserve_bed\" id=\"is_to_bed_equals_reserve_bed\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_on_tfr_yn\" id=\"reserve_bed_on_tfr_yn\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\"hidden\" name=\"p_oper_stn_id\" id=\"p_oper_stn_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\"hidden\" name=\"func_id\" id=\"func_id\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\"hidden\" name=\"bed_blocking_period\" id=\"bed_blocking_period\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type=\"hidden\" name=\"transfer_wo_delink_yn\" id=\"transfer_wo_delink_yn\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"><!-- Added for the CRF HSA-CRF-0035 -->\n\t\t<input type=\"hidden\" name=\"reqRadioBtn\" id=\"reqRadioBtn\" value=\"\"><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->\n\n\t\t\n\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<input type=\'hidden\' name=\'transfer_chargeable_yn\' id=\'transfer_chargeable_yn\' value=\'Y\'>\n\t\t<input type=\'hidden\' name=\'transfer_serv_charge\' id=\'transfer_serv_charge\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'surgery_reqd_yn\' id=\'surgery_reqd_yn\' value=\'Y\' >\n\t\t<input type=\'hidden\' name=\'addnl_dep_amt\' id=\'addnl_dep_amt\' value=\'\'>\n\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\n<script>\n\t\t//document.forms[0].nursing_unit.value=document.forms[0].fr_nursing_unit_code.value;\n\t\tdocument.forms[0].practid.value=document.forms[0].fr_practitioner_id.value;\n\t\tdocument.forms[0].Splcode.value=document.forms[0].fr_speciality_code.value;\n\t\t/*var count=0\n\t\t\tif(count==0)\n\t\t\t{\n\t\t\t\tpopDynamicValues_em(document.forms[0].nursing_unit);\n\t\t\t\tcount++;\n\t\t\t}\n\t\t*/\n</script>\n\t</form>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t \n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
	String locale				= (String)session.getAttribute("LOCALE");
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String bl_operational		= (String)session.getValue("bl_operational");
	String loginUser			= (String)session.getValue("login_user");
	String facilityId			= (String)session.getValue("facility_id");
	String admissiondesc		= "";
	StringBuffer sqlQuery		= new StringBuffer();
	
	String modified_date_val	= "";
	String frmeddesc			= "";
	String admissiondate		= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";
	String frspecialitydesc		= "";
	String frbedclass			= "";
	String frbedclassdesc		= "";
	String frnursingunitcode	= "";
	String frnursingunitdesc	= "";
	String frbedno				= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String gender				= "";
	String age					= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmedid				= "";
	String reserve_bed_no		= "";
	String reserve_nurs_unit_code	= "";
	String reserve_room_no		= "";
	String reserve_specialty_code   = "";
	String reserve_practitioner_id  = "";
	String reserve_bed_type_code    = "";
	String reserve_service_code		= "";
	String reserve_bed_class_code   = "";
	String BED_BLK_PERIOD_MAX	= "";
	int BED_BLOCK_PERIOD_MAX	= 0;
	int req_count				= 0;
	int tfr_req_count			= 0;
	String admissiondate_converted  = "";
	String d_converted			= "";

	String isreadonly			= "";
	String isenable				= "";
	String transfer_wo_delink_yn				= "";//Added for the CRF HSA-CRF-0035

	try
	{
		String func_id			= checkForNull(request.getParameter("func_id"));
		/*
		if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
			isreadonly = "ReadOnly";
			isenable = "Disabled";
		}
		*/
		String patientid			= checkForNull(request.getParameter("patient_id"));

		String req_count_str		= checkForNull(request.getParameter("bed_class_req_cnt"));
		if(!req_count_str.equals(""))
			req_count = Integer.parseInt(req_count_str);
		String tfr_req_count_str	= checkForNull(request.getParameter("trans_req_cnt"));
		if(!tfr_req_count_str.equals(""))
			tfr_req_count			= Integer.parseInt(tfr_req_count_str);
	
		String sdate				= "";
		String install_yn			= "";
		String bedBlock_normal		= "";
		String max_blk_type			= "";
		String deact_pseudo_bed		= "";
		String ch_bed_class_param	= "";
		String reserve_bed_on_tfr_yn= "";
		String MAX_TRN_DATE_TIME    = "";
		String allow_multiple_bed_for_resv_yn    = "";
		int mother_status			= 0;
		String p_oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
		String eid					= checkForNull(request.getParameter("encounter_id"));
		long    encounterid			= Long.parseLong(eid);
		install_yn					= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
		bedBlock_normal				= checkForNull(request.getParameter("bed_block_period_normal"));
		BED_BLK_PERIOD_MAX			= checkForNull(request.getParameter("bed_block_period_max"));
		BED_BLOCK_PERIOD_MAX		= Integer.parseInt(BED_BLK_PERIOD_MAX);
		max_blk_type				= checkForNull(request.getParameter("bed_block_period_max_type"));
		deact_pseudo_bed			= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
		ch_bed_class_param			= checkForNull(request.getParameter("change_bed_class_yn"),"N");
		allow_multiple_bed_for_resv_yn		= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
		reserve_bed_on_tfr_yn		= checkForNull(request.getParameter("allow_multiple_bed_for_resv_yn"),"N");
		transfer_wo_delink_yn		= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
		if(max_blk_type.equals("D"))
				BED_BLOCK_PERIOD_MAX = (BED_BLOCK_PERIOD_MAX)*24;
		session.putValue("patientid",patientid);
		session.putValue("encounter_id",eid);
		con							= ConnectionManager.getConnection(request);
		stmt						= con.createStatement();	
		/*Saturday, May 08, 2010 commnted for PE*/
		/*
		sqlQuery.append(" select nvl(bl_interfaced_yn,'N') bl_interfaced_yn, bed_block_period_max, bed_block_period_max_type, bed_block_period_normal, deactivate_pseudo_bed_yn, change_bed_class_yn, reserve_bed_on_tfr_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate,allow_multiple_bed_for_resv_yn  from IP_PARAM where facility_id = '"+facilityId+"' ");
		
		try
		{
			rset	=stmt.executeQuery(sqlQuery.toString());
			if(rset.next())
			{
				sdate					= rset.getString("sdate");
				//out.println("sdate==="+sdate);
				install_yn				= rset.getString("bl_interfaced_yn");
				bedBlock_normal			= rset.getString("bed_block_period_normal");
				BED_BLOCK_PERIOD_MAX	= rset.getInt("BED_BLOCK_PERIOD_MAX");
				max_blk_type			= rset.getString("BED_BLOCK_PERIOD_MAX_TYPE");
				deact_pseudo_bed		= rset.getString("deactivate_pseudo_bed_yn");
				ch_bed_class_param		= rset.getString("CHANGE_BED_CLASS_YN");
				allow_multiple_bed_for_resv_yn		= rset.getString("allow_multiple_bed_for_resv_yn");

				reserve_bed_on_tfr_yn		= rset.getString("reserve_bed_on_tfr_yn");
				if(reserve_bed_on_tfr_yn == null) reserve_bed_on_tfr_yn = "N";
				if(max_blk_type.equals("D"))
					BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;
			}
			if(rset!=null)rset.close();
		  //if(stmt!=null)stmt.close();
			
		//added by kishore on 8/21/2004
		}
		catch(Exception e)
		{
			//out.println("Exception @try1"+e);
			e.printStackTrace();
		}
		
		//modified for 12/15/2008 6021  MF-SCF-0051
		try{
		
		String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+eid+"'";
		rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			
		}
		catch(Exception ex){
			//out.println("Exception"+ex);
			ex.printStackTrace();
				}

MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
*/
/**/


			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d			= dateFormat.format( dt ) ;
			String min			= String.valueOf(dt.getMinutes()) ;
           // if(min.length() == 1)   min = "0"+min ;
            //if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			if(!(d==null || d.equals("")))
				d_converted = DateUtils.convertDate(d,"DMYHM","en",locale);
			String admissiontype	= "";

			String change_bed_class_yn="";
			
			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());

		
			sqlQuery.append("SELECT" );
			sqlQuery.append("  TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date" );
			sqlQuery.append("  , a.admission_type" );
			sqlQuery.append("  ,IP_GET_DESC.IP_ADMISSION_TYPE(a.ADMISSION_TYPE,'"+locale+"','2') admission_short_desc" );
			sqlQuery.append("  ,a.nursing_unit_code" );
			sqlQuery.append("  , IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc" );
			sqlQuery.append("  , a.specialty_code" );
			sqlQuery.append("  ,AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc" );
			sqlQuery.append("  ,a.attend_practitioner_id practitioner_id" );
			sqlQuery.append("  ,AM_GET_DESC.AM_PRACTITIONER(a.attend_PRACTITIONER_ID,'"+locale+"','1') practitioner_name" );
			sqlQuery.append("  ,a.room_num room_no" );
			sqlQuery.append("  ,a.bed_num bed_no" );
			sqlQuery.append("  ,a.bed_class_code" );
			sqlQuery.append("  ,IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc" );
			sqlQuery.append("  , null dly_charge" );
			sqlQuery.append("  ,a.bed_type_code" );
			sqlQuery.append("  ,IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') BED_TYPE_SHORT_DESC" );
			sqlQuery.append("  ,b.sex gender" );
			sqlQuery.append("  ,TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth" );
			sqlQuery.append("  , a.service_code" );
			sqlQuery.append("  , AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc" );
			sqlQuery.append("  ,a.SUBSERVICE_CODE" );
			sqlQuery.append("  ,AM_GET_DESC.AM_SUBSERVICE(a.service_code,SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
			sqlQuery.append("  , a.PATIENT_CLASS" );
			sqlQuery.append("  ,Am_Get_desc.AM_MEDICAL_TEAM(a.Facility_Id, a.Team_Id,'"+locale+"','2') TEAM_DESC" );
			sqlQuery.append("  ,a.TEAM_ID " );
			sqlQuery.append("  ,to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date " );
			sqlQuery.append("  , to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate " );
			sqlQuery.append("  , (select count(*) m_status from ip_nursing_unit_bed where  occupying_patient_id is not null and facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and main_bed_no = a.bed_num) m_status " );
			sqlQuery.append("  , (SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = a.facility_id AND ENCOUNTER_ID = a.encounter_id) TRN_DATE_TIME " );
			sqlQuery.append("  , (select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = a.facility_id and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and locn_type = 'N' and LOCN_CODE= nursing_unit_code) bed_class_change_yn " );
			sqlQuery.append("FROM" );
			sqlQuery.append("  IP_OPEN_ENCOUNTER a, mp_patient b " );
			sqlQuery.append("WHERE a.facility_id = '"+facilityId+"' " );
			sqlQuery.append("  AND a.encounter_id = '"+encounterid+"' and a.patient_id = b.patient_id" );
			stmt = con.createStatement() ;
			rset = stmt.executeQuery(sqlQuery.toString()) ;
			if(rset != null && rset.next())
			{
				modified_date_val	= checkForNull(rset.getString("modified_date"));
				admissiondate		= checkForNull(rset.getString("admission_date"));
				if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
				admissiontype		= checkForNull(rset.getString("admission_type"));
				admissiondesc		= checkForNull(rset.getString("admission_short_desc"));
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
				frbedtypedesc		= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
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
				sdate				= checkForNull(rset.getString("sdate"));
				mother_status		= rset.getInt("m_status");
				MAX_TRN_DATE_TIME	= checkForNull(rset.getString("TRN_DATE_TIME"));
				change_bed_class_yn	= checkForNull(rset.getString("bed_class_change_yn"),"N");
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			sdate					= DateUtils.convertDate(sdate,"DMYHM","en",locale);
			MAX_TRN_DATE_TIME		= DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
			if(bl_operational.equals("Y"))
			{
				if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"'");

				if(patient_class.equals("IP"))
				{
					sqlQuery.append(" and b.EPISODE_TYPE = 'I' ");
				}
				else if(patient_class.equals("DC"))
				{
					sqlQuery.append(" and b.EPISODE_TYPE = 'D' ");
				}

				stmt = con.createStatement();
				rset = stmt.executeQuery(sqlQuery.toString());

				while(rset.next())
				{
					billing_group_id	= checkForNull(rset.getString("BLNG_GRP_ID"));
					billing_group_desc	= checkForNull(rset.getString("SHORT_DESC"));
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
			}	
			/*Saturday, May 08, 2010 modified for PE*/
			//Added by kishore on 9/24/2004 for check newborn function
			/*
			int mother_status=0;
			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select count(*) m_status from ip_nursing_unit_bed where  occupying_patient_id is not null and facility_id = '"+facilityId+"' and  nursing_unit_code = '"+frnursingunitcode+"' and main_bed_no = '"+frbedno+"' ");
			stmt = con.createStatement(); 
			rset = stmt.executeQuery(sqlQuery.toString());
			if(rset != null)
			{
				if(rset.next())
				{
					mother_status = rset.getInt("m_status");
				}
				
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			//SQL For change_bed_class_yn value
			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = '"+facilityId+"' and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and  LOCN_CODE='"+frnursingunitcode+"'");
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlQuery.toString());

			if (rset != null && rset.next())
			 change_bed_class_yn = checkForNull(rset.getString("bed_class_change_yn"));
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			*/
		//Ended Here
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(MAX_TRN_DATE_TIME));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);
	if(req_count > 0)
	{	
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
	else
	{	
		if (tfr_req_count > 0)
		{	
            _bw.write(_wl_block11Bytes, _wl_block11);
	}	
	}	
            _bw.write(_wl_block12Bytes, _wl_block12);

		//if(install_yn.equals("N"))
		//{
            _bw.write(_wl_block13Bytes, _wl_block13);
//}
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(admissiondesc));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(d_converted));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(d_converted));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block27Bytes, _wl_block27);
            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

							
							if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
							//sqlQuery.append("select transfer_type_code,short_desc from IP_TRANSFER_TYPE_LANG_VW where language_id='"+locale+"'  and  eff_status = 'E' order by short_desc");
							/*Saturday, May 08, 2010 , modified for PE*/
							sqlQuery.append("select transfer_type_code,ip_get_desc.ip_transfer_type(transfer_type_code,?,2)short_desc from IP_TRANSFER_TYPE where eff_status = 'E' order by short_desc");
							pstmt = con.prepareStatement(sqlQuery.toString());
							pstmt.setString(1,locale);
							rset=pstmt.executeQuery();

							while(rset.next())
							{
								String desc = rset.getString("short_desc");
								String code = rset.getString("transfer_type_code");

								out.println("<option value=\""+code+"\" >"+desc );
							}
							if(rset!=null)rset.close();
							if(pstmt!=null)pstmt.close();
					
            _bw.write(_wl_block33Bytes, _wl_block33);

            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block36Bytes, _wl_block36);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("EMERGENCY_TRANSFER")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
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
                        )},{ weblogic.utils.StringUtils.valueOf("BED_BLOCK_PERIOD_MAX"), weblogic.utils.StringUtils.valueOf(BED_BLOCK_PERIOD_MAX
                        )},{ weblogic.utils.StringUtils.valueOf("max_blk_type"), weblogic.utils.StringUtils.valueOf(max_blk_type
                        )},{ weblogic.utils.StringUtils.valueOf("deact_pseudo_bed"), weblogic.utils.StringUtils.valueOf(deact_pseudo_bed
                        )},{ weblogic.utils.StringUtils.valueOf("ch_bed_class_param"), weblogic.utils.StringUtils.valueOf(ch_bed_class_param
                        )},{ weblogic.utils.StringUtils.valueOf("func_id"), weblogic.utils.StringUtils.valueOf(func_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(age));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(BED_BLOCK_PERIOD_MAX));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(req_count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(reserve_nurs_unit_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(reserve_room_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(reserve_bed_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(reserve_specialty_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reserve_practitioner_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reserve_bed_type_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(reserve_service_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(reserve_bed_class_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(func_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);

	if(install_yn.equals("Y"))
	{
	
            _bw.write(_wl_block75Bytes, _wl_block75);

	}
	
            _bw.write(_wl_block76Bytes, _wl_block76);
		
	}catch(Exception e){
		//out.print("Exception EmergencyTransfer :"+e);
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(stmt			!= null)   stmt.close();
			if(rset			!= null)   rset.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){
			//out.print("Error in while closing the connections:"+ee.toString());
			ee.printStackTrace();
			}
	}
 
            _bw.write(_wl_block77Bytes, _wl_block77);
            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EmergencyTransfer.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

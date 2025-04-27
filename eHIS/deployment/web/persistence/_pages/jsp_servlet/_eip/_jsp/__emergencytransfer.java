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

public final class __emergencytransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/EmergencyTransfer.jsp", 1742378864014L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tChitra \n\tCreated on \t:\t13/07/2001\n\tModule\t\t:\tip\n-->\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../js/EmergencyTransfer.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<script>\n\nfunction validateBackDate(tfrDate)\n{\n\tvar max_trn_date_time = document.forms[0].max_trn_date_time.value;\n\tif (tfrDate.value != \"\"  || tfrDate.value != \'\')\n\t{\n\t\tif(!validDateObj(tfrDate,\"DMYHM\",localeName))\n\t\t{\n\t\t\treturn ;\n\t\t}\n\t\tvar greg_tfrDateTime = convertDate(tfrDate.value,\'DMYHM\',localeName,\'en\');\n\t\tvar greg_maxtfrDateTime = convertDate(max_trn_date_time,\'DMYHM\',localeName,\'en\');\n\n\t\tif(!isBefore(document.forms[0].admission_date.value,greg_tfrDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t/* 17956 Thursday, January 07, 2010*/\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\')+\"/\"+getLabel(\"Common.time.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\'Common\'));\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}\n\t\t//else if(isBefore(document.forms[0].sdate.value,greg_tfrDateTime,\'DMYHM\',\'en\'))\n\t\t/* 17956 Thursday, January 07, 2010*/\n\t\telse if(!isBeforeNow(greg_tfrDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_GT_DATE2\',\'IP\');\n\t\t\t/* 17956 Thursday, January 07, 2010*/\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\')+\"/\"+getLabel(\"Common.time.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.SystemDateTime.label\",\'Common\'));\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}//modified for 12/15/2008 6021  MF-SCF-0051\n\t\telse if(!isBefore(greg_maxtfrDateTime,convertDate(document.forms[0].transfer_date.value,\'DMYHM\',localeName,\'en\'),\'DMYHM\',\'en\')){\n\t\t\t\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t//var last_encounter = getLabel(\"Common.Last.label\",\"Common\")+\" \"+getLabel(\"Common.encounterdate.label\",\"Common\");\n\t\t\t/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/\n\t\t\tvar last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\"ip_labels\");\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.transferdate.label\",\'Common\')+\"/\"+getLabel(\"Common.time.label\",\'Common\'));\n\t\t\terror = error.replace(\'#\',last_encounter);\n\t\t\talert(error);\n\t\t\ttfrDate.select();\n\t\t}//\n\t}\n}\n\nfunction checkform()\n{\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\tvar error\t= getMessage(\'ONLY_ONE_REQ_BKG\',\'IP\');\n\t\terror\t\t= error.replace(\'$\',getLabel(\"eIP.RequestTransfer.label\",\'IP\'));\n\t\talert(error);\t\n\t\twindow.close();\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\tvar error = getMessage(\'ONLY_ONE_REQ_BKG\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"eIP.RequestTransfer.label\",\'IP\'));\n\t\t\talert(error);\t\n\t\t\twindow.close();\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\tvar mother_status = document.forms[0].mother_status.value;\n\tvar transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035\t\n\tif (mother_status != \'0\' ) \n\t{\n\t\tif(transfer_wo_delink_yn==\'N\'){\n\t\t\tif(confirm(getMessage(\'DELINK_BABY_YN\',\'IP\')))\n\t\t\t{\n\t\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n\t\t\t\twindow.close();\n\t\t\t}\n\t\t}else{\n\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t}\n\t}\n\telse\n\t\tdocument.forms[0].mother_bed_status.value=\'N\';\n}\n</script>\n</head>\n\n\n<body onload=\'checkform();focusFirst();setDesable_tfrDtls();getOnload_tfrDtls();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<form name=\"EmergencyTransfer_form\" id=\"EmergencyTransfer_form\"  method=\"post\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" action=\"../../servlet/eIP.ModifyServiceServlet\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" action=\"../../servlet/eIP.EmergencyTransferServlet\"  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="target=\"parent.frames[1]\">\n\t<table border=0 width=\"100%\" cellpadding=2 cellspacing=0>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<!-- <br><br><br> -->\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<!-- <tr><td class=\'BLANKROW1PT\' colspan=4></td></tr> -->\n\t\t<tr><!-- 17956 Thursday, January 07, 2010 -->\n\t\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t <td  class=\'querydata\' width=\'24%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td  class=\"label\" width=\'24%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td  class=\'querydata\' width=\'28%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td> \n\t\t</tr>\n\t\t<tr><!-- 17956 Thursday, January 07, 2010 -->\n\t\t\t<td  class=\"label\" width=\'23%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\n\t\t\t<!-- <td class=\'querydata\' width=\'24%\' ><input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td> -->\n\n\t\t<td class=\'fields\'><input type=text name=\'transfer_date\' id=\'transfer_date\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\'transfer_date_id\' maxlength=\"16\" size=\"16\" onBlur=\"validateBackDate(this);\" onKeyPress=\'return(ChkNumberInput(this,event,2));\'  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'ondate1\'  onClick=\"document.forms[0].transfer_date.select();return showCalendar(\'transfer_date_id\',null,\'hh:mm\');\" />\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</td>\n\t\t\t<td  class=\"label\" width=\'26%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td  width=\'28%\'>\n\t\t\t\t<select name=\"transfer_type\" id=\"transfer_type\" onChange=\"getBlockBedDate();\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n\t\t\t\t\t<option value=\"\">----";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="----\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<input type=\"hidden\" name=\"transfer_type_code\" id=\"transfer_type_code\"  value=\"\">\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\n\t<table border=0 width=\"100%\" cellpadding=2 cellspacing=0>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<tr><td colspan=4></td></tr>\n\t\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t</tr>\n\t\t</table>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<!--\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t\n\t\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<tr><td><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onclick=\"ComputeBlDtl();\"><td></tr> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t</table>-->\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t</tr>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'><INPUT TYPE=\"checkbox\" name=\"reserved_bed_yn\" id=\"reserved_bed_yn\" onClick=\"setReserveBedDtls();\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" disabled";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="><input type=\"hidden\" name=\"is_reserved_bed_checked\" id=\"is_reserved_bed_checked\"  value=\"N\" ></TD>\n\t</TR>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'>\n\t<select name=\'reason_for_reserved_bed\' id=\'reason_for_reserved_bed\' ><option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;-----</option>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'reserved_bed_img\' style=\'visibility:hidden\'></img >\n\t</TD>\n\t</TR>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t <tr>\n\t\t<td class=\'label\' width=\'25%\'></td>\n\t\t<td align=\'right\' colspan=\'3\'>\n\t\t<input type=\"button\" class=\"button\" name=\"transfer\" id=\"transfer\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" onclick=\"submitForm_em();\"><input type=\"button\" class=\"button\"  value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onclick=\"cancel();\"></td>\n\t</tr>\n\t\n\t</table>\t\n\t\t<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start -->\n\t\t<input type = \'hidden\' name = \'bl_adm_remarks\' id = \'bl_adm_remarks\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_request\' id = \'bl_bed_request\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_type_code\' id = \'bl_bed_type_code\' value=\"\">\n\t\t<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End -->\n\t\t\t\n\t\t<input type=\"hidden\" name=\"sdate\" id=\"sdate\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"hidden\" name=\"max_trn_date_time\" id=\"max_trn_date_time\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id1\" id=\"encounter_id1\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\"hidden\" name=\"fr_bed_type1\" id=\"fr_bed_type1\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type=\"hidden\" name=\"tobedtype\" id=\"tobedtype\" value=\"\">\n\t\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"open_enctr_gender\" id=\"open_enctr_gender\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n \t\t<input type=\"hidden\" name=\"open_enctr_age\" id=\"open_enctr_age\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"> \n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"Transfer_Patient\">\t\n\t\t<input type=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t<input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" value=\"\">\n\t\t<input type=\'hidden\' name = \'bl_operational\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\"hidden\" name=\"def_max_period\" id=\"def_max_period\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\n\t\t<input type=\"hidden\" name=\"change_bed_class_yn\" id=\"change_bed_class_yn\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\"hidden\" name=\"entitlement_by_pat_cat_yn\" id=\"entitlement_by_pat_cat_yn\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<input type=\"hidden\" name=\"counter\" id=\"counter\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t<input type=\"hidden\" name=\"transfer_wo_delink_yn\" id=\"transfer_wo_delink_yn\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><!-- Added for the CRF - HSA-CRF-0035 -->\n\t\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"\">\n\t\t<input type=\"hidden\" name=\"override_yn\" id=\"override_yn\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"bed_class_chk\" id=\"bed_class_chk\" value=\"Y\">\n\t\t<input type=\"hidden\" name=\"reserve_nurs_unit_code\" id=\"reserve_nurs_unit_code\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_room_no\" id=\"reserve_room_no\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_no\" id=\"reserve_bed_no\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_specialty_code\" id=\"reserve_specialty_code\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_practitioner_id\" id=\"reserve_practitioner_id\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_type_code\" id=\"reserve_bed_type_code\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_service_code\" id=\"reserve_service_code\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_class_code\" id=\"reserve_bed_class_code\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\" name=\"confirm_yn\" id=\"confirm_yn\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"remove_bed\" id=\"remove_bed\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"is_to_bed_equals_reserve_bed\" id=\"is_to_bed_equals_reserve_bed\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"reserve_bed_on_tfr_yn\" id=\"reserve_bed_on_tfr_yn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\" name=\"func_id\" id=\"func_id\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\" name=\"year\" id=\"year\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\" name=\"retain_res_bed\" id=\"retain_res_bed\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"exp_discharge_date_time\" id=\"exp_discharge_date_time\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"pseudo_bed\" id=\"pseudo_bed\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\" name=\"deact_pseudo_bed\" id=\"deact_pseudo_bed\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\" name=\"reserved_bed_cont\" id=\"reserved_bed_cont\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<!-- Added for the CRF HSA-CRF-0035 -- start-->\n\t\t<input type=\"hidden\" name=\"linked_baby_count\" id=\"linked_baby_count\" value=\"\">\n\t\t<input type=\"hidden\" name=\"available_baby_beds\" id=\"available_baby_beds\" value=\"\">\n\t\t<!-- Added for the CRF HSA-CRF-0035 -- End-->\n\t\t<input type=\"hidden\" name=\"reqRadioBtn\" id=\"reqRadioBtn\" value=\"\"><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->\n\n\t\t\n\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t<input type=\'hidden\' name=\'transfer_chargeable_yn\' id=\'transfer_chargeable_yn\' value=\'Y\'>\n\t\t<input type=\'hidden\' name=\'transfer_serv_charge\' id=\'transfer_serv_charge\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'surgery_reqd_yn\' id=\'surgery_reqd_yn\' value=\'Y\' >\n\t\t<input type=\'hidden\' name=\'addnl_dep_amt\' id=\'addnl_dep_amt\' value=\'\'>\n\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\n<script>\n\t\tdocument.forms[0].nursing_unit.value=document.forms[0].fr_nursing_unit_code.value;\n\t\tdocument.forms[0].practid.value=document.forms[0].fr_practitioner_id.value;\n\t\tdocument.forms[0].Splcode.value=document.forms[0].fr_speciality_code.value;\n\t\tvar count=0\n\t\t\tif(count==0)\n\t\t\t{\n\t\t\t\tpopDynamicValues_em(document.forms[0].nursing_unit);\n\t\t\t\tcount++;\n\t\t\t}\n\n</script>\n\t</form>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t \n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );
	
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
	String locale				= "";
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String bl_operational		= "";
	String loginUser			= "";
	String facilityId			= "";
	bl_operational				= (String)session.getValue("bl_operational");
	loginUser					= (String)session.getValue("login_user");
	facilityId					= (String)session.getValue("facility_id");
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
	String reserve_specialty_code	= "";
	String reserve_practitioner_id  = "";
	String reserve_bed_type_code	= "";
	String reserve_service_code		= "";
	String reserve_bed_class_code	= "";
	int BED_BLOCK_PERIOD_MAX	= 0;
	//String BED_BLOCK_PERIOD_MAX	="";
	int req_count				= 0;
	int tfr_req_count			= 0;
	int mother_status			= 0;
	int reserved_bed_cont		= 0;
	String admissiondate_converted = "";
	String d_converted			= "";

	String isreadonly			= "";
	String isenable				= "";
	String exp_discharge_date_time	    = "";
	String pseudo_bed_yn	    = "";
	String func_id				= "";
	String patientid			= "";
	String req_count_str		= "";
	String tfr_req_count_str	= "";
	String p_oper_stn_id		= "";
	String eid					= "";
	String d					= "";
	String min					= "";
	String admissiontype		= "";

	String change_bed_class_yn		= "";

	String entitlement_by_pat_cat_yn		= "";
	java.text.SimpleDateFormat dateFormat	= null ;
	java.util.Date dt						= null ;

	locale						= (String)session.getAttribute("LOCALE");
	try
	{
		func_id					= checkForNull(request.getParameter("func_id"));
		
		if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
			isreadonly			= "ReadOnly";
			isenable			= "Disabled";
		}
		
		patientid				= checkForNull(request.getParameter("patient_id"));

		req_count_str			= checkForNull(request.getParameter("bed_class_req_cnt"));
		if(!req_count_str.equals(""))
			req_count			= Integer.parseInt(req_count_str);
		tfr_req_count_str		= checkForNull(request.getParameter("trans_req_cnt"));
		if(!tfr_req_count_str.equals(""))
			tfr_req_count		= Integer.parseInt(tfr_req_count_str);
	
		String sdate				= "";
		String install_yn			= "";
		String bedBlock_normal		= "";
		String max_blk_type			= "";
		String deact_pseudo_bed		= "";
		String ch_bed_class_param	= "";
		String reserve_bed_on_tfr_yn= "";
		String res_reserve_bed_intraward_yn= "";//Mahesh
		String transfer_wo_delink_yn= "";//Added for the CRF - HSA-CRF-0035
		String bed_blk_period_max	= "";
		String MAX_TRN_DATE_TIME    = "";
		String year					= "";
		p_oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
		eid							= checkForNull(request.getParameter("encounter_id"));
		long    encounterid			= Long.parseLong(eid);
		
		install_yn					= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
		bedBlock_normal				= checkForNull(request.getParameter("bed_block_period_normal"));
		bed_blk_period_max			= checkForNull(request.getParameter("bed_block_period_max"));
		BED_BLOCK_PERIOD_MAX		= Integer.parseInt(bed_blk_period_max);
		max_blk_type				= checkForNull(request.getParameter("bed_block_period_max_type"));
		if(max_blk_type.equals("D"))
				BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;
		deact_pseudo_bed			= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
		ch_bed_class_param			= checkForNull(request.getParameter("change_bed_class_yn"),"N");
		reserve_bed_on_tfr_yn		= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
		res_reserve_bed_intraward_yn		= checkForNull(request.getParameter("res_reserve_bed_intraward_yn"),"N");//Mahesh
		//Added for the CRF - HSA- CRF-0035 -- Begin
		transfer_wo_delink_yn		= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");
		if(transfer_wo_delink_yn.equals(""))
			transfer_wo_delink_yn="N";
		//Added for the CRF - HSA- CRF-0035 -- End
		session.putValue("patientid",patientid);
		session.putValue("encounter_id",eid);
		con							= ConnectionManager.getConnection(request);
		stmt						= con.createStatement();	
		/*Thursday, April 29, 2010 , commented for PE getting data from InpatientLookupQueryResult.jsp*/
		/*
		sqlQuery.append(" select nvl(bl_interfaced_yn,'N') bl_interfaced_yn, bed_block_period_max, bed_block_period_max_type, bed_block_period_normal, deactivate_pseudo_bed_yn, change_bed_class_yn, reserve_bed_on_tfr_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate  from IP_PARAM where facility_id = '"+facilityId+"' ");
		
		try
		{
			rset	=stmt.executeQuery(sqlQuery.toString());
			if(rset.next())
			{
				
				sdate					= rset.getString("sdate");
				install_yn				= rset.getString("bl_interfaced_yn");
				bedBlock_normal			= rset.getString("bed_block_period_normal");
				BED_BLOCK_PERIOD_MAX	= rset.getInt("BED_BLOCK_PERIOD_MAX");
				max_blk_type			= rset.getString("BED_BLOCK_PERIOD_MAX_TYPE");
				deact_pseudo_bed		= rset.getString("deactivate_pseudo_bed_yn");
				ch_bed_class_param		= rset.getString("CHANGE_BED_CLASS_YN");

				reserve_bed_on_tfr_yn	= rset.getString("reserve_bed_on_tfr_yn");
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
			out.println("Exception @try1"+e.toString());
			e.printStackTrace();
		}
		/*Thursday, April 29, 2010 , commendted for PE , merged with main query*/
		/*modified for 12/15/2008 6021  MF-SCF-0051
		try{
		
		String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi'), to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+eid+"'";
		rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
					sdate			= rset.getString(2);
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			
		}
		catch(Exception ex){
			out.println("Exception"+ex);
			ex.printStackTrace();
				}

MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
*/


		

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	if(req_count > 0)
	{	
            _bw.write(_wl_block8Bytes, _wl_block8);
	}
	else
	{	
		if (tfr_req_count > 0)
		{	
            _bw.write(_wl_block9Bytes, _wl_block9);
	}	
	}	
            _bw.write(_wl_block10Bytes, _wl_block10);

			
			dateFormat								= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			dt										= new java.util.Date();
			d										= dateFormat.format( dt ) ;
			min										= String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			if(!(d==null || d.equals("")))
				d_converted = DateUtils.convertDate(d,"DMYHM","en",locale);
			
			/* Commented and merged with below query for PE - 11/05/2010
			if(reserve_bed_on_tfr_yn.equals("Y"))
			{
				if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append(" SELECT " );
				sqlQuery.append(" a.RESERVED_NURS_UNIT_CODE ");
				sqlQuery.append(" ,a.RESERVED_ROOM_NO ");
				sqlQuery.append(" ,a.RESERVED_BED_NO ");
				sqlQuery.append(" ,a.SPECIALTY_CODE ");
				sqlQuery.append(" ,a.ADMIT_PRACTITIONER_ID ");
				sqlQuery.append(" ,a.BED_TYPE_CODE ");
				sqlQuery.append(" ,a.SERVICE_CODE ");
				sqlQuery.append(" ,a.BED_CLASS_CODE ");
				sqlQuery.append(" FROM ");
				sqlQuery.append(" IP_OPEN_ENCOUNTER  a, ");
				sqlQuery.append(" IP_RESERVED_BED_DTL b ");
				sqlQuery.append(" WHERE a.facility_id = '"+facilityId+"' ");
				sqlQuery.append(" AND a.facility_id = b.facility_id ");
				sqlQuery.append(" AND a.encounter_id = '"+encounterid+"' ");
				sqlQuery.append(" AND a.encounter_id = b.encounter_id ");
				sqlQuery.append(" AND a.RESERVED_NURS_UNIT_CODE = b.RESERVED_NURSING_UNIT_CODE ");
				sqlQuery.append(" AND a.RESERVED_BED_NO =  b.RESERVED_BED_NO ");
				sqlQuery.append(" AND b.RESERVED_TO_TIME IS null ");

				stmt = con.createStatement() ;
				rset = stmt.executeQuery(sqlQuery.toString()) ;
				if(rset != null && rset.next())
				{
					reserve_nurs_unit_code			= checkForNull(rset.getString("RESERVED_NURS_UNIT_CODE"));
					reserve_room_no					= checkForNull(rset.getString("RESERVED_ROOM_NO"));
					reserve_bed_no					= checkForNull(rset.getString("RESERVED_BED_NO"));
					reserve_specialty_code			= checkForNull(rset.getString("SPECIALTY_CODE"));
					reserve_practitioner_id			= checkForNull(rset.getString("ADMIT_PRACTITIONER_ID"));
					reserve_bed_type_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
					reserve_service_code			= checkForNull(rset.getString("SERVICE_CODE"));
					reserve_bed_class_code			= checkForNull(rset.getString("BED_CLASS_CODE"));
				}

				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();

			
			} */
	


			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());

		
			sqlQuery.append("SELECT" );
			sqlQuery.append("  TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date" );
			sqlQuery.append("  ,a.admission_type" );
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
			sqlQuery.append("  ,AM_GET_DESC.AM_SUBSERVICE(a.service_code, a.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
			sqlQuery.append("  , a.PATIENT_CLASS" );
			sqlQuery.append("  ,Am_Get_desc.AM_MEDICAL_TEAM(a.Facility_Id, a.Team_Id,'"+locale+"','2') TEAM_DESC" );
			sqlQuery.append("  ,a.TEAM_ID " );
			sqlQuery.append("  ,to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date " );
			sqlQuery.append("  ,to_char(a.exp_discharge_date_time,'dd/mm/rrrr hh24:MI') exp_discharge_date_time " );
			/*Thursday, April 29, 2010 added for PE*/
			sqlQuery.append("  ,(select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = a.facility_id and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and  LOCN_CODE=a.nursing_unit_code and locn_type = 'N') bed_class_change_yn " );
			sqlQuery.append("  ,(select count(*) m_status from ip_nursing_unit_bed where  occupying_patient_id is not null and facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and main_bed_no = a.bed_num) m_status " );
			/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
			sqlQuery.append("  ,(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn " );
			sqlQuery.append("  ,to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate " );
			sqlQuery.append("  ,(SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') FROM IP_ADT_TRN WHERE FACILITY_ID = a.facility_id AND ENCOUNTER_ID = a.encounter_id) TRN_DATE_TIME " );
			sqlQuery.append("  ,(select entitlement_by_pat_cat_yn from MP_PARAM where module_id = 'MP')entitlement_by_pat_cat_yn " );
			sqlQuery.append("  ,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year " );
			if(reserve_bed_on_tfr_yn.equals("Y"))
			{
				sqlQuery.append(" ,a.RESERVED_NURS_UNIT_CODE ");
				sqlQuery.append(" ,a.RESERVED_ROOM_NO ");
				sqlQuery.append(" ,a.RESERVED_BED_NO ");
				sqlQuery.append(" ,a.SPECIALTY_CODE ");
				sqlQuery.append(" ,a.ADMIT_PRACTITIONER_ID ");
				sqlQuery.append(" ,a.BED_TYPE_CODE ");
				sqlQuery.append(" ,a.SERVICE_CODE ");
				sqlQuery.append(" ,a.BED_CLASS_CODE ");
				/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
				sqlQuery.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			}	
			sqlQuery.append("FROM" );
			sqlQuery.append("  IP_OPEN_ENCOUNTER a, mp_patient b " );
			if(reserve_bed_on_tfr_yn.equals("Y")){
				sqlQuery.append("  , IP_RESERVED_BED_DTL c " );
			}
			sqlQuery.append("WHERE a.facility_id = '"+facilityId+"' " );
			sqlQuery.append("  AND a.encounter_id = '"+encounterid+"' and a.patient_id = b.patient_id" );
			if(reserve_bed_on_tfr_yn.equals("Y")){
				sqlQuery.append(" AND a.facility_id = c.facility_id(+) ");
				sqlQuery.append(" AND a.encounter_id = c.encounter_id(+) ");
				sqlQuery.append(" AND a.RESERVED_NURS_UNIT_CODE = c.RESERVED_NURSING_UNIT_CODE(+) ");
				sqlQuery.append(" AND a.RESERVED_BED_NO =  c.RESERVED_BED_NO(+) ");
				sqlQuery.append(" AND c.RESERVED_TO_TIME(+) IS null ");
			}
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
				change_bed_class_yn = checkForNull(rset.getString("bed_class_change_yn"),"N");
				mother_status		= rset.getInt("m_status");
				MAX_TRN_DATE_TIME	= rset.getString("TRN_DATE_TIME");
				entitlement_by_pat_cat_yn = checkForNull(rset.getString("entitlement_by_pat_cat_yn"),"N");
				year				= checkForNull(rset.getString("year"));
				sdate				= rset.getString("sdate");
				exp_discharge_date_time     = checkForNull(rset.getString("exp_discharge_date_time"));
				pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
				if(reserve_bed_on_tfr_yn.equals("Y")){
					reserve_nurs_unit_code			= checkForNull(rset.getString("RESERVED_NURS_UNIT_CODE"));
					reserve_room_no					= checkForNull(rset.getString("RESERVED_ROOM_NO"));
					reserve_bed_no					= checkForNull(rset.getString("RESERVED_BED_NO"));
					reserve_specialty_code			= checkForNull(rset.getString("SPECIALTY_CODE"));
					reserve_practitioner_id			= checkForNull(rset.getString("ADMIT_PRACTITIONER_ID"));
					reserve_bed_type_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
					reserve_service_code			= checkForNull(rset.getString("SERVICE_CODE"));
					reserve_bed_class_code			= checkForNull(rset.getString("BED_CLASS_CODE"));
					reserved_bed_cont				= rset.getInt("reserved_bed_cont");
				}			
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
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
			/*Thursday, April 29, 2010 , commented for PE merged in main query*/
			/*
			if(gender.equals("F"))
			{
				//Added by kishore on 9/24/2004 for check newborn function
				
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
			}
		
		//SQL For change_bed_class_yn value
			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = '"+facilityId+"' and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and  LOCN_CODE='"+frnursingunitcode+"'");
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlQuery.toString());

			if (rset != null && rset.next())
			 change_bed_class_yn = checkForNull(rset.getString("bed_class_change_yn"));
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		//Ended Here
		*/
	

            _bw.write(_wl_block11Bytes, _wl_block11);
 if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

		//if(install_yn.equals("N"))
		//{
            _bw.write(_wl_block15Bytes, _wl_block15);
//}
	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(admissiondesc));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(d));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(d_converted));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(d_converted));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
		
            _bw.write(_wl_block30Bytes, _wl_block30);

			}
		
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

							
							if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
							//sqlQuery.append("select a.short_desc, a.transfer_type_code||'='|| a.blocking_type_code || '=' ||b.short_desc ||'='|| decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)   ||'='|| to_char(sysdate+(decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)/24), 'dd/mm/rrrr hh24:mi') || '='||b.DFLT_BLOCK_UNITS||'='|| override_yn ||'='||('"+bedBlock_normal+"') default_block_period from ip_transfer_type_lang_vw a, ip_blocking_type_lang_vw b where a.language_id='"+locale+"' and a.language_id=b.language_id(+) and a.blocking_type_code=b.BLOCKING_TYPE_CODE(+)  AND A.EFF_STATUS ='E' ORDER BY 1");
							/*Thursday, April 29, 2010 , modified for PE*/
							sqlQuery.append("select ip_get_desc.ip_transfer_type (a.transfer_type_code,?,2) short_desc, a.transfer_type_code||'='|| a.blocking_type_code || '=' || ip_get_desc.IP_BLOCKING_TYPE(b.blocking_type_code,?,'2') ||'='|| decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)   ||'='|| to_char(sysdate+(decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)/24), 'dd/mm/rrrr hh24:mi') || '='||b.DFLT_BLOCK_UNITS||'='|| override_yn ||'='||(?) default_block_period from ip_transfer_type a, ip_blocking_type b where a.blocking_type_code=b.BLOCKING_TYPE_CODE(+)   and a.TRANSFER_TYPE_CODE like '%%' and A.EFF_STATUS ='E' ORDER BY 1");

							pstmt = con.prepareStatement(sqlQuery.toString());
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);
							pstmt.setString(3,bedBlock_normal);
							rset=pstmt.executeQuery();

							String desc		= "";
							String code		= "";
							while(rset.next())
							{
								desc		= rset.getString("short_desc");
								code		= rset.getString("DEFAULT_BLOCK_PERIOD");

								out.println("<option value=\""+code+"\" >"+desc );
							}
							if(rset!=null)rset.close();
							if(pstmt!=null)pstmt.close();
					
            _bw.write(_wl_block35Bytes, _wl_block35);

            _bw.write(_wl_block36Bytes, _wl_block36);

						if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
						{
				
            _bw.write(_wl_block37Bytes, _wl_block37);

						}
				
            _bw.write(_wl_block38Bytes, _wl_block38);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("Transfer_patient")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
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
            }_bw.write(_wl_block41Bytes, _wl_block41);

		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            {java.lang.String __page ="../../eIP/jsp/BlockingDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("tfr_patient")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block45Bytes, _wl_block45);
 if(install_yn.equals("Y")) {
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
 if(reserve_bed_on_tfr_yn.equals("Y")) {
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
if(res_reserve_bed_intraward_yn.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

		/*try{
			
			if(sqlQuery.length() > 0 ) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append(" SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,?,'2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.ADDED_FACILITY_ID =? AND a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ");
			
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityId);
			rset = pstmt.executeQuery();
			if( rset != null )
				{
				  while( rset.next() )
				  {
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();}*/
		
	
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
	
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT")) {
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(MAX_TRN_DATE_TIME));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(age));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(BED_BLOCK_PERIOD_MAX));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(req_count));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(reserve_nurs_unit_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(reserve_room_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(reserve_bed_no));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(reserve_specialty_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(reserve_practitioner_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(reserve_bed_type_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(reserve_service_code));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(reserve_bed_class_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(func_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(year));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(deact_pseudo_bed));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(reserved_bed_cont));
            _bw.write(_wl_block99Bytes, _wl_block99);

	if(install_yn.equals("Y"))
	{
	
            _bw.write(_wl_block100Bytes, _wl_block100);

	}
	
            _bw.write(_wl_block101Bytes, _wl_block101);
		
	}catch(Exception e){
		out.print("Exception EmergencyTransfer :"+e.toString());
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(stmt			!= null)   stmt.close();
			if(rset			!= null)   rset.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){out.print("Error in while closing the connections:"+ee.toString());}
	}
 
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block103Bytes, _wl_block103);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transferdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedBlockDetails.label", java.lang.String .class,"key"));
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

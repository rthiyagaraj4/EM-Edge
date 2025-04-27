package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.util.regex.*;
import java.util.*;
import com.ehis.util.*;

public final class __at_intraanaesheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_IntraAnaesHeader.jsp", 1709120152000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="                    \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\"RecordAnesthesiaHdrForm\" id=\"RecordAnesthesiaHdrForm\" >\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" disabled>\n<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" size=\'30\'  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" disabled> \n<input type=\"hidden\"  name=\"sex\" id=\"sex\" size=\'2\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" disabled>\n<input type=\"hidden\"  name=\"dob\" id=\"dob\" size=\'10\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" disabled>\n<input type=\"hidden\"  name=\"surgeon_name\" id=\"surgeon_name\" size=\'27\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" disabled>\n<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" colspan=\"2\" size=\'8\'  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" disabled>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' size=\'13\' value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" disabled>\n<input type=\'hidden\' name=\'patient_class_desc\' id=\'patient_class_desc\' size=\'15\' value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" disabled>\n<tr>\n\t<td  class=\'Label\' width=\"25%\">\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n\t\n\t<td  class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\" name=\"anaes_srl_no\" id=\"anaes_srl_no\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" disabled>\n\t</td>\n\t<td  class=\'Label\' width=\"25%\" >\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n\t<td  class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\"  name=\"source_id\" id=\"source_id\" size=\'17\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" disabled>\t\n\t</td>\n</tr>\n\n<tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<td  class=\'Label\' width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\"  name=\"accession_num\" id=\"accession_num\" size=\'18\' value=\"\" disabled><!-- AAKH-SCF-221 -->\n\t\t<input type=\"button\" class=\"button\" name=\"generic_search\" id=\"generic_search\" value=\"?\" onclick=\"callAccessionNum(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<td  class=\'Label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\"  name=\"accession_num\" id=\"accession_num\" size=\'18\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" disabled><!-- AAKH-SCF-221 -->\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<td  class=\'Label\' width=\"25%\" >\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\"  name=\"accession_num\" id=\"accession_num\" size=\'18\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" disabled><!-- AAKH-SCF-221 -->\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n<td  class=\'Label\' width=\"25%\"  >\n</td>\n\t<td class=\'fields\' width=\"25%\" >\n\t</td> \n</tr>\n\n<tr>\n\t<td  class=\'Label\' width=\"25%\" >\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</td>\n\t\n\t<td class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\" name=\"weight\" id=\"weight\" size=\'4\'  maxlength=\'6\'  onKeyPress=\"return allowValidNumber(this,event,\'3\',\'2\');\" onBlur=\"if(this.value!=\'\'){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\n\t\t(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\n\t</td>\n\t<td class=\'Label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\" name=\"height\" id=\"height\" size=\'4\' maxlength=\'6\'   onKeyPress=\"return allowValidNumber(this,event,\'3\',\'2\');\"  onBlur=\"if(this.value!=\'\'){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}\"  value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\n\t</td>\n</tr>  \n\n<tr>\t\n\t<td class=\'Label\' width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n\t</td>\n\t<td class=\'fields\' width=\"25%\" >\n\t<!--Condition Added for IN024805 -->\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<input type=\"text\"  name=\"bsaDisp\" id=\"bsaDisp\" size=\'5\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" disabled>\n\t\t<input type=\"hidden\"  name=\"bsa\" id=\"bsa\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<input type=\"hidden\"  name=\"bsa\" id=\"bsa\" size=\'5\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t<input type=\"text\"  name=\"bsaDisp\" id=\"bsaDisp\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" disabled>\n\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</td>\n\t<td  class=\'Label\' width=\"25%\"  >\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\" colspan=\'4\'>\n\t\t<input type=\"text\"  name=\"bmi\" id=\"bmi\"  size=\'5\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" disabled>\n\t\t<input type=\"text\"  name=\"status_desc\" id=\"status_desc\" size=\'18\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" disabled>\n\t</td>\n</tr>  \n<table >\n <tr> <!-- start crf-0021 -->\n     <td class=\'Label\' width=\"25%\"  >\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\t</td>\n\t<td class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\"  name=\"asa\" id=\"asa\"  size=\'5\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" disabled>  \n\t</td>\t\n\t\t <!-- End crf-0021 -->\n\t\n\t<td align=\'right\' width=\"25%\">\n\t\t<a class=\'gridLink\' href=\"javascript:callIntraAnesthesiaNotes(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a> &nbsp;&nbsp;&nbsp;\n\t\t<a class=\'gridLink\' href=\"javascript:callPreAnaesNotes(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a>&nbsp;&nbsp;&nbsp;\n\t\t<a class=\'gridLink\' href=\"javascript:callRecordChart();\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a>\n\t</td>\n\t <td class=\'fields\' width=\"25%\" > \n\t\t<input type=\'hidden\' name=\"intraop_done_yn\" id=\"intraop_done_yn\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t</td>  \n\t\n<!-- <td width=\'20%\'></td> -->\n</tr>\n<!-- </table> -->\n</table>\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n<tr> \n\t<td align=\'left\' class=\'COLUMNHEADER\'>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</td>\n\t\n</tr> \n</table>\n\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\n<tr>\n\t<td  class=\'Label\' width=\"25%\"  >\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td class=\'Label\' width=\"25%\"  colspan=\"3\">\n\t\t<input type=\"hidden\"  name=\"anaesthesia_code\" id=\"anaesthesia_code\"  size=\'14\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t\t<input type=\"text\"  name=\"anaesthesia_desc\" id=\"anaesthesia_desc\" size=\'28\' onblur=\'if(this.value!=\"\")callAnaesthesia1(this);\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n\t\t<input type=\"button\" class=\"button\" name=\"generic_search\" id=\"generic_search\" value=\"?\" onclick=\"callAnaesthesia1(anaesthesia_desc);\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t</td>\n</tr>\n<tr>\n<td  class=\'Label\' width=\"25%\"  >\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n</td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<td class=\'fields\' width=\"25%\">\n\t<input type=\"text\"  name=\"start_date\" id=\"start_date\"  size=\'9\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' Onblur=\"isValidDate(this);\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" >\n\t<image src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'start_date\');\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >\n\t<!-- onBlur=\'checkDateFormat(this);\' Modified Onblur against SKR-SCF-1285 -->\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t<input type=\"text\"  name=\"start_time\" id=\"start_time\"  size=\'4\' maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' onBlur=\'chkTimeFormat(this)\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n</td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' Onblur=\"isValidDate(this);\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" >\n\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'start_date\');\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n\t<td  class=\'Label\' width=\"25%\"  >\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t</td>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t<td class=\'fields\' width=\"25%\">\t\t\n\t\t<input type=\"text\"  name=\"finish_date\" id=\"finish_date\"  size=\'9\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'finish_date\');\" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t<!-- onBlur=\'checkDateFormat(this);\' Modified Onblur against SKR-SCF-1285 -->\n\t\t<input type=\"text\"  name=\"finish_time\" id=\"finish_time\"  size=\'4\' maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'  onBlur=\'chkTimeFormat(this);\' ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" >\t\t\n\t</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\t\t<image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'finish_date\');\" ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" >\t\t\n</td>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</tr>\n</table>\n\t<input type=\'hidden\' name=\'intra_disable_flag\' id=\'intra_disable_flag\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t<input type=\'hidden\' name=\'anesthesia_srl_no\' id=\'anesthesia_srl_no\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t<input type=\'hidden\' name=\'chart_id\' id=\'chart_id\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<input type=\'hidden\' name=\'current_date\' id=\'current_date\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t<input type=\'hidden\' name=\'current_time\' id=\'current_time\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<input type=\'hidden\' name=\'current_date_time\' id=\'current_date_time\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t<input type=\'hidden\' name=\'str_acc_oper_num\' id=\'str_acc_oper_num\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t<input type=\'hidden\' name=\'strUser\' id=\'strUser\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t<input type=\'hidden\' name=\'isRecordAnes\' id=\'isRecordAnes\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'><!-- PMG2017-SS-CRF-0001-US003 -->\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

  java.util.Properties prop = null;
  prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
  String login_user	= prop.getProperty( "login_user" );
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strStatus="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",strAnaesthesiaCode="",strAnaesthesiaDesc="",strEndDateTime="",strStartDateTime="",strBMIDesc="",strEpisodeType="",strIntraopDoneYN="N",strIntraopDone_check="",intra_disable_flag="",accession_num="",current_date = "",current_time="",current_date_time	= "",asa_score_code = "";  // Added asa_score_code for crf -0021
    //Added by AnithaJ for IN024805 on 11/3/2010
  double bsaDisp = 0.0;

 String slate_user_id_disp = CommonBean.checkForNull(request.getParameter("slate_user_id")).toUpperCase();
  if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }
 String strUser="";
  Statement stmt1 = null ;
  ResultSet resultSet1     = null ;
  String strAccessionNum="";
  String[] arrStartDate = null;
  String[] arrEndDate =  null;
  int tot_rec=0;
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
  Statement stmt = null ;
  ResultSet resultSet			= null ;
  conn			= ConnectionManager.getConnection(request);	//Added Against Common-ICN-0031
	try{
		//conn			= ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
		stmt				= conn.createStatement() ;
		resultSet			= stmt.executeQuery(sql_curr_date);
		while(resultSet!=null && resultSet.next()){
			current_date = resultSet.getString("CUR_DATE");
			current_time = resultSet.getString("CUR_TIME");
			current_date_time = resultSet.getString("CURRENT_DATE_TIME");

	}
	
	String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,TO_CHAR(END_TIME,'DD/MM/YYYY HH24:MI') END_TIME1,TO_CHAR(START_TIME,'DD/MM/YYYY HH24:MI') START_TIME1,INTRAOP_DONE_YN INTRAOP_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1,ASA_SCORE_CODE ASA_SCORE_CODE1 FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";  //Added asa_score_code for crf -0021
	strAnesthesiaSrlNo=CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,strAnesthesiaSrlNo);
	rs=pstmt.executeQuery();
	if(rs.next()){
		strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
		strHeight=CommonBean.checkForNull(rs.getString("HEIGHT1"));
		strWeight=CommonBean.checkForNull(rs.getString("WEIGHT1"));
		strBSA=CommonBean.checkForNull(rs.getString("BSA1"));
		asa_score_code=CommonBean.checkForNull(rs.getString("ASA_SCORE_CODE1")); //crf-0021
	if(!strBSA.equals(""))
	{
		bsaDisp=Double.parseDouble(strBSA);
	}
		strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
		strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=CommonBean.checkForNull(rs.getString("STATUS1"));
		strAnaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
		strEndDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("END_TIME1"),"DMYHM","en",locale));
		strStartDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("START_TIME1"),"DMYHM","en",locale));
		strIntraopDoneYN=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
		strAccessionNum=CommonBean.checkForNull(rs.getString("ACCESSION_NUM1"));
		arrStartDate = strStartDateTime.split(" ");
		arrEndDate   =   strEndDateTime.split(" ");
	if(strIntraopDoneYN.equalsIgnoreCase(""))
		strIntraopDoneYN="N";

	if(strIntraopDoneYN.equalsIgnoreCase("Y"))
	{
		strIntraopDone_check="checked";
		intra_disable_flag="disabled";
	}
	else
		strIntraopDone_check="";
		sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();

	if(rs.next())
	{
		strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
		strEpisodeId=CommonBean.checkForNull(rs.getString("EPISODE_ID1"));
		strSourceType=CommonBean.checkForNull(rs.getString("SOURCE_TYPE1"));
		strSourceCode=CommonBean.checkForNull(rs.getString("SOURCE_CODE1"));
		strSurgeonCode=CommonBean.checkForNull(rs.getString("ORD_PRACT_ID1"));
		strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMY","en",locale));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		sql="SELECT PATIENT_NAME SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT  WHERE PATIENT_ID =?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		rs=pstmt.executeQuery();
	if(rs.next())
	{
		strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		strAge=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		strSex=CommonBean.checkForNull(rs.getString("SEX1"));
	}
		sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strPatientClass);
		rs=pstmt.executeQuery();

	if(rs.next())
	{
		strPatientClassDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	if(!strSourceType.equals(""))
	{
		if(strSourceType.equals("W")||strSourceType.equals("N"))
		{
			sql=  "SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID ='"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE ='"+strSourceCode+"' ";
			strReferralSource="Wards";
		}
		else if(strSourceType.equals("C"))
		{
		   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE='"+strSourceCode+"' ";
			strReferralSource="Clinics";
		}
		else if(strSourceType.equals("R"))
		{
		   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE='"+strSourceCode+"' ";
			strReferralSource="Referral";
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);

		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSurgeonCode);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
	sql="SELECT INTRA_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";
	pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		chartId=CommonBean.checkForNull(rs.getString("CHART_ID"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	if(strBMI.length()>0)
	{
		sql="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strBMI);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strBMIDesc=CommonBean.checkForNull(rs.getString("STATUS_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	if(!(strAnaesthesiaCode.equals("null")) && !(strAnaesthesiaCode.equals("")))
	{
		String sql_anaes="SELECT SHORT_DESC SHORT_DESC1  FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ANAESTHESIA_CODE=? ";

		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strAnaesthesiaCode);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strAnaesthesiaDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

		//String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM OT_POST_OPER_HDR WHERE ORDER_ID =? ";//Commented against 58903
		String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM ot_queue WHERE ORDER_ID =? ";//Added against 58903
		
		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{	tot_rec++;
			accession_num=CommonBean.checkForNull(rs.getString("OPER_NUM1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		//Added below qry to fetch func_role_id associated to slate user id on 1/19/2011 by Anitha for 25928
		pstmt=conn.prepareCall("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		pstmt.setString(1,slate_user_id_disp);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		if(rs.next()){
			strUser=CommonBean.checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	  }
}catch(Exception ee){
	ee.printStackTrace();
	//System.err.println("Exception in IntraAnaesHeader="+ee);
}finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
		if(stmt!=null) stmt.close();
		if(resultSet1!=null) resultSet1.close();
		if(stmt1!=null) stmt1.close();
		//if(conn!=null) ConnectionManager.returnConnection(conn,request);	//Commented Against Common-ICN-0031
	}catch(Exception es){
	es.printStackTrace();
	}
}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSurgeryDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strPatientClassDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strAnesthesiaSrlNo));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strSourceOrderId));
            _bw.write(_wl_block19Bytes, _wl_block19);

		if(strAccessionNum.equals("")){
		if(tot_rec>1){
	
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strSourceOrderId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
 } 
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strAccessionNum));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strWeight));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strHeight));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
if(!strBSA.equals("")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bsaDisp));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
	else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBMI));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strBMIDesc));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(asa_score_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strIntraopDoneYN));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strAnaesthesiaCode));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strAnaesthesiaDesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block60Bytes, _wl_block60);

//PMG2017-SS-CRF-0001-US003
try{
	//conn = ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
	boolean isRecordAnes = false;
	isRecordAnes = CommonBean.isSiteSpecific(conn,"OT","OT_RECORD_ANESTHESIA");
	if(!isRecordAnes){

            _bw.write(_wl_block61Bytes, _wl_block61);

	}
	//PMG2017-SS-CRF-0001-US003

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

if(!strStartDateTime.equals("")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrStartDate[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(arrStartDate[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block69Bytes, _wl_block69);
} else if(strStartDateTime.equals("")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strStartDateTime));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strStartDateTime));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block69Bytes, _wl_block69);
}else if(!strIntraopDoneYN.equals("Y") && (!strStartDateTime.equals(""))){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrStartDate[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(arrStartDate[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

	if(!strEndDateTime.equals("")){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(arrEndDate[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(arrEndDate[1]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block78Bytes, _wl_block78);
} else if(strEndDateTime.equals("")) {
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strEndDateTime));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strEndDateTime));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block78Bytes, _wl_block78);
} else if(!strIntraopDoneYN.equals("Y") && (!strEndDateTime.equals(""))) {
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(arrEndDate[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(arrEndDate[1]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strAnesthesiaSrlNo));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strStatus));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(current_time));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strAccessionNum));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(isRecordAnes));
            _bw.write(_wl_block96Bytes, _wl_block96);
}catch(Exception ee){
	ee.printStackTrace();
}finally{
if(conn!=null) ConnectionManager.returnConnection(conn,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesSerialNo.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SourceId.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessionNum.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessionNum.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessionNum.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cms.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BMIDetails.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsaScore.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.IntraAnaesthesia.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreAnaesthesiaDetails.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaParticulars.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthesia.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaStartTime.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaEndTime.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

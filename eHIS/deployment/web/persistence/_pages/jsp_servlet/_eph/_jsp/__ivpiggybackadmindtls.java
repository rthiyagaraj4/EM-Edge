package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivpiggybackadmindtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPiggyBackAdminDtls.jsp", 1732680172688L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n   ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script LANGUAGE=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/IVPiggyBack.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<form name=\"formIVPrescriptionAdminDetail\" id=\"formIVPrescriptionAdminDetail\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"12\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'15%\' class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td COLSPAN=2>&nbsp;\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<input type=\"text\" width=\'3%\' class=\"number\" size=\"2\" maxlength=\"9\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"INFUSION_VALUE\" onChange=\"CheckNum(this);allowValidNumber(this,event,6,2);calVolumeInfuseOver();\" onKeyPress=\"return allowValidNumber(this,event,6,2); \" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<input type=\"text\" width=\'3%\' class=\"number\" size=\"2\" maxlength=\"9\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"INFUSION_VALUE\" onChange=\"CheckNum(this);allowValidNumber(this,event,6,2);calInfuseOver();showAdminRate()\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" > <!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415 and allowValidNumber(this,event,3,0) to allowValidNumber(this,event,6,2) for SKR-SCF-1303-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<label align=\"left\"  width=\'19%\' class=\'label\' id=\'infusion_uom_display\'>&nbsp;&nbsp;&nbsp;&nbsp;</label>\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<select name=\"infusion_time\" id=\"infusion_time\" onChange=\"ChangeInfuseOverTime(this);calVolumeInfuseOver()\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<select name=\"infusion_time\" id=\"infusion_time\" onChange=\"ChangeInfuseOverTime(this);calInfuseOver()\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t\t\t\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t</select> &nbsp;&nbsp;\t\t\t\t\t\n\t\t\t\t\t    <A HREF onMouseOver=\"changeCursor(this);\" onClick=\"adminRate();\" style=\"visibility:hidden\" id=\'adminrate\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td width=\'15%\' class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td >\n\t\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<input type=\"text\"  width=\'3%\' class=\"number\" size=\'2\' maxlength=\"6\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"INFUSION_PERIOD_VALUE\"  onKeyPress=\"return allowValidNumber(this,event,3,0);\" tabindex=\'2\' onBlur=\"CheckNum(this);calVolumeInfuseRate();\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<input type=\"text\"  width=\'3%\' class=\"number\" size=\'2\' maxlength=\"6\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"INFUSION_PERIOD_VALUE\"  onKeyPress=\"return allowValidNumber(this,event,3,0);\" tabindex=\'2\' onBlur=\"CheckNum(this);calInfusionRate();showAdminRate()\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<b>:</b>\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<input type=\"text\"  width=\'3%\' class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE_MIN\" id=\"INFUSION_PERIOD_VALUE_MIN\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onChange=\"CheckNum(this);calVolumeInfuseRate();showAdminRate()\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<input type=\"text\"  width=\'3%\' class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE_MIN\" id=\"INFUSION_PERIOD_VALUE_MIN\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onChange=\"CheckNum(this);calInfusionRate();showAdminRate()\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t<!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415-->\n\t\t\t\t\t\t<label align=\"left\"  width=\'5%\'class=\'label\' <b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b></label>\n\t\t\t\t\t\t<label align=\"left\"  width=\'5%\'class=\'label\' id=\"infuse_over_str\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</label>\n\t\t\t\t\t</td>\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr NOWRAP> \n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t<td class=\"label\" COLSPAN=2><select name=\"FREQUENCY\" id=\"FREQUENCY\" onChange=\"freqChange(this); setSchedule(this.value);ExternalDosageCheck(\'\',\'admndtl\') ; validateFrequency() ; dosageCheck()\" <!-- Modified for IN:070451 added dosagecheck function  -->\n\n\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---</option> \n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t <option value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t   \t\n\t\t\t\t\t\t</select>&nbsp;<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sched_medn_yn\" id=\"sched_medn_yn\" value=\"N\">\n\t\t\t\t\t</td> \n\t\t\t\t\t<td class=\"label\" width=\'12%\' id=\"dosage_label\" colspan=\"\" nowrap>&nbsp;</td>\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td width=\'10%\' class=\'label\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<br><label style=\"visibility:visible\" id=\"\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->\t</td>\n\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<input type=\"text\" size=\"1\" maxlength=\"3\" name=\"DURN_VALUE\" id=\"DURN_VALUE\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  onChange=\"calEndDate();ExternalDosageCheck(\'\',\'admndtl\');validateFrequency()\" onKeyPress=\"return allowValidNumber(this,event,3,0)\" onchange=\"validateAllDates();ExternalDosageCheck(\'\',\'admndtl\');\" >&nbsp;\n\t\t\t\t\t\t<!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415-->\n\t\t\t\t\t\t<select name=\"durn_unit\" id=\"durn_unit\" onfocus = \"validateFrequency();\" onChange=\"validateAllDates();\">\n\t\t\t\t\t\t\t<option>-";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="-</option>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<option value=\'Y\' selected>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\t  \n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<option value=\'L\' selected>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<option value=\'W\' selected>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t<option value=\'D\' selected>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<option value=\'H\' selected>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t<option value=\'H\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t<option value=\'M\' selected>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t</select>\n\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"START_DATE\" id=\"START_DATE\"  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" size=\"14\" maxlength=\"16\" onBlur=\"chkBackFutureDate(this,\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');calEndDate()\"><IMG src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" id=Calendar onclick=\"showCalendar(\'START_DATE\',null,\'hh:mm\');document.formIVPrescriptionAdminDetail.START_DATE.focus(); return false;\" >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"END_DATE\" id=\"END_DATE\" value=\"\"  size=\"14\" maxlength=\"16\" tabindex=\'5\' readonly>&nbsp; \n\t\t\t\t\t</td> \n\t\t\t\t</tr>\n\n\t\t\t</table>\t\t\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"iv_bean_id\" id=\"iv_bean_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"iv_bean_name\" id=\"iv_bean_name\"\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"\t\t>\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"freq_changed_yn\" id=\"freq_changed_yn\" value=\"N\">\n\t\t\t<input type=\"hidden\" name=\"PRACT_ID\" id=\"PRACT_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"LOCN_CODE\" id=\"LOCN_CODE\"\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<!-- <input type=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\"\tvalue=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="> -->\n\t\t\t<input type=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\"\tvalue=\"H\">\n\t\t\t<input type=\"hidden\" name=\"INFUSION_UOM\" id=\"INFUSION_UOM\"\tvalue=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t\t<input type=\"hidden\" name=\"DURN_UNIT\" id=\"DURN_UNIT\"\t\tvalue=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="> <!-- changed from H to ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" for SRR20056-SCF-7374-->\n\t\t\t<input type=\"hidden\" name=\"STOCK_VALUE\" id=\"STOCK_VALUE\"\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"LOCN_TYPE\" id=\"LOCN_TYPE\"\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"EQVL_UOM_CODE\" id=\"EQVL_UOM_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"STOCK_UOM_CODE\" id=\"STOCK_UOM_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"mode1\" id=\"mode1\"\t        value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"repeat_value\" id=\"repeat_value\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\"\t    value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"infusion_over_insert_value\" id=\"infusion_over_insert_value\"\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"calcualted_durn_value\" id=\"calcualted_durn_value\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"interval_value\" id=\"interval_value\"\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"   \tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"repeat_durn_type\" id=\"repeat_durn_type\"value=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"scheduled_yn\" id=\"scheduled_yn\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"iv_calc_infuse_by\" id=\"iv_calc_infuse_by\" value=\"\" >\n            <input type=\"hidden\" name=\"default_comp_fluid_falg\" id=\"default_comp_fluid_falg\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" ><!-- Added for ML-MMOH-CRF-1223 -->\n\n\t\t\t<!-- <input type=\"hidden\" name=\"drugCodeFreq\" id=\"drugCodeFreq\"\tvalue=\"\"\t> -->\n\t\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\t\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<script>\t\t\t\t\n\t\t\t\tdocument.querySelectorAll(\'#infusion_uom_display\').innerHTML =\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="/\"; //stock_uom_code changed to stock_uom_desc for SKR-SCF-1076 [IN:054498]\n\t\t\t</script>\n\t\t</form>\n\t</body>\n\n\t <script>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\n//\t\tdocument.formIVPrescriptionAdminDetail.durn_unit.value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\';\n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t</script>   \n</html>\n<script language=\"javascript\">\n\tcalEndDate();\n\tshowAdminRate();\n\tvar str = getHrsMinStr(document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,document.formIVPrescriptionAdminDetail.infusion_time.value);\n\t\n//\tdocument.formIVPrescriptionAdminDetail.all.infuse_over_str.innerHTML\t= str;\n</script>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana												SKR-SCF-1276
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    /*aa*/
	Connection con			= null;//added for ml-mmoh-crf-1223
	try{
	String end_date_time		="";
	String infuse_over			="";
	String infusion_rate		="";
	String selected1            ="selected";
	String selected2            ="";
	String durn_value			="";
	String freq_value			="";
	String optSelected			="";
	String order_catalog_code	="";
	String order_catalog_code1  ="";
	String stock_uom_code		="", stock_uom_desc=""; //stock_uom_desc added for SKR-SCF-1076 [IN:054498]
	String stock_value			="";
	String optSelected1			="";
	int    durn_value1			=0; 
	int    J					=0; 
	String order_line_num       ="";
	String temp					="";
	String infusion_over_time	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	String durn_type1			="";
	String readonly				="";
	String disabled				="";
	String  repeat_value		="";
	String drug_code			="";
	String srl_no               ="";
	String infusion_uom			="H"; 
	String order_id				= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String patient_id			= request.getParameter("patient_id");
	String patient_class		= request.getParameter("act_patient_class");
	String encounter_id			= request.getParameter("encounter_id");
	String facility_id			= (String)session.getValue("facility_id");
	String 	answer				= request.getParameter("answer")==null?"":request.getParameter("answer");

	String bean_id			= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPiggyBackBean";
	ArrayList shedule_freq		= new ArrayList();
	IVPiggyBackBean bean	= (IVPiggyBackBean)getBeanObject( bean_id, bean_name , request) ;


	bean.setLanguageId(locale);
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-1223
	boolean default_comp_fluid_falg = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DEFAULT_COMP_FLUID_INF_OVER");// Added for ML-MMOH-CRF-1223
	HashMap   max_duration  =  bean.getMaxDuration();
	String op_max_duration  =  (String)max_duration.get("OP");
	String ip_max_duration  =  (String)max_duration.get("IP");
	String disp_str			=  "";
	int size = 0;
	if(patient_class!=null && patient_class.equals("IP")){
		size		=	Integer.parseInt(ip_max_duration);
	}
	else{
		size		=	Integer.parseInt(op_max_duration);
	}
	String sys_date				= request.getParameter("start_date");

	String timeFrame			= "";
	ArrayList orderSetValues	= new ArrayList();
		
	String iv_bean_id		= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
    iv_bean.setLanguageId(locale);

	String infuse_over_hr	= "";
	String infuse_over_mi	= "";
	String durn_type		= "";
	String durn_calc		= "";
	String freq_nature		= "";
	String freq_value_durn	= "";
	String interval_value	= "";
	String repeat_value_durn= "";
	String schedule_yn		= "";
	String repeat_durn_type	= "";
	String freq_durn_type	= "";
	String scheduled_yn		= "";
	String split_dose_yn	= "";
	String qty_value		= "";
	String freq_code		= "";
	String infusion_per_unit= "";//INO71514
	ArrayList tmp_freq_values = new ArrayList();
	float total_qty			= 0.0f;
	String final_qty		= "";
	boolean split_chk		=	false;
	String tooltiptable		= "";
	String adm_time			= "";
    HashMap record;
	HashMap record1;
	String param_volume_cal=iv_bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	//date is coming as thai. so it is converted to english to set the order date.13/07/2010
	if(!(order_type_flag.equals("Existing") && answer.equals("N"))) //If condition added for MO-GN-5407 IN31902	
	         iv_bean.setOrderDate(com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM",iv_bean.getLanguageId(),"en"));
	//end comment
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
		
		String bean_id1				    = "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name1				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1, bean_name1, request );
		
		ArrayList exstngIVorder         = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,""); //passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062

		record			=	new HashMap();
		int siz			=	exstngIVorder.size();
		String lengt=siz+"";
		if(lengt.equals("1")){
			record1		=	(HashMap)exstngIVorder.get(0);
			record		=	(HashMap)exstngIVorder.get(0);
		}
		else{
			record1		=	(HashMap)exstngIVorder.get(0);
			record		=	(HashMap)exstngIVorder.get(1);
		}


		freq_nature		= (String)record.get("FREQ_NATURE")==null?"":(String)record.get("FREQ_NATURE");
		freq_value		= (String)record.get("FREQ_VALUE")==null?"":(String)record.get("FREQ_VALUE");
		interval_value	= (String)record.get("INTERVAL_VALUE")==null?"":(String)record.get("INTERVAL_VALUE");
		repeat_value	= (String)record.get("REPEAT_VALUE")==null?"":(String)record.get("REPEAT_VALUE");
		schedule_yn		= (String)record.get("SCHEDULE_YN")==null?"":(String)record.get("SCHEDULE_YN");
		repeat_durn_type= (String)record.get("REPEAT_DURN_TYPE")==null?"":(String)record.get("REPEAT_DURN_TYPE");
		end_date_time	= (String)record.get("END_DATE_TIME");
		order_line_num  = (String)record.get("ORDER_LINE_NUM");
		infuse_over		= (String)record.get("INFUSE_OVER");
		infusion_per_unit		= (String)record.get("INFUSION_PER_UNIT");//INO71514

		if(infuse_over.indexOf(".") != -1){
			infuse_over_hr	 = infuse_over.substring(0,infuse_over.indexOf("."));
			Double Dtemp	 = new Double(infuse_over);
			Dtemp			 = Dtemp*60;
			Dtemp			 = (Dtemp%60);
			infuse_over_mi	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
			if(infuse_over_mi.indexOf(".") != -1)
				infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx

		}else{
			//added for INO71514	
			if(infusion_per_unit.equals("M")){
				infuse_over_hr = "";
				infuse_over_mi = infuse_over;
			}
			else{
				infuse_over_hr	 = infuse_over;
				infuse_over_mi	 = "";
			}
		}

		infuse_over_hr			= infuse_over_hr.equals("")?"0":infuse_over_hr;
		infuse_over_mi			= infuse_over_mi.equals("")?"0":infuse_over_mi;
		disp_str				= "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
		infusion_rate		    =(String)record.get("INFUSION_RATE");
		durn_type1				=(String)record.get("INFUSION_PER_UNIT");
	
		if(durn_type1.equals("H")){
			selected2		  =	"";
			selected1		  =	"selected";
			infusion_over_time=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
			infusion_uom="H";
		}
		else  if(durn_type1.equals("M")){ 
			selected1		=	"";
			selected2		=	"selected";
			infusion_over_time=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			infusion_uom="M";
		}

		if(mode.equals("amend")){
			sys_date		        =(String)record.get("START_DATE_TIME");
			// start date time is coming as thai. so it is converted and order date is saved
			iv_bean.setOrderDate(com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM",locale,"en"));
			iv_bean.setOrder_type_flag("amend");
		}
		String temp_end_date_time = "";	
		if(order_type_flag.equals("Existing") && !mode.equals("amend")){
			if(end_date_time!=null && !(end_date_time.equals(""))){//if block Code added for IN23819 -- 21/09/2010-- priya
				 temp_end_date_time = DateUtils.convertDate(end_date_time, "DMYHM",locale,"en");
			}
			temp=iv_bean.comp_date_time(temp_end_date_time,order_id,order_line_num); //passed temp_end_date_time instead of end_date_time for IN23819 -- 21/09/2010-- priya
			sys_date=temp;

			if(sys_date!=null && !(sys_date.equals(""))){//if block Code added for IN23819 -- 21/09/2010-- priya
				sys_date = DateUtils.convertDate(sys_date, "DMYHM","en",locale);
			}
			iv_bean.setOrder_type_flag("Existing");
		}

		durn_value				=(String)record.get("DURN_VALUE");
		durn_value1				=Integer.parseInt(durn_value);
		freq_value				=(String)record.get("FREQ_CODE");	
		durn_type				=(String)record.get("DURN_TYPE");

		order_catalog_code1		=(String)record1.get("ORDER_CATALOG_CODE");
		order_catalog_code		=(String)record.get("ORDER_CATALOG_CODE");

		iv_bean.setFluidDetails(order_catalog_code1,"","","",""); // CRF-0062 NEWLY ADDED
		ArrayList stockDetails	=iv_bean.getStockDetails(order_catalog_code1, "1");
		stock_uom_code			=(String)stockDetails.get(1);
		stock_uom_desc			=(String)stockDetails.get(2); //added for SKR-SCF-1076 [IN:054498]
		stock_value				=(String)stockDetails.get(0);		
		HashMap freqNature		=(HashMap)iv_bean.freqValidate(freq_value);

	// for renew purpose....
		if(order_type_flag.equals("Existing")){
			readonly="readonly";
		}
		if(mode.equals("amend") || prev_order.equals("previous")){
			readonly="";
		}
		if((mode.equals("amend"))||(order_type_flag.equals("Existing"))){	  
			ArrayList drugData		= (ArrayList) iv_bean.getDrugDetails();
			if(drugData.size()>0){
				HashMap   drugDataMap   = (HashMap) drugData.get(0);
				repeat_value			= (String) drugDataMap.get("REPEAT_VALUE");
				drug_code		        = (String) drugDataMap.get("DRUG_CODE");
				shedule_freq	=  bean.getSheduleFrequency(drug_code);
				drugDataMap.put("DURN_VALUE",durn_value);     // added while fixing IN25314 --01/12/2010-- priya
				drugDataMap.put("DURN_TYPE",durn_type);        // durn value & type was getting set as 1 D from SQL_PH_PRESCRIPTION_SELECT3A query
			}
			srl_no           ="1";
			Hashtable sch_output1	=	new Hashtable();
			sch_output1.put("code",drug_code);
			sch_output1.put("row_value",srl_no);
			sch_output1.put("start_time_assign","");
			sch_output1.put("durationType",durn_type); //replaced repeat_durn_type with durn_type for IN25314 --01/12/2010-- priya  //hanga
			sch_output1.put("daySM7","7");
			sch_output1.put("daySM6","6");
			sch_output1.put("daySM5","5");
			sch_output1.put("daySM4","4");
			sch_output1.put("daySM3","3");
			sch_output1.put("daySM2","2");
			sch_output1.put("daySM1","1");
			sch_output1.put("error","");
			sch_output1.put("repeat",repeat_value);
			sch_output1.put("dayDisplay7","Sat");
			sch_output1.put("dayDisplay6","Fri"); 
			sch_output1.put("dayDisplay5","Thu"); 
			sch_output1.put("displayHrs6","6");
			sch_output1.put("dayDisplay4","Wed");
			sch_output1.put("displayHrs5","5"); 
			sch_output1.put("dayDisplay3","Tue"); 
			sch_output1.put("displayHrs4","4"); 
			sch_output1.put("dayDisplay2","Mon"); 
			sch_output1.put("displayHrs3","3"); 
			sch_output1.put("dayDisplay1","Sun"); 
			sch_output1.put("displayHrs2","2"); 
			sch_output1.put("displayHrs1","1");
			sch_output1.put("start_day_assign","");			
			sch_output1.put("start_day_param",sys_date);			
			order_line_num="1";
			ArrayList values	=	iv_bean.getFreqDet(order_id,order_line_num);

			int incr=0;

			for(int p=0; p<values.size(); p+=4) {
				incr++;
				sch_output1.put("time"+(incr),values.get(p));
				sch_output1.put("qty"+(incr),values.get(p+1));				
				sch_output1.put("admin_day"+(incr),values.get(p+3));
			}

			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output1.put("time"+(q),"");
					sch_output1.put("qty"+(q),"");
				}
			}
			if(scheduled_yn.equals("Y")){ //hanga //if condition added for  IN25314 --01/12/2010-- priya
			iv_bean.setScheduleFrequencyStr(sch_output1);
			}
			ArrayList schedule		= (ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			HashMap temp_freq_chars =	null;
					freq_durn_type	=  "D";
			 if(schedule != null && schedule.size()>0){
				temp_freq_chars = (HashMap)schedule.get(0);
				freq_durn_type	= (String)temp_freq_chars.get("durationType");
			 }
			
			 if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
	 
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);

				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", sys_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code);
				sch_output.put("row_value","1");
				sch_output.put("start_date_time",sys_date);

				freq_durn_type	= (String)sch_output.get("durationType");

//				iv_bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				values	=	iv_bean.getFreqDet(order_id,"1");
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList	 dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = iv_bean.getDayOfWeek(sys_date); 
						  freqCharctValues = (ArrayList)sch_output.get(drug_code);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
		
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add(values.get(p+3));
				}

				
				if(day_list.size()>0){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals(""))
						{
							String temp1 = (String)day_list.get(j);
							if (temp1 == null || temp1.equals(""))
							{
								temp1 = "0";
							}
							if (!temp1.equals("0"))
							{
								day_names.add(week_days.get((Integer.parseInt(temp1))-1));
							}
						
						}
					}
				}

				tmp_freq_values.add(freqCharctValues.get(0));
				tmp_freq_values.add(day_list);
				tmp_freq_values.add(day_names);
				tmp_freq_values.add(time_list);
				tmp_freq_values.add(dose_list);
				sch_output.put(drug_code,tmp_freq_values);

				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}
						
	/*			tooltiptable = (String)iv_bean.getTooltipStringFrFreq(tmp_freq_values,"toolTip");
				adm_time = tooltiptable;
				split_chk	=	iv_bean.checkSplit(tmp_freq_values);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}*/


		/*		int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));				
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}

				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						sch_output.put("qty"+(q),"");
					}
				}*/
				iv_bean.setScheduleFrequencyStr(sch_output);
				schedule		= (ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");
			}

		}
		putObjectInBean(bean_id1,bean1,request);
	}

	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues	        =	null;
	if(scheduled_yn.equals("Y")){ //hanga //if condition added for  IN25314 --01/12/2010-- priya
	chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();
	if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
		frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(order_catalog_code);
		}
	} 
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();

	orderSetValues = iv_bean.getOrderSetValues();
	if(orderSetValues.size() > 0){
		timeFrame			= (String)orderSetValues.get(7);
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(Integer.parseInt((String)orderSetValues.get(i+7)) > Integer.parseInt(timeFrame)){
				timeFrame	= (String)orderSetValues.get(i+7);
			}
		}
		sys_date	= iv_bean.populateEndDate(sys_date,timeFrame,"H");
	}


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
					else{  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block16Bytes, _wl_block16);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
					else{  
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
					else{  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
					else{  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

						if((mode.equals("amend"))||(order_type_flag.equals("Existing"))){
	
							for(int i=0;i<shedule_freq.size();i=i+2){
								if(((String)shedule_freq.get(i)).equals(freq_value)){
										 optSelected="selected";

								}
								else{
								   optSelected="";
								}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)shedule_freq.get(i)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(optSelected));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)shedule_freq.get(i+1)));
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
						}

            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

						if(durn_value.equals(""))
							durn_value = "1";
						if(durn_type==null || durn_type.equals(""))
							durn_type="D";

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

						if(!(order_type_flag.equals("Existing")||mode.equals("amend"))){
							// Added the if/else for durn_type (Y,L,W,D,H,M) for SRR20056-SCF-7374 Incident No. 27415 to default select for durn_unit.
							if(durn_type.equals("Y")){

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

							}
							else{

            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

							}
							if(durn_type.equals("L")){

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else{

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							if(durn_type.equals("W")){

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else{

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							if(durn_type.equals("D")){

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else{

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							if(durn_type.equals("H")){

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else{

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							if(durn_type.equals("M")){

            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else{

            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
						}

            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(iv_bean_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(iv_bean_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(infusion_uom));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(infusion_uom));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(stock_uom_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);

	if((order_type_flag.equals("Existing")||mode.equals("amend"))){
		out.println("makeAutoSchedule()");
		out.println("assignDurnDesc('"+repeat_value_durn+"','"+repeat_durn_type+"','"+freq_nature+"','"+interval_value+"','','"+freq_value_durn+"','"+schedule_yn+"','','"+durn_value+"','"+durn_type+"')");



	//	out.println("dfltDurnDesc('"+durn_type+"','"+freq_nature+"','')");		

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block95Bytes, _wl_block95);

	//	out.println("populateEndDate()");
	}
	if(!order_type_flag.equals("Existing")&& !mode.equals("amend") && !freq_nature.equals("I")){
		
		out.println("setSchedule('"+freq_value+"')");

	}
		HashMap data		=	null;
		String att			=	null;
		adm_time		=	"";
		String adm_qty		=	"";
		//total_qty	=   "";

		if(frequencyValues!=null && frequencyValues.size()>0){

	/*		adm_time =adm_time +"<tr>";					
			for(int i=0;i<frequencyValues.size();i++){
				data=(HashMap)frequencyValues.get(i);
				att="align=center class=TIP";
				adm_time =adm_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			adm_time =adm_time +"</tr>";

			adm_qty= adm_qty +"<tr>";
			for(int i=0;i<frequencyValues.size();i++){
				att="align=center class=TIP";
				data=(HashMap)frequencyValues.get(i);
				adm_qty= adm_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
				total_qty=(String) data.get("admin_qty");
			}
			adm_qty= adm_qty +"</tr>";*/

			
			tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
			adm_qty = tooltiptable;		
			split_chk	=	iv_bean.checkSplit(frequencyValues);	
			out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+iv_bean.getRepeatValue()+"')");
		}

            _bw.write(_wl_block96Bytes, _wl_block96);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
	putObjectInBean(iv_bean_id,iv_bean,request);
}catch(Exception e){
		e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-1223 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-1223 end

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminRate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.years.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.years.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MONTHS.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MONTHS.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WEEKS.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WEEKS.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.StartDateTime.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndDateTime.label", java.lang.String .class,"key"));
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
}

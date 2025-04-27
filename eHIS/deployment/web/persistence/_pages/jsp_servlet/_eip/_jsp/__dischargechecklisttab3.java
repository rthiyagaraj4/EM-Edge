package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dischargechecklisttab3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListTab3.jsp", 1729590527446L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n    \n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DischargeCheckListTab3\' id=\'DischargeCheckListTab3\'>\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr>\n<td class=\'COLUMNHEADER\' colspan=4>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n</tr>\n<tr></tr><tr></tr>\n<tr>\n<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'COLUMNHEADER\'></td>\n<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<th class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n</tr>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=\'fields\'><input type=\'checkbox\' name=\'adv_cnt_parent\' id=\'adv_cnt_parent\' onclick=\"setValue_tab3(this);\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="></td><td class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><td class=\'fields\'><input type=\'checkbox\' name=\'adv_cnt_guardian\' id=\'adv_cnt_guardian\' onclick=\"setValue_tab3(this);\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="></td>\n</tr>\n<tr> \n<td class=\'label\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'wc_chk\' id=\'wc_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ></td>\n<td class=\'fields\' ><input type=\'text\' name=\'wc_given_by\' id=\'wc_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'wc_given_dt\' id=\'wc_given_dt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"wc_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].wc_given_dt.select();return showCalendar(\'wc_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'nu_chk\' id=\'nu_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ></td>\n<td class=\'fields\' ><input type=\'text\' name=\'nu_given_by\' id=\'nu_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'nu_given_dt\' id=\'nu_given_dt\'  size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"nu_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].nu_given_dt.select();return showCalendar(\'nu_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'mc_chk\' id=\'mc_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ></td>\n<td class=\'fields\' ><input type=\'text\' name=\'mc_given_by\' id=\'mc_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'mc_given_dt\' id=\'mc_given_dt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"mc_given_dt_img\"  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].mc_given_dt.select();return showCalendar(\'mc_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'ph_chk\' id=\'ph_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n<td class=\'fields\' ><input type=\'text\' name=\'ph_given_by\' id=\'ph_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'ph_given_dt\' id=\'ph_given_dt\'  size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"ph_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].ph_given_dt.select();return showCalendar(\'ph_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'cop_chk\' id=\'cop_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="></td>\n<td class=\'fields\' ><input type=\'text\' name=\'cop_given_by\' id=\'cop_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'cop_given_dt\' id=\'cop_given_dt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"cop_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].cop_given_dt.select();return showCalendar(\'cop_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'coc_chk\' id=\'coc_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ></td>\n<td class=\'fields\' ><input type=\'text\' name=\'coc_given_by\' id=\'coc_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'coc_given_dt\' id=\'coc_given_dt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"coc_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].coc_given_dt.select();return showCalendar(\'coc_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'cot_chk\' id=\'cot_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="></td>\n<td class=\'fields\' ><input type=\'text\' name=\'cot_given_by\' id=\'cot_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'cot_given_dt\' id=\'cot_given_dt\'  size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"cot_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].cot_given_dt.select();return showCalendar(\'cot_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n<td class=\'fields\' ><input type=\'checkbox\' name=\'oth_he_chk\' id=\'oth_he_chk\' onclick=\"setValue_tab3(this);enable_disable_tab3(this);\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ></td>\n<td class=\'label\' ></td>\n<td class=\'label\' ></td>\n</tr>\n<tr>\n<td class=\'label\'></td>\n<td class=\'fields\' ><input type=\'text\' name=\'oth_text\' id=\'oth_text\' size=\'20\' maxlength=\'80\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'oth_given_by\' id=\'oth_given_by\' size=\'30\' maxlength=\'30\' disabled></td>\n<td class=\'fields\' ><input type=\'text\' name=\'oth_given_dt\' id=\'oth_given_dt\'  size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab3(event);\" onBlur=\"chk_with_sysdate_tab3(this);\" disabled><input type=\"image\" id=\"oth_given_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_given_dt.select();return showCalendar(\'oth_given_dt\',null,\'hh:mm\')\" disabled>\n</td>\n</tr>\n<tr>\n<td class=\'label\' colspan=4></td>\n</tr>\n</table>\n</form>\n\n<script>\ndocument.forms[0].adv_cnt_parent.value = parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_parent.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_parent.value == \'Y\')\ndocument.forms[0].adv_cnt_parent.checked = true;\n\n\n\ndocument.forms[0].adv_cnt_guardian.value = parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_guardian.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_guardian.value == \'Y\')\ndocument.forms[0].adv_cnt_guardian.checked = true;\n\n\ndocument.forms[0].wc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_wc_chk.value == \'Y\')\ndocument.forms[0].wc_chk.checked = true;\n\n\n\ndocument.forms[0].wc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_given_by.value;\n\n\ndocument.forms[0].wc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_given_dt.value;\n\n\n\ndocument.forms[0].nu_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_nu_chk.value == \'Y\')\ndocument.forms[0].nu_chk.checked = true;\n\n\n\ndocument.forms[0].nu_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_given_by.value;\n\n\n\ndocument.forms[0].nu_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_given_dt.value;\n\n\ndocument.forms[0].mc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_mc_chk.value == \'Y\')\ndocument.forms[0].mc_chk.checked = true;\n\n\n\ndocument.forms[0].mc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_given_by.value;\n\n\ndocument.forms[0].mc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_given_dt.value;\n\n\ndocument.forms[0].ph_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_ph_chk.value == \'Y\')\ndocument.forms[0].ph_chk.checked = true;\n\n\n\ndocument.forms[0].ph_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_given_by.value;\n\n\ndocument.forms[0].ph_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_given_dt.value;\n\n\ndocument.forms[0].cop_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_cop_chk.value == \'Y\')\ndocument.forms[0].cop_chk.checked = true;\n\n\n\ndocument.forms[0].cop_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_given_by.value;\n\n\ndocument.forms[0].cop_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_given_dt.value;\n\n\ndocument.forms[0].coc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_coc_chk.value == \'Y\')\ndocument.forms[0].coc_chk.checked = true;\n\n\n\ndocument.forms[0].coc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_given_by.value;\n\n\ndocument.forms[0].coc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_given_dt.value;\n\n\ndocument.forms[0].cot_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_cot_chk.value == \'Y\')\ndocument.forms[0].cot_chk.checked = true;\n\n\ndocument.forms[0].cot_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_given_by.value;\n\n\ndocument.forms[0].cot_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_given_dt.value;\n\n\ndocument.forms[0].oth_he_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_he_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_oth_he_chk.value == \'Y\')\ndocument.forms[0].oth_he_chk.checked = true;\n\n\n\ndocument.forms[0].oth_text.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_text.value;\n\n\ndocument.forms[0].oth_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_given_by.value;\n\n\ndocument.forms[0].oth_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_given_dt.value;\n\n\n</script>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n<script>\t\n\tif(document.forms[0].wc_chk.checked==true)\n\t{\t\t\n\t\t\tdocument.forms[0].wc_given_by.disabled = false;\n\t\t\tdocument.forms[0].wc_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"wc_given_dt_img\").disabled = false;\t\t\n\t}\n\tif(document.forms[0].nu_chk.checked==true)\n\t{\n\n\t\t\tdocument.forms[0].nu_given_by.disabled = false;\n\t\t\tdocument.forms[0].nu_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"nu_given_dt_img\").disabled = false;\n\t}\n\tif(document.forms[0].mc_chk.checked==true)\n\t{\n\t\t\n\t\t\tdocument.forms[0].mc_given_by.disabled = false;\n\t\t\tdocument.forms[0].mc_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"mc_given_dt_img\").disabled = false;\t\t\n\t}\n\tif(document.forms[0].ph_chk.checked==true)\n\t{\n\t\t\tdocument.forms[0].ph_given_by.disabled = false;\n\t\t\tdocument.forms[0].ph_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"ph_given_dt_img\").disabled = false;\n\t}\n\tif(document.forms[0].cop_chk.checked==true)\n\t{\n\t\t\tdocument.forms[0].cop_given_by.disabled = false;\n\t\t\tdocument.forms[0].cop_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"cop_given_dt_img\").disabled = false;\n\t}\n\tif(document.forms[0].coc_chk.checked==true)\n\t{\n\t\t\tdocument.forms[0].coc_given_by.disabled = false;\n\t\t\tdocument.forms[0].coc_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"coc_given_dt_img\").disabled = false;\t\n\t}\n\tif(document.forms[0].cot_chk.checked==true)\n\t{\n\t\t\tdocument.forms[0].cot_given_by.disabled = false;\n\t\t\tdocument.forms[0].cot_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"cot_given_dt_img\").disabled = false;\n\t}\n\tif(document.forms[0].oth_he_chk.checked==true)\n\t{\n\t\t\tdocument.forms[0].oth_text.disabled = false;\n\t\t\tdocument.forms[0].oth_given_by.disabled = false;\n\t\t\tdocument.forms[0].oth_given_dt.disabled = false;\n\t\t\tdocument.getElementById(\"oth_given_dt_img\").disabled = false;\n\t}\n\n</script>\n<script>\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_adv_cnt_parent.value != \'\')\ndocument.forms[0].adv_cnt_parent.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_adv_cnt_guardian.value != \'\')\ndocument.forms[0].adv_cnt_guardian.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_chk.value == \'Y\')\ndocument.forms[0].wc_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_given_by.value!=\'\')\ndocument.forms[0].wc_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_given_dt.value!=\'\')\n{\ndocument.forms[0].wc_given_dt.disabled = true;\ndocument.getElementById(\"wc_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_chk.value != \'\')\ndocument.forms[0].nu_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_given_by.value!=\'\')\ndocument.forms[0].nu_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_given_dt.value!=\'\')\n{\ndocument.forms[0].nu_given_dt.disabled = true;\ndocument.getElementById(\"nu_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_chk.value != \'\')\ndocument.forms[0].mc_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_given_by.value!=\'\')\ndocument.forms[0].mc_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_given_dt.value!=\'\')\n{\ndocument.forms[0].mc_given_dt.disabled = true;\ndocument.getElementById(\"mc_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_chk.value != \'\')\ndocument.forms[0].ph_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_given_by.value!=\'\')\ndocument.forms[0].ph_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_given_dt.value!=\'\')\n{\ndocument.forms[0].ph_given_dt.disabled = true;\ndocument.getElementById(\"ph_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_chk.value != \'\')\ndocument.forms[0].cop_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_given_by.value!=\'\')\ndocument.forms[0].cop_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_given_dt.value!=\'\')\n{\ndocument.forms[0].cop_given_dt.disabled = true;\ndocument.getElementById(\"cop_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_chk.value != \'\')\ndocument.forms[0].coc_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_given_by.value!=\'\')\ndocument.forms[0].coc_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_given_dt.value!=\'\')\n{\ndocument.forms[0].coc_given_dt.disabled = true;\ndocument.getElementById(\"coc_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_chk.value != \'\')\ndocument.forms[0].cot_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_given_by.value!=\'\')\ndocument.forms[0].cot_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_given_dt.value!=\'\')\n{\ndocument.forms[0].cot_given_dt.disabled = true;\ndocument.getElementById(\"cot_given_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_he_chk.value != \'\')\ndocument.forms[0].oth_he_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_text.value!=\'\')\ndocument.forms[0].oth_text.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_given_by.value!=\'\')\ndocument.forms[0].oth_given_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_given_dt.value!= \'\')\n{\n\tdocument.forms[0].oth_given_dt.disabled = true;\n\tdocument.getElementById(\"oth_given_dt_img\").disabled = true;\n}\n\n</script>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
String disable_fld = "";
if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld = "disabled";
}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
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

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block32Bytes, _wl_block32);


if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{

            _bw.write(_wl_block33Bytes, _wl_block33);

	}

            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HealthEducation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.givenby.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdviceonContcare.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.guardian.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WoundCare.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Nutrition.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Medication.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PersonalHygiene.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CareofPOP.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CareofCatheters.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CareofTube.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
}

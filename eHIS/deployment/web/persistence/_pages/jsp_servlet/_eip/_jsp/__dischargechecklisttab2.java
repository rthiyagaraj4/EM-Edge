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

public final class __dischargechecklisttab2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListTab2.jsp", 1742378185712L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n    \n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DischargeCheckListTab2\' id=\'DischargeCheckListTab2\'>\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<tr><td class=\'COLUMNHEADER\' colspan=6>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr><td class=\'COLUMNHEADER\' colspan=4>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<tr>\n\t<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td class=\'LABELCENTER\' width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td class=\'LABELCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td class=\'LABELCENTER\' width=\'20%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'LABELCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<td class=\'LABELCENTER\' width=\'40%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\'label\' width=\'40%\'></td>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t<!--Modified by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620-->\n\t<td class=\'LABELCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t<td class=\'fileds\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="><input type=\'checkbox\' name=\'iv_catheters_chk\' id=\'iv_catheters_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ></td>\n\t<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'iv_remove_chk\' id=\'iv_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'iv_remarks\' id=\'iv_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'iv_removed_by\' id=\'iv_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'iv_removed_dt\' id=\'iv_removed_dt\' id=\'ivremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"iv_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].iv_removed_dt.select();return showCalendar(\'ivremoveddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="><input type=\'checkbox\' name=\'tubes_chk\' id=\'tubes_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'tubes_remove_chk\' id=\'tubes_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'tubes_remarks\' id=\'tubes_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'tubes_removed_by\' id=\'tubes_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'tubes_removed_dt\' id=\'tubes_removed_dt\' id=\'tubesremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"tubes_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].tubes_removed_dt.select();return showCalendar(\'tubesremoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><input type=\'checkbox\' name=\'drg_chk\' id=\'drg_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'drg_remove_chk\' id=\'drg_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'drg_remarks\' id=\'drg_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'drg_removed_by\' id=\'drg_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'drg_removed_dt\' id=\'drg_removed_dt\' id=\'drgremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"drg_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].drg_removed_dt.select();return showCalendar(\'drgremoveddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="><input type=\'checkbox\' name=\'ngt_tube_chk\' id=\'ngt_tube_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="></td>\n\t<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'ngt_remove_chk\' id=\'ngt_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'ngt_remarks\' id=\'ngt_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'ngt_tube_removed_by\' id=\'ngt_tube_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'ngt_tube_removed_dt\' id=\'ngt_tube_removed_dt\' id=\'ngttuberemoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"ngt_tube_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].ngt_tube_removed_dt.select();return showCalendar(\'ngttuberemoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t<td class=\'fileds\' ><input type=\'checkbox\' name=\'cngt_tube_chk\' id=\'cngt_tube_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'cngt_tube_removed_by\' id=\'cngt_tube_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'cngt_tube_removed_dt\' id=\'cngt_tube_removed_dt\' id=\'cngttuberemoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"cngt_tube_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].cngt_tube_removed_dt.select();return showCalendar(\'cngttuberemoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="><input type=\'checkbox\' name=\'urn_chk\' id=\'urn_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'urn_remove_chk\' id=\'urn_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'urn_remarks\' id=\'urn_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'urn_removed_by\' id=\'urn_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'urn_removed_dt\' id=\'urn_removed_dt\' id=\'urnremoveddt\' size=\'16\' maxlength=\'16\'disabled onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" ><input type=\"image\" id=\"urn_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].urn_removed_dt.select();return showCalendar(\'urnremoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t<td class=\'fileds\' ><input type=\'checkbox\' name=\'curn_chk\' id=\'curn_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'curn_removed_by\' id=\'curn_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'curn_removed_dt\' id=\'curn_removed_dt\' id=\'curnremoveddt\' size=\'16\' maxlength=\'16\' disabled onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" ><input type=\"image\" id=\"curn_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].curn_removed_dt.select();return showCalendar(\'curnremoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="><input type=\'checkbox\' name=\'sto_chk\' id=\'sto_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'sto_remove_chk\' id=\'sto_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'sto_remarks\' id=\'sto_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<td class=\'fileds\' ><input type=\'text\' name=\'sto_removed_by\' id=\'sto_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'sto_removed_dt\' id=\'sto_removed_dt\' id=\'storemoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"sto_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].sto_removed_dt.select();return showCalendar(\'storemoveddt\',null,\'hh:mm\')\" disabled>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="><input type=\'checkbox\' name=\'dressing_chk\' id=\'dressing_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'dressing_remove_chk\' id=\'dressing_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'dressing_remarks\' id=\'dressing_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<td class=\'fileds\'> <input type=\'text\' name=\'dressing_removed_by\' id=\'dressing_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'dressing_removed_dt\' id=\'dressing_removed_dt\' id=\'dressingremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"dressing_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].dressing_removed_dt.select();return showCalendar(\'dressingremoveddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="><input type=\'checkbox\' name=\'itemloan_chk\' id=\'itemloan_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="></td>\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'itemloan_remove_chk\' id=\'itemloan_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'itemloan_remarks\' id=\'itemloan_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t<td class=\'fileds\'> <input type=\'text\' name=\'itemloan_removed_by\' id=\'itemloan_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'itemloan_removed_dt\' id=\'itemloan_removed_dt\' id=\'itemloanremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"itemloan_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].itemloan_removed_dt.select();return showCalendar(\'itemloanremoveddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="><input type=\'checkbox\' name=\'others_chk\' id=\'others_chk\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<td class=\'fileds\' align=\'center\'><input type=\'checkbox\' name=\'others_remove_chk\' id=\'others_remove_chk\' onclick=\"setValue_tab2(this);enableDisableFields(this);\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="></td>\n\t<td class=\'fileds\' align=\'center\'><input type=\'text\' name=\'others_remarks\' id=\'others_remarks\' size=\'30\' maxlength=\'50\' disabled></td>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t<td class=\'fileds\'> <input type=\'text\' name=\'others_removed_by\' id=\'others_removed_by\' size=\'30\' maxlength=\'30\' disabled></td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'others_removed_dt\' id=\'others_removed_dt\' id=\'othersremoveddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"others_removed_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].others_removed_dt.select();return showCalendar(\'othersremoveddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</table>\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td></tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t<td class=\'fileds\' ><input type=\'checkbox\' name=\'blng_returned\' id=\'blng_returned\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ></td>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'blng_returned_dt\' id=\'blng_returned_dt\' id=\'blngreturneddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"blng_returned_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].blng_returned_dt.select();return showCalendar(\'blngreturneddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td><td class=\'fileds\' ><input type=\'text\' name=\'blng_remarks\' id=\'blng_remarks\' size=\'30\' maxlength=\'100\' disabled></td>\n\t<td class=\'label\'></td>\n\t<td class=\'label\'></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t<td class=\'fileds\' ><input type=\'checkbox\' name=\'vlb_returned\' id=\'vlb_returned\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" disabled><a href =\"javascript:showValuables_tab2()\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></td>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'vlb_returned_by\' id=\'vlb_returned_by\' size=\'20\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" disabled><input type=\'button\' class=\'button\' name=\'user_search\' id=\'user_search\' value=\'?\' onclick=\'displayUser_tab2(this,vlb_returned_by,vlb_user)\' disabled><input type=\'hidden\' name=\'vlb_user\' id=\'vlb_user\'></td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'vlb_witness\' id=\'vlb_witness\' size=\'20\' maxlength=\'30\' onBlur=\'getattndpract_tab2();\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" disabled><input type=\'button\' class=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' onclick=\'callPractSearch_tab2(document.forms[0].pract_id_search,document.forms[0].vlb_witness);fixvaluespractitioner_tab2();\' disabled ><input type=\'hidden\' name=\'witness_id\' id=\'witness_id\'><input type=\'hidden\' name=\'temp_desc\' id=\'temp_desc\'><input type=\'hidden\' name=\'temp_physician_id\' id=\'temp_physician_id\'></td>\n\t<td class=\'label\'></td>\n\t<td class=\'label\'></td>\n</tr>\n<tr><td class=\'COLUMNHEADER\' colspan=6>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t<td class=\'fileds\' ><input type=\'checkbox\' name=\'tp_arranged\' id=\'tp_arranged\' onclick=\"setValue_tab2(this);enable_disable_tab2(this);\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="></td>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'tp_returned_dt\' id=\'tp_returned_dt\' id=\'tpreturneddt\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab2(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" disabled><input type=\"image\" id=\"tp_returned_dt_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].tp_returned_dt.select();return showCalendar(\'tpreturneddt\',null,\'hh:mm\')\" disabled></td>\n</tr>\n<tr>\n\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t<td class=\'fileds\' ><input type=\'text\' name=\'tp_remarks\' id=\'tp_remarks\' size=\'30\' maxlength=\'100\' disabled></td>\n\t<td class=\'label\' ></td>\n\t<td class=\'label\' ></td>\n</tr>\n<!-- </tr>\n<tr>\n<td class=\'label\' colspan=4></td></tr> -->\n</table>\n<!-- </td>\n</tr>\n</table> -->\n<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n<input type=\'hidden\' name=\'isChangesInAdditionalDtlsTabAppl\' id=\'isChangesInAdditionalDtlsTabAppl\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->\n<input type=\'hidden\' name=\'isItemOnLoanOthersDisableDateAppl\' id=\'isItemOnLoanOthersDisableDateAppl\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90_0 ="\">\n\n</form>\n<script>\ndocument.forms[0].iv_catheters_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_catheters_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_iv_catheters_chk.value == \'Y\')\ndocument.forms[0].iv_catheters_chk.checked=true;\n\n\ndocument.forms[0].iv_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_removed_by.value;\n\n\ndocument.forms[0].iv_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_removed_dt.value;\n\n\n\ndocument.forms[0].tubes_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_tubes_chk.value == \'Y\')\ndocument.forms[0].tubes_chk.checked=true;\n\n\ndocument.forms[0].tubes_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_removed_by.value;\n\n\ndocument.forms[0].tubes_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_removed_dt.value;\n\n\ndocument.forms[0].drg_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_drg_chk.value == \'Y\')\ndocument.forms[0].drg_chk.checked = true;\n\n\ndocument.forms[0].drg_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_removed_by.value;\n\n\ndocument.forms[0].drg_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_removed_dt.value;\n\ndocument.forms[0].ngt_tube_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_chk.value == \'Y\')\ndocument.forms[0].ngt_tube_chk.checked = true;\n\ndocument.forms[0].ngt_tube_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_removed_by.value;\n\ndocument.forms[0].ngt_tube_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_removed_dt.value;\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tdocument.forms[0].cngt_tube_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_chk.value == \'Y\')\n\tdocument.forms[0].cngt_tube_chk.checked= true;\n\ndocument.forms[0].cngt_tube_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_removed_by.value;\n\n\tdocument.forms[0].cngt_tube_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_removed_dt.value;\n}\n\ndocument.forms[0].urn_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_urn_chk.value == \'Y\')\ndocument.forms[0].urn_chk.checked = true;\n\ndocument.forms[0].urn_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_removed_by.value;\n\ndocument.forms[0].urn_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_removed_dt.value;\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tdocument.forms[0].curn_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_curn_chk.value == \'Y\')\n\tdocument.forms[0].curn_chk.checked = true;\n\ndocument.forms[0].curn_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_removed_by.value;\n\n\tdocument.forms[0].curn_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_removed_dt.value;\n}\n\ndocument.forms[0].sto_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_sto_chk.value == \'Y\')\ndocument.forms[0].sto_chk.checked = true;\n\ndocument.forms[0].sto_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_removed_by.value;\n\ndocument.forms[0].sto_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_removed_dt.value;\n\ndocument.forms[0].dressing_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_chk.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_dressing_chk.value == \'Y\')\ndocument.forms[0].dressing_chk.checked= true;\n\ndocument.forms[0].dressing_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_removed_by.value;\n\ndocument.forms[0].dressing_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_removed_dt.value;\n/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/\nif(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == \"true\")\n{\n\tdocument.forms[0].itemloan_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_chk.value == \'Y\')\n\tdocument.forms[0].itemloan_chk.checked= true;\n\tdocument.forms[0].itemloan_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_removed_by.value;\n\tdocument.forms[0].itemloan_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_removed_dt.value;\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].itemloan_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remove_chk.value;\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remove_chk.value == \'Y\')\n\t\tdocument.forms[0].itemloan_remove_chk.checked=true;\n\t\tdocument.forms[0].itemloan_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remarks.value;\n\t}\n\tdocument.forms[0].others_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_others_chk.value == \'Y\')\n\tdocument.forms[0].others_chk.checked= true;\n\tdocument.forms[0].others_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_removed_by.value;\n\tdocument.forms[0].others_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_removed_dt.value;\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].others_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_remove_chk.value;\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_others_remove_chk.value == \'Y\')\n\t\tdocument.forms[0].others_remove_chk.checked=true;\n\t\tdocument.forms[0].others_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_remarks.value;\n\t}\n}\n\ndocument.forms[0].blng_returned.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned.value == \'Y\')\ndocument.forms[0].blng_returned.checked = true;\n \ndocument.forms[0].blng_returned_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned_dt.value;\n\n \ndocument.forms[0].blng_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_remarks.value;\n \ndocument.forms[0].vlb_returned.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned.value == \'Y\')\ndocument.forms[0].vlb_returned.checked = true;\n \nif(document.forms[0].vlb_returned_by.value==\'\')\ndocument.forms[0].vlb_returned_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned_by.value;\n\nif(document.forms[0].vlb_witness.value==\'\')\n{\n\tdocument.forms[0].vlb_witness.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_witness.value;\n}\n\ndocument.forms[0].witness_id.value = parent.DischargeCheckList_frame1.document.forms[0].h_witness_id.value;\ndocument.forms[0].vlb_user.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_user.value;\n\n \ndocument.forms[0].tp_arranged.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_arranged.value;\nif(parent.DischargeCheckList_frame1.document.forms[0].h_tp_arranged.value == \'Y\')\ndocument.forms[0].tp_arranged.checked = true;\n\n \ndocument.forms[0].tp_returned_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_returned_dt.value;\n\n \ndocument.forms[0].tp_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_remarks.value;\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n{\n\tdocument.forms[0].iv_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_iv_remove_chk.value == \'Y\')\n\tdocument.forms[0].iv_remove_chk.checked=true;\n\n\tdocument.forms[0].iv_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_remarks.value;\t\n\n\tdocument.forms[0].tubes_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remove_chk.value == \'Y\')\n\tdocument.forms[0].tubes_remove_chk.checked=true;\n\n\tdocument.forms[0].tubes_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remarks.value;\n\n\tdocument.forms[0].drg_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_drg_remove_chk.value == \'Y\')\n\tdocument.forms[0].drg_remove_chk.checked=true;\n\n\tdocument.forms[0].drg_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_remarks.value;\n\n\tdocument.forms[0].ngt_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remove_chk.value == \'Y\')\n\tdocument.forms[0].ngt_remove_chk.checked=true;\n\n\tdocument.forms[0].ngt_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remarks.value;\n\n\tdocument.forms[0].urn_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_urn_remove_chk.value == \'Y\')\n\tdocument.forms[0].urn_remove_chk.checked=true;\n\n\tdocument.forms[0].urn_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_remarks.value;\n\n\tdocument.forms[0].sto_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_sto_remove_chk.value == \'Y\')\n\tdocument.forms[0].sto_remove_chk.checked=true;\n\n\tdocument.forms[0].sto_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_remarks.value;\n\n\tdocument.forms[0].dressing_remove_chk.value = ";
    private final static byte[]  _wl_block90_0Bytes = _getBytes( _wl_block90_0 );

    private final static java.lang.String  _wl_block90_1 ="parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remove_chk.value;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remove_chk.value == \'Y\')\n\tdocument.forms[0].dressing_remove_chk.checked=true;\n\n\tdocument.forms[0].dressing_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remarks.value;\n}\n/*End ML-MMOH-CRF-1142*/\n\n</script>\n";
    private final static byte[]  _wl_block90_1Bytes = _getBytes( _wl_block90_1 );

    private final static java.lang.String  _wl_block91_0 ="\n<script>\nif(document.forms[0].iv_catheters_chk.checked==true)\t\n{\n\t\tdocument.forms[0].iv_removed_by.disabled = false;\n\t\tdocument.forms[0].iv_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'iv_removed_dt_img\').disabled = false;\n\t\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\t\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t\t{\n\t\t\tdocument.forms[0].iv_remove_chk.disabled = true;\n\t\t\tdocument.forms[0].iv_remarks.disabled = false;\n\t\t}\n}\n\nif(document.forms[0].tubes_chk.checked==true)\t\n{\n\tdocument.forms[0].tubes_removed_by.disabled = false;\n\tdocument.forms[0].tubes_removed_dt.disabled = false;\n\tdocument.getElementById(\'tubes_removed_dt_img\').disabled = false;\t\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].tubes_remove_chk.disabled = true;\n\t\tdocument.forms[0].tubes_remarks.disabled = false;\n\t}\n}\n\nif(document.forms[0].drg_chk.checked==true)\t\n{\n\tdocument.forms[0].drg_removed_by.disabled = false;\n\tdocument.forms[0].drg_removed_dt.disabled = false;\n\tdocument.getElementById(\'drg_removed_dt_img\').disabled = false;\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].drg_remove_chk.disabled = true;\n\t\tdocument.forms[0].drg_remarks.disabled = false;\n\t}\n}\n\nif(document.forms[0].ngt_tube_chk.checked==true)\t\n{\n\tdocument.forms[0].ngt_tube_removed_by.disabled = false;\n\tdocument.forms[0].ngt_tube_removed_dt.disabled = false;\n\tdocument.getElementById(\'ngt_tube_removed_dt_img\').disabled = false;\t\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].ngt_remove_chk.disabled = true;\n\t\tdocument.forms[0].ngt_remarks.disabled = false;\n\t}\n}\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tif(document.forms[0].cngt_tube_chk.checked==true)\t\n\t{\n\t\tdocument.forms[0].cngt_tube_removed_by.disabled = false;\n\t\tdocument.forms[0].cngt_tube_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'cngt_tube_removed_dt_img\').disabled = false;\t\n\t}\n}\n\nif(document.forms[0].urn_chk.checked==true)\n{\t\n\tdocument.forms[0].urn_removed_by.disabled = false;\n\tdocument.forms[0].urn_removed_dt.disabled = false;\n\tdocument.getElementById(\'urn_removed_dt_img\').disabled = false;\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].urn_remove_chk.disabled = true;\n\t\tdocument.forms[0].urn_remarks.disabled = false;\n\t}\n}\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tif(document.forms[0].curn_chk.checked==true)\n\t{\n\t\tdocument.forms[0].curn_removed_by.disabled = false;\n\t\tdocument.forms[0].curn_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'curn_removed_dt_img\').disabled = false;\t\n\t}\n}\n\nif(document.forms[0].sto_chk.checked==true)\n{\n\tdocument.forms[0].sto_removed_by.disabled = false;\n\tdocument.forms[0].sto_removed_dt.disabled = false;\n\tdocument.getElementById(\'sto_removed_dt_img\').disabled = false;\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].sto_remove_chk.disabled = true;\n\t\tdocument.forms[0].sto_remarks.disabled = false;\n\t}\n}\n\nif(document.forms[0].dressing_chk.checked==true)\n{\n\tdocument.forms[0].dressing_removed_by.disabled = false;\n\tdocument.forms[0].dressing_removed_dt.disabled = false;\n\tdocument.getElementById(\'dressing_removed_dt_img\').disabled = false;\n\t/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\n\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t{\n\t\tdocument.forms[0].dressing_remove_chk.disabled = true;\n\t\tdocument.forms[0].dressing_remarks.disabled = false;\n\t}\n}\n\n/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/\nif(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == \"true\")\n{\n\tif(document.forms[0].itemloan_chk.checked==true)\n\t{\n\t\tdocument.forms[0].itemloan_removed_by.disabled = false;\n\t\tdocument.forms[0].itemloan_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'itemloan_removed_dt_img\').disabled = false;\n\t\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t\t{\n\t\t\tdocument.forms[0].itemloan_remove_chk.disabled = true;\n\t\t\tdocument.forms[0].itemloan_remarks.disabled = false;\n\t\t}\n\t}\n\tif(document.forms[0].others_chk.checked==true)\n\t{\n\t\tdocument.forms[0].others_removed_by.disabled = false;\n\t\tdocument.forms[0].others_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'others_removed_dt_img\').disabled = false;\n\t\tif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n\t\t{\n\t\t\tdocument.forms[0].others_remove_chk.disabled = true;\n\t\t\tdocument.forms[0].others_remarks.disabled = false;\n\t\t}\n\t}\n}\nif(document.forms[0].blng_returned.checked==true)\n{\n\tdocument.forms[0].blng_returned_dt.disabled = false;\n\tdocument.getElementById(\'blng_returned_dt_img\').disabled = false;\n\tdocument.forms[0].blng_remarks.disabled = false;\n}\n\nif(document.forms[0].vlb_returned.checked==true)\n{\n}\n\nif(document.forms[0].tp_arranged.checked==true)\n{\n\tdocument.forms[0].tp_returned_dt.disabled = false;\n\tdocument.getElementById(\"tp_returned_dt_img\").disabled = false;\n\tdocument.forms[0].tp_remarks.disabled = false;\n}\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n{\n\tif(document.forms[0].iv_remove_chk.checked==true)\t\n\t{\n\t\tdocument.forms[0].iv_removed_by.disabled = false;\n\t\tdocument.forms[0].iv_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'iv_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].iv_catheters_chk.disabled = true;\n\t\tdocument.forms[0].iv_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].tubes_remove_chk.checked==true)\t\n\t{\n\t\tdocument.forms[0].tubes_removed_by.disabled = false;\n\t\tdocument.forms[0].tubes_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'tubes_removed_dt_img\').disabled = false;\t\n\t\tdocument.forms[0].tubes_chk.disabled = true;\n\t\tdocument.forms[0].tubes_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].drg_remove_chk.checked==true)\t\n\t{\n\t\tdocument.forms[0].drg_removed_by.disabled = false;\n\t\tdocument.forms[0].drg_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'drg_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].drg_chk.disabled = true;\n\t\tdocument.forms[0].drg_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].ngt_remove_chk.checked==true)\t\n\t{\n\t\tdocument.forms[0].ngt_tube_removed_by.disabled = false;\n\t\tdocument.forms[0].ngt_tube_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'ngt_tube_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].ngt_tube_chk.disabled = true;\n\t\tdocument.forms[0].ngt_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].urn_remove_chk.checked==true)\n\t{\t\n\t\tdocument.forms[0].urn_removed_by.disabled = false;\n\t\tdocument.forms[0].urn_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'urn_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].urn_chk.disabled = true;\n\t\tdocument.forms[0].urn_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].sto_remove_chk.checked==true)\n\t{\n\t\tdocument.forms[0].sto_removed_by.disabled = false;\n\t\tdocument.forms[0].sto_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'sto_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].sto_chk.disabled = true;\n\t\tdocument.forms[0].sto_remarks.disabled = false;\n\t}\n\n\tif(document.forms[0].dressing_remove_chk.checked==true)\n\t{\n\t\tdocument.forms[0].dressing_removed_by.disabled = false;\n\t\tdocument.forms[0].dressing_removed_dt.disabled = false;\n\t\tdocument.getElementById(\'dressing_removed_dt_img\').disabled = false;\n\t\tdocument.forms[0].dressing_chk.disabled = true;\n\t\tdocument.forms[0].dressing_remarks.disabled = false;\n\t}\n\t/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/\n\tif(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == \"true\")\n\t{\n\t\tif(document.forms[0].itemloan_remove_chk.checked==true)\n\t\t{\n\t\t\tdocument.forms[0].itemloan_removed_by.disabled = false;\n\t\t\tdocument.forms[0].itemloan_removed_dt.disabled = false;\n\t\t\tdocument.getElementById(\'itemloan_removed_dt_img\').disabled = false;\n\t\t\tdocument.forms[0].itemloan_chk.disabled = true;\n\t\t\tdocument.forms[0].itemloan_remarks.disabled = false;\n\t\t}\n\t\tif(document.forms[0].others_remove_chk.checked==true)\n\t\t{\n\t\t\tdocument.forms[0].others_removed_by.disabled = false;\n\t\t\tdocument.forms[0].others_removed_dt.disabled = false;\n\t\t\tdocument.getElementById(\'others_removed_dt_img\').disabled = false;\n\t\t\tdocument.forms[0].others_chk.disabled = true;\n\t\t\tdocument.forms[0].others_remarks.disabled = false;\n\t\t}\n\t}\n}\n/*End ML-MMOH-CRF-1142*/\n\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_catheters_chk.value != \'\')\ndocument.forms[0].iv_catheters_chk.disabled=true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_removed_by.value !=\'\')\ndocument.forms[0].iv_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_removed_dt.value !=\'\')\n{\n\tdocument.forms[0].iv_removed_dt.disabled = true;\n\tdocument.getElementById(\'iv_removed_dt_img\').disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_chk.value != \'\')\ndocument.forms[0].tubes_chk.disabled=true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_removed_by.value !=\'\')\ndocument.forms[0].tubes_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_removed_dt.value != \'\')\n{\n\tdocument.forms[0].tubes_removed_dt.disabled = true;\n\tdocument.getElementById(\'tubes_removed_dt_img\').disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_chk.value == \'Y\')\ndocument.forms[0].drg_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_removed_by.value != \'\')\ndocument.forms[0].drg_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_removed_dt.value != \'\')\n{\n\tdocument.forms[0].drg_removed_dt.disabled = true;\n\tdocument.getElementById(\'drg_removed_dt_img\').disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_chk.value != \'\')\ndocument.forms[0].ngt_tube_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_removed_by.value != \'\')\ndocument.forms[0].ngt_tube_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_removed_dt.value !=\'\')\n{\n\tdocument.forms[0].ngt_tube_removed_dt.disabled = true;\n\tdocument.getElementById(\'ngt_tube_removed";
    private final static byte[]  _wl_block91_0Bytes = _getBytes( _wl_block91_0 );

    private final static java.lang.String  _wl_block91_1 ="_dt_img\').disabled = true;\n}\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_chk.value != \'\')\n\tdocument.forms[0].cngt_tube_chk.disabled= true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_removed_by.value != \'\')\n\tdocument.forms[0].cngt_tube_removed_by.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_removed_dt.value != \'\')\n\t{\n\t\tdocument.forms[0].cngt_tube_removed_dt.disabled = true;\n\t\tdocument.getElementById(\'cngt_tube_removed_dt_img\').disabled = true;\n\t}\n}\n\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_chk.value != \'\')\ndocument.forms[0].urn_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_removed_by.value!=\'\')\ndocument.forms[0].urn_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_removed_dt.value != \'\')\n{\n\tdocument.forms[0].urn_removed_dt.disabled = true;\n\tdocument.getElementById(\'urn_removed_dt_img\').disabled = true;\n}\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"false\")\n{\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_chk.value != \'\')\n\tdocument.forms[0].curn_chk.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_removed_by.value != \'\')\n\tdocument.forms[0].curn_removed_by.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_removed_dt.value != \'\')\n\t{\n\t\tdocument.forms[0].curn_removed_dt.disabled = true;\n\t\tdocument.getElementById(\'curn_removed_dt_img\').disabled = true;\n\t}\n}\n\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_chk.value != \'\')\ndocument.forms[0].sto_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_removed_by.value != \'\')\ndocument.forms[0].sto_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_removed_dt.value != \'\')\n{\n\tdocument.forms[0].sto_removed_dt.disabled = true;\n\tdocument.getElementById(\'sto_removed_dt_img\').disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_chk.value != \'\')\ndocument.forms[0].dressing_chk.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_removed_by.value != \'\')\ndocument.forms[0].dressing_removed_by.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_removed_dt.value!=\'\')\n{\n\tdocument.forms[0].dressing_removed_dt.disabled = true;\n\tdocument.getElementById(\'dressing_removed_dt_img\').disabled = true;\n}\n/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/\nif(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == \"true\")\n{\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_chk.value != \'\')\n\tdocument.forms[0].itemloan_chk.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_removed_by.value != \'\')\n\tdocument.forms[0].itemloan_removed_by.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_removed_dt.value!=\'\')\n\t{\n\t\tdocument.forms[0].itemloan_removed_dt.disabled = true;\n\t\tdocument.getElementById(\'itemloan_removed_dt_img\').disabled = true;\n\t}\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_others_chk.value != \'\')\n\tdocument.forms[0].others_chk.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_others_removed_by.value != \'\')\n\tdocument.forms[0].others_removed_by.disabled = true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_others_removed_dt.value!=\'\')\n\t{\n\t\tdocument.forms[0].others_removed_dt.disabled = true;\n\t\tdocument.getElementById(\'others_removed_dt_img\').disabled = true;\n\t}\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_returned.value == \'Y\')\ndocument.forms[0].blng_returned.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_returned_dt.value != \'\')\n{\n\tdocument.forms[0].blng_returned_dt.disabled = true;\n\tdocument.getElementById(\'blng_returned_dt_img\').disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_remarks.value != \'\')\ndocument.forms[0].blng_remarks.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_arranged.value != \'\')\ndocument.forms[0].tp_arranged.disabled = true;\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_returned_dt.value!=\'\')\n{\n\tdocument.forms[0].tp_returned_dt.disabled = true;\n\tdocument.getElementById(\"tp_returned_dt_img\").disabled = true;\n}\nif(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_remarks.value!=\'\')\ndocument.forms[0].tp_remarks.disabled = true;\n\n/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/\nif(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == \"true\")\n{\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_remove_chk.value != \'\')\n\tdocument.forms[0].iv_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_remarks.value !=\'\')\n\tdocument.forms[0].iv_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_remove_chk.value != \'\')\n\tdocument.forms[0].tubes_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_remarks.value !=\'\')\n\tdocument.forms[0].tubes_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_remove_chk.value != \'\')\n\tdocument.forms[0].drg_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_remarks.value !=\'\')\n\tdocument.forms[0].drg_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_remove_chk.value != \'\')\n\tdocument.forms[0].ngt_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_remarks.value !=\'\')\n\tdocument.forms[0].ngt_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_remove_chk.value != \'\')\n\tdocument.forms[0].urn_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_remarks.value !=\'\')\n\tdocument.forms[0].urn_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_remove_chk.value != \'\')\n\tdocument.forms[0].sto_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_remarks.value !=\'\')\n\tdocument.forms[0].sto_remarks.disabled = true;\n\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_remove_chk.value != \'\')\n\tdocument.forms[0].dressing_remove_chk.disabled=true;\n\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_remarks.value !=\'\')\n\tdocument.forms[0].dressing_remarks.disabled = true;\n\t/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/\n\tif(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == \"true\")\n\t{\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_remove_chk.value != \'\')\n\t\tdocument.forms[0].itemloan_remove_chk.disabled=true;\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_remarks.value !=\'\')\n\t\tdocument.forms[0].itemloan_remarks.disabled = true;\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_others_remove_chk.value != \'\')\n\t\tdocument.forms[0].others_remove_chk.disabled=true;\n\t\tif(parent.DischargeCheckList_frame1.document.forms[0].hh_others_remarks.value !=\'\')\n\t\tdocument.forms[0].others_remarks.disabled = true;\n\t}\n}\n/*End ML-MMOH-CRF-1142*/\n\n</script>\n";
    private final static byte[]  _wl_block91_1Bytes = _getBytes( _wl_block91_1 );

    private final static java.lang.String  _wl_block92 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

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
String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con				= null;
PreparedStatement pstmt		= null;
ResultSet rset				= null; 
String locale				= (String)session.getAttribute("LOCALE");
String facility_Id			= (String)session.getValue("facility_id");
String practitioner_name	= "";
String appl_user_name		= "";
String witness_name			= "";
String witness_id			= request.getParameter("witness_id")==null?"":request.getParameter("witness_id");
String witness_user			= request.getParameter("witness_user")==null?"":request.getParameter("witness_user");
String facility_id			= (String)session.getValue("facility_id");
String call_function		= request.getParameter("call_function")==null?"":request.getParameter("call_function");

String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
Boolean isChangesInAdditionalDtlsTabAppl = false;
String alignCenter = "";
/*End ML-MMOH-CRF-1142*/

//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
Boolean isItemOnLoanOthersDisableDateAppl = false;
String disable_fld			= "";
if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld				= "disabled";
}

try
{
	con = ConnectionManager.getConnection(request);

	isChangesInAdditionalDtlsTabAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","DISCHRG_CHKLST_ADD_DTLS"); //Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
	isItemOnLoanOthersDisableDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "ADD_ITEMS_AND_DISBL_DATE"); //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218

	if(!witness_id.equals(""))
	{

		//pstmt = con.prepareStatement("SELECT unique appl_user_name FROM sm_appl_user, pr_patient_valuables WHERE appl_user_id = witness_id and APPL_USER_ID = '"+witness_id+"' ");
		/*Wednesday, September 15, 2010, SRR20056-SCF-5169-IN023708*/
		pstmt = con.prepareStatement("SELECT sm_get_desc.sm_appl_user(witness_id,'"+locale+"',1) witness_name ,am_get_desc.am_practitioner(witness_id,'"+locale+"',1) pract_name FROM  pr_patient_valuables WHERE encounter_id='"+encounter_id+"' and patient_id='"+patient_id+"' and facility_id='"+facility_Id+"' ");

		rset = pstmt.executeQuery();
		if (rset.next())
		{
			witness_name	  = rset.getString(1) == null ? "" : rset.getString(1);
			if(witness_name.equals(""))
				practitioner_name = rset.getString(2)  == null ? "" : rset.getString(2);
			
			if(practitioner_name.equals(""))
				practitioner_name = witness_name ;
		}

		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}
	if(pstmt!=null)pstmt.close();
	if(rset!=null)rset.close();	

	if(!witness_user.equals(""))
	{
		
		pstmt = con.prepareStatement("select appl_user_name  from sm_appl_user_lang_vw where appl_user_id = '"+witness_user+"' and language_id = '"+locale+"'");
		rset = pstmt.executeQuery();
		if (rset.next())
		{
			appl_user_name = rset.getString(1);
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}
	if(pstmt!=null)pstmt.close();
	if(rset!=null)rset.close();

}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(isChangesInAdditionalDtlsTabAppl){
	 alignCenter = "align='center'";
}
            _bw.write(_wl_block8Bytes, _wl_block8);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(!isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(!isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
if(isItemOnLoanOthersDisableDateAppl){
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alignCenter));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
if(isChangesInAdditionalDtlsTabAppl){
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(isChangesInAdditionalDtlsTabAppl));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(isItemOnLoanOthersDisableDateAppl));
            _bw.write(_wl_block90_0Bytes, _wl_block90_0);
            _bw.write(_wl_block90_1Bytes, _wl_block90_1);

if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{

            _bw.write(_wl_block91_0Bytes, _wl_block91_0);
            _bw.write(_wl_block91_1Bytes, _wl_block91_1);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RemovalOf.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Keep.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Remove.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RemovedDoneby.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IVCatheters.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Tubes.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DrainageCatheters.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NasogastricTube.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ChangeofNasogastricTube.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.UrinaryCatheter.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ChangeofUrinaryCatheter.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.STO.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ItemOnLoan.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Properties.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BelongingsReturned.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ValuablesReturned.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returnedby.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Witness.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Transport.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransportArranged.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

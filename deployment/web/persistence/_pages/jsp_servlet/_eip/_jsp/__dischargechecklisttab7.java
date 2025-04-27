package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __dischargechecklisttab7 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListTab7.jsp", 1729590639537L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DischargeCheckListTab7\' id=\'DischargeCheckListTab7\'>\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=3>&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t</tr>\n\t<tr></tr>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\'>&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\'><input type=\'text\' name=\'oth_app_fix_item1\' id=\'oth_app_fix_item1\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item1_given1\' id=\'oth_app_fix_item1_given1\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item1_dt1\' id=\'oth_app_fix_item1_dt1\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><input type=\"image\"  id=\"oth_app_fix_item1_dt1_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item1_dt1.select();return showCalendar(\'oth_app_fix_item1_dt1\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item2\' id=\'oth_app_fix_item2\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item2_given2\' id=\'oth_app_fix_item2_given2\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item2_dt2\' id=\'oth_app_fix_item2_dt2\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input type=\"image\"  id=\"oth_app_fix_item2_dt2_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item2_dt2.select();return showCalendar(\'oth_app_fix_item2_dt2\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item3\' id=\'oth_app_fix_item3\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item3_given3\' id=\'oth_app_fix_item3_given3\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item3_dt3\' id=\'oth_app_fix_item3_dt3\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><input type=\"image\" id=\"oth_app_fix_item3_dt3_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item3_dt3.select();return showCalendar(\'oth_app_fix_item3_dt3\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item4\' id=\'oth_app_fix_item4\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item4_given4\' id=\'oth_app_fix_item4_given4\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item4_dt4\' id=\'oth_app_fix_item4_dt4\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="><input type=\"image\" id=\"oth_app_fix_item4_dt4_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item4_dt4.select();return showCalendar(\'oth_app_fix_item4_dt4\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item5\' id=\'oth_app_fix_item5\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item5_given5\' id=\'oth_app_fix_item5_given5\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item5_dt5\' id=\'oth_app_fix_item5_dt5\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="><input type=\"image\" id=\"oth_app_fix_item5_dt5_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item5_dt5.select();return showCalendar(\'oth_app_fix_item5_dt5\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item6\' id=\'oth_app_fix_item6\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item6_given6\' id=\'oth_app_fix_item6_given6\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item6_dt6\' id=\'oth_app_fix_item6_dt6\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><input type=\"image\" id=\"oth_app_fix_item6_dt6_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item6_dt6.select();return showCalendar(\'oth_app_fix_item6_dt6\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item7\' id=\'oth_app_fix_item7\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item7_given7\' id=\'oth_app_fix_item7_given7\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item7_dt7\' id=\'oth_app_fix_item7_dt7\' size=\'16\' maxlength=\'16\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\" ><input type=\"image\" id=\"oth_app_fix_item7_dt7_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item7_dt7.select();return showCalendar(\'oth_app_fix_item7_dt7\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item8\' id=\'oth_app_fix_item8\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item8_given8\' id=\'oth_app_fix_item8_given8\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item8_dt8\' id=\'oth_app_fix_item8_dt8\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" ><input type=\"image\" id=\"oth_app_fix_item8_dt8_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item8_dt8.select();return showCalendar(\'oth_app_fix_item8_dt8\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item9\' id=\'oth_app_fix_item9\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item9_given9\' id=\'oth_app_fix_item9_given9\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item9_dt9\' id=\'oth_app_fix_item9_dt9\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="><input type=\"image\" id=\"oth_app_fix_item9_dt9_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item9_dt9.select();return showCalendar(\'oth_app_fix_item9_dt9\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item10\' id=\'oth_app_fix_item10\' size=\'50\' maxlength=\'80\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item10_given10\' id=\'oth_app_fix_item10_given10\' size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t<td class=\'fileds\' ><input type=\'text\' name=\'oth_app_fix_item10_dt10\' id=\'oth_app_fix_item10_dt10\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT_tab7(event);\" onBlur=\"chk_with_sysdate_tab2(this);\"  ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="><input type=\"image\" id=\"oth_app_fix_item10_dt10_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].oth_app_fix_item10_dt10.select();return showCalendar(\'oth_app_fix_item10_dt10\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="></td>\n\t</tr>\n<table>\n</form>\n<script>\n\tdocument.forms[0].oth_app_fix_item1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item1.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item1_given1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1_given1.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1_given1.value!=\'\')document.forms[0].oth_app_fix_item1_given1.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item1_dt1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1_dt1.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1_dt1.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item1_dt1.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item1_dt1_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item2.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item2_given2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2_given2.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2_given2.value!=\'\')document.forms[0].oth_app_fix_item2_given2.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item2_dt2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2_dt2.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2_dt2.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item2_dt2.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item2_dt2_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item3.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item3_given3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3_given3.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3_given3.value!=\'\')document.forms[0].oth_app_fix_item3_given3.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item3_dt3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3_dt3.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3_dt3.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item3_dt3.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item3_dt3_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item4.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item4_given4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4_given4.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4_given4.value!=\'\')document.forms[0].oth_app_fix_item4_given4.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item4_dt4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4_dt4.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4_dt4.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item4_dt4.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item4_dt4_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item5.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item5_given5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5_given5.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5_given5.value!=\'\')document.forms[0].oth_app_fix_item5_given5.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item5_dt5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5_dt5.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5_dt5.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item5_dt5.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item5_dt5_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item6.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item6_given6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6_given6.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6_given6.value!=\'\')document.forms[0].oth_app_fix_item6_given6.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item6_dt6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6_dt6.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6_dt6.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item6_dt6.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item6_dt6_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item7.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item7_given7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7_given7.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7_given7.value!=\'\')document.forms[0].oth_app_fix_item7_given7.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item7_dt7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7_dt7.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7_dt7.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item7_dt7.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item7_dt7_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item8.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item8_given8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8_given8.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8_given8.value!=\'\')document.forms[0].oth_app_fix_item8_given8.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item8_dt8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8_dt8.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8_dt8.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item8_dt8.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item8_dt8_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item9.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item9_given9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9_given9.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9_given9.value!=\'\')document.forms[0].oth_app_fix_item9_given9.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item9_dt9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9_dt9.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9_dt9.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item9_dt9.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item9_dt9_img\").disabled = true;\n\t}\n\n\tdocument.forms[0].oth_app_fix_item10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10.value!=\'\')\n\tdocument.forms[0].oth_app_fix_item10.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item10_given10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10_given10.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10_given10.value!=\'\')document.forms[0].oth_app_fix_item10_given10.disabled = true;\n\n\tdocument.forms[0].oth_app_fix_item10_dt10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10_dt10.value;\n\tif(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10_dt10.value!=\'\')\n\t{\n\t\tdocument.forms[0].oth_app_fix_item10_dt10.disabled = true;\n\t\tdocument.getElementById(\"oth_app_fix_item10_dt10_img\").disabled = true;\n\t}\n\n\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

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

request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disable_fld));
            _bw.write(_wl_block51Bytes, _wl_block51);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OtherAppliancesFixtures.label", java.lang.String .class,"key"));
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
}

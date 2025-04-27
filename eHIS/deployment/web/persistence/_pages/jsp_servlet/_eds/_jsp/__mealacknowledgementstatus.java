package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealacknowledgementstatus extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealAcknowledgementStatus.jsp", 1724570962000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- New file MealAcknowledgementStatus.jsp created against ML-MMOH-CRF-1061-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\"javascript\" src=\"../../eDS/js/MealAcknowledgementStatus.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onload=\"changeStatus_OP();changeStatus_IP();\">\n\t\t<br>\n\t\t<form target=\"messageFrame\" name=\"MealAcknowledgementStatusForm\" id=\"MealAcknowledgementStatusForm\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"BORDER\">\n\t\t\t\t\t<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\">\n\t\t\t\t\t   <b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t</b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</td>\n\t\t\t\t\t<td class=\"BORDERX\">\n\t\t\t\t\t\t<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t<tr>\t \n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t    <select name=\"noOfStatusRequired_OP\" id=\"noOfStatusRequired_OP\" id=\"noOfStatusRequired_OP\" onchange=\"changeStatus_OP(this);\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t        <option value=\"3\" selected>ALL</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t    <option value=\"3\">ALL</option >\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<option value=\"2\" selected>2</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t    <option value=\"2\">2</option >\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr name=\"OP_served\" id=\"OP_served\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t\t<td align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"served\" id=\"served\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\"15\" maxlength=\"15\"/>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img >\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr name=\"OP_accept\" id=\"OP_accept\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"accept\" id=\"accept\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr name=\"OP_reject\" id=\"OP_reject\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"reject\" id=\"reject\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"noOfStatusRequired_OP\" id=\"noOfStatusRequired_OP\" id=\"noOfStatusRequired_OP\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"served\" id=\"served\" id=\"served\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"served1\" id=\"served1\" id=\"status_desc1\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"accept\" id=\"accept\" id=\"accept\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"accept1\" id=\"accept1\" id=\"status_desc2\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reject\" id=\"reject\" id=\"reject\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reject1\" id=\"reject1\" id=\"status_desc3\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"patient_class_OP\" id=\"patient_class_OP\" id=\"patient_class_OP\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code1\" id=\"status_code1\" id=\"status_code1\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code2\" id=\"status_code2\" id=\"status_code2\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code3\" id=\"status_code3\" id=\"status_code3\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/> \n\t\t\t<input type=\"hidden\" name=\"OPstatus_Ser_YN\" id=\"OPstatus_Ser_YN\" id=\"OPstatus_Ser_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"OPstatus_Acc_YN\" id=\"OPstatus_Acc_YN\" id=\"OPstatus_Acc_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"OPstatus_Rej_YN\" id=\"OPstatus_Rej_YN\" id=\"OPstatus_Rej_YN\" value=\"Y\"/>\t\t\t\n\t\t\t\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<tr>\n\t\t\t<td class=\"BORDER\">\n\t\t\t\t\t<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\">\n\t\t\t\t\t   <b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t</b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"100%\" class=\"BORDERX\">\n\t\t\t\t\t\t<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t        <select name=\"noOfStatusRequired_IP\" id=\"noOfStatusRequired_IP\" id=\"noOfStatusRequired_IP\"  onchange=\"changeStatus_IP(this)\";>\n\t\t\t\t            ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<option value=\"4\" selected>ALL</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<option value=\"4\">ALL</option >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<option value=\"3\" selected>3</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<option value=\"3\">3</option >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t<option value=\"2\" selected>2</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<option value=\"2\">2</option >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t   </td>\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t<tr name=\"IP_MealPrepared\" id=\"IP_MealPrepared\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"MealPrepared\" id=\"MealPrepared\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr name=\"IP_MealReceived\" id=\"IP_MealReceived\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"MealReceived\" id=\"MealReceived\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t<tr name=\"IP_MealServed\" id=\"IP_MealServed\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"MealServed\" id=\"MealServed\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr name=\"IP_MealRejected\" id=\"IP_MealRejected\">\n\t\t\t\t<td align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"MealRejected\" id=\"MealRejected\"  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\"noOfStatusRequired_IP\" id=\"noOfStatusRequired_IP\" id=\"noOfStatusRequired_IP\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"patient_class_IP\" id=\"patient_class_IP\" id=\"patient_class_IP\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealPrepared\" id=\"MealPrepared\" id=\"MealPrepared\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealPrepared1\" id=\"MealPrepared1\" id=\"status_desc_MP\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealReceived\" id=\"MealReceived\" id=\"MealReceived\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealReceived1\" id=\"MealReceived1\" id=\"status_desc_MR\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealServed\" id=\"MealServed\" id=\"MealServed\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealServed1\" id=\"MealServed1\" id=\"status_desc_MS\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealRejected\" id=\"MealRejected\" id=\"MealRejected\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"MealRejected1\" id=\"MealRejected1\" id=\"status_desc_MJ\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code_MP\" id=\"status_code_MP\" id=\"status_code_MP\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code_MR\" id=\"status_code_MR\" id=\"status_code_MR\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code_MS\" id=\"status_code_MS\" id=\"status_code_MS\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"status_code_MJ\" id=\"status_code_MJ\" id=\"status_code_MJ\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Pre_YN\" id=\"IPstatus_Pre_YN\" id=\"IPstatus_Pre_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Rec_YN\" id=\"IPstatus_Rec_YN\" id=\"IPstatus_Rec_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Ser_YN\" id=\"IPstatus_Ser_YN\" id=\"IPstatus_Ser_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Rej_YN\" id=\"IPstatus_Rej_YN\" id=\"IPstatus_Rej_YN\" value=\"Y\"/>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\n\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"DS_MEAL_ACKNOWLEDGEMENT_STATUS\"/>\n\t\t\t<input type=\"hidden\" name=\"moduleId\" id=\"moduleId\" value=\"DS\"/>\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n\t\t\t</form>\n\t</body>\n</html>\n\t\t\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id	= (String)session.getAttribute("facility_id");
	String locale = (String) session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

   int noOfStatusRequired_OP = 0;
   String patient_class_OP="OP";
   String status_code_OP="";
   String status_desc_OP="";
   String patient_class="";
   String status_desc1="";
   String status_desc2="";
   String status_desc3="";
   String status_code1="";
   String status_code2="";
   String status_code3="";
   String OPstatus_Ser_YN="";
   String OPstatus_Acc_YN="";
   String OPstatus_Rej_YN="";
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			String sql = "",sql_OPstatus="";
	try{
			con=ConnectionManager.getConnection(request);
			
		sql= "SELECT patient_class, status_code, status_desc FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_OP+"' ORDER BY patient_class, disp_sl_no DESC";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();	
		while (rs != null && rs.next()) {
		patient_class = checkForNull(rs.getString(1));
		status_code_OP = checkForNull(rs.getString(2));
		status_desc_OP = checkForNull(rs.getString(3));	
			if(patient_class.equalsIgnoreCase("OP")){
				if(status_code_OP.equalsIgnoreCase("MS")){
						status_code1 = rs.getString(2);
						status_desc1 = rs.getString(3);
				}else if(status_code_OP.equalsIgnoreCase("MA")){
						status_code2 = rs.getString(2);			
						status_desc2 = rs.getString(3);
				}else if(status_code_OP.equalsIgnoreCase("MR")){
						status_code3 = rs.getString(2);				
						status_desc3 = rs.getString(3);
				}
			}
		}
		
			sql_OPstatus= "Select NO_OF_ACK_STATUS_OP from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
			stmt=con.prepareStatement(sql_OPstatus);
			rs=stmt.executeQuery();
			while (rs != null && rs.next()){
			noOfStatusRequired_OP = rs.getInt(1);
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(noOfStatusRequired_OP==3){
					
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
					
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
if(noOfStatusRequired_OP==2){
					
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
					
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(noOfStatusRequired_OP));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class_OP));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status_code1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(status_code2));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(status_code3));
            _bw.write(_wl_block33Bytes, _wl_block33);
  
}catch (Exception e) {
			e.printStackTrace();
			System.err.println("156 Exception==" + e);
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con);
		}

            _bw.write(_wl_block34Bytes, _wl_block34);

   int noOfStatusRequired_IP = 0;
   String patient_class_IP="IP";
   String status_code_IP="";
   String status_desc_IP="";
   String status_desc_MP="";
   String status_desc_MR="";
   String status_desc_MS="";
   String status_desc_MJ="";
   String status_code_MP="";
   String status_code_MR="";
   String status_code_MS="";
   String status_code_MJ="";
   String IPstatus_Pre_YN="";
   String IPstatus_Rec_YN="";
   String IPstatus_Ser_YN="";
   String IPstatus_Rej_YN="";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String sql_Query ="", sql_IPstatus="";

			try
		    {
		        conn=ConnectionManager.getConnection(request);	
		
		sql_Query= "SELECT patient_class, status_code, status_desc FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_IP+"' ORDER BY patient_class, disp_sl_no DESC";
		pstmt=conn.prepareStatement(sql_Query);
		rst=pstmt.executeQuery();
		while (rst.next()){
		patient_class = checkForNull(rst.getString(1));
		status_code_IP = checkForNull(rst.getString(2));
		status_desc_IP = checkForNull(rst.getString(3));
			
			if(patient_class.equalsIgnoreCase("IP")){
				if(status_code_IP.equalsIgnoreCase("MP")){
						status_code_MP = rst.getString(2);
						status_desc_MP = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MR")){
						status_code_MR = rst.getString(2);			
						status_desc_MR = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MS")){
						status_code_MS = rst.getString(2);				
						status_desc_MS = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MJ")){
						status_code_MJ = rst.getString(2);				
						status_desc_MJ = rst.getString(3);
				}
			}
		}
		
		sql_IPstatus= "Select NO_OF_ACK_STATUS_IP from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt=conn.prepareStatement(sql_IPstatus);
			System.err.println("220 sql_IPstatus==>"+sql_IPstatus);
			rst=pstmt.executeQuery();
			while (rst != null && rst.next()){
			noOfStatusRequired_IP = rst.getInt(1);
			System.err.println("223 noOfStatusRequired_IP==>"+noOfStatusRequired_IP);
			}
		
	
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
if(noOfStatusRequired_IP==4){
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(noOfStatusRequired_IP==3){
							
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(noOfStatusRequired_IP==2){
							
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(status_desc_MP));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(status_desc_MR));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(status_desc_MS));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(status_desc_MJ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(noOfStatusRequired_IP));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_class_IP));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(status_desc_MP));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(status_desc_MP));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(status_desc_MR));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(status_desc_MR));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(status_desc_MS));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(status_desc_MS));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(status_desc_MJ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(status_desc_MJ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(status_code_MP));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(status_code_MR));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(status_code_MS));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(status_code_MJ));
            _bw.write(_wl_block67Bytes, _wl_block67);
}catch (Exception e) {
			e.printStackTrace();
			System.err.println("254 Exception==" + e);
		} finally {
			if (rst != null) rst.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(conn);
		}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DefineStatusForDocument/AcknowledgeOP/EMPatientMealOrder.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.NumberOfStatusRequired.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.served.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.accept.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.reject.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DefineStatusForDocument/AcknowledgeMealPrepared/Served/Complaints.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.NumberOfStatusRequired.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealPrepared.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealReceived.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealServed.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealReject.Label", java.lang.String .class,"key"));
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
}

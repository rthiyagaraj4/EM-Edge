package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.resources.*;
import eCommon.Common.*;
import eBL.BillingPrevilageCardPatientBean;
import eBL.BillingPrevilageCardMemberBean;
import eBL.BillingPrevilageCardVisiiUtilizationBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billingmaintainprevilagecardpatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingMaintainPrevilageCardPatientDetails.jsp", 1709114364620L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n<html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n    <!--<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> -->\n        <script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\" ></script>\t\t\n\n        \n        <script language =\"javaScript\"    src =\'../../eCommon/js/CommonLookup.js\'></Script>\t\n\t\t<script language=\"javascript\"     src=\"../../eCommon/js/ValidateControl.js\"></script> \n\t\t<script language=\'javascript\'     src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\n\t \t<script language=\"javascript\" src=\"../../eBL/js/BLPatientEncounters.js\"></script> \t\n\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/BillingMainatainPrevilageCard.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\n\t\t\n\n\t\t\n\t  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eBL/html/ui.dropdownchecklist.css\" />\n         <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eBL/html/main.css\" />\n    \n\n      \n  \n\t\n</head>\n\n\n<BODY onLoad=\"  \"  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\" >\n\n<FORM method=\'post\' name=\"BillingMaintainPrevilageCardPatientDetails\" id=\"BillingMaintainPrevilageCardPatientDetails\"  id=\"BillingMaintainPrevilageCardPatientDetails\"  action=\"\" >\n\n     <table align=\'center\' border=\'0\' cellpadding=3 cellspacing=0  width=\'100%\' align=\"center\"> \t\t\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\'  align=\'left\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" - ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </th>\n\t\t\t\t</tr>\n\t\t\t\t\n\t</table>\n\t\t\n\t\t   \n    \n    <!--  table border=\'0\' cellspacing=\"5\"-->    \n  \n    \n    \n    <table border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\' >\n\t\t<tr>\n\t\t\t<td class=\'fields\' width=\"10%\"></td>\n\t\t\t<td class=\'fields\' width=\"55%\"></td>\n\t\t\t<td class=\'fields\' width=\"55%\"></td>\n\t\t\t<td class=\'fields\' width=\"55%\"></td>\n\t\t\t<td ><input type=\"button\" class=\'button\' name=\"addnew\" id=\"addnew\"\tid=\"addnew\"   value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\tonclick=\"addNewRow(\'patient_subscribe_modify\',\'patient_id\');\" /></td>\t\n \t\t\t<td ><input type=\"button\" class=\'button\' name=\"reprint\" id=\"reprint\"\tid=\"reprint\"   value=\"Reprint\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" style=\"visibility: hidden;\" /></td>\n\n\t\t</tr>\n\t</table>\n\t\t\t\n  \n   <table align=\'center\' border=\'0\' cellpadding=2 cellspacing=0  width=\'100%\'  id=\"patient_subscribe_modify_header\" name=\"patient_subscribe_modify_header\" id=\"patient_subscribe_modify_header\"> \n    \n      \t<tr>\n\t\t     <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<img src=\'../../eCommon/images/mandatory.gif\'> </th> \n\t\t     <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\t\t\t\t\t \n\t         <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\t\n\t         <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t         <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\t\n\t\t\t \n    \t </tr>  \n    </table>\n <div id=\"patient_subscribe_modify_div\" name=\"patient_subscribe_modify_div\" style=\"width:100%; height:120; overflow: auto;\">\n   \t<table align=\'center\' border=\'0\' cellpadding=2 cellspacing=0  width=\'100%\'  id=\"patient_subscribe_modify\" name=\"patient_subscribe_modify\" id=\"patient_subscribe_modify\"> \n  \n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="   \t\t\n \t \t\t<tr>\n\t\t\t     <td class=\"fields\" width=\"1%\"><input type=\"text\"  \tname=\"patient_id";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"patient_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \t\t\t\tid=\"patient_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\t\t\tsize=\"15\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  \tonKeyPress=\'changeToUpper()\' \t\tonBlur=\"\" \t></td>         \n\t\t\t\t <td class=\"fields\" width=\"1%\"><input type=\"text\"  \tname=\"patient_name";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"patient_name";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\t\t\t\tid=\"patient_name";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" \t\tsize=\"25\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="  \tonKeyPress=\'changeToUpper()\' \t\tonBlur=\"\" \t></td>         \n\t\t\t\t <td class=\"fields\" width=\"1%\"><input type=\'text\' \tname=\"patient_age";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"patient_age";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"\t\t\t\tid=\"patient_age";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" \t\t\tsize=\"15\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonKeyPress=\'ChkNumberInput()\' \t\tonBlur=\"\"\t></td> \n\t\t\t\t <td class=\"fields\" width=\"1%\"><select style=\" width: 200px; \" id=\"price_class_Code";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" name=\"price_class_Code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t              ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t              <option title=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" > ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </option>\n\t\t              ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t     \t\t\t\t\t\t\t\t</select></td>       \n\t\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t \t <td class=\"fields\" width=\"1%\"><input type=\"checkbox\"\tname=\"chk";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"chk";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\t\t\t\t\t\tid=\"chk";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" \t\t\t\t\tvalue=\'\'  \tonKeyPress=\'ChkNumberInput()\'  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\tonBlur=\"\"\tonclick=\"checkSelected(this)\"></td> \n\t\t\t \t\t\t\t\t\t \t\t   <input type=\"hidden\"  \tname=\"type";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"type";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  \t\t\t\t\t\tid=\"type";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\t \t\t\t\tvalue=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'\t/>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n \t</table>\n</div>\n    \n    <br/>\n    \n    <TABLE align=\'center\' border=\'0\' cellpadding=3 cellspacing=0  width=\'100%\' align=\"center\"> \t\t\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\'  align=\'left\' >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t</table>\n   \t<br/>\t\n\n\t   \n    ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n    <!--  table border=\'0\' cellspacing=\"5\"-->    \n    \n    <table align=\'center\' border=\'0\' cellpadding=3 cellspacing=0  width=\'100%\' align=\"center\">\n    ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n    <tr>\n        <td class=\"label\" width=\"4%\" nowrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\t\n\t\t<td class=\"fields\" ><input type=\"text\"  name=\"op_allotement\" id=\"op_allotement\" id=\"op_allotement\" size=\"17\" maxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="  onKeyPress=\'changeToUpper()\' onBlur=\"\" ></td>\n\t \t\n\t\t<td class=\"label\" width=\"4%\" nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\t\n\t\t<td class=\"fields\" ><input type=\"text\"  name=\"till_date\" id=\"till_date\" \tid=\"till_date\"\tsize=\"17\" maxlength=\'12\' \t\tvalue=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" onKeyPress=\'changeToUpper()\' onBlur=\"\" ></td>\n\t\t\n\t\t<td class=\"label\" width=\"4%\" nowrap style=\"visibility: hidden;\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\t\n\t\t<td class=\"fields\" ><input type=\"checkbox\" checked=\"checked\" style=\"visibility: hidden;\"></td>\n\t\t\t\t\n\t</tr>  \n    </table>\t\t\n  \n\t\n   \t\n <div id=\"patient_visiit_utilization_header_div\" name=\"patient_visiit_utilization_header_div\"  >  \t\t\n    \n    <table align=\'center\' border=\'1\' cellpadding=3 cellspacing=0  width=\'100%\' > \n\n      <tr>\n\t     <th class=\'CAFLOWSHEETLEVEL1\' width=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</th>\t\t  \t\t\t   \n\t\t <th class=\'CAFLOWSHEETLEVEL1\' width=\"2%\"\talign=\'left\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</th>\t\t\t\t\t   \n         <th class=\'CAFLOWSHEETLEVEL1\' width=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</th>\t\n         <th class=\'CAFLOWSHEETLEVEL1\' width=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</th>\t \n\t  </tr>\n\t</table>\n</div>\n<div id=\"patient_visiit_utilization_div\" name=\"patient_visiit_utilization_div\" style=\"width:100%; height:60; overflow: auto;\">\n\t <table align=\'center\' border=\'0\' cellpadding=3 cellspacing=0  width=\'100%\' >\t  \n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t  \n\t <tr>\n     \t<td class=\"fields\"  width=\"1%\"><input type=\"text\"  name=\"clinic";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"clinic";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" \t\t\tid=\"clinic";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="  \tonKeyPress=\'changeToUpper()\' \tonBlur=\"\" \t></td>         \n\t \t<td class=\"fields\"  width=\"2%\"><input type=\"text\"  name=\"visit_type";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"visit_type";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" \t\tid=\"visit_type";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"\t\tsize=\"38\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  \tonKeyPress=\'changeToUpper()\' \tonBlur=\"\" \t></td>         \n\t \t<td class=\"fields\"  width=\"1%\"><input type=\'text\' \tname=\"no_of_visit";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"no_of_visit";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" \tid=\"no_of_visit";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\t\tsize=\"25\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="  \tonKeyPress=\'ChkNumberInput()\' \tonBlur=\"\"\t></td> \n\t \t<td class=\"fields\"  width=\"1%\"><input type=\'text\' \tname=\"availed";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"availed";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" \t\tid=\"availed";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"\t\t\tsize=\"25\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="  \tonKeyPress=\'ChkNumberInput()\' \tonBlur=\"\"\t></td> \n\t \n     </tr>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="     \n    </table>\t\n </div>   \n   \n   \t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' \t\t\t\t \tid=\'locale\'  \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\t \t     \tid=\'facilityId\'  \t\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' \t\t\t\t \tid=\'mode\' \t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t\t<input type=\'hidden\' name=\'authorized\' id=\'authorized\'\t\t\t \tid=\'authorized\'  \t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" /> \n\t\t<input type=\'hidden\' name=\'isUserCanAcess\' id=\'isUserCanAcess\'\t\t \tid=\'isUserCanAcess\' \t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" />\n\t\t<input type=\'hidden\' name=\'hiddenCardTypeCode\' id=\'hiddenCardTypeCode\' \t \tid=\'hiddenCardTypeCode\'\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPatientId\' id=\'hiddenPatientId\' \t \tid=\'hiddenPatientId\'\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPriceClasscode\' id=\'hiddenPriceClasscode\' \tid=\'hiddenPriceClasscode\'\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPriceClassDesc\' id=\'hiddenPriceClassDesc\' \tid=\'hiddenPriceClassDesc\'\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\'\t\t\t \tid=\'rowCount\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\'\t\t\t \tid=\'from_date\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\'hidden\' name=\'hCardSeqnNo\' id=\'hCardSeqnNo\'\t\t\t \tid=\'hCardSeqnNo\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenhiddenPackageCode\' id=\'hiddenhiddenPackageCode\'\tid=\'hiddenhiddenPackageCode\'value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\'\t\t\t\t\tid=\'to_date\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\'hidden\' name=\'member_fees\' id=\'member_fees\'\t\t\t\tid=\'member_fees\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\'hidden\' name=\'billingServiceCode\' id=\'billingServiceCode\'\t\tid=\'billingServiceCode\'\t\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\'hidden\' name=\'primaryPatientId\' id=\'primaryPatientId\' \t \tid=\'primaryPatientId\'\t\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\n\t\t<input type=\'hidden\' name=\'oPAllotement\' id=\'oPAllotement\'\t\t\tid=\'oPAllotement\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\'hidden\' name=\'oPAvailed\' id=\'oPAvailed\'\t\t\t\tid=\'oPAvailed\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\n\t\t\n   \t</form>\n</body>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n</html>\n\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode														=	new String();
String locale															=	"";
String facilityId														=	"";
String hiddenPatientId													=	"";
String patientDetails													=	"";
String mode																=	"";
String isUserCanAcess													=	"";
String sStyle 															=	"";
String authorized 														=	"";
String bean_id															=	"";
String bean_name														=	"";
String bean_id1															=	"";
String bean_name1														=	"";
String bean_id2															=	"";
String bean_name2														=	"";
String hiddenPriceClasscode												=	"";
String hiddenPriceClassDesc												=	"";
String hiddenCardTypeCode												=	"";
String hiddenCardTypeDesc												=	"";
String rowCount															=	"";
ArrayList<String[]> PatientDetailsList									=	null;
ArrayList<String[]> visitUtilizationDetailsList							=	null;
ArrayList			 PrevilageCardList									=	null;
String cardIndex														=	null;
String hCardSeqnNo														=	null;
String priceClassCode													=	null;
String priceClassDesc													=	null;
String prmaryPatientId													=	null;
String from_date														=	null;
String toDate															= 	null;
String mebnmberFees														=	null;
String billingServiceCode												=	null;
String hiddenhiddenPackageCode											=	null;
String oPAllotement														=	null;
String oPAvailed														=	null;
String defaultCode														=	"";
String disableMode														=	"DISABLED";
String readonly															=	"DISABLED";
String primaryPatientId													=	"";
ArrayList<String[]> priceClassCodeAndDescList							= 	null;

try
{
	
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	bean_id1																				= 	"BillingPrevilageCardMemberBean" ;
	bean_name1																				= 	"eBL.BillingPrevilageCardMemberBean";
	BillingPrevilageCardMemberBean billingPrevilageCardMemberBean							= 	(BillingPrevilageCardMemberBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean_id2																				= 	"BillingPrevilageCardVisiiUtilizationBean" ;
	bean_name2																				= 	"eBL.BillingPrevilageCardVisiiUtilizationBean";
	BillingPrevilageCardVisiiUtilizationBean billingPrevilageCardVisiiUtilizationBean		= 	(BillingPrevilageCardVisiiUtilizationBean)getBeanObject( bean_id2, bean_name2, request ) ;
	PatientDetailsList																		= 	new ArrayList();
	hiddenPatientId																			=	checkForNull(request.getParameter("hiddenPatientId"));
	//billingPrevilageCardPatientBean.getBillingPrevilageCardPatient(hiddenPatientId, facilityId,locale);
 	hiddenPriceClasscode																	=	checkForNull(request.getParameter("priceClassCode"));
 	hiddenPriceClassDesc																	=	checkForNull(request.getParameter("priceClassDesc"));
 	hiddenCardTypeCode																		=	checkForNull(request.getParameter("cardTypeCode")); 
 	hiddenCardTypeDesc																		=	checkForNull(request.getParameter("cardTypeDesc"));
 	hiddenhiddenPackageCode																	=	checkForNull(request.getParameter("packageCode"));
	visitUtilizationDetailsList																=	new ArrayList();
	PrevilageCardList																		=	new ArrayList();
	//cardIndex																				=	checkForNull(request.getParameter("patientId"));
	hCardSeqnNo																				=	checkForNull(request.getParameter("hCardSeqnNo"));
	priceClassCode																			=	checkForNull(request.getParameter("priceClassCode"));
	priceClassDesc																			=	checkForNull(request.getParameter("priceClassDesc"));
	from_date																				=	checkForNull(request.getParameter("fromDate"));
	toDate																					=	checkForNull(request.getParameter("toDate"));
	mebnmberFees																			=	checkForNull(request.getParameter("mebnmberFees"));
	billingServiceCode																		=	checkForNull(request.getParameter("billingServiceCode"));
	primaryPatientId																		=	checkForNull(request.getParameter("primaryPatientId"));
	mode																					=	(String)session.getAttribute("maintainMode");
	mode																					=	checkForNull(mode);
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	authorized 																				=	(String)session.getAttribute("authorized");
	priceClassCodeAndDescList																=	new ArrayList();
	 System.out.println("mode::::: "+mode+" ::authorized::: "+authorized);
	 if(mode.equalsIgnoreCase("modify") && authorized.equalsIgnoreCase("Y"))
	{
		 disableMode ="READONLY";
		 readonly ="READONLY";

	}
	 else
	 {
		 disableMode ="DISABLED";
		 readonly ="DISABLED";
	 }
	System.out.println("disableMode::::: "+disableMode);
	
	System.out.println("hiddenPatientId	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hiddenPatientId);
	System.out.println("hCardSeqnNo		::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hCardSeqnNo);
	System.out.println("priceClassCode	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+priceClassCode);
	System.out.println("priceClassDesc	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+priceClassDesc);
	System.out.println("hiddenPriceClasscode	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hiddenPriceClasscode);


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(hiddenCardTypeDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		PatientDetailsList = billingPrevilageCardMemberBean.getAdditionalPatientId(hCardSeqnNo,facilityId);
		priceClassCodeAndDescList = billingPrevilageCardPatientBean.LoadPriceClassCodeAndDesc(hiddenCardTypeCode, locale);
		for(int index=0;index<PatientDetailsList.size();index++)
		{
			defaultCode=PatientDetailsList.get(index)[3];
						
 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(  PatientDetailsList.get(index)[0]	!=null 	? 	PatientDetailsList.get(index)[0]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(index));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(	PatientDetailsList.get(index)[1]	!=null 	? 	PatientDetailsList.get(index)[1]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(	PatientDetailsList.get(index)[2]	!=null	?	PatientDetailsList.get(index)[2]	:	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block35Bytes, _wl_block35);

		              for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
		          		{
		            	  
		              
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(defaultCode ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[1]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[0]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( priceClassCodeAndDescList.get(priceListIndex)[0].equalsIgnoreCase(defaultCode) ? "SELECTED" : "" ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[1]));
            _bw.write(_wl_block40Bytes, _wl_block40);

		          		}
		              
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( 	PatientDetailsList.get(index)[5]	!=null 	? 	PatientDetailsList.get(index)[5]	: 	"" ));
            _bw.write(_wl_block50Bytes, _wl_block50);

		}
	
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

		  disableMode ="DISABLED";

		
            _bw.write(_wl_block53Bytes, _wl_block53);

    
    billingPrevilageCardVisiiUtilizationBean.getOpVisitUtilizationStatus(primaryPatientId, hCardSeqnNo, facilityId, locale);
    
    
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed() !=null ? billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed()  : "" ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed() !=null ? billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed() : ""));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);


		 
		//visitUtilizationDetailsList = billingPrevilageCardVisiiUtilizationBean.getVisitUtilizationDetails(billingPrevilageCardPatientBean.getHcardSeqNo(),  facilityId,locale);
		visitUtilizationDetailsList = billingPrevilageCardVisiiUtilizationBean.getVisitUtilizationDetails(hCardSeqnNo, facilityId,locale);
		System.out.println("visitUtilizationDetailsList SIZE:::: "+visitUtilizationDetailsList.size());
		for(int visistIndex= 0;visistIndex<visitUtilizationDetailsList.size();visistIndex++)
		{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(  visitUtilizationDetailsList.get(visistIndex)[0]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[0]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(  visitUtilizationDetailsList.get(visistIndex)[1]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[1]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(  visitUtilizationDetailsList.get(visistIndex)[2]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[2]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(visistIndex ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(  visitUtilizationDetailsList.get(visistIndex)[3]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[3]	: 	"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block80Bytes, _wl_block80);

		}

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(authorized));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(isUserCanAcess));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(hiddenCardTypeCode));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(hiddenPatientId));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(hiddenPriceClasscode));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(hiddenPriceClassDesc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(hCardSeqnNo));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(hiddenhiddenPackageCode));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mebnmberFees));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(billingServiceCode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(primaryPatientId));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(checkForNull(billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed())));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(checkForNull(billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed())));
            _bw.write(_wl_block100Bytes, _wl_block100);

putObjectInBean(bean_id, billingPrevilageCardPatientBean, request);
}
catch(Exception e)
{
	System.out.println("Exception in BillingMaintainPrevilageCardPatientDetails.jsp.jsp::"+e);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block101Bytes, _wl_block101);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRIVILIEGE_CARD_MEMBER.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLOpVisitUtilazationStatus.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNoOfOPAllotment.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLTillDateAvailed.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLDetails.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLClinic.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLVisitType.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNoOfVisit.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLAvailed.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

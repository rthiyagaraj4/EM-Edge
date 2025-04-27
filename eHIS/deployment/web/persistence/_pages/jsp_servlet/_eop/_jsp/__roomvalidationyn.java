package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eOR.*;
import eBL.*;
import eOR.Common.*;
import eBL.BLReportIdMapper;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __roomvalidationyn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/RoomValidationYN.jsp", 1743069456211L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\n<head>\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\'../../eOP/js/VisitRegistration.js\' language=\'javascript\'></script>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script src=\'../../eOP/js/BatchProcess.js\' language=\'javascript\'></script>\n</head>\n<body onKeyDown = \'lockKey()\'>\n<form>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n\t\t\t<Script language=\"JavaScript\">\n\t\t\tparent.document.Criteria.document.forms[0].cutoffdate.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\tparent.document.Criteria.document.forms[0].cutoffdate1.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<Script language=\"JavaSCript\">\n\t\t\tparent.document.frames[1].document.forms[0].consecutive_no_shows.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].no_of_visits_months.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].no_of_future_appts_months.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].consecutive_no_shows_months.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].consecutive_no_shows.disabled=true;\n\t\t\tparent.document.frames[1].document.forms[0].no_of_visits_months.disabled=true;\n\t\t\tparent.document.frames[1].document.forms[0].no_of_future_appts_months.disabled=true;\n\t\t\tparent.document.frames[1].document.forms[0].consecutive_no_shows_months.disabled=true;\n\t\t\t</Script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<Script language=\"JavaScript\">\n\t\t\tparent.document.frames[1].document.forms[0].cutoffdate.value=\"\";\n\t\t\tparent.document.frames[1].document.forms[0].cutoffdate1.value=\"\";\n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar ordreq=parent.f_query_add_mod.patient_sub3.document.getElementById(\"order_req\").value;\n\t\t\n\t\t\t\t\tif(ordreq != \"\" && ordreq == \"R\") {\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub3.document.forms[0].multiple_orders_yn.value==\'Y\') { \n\t\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" == 0) {\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\terrors = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(getLabel(\"Common.ordercatalog.label\",\"common_labels\"))));\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t} \t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script>\n\n\t\t\t\t\t\tvar confirm_allow = window.confirm(getMessage(\"EXCEED_MAX_WALKIN_LMT\",\"OP\"));\n\n\t\t\t\t\t\tif(confirm_allow)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' == \'Y\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t//alert(\"You are ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" in queue and your approximate wait time is ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \");\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'==\'Y\'){\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.forms[0].submit();\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\t\t\t\t\t\terr = err.replace(\'$\', getLabel(\"Common.practitioner.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\"NOT_AUTHORISED\",\"OP\"));\n\t\t\t\t\t\t\t\tparent.reset();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.reset();\n\t\t\t\t\t\t} \t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'==\'Y\'){\n\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.forms[0].submit();\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\t\t\t\terr = err.replace(\'$\', getLabel(\"Common.practitioner.label\",\"Common\"));\n\t\t\t\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'==\'Y\'){\n\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.forms[0].submit();\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\t\t\t\terr = err.replace(\'$\', getLabel(\"Common.practitioner.label\",\"Common\"));\n\t\t\t\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err;\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\n\t\t\t<script>\n\t\t\t\tvar tab_data = \"<table cellpadding=\'0\' cellspacing=\'0\'  width=\'100%\' border=\'1\' id=\'order_catalog_tbl\' align=\'center\'><thead><tr><th width =\'10%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th><th width =\'30%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\";\n\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"==\"true\"){\n\t\t\t\t\ttab_data\t= tab_data+\"<th width =\'10%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th><th width =\'10%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\";\n\t\t\t\t}\n\n\t\t\t\ttab_data\t= tab_data+\"</tr></thead><tbody>\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_txt\").value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_code\").value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_category_code\").value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_type_code\").value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").innerHTML = \'\';\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t\t</script>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t\n\t\t\t\t\t<script> <!--Below line modified for this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->\n\t\t\t\t\t\ttab_data = tab_data + \'<tr><td align=\"center\" width =\"10%\"><input type=\"checkbox\" id=\"select_chk\" name=\"select_chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"select_chk";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onclick=\"chkValue(this,";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =");calOrdCtlgAmt();\" checked ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></td>\';\t\t\t\t\n\t\t\t\t\t\ttab_data = tab_data + \'<td align=\"center\" width =\"30%\" nowrap class=\"label\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<input type=\"hidden\" name=\"order_ctl_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"order_ctl_code";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></td>\';\n\t\t\t\t\t\ttab_data = tab_data + \'<td align=\"center\" width =\"30%\" nowrap class=\"label\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<input type=\"hidden\" name=\"order_ctl_desc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"order_ctl_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><input type=\"hidden\" name=\"order_cat_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"order_cat_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><input type=\"hidden\" name=\"order_type_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"order_type_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></td>\';\t\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"==\"true\"){\n\t\t\t\t\t\t\ttab_data = tab_data + \'<td align=\"center\" width =\"10%\" nowrap class=\"label\"><span id=\"netAmt";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">nAmt";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</span></td>\';\n\t\t\t\t\t\t\ttab_data = tab_data + \'<td align=\"center\" width =\"10%\" nowrap class=\"label\"><span id=\"payerNetAmt";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">pNetAmt";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</span></td>\';\n\t\t\t\t\t\t\ttab_data = tab_data + \'<td align=\"center\" width =\"10%\" nowrap class=\"label\"><span id=\"patNetAmt";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">ptNetAmt";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</span></td>\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttab_data = tab_data + \'</tr>\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\ttab_data\t= tab_data.replace(\"nAmt";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\");\n\t\t\t\t\t\t\ttab_data\t= tab_data.replace(\"pNetAmt";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\");\n\t\t\t\t\t\t\ttab_data\t= tab_data.replace(\"ptNetAmt";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"==\"true\"){\n\t\t\t\t\t\ttab_data = tab_data + \"<tr>\";\n\t\t\t\t\t\ttab_data = tab_data + \"<td colspan=\'3\' align=\'right\' class=\'label\' style=\'text-align:right;\'><b>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</b></td>\";\n\t\t\t\t\t\ttab_data = tab_data + \"<td align=\'center\' width =\'10%\' nowrap class=\'label\'><b><span id=\'totNetAmt\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</span></b></td>\";\n\t\t\t\t\t\ttab_data = tab_data + \"<td align=\'center\' width =\'10%\' nowrap class=\'label\'><b><span id=\'totPayerNetAmt\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</span></b></td>\";\n\t\t\t\t\t\ttab_data = tab_data + \"<td align=\'center\' width =\'10%\' nowrap class=\'label\'><b><span id=\'totPatNetAmt\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</span></b></td>\";\n\t\t\t\t\t\ttab_data = tab_data + \"</tr>\";\n\t\t\t\t\t\ttab_data = tab_data + \"<input type=\'hidden\' id=\'selOrdCtlgCodes\' value =\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' />\";\n\t\t\t\t\t}\n\n\t\t\t\t\ttab_data = tab_data + \"</tbody></table>\";\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").innerHTML= tab_data;\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").style.visibility=\'visible\';\t\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_txt\").value=\'\';\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"!=\"true\"){\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_code\").value=\'\';\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_category_code\").value=\'\';\n\t\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_type_code\").value=\'\';\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"multiple_orders_yn\").value=\'Y\';\t\n\t\n\t\t\t\t</script>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_txt\").value=\'\';\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_cat_code\").value=\'\';\t\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_category_code\").value=\'\';\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_type_code\").value=\'\';\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").innerHTML = \'\';\n\t\t\t\t\tparent.f_query_add_mod.patient_sub3.document.getElementById(\"order_ctlg_tbl\").style.visibility=\'hidden\';\t\t\t\n\t\t\t\t</script>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t\t\n\t\t\t<script>\n\t\t\t\tparent.frames[1].document.getElementById(\"sec_res_lst\").value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\tvar tab_data = \"<table width=\'95%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\' align=\'center\'><tr><td class=\'BORDER\' width=\'50%\'><br></td><td class=\'BORDER\' width=\'50%\'><table border=\'0\' ><tr><td class=\'COLUMNHEADER\' width =\'13%\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td><td class=\'COLUMNHEADER\' width =\'13%\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td></tr></table><div style=\'height:100px;overflow-y:auto;overflow-x:no\'><table>\";\n\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\ttab_data = tab_data + \"<tr><td class=\'QUERYDATA\' align=\'center\' width =\'13%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td><td class=\'QUERYDATA\' align=\'center\' width =\'13%\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td></tr>\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<script>\n\t\t\t\ttab_data = tab_data + \"</div></table></tr></td></table>\";\n\t\t\t\tparent.frames[1].document.getElementById(\"sec_res_lbl\").innerHTML= tab_data;\t\n\t\t\t\tparent.frames[1].document.getElementById(\"sec_res_lbl\").style.visibility=\'visible\';\t\n\t\t\t\t</script>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t<script>\n\t\t\t\ttab_data=\"\";\n\t\t\t\tparent.frames[1].document.getElementById(\"sec_res_lbl\").innerHTML= tab_data;\t\n\t\t\t\tparent.frames[1].document.getElementById(\"sec_res_lbl\").style.visibility=\'visible\';\n\t\t\t\t</script>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\talert(getMessage(\"QUEUE_NUM_EXISTS\",\"OP\"));\n\t\t\t\t\t\t\t\t\teval(\"parent.frames[1].document.getElementById(\"queue_no\")\").focus();\n\n\t\t\t\t\t\t\t\t\t   if(parent.frames[1].document.getElementById(\"room_num\").value==\"\")\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"room_num\").value=\"NoRoom\";\n\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'==\'Arrival\') {\n\t\t\t\t\t\t\t\t\t\talert(\"You are ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" \");\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'==\'Arrival\') {\n\t\t\t\t\t\t\t\talert(\"You are ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" \");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"Room_Working_YN\",\"OP\"));\n\t\t\t\t\t\tparent.frames[1].document.getElementById(";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =").focus();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"Pract_Working_YN\",\"OP\"));\n\t\t\t\t\tparent.frames[1].document.getElementById(\'pract_name\').focus();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );
	
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

 

public HashMap ifPractWorkingYN(String facilityId, String assign_care_locn_code,String Practitioner_id ,Connection con)  throws Exception
	{    
	   
		String practWorkingsql =  "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
       
		String practWorkingYN="N";
		HashMap hashFILE_NO_EXISTS=new HashMap();


			CallableStatement practWorkingCS = con.prepareCall(practWorkingsql);
            practWorkingCS.setString(1, facilityId);
            practWorkingCS.setString(2, assign_care_locn_code);
            practWorkingCS.setString(3, Practitioner_id);
			practWorkingCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
            practWorkingCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
            

            try{
				practWorkingCS.execute();

				practWorkingYN = practWorkingCS.getString(4)== null?"":practWorkingCS.getString(4);
				if(practWorkingYN==null) practWorkingYN="N";
				hashFILE_NO_EXISTS.put("practWorkingYN",practWorkingYN);
 
				String P_ERR_MSG = practWorkingCS.getString(5)== null?"":practWorkingCS.getString(5);
                if(P_ERR_MSG==null) P_ERR_MSG="";
			    hashFILE_NO_EXISTS.put("P_ERR_MSG",P_ERR_MSG);
 		}
            catch(Exception e1) {
			
			e1.printStackTrace();
  		   }
            finally{
					practWorkingCS.close();
 				}

	return hashFILE_NO_EXISTS;
	
}//end of File_No_ExistsCall

public HashMap getPractDetails(String Practitioner_id ,String locale,Connection con)  throws Exception
{    
   
	String practsql =  "select AM_GET_DESC.AM_PRACTITIONER(?,?,'1') pract_name,am_get_desc.am_speciality((select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?),?,1) primary_speciality from dual";
   	//String practName=""; // commented for check style
   	HashMap practDetails=new HashMap();

   	try{
		PreparedStatement practStmt = con.prepareStatement(practsql);
		
		practStmt.setString(1,Practitioner_id);
		practStmt.setString(2,locale);
		practStmt.setString(3,Practitioner_id);
		practStmt.setString(4,locale);
							
       ResultSet practrs=practStmt.executeQuery();
       while(practrs.next()){
    	   practDetails.put("practName",practrs.getString("pract_name"));
    	   practDetails.put("specName",practrs.getString("primary_speciality"));    	       	          
       }
       if(practStmt!=null) practStmt.close();
   		if(practrs!=null) practrs.close();
        
			
		}
        catch(Exception e1) {
		
		e1.printStackTrace();
		   }


return practDetails;

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

	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;	
	//SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss.SSS");

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);


	String facilityid=(String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id"); 
	String userid = (String) session.getValue("login_user")==null?"":(String)session.getValue("login_user"); 
	String locale = (String) session.getValue("LOCALE")==null?"":(String)session.getValue("LOCALE"); 
	Connection conn = null;
	try{
		conn=ConnectionManager.getConnection(request);
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		
		String practWorkingYN = "N";
		String roomWorkingYN="N";
		String primary_resource_class = "";
		String override_walkin_yn = "";
		String order_type_code = "";
		String order_category = "";
		String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");

		int max_walkin_for_day = 0;
		int visits_registered = 0;
		int pkgSubsListCount=0;
		String submitYN="Y";
		
		String p_locn_code=request.getParameter("clinic_code")== null?"":request.getParameter("clinic_code");
		String room_num=request.getParameter("room_num")== null?"":request.getParameter("room_num");
		String objval=request.getParameter("objval")== null?"":request.getParameter("objval");
		String callfunc=request.getParameter("callfunc")== null?"":request.getParameter("callfunc");
		String pract_id=request.getParameter("pract_id")== null?"":request.getParameter("pract_id");
		String appt_id=(request.getParameter("appt_id") == null)?"":request.getParameter("appt_id");
		String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
		String locntype = request.getParameter("locntype")== null?"":request.getParameter("locntype");		
		String queue_no = request.getParameter("assigned_q_no")==null?"":request.getParameter("assigned_q_no");	
		String att_pract_id = request.getParameter("att_pract_id")== null?"":request.getParameter("att_pract_id");		
		
		String queue_date = request.getParameter("queue_date")==null?"":request.getParameter("queue_date");
		
		String vst_regn_date_time = request.getParameter("vst_regn_date_time")==null?"":request.getParameter("vst_regn_date_time");
		
		String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");

		String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"N":request.getParameter("bl_install_yn");	
		String appt_ref_no = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");	// Added for Against Incident 35375 
		String invitation_no = request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no"); // Added for Against Incident 35375 
		
		String practList = request.getParameter("practs")==null?"":request.getParameter("practs"); // Added for CRF - Bru-HIMS-CRF 198
		String bl_success = request.getParameter("bl_success")==null?"":request.getParameter("bl_success"); 
		boolean isOrderCtlgAmtCalc = CommonBean.isSiteSpecific(conn, "OP","ORDER_CTLG_AMT_CALC");/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/

				
		/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	    String order_select_count=request.getParameter("order_select_count")==null?"0":request.getParameter("order_select_count");
		    int order_count_appointment=Integer.parseInt(order_select_count);
		 String disableChk ="";  
		 if(order_count_appointment>1)           
				 disableChk = "disabled";				 
	    //End CRF Bru-HIMS-CRF-165.1 [IN:035659]
		
		String Cut_off_date1="";
		String Cut_off_date2="";
		String cnt1="N";		
		String queueNo = "";
		String waitTime = ""; 

		//Added for the CRF - Bru-HIMS-CRF-170 - start
		String consecutive_no_shows="";
		String no_of_visits_months="";
		String no_of_future_appts_months="";
		String no_of_no_show_months="";
		String episode_closure_by=request.getParameter("episode_closure_by")==null?"D":request.getParameter("episode_closure_by");
		//Added for the CRF - Bru-HIMS-CRF-170 - End
		if(callfunc.equals("batchProcess"))
		{

			String sql1="Select to_char(trunc(sysdate - nvl(episode_close_days_fu,0)),'DD/MM/YYYY'), to_char(trunc(sysdate - nvl(episode_close_days_wo_fu,0)),'DD/MM/YYYY'),consecutive_no_shows , no_of_visits_months, no_of_future_appts_months,no_of_no_show_months  from op_param_for_facility_service where OPERATING_FACILITY_ID=? and service_code=?";

			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,service_code);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
				cnt1="Y";
				Cut_off_date1=rs.getString(1) == null?"":rs.getString(1);
				Cut_off_date2=rs.getString(2) == null?"":rs.getString(2);
				consecutive_no_shows=rs.getString("consecutive_no_shows")==null?"":rs.getString("consecutive_no_shows");
				no_of_visits_months=rs.getString("no_of_visits_months")==null?"":rs.getString("no_of_visits_months");
				no_of_future_appts_months=rs.getString("no_of_future_appts_months")==null?"":rs.getString("no_of_future_appts_months");
				no_of_no_show_months=rs.getString("no_of_no_show_months")==null?"":rs.getString("no_of_no_show_months");				
			}
			

			if(rs!=null)
				rs.close();	
			
			if(cnt1.equals("N"))
			{
				String sql2="Select to_char(trunc(sysdate - nvl(episode_close_days_fu,0)),'DD/MM/YYYY'), to_char(trunc(sysdate - nvl(episode_close_days_wo_fu,0)),'DD/MM/YYYY')  from op_param where OPERATING_FACILITY_ID='"+facilityid+"'";
				
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();

				if(rs!=null && rs.next())
				{
					
					Cut_off_date1=rs.getString(1)== null?"":rs.getString(1);
					Cut_off_date2=rs.getString(2)== null?"":rs.getString(2);				
						
				}
				if(rs!=null)
				rs.close();	

			}
			
			if(!service_code.equals("")){			
			if(!episode_closure_by.equals("N")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Cut_off_date1));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Cut_off_date2));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(consecutive_no_shows));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(no_of_visits_months));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(no_of_future_appts_months));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(no_of_no_show_months));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
			}else{
			
            _bw.write(_wl_block13Bytes, _wl_block13);
}
		
		}else if(callfunc.equals("VisitRegn"))
		{
			int no_of_orders = Orderables.getSize();
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_orders));
            _bw.write(_wl_block15Bytes, _wl_block15);


			String sql_override_walkin = "select OVERRIDE_WALKIN_YN from AM_OS_USER_LOCN_ACCESS_VW where locn_type='"+locntype+"' and locn_code ='"+p_locn_code+"' and facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+userid+"'";			

			pstmt = conn.prepareStatement(sql_override_walkin);

			rs = pstmt.executeQuery();
			 
			if(rs!=null && rs.next())
			{
				override_walkin_yn = rs.getString("OVERRIDE_WALKIN_YN")==null?"":rs.getString("OVERRIDE_WALKIN_YN");				
			}			

			if(rs!=null)
				rs.close();			
            // Issue Fix Against 35375 Below query Day order[ Monday to Sunday Changed into Sunday to Saturday]  Dated on 28/09/2012 By Saanthaakumar
			/*String sql_max_walkin = "select primary_resource_class,  DECODE(Trim(to_char(to_date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'DAY')),'SUNDAY',MAX_WALKIN_FOR_DAY_1,'MONDAY',MAX_WALKIN_FOR_DAY_2, 'TUESDAY',MAX_WALKIN_FOR_DAY_3, 'WEDNESDAY',MAX_WALKIN_FOR_DAY_4, 'THURSDAY',MAX_WALKIN_FOR_DAY_5, 'FRIDAY',MAX_WALKIN_FOR_DAY_6, 'SATURDAY',MAX_WALKIN_FOR_DAY_7) MAX_WALKIN_FOR_DAY from op_clinic where clinic_code = '"+p_locn_code+ "' and facility_id='"+facilityid+"'";		//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368	*/
			//Below Query Newly Added for reopen issue 35375 Dated on 07/11/2012 
			String sql_max_walkin = "SELECT primary_resource_class,DECODE(DAY_NO,'1', max_walkin_for_day_1,'2', max_walkin_for_day_2,'3', max_walkin_for_day_3,'4', max_walkin_for_day_4,'5', max_walkin_for_day_5,'6', max_walkin_for_day_6,'7', max_walkin_for_day_7 ) max_walkin_for_day FROM op_clinic  , SM_DAY_OF_WEEK WHERE clinic_code = '"+p_locn_code+ "' AND facility_id = '"+facilityid+"' AND LTRIM(RTRIM(DAY_OF_WEEK))= LTRIM(RTRIM(TO_CHAR (TO_DATE ('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'), 'DAY' )))";                                
 
 
			
			pstmt = conn.prepareStatement(sql_max_walkin);

			rs = pstmt.executeQuery();
			
			 
			if(rs!=null && rs.next())
			{
				primary_resource_class = rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");
				max_walkin_for_day = rs.getInt("MAX_WALKIN_FOR_DAY");
			}

			if(rs!=null)
				rs.close();				
			String sql_visits = " select count(*) VISITS_REGISTERED from op_current_patient where facility_id='"+facilityid+"' and locn_code='"+p_locn_code+"' and APPT_OR_WALK_IN_IND='W' and trunc(queue_date)=trunc(to_date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss')) ";	//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368		
			
			rs = pstmt.executeQuery(sql_visits);

			if(rs!=null && rs.next())
			{
				visits_registered = rs.getInt("VISITS_REGISTERED");
			}

			if(rs!=null)
				rs.close();		
			if(pstmt!=null)
				pstmt.close(); 				
			if(bl_install_yn.equals("Y")){
				eBL.PkgSubsBean pkgSubsBean=(PkgSubsBean)getBeanObject("PkgSubsBean","PkgSubsBean",request);
				ArrayList pkgSubsList=pkgSubsBean.getSubscribedPkgs();
				pkgSubsListCount=pkgSubsList.size();
				if(pkgSubsListCount > 0){
					if(att_pract_id.equals("")){
						submitYN="N";
					}else{
						submitYN="Y";
					}
				}else{
					submitYN="Y";
				}
			}	

			if(max_walkin_for_day != 0 && appt_ref_no.equals("") && invitation_no.equals("")) // Condition Changed Against Incident Number 35375
			{
				if(visits_registered >= max_walkin_for_day)
				{
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(override_walkin_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(queueNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(waitTime));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(submitYN));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
				else if(visits_registered < max_walkin_for_day)
				{
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(submitYN));
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			} else {
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(submitYN));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
		}
		else if(callfunc.equals("OrderCatalog"))
		{

			int tot_records = Orderables.getSize();			

			String order_string = "";			
			String order_code = "";			
			String order_desc = "";	
			String totNetAmt		= "";
			String totPayerNetAmt	= "";
			String totPatNetAmt		= "";

			ArrayList arr= new ArrayList();
			arr= Orderables.getArrayList();		
			
			String grand_tot_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GrandTotal.label",
				"common_labels");
			String select_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label",
				"common_labels");
			String code_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label",
				"common_labels");
			String desc_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label",
				"common_labels");
			String netAmtLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NetAmount.label","common_labels");
			String payerNetLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PayerNetPayable.label","common_labels");
			String patientNetLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientNetPayable.label","common_labels");
			
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(select_lbl));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code_lbl));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(desc_lbl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isOrderCtlgAmtCalc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(netAmtLbl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(payerNetLbl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientNetLbl));
            _bw.write(_wl_block29Bytes, _wl_block29);

			//System.out.println("patient_id==>"+patient_id+"==>line no 365 RoomValidationYN.jsp==> Orderables for Loop Starts ==>Sysdate==>"+formatter.format(new java.util.Date()));
			String allOrderCode	= "";
			String ordCtlgCodeForBL	 = "~~";
			for(int i=0;i<tot_records;i++)
			{
				order_string = arr.get(i).toString();			

				//StringTokenizer order_val = new StringTokenizer(order_string,"$$"); 
				//Above line commented and below lind added for this CRF Bru-HIMS-CRF-165.1
				StringTokenizer order_val = new StringTokenizer(order_string,"~~");
				
				while(order_val.hasMoreTokens())
				{
					order_code = order_val.nextToken();
					order_desc = order_val.nextToken();					
					order_type_code = order_val.nextToken();	
					order_category = order_val.nextToken();	
					allOrderCode	= allOrderCode+order_code+"##";
					ordCtlgCodeForBL	= ordCtlgCodeForBL+order_code+"~~";
					System.out.println("order_code-->"+order_code);
				}	
				System.err.println("allOrderCode-->RoomValidationYN.jsp-->"+allOrderCode);
				



				
				
				if(tot_records==1)
				{
					
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);


				}

				if(tot_records>1 || (isOrderCtlgAmtCalc && tot_records >=1) )
				{	
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disableChk));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(isOrderCtlgAmtCalc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(order_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
	
				}					
			}
		/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/
			if(!allOrderCode.equals("") && isOrderCtlgAmtCalc){
				JSONObject jsonObj  = BLReportIdMapper.getOrderCatalogDtls(conn, patient_id, ordCtlgCodeForBL, bl_success, p_locn_code, request);
				JSONArray orderCatalogDtlsArray 			= (JSONArray) jsonObj.get("orderCatalogDtls");
				try{

					String[] arrOrdCtlgCode = allOrderCode.split("##");
					int i = 0;
					System.out.println("450 orderCatalogDtlsArray->"+orderCatalogDtlsArray.toString());

					for(i=0;i<arrOrdCtlgCode.length;i++){
						String ctlgCode			= arrOrdCtlgCode[i];
						System.err.println("arrOrdCtlgCode[i]"+arrOrdCtlgCode[i]);
						System.err.println("(JSONObject) orderCatalogDtlsArray.get(i);"+(JSONObject) orderCatalogDtlsArray.get(i));
						JSONObject ctlgDtls		= (JSONObject) orderCatalogDtlsArray.get(i);
						System.out.println("ctlgDtls-->"+ctlgDtls.toString());
						JSONObject ctlgAmtDtls	= (JSONObject) ctlgDtls.get(ctlgCode);
										
						System.err.println("ctlgAmtDtls-->"+ctlgAmtDtls.toString());
						String netAmt			= (String) ctlgAmtDtls.get("netAmt");
						String payerNetAmt		= (String) ctlgAmtDtls.get("payerNetAmt");
						String patNetAmt		= (String) ctlgAmtDtls.get("patNetAmt");
					
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(ctlgCode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(netAmt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ctlgCode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(payerNetAmt));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ctlgCode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patNetAmt));
            _bw.write(_wl_block63Bytes, _wl_block63);

						System.err.print("netAmt==>"+netAmt+"==>payerNetAmt==>"+payerNetAmt+"==>patNetAmt==>"+patNetAmt);
					}
					JSONObject totDtls		= (JSONObject) orderCatalogDtlsArray.get(i);
					JSONObject totAmtDtls	= (JSONObject) totDtls.get("totals");
					totNetAmt				= (String) totAmtDtls.get("totalNetAmt");
					totPayerNetAmt			= (String) totAmtDtls.get("payerTotalNetAmt");
					totPatNetAmt			= (String) totAmtDtls.get("patTotalNetAmt");

					//System.out.print("totNetAmt==>"+totNetAmt+"==>totPayerNetAmt==>"+totPayerNetAmt+"==>totPatNetAmt==>"+totPatNetAmt);
				}catch(Exception e) {
					System.err.println("patient_id==>"+patient_id);
					System.err.println("ordCtlgCodeForBL==>"+ordCtlgCodeForBL);
					System.err.println("orderCatalogDtlsArray->"+orderCatalogDtlsArray.toString());
					System.err.println("Exception in getting json data.");
					e.printStackTrace();
				}
			}

		/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] End*/

			if(tot_records>1 || (isOrderCtlgAmtCalc && tot_records >=1))
			{
			
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(isOrderCtlgAmtCalc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(grand_tot_lbl));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(totNetAmt));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totPayerNetAmt));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(totPatNetAmt));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ordCtlgCodeForBL));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(isOrderCtlgAmtCalc));
            _bw.write(_wl_block71Bytes, _wl_block71);
	
			}	
			if(tot_records<1)
			{
			
            _bw.write(_wl_block72Bytes, _wl_block72);
	
			}
			if(tot_records<=1)	
			{				out.println("<script>parent.f_query_add_mod.patient_sub3.document.getElementById('multiple_orders_yn').value='N';</script>");
			}	out.println("<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';</script>");
		}
		/*CRF - 198 start*/
		else if(callfunc.equals("SecResource")){

			int tot_records = 0;			
			StringTokenizer practListToken=new StringTokenizer(practList,"$");
			
			//String order_string = "";	commented for check style		
			//String order_code = "";			
			//String order_desc = "";			
			
			String code_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label",
				"common_labels");
			String desc_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label",
				"common_labels");
			String spec_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label",
					"common_labels");
			
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(practList));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(code_lbl));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(desc_lbl));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(spec_lbl));
            _bw.write(_wl_block76Bytes, _wl_block76);

				String practName="practName";
				String specName="specName";
			while(practListToken.hasMoreElements()){
				tot_records++;
				String practId=practListToken.nextToken();				
				HashMap practDetails=new HashMap();
				practDetails=getPractDetails(practId,locale,conn);				
				
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(practId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(practDetails.get(practName)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(practDetails.get(specName)));
            _bw.write(_wl_block79Bytes, _wl_block79);
	
									
			}
			if(tot_records>=1){
            _bw.write(_wl_block80Bytes, _wl_block80);

			}else{
            _bw.write(_wl_block81Bytes, _wl_block81);

			}
		}
		/*CRF - 198 End*/
		else 
		{

				if(callfunc.equals("Assign"))
				{
					if(appt_id.equals(""))
					{
					HashMap practWorkingHash =ifPractWorkingYN( facilityid, p_locn_code, pract_id,conn);

					practWorkingYN=(String)practWorkingHash.get("practWorkingYN");
					
					}

				}
				if(practWorkingYN==null) practWorkingYN="N";

				if(practWorkingYN.equals("Y") || pract_id.equals("") || !appt_id.equals(""))
				{
					if(appt_id.equals(""))
								{
						
				if(!room_num.equals(""))
				{
					HashMap roomWorkingHash =ifPractWorkingYN( facilityid, p_locn_code	, room_num,conn);

					roomWorkingYN=(String)roomWorkingHash.get("practWorkingYN");
				}
				}

				if(roomWorkingYN==null) roomWorkingYN="N";

				if(roomWorkingYN.equals("Y") || room_num.equals("") || !appt_id.equals(""))
				{			   
										
					if(assign_q_num_by.equals("M")&&callfunc.equals("Arrival"))
					{
						int cnt = 0;						
						boolean submitFlag = true;

						String strPatQ="";					

						if(att_pract_id.equals("*ALL"))
						{
							strPatQ = "select count(*) from op_current_patient where facility_id=? and locn_type=? and locn_code=? and queue_num=? and queue_status < '07' and trunc(queue_date) = to_date(?,'dd/mm/yyyy')";		
						} else {
							strPatQ = "select count(*) from op_current_patient where facility_id=? and locn_type=? AND ((locn_code = ? AND practitioner_id=?) OR (locn_code = ? AND practitioner_id='*ALL')) and queue_num=? and queue_status < '07' and trunc(queue_date) = to_date(?,'dd/mm/yyyy')";
						}
					
						
						pstmt = conn.prepareStatement(strPatQ);

						if(att_pract_id.equals("*ALL"))
						{
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locntype);
							pstmt.setString(3,p_locn_code);
							pstmt.setString(4,queue_no);
							pstmt.setString(5,queue_date);
						} else {
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locntype);
							pstmt.setString(3,p_locn_code);
							pstmt.setString(4,att_pract_id);
							pstmt.setString(5,p_locn_code);
							pstmt.setString(6,queue_no);
							pstmt.setString(7,queue_date);
						}

						rs = pstmt.executeQuery();
						if(rs!=null && rs.next())
						{
							
							cnt = rs.getInt(1);
						
						}
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();						
						if(cnt>0)
						{	
							submitFlag = false ;
							
            _bw.write(_wl_block82Bytes, _wl_block82);
	
						}
						if(submitFlag)
						{
							
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(queueNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(waitTime));
            _bw.write(_wl_block85Bytes, _wl_block85);


						} 

					} else {
						
					
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(queueNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(waitTime));
            _bw.write(_wl_block88Bytes, _wl_block88);

					}
				}
				else
				{
					
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(objval));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}
				}
				else
				{
					
            _bw.write(_wl_block91Bytes, _wl_block91);

				}
		}	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		if(conn != null)
				ConnectionManager.returnConnection(conn,request);
	}


            _bw.write(_wl_block92Bytes, _wl_block92);
            _bw.write(_wl_block93Bytes, _wl_block93);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

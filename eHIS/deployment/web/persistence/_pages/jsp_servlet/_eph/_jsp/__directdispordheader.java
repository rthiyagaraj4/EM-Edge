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
import eCommon.Common.*;
import java.math.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispordheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispOrdHeader.jsp", 1709120673704L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!-- java.math.* Added for ML-MMOH-CRF-1004 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<!-- import the calendar script -->\n\t\t<script type=\"text/javascript\"\t src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\"\t src=\"../js/DirectDispensing.js\"></script>\n\t\t<script language=\"javascript\"\t src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"javascript\"\t src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\"\t src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\"\t src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"dir_disp_header_form\" id=\"dir_disp_header_form\">\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\" >\n\t\t\t\t\t<th colspan=\'20\'  nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<tr nowrap>\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t\t\t\t<td class=\"label\" ><input type=\"text\" name=\"height\" id=\"height\" size=\"5\"  maxlength=\"8\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\"NUMBER\" onBlur=\"checkDecimal(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\" onchange=\"validateBSA();\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" oncopy=\"return false\" onpaste=\"return false\" title=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></td>\n\t\t\t\t\t\t<!-- added onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" and oncopy=\"return false\" onpaste=\"return false\" for [IN:037181]-->\n\t\t\t\t\t\t<td class=\"label\" ><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td>\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n\t\t\t\t\t\t<td class=\"label\" ><input type=\"text\" name=\"weight\" id=\"weight\" size=\"5\"  maxlength=\"8\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onChange=\"validateBSA();\" onBlur=\"checkDecimal(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" class=\"NUMBER\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" oncopy=\"return false\" onpaste=\"return false\" title=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td>\n\t\t\t\t\t\t<!-- added onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" and oncopy=\"return false\" onpaste=\"return false\" for [IN:037181]-->\n\t\t\t\t\t\t<td class=\"label\"  ><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t    <td class=\"label\"  >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t\t\t\t\t\t<td class=\"label\" ><label id=\"bsa_lbl\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></label><input type=\"hidden\" name=\"bsa\" id=\"bsa\" size=\"5\"  maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> m&sup2;</td>\n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  </td>\n\t\t\t\t\t\t<td class=\"label\" ><label id=\"bmi_lbl\"><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></label><input type=\"hidden\" name=\"bmi\" id=\"bmi\" size=\"5\"  maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> kg/m&sup2;</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<td class=\"label\"  ><a href=\"javascript:callOrderRemarks();\" title=\"Clinical Comments\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  </a>\t\n\t\t\t\t\t\t<!-- code added for JD-CRF-0156[IN041737]--Start -->\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t     \n\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;<img src=\"../../ePH/images/dollar.png\" style=\"cursor:pointer\" height=\"15\" title=\"Current Encounter Financial Details\" onClick=\"callFinancialDetailScreen(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" >\t\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<font style=\"font-size:9;\" id=\"policy_exp\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tXX1=new blinkText(\"XX1\",\'policy_exp\',500,500,\'darkred\',\'#ff0000\');\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t<!-- code added for JD-CRF-0156[IN041737]-- End -->\n\t\t\t\t\t\t<label onClick=\"javascript:callDiagText(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'Header\');\" style=\"visibility:hidden\" id=\"diag_text\" title=\"Diag Text\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="  </label></td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"label\" >\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="   \n\t\t\t\t\t\t\t <a href=\"javascript:callADRdetails(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');\" title=\"Clinical Comments\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</a>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="   </td>\n\t\t\t\t\t\t<td class=\"label\" ><input type=\"text\" name=\"sys_date\" id=\"sys_date\" size=\"15\"  maxlength=\"17\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onBlur=\"chkBackFutureOrderDate(this);\"><img SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'sys_date\',null,\'hh:mm\');document.dir_disp_header_form.sys_date.focus();return false;\" > \n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"height_unit\" id=\"height_unit\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"weight_unit\" id=\"weight_unit\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"calculated_date\" id=\"calculated_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ref_sys_date\" id=\"ref_sys_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\"\t\t\t\tvalue=\"C\">\n\t\t\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"order_remarks\" id=\"order_remarks\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\"\t\t\t\t\tvalue=\"C\">\n\t\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"\t>\n\t\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"licence\" id=\"licence\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"\t\t>\n\t\t\t\t<input type=\"hidden\" name=\"servide_code\" id=\"servide_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\t>\n\t\t\t\t<input type=\"hidden\" name=\"service_search_yn\" id=\"service_search_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\t\t\n\t\t\t\t<input type=\"hidden\" name=\"QueryString\" id=\"QueryString\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"allow_without_wt\" id=\"allow_without_wt\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"allow_without_diag\" id=\"allow_without_diag\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_age\" id=\"patient_age\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"diag_size\" id=\"diag_size\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"diag_text_size\" id=\"diag_text_size\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sliding_scale\" id=\"sliding_scale\"\t\t\t\tvalue=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"allergic_yn1\" id=\"allergic_yn1\"\t\t\t\tvalue=\"N\"> \n\t\t\t\t<input type=\"hidden\" name=\"height_min\" id=\"height_min\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"height_max\" id=\"height_max\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_min\" id=\"weight_min\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_max\" id=\"weight_max\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\"\t\tvalue=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\"\t\t\t\t\tvalue=\"R\">\n\t\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<!--External Drug Interface Controls -->\t   \n\t\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\"        value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\"        value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"drug_db_duptherapy_yn\" id=\"drug_db_duptherapy_yn\"       value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"drug_db_interact_check_yn\" id=\"drug_db_interact_check_yn\"   value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_db_contraind_check_yn\" id=\"drug_db_contraind_check_yn\"  value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_db_allergy_check_yn\" id=\"drug_db_allergy_check_yn\"    value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Drug_db_prod_id\" id=\"Drug_db_prod_id\"\t\t\t    value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\t\n\t\t\t\t<!--ends here  -->\n\t\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\"\t\t\t\t    value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\"\t\t\t    value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_rx_yn\" id=\"bl_disp_charge_dtl_in_rx_yn\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"adr_count\" id=\"adr_count\"                   value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"date_of_birth\" id=\"date_of_birth\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"man_rem_on_prn_freq_yn\" id=\"man_rem_on_prn_freq_yn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"max_length_prn_reason\" id=\"max_length_prn_reason\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"atc_allergy_alert_level\" id=\"atc_allergy_alert_level\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"rx_qty_by_pres_base_uom_yn\" id=\"rx_qty_by_pres_base_uom_yn\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"weight_rec_appl_age_group_check_flag\" id=\"weight_rec_appl_age_group_check_flag\" value=\"\"> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->\n\t\t\t\t<input type=\"hidden\" name=\"wt_mand_yn\" id=\"wt_mand_yn\" value=\"\"> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->\n\t\t\t\t<input type=\"hidden\" name=\"ht_mand_yn\" id=\"ht_mand_yn\" value=\"\"> <!--  added for Bru-HIMS-CRF-079 IN[029945]  -->\n\t\t\t\t<input type=\"hidden\" name=\"height_min_value\" id=\"height_min_value\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"height_max_value\" id=\"height_max_value\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_min_value\" id=\"weight_min_value\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_max_value\" id=\"weight_max_value\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"height_min_digits\" id=\"height_min_digits\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"height_max_digits\" id=\"height_max_digits\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_min_digits\" id=\"weight_min_digits\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"weight_max_digits\" id=\"weight_max_digits\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t</form>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.dir_disp_header_form.sys_date.disabled=true;\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.dir_disp_header_form.sys_date.disabled=false;\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<script>\n\t\t\t    setTimeout(\"loadOtherFrames();\",1500);\n\t\t\t</script>\n\t\t</body>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n</html>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		 //ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{
		String licence			= (String)(PhLicenceRights.getKey());
		String facility_id		= (String) session.getValue("facility_id");
		//String bl_install_yn    = (String) session.getValue( "bl_operational" );
		String pract_id			=  request.getParameter("pract_id");
		String practioner_name	=  request.getParameter("pract_name");
		String dir_bean_id      = "DirectDispensingBean" ;
		String dir_bean_name    = "ePH.DirectDispensingBean";
		DirectDispensingBean dir_bean = (DirectDispensingBean)getBeanObject( dir_bean_id,dir_bean_name,request);
		String bl_install_yn    = dir_bean.checkforbillinginterface();
		String patient_id       = "";
		String encounter_id     = "";
		String patient_class    = "";
		String ord_locn         = "";
		String practioner_id    = "";
		String pat_details      = "";
		String pract_name		= "";
		String ord_locn_name    = "";
		String pract_name_str   = "";
		String patient_name		= "";
		String date_of_birth	= "";
		String gender			= "";
		String disp_locn_code   = "";  //code added for JD-CRF-0156[IN041737]
		int adr_count			= 0;
		ArrayList pat_det		= new ArrayList();
		patient_id=dir_bean.getPatientID();
		if(patient_id!=null && !patient_id.equals("")){
			encounter_id			= dir_bean.getEncounterID();
			if(encounter_id==null||encounter_id.equals("")){
				encounter_id="";
				dir_bean.setPatientClass("XT");
			}
			patient_class		= dir_bean.getPatientClass();
			ord_locn				= dir_bean.getOrdLocn();
			if(ord_locn==null){
				ord_locn="";
			}
			practioner_id		= dir_bean.getPractionerID();
			if(practioner_id==null ||practioner_id.equals("")){
				dir_bean.setPractionerID(pract_id);			  
				practioner_id      = pract_id;
				dir_bean.setPractionerName(practioner_name);
			}
			pat_det				=(ArrayList)dir_bean.getPatientDetails1(patient_id);
			pat_details			="<b>"+pat_det.get(0)+"/"+pat_det.get(1)+"/"+pat_det.get(2)+"</b>";
			patient_name         = (String)pat_det.get(0);
			date_of_birth	=	(String)pat_det.get(3);
			gender	=	(String)pat_det.get(2);
			gender	=	gender.substring(0,1).toUpperCase();
			pract_name			= dir_bean.getPractionerName();
			ord_locn_name		= dir_bean.getOrdLocnName();
			pract_name_str		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrdLocnPract.label","ph_labels") + " : <b>"+ord_locn_name+"/"+pract_name+"</b>";
			adr_count = dir_bean.getADRCount(patient_id,"%");
		    disp_locn_code		= dir_bean.getDispLocnCode(); //code added for JD-CRF-0156[IN041737]	
			
		}
		String drug_bean_id = "@DrugSearchBean"+patient_id+encounter_id ;
		String drug_bean_name = "ePH.DrugSearchBean";
		DrugSearchBean drug_bean = (DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
		String mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String presBean_id					= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name				= "ePH.PrescriptionBean";
		PrescriptionBean presBean			= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		boolean default_dose_type_yn = dir_bean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
		param_bean.setLanguageId(locale);
		presBean.setLanguageId(locale);
		bean.setLanguageId(locale);
		drug_bean.setPractitionerId(pract_id);
		//declaration
		float bsa						= 0f;
		String leg_value_1				= "";
		String leg_uom_1				= "";
		String leg_value_2				= "";
		String leg_uom_2				= "";	
		String bsa_str					= "";
		//String visit_date				= "";
		String sys_date					= "";
		String calculated_date			= "";	
		String order_remarks			= "";
		String back_date				= "";
		String future_date				= "";
		String servide_code				= "";
		String service_search_yn		= "N";
		String allow_without_wt			= "";
		String allow_without_diag		= "";
		String patient_age				= "";
		String rec_date					= "";
		String bmi_str					= "";	
		String height_min				= "";
		String height_max				= "";
		String weight_min				= "";
		String weight_max				= "";
		String bl_disp_charge_dtl_in_rx_yn ="";
		String man_rem_on_prn_freq_yn   = "";
		String max_length_prn_reason	="";
		String atc_allergy_alert_level	="";
		String rx_qty_by_pres_base_uom_yn	="";
		String height_min_value			= "";
		String height_max_value			= "";
		String weight_min_value			= "";
		String weight_max_value			= "";
		String height_min_digits		= "";
		String height_max_digits		= "";
		String height_dec_digits		= "";
		String weight_dec_digits		= "";
		String weight_min_digits		= "";
		String weight_max_digits		= "";
		//end
		
		//getting the External Drug Interface Controls 
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id); 	
		String Drug_db_prod_id				=	param_bean.getDrugDBProductID(facility_id); 
		param_bean.clear();

		HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
		if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
			height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE")==null?"0":(String)discr_values.get("HEIGHT_MIN_VALUE");
			height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE")==null?"0":(String)discr_values.get("HEIGHT_MAX_VALUE");
			height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_MIN_DIGITS");
			height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_MAX_DIGITS");
			height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_DEC_DIGITS");
		}
		if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
			weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE")==null?"0":(String)discr_values.get("WEIGHT_MIN_VALUE");
			weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE")==null?"0":(String)discr_values.get("WEIGHT_MAX_VALUE");
			weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_MIN_DIGITS");
			weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_MAX_DIGITS");
			weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_DEC_DIGITS");
		}
		/*HashMap	discr_values			=	bean.getDiscreteValues();
		if(discr_values.containsKey("HEIGHT_MIN")) {	
			height_min				= (String)discr_values.get("HEIGHT_MIN");
			height_max				= (String)discr_values.get("HEIGHT_MAX");
		}

		if(discr_values.containsKey("WEIGHT_MIN")) {	
			weight_min				= (String)discr_values.get("WEIGHT_MIN");
			weight_max				= (String)discr_values.get("WEIGHT_MAX");
		}*/

		//getting the height/uom and weight/uom values from prescription bean:

		HashMap HeaderHtWtValues	=(HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,patient_class);
		if( HeaderHtWtValues.size()>1 ){
			 if(HeaderHtWtValues.containsKey("HEIGHT")){
				leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
				leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
				rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
				if(leg_value_1.equals("0")||leg_value_1.equals("0.0")){
					leg_value_1="";
				}
			 }
			if(HeaderHtWtValues.containsKey("WEIGHT")){
				leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
				leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
				rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");
				if(leg_value_2.equals("0")||leg_value_2.equals("0.0")){
					leg_value_2="";
				}
			}
			bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
			if(leg_uom_1==null) 
				leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Cms.label","ph_labels");
  
			if(leg_uom_2==null) 
				leg_uom_2= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label ","common_labels");
			bsa_str			= (String.valueOf(bsa));
			if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
				bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
				int index	=	bmi_str.indexOf(".");
				if(bmi_str.length()>=(index+3) ) {
					bmi_str	=(bmi_str.substring(0,index+3));
				}
			}
				
			if(bsa_str.equals("0.0")) 
				bsa_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";

			if(bmi_str.equals("0.0")) 
				bmi_str= "";
			if(bmi_str.equals("0")) 
				bmi_str= "";
			if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
				bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
			} // Added for ML-MMOH-CRF-1004 - End
		}
		/*double enc_id=0;
		if(!encounter_id.equals(""))
			enc_id=Double.parseDouble(encounter_id);

		//getting visit date/time
		visit_date		=	bean.getVisitDate(enc_id,facility_id);*/

		// check Parameter values
		ArrayList param_vals	=	bean.getParameterValues();
		if(param_vals!=null && param_vals.size()!=0) {
			allow_without_diag				=	(String)param_vals.get(16);//changed get value from 0 to 16 for Bru-HIMS-CRF-265 [IN:032315]
			allow_without_wt				=	(String)param_vals.get(1);
			bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(2);
			max_length_prn_reason			=   (String)param_vals.get(16);
			rx_qty_by_pres_base_uom_yn		=   (String)param_vals.get(14);
			atc_allergy_alert_level			=   (String)param_vals.get(15);
		} 
		HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
		if(patient_details!=null && patient_details.size()!=0) {
			patient_age	=	(String)patient_details.get("age");
		}

		//check for recorded diagnosis
		ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, "", "");
		int diag_size		=	(diagnosis).size();

		//getting system date
		sys_date=(String) presBean.getSysdate();
		//getting back date of order date/time
		HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
		if(BackDates.size()>0){
			back_date			= (String) BackDates.get("BACK_DATE");
			future_date			= (String) BackDates.get("FUTURE_DATE");
		}
		//getting the last modified order remarks
		order_remarks	= (String)bean.getPresRemarks();
		ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
		if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
			if(leg_value_1.equals("")) {
				leg_uom_1	=	(String)ht_wt_uom.get(0);	
				if( ht_wt_uom.size() > 2) {
					leg_value_1 =	(String)ht_wt_uom.get(2);	
					if(leg_value_1.equals("0")||leg_value_1.equals("0.0")){
					   leg_value_1="";
					}
				}
			}
				
			if(leg_value_2.equals("")) {
				leg_uom_2	=	(String)ht_wt_uom.get(1);	
				if( ht_wt_uom.size() > 4) {
					leg_value_2 =	(String)ht_wt_uom.get(3);
					rec_date	=	(String)ht_wt_uom.get(4);
					if(leg_value_2.equals("0")||leg_value_2.equals("0.0")){
					   leg_value_2="";
					}
				}
			}
			bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
			bsa_str			= (String.valueOf(bsa));
			
			if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
				bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
				int index	=	bmi_str.indexOf(".");
				if(bmi_str.length()>=(index+3) ) {
					bmi_str	=(bmi_str.substring(0,index+3));
				}
			}
			
			if(bsa_str.equals("0.0")) 
				bsa_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";

			if(bmi_str.equals("0.0"))
				bmi_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";
			if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
				bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
			} // Added for ML-MMOH-CRF-1004 - End
		}
		HashMap appl_orders	=	bean.getApplicableOrders(facility_id);
		if(appl_orders != null){
			man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
		}
		dir_bean.setExcludeADRAllergyAlert(bean.getExcludeADRAllergyAlert());//Added for HSA-SCF-0011 [IN:042444]

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pat_details));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pract_name_str));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(leg_value_1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(height_max_digits));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height_min_digits));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height_dec_digits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rec_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(leg_value_2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(weight_max_digits));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(weight_min_digits));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(weight_dec_digits));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rec_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(default_dose_type_yn){ // if else added for Added for ML-MMOH-CRF-1004 - Start 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block29Bytes, _wl_block29);
} else{ 
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block32Bytes, _wl_block32);
} // Added for ML-MMOH-CRF-1004 - End 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
		
						if(dir_bean.toDisplayFinancialDtl(disp_locn_code) && !encounter_id.equals("") ){	   
							ArrayList encounterId_details	 = dir_bean.getEpisodeDetails(patient_id, encounter_id);			 
							if(encounterId_details.size()>0){
								String 	latest_episode_id		 = (String)encounterId_details.get(0);					
								String  latest_patient_class	 = (String)encounterId_details.get(1);							
								String visit_id="";
								if(latest_patient_class.equals("OP") &&  encounter_id.length()>4)
									visit_id = encounter_id.substring(encounter_id.length()-4, encounter_id.length());

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(latest_episode_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
 
								if(!dir_bean.getPolicyExp(encounter_id, latest_patient_class,patient_id)){  

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

							}
						}
					}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
       
						if(adr_count >0){

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
        
						}

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dir_bean.getTodaysDate(),"DMYHM","en",locale)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dir_bean_name ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(calculated_date));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ord_locn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_remarks));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ord_locn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(licence));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(servide_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(service_search_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allow_without_wt));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(allow_without_diag));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(diag_size));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((bean.getDiagText()).size()));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(height_min));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(height_max));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(weight_min));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(weight_max));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(practioner_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(drug_db_duptherapy_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(drug_db_interact_check_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drug_db_contraind_check_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(drug_db_allergy_check_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Drug_db_prod_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(adr_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(max_length_prn_reason));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(atc_allergy_alert_level));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rx_qty_by_pres_base_uom_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(height_min_value));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(height_max_value));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(weight_min_value));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(weight_max_value));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(height_min_digits));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(height_max_digits));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(weight_min_digits));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(weight_max_digits));
            _bw.write(_wl_block104Bytes, _wl_block104);

			if(back_date.equals("0") && future_date.equals("0") ){

            _bw.write(_wl_block105Bytes, _wl_block105);

			}
			else{

            _bw.write(_wl_block106Bytes, _wl_block106);

			}

            _bw.write(_wl_block107Bytes, _wl_block107);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(dir_bean_id,dir_bean,request); 
		putObjectInBean(drug_bean_id,drug_bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block108Bytes, _wl_block108);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PolicyExpired.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ADR.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderDate/Time.label", java.lang.String .class,"key"));
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
}

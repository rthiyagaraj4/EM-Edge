package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import ePH.QueryMednAdminChartBean;
import ePH.MedicationAdministrationBean;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __querymednadminchartdrug extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryMednAdminChartDrug.jsp", 1736414070504L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 28/10/2005-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head> \n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/QueryMednAdminChart.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t\t<!-- import the calendar script -->\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\"> // Added for PMG2014-CRF-0026 [IN:052701]\n\t\t\tfunction initScroll() {\n\t\t\t\tvar rightDivSize = document.body.offsetWidth-451;\n\t\t\t\tvar leftDiv = document.getElementById(\'table_container_left\');\n\t\t\t\tvar rightDiv = document.getElementById(\'table_container_right\');\n\t\t\t\tif(rightDiv!=undefined && leftDiv!=undefined && rightDivSize!=-451){//Added new condition for Bru-HIMS-CRF-081 [IN:029947]\n\t\t\t\t\trightDiv.style.width=rightDivSize+\'px\';\n\t\t\t\t\trightDiv.onscroll = function() {\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop-10;\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop;\n\t\t\t\t\t};\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body offsetleft=0 onKeyDown=\"lockKey()\"  onKeyDown = \'lockKey()\'  onLoad=\"initScroll();\" onresize=\"initScroll();\" >\n\t\t<form name=\"AdminChart\" id=\"AdminChart\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\t//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\")); \n\t\t\t\t\t//top.parent.window.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_fm_date\" id=\"min_fm_date\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"relevantencounter\" id=\"relevantencounter\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\t\t\t\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_class\" id=\"patient_class\"  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t\t\t\t<iNPUT TYPE=\"hidden\" name=\"dishdflg\" id=\"dishdflg\"  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> <!--Added for ML-BRU-SCF-1177 -->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"max_to_date\" id=\"max_to_date\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<div id=\'table_container_top\' style=\'position:relative;float:top;\'><!-- Below table for displaying future/past schedule dates-->\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"  border=\"0\"  width=\'100%\'><!--Modified for ML-BRU-SCF-1177     width=\"1200px\"   -->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"data\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<select name=\"past_dose\" id=\"past_dose\" onChange=\"reloadDosage(this)\">\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;---";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="---&nbsp;</option>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t<option  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \"selected> ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </option>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"data\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<select name=\"future_dose\" id=\"future_dose\" onChange=\"reloadDosage(this)\">\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;---";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"selected> ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td><!--Added for ML-BRU-SCF-1177 start-->\n\t\t\t\t\t\t\t<td align=\"left\"><input type=\"checkbox\" id=\"hold_discontinue_yn\" name=\"hold_discontinue_yn\" id=\"hold_discontinue_yn\" size=\"2\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="></td><!--Added for ML-BRU-SCF-1177 -->\n\t\t\t\t\t\t\t<td align=\"right\" class=\"data\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t\t\t<td><select name=\"orderby\" id=\"orderby\" id=\"orderby\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<option value=\"sch\" selected=\"selected\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t\t\t\t\t<option value=\"status\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<option value=\"sch\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t\t\t\t\t\t\t<option value=\"status\" selected=\"selected\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t</select></td><!--Added for ML-BRU-SCF-1177 end-->\n\t\t\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t\t\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"order_date_from\" id=\"order_date_from\"  size=\"8\" maxlength=\"10\" onBlur=\"CheckDate(this);\"   value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'order_date_from\');document.AdminChart.order_date_from.focus();return false;\" > \n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"order_date_to\" id=\"order_date_to\" size=\"8\" maxlength=\"10\" onBlur=\"CheckDate(this);\"  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'order_date_to\');document.AdminChart.order_date_to.focus();return false;\" > \n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t<td class=\"data\" align=\"right\">\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onClick=\"reloadResult(order_date_from,order_date_to)\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<input type=\"hidden\" name=\"admindate\" id=\"admindate\" value=\"\">\t\n\t\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\")); \n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<div id=\'table_container_left\' style=\'overflow:hidden;width:450px;height:";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =";position:relative;float:left;\'>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"  border=\"1\"   id=\"drugTable\" name=\"drugTable\" id=\"drugTable\" ><!--Modified for ML-BRU-SCF-1177-->\n\t\t\t\t\t<tr style=\'position:relative;border-collapse: collapse;\' style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t\t<td align=\"center\" class=\"COLUMNHEADER\" width=\"3px\" style=\"border-collapse: collapse;\">&nbsp;</td>\n\t\t\t\t\t\t<td align=\"center\"  class=\"COLUMNHEADER\" width=\"447px\" style=\"border-collapse: collapse;\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<tr style=\"border-collapse: collapse;\">\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\"left\" colspan=\"2\" style=\'height:29px;\"border-collapse: collapse;\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td><!-- Pixel modified for SKR-SCF-1179-->\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t<tr style=\'height:19px;\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t<td align=\'center\'class=\"white\" onMouseOver = \"showToolTipLockStatus(this,\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')\" style=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\t\n\t\t\t\t\t\t\t<td align=\'center\'class=\"white\" style=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t<td  align=\'left\' height =\"29px\" nowrap style=\"background-color:#E4CAFF;color:black\"><font size=\'1\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font></td> <!-- Pixel modified for SKR-SCF-1179-->\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<td  align=\'left\' nowrap height =\"29px\"  style=\"background-color:#FFBFBF;color:black\"><font size=\'1\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td><!-- height added for ml-bru-scf-1816-->\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t<td  align=\'left\' height =\"29px\" nowrap style=\"background-color:#FFDFDF;color:black\"><font size=\'1\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font></td><!-- Pixel modified for SKR-SCF-1179-->\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="  \n\t\t\t\t\t\t\t\t<td  align=\'left\' nowrap  height =\"29px\" style=\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" ><font size=\'1\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font><br><label style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" </label></td> \n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<div id=\'table_container_right\' style=\'height:";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =";position:relative;float:left;\' ><!--  Modified for Bru-HIMS-CRF-081 -->\n\t\t\t\t\t<table  border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n\t\t\t\t\t\t<tr style=\'position:relative;border-collapse: collapse;\' style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t\t\t<td align=\"center\" class=\"COLUMNHEADERCENTER\" colspan=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>&nbsp;</td>\t\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t<tr > \n\t\t\t\t\t\t\t\t<td align=\"center\"  class=\"COLUMNHEADER\" style=\"border-collapse: collapse;\" style=\'height:14.5px;\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <!-- style=\'height:14.5px;\' Added for SKR-SCF-1201 -->\n\t\t\t\t\t\t\t\t<td align=\"center\" class=\"COLUMNHEADER\" colspan=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" style=\'height:14.5px;\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td> <!-- style=\'height:14.5px;\' Added for SKR-SCF-1201 -->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr height =\"29px\"> <!-- Pixel added for SKR-SCF-1179-->\n\t\t\t\t\t\t\t\t<td  align=\"center\" class=\'TIMING\'   >&nbsp;</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t<td  align=\"center\" class=\'TIMING\'   ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<td  align=\"center\" class=\'TIMING\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr style=\'height:19px;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" align=\'center\' height=\"29px\" nowrap style=\" background-color:white\" ><font size=\'1\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="&nbsp;</font></td><!--height added for ml-bru-scf-1816-->\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\" background-color:white\"  ><font size=\'1\' >&nbsp;</font></td>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue\"   onClick=\"loadAdminDetails(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\',\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\',\'Y\',this,\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')\"><font size=\'1\' >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="<img src=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"></font><!-- order_line_num1 newly added for inc 30030-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue\"   onClick=\"openMFRDetails(\'1\',\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'\',\'MednAdminChart\',\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="(";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =")<img src=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"></font></td>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue\"   onClick=\"loadAdminDetails(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\')\" ><font size=\'1\' >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</font><!-- order_line_num1 newly added for inc 30030-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue\"   onClick=\"openMFRDetails(\'1\',\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =")</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue\"   onClick=\"loadAdminDetails(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\',\'N\',this,\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</font> <!-- order_line_num1 newly added for inc 30030-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue\"   onClick=\"openMFRDetails(\'1\',\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:#FF8000;border-right:15px solid red;color:black\"  ><font size=\'1\' >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</font></td>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:#FF8000;border-right:15px solid yellow;color:black\"  ><font size=\'1\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:silver;border-right:15px solid silver;color:black\"  ><font size=\'1\' >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\"background-color:white;color:#FF8000;border-right:15px solid #FF8000;color:black\"   ><font size=\'1\' > ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' style=\" background-color:white\"  ><font size=\'1\' >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\"center\"  >&nbsp;</td>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t</tr> \n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t</TABLE>\n\t\t</form>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t</body>\n</html> \n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
	    String locale			= (String)session.getAttribute("LOCALE"); 
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String relevantencounterid	=	request.getParameter("relevantencounter");
	String admindate			=	request.getParameter("admindate")==null?"":request.getParameter("admindate");
	String mode				=	request.getParameter("mode")==null?"":request.getParameter("mode");
	String date_from			=	request.getParameter("date_from")==null?"":request.getParameter("date_from");
	String date_to				=	request.getParameter("date_to")==null?"":request.getParameter("date_to");
	String fromtime				=	"";
	String past_date			=   request.getParameter("past_date")==null?"":request.getParameter("past_date");
	String future_date			=   request.getParameter("future_date")==null?"":request.getParameter("future_date");
	String called_from			=   request.getParameter("called_from")==null?"":request.getParameter("called_from");

	boolean displayed			=	false;
	String t_date="";
	String f_date="";
	String sliding_scale_yn="";
	String sliding_scale_range_unit="";
	String sliding_scale_range_uom="";
	String sliding_scale_adm_unit="";
	String sliding_scale_adm_uom="";
	String sliding_scale="";
	String dishdchk="";//Added for ML-BRU-SCF-1177
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String demostring	="\\\'\'";

	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";
	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject(bean_id,bean_name,request );
	String bean_id1				= "MedicationAdministrationBean";
	String bean_name1			= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject(bean_id1,bean_name1,request );	
	admin_bean.setLanguageId(locale);
	String facility_id					= (String) session.getValue("facility_id");
	String medn_admin_reqd_yn=admin_bean.fetchParamFacilityValues(facility_id);//Added for ML-BRU-SCF-1177--start
	String dishdflg = "";
	String dishdflg1=request.getParameter("dishdflg")==null?"":request.getParameter("dishdflg");
//	String orderby = request.getParameter("ordval")==null?"sch":request.getParameter("ordval"); //Commented for INT-CRF-BRU-PH-001 
	String orderby = request.getParameter("ordval")==null?"status":request.getParameter("ordval"); //Added for INT-CRF-BRU-PH-001
	if(dishdflg1==null || dishdflg1.trim().length()==0)
		dishdflg=admin_bean.getMarDispHeldDiscOrdersYN();
	else
		dishdflg=request.getParameter("dishdflg")==null?"":request.getParameter("dishdflg");

	Date date1 = null;
	Date date2 = null;
	Date date3 = null;
	String chkflg="";
	String heightpx="390px";
	if(called_from.equals("MEDADMIN"))
		heightpx = "450px";
	String scroll	=	"scroll";
	String dosage_seq_no = "";
	String sch_date_time ="";
	boolean	flag  = false;
	if(dishdflg.equals("Y"))//Added for ML-BRU-SCF-1177--end
		dishdchk = "checked";

            _bw.write(_wl_block9Bytes, _wl_block9);

			HashMap sch_dates		=	bean.loadSchDates(relevantencounterid);
			ArrayList all_dates		=	new ArrayList();
			String dflt_sch_date	=	"";
			//String curr_record_date	=	"";
			int t1;
			if(date_from!=null && !date_from.equals("") && date_to!=null && !date_to.equals("")) {
				all_dates			=	bean.getDates(date_from,date_to);
				dflt_sch_date		=	"";
			}
			else if	(!admindate.equals("")){
				all_dates.add(admindate);
				dflt_sch_date	=	admindate;
			}
			ArrayList past_records		=	(ArrayList) sch_dates.get("past_records");
			ArrayList future_records	=	(ArrayList) sch_dates.get("future_records");
			t1=past_records.size();
			if(t1>0){
				if(t1 >= 3){
					f_date=(String)past_records.get(t1-3); 
				}
				else if(t1 == 2){
					f_date=(String)past_records.get(t1-2);
				}
				else{
					f_date=(String)past_records.get(t1-1);
				}
				t_date=(String)past_records.get(t1-1);
			}
			if(admindate.equals("") && all_dates.size()==0){
				for(int i=0; i<past_records.size(); i++) {
					all_dates.add((String)past_records.get(i));
				}
				for(int i=0; i<future_records.size(); i++) {
					all_dates.add((String)future_records.get(i));
				}
			}
			//if(!date_from.equals("") && !date_to.equals("") && ((!past_records.contains(date_from) && !future_records.contains(date_from)) || (!past_records.contains(date_to) && !future_records.contains(date_to))) ) {

            _bw.write(_wl_block10Bytes, _wl_block10);
 
				//return;
			//}
			ArrayList al=new ArrayList();
			ArrayList al_times=new ArrayList();
			ArrayList al_drug_desc=new ArrayList();
			//ArrayList al_strength=new ArrayList();
			ArrayList al_qty=new ArrayList();
			HashMap drug_desc_qty_hm=new HashMap();
			String o_date="";
			//String times="";
			String drug_desc="";
			String drug_strength="";
			//String qty="";
			String te_qty="";
			//String flag="";
			String drug_code="";
			String order_id="";
			String admin_recorded_yn="";
			String admin_recorded_date_time="";
			String administered_yn="";
			String admin_not_recorded_flag="n";
			String admin_due_flag="n";
			String adr_detail_flag="n";
			String adr_remarks="";
			String adr_recorded_date_time="";
			String adr_recorded_by="";
			String adr_reson_code="";
			String dis="";
			String pract_type="";
			String mfr_yn="";
			String disc_date_time="";//Added for ML-BRU-SCF-1177--start
			String hd_date_time="";
			String can_date_time="";
			String disc_pract="";
			String hd_pract="";
			String pract_name="";//Added for ML-BRU-SCF-1177--end
			String iv_prep_yn="";
			String iv_prep_flag="";
			String order_line_num1="";
			String order_line_status=""; 
			String displayStyle		="";
			String drug_class="";
			String displayStyle_drug_class = "";
			String pat_brought_medn_yn = "N";
			String extMedGif = "";
			String verbalOrder="";
			HashMap hm_qty=null;
			int t=0, maxFreqCount=0, tdwidth=0, tableWidth=100;
			for(int j=0; j<all_dates.size(); j++) { 
				admindate		=	(String)all_dates.get(j);
				if (fromtime.equals("")){
					admindate=admindate+" 00:00";
				}
				else{
					admindate=admindate+" "+fromtime;
				}
			}
//Table display starts from here
			if(!displayed) { 
				displayed	=	true;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(past_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(past_records.size()>0?past_records.get(0):""));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dishdflg));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
				if(future_records.size() >=1) { 

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)future_records.get(future_records.size()-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}	
				else{	

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)past_records.get(past_records.size()-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}	

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
 		
								for (int i=0; i<past_records.size(); i++) { 	
									if(dflt_sch_date.trim().equals( ((String)past_records.get(i)).trim() )) {

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block27Bytes, _wl_block27);

									} 
									else {

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
			
									}	  
								}		

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
 		
								for (int i=0; i<future_records.size(); i++) { 	
									if(dflt_sch_date.trim().equals( ((String)future_records.get(i)).trim() )) {

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
		
									}
									else{	

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
									}	
								}		

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dishdchk));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

							if(orderby==null || orderby.trim().length()==0|| orderby.equalsIgnoreCase("sch")){ 

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							}
							else{

            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							}

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

							if (date_from.equals("") && past_date.equals(""))
								date_from=f_date;
							else if(!date_from.equals("") && !past_date.equals(""))
								date_from=past_date;
							else if(!date_from.equals("") && !future_date.equals(""))
								date_from=future_date;
								
							if(date_to.equals("")&& past_date.equals(""))
								date_to=t_date; 
							else if(!date_to.equals("") && !past_date.equals(""))
							   date_to=past_date;
							else if(!date_to.equals("") && !future_date.equals(""))
								date_to=future_date;

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale)));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(date_to,"DMY","en",locale)));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
			}
			al=(ArrayList)bean.getRecord(past_date,future_date,date_from,date_to,relevantencounterid,dishdflg,orderby);//Added dishdflg,orderby for ML-BRU-SCF-1177
			if(al.size() == 0){

            _bw.write(_wl_block50Bytes, _wl_block50);
 
				return;
			}

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(heightpx));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

				HashMap record1=null;
				String altDrugDesc = "";//BRU-CRF-399.1
				String split_dose_yn = "";//ML-MMOH-SCF-1529
				String dosage = "";//ML-MMOH-SCF-1529
				for(int i=0;i<al.size();i++) { 
					record1=(HashMap)al.get(i);
					o_date	= com.ehis.util.DateUtils.convertDate((String)record1.get("dates"),"DMY","en",locale); 

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block56Bytes, _wl_block56);

					al_drug_desc=(ArrayList)record1.get("desc_qty");		
					al_times=(ArrayList)record1.get("times");
					if(maxFreqCount<al_times.size())
						maxFreqCount=al_times.size(); 
					for(int x=0;x<al_drug_desc.size();x++){
						drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
						drug_code=(String)drug_desc_qty_hm.get("drug_code");
						drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
						order_id=(String)drug_desc_qty_hm.get("order_id");
						order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
						order_line_status=(String)drug_desc_qty_hm.get("order_line_status");
						drug_class=(String)drug_desc_qty_hm.get("drug_class");				
						pract_type=(String)drug_desc_qty_hm.get("pract_type");						
						pract_name=(String)drug_desc_qty_hm.get("pract_name")==null?"":(String)drug_desc_qty_hm.get("pract_name");
						disc_pract = disc_date_time + " " +pract_name;
						hd_pract = hd_date_time + " " +pract_name;//Added for ML-BRU-SCF-1177--end
						iv_prep_yn=(String)bean.checkIVOrder(order_id);
						altDrugDesc = "";//BRU-CRF-399.1 - start
						if(iv_prep_yn.equals("") ){
							altDrugDesc = bean.getAltDrugDesc(order_id,order_line_num1);
						}
						//BRU-CRF-399.1 - start

						if(!iv_prep_yn.equals("")){
							if(order_line_num1.equals("1"))
								 iv_prep_flag="Y";
							else 
								 iv_prep_flag="N";
						}
						else
							iv_prep_flag="";
						
						if(order_line_status.equals("DC"))
							displayStyle = "BACKGROUND-COLOR:red;";
						else if(order_line_status.equals("HD")||order_line_status.equals("HC"))
							displayStyle = "BACKGROUND-COLOR:yellow;";						
						else
							displayStyle = "";

						if(pract_type.equals("NS")){
							//displayStyle = "BACKGROUND-COLOR:#00FF00;";
							verbalOrder="<b>V</b>";
						}
						else{
							verbalOrder="&nbsp";
						}
						/*	narcotic  -----N
							controlled-----C
							others    -----""  	*/

						if(iv_prep_flag.equals("")){
							if(drug_class.equals("C"))
								displayStyle_drug_class = "BACKGROUND-COLOR:#CCFFCC;";
							else if(drug_class.equals("N"))
								displayStyle_drug_class = "BACKGROUND-COLOR:#66FFFF";
							else if(!drug_class.equals(""))
								displayStyle_drug_class = "BACKGROUND-COLOR:white";
						}

            _bw.write(_wl_block57Bytes, _wl_block57);
//Modified for ML-BRU-SCF-1177--start
						if(disc_date_time!= null && disc_date_time.trim().length()>0){ 

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disc_pract));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block43Bytes, _wl_block43);
  					}	
						else if(hd_date_time!=null && hd_date_time.trim().length()>0)	{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(hd_pract));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block43Bytes, _wl_block43);
                      }
						else{

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block43Bytes, _wl_block43);
						}	//Modified for ML-BRU-SCF-1177--end			
						if(iv_prep_yn.equals("6")){

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);

							}
							else if(iv_prep_flag.equals("Y")){ 

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);

							}
							else if(iv_prep_flag.equals("N")){ 

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);

							}
							else{

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(displayStyle_drug_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(altDrugDesc));
            _bw.write(_wl_block70Bytes, _wl_block70);
 
							}
						}
					}

            _bw.write(_wl_block71Bytes, _wl_block71);

				if(called_from.equals("MEDADMIN"))
					heightpx = "470px";
				else
					heightpx="410px";
					//if(maxFreqCount>8)
						//tableWidth = (maxFreqCount+1) * 7;
					//if(tableWidth<100)
					//	tableWidth = 100;
					//tdwidth =8;// tableWidth/(maxFreqCount+1);

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(heightpx));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(maxFreqCount+1));
            _bw.write(_wl_block74Bytes, _wl_block74);

						for(int i=0;i<al.size();i++) { 
							record1=(HashMap)al.get(i);
							o_date	= com.ehis.util.DateUtils.convertDate((String)record1.get("dates"),"DMY","en",locale); 
							al_times=(ArrayList)record1.get("times");
							t=al_times.size(); 
							//tableWidth = 100;
							//if(maxFreqCount>9)
								//tableWidth = (maxFreqCount * 10)+10;

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(maxFreqCount));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
 
							for(int p=0;p<maxFreqCount;p++){
								if(p<t){

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(al_times.get(p)));
            _bw.write(_wl_block80Bytes, _wl_block80);
 
								}
								else{

            _bw.write(_wl_block81Bytes, _wl_block81);
 
								}
							}

            _bw.write(_wl_block82Bytes, _wl_block82);
  
										al_drug_desc=(ArrayList)record1.get("desc_qty");		
										for(int x=0;x<al_drug_desc.size();x++){
											drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
											drug_code=(String)drug_desc_qty_hm.get("drug_code");
											drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
											order_id=(String)drug_desc_qty_hm.get("order_id");
											order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
											order_line_status=(String)drug_desc_qty_hm.get("order_line_status");
											drug_class=(String)drug_desc_qty_hm.get("drug_class");				
											pract_type=(String)drug_desc_qty_hm.get("pract_type");						
											mfr_yn=(String)drug_desc_qty_hm.get("mfr_yn")==null?"N":(String)drug_desc_qty_hm.get("mfr_yn");						
											disc_date_time=(String)drug_desc_qty_hm.get("disc_date_time")==null?"":(String)drug_desc_qty_hm.get("disc_date_time");//Added for ML-BRU-SCF-1177--start
											hd_date_time = (String)drug_desc_qty_hm.get("hold_date_time")==null?"":(String)drug_desc_qty_hm.get("hold_date_time");
											can_date_time = (String)drug_desc_qty_hm.get("can_date_time")==null?"":(String)drug_desc_qty_hm.get("can_date_time");
											drug_strength=(String)drug_desc_qty_hm.get("drug_strength")==null?"":(String)drug_desc_qty_hm.get("drug_strength"); 

											split_dose_yn = (String)drug_desc_qty_hm.get("split_dose_yn")==null?"":(String)drug_desc_qty_hm.get("split_dose_yn"); //ML-MMOH-SCF-1529
											dosage = (String)drug_desc_qty_hm.get("dosage")==null?"":(String)drug_desc_qty_hm.get("dosage"); //ML-MMOH-SCF-1529

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,drug_strength) ));
            _bw.write(_wl_block84Bytes, _wl_block84);

										al_qty=(ArrayList)drug_desc_qty_hm.get("qty");
										for(int k=0;k<maxFreqCount;k++){ 
											if(k<al_qty.size()){
												sliding_scale="";
												flag = false;
												hm_qty=(HashMap)al_qty.get(k);
												order_id=(String)hm_qty.get("order_id");
												sch_date_time = (String)hm_qty.get("sch_date_time1");//Added for ML-BRU-SCF-1177
												admin_recorded_yn=(String)hm_qty.get("admin_recorded_yn");
												admin_recorded_date_time=(String)hm_qty.get("admin_recorded_date_time");
												administered_yn=(String)hm_qty.get("administered_yn");
												//admin_date_time=(String)hm_qty.get("admin_date_time");
												te_qty=(String)hm_qty.get("f_qty")==null?"":(String)hm_qty.get("f_qty");
												if(!te_qty.equals("")){
													if(Float.parseFloat(te_qty)<1.0)
														te_qty = "0"+te_qty;
													if(te_qty.equals("00") ){ //if condition added for ML-MMOH-SCF-1529
														if(!split_dose_yn.equals("Y") && !dosage.equals("")) //added for ML-MMOH-SCF-1674
															te_qty = Float.parseFloat(dosage)+"";
														else{
															if(split_dose_yn.equals("Y")){
															te_qty = bean.getSplitDosage(order_id,order_line_num1,sch_date_time.split(" ")[1]);
															te_qty = Float.parseFloat(te_qty)+"";
															}
														}
													}
												}
												admin_not_recorded_flag=(String)hm_qty.get("admin_not_recorded_flag");
												admin_due_flag=(String)hm_qty.get("admin_due_flag");
												adr_detail_flag=(String)hm_qty.get("adr_detail_flag");
												adr_remarks=(String)hm_qty.get("adr_remarks")==null?"":(String)hm_qty.get("adr_remarks");
												adr_recorded_date_time=(String)hm_qty.get("adr_recorded_date_time");
												if(!locale.equals("en")){ //added for IN25266 --04/01/2011-- priya
													adr_recorded_date_time =  DateUtils.convertDate(adr_recorded_date_time, "DMYHM","en",locale);
												}
												adr_recorded_by=(String)hm_qty.get("adr_recorded_by");
												adr_reson_code  =   (String)hm_qty.get("adr_reson_code");
												adr_reson_code  =   adr_reson_code==null?"":adr_reson_code;
												adr_reson_code	=	admin_bean.getReasonDesc("M",adr_reson_code);
												adr_reson_code  =   adr_reson_code==null?"":adr_reson_code;
												sliding_scale_yn=(String)hm_qty.get("sliding_scale_yn")==null?"N":(String)hm_qty.get("sliding_scale_yn");									
												dosage_seq_no= hm_qty.get("DOSAGE_SEQ_NO")==null?"":(String)hm_qty.get("DOSAGE_SEQ_NO");
												sliding_scale_range_unit=(String)hm_qty.get("sliding_scale_range_unit")==null?"":(String)hm_qty.get("sliding_scale_range_unit");
												sliding_scale_range_uom=(String)hm_qty.get("sliding_scale_range_uom")==null?"":(String)hm_qty.get("sliding_scale_range_uom");
												sliding_scale_adm_unit=(String)hm_qty.get("sliding_scale_adm_unit")==null?"":(String)hm_qty.get("sliding_scale_adm_unit");
												sliding_scale_adm_uom=(String)hm_qty.get("sliding_scale_adm_uom")==null?"":(String)hm_qty.get("sliding_scale_adm_uom");
												pat_brought_medn_yn=(String)hm_qty.get("medn_brought_by_patient_yn")==null?"N":(String)hm_qty.get("medn_brought_by_patient_yn");
												//pract_type=(String)hm_qty.get("pract_type");
												dis="";	
												SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");//Added for ML-BRU-SCF-1177--start
												if(sch_date_time!=null && sch_date_time.trim().length()>0){
													date1 = sdf.parse(sch_date_time);
												}
												if(disc_date_time!=null && disc_date_time.trim().length()>0){
													date2 = sdf.parse(disc_date_time);
												}
												if(hd_date_time!=null && hd_date_time.trim().length()>0){
													date3 = sdf.parse(hd_date_time);
												}//Added for ML-BRU-SCF-1177--end
												
												
												if(pat_brought_medn_yn.equals("Y")){
													extMedGif="<img src=\"../../ePH/images/ExternalMedicine.gif\" title=\""+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ExternalMedicine.label", "ph_labels")+"\"> ";
												}
												else{
													extMedGif="";
												}
												if(sliding_scale_yn.equals("Y")){
													sliding_scale=sliding_scale_range_unit+" "+sliding_scale_range_uom+" /"+sliding_scale_adm_unit+" "+sliding_scale_adm_uom;
													if(!te_qty.equals(""))
														te_qty=sliding_scale;
												}
												if(te_qty.equals("")){ 

            _bw.write(_wl_block85Bytes, _wl_block85);

												}
												else if(adr_detail_flag.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														if(te_qty.equals("")){ //added for SCF-7863
															te_qty="&nbsp;";
														}
													}
													dis=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdministrationDetails.label", "ph_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reson_code+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+" : "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordedDateTime.label", "ph_labels")+" : "+adr_recorded_date_time+"\n"+   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+" : "+adr_recorded_by+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.reason.label","common_labels")+" : "+adr_reson_code; 
													if(!mfr_yn.equals("Y"))	{

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bean.getFacilityId()));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(al_times.get(k)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_strength));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_line_num1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block91Bytes, _wl_block91);

													}
													else{

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block96Bytes, _wl_block96);

													}
												}
												else if(admin_recorded_yn.equals("Y")){
													if(administered_yn.equals("Y")){
														if(!mfr_yn.equals("Y")){

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bean.getFacilityId()));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(al_times.get(k)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_strength));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_line_num1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block99Bytes, _wl_block99);

														}
														else{

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

														}
													}
													else{
														if(!mfr_yn.equals("Y")){

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bean.getFacilityId()));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(al_times.get(k)));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_strength));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_line_num1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block104Bytes, _wl_block104);

														}
														else{

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

														}
													}
												}								
												else if(sch_date_time!=null && sch_date_time.trim().length()>0 && disc_date_time!=null && disc_date_time.trim().length()>0 && date1.compareTo(date2)>=0){//Added for ML-BRU-SCF-1177--start

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);
								
												}
												else if(sch_date_time!=null && sch_date_time.trim().length()>0 && hd_date_time!=null && hd_date_time.trim().length()>0 && date1.compareTo(date3)>=0){

            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);

												}//Added for ML-BRU-SCF-1177--end moved after if(adr_detail_flag.equals("Y")) for ML-BRU-SCF-1177.1 [IN:049200]
												else if(admin_due_flag.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){										
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);

												}
												else if(admin_due_flag.equals("N") && !admin_recorded_yn.equals("Y") && !administered_yn.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);

												}
												else{
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(extMedGif));
            out.print( String.valueOf(te_qty ));
            _bw.write(_wl_block107Bytes, _wl_block107);

												}
											}
											else{

            _bw.write(_wl_block112Bytes, _wl_block112);

												}
											}
										}

            _bw.write(_wl_block113Bytes, _wl_block113);
 
					}

            _bw.write(_wl_block114Bytes, _wl_block114);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,admin_bean,request);

            _bw.write(_wl_block115Bytes, _wl_block115);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PastDose.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FutureDose.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DisplayHeld/DiscontinuedOrders.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.displayOrderby.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Scheduled.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Scheduled.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateFrom.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetailfor.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Timings/Dosage.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFR.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFR.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFR.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

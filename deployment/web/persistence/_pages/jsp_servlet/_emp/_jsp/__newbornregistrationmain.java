package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import org.json.simple.*;

public final class __newbornregistrationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationMain.jsp", 1744276156515L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="  \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></Script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration1.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration2.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t\t<Script src=\"../../eCommon/js/calScript/hj/calendar.js\" language=\"JavaScript\"></Script> <!--Added for this CRF MMS-QH-CRF-0145.1 [IN:047497]-->\n\t\t\t<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\t\t</head>\n\t\t<style>\n\t\t\t#mother_dtls td .label {\n\t\t\t\twidth: 15%;\n\t\t\t}\n\t\t\t#mother_dtls td .fields {\n\t\t\t\twidth: 35%;\n\t\t\t}\n\t\t</style>\n\t\t\t<script>\n\t\t\t\tvar frame_ref = \"\";\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'==\'MAINTAIN_BIRTH\')\n\t\t\t\t\tframe_ref = \"parent.parent.frames[1].frames[2]\";\n\t\t\t\telse\n\t\t\t\t\tframe_ref = \"parent.parent.frames[1].frames[2]\";\n\t\t\t</script>\n\t\t\t<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t\t\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onload=\"newbornbabyNames();if(parent.parent.frames[1].frames[2].document.getElementById(\'mothergrp1_tab\')){parent.parent.frames[1].frames[2].document.getElementById(\'mothergrp1_tab\').scrollIntoView();}disabledFields();disableonload();emerRegnNBValidations();";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="onchange_antenatal1(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="noMaritalStatusload(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'FatherDtls\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t\t\t<form name=\'NewbornRegistration_form\' id=\'NewbornRegistration_form\' action=\'../../servlet/eMP.NewbornRegistrationServlet\' method=\'post\' target=\'messageFrame\' onSubmit=\"return getNewBornRegnValues(\'pat_id\')\">\n\t\t\t<table width=\"100%\" cellpadding=1 cellspacing=0 border=\'0\'>\n\t\t\t\t<tr><td>\n\t\t\t\t\t<table id=\'mother_tab\' width=\"100%\" cellpadding=1 cellspacing=0 border=\'0\'>\n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t<td colspan=\'4\' class=\'COLUMNHEADER\'><span id=\'mother_dtls_link\' onClick=\'javascript:expandCollapse(\"MD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'mother_button\' id=\'mother_button\'></span>&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'function_id_mg\' id=\'function_id_mg\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td></tr>\n\t\t\t\t<tr><td>\n\t\t\t\t<div id=\'mother_dtls\'>\n\t\t\t\t\t<table width=\"100%\" cellpadding=1 cellspacing=0 border=\'0\'>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'  width=\'22%\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=text name=\'mother_patient_id1\' id=\'mother_patient_id1\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" maxlength=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" size=\'20\' disabled><input type=button ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" class=button name=\'mothersearch_button\' value=\'?\' onclick=\'mothersearch();\' disabled><img align=center src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'mother_patient_id\' id=\'mother_patient_id\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t<td class=\'label\' colspan=4  >\n\t\t\t\t\t\t\t<table  width=\"100%\" cellpadding=1 cellspacing=0 border=0 ><tr><td class=\'label\'width=\'5%\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t<td class=\'querydata\' id=\"name_moth\">\n\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b>\n\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t</table>\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'mother_patient_id\' id=\'mother_patient_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"> ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\n\t\t\t <tr>\t\t  \n           ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t  <td class=\'label\' height=\"25\"> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t         <td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t <td class=\'QUERYDATA\' >&nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t  <td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' >&nbsp;</td>\n                ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<td class=\'label\' height=\"25\">&nbsp;</td>\n\t\t\t\t<td class=\'QUERYDATA\' height=\"25\">&nbsp;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<a name=\'ViewPatChartSummary\'   href=\"javascript:showPatChartSummary(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\"><B>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</B></a>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>  \t\t\t\t\n\t\t\t</tr>    \n\t\t<tr>\t\n\t\t\t<td class=\'label\' height=\"25\" >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td><input type = \'hidden\' name =\'alt_id_type_desc\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t  <td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</td>\n            ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t  <td  class=\"label\"  height=\"25\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\'  height=\"25\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;</td>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<input type=\'hidden\' name=\'mother_pmi_no\' id=\'mother_pmi_no\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'invoked_from\' id=\'invoked_from\' value = \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t<input type=\'hidden\' name=\'race_required_yn\' id=\'race_required_yn\' value = \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t   <td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t   </tr>\t\t   \n\t\t  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" \t\t\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \t\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t   <tr>\t\n\t\t    ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t<td class=\'label\' height=\"25\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td><input type = \'hidden\'  name =\'alt_id_type_desc\' id=\'alt_id_type_desc\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t    <td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t<td class=\'label\' height=\"25\"><a name=\'ViewPatChartSummary\'   href=\"javascript:showPatChartSummary(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</B></a></td>\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t<td  class=\'QUERYDATA\' height=\"25\"><b>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t  <td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'label\'> &nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t  <td class=\'label\'  >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'label\'> &nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t   </tr>\n\t\t\t   <tr>\n\t\t\t   ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n                      <td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t      <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&nbsp;</td>\n\t\t\t    ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n               ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t</tr>    \n\t\t     <tr>\n\t\t\t    ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t     </tr> \t  \n          ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t<td class=\'fields\' >\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t   <input type=\"checkbox\" name=\"multiple_birth_yn\" id=\"multiple_birth_yn\" onClick=\'enableBirthField(this);\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="disabled";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="></td>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t<td class=\'fields\' >\n\t\t\t<input type=\"text\" name=\"noOfBirths\" id=\"noOfBirths\"  value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' maxlength=1 size=1 onBlur=\"makeValidString(this);getNewBornRegnValues(this.name); setNum(this); return allowValidNumber(this,\'event\',1,0);\" disabled>\n\t\t\t<font id=\'img1\'><img align=center src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></font>\n\t\t  </td>\n\t\t  <input type=\"hidden\" name=\"birth_order\" id=\"birth_order\" value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t  ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<td class=\'querydata\'>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="<input type=\"hidden\" name=\"noOfBirths\" id=\"noOfBirths\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"></td>\n\t\t\t<input type=\"hidden\" name=\"birth_order\" id=\"birth_order\" value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t<td class=\'fields\'><input type = \'hidden\' name =\'unitofgestnb\' id=\'unitofgestnb\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="<!-- Modified against IN:49882 -->\n\t\t\t<input type=\"text\" name=\"gestational_period\" id=\"gestational_period\" maxlength=3 size=2 value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' onBlur=\"return validateMinMax(this,\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\',gestational_period); makeValidString(this);CheckNum(this);return allowValidNumber(this,\'event\',3,0)\" onKeyPress=\'return allowValidNumber(this,event,3,0)\' ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =">\n\t\t\t<select name=\"gestational_unit\" id=\"gestational_unit\" disabled><option value=\'W\' ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="<option value=\'D\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</select>\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t<input type=\"text\" name=\"gestational_period_days\" id=\"gestational_period_days\" maxlength=\'1\' size=\'2\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' onBlur=\"validateGestDays(this);makeValidString(this);return allowValidNumber(this,\'event\',3,0);\" onKeyPress=\'return allowValidNumber(this,event,3,0)\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">&nbsp;";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\t\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t<img src=\'../images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>  \t\t\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t\t\t<td><select name=\"nod_type\" id=\"nod_type\" onChange=\'enDisCompls(this.value,\"Y\")\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="><!--Changes Modified on 30-04-2012 against Incident Numbers 32487 & 32488 By Saanthaakumar--> \n\t\t\t\t<option value=\'\'>------ ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" ------\n\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'DeliveryTypeMandImg\'></img>\n\t\t\t    ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t     <script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\tdocument.forms[0].nod_type.value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"+\"$\"+\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="<!-- Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 -->\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t<td class=\'fields\'>\n\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" <!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t<input type=\"text\" name=\"gravida\" id=\"gravida\" maxlength=2 size=2  value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" onKeyPress=\'return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);\' onBlur=\"checkGravida();makeValidString(this);enableParity(this);checkwithgravida();return allowValidNumber(this,\'event\',2,0);\">";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="<img src=\'../images/mandatory.gif\' align=\'center\'></img>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" <!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t<td class=\'fields\'>\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"text\"  name=\"parity\" id=\"parity\" value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'  ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" maxlength=2 size=2  onKeyPress=\'return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);\' onBlur=\"checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,\'event\',2,0);\">\n\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&nbsp;&nbsp;\n\t\t\t<input type=\"text\"  name=\"parity_on_admission\" id=\"parity_on_admission\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"  ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" maxlength=2 size=2  onKeyPress=\'return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);\' onpaste=\"return OnPaste()\" onBlur=\"checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,\'event\',2,0);\">\n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="<img src=\'../images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t<span>+</span>\n\t\t\t<input type=\"text\"  name=\"parity1\" id=\"parity1\" value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" maxlength=2 size=2  onKeyPress=\'return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);\' onBlur=\"checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,\'event\',2,0);\" title=\"Previous Miscarriage\">  <!--  //68508 -->\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t</td>\n        \t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  >\n\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t</td>\n\t\t\t<input type=\'hidden\' maxlength=10 size=10 name=\"temp_desc\" id=\"temp_desc\" ><input type=\'hidden\' name=\'temp_id_search\' id=\'temp_id_search\' class=button><input type=\'hidden\' name=\"temp_physician_id\" id=\"temp_physician_id\"></td>\n\t\t\t<td  class=\'fields\'><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t<input type=\'text\' maxLength=\"30\" size=\"25\"  name=\"practid_desc\" id=\"practid_desc\" ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" onBlur=\'getattndpract();\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" ><input type=\'button\'  name=\'pract_id_search1\' id=\'pract_id_search1\' value=\'?\' class=\'button\'  onClick=\'callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practid_desc); fixvaluespractitioner();\' ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" ><img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'practid_desc_MandImg\'></img>\n\t\t\t<input type=\'hidden\' name=\"attend_physician_id\" id=\"attend_physician_id\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t<script> \n\t\t\t\t\tdocument.forms[0].attend_physician_id.value = \"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\";\n\t\t\t\t\tdocument.forms[0].practid_desc.value = \"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t</td> <!--Below line modified for this CRF HSA-CRF-0182 -->\t\t\t\n\t\t\t\t<td class=\'label\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=\"att_nurse_newborn\" id=\"att_nurse_newborn\" maxLength=\"30\" size=\"25\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" onblur=\"attendingNurse(this);\" ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" ><input type=\'button\'  name=\'att_nurse_search\' id=\'att_nurse_search\' onClick=\"attendingNurse(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" ><input type=hidden name=\"attend_midwife_id\" id=\"attend_midwife_id\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t\t ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].attend_midwife_id.value = \"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\";\n\t\t\t\t\t        document.forms[0].att_nurse_newborn.value = \"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<input type=\"text\" name=\"mother_witnessed_by1\" id=\"mother_witnessed_by1\" maxlength=80 size=25 ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<input type=\"text\" name=\"mother_witnessed_by2\" id=\"mother_witnessed_by2\" maxlength=80 size=25 ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n                <tr>\t\t\t   \n \t\t\t\t\t<td class=\"label\"  height=\"25\"><span name=\"nationality_id\" id=\"nationality_id\">";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</span></td>\n\t\t\t\t\t<td class=\'QUERYDATA\'  height=\"25\"><span name=\"oth_alternate_id\" id=\"oth_alternate_id\">";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</span>&nbsp;</td>\t\n\t\t\t\t\t<td class=\"label\"  height=\"25\">&nbsp;</td>\n\t\t\t\t\t<td class=\'QUERYDATA\'  height=\"25\">&nbsp;</td>\n\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\t\t\n\t\t    <tr><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t\t\t        <td class=\'fields\' ><input type=text name=\"compln_pregnancy_desc\" id=\"compln_pregnancy_desc\" maxLength=\"75\" size=\"40\" onblur=\"getCompPregnancy(this);\" ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =" ><input type=\'button\'  name=\'comple_preg_button\' id=\'comple_preg_button\' onClick=\"getCompPregnancy(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" ><input type=hidden name=\"compln_pregnancy_code\" id=\"compln_pregnancy_code\" >\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].compln_pregnancy_desc.value = \"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\";\n\t\t\t\t\t\tdocument.forms[0].compln_pregnancy_code.value = \"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\t\t\t\t\t\t   \n\t\t\t\t\t</td>\n\t\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td>\n\t\t\t        <td class=\'fields\' ><input type=text name=\"compln_nr_pregnancy_desc\" id=\"compln_nr_pregnancy_desc\" maxLength=\"75\" size=\"40\" onblur=\"getCompNotRltdPregnancy(this);\" ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="  ><input type=\'button\'  name=\'compln_nr_button\' id=\'compln_nr_button\' onClick=\"getCompNotRltdPregnancy(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="  ><input type=\'hidden\' name=\"compln_nr_pregnancy_code\" id=\"compln_nr_pregnancy_code\" >\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].compln_nr_pregnancy_desc.value = \"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\";\n\t\t\t\t\t\tdocument.forms[0].compln_nr_pregnancy_code.value = \"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t</td>\t\t\t \n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<select name=\"complns_1st_stage_labour_code\" id=\"complns_1st_stage_labour_code\" ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =">\n\t\t\t\t\t<option value=\'\'>------ ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" ------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].complns_1st_stage_labour_code.value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t<img align=\'center\' id = \'complns_1st_stage_labour_code_img\' src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--kamatchi-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<select name=\"complns_2nd_stage_labour_code\" id=\"complns_2nd_stage_labour_code\" ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" ------\n\t\t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].complns_2nd_stage_labour_code.value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</td>\n\t\t\t        <td class=\'fields\'><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t<input type=text maxLength=\"75\" size=\"45\" name=\"del_indica_newborn\" id=\"del_indica_newborn\" onblur=\"delIndiaction(this);\" ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =" ><input type=\'button\'  name=\'del_indica_button\' id=\'del_indica_button\' onClick=\"delIndiaction(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" ><input type=hidden name=\"delivery_indication\" id=\"delivery_indication\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].delivery_indication.value = \"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\";\n\t\t\t\t\t\tdocument.forms[0].del_indica_newborn.value = \"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t\t\t<img align=\'center\' id = \'complns_2nd_stage_labour_code_img\' src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"complns_3rd_stage_labour_code\" id=\"complns_3rd_stage_labour_code\" ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].complns_3rd_stage_labour_code.value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td>\n\t\t\t        <td class=\'fields\' ><input type=text name=\"comple_ofdel_newborn\" id=\"comple_ofdel_newborn\" maxLength=\"75\" size=\"40\" onblur=\"compDelievary(this);\" ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"><input type=\'button\'  name=\'comple_of_button\' id=\'comple_of_button\' onClick=\"compDelievary(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="><input type=\'hidden\' name=\"complications_delivery\" id=\"complications_delivery\" value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].comple_ofdel_newborn.value = \"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\";\n\t\t\t\t\t    document.forms[0].complications_delivery.value = \"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t</td>\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</td>\n\t\t\t        <td class=\'fields\'><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t<input type=text maxLength=\"75\" size=\"40\" name=\"del_indica_newborn\" id=\"del_indica_newborn\" onblur=\"delIndiaction(this);\" ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t<img align=\'center\' id = \'complns_3rd_stage_labour_code_img\' src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'></img> \n\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</td>\n\t\t\t        <td class=\'fields\'><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t<input type=\"text\" name=\"proc_class_desc\" id=\"proc_class_desc\" maxLength=\"75\" size=\"40\" onblur=\'chkprocclass();\' ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" ";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="><input type=\'button\'  name=\'proc_id\' id=\'proc_id\' value=\'?\' class=\'button\' onClick=\'procClass(proc_id,proc_class_desc);\' onKeyPress=\'procClass(proc_id,proc_class_desc);\' ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"proc_class_code\" id=\"proc_class_code\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].proc_class_code.value = \"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].proc_class_desc.value = \"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\t</td></tr>\t\t\t\t\n\t\t\t    <tr class=\'label\'>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t\t        <td  class=\'fields\'><input type=\"text\" name=\"vaginal_del_type_desc\" id=\"vaginal_del_type_desc\" maxLength=\"75\" size=\"40\" onblur=\'chkvagclass();\' ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="><input type=\'button\' name=\'vaginal_del_type_search\' id=\'vaginal_del_type_search\' value=\'?\' class=\'button\' onClick=\'vagClass(vaginal_del_type_search, vaginal_del_type_desc);\' onkeypress=\'vagClass(vaginal_del_type_search, vaginal_del_type_desc);\' ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="><input type=\'hidden\' name=\"vaginal_del_type_code\" id=\"vaginal_del_type_code\" value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].vaginal_del_type_code.value = \"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\";\n\t\t\t\t\tdocument.forms[0].vaginal_del_type_desc.value = \"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"del_serv_desc\" id=\"del_serv_desc\" maxLength=\"75\" size=\"40\" onblur=\'chkdelsurgclass();\' ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="><input type=\'button\'  name=\'del_serv_id\' id=\'del_serv_id\' value=\'?\' class=\'button\' onClick=\'delSurgClass(del_serv_id,del_serv_desc);\' onKeyPress=\'delSurgClass(del_serv_id,del_serv_desc);\' ";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="><input type=\"hidden\" name=\"del_serv_class\" id=\"del_serv_class\" value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].del_serv_class.value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\";\n\t\t\t\t\tdocument.forms[0].del_serv_desc.value = \"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t    <tr><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t        <td class=\'label\'   valign=middle>";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</td>\n\t\t\t\t\t<td colspan=3  >\n\t\t\t\t\t <textarea onKeyPress=\'checkMaxLimit(this,100)\'  onBlur=\'makeValidString(this);chkMotherLength(this,100); \' name=\"remarks\"  rows=\"1\" cols=\"90\" ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="  >";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</textarea>\n\t\t\t\t\t\t\n\t\t\t\t  </td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t\t\t<table width=\"100%\" cellpadding=\'1\' cellspacing=\'0\' border=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<input type = \'hidden\' name = \'ant_born_locn_type\' value = \'\'>\n\t\t\t\t\t<input type = \'hidden\' name = \'ant_born_locn_code\' value = \'\'><!--Below line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="&nbsp;";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'6%\'><input type=\"checkbox\" ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =" name=\"antenatal_care\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" onClick=\"callcareValidate(\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\',\'onClickEvent\')\" ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="></td>\n\t\t\t\t\t<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'50%\'><select name=\"ate_born_where\" id=\"ate_born_where\" onchange=\"onchange_antenatal(this,\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\');\" style=\"width:135\" ";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =" >\n\t\t\t\t\t<option value=\'\' >--------";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="-------</option>\n\t\t\t\t\t<option value=\'I\' >";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="</option>\n\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</option>\n\t\t\t\t\t</select><img id=\'locngif\' align=center src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden;\' name=\'locngif\'></img> / <select name=\"ate_born_at_locn_type\" id=\"ate_born_at_locn_type\" style=\"width:141\" onchange=\"populate_bornat(this,\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\');\" ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =">\n\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 =" ---</option>\n\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="</option>\n\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</option>\n\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="</option>\n\t\t\t\t\t</select>&nbsp;<select name=\"ate_born_at_locn_code\" id=\"ate_born_at_locn_code\" ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="><option value=\'\'>--- ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 =" ---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\t\t\t\t\t\t             \n\t\t\t\t\t</select> <!--Above line modified for this CRF HSA-CRF-0182 -->\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t </table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\t\t<tr><td colspan=4></td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t<script>\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\' == \'Y\') {\n\t\t\t\t\t\t\t\tdocument.getElementById(\"locngif\").style.visibility=\'visible\';\n\t\t\t\t\t\t\t\tdocument.forms[0].antenatal_care.value = \'Y\';\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_where.value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\"; \t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_type.value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\";\n\t\t\t\t\t\t\t\tdocument.forms[0].ant_born_locn_code.value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\";\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].ant_born_locn_type.value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\";\n\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\tdocument.getElementById(\"locngif\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_where.disabled=true;\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_where.value=\'\';\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_type.disabled=true;\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_code.disabled=true;\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_type.value=\'\'; \n\t\t\t\t\t\t\t\tdocument.forms[0].antenatal_care.value = \'N\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\' == \'E\') {\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_type.disabled = true;\n\t\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_code.disabled = true;\n\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n                  ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_type.disabled=true;\n\t\t\t\t\t\t\tdocument.forms[0].ate_born_at_locn_code.disabled=true;\n\t\t\t\t\t\t\tdocument.forms[0].ate_born_where.disabled=true;\n\t\t\t\t\t</script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t\t\t\t<table width=\"100%\" cellpadding=\'1\' cellspacing=\'0\' border=\'0\'>\n\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t<select name=\"mother_alive_yn\" id=\"mother_alive_yn\">\n\t\t\t\t\t\t\t\t<option value=\"Y\" ";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="selected";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</option>\n\t\t\t\t\t\t\t\t<option value=\"N\" ";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n\t\t\t\t</table>\n\t\t\t\t</td></tr> \n\t\t\t<tr><td>\t\t\n\t\t\t\t<table id=\'father_tab\' width=\"100%\" cellpadding=\'1\' cellspacing=0 border=0 >\t\n\t\t\t\t\t<tr><td colspan=\'4\' class=\'COLUMNHEADER\'><span id=\'father_dtls_link\' onClick=\'javascript:expandCollapse(\"FD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'father_button\' id=\'father_button\'></span>&nbsp;";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</td></tr>\n\t\t\t\t</table>\n\t\t\t\t<div>\n\t\t\t<tr><td>\n\t\t\t<div id=\'father_dtls\'>\n\t\t\t<table width=\"100%\" cellpadding=\'1\' cellspacing=0 border=0 >\t\n\t\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t\t\t<input class=\'upper\' type=\"text\" name=\"father_patient_id\" id=\"father_patient_id\"  maxlength=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\" size=\'20\' onblur=\"makeValidString(this); clearData(this);getNewBornRegnValues(\'pat_id\')\" onKeyPress=\"return CheckForSpecChars(event);\" onclick=\"makeValidString(this);getNewBornRegnValues(\'pat_id\')\" value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="><input type=\'button\' ";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =" class=\'button\' value=\'?\' name=\'pat_id_search\' onClick=\"callPatSearch();\"></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'father_age_flag\' id=\'father_age_flag\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'father_patient_id_hd\' id=\'father_patient_id_hd\' value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'>\n\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="</td>\n\t\t\t\t\t\t<td colspan=\'1\' class=\'fields\'>\n\t\t\t\t\t\t<input type=\"text\" name=\"father_patient_name\" id=\"father_patient_name\" disabled maxlength=\"90\" size=\"50\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" onBlur=\'makeMandatory(this,\"FatherDtls\");\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"father_patient_long_name\" id=\"father_patient_long_name\" value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\t\t\t \t \n\t\t\t\t\t\t<input type=\"hidden\" name=\"father_patient_long_name_loc_lang\" id=\"father_patient_long_name_loc_lang\" value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\'>\n\t\t\t\t<table border=\'0\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 =" \t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\">\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'National_id\' id=\'National_id\' maxlength=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\' onkeypress=\"return ";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\"  onblur=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="></td>\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t\t\t <td colspan=\'4\'></td> \t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t</tr>\t\t\n\t\t\t\t<tr>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<td class= \'label\' align = \'right\'>";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\' colspan=\'1\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'father_alt_id1_no\' id=\'father_alt_id1_no\'  onBlur=\'makeValidString(this);\' maxlength=\'";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\' size=\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\' value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="></td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\t\n\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 =" </td>\n\t\t\t\t\t\t<td  colspan=\'";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\' class=\'fields\'>\n\t\t\t\t\t\t<select name=\'cboOtherAltID\' id=\'cboOtherAltID\' onChange=\'enableOtherAlt(this)\' ";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 =">\n\t\t\t\t\t\t<option value=\'\'>-------";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="-------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</select>\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tdocument.forms[0].cboOtherAltID.value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t\t\t\t\t\t<input type=\'text\' name=\'txtOtherAltID\' id=\'txtOtherAltID\' maxlength=20 size=20 value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 =" ></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\t\t\t<tr>\n\t\t\t      ";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\' colspan=\'1\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'father_alt_id2_no\' id=\'father_alt_id2_no\'  onBlur=\'makeValidString(this);\' maxlength=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\n\t\t\t\t\t<td class= \'label\' align = \'right\'>";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\' colspan=\'1\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'father_alt_id3_no\' id=\'father_alt_id3_no\'  onBlur=\'makeValidString(this);\' maxlength=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="></td>\n\t\t\t\t";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t\t     </tr>\n\t\t\t     <tr>\n\t\t\t      ";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\' colspan=\'1\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'father_alt_id4_no\' id=\'father_alt_id4_no\'  onBlur=\'makeValidString(this);\' maxlength=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="</td>\n\t\t\t\t\t<td   class=\'fields\' >\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'text\' ";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="  name=\'cboNationality_desc\' onblur=\"get_Nationality(this);\" value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\"><input class=\'button\' type=\'button\' name=\'cboNationality_button\' id=\'cboNationality_button\' onclick=\"get_Nationality(this);\" value=\'?\' ";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 =" >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'cboNationality\' id=\'cboNationality\' value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t <img id=\'natImg\' align=center src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\">\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 =" </td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'cboEthnicGroupDesc\' id=\'cboEthnicGroupDesc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 =" onblur=\'if(this.value!=\"\"){searchRace(cboEthnicGroup,cboEthnicGroupDesc,\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\");}else{clearfields();}\'><input type=\'button\' name=\'cboEthnicGroupBtn\' id=\'cboEthnicGroupBtn\' value=\'?\' class=\'button\' ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =" onclick=\'searchRace(this,cboEthnicGroupDesc,\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\")\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'cboEthnicGroup\' id=\'cboEthnicGroup\' value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\"><img id=\'racImg\' align=center src=\'../../eCommon/images/mandatory.gif\' style=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\t\t\t\t\t\n\t\t\t\t\t</td>\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\t\t\t\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\"fthGovtEmpl\" id=\"fthGovtEmpl\" ";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 =" value=\'";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="></td>\n\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td   class=\'fields\'><select name=\'cboReligion\' id=\'cboReligion\' ";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 =">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<option value=\'\' selected>---";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="---</option>\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\" selected>";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="</select></td>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].cboReligion.value=\'";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\';\n\t\t\t\t\t\t</script>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\'cboOccupationClass\' id=\'cboOccupationClass\'  onchange=\'enableDesc(this);getNewBornRegnValues(this.name)\' ";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 =">\n\t\t\t\t\t\t\t<option value=\'\' selected>---";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="---</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\t\t\n\t\t\t\t\t </select></td>\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].cboOccupationClass.value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="  </td>\n\t\t\t\t\t<td class=\'fields\'  >\n\t\t\t\t\t<select name=\'cboOccupation\' id=\'cboOccupation\' onchange=\"disOccpDesc()\" ";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 =">\n\t\t\t\t\t<option value=\'\'>-------";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="-------</option>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].cboOccupation.value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\";\n\t\t\t\t\t\t</script>\n                    ";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t\t<input type=text name=\'Occupation_Desc\' id=\'Occupation_Desc\' size=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\' maxlength=\'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\" \n          \t\t\t";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\t\t\t\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 =" </td>\n\t\t\t\t\t<td colspan=\'3\' class=\'fields\'><textarea onKeyPress=\'checkMaxLimit(this,100)\' value = \"\" onBlur=\'makeValidString(this);chkFatherLength(this,100);\' name=\"fatherRemarks\"  rows=\"1\" cols=\"90\" ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="</textarea></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</td></tr>\n\t\t\t<script>\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\'==\'disabled\') {\n\t\t\t\t\n\t\t\t\t\t\tif(document.getElementById(\'first_name\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'first_name\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bf\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bf\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'second_name\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'second_name\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bs\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bs\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'third_name\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'third_name\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bt\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bt\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'family_name\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'family_name\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bfam\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bfam\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'name_prefix\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'name_prefix\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'name_suffix\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'name_suffix\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'first_name_oth_lang\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bfo\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bfo\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'second_name_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'second_name_oth_lang\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bso\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bso\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'third_name_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'third_name_oth_lang\').disabled = true;\n\t\t\t\t\t    if(document.getElementById(\'bto\'))\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'bto\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'family_name_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'family_name_oth_lang\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'bfamo\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'bfamo\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'name_prefix_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'name_prefix_oth_lang\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'name_suffix_oth_lang\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'name_suffix_oth_lang\').disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\'father_patient_name\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'father_patient_name\').disabled = true;\n\t\t\t\t\t}  \n\t\t\t</script>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\n\t\t\t<tr><td>\n\t\t\t<table id=\'newborngrp_tab\' width=\"100%\" cellpadding=1 cellspacing=0 border=0 >\n\t\t\t\t";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n\t\t\t\t\t\t<tr><td class=\'label\'  colspan=\'4\'></td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\n\t\t\t\t<tr> \n\t\t\t\t\t<td colspan=\'4\' class=\'COLUMNHEADER\'><span id = \'newborn_dtls_link\' onClick=\'javascript:expandCollapse(\"ND\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'nb_button\' id=\'nb_button\'></span>&nbsp;";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<tr><td>\n\t\t\t<div id = \'newborn_dtls\'>\n\t\t\t\t<table width=\"100%\" cellpadding=1 cellspacing=0 border=0 >\n\t\t\t\t";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="</td>\n\t\t\t\t\t<td colspan=\'3\' class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"nb_patient_name\" id=\"nb_patient_name\" disabled maxlength=\"90\" size=\"50\" value=\'";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"nb_patient_name_long\" id=\"nb_patient_name_long\" value=\'\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"nb_patient_name_long_local_lang\" id=\"nb_patient_name_long_local_lang\" value=\'\'>\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\'>\n\t\t\t\t<table border=\'0\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 =" \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\t\t\t\t\n\t\t\t\t    ";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'22%\'>";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"new_born_sex\" id=\"new_born_sex\" onChange=\"getNewBornRegnValues(this.name),getRelationShip(this)\">\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="----</option>\n\t                <option value=\'M\'>";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\n\t\t            <option value=\'F\'>";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t        <option value=\'U\'>";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n\t\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'new_born_sex_MandImg\'></img></select>\n\t\t\t\t\t";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].new_born_sex.value = \"";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].new_born_sex.disabled = true;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\n\t\t\t\t\t<!--Below line modified for MMS-QH-CRF-0145.1 [IN:047497]-->\n\t\t\t\t\t<input id=\"dateofbirth\" type=\'text\' name=\'birth_date\' id=\'birth_date\' size=\'8\' maxlength=\'10\' ";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\' onkeypress=\"return Valid_DT(event)\" onblur=\"validateDate(this);calc_hij(this);\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' name=\'nb_calander\'  onClick=\"document.forms[0].birth_date.select();return showCalendar(\'dateofbirth\',\'\',\'\',\'\');\" >\n\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>&nbsp;&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\n\t\t\t\t\t<input type=\'text\' name=\'birth_time\' id=\'birth_time\' size=\'5\' maxlength=\'5\' ";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\' onkeypress=\"return Valid_TM(event)\" onblur=\"validateTime(this)\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t<input type = \'hidden\' name = \'date_of_birth\' value = \'";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\'> \n\t\t\t\t    <input type=\'hidden\' name=\'hij_appl_YN\' id=\'hij_appl_YN\' value=\'";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'invalid_dob\' id=\'invalid_dob\' value=\'N\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'date_of_birth_hjiri\' id=\'date_of_birth_hjiri\' value=\"";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 =" \n\t\t\t\t\t&nbsp;<img id=\'imgdateofbirth_hj\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.getElementById(\'date_of_birth_hj\').select();return showCalendar_hj(\'date_of_birth_hj\',\'\',\'\',\'\');\"  ";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="><input type=\'text\' name=\'date_of_birth_hj\' id=\'date_of_birth_hj\'  maxlength=\'10\' size=\'8\' onblur=\'convertToGD(this);\' value=\"";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t\t\t\t    <script>calc_hij(document.NewbornRegistration_form.birth_date);</script>";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'blood_group\' id=\'blood_group\' ";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 =" ><option value=\'\' >------";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="-------</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\'rf_code\' id=\'rf_code\' ";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="-----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'    >\n\t\t\t\t\t";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\'sltRelationship\' id=\'sltRelationship\' onchange=\"getpat_catrel();\" disabled>\n\t\t\t\t\t<option>---";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="---</option></select></td>\t\n\t\t\t        <td class=\'label\'  >";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="</td>\n\t\t\t        <td class=\'fields\'><select name=\"outcome\" id=\"outcome\" onChange=\'enableFields(this,\"";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\")\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="</option><!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565-->";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="</option>";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="</option></select>&nbsp;<span id = \'stillbirth_dtlsID\' style=\"visibility:hidden\" onClick=\'javascript:stillBirthWindow1()\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\' name=\"apgar_dtls_name\"></span></td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\n                       <script>\n\t\t\t\t\t\t\tdocument.forms[0].outcome.value = \"";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].outcome.disabled = true;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 =" \n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td     class=\'label\'>";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 =":";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 =" </td>\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\"mother_rel_desc\" id=\"mother_rel_desc\" value=\"";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\" disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td     class=\'label\' >";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 =" </td>\n\t\t\t\t\t\t<td >\n\t\t\t\t\t\t<table border=0 cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\"relation_child\" id=\"relation_child\" onchange=\"getpat_catrel()\"";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 =" >\n\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="-----</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'relation_child_MandImg\'></img>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td   class=\'label\'>";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t   <select name=\"relation_child11\" id=\"relation_child11\" ";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 =" onchange=\"callfun_exp_catdate(this);\">\n\t\t\t\t\t\t    <option value=\'\'>----";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="----</option>\n\t\t\t\t\t\t    </select>  \n\t\t\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'relation_child11_MandImg\' ></img>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td><td colspan=1   class=\'label\'>";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'fields\'><input id=\"expcatdate\" type=\'text\' name=\'exp_cat_date\' id=\'exp_cat_date\' onblur=\"validDateObj(this,\'DMY\',localeName);\"  size=\'8\' maxlength=\'10\' value=\'\' disabled ><input id=\"callimag\" type=\"image\"  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].all.expcatdate.select();return showCalendar(\'expcatdate\',null,null,true)\"></td>\n\t\t\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\tdocument.forms[0].relation_child11.value=\"";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\";\n\t\t\t\t\t\t\t    </script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 =" \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\n\t\t\t    <tr>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"indicator_mark\" id=\"indicator_mark\" disabled>\n\t\t\t\t\t<option selected value=\'\'>--- ";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 =" ---</option>\n\t\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="</option>\n\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t     document.NewbornRegistration_form.indicator_mark.value=\'";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\';\n\t\t\t\t\t\t </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 =" \n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name=\"BDVal1\" id=\"BDVal1\" value=\"";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"hddDTTM\" id=\"hddDTTM\" value=\"";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'system_date\' id=\'system_date\' value=\"";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"hddBDate\" id=\"hddBDate\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"hddDate\" id=\"hddDate\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"hddTime\" id=\"hddTime\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"allow_nb_regn_unit\" id=\"allow_nb_regn_unit\" value=";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 =">\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"born_where\" id=\"born_where\" onchange=\"chkumblookup(this,\'";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\');\" style=\"width:155\" ";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 =" >\n\t\t\t\t\t<option value=\'I\' selected>";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="</option>\n\t\t\t\t\t<option value=\'H\'>";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="</option>\n\t\t\t\t\t<option value=\'A\'>";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="</option>\n\t\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="</option>\n\t\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="</option>\n\t\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'born_where_MandImg\' ></img>\t\n                     ";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.forms[0].born_where.selectedIndex=0;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.forms[0].born_where.value=\'";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\'\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\n\t\t\t\t\t</td>    \n\t\t\t\t</tr>\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<select name=\"born_at_locn_type\" id=\"born_at_locn_type\" style=\"width:141\" onchange=\"populate_bornat(this,\'";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 =" >\n\t\t\t\t\t</select>\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"Common.clinic.label\",\"Common\")\n\t\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"Common.emergency.label\",\"Common\")\n\t\t\t\t\t\t\topt.value=\"E\";\n\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"Common.DaycareUnit.label\",\"Common\")\n\t\t\t\t\t\t\topt.value=\"D\";\n\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"Common.nursingUnit.label\",\"Common\")\n\t\t\t\t\t\t\topt.value=\"N\";\n\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\"==\"true\"){\n\t\t\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\topt=document.createElement(\t\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=getLabel(\"eOP.OTSpecific.label\",\"OP\")\n\t\t\t\t\t\t\t\topt.value=\"O\";\n\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t    opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=getLabel(\"Common.ProcedureUnit.label\",\"Common\")\n\t\t\t\t\t\t\t\topt.value=\"P\";\n\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\"==\"Y\"){\n\t\t\t\t\t\t\t    opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=getLabel(\"Common.RadiologyWing.label\",\"Common\")\n\t\t\t\t\t\t\t\topt.value=\"W\";\n\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=getLabel(\"Common.room.label\",\"Common\")\n\t\t\t\t\t\t\t\topt.value=\"R\";\n\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.add(opt);\n\t\t\t\t\t\t}\n\t\t\t\t\t  </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.selectedIndex=0;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.value=\"";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=1 class=label  >";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="</td>\n\t\t\t\t\t<td><select name=\"born_at_locn_code\" id=\"born_at_locn_code\" ";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 =" >\n\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 =" ---</option>          \n\t\t\t\t\t";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.disabled\t\t\t= true;\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_type.options[0].selected\t= true;\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_code.disabled\t\t\t= true;\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].born_at_locn_code.options[0].selected\t= true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'Birth_place_desc\' id=\'Birth_place_desc\'  size=\'15\' maxlength=\'15\' onblur=\'if(this.value != \"\") searchCountry(contry_code,Birth_place_desc)\' value=\'\' ";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 =" ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,Birth_place_desc)\' ";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 =" >\n\t\t\t\t\t<input type=\'hidden\' name=\'Birth_place_code\' id=\'Birth_place_code\' value=\'\'>\n\t\t\t\t\t</td>\n                     ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\";\n\t\t\t\t\t\t document.forms[0].Birth_place_desc.value= \"";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\"birth_cert_no\" id=\"birth_cert_no\" maxlength=15 size=15 ";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 =" ></td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\n\t\t\t\t\t\t     <script>\n\t\t\t\t\t\t     document.forms[0].birth_cert_no.disabled=true;\n\t\t\t\t\t         </script>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\n\t\t\t\t\t\t   <script>\n                            document.forms[0].birth_cert_no.value=\'";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\';\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="</td>\n\t\t\t\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="<input type=\'hidden\' name =\'unitofwtnb\' id=\'unitofwtnb\' value=\'";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\'><input type=\"text\" name=\"weight\" id=\"weight\" maxlength=6 size=4 onBlur=\"return validateMinMax(this,\'";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\',weight);\n\t\t\t\t\tmakeValidString(this);return allowValidNumber(this,\'event\',2,3);\" onKeyPress=\'return allowValidNumber(this,event,2,3)\' ";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 =" ><select disabled name=\"weight_unit\" id=\"weight_unit\"><option value=\'K\'  ";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="<option value=\'L\' ";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="</select><img align=center src=\'../../eCommon/images/mandatory.gif\' id=\'weight_unit_MandImg\'></img>\n\t\t\t\t\t</td> \n                     ";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t document.forms[0].weight.value= value=\'";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="<input type = \'hidden\' name =\'unitoflengthnb\' id=\'unitoflengthnb\' value=\'";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\'><input type=\"text\" name=\"length1\" id=\"length1\" maxlength=6 size=5 onBlur=\"CheckNumZero1(this);return validateMinMax(this,\'";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\',length1);\t\n\t\t\t\t\tmakeValidString(this);return allowValidNumber(this,\'event\',3,2);\" onKeyPress=\'return allowValidNumber(this,event,3,2)\' ";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 =" ><select disabled name=\"length_unit\" id=\"length_unit\"> <option value=\'C\' ";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="<option value=\'I\' ";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="</select>\n\t\t\t\t\t<img align=\'center\' id = \'LENGTH_IMG\' src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\'></img>\n\t\t\t\t\t<!-- Style changed by Kamatchi S for ML-MMOH-CRF-2095-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t document.forms[0].length1.value= value=\'";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="<input type=\'hidden\' name=\'unitofcircumnb\' id=\'unitofcircumnb\' value=\'";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\'><input type=\"text\" name=\"circumference\" id=\"circumference\" maxlength=6 size=4 onBlur=\"CheckNumZero1(this);return validateMinMax(this,\'";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\',circumference);  makeValidString(this);return allowValidNumber(this,\'event\',3,2);\" onKeyPress=\'return allowValidNumber(this,event,3,2)\' ";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 =" ><select disabled name=\"circumference_unit\" id=\"circumference_unit\"><option value=\'C\' ";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="</select>  \t\t\t\n\t\t\t\t\t<img align=\'center\' id = \'CIRCUMFERENCE_IMG\' src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t document.forms[0].circumference.value= value=\"";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\";\n\t\t\t\t\t\t </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="<input type=\'hidden\' name =\'unitofchestunit\' id=\'unitofchestunit\' value = \'";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\'><input type=\"text\" name=\"chest_circumference\" id=\"chest_circumference\" maxlength=6 size=5 onBlur=\"return validateMinMax(this,\'";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\',chest_circumference); makeValidString(this);CheckNum(this);return allowValidNumber(this,\'event\',3,2);\" onKeyPress=\'return allowValidNumber(this,event,3,2)\' ";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 =" ><select disabled name=\"chest_circumference_unit\" id=\"chest_circumference_unit\" ><option value=\'C\' ";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="</select></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t document.forms[0].chest_circumference.value= value=\'";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\n\t\t\t\t\t\n\t\t\t\t\t<!-- Santhosh page splitted for 12c issue-->\n\t\t\t\t";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 =" \n\t\t\t\t\t<!-- Santhosh end page splitted for 12c issue-->\n\t\t\t\t<tr>\t\t\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="</td>\n\t\t\t\t\t<td><select name=\"umbilical_cord_status\" id=\"umbilical_cord_status\" ";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 =" --- </option>\n\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="</option>\n\t\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="</option>\n\t\t\t\t\t</select></td>\n                     ";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\n\t\t\t\t\t\t  <script>\t\n\t\t\t\t\t\t\tdocument.forms[0].umbilical_cord_status.value=\"";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\";\n\t\t\t\t\t\t  </script>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="</td>\n\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\n\t\t\t\t\t    <input type=\'hidden\' name=\"temp_physician_job_title\" id=\"temp_physician_job_title\"><input type =\'text\'  name=\'Umb_cord_cut_by1\' id=\'Umb_cord_cut_by1\' size=20 maxlength=30 value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\" onblur=\"getumbcordcutby(this);\" ";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 =" ><font id=\'UmbCrd\'><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"callPractSearch(document.forms[0].pract_id_search,document.forms[0].Umb_cord_cut_by1); fixvaluesumbcordcutby();\" style=\'visibility:";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 =" >\n\t\t\t\t\t\t<input type=\'hidden\' name=\"Umb_cord_cut_by_physician_id\" id=\"Umb_cord_cut_by_physician_id\" value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\" >\n\t\t\t\t\t\t<input type=\'hidden\' name=\"Umb_cord_cut_by\" id=\"Umb_cord_cut_by\" value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\">\n\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t<img align=center id=\"umb_mand\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\">\n\t\t\t\t\t\t\t</font><font id=\'nmdesig\' class=\'label\'></font>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"Umb_cord_cut_by_desig\" id=\"Umb_cord_cut_by_desig\" ></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="</td>\n\t\t\t\t\t<td><select name=\"feeding\" id=\"feeding\" ";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 =" ---\n\t\t\t\t\t<option value=\'T\'>";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="</option>\n\t\t\t\t\t</select>\n                     ";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\n\t\t\t\t\t\t   <script>\n\t\t\t\t\t\t     document.forms[0].feeding.disabled=true;\n\t\t\t\t\t        </script>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\n\t\t\t\t\t\t   <script>\n                            document.forms[0].feeding.value=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\";\n                           </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\n\t\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 =" </td>\n\t\t\t\t\t<td class=\'fields\'><select name=\'patency_of_anus_yn\' id=\'patency_of_anus_yn\' ";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 =" onchange=\'enablepatencyprac(this);\'>\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="---</option>\n\t\t\t\t\t<option value=\'Y\' ";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="</option>\n\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="</option>\n\t\t\t\t\t</select> \t\t\t\t\t\n\t\t\t\t\t<img align=\'center\' id=\'PATENCY_OF_ANUS_YN_IMG\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'>\n\t\t\t\t\t<input type= \'hidden\' name = \'patency_visibility\' value = \'N\'>\n\t\t\t\t\t</td> \t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'    >";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' maxLength=\"75\" size=\"32\" name=\"Congenital_Anomalies_newborn\" id=\"Congenital_Anomalies_newborn\" onblur=\"Congenital_Ano(this);\" ";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 =" ><input type=\'button\'  name=\'Congenital_Anomalies_search\' id=\'Congenital_Anomalies_search\' onClick=\"Congenital_Ano(this);\" value=\'?\' class=\'button\' ";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 =" ><input type=hidden name=\"Congenital_Anomalies\" id=\"Congenital_Anomalies\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n\t\t\t\t\t\t\t<script> \n\t\t\t\t\t\t\tdocument.forms[0].Congenital_Anomalies_newborn.value=\"";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].Congenital_Anomalies.value=\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\n\t\t\t\t\t\t</td>\t\n\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\n\t\t\t\t<td>\n\t\t\t\t<input type=\'text\' maxLength=\"30\" size=\"25\"  name=\"PatencyofAnusCheckedBy\" id=\"PatencyofAnusCheckedBy\" ";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 =" onBlur=\'getPatencyCheckBy();\' value=\"";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\" ><input type=\'button\'  name=\'pract_id_search_patency\' id=\'pract_id_search_patency\' value=\'?\' class=\'button\'  onClick=\'callPractSearch(document.forms[0].pract_id_search_patency,document.forms[0].PatencyofAnusCheckedBy); Patencyvaluespractitioner();\' ";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 =" >\n\t\t\t\t<input type=\'hidden\' name=\"pract_id_search_patency_hidden\" id=\"pract_id_search_patency_hidden\" value=\"";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\">\n\t\t\t\t<input type=\'hidden\' name=\"prev_patency_prac_hidden\" id=\"prev_patency_prac_hidden\" value=\"";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\">\n\t\t\t\t</td>\t\t\n\t\t\t\t</tr>\n\t\t\t   <tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"stools\" id=\"stools\" ";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 =" ---\n\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="</option>\n\t\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="</td><td class=\'fields\'><input type=\'text\' maxLength=\"75\" size=\"35\" name=\"complications_delivery_text\" id=\"complications_delivery_text\" value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\" onblur=\"comp_delivery(this);\" ";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="><input type=\'button\'  name=\'complications_delivery_search\' id=\'complications_delivery_search\' onClick=\"comp_delivery(this);\" value=\'?\' class=\'button\'  onClick=\'\' ";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="><input type=hidden name=\"complications_delivery_nb\" id=\"complications_delivery_nb\" value=\"";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 =" \n\t\t\t\t\t\t<a href=\"javascript:NeonatalResuscitation();\" style=\"text-decoration:none;white-space: nowrap;\" id=\"linkNeonatalResuscitation\" name=\"linkNeonatalResuscitation\"><b>";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="</b></a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\n\t\t\t\t\t\t</td>\n                     ";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.forms[0].complications_delivery_text.value=\"";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].complications_delivery_nb.value=\"";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\t\n\t\t\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.forms[0].stools.disabled=true;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].stools.value=\"";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\";\n\t\t\t\t\t\t</script>  \n\t\t\t\t   ";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="<tr><td></td><td></td>\n\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bed_number\' id=\'bed_number\' size=\'8\' maxlength=\'8\' value=\'";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\' readonly \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="></input><input type=\'button\' class=\'button\' name=\'bed_lookup\' id=\'bed_lookup\' value=\"?\" onclick=\'bed_search();\' ";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 =">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mother_nursing_unit_code\" id=\"mother_nursing_unit_code\" value=\'";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\'>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mother_bed_no\" id=\"mother_bed_no\" value=\'";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\'>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pseudo_bed_yn\" id=\"pseudo_bed_yn\" value=\'";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\'> \t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"old_bed_number\" id=\"old_bed_number\" value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\n                             <input type=\"hidden\" name=\"mother_nursing_unit_code\" id=\"mother_nursing_unit_code\" value=\'";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mother_bed_no\" id=\"mother_bed_no\" value=\'";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"old_bed_number\" id=\"old_bed_number\" value=\"";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\">\n\t\t\t\t\t\t\t<td class=label colspan=\'4\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 =" \n\t\t\t\t\t\t\t\n\t\t\t\t</tr> \n\t\t\t ";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\n\t\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\n\t\t\t<input type=\'hidden\' maxlength=10 size=10 name=\"resuscit_temp_desc\" id=\"resuscit_temp_desc\" ><input type=\'hidden\' name=\'resuscit_temp_id_search\' id=\'resuscit_temp_id_search\' class=button><input type=\'hidden\' name=\"resuscit_physician_id\" id=\"resuscit_physician_id\">\n\t\t\t</td>\n            <td  class=\'fields\'>\n\t\t\t<input type=\'text\' maxLength=\"30\" size=\"25\"  name=\"resuscit_practid_desc\" id=\"resuscit_practid_desc\"  onBlur=\'getresuscitpract();\' value=\"";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\" ><input type=\'button\'  name=\'resuscit_pract_id_search1\' id=\'resuscit_pract_id_search1\' value=\'?\' class=\'button\'  onClick=\'callPractSearch1(document.forms[0].resuscit_pract_id_search1,document.forms[0].resuscit_practid_desc); fixvaluespractitioner1();\'>\n\t\t\t<input type=\'hidden\' name=\"resuscit_attend_pract_id\" id=\"resuscit_attend_pract_id\" value=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\">\n\t\t\t</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n            <td  class=\'fields\'>&nbsp;</td>\n            </tr>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\n\t\t\t\t   <script> \n\t\t\t\t   document.forms[0].resuscit_attend_pract_id.value = \"";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\";\n\t\t\t\t   document.forms[0].resuscit_practid_desc.value = \"";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\";\n\t\t\t\t   document.forms[0].resuscit_practid_desc.disabled = \"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\";\n\t\t\t\t    document.forms[0].resuscit_pract_id_search1.disabled =\"";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\";\n\t\t\t\t  </script> \n\t\t\t";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\n\t\t\t\t<tr><td colspan=\'4\'>\t\t\t\t\t\n\t\t\t\t\t<table border=\'0\' id=\'child_tab2\' width=\"100%\" cellpadding=1 cellspacing=0>\n\t\t\t\t\t\t<tr><td colspan=\'6\' class=\'columnheader\'><span id = \'vaccin_dtls_link\' onClick=\'javascript:expandCollapse(\"VD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'vacc_button\' id=\'vacc_button\'></span>&nbsp";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\n\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td></tr>\n\t\t\t\t<tr><td colspan=\'4\'>\n\t\t\t\t<div id = \'vaccin_dtls\'>\n\t\t\t\t<table border=\'0\' width=\"100%\" cellpadding=1 cellspacing=0>\n\t\t\t\t<!-- row 1 -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'   width=\'15%\'></td>\n\t\t\t\t\t<td class=\'label\'   width=\'3%\'></td>\n\t\t\t\t\t<td class=\'label\'   width=\'19%\'>";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="</td>\n\t\t\t\t\t<td class=\'label\'   width=\'19%\'>";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="</td>\n\t\t\t\t\t <td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="</td> \n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'     width=\'12%\'>";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"checkbox\" name=\"bcg_given_yn\" id=\"bcg_given_yn\" ";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="onClick=\'chkValues(this);enableBcg(this);\' value=\'";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="  ";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'txtVaccSite\' id=\'txtVaccSite\' value=\"";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\" maxlength=\'30\' size=\'25\' ";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'administeredBy\' id=\'administeredBy\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\" size=\'25\' ";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'Designation\' id=\'Designation\' value=\"";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'bcg_datetime\'  id = \'bcgdatetime\' onkeypress=\"return Valid_DT(event)\" onBlur=\"calldoDateTimeChk(this);chk_with_birthdate(this);\" maxlength=\'16\' value=\"";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\" size=\'14\' ";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="><img  id=\'image1\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].bcg_datetime.select(); if( !document.forms[0].bcg_datetime.disabled){return showCalendar(\'bcgdatetime\',null,\'hh:mm\',\'modal\')}\" ";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="/></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'     width=\'12%\'>";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"checkbox\" name=\"vitak_given_yn\" id=\"vitak_given_yn\"  onClick=\'chkValues(this);enableVitak(this);\'  value=\'";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 =" ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' value=\"";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 =" name=\'vitak_VaccSite\' maxlength=30 size = \'25\' ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'vitak_administeredBy\' id=\'vitak_administeredBy\' value=\"";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 =" maxlength=30 size = \'25\' ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'vitak_Designation\' id=\'vitak_Designation\' value=\"";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 =" maxlength=30 size = \'25\' ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'vitk_datetime\' value=\"";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 =" id = \'vitkdatetime\' onkeypress=\"return Valid_DT(event)\" onBlur=\"calldoDateTimeChk(this);chk_with_birthdate(this);\" maxlength=16 size = \'14\'><img ";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="  id=\'image2\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].vitk_datetime.select(); if(! document.forms[0].vitk_datetime.disabled ){return showCalendar(\'vitkdatetime\',null,\'hh:mm\',\'modal\')}\"/></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"checkbox\" name=\"hep_given_yn\" id=\"hep_given_yn\" onClick=\'chkValues(this);enableHepb(this);\' value=\'";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 =" ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' value=\'";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 =" name=\'hepb_VaccSite\' maxlength=30 size = \'25\' ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'hepb_administeredBy\' id=\'hepb_administeredBy\' value=\'";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 =" maxlength=30 size = \'25\'  ></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' value=\'";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 =" name=\'hepb_Designation\' maxlength=30 size = \'25\' ></td>\t\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'hepb_datetime\' value=\'";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="\'  id = \'hepbdatetime\' onkeypress=\"return Valid_DT(event)\" onBlur=\"calldoDateTimeChk(this);chk_with_birthdate(this);\" maxlength=16 size = \'14\' ";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 ="><img ";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 =" id=\'image3\'  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].hepb_datetime.select();if(! document.forms[0].hepb_datetime.disabled){return showCalendar(\'hepbdatetime\',null,\'hh:mm\',\'modal\')}\"/>\t\t\t\t\t\t\n\t\t\t\t\t</td> \t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t\t<tr><td class=\'label\' colspan=\'4\'></td></tr>\n\t\t\t\t<tr><td class=\'label\' colspan=\'4\'></td></tr>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="\n\t\t\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t\t\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="\n\t\t\t\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t</td></tr>\n\t\t\t</table>\n\t\t\t\t<script> \n\t\t\t\t\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\'==\'disabled\') {\n\t\t\t\t\t\tif(document.getElementById(\"first_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"first_name[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"second_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"second_name[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"third_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"third_name[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"family_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"family_name[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"first_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"first_name_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"second_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"second_name_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"third_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"third_name_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"family_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"family_name_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang[1]\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"nb_patient_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"nb_patient_name\").disabled = true; \n\t\t\t\t\t\t\n\t\t\t\t\t\t/*if(\'";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\'==\'disabled\') {\n\t\t\t\t\t\tif(document.getElementById(\"first_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"first_name\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"second_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"second_name\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"third_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"third_name\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"family_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"family_name\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"first_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"first_name_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"second_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"second_name_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"third_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"third_name_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"family_name_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"family_name_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\").disabled = true;\n\t\t\t\t\t\tif(document.getElementById(\"nb_patient_name\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"nb_patient_name\").disabled = true;\n\t\t\t\t\t\t*/\n\t\t\t\t\t}  \n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\n\t\t\t\t\t\t <script>\t \n\t\t\t\t\t\t\tdocument.forms[0].bcg_given_yn.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].vitak_given_yn.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].hep_given_yn.disabled = true;\n\t\t\t\t\t\t </script>\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"natImg\").style.visibility = \'visible\';\t\n\t\t\t\t\tif(document.getElementById(\"race_required_yn\")) {\n\t\t\t\t\t\tif(document.getElementById(\"race_required_yn\").value == \'Y\') {\n\t\t\t\t\t\t\tif(document.getElementById(\"racImg\").style.visibility) {\n\t\t\t\t\t\t\t\tdocument.getElementById(\"racImg\").style.visibility = \'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\n\t\t\t<input type=hidden name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\"";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\">\n\t\t\t<input type=hidden name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\"> \n\t\t\t<input type=hidden name=\'family_org_sub_id\' id=\'family_org_sub_id\' value=\"";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\">\t   \n\t\t\t<input type=hidden name=\'family_org_id\' id=\'family_org_id\' value=\"";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\">\n\t\t\t<input type=hidden name=\'family_org_membership\' id=\'family_org_membership\' value=\"";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 ="\">\n\t\t\t<input type=hidden name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="\">\n\t\t\t<input type=hidden name=\'family_org_id_accept_yn_hd\' id=\'family_org_id_accept_yn_hd\' value=\"";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\">\n\t\t\t<input type=hidden name=\'family_no_link_yn_hd\' id=\'family_no_link_yn_hd\' value=\"";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\">\n\t\t\t<input type=hidden name=\'HeadPatientid\' id=\'HeadPatientid\' value=\"";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\">\n\t\t\t<input type=hidden name=\'child_mandatoryfield\' id=\'child_mandatoryfield\' value=\"";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="\">\n\t\t\t<input type=hidden name=\'cat_mandatoryfield\' id=\'cat_mandatoryfield\' value=\"";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\">\n\t\t\t<input type=hidden name=\'def_nb_male_relationship\' id=\'def_nb_male_relationship\' value=\"";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="\">\n\t\t\t<input type=hidden name=\'def_nb_female_relationship\' id=\'def_nb_female_relationship\' value=\"";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 ="\">\n\t\t\t<input type=hidden name=\'def_nb_unknown_relationship\' id=\'def_nb_unknown_relationship\' value=\"";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"insert\">\n\t\t\t<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\'Y\'></input>\n\t\t\t<input type=\'hidden\' name=\'name_suffix_male_nb\' id=\'name_suffix_male_nb\' value=\"";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_suffix_female_nb\' id=\'name_suffix_female_nb\' value=\"";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\"></input>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\n\t\t\t<input type=\'hidden\' name=\'mother_patient_id\' id=\'mother_patient_id\' value=\"";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\"></input>\n \t\t\t";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );

    private final static java.lang.String  _wl_block668 ="\n\t\t\t<input type=\'hidden\' name=\'mother_encounter_id\' id=\'mother_encounter_id\' value=\"";
    private final static byte[]  _wl_block668Bytes = _getBytes( _wl_block668 );

    private final static java.lang.String  _wl_block669 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\"sel_accession_num\" id=\"sel_accession_num\" value=\"";
    private final static byte[]  _wl_block669Bytes = _getBytes( _wl_block669 );

    private final static java.lang.String  _wl_block670 ="\">\n\t\t\t<input type=\'hidden\' name=\"isNeonatalApplicable\" id=\"isNeonatalApplicable\" value=\"";
    private final static byte[]  _wl_block670Bytes = _getBytes( _wl_block670 );

    private final static java.lang.String  _wl_block671 ="\"> \n\t\t\t<input type=\'hidden\' name=\"single_stage_appl_yn\" id=\"single_stage_appl_yn\" value=\"";
    private final static byte[]  _wl_block671Bytes = _getBytes( _wl_block671 );

    private final static java.lang.String  _wl_block672 ="\">  \n\t\t\t<input type=\'hidden\' name=\"modify_delivery_type\" id=\"modify_delivery_type\" value=\"";
    private final static byte[]  _wl_block672Bytes = _getBytes( _wl_block672 );

    private final static java.lang.String  _wl_block673 ="\">  \n\t\t\t<input type=\'hidden\' name=\"mother_name\" id=\"mother_name\" value=\"\">    \n\t\t\t<input type=\'hidden\' name=\'inhouse_birth_yn\' id=\'inhouse_birth_yn\' value=\"";
    private final static byte[]  _wl_block673Bytes = _getBytes( _wl_block673 );

    private final static java.lang.String  _wl_block674 ="\">\n\t\t\t<input type=\'hidden\' name=\'system_time\' id=\'system_time\' value=\"";
    private final static byte[]  _wl_block674Bytes = _getBytes( _wl_block674 );

    private final static java.lang.String  _wl_block675 ="\"> \n\t\t\t<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'allow_nb_regn_within_days\' id=\'allow_nb_regn_within_days\' value=\"";
    private final static byte[]  _wl_block675Bytes = _getBytes( _wl_block675 );

    private final static java.lang.String  _wl_block676 ="\">   \n\t\t\t<input type=\'hidden\' name=\'maxLength\' id=\'maxLength\' value=\"";
    private final static byte[]  _wl_block676Bytes = _getBytes( _wl_block676 );

    private final static java.lang.String  _wl_block677 ="\">\t\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block677Bytes = _getBytes( _wl_block677 );

    private final static java.lang.String  _wl_block678 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'CalledFromFunction\' id=\'CalledFromFunction\' value=\"";
    private final static byte[]  _wl_block678Bytes = _getBytes( _wl_block678 );

    private final static java.lang.String  _wl_block679 ="\">\n\t\t\t<input type=\'hidden\' name=\'nb_use_mother_ser\' id=\'nb_use_mother_ser\' value=\"";
    private final static byte[]  _wl_block679Bytes = _getBytes( _wl_block679 );

    private final static java.lang.String  _wl_block680 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'duplicate\' id=\'duplicate\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'accessRights\' id=\'accessRights\' value=\"";
    private final static byte[]  _wl_block680Bytes = _getBytes( _wl_block680 );

    private final static java.lang.String  _wl_block681 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'parent_details\' id=\'parent_details\' value=\"";
    private final static byte[]  _wl_block681Bytes = _getBytes( _wl_block681 );

    private final static java.lang.String  _wl_block682 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'min_weight\' id=\'min_weight\' value=\"";
    private final static byte[]  _wl_block682Bytes = _getBytes( _wl_block682 );

    private final static java.lang.String  _wl_block683 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'max_weight\' id=\'max_weight\' value=\"";
    private final static byte[]  _wl_block683Bytes = _getBytes( _wl_block683 );

    private final static java.lang.String  _wl_block684 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'min_length\' id=\'min_length\' value=\"";
    private final static byte[]  _wl_block684Bytes = _getBytes( _wl_block684 );

    private final static java.lang.String  _wl_block685 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'max_length\' id=\'max_length\' value=\"";
    private final static byte[]  _wl_block685Bytes = _getBytes( _wl_block685 );

    private final static java.lang.String  _wl_block686 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'min_head_circum\' id=\'min_head_circum\' value=\"";
    private final static byte[]  _wl_block686Bytes = _getBytes( _wl_block686 );

    private final static java.lang.String  _wl_block687 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'max_head_circum\' id=\'max_head_circum\' value=\"";
    private final static byte[]  _wl_block687Bytes = _getBytes( _wl_block687 );

    private final static java.lang.String  _wl_block688 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'min_chest_circum\' id=\'min_chest_circum\' value=\"";
    private final static byte[]  _wl_block688Bytes = _getBytes( _wl_block688 );

    private final static java.lang.String  _wl_block689 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'max_chest_circum\' id=\'max_chest_circum\' value=\"";
    private final static byte[]  _wl_block689Bytes = _getBytes( _wl_block689 );

    private final static java.lang.String  _wl_block690 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'min_gestation\' id=\'min_gestation\' value=\"";
    private final static byte[]  _wl_block690Bytes = _getBytes( _wl_block690 );

    private final static java.lang.String  _wl_block691 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'max_gestation\' id=\'max_gestation\' value=\"";
    private final static byte[]  _wl_block691Bytes = _getBytes( _wl_block691 );

    private final static java.lang.String  _wl_block692 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'pat_ser_prefix_reqd_yn\' id=\'pat_ser_prefix_reqd_yn\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'page_show\' id=\'page_show\' value=\'";
    private final static byte[]  _wl_block692Bytes = _getBytes( _wl_block692 );

    private final static java.lang.String  _wl_block693 ="\'>\t\n\t\t\t<input type=\'hidden\' name=\'page_colour\' id=\'page_colour\' value=\'";
    private final static byte[]  _wl_block693Bytes = _getBytes( _wl_block693 );

    private final static java.lang.String  _wl_block694 ="\'>\n\t\t\t<input type=\'hidden\' name=\"pat_ser_grp_code\" id=\"pat_ser_grp_code\">\n\t\t\t<input type=\'hidden\' name=\"patient_id\" id=\"patient_id\" value=";
    private final static byte[]  _wl_block694Bytes = _getBytes( _wl_block694 );

    private final static java.lang.String  _wl_block695 =">\n\t\t\t<input type=\'hidden\' name=\"number_of_births_recorded\" id=\"number_of_births_recorded\" value=\"";
    private final static byte[]  _wl_block695Bytes = _getBytes( _wl_block695 );

    private final static java.lang.String  _wl_block696 ="\">\n\t\t\t<input type=\'hidden\' name=\'mp_parm_reqdate\' id=\'mp_parm_reqdate\' value=\"";
    private final static byte[]  _wl_block696Bytes = _getBytes( _wl_block696 );

    private final static java.lang.String  _wl_block697 ="\">\n\t\t\t<input type=\'hidden\' name=\'mp_parm_systemdate\' id=\'mp_parm_systemdate\' value=\"";
    private final static byte[]  _wl_block697Bytes = _getBytes( _wl_block697 );

    private final static java.lang.String  _wl_block698 ="\"> \n\t\t\t<input type=\'hidden\' name=\"help_function_id\" id=\"help_function_id\" value=\'REGISTER_NEWBORN\'>\n\t\t\t<input type=\'hidden\' name=\"function_invoked\" id=\"function_invoked\" value = \"";
    private final static byte[]  _wl_block698Bytes = _getBytes( _wl_block698 );

    private final static java.lang.String  _wl_block699 ="\">\n\t\t\t<input type=\'hidden\' name=\"module_invoked\" id=\"module_invoked\" value = \"";
    private final static byte[]  _wl_block699Bytes = _getBytes( _wl_block699 );

    private final static java.lang.String  _wl_block700 ="\">\n\t\t\t<input type=\'hidden\' name=\"ip_install_yn\" id=\"ip_install_yn\" value = \"";
    private final static byte[]  _wl_block700Bytes = _getBytes( _wl_block700 );

    private final static java.lang.String  _wl_block701 ="\">\n \t\t\t<input type=\'hidden\' name=\'invoke_adm_from_newborn_yn\' id=\'invoke_adm_from_newborn_yn\' value=\"";
    private final static byte[]  _wl_block701Bytes = _getBytes( _wl_block701 );

    private final static java.lang.String  _wl_block702 ="\">\n \t\t\t<input type=\'hidden\' name=\"called_function\" id=\"called_function\" value = \"";
    private final static byte[]  _wl_block702Bytes = _getBytes( _wl_block702 );

    private final static java.lang.String  _wl_block703 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block703Bytes = _getBytes( _wl_block703 );

    private final static java.lang.String  _wl_block704 ="\">\n\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block704Bytes = _getBytes( _wl_block704 );

    private final static java.lang.String  _wl_block705 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_nb_regn_blng_class\' id=\'dflt_nb_regn_blng_class\' value=\'";
    private final static byte[]  _wl_block705Bytes = _getBytes( _wl_block705 );

    private final static java.lang.String  _wl_block706 ="\'>\n\t\t\t<input type=\'hidden\' name=\'fatherAltId1Desc\' id=\'fatherAltId1Desc\' value=\"";
    private final static byte[]  _wl_block706Bytes = _getBytes( _wl_block706 );

    private final static java.lang.String  _wl_block707 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'parent_details1\' id=\'parent_details1\' value=\"";
    private final static byte[]  _wl_block707Bytes = _getBytes( _wl_block707 );

    private final static java.lang.String  _wl_block708 ="\">\t\n\t\t\t\t<input type=\'hidden\' name=\'q_mother_date_of_birth\' id=\'q_mother_date_of_birth\' value=\"";
    private final static byte[]  _wl_block708Bytes = _getBytes( _wl_block708 );

    private final static java.lang.String  _wl_block709 ="\">\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block709Bytes = _getBytes( _wl_block709 );

    private final static java.lang.String  _wl_block710 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'complications_delivery_hd\' id=\'complications_delivery_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'att_nurse_newborn_hd\' id=\'att_nurse_newborn_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'delivery_indication_hd\' id=\'delivery_indication_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'proc_class_desc_hd\' id=\'proc_class_desc_hd\' value=\"";
    private final static byte[]  _wl_block710Bytes = _getBytes( _wl_block710 );

    private final static java.lang.String  _wl_block711 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'vaginal_del_type_desc_hd\' id=\'vaginal_del_type_desc_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'del_serv_desc_hd\' id=\'del_serv_desc_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'birthplace_desc_hd\' id=\'birthplace_desc_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'Congenital_Anomalies_hd\' id=\'Congenital_Anomalies_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'complications_delivery_hd1\' id=\'complications_delivery_hd1\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'cboNationality_hd\' id=\'cboNationality_hd\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'entitlement_by_pat_cat_ynhd\' id=\'entitlement_by_pat_cat_ynhd\' value=\"";
    private final static byte[]  _wl_block711Bytes = _getBytes( _wl_block711 );

    private final static java.lang.String  _wl_block712 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'function_name_nb\' id=\'function_name_nb\' value=\"";
    private final static byte[]  _wl_block712Bytes = _getBytes( _wl_block712 );

    private final static java.lang.String  _wl_block713 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'captureAntenatalDtlsYN\' id=\'captureAntenatalDtlsYN\' value=\"";
    private final static byte[]  _wl_block713Bytes = _getBytes( _wl_block713 );

    private final static java.lang.String  _wl_block714 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\"";
    private final static byte[]  _wl_block714Bytes = _getBytes( _wl_block714 );

    private final static java.lang.String  _wl_block715 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_long\' id=\'name_drvn_logic_long\' value=\"";
    private final static byte[]  _wl_block715Bytes = _getBytes( _wl_block715 );

    private final static java.lang.String  _wl_block716 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\"";
    private final static byte[]  _wl_block716Bytes = _getBytes( _wl_block716 );

    private final static java.lang.String  _wl_block717 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang_long\' id=\'name_drvn_logic_oth_lang_long\' value=\"";
    private final static byte[]  _wl_block717Bytes = _getBytes( _wl_block717 );

    private final static java.lang.String  _wl_block718 ="\">\n\t\t\t\t<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->\n\t\t\t\t<input type=\'hidden\' name=\'First_Name_Accpt_Yn\' id=\'First_Name_Accpt_Yn\' value=\"";
    private final static byte[]  _wl_block718Bytes = _getBytes( _wl_block718 );

    private final static java.lang.String  _wl_block719 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'Second_Name_Accpt_Yn\' id=\'Second_Name_Accpt_Yn\' value=\"";
    private final static byte[]  _wl_block719Bytes = _getBytes( _wl_block719 );

    private final static java.lang.String  _wl_block720 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'Third_Name_Accpt_Yn\' id=\'Third_Name_Accpt_Yn\' value=\"";
    private final static byte[]  _wl_block720Bytes = _getBytes( _wl_block720 );

    private final static java.lang.String  _wl_block721 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'Family_Name_Accpt_Yn\' id=\'Family_Name_Accpt_Yn\' value=\"";
    private final static byte[]  _wl_block721Bytes = _getBytes( _wl_block721 );

    private final static java.lang.String  _wl_block722 ="\">\n\t\t\t\t<!--End ML-MMOH-CRF-1551-->\n\t\t\t\t<input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\"";
    private final static byte[]  _wl_block722Bytes = _getBytes( _wl_block722 );

    private final static java.lang.String  _wl_block723 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'generate_file\' id=\'generate_file\' value=\"";
    private final static byte[]  _wl_block723Bytes = _getBytes( _wl_block723 );

    private final static java.lang.String  _wl_block724 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'disable_finalized_button_yn\' id=\'disable_finalized_button_yn\' value=\"";
    private final static byte[]  _wl_block724Bytes = _getBytes( _wl_block724 );

    private final static java.lang.String  _wl_block725 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'father_name_prefix\' id=\'father_name_prefix\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_first_name\' id=\'father_first_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_second_name\' id=\'father_second_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_third_name\' id=\'father_third_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_family_name\' id=\'father_family_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_name_suffix\' id=\'father_name_suffix\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_name_prefix_loc_lang\' id=\'father_name_prefix_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_first_name_loc_lang\' id=\'father_first_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_second_name_loc_lang\' id=\'father_second_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_third_name_loc_lang\' id=\'father_third_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_family_name_loc_lang\' id=\'father_family_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_name_suffix_loc_lang\' id=\'father_name_suffix_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_name_prefix\' id=\'nb_name_prefix\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_first_name\' id=\'nb_first_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_second_name\' id=\'nb_second_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_third_name\' id=\'nb_third_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_family_name\' id=\'nb_family_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_name_suffix\' id=\'nb_name_suffix\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_name_prefix_loc_lang\' id=\'nb_name_prefix_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_first_name_loc_lang\' id=\'nb_first_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_second_name_loc_lang\' id=\'nb_second_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_third_name_loc_lang\' id=\'nb_third_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_family_name_loc_lang\' id=\'nb_family_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_name_suffix_loc_lang\' id=\'nb_name_suffix_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'father_patient_name_loc_lang\' id=\'father_patient_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block725Bytes = _getBytes( _wl_block725 );

    private final static java.lang.String  _wl_block726 ="\">\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'nb_patient_name_loc_lang\' id=\'nb_patient_name_loc_lang\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_patient_name_loc_lang_long\' id=\'nb_patient_name_loc_lang_long\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'newTransactionYN\' id=\'newTransactionYN\' value=\"";
    private final static byte[]  _wl_block726Bytes = _getBytes( _wl_block726 );

    private final static java.lang.String  _wl_block727 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'accept_names_for_live_birth_yn\' id=\'accept_names_for_live_birth_yn\' value=\"";
    private final static byte[]  _wl_block727Bytes = _getBytes( _wl_block727 );

    private final static java.lang.String  _wl_block728 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_first_name_hid\' id=\'nb_first_name_hid\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_second_name_hid\' id=\'nb_second_name_hid\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_third_name_hid\' id=\'nb_third_name_hid\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_family_name_hid\' id=\'nb_family_name_hid\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_first_name_hid_loc\' id=\'nb_first_name_hid_loc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_second_name_hid_loc\' id=\'nb_second_name_hid_loc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_third_name_hid_loc\' id=\'nb_third_name_hid_loc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_family_name_hid_loc\' id=\'nb_family_name_hid_loc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'pract_id_still_birth\' id=\'pract_id_still_birth\' value=\"";
    private final static byte[]  _wl_block728Bytes = _getBytes( _wl_block728 );

    private final static java.lang.String  _wl_block729 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'attendant_at_birth\' id=\'attendant_at_birth\' value=\"";
    private final static byte[]  _wl_block729Bytes = _getBytes( _wl_block729 );

    private final static java.lang.String  _wl_block730 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'autopsy_reqd_yn\' id=\'autopsy_reqd_yn\' value=\"";
    private final static byte[]  _wl_block730Bytes = _getBytes( _wl_block730 );

    private final static java.lang.String  _wl_block731 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_main_cod\' id=\'mate_cond_main_cod\' value=\"";
    private final static byte[]  _wl_block731Bytes = _getBytes( _wl_block731 );

    private final static java.lang.String  _wl_block732 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_main_cod_dur\' id=\'mate_cond_main_cod_dur\' value=\"";
    private final static byte[]  _wl_block732Bytes = _getBytes( _wl_block732 );

    private final static java.lang.String  _wl_block733 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_oth_cod\' id=\'mate_cond_oth_cod\' value=\"";
    private final static byte[]  _wl_block733Bytes = _getBytes( _wl_block733 );

    private final static java.lang.String  _wl_block734 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_oth_cod_dur\' id=\'mate_cond_oth_cod_dur\' value=\"";
    private final static byte[]  _wl_block734Bytes = _getBytes( _wl_block734 );

    private final static java.lang.String  _wl_block735 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_preexist_cod\' id=\'mate_cond_preexist_cod\' value=\"";
    private final static byte[]  _wl_block735Bytes = _getBytes( _wl_block735 );

    private final static java.lang.String  _wl_block736 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mate_cond_preexist_cod_dur\' id=\'mate_cond_preexist_cod_dur\' value=\"";
    private final static byte[]  _wl_block736Bytes = _getBytes( _wl_block736 );

    private final static java.lang.String  _wl_block737 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'oth_rel_mate_cond_rel_cod\' id=\'oth_rel_mate_cond_rel_cod\' value=\"";
    private final static byte[]  _wl_block737Bytes = _getBytes( _wl_block737 );

    private final static java.lang.String  _wl_block738 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'oth_rel_mate_cond_rel_cod_dur\' id=\'oth_rel_mate_cond_rel_cod_dur\' value=\"";
    private final static byte[]  _wl_block738Bytes = _getBytes( _wl_block738 );

    private final static java.lang.String  _wl_block739 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_main_cod\' id=\'cond_cau_dea_main_cod\' value=\"";
    private final static byte[]  _wl_block739Bytes = _getBytes( _wl_block739 );

    private final static java.lang.String  _wl_block740 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_main_cod_dur\' id=\'cond_cau_dea_main_cod_dur\' value=\"";
    private final static byte[]  _wl_block740Bytes = _getBytes( _wl_block740 );

    private final static java.lang.String  _wl_block741 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_oth_cod\' id=\'cond_cau_dea_oth_cod\' value=\"";
    private final static byte[]  _wl_block741Bytes = _getBytes( _wl_block741 );

    private final static java.lang.String  _wl_block742 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_oth_cod_dur\' id=\'cond_cau_dea_oth_cod_dur\' value=\"";
    private final static byte[]  _wl_block742Bytes = _getBytes( _wl_block742 );

    private final static java.lang.String  _wl_block743 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_preexist_cod\' id=\'cond_cau_dea_preexist_cod\' value=\"";
    private final static byte[]  _wl_block743Bytes = _getBytes( _wl_block743 );

    private final static java.lang.String  _wl_block744 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cond_cau_dea_preexist_cod_dur\' id=\'cond_cau_dea_preexist_cod_dur\' value=\"";
    private final static byte[]  _wl_block744Bytes = _getBytes( _wl_block744 );

    private final static java.lang.String  _wl_block745 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'rel_cond_cau_dea_rel_cod\' id=\'rel_cond_cau_dea_rel_cod\' value=\"";
    private final static byte[]  _wl_block745Bytes = _getBytes( _wl_block745 );

    private final static java.lang.String  _wl_block746 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'rel_cond_cau_dea_rel_cod_dur\' id=\'rel_cond_cau_dea_rel_cod_dur\' value=\"";
    private final static byte[]  _wl_block746Bytes = _getBytes( _wl_block746 );

    private final static java.lang.String  _wl_block747 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'called_from_mothercare\' id=\'called_from_mothercare\' value=\"";
    private final static byte[]  _wl_block747Bytes = _getBytes( _wl_block747 );

    private final static java.lang.String  _wl_block748 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'apgar_score_changedYN\' id=\'apgar_score_changedYN\' value=\"N\">\n\t\t\t\t<input type=\'hidden\' name=\'data_upd_allowed_aft_final_yn\' id=\'data_upd_allowed_aft_final_yn\' value=\"";
    private final static byte[]  _wl_block748Bytes = _getBytes( _wl_block748 );

    private final static java.lang.String  _wl_block749 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'q_finalized_yn\' id=\'q_finalized_yn\' value=\"";
    private final static byte[]  _wl_block749Bytes = _getBytes( _wl_block749 );

    private final static java.lang.String  _wl_block750 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'still_brith_dtls_mand\' id=\'still_brith_dtls_mand\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'q_indicator_mark\' id=\'q_indicator_mark\' value=\"";
    private final static byte[]  _wl_block750Bytes = _getBytes( _wl_block750 );

    private final static java.lang.String  _wl_block751 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_prefix_male_nb\' id=\'name_prefix_male_nb\' value=\"";
    private final static byte[]  _wl_block751Bytes = _getBytes( _wl_block751 );

    private final static java.lang.String  _wl_block752 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_prefix_female_nb\' id=\'name_prefix_female_nb\' value=\"";
    private final static byte[]  _wl_block752Bytes = _getBytes( _wl_block752 );

    private final static java.lang.String  _wl_block753 ="\">\n\t\t\t\t<!-- Below line Added by Afruddin for ML-MMOH-CRF-1520 US 0002 -->\n\t\t\t\t<input type=\'hidden\' name=\'name_prefix_unknown_nb\' id=\'name_prefix_unknown_nb\' value=\"";
    private final static byte[]  _wl_block753Bytes = _getBytes( _wl_block753 );

    private final static java.lang.String  _wl_block754 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_suffix_male_nb\' id=\'name_suffix_male_nb\' value=\"";
    private final static byte[]  _wl_block754Bytes = _getBytes( _wl_block754 );

    private final static java.lang.String  _wl_block755 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_suffix_female_nb\' id=\'name_suffix_female_nb\' value=\"";
    private final static byte[]  _wl_block755Bytes = _getBytes( _wl_block755 );

    private final static java.lang.String  _wl_block756 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_pfx_loc_lang_male_nb\' id=\'name_pfx_loc_lang_male_nb\' value=\"";
    private final static byte[]  _wl_block756Bytes = _getBytes( _wl_block756 );

    private final static java.lang.String  _wl_block757 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_pfx_loc_lang_female_nb\' id=\'name_pfx_loc_lang_female_nb\' value=\"";
    private final static byte[]  _wl_block757Bytes = _getBytes( _wl_block757 );

    private final static java.lang.String  _wl_block758 ="\">\n\t\t\t\t<!-- Below line Added by Afruddin for ML-MMOH-CRF-1520 US 0002 -->\n\t\t\t\t<input type=\'hidden\' name=\'name_pfx_loc_lang_unknown_nb\' id=\'name_pfx_loc_lang_unknown_nb\' value=\"";
    private final static byte[]  _wl_block758Bytes = _getBytes( _wl_block758 );

    private final static java.lang.String  _wl_block759 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_sfx_loc_lang_male_nb\' id=\'name_sfx_loc_lang_male_nb\' value=\"";
    private final static byte[]  _wl_block759Bytes = _getBytes( _wl_block759 );

    private final static java.lang.String  _wl_block760 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'name_sfx_loc_lang_female_nb\' id=\'name_sfx_loc_lang_female_nb\' value=\"";
    private final static byte[]  _wl_block760Bytes = _getBytes( _wl_block760 );

    private final static java.lang.String  _wl_block761 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'single_stage_nb_reg_appl_yn\' id=\'single_stage_nb_reg_appl_yn\' value=\"";
    private final static byte[]  _wl_block761Bytes = _getBytes( _wl_block761 );

    private final static java.lang.String  _wl_block762 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ca_comp_in_del_stage1\' id=\'ca_comp_in_del_stage1\' value=\"";
    private final static byte[]  _wl_block762Bytes = _getBytes( _wl_block762 );

    private final static java.lang.String  _wl_block763 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ca_comp_in_del_stage2\' id=\'ca_comp_in_del_stage2\' value=\"";
    private final static byte[]  _wl_block763Bytes = _getBytes( _wl_block763 );

    private final static java.lang.String  _wl_block764 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ca_comp_in_del_stage3\' id=\'ca_comp_in_del_stage3\' value=\"";
    private final static byte[]  _wl_block764Bytes = _getBytes( _wl_block764 );

    private final static java.lang.String  _wl_block765 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ca_comp_of_delivery\' id=\'ca_comp_of_delivery\' value=\"";
    private final static byte[]  _wl_block765Bytes = _getBytes( _wl_block765 );

    private final static java.lang.String  _wl_block766 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mother_patient_id_2\' id=\'mother_patient_id_2\' value=\"";
    private final static byte[]  _wl_block766Bytes = _getBytes( _wl_block766 );

    private final static java.lang.String  _wl_block767 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'MC_Dtls_YN\' id=\'MC_Dtls_YN\' value=\"";
    private final static byte[]  _wl_block767Bytes = _getBytes( _wl_block767 );

    private final static java.lang.String  _wl_block768 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'lmp_ca\' id=\'lmp_ca\' value=\"";
    private final static byte[]  _wl_block768Bytes = _getBytes( _wl_block768 );

    private final static java.lang.String  _wl_block769 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mc_cycle_no\' id=\'mc_cycle_no\' value=\"";
    private final static byte[]  _wl_block769Bytes = _getBytes( _wl_block769 );

    private final static java.lang.String  _wl_block770 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_father_min_age\' id=\'nb_father_min_age\' value=\"";
    private final static byte[]  _wl_block770Bytes = _getBytes( _wl_block770 );

    private final static java.lang.String  _wl_block771 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'newborn_pat_ser_grp\' id=\'newborn_pat_ser_grp\' value=\"";
    private final static byte[]  _wl_block771Bytes = _getBytes( _wl_block771 );

    private final static java.lang.String  _wl_block772 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'allow_ext_nb_regn_within_days\' id=\'allow_ext_nb_regn_within_days\' value=\"";
    private final static byte[]  _wl_block772Bytes = _getBytes( _wl_block772 );

    private final static java.lang.String  _wl_block773 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'isAllow_External_Newborn\' id=\'isAllow_External_Newborn\' value=\"";
    private final static byte[]  _wl_block773Bytes = _getBytes( _wl_block773 );

    private final static java.lang.String  _wl_block774 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'nb_dflt_relnship_code\' id=\'nb_dflt_relnship_code\' value=\"";
    private final static byte[]  _wl_block774Bytes = _getBytes( _wl_block774 );

    private final static java.lang.String  _wl_block775 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'siteId\' id=\'siteId\' value=\"";
    private final static byte[]  _wl_block775Bytes = _getBytes( _wl_block775 );

    private final static java.lang.String  _wl_block776 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_alt_id1_no\' id=\'mthr_alt_id1_no\' value=\"";
    private final static byte[]  _wl_block776Bytes = _getBytes( _wl_block776 );

    private final static java.lang.String  _wl_block777 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_alt_id2_no\' id=\'mthr_alt_id2_no\' value=\"";
    private final static byte[]  _wl_block777Bytes = _getBytes( _wl_block777 );

    private final static java.lang.String  _wl_block778 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_alt_id3_no\' id=\'mthr_alt_id3_no\' value=\"";
    private final static byte[]  _wl_block778Bytes = _getBytes( _wl_block778 );

    private final static java.lang.String  _wl_block779 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_alt_id4_no\' id=\'mthr_alt_id4_no\' value=\"";
    private final static byte[]  _wl_block779Bytes = _getBytes( _wl_block779 );

    private final static java.lang.String  _wl_block780 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'father_alt_id1_desc\' id=\'father_alt_id1_desc\' value=\"";
    private final static byte[]  _wl_block780Bytes = _getBytes( _wl_block780 );

    private final static java.lang.String  _wl_block781 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'father_alt_id2_desc\' id=\'father_alt_id2_desc\' value=\"";
    private final static byte[]  _wl_block781Bytes = _getBytes( _wl_block781 );

    private final static java.lang.String  _wl_block782 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'father_alt_id3_desc\' id=\'father_alt_id3_desc\' value=\"";
    private final static byte[]  _wl_block782Bytes = _getBytes( _wl_block782 );

    private final static java.lang.String  _wl_block783 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'father_alt_id4_desc\' id=\'father_alt_id4_desc\' value=\"";
    private final static byte[]  _wl_block783Bytes = _getBytes( _wl_block783 );

    private final static java.lang.String  _wl_block784 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_nat_id_no\' id=\'mthr_nat_id_no\' value=\"";
    private final static byte[]  _wl_block784Bytes = _getBytes( _wl_block784 );

    private final static java.lang.String  _wl_block785 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mthr_oth_alt_id_No\' id=\'mthr_oth_alt_id_No\' value=\"";
    private final static byte[]  _wl_block785Bytes = _getBytes( _wl_block785 );

    private final static java.lang.String  _wl_block786 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'oth_alt_id_type\' id=\'oth_alt_id_type\' value=\"";
    private final static byte[]  _wl_block786Bytes = _getBytes( _wl_block786 );

    private final static java.lang.String  _wl_block787 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'still_born_prefix\' id=\'still_born_prefix\' value=\"";
    private final static byte[]  _wl_block787Bytes = _getBytes( _wl_block787 );

    private final static java.lang.String  _wl_block788 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dflt_race_nat_setup\' id=\'dflt_race_nat_setup\' value=\"";
    private final static byte[]  _wl_block788Bytes = _getBytes( _wl_block788 );

    private final static java.lang.String  _wl_block789 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'citizen_nationality_code\' id=\'citizen_nationality_code\' value=\"";
    private final static byte[]  _wl_block789Bytes = _getBytes( _wl_block789 );

    private final static java.lang.String  _wl_block790 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block790Bytes = _getBytes( _wl_block790 );

    private final static java.lang.String  _wl_block791 ="\">\n                <input type=\'hidden\' name=\'nb_mother_dtls_update_yn\' id=\'nb_mother_dtls_update_yn\' value=\"";
    private final static byte[]  _wl_block791Bytes = _getBytes( _wl_block791 );

    private final static java.lang.String  _wl_block792 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' value=\"";
    private final static byte[]  _wl_block792Bytes = _getBytes( _wl_block792 );

    private final static java.lang.String  _wl_block793 ="\"> \n\t\t\t\t<input type=\'hidden\' name=\'disable_button_yn\' id=\'disable_button_yn\' value=\"";
    private final static byte[]  _wl_block793Bytes = _getBytes( _wl_block793 );

    private final static java.lang.String  _wl_block794 ="\"> \n\t\t\t\t<input type=\'hidden\' name=\'finalize_yn\' id=\'finalize_yn\' value=\"";
    private final static byte[]  _wl_block794Bytes = _getBytes( _wl_block794 );

    private final static java.lang.String  _wl_block795 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'multibirthvalue\' id=\'multibirthvalue\' value=\"";
    private final static byte[]  _wl_block795Bytes = _getBytes( _wl_block795 );

    private final static java.lang.String  _wl_block796 ="\"><!-- added by krishna pranay ML-MMOH-CRF-1759.1 -->\n\t\t\t\t<input type=\'hidden\' name=\'regnStatus\' id=\'regnStatus\' value=\"";
    private final static byte[]  _wl_block796Bytes = _getBytes( _wl_block796 );

    private final static java.lang.String  _wl_block797 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'birth_order_format\' id=\'birth_order_format\' value=\"";
    private final static byte[]  _wl_block797Bytes = _getBytes( _wl_block797 );

    private final static java.lang.String  _wl_block798 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'isLabelChangeApplicable\' id=\'isLabelChangeApplicable\' value=\"";
    private final static byte[]  _wl_block798Bytes = _getBytes( _wl_block798 );

    private final static java.lang.String  _wl_block799 ="\"><!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565-->\n\t\t\t\t<input type=\'hidden\' name=\'isRegNewbornApplicable\' id=\'isRegNewbornApplicable\' value=\"";
    private final static byte[]  _wl_block799Bytes = _getBytes( _wl_block799 );

    private final static java.lang.String  _wl_block800 ="\">\n                 <input type=\'hidden\' name=\'accept_national_id_no_yn\' id=\'accept_national_id_no_yn\' value=\"";
    private final static byte[]  _wl_block800Bytes = _getBytes( _wl_block800 );

    private final static java.lang.String  _wl_block801 ="\">\n                 <input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"";
    private final static byte[]  _wl_block801Bytes = _getBytes( _wl_block801 );

    private final static java.lang.String  _wl_block802 ="\"> \t\t\t\t \n\t\t\t\t <input type=\'hidden\' name=\'newborn_birth_order\' id=\'newborn_birth_order\' value=\"";
    private final static byte[]  _wl_block802Bytes = _getBytes( _wl_block802 );

    private final static java.lang.String  _wl_block803 ="\"> \n                 <input type=\'hidden\' name=\"multiple_birth_patname\" id=\"multiple_birth_patname\" value=\"\"> \n                 <input type=\'hidden\' name=\"nameprefix\" id=\"nameprefix\" value=\"\">\n                 <input type=\'hidden\' name=\"firstNamederieved\" id=\"firstNamederieved\" value=\"\">\n                 <input type=\'hidden\' name=\"familyderievedName\" id=\"familyderievedName\" value=\"\">\n\t\t\t\t <input type=\'hidden\' name=\"emer_regn_nb_yn\" id=\"emer_regn_nb_yn\" value=\"";
    private final static byte[]  _wl_block803Bytes = _getBytes( _wl_block803 );

    private final static java.lang.String  _wl_block804 ="\"> <!-- Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17-->\n\t\t\t\t <input type=\'hidden\' name=\"isNewBornChngsAppl\" id=\"isNewBornChngsAppl\" value=\"";
    private final static byte[]  _wl_block804Bytes = _getBytes( _wl_block804 );

    private final static java.lang.String  _wl_block805 ="\">\n\t\t\t\t<!-- Added by Kamatchi S for ML-MMOH-CRF-2095-->\n\t\t\t\t <input type=\'hidden\' name=\"length_of_baby_yn\" id=\"length_of_baby_yn\" value=\"";
    private final static byte[]  _wl_block805Bytes = _getBytes( _wl_block805 );

    private final static java.lang.String  _wl_block806 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"head_circumference_of_baby_yn\" id=\"head_circumference_of_baby_yn\" value=\"";
    private final static byte[]  _wl_block806Bytes = _getBytes( _wl_block806 );

    private final static java.lang.String  _wl_block807 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"isMPMandatoryFieldsNewborn\" id=\"isMPMandatoryFieldsNewborn\" value=\"";
    private final static byte[]  _wl_block807Bytes = _getBytes( _wl_block807 );

    private final static java.lang.String  _wl_block808 ="\"> \n\t\t\t\t <input type=\'hidden\' name=\"mandate_first_newborn_ip_yn\" id=\"mandate_first_newborn_ip_yn\" value=\"";
    private final static byte[]  _wl_block808Bytes = _getBytes( _wl_block808 );

    private final static java.lang.String  _wl_block809 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_second_newborn_ip_yn\" id=\"mandate_second_newborn_ip_yn\" value=\"";
    private final static byte[]  _wl_block809Bytes = _getBytes( _wl_block809 );

    private final static java.lang.String  _wl_block810 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_third_newborn_ip_yn\" id=\"mandate_third_newborn_ip_yn\" value=\"";
    private final static byte[]  _wl_block810Bytes = _getBytes( _wl_block810 );

    private final static java.lang.String  _wl_block811 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mand_antenatal_newborn_ip_yn\" id=\"mand_antenatal_newborn_ip_yn\" value=\"";
    private final static byte[]  _wl_block811Bytes = _getBytes( _wl_block811 );

    private final static java.lang.String  _wl_block812 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_first_newborn_yn\" id=\"mandate_first_newborn_yn\" value=\"";
    private final static byte[]  _wl_block812Bytes = _getBytes( _wl_block812 );

    private final static java.lang.String  _wl_block813 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_second_newborn_yn\" id=\"mandate_second_newborn_yn\" value=\"";
    private final static byte[]  _wl_block813Bytes = _getBytes( _wl_block813 );

    private final static java.lang.String  _wl_block814 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_third_newborn_yn\" id=\"mandate_third_newborn_yn\" value=\"";
    private final static byte[]  _wl_block814Bytes = _getBytes( _wl_block814 );

    private final static java.lang.String  _wl_block815 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mand_antenatal_newborn_yn\" id=\"mand_antenatal_newborn_yn\" value=\"";
    private final static byte[]  _wl_block815Bytes = _getBytes( _wl_block815 );

    private final static java.lang.String  _wl_block816 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_first_newborn_ae_yn\" id=\"mandate_first_newborn_ae_yn\" value=\"";
    private final static byte[]  _wl_block816Bytes = _getBytes( _wl_block816 );

    private final static java.lang.String  _wl_block817 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_second_newborn_ae_yn\" id=\"mandate_second_newborn_ae_yn\" value=\"";
    private final static byte[]  _wl_block817Bytes = _getBytes( _wl_block817 );

    private final static java.lang.String  _wl_block818 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mandate_third_newborn_ae_yn\" id=\"mandate_third_newborn_ae_yn\" value=\"";
    private final static byte[]  _wl_block818Bytes = _getBytes( _wl_block818 );

    private final static java.lang.String  _wl_block819 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mand_antenatal_newborn_ae_yn\" id=\"mand_antenatal_newborn_ae_yn\" value=\"";
    private final static byte[]  _wl_block819Bytes = _getBytes( _wl_block819 );

    private final static java.lang.String  _wl_block820 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"emer_regn_nb\" id=\"emer_regn_nb\" value=\"";
    private final static byte[]  _wl_block820Bytes = _getBytes( _wl_block820 );

    private final static java.lang.String  _wl_block821 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"ip_regn_nb_yn\" id=\"ip_regn_nb_yn\" value=\"";
    private final static byte[]  _wl_block821Bytes = _getBytes( _wl_block821 );

    private final static java.lang.String  _wl_block822 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mp_regn_nb_yn\" id=\"mp_regn_nb_yn\" value=\"";
    private final static byte[]  _wl_block822Bytes = _getBytes( _wl_block822 );

    private final static java.lang.String  _wl_block823 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"dflt_father_first_name_prompt\" id=\"dflt_father_first_name_prompt\" value=\"";
    private final static byte[]  _wl_block823Bytes = _getBytes( _wl_block823 );

    private final static java.lang.String  _wl_block824 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"dflt_father_Second_name_prompt\" id=\"dflt_father_Second_name_prompt\" value=\"";
    private final static byte[]  _wl_block824Bytes = _getBytes( _wl_block824 );

    private final static java.lang.String  _wl_block825 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"dflt_father_third_name_prompt\" id=\"dflt_father_third_name_prompt\" value=\"";
    private final static byte[]  _wl_block825Bytes = _getBytes( _wl_block825 );

    private final static java.lang.String  _wl_block826 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"dflt_father_family_name_prompt\" id=\"dflt_father_family_name_prompt\" value=\"";
    private final static byte[]  _wl_block826Bytes = _getBytes( _wl_block826 );

    private final static java.lang.String  _wl_block827 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"names_in_oth_lang_yn\" id=\"names_in_oth_lang_yn\" value=\"";
    private final static byte[]  _wl_block827Bytes = _getBytes( _wl_block827 );

    private final static java.lang.String  _wl_block828 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"First_Name_Reqd_Yn\" id=\"First_Name_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block828Bytes = _getBytes( _wl_block828 );

    private final static java.lang.String  _wl_block829 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Second_Name_Reqd_Yn\" id=\"Second_Name_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block829Bytes = _getBytes( _wl_block829 );

    private final static java.lang.String  _wl_block830 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Third_Name_Reqd_Yn\" id=\"Third_Name_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block830Bytes = _getBytes( _wl_block830 );

    private final static java.lang.String  _wl_block831 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Family_Name_Reqd_Yn\" id=\"Family_Name_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block831Bytes = _getBytes( _wl_block831 );

    private final static java.lang.String  _wl_block832 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Name_Prefix_Accept_Yn\" id=\"Name_Prefix_Accept_Yn\" value=\"";
    private final static byte[]  _wl_block832Bytes = _getBytes( _wl_block832 );

    private final static java.lang.String  _wl_block833 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Name_Prefix_Reqd_Yn\" id=\"Name_Prefix_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block833Bytes = _getBytes( _wl_block833 );

    private final static java.lang.String  _wl_block834 ="\">\n\t\t\t\t  <input type=\'hidden\' name=\"Name_Suffix_Accept_Yn\" id=\"Name_Suffix_Accept_Yn\" value=\"";
    private final static byte[]  _wl_block834Bytes = _getBytes( _wl_block834 );

    private final static java.lang.String  _wl_block835 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"Name_Suffix_Reqd_Yn\" id=\"Name_Suffix_Reqd_Yn\" value=\"";
    private final static byte[]  _wl_block835Bytes = _getBytes( _wl_block835 );

    private final static java.lang.String  _wl_block836 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"mpDisableFieldsNBFather\" id=\"mpDisableFieldsNBFather\" value=\"";
    private final static byte[]  _wl_block836Bytes = _getBytes( _wl_block836 );

    private final static java.lang.String  _wl_block837 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"nb_father_name_mandatory_yn\" id=\"nb_father_name_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block837Bytes = _getBytes( _wl_block837 );

    private final static java.lang.String  _wl_block838 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"enable_marital_status\" id=\"enable_marital_status\" value=\"";
    private final static byte[]  _wl_block838Bytes = _getBytes( _wl_block838 );

    private final static java.lang.String  _wl_block839 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"invokeMenstrualHistYN\" id=\"invokeMenstrualHistYN\" value=\"";
    private final static byte[]  _wl_block839Bytes = _getBytes( _wl_block839 );

    private final static java.lang.String  _wl_block840 ="\">  <!-- 68508 -->\n\t\t\t\t <input type=\'hidden\' name=\"mandParityNewBornYN\" id=\"mandParityNewBornYN\" value=\"";
    private final static byte[]  _wl_block840Bytes = _getBytes( _wl_block840 );

    private final static java.lang.String  _wl_block841 ="\">      <!-- 68508 -->\n\t\t\t\t <input type=\'hidden\' name=\"mandParityNewBornAE_YN\" id=\"mandParityNewBornAE_YN\" value=\"";
    private final static byte[]  _wl_block841Bytes = _getBytes( _wl_block841 );

    private final static java.lang.String  _wl_block842 ="\"><!-- 68508 -->\n\t\t\t\t <input type=\'hidden\' name=\"mandParityNewBornIP_YN\" id=\"mandParityNewBornIP_YN\" value=\"";
    private final static byte[]  _wl_block842Bytes = _getBytes( _wl_block842 );

    private final static java.lang.String  _wl_block843 ="\"><!-- 68508 -->\n\t\t\t\t <input type=\'hidden\' name=\"isModifyLongShortDescAppl\" id=\"isModifyLongShortDescAppl\" value=\"";
    private final static byte[]  _wl_block843Bytes = _getBytes( _wl_block843 );

    private final static java.lang.String  _wl_block844 ="\"> <!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->\n\t\t\t\t <!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->  \n\t\t\t\t <input type=\'hidden\' name=\"isNameDervnLogicNBAppl\" id=\"isNameDervnLogicNBAppl\" value=\"";
    private final static byte[]  _wl_block844Bytes = _getBytes( _wl_block844 );

    private final static java.lang.String  _wl_block845 ="\">\n\t\t\t\t <input type=\'hidden\' name=\"nb_derv_logic_appl\" id=\"nb_derv_logic_appl\" value=\"N\"> \n\n\t\t\t\t <input type=\'hidden\' name=\"accession_num_nb_note\" id=\"accession_num_nb_note\" value=\"";
    private final static byte[]  _wl_block845Bytes = _getBytes( _wl_block845 );

    private final static java.lang.String  _wl_block846 ="\">\n\t\t\t\t<script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block846Bytes = _getBytes( _wl_block846 );

    private final static java.lang.String  _wl_block847 ="\t\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'btnNewbornAssessmentNote\').disabled=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block847Bytes = _getBytes( _wl_block847 );

    private final static java.lang.String  _wl_block848 ="\n\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block848Bytes = _getBytes( _wl_block848 );

    private final static java.lang.String  _wl_block849 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'finalized_yn\' id=\'finalized_yn\' value=\"Y\">\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block849Bytes = _getBytes( _wl_block849 );

    private final static java.lang.String  _wl_block850 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'finalized_yn\' id=\'finalized_yn\' value=\"";
    private final static byte[]  _wl_block850Bytes = _getBytes( _wl_block850 );

    private final static java.lang.String  _wl_block851 ="\">\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block851Bytes = _getBytes( _wl_block851 );

    private final static java.lang.String  _wl_block852 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block852Bytes = _getBytes( _wl_block852 );

    private final static java.lang.String  _wl_block853 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'refreshFramesYN\' id=\'refreshFramesYN\' value=\"Y\">\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block853Bytes = _getBytes( _wl_block853 );

    private final static java.lang.String  _wl_block854 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'refreshFramesYN\' id=\'refreshFramesYN\' value=\"N\">\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block854Bytes = _getBytes( _wl_block854 );

    private final static java.lang.String  _wl_block855 ="\n\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\'getRelationShip(document.forms[0].new_born_sex,\"Y\");\',100);\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].sltRelationship.value=\'";
    private final static byte[]  _wl_block855Bytes = _getBytes( _wl_block855 );

    private final static java.lang.String  _wl_block856 ="\'\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block856Bytes = _getBytes( _wl_block856 );

    private final static java.lang.String  _wl_block857 ="\n\t\t\t\t<script>\n\t\t\t\t<!--Below line Added for this CRF HSA-CRF-0182 -->\n\t\t\t\t   if(\'";
    private final static byte[]  _wl_block857Bytes = _getBytes( _wl_block857 );

    private final static java.lang.String  _wl_block858 ="\'==\"Y\"&&\'";
    private final static byte[]  _wl_block858Bytes = _getBytes( _wl_block858 );

    private final static java.lang.String  _wl_block859 ="\'==\"N\"&&\'";
    private final static byte[]  _wl_block859Bytes = _getBytes( _wl_block859 );

    private final static java.lang.String  _wl_block860 ="\'==\"Y\"){document.forms[0].remarks.disabled=true;}\n\t\t\t \n\t\t\t\t   if(\'";
    private final static byte[]  _wl_block860Bytes = _getBytes( _wl_block860 );

    private final static java.lang.String  _wl_block861 ="\'==\"Y\" && \'";
    private final static byte[]  _wl_block861Bytes = _getBytes( _wl_block861 );

    private final static java.lang.String  _wl_block862 ="\'!=\"Y\"&&\'";
    private final static byte[]  _wl_block862Bytes = _getBytes( _wl_block862 );

    private final static java.lang.String  _wl_block863 ="\'!=\"Y\" && \'";
    private final static byte[]  _wl_block863Bytes = _getBytes( _wl_block863 );

    private final static java.lang.String  _wl_block864 ="\'!=\"R\"){ enDisCompls(document.forms[0].nod_type.value,\'N\')}\n\t\t\t\t   <!--End HSA-CRF-0182 -->\n\t\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block864Bytes = _getBytes( _wl_block864 );

    private final static java.lang.String  _wl_block865 ="\" != \'\')\n\t\t\t\t{\n\t\t\t\t\t";
    private final static byte[]  _wl_block865Bytes = _getBytes( _wl_block865 );

    private final static java.lang.String  _wl_block866 =" //Modified by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]\n\t\t\t\t\n\t\t\t\t\tif(parent.parent.frames[0].document.forms[0].home)\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].home.disabled = true;\n\t\t\t\t\tif(parent.parent.frames[0].document.forms[0].reset)\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].reset.disabled = false;\n\t\t\t\t\t";
    private final static byte[]  _wl_block866Bytes = _getBytes( _wl_block866 );

    private final static java.lang.String  _wl_block867 ="\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t\t\n\t\t</form>\n\t\t\t";
    private final static byte[]  _wl_block867Bytes = _getBytes( _wl_block867 );

    private final static java.lang.String  _wl_block868 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.newbornheader_frame) {\t\t\t\t\t\n\t\t\t\t\t\tif(parent.newbornheader_frame.document.getElementById(\"pat_ser_grp_code\")) {\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.newbornheader_frame.document.getElementById(\"pat_ser_grp_code\").value = \'";
    private final static byte[]  _wl_block868Bytes = _getBytes( _wl_block868 );

    private final static java.lang.String  _wl_block869 ="\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.newbornheader_frame.document.getElementById(\'pat_ser_grp_code_desc\')) {\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.newbornheader_frame.document.getElementById(\'pat_ser_grp_code_desc\').value = \'";
    private final static byte[]  _wl_block869Bytes = _getBytes( _wl_block869 );

    private final static java.lang.String  _wl_block870 ="\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block870Bytes = _getBytes( _wl_block870 );

    private final static java.lang.String  _wl_block871 ="\t\n\t<script> \t\t\t\n\t\t";
    private final static byte[]  _wl_block871Bytes = _getBytes( _wl_block871 );

    private final static java.lang.String  _wl_block872 ="\n\t</script>\n\t<script>\nif(\"";
    private final static byte[]  _wl_block872Bytes = _getBytes( _wl_block872 );

    private final static java.lang.String  _wl_block873 ="\"==\"true\" && document.getElementById(\'father_dtls_link\')!=null){\n\t     document.getElementById(\'father_dtls_link\').onclick();          \n}\nif(\"";
    private final static byte[]  _wl_block873Bytes = _getBytes( _wl_block873 );

    private final static java.lang.String  _wl_block874 ="\"==\"true\"){ \n         \n\t\t  var babyoutcome=\"\";\n\t\t  var babyborn_where=\"\";\n\t\t if(document.forms[0].outcome.disabled){\n\t\t\t document.forms[0].outcome.disabled = false;\n\t\t\t babyoutcome=document.forms[0].outcome.value; \n\t\t\t babyborn_where=document.forms[0].born_where.value; \n\t\t\t document.forms[0].outcome.disabled = true;\n\t\t }else{\n\t\t\t babyoutcome=document.forms[0].outcome.value; \n\t\t\t babyborn_where=document.forms[0].born_where.value; \n\t\t }\n\t\t\nif(\"";
    private final static byte[]  _wl_block874Bytes = _getBytes( _wl_block874 );

    private final static java.lang.String  _wl_block875 ="\"==\"N\" && babyoutcome ==\"L\" && babyborn_where==\"I\")\t{ \n\t\t document.forms[0].CIRCUMFERENCE_IMG.style.visibility=\'visible\';\t \n\t\t document.forms[0].LENGTH_IMG.style.visibility=\'visible\';\n    }\nif(\"";
    private final static byte[]  _wl_block875Bytes = _getBytes( _wl_block875 );

    private final static java.lang.String  _wl_block876 ="\"==\"N\" && (babyoutcome!=\"L\" || babyborn_where!=\"I\"))\t{ \n\t document.forms[0].CIRCUMFERENCE_IMG.style.visibility=\'hidden\';\t \n     document.forms[0].LENGTH_IMG.style.visibility=\'hidden\';\n\t}\n\t\n}\n\tfunction OnPaste() {\n            return false;   // cancels the onpaste event\n     }\n\t</script>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block876Bytes = _getBytes( _wl_block876 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	HashMap mPParamDtls =  new HashMap(); 
   	HashMap mthrDtls				= new HashMap();
    HashMap hashMap3				= new HashMap();
    HashMap hashMap10				= new HashMap();
    HashMap hashMap11				= new HashMap();
    HashMap hashMap12				= new HashMap();
    HashMap hashMap13				= new HashMap();
    HashMap hashMap					= new HashMap();
	ArrayList array_list			= new ArrayList();
	
	String emer_regn_nb_yn			= "N";	//Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17
	ArrayList column_name=new ArrayList();/*Added by Rameswar on 30th July 2015 against HSA_CRF_0305 IN054700*/
	String nb_father_name_mandatory_yn = "";
	String newborn_pat_ser_grp = "";
	String nb_dflt_relnship_code = "";
	
	String dis_bed_fields ="", accessRights = "", q_gestational_period = "", q_gestational_period_days = "", getAllowNewBornDate = "", patency_sel1 = "" ,patency_sel2 = "", old_bed_number = "", pseudo_bed_yn = "", alt_id1_type_desc = "", alt_id2_type_desc = "", alt_id3_type_desc = "", alt_id4_type_desc = "", oth_alt_id_type = "", mthr_oth_alt_id_type = "", cd1 = "", cd2 = "", cd3 = "", cd4 = "", alt_id1_type = "", alt_id1_length = "", alt_id2_length = "", alt_id3_length = "", alt_id4_length = "", alt_id1_len_validation_yn = "", alt_id1_routine_yn = "", alt_id1_data_source_id = "", alt_id1_chk_digit_scheme = "" , alt_id1_accept_alphanumeric_yn	= "", nat_id_accept_alphanumeric_yn	= "", name_dervn_logic = "", name_dervn_logic_long = "", name_dervn_logic_oth_lang = "", name_dervn_logic_oth_lang_long = "", race_required_yn="", race_style = "visibility:hidden", single_stage_nb_reg_appl_yn = "N", MC_Dtls_YN="", cong_anom_desc = "", dely_ind_desc = "", q_compln_pregnancy_desc = "", q_compln_nr_pregnancy_desc = "", q_compln_dely_desc = "", q_proc_class_desc = "", q_vaginal_dely_type_desc = "", q_dely_surg_class_desc = "", q_nb_compln_dely_desc = "";
	boolean birth_order_format=false;
	String heart_rate_in_1_min="", heart_rate_in_5_min="", heart_rate_in_10_min="", breathing_in_1_min="", breathing_in_5_min="", breathing_in_10_min="", grimace_in_1_min="", grimace_in_5_min="", grimace_in_10_min="", activity_in_1_min="", activity_in_5_min="", activity_in_10_min="", appearance_in_1_min="", appearance_in_5_min="", appearance_in_10_min="";
	Boolean isModifyLongShortDescAppl = false;//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	java.sql.Statement stmt =null;
	ResultSet rs=null,rs1=null;
	    PreparedStatement newbornstmt	= null;
	    PreparedStatement pstmt1	= null;  //68508
		ResultSet newbornrs			    = null;
		String national_id="", other_alter_id ="";
		PreparedStatement newbornstmt1	= null;
		ResultSet newbornrs1 = null;
	String accession_no=""; //Ashwini Added for MO-CRF-20108
	String single_stage_appl_yn=""; //Ashwini Added for MO-CRF-20108
	String modify_delivery_type="";
	String facilityId       = (String) session.getValue("facility_id");
	String bl_install_yn	= (String) session.getValue("mp_bl_oper_yn");
    String function_id1			= checkForNull(request.getParameter("function_id"));
    String function_id			= checkForNull(request.getParameter("function_id_new"));
	String ca_encounter_id="", mother_patient_id="", ca_delivery_type="", ca_attend_pract_id="", ca_attend_pract_id_desc="", ca_attend_nurse_id="", ca_attend_nurse_id_desc="", ca_proc_classification="", ca_proc_classification_desc="", ca_del_surg_classification="", ca_del_surg_classification_desc="", ca_vaginal_delivery_type="", ca_vaginal_delivery_type_desc="", ca_no_of_births="", ca_comp_in_del_stage1="", ca_comp_in_del_stage2="", ca_comp_in_del_stage3="", ca_comp_of_delivery="", ca_comp_of_delivery_desc="", ca_foetus_comp_of_delivery="", ca_foetus_comp_of_delivery_desc="", captureAntenatalDtlsYN = "N", called_function = "";
	String new_function_id = function_id;
	String motherid	= checkForNull(request.getParameter("mother_id"));//mother Patient ID
	String siteId	= checkForNull(request.getParameter("siteId"));
    String motherencounterid		= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
    String invoked_from				= request.getParameter("invoked_from") == null ? "" : request.getParameter("invoked_from");
	String inhousebirthyn			= request.getParameter("inhouse_birth_yn") == null ? "" : request.getParameter("inhouse_birth_yn");
	String unitofwtnb = "",  unitofcircumnb = "",  unitofchestunit = "",  unitoflengthnb = "",  unitofgestnb	= "",      namesuffixmalenb	= "",  namesuffixfemalenb = "",      nb_use_mother_ser = "",  relation_mcode = "",  relation_mdesc = "";
	String page_colour				= request.getParameter("page_colour") == null ? "" : request.getParameter("page_colour");
	String called_from_mothercare	= request.getParameter("called_from_mothercare") == null ? "" : request.getParameter("called_from_mothercare");
	mother_patient_id				= request.getParameter("mother_patient_id") == null ? "" : request.getParameter("mother_patient_id");
	if(mother_patient_id==null || mother_patient_id.equals("null")){
		mother_patient_id="";
	}
	ca_encounter_id					= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id"); 	
 	String parent_details		=  "";
	String parent_details1 = "";	
	if (called_from_mothercare.equals("MC") && !ca_encounter_id.equals(""))
		motherencounterid = ca_encounter_id;
	String function_invoked		= request.getParameter("function_invoked") == null ? "" : request.getParameter("function_invoked");
	String module_invoked		= request.getParameter("module_invoked")==null?"":request.getParameter("module_invoked");
	String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");  
	String mother_nursing_unit	= request.getParameter("mother_nursing_unit") == null ? "" : request.getParameter("mother_nursing_unit");
	String outcome	= request.getParameter("outcome") == null ? "" : request.getParameter("outcome");	
	String disable_button_yn= request.getParameter("disable_button_yn") == null ? "N" : request.getParameter("disable_button_yn");
	String mother_pat_id=request.getParameter("mother_pat_id") == null ? "" : request.getParameter("mother_pat_id");
	String finalized_mult_birth_yn=request.getParameter("finalized_mult_birth_yn") == null ? "N" : request.getParameter("finalized_mult_birth_yn");//this CRF HSA-CRF-0182 Linked incident [54324]
	String disable_finalized_button_yn=request.getParameter("disable_finalized_button_yn") == null ? "" : request.getParameter("disable_finalized_button_yn");
	String resuscitated_pract_id=request.getParameter("resuscitated_pract_id") == null ? "" : request.getParameter("resuscitated_pract_id");
	String resuscitated_pract_desc=request.getParameter("resuscitated_pract_desc") == null ? "" : request.getParameter("resuscitated_pract_desc");
	String born_where=request.getParameter("born_where") == null ? "" : request.getParameter("born_where");
	String babyoutcome=request.getParameter("outcome") == null ? "" : request.getParameter("outcome");
	String newbornReg=request.getParameter("newbornReg") == null ? "N" : request.getParameter("newbornReg");
	String mother_bed_no		= request.getParameter("mother_bed_no") == null ? "" : request.getParameter("mother_bed_no");
    String function_name 	= request.getParameter( "function_name" ) ;
	if ( function_name	== null ) function_name	= "" ;
	String invoke_adm_from_newborn_yn		= request.getParameter("invoke_adm_from_newborn_yn") == null ? "N" : request.getParameter("invoke_adm_from_newborn_yn");
	String newTransactionYN		= request.getParameter("newTransactionYN") == null ? "Y" : request.getParameter("newTransactionYN");	
	String finalizeYN = request.getParameter("finalizeYN") == null ? "N" : request.getParameter("finalizeYN");
	
	if(function_id.equals("MAINTAIN_BIRTH")) {
		finalizeYN = "Y"; 		
	}
	if(calling_module_id.equals("IP")) { 
		called_function = "IP";
	} else if(calling_module_id.equals("AE")) { //Added by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
		called_function = "AE";
	} else {
		called_function = "MP";
	}
	if(called_function.equals("IP") || function_id.equals("MAINTAIN_BIRTH")) {
		captureAntenatalDtlsYN = "Y";
	}
	String regnStatus = request.getParameter("regnStatus") == null ? "" : request.getParameter("regnStatus"); 
	String current_date = "", desc = "", sel1 = "", sel2 = "";
    String gestDaysDisabled			= "disabled";   
	String ip_install_yn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
	String q_birth_order = "",  q_parity = "",  q_gravida = "",  q_remarks = "",  q_father_patient_id = "",  q_father_name  = "",  q_father_name_long  = "",  q_father_name_long_loc_lang  = "",    q_nb_patient_name = "",  q_father_national_id_no  = "",  q_father_oth_alt_id_type  = "",  q_FATHER_OTH_ALT_ID_NO  = "",  q_father_nationality_code = "",  q_father_nationality_desc = "",  q_race_code  = "",  q_father_religion_code  = "",  q_father_ocpn_class_code = "",  q_father_ocpn_desc = "",  q_father_remarks = "",  q_father_govemp = "",  fathr_ocpn_code = "",  q_race_desc  = "",  q_father_religion_desc = "",  min_weight = "",  max_weight = "",  min_chest_circum = "",  max_chest_circum = "",  min_head_circum = "",   max_head_circum = "",   min_length = "",  max_length = "",  min_gestation = "",  max_gestation = "",  nb_male_relnship = "",  nb_female_relnship = "",  nb_unknown_relnship = "",  father_alt_id1_no_value = "",  father_alt_id2_no_value = "",  father_alt_id3_no_value = "",  father_alt_id4_no_value = "",  pat_name_as_multipart_yn     = "",  accept_national_id_no_yn     = "",  accept_oth_alt_id_yn = "",  mp_param_sysdate = "",  mp_param_reqdate = "",  multidisabled = "",  multibirthvalue = "N",  gestdisabled = "",  gestdisabled1 = "",  multi_check = "",  FAMILY_ORG_ID_ACCEPT_YN = "",  FAMILY_NO_LINK_YN = "",  nat_data_source_id = "",  nat_id_check_digit_id = "",  nat_id_chk_len = "",  nat_invoke_routine = "",  entitlement_by_pat_cat_yn = "",   child_mandatory = "",  cat_mandatory = "",   q_apgar_score = "",       q_apgar_score_in_5_mins = "",  q_apgar_score_in_10_mins = "",  functname_sev = "",  dflt_nb_regn_blng_class = "",  fath_disable = "",  father_id_exists = "",  BDVallnew = "",  dofbirthvalue = "",  birth_date     = "",  birth_time     = "",  dofbirthdis = "",  antenatal_care_yn = "",  ant_care_locn_code = "",  ant_care_locn_type = "",  ant_care_gvn_at = "",  pat_blood_grp = "",  pat_rh_factor = "",  dis_all_flds = "",  call_function_id = "",  accept_names_for_live_birth_yn="",  heart_rate_in_1_min_1 ="",  heart_rate_in_1_min_2 ="",  heart_rate_in_1_min_3 ="",  heart_rate_in_1_min_4 ="",  heart_rate_in_5_min_1 ="",  heart_rate_in_5_min_2 ="",  heart_rate_in_5_min_3 ="",  heart_rate_in_5_min_4 ="",  heart_rate_in_10_min_1 ="",  heart_rate_in_10_min_2 ="",  heart_rate_in_10_min_3 ="",  heart_rate_in_10_min_4 ="",  breathing_in_1_min_1 ="",  breathing_in_1_min_2 ="",  breathing_in_1_min_3 ="",  breathing_in_1_min_4 ="",  breathing_in_5_min_1 ="",  breathing_in_5_min_2 ="",  breathing_in_5_min_3 ="",  breathing_in_5_min_4 ="",  breathing_in_10_min_1 ="",  breathing_in_10_min_2 ="",  breathing_in_10_min_3 ="",  breathing_in_10_min_4 ="",  grimace_in_1_min_1 ="",  grimace_in_1_min_2 ="",  grimace_in_1_min_3 ="",  grimace_in_1_min_4 ="",  grimace_in_5_min_1 ="",  grimace_in_5_min_2 ="",  grimace_in_5_min_3 ="",  grimace_in_5_min_4 ="",  grimace_in_10_min_1 ="",  grimace_in_10_min_2 ="",  grimace_in_10_min_3 ="",  grimace_in_10_min_4 ="",  activity_in_1_min_1 ="",  activity_in_1_min_2 ="",  activity_in_1_min_3 ="",  activity_in_1_min_4 ="",  activity_in_5_min_1 ="",  activity_in_5_min_2 ="",  activity_in_5_min_3 ="",  activity_in_5_min_4 ="",  activity_in_10_min_1 ="",  activity_in_10_min_2 ="",  activity_in_10_min_3 ="",  activity_in_10_min_4 ="",  appearance_in_1_min_1 ="",  appearance_in_1_min_2 ="",  appearance_in_1_min_3 ="",  appearance_in_1_min_4 ="",  appearance_in_5_min_1 ="",  appearance_in_5_min_2 ="",  appearance_in_5_min_3 ="",  appearance_in_5_min_4 ="",  appearance_in_10_min_1 ="",  appearance_in_10_min_2 ="",  appearance_in_10_min_3 ="",  appearance_in_10_min_4 ="",  lmp_ca ="",  no_of_days ="",  no_of_weeks="", q_parity1="";
	int nod=0;
	int mc_cycle_no=0;	
	String data_upd_allowed_aft_final_yn="", q_finalized_yn="", name_prefix_male_nb = "", name_prefix_female_nb = "", name_prefix_unknown_nb = "", name_suffix_male_nb = "", name_suffix_female_nb = "", name_pfx_loc_lang_male_nb = "", name_pfx_loc_lang_female_nb = "", name_pfx_loc_lang_unknown_nb = "", name_sfx_loc_lang_male_nb = "", name_sfx_loc_lang_female_nb = "", nb_mother_dtls_update_yn="N", dis_all_mother_dtls = "", ot_yn = "N", rd_yn = "N", family_org_sub_id = "", family_org_id = "", family_org_membership = "", family_link_no = "", mthr_alt_id1_no =  "", mthr_alt_id2_no =  "", mthr_alt_id3_no =  "", mthr_alt_id4_no =  "", mthr_nat_id_no  = "", mthr_oth_alt_id_No = " ", still_born_prefix=""; // Modified by Afruddin for ML-MMOH-CRF-1520 US0002
	int patient_idlength	= 0;
	int diffHours			= 0;
	int q_no_of_birth		= 0;
	int flag				= 0;
	int new_registration	= 0;
	String field_name = "",emer_regn_nb = "N",ip_regn_nb_yn = "N",mp_regn_nb_yn = "N",ant_care_given_at = "",length_of_baby_yn = "",lengthofbaby = "visibility:hidden",head_circumference_of_baby_yn = "",headcircumference = "visibility:hidden" ,lengthValue = "" ,headValue="",mandate_first_newborn_yn = "",mandate_second_newborn_yn = "",mandate_third_newborn_yn = "",mand_antenatal_newborn_yn = "",mandate_first_newborn_ae_yn = "",mandate_second_newborn_ae_yn = "",mandate_third_newborn_ae_yn = "",mand_antenatal_newborn_ae_yn = "",mandate_first_newborn_ip_yn = "",mandate_second_newborn_ip_yn = "",mandate_third_newborn_ip_yn = "", mand_antenatal_newborn_ip_yn = "",mandatefirstnewbornValue = "visibility:hidden",mandate_secondnewbornValue = "visibility:hidden", mandate_third_newbornValue = "visibility:hidden",mand_antenatal_newbornValue = "visibility:hidden",antvalue = "" , maintainbirthvalue = "" ,dflt_father_first_name_prompt = "", dflt_father_Second_name_prompt = "" , dflt_father_third_name_prompt = "" , dflt_father_family_name_prompt = "",no_marital_status="",enable_marital_status="",hij_appl_YN="N";
	double min_gest_bet_del = 0;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
    java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String sec = String.valueOf(dt.getMinutes());
	if ((sec).length()==1) sec="0"+sec; else sec = sec;
	d=d + " "+String.valueOf(dt.getHours())+":"+sec;
	String tm =String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
    String 	page_show =  request.getParameter("page_show") == null ? "M" : request.getParameter("page_show");
    String enable_gestn_field = "", displayLabel="", invoke_menstrual_history ="", rec_view_lmp_details_label = "", rec_lmp_dtl_mand="none",invoke_mens_hist_mand = "N",gestn_day_from_lmp="", gestn_week_from_lmp="";// Added by Jeyachitra ML-MMOH-CRF-1759.1
    boolean ca_mens_trans_dtl_avail=false; // Added by Jeyachitra ML-MMOH-CRF-1759.1
    PreparedStatement pstmt = null; // Added by Jeyachitra ML-MMOH-CRF-1759.1
   
	try	{
		con = ConnectionManager.getConnection(request);	
		birth_order_format=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_ORDER");//Mahesh   HSA-CRF-0304 [IN:054703]
	   Boolean isMPMandatoryFieldsNewborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_MANDATORY_FIELDS_NEWBORN");
	   Boolean mpDisableFieldsNBFather = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_DISABLE_FIELDS_NB_FATHER");
	   if(called_function.equals("IP") || function_id.equals("MAINTAIN_BIRTH") || !isMPMandatoryFieldsNewborn) {
		captureAntenatalDtlsYN = "Y";
	}
       Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");
	   Boolean isAllow_External_Newborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALLOW_EXTERNAL_NEWBORN");
	   Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
	   Boolean isNeonatalApplicable = CommonBean.isSiteSpecific(con, "MP","NEONATAL_RESUSCITATION");//Added by Ashwini on 24-oct-2016 for MO-CRF-20108
	   Boolean isNewBornChngsAppl = CommonBean.isSiteSpecific(con, "IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
	   Boolean isMotherAliveAppl = CommonBean.isSiteSpecific(con, "MP","MOTHER_ALIVE_APPL");//Added by Mujafar against ML-MMOH-CRF-1476  
	   Boolean newborn_birth_order=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_BIRTH_ORDER");
	   Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	   Boolean newbornBornAt = CommonBean.isSiteSpecific(con, "MP","NEWBORN_BORN_AT");
	   isModifyLongShortDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	   Boolean isNameDervnLogicNBAppl = CommonBean.isSiteSpecific(con,"MP","NEWBORN_NAME_DERV_LOGIC");//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	    
	 //68508 added by Twinkle 
		    String invokeMenstrualHistYN=""; 
			String mandParityNewBornYN="";
			String mandParityNewBornAE_YN="";
			String mandParityNewBornIP_YN="";
		    pstmt1 = con.prepareStatement("SELECT INVOKE_MENSTRUAL_HISTORY_YN, MAND_PARITY_NEWBORN_YN, MAND_PARITY_NEWBORN_AE_YN,MAND_PARITY_NEWBORN_IP_YN FROM MP_PARAM");
		    rs1 = pstmt1.executeQuery();
		    if (rs1.next()){
		    	invokeMenstrualHistYN = rs1.getString("INVOKE_MENSTRUAL_HISTORY_YN");
		    	mandParityNewBornYN = rs1.getString("MAND_PARITY_NEWBORN_YN");
		    	mandParityNewBornAE_YN = rs1.getString("MAND_PARITY_NEWBORN_AE_YN");
		    	mandParityNewBornIP_YN = rs1.getString("MAND_PARITY_NEWBORN_IP_YN");	
		    }
		    if(pstmt1!=null) pstmt1.close();
		    if(rs1!=null) rs1.close();	
	  //68508 added by Twinkle 	   
			      
       int inc = 3, incArr = 2;
	   String sel_yn = "";
	   
	   JSONObject OTRDInstalledYNJson = new JSONObject();
	   OTRDInstalledYNJson		=	eMP.MPCommonBean.getOTRDInstalledYN(con);
	   ot_yn					=	(String)OTRDInstalledYNJson.get("ot_yn");
	   rd_yn					=	(String)OTRDInstalledYNJson.get("rd_yn");
	String maxsize="30", maximumLength="30"; 	
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		
	//Santhosh added for ML-MMOH-CRF-1895
     Boolean isApgarScoreMinsAppl = CommonBean.isSiteSpecific(con, "MP","APGAR_SCORE_IN_MINS_MANDATORY");
	
	
	if(increasedaddressLength){	  
	  maximumLength="50";	
	  maxsize="64";
	}
	   String headcircum_lengofBaby="visibility:hidden"; 
	   if(isRegNewbornApplicable){  
	      headcircum_lengofBaby="visibility:visible"; 
	   }
	if(isRegNewbornApplicable && !resuscitated_pract_id.equals("")){
    StringBuffer natstrBuffer=new StringBuffer("select practitioner_name from am_practitioner where practitioner_id ='");	
	natstrBuffer.append(resuscitated_pract_id).append("'");
	newbornstmt1 = con.prepareStatement(natstrBuffer.toString());
	newbornrs1 = newbornstmt1.executeQuery();
	if(newbornrs1!=null && newbornrs1.next()){
	resuscitated_pract_desc=newbornrs1.getString("practitioner_name")==null?"":newbornrs1.getString("practitioner_name");		 
	}
	if(newbornrs1 != null) newbornrs1.close();
	if(newbornstmt1 != null) newbornstmt1.close();
	}
       if(hijirisitespecifApplicable)  hij_appl_YN="Y";
		mPParamDtls = eMP.NewbornDetails.getMPParamDtls(con,p);
		newborn_pat_ser_grp		= checkForNull((String) mPParamDtls.get("newborn_pat_ser_grp"));
		String allow_ext_nb_regn_within_days		= checkForNull((String) mPParamDtls.get("allow_ext_nb_regn_within_days"));
		nb_dflt_relnship_code		= checkForNull((String) mPParamDtls.get("nb_dflt_relnship_code"));
		String dflt_race_nat_setup = checkForNull((String) mPParamDtls.get("dflt_race_nat_setup_nb_as_per"));	
		String citizen_nationality_code	= checkForNull((String) mPParamDtls.get("citizen_nationality_code"));	
		String default_race_code = checkForNull((String) mPParamDtls.get("default_race_code"));	
		String nb_father_min_age		= checkForNull((String) mPParamDtls.get("nb_father_min_age"));
		String generate_file		= checkForNull((String) mPParamDtls.get("create_file_at_pat_regn_yn"),"N");
		String Name_Prefix_Accept_Yn		= checkForNull((String) mPParamDtls.get("name_prefix_accept_yn"));
		String Name_Prefix_Reqd_Yn		= checkForNull((String) mPParamDtls.get("name_prefix_reqd_yn"));
		String Name_Suffix_Accept_Yn		= checkForNull((String) mPParamDtls.get("name_suffix_accept_yn"));
		String Name_Suffix_Reqd_Yn		= checkForNull((String) mPParamDtls.get("name_suffix_reqd_yn"));
		String First_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("first_name_accept_yn"));
		String First_Name_Prompt		= checkForNull((String) mPParamDtls.get("first_name_prompt"));
		String First_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("first_name_reqd_yn"));
		String Second_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("second_name_accept_yn"));
		String Second_Name_Prompt		= checkForNull((String) mPParamDtls.get("second_name_prompt"));
		String Third_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("third_name_accept_yn"));
		String Third_Name_Prompt		= checkForNull((String) mPParamDtls.get("third_name_prompt"));
		String Family_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("family_name_accept_yn"));
		String Family_Name_Prompt		= checkForNull((String) mPParamDtls.get("family_name_prompt"));
		String Second_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("second_name_reqd_yn"));
		String Third_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("third_name_reqd_yn"));
		String Family_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("family_name_reqd_yn"));
		String Name_Suffix_Prompt		= checkForNull((String) mPParamDtls.get("name_suffix_prompt"));
		String Name_Prefix_Prompt		= checkForNull((String) mPParamDtls.get("name_prefix_prompt"));
		String Family_Name_Order		= checkForNull((String) mPParamDtls.get("family_name_order"));
		String First_Name_Order			= checkForNull((String) mPParamDtls.get("first_name_order"));
		String Second_Name_Order		= checkForNull((String) mPParamDtls.get("second_name_order"));
		String Third_Name_Order			= checkForNull((String) mPParamDtls.get("third_name_order"));
		String first_name_length		= checkForNull((String) mPParamDtls.get("first_name_length"),"0");
		String second_name_length		= checkForNull((String) mPParamDtls.get("second_name_length"),"0");
		String third_name_length		= checkForNull((String) mPParamDtls.get("third_name_length"),"0");
		String family_name_length		= checkForNull((String) mPParamDtls.get("family_name_length"),"0");
		String family_name_loc_lang_prompt = checkForNull((String)mPParamDtls.get("family_name_loc_lang_prompt"));
		String name_suffix_loc_lang_prompt = checkForNull((String)mPParamDtls.get("name_suffix_loc_lang_prompt"));
		String first_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("first_name_loc_lang_prompt"));
		String second_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("second_name_loc_lang_prompt"));
		String third_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("third_name_loc_lang_prompt"));
		String name_prefix_loc_lang_prompt =checkForNull((String)mPParamDtls.get("name_prefix_loc_lang_prompt"));
		String names_in_oth_lang_yn = checkForNull((String)mPParamDtls.get("names_in_oth_lang_yn"),"N"); 
		cd1    = checkForNull((String) mPParamDtls.get("allow_nb_regn_unit"),"H");
		cd2    = checkForNull((String) mPParamDtls.get("allow_nb_regn_within_days"),"0");
		cd3	   = checkForNull((String) mPParamDtls.get("nat_id_prompt"), "National ID No"); //Modified for this CRF ML-MMOH-CRF-0621 
		cd4	   = checkForNull((String) mPParamDtls.get("nat_id_length"),"20");	
		nb_father_name_mandatory_yn	   = checkForNull(((String) mPParamDtls.get("nb_father_name_mandatory_yn")),"N");			
		unitofwtnb = checkForNull(((String) mPParamDtls.get("unit_of_wt_nb")),"");
        unitofcircumnb = checkForNull(((String) mPParamDtls.get("unit_of_circum_nb")),"");
		unitofchestunit = checkForNull(((String) mPParamDtls.get("unit_of_chest_circum_nb")),"");
		unitoflengthnb = checkForNull(((String) mPParamDtls.get("unit_of_length_nb")),"");
		unitofgestnb	= checkForNull(((String) mPParamDtls.get("unit_of_gest_nb")),"");  
		namesuffixmalenb	= checkForNull(((String) mPParamDtls.get("name_suffix_male_nb")),"");
		namesuffixfemalenb = checkForNull(((String) mPParamDtls.get("name_suffix_female_nb")),"");    
		nb_use_mother_ser = checkForNull(((String) mPParamDtls.get("nb_use_mother_ser")),"");
		accept_names_for_live_birth_yn = checkForNull(((String) mPParamDtls.get("accept_names_for_live_birth_yn")),"N");
		still_born_prefix = checkForNull(((String) mPParamDtls.get("still_born_prefix")),"");
		accept_oth_alt_id_yn		= checkForNull((String)mPParamDtls.get("accept_oth_alt_id_yn"),"N");
		accept_national_id_no_yn		= checkForNull((String)mPParamDtls.get("accept_national_id_no_yn"),"N");
		patient_idlength			= Integer.parseInt(checkForNull( (String)mPParamDtls.get("patient_id_length"),"0"));
		alt_id1_type				= checkForNull((String)mPParamDtls.get("alt_id1_type"));
		alt_id1_length				= checkForNull((String)mPParamDtls.get("alt_id1_length"));
		alt_id2_length				= checkForNull((String)mPParamDtls.get("alt_id2_length"));
		alt_id3_length				= checkForNull((String)mPParamDtls.get("alt_id3_length"));
		alt_id4_length				= checkForNull((String)mPParamDtls.get("alt_id4_length"));
		alt_id1_type_desc			= checkForNull((String)mPParamDtls.get("alt_id1_type_desc"));
		alt_id2_type_desc			= checkForNull((String)mPParamDtls.get("alt_id2_type_desc"));
		alt_id3_type_desc			= checkForNull((String)mPParamDtls.get("alt_id3_type_desc"));
		alt_id4_type_desc			= checkForNull((String)mPParamDtls.get("alt_id4_type_desc"));
		alt_id1_len_validation_yn	= checkForNull((String)mPParamDtls.get("alt_id1_len_validation_yn"));
		alt_id1_routine_yn			= checkForNull((String)mPParamDtls.get("alt_id1_routine_yn"));
		alt_id1_data_source_id		= checkForNull((String)mPParamDtls.get("alt_id1_data_source_id"));
		alt_id1_chk_digit_scheme	= checkForNull((String)mPParamDtls.get("alt_id1_chk_digit_scheme"));
		alt_id1_accept_alphanumeric_yn	= 
		checkForNull((String)mPParamDtls.get("alt_id1_accept_alphanumeric_yn"));
	   motherid	= eMP.NewbornDetails.getMutipleBirthPatientId(motherid, con, p,mother_pat_id,finalized_mult_birth_yn); //Below line added for this CRF HSA-CRF-0182 linked incident [54168]
 	   hashMap	= eMP.NewbornDetails.getNewbornData(motherid, con, p);//this line added for this incident [54168]

		cong_anom_desc = checkForNull((String )hashMap.get("cong_anomalies_long_desc"));
		dely_ind_desc = checkForNull((String )hashMap.get("dely_ind_long_desc"));
		q_compln_pregnancy_desc = checkForNull((String)hashMap.get("compln_pregnancy_long_desc"));
		q_compln_nr_pregnancy_desc = checkForNull((String)hashMap.get("compln_nr_pregnancy_long_desc"));
		q_compln_dely_desc = checkForNull((String)hashMap.get("compln_dely_long_desc"));
		q_proc_class_desc = checkForNull((String)hashMap.get("proc_class_long_desc"));
		q_vaginal_dely_type_desc = checkForNull((String) hashMap.get("vaginal_del_type_long_desc"));
		q_dely_surg_class_desc = checkForNull((String) hashMap.get("dely_surg_class_long_desc"));
		q_nb_compln_dely_desc = checkForNull((String )hashMap.get("nb_compln_del_long_desc"));

	   emer_regn_nb_yn = checkForNull((String)hashMap.get("emer_regn_nb_yn"));
		if(mother_patient_id.equals("")){
			mother_patient_id=checkForNull((String)hashMap.get("q_mother_patient_id"));
		}
		mthrDtls = eMP.NewbornDetails.getMotherData(con, p, mother_patient_id); 
		if(hashMap.isEmpty()) {
			 relation_mcode = checkForNull((String)mthrDtls.get("relation_code"));
			 relation_mdesc = checkForNull((String)mthrDtls.get("relation_desc"));	
			 family_org_sub_id = checkForNull((String)mthrDtls.get("mthr_family_org_sub_id"));			
			 family_org_id = checkForNull((String)mthrDtls.get("mthr_family_org_id"));			
			 family_org_membership = checkForNull((String)mthrDtls.get("mthr_family_org_membership"));			
			 family_link_no = checkForNull((String)mthrDtls.get("mthr_family_link_no"));			
		} else {
			 relation_mcode = checkForNull((String)hashMap.get("relation_code"));
			 relation_mdesc = checkForNull((String)hashMap.get("relation_desc"));
			 family_org_sub_id = checkForNull((String)hashMap.get("family_org_sub_id"));			
			 family_org_id = checkForNull((String)hashMap.get("family_org_id"));			
			 family_org_membership = checkForNull((String)hashMap.get("family_org_membership"));			
			 family_link_no = checkForNull((String)hashMap.get("family_link_no"));			
			} 		
		//Added by Jeyachitra for ML-MMOH-CRF-1759.1
		String patient_gender = checkForNull((String)mthrDtls.get("patient_gender"));
		String patient_age =checkForNull((String)mthrDtls.get("patient_age"));
		mthr_alt_id1_no = checkForNull((String)mthrDtls.get("mthr_alt_id1_no"));
		mthr_alt_id2_no = checkForNull((String)mthrDtls.get("mthr_alt_id2_no"));
		mthr_alt_id3_no = checkForNull((String)mthrDtls.get("mthr_alt_id3_no"));
		mthr_alt_id4_no = checkForNull((String)mthrDtls.get("mthr_alt_id4_no"));
		mthr_nat_id_no  =checkForNull((String)mthrDtls.get("mthr_nat_id_no"));
		mthr_oth_alt_id_No  =checkForNull((String)mthrDtls.get("mthr_oth_alt_id_No"));
		oth_alt_id_type	=checkForNull((String)mthrDtls.get("oth_alt_id_type"));
		mthr_oth_alt_id_type	=checkForNull((String)mthrDtls.get("mthr_oth_alt_id_type"));
		String dft_vlaues_from_mc=(String)session.getValue("dft_vlaues_from_mc");		
		Integer ca_cycle=(Integer)session.getValue("mc_cycle_number");
		if(ca_cycle!=null){
			mc_cycle_no=ca_cycle.intValue();
		}else if(hashMap.get("q_mc_cycle_no")!=null){
			mc_cycle_no=Integer.parseInt((String)hashMap.get("q_mc_cycle_no"));
		}
		if((dft_vlaues_from_mc!=null && dft_vlaues_from_mc.equals("Y")) || (called_from_mothercare.equals("MC"))){
			String motherdataSQl="select DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION,DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH,COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3,COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY,mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,'"+localeName+"',2)VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,'"+localeName+"',2) PROC_CLASSIFICATION_DESC,	   mp_get_desc.MP_COMPLN_DELIVERY(comp_of_delivery,'"+localeName+"',2) COMP_OF_DELIVERY_DESC,mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,'"+localeName+"',2) DEL_SURG_CLASSIFICATION_DESC,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,'"+localeName+"',1)ATTEND_PRACT_ID_DESC,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,'"+localeName+"',1)ATTEND_NURSE_ID_DESC,mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,'"+localeName+"',2) FOETUS_COMP_OF_DELIVERY_DESC,cycle_no,to_char(LMP,'dd/mm/yyyy') LMP,(trunc(sysdate)-trunc(lmp)) no_of_days, mp_get_desc.MP_COMPLN_DELIVERY(comp_of_delivery,'"+localeName+"',1) COMP_OF_DELIVERY_LONG_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,'"+localeName+"',1) FOETUS_COMP_OF_DEL_LONG_DESC, mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,'"+localeName+"',1) PROC_CLASS_LONG_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,'"+localeName+"',1) VAGINAL_DELTYPE_LONG_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,'"+localeName+"',1) DEL_SURG_CLASS_LONG_DESC from CA_SPL_DELIVERY_RECORD where facility_id='"+facilityId+"' and mother_patient_id='"+mother_patient_id+"' and CYCLE_NO=(select max(CYCLE_NO) from CA_PAT_SPLTY_EPISODE_EVENT where patient_id='"+mother_patient_id+"' and SPLTY_EVENT_CODE IN ('MCE004','MCE008','MCE009' ) AND SPLTY_EVENT_STATUS='O')";			
				session.removeValue("mc_cycle_number");
				stmt = con.createStatement();		
				rs=stmt.executeQuery(motherdataSQl);
				if(rs!=null && rs.next()){
					ca_no_of_births=rs.getString("NO_OF_BIRTH")==null?"":rs.getString("NO_OF_BIRTH");
					ca_delivery_type=rs.getString("DELIVERY_TYPE")==null?"":rs.getString("DELIVERY_TYPE");
					ca_attend_pract_id=rs.getString("ATTEND_PRACT_ID")==null?"":rs.getString("ATTEND_PRACT_ID");
					ca_attend_pract_id_desc=rs.getString("ATTEND_PRACT_ID_DESC")==null?"":rs.getString("ATTEND_PRACT_ID_DESC");
					ca_attend_nurse_id=rs.getString("ATTEND_NURSE_ID")==null?"":rs.getString("ATTEND_NURSE_ID");
					ca_attend_nurse_id_desc=rs.getString("ATTEND_NURSE_ID_DESC")==null?"":rs.getString("ATTEND_NURSE_ID_DESC");
					ca_proc_classification=rs.getString("PROC_CLASSIFICATION")==null?"":rs.getString("PROC_CLASSIFICATION");
					ca_del_surg_classification=rs.getString("DEL_SURG_CLASSIFICATION")==null?"":rs.getString("DEL_SURG_CLASSIFICATION");
					ca_vaginal_delivery_type=rs.getString("VAGINAL_DELIVERY_TYPE")==null?"":rs.getString("VAGINAL_DELIVERY_TYPE");
					ca_comp_in_del_stage1=rs.getString("COMP_IN_DEL_STAGE1")==null?"":rs.getString("COMP_IN_DEL_STAGE1");
					ca_comp_in_del_stage2=rs.getString("COMP_IN_DEL_STAGE2")==null?"":rs.getString("COMP_IN_DEL_STAGE2");
					ca_comp_in_del_stage3=rs.getString("COMP_IN_DEL_STAGE3")==null?"":rs.getString("COMP_IN_DEL_STAGE3");
					ca_comp_of_delivery=rs.getString("COMP_OF_DELIVERY")==null?"":rs.getString("COMP_OF_DELIVERY");
					ca_foetus_comp_of_delivery=rs.getString("FOETUS_COMP_OF_DELIVERY")==null?"":rs.getString("FOETUS_COMP_OF_DELIVERY");
					ca_proc_classification_desc=rs.getString("PROC_CLASS_LONG_DESC")==null?"":rs.getString("PROC_CLASS_LONG_DESC");
					ca_del_surg_classification_desc=rs.getString("DEL_SURG_CLASS_LONG_DESC")==null?"":rs.getString("DEL_SURG_CLASS_LONG_DESC");
					ca_vaginal_delivery_type_desc=rs.getString("VAGINAL_DELTYPE_LONG_DESC")==null?"":rs.getString("VAGINAL_DELTYPE_LONG_DESC");
					ca_comp_of_delivery_desc=rs.getString("COMP_OF_DELIVERY_LONG_DESC")==null?"":rs.getString("COMP_OF_DELIVERY_LONG_DESC");
					ca_foetus_comp_of_delivery_desc=rs.getString("FOETUS_COMP_OF_DEL_LONG_DESC")==null?"":rs.getString("FOETUS_COMP_OF_DEL_LONG_DESC");
					
					
					mc_cycle_no=rs.getInt("cycle_no");
					lmp_ca=rs.getString("LMP")==null?"":rs.getString("LMP");
					no_of_days=rs.getString("no_of_days")==null?"0":rs.getString("no_of_days");
					if(unitofgestnb.equals("W")){
						StringTokenizer str=new StringTokenizer(no_of_days,".");
						nod=Integer.parseInt(str.nextToken());
						if(nod > 6){
							no_of_weeks=(new Integer(nod/7)).toString();							 					
							nod=nod%7;							
						}else{							
							no_of_weeks = "0"; //Added the code for SRR20056-SCF-6095 [IN:025248] by Suresh M on 26.11.2010						
						}
					}
					MC_Dtls_YN="Y";
				}}
		String q_delivery_indicator= checkForNull((String) hashMap.get("q_delivery_indicator"));					
		String dis_com_stages ="", dis_com_delivery ="";
    	if(function_id.equals("MAINTAIN_BIRTH") && called_function.equals("MP"))  {
			if(q_delivery_indicator.equals("C")) {
				dis_com_stages ="disabled";
			} else if(q_delivery_indicator.equals("N")) {
				dis_com_delivery ="disabled";
			} else {
				dis_com_stages ="";
				dis_com_delivery ="";
			}
		}
		if(invoked_from.equals("details_page")){
			if(regnStatus.equals("R") && finalizeYN.equals("Y")) {
				dis_all_flds = "";				
			} else if(regnStatus.equals("F")) {
				dis_all_flds = "disabled";				
			}
			function_id = "MAINTAIN_BIRTH";
			new_function_id = "MAINTAIN_BIRTH";
		} else if (invoked_from.equals("servlet")) {
			if(function_id.equals("REGISTER_NEWBORN")) {
				dis_all_flds = "disabled";
			} else if(function_id.equals("MAINTAIN_BIRTH")) {
				dis_all_flds = "";
			} 
			function_id = "MAINTAIN_BIRTH";
		} else {
			function_id = new_function_id;	
		}
		call_function_id = function_id;
		if(!function_id.equals("REGISTER_NEWBORN") && !invoked_from.equals("servlet") && motherencounterid.equals("")) {
			 motherencounterid = checkForNull((String)hashMap.get("q_mother_encounter_id"));
		} 
		if(new_function_id.equals("REGISTER_NEWBORN"))		
			functname_sev="insert";		
		else
			functname_sev="Query";		
		if( !function_id.equals("REGISTER_NEWBORN")){
			hashMap10 = eMP.NewbornDetails.getIPOpenEncounter(facilityId,motherencounterid,con,p); 
			mother_nursing_unit=checkForNull((String)hashMap10.get("mother_nursing_unit_code")) ;
			mother_bed_no=checkForNull((String)hashMap10.get("mother_bed_no"));
			pseudo_bed_yn=checkForNull((String)hashMap10.get("pseudo_bed_yn"),"N");
			pat_blood_grp = checkForNull((String)hashMap.get("blood_grp"));
			pat_rh_factor = checkForNull((String)hashMap.get("rh_factor"));
		}
		stmt = con.createStatement();
		rs = stmt.executeQuery("select single_stage_nb_reg_appl_yn,mod_birth_reg_appl_yn,INVOKE_MENSTRUAL_HISTORY_YN from mp_param");//// Added by Jeyachitra ML-MMOH-CRF-1759.1
		
		if(rs!=null && rs.next()){
			single_stage_appl_yn=rs.getString("single_stage_nb_reg_appl_yn")==null?"N":rs.getString("single_stage_nb_reg_appl_yn");
			modify_delivery_type=rs.getString("mod_birth_reg_appl_yn")==null?"N":rs.getString("mod_birth_reg_appl_yn");
			invoke_menstrual_history = rs.getString("INVOKE_MENSTRUAL_HISTORY_YN") == null?"N":rs.getString("INVOKE_MENSTRUAL_HISTORY_YN");//// Added by Jeyachitra ML-MMOH-CRF-1759.1
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		//Added by Kamatchi S for ML-MMOH-CRF-2095
	   lengthValue = checkForNull((String) hashMap.get("q_length"));
	   headValue = checkForNull((String) hashMap.get("q_circumference"));
	   JSONObject getLengthHeadValueYN = new JSONObject();
	   getLengthHeadValueYN		=	eMP.MPCommonBean.getLengthHeadValueYN(con);
	   length_of_baby_yn					=	checkForNull((String)getLengthHeadValueYN.get("length_of_baby_yn"));
	   head_circumference_of_baby_yn = checkForNull((String)getLengthHeadValueYN.get("head_circumference_of_baby_yn"));
	   dflt_father_first_name_prompt = checkForNull((String)getLengthHeadValueYN.get("dflt_father_first_name_prompt"));
	   dflt_father_Second_name_prompt =	checkForNull((String)getLengthHeadValueYN.get("dflt_father_Second_name_prompt"));
	   dflt_father_third_name_prompt = checkForNull((String)getLengthHeadValueYN.get("dflt_father_third_name_prompt"));
	   dflt_father_family_name_prompt =	checkForNull((String)getLengthHeadValueYN.get("dflt_father_family_name_prompt"));
	   enable_marital_status =	checkForNull((String)getLengthHeadValueYN.get("enable_marital_status"));
	   if(length_of_baby_yn.equals("Y") || length_of_baby_yn == "Y"){  lengthofbaby="visibility:visible"; }
	   if(head_circumference_of_baby_yn.equals("Y") || head_circumference_of_baby_yn == "Y"){  headcircumference="visibility:visible"; }
	   JSONObject getComplicationValue = new JSONObject();
	   getComplicationValue		=	eMP.MPCommonBean.getComplicationValue(con,motherid);
	   emer_regn_nb					=	checkForNull((String)getComplicationValue.get("emer_regn_nb_yn"));
	   ip_regn_nb_yn					= checkForNull((String)getComplicationValue.get("ip_regn_nb_yn"));
	   mp_regn_nb_yn					=	checkForNull((String)getComplicationValue.get("mp_regn_nb_yn"));
	   ant_care_given_at					=	checkForNull((String)getComplicationValue.get("ant_care_gvn_at"));
	   no_marital_status					=	checkForNull((String)getComplicationValue.get("no_marital_status"));
	   if(function_id.equals("REGISTER_NEWBORN") ) { antvalue = ""; }
	   if(function_id.equals("MAINTAIN_BIRTH")) { antvalue = ant_care_given_at; } 
	   //Added by Kamatchi S for ML-MMMOH-CRF-1757
	   mandate_first_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_yn");
	   mandate_first_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_ae_yn");
	   mandate_second_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_yn");
	   mandate_second_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_ae_yn");
	   mandate_third_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_yn");
	   mandate_third_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_ae_yn");
	   mand_antenatal_newborn_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_yn");
	   mand_antenatal_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_ae_yn");
	   mandate_first_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_ip_yn");
	   mandate_second_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_ip_yn");
	   mandate_third_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_ip_yn");
	   mand_antenatal_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_ip_yn");
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_first_newborn_yn.equals("Y") || mandate_first_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mandatefirstnewbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_second_newborn_yn.equals("Y") || mandate_second_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mandate_secondnewbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_third_newborn_yn.equals("Y") || mandate_third_newborn_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") )){  mandate_third_newbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mand_antenatal_newborn_yn.equals("Y") || mand_antenatal_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mand_antenatal_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_first_newborn_ae_yn.equals("Y") || mandate_first_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandatefirstnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_second_newborn_ae_yn.equals("Y") || mandate_second_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandate_secondnewbornValue="visibility:visible";  }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_third_newborn_ae_yn.equals("Y") || mandate_third_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandate_third_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mand_antenatal_newborn_ae_yn.equals("Y") || mand_antenatal_newborn_ae_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") )  ) { mand_antenatal_newbornValue ="visibility:visible";}
	    if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_first_newborn_ip_yn.equals("Y") || mandate_first_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mandatefirstnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_second_newborn_ip_yn.equals("Y") || mandate_second_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") )  ){  mandate_secondnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_third_newborn_ip_yn.equals("Y") || mandate_third_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mandate_third_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mand_antenatal_newborn_ip_yn.equals("Y") || mand_antenatal_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mand_antenatal_newbornValue ="visibility:visible"; }
		race_required_yn = checkForNull((String)mPParamDtls.get("race_required_yn"));	
		mp_param_reqdate				= checkForNull((String)mPParamDtls.get("sysdays_reg"));
		FAMILY_ORG_ID_ACCEPT_YN			= checkForNull((String)mPParamDtls.get("family_org_id_accept_yn"));
		FAMILY_NO_LINK_YN				= checkForNull((String)mPParamDtls.get("family_no_link_yn"));
		entitlement_by_pat_cat_yn		= checkForNull((String)mPParamDtls.get("entitlement_by_pat_cat_yn"));
		mp_param_sysdate				= checkForNull((String)mPParamDtls.get("sysdatesys"));
		current_date					= checkForNull((String)mPParamDtls.get("curr_date"));
		nat_invoke_routine				= checkForNull((String)mPParamDtls.get("invoke_routine"));
		nat_data_source_id				= checkForNull((String)mPParamDtls.get("nat_data_source_id"));
		nat_id_check_digit_id			= checkForNull((String)mPParamDtls.get("nat_id_check_digit_id"));
		nat_id_chk_len					= checkForNull((String)mPParamDtls.get("nat_id_chk_len"));
		single_stage_nb_reg_appl_yn		= checkForNull((String)mPParamDtls.get("single_stage_nb_reg_appl_yn"));	 
		data_upd_allowed_aft_final_yn	= checkForNull((String)mPParamDtls.get("data_upd_allowed_aft_final_yn")); 
		name_prefix_male_nb	= checkForNull((String)mPParamDtls.get("name_prefix_male_nb"));	 
		name_prefix_female_nb = checkForNull((String)mPParamDtls.get("name_prefix_female_nb"));	 
	    name_prefix_unknown_nb = checkForNull((String)mPParamDtls.get("name_prefix_unknown_nb"));	//Added by Afruddin for ML-MMOH-CRF-1520 US 0002
		name_suffix_male_nb	= checkForNull((String)mPParamDtls.get("name_suffix_male_nb"));	 
		name_suffix_female_nb = checkForNull((String)mPParamDtls.get("name_suffix_female_nb"));
		name_pfx_loc_lang_male_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_male_nb"));		
		name_pfx_loc_lang_female_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_female_nb"));	
		name_pfx_loc_lang_unknown_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_unknown_nb")); //Added by Afruddin for ML-MMOH-CRF-1520 US 0002
		name_sfx_loc_lang_male_nb	= checkForNull((String)mPParamDtls.get("name_sfx_loc_lang_male_nb"));		
		name_sfx_loc_lang_female_nb	= checkForNull((String)mPParamDtls.get("name_sfx_loc_lang_female_nb"));	
        nb_mother_dtls_update_yn= checkForNull((String)mPParamDtls.get("nb_mother_dtls_update_yn")); 
		if(nb_mother_dtls_update_yn.equals("Y") && disable_button_yn.equals("N")){
		  dis_all_mother_dtls="";	
		}else{
		    dis_all_mother_dtls=dis_all_flds;	
		 }
		if(!(checkForNull((String) hashMap.get("q_father_patient_id"))).equals("")) 
		{ fath_disable = ""; father_id_exists = "1"; }
		if(!cd2.equals("")){
          getAllowNewBornDate=mp_param_reqdate;
		}
		else
           getAllowNewBornDate="";
		if(bl_install_yn.equals("Y")){
			dflt_nb_regn_blng_class = checkForNull((String)mPParamDtls.get("dflt_nb_regn_blng_class"));
		}
		diffHours = Integer.parseInt(checkForNull((String) mthrDtls.get("diffHours"),"0"));
		double temp_var = (double)diffHours/(24*7);							
		long diffWeeks = Math.round(temp_var);
		min_gest_bet_del = Double.parseDouble(checkForNull((String)mPParamDtls.get("nb_min_gest_bet_2_dely"),"0"));
		if(diffWeeks > min_gest_bet_del) {
			new_registration = 1;
		}
		if(new_registration == 0) {
			hashMap3 = eMP.NewbornDetails.getMPBirthRegisterData((String) hashMap.get("q_mother_patient_id"), "mp_birth_register1", con,p);
			q_no_of_birth					= Integer.parseInt(checkForNull((String)hashMap3.get("q_no_of_birth"),"0"));
			q_gestational_period			= checkForNull((String) hashMap3.get("q_gestational_period"));
			q_gestational_period_days		= checkForNull((String) hashMap3.get("q_gestational_period_days"));
			q_birth_order					= checkForNull((String) hashMap3.get("q_birth_order"));		  
			q_parity						= checkForNull((String) hashMap3.get("q_parity"));
			q_parity1						= checkForNull((String) hashMap3.get("q_parity1")); //68508
			q_gravida						= checkForNull((String) hashMap3.get("q_gravida"));
			if(q_no_of_birth > 1) {
				flag = 1;
			} else {	
				flag = 0;
			}
		}
		String hide_bedNo ="", bed_label ="";	
		if(invoke_adm_from_newborn_yn.equals("Y")){
		
			bed_label="";
			hide_bedNo="style='visibility:hidden'";
		}else {
			bed_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels");
			hide_bedNo="style='visibility:visible'";
		}
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(new_function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(antvalue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
if(mpDisableFieldsNBFather && function_id.equals("MAINTAIN_BIRTH")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(no_marital_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

				min_weight						= checkForNull((String) mPParamDtls.get("min_weight"));
				max_weight						= checkForNull((String) mPParamDtls.get("max_weight"));
				min_chest_circum				= checkForNull((String) mPParamDtls.get("min_chest_circum"));
				max_chest_circum				= checkForNull((String) mPParamDtls.get("max_chest_circum"));
				min_head_circum					= checkForNull((String) mPParamDtls.get("min_head_circum"));
				max_head_circum					= checkForNull((String) mPParamDtls.get("max_head_circum"));
				min_length						= checkForNull((String) mPParamDtls.get("min_length"));
				max_length						= checkForNull((String) mPParamDtls.get("max_length"));
				min_gestation					= checkForNull((String) mPParamDtls.get("min_gestation"));
				max_gestation					= checkForNull((String) mPParamDtls.get("max_gestation"));
				nb_male_relnship				= checkForNull((String) mPParamDtls.get("nb_male_relnship"));
				nb_female_relnship				= checkForNull((String) mPParamDtls.get("nb_female_relnship"));
				nb_unknown_relnship				= checkForNull((String) mPParamDtls.get("nb_unknown_relnship"));
				pat_name_as_multipart_yn		= checkForNull((String) mPParamDtls.get("pat_name_as_multipart_yn"));
				nat_id_accept_alphanumeric_yn	= checkForNull((String) mPParamDtls.get("nat_id_accept_alphanumeric_yn"),"N");
				name_dervn_logic	= checkForNull((String) mPParamDtls.get("name_dervn_logic"),"");
				name_dervn_logic_long	= checkForNull((String) mPParamDtls.get("name_dervn_logic_long"),"");
				name_dervn_logic_oth_lang	= checkForNull((String) mPParamDtls.get("name_dervn_logic_oth_lang"),"");
				name_dervn_logic_oth_lang_long	= checkForNull((String) mPParamDtls.get("name_dervn_logic_oth_lang_long"),"");
		
				out.println("<script language = 'javascript'> var PSGCodeArray = new Array(); var PSGYNArray = new Array(); var PSGPRYNArray = new Array(); var NamePrefixArray = new Array(); var PrefixSexArray = new Array();");	
				array_list = eMP.NewbornDetails.getPatSerGroupGenIdPrefixReqd(con,p);
				int k =0;
				for(int i=0;i<array_list.size();i+=3) {
					out.println("PSGCodeArray["+k+"]=\""+(String) array_list.get(i)+"\";");
					out.println("PSGYNArray["+k+"]=\""+(String) array_list.get(i+1)+"\";");
					out.println("PSGPRYNArray["+k+"]=\""+(String) array_list.get(i+2)+"\";");
					k++;
				}
				out.println("</script>");




				accessRights = (String)session.getValue("accessRights");
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(new_function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);

						if(!function_id.equals("REGISTER_NEWBORN")){ 
							if(!invoked_from.equals("servlet") && !invoked_from.equals("details_page")) {							
						
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String) hashMap.get("q_mother_patient_id")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_idlength));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String) 	hashMap.get("q_mother_patient_id")));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("q_mother_patient_name"))));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String) 	hashMap.get("q_mother_patient_id")));
            _bw.write(_wl_block27Bytes, _wl_block27);

					}}
            _bw.write(_wl_block28Bytes, _wl_block28);
 
			if(isRegNewbornApplicable){
			
            _bw.write(_wl_block29Bytes, _wl_block29);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(!cd3.equals("")){  
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cd3));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mthr_nat_id_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
 }else {
            _bw.write(_wl_block34Bytes, _wl_block34);
}}
			   else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block36Bytes, _wl_block36);
if(calling_module_id.equals("IP")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(motherencounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(!alt_id1_type_desc.equals("")){

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_type_desc));
}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(!alt_id1_type_desc.equals("")){
            out.print( String.valueOf(mthr_alt_id1_no));
}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){
            out.print( String.valueOf(mthr_alt_id2_no));
}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(mthr_alt_id3_no));
} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){
            out.print( String.valueOf(mthr_oth_alt_id_No));
}
            _bw.write(_wl_block45Bytes, _wl_block45);

			  if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") || accept_oth_alt_id_yn.equals("Y"))) && (alt_id3_type_desc.equals("") || !alt_id3_type_desc.equals("") ) ){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(mthr_alt_id2_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
 }
			if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") &&!alt_id3_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") ||accept_oth_alt_id_yn.equals("Y")) )){
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(mthr_alt_id3_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
 } if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mthr_oth_alt_id_No));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(race_required_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
 
                if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")) || ((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !!alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ) ){   
               
            _bw.write(_wl_block56Bytes, _wl_block56);
if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_type_desc));
}else {

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(mthr_alt_id3_no));
}else{
            out.print( String.valueOf(mthr_oth_alt_id_No));
}
            _bw.write(_wl_block33Bytes, _wl_block33);
 } if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mthr_oth_alt_id_No));
            _bw.write(_wl_block57Bytes, _wl_block57);
 } 
            _bw.write(_wl_block58Bytes, _wl_block58);
 //End this CRF ML-MMOH-CRF-0621
		  }
		  else if(isMPMandatoryFieldsNewborn){
			  
            {java.lang.String __page ="../../eMP/jsp/NewbornRegistrationMotherDtls.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("accept_national_id_no_yn"), weblogic.utils.StringUtils.valueOf(accept_national_id_no_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_nat_id_no"), weblogic.utils.StringUtils.valueOf(mthr_nat_id_no
                        )},{ weblogic.utils.StringUtils.valueOf("cd3"), weblogic.utils.StringUtils.valueOf(cd3
                        )},{ weblogic.utils.StringUtils.valueOf("accept_oth_alt_id_yn"), weblogic.utils.StringUtils.valueOf(accept_oth_alt_id_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_oth_alt_id_No"), weblogic.utils.StringUtils.valueOf(mthr_oth_alt_id_No
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_alt_id1_no"), weblogic.utils.StringUtils.valueOf(mthr_alt_id1_no
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_type_desc"), weblogic.utils.StringUtils.valueOf(alt_id1_type_desc
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_alt_id2_no"), weblogic.utils.StringUtils.valueOf(mthr_alt_id2_no
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_type_desc"), weblogic.utils.StringUtils.valueOf(alt_id2_type_desc
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_alt_id3_no"), weblogic.utils.StringUtils.valueOf(mthr_alt_id3_no
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_type_desc"), weblogic.utils.StringUtils.valueOf(alt_id3_type_desc
                        )},{ weblogic.utils.StringUtils.valueOf("mthr_alt_id4_no"), weblogic.utils.StringUtils.valueOf(mthr_alt_id4_no
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_type_desc"), weblogic.utils.StringUtils.valueOf(alt_id4_type_desc
                        )},{ weblogic.utils.StringUtils.valueOf("motherencounterid"), weblogic.utils.StringUtils.valueOf(motherencounterid
                        )},{ weblogic.utils.StringUtils.valueOf("mother_patient_id"), weblogic.utils.StringUtils.valueOf(mother_patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("invoked_from"), weblogic.utils.StringUtils.valueOf(invoked_from
                        )},{ weblogic.utils.StringUtils.valueOf("race_required_yn"), weblogic.utils.StringUtils.valueOf(race_required_yn
                        )},{ weblogic.utils.StringUtils.valueOf("oth_alt_id_type"), weblogic.utils.StringUtils.valueOf(oth_alt_id_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block62Bytes, _wl_block62);
  }else{
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(!alt_id1_type_desc.equals("")){  
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(calling_module_id.equals("IP")) {
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(motherencounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
}}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(race_required_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
 if(!alt_id2_type_desc.equals("")){  
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mthr_alt_id2_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else {  
            _bw.write(_wl_block73Bytes, _wl_block73);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(!alt_id3_type_desc.equals("")){  
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mthr_alt_id3_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else {  
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block75Bytes, _wl_block75);
 if(!alt_id4_type_desc.equals("")){  
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( alt_id4_type_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mthr_alt_id4_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
 } else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block79Bytes, _wl_block79);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(!cd3.equals("")){  
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cd3));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mthr_nat_id_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } }
			   else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block80Bytes, _wl_block80);
if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mthr_oth_alt_id_No));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
  
		if(function_id.equals("REGISTER_NEWBORN")){
			 if(flag==1)
			 {
				 multi_check="checked";
				 multibirthvalue="Y";
				 multidisabled="disabled";
			 }
		}else{
			 if(checkForNull((String) hashMap.get("q_multiple_birth_yn")).equals("Y")) {
				 multibirthvalue="Y";
				 multi_check="checked";
			   }
			  multidisabled="disabled";
		   }
			if(function_id.equals("REGISTER_NEWBORN")){
				if(q_no_of_birth==0)
					q_no_of_birth=1;
				if(MC_Dtls_YN.equals("Y") && !ca_no_of_births.equals("")){
					q_no_of_birth=Integer.parseInt(ca_no_of_births);
					if(q_no_of_birth > 1){
						multi_check="checked";
					}
				}
			}
		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(multibirthvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(multi_check));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(multidisabled));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(MC_Dtls_YN.equals("Y")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
if(function_id.equals("REGISTER_NEWBORN")){
			String noofbirthvisibible="visibility:hidden";
			if(flag==1)
			{
				noofbirthvisibible="visibility:visible";
			}
			
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(q_no_of_birth));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(noofbirthvisibible));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(q_birth_order));
            _bw.write(_wl_block92Bytes, _wl_block92);
}else{
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf((String) hashMap.get("q_no_of_birth")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf((String) hashMap.get("q_no_of_birth")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf((String) hashMap.get("q_birth_order")));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(unitofgestnb));
            _bw.write(_wl_block66Bytes, _wl_block66);
	
			sel1 = ""; sel2 = ""; 
			if(unitofgestnb.equals("W")) {
				sel1="selected";						
			} else { 
				sel2 = "selected";				
			}			 
			if(function_id.equals("REGISTER_NEWBORN")){
				if(flag == 1){ 
					if(!q_gestational_period.equals("")) {
						gestdisabled="disabled";
					}		
					if(!q_gestational_period_days.equals("")) {
						gestDaysDisabled="disabled";
					}	
				}				
				if(!lmp_ca.equals("")){
					if(unitofgestnb.equals("W")){
						q_gestational_period=no_of_weeks;
						if(nod <= 6){
							q_gestational_period_days=(new Integer(nod)).toString();
						}
					}else{
						q_gestational_period=no_of_days;
					}
					gestdisabled1="disabled";					
					gestDaysDisabled="disabled";
				}
			}else{
				  q_gestational_period = checkForNull((String) hashMap.get("q_gestational_period"));			  
				  q_gestational_period_days = checkForNull((String) hashMap.get("q_gestational_period_days"));				 
				  if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet"))) {
					  gestdisabled = "disabled";
					  gestDaysDisabled="disabled";
				  }else{
					  gestdisabled="";
					  if(!q_gestational_period_days.equals("")) {
						  gestDaysDisabled="";
					  }
				  }
				  if(!((String)hashMap.get("q_lmp")).equals("")){
					  gestdisabled1="disabled";
					  gestDaysDisabled="disabled";
				  }
			}
			
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(q_gestational_period));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(min_gestation));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_gestation));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(gestdisabled1));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(gestdisabled));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
 
				if(unitofgestnb.equals("W")){
			
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(q_gestational_period_days));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(gestDaysDisabled));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

				}
			
            _bw.write(_wl_block28Bytes, _wl_block28);
if(called_function.equals("IP")){
            _bw.write(_wl_block109Bytes, _wl_block109);

			} 
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block41Bytes, _wl_block41);
if((!ca_delivery_type.equals("")) && (!nb_mother_dtls_update_yn.equals("Y")) ||(finalizeYN.equals("Y"))&&(ca_no_of_births.equals(""))){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

				array_list = eMP.NewbornDetails.getNodeTypeShortDesc(con,p);
				for(int i=0;i<array_list.size();i+=3) {
					if(ca_delivery_type.equals((String)array_list.get(i))){
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\" selected>"+(String) array_list.get(i+1)+"</option>");
					}else{
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\">"+(String) array_list.get(i+1)+"</option>");
					} 				
				}
				
            _bw.write(_wl_block114Bytes, _wl_block114);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block115Bytes, _wl_block115);

						if((!checkForNull((String) hashMap.get("q_nod_type")).equals("")) && (!checkForNull((String) hashMap.get("q_delivery_indicator")).equals(""))){
					
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_nod_type"))));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_delivery_indicator"))));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block119Bytes, _wl_block119);
}
            _bw.write(_wl_block120Bytes, _wl_block120);

				if((called_function.equals("IP")&& isLabelChangeApplicable) || (called_function.equals("IP") && isRegNewbornApplicable)){
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
if(!function_id.equals("REGISTER_NEWBORN")){
				q_gravida=checkForNull((String) hashMap.get("q_gravida"));}
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(q_gravida));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block126Bytes, _wl_block126);
if(called_function.equals("IP")){
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block128Bytes, _wl_block128);
 /*Below line added for this CRF ML-MMOH-CRF-0621*/
			if((called_function.equals("IP") && isLabelChangeApplicable) || (called_function.equals("IP") && isRegNewbornApplicable)){
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(!function_id.equals("REGISTER_NEWBORN")){
			 q_parity=checkForNull((String)hashMap.get("q_parity"));
			 q_parity1=checkForNull((String)hashMap.get("q_parity1"));  //68508
			}
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(q_parity));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block131Bytes, _wl_block131);
if(isRegNewbornApplicable){
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(checkForNull((String)hashMap.get("parity_on_admission"))));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
 
			if((called_function.equals("IP")) || (called_function.equals("MP") && mandParityNewBornYN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("AE") && mandParityNewBornAE_YN.equals("Y") && invokeMenstrualHistYN.equals("Y"))) 
			{ 
			
			
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);
if(invokeMenstrualHistYN.equals("Y")){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(q_parity1));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block138Bytes, _wl_block138);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
 if((called_function.equals("IP") && mandParityNewBornIP_YN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("MP") && mandParityNewBornYN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("AE") && mandParityNewBornAE_YN.equals("Y") && invokeMenstrualHistYN.equals("Y"))) { 
			
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block139Bytes, _wl_block139);
	if(isNewBornChngsAppl){
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(ca_attend_pract_id_desc));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(ca_attend_pract_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_attend_physician_id"))));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_attend_physician_desc"))));
            _bw.write(_wl_block147Bytes, _wl_block147);
}
            _bw.write(_wl_block148Bytes, _wl_block148);
if(isNewBornChngsAppl){
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
}else{
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(ca_attend_nurse_id_desc));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(ca_attend_nurse_id));
            _bw.write(_wl_block155Bytes, _wl_block155);
if(!function_id.equals("REGISTER_NEWBORN")){
		
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_attend_midwife_id"))));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_attend_midwife_desc"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block159Bytes, _wl_block159);
	if(isNewBornChngsAppl){
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(checkForNull((String)hashMap.get("mother_witnessed_by1"))));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(checkForNull((String)hashMap.get("mother_witnessed_by2"))));
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
if(isRegNewbornApplicable){
				if(newbornReg.equals("Y")){
                if((function_id.equals("MAINTAIN_BIRTH") && born_where.equals("I") && babyoutcome.equals("L"))) { 				 
						   headcircum_lengofBaby="visibility:visible"; 
				}else if((function_id.equals("MAINTAIN_BIRTH") && !born_where.equals("I")) || (function_id.equals("MAINTAIN_BIRTH") && !babyoutcome.equals("L"))) {
						   headcircum_lengofBaby="visibility:hidden";	
        		 } 	
			}
        	    String  nat_other_alter_id="", nat_other_alter_legend="";
			    StringBuffer natstrBuffer=new StringBuffer("select national_id_num, oth_alt_id_no from am_practitioner where practitioner_id ='");	
				natstrBuffer.append(checkForNull((String)hashMap.get("q_attend_physician_id"))).append("'");
				newbornstmt = con.prepareStatement(natstrBuffer.toString());
				newbornrs = newbornstmt.executeQuery();
				if(newbornrs!=null && newbornrs.next()){
				national_id=newbornrs.getString("national_id_num")==null?"":newbornrs.getString("national_id_num");
				other_alter_id=newbornrs.getString("oth_alt_id_no")==null?"":newbornrs.getString("oth_alt_id_no");    	 
				}
			 if(!national_id.equals("")){
						 if(cd3.equals("")){
							nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
						 }else{
							nat_other_alter_legend=cd3;	
						  }				  
						 nat_other_alter_id=national_id;
			 }else if(national_id.equals("") && !other_alter_id.equals("")){
						   nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels"); 
						   nat_other_alter_id=other_alter_id;
						 
			}
				 if(newbornrs!=null) newbornrs.close();
				 if(newbornstmt!=null) newbornstmt.close();   
			   
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(nat_other_alter_legend));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(nat_other_alter_id));
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block172Bytes, _wl_block172);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(q_compln_pregnancy_desc));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_compln_pregnancy_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(q_compln_nr_pregnancy_desc));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_compln_nr_pregnancy_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_stages));
if(((!ca_comp_in_del_stage1.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);
array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"First");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn = "";
								if(ca_comp_in_del_stage1.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
							}
            _bw.write(_wl_block185Bytes, _wl_block185);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(checkForNull((String) hashMap.get("complns_1st_stage_labour_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block140Bytes, _wl_block140);
if(isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(mandatefirstnewbornValue));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
            _bw.write(_wl_block189Bytes, _wl_block189);
if(!isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_stages));
if((!ca_comp_in_del_stage2.equals(""))||(finalizeYN.equals("Y"))){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
								for(int i=0;i<array_list.size();i+=inc) {
									sel_yn = "";
								if(ca_comp_in_del_stage2.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
            _bw.write(_wl_block185Bytes, _wl_block185);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(checkForNull((String) hashMap.get("complns_2nd_stage_labour_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block194Bytes, _wl_block194);
}else{
            _bw.write(_wl_block195Bytes, _wl_block195);
if(isModifyLongShortDescAppl){

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block198Bytes, _wl_block198);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_delivery_indication"))));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(dely_ind_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block201Bytes, _wl_block201);
}
            _bw.write(_wl_block202Bytes, _wl_block202);
if(isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_stages));
if(((!ca_comp_in_del_stage2.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
								for(int i=0;i<array_list.size();i+=inc) {
									sel_yn = "";
								if(ca_comp_in_del_stage2.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
            _bw.write(_wl_block185Bytes, _wl_block185);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(checkForNull((String) hashMap.get("complns_2nd_stage_labour_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block140Bytes, _wl_block140);
if(isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(mandate_secondnewbornValue));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
            _bw.write(_wl_block204Bytes, _wl_block204);
}else{
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_stages));
if((!ca_comp_in_del_stage3.equals(""))||(finalizeYN.equals("Y"))){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn	= "";
								if(ca_comp_in_del_stage3.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
						
            _bw.write(_wl_block185Bytes, _wl_block185);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(checkForNull((String) hashMap.get("complns_3rd_stage_labour_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block194Bytes, _wl_block194);
}
            _bw.write(_wl_block207Bytes, _wl_block207);
if(isModifyLongShortDescAppl){

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_delivery));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_comp_of_delivery.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ca_comp_of_delivery_desc));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_delivery));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_comp_of_delivery.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ca_comp_of_delivery));
            _bw.write(_wl_block211Bytes, _wl_block211);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(q_compln_dely_desc));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_COMPLN_DELY_CODE"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block214Bytes, _wl_block214);
if(!isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block215Bytes, _wl_block215);
if(isModifyLongShortDescAppl){

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block198Bytes, _wl_block198);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_delivery_indication"))));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(dely_ind_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block194Bytes, _wl_block194);
}else{
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_com_stages));
if(((!ca_comp_in_del_stage3.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn	= "";
								if(ca_comp_in_del_stage3.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
						
            _bw.write(_wl_block185Bytes, _wl_block185);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(checkForNull((String) hashMap.get("complns_3rd_stage_labour_code"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block140Bytes, _wl_block140);
if(isMPMandatoryFieldsNewborn){
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(mandate_third_newbornValue));
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block220Bytes, _wl_block220);
}
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ca_proc_classification_desc));
            _bw.write(_wl_block223Bytes, _wl_block223);
if(!ca_proc_classification.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_proc_classification_desc.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(ca_proc_classification));
            _bw.write(_wl_block226Bytes, _wl_block226);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_proc_class_code"))));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(q_proc_class_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ca_vaginal_delivery_type_desc));
            _bw.write(_wl_block223Bytes, _wl_block223);
if(!ca_vaginal_delivery_type.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_vaginal_delivery_type.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(ca_vaginal_delivery_type));
            _bw.write(_wl_block233Bytes, _wl_block233);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_vaginal_del_type_code"))));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(q_vaginal_dely_type_desc));
            _bw.write(_wl_block236Bytes, _wl_block236);
}
            _bw.write(_wl_block237Bytes, _wl_block237);
if(isModifyLongShortDescAppl){

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ca_del_surg_classification_desc));
            _bw.write(_wl_block223Bytes, _wl_block223);
if(!ca_del_surg_classification.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_del_surg_classification.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(ca_del_surg_classification));
            _bw.write(_wl_block241Bytes, _wl_block241);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_del_serv_class"))));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(q_dely_surg_class_desc));
            _bw.write(_wl_block236Bytes, _wl_block236);
}
            _bw.write(_wl_block244Bytes, _wl_block244);
if(!function_id.equals("REGISTER_NEWBORN"))
					{
						q_remarks=checkForNull((String) hashMap.get("q_remarks"));
					}
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(q_remarks));
            _bw.write(_wl_block248Bytes, _wl_block248);
 if(captureAntenatalDtlsYN.equals("Y")) { 
						antenatal_care_yn=checkForNull((String)hashMap.get("antenatal_care_yn"));
						String antechecked="", antecarevalue="N";
						if(antenatal_care_yn.equals("Y")){
							antechecked="checked";
							antecarevalue="Y";
						}
					
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(antechecked));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(antecarevalue));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(captureAntenatalDtlsYN));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(call_function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(captureAntenatalDtlsYN));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(dis_all_mother_dtls));
            _bw.write(_wl_block268Bytes, _wl_block268);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block269Bytes, _wl_block269);
	if(!function_id.equals("REGISTER_NEWBORN")){	 												ant_care_gvn_at=checkForNull((String)hashMap.get("ant_care_gvn_at"));
							ant_care_locn_code=checkForNull((String)hashMap.get("ant_care_locn_code"));
							ant_care_locn_type=checkForNull((String)hashMap.get("ant_care_locn_type"));
						if(!ant_care_locn_type.equals("")) {
							array_list.clear();
							array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,ant_care_locn_type,con,p);
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull(ant_care_locn_code).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						 }
					}
            _bw.write(_wl_block270Bytes, _wl_block270);
 	}else{
            _bw.write(_wl_block271Bytes, _wl_block271);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
if(captureAntenatalDtlsYN.equals("Y"))  {
					if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(antenatal_care_yn));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(ant_care_gvn_at));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(ant_care_locn_type));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(ant_care_locn_code));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(ant_care_locn_type));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(ant_care_gvn_at));
            _bw.write(_wl_block278Bytes, _wl_block278);
}else{
            _bw.write(_wl_block279Bytes, _wl_block279);
}
					}
            _bw.write(_wl_block59Bytes, _wl_block59);
	if(isNewBornChngsAppl || isMotherAliveAppl){
							String mother_alive_yn	= checkForNull((String)hashMap.get("mother_alive_yn"),"Y");
					
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);
if("Y".equals(mother_alive_yn)){
            _bw.write(_wl_block282Bytes, _wl_block282);
}
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);
if("N".equals(mother_alive_yn)){
            _bw.write(_wl_block282Bytes, _wl_block282);
}
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block284Bytes, _wl_block284);
}
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);

					   String patiddis="", q_father_patient_name_loc_lang="";
					if(function_id.equals("REGISTER_NEWBORN")){
						if(flag==1)
						{
							patiddis="disabled";
						}
					} else {
						 if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
							  patiddis="disabled";
						 else
							  patiddis="";						 q_father_patient_id			= checkForNull((String) hashMap.get("q_father_patient_id"));
						 q_father_name				= checkForNull((String) hashMap.get("q_father_name"));						
						 q_father_name_long				= checkForNull((String) hashMap.get("q_father_name_long"));						
						 q_father_name_long_loc_lang				= checkForNull((String) hashMap.get("q_father_name_long_loc_lang"));						
						 q_father_national_id_no	= checkForNull(((String) hashMap.get("q_FATHER_NATIONAL_ID_NO")));
						 q_father_oth_alt_id_type	=checkForNull((String)hashMap.get("q_FATHER_OTH_ALT_ID_TYPE"));
						 father_alt_id1_no_value=checkForNull((String) hashMap.get("q_father_alt_id1_no"));
						 father_alt_id2_no_value=checkForNull((String) hashMap.get("q_father_alt_id2_no"));
						 father_alt_id3_no_value=checkForNull((String) hashMap.get("q_father_alt_id3_no"));
						 father_alt_id4_no_value=checkForNull((String) hashMap.get("q_father_alt_id4_no"));
						 q_FATHER_OTH_ALT_ID_NO=checkForNull((String) hashMap.get("q_FATHER_OTH_ALT_ID_NO"));
						 q_father_nationality_code=checkForNull((String)hashMap.get("q_FATHER_NATIONALITY_CODE")); 
						 q_father_nationality_desc=checkForNull((String)hashMap.get("q_father_nationality_desc")); 
                         q_race_code = checkForNull((String)hashMap.get("q_FATHER_ETHNIC_GROUP_CODE"));
                         q_race_desc = checkForNull((String)hashMap.get("q_father_ethnic_group_desc"));
						 q_father_religion_code = checkForNull((String)hashMap.get("q_FATHER_RELIGION_CODE")).trim();
						 q_father_ocpn_class_code = checkForNull((String)hashMap.get("q_FATHER_OCPN_CLASS_CODE")).trim();
						 q_father_remarks = checkForNull((String) hashMap.get("q_FATHER_REMARKS"));
						 q_finalized_yn = (String) hashMap.get("q_finalized_yn");
						 q_father_religion_desc = checkForNull((String) hashMap.get("q_father_religion_desc"));
						  q_father_patient_name_loc_lang				= checkForNull((String) hashMap.get("father_patient_name_loc_lang"));
					}
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(patient_idlength));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(q_father_patient_id));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(patiddis));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(patiddis));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(q_father_patient_id));
            _bw.write(_wl_block292Bytes, _wl_block292);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(q_father_name));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(q_father_name_long));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(q_father_name_long_loc_lang));
            _bw.write(_wl_block296Bytes, _wl_block296);
if(!function_id.equals("REGISTER_NEWBORN")) {
            _bw.write(_wl_block149Bytes, _wl_block149);
            {java.lang.String __page ="../../eMP/jsp/PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("FatherDtls")},{ weblogic.utils.StringUtils.valueOf("populatenewBornDtls"), weblogic.utils.StringUtils.valueOf("N")},{ weblogic.utils.StringUtils.valueOf("nb_father_name_mandatory_yn"), weblogic.utils.StringUtils.valueOf(nb_father_name_mandatory_yn
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_name_prefix")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_name_suffix")
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_family_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_first_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_second_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_third_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_name_prefix_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_first_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_second_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_third_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_family_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("father_name_suffix_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Prompt"), weblogic.utils.StringUtils.valueOf(First_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Second_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Third_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Family_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_org_id_accept_yn"), weblogic.utils.StringUtils.valueOf(FAMILY_ORG_ID_ACCEPT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Order"), weblogic.utils.StringUtils.valueOf(Family_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Order"), weblogic.utils.StringUtils.valueOf(First_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Order"), weblogic.utils.StringUtils.valueOf(Second_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Order"), weblogic.utils.StringUtils.valueOf(Third_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_length"), weblogic.utils.StringUtils.valueOf(first_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_length"), weblogic.utils.StringUtils.valueOf(second_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_length"), weblogic.utils.StringUtils.valueOf(third_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_length"), weblogic.utils.StringUtils.valueOf(family_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(family_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_suffix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(first_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(second_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(third_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_prefix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("names_in_oth_lang_yn"), weblogic.utils.StringUtils.valueOf(names_in_oth_lang_yn
                        )},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("no_marital_status"), weblogic.utils.StringUtils.valueOf(no_marital_status
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block299Bytes, _wl_block299);
} else {
            _bw.write(_wl_block149Bytes, _wl_block149);
            {java.lang.String __page ="../../eMP/jsp/PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("FatherDtls")},{ weblogic.utils.StringUtils.valueOf("populatenewBornDtls"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("nb_father_name_mandatory_yn"), weblogic.utils.StringUtils.valueOf(nb_father_name_mandatory_yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Prompt"), weblogic.utils.StringUtils.valueOf(First_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Second_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Third_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Family_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_org_id_accept_yn"), weblogic.utils.StringUtils.valueOf(FAMILY_ORG_ID_ACCEPT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Order"), weblogic.utils.StringUtils.valueOf(Family_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Order"), weblogic.utils.StringUtils.valueOf(First_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Order"), weblogic.utils.StringUtils.valueOf(Second_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Order"), weblogic.utils.StringUtils.valueOf(Third_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_length"), weblogic.utils.StringUtils.valueOf(first_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_length"), weblogic.utils.StringUtils.valueOf(second_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_length"), weblogic.utils.StringUtils.valueOf(third_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_length"), weblogic.utils.StringUtils.valueOf(family_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(family_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_suffix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(first_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(second_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(third_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_prefix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("names_in_oth_lang_yn"), weblogic.utils.StringUtils.valueOf(names_in_oth_lang_yn
                        )},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("no_marital_status"), weblogic.utils.StringUtils.valueOf(no_marital_status
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block301Bytes, _wl_block301);
 
				String nat_on_blurfn_st = "", nat_id_onKeyPress="";
				if(accept_national_id_no_yn.equals("Y")){
				if(!cd3.equals("")){					
					nat_on_blurfn_st = "makeValidString(this);validateNationality(this,'','','"+nat_invoke_routine+"','"+nat_data_source_id+"','"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','N')";
					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
					}				
					
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(cd3));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(cd3));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(cd4));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(q_father_national_id_no));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(patiddis));
            _bw.write(_wl_block308Bytes, _wl_block308);
 }}
					int span=2;
					if(cd3.equals("")){
            _bw.write(_wl_block309Bytes, _wl_block309);
 span=1;
					}
						String otheraltidnewborn="";
            _bw.write(_wl_block310Bytes, _wl_block310);

					if(function_id.equals("REGISTER_NEWBORN")){
						  if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
				}
				else
				{
					if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
						otheraltidnewborn="disabled";
					else
						otheraltidnewborn="";
				}
				if(!alt_id1_type_desc.equals("")) {
					
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(father_alt_id1_no_value));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block315Bytes, _wl_block315);

				} 
					if(accept_oth_alt_id_yn.equals("Y")) {
            _bw.write(_wl_block316Bytes, _wl_block316);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(span));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(patiddis));
            _bw.write(_wl_block319Bytes, _wl_block319);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

								array_list.clear();
								array_list = eMP.NewbornDetails.getAlternateIDTypeDesc(con,p);
								for(int i=0;i<array_list.size();i+=2) {
								out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
								} 
						
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(q_father_oth_alt_id_type));
            _bw.write(_wl_block322Bytes, _wl_block322);
						
					  if(function_id.equals("REGISTER_NEWBORN")){					  
						  if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
						}
						  else
						  {
							if (q_FATHER_OTH_ALT_ID_NO.equals("") || (invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet")) 
								otheraltidnewborn="disabled";
						  }
					   
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(q_FATHER_OTH_ALT_ID_NO));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block324Bytes, _wl_block324);
}else{
            _bw.write(_wl_block325Bytes, _wl_block325);
}
            _bw.write(_wl_block326Bytes, _wl_block326);

                     if(function_id.equals("REGISTER_NEWBORN")){
						 if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
					} else {
						if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
							otheraltidnewborn="disabled";
					    else
						    otheraltidnewborn="";							  
					}
					
            _bw.write(_wl_block327Bytes, _wl_block327);
 if(!alt_id2_type_desc.equals("")) {
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(father_alt_id2_no_value));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block315Bytes, _wl_block315);
} if(!alt_id3_type_desc.equals("")) {
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(father_alt_id3_no_value));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block331Bytes, _wl_block331);
} 
            _bw.write(_wl_block332Bytes, _wl_block332);
 if(!alt_id4_type_desc.equals("")) {
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(father_alt_id4_no_value));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block315Bytes, _wl_block315);
}
            _bw.write(_wl_block334Bytes, _wl_block334);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(q_father_nationality_desc));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(q_father_nationality_code));
            _bw.write(_wl_block339Bytes, _wl_block339);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(q_race_desc));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(q_race_code));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(race_style));
            _bw.write(_wl_block346Bytes, _wl_block346);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);

						String q_FATHER_GOVE_EMPLOYEE_YN="N", q_father_gove_checked="";
						if(function_id.equals("REGISTER_NEWBORN")){
						if (flag==1) { 
					    	otheraltidnewborn="disabled";
							if(q_father_govemp.equals("Y"))
						    {
								q_FATHER_GOVE_EMPLOYEE_YN="Y";
								q_father_gove_checked="checked";
							}
						  }
					   } else
						  {
						    if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet"))
								otheraltidnewborn="disabled";
					        else
						        otheraltidnewborn="";
							
							if(checkForNull(((String) hashMap.get("q_FATHER_GOVE_EMPLOYEE_YN"))).equals("Y")) {
								q_FATHER_GOVE_EMPLOYEE_YN="Y";
								q_father_gove_checked="checked";
							}
							
						  }
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(q_FATHER_GOVE_EMPLOYEE_YN));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(q_father_gove_checked));
            _bw.write(_wl_block350Bytes, _wl_block350);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block353Bytes, _wl_block353);
if(!q_father_religion_code.equals("") && !otheraltidnewborn.equals("")){ 
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(q_father_religion_code));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(q_father_religion_desc));
            _bw.write(_wl_block356Bytes, _wl_block356);
}else{
							array_list.clear();
							array_list = eMP.NewbornDetails.getReligionCodeShortDesc(con,p);
							for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
							  }
							}
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(q_father_religion_code));
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block360Bytes, _wl_block360);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);

								array_list.clear();
								array_list = eMP.NewbornDetails.getOccupationClassCodeShortDesc(con,p);
								for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
								}
							
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(q_father_ocpn_class_code));
            _bw.write(_wl_block236Bytes, _wl_block236);
 
					if(!function_id.equals("REGISTER_NEWBORN")){
						fathr_ocpn_code = checkForNull((String)hashMap.get("q_FATHER_OCPN_CODE"));
						q_father_ocpn_desc = checkForNull((String) hashMap.get("q_FATHER_OCPN_DESC"));
				    } 					
					
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(otheraltidnewborn));
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block365Bytes, _wl_block365);

							if(!q_father_ocpn_class_code.equals("")) {
								array_list.clear();
								array_list = eMP.NewbornDetails.getOccupationCodeShortDesc(checkForNull((String) hashMap.get("q_FATHER_OCPN_CLASS_CODE")),con,p);
							
								for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String) array_list.get(i)+"\" >"+(String)array_list.get(i+1)+"</option>");								
								}
							}					
					
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(fathr_ocpn_code));
            _bw.write(_wl_block367Bytes, _wl_block367);

					String q_father_ocpn_descdis=""; 
					if(function_id.equals("REGISTER_NEWBORN")){
					 	  q_father_ocpn_descdis="disabled";
					 }
					 else
					 {
						 if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet"))
							q_father_ocpn_descdis="disabled";
						 else
						 {
							 if(!q_father_ocpn_desc.equals(""))
							 {
								 q_father_ocpn_descdis = "";
							 }
							 else
								 q_father_ocpn_descdis = "disabled";
						 }
					 }
					
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(q_father_ocpn_desc));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(q_father_ocpn_descdis));
            _bw.write(_wl_block371Bytes, _wl_block371);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(q_father_remarks));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block374Bytes, _wl_block374);

				if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))	
					dis_all_flds = ""; 				
				
				if(invoked_from.equals("servlet"))
					function_id = new_function_id; 			
			
            _bw.write(_wl_block375Bytes, _wl_block375);
if(ip_install_yn.equals("N") || !called_function.equals("IP")) { 
            _bw.write(_wl_block376Bytes, _wl_block376);
 } 
            _bw.write(_wl_block377Bytes, _wl_block377);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);

					if(function_id.equals("MAINTAIN_BIRTH")) {
						q_nb_patient_name = checkForNull((String) hashMap.get("nb_patient_name"));	
					}
				
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(q_nb_patient_name));
            _bw.write(_wl_block381Bytes, _wl_block381);
if(!function_id.equals("REGISTER_NEWBORN")) { 
            _bw.write(_wl_block149Bytes, _wl_block149);
            {java.lang.String __page ="../../eMP/jsp/PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("NewbornDtls")},{ weblogic.utils.StringUtils.valueOf("populatenewBornDtls"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("a_name_prefix"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_name_prefix")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_name_suffix")
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_family_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_first_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_second_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_third_name")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_name_prefix_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_first_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_second_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_third_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_family_name_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix_loc_lang"), weblogic.utils.StringUtils.valueOf((String)hashMap.get("nb_name_suffix_loc_lang")
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Prompt"), weblogic.utils.StringUtils.valueOf(First_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Second_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Third_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Family_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_org_id_accept_yn"), weblogic.utils.StringUtils.valueOf(FAMILY_ORG_ID_ACCEPT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Order"), weblogic.utils.StringUtils.valueOf(Family_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Order"), weblogic.utils.StringUtils.valueOf(First_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Order"), weblogic.utils.StringUtils.valueOf(Second_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Order"), weblogic.utils.StringUtils.valueOf(Third_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_length"), weblogic.utils.StringUtils.valueOf(first_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_length"), weblogic.utils.StringUtils.valueOf(second_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_length"), weblogic.utils.StringUtils.valueOf(third_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_length"), weblogic.utils.StringUtils.valueOf(family_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(family_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_suffix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(first_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(second_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(third_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_prefix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("names_in_oth_lang_yn"), weblogic.utils.StringUtils.valueOf(names_in_oth_lang_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block383Bytes, _wl_block383);
 }else{
            _bw.write(_wl_block149Bytes, _wl_block149);
            {java.lang.String __page ="../../eMP/jsp/PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("NewbornDtls")},{ weblogic.utils.StringUtils.valueOf("mother_patient_id"), weblogic.utils.StringUtils.valueOf(mother_patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("populatenewBornDtls"), weblogic.utils.StringUtils.valueOf("N")},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Prompt"), weblogic.utils.StringUtils.valueOf(First_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(First_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Second_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Third_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Accept_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Accept_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Prompt"), weblogic.utils.StringUtils.valueOf(Family_Name_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Second_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Third_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Reqd_Yn"), weblogic.utils.StringUtils.valueOf(Family_Name_Reqd_Yn
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_org_id_accept_yn"), weblogic.utils.StringUtils.valueOf(FAMILY_ORG_ID_ACCEPT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Suffix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Suffix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Name_Prefix_Prompt"), weblogic.utils.StringUtils.valueOf(Name_Prefix_Prompt
                        )},{ weblogic.utils.StringUtils.valueOf("Family_Name_Order"), weblogic.utils.StringUtils.valueOf(Family_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("First_Name_Order"), weblogic.utils.StringUtils.valueOf(First_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Second_Name_Order"), weblogic.utils.StringUtils.valueOf(Second_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("Third_Name_Order"), weblogic.utils.StringUtils.valueOf(Third_Name_Order
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_length"), weblogic.utils.StringUtils.valueOf(first_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_length"), weblogic.utils.StringUtils.valueOf(second_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_length"), weblogic.utils.StringUtils.valueOf(third_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_length"), weblogic.utils.StringUtils.valueOf(family_name_length
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(family_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_suffix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(first_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(second_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(third_name_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_loc_lang_prompt"), weblogic.utils.StringUtils.valueOf(name_prefix_loc_lang_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("names_in_oth_lang_yn"), weblogic.utils.StringUtils.valueOf(names_in_oth_lang_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block384Bytes, _wl_block384);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block385Bytes, _wl_block385);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block386Bytes, _wl_block386);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block387Bytes, _wl_block387);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_nb_sex"))));
            _bw.write(_wl_block391Bytes, _wl_block391);
}
            _bw.write(_wl_block392Bytes, _wl_block392);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block393Bytes, _wl_block393);
 
						if ( function_id.equals("REGISTER_NEWBORN") || function_id.equals("MAINTAIN_BIRTH") )
						{
							
							if ( function_id.equals("REGISTER_NEWBORN")  )
							{
								BDVallnew=cd1+"*"+cd2;
								birth_date=current_date;
								dofbirthdis="";
							}
							else
							{
								dofbirthdis="disabled";
								BDVallnew = cd1+"*"+ cd2;
								dofbirthvalue=(checkForNull((String) hashMap.get("q_date_of_birth")));	
								
								if(dofbirthvalue!=null || !dofbirthvalue.equals("")) {
									StringTokenizer st_date = new StringTokenizer(dofbirthvalue," ");
									if(st_date.hasMoreTokens()) {
										birth_date = st_date.nextToken();
										birth_time = st_date.nextToken();
									}									
								}
							}
					}
					if(!dofbirthvalue.equals(""))
						dofbirthvalue=DateUtils.convertDate(dofbirthvalue,"DMYHM","en",localeName);				
					if(!birth_date.equals(""))
						birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);				
					
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(dofbirthdis));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(birth_date));
            _bw.write(_wl_block395Bytes, _wl_block395);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(dofbirthdis));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(birth_time));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(dofbirthvalue));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(hij_appl_YN));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(checkForNull((String )hashMap.get("hijri_birth_date"))));
            _bw.write(_wl_block226Bytes, _wl_block226);
if(hij_appl_YN.equals("Y")){ 
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(dofbirthdis));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(checkForNull((String )hashMap.get("hijri_birth_date"))));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(dofbirthdis));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block402Bytes, _wl_block402);
}
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block406Bytes, _wl_block406);

								try {
									stmt = con.createStatement();			
									rs1 = stmt.executeQuery("select blood_grp , short_desc  from mr_blood_grp_lang_vw  where eff_status='E' AND language_id='"+localeName+"'");
									if (rs1 != null) {
											while(rs1.next() ) {
												String BloodGroup = rs1.getString("blood_grp");
												String ShortDesc = rs1.getString("short_desc");
												if(!function_id.equals("REGISTER_NEWBORN"))
												{
													if(BloodGroup.equals(pat_blood_grp))
													{
														out.println("<option value ='"+BloodGroup+"' selected>"+ShortDesc);
													}
													else
														out.println("<option value ='"+BloodGroup+"'>"+ShortDesc);
												}
												else
												{
													out.println("<option value ='"+BloodGroup+"'>"+ShortDesc);
												}
											}
									}
								}catch(Exception e) {
									//out.println(e);
									e.printStackTrace();
								} finally {
									if (rs1 != null) rs1.close();
									if (stmt != null) stmt.close();
								}
								
            _bw.write(_wl_block407Bytes, _wl_block407);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block409Bytes, _wl_block409);

								 try {
								   String rhes_fac = "";
								   stmt = con.createStatement();
								   rs1 = stmt.executeQuery("select rhesus_factor_code, short_desc from mr_rhesus_factor_lang_vw  where eff_status='E' and language_id='"+localeName+"'");
								   if(rs1 != null) {
									   while(rs1.next()) {
										   rhes_fac = rs1.getString("rhesus_factor_code");
										if(!function_id.equals("REGISTER_NEWBORN"))
										{
										   if(rhes_fac.equals(pat_rh_factor))
										   {
											 out.println("<option value='" + rs1.getString("rhesus_factor_code") + "' selected>"+ rs1.getString("short_desc"));
										   }
										   else{
										   out.println("<option value='" + rs1.getString("rhesus_factor_code") + "'>"+ rs1.getString("short_desc"));
										   }
										}
										else
										{
											out.println("<option value='" + rs1.getString("rhesus_factor_code") + "'>"+ rs1.getString("short_desc"));
										}
									   }
									}
								
								 }catch(Exception e) {
									//out.println(e);
									e.printStackTrace();
								 } finally {
									if (rs1 != null) rs1.close();
									if (stmt != null) stmt.close();
								 }
								 
            _bw.write(_wl_block410Bytes, _wl_block410);
if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
						{

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
						else{

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block411Bytes, _wl_block411);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block412Bytes, _wl_block412);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(call_function_id));
            _bw.write(_wl_block414Bytes, _wl_block414);
if(isLabelChangeApplicable){
            _bw.write(_wl_block415Bytes, _wl_block415);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);
}else{
            _bw.write(_wl_block415Bytes, _wl_block415);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block417Bytes, _wl_block417);
}
            _bw.write(_wl_block418Bytes, _wl_block418);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBirthDtls.label","mp_labels")));
            _bw.write(_wl_block420Bytes, _wl_block420);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf((String) hashMap.get("q_outcome")));
            _bw.write(_wl_block422Bytes, _wl_block422);
}
            _bw.write(_wl_block423Bytes, _wl_block423);
if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y")){
            _bw.write(_wl_block424Bytes, _wl_block424);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block425Bytes, _wl_block425);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(relation_mdesc));
            _bw.write(_wl_block427Bytes, _wl_block427);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block429Bytes, _wl_block429);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block430Bytes, _wl_block430);

							if(FAMILY_NO_LINK_YN.equals("Y") || FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
							{
								child_mandatory="mandatory";
						
            _bw.write(_wl_block431Bytes, _wl_block431);

							}
						
            _bw.write(_wl_block432Bytes, _wl_block432);
if(entitlement_by_pat_cat_yn.equals("Y")){
            _bw.write(_wl_block433Bytes, _wl_block433);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block435Bytes, _wl_block435);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block437Bytes, _wl_block437);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(checkForNull((String)hashMap.get("pat_cat_code"))));
            _bw.write(_wl_block439Bytes, _wl_block439);
}
            _bw.write(_wl_block440Bytes, _wl_block440);
}
						}
            _bw.write(_wl_block441Bytes, _wl_block441);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block442Bytes, _wl_block442);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block443Bytes, _wl_block443);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block444Bytes, _wl_block444);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block445Bytes, _wl_block445);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf((String) hashMap.get("q_indicator_mark")));
            _bw.write(_wl_block447Bytes, _wl_block447);
}
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(BDVallnew));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(mp_param_sysdate));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(mp_param_sysdate));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(cd1));
            _bw.write(_wl_block452Bytes, _wl_block452);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(call_function_id));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block455Bytes, _wl_block455);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block456Bytes, _wl_block456);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block457Bytes, _wl_block457);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block459Bytes, _wl_block459);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block460Bytes, _wl_block460);
if(!function_id.equals("REGISTER_NEWBORN")){
							if(checkForNull((String) hashMap.get("q_bba_yn")).equals("")){
            _bw.write(_wl_block461Bytes, _wl_block461);
}else{
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(((String) hashMap.get("q_bba_yn"))));
            _bw.write(_wl_block463Bytes, _wl_block463);
}
					  }
            _bw.write(_wl_block464Bytes, _wl_block464);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(newbornBornAt));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(ot_yn));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(rd_yn));
            _bw.write(_wl_block469Bytes, _wl_block469);
if(!function_id.equals("REGISTER_NEWBORN")){
					if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("")){
            _bw.write(_wl_block470Bytes, _wl_block470);
}else{
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(((String) hashMap.get("q_born_at_locn_type"))));
            _bw.write(_wl_block236Bytes, _wl_block236);
} }
            _bw.write(_wl_block472Bytes, _wl_block472);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);

						if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block476Bytes, _wl_block476);
 if(!checkForNull((String) hashMap.get("q_born_at_locn_code")).equals("")) {
							array_list.clear();
							if(((String) hashMap.get("q_born_at_locn_type")).equals("C")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"C",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("E")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"E",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("D")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"D",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("N")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"N",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("O")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"O",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("P")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"P",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("W")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"W",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("R")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"R",con,p);
							}
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull((String)hashMap.get("q_born_at_locn_code")).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						} 
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block477Bytes, _wl_block477);
if(!function_id.equals("REGISTER_NEWBORN")){
								if(checkForNull((String) hashMap.get("q_outcome")).equals("S")&&!checkForNull((String) hashMap.get("q_bba_yn")).equals("I")) 
								{
            _bw.write(_wl_block478Bytes, _wl_block478);
} 
						}
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block482Bytes, _wl_block482);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_Birth_place_code"))));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(checkForNull((String)hashMap.get("q_birth_place_desc"))));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block486Bytes, _wl_block486);
if(!function_id.equals("REGISTER_NEWBORN")){
                       if(((String) hashMap.get("q_outcome")).equals("S")) {
            _bw.write(_wl_block487Bytes, _wl_block487);
}
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf((String) hashMap.get("q_birth_cert_no")));
            _bw.write(_wl_block489Bytes, _wl_block489);
}
            _bw.write(_wl_block490Bytes, _wl_block490);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block491Bytes, _wl_block491);
sel1="";sel2="";if(unitofwtnb.equals("K")) sel1="selected"; else sel2="selected";
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(unitofwtnb));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(min_weight));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_weight));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block497Bytes, _wl_block497);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf((String) hashMap.get("q_weight")));
            _bw.write(_wl_block499Bytes, _wl_block499);
}
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block491Bytes, _wl_block491);
sel1="";sel2="";if(unitoflengthnb.equals("C")) sel1="selected"; else sel2="selected";
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(unitoflengthnb));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(min_length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_length));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block505Bytes, _wl_block505);
if(isRegNewbornApplicable){
            out.print( String.valueOf(headcircum_lengofBaby));
}else{
            out.print( String.valueOf(lengthofbaby));
}
            _bw.write(_wl_block506Bytes, _wl_block506);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf((String) hashMap.get("q_length")));
            _bw.write(_wl_block499Bytes, _wl_block499);
}
            _bw.write(_wl_block508Bytes, _wl_block508);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block491Bytes, _wl_block491);
sel1="";sel2="";if(unitofcircumnb.equals("C")) sel1="selected"; else sel2="selected";
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(unitofcircumnb));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(min_head_circum));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_head_circum));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block513Bytes, _wl_block513);
if(isRegNewbornApplicable){
            out.print( String.valueOf(headcircum_lengofBaby));
}else{
            out.print( String.valueOf(headcircumference));
}
            _bw.write(_wl_block514Bytes, _wl_block514);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_circumference"))));
            _bw.write(_wl_block516Bytes, _wl_block516);
}
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block491Bytes, _wl_block491);
sel1="";sel2="";if(unitofchestunit.equals("C")) sel1="selected"; else sel2="selected";
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(unitofchestunit));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(min_chest_circum));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_chest_circum));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block521Bytes, _wl_block521);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf((String) hashMap.get("q_chest_circumference")));
            _bw.write(_wl_block499Bytes, _wl_block499);
}
            _bw.write(_wl_block523Bytes, _wl_block523);

					String outcome_dis = "", outcome_disalbed = "";
					if(!function_id.equals("REGISTER_NEWBORN")) {
						outcome_dis = (String) hashMap.get("q_outcome")==null?"":(String)hashMap.get("q_outcome");
						if(((String)hashMap.get("q_bba_yn")).equals("I")){
					}else{
						outcome_disalbed="disabled";
					}
					} 						
					
					if(outcome_dis.equals("S") || (invoked_from.equals("details_page")&&regnStatus.equals("F"))){
						outcome_disalbed="disabled";
					}
					if(isRegNewbornApplicable && outcome_dis.equals("L")){ outcome_disalbed=""; }
					
            _bw.write(_wl_block524Bytes, _wl_block524);
            {java.lang.String __page ="../../eMP/jsp/NewbornRegistrationApgarScore.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id_apgarScore"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("mother_id"), weblogic.utils.StringUtils.valueOf(motherid
                        )},{ weblogic.utils.StringUtils.valueOf("invoked_from"), weblogic.utils.StringUtils.valueOf(invoked_from
                        )},{ weblogic.utils.StringUtils.valueOf("regnStatus"), weblogic.utils.StringUtils.valueOf(regnStatus
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block525Bytes, _wl_block525);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block527Bytes, _wl_block527);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block528Bytes, _wl_block528);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block529Bytes, _wl_block529);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_umbilical_cord_status"))));
            _bw.write(_wl_block531Bytes, _wl_block531);
}
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block532Bytes, _wl_block532);

					String umbvisiblemb="";
					if(function_id.equals("REGISTER_NEWBORN")){
						  umbvisiblemb="visible";
						  desc = "";
						  if(invoked_from!=null && invoked_from.equals("details_page")){
						  }else{
							  hashMap.put("q_Umb_cord_cut_by","");
							  hashMap.put("auth_practitioner_id","");
							  hashMap.put("attendant_at_birth","");
							  hashMap.put("autopsy_reqd_yn","");
							  hashMap.put("mate_cond_main_cod","");
							  hashMap.put("mate_cond_main_cod_dur","");
							  hashMap.put("mate_cond_oth_cod","");
							  hashMap.put("mate_cond_oth_cod_dur","");
							  hashMap.put("mate_cond_preexist_cod","");
							  hashMap.put("mate_cond_preexist_cod_dur","");
							  hashMap.put("oth_rel_mate_cond_rel_cod","");
							  hashMap.put("oth_rel_mate_cond_rel_cod_dur","");
							  hashMap.put("cond_cau_dea_main_cod","");
							  hashMap.put("cond_cau_dea_main_cod_dur","");
							  hashMap.put("cond_cau_dea_oth_cod","");
							  hashMap.put("cond_cau_dea_oth_cod_dur","");
							  hashMap.put("cond_cau_dea_preexist_cod","");
							  hashMap.put("cond_cau_dea_preexist_cod_dur","");
							  hashMap.put("rel_cond_cau_dea_rel_cod","");
							  hashMap.put("rel_cond_cau_dea_rel_cod_dur","");
						  }
					}else{
						
						if((checkForNull((String) hashMap.get("q_bba_yn"))).equals("I")) {
						   umbvisiblemb="visible"; 
						   desc = checkForNull((String) hashMap.get("q_umb_cord_cut_by_desc"));
						   String q_Umb_cord_cut_by_chk_len	= checkForNull((String) hashMap.get("q_Umb_cord_cut_by"));
						  if(!q_Umb_cord_cut_by_chk_len.equals("")){
							   if(((String) hashMap.get("q_Umb_cord_cut_by")).length() == 0) {
									desc = "";								
							   }
						  }
						}else{
                            umbvisiblemb="hidden";
							desc = checkForNull((String) hashMap.get("q_Umb_cord_cut_by"));
						}
					 }
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(umbvisiblemb));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_Umb_cord_cut_by"))));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_Umb_cord_cut_by"))));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(umbvisiblemb));
            _bw.write(_wl_block539Bytes, _wl_block539);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block541Bytes, _wl_block541);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block459Bytes, _wl_block459);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block542Bytes, _wl_block542);
if(!function_id.equals("REGISTER_NEWBORN")){
                       if(((String) hashMap.get("q_outcome")).equals("S")) {
            _bw.write(_wl_block543Bytes, _wl_block543);
}
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf((String) hashMap.get("q_feeding")));
            _bw.write(_wl_block545Bytes, _wl_block545);
}
					if(!function_id.equals("REGISTER_NEWBORN")){
							if(((String) hashMap.get("q_patency_of_anus_yn")).equals("Y")) 				patency_sel1="selected";
							else if (((String) hashMap.get("q_patency_of_anus_yn")).equals("N")) 
								patency_sel2 = "selected";
					 }
            _bw.write(_wl_block546Bytes, _wl_block546);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block548Bytes, _wl_block548);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(patency_sel1));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(patency_sel2));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block551Bytes, _wl_block551);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block554Bytes, _wl_block554);
 if(!function_id.equals("REGISTER_NEWBORN")){ 
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(cong_anom_desc));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_cong_anomalies_code"))));
            _bw.write(_wl_block557Bytes, _wl_block557);
}
            _bw.write(_wl_block558Bytes, _wl_block558);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(checkForNull((String) hashMap.get("patency_of_anus_checked_by_desc"))));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(checkForNull((String) hashMap.get("patency_of_anus_checked_by_id"))));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(checkForNull((String) hashMap.get("patency_of_anus_checked_by_id"))));
            _bw.write(_wl_block564Bytes, _wl_block564);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block566Bytes, _wl_block566);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block567Bytes, _wl_block567);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block568Bytes, _wl_block568);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(ca_foetus_comp_of_delivery_desc));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_foetus_comp_of_delivery.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!ca_foetus_comp_of_delivery.equals("")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(ca_foetus_comp_of_delivery));
            _bw.write(_wl_block226Bytes, _wl_block226);

						if(!function_id.equals("REGISTER_NEWBORN")){
							accession_no	= checkForNull((String) hashMap.get("q_accession_num"));
						}
					
            _bw.write(_wl_block573Bytes, _wl_block573);

					 if(isNeonatalApplicable){
            _bw.write(_wl_block574Bytes, _wl_block574);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block575Bytes, _wl_block575);
}
					
            _bw.write(_wl_block576Bytes, _wl_block576);
 if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(q_nb_compln_dely_desc));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(checkForNull((String )hashMap.get("q_complications_delivery_nb"))));
            _bw.write(_wl_block579Bytes, _wl_block579);
}
            _bw.write(_wl_block580Bytes, _wl_block580);
 if(!function_id.equals("REGISTER_NEWBORN")){
						if(((String) hashMap.get("q_outcome")).equals("S")) {
						
            _bw.write(_wl_block581Bytes, _wl_block581);
}
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(checkForNull((String) hashMap.get("q_stools"))));
            _bw.write(_wl_block583Bytes, _wl_block583);
}
						if (ip_install_yn.equals("Y") && called_function.equals("IP")) 
							{  
							
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(bed_label));
            _bw.write(_wl_block585Bytes, _wl_block585);
if(!function_id.equals("REGISTER_NEWBORN")){
								      if(!mother_bed_no.equals("")) {
											hashMap11 = eMP.NewbornDetails.getIPNursingUnitBedNO(facilityId, mother_bed_no, (String)hashMap.get("q_patient_id"), con);
											old_bed_number = checkForNull((String)hashMap11.get("old_bed_number"));
									}
                                      mother_nursing_unit=(String)hashMap10.get("mother_nursing_unit_code");
								}
								else
								 {
									hashMap10 = eMP.NewbornDetails.getIPOpenEncounter(facilityId,motherencounterid,con,p); 
									 pseudo_bed_yn=checkForNull((String)hashMap10.get("pseudo_bed_yn"),"N");
								}
																
								if(outcome.equals("S"))
									dis_bed_fields="disabled";
								else
									dis_bed_fields="";								
				
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(old_bed_number));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(hide_bedNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_bed_fields));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(hide_bedNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_bed_fields));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(old_bed_number));
            _bw.write(_wl_block593Bytes, _wl_block593);
}else{
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(old_bed_number));
            _bw.write(_wl_block597Bytes, _wl_block597);
}
            _bw.write(_wl_block598Bytes, _wl_block598);
if(isRegNewbornApplicable){
            _bw.write(_wl_block599Bytes, _wl_block599);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(checkForNull(resuscitated_pract_desc)));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(checkForNull(resuscitated_pract_id)));
            _bw.write(_wl_block602Bytes, _wl_block602);
if(!function_id.equals("REGISTER_NEWBORN")){
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(checkForNull((String) hashMap.get("resuscitated_pract_id"))));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(checkForNull((String) hashMap.get("resuscitated_pract_desc"))));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block607Bytes, _wl_block607);
}
			}
            _bw.write(_wl_block608Bytes, _wl_block608);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block609Bytes, _wl_block609);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block610Bytes, _wl_block610);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block610Bytes, _wl_block610);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block611Bytes, _wl_block611);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block612Bytes, _wl_block612);

				      String bcgselect="";
				      String bcgtxtvaccsite="";
				      String bcgtxtvaccdis="disabled";
				      String bcgselectvalue="N";
					  String bcgdesig="";
					  String bcgadmin="";
					  String bcgdatetime="";
					  String vitaminkselect="";
				      String vitaminktxtvaccsite="";
				      String vitaminktxtvaccdis="disabled";
				      String vitaminkselectvalue="N";
					  String vitaminkdesig="";
					  String vitaminkadmin="";
					  String vitaminkdatetime="";
					  String Hepatitisselect="";
				      String Hepatitistxtvaccsite="";
				      String Hepatitistxtvaccdis="disabled";
				      String Hepatitisselectvalue="N";
					  String Hepatitisdesig="";
					  String Hepatitisadmin="";
					  String Hepatitisdatetime="";
				      if(!function_id.equals("REGISTER_NEWBORN"))
					  {
						  if(((String)      hashMap.get("q_bcg_given_yn")).equals("Y")) {
						   bcgselect="checked";
						   bcgselectvalue="Y";
						   bcgtxtvaccsite=(String) hashMap.get("q_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
						         bcgtxtvaccdis="";
						   bcgadmin=(String) hashMap.get("q_administered_by");
						   bcgdesig=(String) hashMap.get("q_administered_designation");
						   bcgdatetime=(String) hashMap.get("q_bcg_datetime");
						   bcgdatetime=DateUtils.convertDate(bcgdatetime,"DMYHM","en",localeName);
						 }
						 if(((String) hashMap.get("q_vitak_given_yn")).equals("Y")) {		
						   vitaminkselect="checked";
						   vitaminkselectvalue="Y";
						   vitaminktxtvaccsite=(String) hashMap.get("q_vitak_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
								vitaminktxtvaccdis="";
						   vitaminkadmin=(String) hashMap.get("q_vitak_administered_by");
						   vitaminkdesig=(String) hashMap.get("q_vitak_administered_designation");
						   vitaminkdatetime=(String) hashMap.get("q_vitk_datetime");
						   vitaminkdatetime=DateUtils.convertDate(vitaminkdatetime,"DMYHM","en",localeName);
						 }
						 if(((String) hashMap.get("q_hep_given_yn")).equals("Y")) {
						   Hepatitisselect="checked";
						   Hepatitisselectvalue="Y";
						   Hepatitistxtvaccsite=(String) hashMap.get("q_hepb_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
								Hepatitistxtvaccdis="";
						   Hepatitisadmin=(String) hashMap.get("q_hepb_administered_by");
						   Hepatitisdesig=(String) hashMap.get("q_hepb_administered_designation");
						   Hepatitisdatetime=(String) hashMap.get("q_hepb_datetime");
						   Hepatitisdatetime=DateUtils.convertDate(Hepatitisdatetime,"DMYHM","en",localeName);
						 }
						 
						}
				
            _bw.write(_wl_block613Bytes, _wl_block613);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(bcgselect));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(bcgselectvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(bcgselect));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(bcgtxtvaccsite));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(bcgadmin));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(bcgdesig));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf(bcgdatetime));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block625Bytes, _wl_block625);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(vitaminkselectvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(vitaminkselect));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(vitaminktxtvaccsite));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(vitaminktxtvaccdis));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(vitaminkadmin));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(vitaminktxtvaccdis));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(vitaminkdesig));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(vitaminktxtvaccdis));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(vitaminkdatetime));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(vitaminktxtvaccdis));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block632Bytes, _wl_block632);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(Hepatitisselectvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Hepatitisselect));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(Hepatitistxtvaccsite));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Hepatitistxtvaccdis));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(Hepatitisadmin));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Hepatitistxtvaccdis));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(Hepatitisdesig));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Hepatitistxtvaccdis));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(Hepatitisdatetime));
            _bw.write(_wl_block638Bytes, _wl_block638);
            out.print( String.valueOf(Hepatitistxtvaccdis));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(bcgtxtvaccdis));
            _bw.write(_wl_block640Bytes, _wl_block640);
if(!entitlement_by_pat_cat_yn.equals("Y") || !FAMILY_ORG_ID_ACCEPT_YN.equals("Y")){
            _bw.write(_wl_block641Bytes, _wl_block641);
}
            _bw.write(_wl_block642Bytes, _wl_block642);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(dis_all_flds));
            _bw.write(_wl_block644Bytes, _wl_block644);
 if(!function_id.equals("REGISTER_NEWBORN"))
			  {
					if(((String) hashMap.get("q_outcome")).equals("S")) {
            _bw.write(_wl_block645Bytes, _wl_block645);
 }
			 }
            _bw.write(_wl_block646Bytes, _wl_block646);
if(function_id.equals("REGISTER_NEWBORN")){
				if(!(checkForNull((String) hashMap.get("q_father_patient_id"))).equals("") || !(checkForNull((String) hashMap.get("q_father_name"))).equals("")) 
		        { 
            _bw.write(_wl_block647Bytes, _wl_block647);
}
			}
            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(checkForNull((String) mPParamDtls.get("maintain_doc_or_file"),"F")));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block650Bytes, _wl_block650);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block651Bytes, _wl_block651);
            out.print( String.valueOf(family_org_sub_id));
            _bw.write(_wl_block652Bytes, _wl_block652);
            out.print( String.valueOf(family_org_id));
            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf(family_org_membership));
            _bw.write(_wl_block654Bytes, _wl_block654);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block655Bytes, _wl_block655);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("family_org_id_accept_yn"))));
            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("family_no_link_yn"))));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(family_link_no));
            _bw.write(_wl_block658Bytes, _wl_block658);
            out.print( String.valueOf(child_mandatory));
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(cat_mandatory));
            _bw.write(_wl_block660Bytes, _wl_block660);
            out.print( String.valueOf(nb_male_relnship));
            _bw.write(_wl_block661Bytes, _wl_block661);
            out.print( String.valueOf(nb_female_relnship));
            _bw.write(_wl_block662Bytes, _wl_block662);
            out.print( String.valueOf(nb_unknown_relnship));
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(namesuffixmalenb));
            _bw.write(_wl_block664Bytes, _wl_block664);
            out.print( String.valueOf(namesuffixfemalenb));
            _bw.write(_wl_block665Bytes, _wl_block665);
if(new_function_id.equals("REGISTER_NEWBORN") && !invoked_from.equals("servlet")){ 
            _bw.write(_wl_block666Bytes, _wl_block666);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block667Bytes, _wl_block667);
}
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(motherencounterid));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(accession_no));
            _bw.write(_wl_block670Bytes, _wl_block670);
            out.print( String.valueOf(isNeonatalApplicable));
            _bw.write(_wl_block671Bytes, _wl_block671);
            out.print( String.valueOf(single_stage_appl_yn));
            _bw.write(_wl_block672Bytes, _wl_block672);
            out.print( String.valueOf(modify_delivery_type));
            _bw.write(_wl_block673Bytes, _wl_block673);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block674Bytes, _wl_block674);
            out.print( String.valueOf(tm));
            _bw.write(_wl_block675Bytes, _wl_block675);
            out.print( String.valueOf(cd2));
            _bw.write(_wl_block676Bytes, _wl_block676);
            out.print( String.valueOf(patient_idlength));
            _bw.write(_wl_block677Bytes, _wl_block677);
            out.print( String.valueOf(function_id1));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block679Bytes, _wl_block679);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block680Bytes, _wl_block680);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block681Bytes, _wl_block681);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block682Bytes, _wl_block682);
            out.print( String.valueOf(min_weight));
            _bw.write(_wl_block683Bytes, _wl_block683);
            out.print( String.valueOf(max_weight));
            _bw.write(_wl_block684Bytes, _wl_block684);
            out.print( String.valueOf(min_length));
            _bw.write(_wl_block685Bytes, _wl_block685);
            out.print( String.valueOf(max_length));
            _bw.write(_wl_block686Bytes, _wl_block686);
            out.print( String.valueOf(min_head_circum));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(max_head_circum));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(min_chest_circum));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(max_chest_circum));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(min_gestation));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(max_gestation));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(page_show));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(page_colour));
            _bw.write(_wl_block694Bytes, _wl_block694);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(q_no_of_birth));
            _bw.write(_wl_block696Bytes, _wl_block696);
            out.print( String.valueOf(DateUtils.convertDate(getAllowNewBornDate,"DMYHM","en",localeName)));
            _bw.write(_wl_block697Bytes, _wl_block697);
            out.print( String.valueOf(DateUtils.convertDate(mp_param_sysdate,"DMYHM","en",localeName)));
            _bw.write(_wl_block698Bytes, _wl_block698);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block699Bytes, _wl_block699);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block700Bytes, _wl_block700);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block702Bytes, _wl_block702);
            out.print( String.valueOf(called_function));
            _bw.write(_wl_block703Bytes, _wl_block703);
            out.print( String.valueOf(functname_sev));
            _bw.write(_wl_block704Bytes, _wl_block704);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block705Bytes, _wl_block705);
            out.print( String.valueOf(dflt_nb_regn_blng_class));
            _bw.write(_wl_block706Bytes, _wl_block706);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block707Bytes, _wl_block707);
            out.print( String.valueOf(parent_details1));
            _bw.write(_wl_block708Bytes, _wl_block708);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("q_mother_date_of_birth"))));
            _bw.write(_wl_block709Bytes, _wl_block709);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block710Bytes, _wl_block710);
            out.print( String.valueOf((String) hashMap.get("proc_class_long_desc")));
            _bw.write(_wl_block711Bytes, _wl_block711);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block712Bytes, _wl_block712);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block713Bytes, _wl_block713);
            out.print( String.valueOf(captureAntenatalDtlsYN));
            _bw.write(_wl_block714Bytes, _wl_block714);
            out.print( String.valueOf(name_dervn_logic));
            _bw.write(_wl_block715Bytes, _wl_block715);
            out.print( String.valueOf(name_dervn_logic_long));
            _bw.write(_wl_block716Bytes, _wl_block716);
            out.print( String.valueOf(name_dervn_logic_oth_lang));
            _bw.write(_wl_block717Bytes, _wl_block717);
            out.print( String.valueOf(name_dervn_logic_oth_lang_long));
            _bw.write(_wl_block718Bytes, _wl_block718);
            out.print( String.valueOf(First_Name_Accept_Yn));
            _bw.write(_wl_block719Bytes, _wl_block719);
            out.print( String.valueOf(Second_Name_Accept_Yn));
            _bw.write(_wl_block720Bytes, _wl_block720);
            out.print( String.valueOf(Third_Name_Accept_Yn));
            _bw.write(_wl_block721Bytes, _wl_block721);
            out.print( String.valueOf(Family_Name_Accept_Yn));
            _bw.write(_wl_block722Bytes, _wl_block722);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block723Bytes, _wl_block723);
            out.print( String.valueOf(generate_file));
            _bw.write(_wl_block724Bytes, _wl_block724);
            out.print( String.valueOf(disable_finalized_button_yn));
            _bw.write(_wl_block725Bytes, _wl_block725);
            out.print( String.valueOf(q_father_patient_name_loc_lang));
            _bw.write(_wl_block726Bytes, _wl_block726);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block727Bytes, _wl_block727);
            out.print( String.valueOf(accept_names_for_live_birth_yn));
            _bw.write(_wl_block728Bytes, _wl_block728);
            out.print( String.valueOf((String)(hashMap.get("auth_practitioner_id")==null?"":hashMap.get("auth_practitioner_id"))));
            _bw.write(_wl_block729Bytes, _wl_block729);
            out.print( String.valueOf((String)(hashMap.get("attendant_at_birth")==null?"":hashMap.get("attendant_at_birth"))));
            _bw.write(_wl_block730Bytes, _wl_block730);
            out.print( String.valueOf((String)(hashMap.get("autopsy_reqd_yn")==null?"":hashMap.get("autopsy_reqd_yn"))));
            _bw.write(_wl_block731Bytes, _wl_block731);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_main_cod")==null?"":hashMap.get("mate_cond_main_cod"))));
            _bw.write(_wl_block732Bytes, _wl_block732);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_main_cod_dur")==null?"":hashMap.get("mate_cond_main_cod_dur"))));
            _bw.write(_wl_block733Bytes, _wl_block733);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_oth_cod")==null?"":hashMap.get("mate_cond_oth_cod"))));
            _bw.write(_wl_block734Bytes, _wl_block734);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_oth_cod_dur")==null?"":hashMap.get("mate_cond_oth_cod_dur"))));
            _bw.write(_wl_block735Bytes, _wl_block735);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_preexist_cod")==null?"":hashMap.get("mate_cond_preexist_cod"))));
            _bw.write(_wl_block736Bytes, _wl_block736);
            out.print( String.valueOf((String)(hashMap.get("mate_cond_preexist_cod_dur")==null?"":hashMap.get("mate_cond_preexist_cod_dur"))));
            _bw.write(_wl_block737Bytes, _wl_block737);
            out.print( String.valueOf((String)(hashMap.get("oth_rel_mate_cond_rel_cod")==null?"":hashMap.get("oth_rel_mate_cond_rel_cod"))));
            _bw.write(_wl_block738Bytes, _wl_block738);
            out.print( String.valueOf((String)(hashMap.get("oth_rel_mate_cond_rel_cod_dur")==null?"":hashMap.get("oth_rel_mate_cond_rel_cod_dur"))));
            _bw.write(_wl_block739Bytes, _wl_block739);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_main_cod")==null?"":hashMap.get("cond_cau_dea_main_cod"))));
            _bw.write(_wl_block740Bytes, _wl_block740);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_main_cod_dur")==null?"":hashMap.get("cond_cau_dea_main_cod_dur"))));
            _bw.write(_wl_block741Bytes, _wl_block741);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_oth_cod")==null?"":hashMap.get("cond_cau_dea_oth_cod"))));
            _bw.write(_wl_block742Bytes, _wl_block742);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_oth_cod_dur")==null?"":hashMap.get("cond_cau_dea_oth_cod_dur"))));
            _bw.write(_wl_block743Bytes, _wl_block743);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_preexist_cod")==null?"":hashMap.get("cond_cau_dea_preexist_cod"))));
            _bw.write(_wl_block744Bytes, _wl_block744);
            out.print( String.valueOf((String)(hashMap.get("cond_cau_dea_preexist_cod_dur")==null?"":hashMap.get("cond_cau_dea_preexist_cod_dur"))));
            _bw.write(_wl_block745Bytes, _wl_block745);
            out.print( String.valueOf((String)(hashMap.get("rel_cond_cau_dea_rel_cod")==null?"":hashMap.get("rel_cond_cau_dea_rel_cod"))));
            _bw.write(_wl_block746Bytes, _wl_block746);
            out.print( String.valueOf((String)(hashMap.get("rel_cond_cau_dea_rel_cod_dur")==null?"":hashMap.get("rel_cond_cau_dea_rel_cod_dur"))));
            _bw.write(_wl_block747Bytes, _wl_block747);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block748Bytes, _wl_block748);
            out.print( String.valueOf(data_upd_allowed_aft_final_yn));
            _bw.write(_wl_block749Bytes, _wl_block749);
            out.print( String.valueOf(q_finalized_yn));
            _bw.write(_wl_block750Bytes, _wl_block750);
            out.print( String.valueOf((String)(hashMap.get("q_indicator_mark")==null?"":hashMap.get("q_indicator_mark"))));
            _bw.write(_wl_block751Bytes, _wl_block751);
            out.print( String.valueOf(name_prefix_male_nb));
            _bw.write(_wl_block752Bytes, _wl_block752);
            out.print( String.valueOf(name_prefix_female_nb));
            _bw.write(_wl_block753Bytes, _wl_block753);
            out.print( String.valueOf(name_prefix_unknown_nb));
            _bw.write(_wl_block754Bytes, _wl_block754);
            out.print( String.valueOf(name_suffix_male_nb));
            _bw.write(_wl_block755Bytes, _wl_block755);
            out.print( String.valueOf(name_suffix_female_nb));
            _bw.write(_wl_block756Bytes, _wl_block756);
            out.print( String.valueOf(name_pfx_loc_lang_male_nb));
            _bw.write(_wl_block757Bytes, _wl_block757);
            out.print( String.valueOf(name_pfx_loc_lang_female_nb));
            _bw.write(_wl_block758Bytes, _wl_block758);
            out.print( String.valueOf(name_pfx_loc_lang_unknown_nb));
            _bw.write(_wl_block759Bytes, _wl_block759);
            out.print( String.valueOf(name_sfx_loc_lang_male_nb));
            _bw.write(_wl_block760Bytes, _wl_block760);
            out.print( String.valueOf(name_sfx_loc_lang_female_nb));
            _bw.write(_wl_block761Bytes, _wl_block761);
            out.print( String.valueOf(single_stage_nb_reg_appl_yn));
            _bw.write(_wl_block762Bytes, _wl_block762);
            out.print( String.valueOf(ca_comp_in_del_stage1));
            _bw.write(_wl_block763Bytes, _wl_block763);
            out.print( String.valueOf(ca_comp_in_del_stage2));
            _bw.write(_wl_block764Bytes, _wl_block764);
            out.print( String.valueOf(ca_comp_in_del_stage3));
            _bw.write(_wl_block765Bytes, _wl_block765);
            out.print( String.valueOf(ca_comp_of_delivery));
            _bw.write(_wl_block766Bytes, _wl_block766);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block767Bytes, _wl_block767);
            out.print( String.valueOf(MC_Dtls_YN));
            _bw.write(_wl_block768Bytes, _wl_block768);
            out.print( String.valueOf(lmp_ca));
            _bw.write(_wl_block769Bytes, _wl_block769);
            out.print( String.valueOf(mc_cycle_no));
            _bw.write(_wl_block770Bytes, _wl_block770);
            out.print( String.valueOf(nb_father_min_age));
            _bw.write(_wl_block771Bytes, _wl_block771);
            out.print( String.valueOf(newborn_pat_ser_grp));
            _bw.write(_wl_block772Bytes, _wl_block772);
            out.print( String.valueOf(allow_ext_nb_regn_within_days));
            _bw.write(_wl_block773Bytes, _wl_block773);
            out.print( String.valueOf(isAllow_External_Newborn));
            _bw.write(_wl_block774Bytes, _wl_block774);
            out.print( String.valueOf(nb_dflt_relnship_code));
            _bw.write(_wl_block775Bytes, _wl_block775);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block776Bytes, _wl_block776);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_alt_id1_no"))));
            _bw.write(_wl_block777Bytes, _wl_block777);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_alt_id2_no"))));
            _bw.write(_wl_block778Bytes, _wl_block778);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_alt_id3_no"))));
            _bw.write(_wl_block779Bytes, _wl_block779);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_alt_id4_no"))));
            _bw.write(_wl_block780Bytes, _wl_block780);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("alt_id1_type"))));
            _bw.write(_wl_block781Bytes, _wl_block781);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("alt_id2_type"))));
            _bw.write(_wl_block782Bytes, _wl_block782);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("alt_id3_type"))));
            _bw.write(_wl_block783Bytes, _wl_block783);
            out.print( String.valueOf(checkForNull((String)mPParamDtls.get("alt_id4_type"))));
            _bw.write(_wl_block784Bytes, _wl_block784);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_nat_id_no"))));
            _bw.write(_wl_block785Bytes, _wl_block785);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_oth_alt_id_No"))));
            _bw.write(_wl_block786Bytes, _wl_block786);
            out.print( String.valueOf(checkForNull((String) mthrDtls.get("mthr_oth_alt_id_type"))));
            _bw.write(_wl_block787Bytes, _wl_block787);
            out.print( String.valueOf(still_born_prefix));
            _bw.write(_wl_block788Bytes, _wl_block788);
            out.print( String.valueOf(dflt_race_nat_setup));
            _bw.write(_wl_block789Bytes, _wl_block789);
            out.print( String.valueOf(citizen_nationality_code));
            _bw.write(_wl_block790Bytes, _wl_block790);
            out.print( String.valueOf(default_race_code));
            _bw.write(_wl_block791Bytes, _wl_block791);
            out.print( String.valueOf(nb_mother_dtls_update_yn));
            _bw.write(_wl_block792Bytes, _wl_block792);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block793Bytes, _wl_block793);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block794Bytes, _wl_block794);
            out.print( String.valueOf(finalizeYN));
            _bw.write(_wl_block795Bytes, _wl_block795);
            out.print( String.valueOf(multibirthvalue));
            _bw.write(_wl_block796Bytes, _wl_block796);
            out.print( String.valueOf(regnStatus));
            _bw.write(_wl_block797Bytes, _wl_block797);
            out.print( String.valueOf(birth_order_format));
            _bw.write(_wl_block798Bytes, _wl_block798);
            out.print( String.valueOf(isLabelChangeApplicable));
            _bw.write(_wl_block799Bytes, _wl_block799);
            out.print( String.valueOf(isRegNewbornApplicable));
            _bw.write(_wl_block800Bytes, _wl_block800);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block801Bytes, _wl_block801);
            out.print( String.valueOf(cd3));
            _bw.write(_wl_block802Bytes, _wl_block802);
            out.print( String.valueOf(newborn_birth_order));
            _bw.write(_wl_block803Bytes, _wl_block803);
            out.print( String.valueOf(emer_regn_nb_yn));
            _bw.write(_wl_block804Bytes, _wl_block804);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block805Bytes, _wl_block805);
            out.print( String.valueOf(length_of_baby_yn));
            _bw.write(_wl_block806Bytes, _wl_block806);
            out.print( String.valueOf(head_circumference_of_baby_yn));
            _bw.write(_wl_block807Bytes, _wl_block807);
            out.print( String.valueOf(isMPMandatoryFieldsNewborn));
            _bw.write(_wl_block808Bytes, _wl_block808);
            out.print( String.valueOf(mandate_first_newborn_ip_yn));
            _bw.write(_wl_block809Bytes, _wl_block809);
            out.print( String.valueOf(mandate_second_newborn_ip_yn));
            _bw.write(_wl_block810Bytes, _wl_block810);
            out.print( String.valueOf(mandate_third_newborn_ip_yn));
            _bw.write(_wl_block811Bytes, _wl_block811);
            out.print( String.valueOf(mand_antenatal_newborn_ip_yn));
            _bw.write(_wl_block812Bytes, _wl_block812);
            out.print( String.valueOf(mandate_first_newborn_yn));
            _bw.write(_wl_block813Bytes, _wl_block813);
            out.print( String.valueOf(mandate_second_newborn_yn));
            _bw.write(_wl_block814Bytes, _wl_block814);
            out.print( String.valueOf(mandate_third_newborn_yn));
            _bw.write(_wl_block815Bytes, _wl_block815);
            out.print( String.valueOf(mand_antenatal_newborn_yn));
            _bw.write(_wl_block816Bytes, _wl_block816);
            out.print( String.valueOf(mandate_first_newborn_ae_yn));
            _bw.write(_wl_block817Bytes, _wl_block817);
            out.print( String.valueOf(mandate_second_newborn_ae_yn));
            _bw.write(_wl_block818Bytes, _wl_block818);
            out.print( String.valueOf(mandate_third_newborn_ae_yn));
            _bw.write(_wl_block819Bytes, _wl_block819);
            out.print( String.valueOf(mand_antenatal_newborn_ae_yn));
            _bw.write(_wl_block820Bytes, _wl_block820);
            out.print( String.valueOf(emer_regn_nb));
            _bw.write(_wl_block821Bytes, _wl_block821);
            out.print( String.valueOf(ip_regn_nb_yn));
            _bw.write(_wl_block822Bytes, _wl_block822);
            out.print( String.valueOf(mp_regn_nb_yn));
            _bw.write(_wl_block823Bytes, _wl_block823);
            out.print( String.valueOf(dflt_father_first_name_prompt));
            _bw.write(_wl_block824Bytes, _wl_block824);
            out.print( String.valueOf(dflt_father_Second_name_prompt));
            _bw.write(_wl_block825Bytes, _wl_block825);
            out.print( String.valueOf(dflt_father_third_name_prompt));
            _bw.write(_wl_block826Bytes, _wl_block826);
            out.print( String.valueOf(dflt_father_family_name_prompt));
            _bw.write(_wl_block827Bytes, _wl_block827);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block828Bytes, _wl_block828);
            out.print( String.valueOf(First_Name_Reqd_Yn));
            _bw.write(_wl_block829Bytes, _wl_block829);
            out.print( String.valueOf(Second_Name_Reqd_Yn));
            _bw.write(_wl_block830Bytes, _wl_block830);
            out.print( String.valueOf(Third_Name_Reqd_Yn));
            _bw.write(_wl_block831Bytes, _wl_block831);
            out.print( String.valueOf(Family_Name_Reqd_Yn));
            _bw.write(_wl_block832Bytes, _wl_block832);
            out.print( String.valueOf(Name_Prefix_Accept_Yn));
            _bw.write(_wl_block833Bytes, _wl_block833);
            out.print( String.valueOf(Name_Prefix_Reqd_Yn));
            _bw.write(_wl_block834Bytes, _wl_block834);
            out.print( String.valueOf(Name_Suffix_Accept_Yn));
            _bw.write(_wl_block835Bytes, _wl_block835);
            out.print( String.valueOf(Name_Suffix_Reqd_Yn));
            _bw.write(_wl_block836Bytes, _wl_block836);
            out.print( String.valueOf(mpDisableFieldsNBFather));
            _bw.write(_wl_block837Bytes, _wl_block837);
            out.print( String.valueOf(nb_father_name_mandatory_yn));
            _bw.write(_wl_block838Bytes, _wl_block838);
            out.print( String.valueOf(enable_marital_status));
            _bw.write(_wl_block839Bytes, _wl_block839);
            out.print( String.valueOf(invokeMenstrualHistYN));
            _bw.write(_wl_block840Bytes, _wl_block840);
            out.print( String.valueOf(mandParityNewBornYN));
            _bw.write(_wl_block841Bytes, _wl_block841);
            out.print( String.valueOf(mandParityNewBornAE_YN));
            _bw.write(_wl_block842Bytes, _wl_block842);
            out.print( String.valueOf(mandParityNewBornIP_YN));
            _bw.write(_wl_block843Bytes, _wl_block843);
            out.print( String.valueOf(isModifyLongShortDescAppl));
            _bw.write(_wl_block844Bytes, _wl_block844);
            out.print( String.valueOf(isNameDervnLogicNBAppl));
            _bw.write(_wl_block845Bytes, _wl_block845);
            out.print( String.valueOf(checkForNull((String)hashMap.get("accession_num_nb_note"))));
            _bw.write(_wl_block846Bytes, _wl_block846);
if(q_finalized_yn.equals("Y") && "N".equals(data_upd_allowed_aft_final_yn) && isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id) && checkForNull((String)hashMap.get("accession_num_nb_note")).equals("")){
            _bw.write(_wl_block847Bytes, _wl_block847);
}
            _bw.write(_wl_block848Bytes, _wl_block848);
 if(invoked_from.equals("details_page") && regnStatus.equals("R") && finalizeYN.equals("Y")) {
					out.println("<script>if(document.forms[0].nod_type){enDisCompls(document.forms[0].nod_type.value,'N')}</script>");
				} 
            _bw.write(_wl_block59Bytes, _wl_block59);
if(single_stage_nb_reg_appl_yn.equals("Y")) {
            _bw.write(_wl_block849Bytes, _wl_block849);
} else if(single_stage_nb_reg_appl_yn.equals("N")) {
            _bw.write(_wl_block850Bytes, _wl_block850);
            out.print( String.valueOf(finalizeYN));
            _bw.write(_wl_block851Bytes, _wl_block851);
}
            _bw.write(_wl_block852Bytes, _wl_block852);
if(invoked_from.equals("details_page") && regnStatus.equals("R") && finalizeYN.equals("Y")) {
            _bw.write(_wl_block853Bytes, _wl_block853);
} else {
            _bw.write(_wl_block854Bytes, _wl_block854);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
if(!function_id.equals("REGISTER_NEWBORN")){	
            _bw.write(_wl_block855Bytes, _wl_block855);
            out.print( String.valueOf(relation_mcode));
            _bw.write(_wl_block856Bytes, _wl_block856);
}
            _bw.write(_wl_block857Bytes, _wl_block857);
            out.print( String.valueOf(nb_mother_dtls_update_yn));
            _bw.write(_wl_block858Bytes, _wl_block858);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block859Bytes, _wl_block859);
            out.print( String.valueOf(finalized_mult_birth_yn));
            _bw.write(_wl_block860Bytes, _wl_block860);
            out.print( String.valueOf(nb_mother_dtls_update_yn));
            _bw.write(_wl_block861Bytes, _wl_block861);
            out.print( String.valueOf(finalizeYN));
            _bw.write(_wl_block862Bytes, _wl_block862);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block863Bytes, _wl_block863);
            out.print( String.valueOf(regnStatus));
            _bw.write(_wl_block864Bytes, _wl_block864);
            out.print( String.valueOf(function_id1));
            _bw.write(_wl_block865Bytes, _wl_block865);
 if(called_function.equals("IP") || called_function.equals("AE")) { 
            _bw.write(_wl_block866Bytes, _wl_block866);
 } 
            _bw.write(_wl_block867Bytes, _wl_block867);

			if(function_id.equals("MAINTAIN_BIRTH") && !invoked_from.equals("details_page")) {
				String pat_ser_grp_code = checkForNull((String)hashMap.get("q_pat_ser_grp_code"));
				String pat_ser_grp_desc = checkForNull((String)hashMap.get("q_pat_ser_grp_desc"));
				
            _bw.write(_wl_block868Bytes, _wl_block868);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block869Bytes, _wl_block869);
            out.print( String.valueOf(pat_ser_grp_desc));
            _bw.write(_wl_block870Bytes, _wl_block870);

			}
			
            _bw.write(_wl_block871Bytes, _wl_block871);
				
					column_name  = CommonBean.getFunctionFieldRestriction(con, "MP","NEWBORN_REG","MP_BIRTH_REGISTER","Y","Y"); 
					Iterator itr = column_name.iterator();
					while(itr.hasNext()){	
					field_name=(String)itr.next();
					
					if(field_name.equals("PATENCY_OF_ANUS_YN")){
						out.println("document.getElementById('patency_visibility').value='Y';");
						out.println("eval(document.getElementById(field_name+'_IMG')).style.visibility = 'visible'");
					}else if(field_name.equals("APGAR_SCORE_IN_5_MINS_YN")){
						out.println("document.getElementById('apgar5_visibility').value='Y';");
						out.println("eval(document.getElementById('" + field_name + "_IMG')).style.visibility = 'visible'");
					}else if(field_name.equals("APGAR_SCORE_IN_10_MINS_YN")){
						out.println("document.getElementById('apgar10_visibility').value='Y';");
						out.println("eval(document.getElementById(field_name+'_IMG').style.visibility = 'visible'");
					}
					
					}
			if(!function_id.equals("REGISTER_NEWBORN")) {
				//Santhosh added for ML-MMOH-CRF-1895
				if(function_id.equals("MAINTAIN_BIRTH") && isApgarScoreMinsAppl){
					
					out.println("document.getElementById('apgar5_visibility').value='Y';");
					out.println("document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility = 'visible'");
					if(((String) hashMap.get("q_outcome")).equals("S")){
						out.println("document.getElementById('apg').style.visibility	= 'hidden';");
						out.println("document.getElementById('apg').innerHTML	= ''; ");								
						out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
						out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");

						out.println("document.forms[0].patency_of_anus_yn.disabled	= true;					document.forms[0].patency_of_anus_yn.options[0].selected = true;");
						out.println("if(document.getElementById('PATENCY_OF_ANUS_YN_IMG'))						document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';");
					}
					//Santhosh End
				}else if(((String) hashMap.get("q_outcome")).equals("S")||!((String) hashMap.get("q_bba_yn")).equals("I")) {	
					
					out.println("document.getElementById('apg').style.visibility	= 'hidden';");
					
					out.println("document.getElementById('apg').innerHTML	= ''; ");
					out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
					out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");
					
					out.println("document.forms[0].patency_of_anus_yn.disabled	= true;					document.forms[0].patency_of_anus_yn.options[0].selected = true;");
					out.println("if(document.getElementById('PATENCY_OF_ANUS_YN_IMG'))						document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';");
				}
				
			} else if(function_id.equals("REGISTER_NEWBORN") && isApgarScoreMinsAppl){
				//Santhosh added for ML-MMOH-CRF-1895
				out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
					out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");
			}
			//Santhosh End
			if(rs1!=null)
				rs1.close();
			if(stmt!=null)
				stmt.close();
		
            _bw.write(_wl_block872Bytes, _wl_block872);
            out.print( String.valueOf(isRegNewbornApplicable));
            _bw.write(_wl_block873Bytes, _wl_block873);
            out.print( String.valueOf(isRegNewbornApplicable));
            _bw.write(_wl_block874Bytes, _wl_block874);
            out.print( String.valueOf(newbornReg));
            _bw.write(_wl_block875Bytes, _wl_block875);
            out.print( String.valueOf(newbornReg));
            _bw.write(_wl_block876Bytes, _wl_block876);

		array_list.clear();
		hashMap3.clear();
		hashMap10.clear();hashMap11.clear();hashMap12.clear();hashMap13.clear();
	}
	catch(Exception e)
	{
		//out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherdetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewPatChartSummary.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothers.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothers.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewPatChartSummary.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MultipleBirth.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoofBirths.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gestation.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryType.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GravidaOnAdmission.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gravida.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ParityOnAdmission.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Parity.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConductedBy.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AssistedBy.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AttendingNurse.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WitnessedBy1.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WitnessedBy2.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsRelatedPregnancy.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsNotRelatedPregnancy.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin1stStage.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin2ndStage.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicationsForOperativeDelivery.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryIndication.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin2ndStage.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin3rdStage.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OperativeComplications.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CompofDelivery.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicationsForOperativeDelivery.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryIndication.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin3rdStage.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ProcedureClassification.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaginalDeliveryType.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgClass.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgicalClassification.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AnteNatalCare.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.given.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AnteNatalCare.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.given.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.inhospital.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.externalhospital.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DaycareUnit.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Alive.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fatherdetails.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GovtEmployee.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.newborndetails.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Birth.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Hijri.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RHDFactor.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.prefix.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Alive.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Live.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.StillBorn.option.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mother.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.child.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicatorMark.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Fresh.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Macerated.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornWhere.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InFacility.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.home.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Ambulance.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherModesofTpt.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornBeforeArrival.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Bornat.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthCertificateNo.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }

    private boolean _jsp__tag128(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag128 = null ;
        int __result__tag128 = 0 ;

        if (__tag128 == null ){
            __tag128 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag128);
        }
        __tag128.setPageContext(pageContext);
        __tag128.setParent(null);
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthWeight.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag128;
        __result__tag128 = __tag128.doStartTag();

        if (__result__tag128!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag128== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag128.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag128);
            return true;
        }
        _activeTag=__tag128.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag128);
        __tag128.release();
        return false;
    }

    private boolean _jsp__tag129(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag129 = null ;
        int __result__tag129 = 0 ;

        if (__tag129 == null ){
            __tag129 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag129);
        }
        __tag129.setPageContext(pageContext);
        __tag129.setParent(null);
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.kg.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag129;
        __result__tag129 = __tag129.doStartTag();

        if (__result__tag129!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag129== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag129.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag129);
            return true;
        }
        _activeTag=__tag129.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag129);
        __tag129.release();
        return false;
    }

    private boolean _jsp__tag130(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
        int __result__tag130 = 0 ;

        if (__tag130 == null ){
            __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
        }
        __tag130.setPageContext(pageContext);
        __tag130.setParent(null);
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.lb.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag130;
        __result__tag130 = __tag130.doStartTag();

        if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag130);
            return true;
        }
        _activeTag=__tag130.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
        __tag130.release();
        return false;
    }

    private boolean _jsp__tag131(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
        int __result__tag131 = 0 ;

        if (__tag131 == null ){
            __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
        }
        __tag131.setPageContext(pageContext);
        __tag131.setParent(null);
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LengthofBaby.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag131;
        __result__tag131 = __tag131.doStartTag();

        if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag131);
            return true;
        }
        _activeTag=__tag131.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
        __tag131.release();
        return false;
    }

    private boolean _jsp__tag132(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag132 = null ;
        int __result__tag132 = 0 ;

        if (__tag132 == null ){
            __tag132 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag132);
        }
        __tag132.setPageContext(pageContext);
        __tag132.setParent(null);
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag132;
        __result__tag132 = __tag132.doStartTag();

        if (__result__tag132!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag132== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag132.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag132);
            return true;
        }
        _activeTag=__tag132.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag132);
        __tag132.release();
        return false;
    }

    private boolean _jsp__tag133(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag133 = null ;
        int __result__tag133 = 0 ;

        if (__tag133 == null ){
            __tag133 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag133);
        }
        __tag133.setPageContext(pageContext);
        __tag133.setParent(null);
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.in.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag133;
        __result__tag133 = __tag133.doStartTag();

        if (__result__tag133!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag133== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag133.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag133);
            return true;
        }
        _activeTag=__tag133.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag133);
        __tag133.release();
        return false;
    }

    private boolean _jsp__tag134(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag134 = null ;
        int __result__tag134 = 0 ;

        if (__tag134 == null ){
            __tag134 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag134);
        }
        __tag134.setPageContext(pageContext);
        __tag134.setParent(null);
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HeadCircumference.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag134;
        __result__tag134 = __tag134.doStartTag();

        if (__result__tag134!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag134== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag134.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag134);
            return true;
        }
        _activeTag=__tag134.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag134);
        __tag134.release();
        return false;
    }

    private boolean _jsp__tag135(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag135 = null ;
        int __result__tag135 = 0 ;

        if (__tag135 == null ){
            __tag135 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag135);
        }
        __tag135.setPageContext(pageContext);
        __tag135.setParent(null);
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag135;
        __result__tag135 = __tag135.doStartTag();

        if (__result__tag135!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag135== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag135.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag135);
            return true;
        }
        _activeTag=__tag135.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag135);
        __tag135.release();
        return false;
    }

    private boolean _jsp__tag136(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag136 = null ;
        int __result__tag136 = 0 ;

        if (__tag136 == null ){
            __tag136 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag136);
        }
        __tag136.setPageContext(pageContext);
        __tag136.setParent(null);
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.in.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag136;
        __result__tag136 = __tag136.doStartTag();

        if (__result__tag136!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag136== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag136.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag136);
            return true;
        }
        _activeTag=__tag136.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag136);
        __tag136.release();
        return false;
    }

    private boolean _jsp__tag137(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag137 = null ;
        int __result__tag137 = 0 ;

        if (__tag137 == null ){
            __tag137 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag137);
        }
        __tag137.setPageContext(pageContext);
        __tag137.setParent(null);
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ChestCirumference.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag137;
        __result__tag137 = __tag137.doStartTag();

        if (__result__tag137!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag137== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag137.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag137);
            return true;
        }
        _activeTag=__tag137.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag137);
        __tag137.release();
        return false;
    }

    private boolean _jsp__tag138(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag138 = null ;
        int __result__tag138 = 0 ;

        if (__tag138 == null ){
            __tag138 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag138);
        }
        __tag138.setPageContext(pageContext);
        __tag138.setParent(null);
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag138;
        __result__tag138 = __tag138.doStartTag();

        if (__result__tag138!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag138== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag138.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag138);
            return true;
        }
        _activeTag=__tag138.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag138);
        __tag138.release();
        return false;
    }

    private boolean _jsp__tag139(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag139 = null ;
        int __result__tag139 = 0 ;

        if (__tag139 == null ){
            __tag139 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag139);
        }
        __tag139.setPageContext(pageContext);
        __tag139.setParent(null);
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.in.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag139;
        __result__tag139 = __tag139.doStartTag();

        if (__result__tag139!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag139== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag139.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag139);
            return true;
        }
        _activeTag=__tag139.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag139);
        __tag139.release();
        return false;
    }

    private boolean _jsp__tag140(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag140 = null ;
        int __result__tag140 = 0 ;

        if (__tag140 == null ){
            __tag140 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag140);
        }
        __tag140.setPageContext(pageContext);
        __tag140.setParent(null);
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbilicalCord.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag140;
        __result__tag140 = __tag140.doStartTag();

        if (__result__tag140!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag140== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag140.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag140);
            return true;
        }
        _activeTag=__tag140.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag140);
        __tag140.release();
        return false;
    }

    private boolean _jsp__tag141(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag141 = null ;
        int __result__tag141 = 0 ;

        if (__tag141 == null ){
            __tag141 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag141);
        }
        __tag141.setPageContext(pageContext);
        __tag141.setParent(null);
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag141;
        __result__tag141 = __tag141.doStartTag();

        if (__result__tag141!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag141== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag141.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag141);
            return true;
        }
        _activeTag=__tag141.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag141);
        __tag141.release();
        return false;
    }

    private boolean _jsp__tag142(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag142 = null ;
        int __result__tag142 = 0 ;

        if (__tag142 == null ){
            __tag142 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag142);
        }
        __tag142.setPageContext(pageContext);
        __tag142.setParent(null);
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag142;
        __result__tag142 = __tag142.doStartTag();

        if (__result__tag142!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag142== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag142.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag142);
            return true;
        }
        _activeTag=__tag142.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag142);
        __tag142.release();
        return false;
    }

    private boolean _jsp__tag143(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag143 = null ;
        int __result__tag143 = 0 ;

        if (__tag143 == null ){
            __tag143 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag143);
        }
        __tag143.setPageContext(pageContext);
        __tag143.setParent(null);
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stump.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag143;
        __result__tag143 = __tag143.doStartTag();

        if (__result__tag143!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag143== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag143.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag143);
            return true;
        }
        _activeTag=__tag143.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag143);
        __tag143.release();
        return false;
    }

    private boolean _jsp__tag144(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag144 = null ;
        int __result__tag144 = 0 ;

        if (__tag144 == null ){
            __tag144 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag144);
        }
        __tag144.setPageContext(pageContext);
        __tag144.setParent(null);
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag144;
        __result__tag144 = __tag144.doStartTag();

        if (__result__tag144!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag144== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag144.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag144);
            return true;
        }
        _activeTag=__tag144.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag144);
        __tag144.release();
        return false;
    }

    private boolean _jsp__tag145(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag145 = null ;
        int __result__tag145 = 0 ;

        if (__tag145 == null ){
            __tag145 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag145);
        }
        __tag145.setPageContext(pageContext);
        __tag145.setParent(null);
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbCordCutBy.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag145;
        __result__tag145 = __tag145.doStartTag();

        if (__result__tag145!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag145== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag145.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag145);
            return true;
        }
        _activeTag=__tag145.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag145);
        __tag145.release();
        return false;
    }

    private boolean _jsp__tag146(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag146 = null ;
        int __result__tag146 = 0 ;

        if (__tag146 == null ){
            __tag146 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag146);
        }
        __tag146.setPageContext(pageContext);
        __tag146.setParent(null);
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Feeding.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag146;
        __result__tag146 = __tag146.doStartTag();

        if (__result__tag146!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag146== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag146.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag146);
            return true;
        }
        _activeTag=__tag146.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag146);
        __tag146.release();
        return false;
    }

    private boolean _jsp__tag147(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag147 = null ;
        int __result__tag147 = 0 ;

        if (__tag147 == null ){
            __tag147 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag147);
        }
        __tag147.setPageContext(pageContext);
        __tag147.setParent(null);
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag147;
        __result__tag147 = __tag147.doStartTag();

        if (__result__tag147!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag147== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag147.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag147);
            return true;
        }
        _activeTag=__tag147.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag147);
        __tag147.release();
        return false;
    }

    private boolean _jsp__tag148(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag148 = null ;
        int __result__tag148 = 0 ;

        if (__tag148 == null ){
            __tag148 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag148);
        }
        __tag148.setPageContext(pageContext);
        __tag148.setParent(null);
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Breast.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag148;
        __result__tag148 = __tag148.doStartTag();

        if (__result__tag148!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag148== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag148.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag148);
            return true;
        }
        _activeTag=__tag148.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag148);
        __tag148.release();
        return false;
    }

    private boolean _jsp__tag149(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag149 = null ;
        int __result__tag149 = 0 ;

        if (__tag149 == null ){
            __tag149 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag149);
        }
        __tag149.setPageContext(pageContext);
        __tag149.setParent(null);
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Bottle.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag149;
        __result__tag149 = __tag149.doStartTag();

        if (__result__tag149!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag149== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag149.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag149);
            return true;
        }
        _activeTag=__tag149.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag149);
        __tag149.release();
        return false;
    }

    private boolean _jsp__tag150(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag150 = null ;
        int __result__tag150 = 0 ;

        if (__tag150 == null ){
            __tag150 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag150);
        }
        __tag150.setPageContext(pageContext);
        __tag150.setParent(null);
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag150;
        __result__tag150 = __tag150.doStartTag();

        if (__result__tag150!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag150== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag150.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag150);
            return true;
        }
        _activeTag=__tag150.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag150);
        __tag150.release();
        return false;
    }

    private boolean _jsp__tag151(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag151 = null ;
        int __result__tag151 = 0 ;

        if (__tag151 == null ){
            __tag151 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag151);
        }
        __tag151.setPageContext(pageContext);
        __tag151.setParent(null);
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnus.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag151;
        __result__tag151 = __tag151.doStartTag();

        if (__result__tag151!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag151== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag151.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag151);
            return true;
        }
        _activeTag=__tag151.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag151);
        __tag151.release();
        return false;
    }

    private boolean _jsp__tag152(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag152 = null ;
        int __result__tag152 = 0 ;

        if (__tag152 == null ){
            __tag152 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag152);
        }
        __tag152.setPageContext(pageContext);
        __tag152.setParent(null);
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag152;
        __result__tag152 = __tag152.doStartTag();

        if (__result__tag152!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag152== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag152.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag152);
            return true;
        }
        _activeTag=__tag152.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag152);
        __tag152.release();
        return false;
    }

    private boolean _jsp__tag153(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag153 = null ;
        int __result__tag153 = 0 ;

        if (__tag153 == null ){
            __tag153 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag153);
        }
        __tag153.setPageContext(pageContext);
        __tag153.setParent(null);
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Patent.label", java.lang.String .class,"key"));
        __tag153.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag153;
        __result__tag153 = __tag153.doStartTag();

        if (__result__tag153!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag153== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag153.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag153);
            return true;
        }
        _activeTag=__tag153.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag153);
        __tag153.release();
        return false;
    }

    private boolean _jsp__tag154(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag154 = null ;
        int __result__tag154 = 0 ;

        if (__tag154 == null ){
            __tag154 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag154);
        }
        __tag154.setPageContext(pageContext);
        __tag154.setParent(null);
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NotPatent.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag154;
        __result__tag154 = __tag154.doStartTag();

        if (__result__tag154!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag154== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag154.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag154);
            return true;
        }
        _activeTag=__tag154.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag154);
        __tag154.release();
        return false;
    }

    private boolean _jsp__tag155(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag155 = null ;
        int __result__tag155 = 0 ;

        if (__tag155 == null ){
            __tag155 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag155);
        }
        __tag155.setPageContext(pageContext);
        __tag155.setParent(null);
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CongenitalAnomalies.label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag155;
        __result__tag155 = __tag155.doStartTag();

        if (__result__tag155!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag155== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag155.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag155);
            return true;
        }
        _activeTag=__tag155.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag155);
        __tag155.release();
        return false;
    }

    private boolean _jsp__tag156(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag156 = null ;
        int __result__tag156 = 0 ;

        if (__tag156 == null ){
            __tag156 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag156);
        }
        __tag156.setPageContext(pageContext);
        __tag156.setParent(null);
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnusCheckedBy.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag156;
        __result__tag156 = __tag156.doStartTag();

        if (__result__tag156!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag156== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag156.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag156);
            return true;
        }
        _activeTag=__tag156.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag156);
        __tag156.release();
        return false;
    }

    private boolean _jsp__tag157(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag157 = null ;
        int __result__tag157 = 0 ;

        if (__tag157 == null ){
            __tag157 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag157);
        }
        __tag157.setPageContext(pageContext);
        __tag157.setParent(null);
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stools.label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag157;
        __result__tag157 = __tag157.doStartTag();

        if (__result__tag157!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag157== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag157.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag157);
            return true;
        }
        _activeTag=__tag157.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag157);
        __tag157.release();
        return false;
    }

    private boolean _jsp__tag158(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag158 = null ;
        int __result__tag158 = 0 ;

        if (__tag158 == null ){
            __tag158 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag158);
        }
        __tag158.setPageContext(pageContext);
        __tag158.setParent(null);
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag158.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag158;
        __result__tag158 = __tag158.doStartTag();

        if (__result__tag158!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag158== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag158.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag158);
            return true;
        }
        _activeTag=__tag158.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag158);
        __tag158.release();
        return false;
    }

    private boolean _jsp__tag159(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag159 = null ;
        int __result__tag159 = 0 ;

        if (__tag159 == null ){
            __tag159 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag159);
        }
        __tag159.setPageContext(pageContext);
        __tag159.setParent(null);
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Meconium.label", java.lang.String .class,"key"));
        __tag159.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag159;
        __result__tag159 = __tag159.doStartTag();

        if (__result__tag159!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag159== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag159.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag159);
            return true;
        }
        _activeTag=__tag159.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag159);
        __tag159.release();
        return false;
    }

    private boolean _jsp__tag160(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag160 = null ;
        int __result__tag160 = 0 ;

        if (__tag160 == null ){
            __tag160 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag160);
        }
        __tag160.setPageContext(pageContext);
        __tag160.setParent(null);
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.YellowSoft.label", java.lang.String .class,"key"));
        __tag160.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag160;
        __result__tag160 = __tag160.doStartTag();

        if (__result__tag160!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag160== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag160.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag160);
            return true;
        }
        _activeTag=__tag160.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag160);
        __tag160.release();
        return false;
    }

    private boolean _jsp__tag161(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag161 = null ;
        int __result__tag161 = 0 ;

        if (__tag161 == null ){
            __tag161 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag161);
        }
        __tag161.setPageContext(pageContext);
        __tag161.setParent(null);
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag161;
        __result__tag161 = __tag161.doStartTag();

        if (__result__tag161!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag161== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag161.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag161);
            return true;
        }
        _activeTag=__tag161.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag161);
        __tag161.release();
        return false;
    }

    private boolean _jsp__tag162(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag162 = null ;
        int __result__tag162 = 0 ;

        if (__tag162 == null ){
            __tag162 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag162);
        }
        __tag162.setPageContext(pageContext);
        __tag162.setParent(null);
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FetusCompofDelivery.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag162;
        __result__tag162 = __tag162.doStartTag();

        if (__result__tag162!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag162== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag162.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag162);
            return true;
        }
        _activeTag=__tag162.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag162);
        __tag162.release();
        return false;
    }

    private boolean _jsp__tag163(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag163 = null ;
        int __result__tag163 = 0 ;

        if (__tag163 == null ){
            __tag163 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag163);
        }
        __tag163.setPageContext(pageContext);
        __tag163.setParent(null);
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NeonatalResuscitation.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag163;
        __result__tag163 = __tag163.doStartTag();

        if (__result__tag163!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag163== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag163.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag163);
            return true;
        }
        _activeTag=__tag163.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag163);
        __tag163.release();
        return false;
    }

    private boolean _jsp__tag164(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag164 = null ;
        int __result__tag164 = 0 ;

        if (__tag164 == null ){
            __tag164 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag164);
        }
        __tag164.setPageContext(pageContext);
        __tag164.setParent(null);
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Resuscitated.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag164;
        __result__tag164 = __tag164.doStartTag();

        if (__result__tag164!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag164== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag164.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag164);
            return true;
        }
        _activeTag=__tag164.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag164);
        __tag164.release();
        return false;
    }

    private boolean _jsp__tag165(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag165 = null ;
        int __result__tag165 = 0 ;

        if (__tag165 == null ){
            __tag165 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag165);
        }
        __tag165.setPageContext(pageContext);
        __tag165.setParent(null);
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.vaccinationdetails.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag165;
        __result__tag165 = __tag165.doStartTag();

        if (__result__tag165!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag165== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag165.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag165);
            return true;
        }
        _activeTag=__tag165.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag165);
        __tag165.release();
        return false;
    }

    private boolean _jsp__tag166(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag166 = null ;
        int __result__tag166 = 0 ;

        if (__tag166 == null ){
            __tag166 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag166);
        }
        __tag166.setPageContext(pageContext);
        __tag166.setParent(null);
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaccSite.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag166;
        __result__tag166 = __tag166.doStartTag();

        if (__result__tag166!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag166== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag166.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag166);
            return true;
        }
        _activeTag=__tag166.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag166);
        __tag166.release();
        return false;
    }

    private boolean _jsp__tag167(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag167 = null ;
        int __result__tag167 = 0 ;

        if (__tag167 == null ){
            __tag167 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag167);
        }
        __tag167.setPageContext(pageContext);
        __tag167.setParent(null);
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdministeredBy.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag167;
        __result__tag167 = __tag167.doStartTag();

        if (__result__tag167!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag167== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag167.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag167);
            return true;
        }
        _activeTag=__tag167.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag167);
        __tag167.release();
        return false;
    }

    private boolean _jsp__tag168(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag168 = null ;
        int __result__tag168 = 0 ;

        if (__tag168 == null ){
            __tag168 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag168);
        }
        __tag168.setPageContext(pageContext);
        __tag168.setParent(null);
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag168;
        __result__tag168 = __tag168.doStartTag();

        if (__result__tag168!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag168== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag168.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag168);
            return true;
        }
        _activeTag=__tag168.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag168);
        __tag168.release();
        return false;
    }

    private boolean _jsp__tag169(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag169 = null ;
        int __result__tag169 = 0 ;

        if (__tag169 == null ){
            __tag169 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag169);
        }
        __tag169.setPageContext(pageContext);
        __tag169.setParent(null);
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AdminDateTime.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag169;
        __result__tag169 = __tag169.doStartTag();

        if (__result__tag169!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag169== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag169.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag169);
            return true;
        }
        _activeTag=__tag169.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag169);
        __tag169.release();
        return false;
    }

    private boolean _jsp__tag170(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag170 = null ;
        int __result__tag170 = 0 ;

        if (__tag170 == null ){
            __tag170 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag170);
        }
        __tag170.setPageContext(pageContext);
        __tag170.setParent(null);
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BCG.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag170;
        __result__tag170 = __tag170.doStartTag();

        if (__result__tag170!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag170== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag170.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag170);
            return true;
        }
        _activeTag=__tag170.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag170);
        __tag170.release();
        return false;
    }

    private boolean _jsp__tag171(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag171 = null ;
        int __result__tag171 = 0 ;

        if (__tag171 == null ){
            __tag171 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag171);
        }
        __tag171.setPageContext(pageContext);
        __tag171.setParent(null);
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VitaminK.label", java.lang.String .class,"key"));
        __tag171.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag171;
        __result__tag171 = __tag171.doStartTag();

        if (__result__tag171!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag171== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag171.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag171);
            return true;
        }
        _activeTag=__tag171.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag171);
        __tag171.release();
        return false;
    }

    private boolean _jsp__tag172(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag172 = null ;
        int __result__tag172 = 0 ;

        if (__tag172 == null ){
            __tag172 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag172);
        }
        __tag172.setPageContext(pageContext);
        __tag172.setParent(null);
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HepatitisB.label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag172;
        __result__tag172 = __tag172.doStartTag();

        if (__result__tag172!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag172== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag172.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag172);
            return true;
        }
        _activeTag=__tag172.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag172);
        __tag172.release();
        return false;
    }
}

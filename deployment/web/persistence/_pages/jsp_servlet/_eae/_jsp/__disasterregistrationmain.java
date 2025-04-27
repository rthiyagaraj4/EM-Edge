package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __disasterregistrationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/DisasterRegistrationMain.jsp", 1725526656262L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<!--<object id=\"locale\" classid=\"clsid:C0276E18-D808-4F12-829E-BC186831D396\" CODEBASE=\"../../eCommon/js/Locale.CAB#version=1,0,0,0\"></object>-->\n\n    <script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script> \n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script> \n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eAE/js/DisasterPatient.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n\n    <body onSelect=\"codeArrestThruSelect()\" OnMouseDown=\"CodeArrest()\"  onKeyDown = \"lockKey()\" onload=\'chkValue(document.forms[0].creat_attn_detail_yn);setfocus();coldisable()\' >\n    <form name=\'DisasterPatReg\' id=\'DisasterPatReg\' method=\'post\'   action=\'../../servlet/eAE.DisasterRegistrationServlet\' target=\'messageFrame\'>\n\t<br><br>\n<!--\t<script>alert(\'Main\')</script> -->\n    <table width=\'90%\' cellpadding=\'2\' cellspacing=\'0\' border=\'0\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td  class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n            <td class=\'fields\'  width=\'25%\'>\n            ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n            </td>\n\t\t\t<td width=\'25%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'fields\'  width=\'25%\'><select name=\'priority_zone\' id=\'priority_zone\'>\n         <option value=\"\">-----";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="-----</option> \n\t\t\t<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t           \n\t\t      ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t      <!--CRF  SKR-CRF-0021 [IN028173] end-->\n\n\t\t   </select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t</tr>\n\t</table>\n\t<br>\n\n\t<table width=\'90%\' cellpadding=\'0\' cellspacing=\'0\' border=\'1\' align=\'center\' colspan=7 >\t\t\n\t\t<tr>\n\t\t\t <td  width=\'10%\'>&nbsp;</td><td class = \'label\'  colspan=2 align=\'center\'>&nbsp;<b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</td>\n\t\t\t<td  class = \'label\' colspan=2 align=\'center\'>&nbsp;<b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;</td>\n\t\t</tr>\n\t\t<tr> </tr>     \n\t\t<tr> \n\t\t\t<td class = \'label\' align=\'right\'><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</td>\n\t\t\t<td  class = \'label\' align=\'center\' width=\'10%\'><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td  class = \'label\' align=\'center\' width=\'10%\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td>\n\t\t\t<td  class = \'label\' align=\'center\' width=\'10%\'>&nbsp;<b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td> \n\t\t\t<td  class = \'label\' align=\'center\' width=\'10%\'><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td>\n\t\t </tr>\t\t \n\t\t <tr>\n\t\t\t<td class=\'label\' align=\'right\' width=\'10%\'><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</b></td>\n\t\t\t<td class=\'label\' align=\'center\'><input type=\'textbox\' name=\'adultmale\' id=\'adultmale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adult(adultmale,adultmaleage_y)\' tabindex=1></td>\n\t\t\t<td class=\'label\' align=\'center\'><input type=\'textbox\' name=\'adultmaleage_y\' id=\'adultmaleage_y\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adultmaleage(this,adultmale)\' tabindex=2><b>Y</b></td>\t\t\n\t\t\t<td class=\'label\' align=\'center\'> \n\t\t\t\t<input type=\'textbox\' name=\'childmale\' id=\'childmale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_child(childmale,childmaleage_y)\' tabindex=3></td>\n\t\t\t<td class=\'label\' ><input type=\'textbox\' name=\'childmaleage_y\' id=\'childmaleage_y\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_childmaleage(this,childmale)\'tabindex=4><b>Y</b></td>\t\t\n\t\t\t<td class=\'label\' align=\'center\'>\n\t\t\t\t<input tabindex=6 type=\'textbox\' name=\'infantmale\' id=\'infantmale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_infant(infantmale,infantmaleage_d)\'></td>\n\t\t\t<td class=\'label\' ><input tabindex=7 type=\'textbox\' name=\'infantmaleage_m\' id=\'infantmaleage_m\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onBlur=\'setage_infantmaleage(this,infantmale,infantmaleage_d);return allowValidMonth(this);\'><b>M</b><input tabindex=8 type=\'textbox\' name=\'infantmaleage_d\' id=\'infantmaleage_d\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\"\n\t\t    onBlur=\'setage_infantmaleage(this,infantmale,infantmaleage_m);return allowValidDate(this,event,20, 0);\'><b>D</b></td> \n\t\t </tr>\n\t\t <tr>\n\t\t\t <td class=\'label\' align=\'right\' width=\'10%\'><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</b></td>\n\t\t\t <td class=\'label\' align=\'center\' ><input tabindex=9 type=\'textbox\' name=\'adultfemale\' id=\'adultfemale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adultF(adultfemale,adultfemaleage_y)\'></td> \n\t\t\t <td class=\'label\' align=\'center\'><input tabindex=10 type=\'textbox\' name=\'adultfemaleage_y\' id=\'adultfemaleage_y\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adultfemaleage(this,adultfemale)\' ><b>Y</b></td>\t\t\n\t\t\t<td class=\'label\' align=\'center\'> \n\t\t\t\t<input tabindex=11 type=\'textbox\' name=\'childfemale\' id=\'childfemale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_childF(childfemale,childfemaleage_y)\'></td>\n\t\t\t<td class=\'label\'  ><input tabindex=12 type=\'textbox\' name=\'childfemaleage_y\' id=\'childfemaleage_y\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_childfemaleage(this,childfemale)\'><b>Y</b></td>\t\t\n\t\t\t<td class=\'label\' align=\'center\'> \n\t\t\t\t<input type=\'textbox\'  tabindex=14 name=\'infantfemale\' id=\'infantfemale\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\"  onblur=\'setage_infantF(infantfemale,infantfemaleage_d)\'></td>\n\t\t\t<td class=\'label\' ><input tabindex=15 type=\'textbox\' name=\'infantfemaleage_m\' id=\'infantfemaleage_m\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\"onBlur=\'setage_infantfemaleage(this,infantfemale,infantfemaleage_d);return allowValidMonth(this);\'><b>M</b><input type=\'textbox\'  tabindex=16 name=\'infantfemaleage_d\' id=\'infantfemaleage_d\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onBlur=\'setage_infantfemaleage(this,infantfemale,infantfemaleage_m);return allowValidDate(this,event,20, 0);\'><b>D</b></td>\n\t\t </tr>\n         <tr>\n\t\t\t <td class=\'label\' align=\'right\' width=\'10%\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;</b></td>\n\t\t\t<td class=\'label\' align=\'center\' ><input tabindex=17 type=\'textbox\' name=\'adultunknown\' id=\'adultunknown\' size=\'3\' maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adultU(adultunknown,adultunknownage_y)\'></td>\n\t\t\t<td class=\'label\' align=\'center\' ><input type=\'textbox\' tabindex=18 name=\'adultunknownage_y\' id=\'adultunknownage_y\' size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_adultunknownage(this,adultunknown)\'><b>Y</b></td>\t\n\t\t\t<td class=\'label\' align=\'center\'> \n\t\t\t\t<input type=\'textbox\' name=\'childunknown\' id=\'childunknown\' size=\'3\' tabindex=19 maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_childU(childunknown,childunknownage_y)\'></td>\n\t\t\t<td class=\'label\' ><input tabindex=20 type=\'textbox\' name=\'childunknownage_y\' id=\'childunknownage_y\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_childunknownage(this,childunknown)\'><b>Y</b></td>\t\n\t\t\t<td class=\'label\' align=\'center\'>\n\t\t\t\t<input type=\'textbox\' name=\'infantunknown\' id=\'infantunknown\' size=\'3\'  tabindex=22 maxlength=\'3\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onblur=\'setage_infantU(infantunknown,infantunknownage_d)\'></td>\n\t\t\t<td class=\'label\' ><input type=\'textbox\' name=\'infantunknownage_m\' id=\'infantunknownage_m\'  tabindex=23 size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onBlur=\'setage_infantunknownage(this,infantunknown,infantunknownage_d);return allowValidMonth(this);\'><b>M</B><input type=\'textbox\'  tabindex=24 name=\'infantunknownage_d\' id=\'infantunknownage_d\' size=\'2\' maxlength=\'2\' value=\"\" onkeypress=\"return allowValidNumber1(this,event,20, 0);\" onBlur=\'setage_infantunknownage(this,infantunknown,infantunknownage_m);return allowValidDate(this,event,20, 0);\'><b>D</B></td>\n\t\t </tr>\t \t\t \t\t\n\t</table>\n\t<br>\n\n\t<table width=\'90%\' cellpadding=\'2\' cellspacing=\'0\' border=\'0\' align=\'center\'>\n\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'  \n             maxLength=\'15\' value=\'\' onKeyPress=\"return CheckForSpecChar(event)\"  onblur = \"SpeCharCheck(this)\">&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'></img></td>\n             <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'  \n             maxLength=\'15\' value=\'\' onKeyPress=\"return CheckForSpecChars(event)\"  onblur = \"SpeCharCheck(this)\">&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'></img></td>\n             <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<input type=\'hidden\' name=\'allowSplChar\' id=\'allowSplChar\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></input>\n\t\t\t\n           </tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t<td class=\'field\'  colspan=\'3\'>\n    \t\t <textarea  name=\'remarks\' cols=\'50\'   align=\'left\'  onblur=\'makeValidString(this);checkMaxLen(this);\' onkeypress=\'checkMaxLimit(this,200);\'></textarea>\n\n\n\t\t</tr> \n\t</table>\n\t<br>\n\n    <table width=\'90%\' cellpadding=\'2\' cellspacing=\'0\' border=\'0\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td class=\'field\'  width=\'25%\'><input type=\'checkbox\'  name=\'creat_attn_detail_yn\' id=\'creat_attn_detail_yn\' onClick=\'chkValue(this);\' value=\"N\"></td>\n            <td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<td class=\'field\'  width=\'25%\'><input type=\'checkbox\'  name=\'CaptureFinancialDetails\' id=\'CaptureFinancialDetails\' onClick=\'chkValue2(this);\' value=\"N\"></td>\n            <td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<input type=\'hidden\' name=\'CaptureFinancialDetails\' id=\'CaptureFinancialDetails\' value=\"N\">\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<tr>\n            <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n            <td class=\'field\' width=\'25%\'>\n            <select name=\'clinic_code\' id=\'clinic_code\' onchange=\"populateVisitType(this)\" ><option value=\'\'>--------";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="-------</option>\n                ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' > ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n            ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</select>&nbsp;<img id=\'mand1\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t<td class=\'field\' width=\'25%\'><select name=\'service_code\' id=\'service_code\' ><option value=\'\'>--------";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="-------</option> \n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\n\t\t\t</select><img id=\'mand2\' src=\'../../eCommon/images/mandatory.gif\'></img></select>\n\t\t</td>\n\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t<td class=\'field\' width=\'25%\'>\n\t\t\t\t\t<select name=\'visit_type\' id=\'visit_type\' ><option value=\'\'>--------";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="-------</option>\n\t\t\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t</select><img id=\'mand3\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t<td class=\'field\'  width=\'25%\'>\n\t\t\t\t\t<select name=\'arrival_mode\' id=\'arrival_mode\'><option value=\'\'>--------";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="-------</option>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n            </select>\n            </td>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n        </tr>\n\t    <tr><td colspan=4 class=label height=5></td></tr>\n\t</table>\n\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' />\n\t<input type=\'hidden\' name=\'max_pat_in_disaster_regn\' id=\'max_pat_in_disaster_regn\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\'hidden\' name=\'site\' id=\'site\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\'hidden\' name=\'retValue\' id=\'retValue\' value=\'\'> \n  \t<input type=\'hidden\' name=\'treatment_area\' id=\'treatment_area\'>\n\t<input type=\'hidden\' name=\'reasonForVisit\' id=\'reasonForVisit\'>\n\t<input type=\'hidden\' name=\'cancel_mode\' id=\'cancel_mode\' value=\'\'>\n  \t<input type=\'hidden\' name=\'BLValue\' id=\'BLValue\' value=\'\'>\n\t \n\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"> \n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"> \n\t<input type=\'hidden\' name=\'is_financial_captured\' id=\'is_financial_captured\' value=\"\"> \n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<input type=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"N\">\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t<input type=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"Y\">\n  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n  <input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\t\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\n\n\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n    ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" \n\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"PatRegForm\"></input>\n\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'change_data_source\' id=\'change_data_source\' value=\"\"></input>\t\n\t<input type=\'hidden\' name=\'un_adult_age_for_dis_regn\' id=\'un_adult_age_for_dis_regn\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></input>\n\t<input type=\'hidden\' name=\'visit_type_dflt\' id=\'visit_type_dflt\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></input>\n\t<input type=\'hidden\' name=\'clinic_code_dflt\' id=\'clinic_code_dflt\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"></input>\n\t<input type=\'hidden\' name=\'service_code_dflt\' id=\'service_code_dflt\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></input>\n\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<!-- Added For Billing -->\n\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'cred_start_dt1\' id=\'cred_start_dt1\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'cred_start_dt2\' id=\'cred_start_dt2\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'cred_start_dt3\' id=\'cred_start_dt3\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"PatRegForm\"></input>\n\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"\"></input> \n\t<input type=\'hidden\' name=\'change_data_source\' id=\'change_data_source\' value=\"\"></input> \n\t<input type=\'hidden\' name=\'un_adult_age_for_dis_regn\' id=\'un_adult_age_for_dis_regn\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"></input>\n\n\t\n\n\n\n ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\n   <script>\n   /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */\n    var pry_zone_for_dis_regn =\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t if (pry_zone_for_dis_regn !=\"\"){  \n\t\t var drop_down = document.forms[0].priority_zone;\n\t\t for (var i = 0; i < drop_down.options.length; i++){\n\t\t   if (drop_down.options[i].value == pry_zone_for_dis_regn){\n\t\t    drop_down.selectedIndex = i;}}}\t\n   /* CRF  SKR-CRF-0021 [IN028173] end  */\n  </script>\n\n   </form>\n\t</body>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t</html> \n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

				Connection        con			= null;
				Statement stmt					 = null;
				PreparedStatement pstmt			= null;
				PreparedStatement pstmt3		= null; 
				ResultSet rs					= null;
				ResultSet rset					= null;
				StringBuffer sqlbuf				= new StringBuffer();
				String Site						= request.getParameter("Site");
				if(Site == null)   Site="DS";
				String bl_interface_yn			= request.getParameter("billing_interfaced_yn");
				String operstn					= request.getParameter("operstn");
				String module_id				= request.getParameter("module_id");
			
				request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
				
				String locale					= (String)session.getAttribute("LOCALE");
				String facility_id				= (String)session.getValue("facility_id");
				//String loginUser				= (String)session.getValue("login_user");
				String bl_install_yn			= (String)session.getValue("bl_operational"); 
				if(bl_install_yn == null)   bl_install_yn="";
				 String dflt_disaster_blng_grp_id = "";
				String dflt_slmt_type_code = "";
				String settlement_ind =  "";
				String emer_blng_class_code= "";
				String location_prop= "";
				String service_prop= "";
				String visitType_prop= "";
                /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
				String sql="";
				String  five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
				
                /* CRF  SKR-CRF-0021 [IN028173] end  */
				String  max_pat_in_disaster_regn	= (request.getParameter("max_pat_in_disaster_regn")==null || request.getParameter("max_pat_in_disaster_regn")=="")?"0":request.getParameter("max_pat_in_disaster_regn");
				
			
				String pry_zone_for_dis_regn= request.getParameter("pry_zone_for_dis_regn");
				if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
				String un_adult_age_for_dis_regn= request.getParameter("un_adult_age_for_dis_regn");
				if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
				String emer_val_sr              = request.getParameter("emer_val_sr");
				if(emer_val_sr == null)   emer_val_sr="";
				String clinic_code              = request.getParameter("clinic_code");
				if(clinic_code == null)   clinic_code="";
				String service_code             = request.getParameter("service_code");
				if(service_code == null)   service_code="";
				String visit_type                = request.getParameter("visit_type");
				if(visit_type == null)   visit_type="";
				
				//Added below line for this CRF ML-MMOH-CRF-0466				
				String dist_pat_ser_grp = request.getParameter("dist_pat_ser_grp");
				if(dist_pat_ser_grp == null)   dist_pat_ser_grp="";
				
				

/* Thursday, May 20, 2010 PE_EXE
				try{
					pstmt2 = con.prepareStatement("select BILLING_INTERFACED_YN billing_interfaced_yn,DFLT_LOCN_CODE_FOR_DIS_REGN, DFLT_SRVC_CODE_FOR_DIS_REGN,DFLT_PRY_ZONE_FOR_DIS_REGN, DFLT_UN_ADULT_AGE_FOR_DIS_REGN, DFLT_VIS_TYP_CDE_FOR_DIS_REGN from ae_param where operating_facility_id=?");
                    pstmt2.setString(1,facility_id);
					rset1 = pstmt2.executeQuery();
					if (rset1!=null) {
						while (rset1.next()) {
							bl_interface_yn = rset1.getString("billing_interfaced_yn");
							clinic_code = rset1.getString("DFLT_LOCN_CODE_FOR_DIS_REGN");
							if(clinic_code == null)   clinic_code="";
							service_code = rset1.getString("DFLT_SRVC_CODE_FOR_DIS_REGN");
							if(service_code == null)   service_code="";
							visit_type = rset1.getString("DFLT_VIS_TYP_CDE_FOR_DIS_REGN");
							if(visit_type == null)   visit_type="";

							pry_zone_for_dis_regn = rset1.getString("DFLT_PRY_ZONE_FOR_DIS_REGN");
							if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
							un_adult_age_for_dis_regn = rset1.getString("DFLT_UN_ADULT_AGE_FOR_DIS_REGN");
							if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
						}
					}
							 
					if(rset1!=null) rset1.close();
					if(pstmt2!=null) pstmt2.close();

				}catch(Exception ee){ee.printStackTrace();}
							 
				try {                        
                               
					pstmt2 = con.prepareStatement("select site_id from sm_site_param " );
					rset1 = pstmt2.executeQuery() ;
					if(rset1.next())
					Site = rset1.getString(1) ;
					if(rset1!=null) rset1.close();
					if(pstmt2!=null) pstmt2.close();
				}catch(Exception ee){ee.printStackTrace();}

				try{
					String sqlOper="select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id=? and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =? and trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate))";
					pstmt=con.prepareStatement(sqlOper);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,loginUser);
					rset=pstmt.executeQuery();
					if(rset != null && rset.next()) {
						operstn	 = (rset.getString("oper_stn_id") == null)?"":rset.getString("oper_stn_id");
					}
					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();

				}catch(Exception e) {
					e.printStackTrace();
				}

				*/
				


			try{
	            con = ConnectionManager.getConnection(request);
				//Added by mano on CRF-0644
				boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");
				StringBuffer sqlArrival	 = new StringBuffer();
				sqlArrival.append(" select arrival_code, short_desc from am_arrival_lang_vw where facility_id= ? and language_id='"+locale+"' and eff_status='E' order by short_desc "); 


                StringBuffer sqlLocation	  = new StringBuffer();
				//	sqlLocation.append("select a.CLINIC_CODE, a.long_desc SHORT_DESC, c.gender from OP_CLINIC_LANG_VW a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b, am_age_group c  where decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and a.facility_id = ? and a.language_id = '"+locale+"' and a.clinic_type ='C' and a.level_of_care_ind = 'E'   and a.eff_status = 'E'   and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = a.facility_id and  register_visit_yn = 'Y')  and  a.age_group_code = c.age_group_code(+)  and c.gender is null and (facility_id,clinic_code) in (select facility_id,locn_code from am_locn_for_oper_stn_vw where facility_id =a.facility_id and oper_stn_id =? )order by 2  ");  
				sqlLocation.append("SELECT a.clinic_code, a.long_desc short_desc, c.gender FROM op_clinic_lang_vw a, (SELECT day_no FROM sm_day_of_week WHERE day_of_week = RTRIM (TO_CHAR (SYSDATE, 'DAY'))) b, am_age_group c WHERE DECODE (b.day_no, '1', working_day_1, '2', working_day_2, '3', working_day_3, '4', working_day_4, '5', working_day_5, '6', working_day_6, '7', working_day_7 ) = 'Y' AND a.facility_id = ? AND a.language_id = '"+locale+"' AND a.clinic_type = 'C' AND a.level_of_care_ind = 'E' AND a.eff_status = 'E' AND a.age_group_code = c.age_group_code(+) AND c.gender IS NULL AND (facility_id, clinic_type,clinic_code) IN ( SELECT oper_stn.facility_id, locn_oper_stn.locn_type,locn_oper_stn.locn_code FROM AM_OPER_STN oper_stn , am_locn_for_oper_stn locn_oper_stn WHERE oper_stn.facility_id = a.facility_id AND oper_stn.oper_stn_id = ? AND oper_stn.register_visit_yn = 'Y' AND locn_oper_stn.facility_id = locn_oper_stn.facility_id AND locn_oper_stn.oper_stn_id = locn_oper_stn.oper_stn_id) ORDER BY 2 ");  

				StringBuffer sqlVisitType	  = new StringBuffer();
				sqlVisitType.append("select distinct visit_type_code, visit_type_short_desc from OP_VISIT_TYPE_FOR_CLINIC_VW where visit_type_ind='E'  and eff_status='E'   and clinic_code= ? and FACILITY_ID= ?");

				StringBuffer sqlService	  = new StringBuffer();
                sqlService.append("SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID=? AND C.CLINIC_CODE = ? AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID=?  AND b.CLINIC_CODE=? AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2");




				//sql="select emeg_pat_ser_grp FROM mp_param where module_id='MP'";

				try {
					//pstmt1 = con.prepareStatement(sql) ;
					//rset = pstmt1.executeQuery() ;
					//if(rset!=null) 

					

Properties p;		
	p = (Properties) session.getValue("jdbc");
	String userId				= (String)session.getAttribute("login_user");
	HashMap hashMap		= new HashMap();
	hashMap = eMP.ChangePatientDetails.getSetupData(facility_id,"",con,p);
	String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
	
	String userAccessSql	= "";
	if(pat_ser_access_by_user_yn.equals("Y")){
		userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
	}






					if(emer_val_sr!=null) 
					//sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in('E','U') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?))) order by 2");
					
					sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in ('E', 'U','G','N') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?) and used_status = 'N' ))  "+userAccessSql+" order by 2");
						

                    pstmt3 = con.prepareStatement(sqlbuf.toString()); 
				
					//while(rset.next()) { 
						pstmt3.setString(1,Site);
						pstmt3.setString(2,facility_id);
                        rs = pstmt3.executeQuery( );
                        out.println("<select name='pat_ser_grp_code' id='pat_ser_grp_code'>");
						out.println( "<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----</Option>" ) ;  
						if(rs !=null)  {
							while(rs.next())  {
								String sel ="" ;
								
							if(dist_pat_ser_grp.equals("")){
                                if(emer_val_sr.equals((rs.getString(1) == null ? "" :rs.getString(1)) ))
							      sel = "selected" ;
								  
                                  out.println( "<Option value=\""+rs.getString(1)+"\" "+sel+">"+rs.getString(2)+"</Option>" ) ;
							}else{
							   /*Above line commented and Below line added for this CRF ML-MMOH-CRF-0466*/
							    if(dist_pat_ser_grp.equals((rs.getString(1) == null ? "" :rs.getString(1)) )) 
									sel = "selected" ;
									
                                out.println( "<Option value=\""+rs.getString(1)+"\" "+sel+">"+rs.getString(2)+"</Option>" ) ;
							}
                            }
                         }
						out.println("</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>");
						if(rs!=null) rs.close();
						//if(pstmt3!=null) pstmt3.close();
					//}// END of While..........
					if(pstmt3!=null) pstmt3.close();
					sqlbuf.setLength(0);
					//if(rset!=null) rset.close();
					//if(pstmt1!=null) pstmt1.close(); 
                }catch(Exception e) {e.printStackTrace();}
            
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(pry_zone_for_dis_regn.equals("") || !pry_zone_for_dis_regn.equals("") ){
			 
			   
	  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
		if(!five_level_triage_appl_yn.equals("Y")){
				sql	= sql + "  and priority_zone not in ('B','W') ";
		}
			sql= sql + " order by PRIORITY_ZONE_ORDER asc"; 
			     pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 out.println("<option value='"+rset.getString(1)+"'>");	     
			   out.println(rset.getString(2));
			   out.println("</option>"); 
				}

			  if(pstmt!=null) pstmt.close();
			  if(rset!=null)rset.close();
			  
			   
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(un_adult_age_for_dis_regn));
            _bw.write(_wl_block24Bytes, _wl_block24);

		if(allowSplChar)
		{
			
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		else
		{
			
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(allowSplChar));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
	
				try {

				   pstmt = con.prepareStatement(sqlLocation.toString());
				   pstmt.setString(1,facility_id);
				   pstmt.setString(2,operstn);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   int counter = 1; 
				   //boolean rec_exists=false;
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);

						if(clinic_code.equals(code))	
			            {
							
							location_prop				=	"selected";
						}
						else
						{
							
							location_prop				=	"";
						}
  						if(counter==1){ counter=0;}
            
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block41Bytes, _wl_block41);

				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				if((sqlLocation != null) && (sqlLocation.length() > 0))
				 {
					sqlLocation.delete(0,sqlLocation.length());
				 }

			    }catch (Exception e){e.printStackTrace();}
				finally {
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				}
            
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

				if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlService.toString());
				   pstmt.setString(1,facility_id);
				   pstmt.setString(2,clinic_code);
				   pstmt.setString(3,facility_id);
				   pstmt.setString(4,clinic_code);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(service_code.equals(code))	
			            {
							service_prop				=	"selected";
						}
						else
						{
							service_prop				=	"";
						}
            
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block41Bytes, _wl_block41);

				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){e.printStackTrace();}
				if((sqlService != null) && (sqlService.length() > 0))
				 {
					sqlService.delete(0,sqlService.length());
				 }
			}
			
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

			if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlVisitType.toString());
				   pstmt.setString(1,clinic_code);
				   pstmt.setString(2,facility_id);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(visit_type.equals(code))	
			            {
							visitType_prop	   =	"selected";
						}
						else
						{
							visitType_prop				=	"";
						}
            
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block41Bytes, _wl_block41);

				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){e.printStackTrace();}
				if((sqlVisitType != null) && (sqlVisitType.length() > 0))
				 {
					sqlVisitType.delete(0,sqlService.length());
				 }
			}
			
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

				try {	
					pstmt = con.prepareStatement(sqlArrival.toString());
	   				pstmt.setString(1,facility_id);
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next()) {
						out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
					}
					sqlArrival.setLength(0);
					sqlLocation.setLength(0);
				    if(pstmt!=null) pstmt.close();
 			        if(rset!=null) rset.close();
				}catch (Exception e) {e.printStackTrace();}
				
			
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(max_pat_in_disaster_regn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(Site));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(localeName.equals("en"))
	{
            _bw.write(_wl_block58Bytes, _wl_block58);
}
  else if(localeName.equals("th"))
	{
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block61Bytes, _wl_block61);

	try
	{
	if (bl_install_yn.equals("Y"))
	{
		String sqlBL ="select DFLT_DISASTER_BLNG_GRP_ID,DFLT_SLMT_TYPE_CODE, SETTLEMENT_IND,DFLT_PAT_REGN_BLNG_CLASS from bl_mp_param a, BL_BLNG_GRP b where a.DFLT_DISASTER_BLNG_GRP_ID=b.BLNG_GRP_ID";
		stmt = con.createStatement();
		rset = stmt.executeQuery(sqlBL);
	 	
		if(rset!=null && rset.next())
		{
			dflt_disaster_blng_grp_id = rset.getString("DFLT_DISASTER_BLNG_GRP_ID");
		 if(dflt_disaster_blng_grp_id == null)   dflt_disaster_blng_grp_id="";
			dflt_slmt_type_code = rset.getString("DFLT_SLMT_TYPE_CODE");
			if(dflt_slmt_type_code == null)   dflt_slmt_type_code="";
			settlement_ind = rset.getString("SETTLEMENT_IND");
			if(settlement_ind == null)   settlement_ind="";
			emer_blng_class_code=rset.getString("DFLT_PAT_REGN_BLNG_CLASS");
			if(emer_blng_class_code == null)   emer_blng_class_code="";
		}
		if(rset!=null)	rset.close();
        if(stmt!=null)	stmt.close();


            _bw.write(_wl_block62Bytes, _wl_block62);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("dflt_disaster_blng_grp_id"), weblogic.utils.StringUtils.valueOf(dflt_disaster_blng_grp_id
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_slmt_type_code"), weblogic.utils.StringUtils.valueOf(dflt_slmt_type_code
                        )},{ weblogic.utils.StringUtils.valueOf("settlement_ind"), weblogic.utils.StringUtils.valueOf(settlement_ind
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("AE")},{ weblogic.utils.StringUtils.valueOf("emer_blng_class_code"), weblogic.utils.StringUtils.valueOf(emer_blng_class_code
                        )},{ weblogic.utils.StringUtils.valueOf("disaster_regn_YN"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("E")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf("VISIT_REGISTRATION")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(un_adult_age_for_dis_regn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(visit_type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block69Bytes, _wl_block69);

	}
	else
	{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(un_adult_age_for_dis_regn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(visit_type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block71Bytes, _wl_block71);

	}
	 }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 }catch (Exception e) {e.printStackTrace();}
   finally
      {
  	    ConnectionManager.returnConnection(con,request);
      }
 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pry_zone_for_dis_regn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Adult.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.child.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Infant.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NoofPatients.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.EstdAge.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NoofPatients.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.EstdAge.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NoofPatients.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.EstdAge.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference1.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CreateAttendanceDetails.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaptureFinancialDetails.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

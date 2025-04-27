package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.lang.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __otherstaffaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/OtherStaffAddModify.jsp", 1721039040124L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n <head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n        <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eAM/js/OtherStaff.js\' language=\'javascript\'></script>\n     \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n      </head>\n<script>\nvar tabKeyFlag=false;\nfunction scroll_vw()\n{\n\tif(parent.frames[1].document.getElementById(\'identitylink\')){\n\t\tparent.frames[1].document.getElementById(\'identitylink\').scrollIntoView();\n\t\t}\n}\n\nfunction registerLastKey(evt){\n\tif(evt.keyCode==9) \n\t\ttabKeyFlag=true; \n}\n\nfunction getfocus()\n{\t\n\tif(tabKeyFlag){\n\t  if(document.getElementById(\"other_staff_type\"))\n\t     document.getElementById(\"other_staff_type\").focus();\n      if(document.getElementById(\'other_staff_type2\'))\n          document.getElementById(\'other_staff_type2\').focus();\n\t} \t\n}\nfunction tabfocus()\n{\t\n\tdocument.getElementById(\'sex\').focus();\t\n}\n\n</script>\n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<body onLoad=\"FocusFirstElement();check();scroll_vw();setfocus();\" onSelect = \"resMove()\" onKeyDown = \'lockKey()\' OnMouseDown=\'CodeArrest()\' onKeyPress=\'return ChkKey(event);\'> \n    \t<form name=\'OtherStaff_form\' id=\'OtherStaff_form\'>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</td>\n\t<td class=\"label\" colspan=\'2\' width=\"45%\"></td>\n\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t<input type=\'text\' name=\'other_staff_id\' id=\'other_staff_id\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onKeyPress=\"return CheckForSpecCharsValidation2(event);\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onKeyPress=\"return CheckForSpecChars(event)\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td class=\"label\" colspan=\'2\' width=\"45%\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t<input type=\'text\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onKeyPress=\"return CheckForSpecCharsValidation1(event);\" onBlur=\'CheckSplCharsValidation(this); makeValidString(this);\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" name=\'other_staff_name\' id=\'other_staff_name\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class=\"fields\" width=\"30%\"><input type=\'text\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" name=\'short_name\' id=\'short_name\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<tr>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n<td class=\'fields\' colspan=\'2\'><textarea name=\'long_name\' id=\'long_name\'  rows=\'4\' cols=\'72\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onKeyPress=\'return CheckForSpecCharsValidation1(event); checkMaxLimit(this,\"300\");\' onBlur=\'CheckSplCharsValidation(this); return maxLength(this,\"300\");\' onpaste=\'return maxLengthPaste(this,\"300\");\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\tonKeyPress=\'checkMaxLimit(this,\"300\");\' onpaste=\'return maxLengthPaste(this,\"300\");\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\t\n\t\n</td>\n<td class=\'label\'  >&nbsp;</td>\n\t<td class=\'fields\' ></td>\n\t\t</tr>\n<tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\"><input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\'  value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onclick=\"checkActive(this)\" onKeydown=\"registerLastKey(event)\" onblur=\"getfocus()\" >\n\t\t\t</td>\n\t\t\t<td class=\"label\" colspan=\'2\' width=\"45%\"></td>\n\t\t</tr>\n<tr><td colspan=\'5\'>\n\n<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"General\">\n\t\t\t\t<a onclick=\"tab_click2(\'search_tab\')\" class=\"tabClicked\" id=\'search_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"search_tabspan\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Additional details\">\n\t\t\t\t<a onclick=\"tab_click2(\'additional_tab\')\" class=\"tabA\" id=\'additional_tab\'>\n\t\t\t\t\t<span class=\"tabAspan\" id=\"additional_tabspan\" >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n</td></tr>\t\t\n\t</table>\n</form>\n\n<script>prevTabObj=\'search_tab\';</script>\n<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->  \n<form name=\'OtherStaff1_form\' id=\'OtherStaff1_form\' action=\'../../servlet/eAM.OtherStaffServlet\' method=\'post\' target=\'messageFrame\'>\n\t<a name=\'identitylink\'  id=\'identitylink\'></a>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'sub_tab\' id=\'sub_tab\'>\n\t\t<tr>\n\t\t\t\n      \t<td width=\"100%\" class=\"Border\"><table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t<td class=\'fields\' width=\"35%\">\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n\n\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<td class=\"label\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t<td>\n\t\t<table width=\'53%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"oaBorder\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<input type=\'radio\' name=\'res_citizen\' id=\'res_citizen\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t\t\tonClick=\'validateCitizen(\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\");\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" \n\t\t\t\t\tonClick=\'validateNonCitizen(\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\",\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" disabled>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t</table>\n\t</td>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t<!--End MOHE-CRF-0011-->\n\t<input type=\'hidden\' name=\'max_pa_age\' id=\'max_pa_age\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\n\t</tr>\n\t\t\t\n\t\t<tr>\n\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td class=\'fields\' width=\'35%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\"  size=\"3\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onChange=\'calculateAge(this,2)\' disabled  onblur=\'chkY()\'>&nbsp;Y&nbsp;\n\t\t\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' size=\"2\" onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onChange=\'calculateAge(this,2)\' disabled >&nbsp;M&nbsp;\n\t\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\"  maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onChange=\'calculateAge(this,2)\'  disabled>&nbsp;D&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\"  maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onChange=\'calculateAge(this,2)\' onblur=\'chkY()\' >&nbsp;Y&nbsp;\n\t\t\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\"  maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' size=\"2\" onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onBlur=\'calculateAge(this,2)\' >&nbsp;M&nbsp;\n\t\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\"  maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onBlur=\'calculateAge(this,2)\'  >&nbsp;D&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t<td class=\"fields\" width=\"30%\" >\n\t\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'effstatus\' id=\'effstatus\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'greg_date_of_birth\' id=\'greg_date_of_birth\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'greg_date_of_birth_mod\' id=\'greg_date_of_birth_mod\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t\t<input type=\"text\"  name=\"date_of_birth\" id=\"date_of_birth\" maxlength=\"10\" size=\"8\"  value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' onblur=\'calculateAge(this,1);\'  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'date_of_birth\');\" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" >\n\t\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t<td class=\'fields\' width=\"35%\">\n\t\t\t\t<input type=\'text\' name=\"birth_place\" id=\"birth_place\"  onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" >\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t<td class=\"fields\" width=\"30%\">\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</td>\n</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'sub_tab\' id=\'sub_tab\'>\n\n<tr>\n    <td width=\"100%\" class=\"Border\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\" NOWRAP>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t\t<input type=\'text\' name=\"alias_name\" id=\"alias_name\"  \n            onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" >\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\"15%\" NOWRAP>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;\n\t\t\t\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\t\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\n\t\t\t<td class=\'label\' width=\"12%\" NOWRAP>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t\t<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t\t\t<input type=\'text\' name=\"national_id_no\" id=\"national_id_no\"   maxlength=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" onkeypress=\"return ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" onBlur=\"makeValidString(this);validateNationality(this,\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\');\" size=\'15\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" >\n\t\t\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="<img name=\'nat_mandatory\' style=\'visibility:";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t<input type=\'hidden\' name=\'oldnationalid\' id=\'oldnationalid\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t<!--Added for this HSA-CRF-160 -->\t\t\n\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t<td class=\'label\' width=\"15%\" NOWRAP>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t<td class= \'fields\' width=\"30%\"> ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<select name=\"Position\" id=\"Position\" >\n\t\t\t\t\t\t\t <option value=\'\'>--------------- ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="------------------</option>  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" \n\t\t\t\t\t\tselected>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" </option>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" \n\t\t\t\t\t\t>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" </option>\n\n\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t<input type=\'hidden\' name=\"Position\" id=\"Position\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" > \t \n\t\t\t\t<input type=\'text\' name=\"Position1\" id=\"Position1\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" readonly> \n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<td class=\'label\' width=\"15%\" NOWRAP>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t<td class=\"fields\" width=\"30%\" nowrap><select name=\"other_alt_type\" id=\"other_alt_type\" onchange=\"enabledOtherAltId()\" ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="><option value=\'\'>----------";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="---------</option>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t <!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t <option value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</option>\t \n\t ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</select><input type=\'text\' name=\"other_alt_no\" id=\"other_alt_no\" onBlur=\"makeValidString(this);";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="duplicateOthAltIdValidation(this,\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\');";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" maxlength=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' size=\'20\' tabindex=\'18\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =">\n\t ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="<img name=\'oth_alt_mand\' style=\'visibility:";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t        <input type=\'hidden\' name=\"other_alt_no1\" id=\"other_alt_no1\"  value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t </td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"12%\" NOWRAP>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t\t<input type=\'text\' name=\"degree\" id=\"degree\"  \nonBlur=\"makeValidString(this)\" maxlength=\'15\' size=\'15\' \nvalue=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" >\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"12%\" NOWRAP>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t\t<td class=\"fields\" width=\"35%\">\n\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t<select name=\'rep_facility\' id=\'rep_facility\' onClick=\'check7()\'>\n\t\t\t\t<option value=\'\'>------------------------";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="-----------------------------&nbsp;\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t</select><img name=\'mandatory\' style=\'visibility: hidden\' src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\n\t\t\t<td class=\'label\' width=\"15%\" >";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t\t\t\t\n\t\t\t\t<td class= \'fields\' width=\"30%\"> \n\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\t\t\t\t<img src=\'../../eMP/images/mandatory.gif\' align=\'center\'></img></td>\t\n\t</tr>\n\t\t\t\t\t\t\t<TR class=\'label\'><TD colspan =\'4\' id = \'popempid\' class=\'label\'></TD></TR>\t\n\n\t<tr>\n\t\t<td>\n\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t</td>\n\t</tr>\n\t\n\t<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t<td class=\'label\' width=\"15%\" >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="<td width=\"30%\" class=\"fields\"><input type=\'checkbox\' name=\'all_facilities\' id=\'all_facilities\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" onClick=\"check();changeFocus1();\" onblur=\"\" ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" align=\'left\' style=\"padding:0;\"><input type=\'hidden\' name=\'all_facilities1\' id=\'all_facilities1\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"  align=\'left\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="<td width=\"30%\" class=\"fields\"><input type=\'checkbox\'   name=\'all_facilities\' id=\'all_facilities\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" disabled ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" align=\'left\' onblur=\"\"><input type=\'hidden\' name=\'all_facilities1\' id=\'all_facilities1\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="<td  width=\"30%\" class=\"fields\"><input type=\'checkbox\' name=\'all_facilities\' id=\'all_facilities\'  value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" align=\'left\' ><input type=\'hidden\' name=\'all_facilities1\' id=\'all_facilities1\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\n\t</tr>\n\n</table>\n</td>\n</tr>\n</table>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br>\n<a name=\'contactnolink\' id=\'contactnolink\' ></a>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n  \t<td width=\"100%\" class=\"Border\">\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td class=\'label\' width=\"16%\" >";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t<td class=\"fields\" width=\"15%\" ><input type=\'text\'  onfocus=\"tab_click22()\" onBlur=\"makeValidString(this)\" name=\"residencetelno\" id=\"residencetelno\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =" ></td>\n\t<td class=\'label\' width=\"16%\" >";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n\t<td class=\"fields\" width=\"20%\" >\n\t\t<input type=\'text\' name=\"offtelno\" id=\"offtelno\" onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" >\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\'text\' name=\"offtelext\" id=\"offtelext\" onBlur=\"makeValidString(this)\" maxlength=\'6\' size=\'6\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" >\n\t</td>\n\t<td class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\t<td class=\'fields\' width=\"15%\">\n\t\t<input type=\'text\' name=\"faxno\" id=\"faxno\" onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td>\n\t<td class=\'fields\' width=\"20%\">\n\t\t\t<input type=\'text\' name=\"mobileno\" id=\"mobileno\" onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\'text\' name=\"pagerno\" id=\"pagerno\" onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" >\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"15%\" >";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t<td class=\"fields\" width=\"15%\" ><input type=\'text\' name=\'emailid\' id=\'emailid\' onBlur=\"makeValidString(this)\" maxlength=\'50\' size=\'18\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" ></td>\n\t<td class=\'label\' width=\"15%\" >";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</td>\n\t<td class=\"fields\" width=\"20%\">\n\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t</td>\n<!--  \t<td class=\"label\" width=\"40%\" colspan=\'2\'></td>-->\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<br>\n\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n      \t<td width=\"100%\" class=\"Border\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\n</tr>\n\n<tr>\n\t<td class=\"label\" width=\'20%\' colspan=\"1\">&nbsp;</td>\n\t<td   width=\'20%\' class=\'label\'><b>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</b></td>\n\t<td   width=\'20%\' class=\'label\'><b>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</b></td>\n\t<td class=\"label\" colspan=\'1\' width=\"20%\"></td>\n<tr>\n\t<td width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'res_add_ln1\' id=\'res_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'off_add_ln1\' id=\'off_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'mail_add_ln1\' id=\'mail_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" ></td>\n\t<td class=\"label\" colspan=\'1\' width=\"20%\"></td>\n</tr>\n\n<tr>\n\t<td class=\"label\" width=\'20%\' colspan=\"1\"></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'res_add_ln2\' id=\'res_add_ln2\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'off_add_ln2\' id=\'off_add_ln2\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"  onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'mail_add_ln2\' id=\'mail_add_ln2\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" onBlur=\"makeValidString(this)\"  ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" ></td>\n\t<td class=\"label\" colspan=\'1\' width=\"20%\"></td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'20%\' colspan=\"1\"> </td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'res_add_ln3\' id=\'res_add_ln3\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'off_add_ln3\' id=\'off_add_ln3\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'mail_add_ln3\' id=\'mail_add_ln3\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =" ></td>\n\t<td class=\"label\" colspan=\'1\' width=\"20%\"></td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'20%\' colspan=\"1\"> </td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'res_add_ln4\' id=\'res_add_ln4\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'off_add_ln4\' id=\'off_add_ln4\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =" ></td>\n\t<td width=\'20%\' class=\"fields\">\n\t\t<input type=\'text\' name=\'mail_add_ln4\' id=\'mail_add_ln4\' maxlength=\'30\' size=\'20\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =" ></td>\n\t<td class=\"label\" colspan=\'1\' width=\"20%\"></td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n<td width=\'20%\' class=\"fields\">\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\n        <input type=\'text\' name=\'res_add_postal_code\' id=\'res_add_postal_code\' size=\'8\' onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,res_add_postal_code,res_add_postal) \' maxlength=\'8\' ><input type=\"hidden\" name=\"res_add_postal\" id=\"res_add_postal\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code,res_add_postal)\'>\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t<input type=\'text\' name=\'res_add_postal_code2\' id=\'res_add_postal_code2\' size=\'8\' maxlength=\'8\' value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,res_add_postal_code2,res_add_postal2)\' ><input type=\"hidden\" name=\"res_add_postal2\" id=\"res_add_postal2\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code2,res_add_postal2)\'>\n\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t<input type=\'text\' name=\'res_add_postal_code2\' id=\'res_add_postal_code2\' size=\'8\' maxlength=\'8\' onblur=\'if(this.value !=\"\") searchCode(this,res_add_postal_code2,res_add_postal2)\'><input type=\"hidden\" name=\"res_add_postal2\" id=\"res_add_postal2\"><input type=\'button\' onBlur=\"makeValidString(this)\" name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code2,res_add_postal2)\'>\n\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</td>\n\t\n\t<td width=\'20%\' class=\"fields\">\n\t\n\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t<input type=\'text\' onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,off_add_postal_code,off_add_postal)\' name=\'off_add_postal_code\' id=\'off_add_postal_code\' size=\'8\' maxlength=\'8\'><input type=\"hidden\" name=\"off_add_postal\" id=\"off_add_postal\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code,off_add_postal)\'>\n\t        ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t<input type=\'text\' name=\'off_add_postal_code2\' id=\'off_add_postal_code2\' size=\'8\' maxlength=\'8\'  onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,off_add_postal_code2,off_add_postal2)\' value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"  ><input type=\"hidden\" name=\"off_add_postal2\" id=\"off_add_postal2\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code2,off_add_postal2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t<input type=\'text\' name=\'off_add_postal_code2\' id=\'off_add_postal_code2\' onBlur=\'makeValidString(this)  if(this.value !=\"\") searchCode(this,off_add_postal_code2,off_add_postal2)\' size=\'8\' maxlength=\'8\'><input type=\"hidden\" name=\"off_add_postal2\" id=\"off_add_postal2\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code2,off_add_postal2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\n\t<!--";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="-->";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n\t\t\n\t\n\t\t\n\t<td width=\'20%\' class=\"fields\">\n\t\n\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t<input type=\'text\' name=\'mail_add_postal_code\' id=\'mail_add_postal_code\' size=\'8\' onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,mail_add_postal_code,mail_add_postal)\' maxlength=\'8\'><input type=\"hidden\" name=\"mail_add_postal\" id=\"mail_add_postal\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code,mail_add_postal)\'>\n\n\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t<input type=\'text\' onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,mail_add_postal_code2,mail_add_postal2)\' name=\'mail_add_postal_code2\' id=\'mail_add_postal_code2\' size=\'8\' maxlength=\'8\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" ><input type=\"hidden\" name=\"mail_add_postal2\" id=\"mail_add_postal2\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code2,mail_add_postal2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t<input type=\'text\' onBlur=\'makeValidString(this); if(this.value !=\"\") searchCode(this,mail_add_postal_code2,mail_add_postal2)\'  name=\'mail_add_postal_code2\' id=\'mail_add_postal_code2\' size=\'8\' maxlength=\'8\'><input type=\"hidden\" name=\"mail_add_postal2\" id=\"mail_add_postal2\"><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code2,mail_add_postal2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t<!--";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="</td>\n\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t<td width=\'20%\' class=\"fields\">";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="</td>\n\t<td width=\'20%\' class=\"fields\">";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n</tr>\n<tr>\n\t<td  width=\'3%\' class=\'label\'>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="&nbsp;</td>\n\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n</tr>\n</table>\n</td>\n</tr>\n\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n</table>\n\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\n  \t       \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n  \t       \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n  \t     \n\n  \t       ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n               \n  \t       \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n  \t       \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n  \t       \t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\n\n  \t       \t<input type=\'hidden\' name=\'other_staff_type1\' id=\'other_staff_type1\' >\n  \t       \t<input type=\'hidden\' name=\'other_staff_id1\' id=\'other_staff_id1\'  >\n  \t       \t<input type=\'hidden\' name=\'other_staff_name1\' id=\'other_staff_name1\'  >\n  \t       \t<input type=\'hidden\' name=\'short_name1\' id=\'short_name1\' >\n  \t       \t<input type=\'hidden\' name=\'eff_status1\' id=\'eff_status1\' >\n  \t       \t<input type=\'hidden\' name=\'date_of_birth1\' id=\'date_of_birth1\' >\n  \t       \t<input type=\'hidden\' name=\'date_of_birth2\' id=\'date_of_birth2\' >\n  \t       \t<input type=\'hidden\' name=\'otherstaffid\' id=\'otherstaffid\' value=";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" >\n  \t \t    <input type=\'hidden\' name=\'server_date\' id=\'server_date\' value=";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" >\n\t\t    <input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t\t\t<input type=\'hidden\' name=\'long_name1\' id=\'long_name1\' >\n\n\t\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t\t<input type=\"hidden\" name=\"eff_stat\" id=\"eff_stat\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t<input type=\'hidden\' name=\'citizenship_code\' id=\'citizenship_code\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\t\t\t<input type=\'hidden\' name=\'citizen_nat_code\' id=\'citizen_nat_code\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n\t\t\t<input type=\'hidden\' name=\'isResidencyApplYN\' id=\'isResidencyApplYN\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n\t\t\t<input type=\"hidden\" name=\"natid_mand_yn\" id=\"natid_mand_yn\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t\t<input type=\"hidden\" name=\"oth_alt_val\" id=\"oth_alt_val\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\t\t\t<input type=\"hidden\" name=\"other_alt_type_no\" id=\"other_alt_type_no\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t\t\t<input type=\"hidden\" name=\"other_alt_type_desc\" id=\"other_alt_type_desc\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t<input type=\"hidden\" name=\"alt_id1_type\" id=\"alt_id1_type\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t\t\t<input type=\"hidden\" name=\"alt_id1_length\" id=\"alt_id1_length\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t<input type=\"hidden\" name=\"oth_alt_length\" id=\"oth_alt_length\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\n<script>\n\t\tif(\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' == \"T\") \n\t\t{\n\t\t\tdocument.getElementById(\'popempid\').innerHTML=\"Empl ID <input type=\'text\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' name=\'employee_id\' maxlength=\'30\' size =\'30\' READONLY>\";\n\n\t\t}\nfunction echeck10()\n     \t\t{\n     \t\t\tif(OtherStaff1_form.empl_status.value == \"T\")\t\t\t\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input type=\'text\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\' name=\'employee_id\' maxlength=\'30\' size =\'30\' READONLY>\";\n\t\t\t\t\t\n\t\t\t\t}\n     \t\t\telse \t\n     \t\t\t \tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;\";\t\n     \t\t}\nfunction echeck1(Obj)\n     \t\t{\n     \t\t\tif(Obj.value == \"T\") \n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input id=\'employee_id\'  type=\'text\' value=\'\' onBlur=\'makeValidString(this)\'  name=\'employee_id\' maxlength=\'30\' size =\'30\'>\";\t\n\t\t\t\t}\n     \t\t\telse \t\n     \t\t\t \tdocument.getElementById(\'popempid\').innerHTML=\"\";\t\n     \t\t}\nfunction maxLength(field,maxChars)\n {\n       //if(field.value.length >= maxChars) {\n\t   if(field.value.length > maxChars) {\n\t      var errors1 = getMessage(\'OBJ_CANNOT_EXCEED\',\'Common\');\n\t\terrors1 = errors1.replace(\'$\', maxChars);\t\t  \n\t\t  alert(errors1);  \t\n              field.select();\n              field.focus();\t\t  \n          return false;\n       }\n\t   else{\n\t     return true;\n\t   }\n }    \n\nfunction maxLengthPaste(event, field, maxChars) {\n    // Prevent the default paste behavior\n    event.preventDefault();\n\n    // Get the clipboard data\n    let clipboardData;\n    if (event.clipboardData) {\n        clipboardData = event.clipboardData.getData(\'text\');\n    } else if (window.clipboardData) {\n        clipboardData = window.clipboardData.getData(\'Text\');\n    } else {\n        // Fallback if clipboardData is not available\n        return;\n    }\n\n    // Calculate the new length if paste is allowed\n    if ((field.value.length + clipboardData.length) > maxChars) {\n        // Generate the error message\n        const errors1 = getMessage(\'OBJ_CANNOT_EXCEED\', \'Common\').replace(\'$\', maxChars);\n        alert(errors1);\n        return;\n    }\n    field.value += clipboardData;\n}\n\nconst inputField = document.getElementById(\'myInputField\');\ninputField.addEventListener(\'paste\', function(event) {\n    maxLengthPaste(event, this, 100); // For example, limit to 100 characters\n});\n\nfunction ChkKey(evnt)\n{ \n\tif(evnt.keyCode == \'13\')\n\t\treturn false;\n}\n\n//Added for this CRF HAS-CRF-160\nfunction enabledOtherAltId(){  \n        document.OtherStaff1_form.other_alt_no.value=\"\";\n\t\tif(document.OtherStaff1_form.other_alt_type.selectedIndex != 0){ \n\t\t\tdocument.OtherStaff1_form.other_alt_no.disabled = false;\n\t\t\tdocument.OtherStaff1_form.other_alt_no.value=\"\";\n\t\t\tdocument.OtherStaff1_form.other_alt_no1.value=\"\";\n\t\t}else { \n\t\t\tdocument.OtherStaff1_form.other_alt_no.disabled = true;\t\t\t\n\t\t}\n}\n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

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
		
			String locale = (String)session.getAttribute("LOCALE");
			String otherstafftype="";
			String otherstaffid="";
			String otherstaffname="";
			String shortname="";
			String effstatus="";
			String Position="";
			String Position1="";
			String job_title="";
			String birthdate_disp="";
			String max_patient_age="";
			ArrayList position_list = new ArrayList();
		 otherstafftype = request.getParameter("other_staff_type")==null ? "":request.getParameter("other_staff_type");
		 otherstaffid = request.getParameter("other_staff_id")==null ? "":request.getParameter("other_staff_id");
		 otherstaffname = request.getParameter("other_staff_name")==null ? "":request.getParameter("other_staff_name");
		 shortname=request.getParameter("short_name")==null ? "":request.getParameter("short_name");
		 effstatus = request.getParameter("eff_staus")==null ? "":request.getParameter("eff_staus");

		  
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

      	Connection conn = null; 
		conn = ConnectionManager.getConnection(request);	

		/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
		Boolean isResidencyApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
		Boolean isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
		String natid_mand_yn = eAM.AMCommonBean.getNatIdMandYN(conn);
		String oth_alt_val = eAM.AMCommonBean.getOthAltDefaultValue(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
		String citizen_nat_code = "";
		String citizenship_code = "";
		String citizenChk = "Checked";
		String nonCitizenChk = "";
		String natIdDis = "";
		String nat_visibility = "";
		String other_alt_type_dis = "";
		String other_alt_no_dis = "disabled";
		String oth_alt_visibility = "hidden";
		String alt_id1_type = "";
		String alt_id1_length = "";
		String oth_alt_length = "20";
		/*End MOHE-CRF-0011*/
      	
      	String accept_national_id_no_yn = "N",nat_id_prompt="",nat_id_chk_len="",nat_id_check_digit_id="",nat_data_source_id="";
      		
		if(otherstaffid==null) otherstaffid = "null";
		String shortdesc="";
		String strt="";
    	String strt1="";
    	String strt2="";
      	String otherstafftype1="";
   	 	String str1="";
   	 	String strs1="";
   	 	String strs2="";
		String str2="";
		String strm1="";
		String strm2="";
		String str3="";
		String strc1="";
		String strc2="";
		String str4="";
		String strr1="";
		String strr2="";
		String str5="";
		String stre1="";
		String stre2="";
		String str6="";
		String strp1="";
		String strp2="";
		String str7="";
		String strrep1="";
		String strrep2="";
		String str8="";
		String strrec1="";
		String strrec2="";
		String strofp1="";
		String strofp2="";
		String str10="";
		String strofc1="";
		String strofc2="";
		String strmap1="";
		String strmap2="";
		String str12="";
		String strmac1="";
		String strmac2="";
		String str13="";
		String str14="";
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";
		String birthplace="";
		String maritalstatus="";
		String maritaldesc="";
		String maritalstatus1="";
		String maritaldesc1="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		String shortdesc1="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";
		String allfacilities="";
		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";
		String rescountrycode1="";
		String rescountrydesc1="";
		String offcountrycode="";
		String offcountrydesc="";
		String offcountrycode1="";
		String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		String mailcountrycode1="";
		String mailcountrydesc1="";
		String Position_one="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		int count=0;
   	 	String codeTextAttribute="";
		String otherTextAttribute="";
		String checkBoxAttribute="";
		String checkBoxAttribute1="";
		String eventFunctionForCase="";
		String fcall="";		
		String cnc = "";
		String employeeid ="";
		String disablerecord="";
		String nat_id_accept_alphanumeric_yn="";
		String longname="";
		String longname1="";
		
		//Added HSA-CRF-160
		Statement other_altstat=null;
		ResultSet other_altrs=null;
		String alt_type_code="",alt_type_desc="",other_alt_type_no="",other_alt_type_desc="",other_alt_select="";


			PreparedStatement pstmtsv=null;
			ResultSet rsv = null;

		try{

			String sql_maxage="select max_patient_age, citizen_nationality_code citizen_nat_code, alt_id1_type, alt_id1_length from mp_param_lang_vw mp_param  WHERE  module_id = 'MP' AND language_id = '"+locale+"'";
			pstmtsv=conn.prepareStatement(sql_maxage);
			rsv=pstmtsv.executeQuery();
			if(rsv.next())
			{
		  		max_patient_age=rsv.getString("max_patient_age");
				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizen_nat_code = rsv.getString("citizen_nat_code");
				if (citizen_nat_code == null || citizen_nat_code.equals("null")) citizen_nat_code = "";
				alt_id1_type = rsv.getString("alt_id1_type");
				if (alt_id1_type == null || alt_id1_type.equals("null")) alt_id1_type = "";
				alt_id1_length = rsv.getString("alt_id1_length");
				if (alt_id1_length == null || alt_id1_length.equals("null")) alt_id1_length = "";

			}
			if(pstmtsv != null) pstmtsv.close();
		      if(rsv != null) rsv.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
			 e.printStackTrace();
		     }

		PreparedStatement pstmt9=null;
		ResultSet rs9=null;
		String sql9="select to_char(sysdate,'dd/mm/yyyy') from dual";	
		pstmt9=conn.prepareStatement(sql9);
		rs9=pstmt9.executeQuery();
					  	
		if(rs9.next())
		{		  	
		str13=rs9.getString(1);
		}
			
	try{
      	boolean newOtherStaff=false;
   	 	fcall = request.getParameter("fcall")==null ? "":request.getParameter("fcall"); 

			String male=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			String female=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			String unknown=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			String defaultselect=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
			String associate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
			String fulltime=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
			String PartTime=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
			String Visitor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
			String email=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
			String fax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
			String mobile=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");
			String office=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
			String pager=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
			String residence =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
//out.println("<script>alert(\"otherstaffid:"+otherstaffid+"\");</script>");

   	 	if(otherstaffid==null || otherstaffid.equals("") || otherstaffid.equals("null")) 
			{
			
		  
   	 		otherstaffid = "";
			otherstaffname="";
			shortname="";
   	 		str1="<select name='sex' id='sex' ><option value='M'>"+male+"<option value='F'>"+female+"<option value='U'>"+unknown+"</select>";
			birthdate="";
			birthplace="";
   	 		PreparedStatement pstmtty = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1= null;
			PreparedStatement pstmt2= null;
   	 		PreparedStatement pstmt4=null;
			PreparedStatement pstmt6=null;
			PreparedStatement pstmt8=null;
			PreparedStatement pstmt10=null;
			PreparedStatement pstmtf=null;
			PreparedStatement pstmtc=null;
			ResultSet rst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs4= null;
			ResultSet rs6=null;
			ResultSet rs8=null;
			ResultSet rs10=null;
			ResultSet rsf=null;
			ResultSet rsc=null;

	

			
try{

			String sqlf="select count(*) as total from sm_facility_param";
			pstmtf=conn.prepareStatement(sqlf);
			rsf=pstmtf.executeQuery();
			if(rsf.next())
			{
				count=rsf.getInt("total");
			}if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
			 e.printStackTrace();
		     }
		try {
		  	String sqlt="select other_staff_type,short_desc from am_other_staff_type where eff_status='E' order by short_desc";
		  	pstmtty=conn.prepareStatement(sqlt);
			rst=pstmtty.executeQuery();
		  	strt="<select name='other_staff_type' id='other_staff_type' onChange='checkPosition(this.form,this)' ><option value=''>---------"+defaultselect+"--------------";
		  	 while(rst.next()) 
		  	 {
		  		otherstafftype=rst.getString("other_staff_type");
		  		shortdesc=rst.getString("short_desc");
		  		strt=strt+"<option value='"+ otherstafftype+"' onClick='checkothersatff()' >"+shortdesc;

		  	 }if(pstmtty != null) pstmtty.close();
		      if(rst != null) rst.close();
		  	 
		  	strt=strt+"</select>";
			String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and 		  	nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			str2="<select name='marital_status' id='marital_status' ><option value=''>---"+defaultselect+"-----";
			 while(rs.next())
			 {
				maritalstatus=rs.getString("mar_status_code");
				if(maritalstatus == null) maritalstatus="";
				maritaldesc=rs.getString("short_desc");
				str2=str2+"<option value='"+maritalstatus+"'>"+maritaldesc+"</option>";
			 }if(pstmt != null) pstmt.close();
		      if(rs != null) rs.close();
			str2=str2+"</select>";
			String sqlc="select citizen_nationality_code from mp_param";
			pstmtc=conn.prepareStatement(sqlc);
			rsc=pstmtc.executeQuery();
			if(rsc != null)
			{		
				while(rsc.next())
				{
					cnc=rsc.getString("citizen_nationality_code");
				}	
			}if(pstmtc != null) pstmtc.close();
		      if(rsc != null) rsc.close();

			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))  and long_desc is not null order by long_desc ";
			pstmt1=conn.prepareStatement(sql1);
			rs1=pstmt1.executeQuery();
			//Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN){
				str3="<select name='citizen' id='citizen' onChange='checkCitznOrNonCitzn();'><option value=''>---"+defaultselect+"-----"+"</option>";
			}else
			{
				str3="<select name='citizen' id='citizen'><option value=''>---"+defaultselect+"-----"+"</option>";
			}
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

				if(cnc.equals(citizen)) 
				{
					str3=str3+"<option value='"+citizen+"' selected>"+citizendesc+"</option>";
				}
				else 
				{
					str3=str3+"<option value='"+citizen+"'>"+citizendesc+"</option>";
				}
			 }
			 if(pstmt1 != null) pstmt1.close();
		      if(rs1 != null) rs1.close();
			str3=str3+"</select>";
			String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name ";
			pstmt2=conn.prepareStatement(sql2);
			rs2=pstmt2.executeQuery();
			 while(rs2.next())
			 {
				repfacility=rs2.getString("facility_id");
				if(repfacility == null) repfacility="";
				repfacilityname=rs2.getString("facility_name");
				str4=str4+"<option value='"+repfacility+"'>"+repfacilityname+"</option>" ;
			 }if(pstmt2 != null) pstmt2.close();
		      if(rs2 != null) rs2.close();
			str4=str4+"</select>";
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt4=conn.prepareStatement(sql4);
			rs4=pstmt4.executeQuery();
			str8="<select name='res_add_country_code' id='res_add_country_code'><option value=''>---"+defaultselect+"-----"+"</option>";
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
				str8=str8+"<option value='"+rescountrycode+"'>"+rescountrydesc+"</option>";
			}if(pstmt4 != null) pstmt4.close();
		      if(rs4 != null) rs4.close();
			 str8=str8+"</select>";
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt6=conn.prepareStatement(sql6);
			rs6=pstmt6.executeQuery();
			str10="<select name='off_add_country_code' id='off_add_country_code'><option value=''>---"+defaultselect+"-----"+"</option>";
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  		str10=str10+"<option value='"+offcountrycode+"'>"+offcountrydesc+"</option>";
		  	 } if(pstmt6 != null) pstmt6.close();
		      if(rs6 != null) rs6.close();
		  	 str10=str10+"</select>";
		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
		   	pstmt8=conn.prepareStatement(sql8);
			rs8=pstmt8.executeQuery();
		  	str12="<select name='mail_add_country_code' id='mail_add_country_code' onBlur=document.getElementById('residencetelno').focus()><option value=''>---"+defaultselect+"-----"+"</option>";
		  	 while (rs8.next())
		  	 {
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  		str12=str12+"<option value='"+mailcountrycode+"'>"+mailcountrydesc+"</option>";
		  	 }
			 if(pstmt8 != null) pstmt8.close();
		      if(rs8 != null) rs8.close();
		  	 str12=str12+"</select>";
		  	String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id,nat_id_accept_alphanumeric_yn from mp_param";
		  	pstmt10=conn.prepareStatement(sql10);
		  	rs10=pstmt10.executeQuery();
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			str14=rs10.getString(1);
		  			accept_national_id_no_yn=rs10.getString(2);
		  			if(accept_national_id_no_yn == null) accept_national_id_no_yn ="N";
		  			nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt="National ID  No";
		  			nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
		  			nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
		  			nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs10.getString("nat_id_accept_alphanumeric_yn");
		  			
		  		}	
		  	}	
			if(pstmt10 != null) pstmt10.close();
		      if(rs10 != null) rs10.close();
		 }catch(Exception e)
		{
			out.println("ERROR is -->"+e);
			e.printStackTrace();
		}finally
		{
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs4 != null) rs4.close();
			if (rs6 != null) rs6.close();
			if (rs8 != null) rs8.close();
			if (rs9 != null) rs9.close();
			if (rs10 != null) rs10.close();
			if (rsc != null) rsc.close();
			if (rsf != null) rsf.close();
			if (pstmtty != null)pstmtty.close();
			if (pstmt != null)  pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt2 != null) pstmt2.close();
			if (pstmt4 != null) pstmt4.close();
			if (pstmt6 != null) pstmt6.close();
			if (pstmt8 != null) pstmt8.close();
			if (pstmt9 != null) pstmt9.close();
			if (pstmt10 != null)pstmt10.close();
			if (pstmtc != null) pstmtc.close();

		}

		effstatus="E";
		bage="";
		aliasname="";
		nationalidno="";
		Position="";
		str5="<select name='empl_status' id='empl_status' onChange='echeck1(this);'><option value=''>----------"+defaultselect+"---------<option value='S'>"+associate+"<option value='F'>"+fulltime+"<option value='P'>"+PartTime+"<option value='V'>"+Visitor+"</select>";
		degree="";
		allfacilities="N";
		restelnum="";
		offtelnum="";
		offtelext="";
		pagernum="";
		faxnum="";
		mobilenum="";
		emailid="";
		str6="<select name='pref_contact_mode' id='pref_contact_mode'><option value=''>----------"+defaultselect+"---------<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+"</select>";
		resaddln1="";
		resaddln2="";
		resaddln3="";
		resaddln4="";
		offaddln1="";
		offaddln2="";
		offaddln3="";
		offaddln4="";
		mailaddln1="";
		mailaddln2="";
		mailaddln3="";
		mailaddln4="";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";

		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";
		newOtherStaff=true;
		//Below Modified by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
		if(isSplCharNotAllowApplYN)
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this);CheckSplCharsforIdValidation(this)'";		
			}
			else 
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";		
			}
		}
	else
	{

		PreparedStatement pstmtstmt=null;
		PreparedStatement pstmt10=null;
		PreparedStatement pstmt11=null;
		PreparedStatement pstmt12=null;
		PreparedStatement pstmt13=null;
		PreparedStatement pstmt14=null;
		PreparedStatement pstmt15=null;
		PreparedStatement pstmt17=null;
		PreparedStatement pstmt19=null;
		PreparedStatement pstmt21=null;
		PreparedStatement pstmt25=null;
		PreparedStatement pstmt26=null;
		PreparedStatement pstmt27=null;
		PreparedStatement pstmtp=null;
		PreparedStatement pstmtm=null;
		PreparedStatement pstmtc=null;
		PreparedStatement pstmtr=null;
		PreparedStatement pstmtrec=null;
		PreparedStatement pstmtofc=null;
		PreparedStatement pstmtmac=null;
		PreparedStatement pstmtf=null;
		ResultSet rset=null;
		ResultSet rs10=null;
		ResultSet rs12=null;
		ResultSet rs13=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs17=null;
		ResultSet rs19=null;
		ResultSet rs21=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrec=null;
		ResultSet rsofc=null;
		ResultSet rsmac=null;
		ResultSet rsf=null;
		ResultSet rss=null;
try{
					String sqlf="select count(*) as total from sm_facility_param";
					pstmtf=conn.prepareStatement(sqlf);
					rsf=pstmtf.executeQuery();
					if(rsf != null)
					{     
						while(rsf.next())
						{
							count=rsf.getInt("total");
						}	
					}	if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

				    }catch(Exception e) {
				    out.println("errors="+e);
					e.printStackTrace();
				     }
		
	try
		{   
		//Modified for this HAS-CRF-160
		
			sql11 ="select other_staff_id,other_staff_name,short_name,other_staff_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,position_code,empl_status,employee_id,degree,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status ,JOB_TITLE,LONG_NAME,OTH_ALT_ID_TYPE, OTH_ALT_ID_NO from am_other_staff where other_staff_id=?";			
			pstmt11 = conn.prepareStatement(sql11);
			pstmt11.setString(1,otherstaffid);
			rset=pstmt11.executeQuery();
			System.out.println("rset"+rset);
			rset.next();
			  	otherstaffid=rset.getString("other_staff_id");
				otherstaffname=rset.getString("other_staff_name");
				shortname=rset.getString("short_name");
				 sex=rset.getString("gender");
				 allfacilities=rset.getString("all_facilities_yn");
				
				employeeid=rset.getString("employee_id");
				 otherstafftype=rset.getString("other_staff_type");
				 Position=rset.getString("position_code");
				 System.out.println("Position"+Position);
				job_title=rset.getString("JOB_TITLE");
				longname=rset.getString("LONG_NAME");
				if(longname == null) longname = "";
				
				//Added  for this HAS-CRF-160
				other_alt_type_no=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
                other_alt_type_desc=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");
				
				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizenship_code = rset.getString("citizenship_code");
				if(citizenship_code == null) citizenship_code = "";
				
				 if(Position==null || Position.equals("null"))
			{
                 Position="";
			}
				 effstatus=rset.getString("eff_status");
				 System.out.println("effstatus"+effstatus);
				 
		try
			{
						
				if(effstatus.equals("E"))
				{
				String sqlsql="select position_desc,position_code from am_position where role_type='O' and (staff_type is null or staff_type=?) and eff_status='E' order by position_desc";
				pstmtstmt=conn.prepareStatement(sqlsql);
				System.out.println("sqlsql"+sqlsql);
				pstmtstmt.setString(1,otherstafftype);
				
				rss=pstmtstmt.executeQuery();
				System.out.println("rss"+rss);
				while(rss.next())
				{
					position_list.add(rss.getString("position_code"));
					position_list.add(rss.getString("position_desc"));

					Position_one=rss.getString("position_code");
					Position1=rss.getString("position_desc");
				}
				System.out.println("position_list"+position_list);
				
				if(pstmtstmt != null) pstmtstmt.close();
		      if(rss != null) rss.close();
				}
				else
				{
					String sqlsql="select position_desc,position_code from am_position where role_type='O' and (staff_type is null or staff_type=?) and eff_status='E' and position_code='"+Position+"' order by position_desc";
					pstmtstmt=conn.prepareStatement(sqlsql);
					pstmtstmt.setString(1,otherstafftype);
					rss=pstmtstmt.executeQuery();
					while(rss.next())
						{
							
							Position=rss.getString("position_code");
							Position1=rss.getString("position_desc");

					
						}
						if(pstmtstmt != null) pstmtstmt.close();
		      if(rss != null) rss.close();
				}
			}catch(Exception e)
				{
					e.printStackTrace();
				}
		if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()' >";
				str1=str1+"<option value='M' selected>"+male+"<option value='F'>"+female+"<option value='U'>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("F")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()'>";
				str1=str1+"<option value='M' >"+male+"<option value='F' selected>"+female+"<option value='U'>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("U")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()'>";
				str1=str1+"<option value='M' >"+male+"<option value='F'>"+female+"<option value='U' selected>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
				emplstatus=rset.getString("empl_status");
				
				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
                        		str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+"<option value='F' selected>"+fulltime+"<option value='P'>"+PartTime+"<option value='V'>"+Visitor+" </select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+"<option value='F' >"+fulltime+"<option value='P' selected>"+PartTime+"<option value='V'>"+Visitor+" </select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();echeck10()'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+" <option value='F' >"+fulltime+"<option value='P'>"+PartTime+"<option value='V' selected>"+Visitor+"</select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				else if(emplstatus.equals("S")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S' selected>"+associate+" <option value='F' >"+fulltime+"<option value='P'>"+PartTime+"<option value='V' >"+Visitor+"</select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}

			prefmode=rset.getString("pref_contact_mode");
			if(prefmode != null) 
				{
					 if (prefmode.equals("R")) 
					 {															
						 prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' selected>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if (prefmode.equals("O")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O' selected>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("F")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F' selected>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' >"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("M")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M' selected>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' >"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("P")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P' selected>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("E")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E' selected>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals(" ") || prefmode.equals("null")) 
					{
						prefmode1="---"+defaultselect+"-----";
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value='' selected>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
			     }else{
					prefmode=" ";
					prefmode1=" ";
			str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value='' selected>---"+defaultselect+"-----";
			str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' selected>"+residence+" </select>";
					strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
					strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
			     }

			java.util.Date date2 = rset.getDate("date_of_birth");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);
			birthdate_disp=DateUtils.convertDate(birthdate,"DMY","en",localeName);

			formatter1 = null;
			String sqldb="select calculate_age(?,1) from dual";
			pstmt25=conn.prepareStatement(sqldb);
			pstmt25.setString(1,birthdate);
			rs25=pstmt25.executeQuery();
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}

			
			
			if (rs25 != null) rs25.close();
		if (pstmt25 != null) pstmt25.close();
			if(bage==null) bage="";
			String sqldb1="select calculate_age(?,2) from dual";
			pstmt26=conn.prepareStatement(sqldb1);
			pstmt26.setString(1,birthdate);
			rs26=pstmt26.executeQuery();
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}if (rs26 != null) rs26.close();
		     if (pstmt26 != null) pstmt26.close();
			
			if(bmonths==null) bmonths="";
			String sqldb2="select calculate_age(?,3) from dual";
			pstmt27=conn.prepareStatement(sqldb2);
			pstmt27.setString(1,birthdate);
			rs27=pstmt27.executeQuery();
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	if (rs27 != null) rs27.close();
		     if (pstmt27 != null) pstmt27.close();
			if(bdays==null) bdays="";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace="";

			aliasname=rset.getString("alias_name");
			if(aliasname == null) aliasname="";
			nationalidno=(rset.getString("national_id_num")==null || rset.getString("national_id_num").equals("null"))? "":rset.getString("national_id_num");
			degree=rset.getString("degree");
			if(degree == null) degree="";
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="";
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="";
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="";
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="";
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="";
			resaddln1=rset.getString("res_add_ln1");
			if(resaddln1==null) resaddln1="";
			resaddln2=rset.getString("res_add_ln2");
			if(resaddln2==null) resaddln2="";
			resaddln3=rset.getString("res_add_ln3");
			if(resaddln3==null) resaddln3="";
			resaddln4=rset.getString("res_add_ln4");
			if(resaddln4==null) resaddln4="";
			offaddln1=rset.getString("off_add_ln1");
			if(offaddln1==null) offaddln1="";
			offaddln2=rset.getString("off_add_ln2");
			if(offaddln2==null) offaddln2="";
			offaddln3=rset.getString("off_add_ln3");
			if(offaddln3==null) offaddln3="";
			offaddln4=rset.getString("off_add_ln4");
			if(offaddln4==null) offaddln4="";
			mailaddln1=rset.getString("mail_add_ln1");
			if(mailaddln1==null) mailaddln1="";
			mailaddln2=rset.getString("mail_add_ln2");
			if(mailaddln2==null) mailaddln2="";
			mailaddln3=rset.getString("mail_add_ln3");
			if(mailaddln3==null) mailaddln3="";
			mailaddln4=rset.getString("mail_add_ln4");
			if(mailaddln4==null) mailaddln4="";
			if ( rset.getDate("eff_date_from") != null )
			{
				//java.util.Date date = rset.getDate("eff_date_from");
				// formatter = new SimpleDateFormat ("dd/MM/yyyy");
				//date = null;
				//formatter = null;
			}
			if ( rset.getDate("eff_date_to") != null)
			{
				//java.util.Date date1 = rset.getDate("eff_date_to");
				// formatter = new SimpleDateFormat ("dd/MM/yyyy");
				
			        //date1 = null;
				//formatter = null;
			}

			effstatus=rset.getString("eff_status");
			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				disablerecord="disabled";
				checkBoxAttribute="";

			}else
			{

				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
 			}
			String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id, nat_id_accept_alphanumeric_yn from mp_param";
			pstmt10=conn.prepareStatement(sql10);
			rs10=pstmt10.executeQuery();
			if(rs10 != null)
			{		
				while(rs10.next())
				{
					str14=rs10.getString(1);
					accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn="N";
					nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt="National ID No";
					nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
					nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
					nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					
					allfacilities=rset.getString("all_facilities_yn");
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs10.getString("nat_id_accept_alphanumeric_yn");
				}	
			}	if (rs10 != null) rs10.close();
		         if (pstmt10 != null) pstmt10.close();
			if(effstatus.equals("E") || effstatus.equals("D"))
			{
				if(allfacilities.equals("Y"))
					checkBoxAttribute1="CHECKED";
				else
					checkBoxAttribute1=" ";
			}
			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="";
			strrep1="<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='15' maxlength='15' value='"+respostalcode+"' readonly>";
			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)
			{
				String sqlrec="select short_name from mp_country where country_code=? ";
				pstmtrec=conn.prepareStatement(sqlrec);
				pstmtrec.setString(1,rescountrycode);
				rsrec=pstmtrec.executeQuery();
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	if (rsrec != null) rsrec.close();
		if (pstmtrec != null) pstmtrec.close();
			}
			else
			{
				rescountrydesc=" ";
			}
			String sql17="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt17=conn.prepareStatement(sql17);
			rs17=pstmt17.executeQuery();
			str8="<select name='res_add_country_code' id='res_add_country_code' onClick='check9()'><option value=''>---"+defaultselect+"-----";
			if(rs17 !=null)
			{
			 while(rs17.next())
			 {
				rescountrycode1=rs17.getString("country_code");
				rescountrydesc1=rs17.getString("short_name");
				if((rescountrycode1.equals(rescountrycode)) && (rescountrydesc1.equals(rescountrydesc)))
				{

					str8=str8+"<option value='"+rescountrycode1+"' selected>"+rescountrydesc1;
				}
				else 
				{
					str8=str8+"<option value='"+rescountrycode1+"' >"+rescountrydesc1;
				}
			 }
			} if (rs17 != null) rs17.close();
		if (pstmt17 != null) pstmt17.close();
			str8=str8+"</select>";
			strrec1="<input type='text' name='res_add_country_code1' id='res_add_country_code1' size='15' maxlength='15' value='"+rescountrydesc+"' readonly>";
			if(rescountrycode == null) 
			{
				strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(rescountrycode != null) 
			{
				if(effstatus.equals("E")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
				else if(effstatus.equals("D")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
			}

			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="";
			strofp1="<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' size='15' maxlength='15' value='"+offpostalcode+"' readonly>";
			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					String sqlofc="select short_name from mp_country where country_code=? ";
					pstmtofc=conn.prepareStatement(sqlofc);
					pstmtofc.setString(1,offcountrycode);
					rsofc=pstmtofc.executeQuery();
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	if (rsofc != null) rsofc.close();
		                if (pstmtofc != null) pstmtofc.close();
			}
			else
			{
					offcountrydesc= " ";
			}

			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt19=conn.prepareStatement(sql19);
			rs19=pstmt19.executeQuery();

			str10="<select name='off_add_country_code' id='off_add_country_code' onClick='check11()'><option value=''>---"+defaultselect+"-----";
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				offcountrycode1=rs19.getString("country_code");
				offcountrydesc1=rs19.getString("short_name");
				if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' selected>"+offcountrydesc1;
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}
				else if((offcountrycode == null) && (offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}

			 }
			}   
			
			if (rs19 != null) rs19.close();
		                if (pstmt19 != null) pstmt19.close();
			str10=str10+"</select>";
			strofc1="<input type='text' name='off_add_country_code1' id='off_add_country_code1' size='15' maxlength='15' value='"+offcountrydesc+"' readonly>";
			if(offcountrycode == null)
			{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(offcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
			}

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode==null || mailpostalcode.equals("null")) mailpostalcode="";
			
			
			strmap1="<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' size='15' maxlength='15' value='"+mailpostalcode+"' readonly>";
			
			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			String sqlmac="select short_name from mp_country where country_code=? ";
			pstmtmac=conn.prepareStatement(sqlmac);
			pstmtmac.setString(1,mailcountrycode);
			rsmac=pstmtmac.executeQuery();
			
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }			if (rsmac != null) rsmac.close();
		                if (pstmtmac != null) pstmtmac.close();
			}
			else
			{
				mailcountrydesc=" ";
			}

			String sql21="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))order by short_name";
			pstmt21=conn.prepareStatement(sql21);
			rs21=pstmt21.executeQuery();
			str12="<select name='mail_add_country_code' id='mail_add_country_code' onClick='check13()'><option value=''>---"+defaultselect+"-----";
			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					mailcountrycode1=rs21.getString("country_code");
					mailcountrydesc1=rs21.getString("short_name");
					if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' selected>"+mailcountrydesc1;
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}
					else if((mailcountrycode == null) && (mailcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}

			 }
			} if (rs21 != null) rs21.close();
		                if (pstmt21 != null) pstmt21.close();
			
			str12=str12+"</select>";
			strmac1="<input type='text' name='mail_add_country_code1' id='mail_add_country_code1' size='15' maxlength='15' value='"+mailcountrydesc+"' readonly onBlur='document.getElementById('residencetelno').focus()'>";
			if(mailcountrycode == null)
			{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(mailcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
			}
repfacility=rset.getString("reporting_facility_id");
if(repfacility == null) repfacility="";

			if(repfacility != null)
			{
				String sqlr="select facility_name from sm_facility_param where facility_id=? ";
				pstmtr = conn.prepareStatement(sqlr);
				pstmtr.setString(1,repfacility);
				rsr=pstmtr.executeQuery();
				if(rsr != null )
				{
					while(rsr.next())
					{
						repfacilityname=rsr.getString("facility_name");
					}	
				}	if (rsr != null) rsr.close();
		            if (pstmtr != null) pstmtr.close();
			}
			else
				{
					repfacilityname=" ";
				}

				String sql15="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
				pstmt15=conn.prepareStatement(sql15);
				rs15=pstmt15.executeQuery();
				if(rs15 != null)
				{
				 while (rs15.next())
				 {
					repfacility1=rs15.getString("facility_id");
					if(repfacility1 == null) repfacility1="";
					repfacilityname1=rs15.getString("facility_name");
					if((repfacility1.equals(repfacility)) && (repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"' selected>"+repfacilityname1;
					}
					else if((!repfacility1.equals(repfacility)) && (!repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"'>"+repfacilityname1;
					}
					else if((repfacility == null) && (repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"'>"+repfacilityname1;
					}
				 }
				}
				if (rs15 != null) rs15.close();
		            if (pstmt15 != null) pstmt15.close();
				str4=str4+"</select>";
				strr1="<input type='text' name='rep_facility1' id='rep_facility1' size='30' maxlength='30' value='"+repfacilityname+"' readonly>";
				if(repfacility == null)
				{
				strr2="<input type='hidden' name='rep_facility2' id='rep_facility2' size='15' maxlength='15' value=''>";
				}
				else if(repfacility != null)
				{
				if(effstatus.equals("E"))
				{
				strr2="<input type='hidden' name='rep_facility2' id='rep_facility2' size='15' maxlength='15' value='"+repfacility+"'>";
				}
				else if(effstatus.equals("D"))
				{
				strr2="<input type='hidden' name='rep_facility' id='rep_facility' size='15' maxlength='15' value='"+repfacility+"'>";
				}
 			}
			otherstafftype=rset.getString("other_staff_type");
			String sqlp="select short_desc from am_other_staff_type where other_staff_type=? ";
			pstmtp=conn.prepareStatement(sqlp);
			pstmtp.setString(1,otherstafftype);
			rsp=pstmtp.executeQuery();
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					shortdesc=rsp.getString("short_desc");
				}	
			}	    if (rsp != null) rsp.close();
		            if (pstmtp != null) pstmtp.close();

			String sql12 = "select other_staff_type,short_desc from am_other_staff_type where eff_status='E' order by short_desc";
			pstmt12=conn.prepareStatement(sql12);
			rs12=pstmt12.executeQuery();
			strt="<select name='other_staff_type' id='other_staff_type' onClick='checkOtherStaff();check1()' onChange='checkPosition(this.form,this)' ><option  value=''>-----"+defaultselect+"-------";			
			if(rs12 != null)
			{
			while (rs12.next())
			{
				otherstafftype1=rs12.getString("other_staff_type");
				
				shortdesc1=rs12.getString("short_desc");
				if((otherstafftype1.equals(otherstafftype)) && (shortdesc1.equals(shortdesc)))
				{
					strt=strt+"<option value='"+otherstafftype+"' selected>"+shortdesc1;
						if(effstatus.equals("E"))
								{

								strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
								}
				}
				else if((!otherstafftype1.equals(otherstafftype)) && (!shortdesc1.equals(shortdesc)))
				{
					strt=strt+"<option value='"+otherstafftype1+"'>"+shortdesc1;
					if(effstatus.equals("E"))
					{
						strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
					}
				}

			 }
		        }if (rs12 != null) rs12.close();
		            if (pstmt12 != null) pstmt12.close();
			strt=strt+"</select>";
			strt1="<input type='text' name='other_staff_type2' id='other_staff_type2' size='15' maxlength='15' value='"+shortdesc+"' readonly>";

 			if(effstatus.equals("D"))
 			{
 				strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
 			}
			
	
 				maritalstatus=rset.getString("mar_status_code");
				if(maritalstatus == null) maritalstatus="";
 			if(maritalstatus != null)
 			{

 				String sqlm="select short_desc from mp_marital_status where mar_status_code=?";
 				pstmtm=conn.prepareStatement(sqlm);
				pstmtm.setString(1,maritalstatus);
 				rsm=pstmtm.executeQuery();
 				if(rsm != null)
 				{
 					while(rsm.next())
 					{
 						maritaldesc=rsm.getString("short_desc");
 					}	
 				}	
 			}
 			else
 			{
 				maritaldesc=" ";
 			}
 			String sql13="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc";
 			pstmt13=conn.prepareStatement(sql13);
 			rs13=pstmt13.executeQuery();
 			str2="<select name='marital_status' id='marital_status' onClick='check5()' ><option value=''>---"+defaultselect+"-----";
 			if(rs13 != null)
 			{
 			 while (rs13.next())
 			 {
 				maritalstatus1=rs13.getString("mar_status_code");
				if(maritalstatus1 == null) maritalstatus1="";
 				maritaldesc1=rs13.getString("short_desc");
				
 				if((maritalstatus1.equals(maritalstatus)) && (maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"' selected>"+maritaldesc1;
					}
 				}
 				else if((!maritalstatus1.equals(maritalstatus)) && (!maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"' >"+maritaldesc1;
					}
 				}
 				else if ((maritalstatus == null) && (maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"'>"+maritaldesc1;
					}
 				}
 			 }
 		        } if (rs13 != null) rs13.close();
		if (pstmt13 != null) pstmt13.close();	
 			str2=str2+"</select>";

 			strm1="<input type='text' name='marital_status1' id='marital_status1' size='15' maxlength='15' value='"+maritaldesc+"' readonly>";
 			if(maritalstatus == null)
 			{
 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			else if(maritalstatus != null)
 			{
 			if(effstatus.equals("E"))
 			{

 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			if(effstatus.equals("D"))
 			{
 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			}
	
			citizen=rset.getString("citizenship_code");
			if (citizen == null) citizen="";
			if(citizen != null)
 			{
 				String sqlc="select long_desc from mp_country where country_code=?";
 				pstmtc=conn.prepareStatement(sqlc);
				pstmtc.setString(1,citizen);
 				rsc=pstmtc.executeQuery();
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");
						if(citizendesc==null)citizendesc="";
 					}	
 				}	 if (rsc != null) rsc.close();
		if (pstmtc != null) pstmtc.close();
 			}
 			else
 			{
 				citizendesc="";
 			}
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and long_desc is not null order by long_desc";
 			pstmt14=conn.prepareStatement(sql14);
 			rs14=pstmt14.executeQuery();
			//Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN){
 				str3="<select name='citizen' id='citizen' onChange='checkCitznOrNonCitzn();' onClick='check6()'><option value=''>---"+defaultselect+"-----";
			}else
			{
				str3="<select name='citizen' id='citizen' onClick='check6()'><option value=''>---"+defaultselect+"-----";
			}
 			if(rs14 != null)
 			{
 			while (rs14.next())
 			{
 				citizen1=rs14.getString("country_code");
 				if(citizen1 == null) citizen1="";
 				citizendesc1=rs14.getString("long_desc");
 				if (citizendesc1==null)citizendesc1="";
 				if((citizen1.equals(citizen)) && (citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"' selected>"+citizendesc1;
 				}
 				else if((!citizen1.equals(citizen)) && (!citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"'>"+citizendesc1;
 				}
 				else if((citizen == null) && (citizendesc.equals("")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"'>"+citizendesc1;

 				}
 			 }
 			} if (rs14 != null) rs14.close();
		if (pstmt14 != null) pstmt14.close();
			
 			str3=str3+"</select>";

 			strc1="<input type='text' name='citizen1' id='citizen1' size='15' maxlength='15' value='"+citizendesc+"' readonly>";

 			if(citizen==null)
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value=''>";
 			}
 			else if(citizen != null)
 			{

 			if(effstatus.equals("E"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}
 			else if(effstatus.equals("D"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}

 			}
		}catch(Exception e) {
					e.printStackTrace();
				    }
			finally     {		
								if(pstmtstmt != null) pstmtstmt.close();
								if(pstmt10 != null) pstmt10.close();
								if(pstmt11 != null) pstmt11.close();
								if(pstmt12 != null) pstmt12.close();
								if(pstmt13 != null) pstmt13.close();
								if(pstmt14 != null) pstmt14.close();
								if(pstmt15 != null) pstmt15.close();
								if(pstmt17 != null) pstmt17.close();
								if(pstmt19 != null) pstmt19.close();
								if(pstmt21 != null) pstmt21.close();
								if(pstmt25 != null) pstmt25.close();
								if(pstmt26 != null) pstmt26.close();
								if(pstmt27 != null) pstmt27.close();
								if(pstmtp  != null) pstmtp.close();
								if(pstmtm  != null) pstmtm.close();
								if(pstmtc  != null) pstmtc.close();
								if(pstmtr  != null) pstmtr.close();
								if(pstmtrec!= null) pstmtrec.close();
								if(pstmtofc!= null) pstmtofc.close();
					 			if(pstmtmac!= null) pstmtmac.close();			 			
								if(rset != null) rset.close();
								if(rs10 != null) rs10.close();
								if(rs12 != null) rs12.close();
								if(rs13 != null) rs13.close();
								if(rs14 != null) rs14.close();
								if(rs15 != null) rs15.close();
								if(rs17 != null) rs17.close();
								if(rs19 != null) rs19.close();
								if(rs21 != null) rs21.close();
								if(rs25 != null) rs25.close();
								if(rs26 != null) rs26.close();
								if(rs27 != null) rs27.close();
								if(rsp != null) rsp.close();
								if(rsm != null) rsm.close();
								if(rsc != null) rsc.close();
								if(rsr != null) rsr.close();
								if(rsrec!= null) rsrec.close();
								if(rsofc!= null) rsofc.close();
					 			if(rsmac!= null) rsmac.close();
								if(rss  != null) rss.close();

			}

			codeTextAttribute="READONLY";
			newOtherStaff=false;
 			eventFunctionForCase="";

		}

// checkPosition(document.forms[0].other_staff_type.form,document.forms[0].other_staff_type) Removed Against Script Error 		

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	if(effstatus.equals("E")) 
	{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strt));
            out.print( String.valueOf(strt2));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strt1));
            out.print( String.valueOf(strt2));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(otherstaffid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(otherstaffname));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(shortname));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!(longname.equals("")))
{
int len = longname.length();
int i1=0;
int n_incre = 0;
int max = 0;

if (len > 75) 
{ 
    for ( i1=0; i1 <= (len/75);i1++) 
	{   
		if((i1+1)*75 < len)
			max = (i1+1)*75;
		 else
		  max = len;
		
		longname1=longname1+""+longname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	longname1=longname;
 }} 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(longname1 ));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
 
		if(effstatus.equals("E")) {
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str1));
            out.print( String.valueOf(strs2));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
			else if(effstatus.equals("D")) {
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strs1));
            out.print( String.valueOf(strs2));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(isResidencyApplYN){

	if(natid_mand_yn.equals("Y"))
	{
		nat_visibility = "visible";
	}else
	{
		nat_visibility = "hidden";
	}

	if(!citizenship_code.equals(""))
	{
		if(citizen_nat_code.equals(citizenship_code))
		{
			citizenChk = "Checked";
			natIdDis = "";
			if(!other_alt_type_no.equals(""))
			{
				other_alt_no_dis = "";
			}else
			{
				other_alt_no_dis = "disabled";
			}
			if(natid_mand_yn.equals("Y"))
			{
				nat_visibility = "visible";
			}
		}else
		{
			nonCitizenChk = "Checked";
			natIdDis = "disabled";
			nationalidno = "";
			nat_visibility = "hidden";
			if(alt_id1_type.equals(oth_alt_val))
			{
				oth_alt_length = alt_id1_length;
			}else
			{
				oth_alt_length = "20";
			}
			if(!oth_alt_val.equals(""))
			{
				if(oth_alt_val.equals(other_alt_type_no))
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}else
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_type_desc = "";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}
			}else
			{
				other_alt_type_no = "";
				other_alt_type_dis = "disabled";
				other_alt_type_desc = "";
				other_alt_no_dis = "disabled";
			}
		}
	}
	
	if(effstatus.equals("D"))
	{
		other_alt_type_dis = "disabled";
		other_alt_no_dis = "disabled";
	}

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
if(effstatus.equals("E")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(citizenChk));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(citizen_nat_code));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nonCitizenChk));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(citizen_nat_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(citizenship_code));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}else if(effstatus.equals("D")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(citizenChk));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nonCitizenChk));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

				if(effstatus.equals("D")) {
				
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bage));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bmonths));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bdays));
            _bw.write(_wl_block61Bytes, _wl_block61);

				}else{
				
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bage));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bmonths));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bdays));
            _bw.write(_wl_block65Bytes, _wl_block65);

				}
				
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(birthdate));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(birthdate_disp));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disablerecord));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(disablerecord));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(birthplace));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
if(effstatus.equals("E")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str2));
            out.print( String.valueOf(strm2));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
				else if(effstatus.equals("D")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(strm1));
            out.print( String.valueOf(strm2));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(aliasname));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
  if(effstatus.equals("E")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str3));
            out.print( String.valueOf(strc2));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(isResidencyApplYN){
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
				else if(effstatus.equals("D")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(strc1));
            out.print( String.valueOf(strc2));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
 		
			if(accept_national_id_no_yn.equals("Y")){
					
					String nat_id_onKeyPress="";

					/*
					if ( nat_id_check_digit_id.equals("M11") )
						nat_id_onKeyPress = "return CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "return  allowValidNumber(this,event,'"+str14+"',0);";
					*/

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,'"+str14+"', 0);";
					}

					
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(str14));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(natIdDis));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(nationalidno));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block92Bytes, _wl_block92);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(nat_visibility));
            _bw.write(_wl_block94Bytes, _wl_block94);
}
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(nationalidno));
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
if(!accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

				System.out.println("effstatusend "+effstatus);
				if(effstatus.equals("E"))
				{
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
 
				
				 Iterator eee=position_list.iterator();
				 System.out.println("eee "+eee);
				// Iterator enu=position_list.iterator();
				 String tempvariable="";int iop=0;
				/* while(enu.hasNext())
			     {
              
				   
				   iop=iop+1;
				   
				 }*/
				while(eee.hasNext())
			    { 
					tempvariable=(String)eee.next();
					System.out.println("tempvariable "+tempvariable);
					iop=iop+1;
				if(Position.equals(tempvariable))
				{
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tempvariable));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf((String)eee.next() ));
            _bw.write(_wl_block104Bytes, _wl_block104);

				}else
					{
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tempvariable));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( (String)eee.next() ));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
				}
            _bw.write(_wl_block107Bytes, _wl_block107);
 }else
				{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(Position));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Position1));
            _bw.write(_wl_block110Bytes, _wl_block110);
}	}
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(other_alt_type_dis));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 if(alt_type_code.equals(other_alt_type_no)){
	  other_alt_select="selected";
	 }else{
	    other_alt_select="";
      }		
	 
	 
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(alt_type_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(other_alt_select));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(alt_type_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(oth_alt_val));
            _bw.write(_wl_block120Bytes, _wl_block120);
}
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(oth_alt_length));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(other_alt_no_dis));
            _bw.write(_wl_block123Bytes, _wl_block123);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(oth_alt_visibility));
            _bw.write(_wl_block94Bytes, _wl_block94);
}
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(degree));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block128Bytes, _wl_block128);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

				if(effstatus.equals("E"))
				{
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
 
				
				 Iterator eee=position_list.iterator();
				// Iterator enu=position_list.iterator();
				 String tempvariable="";int iop=0;
				/* while(enu.hasNext())
			     {
              
				   
				   iop=iop+1;
				   
				 }*/
				while(eee.hasNext())
			    { 
					tempvariable=(String)eee.next();
					iop=iop+1;
				if(Position.equals(tempvariable))
				{
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tempvariable));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf((String)eee.next() ));
            _bw.write(_wl_block104Bytes, _wl_block104);

				}else
					{
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tempvariable));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( (String)eee.next() ));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
				}
            _bw.write(_wl_block107Bytes, _wl_block107);
 }else
				{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(Position));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Position1));
            _bw.write(_wl_block110Bytes, _wl_block110);
}}
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(effstatus.equals("E")) {
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(str4));
            out.print( String.valueOf(strr2));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
				else if(effstatus.equals("D")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(strr1));
            out.print( String.valueOf(strr2));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
if(effstatus.equals("E")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str5));
            out.print( String.valueOf(stre2));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
				else if(effstatus.equals("D")) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(stre1));
            out.print( String.valueOf(stre2));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
	
				if(count > 1){
            _bw.write(_wl_block42Bytes, _wl_block42);
if(effstatus.equals("E")) {
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block141Bytes, _wl_block141);
}else if(effstatus.equals("D")) {
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
}else {
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(restelnum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(offtelnum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(offtelext));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(faxnum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(mobilenum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(pagernum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(emailid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if (effstatus.equals("E")) {
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(str6));
            out.print( String.valueOf(strp2));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(strp1));
            out.print( String.valueOf(strp2));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(resaddln1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(offaddln1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(mailaddln1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(resaddln2));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(offaddln2));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(mailaddln2));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(resaddln3));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(offaddln3));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(mailaddln3));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(resaddln4));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(offaddln4));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(mailaddln4));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
if(effstatus.equals("E")) {
            _bw.write(_wl_block182Bytes, _wl_block182);
 if(fcall.equals("call"))
	{
	if(newOtherStaff)
	{ 
            _bw.write(_wl_block183Bytes, _wl_block183);

	 
        }
        else								
        { 
        if(respostalcode != null) {
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(respostalcode));
            _bw.write(_wl_block185Bytes, _wl_block185);
}else{
            _bw.write(_wl_block186Bytes, _wl_block186);
}

		

	}
	}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(strrep2));
            _bw.write(_wl_block187Bytes, _wl_block187);
    	if(fcall.equals("call"))
	        {

			



        if(newOtherStaff)
	        {
            _bw.write(_wl_block188Bytes, _wl_block188);
		
		
	        }
	        else
	        {
				if(offpostalcode != null) {
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(offpostalcode));
            _bw.write(_wl_block190Bytes, _wl_block190);
}else{
            _bw.write(_wl_block191Bytes, _wl_block191);
}

	}
	}
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(str7));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(strofp2));
            _bw.write(_wl_block194Bytes, _wl_block194);
  if(fcall.equals("call"))
		{
		if(newOtherStaff)
		{
			
            _bw.write(_wl_block195Bytes, _wl_block195);
		
		}else{
		if(mailpostalcode != null) {
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(mailpostalcode));
            _bw.write(_wl_block197Bytes, _wl_block197);
}else{
            _bw.write(_wl_block198Bytes, _wl_block198);
}

	}
	}			
	
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(str7));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(strmap2));
            _bw.write(_wl_block200Bytes, _wl_block200);
 }
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(strrep1));
            out.print( String.valueOf(strrep2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(strofp1));
            out.print( String.valueOf(strofp2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(strmap1));
            out.print( String.valueOf(strmap2));
            _bw.write(_wl_block200Bytes, _wl_block200);
 }
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
if(effstatus.equals("E")) {
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(str8));
            out.print( String.valueOf(strrec2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(str10));
            out.print( String.valueOf(strofc2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(str12));
            out.print( String.valueOf(strmac2));
            _bw.write(_wl_block200Bytes, _wl_block200);
 }
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(strrec1));
            out.print( String.valueOf(strrec2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(strofc1));
            out.print( String.valueOf(strofc2));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(strmac1));
            out.print( String.valueOf(strmac2));
            _bw.write(_wl_block200Bytes, _wl_block200);
}
            _bw.write(_wl_block205Bytes, _wl_block205);
  

	if(newOtherStaff){
            _bw.write(_wl_block206Bytes, _wl_block206);
}else{
            _bw.write(_wl_block207Bytes, _wl_block207);
}
  	       	
  	       	}catch(Exception e){
			e.printStackTrace();
			}
  	       	
		finally{
			ConnectionManager.returnConnection(conn,request);
		}
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(otherstaffid));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(citizenship_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(citizen_nat_code));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(isResidencyApplYN));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(natid_mand_yn));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(oth_alt_val));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(other_alt_type_no));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(oth_alt_length));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(emplstatus));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block225Bytes, _wl_block225);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherStaffType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortname.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longname.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Identity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactNoAddr.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Citizenship.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Degree.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RepFacility.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmplStatus.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllFacilities.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ResTelNo.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ext.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FaxNo.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PagerNo.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PrefMode.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.office.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mail.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.postalcode.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

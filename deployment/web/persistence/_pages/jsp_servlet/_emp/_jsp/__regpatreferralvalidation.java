package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __regpatreferralvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatReferralValidation.jsp", 1742453926312L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n\n<html>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<head>\n\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t</head>\n\t<body class=\'MESSAGE\' onKeyDown = \'lockKey();\'>\t\t\t\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<form method=post action=\"\">\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\'100%\' align=center>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td><textarea name=\"referral_notes\" id=\"referral_notes\"   onBlur = \'makeValidString(this);checkMaxLen(this);\' rows=\"6\" cols=\"100\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</textarea></td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t</tr> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td align=center>\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp<input type=button class=button name=Close value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\'close_me()\'></td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t</tr>\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'PAT_DECEASED_NOT_ALLOWE\',\'MP\'));\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\"patient_id\").value =\"\"; \t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\"patient_id\").focus();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'PAT_SUSPENDED_NOT_ALLOWED\',\'MP\'));\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').value =\"\"; \n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').focus();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'PATIENT_INACTIVE\',\'MP\'));\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').value =\"\"; \n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').focus();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar mes=getMessage(\"PATIENT_DESIG_FACILITY\",\"MP\");\n\t\t\t\t\t\t\t\tmes=mes.replace(\'\"\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\n\t\t\t\t\t\t\t\talert(mes);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'name_prefix\') != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.frames[0].document.getElementById(\'name_prefix\').options;\n\t\t\t\t\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\n\t\t\t\t\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'first_name\') != null)\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'first_name\').value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'second_name\') != null)\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'second_name\').value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'third_name\') != null)\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'third_name\').value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'family_name\') != null)\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'family_name\').value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'name_suffix\') != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.frames[0].document.getElementById(\'name_suffix\').options;\n\t\t\t\t\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(obj.options[k].value == \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\n\t\t\t\t\t\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.frames[0].document.getElementById(\'sex\').options;\n\t\t\t\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(obj.options[k].value == \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\n\t\t\t\t\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'date_of_birth\').value = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'b_age\').value = \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'b_months\').value = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'b_days\').value =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\n\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.frames[0].document.getElementById(\'nationality_code\').options;\n\t\t\t\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(obj.options[k].value == \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\n\t\t\t\t\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'primary_resi_no\'))\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'primary_resi_no\').value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'other_resi_no\'))\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'other_resi_no\').value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line1\'))\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line1\').value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line2\'))\t\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line2\').value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line3\'))\t\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line3\').value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line4\'))\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'addr1_line4\').value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"\n\n\t\t\t\t\t\tputPatientName();\t\n\t\t\t\t\t\tdisableItems();\n\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXPIRED\",\"MP\");\n\t\t\t\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\");\n\t\t\t\t\t\talert(err_age3);\t\n\t\t\t\t\t\t</script> \t\t\t\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXP_WITH_GRACE\",\"MP\");\n\t\t\t\t\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\");\n\t\t\t\t\t\t\talert(err_age3);\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\')\"\n\t\t\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\')\"\n\t\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXP_WITHIN\",\"MP\");\n\t\t\t\t\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\");\n\n\t\t\t\t\t\t\t/*added by Raj on 10/3/2003 to display 0 days as Today */\n\t\t\t\t\t\t\tvar diffdays = ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =";\n\t\t\t\t\t\t\tif(diffdays==\'0\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\terr_age3 = err_age3.replace(\'within\',\'\');\n\t\t\t\t\t\t\t\talert(err_age3+\"Today\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse \t\t/*end of addition by Raj**/\t\n\t\t\t\t\t\t\t\talert(err_age3+\" \"+\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" Days\");\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXP_WITHIN\',\'MP\')\"\n\t\t\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =";\n\t\t\t\t\t\t\tif(diffdays==\'0\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tmsg = msg.replace(\"\'\"+getLabel(\'Common.within.label\',\'Common\')+\"\'\",\'\');\n\t\t\t\t\t\t\t\talert(msg+\" \'\"+getLabel(\'Common.within.label\',\'Common\')+\"\'\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse \t\n\t\t\t\t\t\t\t\talert(msg+\" \"+\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"+\"\'\"+getLabel(\'Common.days.label\',\'Common\')+\"\'\");\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\");\n\t\t\n\t\t\t\t\t\t\t/*added by Raj on 10/3/2003 to display 0 days as Today */\n\t\t\t\t\t\t\tvar diffdays = ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =";\n\t\t\t\t\t\t\tif(diffdays==\'0\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"\'\"+getLabel(\'Common.within.label\',\'Common\')+\"\'\",\'\');\n\t\t\t\t\t\t\t\talert(msg+\" \'\"+getLabel(\'Common.within.label\',\'Common\')+\"\'\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse \t\n\t\t\t\t\t\t\t\talert(msg+\" \"+\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\");\n\n\t\t\t\t\t\t\t\t/*added by Raj on 10/3/2003 to display 0 days as Today */\n\t\t\t\t\t\t\tvar diffdays = ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"+\"\'\"+getLabel(\'Common.days.label\',\'Common\')+\"\'\");\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" \n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\",\"MP\");\n\t\t\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\");\n\t\t\t\t\t\talert(error);\t\n\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'patient_id\').value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').focus();\n\t\t\t\t\t\tparent.f_query_add_mod.document.frames[0].document.getElementById(\'patient_id\').select();\n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<script>\n\t\t\t\tvar objval=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\n\t\t\t\tvar objarray=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\tvar len=0;\n\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\t\topt=parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");   \n\t\t\t\t\teval(\"parent.document.f_query_add_mod.document.tab_comp.document.forms[0].\"+objval).add(opt);\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\t\t\t                   \n\t\t\t\t\tlen=eval(\"parent.document.f_query_add_mod.document.tab_comp.\"+objarray).length;\n\t\t\t\t\teval(\"parent.document.f_query_add_mod.document.tab_comp.\"+objarray)[len] = opt\n\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar oOption = parent.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\toOption.text=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\';\n\t\t\t\t\toOption.value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\t\t\tparent.f_query_add_mod.document.tab_comp.document.getElementById(\"to_practitioner\").add(oOption);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<script>\n\t\t\t\t\t/*var oOption = parent.f_query_add_mod.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\toOption.text=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\';\n\t\t\t\t\tparent.f_query_add_mod.document.frames[1].document.getElementById(\'to_service_code\').add(oOption);*/\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//var temp  = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\t\t\t\t//var temp1 = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\t\t//var hcare_setting_type_desc =\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t\t\t\t//var hcare_setting_type\t\t=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\t\t//var opt=parent.document.frames[1].document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t//opt.text=temp1;\n\t\t\t\t\t\t//opt.value=hcare_setting_type+\"~\"+temp;\n\t\t\t\t\t\t//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.add(opt);\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\t\t\t\t\tvar hcare_setting_type_desc=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\t\tvar hcare_setting_type=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"785 in RegPatReferralValidation.jsp\");\n\t\t\t\t\t\t// var opt3=parent.document.frames[1].document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\tvar opt3=parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\topt3.text=temp1;\n\t\t\t\t\t\topt3.value=hcare_setting_type+\"~\"+temp;          \n\t\t\t\t\t\t//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.add(opt3);\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t\t\t\t//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.options[1].selected=true;\n\t\t\t\t\t\t//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.disabled=true;\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source.value=temp1;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source.disabled=true;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_bkup_text.value=temp1;\n\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_but.disabled=true;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_id.value=hcare_setting_type+\"~\"+temp;\n\n\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source1.value=temp;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.disabled=false;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].from_hcare_setting_type.value=hcare_setting_type;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.value=hcare_setting_type;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.disabled=true;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\topt=parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].location0.add(opt);                          parent.document.f_query_add_mod.document.tab_comp.location0_array[parent.document.f_query_add_mod.document.tab_comp.location0_array.length] = opt\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar objval=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\t\t\t\tvar temp3=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\t\t\tvar opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t// code added for 20854\n\t\t\t\t\t\topt.value=temp+\"$\"+temp3;\t\t\t\t\t\n\t\t\t\t\t\tif(objval ==\"location0\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].from_locn.add(opt);\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].to_locn.add(opt);\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<script>\n\t\t\t\t\t\n/*\n\t\t\tvar oOption = parent.f_query_add_mod.document.frames[1].document.createElement(\"OPTION\");\n\t\t\toOption.text=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\toOption.value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\t\tparent.f_query_add_mod.document.frames[1].document.getElementById(\'to_service_code\').add(oOption);*/\n\t\t</script>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\t\tvar opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].speciality.add(opt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\t\t\t\t\tvar opt = parent.document.f_query_add_mod.document.tab_comp.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].speciality.add(opt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<script>\t\n\t\tif(\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"!=\"\")\n\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<script>\t\t\n\t\tif(\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t<script>\n\t\t\t\tparent.document.f_query_add_mod.document.frames[0].document.forms[0].tel_no.value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\tparent.document.f_query_add_mod.document.frames[0].document.forms[0].mobile_no.value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\tparent.document.f_query_add_mod.document.frames[0].document.forms[0].pager_no.value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t<script>\t\t\t\t\t\t \n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].tel_no.value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].mobile_no.value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.tab_comp.document.forms[0].pager_no.value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t   ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String pr_id = request.getParameter("process_id");
	boolean fromProcess9=false;     
	
	String practitioner = request.getParameter("practitioner");
	if (practitioner==null)practitioner="";
	String referral_type = request.getParameter("referral_type");
	if (referral_type==null)referral_type="";
	String service_code = request.getParameter("service_code");
	if (service_code==null)service_code="";

    String p_call_func=request.getParameter("pcallfunc");
	if(p_call_func == null || p_call_func.equals("null")) p_call_func="";

	String funid=request.getParameter("funid");
	if(funid== null || funid.equals("null")) funid="";
	String locntypecode="";
	String locntypedesc="";
	
	String facilityname = "";

	int process = Integer.parseInt(pr_id);
	

	String rd_operational_yn=request.getParameter("rd_operational_yn");
	if(rd_operational_yn == null)rd_operational_yn="N";
	
	Connection con = null;
	
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
		
	String loginfacility = (String) session.getValue("facility_id");
	String sql = "";
	StringBuffer sql1= new StringBuffer();
	try
	{
		con = ConnectionManager.getConnection(request);

		if (process == 7)
		{
			String referral_text = request.getParameter("referral_text") ;
			if(referral_text ==null)    referral_text  = "";
			StringBuffer text=new StringBuffer();
			text.setLength(0);
			StringTokenizer token=new StringTokenizer(referral_text,"`,");
			while(token.hasMoreTokens())
			{                
			  text.append(token.nextToken()).append("\n");
			}
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(text.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			text.setLength(0);
		}
		else
		{			

			if(process == 4)
			{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			String pat_id = request.getParameter("pat_id");
			sql1.append("Select a.patient_id,name_prefix,first_name,second_name,third_name,family_name_prefix,family_name, name_suffix,patient_name,sex,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,nationality_code,contact1_no primary_resi_no,contact2_no Other_Resi_No,nvl(active_yn,'N') active_yn,nvl(suspend_yn,'N') suspend_yn, nvl(deceased_yn,'N')  deceased_yn  ,");			
			sql1.append(" b.addr1_line1,b.addr1_line2,b.addr1_line3,b.addr1_line4,pref_facility_id, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) y,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) m,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) d ");
			sql1.append(" from mp_patient a, mp_pat_addresses b where a.patient_id = '"+pat_id+"' and a.patient_id = b.patient_id ");

			pstmt=con.prepareStatement(sql1.toString());
			rs = pstmt1.executeQuery();			
			if ( rs != null && rs.next() )
			{
				int DAYSq=0,MONTHSq=0,AGEq=0;	
				String pop_flag = "Y";
				AGEq= rs.getInt("y");
				MONTHSq = rs.getInt("m");
				DAYSq = rs.getInt("d");
			
				if(rs.getString("deceased_yn").equals("Y") && pop_flag.equals("Y"))
				{	
					
            _bw.write(_wl_block12Bytes, _wl_block12);

					pop_flag = "N";
				}

				if(rs.getString("suspend_yn").equals("Y") && pop_flag.equals("Y"))
				{	
					
            _bw.write(_wl_block13Bytes, _wl_block13);

					pop_flag = "N";
				}
				if (rs.getString("active_yn").equals("N") && pop_flag.equals("Y")) 
				{	
					
            _bw.write(_wl_block14Bytes, _wl_block14);

					pop_flag = "N";
				}

				if (pop_flag.equals("Y"))
				{
					if(!rs.getString("pref_facility_id").equals(loginfacility))
					{						
						pstmt1=con.prepareStatement("select facility_name from sm_facility_param_lang_vw where FACILITY_ID = '"+rs.getString("pref_facility_id")+"' and language_id='"+locale+"'");
						
						rs1= pstmt1.executeQuery();
						if(rs1.next())
						{
							facilityname = rs1.getString("facility_name");
						}
						
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityname));
            _bw.write(_wl_block16Bytes, _wl_block16);
						
					}
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("name_prefix")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("first_name")==null?"":rs.getString("first_name")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("second_name")==null?"":rs.getString("second_name")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString("third_name")==null?"":rs.getString("third_name")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("family_name")==null?"":rs.getString("family_name")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString("name_suffix")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("sex")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("date_of_birth")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(AGEq));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(MONTHSq));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(DAYSq));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString("nationality_code")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs.getString("primary_resi_no")==null?"":rs.getString("primary_resi_no")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs.getString("Other_Resi_No")==null?"":rs.getString("Other_Resi_No")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString("addr1_line1")==null?"":rs.getString("addr1_line1")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("addr1_line2")==null?"":rs.getString("addr1_line2")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("addr1_line3")==null?"":rs.getString("addr1_line3")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rs.getString("addr1_line4")==null?"":rs.getString("addr1_line4")));
            _bw.write(_wl_block35Bytes, _wl_block35);


				String alt_status1 = patdata.CheckAlternateId(con,pat_id,localeName);
				char alt_stat1 = 'Y';
				if (alt_status1.equals("alt_id1_expired") && alt_stat1 != 'N')
				{
					alt_stat1 = 'N';
					pstmt1=con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id1_type=rs1.getString("alt_id1_type");
					
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block37Bytes, _wl_block37);

					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
				}
				else if (alt_status1.equals("alt_id2_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id2_type=rs1.getString("alt_id2_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id2_type+"');alert(msg);</script>");       

					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();

					alt_stat1 = 'N';
				}
				else if (alt_status1.equals("alt_id3_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id3_type=rs1.getString("alt_id3_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id3_type+"');alert(msg);</script>");        
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					alt_stat1 = 'N';
				}
				else if (alt_status1.equals("alt_id4_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id4_type=rs1.getString("alt_id4_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id4_type+"');alert(msg);</script>");        
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					alt_stat1 = 'N';
				}	
				if (alt_stat1!='N'&& alt_status1!="")
				{
					if (alt_status1.indexOf("ALT_ID1_IN_GRACE")>=0)
					{
						alt_stat1 = 'N';
						pstmt1=con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id1_type=rs1.getString("alt_id1_type");
						
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
	
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}
					else if (alt_status1.indexOf("ALT_ID2_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt1 = con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id2_type=rs1.getString("alt_id2_type");
						
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block41Bytes, _wl_block41);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID3_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id3_type=rs1.getString("alt_id3_type");
						
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block43Bytes, _wl_block43);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID4_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt=con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id4_type=rs1.getString("alt_id4_type");
						
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block43Bytes, _wl_block43);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}
				}
				if (alt_stat1!='N'&& alt_status1!="")
				{
					if (alt_status1.indexOf("ALT_ID1_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						pstmt1 = con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'") ;
						rs1 = pstmt1.executeQuery();
						rs1.next();
						alt_stat1 = 'N';
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						alt_stat1='N';

						String alt_id1_type=rs1.getString("alt_id1_type");
						
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( days1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}
					else if (alt_status1.indexOf("ALT_ID2_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1=con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id2_type=rs1.getString("alt_id2_type");
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( days1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block50Bytes, _wl_block50);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID3_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();
						String alt_id3_type=rs1.getString("alt_id3_type");
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( days1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block50Bytes, _wl_block50);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID4_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1 = con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'") ;
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id4_type=rs1.getString("alt_id4_type");
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( days1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block54Bytes, _wl_block54);

						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}
				}					
				}
			}
			else
			{
				String chkst=patdata.CheckStatus(con,pat_id);
				if (chkst.indexOf("PATIENT_MERGED_VALID")>=0 )
				{
					StringTokenizer token=new StringTokenizer(chkst,"$");
					String valid_patient_id = token.nextToken();
					valid_patient_id = token.nextToken();
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
		
				}	
				else{	out.println("<script>alert(getMessage('INVALID_PATIENT','MP'));parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').focus();</script>");
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
		}

		if(process == 5)
		{		
			String objval = request.getParameter("objval");		
		
			String objarray="";
			if(objval.equals("to_speciality_code"))
			{

				objval="locationT0";
				objarray="locationT0_array";
			}
			else
			{
				objval = "location0";
				objarray="location0_array";
			}
			
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(objval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(objarray));
            _bw.write(_wl_block60Bytes, _wl_block60);

		sql1.append("select locn_type,short_desc from AM_CARE_LOCN_TYPE_LANG_VW  where");
		if( p_call_func.equals("AE_REGISTER_ATTN") || p_call_func.equals("CHG_REG_DTLS") || p_call_func.equalsIgnoreCase("REV_VISIT_DTLS"))
		{
			sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
		}
		else if(p_call_func.equals("IP_BOOKING") || p_call_func.equals("IP_ADMIT"))
		{
			sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");
		}
		else if(p_call_func.equals("OP_REG_VISIT") && funid.equals("VISIT_REGISTRATION"))
		{
			sql1.append(" care_locn_type_ind in ('E','C') and locn_type in('E','C') and ");
		}
		else if(p_call_func.equals("OA_BOOK_APPT") || p_call_func.equals("OA_MODIFY_APPT"))
		{
			sql1.append(" care_locn_type_ind in ('C','D','E') and locn_type in('C','Y','E') and ");
		}
		else
		{
			if(rd_operational_yn.equals("Y"))
			{
			sql1.append(" care_locn_type_ind in ('C','D','E','N','W') and locn_type in('C','Y','E','N','W') and  ");
			}else
			{
			sql1.append(" care_locn_type_ind in ('C','D','E','N') and locn_type in('C','Y','E','N') and ");
			}

		}
		sql1.append(" sys_user_def_ind='S' and language_id='"+locale+"' order by 2");			 
		pstmt=con.prepareStatement(sql1.toString());
		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{	
				 locntypecode=rs.getString("locn_type");
				 locntypedesc=rs.getString("short_desc");
				
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locntypecode));
            _bw.write(_wl_block63Bytes, _wl_block63);
			 
			}
		}
		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();
		sql1.setLength(0);	
	}

	if(process == 6)
	{
		String locntype = request.getParameter("locn_type");
		String locncode = request.getParameter("locn_code");
		String opentoallyn = request.getParameter("open_to_all_yn")==null?"":request.getParameter("open_to_all_yn");
		
		if(locntype.equals("C"))
		{
			if(opentoallyn.equals("Y"))
			{
				sql1.append("Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','2') short_name,a.practitioner_id From am_pract_for_facility a, am_practitioner b     Where a.facility_id = '"+loginfacility+"'  And a.practitioner_id =b.practitioner_id   And a.eff_status = 'E' order by 1 ");
			}
			else
			{
				sql1.append(" Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','2') short_name,a.practitioner_id From op_pract_for_clinic a,am_practitioner b Where a.facility_id = '"+loginfacility+"' ");
				sql1.append(" And a.clinic_code = '"+locncode+"'  And a.practitioner_id =b.practitioner_id And a.eff_status = 'E' order by 1 ");
			}
		}
		else if(locntype.equals("N"))
		{
			sql1.append(" Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') short_name,a.practitioner_id From ip_nursing_unit_for_pract a,am_practitioner b Where a.facility_id = '"+loginfacility+"' ");                 
			sql1.append(" And a.nursing_unit_code = '"+locncode+"'  And a.practitioner_id = b.practitioner_id order by 1 ");
		}
		pstmt=con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
		while ( rs.next() )
		{
			
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rs.getString("short_name")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rs.getString("practitioner_id")));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		sql1.setLength(0);
	}

	if(process == 8)
	{
		String speciality_code = request.getParameter("speciality");	
		String locncode=request.getParameter("loc_code");	
		String loc_type=request.getParameter("loc_type");
		
		if(locncode == null) locncode ="";
		

		if(loc_type.equals("C"))
		{
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' ) and language_id='"+locale+"' order by short_desc";
		}
		else if(loc_type.equals("E"))
		{
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' ) and language_id='"+locale+"' order by short_desc";
		}
		else if(loc_type.equals("N"))
		{
			sql="select service_code,short_desc from AM_SERVICE_LANG_VW   where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"'and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+locncode+"') and language_id='"+locale+"' order by short_desc";

		}
		else if (loc_type.equals("W"))
		{
			sql="SELECT distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE D WHERE   A.OPERATING_FACILITY_ID='"+loginfacility+"' AND A.WING_CODE = NVL('"+locncode+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I'";
		}
		else
		{
	
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' )and language_id='"+locale+"' order by short_desc";
		}
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while ( rs.next() )
		{
			
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rs.getString("Service_code")));
            _bw.write(_wl_block68Bytes, _wl_block68);

		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

	if(process == 9)
	{
		 String ref_type = request.getParameter("ref_type");
		 if(ref_type==null) ref_type="";
		 String hcare_type_code = request.getParameter("hcare_type");
		 if(hcare_type_code==null) ref_type="";

		 String referredtoid="";
		 String referredtodesc="";
		 String hcare_setting_type_desc="";
		 String hcare_setting_type="";
		 
		if(ref_type.equals("X"))
		{
			//sql="Select a.LONG_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"'   and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc ";

			//pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null)
			//{
				//while(rs.next())
				//{
					//referredtoid			=rs.getString("referred_to_id");
					//referredtodesc			=rs.getString("referred_to_id_desc");
					//hcare_setting_type_desc	=rs.getString("hcare_setting_type_desc");
					//hcare_setting_type		=rs.getString("hcare_setting_type");
					
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block73Bytes, _wl_block73);

				//}
			//}
			//if(rs != null)  rs.close();
			//if(pstmt != null) pstmt.close();
		}
		else if(ref_type.equals("E") || ref_type.equals("L"))
		{
		
			if(ref_type.equals("E"))
			{
            _bw.write(_wl_block74Bytes, _wl_block74);

				//sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW   a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.facility_id != '"+loginfacility+"' and  a.hcare_setting_type_code='"+hcare_type_code+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name ";
				sql="SELECT a.FACILITY_ID referred_to_id ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != '"+loginfacility+"'  AND a.hcare_setting_type_code='"+hcare_type_code+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+locale+"'   AND b.language_id='"+locale+"' ORDER BY  a.facility_name";
				
			}
			else
			{
		

				sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and a.facility_id='"+loginfacility+"' order by a.facility_name";
			}
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid=rs.getString("referred_to_id");
					referredtodesc=rs.getString("referred_to_id_desc");
					hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
					hcare_setting_type=rs.getString("hcare_setting_type_code");
					
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block79Bytes, _wl_block79);

						if(ref_type.equals("L"))
						{
						
            _bw.write(_wl_block80Bytes, _wl_block80);

						}
						
            _bw.write(_wl_block81Bytes, _wl_block81);

				}
			}	 
			if (rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			
			int ip=0;
			int op=0;

			sql1.append("select locn_type,short_desc from am_care_locn_type_lang_vw  where ");

			if(ref_type.equals("E"))
			{				
				sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs!=null)
				{
					if (rs.next())
					{
						ip=rs.getInt(1);
						op=rs.getInt(2);
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		

				if (ip> 0 )
				{
				   if (op > 0)
					{
					   sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
				
					}
					else
					{
						sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");				
					}
				}
				else
				{       
					if(op>0)
					{
						sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
					
					}
				
				}
			} //main if ends here
			else{
					sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");				
				}
			sql1.append(" sys_user_def_ind='S' and  language_id='"+locale+"' order by 2");

			pstmt=con.prepareStatement(sql1.toString());
			rs=pstmt.executeQuery();
			if(rs !=null)
			{
				while(rs.next())
				{
					locntypecode=rs.getString("locn_type");
					locntypedesc=rs.getString("short_desc");
					
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(locntypecode));
            _bw.write(_wl_block84Bytes, _wl_block84);

				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
		}
		process=11;
		fromProcess9=true;
	}

	if(process == 10)
	{
		String loc_type		= request.getParameter("loc_type");	
		String ref_type		= "";	
		String speciality	= request.getParameter("speciality");	
		String ref_to		= "";
		String objval		= request.getParameter("objval");

		if(objval.equals("locationT0"))
		{
			ref_type= "L";
			ref_to	= loginfacility;	
		}
		else
		{
			 ref_type	= request.getParameter("ref_type");	
			 ref_to		= request.getParameter("referral_source");
		}

		String clinicdesc			="";
		String clinicid				="";
		String open_to_all_pract_yn ="";
		
		String lcare="";

		String ssql="";

		if(p_call_func.equals("CHG_REG_DTLS")||p_call_func.equals("AE_REGISTER_ATTN"))
			lcare="and level_of_care_ind ='E' ";
		else 
			lcare="and level_of_care_ind in ('A','E') ";

	
		if(ref_type.equals("L") || ref_type.equals("E"))
		{
			if(loc_type.equals("C"))
			{
				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='C' "+lcare+" and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and clinic_type='C'  and  language_id='"+locale+"' order by 1 ";

				

			}
			else if (loc_type.equals("N"))
			{
				sql="Select a.long_desc dat, a.nursing_unit_code id,'N' open_to_all_pract_yn from IP_NURSING_UNIT_LANG_VW  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.Patient_Class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+speciality+"' and a.language_id='"+locale+"'  order by 1";
			}
			else if(loc_type.equals("Y"))
			{		

				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='D' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and clinic_type='Y' and language_id='"+locale+"'  order by 1 ";
			}
			else if(loc_type.equals("E"))
			{
				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='E' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and language_id='"+locale+"' order by 1 "; 
			}
			else if(loc_type.equals("W"))
			{
				sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+loginfacility+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL";
			}

			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					clinicdesc=rs.getString("dat");
					clinicid  =rs.getString("id");
					if(loc_type.equals("C"))
						open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
					else 
						open_to_all_pract_yn="N";

					
					
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(objval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(clinicid));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(clinicdesc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);

				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	
	

	if(!objval.equals("location0"))
	{
	if (loc_type.equals("W"))
	{
	ssql="SELECT  distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE_LANG_VW   D WHERE   A.OPERATING_FACILITY_ID='"+loginfacility+"' AND A.WING_CODE = NVL('',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I' and D.language_id='"+locale+"'";
	}else
	{
	ssql="Select Distinct service_code, short_desc from AM_SERVICE_LANG_VW  where eff_status='E' and language_id='"+locale+"' order by short_desc";
	}
	
	
	String cdesc="";
	String ccode="";

	pstmt=con.prepareStatement(ssql);
	rs=pstmt.executeQuery();
	
	if(rs != null)
		{
	while ( rs.next() )
	{
		cdesc=rs.getString("short_desc");
		ccode=rs.getString("service_code");

	
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cdesc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ccode));
            _bw.write(_wl_block91Bytes, _wl_block91);

	}
	}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}
	}

	if (process == 11)
	{	
		String hcare_code     = request.getParameter("hcare_code");
		if(hcare_code==null) hcare_code="";
		String ref_to_code        = request.getParameter("ref_to_code");
		if(ref_to_code ==null) ref_to_code  ="";
		String ref_type        = request.getParameter("ref_type");
		String specialty_short_desc="";
		String specialty_code="";
		

		if(ref_type ==null) ref_type  ="";            
		if(ref_type.equals("X"))
		{
			sql="Select specialty_code,am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"'  order by 2";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code=rs.getString("specialty_code");
					specialty_short_desc=rs.getString("specialty_short_desc");
					
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
                        
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}//if ref type='X'
		else
		{
			sql="Select Short_Desc specialty_short_desc,Speciality_Code specialty_code from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' order by 1";

			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code=rs.getString("specialty_code");
					specialty_short_desc=rs.getString("specialty_short_desc");
					
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);

				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}	
		
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(hcare_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(hcare_code));
            _bw.write(_wl_block96Bytes, _wl_block96);


		if(!fromProcess9)
		{	
		
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(hcare_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(hcare_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
	
		}//if fromProcess9
	}

	if (process == 12)
	{
		String from_pract_id     = request.getParameter("from_pract_id");
		if(from_pract_id==null) from_pract_id="";

		sql="SELECT RES_TEL_NUM,MOBILE_NUM,PAGER_NUM FROM am_practitioner where PRACTITIONER_ID='"+from_pract_id+"'";
		
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null  && rs.next())
		{	
			
			String RES_TEL_NUM	=rs.getString("RES_TEL_NUM");
			if(RES_TEL_NUM==null) RES_TEL_NUM="";
			String MOBILE_NUM	=rs.getString("MOBILE_NUM");
			if(MOBILE_NUM==null) MOBILE_NUM="";
			String PAGER_NUM		=rs.getString("PAGER_NUM");
			if(PAGER_NUM==null) PAGER_NUM="";
			
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(RES_TEL_NUM));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(MOBILE_NUM));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(PAGER_NUM));
            _bw.write(_wl_block101Bytes, _wl_block101);
	
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}	
		
	
		if(process==1024){

		//	pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num,am_get_desc.AM_POSITION(POSITION_CODE, '"+locale+"','1') job_title,pract_type,am_get_desc.am_pract_type(pract_type,'"+locale+"',2) pract_type_desc from am_practitioner  where practitioner_id='"+practitioner+"'");
		
			if(referral_type.equals("X")){	 
				pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num from am_ext_practitioner where practitioner_id='"+practitioner+"'");
			}else{
				pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num from am_practitioner where practitioner_id='"+practitioner+"'");
			}

			rs = pstmt.executeQuery();

			if( rs !=null  && rs.next()){
				
				String off_tel_num	=rs.getString("off_tel_num");
				if(off_tel_num==null) off_tel_num="";
				String mobile_num	=rs.getString("mobile_num");
				if(mobile_num==null) mobile_num="";
				String pager_num		=rs.getString("pager_num");
				if(pager_num==null) pager_num="";
					
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(off_tel_num));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(mobile_num));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(pager_num));
            _bw.write(_wl_block105Bytes, _wl_block105);

			}

			if(pstmt != null)    pstmt.close();
			if(rs != null)    rs.close();

		}	
	}
}catch(Exception e){
	
	e.printStackTrace();
}
finally
{
	try{
			if(rs != null)		rs.close();
			if(rs1 != null) rs1.close();
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
	}catch(Exception ee){
			
			ee.printStackTrace();

	}
	if(con != null) ConnectionManager.returnConnection(con,request);
}	
	
            _bw.write(_wl_block106Bytes, _wl_block106);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferralNotes.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}

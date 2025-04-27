package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;

public final class __nataltidcomponentvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/natAltIDComponentValues.jsp", 1718091513599L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t var msg = getMessage(\"INVALID_NAT_ID\",\"MP\");\n\t\t\t\t\t\t msg = msg.replace(\'#\',\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\');\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t//Maheshwaran K added for the IN:035434 as on 01/10/2012\n\t\t\t\t\t\t//Start\n\t\t\t\t\t\tdocument.getElementById(\"national_id_no\").value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\"national_id_no\").focus();\n\t\t\t\t\t\t//End\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'==\'N\'){\n\t\t\t\t\t\t\tif(document.getElementById(\"alt_id1_no\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"alt_id1_no\").value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"alt_id1_exp_date\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"alt_id1_exp_date\").value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\").value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"first_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"first_name\").value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"second_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"second_name\").value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"third_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"third_name\").value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"family_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"family_name\").value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\").value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"sex\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_age\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_age\").value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_months\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_months\").value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_days\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_days\").value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"date_of_birth\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"date_of_birth\").value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"nationality_desc\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_desc\").value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"nationality_code1\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_code1\").value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"race_code\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"race_code\").value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\t\t\t\t\t\t\tif(document.getElementById(\"race_desc\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"race_desc\").value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line1)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line1.value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line2)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line2.value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line3)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line3.value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line4)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line4.value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(document.forms[0].res_town_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_town_code.value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].res_town_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_town_desc.value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].res_area_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_area_code.value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].res_area_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_area_desc.value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].postal_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].postal_code.value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].r_postal_code_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].r_postal_code_desc.value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].region_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].region_code.value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].region_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].region_desc.value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].country_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].country_code.value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\t\t\tif(document.forms[0].country_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].country_desc.value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\t\t\t\t\t\t\t\tputPatientName(\'\');\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\talert(getMessage(\'PAT_DECEASED_NOT_ALLOWED\',\'MP\'));\n\t\t\t\t\t\t\tdocument.getElementById(\"national_id_no\").value=\'\'; \n\t\t\t\t\t\t\tif(document.getElementById(\"alt_id1_no\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"alt_id1_no\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"alt_id1_exp_date\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"alt_id1_exp_date\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"first_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"first_name\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"second_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"second_name\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"third_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"third_name\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"family_name\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"family_name\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"sex\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_age\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_age\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_months\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_months\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"b_days\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"b_days\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"date_of_birth\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"date_of_birth\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"nationality_desc\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_desc\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"nationality_code1\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_code1\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"race_code\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"race_code\").value=\'\';\n\t\t\t\t\t\t\tif(document.getElementById(\"race_desc\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"race_desc\").value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line1)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line1.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line2)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line2.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line3)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line3.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].addr_line4)\n\t\t\t\t\t\t\t\tdocument.forms[0].addr_line4.value=\'\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(document.forms[0].res_town_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_town_code.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].res_town_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_town_desc.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].res_area_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_area_code.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].res_area_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].res_area_desc.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].postal_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].postal_code.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].r_postal_code_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].r_postal_code_desc.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].region_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].region_code.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].region_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].region_desc.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].country_code)\n\t\t\t\t\t\t\t\tdocument.forms[0].country_code.value=\'\';\n\t\t\t\t\t\t\tif(document.forms[0].country_desc)\n\t\t\t\t\t\t\t\tdocument.forms[0].country_desc.value=\'\';\n\t\t\t\t\t\t\t\tputPatientName(\'\');\n\t\t\t\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t\t\t var err_age1 = getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\");\t\n\t\t\t\talert(err_age1);\n\t\t\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t var err_age2 = getMessage(\"PAT_SUSPENDED_NOT_ALLOWED\",\"MP\");\n\t\t\talert(err_age2);\n\t\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\tvar err_age3 = getMessage(\"PAT_INACTIVE_NOT_ALLOWED\",\"MP\");\n\t\t\talert(err_age3);\n\t\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t populateDetail(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\",\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\");\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t populateDetail(\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\");\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\tvar msg = getMessage(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'MP\');\n\t\t\t\t\t\t\tvar val = msg.replace(\"#\",\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tval = val.replace(\"@\",\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\n\t\t\t\t\t\t\talert(val);\t\n\t\t\t\t\t\t\tdocument.forms[0].national_id_no.value=\'\';\n\t\t\t\t\t\t\tdocument.forms[0].national_id_no.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t var msg = getMessage(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'MP\');\n\t\t\t\t\t\t\talert(msg);\t\n\t\t\t\t\t\t\tdocument.forms[0].national_id_no.value=\'\';\n\t\t\t\t\t\t\tdocument.forms[0].national_id_no.focus();\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String ifCondition = "";
	String locale =((String)session.getAttribute("LOCALE"));
	Hashtable hash	= (Hashtable) obj.parseXMLString( request);
	hash			= (Hashtable) hash.get("SEARCH");
	
	
	ifCondition = (String) hash.get("ifCondition"); 
	String nat_id_no = (String) hash.get("nat_id_no"); 
	if(ifCondition == null || ifCondition.equals("null")) ifCondition = "";
	try{	
		con = ConnectionManager.getConnection(request);
	ResultSet rset				= null; 
	java.sql.Statement stmt		= null; 

	if(ifCondition.equals("forSmartCard"))
	{
		String region			= "";
		String regionval		= "";
		String area_desc		= "";
		String area_code		= "";
		String town_desc		= "";
		String town				= "";
		String concatValues		= "";
		String raceVal		= "";
		String relgnVal		= "";
		String raceCode		= "";
		String rlgnCode		= "";
		String postal_code		= "";
		String postal_desc		= "";

		try
		{
			java.sql.Statement stmt1	= null; 
			ResultSet rset1				= null; 
						
			regionval	= (String) hash.get("regionval");
			town_desc	= (String) hash.get("areaval");
			raceVal	= (String) hash.get("raceVal");
			relgnVal	= (String) hash.get("relgnVal");
			postal_code	= (String) hash.get("postal_code");
						
			if(regionval == null || regionval.equals("null")) regionval = "";
			if(town_desc == null || town_desc.equals("null")) town_desc = "";
			if(raceVal == null || raceVal.equals("null")) raceVal = "";
			if(relgnVal == null || relgnVal.equals("null")) relgnVal = "";
			if(postal_code == null || postal_code.equals("null")) postal_code = "";
						
			stmt = con.createStatement();

			if(!raceVal.equals("") || !relgnVal.equals("")) {

				if(!raceVal.equals("")) {

					raceVal = raceVal.toUpperCase();
					String s = "SELECT race_code FROM mp_race WHERE UPPER(long_desc) = '"+raceVal+"'";
					rset = stmt.executeQuery(s);					
					if(rset != null && rset.next())
					{
						raceCode = rset.getString(1); 
					}

				} 
				
				if(!relgnVal.equals("")) {

					relgnVal = relgnVal.toUpperCase();
					String s = "SELECT relgn_code FROM mp_religion WHERE UPPER(long_desc) = '"+relgnVal+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						rlgnCode = rset.getString(1); 
					}

				}
				
				concatValues = raceCode+"~"+rlgnCode;
				out.println(concatValues);				

			} else {

				if(!regionval.equals(""))
				{
					regionval = regionval.toUpperCase();
					String s = "SELECT region_code FROM mp_region WHERE UPPER(long_desc) = '"+regionval+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						region = rset.getString(1); 
					}
				}
				if(rset != null) rset.close();

				if(!town_desc.equals(""))
				{
					town_desc = town_desc.toUpperCase();
					String s1 = "SELECT res_town_code FROM mp_res_town WHERE UPPER(long_desc) = '"+town_desc+"'";
					rset = stmt.executeQuery(s1);
					if(rset != null && rset.next())
					{
						town = rset.getString(1); 
						if(town != null && !town.equals(""))
						{
							stmt1 = con.createStatement();
							String s2 = "SELECT b.long_desc, a.res_area_code FROM mp_res_town a, mp_res_area b WHERE a.res_town_code = '"+town+"' AND a.res_area_code = b.res_area_code";
							rset1 = stmt1.executeQuery(s2);
							if(rset1 != null && rset1.next())
							{
								area_desc = rset1.getString(1); 
								area_code = rset1.getString(2); 
							}
						}
					}
				}
				if(rset != null) rset.close();
				if(!postal_code.equals(""))
				{
					regionval = regionval.toUpperCase();
					String s = "SELECT POSTAL_CODE,SHORT_DESC FROM mp_postal_code WHERE postal_code='"+postal_code+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						postal_desc = rset.getString("SHORT_DESC"); 
					}
				}
				concatValues = region+"~"+town+"~"+area_desc+"~"+area_code+"~"+postal_desc;
				out.println(concatValues);
				

			}
						
			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
										
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			hash.clear();
			//ConnectionManager.returnConnection(con, request);
		}
	} 
	else 
	{
		java.sql.Statement stmtn	= null;
		ResultSet rset3				= null;

		String step=(String) hash.get("step");
		String id=(String) hash.get("id");
		String oth_id_type=(String) hash.get("oth_id_type");
		String alert_reqd_yn = (String) hash.get("alert_reqd_yn");
		if(step == null) step = "";		
		if(id == null) id="";
		if(oth_id_type == null) oth_id_type="";
		if(alert_reqd_yn == null) alert_reqd_yn="N";
		String objttt="";
		if(step.equals("N")){
			objttt ="national_id_no";
		}else if(step.equals("A1")){
			objttt ="alt_id1_no";
		}else if(step.equals("A2")) {
			objttt ="alt_id2_no";
		}else if(step.equals("A3")) {
			objttt ="alt_id3_no";
		}else if(step.equals("A4")) {
			objttt ="alt_id4_no";
		}else if(step.equals("A5")) {
			objttt ="other_alt_Id";
		}

		String patient_id = "";
		String error_message = "";
		String date_of_birth = "";
		String alt_id1_type = "";
		String alt_id2_type = "";
		String alt_id3_type = "";
		String alt_id4_type = "";
		String disp_prompt="";
		String field_name="";
		String patient_id_detail="";
		String nat_invoke_routine="";
		String nat_data_source_id="";
		String age_in_years  = "";
		String age_in_months = "";
		String age_in_days   = "";
		String sex = "";	
		String patient_id_addresses= "";	
		String place_of_birth_code = "";
		String place_of_birth_desc = "";
		String nat_id_len="";
		String nat_id_check_digit_id="";
		String sql = "";
		String result = "";
		String nat_id_prompt = "";
		String ext_system_interface_yn = "";
		stmtn=con.createStatement();		
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();			
		try{
			if (step.equals("N")) /* To Validate only for National ID */
			{
			//con = ConnectionManager.getConnection(request);
			String sql1 = "select decode('"+step+"','N',nat_id_prompt,'A1',alt_id1_type,'A2',alt_id2_type,'A3',alt_id3_type,'A4',alt_id4_type),alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,invoke_routine,nat_data_source_id ,nat_id_length,nat_id_check_digit_id,nat_id_prompt,ext_system_interface_yn from mp_param_lang_vw where module_id='MP' and language_id='"+locale+"'";
			
			rset3=stmtn.executeQuery(sql1);
				 
			if(rset3!= null && rset3.next())
			{
				disp_prompt= rset3.getString(1);
				alt_id1_type= rset3.getString(2);
				alt_id2_type= rset3.getString(3);
				alt_id3_type= rset3.getString(4);
				alt_id4_type= rset3.getString(5);
				nat_invoke_routine= rset3.getString(6);
				nat_data_source_id= rset3.getString(7);
				nat_id_len=rset3.getString("NAT_ID_LENGTH");
				nat_id_prompt=rset3.getString("nat_id_prompt");
				nat_id_check_digit_id=rset3.getString("nat_id_check_digit_id");
				ext_system_interface_yn=rset3.getString("ext_system_interface_yn");
			}
			if(rset3 != null) rset3.close();
				if(disp_prompt==null) disp_prompt="";
				if(alt_id1_type==null) alt_id1_type="";
				if(alt_id2_type==null) alt_id2_type="";
				if(alt_id3_type==null) alt_id3_type="";
				if(alt_id4_type==null) alt_id4_type="";
				if(nat_invoke_routine==null) nat_invoke_routine="";
				if(nat_data_source_id==null) nat_data_source_id="";
				if(nat_id_prompt==null) nat_id_prompt="";
				if(nat_id_check_digit_id==null) nat_id_check_digit_id="";
				if(ext_system_interface_yn==null) ext_system_interface_yn="";

					//if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals("") && ext_system_interface_yn.equals("N"))
					if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals(""))
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
				        rset = stmt.executeQuery(sql);
				        if(rset.next())
				        {
				            nat_id_check_digit_id = rset.getString(1);
				            if(rset != null)  rset.close();

							sql	= "select "+nat_id_check_digit_id+"('"+nat_id_no+"') from dual";
					        rset = stmt.executeQuery(sql);
				            if(rset.next())
								result = rset.getString(1);
				            if(rset != null)  rset.close();
						}
					}
				    if(rset != null)  rset.close();
					if (result.equals("N"))
					{
						
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block3Bytes, _wl_block3);

					}
		}
		  //Below line modified Query tuning for full table scan [IN:051268]
			 sql="select a.patient_id,a.patient_id||'||'||decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) ||'||'||a.national_id_no||'||'||a.alt_id1_no||'||'||a.alt_id2_no||'||'||a.alt_id3_no||'||'||a.alt_id4_no||'||'||a.name_prefix||'||'||a.first_name||'||'||a.second_name||'||'||a.third_name||'||'||a.family_name||'||'||a.name_suffix||'||'||a.sex||'||'||to_char(a.date_of_birth,'dd/mm/yyyy')||'||'||a.contact1_no||'||'||a.contact2_no||'||'||a.email_id||'||'||a.nationality_code||'||'||to_char(a.alt_id1_exp_date,'dd/mm/yyyy')||'||'||to_char(a.alt_id2_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id3_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id4_exp_date,'dd/mm/yyyy')||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3)||'||'||a.oth_alt_id_type ||'||'|| a.oth_alt_id_no,b.ADDR1_TYPE    ||'||'||B.ADDR1_LINE1   ||'||'||B.ADDR1_LINE2   ||'||'||B.ADDR1_LINE3   ||'||'||B.ADDR1_LINE4   ||'||'||a.RES_TOWN_CODE ||'||'||a.RES_AREA_CODE ||'||'||B.POSTAL1_CODE||'||'||a.REGION_CODE ||'||'||B.COUNTRY1_CODE||'||'||B.CONTACT1_NAME ||'||'||B.INVALID1_YN ||'||'||B.ADDR2_TYPE    ||'||'||B.ADDR2_LINE1   ||'||'||B.ADDR2_LINE2   ||'||'||B.ADDR2_LINE3   ||'||'||B.ADDR2_LINE4   ||'||'||B.RES_TOWN2_CODE||'||'||B.RES_AREA2_CODE||'||'||B.REGION2_CODE||'||'||B.POSTAL2_CODE  ||'||'||B.COUNTRY2_CODE ||'||'||B.CONTACT2_NAME ||'||'||B.INVALID2_YN    ||'||'||B.ADDR3_TYPE    ||'||'||B.ADDR3_LINE1   ||'||'||B.ADDR3_LINE2   ||'||'||B.ADDR3_LINE3   ||'||'||B.ADDR3_LINE4   ||'||'||B.POSTAL3_CODE  ||'||'||B.COUNTRY3_CODE ||'||'||B.CONTACT3_NAME ||'||'||B.INVALID3_YN   ||'||'||B.ADDR4_TYPE    ||'||'||B.ADDR4_LINE1   ||'||'||B.ADDR4_LINE2   ||'||'||B.ADDR4_LINE3   ||'||'||B.ADDR4_LINE4   ||'||'||B.POSTAL4_CODE  ||'||'||B.COUNTRY4_CODE ||'||'||B.CONTACT4_NAME ||'||'||B.INVALID4_YN   ||'||'||B.ADDR5_TYPE    ||'||'||B.ADDR5_LINE1   ||'||'||B.ADDR5_LINE2   ||'||'||B.ADDR5_LINE3   ||'||'||B.ADDR5_LINE4   ||'||'||B.POSTAL5_CODE  ||'||'||B.COUNTRY5_CODE ||'||'||B.CONTACT5_NAME    from mp_patient a ,mp_pat_addresses b where a.patient_id = b.patient_id(+) AND a.patient_id BETWEEN NVL ('%%','%%')  AND NVL ('',a.patient_id) AND a.patient_id LIKE '%%'";
			
			if(step.equals("N")){
				sql=sql+" and  a.national_id_no='"+id+"' ";
				field_name = "national_id_no";
			}
			else if(step.equals("A1")){
				sql=sql+" and  a.alt_id1_no='"+id+"' ";
				field_name = "alt_id1_no";
			}
			else if(step.equals("A2")){
				sql=sql+" and  a.alt_id2_no='"+id+"' ";
				field_name = "alt_id2_no";
			}
			else if(step.equals("A3")){
				sql=sql+" and  a.alt_id3_no='"+id+"' ";
				field_name = "alt_id3_no";
			}
			else if(step.equals("A4")){
				sql=sql+" and  a.alt_id4_no='"+id+"' ";
				field_name = "alt_id4_no";
			}
			else if(step.equals("A5")){
				sql=sql+" and  a.oth_alt_id_no='"+id+"' and  a.oth_alt_id_type = '"+oth_id_type+"' ";
				field_name = "other_alt_Id";
			}
			
			
			rset3=stmtn.executeQuery(sql);
			int natIdDataCount=0;
			int extNatIdDataCount=0;
			if(rset3!= null){
				while(rset3.next()){
					patient_id = rset3.getString(1);
					patient_id_detail = rset3.getString(2);
					patient_id_addresses = rset3.getString(3);
					natIdDataCount++;
				}
			}
			if(rset3 != null) rset3.close();
			if(natIdDataCount==0 && step.equals("N")){
				//sql="select ehis_pat_id patient_id,ehis_pat_id||'||'||''/*patient Name*/ ||'||'||national_id_no||'||'||alt_id1_no||'||'||''/*alt_id2_no*/||'||'||''/*a.alt_id3_no*/||'||'||''/*a.alt_id4_no*/||'||'||name_prefix||'||'||first_name||'||'||second_name||'||'||third_name||'||'||family_name||'||'||name_suffix||'||'||gender/*a.sex*/||'||'||to_char(date_of_birth,'dd/mm/yyyy')||'||'||''/*a.contact1_no*/||'||'||''/*a.contact2_no*/||'||'||''/*a.email_id*/||'||'||nationality_code||'||'||to_char(alt_id1_exp_date,'dd/mm/yyyy')||'||'||''/*to_char(a.alt_id2_exp_date,'dd/mm/yyyy')*/ ||'||'||''/*to_char(a.alt_id3_exp_date,'dd/mm/yyyy')*/ ||'||'||''/*to_char(a.alt_id4_exp_date,'dd/mm/yyyy')*/||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)||'||'||''/*a.oth_alt_id_type*/ ||'||'|| ''/*a.oth_alt_id_no*/,''/*b.ADDR1_TYPE**/   ||'||'||RES_ADDR_LINE_1   ||'||'||RES_ADDR_LINE_2   ||'||'||RES_ADDR_LINE_3   ||'||'||RES_ADDR_LINE_4   ||'||'||RES_TOWN_CODE ||'||'||RES_AREA_CODE ||'||'||RES_POSTAL_CODE||'||'||RES_REGION_CODE ||'||'||RES_COUNTRY_CODE||'||'||''/*B.CONTACT1_NAME*/ ||'||'||''/*B.INVALID1_YN*/ ||'||'||''/*B.ADDR2_TYPE */   ||'||'||''/*B.ADDR2_LINE1*/   ||'||'||''/*B.ADDR2_LINE2*/   ||'||'||''/*B.ADDR2_LINE3*/   ||'||'||''/*B.ADDR2_LINE4 */  ||'||'||''/*B.RES_TOWN2_CODE*/||'||'||''/*B.RES_AREA2_CODE*/||'||'||''/*B.REGION2_CODE*/||'||'||''/*B.POSTAL2_CODE*/  ||'||'||''/*B.COUNTRY2_CODE*/ ||'||'||''/*B.CONTACT2_NAME*/ ||'||'||''/*B.INVALID2_YN*/    ||'||'||''/*B.ADDR3_TYPE*/    ||'||'||''/*B.ADDR3_LINE1*/   ||'||'||''/*B.ADDR3_LINE2*/   ||'||'||''/*B.ADDR3_LINE3*/   ||'||'||''/*B.ADDR3_LINE4*/   ||'||'||''/*B.POSTAL3_CODE*/  ||'||'||''/*B.COUNTRY3_CODE*/ ||'||'||''/*B.CONTACT3_NAME*/ ||'||'||''/*B.INVALID3_YN*/   ||'||'||''/*B.ADDR4_TYPE*/    ||'||'||''/*B.ADDR4_LINE1*/   ||'||'||''/*B.ADDR4_LINE2/   ||'||'||''/*B.ADDR4_LINE3*/   ||'||'||''/*B.ADDR4_LINE4*/   ||'||'||''/*B.POSTAL4_CODE*/  ||'||'||''/*B.COUNTRY4_CODE*/ ||'||'||''/*B.CONTACT4_NAME*/ ||'||'||''/*B.INVALID4_YN*/   ||'||'||''/*B.ADDR5_TYPE*/    ||'||'||''/*B.ADDR5_LINE1*/   ||'||'||''/*B.ADDR5_LINE2*/   ||'||'||''/*B.ADDR5_LINE3*/   ||'||'||''/*B.ADDR5_LINE4*/   ||'||'||''/*B.POSTAL5_CODE*/  ||'||'||''/*B.COUNTRY5_CODE*/ ||'||'||''/*B.CONTACT5_NAME*/    from xf_person where national_id_no='"+id+"'";
				String xf_personSQL="select NATIONAL_ID_NO,EXT_PAT_ID,EHIS_PAT_ID,ALT_ID1_TYPE,ALT_ID1_NO,TO_CHAR (ALT_ID1_EXP_DATE, 'dd/mm/yyyy')ALT_ID1_EXP_DATE,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,FAMILY_NAME_PREFIX,NAME_SUFFIX,SEX GENDER,to_char(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)years,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2)months,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)days,NATIONALITY_CODE,(CASE WHEN NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(NATIONALITY_CODE,'"+locale+"',3)) END ) nationality_desc,RACE_CODE,(CASE WHEN RACE_CODE IS NOT NULL THEN (mp_get_desc.mp_race(RACE_CODE,'"+locale+"',2)) END ) RACE_DESC,RELIGION_CODE, (CASE WHEN RELIGION_CODE IS NOT NULL THEN (mp_get_desc.mp_religion(RELIGION_CODE,'"+locale+"',2)) END ) RELIGION_DESC,RES_ADDR_LINE_1,RES_ADDR_LINE_2,RES_ADDR_LINE_3,RES_ADDR_LINE_4,RES_TOWN_CODE,(CASE WHEN RES_TOWN_CODE IS NOT NULL  THEN (mp_get_desc.mp_res_town(RES_TOWN_CODE,'"+locale+"',2)) END ) RES_TOWN_DESC,RES_AREA_CODE,(CASE WHEN RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.mp_res_area(RES_AREA_CODE,'"+locale+"',2)) END ) RES_AREA_DESC,RES_REGION_CODE,(CASE WHEN RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.mp_region(RES_REGION_CODE,'"+locale+"',2)) END ) RES_REGION_DESC,RES_POSTAL_CODE,mp_get_desc.mp_postal_code(RES_POSTAL_CODE,'"+locale+"',2) RES_POSTAL_DESC,RES_COUNTRY_CODE, (CASE WHEN RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(RES_COUNTRY_CODE,'"+locale+"',1)) END ) RES_COUNTRY_DESC,DECEASED_YN,DOC1_TYPE,(CASE WHEN DOC1_TYPE IS NOT NULL THEN(mp_get_desc.mp_document_type(DOC1_TYPE, '"+locale+"', 2)) END) DOC1_TYPE_DESC,DOC1_NUM,TO_CHAR(DOC1_EXP_DATE, 'DD/MM/YYYY')DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,TO_CHAR(DOC1_ISS_DATE, 'DD/MM/YYYY') DOC1_ISS_DATE,STATUS from xf_person where national_id_no='"+id+"'";
				
				if(rset3!=null)rset3.close();
				rset3=stmtn.executeQuery(xf_personSQL);
				if(rset3!= null){
					while(rset3.next()){
						alt_id1_type=rset3.getString("ALT_ID1_TYPE")==null?"":rset3.getString("ALT_ID1_TYPE");
						String alt_id1_no=rset3.getString("ALT_ID1_NO")==null?"":rset3.getString("ALT_ID1_NO");
						String alt_id1_exp_date=rset3.getString("ALT_ID1_EXP_DATE")==null?"":rset3.getString("ALT_ID1_EXP_DATE");
						String name_prefix=rset3.getString("NAME_PREFIX")==null?"":rset3.getString("NAME_PREFIX");
						String first_name=rset3.getString("FIRST_NAME")==null?"":rset3.getString("FIRST_NAME");
						String second_name=rset3.getString("SECOND_NAME")==null?"":rset3.getString("SECOND_NAME");
						String third_name=rset3.getString("THIRD_NAME")==null?"":rset3.getString("THIRD_NAME");
						String family_name=rset3.getString("FAMILY_NAME")==null?"":rset3.getString("FAMILY_NAME");
						String family_name_prefix=rset3.getString("FAMILY_NAME_PREFIX")==null?"":rset3.getString("FAMILY_NAME_PREFIX");
						String name_suffix=rset3.getString("NAME_SUFFIX")==null?"":rset3.getString("NAME_SUFFIX");
						String gender=rset3.getString("GENDER")==null?"":rset3.getString("GENDER");
						date_of_birth=rset3.getString("date_of_birth")==null?"":rset3.getString("date_of_birth");
						String years=rset3.getString("years")==null?"":rset3.getString("years");
						String months=rset3.getString("months")==null?"":rset3.getString("months");
						String days=rset3.getString("days")==null?"":rset3.getString("days");
						String nationality_code=rset3.getString("NATIONALITY_CODE")==null?"":rset3.getString("NATIONALITY_CODE");
						String nationality_desc=rset3.getString("NATIONALITY_DESC")==null?"":rset3.getString("NATIONALITY_DESC");
						String race_code=rset3.getString("RACE_CODE")==null?"":rset3.getString("RACE_CODE");
						String race_desc=rset3.getString("RACE_DESC")==null?"":rset3.getString("RACE_DESC");
//						String religion_code=rset3.getString("RELIGION_CODE")==null?"":rset3.getString("RELIGION_CODE");//checkstyle changes - 35886
	//					String religion_desc=rset3.getString("RELIGION_DESC")==null?"":rset3.getString("RELIGION_DESC");
						String res_addr_line_1=rset3.getString("res_addr_line_1")==null?"":rset3.getString("res_addr_line_1");
						String res_addr_line_2=rset3.getString("res_addr_line_2")==null?"":rset3.getString("res_addr_line_2");
						String res_addr_line_3=rset3.getString("res_addr_line_3")==null?"":rset3.getString("res_addr_line_3");
						String res_addr_line_4=rset3.getString("res_addr_line_4")==null?"":rset3.getString("res_addr_line_4");
						String res_town_code=rset3.getString("RES_TOWN_CODE")==null?"":rset3.getString("RES_TOWN_CODE");
						String res_town_desc=rset3.getString("RES_TOWN_DESC")==null?"":rset3.getString("RES_TOWN_DESC");
						String res_area_code=rset3.getString("RES_AREA_CODE")==null?"":rset3.getString("RES_AREA_CODE");
						String res_area_desc=rset3.getString("RES_AREA_DESC")==null?"":rset3.getString("RES_AREA_DESC");
						String res_region_code=rset3.getString("RES_REGION_CODE")==null?"":rset3.getString("RES_REGION_CODE");
						String res_region_desc=rset3.getString("RES_REGION_DESC")==null?"":rset3.getString("RES_REGION_DESC");
						String res_postal_code=rset3.getString("RES_POSTAL_CODE")==null?"":rset3.getString("RES_POSTAL_CODE");
						String res_postal_desc=rset3.getString("RES_POSTAL_DESC")==null?"":rset3.getString("RES_POSTAL_DESC");
						String res_country_code=rset3.getString("RES_COUNTRY_CODE")==null?"":rset3.getString("RES_COUNTRY_CODE");
						String res_country_desc=rset3.getString("RES_COUNTRY_DESC")==null?"":rset3.getString("RES_COUNTRY_DESC");
		//				String doc1_type=rset3.getString("DOC1_TYPE")==null?"":rset3.getString("DOC1_TYPE");
			//			String doc1_type_desc=rset3.getString("DOC1_TYPE_DESC")==null?"":rset3.getString("DOC1_TYPE_DESC");
				//		String doc1_num=rset3.getString("DOC1_NUM")==null?"":rset3.getString("DOC1_NUM");
					//	String doc1_exp_date=rset3.getString("DOC1_EXP_DATE")==null?"":rset3.getString("DOC1_EXP_DATE");
						//String doc1_place_of_issue=rset3.getString("DOC1_PLACE_OF_ISSUE")==null?"":rset3.getString("DOC1_PLACE_OF_ISSUE");
						//String doc1_iss_date=rset3.getString("DOC1_ISS_DATE")==null?"":rset3.getString("DOC1_ISS_DATE");
						String deceased_yn=rset3.getString("DECEASED_YN")==null?"N":rset3.getString("DECEASED_YN");
						//patient_id = rset3.getString(1)==null?"":rset3.getString(1);
						//patient_id_detail = rset3.getString(2)==null?"":rset3.getString(2);
						//patient_id_addresses = rset3.getString(3)==null?"":rset3.getString(3);
						extNatIdDataCount++;
						
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(years));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(months));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(days));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(res_addr_line_1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(res_addr_line_2));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(res_addr_line_3));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(res_addr_line_4));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(res_postal_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(res_postal_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
				}
			}
			
			
			
		if(!patient_id.equals(""))
		{
			String chkst = patdata.CheckStatus(con,patient_id);
			if(chkst.equals("DECEASED"))
			{
				patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels");
			
            _bw.write(_wl_block37Bytes, _wl_block37);

		}
		else if(chkst.equals("SUSPENDED"))
		{
			patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels");
			
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
		else if(chkst.equals("INACTIVE"))
		{
			patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels");
			
            _bw.write(_wl_block39Bytes, _wl_block39);

		} else{	 // smart card
		
			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(field_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_detail));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_addresses));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(objttt));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
		}
		else{
		   if(step.equals("N") && nat_invoke_routine.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals("")){
				sql = "select VERIFY_NATIONAL_ID('"+id+"') from dual";
				rset3=stmtn.executeQuery(sql);
				if(rset3!= null && rset3.next())
				result = rset3.getString(1);
							
				StringTokenizer strTok = new StringTokenizer(result,"$");				
						
				if(strTok.hasMoreTokens())
					result = strTok.nextToken();
					if(result.equals("TRUE")){
						if(strTok.hasMoreTokens())
							date_of_birth = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_years = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_months = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_days = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							sex = strTok.nextToken();
						if (strTok.hasMoreTokens())
							place_of_birth_code = strTok.nextToken();
						if (strTok.hasMoreTokens())
							place_of_birth_desc = strTok.nextToken();  

						result = "NAT_ID_VALUES"+"||"+date_of_birth+"||"+age_in_years+"||"+age_in_months+"||"+age_in_days+"||"+sex+"||"+place_of_birth_code+"||"+place_of_birth_desc;
						
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(field_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(result));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_addresses));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(objttt));
            _bw.write(_wl_block44Bytes, _wl_block44);

					}
					else if(result.equals("FALSE")){
						if(strTok.hasMoreTokens()){
							error_message = strTok.nextToken();
							
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_prompt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nat_id_len));
            _bw.write(_wl_block48Bytes, _wl_block48);

						}
					}
					else
					{
						if(strTok.hasMoreTokens()){
							error_message = strTok.nextToken();
							
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block50Bytes, _wl_block50);
							
						}
					}
				}
			}
		}
		catch(Exception e2)
		{	 
			e2.printStackTrace();
		}
		finally
		{
			hash.clear();
			if(stmtn!= null) stmtn.close();
			if(rset3 != null) rset3.close();
			if(stmt != null) stmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
	}
	catch(Exception e)
	{
        e.printStackTrace();
	}
	finally
		{
			hash.clear();
			ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

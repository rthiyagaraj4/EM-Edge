package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __servervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ServerValidation.jsp", 1709119501147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  <script>parent.frames[0].document.forms[0].working_week_1_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_1.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<script>parent.frames[0].document.forms[0].working_week_1_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_1.checked=false;\tparent.frames[0].document.forms[0].working_week_1_day_1.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_1.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<script>parent.frames[0].document.forms[0].working_week_1_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_2.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<script>parent.frames[0].document.forms[0].working_week_1_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_2.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_2.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_2.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>parent.frames[0].document.forms[0].working_week_1_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_3.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<script>parent.frames[0].document.forms[0].working_week_1_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_3.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_3.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_3.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<script>parent.frames[0].document.forms[0].working_week_1_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_4.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>parent.frames[0].document.forms[0].working_week_1_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_4.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_4.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_4.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<script>parent.frames[0].document.forms[0].working_week_1_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_5.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<script>parent.frames[0].document.forms[0].working_week_1_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_5.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_5.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_5.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<script>parent.frames[0].document.forms[0].working_week_1_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_6.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<script>parent.frames[0].document.forms[0].working_week_1_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_6.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_6.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_6.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<script>parent.frames[0].document.forms[0].working_week_1_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_1_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_1_day_7.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<script>parent.frames[0].document.forms[0].working_week_1_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_1_day_7.checked=false;\n\tparent.frames[0].document.forms[0].working_week_1_day_7.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_1_day_7.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  <script>parent.frames[0].document.forms[0].working_week_2_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_1.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<script>parent.frames[0].document.forms[0].working_week_2_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_1.checked=false;\tparent.frames[0].document.forms[0].working_week_2_day_1.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_1.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<script>parent.frames[0].document.forms[0].working_week_2_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_2.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<script>parent.frames[0].document.forms[0].working_week_2_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_2.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_2.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_2.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<script>parent.frames[0].document.forms[0].working_week_2_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_3.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<script>parent.frames[0].document.forms[0].working_week_2_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_3.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_3.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_3.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<script>parent.frames[0].document.forms[0].working_week_2_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_4.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<script>parent.frames[0].document.forms[0].working_week_2_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_4.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_4.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_4.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<script>parent.frames[0].document.forms[0].working_week_2_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_5.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<script>parent.frames[0].document.forms[0].working_week_2_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_5.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_5.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_5.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<script>parent.frames[0].document.forms[0].working_week_2_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_6.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<script>parent.frames[0].document.forms[0].working_week_2_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_6.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_6.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_6.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<script>parent.frames[0].document.forms[0].working_week_2_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_2_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_2_day_7.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<script>parent.frames[0].document.forms[0].working_week_2_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_2_day_7.checked=false;\n\tparent.frames[0].document.forms[0].working_week_2_day_7.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_2_day_7.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  <script>parent.frames[0].document.forms[0].working_week_3_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_1.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<script>parent.frames[0].document.forms[0].working_week_3_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_1.checked=false;\tparent.frames[0].document.forms[0].working_week_3_day_1.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_1.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<script>parent.frames[0].document.forms[0].working_week_3_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_2.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<script>parent.frames[0].document.forms[0].working_week_3_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_2.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_2.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_2.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<script>parent.frames[0].document.forms[0].working_week_3_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_3.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<script>parent.frames[0].document.forms[0].working_week_3_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_3.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_3.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_3.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<script>parent.frames[0].document.forms[0].working_week_3_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_4.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<script>parent.frames[0].document.forms[0].working_week_3_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_4.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_4.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_4.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<script>parent.frames[0].document.forms[0].working_week_3_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_5.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<script>parent.frames[0].document.forms[0].working_week_3_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_5.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_5.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_5.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<script>parent.frames[0].document.forms[0].working_week_3_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_6.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<script>parent.frames[0].document.forms[0].working_week_3_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_6.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_6.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_6.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<script>parent.frames[0].document.forms[0].working_week_3_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_3_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_3_day_7.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<script>parent.frames[0].document.forms[0].working_week_3_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_3_day_7.checked=false;\n\tparent.frames[0].document.forms[0].working_week_3_day_7.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_3_day_7.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="  <script>parent.frames[0].document.forms[0].working_week_4_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_1.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<script>parent.frames[0].document.forms[0].working_week_4_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_1.checked=false;\tparent.frames[0].document.forms[0].working_week_4_day_1.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_1.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<script>parent.frames[0].document.forms[0].working_week_4_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_2.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<script>parent.frames[0].document.forms[0].working_week_4_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_2.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_2.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_2.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<script>parent.frames[0].document.forms[0].working_week_4_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_3.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<script>parent.frames[0].document.forms[0].working_week_4_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_3.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_3.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_3.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<script>parent.frames[0].document.forms[0].working_week_4_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_4.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<script>parent.frames[0].document.forms[0].working_week_4_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_4.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_4.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_4.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<script>parent.frames[0].document.forms[0].working_week_4_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_5.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<script>parent.frames[0].document.forms[0].working_week_4_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_5.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_5.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_5.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<script>parent.frames[0].document.forms[0].working_week_4_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_6.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="<script>parent.frames[0].document.forms[0].working_week_4_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_6.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_6.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_6.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<script>parent.frames[0].document.forms[0].working_week_4_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_4_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_4_day_7.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<script>parent.frames[0].document.forms[0].working_week_4_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_4_day_7.checked=false;\n\tparent.frames[0].document.forms[0].working_week_4_day_7.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_4_day_7.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="  <script>parent.frames[0].document.forms[0].working_week_5_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_1.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="<script>parent.frames[0].document.forms[0].working_week_5_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_1.checked=false;\tparent.frames[0].document.forms[0].working_week_5_day_1.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_1.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="<script>parent.frames[0].document.forms[0].working_week_5_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_2.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<script>parent.frames[0].document.forms[0].working_week_5_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_2.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_2.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_2.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<script>parent.frames[0].document.forms[0].working_week_5_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_3.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<script>parent.frames[0].document.forms[0].working_week_5_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_3.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_3.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_3.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="<script>parent.frames[0].document.forms[0].working_week_5_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_4.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<script>parent.frames[0].document.forms[0].working_week_5_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_4.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_4.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_4.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<script>parent.frames[0].document.forms[0].working_week_5_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_5.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="<script>parent.frames[0].document.forms[0].working_week_5_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_5.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_5.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_5.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="<script>parent.frames[0].document.forms[0].working_week_5_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_6.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="<script>parent.frames[0].document.forms[0].working_week_5_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_6.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_6.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_6.disabled=true;\n\t</script>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="<script>parent.frames[0].document.forms[0].working_week_5_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].working_week_5_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].working_week_5_day_7.disabled=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.value=\'W\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.checked=true;\t\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.disabled=false;\n\t</script>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<script>parent.frames[0].document.forms[0].working_week_5_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].working_week_5_day_7.checked=false;\n\tparent.frames[0].document.forms[0].working_week_5_day_7.disabled=true;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.value=\'H\';\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.checked=false;\n\tparent.frames[0].document.forms[0].pract_working_week_5_day_7.disabled=true;\n\t  \n\t</script>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n                <script>\n                    var n=parent.frames[0].document.forms[0].practitioner.options.length;\n                    for(var i=0;i<n;i++)\n                    {\n                    parent.frames[0].document.forms[0].practitioner.remove(\"practitioner\");             \n                    }                   \n                var tp =\" --------\"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\"-------- \"\n                var opt=parent.document.frames[0].document.createElement(\"OPTION\");         \n                opt.text=tp;\n                opt.value=\"\";\n            parent.frames[0].document.forms[0].practitioner.add(opt);                   \n\n                </script>           \n\n    ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

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

request.setCharacterEncoding("UTF-8");
String pr_id = request.getParameter("clinic_code");

String from_item_chk = request.getParameter("from_item_chk");

if(pr_id == null || pr_id.equals("null")) pr_id = "";
if(from_item_chk == null || from_item_chk.equals("null")) from_item_chk = "";
Connection con = null;

Statement stmt = null;
ResultSet rs = null;
PreparedStatement pstmt1=null;
ResultSet rs1 = null;

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


try{

con=ConnectionManager.getConnection(request);

stmt = con.createStatement();
PreparedStatement pstmt; 
    String wd1="";
    String wd2="";
    String wd3="";
    String wd4="";
    String wd5="";
    String wd6="";
    String wd7="";
    
    String emergency="";
    String first="";
    String follow="";
    String routine="";
    String  series="";
    String consult="";
    
    String yes="Y";
    String no="N";
	String WORKING_WEEK_1_DAY_1 = "", WORKING_WEEK_2_DAY_1 = "",WORKING_WEEK_3_DAY_1 = "";
	String WORKING_WEEK_1_DAY_2 = "", WORKING_WEEK_2_DAY_2 = "",WORKING_WEEK_3_DAY_2 = "";
	String WORKING_WEEK_1_DAY_3 = "", WORKING_WEEK_2_DAY_3 = "",WORKING_WEEK_3_DAY_3 = "";
	String WORKING_WEEK_1_DAY_4 = "", WORKING_WEEK_2_DAY_4 = "",WORKING_WEEK_3_DAY_4 = "";
	String WORKING_WEEK_1_DAY_5 = "", WORKING_WEEK_2_DAY_5 = "",WORKING_WEEK_3_DAY_5 = "";
	String WORKING_WEEK_1_DAY_6 = "", WORKING_WEEK_2_DAY_6 = "",WORKING_WEEK_3_DAY_6 = "";
	String WORKING_WEEK_1_DAY_7 = "", WORKING_WEEK_2_DAY_7 = "",WORKING_WEEK_3_DAY_7 = "";
	
	String WORKING_WEEK_4_DAY_1 = "", WORKING_WEEK_5_DAY_1 = "";
	String WORKING_WEEK_4_DAY_2 = "", WORKING_WEEK_5_DAY_2 = "";
	String WORKING_WEEK_4_DAY_3 = "", WORKING_WEEK_5_DAY_3 = "";
	String WORKING_WEEK_4_DAY_4 = "", WORKING_WEEK_5_DAY_4 = "";
	String WORKING_WEEK_4_DAY_5 = "", WORKING_WEEK_5_DAY_5 = "";
	String WORKING_WEEK_4_DAY_6 = "", WORKING_WEEK_5_DAY_6 = "";
	String WORKING_WEEK_4_DAY_7 = "", WORKING_WEEK_5_DAY_7 = "";


    
  
    String facilityid="";
    facilityid=(String)session.getValue("facility_id");
  

  String sql1 = "SELECT WORKING_WEEK_1_DAY_1, WORKING_WEEK_1_DAY_2, WORKING_WEEK_1_DAY_3, WORKING_WEEK_1_DAY_4, WORKING_WEEK_1_DAY_5, WORKING_WEEK_1_DAY_6, WORKING_WEEK_1_DAY_7, WORKING_WEEK_2_DAY_1, WORKING_WEEK_2_DAY_2, WORKING_WEEK_2_DAY_3, WORKING_WEEK_2_DAY_4, WORKING_WEEK_2_DAY_5, WORKING_WEEK_2_DAY_6, WORKING_WEEK_2_DAY_7, WORKING_WEEK_3_DAY_1, WORKING_WEEK_3_DAY_2, WORKING_WEEK_3_DAY_3, WORKING_WEEK_3_DAY_4, WORKING_WEEK_3_DAY_5, WORKING_WEEK_3_DAY_6, WORKING_WEEK_3_DAY_7, WORKING_WEEK_4_DAY_1, WORKING_WEEK_4_DAY_2, WORKING_WEEK_4_DAY_3, WORKING_WEEK_4_DAY_4, WORKING_WEEK_4_DAY_5, WORKING_WEEK_4_DAY_6, WORKING_WEEK_4_DAY_7, WORKING_WEEK_5_DAY_1, WORKING_WEEK_5_DAY_2, WORKING_WEEK_5_DAY_3, WORKING_WEEK_5_DAY_4, WORKING_WEEK_5_DAY_5, WORKING_WEEK_5_DAY_6, WORKING_WEEK_5_DAY_7  FROM OP_CLINIC WHERE clinic_code = '"+pr_id+"' and facility_id = '"+facilityid+"'";
 pstmt1 = con.prepareStatement("sql1");
 rs1 = pstmt1.executeQuery(sql1);
 if (rs1!=null)
	{
		while(rs1.next())
		{
			WORKING_WEEK_1_DAY_1 = rs1.getString("WORKING_WEEK_1_DAY_1");
			WORKING_WEEK_1_DAY_2 = rs1.getString("WORKING_WEEK_1_DAY_2");
			WORKING_WEEK_1_DAY_3 = rs1.getString("WORKING_WEEK_1_DAY_3");
			WORKING_WEEK_1_DAY_4 = rs1.getString("WORKING_WEEK_1_DAY_4");
			WORKING_WEEK_1_DAY_5 = rs1.getString("WORKING_WEEK_1_DAY_5");
			WORKING_WEEK_1_DAY_6 = rs1.getString("WORKING_WEEK_1_DAY_6");
			WORKING_WEEK_1_DAY_7 = rs1.getString("WORKING_WEEK_1_DAY_7");
			WORKING_WEEK_2_DAY_1 = rs1.getString("WORKING_WEEK_2_DAY_1");
			WORKING_WEEK_2_DAY_2 = rs1.getString("WORKING_WEEK_2_DAY_2");
			WORKING_WEEK_2_DAY_3 = rs1.getString("WORKING_WEEK_2_DAY_3");
			WORKING_WEEK_2_DAY_4 = rs1.getString("WORKING_WEEK_2_DAY_4");
			WORKING_WEEK_2_DAY_5 = rs1.getString("WORKING_WEEK_2_DAY_5");
			WORKING_WEEK_2_DAY_6 = rs1.getString("WORKING_WEEK_2_DAY_6");
			WORKING_WEEK_2_DAY_7 = rs1.getString("WORKING_WEEK_2_DAY_7");
			WORKING_WEEK_3_DAY_1 = rs1.getString("WORKING_WEEK_3_DAY_1");
			WORKING_WEEK_3_DAY_2 = rs1.getString("WORKING_WEEK_3_DAY_2");
			WORKING_WEEK_3_DAY_3 = rs1.getString("WORKING_WEEK_3_DAY_3");
			WORKING_WEEK_3_DAY_4 = rs1.getString("WORKING_WEEK_3_DAY_4");
			WORKING_WEEK_3_DAY_5 = rs1.getString("WORKING_WEEK_3_DAY_5");
			WORKING_WEEK_3_DAY_6 = rs1.getString("WORKING_WEEK_3_DAY_6");
			WORKING_WEEK_3_DAY_7 = rs1.getString("WORKING_WEEK_3_DAY_7");

			WORKING_WEEK_4_DAY_1 = rs1.getString("WORKING_WEEK_4_DAY_1");
			WORKING_WEEK_4_DAY_2 = rs1.getString("WORKING_WEEK_4_DAY_2");
			WORKING_WEEK_4_DAY_3 = rs1.getString("WORKING_WEEK_4_DAY_3");
			WORKING_WEEK_4_DAY_4 = rs1.getString("WORKING_WEEK_4_DAY_4");
			WORKING_WEEK_4_DAY_5 = rs1.getString("WORKING_WEEK_4_DAY_5");
			WORKING_WEEK_4_DAY_6 = rs1.getString("WORKING_WEEK_4_DAY_6");
			WORKING_WEEK_4_DAY_7 = rs1.getString("WORKING_WEEK_4_DAY_7");

			WORKING_WEEK_5_DAY_1 = rs1.getString("WORKING_WEEK_5_DAY_1");
			WORKING_WEEK_5_DAY_2 = rs1.getString("WORKING_WEEK_5_DAY_2");
			WORKING_WEEK_5_DAY_3 = rs1.getString("WORKING_WEEK_5_DAY_3");
			WORKING_WEEK_5_DAY_4 = rs1.getString("WORKING_WEEK_5_DAY_4");
			WORKING_WEEK_5_DAY_5 = rs1.getString("WORKING_WEEK_5_DAY_5");
			WORKING_WEEK_5_DAY_6 = rs1.getString("WORKING_WEEK_5_DAY_6");
			WORKING_WEEK_5_DAY_7 = rs1.getString("WORKING_WEEK_5_DAY_7");

		}
	}

	if(rs1 != null) rs1.close();
	if(pstmt1 != null) pstmt1.close();

	
	if (WORKING_WEEK_1_DAY_1.equals("W")) {
   
            _bw.write(_wl_block5Bytes, _wl_block5);
 }else {
            _bw.write(_wl_block6Bytes, _wl_block6);
}
	if (WORKING_WEEK_1_DAY_2.equals("W")) {
	
            _bw.write(_wl_block7Bytes, _wl_block7);
	} else {
	
            _bw.write(_wl_block8Bytes, _wl_block8);
}
	if (WORKING_WEEK_1_DAY_3.equals("W")) {
            _bw.write(_wl_block9Bytes, _wl_block9);
}else {
            _bw.write(_wl_block10Bytes, _wl_block10);
}
	if (WORKING_WEEK_1_DAY_4.equals("W")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}else {
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	if (WORKING_WEEK_1_DAY_5.equals("W")) {
            _bw.write(_wl_block13Bytes, _wl_block13);
}else {
            _bw.write(_wl_block14Bytes, _wl_block14);
}	
  	if (WORKING_WEEK_1_DAY_6.equals("W")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
}else {
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	if (WORKING_WEEK_1_DAY_7.equals("W")) {
            _bw.write(_wl_block17Bytes, _wl_block17);
}else {
            _bw.write(_wl_block18Bytes, _wl_block18);
}

//////////
if (WORKING_WEEK_2_DAY_1.equals("W")) {
   
            _bw.write(_wl_block19Bytes, _wl_block19);
 }else {
            _bw.write(_wl_block20Bytes, _wl_block20);
}
	if (WORKING_WEEK_2_DAY_2.equals("W")) {
	
            _bw.write(_wl_block21Bytes, _wl_block21);
	} else {
	
            _bw.write(_wl_block22Bytes, _wl_block22);
}
	if (WORKING_WEEK_2_DAY_3.equals("W")) {
            _bw.write(_wl_block23Bytes, _wl_block23);
}else {
            _bw.write(_wl_block24Bytes, _wl_block24);
}
	if (WORKING_WEEK_2_DAY_4.equals("W")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}else {
            _bw.write(_wl_block26Bytes, _wl_block26);
}
	if (WORKING_WEEK_2_DAY_5.equals("W")) {
            _bw.write(_wl_block27Bytes, _wl_block27);
}else {
            _bw.write(_wl_block28Bytes, _wl_block28);
}	
  	if (WORKING_WEEK_2_DAY_6.equals("W")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
}else {
            _bw.write(_wl_block30Bytes, _wl_block30);
}
	if (WORKING_WEEK_2_DAY_7.equals("W")) {
            _bw.write(_wl_block31Bytes, _wl_block31);
}else {
            _bw.write(_wl_block32Bytes, _wl_block32);
}
//////////
if (WORKING_WEEK_3_DAY_1.equals("W")) {
   
            _bw.write(_wl_block33Bytes, _wl_block33);
 }else {
            _bw.write(_wl_block34Bytes, _wl_block34);
}
	if (WORKING_WEEK_3_DAY_2.equals("W")) {
	
            _bw.write(_wl_block35Bytes, _wl_block35);
	} else {
	
            _bw.write(_wl_block36Bytes, _wl_block36);
}
	if (WORKING_WEEK_3_DAY_3.equals("W")) {
            _bw.write(_wl_block37Bytes, _wl_block37);
}else {
            _bw.write(_wl_block38Bytes, _wl_block38);
}
	if (WORKING_WEEK_3_DAY_4.equals("W")){
            _bw.write(_wl_block39Bytes, _wl_block39);
}else {
            _bw.write(_wl_block40Bytes, _wl_block40);
}
	if (WORKING_WEEK_3_DAY_5.equals("W")) {
            _bw.write(_wl_block41Bytes, _wl_block41);
}else {
            _bw.write(_wl_block42Bytes, _wl_block42);
}	
  	if (WORKING_WEEK_3_DAY_6.equals("W")) {
            _bw.write(_wl_block43Bytes, _wl_block43);
}else {
            _bw.write(_wl_block44Bytes, _wl_block44);
}
	if (WORKING_WEEK_3_DAY_7.equals("W")) {
            _bw.write(_wl_block45Bytes, _wl_block45);
}else {
            _bw.write(_wl_block46Bytes, _wl_block46);
}
/////////
if (WORKING_WEEK_4_DAY_1.equals("W")) {
   
            _bw.write(_wl_block47Bytes, _wl_block47);
 }else {
            _bw.write(_wl_block48Bytes, _wl_block48);
}
	if (WORKING_WEEK_4_DAY_2.equals("W")) {
	
            _bw.write(_wl_block49Bytes, _wl_block49);
	} else {
	
            _bw.write(_wl_block50Bytes, _wl_block50);
}
	if (WORKING_WEEK_4_DAY_3.equals("W")) {
            _bw.write(_wl_block51Bytes, _wl_block51);
}else {
            _bw.write(_wl_block52Bytes, _wl_block52);
}
	if (WORKING_WEEK_4_DAY_4.equals("W")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}else {
            _bw.write(_wl_block54Bytes, _wl_block54);
}
	if (WORKING_WEEK_4_DAY_5.equals("W")) {
            _bw.write(_wl_block55Bytes, _wl_block55);
}else {
            _bw.write(_wl_block56Bytes, _wl_block56);
}	
  	if (WORKING_WEEK_4_DAY_6.equals("W")) {
            _bw.write(_wl_block57Bytes, _wl_block57);
}else {
            _bw.write(_wl_block58Bytes, _wl_block58);
}
	if (WORKING_WEEK_4_DAY_7.equals("W")) {
            _bw.write(_wl_block59Bytes, _wl_block59);
}else {
            _bw.write(_wl_block60Bytes, _wl_block60);
}
/////////
if (WORKING_WEEK_5_DAY_1.equals("W")) {
   
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else {
            _bw.write(_wl_block62Bytes, _wl_block62);
}
	if (WORKING_WEEK_5_DAY_2.equals("W")) {
	
            _bw.write(_wl_block63Bytes, _wl_block63);
	} else {
	
            _bw.write(_wl_block64Bytes, _wl_block64);
}
	if (WORKING_WEEK_5_DAY_3.equals("W")) {
            _bw.write(_wl_block65Bytes, _wl_block65);
}else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
	if (WORKING_WEEK_5_DAY_4.equals("W")){
            _bw.write(_wl_block67Bytes, _wl_block67);
}else {
            _bw.write(_wl_block68Bytes, _wl_block68);
}
	if (WORKING_WEEK_5_DAY_5.equals("W")) {
            _bw.write(_wl_block69Bytes, _wl_block69);
}else {
            _bw.write(_wl_block70Bytes, _wl_block70);
}	
  	if (WORKING_WEEK_5_DAY_6.equals("W")) {
            _bw.write(_wl_block71Bytes, _wl_block71);
}else {
            _bw.write(_wl_block72Bytes, _wl_block72);
}
	if (WORKING_WEEK_5_DAY_7.equals("W")) {
            _bw.write(_wl_block73Bytes, _wl_block73);
}else {
            _bw.write(_wl_block74Bytes, _wl_block74);
}

  String sql="Select Working_Day_1,Working_Day_2,Working_Day_3,Working_Day_4,Working_Day_5,"+
    "Working_Day_6,Working_Day_7,Fi_Visit_Type_Appl_Yn,Fu_Visit_Type_Appl_Yn,"+
    "Rt_Visit_Type_Appl_Yn,Sr_Visit_Type_Appl_Yn,Cs_Visit_Type_Appl_Yn,"+
    "Em_Visit_Type_Appl_Yn from op_clinic where clinic_code = '"+pr_id+"' and facility_id = '"+facilityid+"'";
       // out.println(sql);
            
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        wd1 = rs.getString("working_day_1");
        wd2 = rs.getString("working_day_2");
        wd3 = rs.getString("working_day_3");
        wd4 = rs.getString("working_day_4");
        wd5 = rs.getString("working_day_5");
        wd6 = rs.getString("working_day_6");
        wd7 = rs.getString("working_day_7");
        
        emergency=rs.getString("Em_Visit_Type_Appl_Yn");
		 first=rs.getString("fi_visit_type_appl_yn");
        follow=rs.getString("fu_visit_type_appl_yn");
        routine=rs.getString("rt_visit_type_appl_yn");
        series=rs.getString("sr_visit_type_appl_yn");
        consult=rs.getString("cs_visit_type_appl_yn");		

        }

		if(rs != null) rs.close();

        if(wd1.equals("Y"))
        {
        String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_1.disabled=false;"+
        "parent.frames[0].document.forms[0].i1.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_1.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_1.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown ='lockKey()'></body></html>";
        out.println(a1);
        }
        else{
        String a2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_1.disabled=true;"+
        "parent.frames[0].document.forms[0].i1.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_1.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_1.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a2);
        }
        
        if(wd2.equals("Y"))
        {
        String a3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_2.disabled=false;" + 
        "parent.frames[0].document.forms[0].i2.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_2.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_2.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a3);
        }
        else{
        String a4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_2.disabled=true;"+
        "parent.frames[0].document.forms[0].i2.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_2.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_2.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a4);
        }
        if(wd3.equals("Y"))
        {
        String a5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_3.disabled=false;"+
        "parent.frames[0].document.forms[0].i3.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_3.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_3.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a5);
        }
        else{
        String a6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_3.disabled=true;"+
        "parent.frames[0].document.forms[0].i3.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_3.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_3.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a6);
        }
        
        if(wd4.equals("Y"))
        {
        String a7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_4.disabled=false;"+
        "parent.frames[0].document.forms[0].i4.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_4.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_4.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a7);
        }
        else{
        String a8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_4.disabled=true;"+
        "parent.frames[0].document.forms[0].i4.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_4.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_4.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a8);
        }
        if(wd5.equals("Y"))
        {
        String a9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_5.disabled=false;"+
        "parent.frames[0].document.forms[0].i5.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_5.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_5.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a9);
        }
        else{
        String a10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_5.disabled=true;"+
        "parent.frames[0].document.forms[0].i5.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_5.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_5.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a10);
        }
        if(wd6.equals("Y"))
        {
        String a11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_6.disabled=false;"+
        "parent.frames[0].document.forms[0].i6.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_6.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_6.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a11);
        }
        else{
        String a12="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_6.disabled=true;"+
        "parent.frames[0].document.forms[0].i6.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_6.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_6.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a12);
        }
        
        if(wd7.equals("Y"))
        {
        String a13="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_7.disabled=false;"+
        "parent.frames[0].document.forms[0].i7.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_7.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_7.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a13);
        }
        else{
        String a14="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_7.disabled=true;"+
        "parent.frames[0].document.forms[0].i7.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_7.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_7.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a14);
        }
        
        
        if(emergency.equals("N")) // || emergency.equals("null") || emergency.equals(""))
        {
        String a15="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+
        "parent.frames[0].document.forms[0].emergency.checked=false;"+
        "parent.frames[0].document.forms[0].emergency.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        
		
		out.println(a15);
            if(first.equals("N")) // || first.equals("null") || first.equals(""))
                {
                String d1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d1);
                }
            else if(first.equals("Y"))
                { 
                String d11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=false;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d11);
                String d2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d2);
                }
                
            if(follow.equals("N")) // || follow.equals("null") || follow.equals(""))
                {
                String d3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=true;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d3);
                        }
            else if(follow.equals("Y"))
                    { 
                    String d33="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=false;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d33);
                    String d4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.checked=true;"+
                    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d4);
                }
                
                
                
                
            
            if(routine.equals("N")) // || routine.equals("null") || routine.equals(""))
                {
                String d5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d5);
                }
            else if(routine.equals("Y"))
                {
                String d55="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d55);
                String d6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d6);
                }
            
            
            if(series.equals("N")) // || series.equals("null") || series.equals(""))
                {
                String d7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d7);
                }
            else if(series.equals("Y"))
                {
                String d77="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d77);
                String d8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d8);
                }
            
            if(consult.equals("N")) // || consult.equals("null") || consult.equals(""))
                {
                String d9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d9);
                }
                else if(consult.equals("Y"))
                {
                String d99="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d99);
                String d10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d10);
                }
            
        }
        else if(emergency.equals("Y")) {
        if(first.equals("N")) // || first.equals("null") || first.equals(""))
        {
        String a16="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=true;"+
            "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a16);          
		}
		else{
		String a16="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=false;parent.frames[0].document.forms[0].first.checked=true;"+
            "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a16); 
		
		}
	if(follow.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a17="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a17);          
	}
	else{
	String a17="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=false;parent.frames[0].document.forms[0].follow.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a17);          
	
	
	}
    if(routine.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a18="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script> parent.frames[0].document.forms[0].routine.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a18); 
	}
	else{
	 String a18="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script> parent.frames[0].document.forms[0].routine.disabled=false;parent.frames[0].document.forms[0].routine.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a18); 
	
	}
    
	 if(series.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a19="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a19);          
	}
	else{
	String a19="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=false;parent.frames[0].document.forms[0].series.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a19);          
	
	}
	if(consult.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a20="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=true;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'>></body></html>";
        out.println(a20); 
	}
	else{
	String a20="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=false;parent.frames[0].document.forms[0].consult.checked=true;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a20); 
	
	}
		
		
		String a21="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].emergency.disabled=false;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a21);           
        String a22="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].emergency.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a22);           
                
        }
        
        if(emergency.equals("Y"))
        {
        String k1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].emergency.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k1);
        
        }
        else
        {
        String k2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].emergency.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k2);
        }
        
        if(first.equals("Y"))
        {
        String k3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].first.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k3);
        
        }
        else
        {
        String k4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].first.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k4);
        }
        
        if(follow.equals("Y"))
        {
        String k5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].follow.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k5);
        }
        else
        {
        String k6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].follow.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k6);
        }
    
        if(routine.equals("Y"))
        {
        String k7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
         "<script>parent.frames[0].document.forms[0].routine.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k7);
        }
        else
        {
        String k8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].routine.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k8);
        }
        
        
        if(series.equals("Y"))
        {
        String k9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].series.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k9);
        }
        else
        {
        String k10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].series.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k10);
        }
        
        
        if(consult.equals("Y"))
        {
        String k11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].consult.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k11);
        }
        else
        {
        String k12="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].consult.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k12);
        }

		if(!from_item_chk.equals("Y"))
	    {

            _bw.write(_wl_block75Bytes, _wl_block75);
  
        String mysql = "Select a.practitioner_id,b.short_name from am_pract_for_facility a, "+
                " am_practitioner b , op_clinic c  where b.practitioner_id = a.practitioner_id  "+  
                " and a.eff_status = 'E' and a.facility_id = '"+facilityid+"'"+
                " and c.facility_id = a.facility_id and c.clinic_code = '"+pr_id+"'"+
                " and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id ))"+
                " and nvl(c.pract_type, b.pract_type) = b.pract_type ";
        
        pstmt   = con.prepareStatement( mysql);

        rs = pstmt.executeQuery() ;
        String str1 = "";
        String str2 = "";
        if( rs != null ) 
        {
            while( rs.next() ) 
            {
                str1 = rs.getString(2) ;
                str2 = rs.getString(1);
                
                out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
                "<script>var element = parent.frames[0].document.createElement('OPTION');"+
                        "element.text = \""+str1+"\";"+ 
                        "element.value= \""+str2+"\";"+
                        "parent.frames[0].document.clinic_form.practitioner.add(element);</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>");
            }
        }
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close() ;             
		}
}catch(Exception e){out.println(e);}
finally { 
	//Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
	if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();
	if(rs1!=null)rs1.close();
	if(pstmt1!=null)pstmt1.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
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

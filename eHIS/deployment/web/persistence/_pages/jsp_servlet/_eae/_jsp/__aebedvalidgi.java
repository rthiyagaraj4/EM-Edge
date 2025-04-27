package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __aebedvalidgi extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEBedValidGI.jsp", 1739968827510L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n                    <script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t    <script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].ok.disabled=true;\n\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].ok.disabled=true;\n\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n                    <script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t    parent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t    parent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.TriageButtonsFrame.SecondaryTriageButtonsForm.Record.disabled=false;\n                        }\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\n                        top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n                        parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\ttop.content.frames[1].frames[2].document.getElementById(\"tab1\").scrollIntoView();\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t    top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\n                   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n                      top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\n\t\t\t\t\t    if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n                        parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t    parent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].ok!=null){\n\t\t\t\t\t\tparent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t }\n                        }else{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (parent.frames[0].document.forms[0].ok!=null){\n\t\t\t\t\t\tparent.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t }\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n                    <script>\n\t\t\t\t%>       \n\t\t\t\t\t    top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t    \t<script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\t if (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t    parent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].ok!=null){\n\t\t\t\t\t\tparent.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t }\n\t\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n\t\t\t\t    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n                       top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\tif (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){\ttop.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;\n                    }\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<script>\n                       parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n                        parent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t</script>\n\t\t\t\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                    <script>\n                      top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t    parent.frames[1].document.forms[0].ok.disabled=true;\n\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].ok!=null){\n\t\t\t\t\t\tparent.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n                    <script>\n                        parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t    parent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\t//parent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.TriageButtonsFrame.SecondaryTriageButtonsForm.Record.disabled=false;\n                        }\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n\t\t\t\t    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t  top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t }\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\t\t\t\t\t\tif (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n                        parent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}else if(parent.frames[2].document.forms[0].bed_bay_no!=null) {\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n                        parent.frames[0].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t</script>\n\t\t\t\t   ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n                       <script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\n\t\t\t\t\t   \ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\n                        if (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n                            parent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].ok!=null){\n                        parent.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n                    <script>\n                       parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t    parent.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t    parent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n                        }\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n\t\t\t\t    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();\n\t\t\t\t\t\tif (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){\n                        top.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;\n                        }\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\t\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].bed_bay_no!=null){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_bay_no.select();\n                        parent.frames[1].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}else if(parent.frames[2].document.forms[0].bed_bay_no!=null) {\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.value=\"\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].bed_bay_no.select();\n                        parent.frames[2].document.forms[0].ok.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<script>\n                     top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="{%>\n                    <script>\n                      parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<script>\n\t\t\t\tparent.f_query_add_mod.patientDetailsFrame.document.forms[0].action=\'../../servlet/eAE.AERegisterAttnServlet\';\n\t\t\t\tparent.f_query_add_mod.patientDetailsFrame.document.forms[0].target=\'messageFrame\';\n\t\t\t     parent.f_query_add_mod.patientDetailsFrame.document.forms[0].submit();\n\t\t    </script>\n       ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n        <script>\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].submit();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n         <script>\n         async function toSubmit(){\n\t\t\t\t\t\t var proceed1 = true; \n\t\t  if (parent.frames[1].document.getElementById(\'practitioner_id\')!=null){\n\t\t  /*var practitioner_id\t\t=\tparent.frames[1].document.forms[0].practitioner_id.value;\n\t         if(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t {\n\t\t\t\t \n\t\t\t  parent.frames[1].document.forms[0].practitioner_desc.select();\n\t\t\t  proceed1 = false;\n\t\t\t }*/\n\t\t if(proceed1){ \n\t\t\t if(await parent.funQry1())\n\t         {\n\t\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageFrame\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t }\n\t\t }\n\t\t}else{\n\t\t\t\t\t//var dialogFrame = parent.document.getElementById(\'dialog-body\').contentWindow\n\t\t\t\t\tvar dialogFrame=top.window.document.getElementById(\'dialog-body\').contentWindow;\n\t\t\t\t\tdialogFrame.frames[1].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t\tdialogFrame.frames[1].document.forms[0].priority_value.disabled = false;\n\t\t\t\t\tdialogFrame.frames[1].document.forms[0].assign_tmt_area_time.disabled = false;\n\t\t\t\t\t\n\t\t\t\t\t/*top.content.workAreaFrame.document.getElementById(\"treatment_area_code\").disabled = false;\n\t\t\t\t\ttop.content.workAreaFrame.document.getElementById(\"priority_value\").disabled=false;\n\t\t\t\t\ttop.content.workAreaFrame.document.getElementById(\'assign_tmt_area_time\').disabled=false;*/\n\t\t\t\t\t\n\t\t\t\t\tif(top.messageframe==null){\n\t\t\t\t\tdialogFrame.frames[1].document.forms[0].target = \"messageFrame\";\n\t\t\t\t\t//top.content.workAreaFrame.document.forms[0].target = \"messageFrame\";\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\tdialogFrame.frames[1].document.forms[0].target = \"messageframe\";\n\t\t\t\t\t//top.content.workAreaFrame.document.forms[0].target = \"messageframe\";\n\t\t\t\t\t}\n\t\t\t\t\t/*var practitioner_id\t\t=\ttop.content.workAreaFrame.document.forms[0].practitioner_id.value;\n\n\t\t\t\t\t\tif(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t\t\t\t {\n\t\t\t\t\t\t\talert(\'1.....\');\n\t\t\t\t\t\t  alert(getAEMessage(\"AE_PRACTITIONER_BLANK\"));\n\t\t\t\t\t\t  top.content.workAreaFrame.document.forms[0].practitioner_desc.select();\n\t\t\t\t\t\t  proceed1 = false;\n\t\t\t\t\t\t }*/\n\t\t\t\t\t if(proceed1){\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar check = await dialogFrame.funQry1();\n\t\t\t\t\t\t if(check)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t        dialogFrame.frames[1].document.forms[0].method = \"POST\";\n\n\t\t\t\t\t\t\tdialogFrame.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\n\t\t\t\t\t\t\tdialogFrame.frames[1].document.forms[0].submit();\n\n\t\t\t\t\t\t\tdialogFrame.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\n\t\t\t\t\t\t\t/*top.content.workAreaFrame.document.forms[0].method = \"POST\";\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.document.forms[0].submit();\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.document.forms[0].assign_tmt_area_time.disabled=true;*/\n\t\t\t\t\t\t\t}\n\t\t          }\n\t\t\t }\n\t\t}\n         toSubmit();\n\t\t </script>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n         <script>\n         async function toSubmit(){\n        \t \n        \tvar ret = await parent.funQry1();\n\t\t\t if(ret)\n\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageFrame\";\n\t\t\t\t\t    parent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\t\t\t\t\t    parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\t\t    parent.frames[1].document.forms[0].submit();\n\t\t\t\t\t    parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t\t}}\n         toSubmit();\n\t\t </script>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n         <script>\n\t\t if(parent.funQry1())\n\t\t\t{\n\t\t\t \tparent.frames[1].document.forms[0].target = \"messageFrame\";\n\t\t\t\tparent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t}\n\t\t </script>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<script>\n\t\tasync function toSubmit(){\n\t\t\t\tvar practitioner_id\t\t=\tparent.frames[1].document.getElementById(\'practitioner_id\').value;\n\t\t var proceed1 = true;\n         if(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t {\n\t\t\t  alert(getMessage(\"AE_PRACTITIONER_BLANK\",\'AE\'));\n\t\t\t  parent.frames[1].document.forms[0].practitioner_desc.select();\n\t\t\t  proceed1 = false;\n\t\t\t }\n\t\t if(proceed1){\n\t\t\tif(await parent.funQry1())\n\t\t\t{\n\n\t\t\t \t parent.frames[1].document.forms[0].target = \"messageFrame\";\n\t\t\t\t parent.frames[1].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t parent.frames[1].document.forms[0].priority_value.disabled=false;\n\t\t\t\t parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\t parent.frames[1].document.forms[0].method = \"POST\";\n\t\t\t\t parent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\t\t\t     parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\t parent.frames[1].document.forms[0].submit();\n\t\t\t     parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t}\n\t\t }\n\t\t}\n\t\ttoSubmit();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t <script>\n\t\t\t\t// top.content.workAreaFrame.document.forms[0].submit();\n\t\t\t\t top.content.frames[2].frames[2].document.forms[0].submit();\n\t\t\t  </script>\n\t\t\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<script>\n\t\t\t\t  parent.frames[2].document.forms[0].submit();\n\t\t    </script>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                <script>\n               async function toSubmit(){\n\t\t\t\t    var proceed1 = true;\n                    if (parent.frames[1].document.forms[0].treatment_area_code !=null){\n\t\t\t\t\tparent.frames[1].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t\tparent.frames[1].document.forms[0].priority_value.disabled=false;\n\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\n\t\t\t\t\tif(top.messageframe==null){\n\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageFrame\";}\n\t\t\t\t\telse {\n\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageframe\";\n\t\t\t\t\t}\n                    var practitioner_id\t\t=\tparent.frames[1].document.getElementById(\'practitioner_id\').value;\n\n\t\t\t\t\tif(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t                 {\n\t\t\t          alert(getMessage(\"AE_PRACTITIONER_BLANK\",\'AE\'));\n                      parent.frames[1].document.forms[0].practitioner_desc.select();\n\t\t\t\t\t  proceed1 = false;\n\t\t             }\n\t\t\t\t\t if(proceed1){\n\t\t\t\t\t   if(await parent.funQry1())\n\t\t\t            {\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].method = \"POST\";\n\t\t\t\t\t\t    parent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t  }\n\t\t\t\t\t}else{\n\t\t\t\t\tparent.frames[2].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t\tparent.frames[2].document.forms[0].priority_value.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].assign_tmt_area_time.disabled=false;\n\n\t\t\t\t\tif(top.messageframe==null){\n\t\t\t\t\tparent.frames[2].document.forms[0].target = \"messageFrame\";}\n\t\t\t\t\telse {\n\t\t\t\t\tparent.frames[2].document.forms[0].target = \"messageframe\";\n\t\t\t\t\t}\n                    var practitioner_id\t\t=\tparent.frames[2].document.getElementById(\'practitioner_id\').value;\n\t\t\t\t\n\t\t\t\t\t\tif(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t\t\t\t {\n\t\t\t\t\t\t  alert(getMessage(\"AE_PRACTITIONER_BLANK\",\'AE\'));\n\t\t\t\t\t\t  parent.frames[2].document.forms[0].practitioner_desc.select();\n\t\t\t\t\t\t  proceed1= false;\n\t\t\t\t\t\t }\n\t\t\t\t\t if(proceed1){\n\t\t\t\t\t  if(await parent.funQry1())\n\t\t\t             {\n\t\t\t\t\t\t    parent.frames[2].document.forms[0].method = \"POST\";\n\n\t\t\t\t\t\t\t//cument.forms[0].ok.disabled = true;\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t\t\t\t }\n\t\t\t\t\t  }\n\t\t\t\t\t}\n               }\n               toSubmit();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n                  \t<script>\n                  \tasync function toSubmit(){\n\t\t\t\t\tvar proceed1=true;\n\t\t\t\t \ttop.content.workAreaFrame.frames[2].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].priority_value.disabled=false;\n\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].assign_tmt_area_time.disabled=false;\n\n\t\t\t\t\tif(top.messageframe==null){\n\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].target = \"messageFrame\";}\n\t\t\t\t\telse {\n\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].target = \"messageframe\";\n\t\t\t\t\t}\n                    var practitioner_id\t\t=\ttop.content.workAreaFrame.frames[2].document.getElementById(\'practitioner_id\').value;\n\n\t\t\t\t\t\tif(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t\t\t\t {\n\t\t\t\t\t\t  alert(getMessage(\"AE_PRACTITIONER_BLANK\",\'AE\'));\n\t\t\t\t\t\t  top.content.workAreaFrame.frames[2].document.forms[0].practitioner_desc.select();\n\t\t\t\t\t\t  proceed1 = false;\n\t\t\t\t\t\t }\n\t\t\t\t\t if(proceed1){\n\t\t\t\t\t   if(await parent.funQry1())\n\t\t\t             {\n\t\t\t\t\t\t    top.content.workAreaFrame.frames[2].document.forms[0].method = \"POST\";\n\n\t\t\t\t\t\t\t//cument.forms[0].ok.disabled = true;\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].submit();\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frames[2].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t\t\t\t }\n\t\t\t\t\t }\n                  \t}\n                  \ttoSubmit();\n\t\t\t\t</script>\n                 ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tasync function toSubmit(){\n\t\t\t        var proceed1=true;\n\t\t\t\t\tparent.frames[1].document.forms[0].treatment_area_code.disabled = false;\n\t\t\t\t\tparent.frames[1].document.forms[0].priority_value.disabled=false;\n\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;\n\t\t\t\t\tif(top.messageframe==null){\n\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageFrame\";}\n\t\t\t\t\telse {\n\t\t\t\t\tparent.frames[1].document.forms[0].target = \"messageframe\";\n\t\t\t\t\t}\n                    var practitioner_id\t\t=\tparent.frames[1].document.getElementById(\'practitioner_id\')value;\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\tif(practitioner_id==\'\' || practitioner_id==\'*ALL\')\n\t\t\t\t\t\t {\n\t\t\t\t\t\t  alert(getMessage(\"AE_PRACTITIONER_BLANK\",\'AE\'));\n\t\t\t\t\t\t  parent.frames[1].document.forms[0].practitioner_desc.select();\n\t\t\t\t\t\t  proceed1 = false;\n\t\t\t\t\t\t }\n\t\t\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t if(proceed1){\n\t\t\t\t\t\t if(await parent.funQry1())\n\t\t\t             {\n\t\t\t\t\t\t    parent.frames[1].document.forms[0].method = \"POST\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].action = \"../../servlet/eAE.AEManagePatientServlet\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;\n\t\t\t\t\t\t }\n\t\t\t\t\t }\n\t\t\t\t\t}\n\t\t\t\t\ttoSubmit();\n\t\t\t\t</script>\n\t            ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n<!-- <script>\nparent.frames[1].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";</script> -->\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

/** To Handle java.lang.NullPointerException. **/

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString ); 
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
  
	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	PreparedStatement pstat			=	null;
	ResultSet		rs				=	null;

	StringBuffer sqlBuffer			=	new StringBuffer();
	String		function_name		=	""; 
	String		sub_function_name	=	"";
	String		field1				=	"";
	String		field2				=	"";
	String		field3				=	"";
	String		field4				=	"";
	String patient_id="";
	String caInstalled = "";
	String reg_flag = "";
	String called_from_ca = "";
	String calledFrom="";
	String eff_status ="";
	String selection_mode="";
	String func_source="";
	request.setCharacterEncoding("UTF-8");

	boolean submit_flag = true;
	boolean proceed = true;

	boolean submit_flag1 =true;
	try
	{
		function_name		=	checkForNull(request.getParameter("function_name"));
		sub_function_name	=	checkForNull(request.getParameter("sub_function_name"));
		field1				=	checkForNull(request.getParameter("field1"));
		field2				=	checkForNull(request.getParameter("field2"));
		field3				=	checkForNull(request.getParameter("field3"));
		field4				=	checkForNull(request.getParameter("field4"));
		func_source       = request.getParameter("func_source");
        func_source 		         = (func_source == null)?"":func_source; 
		session.putValue("queryString",func_source);
		connection			= ConnectionManager.getConnection(request);
		patient_id=checkForNull(request.getParameter("patient_id"));
        caInstalled=checkForNull(request.getParameter("caInstalled"));
		reg_flag=checkForNull(request.getParameter("reg_flag"));
        called_from_ca =checkForNull(request.getParameter("called_from_ca"));
        calledFrom =checkForNull(request.getParameter("calledFrom"));
		selection_mode=checkForNull(request.getParameter("selection_mode")); 
		if ((function_name.equals("ManagePatGITreatArea")) && (sub_function_name.equals("ValidBed")))
		{
			String treatment_area	=	field1;
			String bed				=	field2;
			String facility_id		=	field3;
			String clinic			=	field4;

			int countValue			= 0;
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("select count(*) countValue from ae_bed_for_trmt_area where clinic_code ");
			sqlBuffer.append("= ? and treatment_area_code = ? and bed_no = ? and facility_id = ? ");
			
			if (pStatement != null)	pStatement	= null;
			if (resultSet != null)	resultSet	= null;

			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			
			pStatement.setString(1, clinic);
			pStatement.setString(2, treatment_area);
			pStatement.setString(3, bed);
			pStatement.setString(4, facility_id);

			resultSet	= pStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				countValue	=	resultSet.getInt("countValue");
			if(pStatement!=null)pStatement.close();
            if(resultSet!=null)resultSet.close();
			if (countValue == 0)
			{
				proceed = false;
				if (caInstalled.equals("Y")){
					if(selection_mode.equals("triage")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{
            _bw.write(_wl_block9Bytes, _wl_block9);
submit_flag = false;}
                }else if (selection_mode.equals("triage")){
            _bw.write(_wl_block10Bytes, _wl_block10);
submit_flag1= false;}else if (reg_flag.equals("Y")){ 
            _bw.write(_wl_block11Bytes, _wl_block11);
submit_flag= false;}else if (called_from_ca.equals("Y")){
                     
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
			}
			if (countValue > 0)
			{
				int maxRecord = 0 ;
				String occupying_patient_id	 = "";
				String current_status		 = "";
				String occupying_bed_no		 = "";
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				    sqlBuffer.append("select occupying_patient_id, current_status,bed_no,eff_status from ");
				    sqlBuffer.append("ae_bed_for_trmt_area where clinic_code = ? and treatment_area_code ");
				    sqlBuffer.append("= ? and bed_no = ? and facility_id = ? ");
				
				if (pStatement != null)	pStatement	= null;
				if (resultSet != null)	resultSet	= null;

				pStatement	= connection.prepareStatement(sqlBuffer.toString());

				pStatement.setString(1, clinic);
				pStatement.setString(2, treatment_area);
				pStatement.setString(3, bed);
				pStatement.setString(4, facility_id);

				resultSet	= pStatement.executeQuery();
				if ((resultSet != null) && (resultSet.next()))
				{
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
					occupying_bed_no =
                    checkForNull(resultSet.getString("bed_no"));
				eff_status =                    checkForNull(resultSet.getString("eff_status"));
				} 
				if(pStatement!=null)pStatement.close();
                if(resultSet!=null)resultSet.close();
				if (eff_status.equals("D"))
				{
                  if (caInstalled.equals("Y")){
					  if(selection_mode.equals("triage")){
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
					}else if (reg_flag.equals("Y")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
submit_flag= false;}else if (called_from_ca.equals("Y")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
			    }
				if ((!occupying_patient_id.equals("")) && (!occupying_bed_no.equals("")))
				if ((!occupying_patient_id.equals(patient_id)) &&  (current_status.equals("O")) )
				{
				proceed = false;
                if (caInstalled.equals("Y")){
				 if(selection_mode.equals("triage")){
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
}
						}else if (selection_mode.equals("triage")){
            _bw.write(_wl_block21Bytes, _wl_block21);
submit_flag1= false;
					}else if (reg_flag.equals("Y")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
submit_flag= false;}else if (called_from_ca.equals("Y")){ 
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
 }
				}
				if (current_status.equals("R"))
				{
                pstat  = connection.prepareStatement("select (1) from ae_bed_for_trmt_area where occupied_until_date_time >= sysdate and clinic_code = ? and treatment_area_code = ? and bed_no = ? and facility_id = ?");
					pstat.setString(1, clinic);
				    pstat.setString(2, treatment_area);
				    pstat.setString(3, bed);
				    pstat.setString(4, facility_id);
                    rs = pstat.executeQuery();
                   if (rs!=null)
                   {
                    while (rs.next())
                    {
                     maxRecord = rs.getInt(1);
                    }
				   }
				    if(rs != null) rs.close(); 
	            	if(pstat != null) pstat.close();
					if (!(maxRecord==0))
					{
					proceed = false;
		         	if (caInstalled.equals("Y")){
						if(selection_mode.equals("triage")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
 }
						}else if (selection_mode.equals("triage")){
            _bw.write(_wl_block27Bytes, _wl_block27);
submit_flag1= false;
				 }else if (reg_flag.equals("Y")){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
submit_flag= false;}else if (called_from_ca.equals("Y")){ 
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
				    }
				}

                if (called_from_ca.equals("Y")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
}else if ((reg_flag.equals("")) && (caInstalled.equals("")) ){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
	}			
		  }
		}
		
		if ((submit_flag) && reg_flag.equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
        else if ((submit_flag) && caInstalled.equals("Y") && (selection_mode.equals("triage")) && (proceed) ){
            _bw.write(_wl_block34Bytes, _wl_block34);
}
		else if ((submit_flag) && caInstalled.equals("Y") && (proceed)){
            _bw.write(_wl_block35Bytes, _wl_block35);

		}
		else if ((submit_flag) && selection_mode.equals("AssignTreatmentArea")){
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
		 else if ((submit_flag) && selection_mode.equals("ReassignTreatmentArea")){
            _bw.write(_wl_block37Bytes, _wl_block37);

		}
		else if ((submit_flag) && selection_mode.equals("AssignReassignPractitioner")){
            _bw.write(_wl_block38Bytes, _wl_block38);
}
        else if ((submit_flag1) && (selection_mode.equals("triage"))){
			 if (caInstalled.equals("Y") && (proceed)){
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
}
		}
        else if(( proceed) && calledFrom.equals("bedValidY"))
		{
			 if (caInstalled.equals("Y") && (!(selection_mode.equals("triage")))){
		     
            _bw.write(_wl_block41Bytes, _wl_block41);
}else if (called_from_ca.equals("Y") ){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
}else if (!submit_flag1){	
           
            _bw.write(_wl_block43Bytes, _wl_block43);
if (selection_mode.equals("AssignReassignPractitioner")){
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
}
				if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
		}
	}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(connection, request);
	}

            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

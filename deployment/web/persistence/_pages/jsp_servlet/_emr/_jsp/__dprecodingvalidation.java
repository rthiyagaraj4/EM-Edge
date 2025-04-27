package jsp_servlet._emr._jsp;

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
import webbeans.eCommon.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingValidation.jsp", 1709118913142L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\'none\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[5].document.forms[0].Save.disabled=false;\n\t\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].Save.disabled=false;\n\t\t\t\t\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"!=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_0.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'==\"D\" || \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'==\"C\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_0.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_1.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_1.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_2.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_2.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\"CODE_NOT_SELECTABLE\",\"MR\"));\n\t\t\t\t\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value = \"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value = \"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value = \"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"){\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"){\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"){\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\"CODE_NOT_SELECTABLE\",\"MR\"));\t\t\t\t\t\t\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\"\";\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\"\";\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\"\";\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'ACT_DIAG_PROC_CODE\',\'MR\'));\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\'none\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'!=\"Y\"){\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'!=\"Y\"){\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code3.focus();\n\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'!=\"Y\"){\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[5].document.forms[0].Save.disabled=false;\n\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t<script>submit();</script><!-- Submit Should Come -->\n\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.focus();\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.focus();\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\t\t\t\t\t\t/* In Below line ComplaintSrch added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[5].document.forms[0].ComplaintSrch) // added for existing issue while testing Ml_mmoh_crf-0878\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].ComplaintSrch.disabled=false; \n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_0.value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'==\"C\"){\n\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_0.value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t// ADDED BY MUJAFAR FOR ML-MMOH-CRF-1281 START\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\tif(parent.frames[5].document.getElementById(\'other_disp1\')) // Added by mujafar for ML-MMOH-CRF-1281 US3\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[5].document.getElementById(\'other_disp1\').style.visibility=\'visible\'; \n\t\t\t\t\t\tparent.frames[5].document.getElementById(\'other_disp2\').style.visibility=\'visible\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar select = parent.frames[5].document.forms[0].term_oth_desc;\n\t\t\t\t\t\t\n\t\t\t\t\t\t if (select.type!=\'hidden\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\twhile (select.options.length > 0 )\n\t\t\t\t\t\t\tselect.remove(select.options[0]);\n\t\t\t\t\t\t\tvar element =parent.frames[5].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----- \';\n\t\t\t\t\t\t\telement.value= \'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\n\t\t\t\t\t\t\tvar element =parent.frames[5].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";//  description";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\t\t\t\tif(element.value!=\'\')\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\t\t     }\t\n\n\t\n\n\n\n\t\t\t\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[5].document.getElementById(\'other_disp1\'))\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[5].document.getElementById(\'other_disp1\').style.visibility=\'hidden\'; \n\t\t\t\t\t\tparent.frames[5].document.getElementById(\'other_disp2\').style.visibility=\'hidden\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar select = parent.frames[5].document.forms[0].term_oth_desc;\n\t\t\t\t\t\t\n\t\t\t\t\t\t if (select.type!=\'hidden\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\twhile (select.options.length > 0 )\n\t\t\t\t\t\t\tselect.remove(select.options[0]);\n\t\t\t\t\t\t\tvar element =parent.frames[5].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----- \';\n\t\t\t\t\t\t\telement.value= \'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t     }\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_1.value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_1.value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_2.value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].dagger_independent_yn_2.value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'!=0){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].code_indicator_2.value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\"CODE_NOT_SELECTABLE\",\"MR\"));\t\n\t\t\t\t\t\t\t</script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value = \"\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value = \"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value = \"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value = \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"){\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_0\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_0.value=\'\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"){\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_1\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_1.value=\'\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value = \"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"){\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.getElementById(\"long_desc_2\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].long_desc_val_2.value=\'\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\"CODE_NOT_SELECTABLE\",\"MR\"));\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\"\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\"\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value = \"\";\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\"\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc2.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code2.value=\"\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_2.value=\"\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_0.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_desc1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].hid_diagprob_code_1.value=\'\';\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'!=\"Y\"){\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t  <script>\n\t\t\t\t\t   parent.frames[5].document.forms[0].diagprob_desc2.value=\'\';\n\t\t\t\t\t   parent.frames[5].document.forms[0].diagprob_code2.value=\'\';\n\t\t\t\t\t   parent.frames[5].document.forms[0].hid_diagprob_code_2.value=\'\';\n\t\t\t\t\t   parent.frames[5].document.forms[0].diagprob_code3.focus();\n\t\t\t\t\t   if(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'!=\"Y\"){\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;\n\t\t\t\t\t   }\n\t\t\t\t\t  </script>\n\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t<script>parent.frames[6].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";</script>\n\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\n\t\t  <script>\n\t\t\tparent.frames[2].document.forms[0].recal_yn.value = \"Y\";\n\t\t\tparent.frames[2].document.forms[0].sequenced_yn.value = \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\";\n\t\t\tparent.frames[2].document.forms[0].authorize_item.value = \"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\";\n\t\t\tparent.frames[2].document.forms[0].drg_temp.value = \"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n\n\n\n\t\t</script>\n\t\t  ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t<script>\n\t\t\t\t\n\t\t\t\t//parent.frames[2].document.forms[0].action=\"../../servlet/eMR.DiagProcRecodingServlet\";\n\t\t\t\t//parent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\t\tparent.frames[2].document.forms[0].action=\"../../servlet/eMR.DRGCalculationServlet\";\n\t\t\t\tparent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\n\t\t\t  <script>\n\t\t\t\t\tvar error=getMessage(\"DATE_BTWN_ENC_PERIOD_RANGE\",\"MR\") ;\n\t\t\t\t\tvar proc_type\t\t\t= parent.frames[5].document.forms[0].proc_type.value;\n\t\t\t\t\tvar start_dt_time\t\t= parent.frames[5].document.forms[0].start_dt_time;\n\t\t\t\t\tvar end_dt_time\t\t= parent.frames[5].document.forms[0].end_dt_time;\n\t\t\t\t\tvar start_dt_tm_lbl\t= \"\";\n\t\t\t\t\tvar end_dt_tm_lbl\t= \"\";\n\t\t\t\t\tif(proc_type==\"OT\"){\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'==\"start_dt_time\"){\n\t\t\t\t\t\t\tstart_dt_tm_lbl\t = getLabel(\"eMR.checkindatetime.label\",\"MR\");\n\t\t\t\t\t\t\terror\t = error.replace(\"$\",start_dt_tm_lbl)\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].start_dt_time.value=\"\";\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].start_dt_time.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_srt_dt_hid.value=\"Y\";\n\t\t\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'==\"end_dt_time\"){\n\t\t\t\t\t\t\tend_dt_tm_lbl\t = getLabel(\"eMR.checkoutdatetime.label\",\"MR\");\n\t\t\t\t\t\t\terror\t = error.replace(\"$\",end_dt_tm_lbl)\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].end_dt_time.value=\"\";\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].end_dt_time.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_end_dt_hid.value=\"Y\";\n\t\t\t\t\t}\n\t\t\t\t}else if(proc_type==\"NO\"){\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'==\"start_dt_time\"){\n\t\t\t\t\t\t\tstart_dt_tm_lbl\t = getLabel(\"Common.startdatetime.label\",\"Common\");\n\t\t\t\t\t\t\terror\t = error.replace(\"$\",start_dt_tm_lbl)\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].start_dt_time.value=\"\";\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].start_dt_time.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_srt_dt_hid.value=\"Y\";\n\t\t\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'==\"end_dt_time\"){\n\t\t\t\t\t\t\tend_dt_tm_lbl\t = getLabel(\"Common.enddatetime.label\",\"Common\");\n\t\t\t\t\t\t\terror\t = error.replace(\"$\",end_dt_tm_lbl)\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].end_dt_time.value=\"\";\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].end_dt_time.focus();\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_end_dt_hid.value=\"Y\";\n\n\t\t\t\t\t}\n\t\t\t\t}\n//\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n\t\t\t </script>\n\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t  <script>\n\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_srt_dt_hid.value=\"N\";\n\t\t\t\t\t  </script>\n\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t  <script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_srt_dt_hid.value=\"Y\";\n\t\t\t\t\t\t  </script>\n\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t  <script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_srt_dt_hid.value=\"N\";\n\t\t\t\t\t\t  </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[5].document.forms[0].proc_end_dt_hid.value=\"N\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_end_dt_hid.value=\"Y\";\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t  <script>\n\t\t\t\t\t\t\t\tparent.frames[5].document.forms[0].proc_end_dt_hid.value=\"N\";\n\t\t\t\t\t\t  </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


	public int  getSupprtDiagCnt(String term_set,String term_code,Connection con){
		int support_diag_cnt=0;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql_sprt_diag	=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
		try{
			stmt  = con.prepareStatement(sql_sprt_diag);
			rs		 = stmt.executeQuery();
			while(rs.next()){
					support_diag_cnt=rs.getInt("COUNT");
			}
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
		}catch(Exception ex){
			support_diag_cnt=0;
			ex.printStackTrace();
		}
			return support_diag_cnt;
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
 request.setCharacterEncoding("UTF-8");
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

 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale					= (String) session.getValue( "LOCALE" ) ;
  //String locale = (String)session.getAttribute("LOCALE"); 


	Connection con = null; 
	PreparedStatement stmt1=null;
//	PreparedStatement stmt_appln_yn=null;
	PreparedStatement stmt=null;
	ResultSet rs1 = null;
//	ResultSet rs_appln_yn = null;
	ResultSet rs = null;

//	StringBuffer sql = new StringBuffer();
	String Pat_id = "";
	String term_set_id = "";
	String term_set_code = "";
	String Age = "";
	String dob = "";
	String sex = "";
//	String age_group_appl_yn = "";
//	String age_spec_ind_val = "";
	String short_desc = "";
	String long_desc = "";
	String select_yn = "";
	String mode = "";
	//String diag_class_code = "";
	//String curr_accuracy_code = "";
	//String curr_severity = "";
	//String curr_priority = "";
	//String curr_onset_type = "";
	//String curr_onset_date = "";
	//String status = "";
	//String status_date = "";
	//String applicable_side = "";
	//String curr_remarks = "";
	//String caused_death = "";
	//String occur_srl_no = "";
	String recode_status = "";
	String orig_termset = "";
	String orig_termcode = "";
	String descIndex = "";
	String temp_code = "";
	String drg_flag = "";
	String authorize_item = "";
	//String p_episode_type = "";


	String EncounterId = "";
	String Pat_name = "";
	String Patient_Class = "";
	String Pat_familyname = "";
	String Pat_visit = "";
	String Pat_disch = "";
	String drg_temp = "";
	String Pat_los = "";
	String drg_val = "";
	//String tot_cnt = "";
	String requestSyntax = "";
	String responseSyntax = "";
	String st3 = "";
	String st4 = "";
	String st5 = "";
	String st6 = "";
	String procedure_yn = "";
	//int srl_no = 0;
	//String proc_code_scheme = "";
	//String proc_code = "";
	String sequenced_yn = "";
	String newcodeYN="";
	String stage_no="";
	String proc_chk_dates="";
	String field_names		 =	"";
	String proc_srt_dt		 =	"";
	String proc_end_dt	 =	"";
	String code_indicator	 =	"";
	String dagger_independent_yn	 =	"";
	boolean disp_err	 =	true;//Added On 3/10/2010 for [IN019951]
	boolean disp_age_err	=	true;//Added On 3/10/2010 for [IN019951]
	String isMultiDescAppl = ""; // added by mujafar for ML-MMOH-CRF-1281


	int maxrecord = 0;
	int recordcnt = 0;

	Pat_id = request.getParameter("Pat_id");
	term_set_id = checkForNull(request.getParameter("term_set_id"));
	term_set_code = request.getParameter("term_set_code");
	Age = request.getParameter("Age");
	dob = request.getParameter("Dob");
	sex = checkForNull(request.getParameter("Sex"));
	mode = checkForNull(request.getParameter("mode"));
	descIndex = checkForNull(request.getParameter("descIndex"));
	recode_status = checkForNull(request.getParameter("recode_status"));
	orig_termset = checkForNull(request.getParameter("orig_termset"));
	orig_termcode = checkForNull(request.getParameter("orig_termcode"));
	temp_code = checkForNull(request.getParameter("temp_code"));
	EncounterId = request.getParameter("EncounterId");
	Pat_name = request.getParameter("Pat_name");
	Pat_familyname = checkForNull(request.getParameter("Pat_familyname"));
	Pat_visit = request.getParameter("Pat_visit");
	Pat_disch = request.getParameter("Pat_disch");
	drg_temp = request.getParameter("drg_temp");
	Pat_los = request.getParameter("Pat_los");
	procedure_yn = checkForNull(request.getParameter("procedure_yn"));
	Patient_Class = checkForNull(request.getParameter("Patient_Class"));
	authorize_item = checkForNull(request.getParameter("authorize_item"));
	drg_flag = checkForNull(request.getParameter("drg_flag"));
	sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
	newcodeYN= checkForNull(request.getParameter("newcodeYN"));
	String validCode= checkForNull(request.getParameter("validCode"));
	stage_no= checkForNull(request.getParameter("stage_no"));
	proc_chk_dates= checkForNull(request.getParameter("proc_chk_dates"));
	field_names= checkForNull(request.getParameter("field_names"));
	proc_srt_dt= checkForNull(request.getParameter("proc_srt_dt"));
	proc_end_dt= checkForNull(request.getParameter("proc_end_dt"));
	isMultiDescAppl = checkForNull(request.getParameter("isMultiDescAppl")); // added by mujafar for ML-MMOH-CRF-1281

try
	{
		con = ConnectionManager.getConnection(request);
		
		// added by mujafar for ML-MMOH-CRF-1281 START
		
		int descCount=0;
		JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,term_set_id,term_set_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}
		StringTokenizer validCodeStr=new StringTokenizer(validCode,"$");
int placerInd	=0;
boolean proceed=false;
	if(mode.equals("ValidateDesc")){
		while(validCodeStr.hasMoreTokens()){
			term_set_code	= validCodeStr.nextToken();
			placerInd++;
			int active_term_count = 0;
			//int rec_term_count = 0;
			String sql_recode_exist="";
			if(procedure_yn.equals("Y")){
				sql_recode_exist="select count(*) from mr_procedure_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and proc_code_scheme='"+term_set_id+"' and proc_code in ('"+term_set_code+"') and active_yn='Y' and stage_no='"+stage_no+"'";
			}else{
				sql_recode_exist="select count(*) from mr_diagnosis_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and term_set_id='"+term_set_id+"' and term_code in ('"+term_set_code+"') and active_yn='Y' and stage_no='"+stage_no+"' ";
			}
			stmt1 = con.prepareStatement(sql_recode_exist);
			rs1 =  stmt1.executeQuery();
			if(rs1.next()){
				active_term_count=rs1.getInt(1);
			}
			if(active_term_count==0){
				String sql_cnt="";
				String err="";
				if(procedure_yn.equals("Y")){
					err=" 'MR_INVALID_PROC_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}else{
					err=" 'INVALID_DIAG_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}
				stmt1 = con.prepareStatement(sql_cnt);
				stmt1.setString(1,term_set_code);
				stmt1.setString(2,term_set_id);
				stmt1.setString(3,locale);
				rs1 =  stmt1.executeQuery();
				int maxrecord1=0;
				if(rs1!=null){
					while(rs1.next()){
						short_desc = rs1.getString("short_desc");
						long_desc = rs1.getString("long_desc");
						select_yn = rs1.getString("select_yn");
						maxrecord1++;
					}
				}
				if(rs1 != null) rs1.close();
				if(maxrecord1 == 0){
					if(placerInd==1){
						out.print("<script>alert(getMessage("+err+"))</script>");
						
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(placerInd==2){
						out.print("<script>alert(getMessage("+err+"))</script>");
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else if(placerInd==3){
					out.print("<script>alert(getMessage("+err+"))</script>");
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{//Valid Code
						if(!procedure_yn.equals("Y")){  // to be executed only for diagnosis .
							if(select_yn.equals("Y")){
								//String QUERY_FOR_VALID_CODE= "SELECT SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)";

								String QUERY_FOR_VALID_CODE= "SELECT COUNT(*) COUNT,SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_LANG_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND LANGUAGE_ID=? AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL) group by SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN";

								stmt = con.prepareStatement(QUERY_FOR_VALID_CODE);
								stmt.setString(1,term_set_id);
								stmt.setString(2,term_set_code);
								stmt.setString(3,locale);
								stmt.setString(4,sex);
								stmt.setString(5,dob);
								rs = stmt.executeQuery();
								int recordcnt1=0;
								int age_count=0;
								if(rs!=null && rs.next()){
									age_count	= rs.getInt("COUNT");
									short_desc		= checkForNull(rs.getString("SHORT_DESC"));
									long_desc			= checkForNull(rs.getString("LONG_DESC"));
									code_indicator = checkForNull(rs.getString("CODE_INDICATOR"));
									dagger_independent_yn = checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"),"N");
									recordcnt1++;
									/*Added On 2/16/2010  For Srr-CRF-303.2(IN015597)*/
									if((code_indicator.equals("A") || code_indicator.equals("E")) && !dagger_independent_yn.equals("Y") ){
										recordcnt1=0;
										disp_err =false;
									}
									if(rs!=null) rs.close();
									if(stmt!=null) stmt.close();
								}
								if(disp_err){
									
									/*String QUERY_FOR_PAT_AGE="SELECT COUNT(*) COUNT FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
									stmt = con.prepareStatement(QUERY_FOR_PAT_AGE);
									stmt.setString(1,term_set_id);
									stmt.setString(2,term_set_code);
									stmt.setString(3,sex);
									stmt.setString(4,dob);
									rs = stmt.executeQuery();
									if(rs.next()){
										age_count	= rs.getInt("COUNT");
									}
									*/
									if(age_count==0){
										recordcnt1=0;
										disp_age_err =false;
									}
									//if(rs!=null) rs.close();
									//if(stmt!=null) stmt.close();
								}
								if(recordcnt1 == 0){
									if(placerInd==1){								
										if(!disp_err){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else if(!disp_age_err){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
									}else if(placerInd==2){
										if(!disp_err){
            _bw.write(_wl_block15Bytes, _wl_block15);
}else if(!disp_age_err){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
									}else if(placerInd==3){
									if(!disp_err){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else if(!disp_age_err){
            _bw.write(_wl_block18Bytes, _wl_block18);
}
								}
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
										String long_desc_params	=term_set_code+","+term_set_id;
										int support_diag_cnt = getSupprtDiagCnt(term_set_id,term_set_code,con);
										if(placerInd==1){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else if(placerInd==2){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else if(placerInd==3){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
										proceed =true;
								}
							}else{
            _bw.write(_wl_block46Bytes, _wl_block46);

								if(placerInd==1){
            _bw.write(_wl_block47Bytes, _wl_block47);
}else if(placerInd==2){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else if(placerInd==3){
            _bw.write(_wl_block49Bytes, _wl_block49);
}
							}
						}else{//Procedure YN
							String proc_long_desc_params=term_set_code+","+term_set_id;
							if(select_yn.equals("Y")){
								if(placerInd==1){
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else if(placerInd==2){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block60Bytes, _wl_block60);
}	else if(placerInd==3){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
								proceed=true;
							}else{
            _bw.write(_wl_block66Bytes, _wl_block66);

								if(placerInd==1){
            _bw.write(_wl_block67Bytes, _wl_block67);
}else if(placerInd==2){
            _bw.write(_wl_block68Bytes, _wl_block68);
}else if(placerInd==3){
            _bw.write(_wl_block69Bytes, _wl_block69);
}
							}
						}//Procedure YN =Y;
				}
			}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
if(descIndex.equals("1")){
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else if(descIndex.equals("2")){
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else if(descIndex.equals("3")){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
}
	}//End Of While
		if(proceed){
            _bw.write(_wl_block78Bytes, _wl_block78);
}
	}//End OF ValidateDesc By Clicking Record Button

	else  if(mode.equals("recode"))  {
		  int active_term_count = 0;
		  //int rec_term_count = 0;
			String sql_recode_exist="";
			if(procedure_yn.equals("Y")){
				sql_recode_exist="select count(*) from mr_procedure_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and proc_code_scheme='"+term_set_id+"' and proc_code='"+term_set_code+"' and active_yn='Y' and stage_no='"+stage_no+"' ";
			}else{
				sql_recode_exist="select count(*) from mr_diagnosis_recoding_dtl A ,mr_term_code B where A.patient_id='"+Pat_id+"' and A.facility_id='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and A.term_set_id='"+term_set_id+"' and A.term_code='"+term_set_code+"' and A.active_yn='Y' and B.free_text_yn='N' and A.term_code=B.term_code and stage_no='"+stage_no+"'";
			}
			stmt1 = con.prepareStatement(sql_recode_exist);
			rs1 =  stmt1.executeQuery();
			if(rs1.next()){
				active_term_count=rs1.getInt(1);
			}
		if(active_term_count==0){
				String sql_cnt="";
				String err="";
				if(procedure_yn.equals("Y")){
					 err=" 'MR_INVALID_PROC_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}else{
					 err=" 'INVALID_DIAG_CODE','MR' ";
					sql_cnt="select short_desc,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW  where term_code = ? and term_set_id=? and free_text_yn='N' and eff_status='E' and language_id=? " ;
				}
				stmt1 = con.prepareStatement(sql_cnt);
				stmt1.setString(1,term_set_code);
				stmt1.setString(2,term_set_id);
				stmt1.setString(3,locale);
				rs1 =  stmt1.executeQuery();
				while(rs1.next()){
						short_desc = rs1.getString("short_desc");
						long_desc = rs1.getString("long_desc");
						select_yn = rs1.getString("select_yn");
						maxrecord++;
				}
				if(rs1 != null) rs1.close();
				if(maxrecord == 0){
					if(descIndex.equals("1")){
						out.print("<script>alert(getMessage("+err+"))</script>");
					
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(descIndex.equals("2")){
						out.print("<script>alert(getMessage("+err+"))</script>");
						
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
}else if(descIndex.equals("3")){
							out.print("<script>alert(getMessage("+err+"))</script>");
							
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);


				}else{

					if(!procedure_yn.equals("Y")){  // to be executed only for diagnosis .
						if(select_yn.equals("Y")){
							/*String sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
							stmt_appln_yn = con.prepareStatement(sql_appln_yn);
							stmt_appln_yn.setString(1,term_set_id);
							rs_appln_yn = stmt_appln_yn.executeQuery();
							while(rs_appln_yn.next()){
								age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN");
							}
							if(rs_appln_yn!=null)  rs_appln_yn.close();
							if(stmt_appln_yn!=null)  stmt_appln_yn.close();
							if(age_group_appl_yn.equals("Y")){}*/
								//String QUERY_FOR_VALID_CODE= "SELECT SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)";
								String QUERY_FOR_VALID_CODE= "SELECT COUNT(*) COUNT ,SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_LANG_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND LANGUAGE_ID=? AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL) group by SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN";

								stmt = con.prepareStatement(QUERY_FOR_VALID_CODE);
								stmt.setString(1,term_set_id);
								stmt.setString(2,term_set_code);
								stmt.setString(3,locale);
								stmt.setString(4,sex);
								stmt.setString(5,dob);
								rs = stmt.executeQuery();
								int age_count	=0;

								if(rs!=null && rs.next()){
									age_count	= rs.getInt("COUNT");
									short_desc		= checkForNull(rs.getString("SHORT_DESC"));
									long_desc			= checkForNull(rs.getString("LONG_DESC"));
									code_indicator = checkForNull(rs.getString("CODE_INDICATOR"));
									dagger_independent_yn = checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"),"N");
									recordcnt++;
									/*Added On 2/16/2010  For Srr-CRF-303.2(IN015597)*/
									if((code_indicator.equals("A") || code_indicator.equals("E")) && !dagger_independent_yn.equals("Y") ){
										recordcnt=0;
										disp_err =false;
									}
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
								}

								
								if(disp_err){
									
									/*String QUERY_FOR_PAT_AGE="SELECT COUNT(*) COUNT FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
									stmt = con.prepareStatement(QUERY_FOR_PAT_AGE);
									stmt.setString(1,term_set_id);
									stmt.setString(2,term_set_code);
									stmt.setString(3,sex);
									stmt.setString(4,dob);
									rs = stmt.executeQuery();
									if(rs.next()){
										 age_count	= rs.getInt("COUNT");
									}*/

									if(age_count==0){
										recordcnt=0;
										disp_age_err =false;
									}
									//if(rs!=null) rs.close();
									//if(stmt!=null) stmt.close();
								}

									

								if(recordcnt == 0){
									if(descIndex.equals("1")){								
										if(!disp_err){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else if(!disp_age_err){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
									}else if(descIndex.equals("2")){
										if(!disp_err){
            _bw.write(_wl_block85Bytes, _wl_block85);
}else if(!disp_age_err){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
									}else if(descIndex.equals("3")){
										if(!disp_err){
            _bw.write(_wl_block87Bytes, _wl_block87);
}else if(!disp_age_err){
            _bw.write(_wl_block88Bytes, _wl_block88);
}
									}
									
            _bw.write(_wl_block89Bytes, _wl_block89);

								}else{
									int support_diag_cnt = getSupprtDiagCnt(term_set_id,term_set_code,con);
									String long_desc_params = term_set_code+","+term_set_id;
									if(descIndex.equals("1")){
									
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(descCount>0){
            _bw.write(_wl_block96Bytes, _wl_block96);

							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								
							
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block100Bytes, _wl_block100);

							}	
							
            _bw.write(_wl_block101Bytes, _wl_block101);
}
					else{
					
            _bw.write(_wl_block102Bytes, _wl_block102);

							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);
							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								System.out.println("descriptions else:"+descriptions);
							
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block100Bytes, _wl_block100);

							}	
							
            _bw.write(_wl_block104Bytes, _wl_block104);

						}	
						
            _bw.write(_wl_block105Bytes, _wl_block105);
}
									else if(descIndex.equals("2")){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else if(descIndex.equals("3")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(support_diag_cnt));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);

									}
					}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
if(descIndex.equals("1")){
            _bw.write(_wl_block116Bytes, _wl_block116);
}
							else if(descIndex.equals("2"))
							{
            _bw.write(_wl_block117Bytes, _wl_block117);
}else if(descIndex.equals("3")){
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block119Bytes, _wl_block119);

							}
				}else{
					String proc_long_desc_params =term_set_code+","+term_set_id;
					if(select_yn.equals("Y")){
						if(descIndex.equals("1")){
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block125Bytes, _wl_block125);
}else if(descIndex.equals("2")){
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block130Bytes, _wl_block130);
}	else if(descIndex.equals("3")){
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(proc_long_desc_params));
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);

					}else{
            _bw.write(_wl_block137Bytes, _wl_block137);
if(descIndex.equals("1")){
            _bw.write(_wl_block138Bytes, _wl_block138);
}
							else if(descIndex.equals("2"))
							{
            _bw.write(_wl_block139Bytes, _wl_block139);
}else if(descIndex.equals("3")){
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block119Bytes, _wl_block119);

							}
				}
			}
		}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
if(descIndex.equals("1")){
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
}else if(descIndex.equals("2")){
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
}else if(descIndex.equals("3")){
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
}
            _bw.write(_wl_block147Bytes, _wl_block147);

		}

	}else if(mode.equals("DRG") && Patient_Class.equals("IP")){
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(sequenced_yn));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(authorize_item));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(drg_temp));
            _bw.write(_wl_block151Bytes, _wl_block151);

			 StringTokenizer st8=new StringTokenizer(drg_temp,"~");
			 int temp=st8.countTokens();
				
			for(int u2=0;u2<temp;u2++)
			{
				 String st2=st8.nextToken();
				 StringTokenizer st1=new StringTokenizer(st2,"&");
				while(st1.hasMoreTokens())
				{
					 st3=st1.nextToken();
					 st4=st1.nextToken();
					 st5=st1.nextToken();
					 st6=st1.nextToken();

				}
				
			}

			int asc1=11;
			char c=(char) asc1;
			


			drg_val=c+"DRG|"+Pat_id+"|"+EncounterId+"|"+Pat_name+"|"+Pat_familyname+"|"+Pat_visit+"|"+Pat_disch+"|"+Age+"|"+sex+"|"+Pat_los+"|||"+st4+"|"+st6+"|||||||||||||||||||||||63255|"+dob+"|0|"+Age;

					

			requestSyntax = "####$#Siriraj Hosp - Devlopment DB#%#DRG Segment|hn|an|name|surname|dateadm|datedsc|age|sex|los|discht|pdx|sdx1|sdx2|sdx3|sdx4|sdx5|sdx6|sdx7|sdx8|sdx9|sdx10|sdx11|sdx12|proc1|proc2|proc3|proc4|proc5|proc6|proc7|proc8|proc9|proc10|proc11|proc12|totalcost|Drg|Rw|Ot|Wtlos|Mdc|Err|Warn|Result|dob|admwt|Callos|ageday|Adjrw";

			responseSyntax = "####$#Siriraj Hosp - Devlopment DB#%#DRG Segment|hn|an|name|surname|dateadm|datedsc|age|sex|los|discht|pdx|sdx1|sdx2|sdx3|sdx4|sdx5|sdx6|sdx7|sdx8|sdx9|sdx10|sdx11|sdx12|proc1|proc2|proc3|proc4|proc5|proc6|proc7|proc8|proc9|proc10|proc11|proc12|totalcost|Drg|Rw|Ot|Wtlos|Mdc|Err|Warn|Result|dob|admwt|Callos|ageday|Adjrw";
	
			/*out.println("<script>alert(\"drg_val  :"+drg_val+"\");</script>");
			out.println("<script>alert(\"requestSyntax  :"+requestSyntax+"\");</script>");
			out.println("<script>alert(\"responseSyntax  :"+responseSyntax+"\");</script>");
			out.println("<script>alert(\"authorize_item  :"+authorize_item+"\");</script>");*/
			
            _bw.write(_wl_block152Bytes, _wl_block152);


	  }else if(mode.equals("RemoveSessionVals")){
		  session.removeAttribute("allow_recode_diag_yn");
		  session.removeAttribute("allow_recode_proc_yn");
		  session.removeAttribute("allow_ot_proc_recode_yn");
		  session.removeAttribute("allow_non_ot_proc_recode_yn");
		  session.removeAttribute("drg_calculation_yn");
		  session.removeValue("practitioner_type");
		  session.removeValue("ca_practitioner_id");
		  session.removeAttribute("MedicalReportReq");


	  }else if(mode.equals("VALIDATE_DT_TM")){
		  String status="";
		  String RANGE_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_chk_dates+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
		  stmt1=con.prepareStatement(RANGE_SQL);
		  rs1=stmt1.executeQuery();
		  while(rs1.next()){
				status	=	checkForNull(rs1.getString("STATUS"));
		  }
		  if(status.equals("")){
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(field_names));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(field_names));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(field_names));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(field_names));
            _bw.write(_wl_block157Bytes, _wl_block157);
}
		  if(rs1 != null) rs1.close();
		  if(stmt1 != null) stmt1.close();
	  }else if(mode.equals("VALIDATE_DT_TM_ON_RECORD")){
		  boolean proceed_1 =	true;
		  String strt_dt_status	="";
		  String end_dt_status	="";
		  String STRT_DT_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_srt_dt+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
		  stmt1=con.prepareStatement(STRT_DT_SQL);
		  rs1=stmt1.executeQuery();
		  if(rs1.next()&& rs1!=null){
				strt_dt_status	=	checkForNull(rs1.getString("STATUS"));
				if(strt_dt_status.equals("")){
					proceed_1	=	false;
            _bw.write(_wl_block158Bytes, _wl_block158);
}else{
						proceed_1	=	true;
            _bw.write(_wl_block159Bytes, _wl_block159);
}					  
				}else{
            _bw.write(_wl_block160Bytes, _wl_block160);
}
		  if(proceed_1){
			  if(!proc_end_dt.equals("")){
			  String END_DT_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_end_dt+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
				stmt1=con.prepareStatement(END_DT_SQL);
				rs1=stmt1.executeQuery();
				if(rs1.next()&&rs1!=null){
					end_dt_status	=	checkForNull(rs1.getString("STATUS"));
				if(end_dt_status.equals("")){
					proceed_1	=	false;
            _bw.write(_wl_block161Bytes, _wl_block161);
}else{
						proceed_1	=	true;
            _bw.write(_wl_block162Bytes, _wl_block162);
}					  
				}else{
            _bw.write(_wl_block163Bytes, _wl_block163);
}
			  }
		  }
	  }

	}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
//			session.setAttribute("mr_requestText", drg_val);
//			session.setAttribute("mr_requestSyntax", requestSyntax);
//			session.setAttribute("mr_responseSyntax", responseSyntax);
//			session.setAttribute("drg_flag", drg_flag);

		}

			
            _bw.write(_wl_block164Bytes, _wl_block164);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

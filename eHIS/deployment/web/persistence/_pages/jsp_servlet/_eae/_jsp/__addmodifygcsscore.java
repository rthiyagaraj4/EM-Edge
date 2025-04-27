package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifygcsscore extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/addModifyGCSScore.jsp", 1709113824303L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eAE/js/GCSScore.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t <form name=\"gcs_for_response_form\" id=\"gcs_for_response_form\" action=\"../../servlet/eAE.GCSScoreServlet\" method=\"post\" target=\"messageFrame\">\n\t\t <!--<br>-->\n\t\t <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<th align=\'left\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t <input type=\'hidden\' name=\'er_error_desc\' id=\'er_error_desc\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t</th>\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t    <tr>\n\t\t      <td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' align=\'LEFT\' width=\'85%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t      <input type=\'hidden\' name=\'er_code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'er_code";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t      </td>\n\t\t      <td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=\'center\' width=\'15%\'>&nbsp;\n\t\t\t  <select name=\'er_gcs_code1_weight";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'er_gcs_code1_weight";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t   <option value=\'1\'>1\n\t\t \t\t   <option value=\'2\'>2\n\t\t\t       <option value=\'3\'>3\n\t\t \t\t   <option value=\'4\'>4\n\t\t      </select>\n   \t\t  \t  </td> \t\n\t    </tr>\t\n    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n     ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n        <th align=\'left\' >\n        ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t <input type=\'hidden\' name=\'vr_error_desc\' id=\'vr_error_desc\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t</th>\n\t\t<th align=\'center\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n    <tr>\n\t\t      <td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' align=\'left\' width=\'85%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t      <input type=\'hidden\' name=\'vr_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'vr_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' align=\'center\' width=\'15%\'>&nbsp;\n\t\t\t  <select name=\'vr_gcs_code1_weight";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'vr_gcs_code1_weight";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t      \t   <option value=\'1\'>1\n\t\t \t\t   <option value=\'2\'>2\n\t\t\t       <option value=\'3\'>3\n\t\t \t\t   <option value=\'4\'>4\n\t\t\t\t   <option value=\'5\'>5\n\t\t      </select>\n   \t\t  \t  </td> \t\n\t    </tr>\t\n    ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n\t\t\n        <th align=\'left\' >\n        ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t <input type=\'hidden\' name=\'mr_error_desc\' id=\'mr_error_desc\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n    ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<tr>\n\t\t      <td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t      <input type=\'hidden\' name=\'mr_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'mr_code";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' align=\'center\' width=\'15%\'>&nbsp;\n\t\t\t  <select name=\'mr_gcs_code1_weight";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'mr_gcs_code1_weight";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t      \n\t\t\t\t   <option value=\'1\'>1\n\t\t \t\t   <option value=\'2\'>2\n\t\t\t       <option value=\'3\'>3\n\t\t \t\t   <option value=\'4\'>4\n   \t\t\t       <option value=\'5\'>5\n\t\t\t\t   <option value=\'6\'>6\n\t\t      </select>\n   \t\t  \t  </td> \t\n\t    </tr>\t\n    ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t </table> \n\t\t     <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\t\n\t\t     <input type=\'hidden\' name=\'total_vr\' id=\'total_vr\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t     <input type=\'hidden\' name=\'total_mr\' id=\'total_mr\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t  \t     <input type=\'hidden\' name=\'total_er\' id=\'total_er\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\n\t\t\t <input type=hidden name=\'er_gcs_code1_score\' id=\'er_gcs_code1_score\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t <input type=hidden name=\'er_gcs_code2_score\' id=\'er_gcs_code2_score\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t <input type=hidden name=\'er_gcs_code3_score\' id=\'er_gcs_code3_score\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t <input type=hidden name=\'er_gcs_code4_score\' id=\'er_gcs_code4_score\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\n\t\t\t <input type=hidden name=\'vr_gcs_code1_score\' id=\'vr_gcs_code1_score\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t <input type=hidden name=\'vr_gcs_code2_score\' id=\'vr_gcs_code2_score\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t <input type=hidden name=\'vr_gcs_code3_score\' id=\'vr_gcs_code3_score\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t <input type=hidden name=\'vr_gcs_code4_score\' id=\'vr_gcs_code4_score\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t <input type=hidden name=\'vr_gcs_code5_score\' id=\'vr_gcs_code5_score\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\n\t\t\t <input type=hidden name=\'mr_gcs_code1_score\' id=\'mr_gcs_code1_score\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t\t <input type=hidden name=\'mr_gcs_code2_score\' id=\'mr_gcs_code2_score\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t <input type=hidden name=\'mr_gcs_code3_score\' id=\'mr_gcs_code3_score\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t <input type=hidden name=\'mr_gcs_code4_score\' id=\'mr_gcs_code4_score\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t <input type=hidden name=\'mr_gcs_code5_score\' id=\'mr_gcs_code5_score\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t <input type=hidden name=\'mr_gcs_code6_score\' id=\'mr_gcs_code6_score\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\n\t </form>\n\t\t  ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].er_gcs_code1_weight0.value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight1.value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight2.value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight3.value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\';\n\n\t\t\t\t\t\tdocument.forms[0].vr_gcs_code1_weight0.value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight1.value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight2.value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight3.value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\t\t\tdocument.forms[0].vr_gcs_code1_weight4.value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\';\n\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight0.value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight1.value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight2.value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight3.value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\';\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight4.value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\';\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight5.value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\';\n\t\t\t\t\t</script>\n\t\t   ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].er_gcs_code1_weight0.value=\'1\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight1.value=\'2\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight2.value=\'3\';\n\t\t\t\t  \t    document.forms[0].er_gcs_code1_weight3.value=\'4\';\n\n\t\t\t\t\t\tdocument.forms[0].vr_gcs_code1_weight0.value=\'1\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight1.value=\'2\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight2.value=\'3\';\n\t\t\t\t  \t    document.forms[0].vr_gcs_code1_weight3.value=\'4\';\n\t\t\t\t\t\tdocument.forms[0].vr_gcs_code1_weight4.value=\'5\';\n\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight0.value=\'1\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight1.value=\'2\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight2.value=\'3\';\n\t\t\t\t  \t    document.forms[0].mr_gcs_code1_weight3.value=\'4\';\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight4.value=\'5\';\n\t\t\t\t\t\tdocument.forms[0].mr_gcs_code1_weight5.value=\'6\';\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n    </body>\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n</html>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

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
	
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 PreparedStatement pstmt1			= null;
	 ResultSet rset1				    = null;
	 String mode						= "";
	 int i								= 0;
	 int j								= 0;
	 int k								= 0;
	 String classValue					= "";

  try
  {
	 request.setCharacterEncoding("UTF-8");
     con								= ConnectionManager.getConnection(request);
	 String er_gcs_code1_score			= "";
	 String	er_gcs_code2_score			= "";
	 String er_gcs_code3_score			= "";
	 String er_gcs_code4_score			= "";
	 String vr_gcs_code1_score			= "";
	 String vr_gcs_code2_score			= "";
	 String vr_gcs_code3_score			= "";
	 String vr_gcs_code4_score			= ""; 
	 String vr_gcs_code5_score			= "";
	 String mr_gcs_code1_score			= "";
	 String mr_gcs_code2_score			= "";
	 String mr_gcs_code3_score			= ""; 
	 String mr_gcs_code4_score			= ""; 
	 String mr_gcs_code5_score			= "";  
	 String mr_gcs_code6_score			= "";  
		mode							= "INSERT";
   
    StringBuffer sql = new StringBuffer();
	sql.append(" Select GCS_RESPONSE_CODE_ER, ER_GCS_CODE1, ER_GCS_CODE1_SCORE, ");
	sql.append(" ER_GCS_CODE2, ER_GCS_CODE2_SCORE, ER_GCS_CODE3, ER_GCS_CODE3_SCORE, ");
    sql.append(" ER_GCS_CODE4, ER_GCS_CODE4_SCORE, GCS_RESPONSE_CODE_VR, VR_GCS_CODE1, ");
    sql.append(" VR_GCS_CODE1_SCORE, VR_GCS_CODE2, VR_GCS_CODE2_SCORE, VR_GCS_CODE3, ");          
	sql.append(" VR_GCS_CODE3_SCORE, VR_GCS_CODE4, VR_GCS_CODE4_SCORE, VR_GCS_CODE5, ");
	sql.append(" VR_GCS_CODE5_SCORE, GCS_RESPONSE_CODE_MR, MR_GCS_CODE1, MR_GCS_CODE1_SCORE, ");     
	sql.append(" MR_GCS_CODE2, MR_GCS_CODE2_SCORE, MR_GCS_CODE3, MR_GCS_CODE3_SCORE, ");
	sql.append(" MR_GCS_CODE4, MR_GCS_CODE4_SCORE, MR_GCS_CODE5, MR_GCS_CODE5_SCORE, ");
	sql.append(" MR_GCS_CODE6, MR_GCS_CODE6_SCORE from AE_GCS_SCORE where MODULE_ID='AE'");	    
	//where module_id='AE'";
	pstmt   = con.prepareStatement(sql.toString());
	rset = pstmt.executeQuery();
	 while(rset!=null && rset.next())
	  {
	 		er_gcs_code1_score					= rset.getString("ER_GCS_CODE1_SCORE");    
			er_gcs_code1_score 					= (er_gcs_code1_score == null)?"":er_gcs_code1_score;
	 		er_gcs_code2_score					= rset.getString("ER_GCS_CODE2_SCORE");    
			er_gcs_code2_score 					= (er_gcs_code2_score == null)?"":er_gcs_code2_score;
	 		er_gcs_code3_score					= rset.getString("ER_GCS_CODE3_SCORE");    
			er_gcs_code3_score 					= (er_gcs_code3_score == null)?"":er_gcs_code3_score;
	 		er_gcs_code4_score					= rset.getString("ER_GCS_CODE4_SCORE");    
			er_gcs_code4_score 					= (er_gcs_code4_score == null)?"":er_gcs_code4_score;

			vr_gcs_code1_score					= rset.getString("VR_GCS_CODE1_SCORE");    
			vr_gcs_code1_score 					= (vr_gcs_code1_score == null)?"":vr_gcs_code1_score;
	 		vr_gcs_code2_score					= rset.getString("VR_GCS_CODE2_SCORE");    
			vr_gcs_code2_score 					= (vr_gcs_code2_score == null)?"":vr_gcs_code2_score;
	 		vr_gcs_code3_score					= rset.getString("VR_GCS_CODE3_SCORE");    
			vr_gcs_code3_score 					= (vr_gcs_code3_score == null)?"":vr_gcs_code3_score;
	 		vr_gcs_code4_score					= rset.getString("VR_GCS_CODE4_SCORE");    
			vr_gcs_code4_score 					= (vr_gcs_code4_score == null)?"":vr_gcs_code4_score;
			vr_gcs_code5_score					= rset.getString("VR_GCS_CODE5_SCORE");    
			vr_gcs_code5_score 					= (vr_gcs_code5_score == null)?"":vr_gcs_code5_score;

			mr_gcs_code1_score					= rset.getString("MR_GCS_CODE1_SCORE");    
			mr_gcs_code1_score 					= (mr_gcs_code1_score == null)?"":mr_gcs_code1_score;
	 		mr_gcs_code2_score					= rset.getString("MR_GCS_CODE2_SCORE");    
			mr_gcs_code2_score 					= (mr_gcs_code2_score == null)?"":mr_gcs_code2_score;
	 		mr_gcs_code3_score					= rset.getString("MR_GCS_CODE3_SCORE");    
			mr_gcs_code3_score 					= (mr_gcs_code3_score == null)?"":mr_gcs_code3_score;
	 		mr_gcs_code4_score					= rset.getString("MR_GCS_CODE4_SCORE");    
			mr_gcs_code4_score 					= (mr_gcs_code4_score == null)?"":mr_gcs_code4_score;
			mr_gcs_code5_score					= rset.getString("MR_GCS_CODE5_SCORE");    
			mr_gcs_code5_score 					= (mr_gcs_code5_score == null)?"":mr_gcs_code5_score;
			mr_gcs_code6_score					= rset.getString("MR_GCS_CODE6_SCORE");    
			mr_gcs_code6_score 					= (mr_gcs_code6_score == null)?"":mr_gcs_code6_score;


			mode								= "MODIFY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	  pstmt1 = con.prepareStatement("select GCS_CODE,GCS_DESC,APPL_GCS_RESPONSE_CODE from AE_GCS_FOR_RESPONSE where APPL_GCS_RESPONSE_CODE = ? ");
   
            _bw.write(_wl_block8Bytes, _wl_block8);
	pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where GCS_RESPONSE_CODE = ?");
			pstmt.setString(1,"ER");
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
    out.println(rset.getString(1));  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
  }
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
		 
            _bw.write(_wl_block13Bytes, _wl_block13);

			pstmt1.setString(1,"ER");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		   {
				if ( i % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset1.getString(2)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset1.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);

        i++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	    //if(pstmt1!=null) pstmt1.close();
    
            _bw.write(_wl_block23Bytes, _wl_block23);
		pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where 	GCS_RESPONSE_CODE = ?");
	    pstmt.setString(1,"VR");
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
	
            _bw.write(_wl_block24Bytes, _wl_block24);
    out.println(rset.getString(1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
  }	
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();

			pstmt1.setString(1,"VR");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		{
				if ( j % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rset1.getString(2)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset1.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);

        j++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	   // if(pstmt1!=null) pstmt1.close();
    
            _bw.write(_wl_block35Bytes, _wl_block35);
	pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where GCS_RESPONSE_CODE = ?");
	    pstmt.setString(1,"MR");
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next())
		{
	
            _bw.write(_wl_block36Bytes, _wl_block36);
    out.println(rset.getString(1));  
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
  }	
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
    
            _bw.write(_wl_block39Bytes, _wl_block39);

			pstmt1.setString(1,"MR");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		   {
				if ( k % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rset1.getString(2)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset1.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(k));
            _bw.write(_wl_block45Bytes, _wl_block45);

        k++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	    if(pstmt1!=null) pstmt1.close();
    
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(k));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(er_gcs_code1_score));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(er_gcs_code2_score));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(er_gcs_code3_score));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(er_gcs_code4_score));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(vr_gcs_code1_score));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(vr_gcs_code2_score));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(vr_gcs_code3_score));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(vr_gcs_code4_score));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(vr_gcs_code5_score));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mr_gcs_code1_score));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mr_gcs_code2_score));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(mr_gcs_code3_score));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(mr_gcs_code4_score));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(mr_gcs_code5_score));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(mr_gcs_code6_score));
            _bw.write(_wl_block65Bytes, _wl_block65);

                if(!mode.equals("INSERT"))
				{	
          
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(er_gcs_code1_score));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(er_gcs_code2_score));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(er_gcs_code3_score));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(er_gcs_code4_score));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(vr_gcs_code1_score));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(vr_gcs_code2_score));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(vr_gcs_code3_score));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(vr_gcs_code4_score));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(vr_gcs_code5_score));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(mr_gcs_code1_score));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mr_gcs_code2_score));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mr_gcs_code3_score));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mr_gcs_code4_score));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mr_gcs_code5_score));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mr_gcs_code6_score));
            _bw.write(_wl_block81Bytes, _wl_block81);
	} else {  
            _bw.write(_wl_block82Bytes, _wl_block82);
		}	 
            _bw.write(_wl_block83Bytes, _wl_block83);
 
sql.setLength(0);

} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block84Bytes, _wl_block84);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
}

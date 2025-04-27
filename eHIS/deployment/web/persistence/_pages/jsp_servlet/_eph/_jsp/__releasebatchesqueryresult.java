package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __releasebatchesqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReleaseBatchesQueryResult.jsp", 1709121395845L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
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

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/ReleaseBatches.js\"></script>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"frmReleaseBatchesResult\" id=\"frmReleaseBatchesResult\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script language=\"javascript\">\n\t\t\t\t    parent.f_batch_result.location.href = \"../../eCommon/html/blank.html\"; //Added for MMS ADHOC Testing\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!-- Display the Previous Next link -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' align=\"center\" id=\"nav_table\" width=\"98%\" BORDER=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"75%\" class=\"white\">&nbsp;</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"99%\" align=\"center\">\n\t\t\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<input type=\"checkbox\" name=\"Selcet_chk\" id=\"Selcet_chk\" value=\'\' onClick=\"SelectAll(this)\"></td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<a id=\"docno_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" href=\"javascript:loadBatchDetails(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'docno_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t<!-- <td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td> commented on 7/10/09-->\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td> \n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><img src=\"../../eCommon/images/disabled.gif\" align=\"center\"></td>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><img src=\"../../eCommon/images/enabled.gif\" align=\"center\"></td>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" align=\"center\">\n\t\t\t\t\t\t<select name=\"rcode_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"rcode_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" onchange=\"selectRsnAdmix(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\" > <!-- selectRsnAdmix added for Added for SRR20056-SCF-7734 ICN 28022 -->\t\n\t\t\t\t\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ---</option>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tdocument.frmReleaseBatchesResult.Selcet_chk.checked=true;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tdocument.frmReleaseBatchesResult.Selcet_chk.checked=false;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" align=\"center\">\n\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"check_id";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" name=\"chk_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" onClick=\"chkValue(this, \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\', \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' )\"> <!-- chkValue params added for Added for SRR20056-SCF-7734 ICN 28022 -->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_prep_yn";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'iv_prep_yn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'workSheetid";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'workSheetid";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'doc_srl_no";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'doc_srl_no";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'order_id";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'order_id";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'disp_qty";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'disp_qty";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bms_qty";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'bms_qty";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"dt_from\" id=\"dt_from\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"dt_to\" id=\"dt_to\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn\" id=\"disp_locn\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name=\"batches\" id=\"batches\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"bl_installed_yn\" id=\"bl_installed_yn\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name=\"paid_status\" id=\"paid_status\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\"hidden\" name=\"prevnext\" id=\"prevnext\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"chk_\" id=\"chk_\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t<!-- // Added for SRR20056-SCF-7734 ICN 28022 - Start -->\n\t\t\t<input type=\"hidden\" name=\"incompleteAdmixFound\" id=\"incompleteAdmixFound\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"incompleteAdmixFoundPrev\" id=\"incompleteAdmixFoundPrev\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name=\"rec_count\" id=\"rec_count\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t<input type=\"hidden\" name=\"incompleteAdmixORdID\" id=\"incompleteAdmixORdID\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name=\"PrevAdmixOrderID\" id=\"PrevAdmixOrderID\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t<!-- // Added for SRR20056-SCF-7734 ICN 28022 - End -->\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<!-- // Added for SRR20056-SCF-7706 ICN IN027926 - End -->\n\t\t\t<input type=\"hidden\" name=\"select_value\" id=\"select_value\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"> <!-- added for newly added for ML-BRU-SCF-0603 [IN:036245]-->\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

        request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		try{
			//Search Criteria's from Query Criteria page
			String dt_from		= request.getParameter("dt_from");
			String dt_to		= request.getParameter("dt_to");
			String disp_locn	= request.getParameter("disp_locn");
			String called_frm	= request.getParameter("called_from");
			String batches		= request.getParameter("batches");
			String patient_id	= request.getParameter("patient_id");
			String drug_code	= request.getParameter("drug_code");
			String bl_installed_yn=CommonBean.checkForNull(request.getParameter("bl_installed_yn"));
			String paid_status	=CommonBean.checkForNull(request.getParameter("paid_status"));
			String disabled		=	"";
			String st1		=	"";
			String st2		=	"";
			String select_value = ""; // added for ML-BRU-SCF-0603 [IN:036245]
			
			if(patient_id == null) 
				patient_id="";

			String from			= CommonBean.checkForNull(request.getParameter("from"));
			String to			= CommonBean.checkForNull(request.getParameter("to"));
			String prevnext		= CommonBean.checkForNull(request.getParameter("prevnext"));

			String bean_id				= "ReleaseBatchesBean";
			String bean_name			= "ePH.ReleaseBatchesBean";
			ReleaseBatchesBean bean		= (ReleaseBatchesBean)getBeanObject( bean_id,bean_name,request);
			String facility_id					= (String) session.getValue("facility_id");
		
			if(called_frm!=null && called_frm.equals("search") && !prevnext.equals("prevnext")) {
				bean.clear();
			}
			bean.setLanguageId(locale);
			bean.setMode(CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			bean.setLanguageId(locale);
			ArrayList result			=	bean.getAllocatedRecords(dt_from, dt_to, disp_locn, from, to,patient_id,batches,drug_code,locale,paid_status,bl_installed_yn);
			String classValue			=	"";
			String check_status			=	"";
			String chk_value			=	"";
			String sel_rsn_code			=	"";
			String opt_sel				=	"";
			
			boolean flag=true;

			HashMap record_status		=	bean.getRecordStatus();
			HashMap rsn_cds				=	bean.getRsnCodes();
			ArrayList reason_codes		=	bean.getReasonCodes(locale);
			if(record_status != null && record_status.containsValue("Y")) // if block added for ML-BRU-SCF-0603 [IN:036245]
				select_value = "Y"; 
			
			String sAdmixChk="";//Added for SRR20056-SCF-7734 ICN 28022 - Start
			String sPrevOrderID="";
			String sPrevOrderLineNo="";
			String sIVPrepYN="";
			String sWorkSheetId="";
			String drug_count = "1";
			String sPrevAdmixOrderID = bean.getPrevAdmixOrderID();
			String sPrevAdmixReasonCode = bean.getPrevAdmixReasonCode();
			String sPrevAdmixWorkSheetId = bean.getPrevAdmixWorkSheetId();
			String incompleteAdmixFoundPrev = bean.getIncompleteAdmixFoundPrev();
			String incompleteAdmixORdID ="";
			String admixYN = "";//Added for SRR20056-SCF-7734 ICN 28022 - End
			if(result.size()<=1) {

            _bw.write(_wl_block10Bytes, _wl_block10);

				return;
			}

            _bw.write(_wl_block11Bytes, _wl_block11);
 
			if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){

            _bw.write(_wl_block12Bytes, _wl_block12);

							// For display the previous/next link
							out.println(result.get(0));
							System.err.println(result.get(0));
							//result.remove(0);

            _bw.write(_wl_block13Bytes, _wl_block13);

			}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				if(bl_installed_yn.equals("Y")){

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				}

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				int rec_count	=	1;
				int row_val		=	0;
				int idrug_count = 1;
				for(int i=0; i<result.size();) {
					if(i==0)
						++i;
					if(row_val%2==0)
					   classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";

					row_val++;
					check_status	=	"";
					chk_value		=	"N";
//Added for SRR20056-SCF-7734 ICN 28022 - Start
					sAdmixChk = "";
					sWorkSheetId	= (String)result.get(i+11);
					sIVPrepYN		=(String)result.get(i+12);
					drug_count = (String)result.get(i+13);
					idrug_count = Integer.parseInt(drug_count);
					if(sIVPrepYN.equals("0") || sIVPrepYN.equals("2") || sIVPrepYN.equals("4") || sIVPrepYN.equals("6") || sIVPrepYN.equals("8"))
						admixYN = "Y";
					else{
						admixYN = "N";
						drug_count = "1";
					}

					if(sIVPrepYN!=null && admixYN.equals("Y")){
						if(!sPrevOrderID.equals((String)result.get(i))){
							sPrevOrderID = (String)result.get(i);
						}
						if(!((String)result.get(i+1)).equals("1")){
							sAdmixChk = "disabled";
						}
					}

//Added for SRR20056-SCF-7734 ICN 28022 - End
					if(record_status.size()>0){
						if(((String)record_status.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10))!=null) && ((String)record_status.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10))).equals("Y") )  {
							check_status	=	"checked";
							chk_value		=	"Y";
						}
						else{ 
							flag=false;
						}
					}
					if(rsn_cds.size()>0){
						sel_rsn_code	=	(String)rsn_cds.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10));
					}
					// Added for SRR20056-SCF-7734 ICN 28022 - Start
					if(sPrevAdmixOrderID!=null && sPrevAdmixOrderID.equals((String)result.get(i)) && sPrevAdmixWorkSheetId!=null && sPrevAdmixWorkSheetId.equals(sPrevAdmixWorkSheetId)){
						sel_rsn_code= sPrevAdmixReasonCode;
					}
					if (admixYN.equals("Y") && sPrevAdmixOrderID!=null && sPrevAdmixOrderID.equals((String)result.get(i))&& sPrevAdmixWorkSheetId!=null && sPrevAdmixWorkSheetId.equals((String)result.get(i+11))){
						check_status	=	"checked";
						chk_value		=	"Y";
					}
					/*else if ( sPrevAdmixWorkSheetId ==null  || sPrevAdmixWorkSheetId.equals("") ) {
						sel_rsn_code = "";
						check_status	=	"";
						chk_value		=	"N";
					}*/ //Commented for ML-BRU-SCF-0603 [IN:036245]
					if( chk_value ==null || !chk_value.equals("Y")) //if block added for ML-BRU-SCF-0603 [IN:036245]
						sel_rsn_code = "";

					// Added for SRR20056-SCF-7734 ICN 28022 - End
					if(sel_rsn_code==null || sel_rsn_code.equals("")){
						sel_rsn_code = "";
					}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)result.get(i+2)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)result.get(i+3)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);

						if(((String)result.get(i+15)).equals("") || ((String)result.get(i+15)).equals("0")){ //Added if block and else condition for ML-BRU-SCF-0674 [IN:037567]

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)result.get(i+4)));
            _bw.write(_wl_block1Bytes, _wl_block1);

						}
						else{

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+4)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)result.get(i+4)));
            _bw.write(_wl_block30Bytes, _wl_block30);

						}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)result.get(i+6)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)result.get(i+7)));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
						StringTokenizer st =new StringTokenizer(result.get(i+7).toString(), " ");
						while (st.hasMoreTokens()){
							 st1 = st.nextToken();
							 st2 = st.nextToken();
						}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(st1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,st2)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)result.get(i+9)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)result.get(i+8),"DMY","en",locale)));
            _bw.write(_wl_block16Bytes, _wl_block16);

						if(bl_installed_yn.equals("Y")){
							if(((String)result.get(i+14)).equals("N")){
								disabled="";

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);

							}
							else{
								disabled="disabled";

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
						}
//Added for SRR20056-SCF-7734 ICN 28022 - Start
						if(disabled.equals(""))
							disabled = sAdmixChk;
//Added for SRR20056-SCF-7734 ICN 28022 - End

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

							if(reason_codes !=null && reason_codes.size()>0){
								for(int rc=0; rc<reason_codes.size();rc=rc+3){
									if(sel_rsn_code.equals((String)reason_codes.get(rc)+(String)reason_codes.get(rc+1)))
										opt_sel = "selected";
									else
										opt_sel = "";

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)reason_codes.get(rc)+(String)reason_codes.get(rc+1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(opt_sel));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)reason_codes.get(rc+2)));
            _bw.write(_wl_block50Bytes, _wl_block50);
	 
								}
								if(flag==true){

            _bw.write(_wl_block51Bytes, _wl_block51);

								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);

								}
							}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(check_status));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sWorkSheetId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+10)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(sIVPrepYN));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(sWorkSheetId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)result.get(i+10)));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)result.get(i+15)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)result.get(i+16)));
            _bw.write(_wl_block72Bytes, _wl_block72);
	
					rec_count++;

					if(bl_installed_yn.equals("Y"))
						 i+=17; //changed for SRR20056-SCF-7734 ICN 28022 -- changed from 15->17 for ML-BRU-SCF-0674 [IN:037567]
					else
						i+=18; //changed for SRR20056-SCF-7734 ICN 28022 --Changed from 16-18 for ML-BRU-SCF-0674 [IN:037567]
				} 
				// Added for SRR20056-SCF-7734 ICN 28022 - Start
				rec_count--;
				if(admixYN.equals("Y") && (idrug_count+rec_count > 11))
					incompleteAdmixORdID = sPrevOrderID;
				// Added for SRR20056-SCF-7734 ICN 28022 - End

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean.getMode()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(from));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(to));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dt_from));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dt_to));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(disp_locn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(batches));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bl_installed_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(paid_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(incompleteAdmixFoundPrev));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(incompleteAdmixORdID));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(sPrevAdmixOrderID));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block93Bytes, _wl_block93);
 			putObjectInBean(bean_id,bean,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}

            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedDrug.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedBy.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Paid.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}

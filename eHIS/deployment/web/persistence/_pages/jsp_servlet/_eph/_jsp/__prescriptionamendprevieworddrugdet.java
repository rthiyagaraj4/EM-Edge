package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eOR.Common.*;
import eOR.*;
import java.text.DecimalFormat;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionamendprevieworddrugdet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionAmendPreviewOrdDrugDet.jsp", 1709121195162L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--saved on 27th Oct 2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../js/Prescription.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t\t\t<form name=\"prescription_form_preview_order\" id=\"prescription_form_preview_order\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"prescription_table\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<td class=\"data\" colspan=\"4\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\'Data\' nowrap width=\'16%\' align=\'right\' style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t\t<td colspan=\'3\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\'>&nbsp;</td> <!-- added for ML-MMOH-CRF-0343 -->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'5%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" WRAP colspan=\"2\"  width=\"50%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" &nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label></td>\n\t\t\t\t\t\t\t\t<td class=\"data\" wrap >&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<td class=\'Data\' align=\'right\' style=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\'Data\' align=\'right\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<td class=\"data\" wrap  width=\"15%\">&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" &nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" wrap  width=\"15%\">&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" align=\'center\' style=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =";\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" wrap colspan=\"2\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =";\'> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =";";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<tr>\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\"8\" class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\t\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\'20%\' class=\'label\' ><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =": </b></td>\n\t\t\t\t\t\t\t\t\t<td colspan=\"7\" class=\"label\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =": </b></td>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'prn_remarks";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar prn_rem = decodeURIComponent(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"prn_remarks\").innerText=document.getElementById(\"prn_remarks\").innerText+prn_rem;\n\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"prn_remarks\")\"+\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\').innerText= prn_rem ;\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t <td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t <td width=\'17%\' class=label ><b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =": </b></td>\n\t\t\t\t\t\t\t\t\t <td class=label colspan=\'7\'  id=\'drugindication_remarks";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\'><b>Drug Abuse Remarks:</b></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'abuse_remarks";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\'19%\' class=label valign=\'TOP\'><b>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =": </b></td>\n\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\' >&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\t\t\t\t\t\t<tr><TD colspan=\'9\' width=\'100%\'><table  width=\'100%\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<th > ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" </th>\n\t\t\t\t\t\t\t\t\t\t<th > ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="  </th>\n\t\t\t\t\t\t\t\t\t\t<th > ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </th>\n\t\t\t\t\t\t\t\t\t\t<td class=\"data\" align=\'center\' style=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"data\"   width=\"15%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td> \n\t\t\t\t\t\t\t\t\t\t\t<td class=\"data\"   width=\"15%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td> \n\t\t\t\t\t\t\t\t\t\t\t<td class=\"data\"   width=\"25%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td> \n\t\t\t\t\t\t\t\t\t\t\t<td class=\"data\" align=\'center\' style=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =";\'>&nbsp;</td> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\t\t\t\t\t\t\t</table></TD></tr>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' width=\"20%\"  ><b>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =": </b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'dsg_reason";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar dsg_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\');\n\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"dsg_reason\")\"+\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\').innerText= dsg_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"20%\" valign=\'TOP\'><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =":</b></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'dsg_reason";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\'><U><b>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</b></U></td>\n\n\t\t\t\t\t\t\t\t\t\t\t</tr><br><br>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' width=\"20%\" ><b>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =": </b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'dup_reason";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar dup_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\');\n\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"dup_reason\")\"+\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\').innerText= dup_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"20%\" valign=\'TOP\'><b>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =":</b></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'dup_reason";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td><!--label modified for  MMS-KH-CRF-0029-->\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =": </b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'con_reason";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar con_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\');\n\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"con_reason\")\"+\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\').innerText= con_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =": </b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'int_reason";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar int_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');\n\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"int_reason\")\"+\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\').innerText= int_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =": </b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'7\'  id=\'alg_reason";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar alg_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\n\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"alg_reason\")\"+\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\').innerText= alg_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\' nowrap><b>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;:</b></td> <!-- modified for MMS-KH-CRF-0029[IN070606]-->\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'interaction_remarks";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr> <!-- modified for MMS-KH-CRF-0029[IN070606]-->\n\t\t\t\t\t\t\t\t\t\t<!--\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tvar interaction_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"interaction_remarks\")\"+\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\').innerText= interaction_remarks ;\n\t\t\t\t\t\t\t\t\t\t\t</script> -->\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;:</b></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'interaction_remarks";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<!--\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tvar interaction_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr> <!-- added for MMS-KH-CRF-0029[IN070606] end-->\n\t\t\t\t\t\t\t\t\t\t<!--\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tvar interaction_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr> \n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t<tr><td class=\"data\" colspan=\"8\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=\"data\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" wrap  colspan=\"4\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =";\'> <!-- added for ML-MMOH-CRF-0349 -->\n\t\t\t\t\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t<tr><td class=\"data\" colspan=\"8\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t<tr><td class=\"data\" colspan=\"8\" >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td></tr>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=\"data\">";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" wrap   colspan=\"2\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =";\'> <!-- added for ML-MMOH-CRF-0349 -->\n\t\t\t\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=\"8\" class=\"label\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\'20%\' class=\'label\'  ><b>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar PRN_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\');\n\t\t\t\t\t\t\t\t\teval(\"document.getElementById(\"prn_remarks\")\"+\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'+\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\').innerText= PRN_remarks ;\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\').innerText= con_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =">\'></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar int_reason = decodeURIComponent(\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\').innerText= int_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\').innerText= alg_reason ;\n\t\t\t\t\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"5%\" colspan=\"2\" class=\"data\">";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =":&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td colspan=\"5\" class=\"label\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\t\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t<tr><td class=\"white\"></td></tr>\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'4\' class=\'data\' align=\'right\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td class=\'data\' align=\'right\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t</form>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	String patient_id		=request.getParameter("patient_id");
	String encounter_id	=request.getParameter("encounter_id");
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name	= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	ArrayList prescriptionDetails = bean.getpresDetails();
	String or_bean_name = "eOR.OrderEntryBean";
	String or_bean_id = "@orderentrybean" + patient_id + encounter_id;
	//Code Added For ICN 29927	RUT-CRF-0034 -Start
	String route_color = "";
	String addRouteDesc = "";
	String route_desc = "";
	String fntColor = "";
	String route_code = "";
	//Code Added For ICN 29927	RUT-CRF-0034 -End
String called_amend_from=bean.getCalledFromAmend();
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

	String drug_code = null;
	String srl_no = null;
	String taper_yn = null;
	String qty_value = null;
	String qty_desc = null;
	String qty_desc_code = null;
	String or_qty_desc = null;
	String freq_nature = null;
	String freq_desc = null;
	String durn_value = null;
	String durn_type = null;
	String or_durn_desc = null;
	String strength_uom = null;
	String dosage_type = null;
	String strength_value = null;
	String no_refill = null;
	HashMap RefillDetail = null;
	String end_date = null;
	String repeat_durn_type = null;
	String order_line_num = "";
	String order_qty = null;
	String order_uom = null;
	String uom_desc = "";
	HashMap PRN_remarks = new HashMap();
	String PRN_remarks_code = "";
	String PRN_remarks_dtl = "";
	String allergy_yn = "";
	String override_yn = "";
	String overdose_yn = "";
	String dsg_reason = "";
	String dup_reason = "";
	String con_reason = "";
	String int_reason = "";
	String alg_reason = "";
	String trade_name = "";
	String tot_payable = "";
	String pat_payable = "";
	double tot_payable_sum = 0.0;
	double pat_payable_sum = 0.0;
	String tot_payable_sum_str = "";
	String pat_payable_sum_str = "";
	String decimalFormatString = "";
	String charge_display = "display:none";
	String sliding_scale_remarks = "";
	String billable_item_yn = "";
	String facility_id = (String) session.getValue("facility_id");
	String drugindication_remarks = "";//added for MMS Adhoc Testing
	String display_auth_rule = "visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus = "-"; //added for ML-MMOH-CRF-0343
	String preview_auth_status_yn = bean.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
	String interaction_exists="";//MMS-KH-CRF-0029
	String interaction_remarks = "";//MMS-KH-CRF-0029
	String food_interaction_remarks = "";//MMS-KH-CRF-0029
	String lab_interaction_remarks = "";//MMS-KH-CRF-0029
	String abuse_exists="";//added  for AAKH-CRF-0140
	String abuse_action="";//added for aakh-crf-0140
	String abuse_remarks	=	"";//added  for AAKH-CRF-0140
	String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229
	
	//String order_ststus="";//added for ml-mmoh-crf-0863
	if ("Y".equals(preview_auth_status_yn)) { // if condition added for ML-MMOH-CRF-0343
		display_auth_rule = "visibility:visible";
	}
	//added for ml-mmoh-crf-0863 start
	String disp_locn_code = "";
	disp_locn_code = presBean.getDisp_locn_code();//added for ml-mmoh-crf-0863
	//	 order_ststus=presBean.getOrder_ststus();//added for ml-mmoh-crf-0863

	String auth_amend_pres_yn = "";
	auth_amend_pres_yn = presBean.getAuthAmendPres(disp_locn_code);

	//added for ml-mmoh-crf-0863 end

            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale = (String) session.getAttribute("LOCALE");
			bean.setLanguageId(locale);
			orbean.setLanguageId(locale);
			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
			String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if (prescriptionDetails.size() > 0) {

            _bw.write(_wl_block9Bytes, _wl_block9);

				ArrayList grp		=(ArrayList) bean.sortList();
				int k=0;
				HashMap drugDetails =	null;
				for(int i=0;i<grp.size();i++){
					ArrayList displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));

					for(int j=0;j<displayList.size();j++){	
						color_auth_rule ="BLACK"; // Added for  ML-MMOH-CRF-0343 [IN:057182]
						strAuthStatus="-"; // Added for  ML-MMOH-CRF-0343 [IN:057182]
						drugDetails=(HashMap) displayList.get(j);
						drug_code		= (String)drugDetails.get("DRUG_CODE");
						srl_no			= (String)drugDetails.get("SRL_NO");
						taper_yn		= (String)drugDetails.get("TAPERED_YN");
						billable_item_yn = (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y":(String)drugDetails.get("BILLABLE_ITEM_YN");
						qty_value		= (String)drugDetails.get("QTY_VALUE");
						qty_desc		= (String)drugDetails.get("QTY_DESC");
						or_qty_desc		= (String)drugDetails.get("OR_QTY_DESC")==null?(String)drugDetails.get("QTY_UNIT"):(String)drugDetails.get("OR_QTY_DESC");
						//added for ML-BRU-SCF-1785 start
						if((String) drugDetails.get("OR_QTY_DESC") == null){
							//(String)drugDetails.get("ORDERING_FACILITY_ID");
							or_qty_desc=bean.getUomDisplay((String)drugDetails.get("ORDERING_FACILITY_ID"),or_qty_desc);
						}
						//added for ML-BRU-SCF-1785 end
						freq_desc		= (String)drugDetails.get("FREQ_DESC");
						freq_desc		=  java.net.URLDecoder.decode(freq_desc,"UTF-8");
						freq_desc		=  freq_desc.replaceAll("%26","&");
						freq_desc		=  freq_desc.replaceAll("%40","@");

				durn_value = (String) drugDetails.get("DURN_VALUE");
				durn_type = (String) drugDetails.get("DURN_TYPE");
				or_durn_desc = (String) drugDetails.get("DURN_DESC");
				strength_uom = (String) drugDetails.get("STRENGTH_UOM");
				dosage_type = (String) drugDetails.get("DOSAGE_TYPE"); 
				interaction_exists =		  (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");//MMS-KH-CRF-0029
				interaction_remarks=	  (String)drugDetails.get("INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("INTERACTION_REMARKS"); //MMS-KH-CRF-0029
						strength_value	= (String)drugDetails.get("STRENGTH_VALUE");
						trade_name		= (String)drugDetails.get("TRADE_NAME")==null?"": (String)drugDetails.get("TRADE_NAME");
						
					//	order_ststus       =(String)drugDetails.get("ORDER_STATUS")==null?"N":(String)drugDetails.get("ORDER_STATUS");//added for ml-mmoh-crf-0863
						if(!trade_name.equals(""))
							trade_name	="("+trade_name+")";
						
						if(drugDetails.containsKey("SLIDING_SCALE_REMARKS")) {
							sliding_scale_remarks	=	(String)drugDetails.get("SLIDING_SCALE_REMARKS");
						}
						
						//route_desc=(String)drugDetails.get("ROUTE_DESC")==null?"":	(String)drugDetails.get("ROUTE_DESC");  //Code Added For ICN 29927	RUT-CRF-0034 Start
						route_code=(String)drugDetails.get("ROUTE_CODE")==null?"":	(String)drugDetails.get("ROUTE_CODE");  
						fntColor="000000";
						ArrayList routes				=	presBean.getRoutes((String)drugDetails.get("FORM_CODE")); 
						for(int l=0; l<routes.size(); l+=3) { 
							if(route_code.equals(routes.get(l))){
								route_desc = (String)routes.get(l+1);
								route_color = (String)routes.get(l+2);
								break;
							}
						}
						if(route_color!= null && !route_color.equals("") && route_color.length()==12){
							fntColor= route_color.substring(0, 6);
						}
						addRouteDesc="<font color='"+fntColor+"'>("+route_desc+")</font>"; 	//Code Added For ICN 29927	RUT-CRF-0034 End

						if( "Y".equals(preview_auth_status_yn)) {
							ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
							ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
							if(ord_auth_reqd_yn.equals("Y") && "Y".equals(preview_auth_status_yn)){
								display_auth_rule = "visibility:visible";
								color_auth_rule = "color:red";
								strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
								if(ord_authorized_yn.equals("Y")){
									color_auth_rule = "color:green";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
								}
								//added for ml-mmoh-crf-0863 start
							if(ord_authorized_yn.equals("N")){
								if("Y".equals(auth_amend_pres_yn) && called_amend_from.equals("PH") ){
									color_auth_rule = "color:green";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
								}
								
							}
								//added for ml-mmoh-crf-0863 end
							} 
						}//added for ML-MMOH-CRF-0343 -end

						String scheduled_yn	= (String)drugDetails.get("SCHEDULED_YN");
						no_refill			= (String)drugDetails.get("NO_REFILL");
						end_date			= (String)drugDetails.get("END_DATE");	
						repeat_durn_type	= (String)drugDetails.get("REPEAT_DURN_TYPE");	
						order_qty			= (String)drugDetails.get("ORDER_QTY");	

						if(order_qty != null && (!order_qty.equals(""))) 
							order_qty			=	new Float(Math.ceil(Float.parseFloat(order_qty))).intValue()+""; 

						order_uom			= (String)drugDetails.get("ORDER_UOM");	
						freq_nature			= (String)drugDetails.get("FREQ_NATURE")==null?"":(String)drugDetails.get("FREQ_NATURE");
						PRN_remarks			=  bean.getPRNRemarks(drug_code);

						if(PRN_remarks != null){
							PRN_remarks_code = PRN_remarks.get("prn_remarks_code")==null?"":(String)PRN_remarks.get("prn_remarks_code");
							PRN_remarks_dtl  = PRN_remarks.get("prn_remarks_dtl")==null?"":(String)PRN_remarks.get("prn_remarks_dtl");
						}
						String order_uom1	=	presBean.getOrderUnit(dosage_type,order_qty,drug_code);
						PRN_remarks_dtl		=	PRN_remarks_dtl.replaceAll(" ","%20");
						PRN_remarks_dtl		=	java.net.URLEncoder.encode(PRN_remarks_dtl,"UTF-8");
						PRN_remarks_dtl		=	PRN_remarks_dtl.replaceAll("%2520","%20");

						allergy_yn			=   (String)drugDetails.get("ALLERGY_OVERRIDE")==null?"":	(String)drugDetails.get("ALLERGY_OVERRIDE");  
						alg_reason			=   (String)drugDetails.get("ALLERGY_REMARKS")==null?"":	(String)drugDetails.get("ALLERGY_REMARKS");   
						alg_reason			=   alg_reason.replaceAll(" ","%20");
						alg_reason			=   java.net.URLEncoder.encode(alg_reason,"UTF-8");
						alg_reason			=   alg_reason.replaceAll("%2520","%20");

						override_yn			=  (String)drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
						dup_reason			=  (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":	(String)drugDetails.get("CURRENTRX_REMARKS");

						dup_reason			=	dup_reason.replaceAll(" ","%20");
						dup_reason			=	java.net.URLEncoder.encode(dup_reason,"UTF-8");
						dup_reason			=	dup_reason.replaceAll("%2520","%20");

						overdose_yn			=   (String)drugDetails.get("DOSE_OVERRIDE")==null?"":	 (String)drugDetails.get("DOSE_OVERRIDE");      
						dsg_reason			=   (String)drugDetails.get("DOSE_REMARKS")==null?"": (String)drugDetails.get("DOSE_REMARKS");  
						
						dsg_reason			=	dsg_reason.replaceAll(" ","%20");
						dsg_reason			=   java.net.URLEncoder.encode(dsg_reason,"UTF-8");
						dsg_reason			=	dsg_reason.replaceAll("%2520","%20");

						con_reason			=   (String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");      
						con_reason			=	con_reason.replaceAll(" ","%20");
						con_reason			=   java.net.URLEncoder.encode(con_reason,"UTF-8");
						con_reason			=   con_reason.replaceAll("%2520","%20");

						int_reason			=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
						int_reason			=	int_reason.replaceAll(" ","%20");
						int_reason			=	java.net.URLEncoder.encode(int_reason,"UTF-8");
						int_reason			=	int_reason.replaceAll("%2520","%20");
						drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");
				////MMS-KH-CRF-0029 [IN070606] - start
				food_interaction_remarks=	  (String)drugDetails.get("FOOD_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("FOOD_INTERACTION_REMARKS"); 
				lab_interaction_remarks=	  (String)drugDetails.get("LAB_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("LAB_INTERACTION_REMARKS");//MMS-KH-CRF-0029 [IN070606]
				disease_interaction_remarks=	  (String)drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
				interaction_remarks=interaction_remarks.replaceAll(" ","%20");
				interaction_remarks = java.net.URLEncoder.encode(interaction_remarks,"UTF-8");
				interaction_remarks = java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
				interaction_remarks=interaction_remarks.replaceAll("%2520"," ");
				interaction_remarks=interaction_remarks.replaceAll("%20"," ");
				abuse_exists= (String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");//added for aakh-crf-0140
				abuse_action= (String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");//added for aakh-crf-0140
				abuse_remarks= (String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");//added for aakh-crf-0140
				
				food_interaction_remarks=food_interaction_remarks.replaceAll(" ","%20");
				food_interaction_remarks = java.net.URLEncoder.encode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks = java.net.URLDecoder.decode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%2520"," ");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%20"," ");

				lab_interaction_remarks=lab_interaction_remarks.replaceAll(" ","%20");
				lab_interaction_remarks = java.net.URLEncoder.encode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks = java.net.URLDecoder.decode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%2520"," ");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%20"," ");
				//MMS-KH-CRF-0029 [IN070606] - end
				//Adding start for MMS-DM-CRF-0229
								disease_interaction_remarks=disease_interaction_remarks.replaceAll(" ","%20");
								disease_interaction_remarks = java.net.URLEncoder.encode(disease_interaction_remarks,"UTF-8");
								disease_interaction_remarks = java.net.URLDecoder.decode(disease_interaction_remarks,"UTF-8");
								disease_interaction_remarks=disease_interaction_remarks.replaceAll("%2520"," ");
								disease_interaction_remarks=disease_interaction_remarks.replaceAll("%20"," ");//Adding end MMS-DM-CRF-0229
						if(orbean.getCalledFromFunction()!=null && !(orbean.getCalledFromFunction()).equals("RENEW_ORDER")) {
							order_line_num	=	(String)drugDetails.get("ORDER_LINE_NUM");	
						}
						else {
							order_line_num	=	orbean.getOrderLineNo();	
						}
						RefillDetail= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);
						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
							strength_value = Float.parseFloat(strength_value) +"" ;

						if(strength_value!=null && strength_value.equals("0")) {
							strength_value		=	"";
					strength_uom = "";
				}

				String tooltip = "";
				String freq_str = "";
				String pres_remarks = "";
				boolean split_chk = false;
				boolean override_flag = false; //MMS-KH-CRF-0029

				ArrayList schedule = new ArrayList();

				if (scheduled_yn.equals("Y")) {
							 schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
						     split_chk	=	bean.checkSplit(schedule);
						     //freq_str    = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+or_qty_desc);
							 if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) 
							      freq_str = (String)bean.getTooltipStringFrFreq(schedule,"SSprvwString"+or_qty_desc);
						     else
							      freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+or_qty_desc);

					/*						for(int n=0; n<schedule.size(); n++) {
					 HashMap detail	=	(HashMap)schedule.get(n);
					 freq_str += detail.get("admin_time")+"-";
					 if(drugDetails.get("SLIDING_SCALE_YN") == null || ((String)drugDetails.get("SLIDING_SCALE_YN")).equals("N")) {
					 freq_str += detail.get("admin_qty")+" "+qty_desc;
					 }
					 if(n==(schedule.size()-1))
					 freq_str +=" ";
					 else
					 freq_str +=", ";
					 }		*/
				}

						if(drugDetails.get("SLIDING_SCALE_YN") != null && ((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) {
							qty_value = "";
							or_qty_desc = "";
						}
					/*	if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1.0)
							qty_value = Float.parseFloat(qty_value)+""; */ //commented for IN25920 --28/01/2011-- priya

						or_durn_desc = presBean.getDurationType(durn_type);
						if(dosage_type.equals("A"))
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						else if(schedule.size() > 0 && split_chk) {
							tooltip			= " "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+durn_value+" "+or_durn_desc;
						}
						else if(schedule.size() > 0) {
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+durn_value+" "+or_durn_desc;
						} 
						else {
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}

						Hashtable template	=	null;
						ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),(drug_code+srl_no)+"_0");

						if(seq_num==null)
							seq_num			=	new ArrayList();

						for(int p=0; p<seq_num.size(); p++) {
							template	=	(Hashtable)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),((drug_code+srl_no)+((Integer.parseInt((String)seq_num.get(p))) ) ));

							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
								pres_remarks += "<br>"+template.get("label_text")+": "+presBean.getPrescriptionRemarks((String) template.get("field_values"));
							}
							else {
								pres_remarks += "<br>"+template.get("label_text")+": "+(String) template.get("field_values") ;
							}
					
						}
						if(pres_remarks.equals("")) {
							ArrayList drug_remarks	=	bean.getPrescribedRemarks(orbean.getOrderId(),order_line_num);
							if(drug_remarks.size()!=0) { 
								for(int x=0; x<drug_remarks.size(); x++) {	
									if(x==(drug_remarks.size()-1)) {	
										pres_remarks	+=	(String)drug_remarks.get(x);
									}
									else {
										pres_remarks	+=	(String)drug_remarks.get(x)+",";
									}
								} 
							} 
							if(drug_remarks.size() == 0){
								String drug_remarks1						= bean.getDrugInstructions(orbean.getOrderId(),order_line_num);
								pres_remarks=drug_remarks1;
							}
						}
						if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
							tot_payable			= (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
							pat_payable			= (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
							decimalFormatString	= (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
							if(billable_item_yn.equals("Y"))
							{
								if(!(tot_payable.equals("")) && tot_payable != null)
									tot_payable_sum += Float.parseFloat(tot_payable);
								if(!(pat_payable.equals("")) && pat_payable != null)
									pat_payable_sum += Float.parseFloat(pat_payable);
							}
							else
							{
								tot_payable = "--";
								pat_payable = "--";
							}
							charge_display = "display:inline";
						}
						else{
							tot_payable = "&nbsp;";
							pat_payable = "&nbsp;";
						}
						if(j==0 || !taper_yn.equals("Y"))	{					


            _bw.write(_wl_block10Bytes, _wl_block10);

	//								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&(i==0)&&(j==0)){

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block15Bytes, _wl_block15);

	//							}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)drugDetails.get("DRUG_DESC")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,strength_uom)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)drugDetails.get("FORM_CODE")));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&(i==0)&&(j==0)){

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(addRouteDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_uom1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tot_payable));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_payable));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)drugDetails.get("START_DATE_TIME")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)drugDetails.get("END_DATE_TIME")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block36Bytes, _wl_block36);

	if (!freq_str.equals("")) {

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(freq_str));
            _bw.write(_wl_block38Bytes, _wl_block38);

	}
					if (!pres_remarks.equals("")) {

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);

							}		
							if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(PRN_remarks_dtl));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
							}
							if(!drugindication_remarks.equals("")) { //if condition is added for MMS Adhoc Testing-Start

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drugindication_remarks));
            _bw.write(_wl_block48Bytes, _wl_block48);

	}
							//if condition is added for MMS Adhoc Testing-End
							if(!abuse_remarks.equals("") ){//aaded for aakh-crf-0140
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(abuse_remarks));
            _bw.write(_wl_block50Bytes, _wl_block50);
		
																		}
					if (!sliding_scale_remarks.equals("")) {

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sliding_scale_remarks));
            _bw.write(_wl_block48Bytes, _wl_block48);
			
							}	
							if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")){
								ArrayList slidingScaleTmplDtl = (ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL");
								int noOfRangeForTmpl = slidingScaleTmplDtl.size();
								if(noOfRangeForTmpl > 0){

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
									for(int m=0; m<noOfRangeForTmpl; m=m+5){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slidingScaleTmplDtl.get(m+1)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(slidingScaleTmplDtl.get(m+2)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)drugDetails.get("RANGEUOM")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(slidingScaleTmplDtl.get(m+3)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)drugDetails.get("ADMINUOM")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(java.net.URLDecoder.decode((String) slidingScaleTmplDtl.get(m+4),"UTF-8")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block62Bytes, _wl_block62);

									} 

            _bw.write(_wl_block63Bytes, _wl_block63);
								}
							}
					//		if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
								if(!dsg_reason.equals("") && !((String)drugDetails.get("LIMIT_IND")).equals("N")){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);

								}else{
										if(((String)drugDetails.get("LIMIT_IND")).equals("N") && !dsg_reason.equals("")){

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLDecoder.decode(dsg_reason,"UTF-8")));
            _bw.write(_wl_block71Bytes, _wl_block71);
										}
								}
					//MMS-KH-CRF-0029 [IN070606] - start	
										if((override_yn.equals("Y") && !dup_reason.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")) || (allergy_yn.equals("Y") && !alg_reason.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")) || (overdose_yn.equals("Y") && !dsg_reason.equals("") && ((String)drugDetails.get("LIMIT_IND")).equals("N")) || ((interaction_exists.equals("Y") && !interaction_remarks.equals("")) || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals("")|| !disease_interaction_remarks.equals(""))) //modified for MMS-KH-CRF-0029
										{  
											override_flag = true; //MMS-KH-CRF-0029
											System.err.println("PrescriptionPreviewOrderDrugDetails.jsp===943====>");

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
										} //MMS-KH-CRF-0029 [IN070606] - end
								if(!dup_reason.equals("") && !((String)drugDetails.get("CURRENT_RX")).equals("Y")){

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);

								}
								else{
									if(((String)drugDetails.get("CURRENT_RX")).equals("Y") && !dup_reason.equals("")){

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLDecoder.decode(
											dup_reason, "UTF-8")));
            _bw.write(_wl_block81Bytes, _wl_block81);
									}
								}
								if(!con_reason.equals("")){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);

	}
					if (!int_reason.equals("")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(j));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block89Bytes, _wl_block89);

								}
								if(!alg_reason.equals("") && !((String)drugDetails.get("ALLERGY_YN")).equals("Y")){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            _bw.write(_wl_block93Bytes, _wl_block93);

								}
								else{
									if(((String)drugDetails.get("ALLERGY_YN")).equals("Y") && !alg_reason.equals("")){

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLDecoder.decode(alg_reason,"UTF-8")));
            _bw.write(_wl_block94Bytes, _wl_block94);
										}
								}
							//}
					ArrayList hmDrugIntList=(ArrayList) drugDetails.get("INTERACTION_DTL"); //MMS-KH-CRF-0029 - start
										String interaction_desc = "";
										String interaction_type = "";
										ArrayList intrType = new ArrayList();
										HashMap DrugInteractionDtl=  null;
										if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
											for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
												DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
											  interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
											  interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");
												intrType.add(interaction_type);
											}
										}
										String drug_drug_display = "none";
										String drug_food_display = "none";
										String drug_lab_display = "none";
										String drug_disease_display = "none";//MMS-DM-CRF-0229
										String drug_food_remarks ="";
										String drug_lab_remarks ="";
										String drug_disease_remarks ="";//MMS-DM-CRF-0229

										if(intrType!=null && intrType.size()>0){
										if(intrType.contains("D") || intrType.contains("G")){
											drug_drug_display = "inline";
										}
										if(intrType.contains("F")){
											drug_food_display = "inline";
										}
										if(intrType.contains("L")){
											drug_lab_display = "inline"; 
										}
										if(intrType.contains("I")){//MMS-DM-CRF-0229
											drug_disease_display = "inline"; 
										}
										drug_food_remarks = food_interaction_remarks;
										drug_lab_remarks = lab_interaction_remarks;
										drug_disease_remarks = disease_interaction_remarks;//MMS-DM-CRF-0229

										} //MMS-KH-CRF-0029 [IN070606] - end
										if(interaction_exists.equals("Y") && drug_drug_display.equals("inline") && !interaction_remarks.equals("")  ){//modified for MMS-KH-CRF-0029

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
		
										}
										if(drug_food_display.equals("inline") && override_flag ){//modified for MMS-KH-CRF-0029

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_food_remarks));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
		
										}
										if(drug_lab_display.equals("inline") && override_flag){ //modified for MMS-KH-CRF-0029

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_lab_remarks));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
		
										} //MMS-KH-CRF-0029 - end
                                   if(drug_disease_display.equals("inline") && override_flag){ //modified for MMS-DM-CRF-0229

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_disease_remarks));
            _bw.write(_wl_block103Bytes, _wl_block103);
		
										}

					if (no_refill != null && (!no_refill.equals(""))) {

            _bw.write(_wl_block104Bytes, _wl_block104);

								for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { 		

            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tot_payable));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_payable));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(((ArrayList)RefillDetail.get("refill_start_date")).get(p)));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(((ArrayList)RefillDetail.get("refill_end_date")).get(p)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block111Bytes, _wl_block111);

								} 
							}
						
						} 
						else	{	

            _bw.write(_wl_block112Bytes, _wl_block112);

	if (freq_nature.equals("O") || freq_nature.equals("P")) {

            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
		
							}
							else{ 

            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_uom1));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tot_payable));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(charge_display));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_payable));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)drugDetails.get("START_DATE_TIME")));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)drugDetails.get("END_DATE_TIME")));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block122Bytes, _wl_block122);

	}
					if (!freq_str.equals("")) {

            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(freq_str));
            _bw.write(_wl_block38Bytes, _wl_block38);

	}

					if (!pres_remarks.equals("")) {

            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);

							}		
							if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){ 

            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(PRN_remarks_dtl));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(k));
            _bw.write(_wl_block128Bytes, _wl_block128);
						}
						//	if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
								if(!dsg_reason.equals("")){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block68Bytes, _wl_block68);

	}
					if (!dup_reason.equals("")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block78Bytes, _wl_block78);

	}
					if (!con_reason.equals("")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block129Bytes, _wl_block129);

	}
					if (!int_reason.equals("")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block131Bytes, _wl_block131);

	}
					if (!alg_reason.equals("")) {

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block132Bytes, _wl_block132);

	}
					//	}
				}
				k++;
			}
			if ((i != (grp.size()) - 1))

            _bw.write(_wl_block133Bytes, _wl_block133);

		}
			String clinical_comments = bean.getPresRemarks();
			if (clinical_comments != null && !clinical_comments.equals("")) {
	
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(clinical_comments));
            _bw.write(_wl_block136Bytes, _wl_block136);

				}
				if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
					DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
					//charge_amt = Double.parseDouble(patient_payable_amt)+"";
					tot_payable_sum_str = dfTest.format(tot_payable_sum);
					pat_payable_sum_str = dfTest.format(pat_payable_sum);


            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tot_payable_sum_str));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(pat_payable_sum_str));
            _bw.write(_wl_block139Bytes, _wl_block139);

	}

            _bw.write(_wl_block140Bytes, _wl_block140);

	}

            _bw.write(_wl_block141Bytes, _wl_block141);

	putObjectInBean(bean_id, bean, request);
	putObjectInBean(or_bean_id, orbean, request);
	putObjectInBean(presBean_id, presBean, request);

            _bw.write(_wl_block142Bytes, _wl_block142);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SlidingScaleRemarks.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminUnits.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDosageOverrideReason.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverDoseRemarks.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateTheraphyOverrideReason.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateRemarks.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ContraIndicationOverrideReason.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyOverrideReason.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyRemarks.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_DrugInteractionRemarks.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_FoodInteractionRemarks.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_LabInteractionRemarks.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DiseaseInteractionRemarks.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Refill.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDosageOverrideReason.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateTheraphyOverrideReason.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ContraIndicationOverrideReason.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyOverrideReason.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescriptionRemarks.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}

package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eOR.*;
import eOR.Common.*;
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

public final class __oncologyregimenpreviewdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenPreviewDetails.jsp", 1709120990500L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/OncologyRegimen.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"javascript\" src=\"../js/OncologyRegimenMFR.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- ML-MMOH-CRF-1014-->\n\t</head>\n\n\t<!-- <body> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"OncologyPreviewDetails\" id=\"OncologyPreviewDetails\">\n\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<th colspan=\"4\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" :&nbsp;</td>\n\t\t\t\t\t<td class=\"data\" width=\"30%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =":&nbsp;</td>\n\t\t\t\t\t<td class=\"data\" width=\"30%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th  width=\"20%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t<th  width=\"10%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t<th  width=\"18%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t<th  width=\"16%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t\t<th  width=\"10%\" style=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th> <!-- Added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t   \n\t\t\t\t\t   <th  width=\"18%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t\t    <th width=\"18%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<tr><td colspan=\"6\">&nbsp;</tr>\n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<td width=\"30%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'><font size=\"1\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</font></td>\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"18%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"16%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n\t\t\t\t\t\t    \t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =";";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<!--added for ml-mmoh-crf-1224 start-->\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' ><font size=\"1\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"  style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</br>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t<!--added for ml-mmoh-crf-1224 end-->\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"30%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><font  size=\"1\">&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"18%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font></td>\n\t\t\t\t\t\t\t\t<!-- modified for  ml-mmoh-scf-1050 start -->\n\t\t\t\t\t\t\t\t<td width=\"16%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"16%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</font></td>\n\t\t\t\t\t\t\t    \t<!-- modified for  ml-mmoh-scf-1050 end -->\n\t\t\t\t\t\t\t    \t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</label>\n\t\t\t\t\t\t\t    \t</td>  \n\t\t\t\t\t\t\t    \t<!--added for ml-mmoh-crf-1224-->\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'><font size=\"1\">&nbsp;</font></td>\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\" style=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'><font size=\"1\">&nbsp;</font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t<!--added for ml-mmoh-crf-1224-->\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"30%\" class=\"label\"><font size=\"1\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</font></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;</font></td>\n\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"18%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</font></td>\n\t\t\t\t\t\t\t<td width=\"16%\" class=\"label\"><font size=\"1\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =";\'> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"30%\" class=\"label\"><font size=\"1\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" \n\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRateOnco(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');\" id=\'mfrLink\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</a>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="  </font></td>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"18%\" class=\"label\"><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</font></td>\n\t\t\t\t\t\t\t\t<td width=\"16%\" class=\"label\"><font size=\"1\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font></td>\n\t\t\t\t\t\t\t    \t<td class=\"label\" align=\'center\' style=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =";\'> <!-- added for ML-MMOH-CRF-0343 -->\n\t\t\t\t\t\t\t\t<label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</label>\n\t\t\t\t\t\t\t    \t</td>\n\t\t\t\t\t\t\t<!--\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t\t\t\t\t\t\t\t<td class=\"label\"  nowrap>\n\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRateOnco(\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</a></td>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="  -->\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t   <tr>\t\n\t\t\t\t\t\t\t\t<td width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =":&nbsp;&nbsp;</b>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\t\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td colspan=\"2\" class=\"label\"><b>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =":&nbsp;&nbsp;</b></td><td colspan=\"5\" class=\"label\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"10%\" colspan=\"2\" class=\"data\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =":&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td colspan=\"5\" class=\"label\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\t\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );
	
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

    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patient_id			= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String locn_code			= request.getParameter("locn_code");
	String pract_name			= request.getParameter("pract_name") ;	
	pract_name					= java.net.URLDecoder.decode(pract_name,"UTF-8");	
	String bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name			= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
	String or_bean_name			="eOR.OrderEntryBean";
	String or_bean_id			="@orderentrybean"+patient_id+encounter_id;
	String display_auth_rule ="visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus="-" ;  //added for ML-MMOH-CRF-0343
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

	String pres_bean_id_1			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String pres_bean_name_1		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 pres_bean_1 = (PrescriptionBean_1)getBeanObject( pres_bean_id_1, pres_bean_name_1, request ) ;	

	String pres_bean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String pres_bean_name		= "ePH.PrescriptionBean";
	PrescriptionBean pres_bean = (PrescriptionBean)getBeanObject( pres_bean_id, pres_bean_name, request ) ;	

	String patient_name					= "";
	String patient_class                = "";
	String sex							= "";
	String age							= "";
	String strength_per_value_pres_uom	= "";
	String strength_per_pres_uom		= "";
	String ing_order_qty				= "";
	String drugindication_remarks		= "";//added for MMS Adhoc Testing
	//String dosage_type                  = "";
	String pres_remarks					= "";
	String existing_order_id            = "";
	int    size                         = 0;
	int    count                        = 0;
	//int    count1                       = 0;
	 //ML-MMOH-CRF-0345 - start
	String cycle_freq_yn				= "";
	String cycle_checked_yn			= "";//ML-MMOH-CRF-1004
	String no_of_cycle				= "";
	String srl_no					= "";
	String cycle_start_date			= "";
	String cycle_end_date			= "";
	String mfr_yn					= "N";//ML-MMOH-CRF-1014
	HashMap hm = bean.getCycleDetails();
	HashMap hm_details = null;
	ArrayList time_list = new ArrayList();
	ArrayList time = new ArrayList();//added for ML-MMOH-CRF-1224
	 //ML-MMOH-CRF-0345 - end
	ArrayList pat_details				= bean.getPatientDetails(patient_id);
	String ord_date						=bean.getOrderDate();
	String Display="";//added for ml-mmoh-crf-1224
	String Display1="";//added for ml-mmoh-crf-1224
	String sch_start_date  = "";//added for ml-mmoh-crf-1224
	String sch_end_date	= "";//added for ml-mmoh-crf-1224
	String disp_route_shadule=request.getParameter("site_spec_YN");//ADDED FOR ML-MMOH-CRF-1224
    	String preview_auth_status_yn = pres_bean_1.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
	if( "Y".equals(preview_auth_status_yn)) {   // if condition added for ML-MMOH-CRF-0343
		display_auth_rule = "visibility:visible";   
	}
	if (pat_details.size() != 0) {
		patient_name			= (String)pat_details.get(0);
		sex						= (String)pat_details.get(1);
		age						= (String)pat_details.get(2);
	}
    ArrayList drugList1 = bean.getDrugDetails(); 
	if (drugList1!=null && drugList1.size() != 0) {
		 for(int i=0;i<drugList1.size();i++) {
			HashMap drugDetails1 = (HashMap)drugList1.get(i);
			patient_class=(String)drugDetails1.get("PATIENT_CLASS");
			if(patient_class!=null && !patient_class.equals(""))
				break;
		 }
	}

	String locn_desc			=   bean.getLocationDesc(patient_class, locn_code);
	String called_from			=	orbean.getCalledFromFunction();
	String uom="";
	
	if(sex.equalsIgnoreCase("female"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(sex.equalsIgnoreCase("male"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(sex.equalsIgnoreCase("unknown"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( patient_name ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( age ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( sex ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( ord_date ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( locn_desc ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( pract_name ));
            _bw.write(_wl_block12Bytes, _wl_block12);

			ArrayList drugList = bean.getDrugDetails(); 
			if (drugList!=null && drugList.size() != 0) {

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(disp_route_shadule.equals("Y")){//added for ml-mmoh-crf-1224
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

					//HashMap doseUOM=bean.getDosageUOMS();
					 for(int i=0;i<drugList.size();i++) {
						HashMap drugDetails = (HashMap)drugList.get(i);
						/*if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE"))){
							uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
						}	*/

						if(drugDetails!=null && drugDetails.size() > 0){
							
							String order_qty		="";
							String freq_nature=(String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");
							String durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
							String amend_stock_value=(String)drugDetails.get("amend_stock_value");
							String repeat_durn_type=(String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE");
							String amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");
							String infusion_over      =(String)drugDetails.get("amend_infusion_period_value")==null?"1":(String)drugDetails.get("amend_infusion_period_value");
							String amend_durn_unit     =(String)drugDetails.get("amend_durn_unit")==null?"":(String)drugDetails.get("amend_durn_unit");
							String fract_dose_round_up_yn     =(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							String interval_value     =(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
							String freq_chng_durn_desc = (String)drugDetails.get("freq_chng_durn_desc");
							drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//added for MMS Adhoc Testing
							mfr_yn = (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014 - start
							if(mfr_yn.equals("Y")){
								freq_chng_durn_desc = "H";
								amend_durn_unit = "H";
								amend_durn_value = "1";
							}//ML-MMOH-CRF-1014 - end
							if(!freq_chng_durn_desc.equals(amend_durn_unit)){
								amend_durn_value = (String)bean.getFreqDurnConvValue(freq_chng_durn_desc,amend_durn_value,amend_durn_unit);
							}
							strength_per_pres_uom=(String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom	=(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							String amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");

							if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")){
								uom = (String)drugDetails.get("STRENGTH_UOM_DESC")==null?"":(String)drugDetails.get("STRENGTH_UOM_DESC");
							}
							else{
								uom = (String)drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC");
							}

							String drug_code		= (String)drugDetails.get("DRUG_CODE");
							String ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
							if((called_from!=null && called_from.equals("AMEND_ORDER")) )
								ocurrance_num = (i+1)+"";
							// ML-MMOH-CRF-0345- start
							srl_no = (String)drugDetails.get("SRL_NO");
							if(hm!=null && hm.size()>0){
							  hm_details = (HashMap)hm.get(drug_code+srl_no);//
							}// ML-MMOH-CRF-0345- end

						//	dosage_type				= (String)drugDetails.get("DOSAGE_TYPE");
							cycle_freq_yn          = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");// ML-MMOH-CRF-0345
							no_of_cycle     = (String)drugDetails.get("NO_OF_CYCLE")==null?"0":(String)drugDetails.get("NO_OF_CYCLE");// ML-MMOH-CRF-0345
						//Drug Remarks	
							Hashtable template		=	null;
							pres_remarks			= "";
							String	catalog_code	= drug_code+ocurrance_num; //added +ocurrance_num for SRR20056-SCF-7085 IN26862 "Drug"+
							String	row_value		= (catalog_code+"_"+"0");
							int seq_num1            =0;
							ArrayList seq_num		=	(ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code,row_value); //added removed +ocurrance_num for SRR20056-SCF-7085 IN26862
							//ArrayList seq_num		=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+ocurrance_num),(drug_code+ocurrance_num)+"_0");

							if(seq_num==null){
								seq_num			=	new ArrayList();
							}				
							for(int p=0; p<seq_num.size(); p++) {
								seq_num1		= ((Integer.parseInt((String)seq_num.get(p))) );
								template	    = (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num1)); //removed +ocurrance_num for SRR20056-SCF-7085 IN26862
								if(template.get("field_values")!=null && !(((String)template.get("field_values")).trim()).equals("")){
									if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
										pres_remarks = pres_remarks +"<br>"+template.get("label_text")+": "+pres_bean.getPrescriptionRemarks((String) template.get("field_values"));
									} 
									else {
										pres_remarks = pres_remarks +"<br>"+template.get("label_text")+": "+(String) template.get("field_values");
									}	
								}
							}
						  /*--------------------------------------------*/
							HashMap record_flag				=null;
						//	HashMap fluids					=null;
							HashMap Existingrecord			=null;			
							existing_order_id				= ""; 
							if(called_from!=null && called_from.equals("AMEND_ORDER")){   				 
							 
								ArrayList ExistingCYTORecords = bean.getExistingCYTORecords();							
								size                       = ExistingCYTORecords.size();
								record_flag                = (HashMap) ExistingCYTORecords.get(size-2);
								Existingrecord				= (HashMap) ExistingCYTORecords.get(count);					
								existing_order_id          = (String)Existingrecord.get("ORDER_ID");		
								if(record_flag.containsKey(existing_order_id)) {                    
									count=count+1;										
								}
								else{
								// count1=count;					 
								} 				 
								count=count+1;
							}

							if(pres_remarks.equals("")) {
								ArrayList drug_remarks	=	bean.getPrescribedRemarks(existing_order_id,"1");
					
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
							}

							String order_uom	= bean.getStockUOM(drug_code);			
							String pack_size	= bean.getPackSize(drug_code);	
							float ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));
							if(drugDetails.get("DOSAGE_TYPE") !=null){
							   if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {				
									strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
									strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
									float in_tot_qty	= 0.0f;	

									if(fract_dose_round_up_yn.equals("Y")){
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
									}
									else{
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();
									}
									if (freq_nature.equals("I")) {
										in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
									}
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
									}
									else if (freq_nature.equals("O")) {
										in_tot_qty = in_tot_qty;
									}

									ing_order_qty=in_tot_qty+"";
									ing_order_qty=(Math.ceil(Float.parseFloat(ing_order_qty)/Float.parseFloat(pack_size)))+"";
								}
								else{
									String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
									String ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
									String eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
									if(eqvl_value.equals(""))	eqvl_value	=	"1";
									
									float in_tot_qty	= 0.0f;
									if(fract_dose_round_up_yn.equals("Y")){
										in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);	
									}
									else{
										in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
									}

									if (freq_nature.equals("I")) {
										in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
									}
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
									}
									else if (freq_nature.equals("O")) {
										in_tot_qty = in_tot_qty;
								   }

								   if(!fract_dose_round_up_yn.equals("Y")){
									in_tot_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(pack_size))).floatValue();
								}	
								ing_order_qty=in_tot_qty+"";
							}
							ing_order_qty=new Float(ing_order_qty).intValue()+"";
						}	
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343
							if( "Y".equals(preview_auth_status_yn)) {
								ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
								ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
								if(ord_auth_reqd_yn.equals("Y")){
									color_auth_rule = "color:red";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
									if(ord_authorized_yn.equals("Y")){
										color_auth_rule = "color:green";
										strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
									}
								} 
							}//added for ML-MMOH-CRF-0343 -end

            _bw.write(_wl_block24Bytes, _wl_block24);


					if(cycle_freq_yn.equals("Y")){// ML-MMOH-CRF-0345 - start
					for(int j=0;j<Integer.parseInt(no_of_cycle);j++){
						cycle_checked_yn = "";//ML-MMOH-CRF-1004
						 Display="";//added for ml-mmoh-crf-1224
						 Display1="";//added for ml-mmoh-crf-1224
						if(hm_details!=null){
							time_list	= (ArrayList)hm_details.get("cycle_"+j);
							time		= (ArrayList)time_list.get(0);//added for ml-mmoh-crf-1224
							//day_list	= (String)time_list.get(1);
							cycle_start_date  = (String)time_list.get(3);
							cycle_end_date	= (String)time_list.get(4);
							cycle_checked_yn = (String)time_list.get(5);//ML-MMOH-CRF-1004
							String[] arrOfStr = cycle_start_date.split(" ");//added for ml-mmoh-crf-1224
							String[] arrOfStr1 = cycle_end_date.split(" ");//added for ml-mmoh-crf-1224
							sch_start_date  = arrOfStr[0];//added for ml-mmoh-crf-1224
							sch_end_date	= arrOfStr1[0];//added for ml-mmoh-crf-1224
							//added for ml-mmoh-crf-1224 start
							for(int chk=0;chk<time.size();chk++){
								String value=(String)time.get(chk);
								
								int valueInt=Integer.parseInt(value.replaceAll(":",""));
								if(valueInt>Integer.parseInt(arrOfStr[1].replaceAll(":",""))){
								
									if(chk!=0  && Display!=""){
										Display=Display+",";
							}
									Display=Display+value;
							}
								
						}
							for(int chk=0;chk<time.size();chk++){
								String value=(String)time.get(chk);
								
								int valueInt=Integer.parseInt(value.replaceAll(":",""));
								if(valueInt<Integer.parseInt(arrOfStr[1].replaceAll(":",""))){
									
									if(  chk!=0  && Display1!=""){
									
										Display1=Display1+",";
							}
									Display1=Display1+value;
							}
								
						}
						}
						//added for ml-mmoh-crf-1224 end
						
						
						if(cycle_checked_yn==null)//ML-MMOH-CRF-1004
							cycle_checked_yn = "";
						String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name");
						//added for ML-MMOH-CRF-1224 START
						String style="";
						if(amend_fluid_name!=null && !amend_fluid_name.equals("") && disp_route_shadule.equals("Y")) {
							style="";
						}
						else{
							if(disp_route_shadule.equals("Y")){
							style="border-bottom: 1px solid black;border-collapse: collapse;";
							}
						}
						//ADDED FOR ML-MMOH-CRF-1224 END
						if(cycle_checked_yn.equals("Y")){
						// ML-MMOH-CRF-0345 - end
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((drugDetails.get("DRUG_DESC")==null ? "":drugDetails.get("DRUG_DESC"))));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(style));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((drugDetails.get("dose")==null ? "":drugDetails.get("dose")+"&nbsp;"+uom)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(style));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(style));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ing_order_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((cycle_start_date==null ? "":DateUtils.convertDate(cycle_start_date, "DMYHM","en",locale)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((cycle_end_date==null ? "":DateUtils.convertDate(cycle_end_date, "DMYHM","en",locale))));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(style));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(disp_route_shadule.equals("Y")){//added for ml-mmoh-crf-1224
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(style));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((drugDetails.get("ROUTE_DESC")==null ? "":drugDetails.get("ROUTE_DESC"))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(Display!=""){
            out.print( String.valueOf(sch_start_date ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Display));
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
if(Display1!=""){
            out.print( String.valueOf(sch_end_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Display1));
} 
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
System.err.println("no_of_cycle==========334===>");
				//	}

            _bw.write(_wl_block45Bytes, _wl_block45);
			
						
						if(amend_fluid_name!=null && !amend_fluid_name.equals("")) {
							String fluid_code=(String)drugDetails.get("amend_fluid_code");
							String fluid_dosage_uom=(String)drugDetails.get("amend_stock_uom_val");
							pack_size	= bean.getPackSize(fluid_code);			
							order_uom	= bean.getStockUOM(fluid_code);	
							order_qty		= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+""; 
							mfr_yn = (String)(drugDetails.get("mfr_yn"))==null?"N":(String)(drugDetails.get("mfr_yn")); //added for CRF-1014


							order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
							// order_qty		= (Math.ceil((Float.parseFloat(order_qty)) / Float.parseFloat(pack_size)))+"";
							order_qty=new Float(order_qty).intValue()+"";
							
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343
								//if condtion ADDED FOR ML-MMOH-CRF-1224
									if(disp_route_shadule.equals("Y")){
										style="border-bottom: 1px solid black;border-collapse: collapse;";
									}

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((drugDetails.get("amend_fluid_name")==null ? "":drugDetails.get("amend_fluid_name"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(style));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((drugDetails.get("dose")==null ? "":drugDetails.get("amend_stock_value")+"&nbsp;"+ bean.getUomDisplay((String)session.getValue("facility_id"),fluid_dosage_uom) )));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(style));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(style));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((cycle_start_date==null ? "":DateUtils.convertDate(cycle_start_date, "DMYHM","en",locale)) ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(style));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((cycle_end_date==null ? "":DateUtils.convertDate(cycle_end_date, "DMYHM","en",locale)) ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(style));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(disp_route_shadule.equals("Y")){
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(style));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(style));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

						}
						}	
					}
					}else{
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((drugDetails.get("DRUG_DESC")==null ? "":drugDetails.get("DRUG_DESC"))));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((drugDetails.get("dose")==null ? "":drugDetails.get("dose")+"&nbsp;"+uom)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ing_order_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((drugDetails.get("amend_start_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_start_date").toString(), "DMYHM","en",locale)) ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((drugDetails.get("amend_end_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_end_date").toString(), "DMYHM","en",locale))));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block65Bytes, _wl_block65);
			
						String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name");
						if(amend_fluid_name!=null && !amend_fluid_name.equals("")) {
							String fluid_code=(String)drugDetails.get("amend_fluid_code");
							String fluid_dosage_uom=(String)drugDetails.get("amend_stock_uom_val");
							pack_size	= bean.getPackSize(fluid_code);			
							order_uom	= bean.getStockUOM(fluid_code);	
							order_qty		= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+""; 
						
							order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
							// order_qty		= (Math.ceil((Float.parseFloat(order_qty)) / Float.parseFloat(pack_size)))+"";
							order_qty=new Float(order_qty).intValue()+"";
							
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((drugDetails.get("amend_fluid_name")==null ? "":drugDetails.get("amend_fluid_name"))));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(mfr_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean_id ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean_name ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(fluid_dosage_uom));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(existing_order_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)drugDetails.get("OCURRANCE_NUM")));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((drugDetails.get("dose")==null ? "":drugDetails.get("amend_stock_value")+"&nbsp;"+fluid_dosage_uom)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf((drugDetails.get("amend_start_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_start_date").toString(), "DMYHM","en",locale))));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf((drugDetails.get("amend_end_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_end_date").toString(), "DMYHM","en",locale))));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strAuthStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(mfr_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean_id ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean_name ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(fluid_dosage_uom));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(existing_order_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)drugDetails.get("OCURRANCE_NUM")));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block80Bytes, _wl_block80);

							}
						}
						if(!pres_remarks.equals("")){

            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block83Bytes, _wl_block83);

						}

            _bw.write(_wl_block84Bytes, _wl_block84);

				//added for MMS Adhoc Testing-Start
				if(!drugindication_remarks.equals("")) {

            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drugindication_remarks));
            _bw.write(_wl_block87Bytes, _wl_block87);

						}//added for MMS Adhoc Testing-End
					}
				}  
				String clinical_comments	=	pres_bean_1.getPresRemarks();
				if(clinical_comments!=null && !clinical_comments.equals("")) {

            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(clinical_comments));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}

            _bw.write(_wl_block91Bytes, _wl_block91);

			} 

            _bw.write(_wl_block92Bytes, _wl_block92);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(pres_bean_id,pres_bean,request);
	putObjectInBean(pres_bean_id_1,pres_bean_1,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrescribedBy.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/FluidDetails.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Route.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduleDateTime.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescriptionRemarks.label", java.lang.String .class,"key"));
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
}

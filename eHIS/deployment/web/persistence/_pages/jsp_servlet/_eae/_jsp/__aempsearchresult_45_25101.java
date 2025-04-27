package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.Common.*;
import eAE.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aempsearchresult_45_25101 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPSearchResult-25101.jsp", 1737911843122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEPatientByCriteria.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n        var refreshparam;\n        var checkout_yn;\n\t\trefreshparam=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'*60*1000;\n\t\tself.setInterval(\'window.location.href = window.location.href;\',refreshparam);\n\t\t//self.setInterval(\'parent.AEMPSearchResultFrame.location.reload();\',refreshparam);//modified By munisekhar for IN43904\n\t\t\n       </script>  \t\t\t\n</head>\n\t\t\n<input type=\'hidden\' name=\'CAInstalled\' id=\'CAInstalled\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >   \n\n\t<body onMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\' class=\'CONTENT\' onscroll=\'scrollTitle();\'>\n<center>\n<form name=\'AEMPSearchResultForm\' id=\'AEMPSearchResultForm\'>\n<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n</div>\n\n<div  id=\'divTitleTable\' >\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'TitleTab\'>\n<tr>\n        <td align=left width=\'10%\'>\n            <table align=left >\n                <tr>\n                    <td class=label nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" <b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n                </tr>\n            </table>\n        </td>\n\t\t \n\t\t <td  width=\'37%\' align=\'right\'>&nbsp;</td>\n    </tr>\n<!--</td>\n                </tr>\n            </table>\n        </td>\n    </tr>-->\n</table>\n<!--<table  id=\'th_table\' cellspacing=0 cellpadding=0 align=\'center\' width=\'160%\' border=\'20\'>-->\n<table  id=\'th_table\'  cellpadding=\'0\' cellspacing=\'0\' border=1 >\n\t\t<tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<th width=\'5%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'reattendanceGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<th  onclick =\"sort(\'practitioner\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\" style=\'cursor:pointer\' nowrap  width=\'4%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'practitionerGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<th onclick =\"sort(\'zone\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\" nowrap  width=\'2%\' style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'zoneGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<th  nowrap  width=\'1%\'  >&nbsp;&nbsp;&nbsp;</th>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n <th onclick =\"sort(\'priorityZone\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\"  style=\'cursor:pointer\' nowrap width=\'4%\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'prior\' style=\'visibility:hidden\'></th>\n ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<th onclick =\"sort(\'queueDate\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\"  style=\'cursor:pointer\'  nowrap width=\'4%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'dateGif\' style=\'visibility:hidden\'></th>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\"  style=\'cursor:pointer\'  nowrap width=\'6%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n<th  onclick =\"sort(\'bed_no\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\');\"  style=\'cursor:pointer\'  nowrap ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="width=\'3%\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" width=\'3%\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'bedNoGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n<th onclick =\"sort(\'patientName\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\"  style=\'cursor:pointer\' nowrap width=\'9%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patNameGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<th onclick =\"sort(\'patientId\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\" style=\'cursor:pointer\'  nowrap  width=\'4%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patIdGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<th onclick =\"sort(\'age\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\" style=\'cursor:pointer\'   nowrap width=\'3%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'ageGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<th onclick =\"sort(\'waitingTime\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\"  style=\'cursor:pointer\'   nowrap width=\'3%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none align=right name=\'waitTimeGif\' style=\'visibility:hidden\'>&nbsp;&nbsp;</th>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<th onclick =\"sort(\'status\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"  style=\'cursor:pointer\' nowrap width=\'15%\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'statusGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n<th onclick =\"sort(\'for_admission\',\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\" style=\'cursor:pointer\' nowrap width=\'4%\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'forAdmGif\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<th style=\'cursor:pointer\' nowrap width=\'6%\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right  style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<th style=\'cursor:pointer\' nowrap  width=\'6%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<th onclick =\"sort(\'locType\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\"  style=\'cursor:pointer\' nowrap width=\'7%\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'locTypeGif\' style=\'visibility:hidden\'></th>\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n<th nowrap width=\'5%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'loc\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\n<th nowrap width=\'8%\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<th nowrap width=\'8%\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'loc\' style=\'visibility:hidden\'></th>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n<th nowrap  width=\'5%\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'locc\' style=\'visibility:hidden\'></th>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</tr>\n\n\t\t  </table>\n\t</div>\n<table border=\'10\'  style=\'border-bottom:#ffffff\'  cellspacing=\'0\' width=\'200%\' id=\'tb1\'>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t<tr   ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" > <!-- modified by mujafar for ML-MMOH-CRF-1194 -->\n\t\t<th colspan=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" align=\'left\'><font size=1>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&nbsp;&nbsp;&nbsp;\n\t ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t</th>\n\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<tr ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" >\n\t\t<th colspan=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</th>\n\t</tr>\n\t ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<tr ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;&nbsp;&nbsp; \n\t </th>\n\t</tr>\n\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' onMouseOver=\'hideToolTip()\'>\t\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'  width=\'5%\'><font size=1>&nbsp;";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'  width=\'4%\'><font size=1>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" style=\"background-color:";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" width=\'2%\' ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" width=\'1%\'> ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" &nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' width=\'4%\' ><font size=1>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td> \n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'  width=\'6%\'><font size=1>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="<br>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&nbsp;:&nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" </td> <!--added by mujafar for ML-MMOH-CRF-1194-->\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' align=\'center\'  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="><font size=1>\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" </td>\n      ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t<script>\n\t\t\t\tvar clinic_desc =\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"; \n\t\t\t\t</script>\n\t\t\t\t<!-- Below TD modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] -->\n\t\t\t\t<!--reg_new_born_yn,inv_reg_new_born_yn  Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] -->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' width=\'9%\'  id=\'desc";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'onMouseover=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\');hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');\" onMouseout=\"onMOut(msg,\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\');\" onClick=\"showAllowedOperations(\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\', \'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\',\'link";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\');onMOut(msg,\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\');\"><a href=\'javascript:DummyRef()\' name=\'link";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' ><font size=\'1\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</a><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'></td><!--Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658-->\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' width=\'9%\'><a name=\'desc";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');\"   href=\'javascript:DummyRef()\' \n\t\t\tonClick=\" CallViewPatDetails1(\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\');\" ><font size=1>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</a></td>\n\n\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\');\" href=\'javascript:LoadChkOut( \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\",\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\")\' ><font size=1>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</a></td>\n\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\');\" href=\'javascript:DummyRef()\' \n\t\t\t\t\tonClick=\" CallViewPatDetails1(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\');\"><font size=1>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t<td class=\'AEDECEASED\' width=\'4%\'><font size=1>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' width=\'4%\'><font size=1>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' width=\'3%\'><font size=1>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="Y";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="M";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="D</td>\n\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' width=\'3%\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="><font size=1>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t<td nowrap width=\'15%\' class=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' ><font size=1>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t\t\t<!-- Friday, March 19, 2010 20119 -->\n\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' width=\'4%\' nowrap><font size=1>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'2\'><font size=1>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td nowrap><font size=1>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="&nbsp; -</font></td>\n\t\t\t\t\t\t\t\t\t<td nowrap><font size=1>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t      <td nowrap class=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\t\t  ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n         ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t       <td nowrap class=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'  width=\'6%\'><font size=1><a href=\'javascript:GetChiefComplaint(\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\")\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t  <td nowrap class=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'   width=\'6%\'><font size=1>&nbsp;</td>\n\t\t\t \t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t    <td nowrap class=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'  width=\'6%\'><font size=1>&nbsp;</td>\n\t\t\t  \t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t<td  class=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' width=\'7%\'><font size=1>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\n\t\t ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n        ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" \n\t\t<td class=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' width=\'5%\'><font size=1>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' width=\'5%\'><font size=1>&nbsp</td>\n\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n        ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t        ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' width=\'8%\'><font size=1>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' width=\'8%\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\t        \n\t\t ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t <!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->\n\t\t   ";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' width=\'5%\'><font size=1>\n\t\t <a href=\"javascript:ShowRemarks(\'txtComm";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\',\'I\',";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =")\">";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t <INPUT TYPE=\"hidden\" name=\"txtComm";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" id=\"txtComm";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t </a>\n\t\t\t   </font>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\t  \n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t </a>\n\t\t\t   </font>\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' width=\'5%\'>&nbsp;</td>  \n\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' width=\'5%\'><font size=1>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' width=\'5%\'><font size=1>&nbsp;</td>\n        ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' width=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'><font size=1>";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\t\n\t\t</tr>\n\t    ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n</table>\n<input type=\'hidden\' name=\'queue_date\' id=\'queue_date\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n<input type=\'hidden\' name=\'CAInstalled\' id=\'CAInstalled\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" >  \n<input type=\'hidden\' name=\'priority_zone\' id=\'priority_zone\'  value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" > \n<input type=\'hidden\' name=\'queue_refresh_interval\' id=\'queue_refresh_interval\'  value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" >\n<input type=\'hidden\' name=\'checkout_yn\' id=\'checkout_yn\'  value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" >\n<input type=\'hidden\' name=\'include_checkedout\' id=\'include_checkedout\'  value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" >\n<input type=\'hidden\' name=\'enable_rights_yn\' id=\'enable_rights_yn\'  value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" >\n<input type=\'hidden\' name=\'pract_type1\' id=\'pract_type1\'  value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" >\n<input type=\'hidden\' name=\'sel_triage_yn\' id=\'sel_triage_yn\'  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" >\n<input type=\'hidden\' name=\'sel_cons_yn\' id=\'sel_cons_yn\'  value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" >\n<input type=\'hidden\' name=\'orderCriteria\' id=\'orderCriteria\'  value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" >\n<input type=\"hidden\" name=\"finalString\" id=\"finalString\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n<input type=\'hidden\' name=\'from\' id=\'from\' value=";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =" >\n <input type=\'hidden\' name=\'to\' id=\'to\' value=";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" >\n <input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\'  value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" >\n <input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\'  value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" >\n<input type=\'hidden\' name= \'observe_id\' value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n<input type=\'hidden\' name= \'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n <!-- Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start -->\n<input type=\'hidden\' name= \'reg_new_born_yn\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n<input type=\'hidden\' name= \'inv_reg_new_born_yn\'  value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"> \n <!-- Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] End -->\n\n<input type=\'hidden\' name= \'function_id\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n<!-- crf-362 bed_no taken hidden variable-->\n<input type=\'hidden\' name= \'bed_no\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\n<!-- action_on_pending_bill added for MMS-QH-CRF-0126.2 -->\n<input type=\'hidden\' name= \'action_on_pending_bill\'  value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"> \n<input type=\'hidden\' name= \'facility_id\'  value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"> \n\t<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\n<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n<input type=\"hidden\" name=\'isPracApplicable\' id=\'isPracApplicable\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\t\n<!--Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636-->\n<input type=\"hidden\" name=\'sortByPriorityZone\' id=\'sortByPriorityZone\' value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\t\n\n<!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->\n<input type=\"hidden\" name=\'isDisplayAllRemarks\' id=\'isDisplayAllRemarks\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\t\n\n<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" >\n\n<input type=\"hidden\" name=\'isStartConsultationAppl\' id=\'isStartConsultationAppl\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"><!--Added by Thamizh selvi on 3rd Oct 2017 against ML-MMOH-CRF-0623-->\t\n\n<input type=\"hidden\" name=\'isPendingForAdmissionAppl\' id=\'isPendingForAdmissionAppl\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\"><!--Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658-->\t\n<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->\n<input type=\"hidden\" name=\'chk_for_pen_orders_bfr_chkout\' id=\'chk_for_pen_orders_bfr_chkout\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\t\n<input type=\"hidden\" name=\'checkout_allow_yn\' id=\'checkout_allow_yn\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->\n\n\n<script>\nhideAllGifs(\'pseudo\');\ntoggleGifs(\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\')\n</script>\n\t\t  ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:10%; visibility:hidden;\' bgcolor=\'blue\'>\n<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n<tr><td width=\'100%\' id=\'t\'></td></tr>\n</table>\n</div>\t \n</form>\n</center>\n<script>\nalignHeading1();\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n <script>\n //Following line of code commented by Kamakshi.N on 05/01/12 for IN-29357\n\t\t//parent.parent.frames[0].document.forms[0].reset.disabled=true;\n </script>\n\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );
 public StringBuffer getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code, String include_checkedout) throws java.sql.SQLException    
	{  
		StringBuffer tmt_area_statistics= null;
		StringBuffer queryStat = new StringBuffer();

        queryStat.append("SELECT SUM(DECODE(queue_status,'01',1,0)) Checked_In, SUM(CASE WHEN QUEUE_STATUS='02' AND CONS_SRVC_START_DATE_TIME IS NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) Assigned_to_Treat_Area, SUM(CASE WHEN (CONS_SRVC_START_DATE_TIME IS NOT NULL AND CONS_SRVC_END_DATE_TIME IS NULL) or queue_status = '03' THEN 1 ELSE 0 END) Undergoing_Treat, SUM(DECODE(CONS_SRVC_END_DATE_TIME,NULL,0,1)) Consulted, SUM(1) Total_Patients,SUM(DECODE(queue_status,'07',1,0)) tot_checked_out FROM op_patient_queue ");
		queryStat.append(" where facility_id = ? and patient_class = 'EM' and queue_status != '99' ");
		queryStat.append(" and trunc(queue_date) = trunc(sysdate) and  ");
		queryStat.append(" locn_type = ? and locn_code = ?  ");
		if (treatment_area_code!="")
		queryStat.append(" and treatment_area_code = ?  ");
		else
		queryStat.append(" and treatment_area_code is null ");


      	int tot_Checked_In			=	0;
		int tot_Assig_to_Treat_Area	=	0; 
		int tot_Undergoing_Treat	=	0;
		int tot_Consulted	=	0;
		int tot_checked_out	=	0;
		int total_patients = 0; 

		PreparedStatement pstmt	=	con.prepareStatement(queryStat.toString());

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		if (treatment_area_code!="")
		pstmt.setString	(	4,	treatment_area_code);
		ResultSet rs =	pstmt.executeQuery();
		if(rs.next())
		{
			tot_Checked_In			=	rs.getInt("Checked_In");
			tot_Assig_to_Treat_Area	=	rs.getInt("Assigned_to_Treat_Area"); 
			tot_Undergoing_Treat	=	rs.getInt("Undergoing_Treat");
			tot_Consulted			=	rs.getInt("Consulted");
			total_patients			=   rs.getInt("Total_Patients");
			tot_checked_out         =   rs.getInt("tot_checked_out");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)			pstmt.close();
		if((queryStat != null) && (queryStat.length() > 0))
		{
			queryStat.delete(0,queryStat.length());
		}

		tmt_area_statistics=  new StringBuffer();
		tmt_area_statistics.append(" ( "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels")+" : "+tot_Checked_In+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels")+" : "+tot_Assig_to_Treat_Area+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : "+tot_Undergoing_Treat+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : "+tot_Consulted+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.NoofPatients.label","ae_labels")+" : " +total_patients+" )");
		return tmt_area_statistics;

	}
	/*Commented below method and added it in AECommonBean.java --against ML-MMOH-CRF-0658 on 10th May 2018*/
	//Maheshwaran K added for the HSA-CRF-318
	//Start
	/*	public ArrayList getFieldOrder(Connection con,String facility_id,String user_id ) throws java.sql.SQLException 
	{  
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList fields = new ArrayList();
		int recCnt = 0 ;
		
		String fid="";
		String uid="";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='"+facility_id+"' and User_id='"+user_id+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
			
			
			if (recCnt == 0) 
			{
				uid="*ALL";
				fid="DF";
			}
			else
			{
				uid=user_id;
				fid=facility_id;
			}

			pstmt1	=	con.prepareStatement("select field_name from AE_CURR_EMERG_PAT_RESULT where facility_id = ? and user_id = ? order by field_order asc");

			pstmt1.setString(1,fid);
			pstmt1.setString(2,uid);
	
			rs1 =	pstmt1.executeQuery();

			while (rs1.next())
			{
				fields.add(rs1.getString("field_name"));
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs1!=null) rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(stmt!=null)	stmt.close();
		
			if(rs!=null) rs.close();
		}
		//The fields are added to the list in the order of their display
		return fields;
		}*/
		//End


public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		} 
	

		return single ;
			
			}	



	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String queue_refresh_interval = "";
/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
String pend_ord_stats	= "N";
String chk_for_pen_orders_bfr_chkout	= "N";
String checkout_allow_yn	= "N";
/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	ResultSet rs1			    =   null;
	int maxDispRecords			=	6;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String loginUser			= checkForNull((String)session.getValue("login_user"));
	
	Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF ML-MMOH-CRF-0637

	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String	facility_id				=	"";
	String	clinic_code				=	"";
	String	practitioner_id			=	"",		practitioner_name		=	"" ; 
    String	practitioner_full_name	=	"";
	String	patient_id				=	"",		patient_name			=	"";
	String	waiting_time			=	"",		queue_status			=	"";
	String	queue_status_desc		=	"",		classValue				=	"";
	StringBuffer queue_status_desc1 = new StringBuffer();
	String	treatment_area_code		=	"";
	String	treatment_area_desc		=	"",		triage_area				=	"";
	String	classValuePI			=	"";
	String	oper_stn_id				=	"",		queue_date				=	"";
	String	encounter_id			=	"",		clinic_type				=	"";
	String	patient_gender			=	"",		include_checkedout		=	"";
	String	order_by_priority		=	"";
	String	priority				=	"";
	String	trauma_yn				=	"";
	String	tblrow_id				=	"",		queue_date_time			=	"";
	String	sys_date_time			=	"",		checkout_yn				=	"";
	String	sys_date				=	"",		brought_dead_yn			=	"";
	String  curr_location="";
	String	from 					=	"",		to 						=	"";
	String	assign_tmt_area_time	=	"";
	String	p_clinic_desc	= "";
	String	open_to_all_pract_yn	=	"";
	String  priority_status			=	"",		priority_zone			=	"";
	String	bed_no					=	""; 
	String CAInstalled              =   "";
	String disaster_yn = "";
	String CaseofTrauma_val = "";
	String sys_date_time_1="";
	String sys_date2="";
	String bed_bay_type="";
	String PAT_PRIORITY_DESC="";
	String min_age_for_lmp="";
	String end_date = "";
	String start_date="";
	String dis_regn_reference="";
	String  dis_regn_remarks="";
	//StringBuffer sqlPatQ        = new StringBuffer();
	StringBuffer whereClause    = new StringBuffer();
	StringBuffer orderByClause  = new StringBuffer();
	StringBuffer byObserveId_criteria  = new StringBuffer();
	StringBuffer byObserveId_criteria1  = new StringBuffer();

	StringBuffer sqlPatQ1        = new StringBuffer();
	StringBuffer whereClause1   = new StringBuffer();
	StringBuffer orderByClause1  = new StringBuffer();

	String observe_id="";
	String oberv_clinc_code="";
	String oberv_TMT_code="";

	String check_in_date_time = "";
	String assign_tmt_area_time1 = "";
	String treatment_start_time = "";
	String cons_srvc_start_date_time = "";
	String cons_srvc_end_date_time = "";
	String TRIAGE_DATE_TIME="";
	String p_cutoff_hours_prv_day_visit = "";
	String visit_type_code = "";
	String pract_type      = "";
	String firststring     = "";
    String secondstring   = "";
	String record_vital_signs_yn = "";
	String enable_rights_yn="";
	String pract_type1="";
	String sel_triage_yn="";
	String sel_cons_yn="";
	String rowid="";
	String nursing_unit_code="";
	String allow_chkout_with_bill_stmt_yn ="N";
	String visit_num = "";
	String priority_zone1="";
    ArrayList temp=new ArrayList();
	String action_on_pending_bill	= "N";
	String reg_new_born_yn	= "N"; //Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
	String inv_reg_new_born_yn	= "N"; //Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
	
	String register_reattance_hours="";// Added for this CRF ML-MMOH-CRF-0639
	int reattance_hours=0;

	Boolean isStartConsultationAppl = false;//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623
	
	Boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070
	
	
	
	
	Boolean isLengthOfStayAppl = false; // added by mujafar for ML-MMOH-CRF-1194  
	String stay_time=""; // added by mujafar for ML-MMOH-CRF-1194

	/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	Boolean isPendingForAdmissionAppl	= false;
	String pendngAdmDateTime			= "";
	String forAdmWaitngTime				= "";
	String forAdmWaitString1			= "";
	String forAdmWaitString2			= "";
	JSONObject fieldOrderJSON			= new JSONObject();
	/*End*/
	
	String stay_time_1 = ""; // added by mujafar for ML-MMOH-CRF-1194
	String stay_time_2 = ""; // added by mujafar for ML-MMOH-CRF-1194

	String	open_to_all_prac_for_clinic_yn	=	"";
	String patient_class = "";
	String prev_visit = "";
	int		rowIndex				=	1,		columnIndex				=	1;
	int		maxRecord				=	0,		i						=	1;
	int		start					=	0,		end						=	0;
	int max = 0;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String priority_zone_bgcolor		= "";
	String priority_zone_all_codes		= (request.getParameter("priority_zone_all_codes")==null || request.getParameter("priority_zone_all_codes")=="")?"":request.getParameter("priority_zone_all_codes");

	StringBuilder priority_zone_order	 = new StringBuilder();
	if(!priority_zone_all_codes.equals("")){
		if (priority_zone_all_codes.length() > 0 && priority_zone_all_codes.charAt(priority_zone_all_codes.length()-1)==',') {
			priority_zone_all_codes = priority_zone_all_codes.substring(0, priority_zone_all_codes.length()-1);
		}
		
		String[] priority_zone_split = priority_zone_all_codes.split(",");
		for (int  x= 0; x < priority_zone_split.length; x++) {
			priority_zone_order.append("'"+priority_zone_split[x]+"',"+(x+1));
			if (x!= priority_zone_split.length - 1) {
		    	priority_zone_order.append(",");
		    }
		}
		
	}

	
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
	
	from							=	request.getParameter("from") ;
	to								=	request.getParameter("to") ;
	
//for age
	String year_value				=	"";
	String month_value				=	"";
	String day_value				=	"";
	String complaint_code			=	"";
	String COMPLAINT_DESC			=	"";
	String ret_str					=	"";
	String episode_id               =	"";

	if ( from == null ||from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null ||to.equals("") )
	  	end = maxDispRecords ;
	else
		end = Integer.parseInt( to ) ;  


/************************/
String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "queueDate" : request.getParameter("orderCriteria");
String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

priority_zone	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone"); 
priority_zone1	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone");
String maxRcd = request.getParameter("maxRcd")==null?"":request.getParameter("maxRcd");
if(!maxRcd.equals(""))
 max = Integer.parseInt(maxRcd);

String ch_id	=	(request.getParameter("ch_id")==null)	? "" : request.getParameter("ch_id");  
 if(ch_id.equals("Y")) {
	 ret_str		=	(request.getParameter("ch_x")==null)?"":request.getParameter("ch_x");
	 
	 if(ret_str.length()>0) {
		ret_str=ret_str.substring(0,ret_str.length()-3).trim() ;
		 if(ret_str.indexOf("[")!=-1) {
			ret_str=ret_str.substring(1,ret_str.length()).trim() ;
		}
		 if(ret_str.indexOf("]")!=-1) {
				ret_str=ret_str.substring(0,ret_str.length()-1).trim() ;
		}
     }
}
	try
	{ 
		con				=	(Connection)	ConnectionManager.getConnection(request);
		
		//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
		Boolean sortPriorityZoneTab = CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		//Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641
		Boolean isDisplayAllRemarks = CommonBean.isSiteSpecific(con, "AE", "SEC_TRG_AND_DIS_REG_REMARKS");

		//Added by Mano on 24-Apr-2017 for ML-MMOH-CRF-0644
		boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");
		//Added by Sangeetha for ML-MMOH-CRF-0636 on 26/apr/2017
		Boolean sortByPriorityZone = CommonBean.isSiteSpecific(con, "AE", "SORT_BY_PRIORITY_ZONE");

		isStartConsultationAppl = CommonBean.isSiteSpecific(con, "AE", "AE_START_CONSULTATION");//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623
		isLengthOfStayAppl      = CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL"); // added by mujafar for ML-MMOH-CRF-1194
		
		isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
		
		String disp="";
		String disp_val=""; // added by mujafar for ML-MMOH-CRF-1194
		
		if(isLengthOfStayAppl)
			disp="style=\'display:none'";
		isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_PENDING_FOR_ADMISSION_TAB");//Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658

		facility_id		=	(String)		session.getValue("facility_id");
		//ArrayList fieldOrder = getFieldOrder(con, facility_id, loginUser ) ;//Maheshwaran K added for the HSA-CRF-318
		/*Commented above line and added below lines by Thamizh selvi on 10th May 2018 against ML-MMOH-CRF-0658 Start*/
		fieldOrderJSON = eAE.AECommonBean.getFieldOrder(con, facility_id, loginUser);
		ArrayList fieldOrder = (ArrayList) fieldOrderJSON.get("fieldNames");
		/*End*/

		//Below line added for this CRF ML-MMOH-CRF-0637
		Boolean registerattendance = CommonBean.isSiteSpecific(con, "AE", "RE_ATTENDANCE");		
		int clspanval=fieldOrder.size();//Modified by Thamizh selvi on 9th May 2018 against ML-MMOH-CRF-0658
		String tdwidth="6%";
		if(registerattendance){
		//clspanval="18";
		tdwidth="4%";
		}
		/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 Start*/
		 Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		 int p_waiting_time					= 0;
		 String p_waiting_time_color		= "";
		 int p_waiting_time_hours			= 0;
		 int p_waiting_time_mins			= 0;
		  
		 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 End*/
		long diff=0;
		//End this CRF ML-MMOH-CRF-0637		

		
		//Added for this CRF ML-MMOH-CRF-0639
		
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals(""))reattance_hours=Integer.parseInt(register_reattance_hours);
		//End ML-MMOH-CRF-0639
		
		p_cutoff_hours_prv_day_visit = checkForNull(request.getParameter("p_cutoff_hours_prv_day_visit"));
		prev_visit          =	checkForNull(request.getParameter("prev_visit"));
		oper_stn_id			=	checkForNull(request.getParameter("oper_stn_id"));
		clinic_code			=	checkForNull(request.getParameter("clinic_code"));
		clinic_type			=	checkForNull(request.getParameter("clinic_type"));
		nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit_code"));
		treatment_area_code	=	checkForNull(request.getParameter("treatment_area_code"));
		practitioner_id		=	checkForNull(request.getParameter("practitioner_id"));
		patient_id			=	checkForNull(request.getParameter("patient_id"));
		priority			=	checkForNull(request.getParameter("priority"));
		patient_gender		=	checkForNull(request.getParameter("gender"));
		include_checkedout	=	checkForNull(request.getParameter("include_checkedout"));
		if(include_checkedout.equals("")) include_checkedout="N";
		order_by_priority	=	checkForNull(request.getParameter("order_by_priority"));
		checkout_yn			=	checkForNull(request.getParameter("checkout_yn"));
		if(checkout_yn.equals("")) checkout_yn="N";
    	priority_status		=	checkForNull(request.getParameter("priority_zone"));	bed_bay_type        =	checkForNull(request.getParameter("bed_bay_type"));
		observe_id				=	checkForNull(request.getParameter("observ_id"));
	    oberv_clinc_code		=	checkForNull(request.getParameter("oberv_clinc_code"));
	    oberv_TMT_code	=	checkForNull(request.getParameter("oberv_TMT_code"));

		
		if(isLengthOfStayAppl && priority_status.equals("")) // added by mujafar for ML-MMOH-CRF-1194
		{
			disp_val="style=\'display:none' ";
			
		}

		PreparedStatement  aepstmt			=	con.prepareStatement("select TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') end_date,       TO_CHAR (SYSDATE - (DECODE (visit_backdating_allowed_yn, 'Y', max_hours_allow_insert, 0) * 60) / 1440,'dd/mm/yyyy hh24:mi'          ) start_date, min_age_for_lmp,queue_refresh_interval,to_char(sysdate ,'hh24:mi') hmin,record_vital_signs_yn,		CUTOFF_HOURS_PRV_DAY_VISIT,ENABLE_ACCS_RIGHTS_IN_QUEUE,allow_chkout_with_bill_stmt_yn,(select install_yn from sm_module where module_id='CA') CAInstalled,action_on_pending_bill,inv_reg_new_born_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn  from ae_param where operating_facility_id = ? ");
		aepstmt.setString	(	1,	facility_id		);
		rs1 = aepstmt.executeQuery();

		if(rs1!= null &&  rs1.next() )
		{
			queue_refresh_interval = rs1.getString("queue_refresh_interval")==null?"0":rs1.getString("queue_refresh_interval");
			min_age_for_lmp=rs1.getString("min_age_for_lmp")==null?"":rs1.getString("min_age_for_lmp");
			sys_date	=	rs1.getString("hmin");
			record_vital_signs_yn =	rs1.getString("record_vital_signs_yn");
			p_cutoff_hours_prv_day_visit = rs1.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
			enable_rights_yn=checkForNull(rs1.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE"));
			allow_chkout_with_bill_stmt_yn =checkForNull(rs1.getString("allow_chkout_with_bill_stmt_yn"));
			end_date =checkForNull(rs1.getString("end_date"));
			start_date =checkForNull(rs1.getString("start_date"));
			CAInstalled = checkForNull(rs1.getString("CAInstalled")); 
			action_on_pending_bill	= rs1.getString("action_on_pending_bill");
			inv_reg_new_born_yn	= rs1.getString("inv_reg_new_born_yn");
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			chk_for_pen_orders_bfr_chkout =checkForNull(rs1.getString("chk_for_pen_orders_bfr_chkout"),"N");
			checkout_allow_yn =checkForNull(rs1.getString("checkout_allow_yn"),"N");
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
		} 
		
       if(rs1!=null) rs1.close();
	   if(aepstmt!=null)			aepstmt.close();

	    if(enable_rights_yn.equals("Y")){
		String pract_sql="select  b.pract_type pract_type from sm_appl_user a,am_practitioner b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id";
		PreparedStatement  prpstmt=con.prepareStatement(pract_sql);
		prpstmt.setString	(1,loginUser);
		rs1 = prpstmt.executeQuery();
		if(rs1!= null &&  rs1.next() ){
			pract_type1=checkForNull(rs1.getString("pract_type"));
		}
		if(rs1!=null) rs1.close();
		if(prpstmt!=null)			prpstmt.close();
		if(!(pract_type1.equals(""))){
		String access_rights_sql="select SEC_TRIAG_YN,CONS_YN,REG_NEW_BORN_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE where pract_type =?";//REG_NEW_BORN_YN Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
		PreparedStatement  acc_pstmt=con.prepareStatement(access_rights_sql);
		acc_pstmt.setString	(1,pract_type1);
		rs1 = acc_pstmt.executeQuery();
		if(rs1!= null &&  rs1.next() ){
			sel_triage_yn=rs1.getString("SEC_TRIAG_YN");
			sel_cons_yn=rs1.getString("CONS_YN");
			reg_new_born_yn=rs1.getString("REG_NEW_BORN_YN");//Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
		}
		if(rs1!=null) rs1.close();
		if(acc_pstmt!=null)			acc_pstmt.close();
		}
	  }	

		if(!(clinic_code.equals("")))			whereClause1.append(" and a.locn_code = ? and a.locn_type = ? ");
		if(!(treatment_area_code.equals(""))){
			whereClause1.append(" and a.treatment_area_code = ? ");
			}
        if(!(bed_bay_type.equals(""))){
			whereClause1	.append(" and d.bay_type_code = ? ");
			}
		if(!(practitioner_id.equals("")))		whereClause1.append(" and a.practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause1.append(" and a.patient_id = ? ");
		if(!(priority.equals("")))				whereClause1.append(" and a.priority_indicator = ? ");
		if(!(patient_gender.equals("")))		whereClause1.append(" and b.sex = ? ");
		if(include_checkedout.equals("Y"))		whereClause1.append(" and a.queue_status <= '07' ");
		if(include_checkedout.equals("N"))		whereClause1.append(" and a.queue_status < '07' ");
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
		/*if(priority_status.equals("R"))		whereClause1.append(" and a.priority_zone = 'R' ");
		if(priority_status.equals("Y"))		whereClause1.append(" and a.priority_zone = 'Y' ");
		if(priority_status.equals("G"))		whereClause1.append(" and a.priority_zone = 'G' ");
		if(priority_status.equals("U"))		whereClause1.append(" and a.priority_zone = 'U' ");*/
		if(!priority_status.equals("")){
			/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
			if(priority_status.equals("for_admission"))
				whereClause1.append(" and a.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");
			else if(priority_status.equals("observe") && isLengthOfStayAppl )
			{
			whereClause1.append("");
			
			}
			
			else/*End*/
				whereClause1.append(" and a.priority_zone = '"+priority_status+"' ");
		}
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
		
		
/*******order by creation logic**********************/
if(!priority_zone_order.toString().equals("") && five_level_triage_appl_yn.equals("Y")){
	orderByClause1.append(" DECODE(priority_zone,"+priority_zone_order.toString()+")asc,queue_date_time desc ");
}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
if(orderByClause1.length() > 0){
	orderByClause1.append(" , ");
}
if(priority_status.equals("for_admission") && orderCriteria.equals("")){
	orderCriteria="zone" ;
}else{
	if(orderCriteria.equals("")) orderCriteria="queueDate" ;
}/*End*/

if(!priority_status.equals("for_admission")){//Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029
		//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
		if(sortPriorityZoneTab)
		{
		//	if(priority_zone.equals("R") || priority_zone.equals("Y") || (!observe_id.equals("")) )
			//{
		//	orderByClause1.append("a.AE_BED_NO");
			//}else
			//{ commented by mujafar for ML-MMOH-CRF-1194
			orderByClause1.append(" locn_desc,treatment_area_code,practitioner_name ");
			//}
		}else
		{
		orderByClause1.append(" locn_desc,treatment_area_code ");
		}
}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/	
if(orderCriteria.matches("practitioner||queueDate||bed_no||patientName||patientId||age||status||priorityZone||waitingTime||zone||for_admission")){
	if(orderByClause1.length() > 0) orderByClause1.append(" , ");
	/*End*/
	if(orderCriteria.equals("practitioner"))
			{
				orderByClause1.append("practitioner_name"+asc_desc+" ");
			}
	else if(orderCriteria.equals("queueDate"))
			{
				orderByClause1.append("queue_date_time ");
				orderByClause1.append(""+asc_desc+" ");
			}
			else if(orderCriteria.equals("bed_no"))
			{
				//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
				if(sortPriorityZoneTab)
				{
					if(priority_zone.equals("Y") || priority_zone.equals("R") || (!observe_id.equals("")) )
					{
					orderByClause1.append(""+asc_desc+" ");
					}else
					{
					orderByClause1.append("a.AE_BED_NO ");
					orderByClause1.append(""+asc_desc+" ");
					}
				}else
				{
				orderByClause1.append("a.AE_BED_NO ");
				orderByClause1.append(""+asc_desc+" ");
				}
			}
	else if(orderCriteria.equals("patientName"))
			{
				orderByClause1.append("b.patient_name"+asc_desc+" ");
			}
	else if(orderCriteria.equals("patientId"))
			{
				orderByClause1.append("a.patient_id"+asc_desc+" ");
			}

	else if(orderCriteria.equals("age"))
			{
				orderByClause1.append("year "+asc_desc+" ");
			}

	else if(orderCriteria.equals("status"))
			{
				orderByClause1.append("a.QUEUE_STATUS"+asc_desc+" ");
			}

	else if(orderCriteria.equals("priorityZone"))
			{
				orderByClause1.append(" PAT_PRIORITY_DESC"+asc_desc+" ");
			}
	else if(orderCriteria.equals("waitingTime"))
			{
				orderByClause1.append("a.QUEUE_DATE ");
				orderByClause1.append(""+asc_desc+" ");
			}
	//Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636
	else if(orderCriteria.equals("zone"))
			{
				if(asc_desc.equals(" asc")){
					orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'G', 1, 'Y', 2, 'R', 3, 'U', 4) ASC");
				} else if(asc_desc.equals(" desc")){
					orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'R', 1, 'Y', 2, 'G', 3, 'U', 4) ASC");
				}
				
				/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
				if(priority_status.equals("for_admission"))
					orderByClause1.append(",queue_date_time DESC");
				/*End*/
				
			}
	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	else if(orderCriteria.equals("for_admission")){
		orderByClause1.append(" PENDNG_ADMISSION_DATE_TIME ");
		orderByClause1.append(""+asc_desc+" ");
	}/*End*/	

}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
if(priority_status.equals("for_admission") && orderCriteria.equals("locType")){
	orderByClause1.append(" locn_desc ");
	orderByClause1.append(""+asc_desc+" ");
}/*End*/			
  
/**********orderby logic ends**************/		
			if(!prev_visit.equals("") )	
			{
				whereClause1.append(" and (a.check_in_date_time between trunc(SYSDATE) -((1/(24*60*60))*3600*'"+p_cutoff_hours_prv_day_visit+"') and trunc(sysdate)) ");
			}
			else
			{
				//whereClause1.append(" and (a.check_in_date_time between SYSDATE-1  and sysdate)");
				/*Above line commented and below line added for this ML-MMOH-CRF-0639*/
				whereClause1.append(" AND SYSDATE BETWEEN a.check_in_date_time AND (("+reattance_hours+"/24)+(a.check_in_date_time))");
				//End this CRF ML-MMOH-CRF-0639
				
				
			}

			whereClause1.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
		whereClause1.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");

		whereClause1.append(" )");    


	      sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'dd/mm/yyyy hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'dd/mm/yyyy hh24:mi') ASSIGN_TMT_AREA_TIME, to_char(a.TREATMENT_START_TIME,'dd/mm/yyyy hh24:mi') TREATMENT_START_TIME,				TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth,	CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),2) months,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),3) days,		to_char(a.CONS_SRVC_START_DATE_TIME,'dd/mm/yyyy hh24:mi') CONS_SRVC_START_DATE_TIME,to_char(a.TRIAGE_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_DATE_TIME, to_char(a.CONS_SRVC_END_DATE_TIME,'dd/mm/yyyy hh24:mi') CONS_SRVC_END_DATE_TIME, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate-1,'dd/mm/yyyy') sys_date_time_1, to_char(sysdate,'dd/mm/yyyy') sys_date, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, AM_GET_DESC.AM_COMPLAINT(a.COMPLAINT_CODE,'"+locale+"' ,'1') COMPLAINT_DESC, a.encounter_id,get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.queue_status queue_status_desc, a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.dis_regn_reference,a.dis_regn_remarks,a.disaster_yn, a.TRAUMA_YN, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"' ,'1')) pat_curr_locn_desc, AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,(SELECT max(complaint_id) FROM ca_encntr_chief_complaint x WHERE encounter_id = a.encounter_id and facility_id=a.facility_id)complaint_code ,a.episode_id, a.OP_EPISODE_VISIT_NUM, ");  // added by mujafar for HSA-CRF-0240 on 2/4/2015
	      // modified by mujafar for ML-MMOH-CRF-1194
		  
		   if(include_checkedout.equals("Y"))  // modified by mujafar for ML-MMOH-CRF-1194
				sqlPatQ1.append("  get_waiting_time ( NVL (a.DISCHARGE_DATE_TIME,SYSDATE),queue_date) stay_time ");
		  else
				sqlPatQ1.append("  get_waiting_time ( SYSDATE,queue_date) stay_time ");
		  
		  
		
		  /*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
		  if(include_checkedout.equals("Y"))
				sqlPatQ1.append(", to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(NVL (a.DISCHARGE_DATE_TIME, SYSDATE), a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		  else
				sqlPatQ1.append(", to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(SYSDATE, a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		  /*End*/

		//sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time,            to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,            to_char(a.TREATMENT_START_TIME,'hh24:mi') TREATMENT_START_TIME,				TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth,	CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),2) months,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),3) days,		to_char(a.CONS_SRVC_START_DATE_TIME,'hh24:mi') CONS_SRVC_START_DATE_TIME,           to_char(a.TRIAGE_DATE_TIME,'hh24:mi') TRIAGE_DATE_TIME,            to_char(a.CONS_SRVC_END_DATE_TIME,'hh24:mi') CONS_SRVC_END_DATE_TIME, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate-1,'dd/mm/yyyy') sys_date_time_1, to_char(sysdate,'dd/mm/yyyy') sys_date, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, AM_GET_DESC.AM_COMPLAINT(a.COMPLAINT_CODE,'"+locale+"' ,'1') COMPLAINT_DESC, a.encounter_id,get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.queue_status queue_status_desc, a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.dis_regn_reference,a.dis_regn_remarks,a.disaster_yn, a.TRAUMA_YN, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"' ,'1')) pat_curr_locn_desc, AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,(SELECT max(complaint_id) FROM ca_encntr_chief_complaint x WHERE encounter_id = a.encounter_id and facility_id=a.facility_id)complaint_code ,a.episode_id, a.OP_EPISODE_VISIT_NUM ");
	  	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 Start*/
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
		if(checkout_yn.equals("Y")){
			sqlPatQ1.append(" ,(select Or_patient_Order_Pend(a.patient_id,a.facility_id,a.encounter_id,'C') from dual) pend_ord_stats ");
		}
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
	  	sqlPatQ1.append(" ,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR ");
	  	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 End*/
	  	if(waitingTimeIndYN){
			sqlPatQ1.append(",(SELECT WAITING_TIME_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME_COLOR,(SELECT WAITING_TIME FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME ");
		}
		if(include_checkedout.equals("Y"))
		{
		sqlPatQ1.append(" from  op_patient_queue a, mp_patient b, op_clinic_lang_vw c ");
		}else
		{
		sqlPatQ1.append(" from  ae_current_patient a, mp_patient b, op_clinic_lang_vw c ");
		}
		 
		if(!(bed_bay_type.equals("")))
		{
			sqlPatQ1.append(" ,ae_bed_for_trmt_area d ");
		}

	if (checkout_yn.equals("N"))
		{
		if (observe_id.equals("C"))
		{
			byObserveId_criteria1.append("and a.locn_code='"+oberv_clinc_code+"'");
		}
	  else if(observe_id.equals("T"))
		{
			byObserveId_criteria1.append("and a.treatment_area_code='"+oberv_TMT_code+"'");
		}
		/*else
		{
			if(!priority_status.equals("for_admission")){//Added by Thamizh selvi on 16th May 2018 against ML-MMOH-CRF-0658
				byObserveId_criteria1.append("and  a.locn_code not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = 'C') "); 
			}
		}*///commented on 29th-OCT-2018 for ML-MMOH-SCF-1081
		}
		if(include_checkedout.equals("Y"))
		{
		sqlPatQ1.append(" where a.patient_class = 'EM' and ");
		}
		else
		{
		sqlPatQ1.append(" where ");
		}	
        if(ch_id.equals("Y"))
		{
		sqlPatQ1.append("  a.rowid in('"+ret_str+"') and ");
		}
		sqlPatQ1.append("   a.facility_id = ?  and a.facility_id = c.facility_id and  a.patient_id = b.patient_id  and c.language_id = '"+locale+"'  and a.facility_id=c.facility_id and a.locn_code = c.clinic_code  ");
		if(!(bed_bay_type.equals("")))
		{
			
			sqlPatQ1.append(" and a.facility_id=d.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL ");
		}
		
    	sqlPatQ1.append(whereClause1);	
		
		sqlPatQ1.append(byObserveId_criteria1);	
		
		sqlPatQ1.append(" ORDER BY ");
		sqlPatQ1.append(orderByClause1);


		pstmt		=	con.prepareStatement(sqlPatQ1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
    	pstmt.setString	(	1,	facility_id		);

		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(bed_bay_type.equals("")))				
			pstmt.setString	(	++columnIndex,	bed_bay_type	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(priority.equals("")))	
			pstmt.setString	(	++columnIndex,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);


		rs	=	pstmt.executeQuery();
		
		if(max == 0) {
			rs.last();
			maxRecord = rs.getRow();			
			rs.beforeFirst();
		} else {
			maxRecord = max;
		}
		
		if	 (maxRecord==0)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{
		
    	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queue_refresh_interval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CAInstalled));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
  String StrHdr = "";
	int size = fieldOrder.size();
	for (int m=0; m < size; ++m)
	{
	 StrHdr = ((String)fieldOrder.get(m)).toLowerCase();
		 
	 /*Below line added for this CRF ML-MMOH-CRF-0637*/
 if (registerattendance && StrHdr.equals("reattendance")) { 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
//End ML-MMOH-CRF-0637	 
else if (StrHdr.equals("practitioner_name")) {  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
} else if (StrHdr.equals("priority_ind")) { 
//Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636
if(sortByPriorityZone){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
} else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
} } else if (StrHdr.equals("priority")) {  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
} else if (StrHdr.equals("queue_date_time")) {
     if(!isLengthOfStayAppl)
	 {
 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	 }
	 else
	 {
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
 
	 }
	
	} else if (StrHdr.equals("bed_no")) {  
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(sortByPriorityZone){
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
} else if (StrHdr.equals("patient_name")) {  
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
} else if (StrHdr.equals("patient_id")) {  
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
} else if (StrHdr.equals("age")) {  
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
} else if (StrHdr.equals("wait_time")) {  
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
} else if (StrHdr.equals("queue_status")) {  
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
} /*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
else if (isPendingForAdmissionAppl && StrHdr.equals("for_admission")) {  
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}/*End*/ 
else if (StrHdr.equals("presenting_problem")) {  
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
} else if (StrHdr.equals("comp_desc")) {  
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
} else if (StrHdr.equals("curr_location")) {  
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
} else if (StrHdr.equals("disaster_yn")) {  
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
} else if (StrHdr.equals("dis_regn_reference")) {

	if(allowSplChar){
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
} 
else
{
	
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

}
}
else if (StrHdr.equals("dis_regn_remarks")) {  
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
} else if (StrHdr.equals("case_of_trauma")) {  
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

String prev_header  ="";
String Header  ="";
String ind="";
String brought_dead = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.broughtdead.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels") ;

int tryl=1;
i=1;
if ( rs != null )
{
    int p1=1;
	
	/* if(!ch_id.equals("Y")){
    if ( start != 1 )
    {
	     for( int k=1; k<start; i++,k++ )
	     {
		  rs.next() ;
	     }
    }
	}
      while ( rs.next() && i<=end )*/
	  while ( rs.next())
        {

			ind="";
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
			rowid			        =   checkForNull(rs.getString("row_id"));
			
			if( !temp.contains(rowid))
				    {   
						 temp.add(rowid);
					}
			
			patient_class			=   checkForNull(rs.getString("patient_class"));
			open_to_all_pract_yn	=	checkForNull(rs.getString("open_to_all_pract_yn"));	
			clinic_code			    =	checkForNull(rs.getString("LOCN_CODE"));	
			curr_location           =   checkForNull(rs.getString("CURR_LOCN_TYPE_DESC")) + " / " + checkForNull(rs.getString("pat_curr_locn_desc"));
			p_clinic_desc			=	checkForNull(rs.getString("locn_desc"));	
			clinic_type				=	checkForNull(rs.getString("locn_type"));	
			treatment_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
			treatment_area_desc		=	checkForNull(rs.getString("treatment_area_desc"));	
			triage_area				=	checkForNull(rs.getString("triage_area"));	
			practitioner_id			=	checkForNull(rs.getString("practitioner_id"));
			practitioner_name		=	rs.getString("practitioner_name");
			practitioner_name 		= (practitioner_name == null)?"&nbsp;":practitioner_name;
			practitioner_full_name	=	checkForNull(rs.getString("practitioner_full_name"));
			queue_date_time			=	checkForNull(rs.getString("queue_date_time"));
			sys_date_time			=	checkForNull(rs.getString("sys_date_time"));
			patient_id				=	checkForNull(rs.getString("patient_id"));
			patient_name			=	checkForNull(rs.getString("patient_name"));
			encounter_id			=	checkForNull(rs.getString("encounter_id"));
			waiting_time			=	checkForNull(rs.getString("waiting_time")); 
			
			stay_time               =   checkForNull(rs.getString("stay_time")); // added by mujafar for ML-MMOH-CRF-1194
	
			stay_time = stay_time.replaceAll("\\s", ""); 
	
			/* added by mujafar for ML-MMOH-CRF-1194*/
			StringTokenizer StaytimeWt	= new StringTokenizer(stay_time,":");
            if(StaytimeWt.hasMoreTokens()){
				stay_time_1 = StaytimeWt.nextToken();
				stay_time_2 = StaytimeWt.nextToken();
				
			}
			if(stay_time_1.length() == 1)
				stay_time_1	= "0" + stay_time_1;
				stay_time_2	= stay_time_1 + ":" + stay_time_2;
				
			
			/* added by mujafar for ML-MMOH-CRF-1194*/
			
			StringTokenizer wt = new StringTokenizer(waiting_time,":");
            if(wt.hasMoreTokens()){
				firststring = wt.nextToken();
				secondstring = wt.nextToken();
				if(!("").equals(firststring)){
					p_waiting_time_hours	= Integer.parseInt(firststring.trim());
					p_waiting_time_hours	= p_waiting_time_hours * 60;
				}
				if(!("").equals(secondstring))
					p_waiting_time_mins		= Integer.parseInt(secondstring.trim());
				
				p_waiting_time_mins			= p_waiting_time_hours+p_waiting_time_mins;
            }
			 if(firststring.length() == 1){
				 firststring = "0"+firststring;
				 waiting_time = firststring +":" +secondstring;
			}
			
			if(waitingTimeIndYN){
				p_waiting_time	= rs.getInt("P_WAITING_TIME");
				p_waiting_time_color	= checkForNull(rs.getString("P_WAITING_TIME_COLOR"));
			}
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			if(checkout_yn.equals("Y")){
				pend_ord_stats	= checkForNull(rs.getString("pend_ord_stats"),"N");
			}
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

			/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
			pendngAdmDateTime	=	checkForNull(rs.getString("pendngAdmDateTime"));
			forAdmWaitngTime	=	checkForNull(rs.getString("pendngForAdmissionTime"));
			StringTokenizer frAdmWt	= new StringTokenizer(forAdmWaitngTime,":");
            if(frAdmWt.hasMoreTokens()){
				forAdmWaitString1 = frAdmWt.nextToken();
				forAdmWaitString2 = frAdmWt.nextToken();
			}
			if(forAdmWaitString1.length() == 1){
				forAdmWaitString1	= "0" + forAdmWaitString1;
				forAdmWaitngTime	= forAdmWaitString1 + ":" + forAdmWaitString2;
			}
			/*End*/

			queue_date				=	checkForNull(rs.getString("queue_date1"));	
			queue_status			=	checkForNull(rs.getString("queue_status"));	
			queue_status_desc		=	checkForNull(rs.getString("queue_status"));	
			trauma_yn				=	checkForNull(rs.getString("trauma_yn"));	
            bed_no					=	rs.getString("bed_no");
			bed_no 					=  (bed_no == null)?"":bed_no;
			disaster_yn				=	checkForNull(rs.getString("disaster_yn"));	
			CaseofTrauma_val		=   checkForNull(rs.getString("TRAUMA_YN"));
			patient_gender			=	checkForNull(rs.getString("patient_gender"));	
			brought_dead_yn			=	checkForNull(rs.getString("brought_dead_yn"));	
			open_to_all_prac_for_clinic_yn=	checkForNull(rs.getString("open_to_all_prac_for_clinic_yn"));	
			assign_tmt_area_time	=	checkForNull(rs.getString("assign_date"));
			priority_zone			=	rs.getString("priority_zone");
			priority_zone 		= (priority_zone == null)?"&nbsp;":priority_zone;
			visit_type_code         =	checkForNull(rs.getString("visit_type_code"));
	        //pract_type				=	checkForNull(rs.getString("pract_type"));
			sys_date_time_1			=	checkForNull(rs.getString("sys_date_time_1"));	
			sys_date2				=	checkForNull(rs.getString("sys_date"));	
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 Start*/
			priority_zone_bgcolor	=  checkForNull(rs.getString("PRIORITY_ZONE_COLOR"));
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 End*/

			dis_regn_reference			=	rs.getString("dis_regn_reference");
			if(dis_regn_reference == null) dis_regn_reference="&nbsp";

	        dis_regn_remarks			=	rs.getString("dis_regn_remarks");
			if(dis_regn_remarks == null) dis_regn_remarks="";
			

			COMPLAINT_DESC			=	rs.getString("COMPLAINT_DESC");
			if(COMPLAINT_DESC == null) COMPLAINT_DESC="&nbsp";

           
			complaint_code			=	rs.getString("complaint_code");
			if(complaint_code == null) complaint_code="";
			
			episode_id=	rs.getString("episode_id");
			if(episode_id == null) episode_id="";

            visit_num =	rs.getString("OP_EPISODE_VISIT_NUM");
			if(visit_num == null) visit_num="";

			year_value				=	checkForNull(rs.getString("year"));	
			month_value				=	checkForNull(rs.getString("months"));	
			day_value				=	checkForNull(rs.getString("days"));	



			PAT_PRIORITY_DESC       =   rs.getString("PAT_PRIORITY_DESC");
			PAT_PRIORITY_DESC 		= (PAT_PRIORITY_DESC == null)?"&nbsp;":PAT_PRIORITY_DESC;

			if(PAT_PRIORITY_DESC == null) PAT_PRIORITY_DESC="";
			
			/*Below line added for this CRF ML-MMOH-CRF-0637*/
			String dischargedate="",visitdate="",currentdate="",clinicdesc="",maxhrsforreattend="",reattance="";
		if(registerattendance){
			ArrayList arrIPList=(ArrayList)AEReattendanceEncounterDetails.getAEEncounterDetails(con, patient_id, facility_id,p);
			 for(int ae=0; ae<arrIPList.size(); ae++){
					AEReattendanceEncounterDetailsBean aeEncounterDetails=(AEReattendanceEncounterDetailsBean)arrIPList.get(ae); 
					dischargedate=aeEncounterDetails.getDischargedate();
					visitdate=aeEncounterDetails.getVisitdate();
					currentdate=aeEncounterDetails.getCurrentdate();
					clinicdesc=aeEncounterDetails.getClinicdesc();
					maxhrsforreattend=aeEncounterDetails.getMaxhrsforreattend();										
		     }
			  if( !dischargedate.equals("") && !maxhrsforreattend.equals("")){					 
						
						 int chk_period_admit=Integer.parseInt(maxhrsforreattend);
						 chk_period_admit=chk_period_admit*60;
					     java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyy HH:mm:ss"); 
						 java.util.Date currentdate_reattence =new java.util.Date();
		                 java.util.Date dischargedate_reattence  =new java.util.Date();
						 currentdate_reattence = format.parse(currentdate);
		                 dischargedate_reattence =format.parse(dischargedate); 
						 diff=(currentdate_reattence.getTime()-dischargedate_reattence.getTime())/60000;
						 	 
						 if(chk_period_admit >= diff  && !maxhrsforreattend.equals("")){
						  reattance=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
						 }
				}		 
			}
			//End this CRF ML-MMOH-CRF-0637
			
			
			if(queue_status_desc1 != null)
				queue_status_desc1.delete(0,queue_status_desc1.length());

			check_in_date_time = rs.getString("check_in_date_time");
			check_in_date_time 		 = (check_in_date_time == null)?"empty":check_in_date_time;
			if (!check_in_date_time.equals("empty"))
				queue_status_desc1.append(" <table border='0' width='90%'  cellspacing='0.5px' ><tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels")+"</td> <td align='right'><font size=1>- " + check_in_date_time +"</td></tr>" );  // modified by mujafar for HSA-CRF-0240

			assign_tmt_area_time1  = rs.getString("ASSIGN_TMT_AREA_TIME");
			assign_tmt_area_time1 		 = (assign_tmt_area_time1 == null)?"empty":assign_tmt_area_time1;
			if (!assign_tmt_area_time1.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels")+"</td> <td align='right'><font size=1>- "+ assign_tmt_area_time1 +"</td></tr>" );  // modified by mujafar for HSA-CRF-0240

			treatment_start_time  = rs.getString("TREATMENT_START_TIME");
			treatment_start_time 		 = (treatment_start_time == null)?"empty":treatment_start_time;
			if (!treatment_start_time.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+"</td> <td align='right'><font size=1>- " +treatment_start_time +"</td></tr>" );		// modified by mujafar for HSA-CRF-0240			
			cons_srvc_start_date_time  = rs.getString("CONS_SRVC_START_DATE_TIME");
			cons_srvc_start_date_time 		 = (cons_srvc_start_date_time == null)?"empty":cons_srvc_start_date_time;
					
			TRIAGE_DATE_TIME  = rs.getString("TRIAGE_DATE_TIME");
			TRIAGE_DATE_TIME  =(TRIAGE_DATE_TIME == null)?"empty":TRIAGE_DATE_TIME;
			/* follwoing block added by mujafar for HSA-crf-0240 on 2/4/2015.  *start* */
				
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date d1 = null;
			java.util.Date d2 = null;
 			if(!(TRIAGE_DATE_TIME.equals("empty") || cons_srvc_start_date_time.equals("empty")))
			{
					d1 = format.parse(TRIAGE_DATE_TIME);
					d2 = format.parse(cons_srvc_start_date_time);		
					 boolean flag = d1.before(d2);
					 boolean flag1 = d1.equals(d2);
					 if(flag == true || flag1 == true)
						{																										  
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
						
					 }
					 else
					 {
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
					 }
			
			}
			else
			if( !TRIAGE_DATE_TIME.equals("empty") && cons_srvc_start_date_time.equals("empty"))
			{
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
			}
			else
				if(TRIAGE_DATE_TIME.equals("empty") && !cons_srvc_start_date_time.equals("empty"))
				{
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
				}					
			/* above block added by mujafar for HSA-crf-0240 on 2/4/2015.  *end* */	
				
			cons_srvc_end_date_time  = rs.getString("CONS_SRVC_END_DATE_TIME");
			cons_srvc_end_date_time 		 = (cons_srvc_end_date_time == null)?"empty":cons_srvc_end_date_time;
			if (!cons_srvc_end_date_time.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_end_date_time +"</td></tr> " );  // modified by mujafar for HSA-CRF-0240
				queue_status_desc1.append("</table>");
			queue_status_desc = queue_status_desc1.toString();
				
			
			
	if(prev_visit.equals("") && (sys_date2.equals(queue_date)) )	
	{     
		ind="";
	}
	else if(prev_visit.equals(""))
	{
	ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
	else if( (!prev_visit.equals(""))  &&  (sys_date_time_1.equals(queue_date))) 
	{
        ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
	else if( (!prev_visit.equals("")) ) 
	{
        ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
   treatment_area_desc=specialCharacter(treatment_area_desc);
	   Header=p_clinic_desc;
	if(!treatment_area_desc.equals(""))
		Header=Header+"/"+ treatment_area_desc;
	if(!ind.equals(""))
		Header=Header+"/"+ ind;

	if(!(Header.equals(prev_header)))
			{
					
	if(prev_visit.equals("") && (sys_date2.equals(queue_date)) )	
					{   
	
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(disp_val));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(clspanval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Header));
            _bw.write(_wl_block73Bytes, _wl_block73);
 
		out.println(getStatistics(pageContext,con,facility_id,clinic_type,clinic_code,treatment_area_code, include_checkedout));
		
            _bw.write(_wl_block74Bytes, _wl_block74);

				}
	else if(prev_visit.equals("")){
	
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(clspanval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Header));
            _bw.write(_wl_block77Bytes, _wl_block77);

	} 
		
	else if( (!prev_visit.equals("")) && (sys_date_time_1.equals(queue_date)) ) 
			{
	
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(clspanval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Header));
            _bw.write(_wl_block79Bytes, _wl_block79);

	 }
	 else if( (!prev_visit.equals("")) ) 
			{
	
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(clspanval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Header));
            _bw.write(_wl_block79Bytes, _wl_block79);

	 }
	
		if(!isLengthOfStayAppl)
		prev_header	=	Header;		

}
	
//Mahesh added
/* To iterate over each column and paint the columns in correct order - vinod 11/9/2009 */
			
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block81Bytes, _wl_block81);

	String str = "";
	for (int m=0; m < size; ++m)
	{
		str = ((String)fieldOrder.get(m)).toLowerCase();
					
			/*Below line added for this CRF ML-MMOH-CRF-0637*/
			 if (registerattendance && str.equals("reattendance")) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(reattance));
            _bw.write(_wl_block84Bytes, _wl_block84);
}else if (str.equals("practitioner_name")) {
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
} else if (str.equals("priority_ind")) {
			//Modified by Sangeetha for ML-MMOH-CRF-0636 on 27/apr/2017
			
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValuePI));
            _bw.write(_wl_block86Bytes, _wl_block86);
if(!priority_zone_bgcolor.equals("")){ 
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(priority_zone_bgcolor));
            _bw.write(_wl_block88Bytes, _wl_block88);
} if(sortByPriorityZone){
            _bw.write(_wl_block89Bytes, _wl_block89);
}else{ 
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
            _bw.write(_wl_block91Bytes, _wl_block91);
}else if (str.equals("priority")) {
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
if(PAT_PRIORITY_DESC.equals("")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            out.print( String.valueOf(PAT_PRIORITY_DESC));
} 
            _bw.write(_wl_block93Bytes, _wl_block93);
} else if (str.equals("queue_date_time")) 
			{
				if(isLengthOfStayAppl) // Modified by mujafar for ML-MMOH-CRF-1194
				{
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(stay_time_2));
            _bw.write(_wl_block98Bytes, _wl_block98);

				}
				else
				{
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block99Bytes, _wl_block99);

				} 
			}
			else if (str.equals("bed_no")) {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
 if(sortByPriorityZone){
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block102Bytes, _wl_block102);
if(bed_no.equals("")){ 
            _bw.write(_wl_block103Bytes, _wl_block103);
}
				else{
					
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block104Bytes, _wl_block104);
} 
            _bw.write(_wl_block105Bytes, _wl_block105);
 } else if (str.equals("patient_name")) {
		  
		  String img_temp="";
		  if(isVIPimgpatfrontappl)
			{	
			 
			String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,patient_id,facility_id);
			if(vip_pat_yn.equals("TRUE"))
			img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
			else
			img_temp = "";
			
			}
		  
		if(checkout_yn.equals("N"))
			{
				if(!queue_status.equals("07"))
				{
		    	
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(p_clinic_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(p_clinic_desc)));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(triage_area));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(trauma_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(practitioner_full_name));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(queue_date_time));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(assign_tmt_area_time));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(record_vital_signs_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(pract_type1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(enable_rights_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(sel_triage_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(sel_cons_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(enable_rights_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(min_age_for_lmp));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(year_value));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(visit_num));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(reg_new_born_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(inv_reg_new_born_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(pendngAdmDateTime));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(img_temp));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);

			  }
				else
				{
							
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(img_temp));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block125Bytes, _wl_block125);

				}
			}
			else 
			{
				if (!queue_status.equals("07"))
				{
			
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(visit_num));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(img_temp));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block129Bytes, _wl_block129);

				}
				else
				{
			   
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(img_temp));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block129Bytes, _wl_block129);
	}
			
            _bw.write(_wl_block133Bytes, _wl_block133);
}
			} else if (str.equals("patient_id")) {
			if(brought_dead_yn.equals("Y")) {   
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
 }else {
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block133Bytes, _wl_block133);
} else if (str.equals("age")) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(year_value));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(month_value));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(day_value));
            _bw.write(_wl_block139Bytes, _wl_block139);
 } else if (str.equals("wait_time")) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block140Bytes, _wl_block140);
if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(p_waiting_time_color));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(waiting_time));
            _bw.write(_wl_block84Bytes, _wl_block84);
 } else if (str.equals("queue_status")) { 
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(queue_status_desc));
            _bw.write(_wl_block145Bytes, _wl_block145);
 } /*Added by Thamizh selvi on 19th Apr 2018 against ML-MMOH-CRF-0658 Start*/
				else if (isPendingForAdmissionAppl && str.equals("for_admission")) {
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block146Bytes, _wl_block146);
 if(pendngAdmDateTime.equals("")){ 
            _bw.write(_wl_block147Bytes, _wl_block147);
 }else{ 
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(pendngAdmDateTime));
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(forAdmWaitngTime));
            _bw.write(_wl_block151Bytes, _wl_block151);
 } 
            _bw.write(_wl_block152Bytes, _wl_block152);
}/*End*/
			else if (str.equals("presenting_problem")) { 
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(COMPLAINT_DESC));
            _bw.write(_wl_block154Bytes, _wl_block154);
 } else if (str.equals("comp_desc")) { 
            _bw.write(_wl_block155Bytes, _wl_block155);

			    	
			if(disaster_yn.equals("Y")) {  
					if(!complaint_code.equals("")){
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
 }else {
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block160Bytes, _wl_block160);
}
          }else {
				  
		if(!complaint_code.equals("")){
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
 }else {
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block163Bytes, _wl_block163);
} }
            _bw.write(_wl_block104Bytes, _wl_block104);
 } else if (str.equals("curr_location")) { 
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(curr_location));
            _bw.write(_wl_block166Bytes, _wl_block166);
} else if (str.equals("disaster_yn")) { 
            _bw.write(_wl_block167Bytes, _wl_block167);

		//Added by Sangeetha for ML-MMOH-CRF-0625
		Boolean DISPLAY_BLANK_NON_DISASTER = CommonBean.isSiteSpecific(con, "AE", "DISPLAY_BLANK_NON_DISASTER");
		if(disaster_yn.equals("Y")) {   
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
 }else {
		if(DISPLAY_BLANK_NON_DISASTER){
		
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block171Bytes, _wl_block171);
 }else {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
}}
            _bw.write(_wl_block173Bytes, _wl_block173);
} else if (str.equals("dis_regn_reference")) {
            _bw.write(_wl_block174Bytes, _wl_block174);
if(disaster_yn.equals("Y")) {   
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(dis_regn_reference));
            _bw.write(_wl_block170Bytes, _wl_block170);
 }else {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(dis_regn_reference));
            _bw.write(_wl_block172Bytes, _wl_block172);
}
            _bw.write(_wl_block177Bytes, _wl_block177);
} else if (str.equals("dis_regn_remarks")) {
            _bw.write(_wl_block178Bytes, _wl_block178);
if(isDisplayAllRemarks){
			   if(!dis_regn_remarks.equals("")) // added by mujafar for ML-MMOH-CRF-1040 start
			   {
			   
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dis_regn_remarks));
            _bw.write(_wl_block185Bytes, _wl_block185);

			   }
			  else{ 
				int remarks_cnt = eAE.AECommonBean.getSecTriageRemarksCount(con,encounter_id,facility_id);
				 if(remarks_cnt>0) 
				 {
			
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dis_regn_remarks));
            _bw.write(_wl_block187Bytes, _wl_block187);
	
				 }
				else
				{
					
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block188Bytes, _wl_block188);

				}
			  }  // added by mujafar for ML-MMOH-CRF-1040 end
		}else{
			if(disaster_yn.equals("Y")) { 
			if(!dis_regn_remarks.equals("")) // added by mujafar for ML-MMOH-CRF-1040 start
			{
			
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dis_regn_remarks));
            _bw.write(_wl_block185Bytes, _wl_block185);
 
			}
			else
			{
			
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block189Bytes, _wl_block189);

			} // added by mujafar for ML-MMOH-CRF-1040 end
		}else {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block190Bytes, _wl_block190);
}}
            _bw.write(_wl_block191Bytes, _wl_block191);
} else if (str.equals("case_of_trauma")) {
            _bw.write(_wl_block167Bytes, _wl_block167);
if(CaseofTrauma_val.equals("Y")) {   
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tdwidth));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
 }else {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tdwidth));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
}
            _bw.write(_wl_block173Bytes, _wl_block173);
} // End To iterate over each column and paint the columns in correct order
		  
		 
		}
		
            _bw.write(_wl_block194Bytes, _wl_block194);

			tryl++;
			i++;
			p1++;
	} //end while

	   if(rs!=null) rs.close();
	   if(pstmt!=null)			pstmt.close();
}
	   if((orderByClause != null) && (orderByClause.length() > 0))
		{
			orderByClause.delete(0,orderByClause.length());
		}
		if((whereClause != null) && (whereClause.length() > 0))
		{
			whereClause.delete(0,whereClause.length());
		}
			if((byObserveId_criteria != null) && (byObserveId_criteria.length() > 0))
		{
			byObserveId_criteria.delete(0,byObserveId_criteria.length());
		}
	  
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(CAInstalled));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(priority_zone1));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(queue_refresh_interval));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(checkout_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(include_checkedout));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(enable_rights_yn));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(pract_type1));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(sel_triage_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(sel_cons_yn));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(start));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(end));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(observe_id));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(reg_new_born_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(inv_reg_new_born_yn));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block220Bytes, _wl_block220);
Boolean isPracApplicable	= CommonBean.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE");
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(isPracApplicable));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(sortByPriorityZone));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(isDisplayAllRemarks));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(isStartConsultationAppl));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(isPendingForAdmissionAppl));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(chk_for_pen_orders_bfr_chkout));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(checkout_allow_yn));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block230Bytes, _wl_block230);

	  }
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block231Bytes, _wl_block231);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block232Bytes, _wl_block232);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastRefreshTime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Reattendance.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Zone.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeIn.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeIn.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WaitTime.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.for.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PresentingProblem.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChiefComplaints.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.LengthofStay.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Pending.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.for.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
}

package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __recdiagnosiscurrentdiag extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisCurrentDiag.jsp", 1742301158122L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisGetValidation.jsp", 1730014091638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\'query_result_form\' id=\'query_result_form\' action=\'../../servlet/eMR.RecDiagnosisServlet\' method=\'post\' target=\'messageFrame\'>\n\t<div>\n\t<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t\t<tr>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'><font size=1 >&nbsp;</font></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'><font size=1 >&nbsp;</font></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'><font size=1 >&nbsp;</font></th>\n\t\t\t\t<!-- <td align=\'center\'  nowrap><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></td>\n\t\t\t\t -->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'   nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'   onclick =\"sort(\'diagProb\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" style=\'cursor:pointer\'    wrap class=\'CAGROUPHEADING\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font>\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'diagprobGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'     onclick =\"sort(\'diagProbDesc\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" style=\'cursor:pointer\'   nowrap class=\'CAGROUPHEADING\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'diagprobdescGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<!--Below line added for this CRF Bru-HIMS-CRF-024.2-->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap   class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<!--End Bru-HIMS-CRF-024.2 -->\t\t\t\t\n\t\t\t\t<!--Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012\n\t\t\t\t//Start-->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'    onclick =\"sort(\'status\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\" style=\'cursor:pointer\'   nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'statusGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<!--End-->\n\t\t\t\t\n\t\t\t\t<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started-->\n\t\t\t\t\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'>  <font size=1>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<br>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t\n\t\t\t\t<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End-->\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'   nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th> <!--this line Added for this CRF [PMG2012-CRF-0030] -->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'   nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'    nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<!-- Added by Ajay for TH-KW-CRF-165.1  -->\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'    nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<!-- End of CRF TH-KW-CRF-165.1 -->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'   nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'     onclick =\"sort(\'recDateTime\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </font>\t\t\t\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'recordeddateGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" color=\'red\' align=\'center\'    onclick =\"sort(\'accuracy\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" style=\'cursor:pointer\'  nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font>\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'accuracyGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'   ><font size=1 >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'   ><font size=1 >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\'   onclick =\"sort(\'onsetDate\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</font>\n\t\t\t\t<img src=\'\'  border=none  align=right name=\'onsetDateGif\' style=\'visibility:hidden\'>\n\t\t\t\t</th>\n\t\t\t\t<!--Maheshwaran K has commented this code for SKR-CRF-0020 as on 10/07/2013-->\n\t\t\t\t<!--<td align=\'center\' nowrap class=\'CAGROUPHEADING\'><font size=1 >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></td>-->\n\t\t\t\t<th style=\"border-bottom: 1px solid black;\" align=\'center\' nowrap class=\'CAGROUPHEADING\'   ><font size=1 >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font><img src=\'\'  border=none  align=right  style=\'visibility:hidden\'></th>\n\t\t</tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<!-- <tr>\n\t\t\t\t<td colspan=\'12\' class=\'CAGROUPHEADING\' align=\'left\'><font size=1><b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</b></font></td>\n\t\t\t</tr>\t -->\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><img src=\'../../eCommon/images/Differentials.gif\' style=\"cursor:pointer;visibility:visible\" onclick=\'diffGroup(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\",\"update\",\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\")\'></img></td>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  nowrap><font size=\'1\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<img src=\'../../eCommon/images/LinkView.gif\' align=\'right\' onclick=\'showProblem(\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\",\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\")\'></font></td>\n\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'  nowrap><font size=\'1\'><a href=\"javascript:callDetails(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></font></td> -->\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<!-- \t\t\t<tr>\n\t\t\t\t<td colspan=\'12\' class=\'CAGROUPHEADING\' align=\'left\'><font size=1><b>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</b></font></td>\n\t\t\t</tr>\t\n -->\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\")\'></font></td>\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a></font></td> -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<tr style=\'visibility:hidden\'>\n<th>&nbsp;</th>\n<!--<th>&nbsp;</th>-->\n<th align=\'center\'><font size=1>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</font></th>\n<th align=\'center\'><font size=1>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font></th>\n<!--<th align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font></th>-->\n<th align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</font></th>\n<th align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font></th>\n</tr>\n\t\t  \n</table>\n</div>\n<script>\n//Added by mujafar for ML-BRU-CRF-0524\nchangeSortOrder(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\')\n</script>\n\t<input type=\'hidden\' name=\'qryStr\' id=\'qryStr\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t<input type=\'hidden\' name=\'diff_mode\' id=\'diff_mode\' value=\"\" >\n\t<input type=\"hidden\" name = \"Locn_Code\" id = \"Locn_Code\" value =\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name = \"Locn_Type\" id = \"Locn_Type\" value =\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name = \"Practitioner_Id\" id = \"Practitioner_Id\" value =\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name = \"relationship_id\" id = \"relationship_id\" value =\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name = \"modal_yn\" id = \"modal_yn\" value =\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\"hidden\" name =\"practitioner_type\" id =\"practitioner_type\" value =\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name =\"called_from_ip\" id =\"called_from_ip\" value =\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\'hidden\' name=\'diag_classification\' id=\'diag_classification\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'></input>\n\t<input type=\'hidden\' name=\'term_code_short_desc\' id=\'term_code_short_desc\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'></input>\n\t<input type=\'hidden\' name=\'diag_class_code\' id=\'diag_class_code\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'></input>\n\t<!--Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645-->\n\t<input type=\'hidden\' name=\'termCodeEffStatus\' id=\'termCodeEffStatus\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'></input>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'></input>\n\n\t<input type=\'hidden\' name=\'enbl_link_to_curr_enc\' id=\'enbl_link_to_curr_enc\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'></input>\n\t<input type=\'hidden\' name=\'crs_chk_mand_flds\' id=\'crs_chk_mand_flds\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'></input>\t\n\t<input type=\'hidden\' name=\'term_set_desc\' id=\'term_set_desc\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></input>\t\n\t<input type=\'hidden\' name=\'notifiable_yn\' id=\'notifiable_yn\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'></input>\t\n\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"></input>\n\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"></input>\n\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"></input>\n\t<input type=\'hidden\' name=\'cause_of_death\' id=\'cause_of_death\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"></input>\n\t<input type=\'hidden\' name=\'isCurrentEncounter\' id=\'isCurrentEncounter\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"></input>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

		request.setCharacterEncoding("UTF-8");
		String locale				= (String)session.getAttribute("LOCALE");
		String Patient_Id			= checkForNull(request.getParameter("Patient_Id"));
		String Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));		
		String cause_of_death		= checkForNull(request.getParameter("cause_of_death"));		
		String operating_facility_id= (String) session.getValue("facility_id");
		String patient_class        = checkForNull(request.getParameter("patient_class"));
		String age					= checkForNull(request.getParameter("Age"));	
		String dob					= checkForNull(request.getParameter("Dob"));	
		String Locn_Code            = checkForNull(request.getParameter("Locn_Code"));			
		String Locn_Type            = checkForNull(request.getParameter("Locn_Type"));

		String Practitioner_Id		= checkForNull(request.getParameter("Practitioner_Id"));	
		String relationship_id		= checkForNull(request.getParameter("relationship_id"));
		String sex					= checkForNull(request.getParameter("Sex"));
		String modal_yn				= checkForNull(request.getParameter("modal_yn"));
		String classValue			= "";
		String called_from_ip		= checkForNull(request.getParameter("called_from_ip"));

		String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
		if(practitioner_type.equals(""))	
			practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));

		String option_id			= checkForNull(request.getParameter("option_id"));
		String accession_number     = checkForNull(request.getParameter("accession_num"));
		String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));
		String f_authorize_yn		= checkForNull(request.getParameter("f_authorize_yn"));
		String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));	//CHL-CRF- 0008 - IN:001472
		String headerVal = checkForNull(request.getParameter("headerVal")); // Added by mujafar for ML-BRU-CRF-0524
		String function_id = checkForNull(request.getParameter("function_id")); // Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
				
		
		
		Connection con				= null;	
		PreparedStatement stmt		= null;
		PreparedStatement stmt1		= null;
		PreparedStatement stmt2		= null;
		PreparedStatement pstmt		= null; 
		ResultSet res				= null;		
		ResultSet rs				= null;		
		ResultSet rset2				= null;		
		ResultSet rs1				= null;		
		Statement st				= null;
		ResultSet rset				= null;

		String Support_exisist_yn_YN= "";
		String accur_code_ind		= ""; 
		String accuracy_short_desc  = "";
		int encounter_id1		= 0;	
		String occur_srl_no			= "";
		String onset_date			= "";
		String onset_date_converted	= "";
		String onset_nature			= "";	
		String onset_status			= "";	
		String short_desc			= "";
		String actual_short_desc		= ""; // included for the SCF - SRR20056-scf-8582 
		String term_code			= ""; 		
		String term_set_desc		= "";
		String term_set_id			= "";	
		String encounter_stage		= "";
		String old_encounter_id		= "";
		String curr_practitioner_id = "";
		String curr_practitioner_name= "";
		StringBuffer associate_codes = new StringBuffer();
		String anatomical_site		= "" ;
		String applicable_side		= "" ;
		String pat_accession_num	= "";
		String diag_classification	= "";
		String notifiable_code="";//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		String diag_classification_display	= "";
		String recordedDate			= "";
		String recordedDateDisp		= "";
		String dagger_independent_yn		= "";// Added For SRR-CRF-303.2
		String disp_dagger_dep_ind			= "";// Added For SRR-CRF-303.2
		
		String called_from_ot=checkForNull(request.getParameter("called_from_ot")); //this line Added for this CRF [PMG2012-CRF-0030]
		//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
		//Start
		String encounter_stage_str="";
		String nature_str="";
		String curr_onset_type="";
		String severity_str="";
		String curr_enc_diag_class="";
		String diag_category_code = "";
		
		String diagnosis_remark	= ""; //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023
		
		//End
		//Added for this CRF Bru-HIMS-CRF-024.2
		String accession_num_work_related="",accession_num_notifiable="", accession_num_notifiable_display="";
		String notifiable_form_mand_yn="N"; 
        HashMap ResultParamHashMap = new HashMap();	
		
            _bw.write(_wl_block12Bytes, _wl_block12);

	try
	{

		String Diff_status			= "";
		String curr_accuracy_code	= "";
		String nature				= "";
		String natureLangDesc		= "";
		String not_curr_enc			= "S";
		String notifiable_yn		= "";
		String sensitive_yn			= "";
		String prev_term_set_id		= "";
		String priority				= "";
		String priorityclass		= "";
		String status					= "";
		String status_lbl			= "";
		String isCurrentEncounter	= "N";

		String complaint_id			= "";
		String complaint_desc		= "";
		String remarks				= "";
		String onset_datetime_str	= "";
		String complaint_date		= "";
        String comp_added_by		= "";
        String severity				= "";
        String term_code_disply		= "";
        String diag_class_code		= "";
        String curr_status			= "";
		String diag_category 		= ""; //Added by Ajay for TH-KW-CRF-165.1
		String term_code_status="";
		int view_cnt=0;
		String linkviewcnt_sql = "";
		String preoperative=""; //Added this line for this CRF [PMG2012-CRF-0030]
		//String diag_enc_level_yn="N";//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
		
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		String diag_enc_level_yn="N";

        con=ConnectionManager.getConnection(request);

		Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TYPES_OF_NOTIFICATION_FORM"); //Added by Sangeetha for ML-MMOH-CRF-0547

		Boolean notifiableLegndChgApplYn =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","NOTIFIABLE_LEGEND_CHG"); //Added by Dharma
		
		Boolean isMultiDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281

		Boolean termCodeEffStatus =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHK_TERM_CODE_EFF_STATUS"); //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		
		Boolean isDiagCatgMand  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_CATEGORY_MAND"); //Added by Ajay for TH-KW-CRF-165.1
		
		
		String asc_desc	=	(request.getParameter("asc_desc")==null)? " desc" : request.getParameter("asc_desc"); // Added by mujafar for ML-BRU-CRF-0524
		
		Boolean diagRevokeStatus  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_REVOKED_STATUS"); //Added by Maheshwaran K for MMS-DM-SCF-0867
		
		//	Boolean IsDiagRemark  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DIAG_REMARKS"); //<!-- added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started-->
		
		Boolean isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("notifiable_form_mand_yn","S");		
		sqlColumns.put("enable_link_to_curr_enc_s","S");//Added by Ajay Hatwate for ML-MMOH-CRF-1741		
		sqlColumns.put("crs_chk_mand_flds_on_link_diag","S");//Added by Ajay Hatwate for ML-MMOH-CRF-1741		
		ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,"","mr_parameter",con);
		notifiable_form_mand_yn = (String) ResultParamHashMap.get("notifiable_form_mand_yn");		
		//End  Bru-HIMS-CRF-024.2	
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
		String diagClassMandYn		= "";		
		String crossChkMandFldsYn = checkForNull((String) ResultParamHashMap.get("crs_chk_mand_flds_on_link_diag"),"N");
		String enableLinktoCurrEncS = checkForNull((String) ResultParamHashMap.get("enable_link_to_curr_enc_s"),"N");
		//System.out.println(crossChkMandFldsYn + " crossChkMandFldsYn " +enableLinktoCurrEncS + " enableLinktoCurrEncS ");
		if(enableLinktoCurrEncS.equals("N")){
			not_curr_enc = "";
		}
		/* End of ML-MMOH-CRF-1741 */
		
		int k						= 0;
		StringBuffer strBuffer		= new StringBuffer();
		StringBuffer probBuffer		= new StringBuffer();
	
		if(strBuffer.length() > 0) strBuffer.delete(0,strBuffer.length());
		if(probBuffer.length() > 0) probBuffer.delete(0,probBuffer.length());
		
		//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
		//Start
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		try
		{
			stmt = con.prepareStatement("select diag_enc_level from mr_parameter");
			rs = stmt.executeQuery();
			if(rs!=null && rs.next())
			{
			diag_enc_level_yn=rs.getString("diag_enc_level")==null?"N":rs.getString("diag_enc_level");
			}
			if(rs!=null)		rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	  	
		//End this SCF TTM-SCF-0167-904499 [IN:061028]
		
		//strBuffer.append("SELECT e.enc_stage,a.term_set_id, b.term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn,c.short_desc,c.long_desc ");
		//strBuffer.append("SELECT  to_char(.ADDED_DATE,'dd/mm/yyyy hh24:mi') recordedDate,e.encounter_id old_encounter_id,e.enc_stage,a.term_set_id, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");

		/*Below Query Modified for this CRF [PMG2012-CRF-0030]*/
		//Below query modified for this CRF Bru-HIMS-CRF-024.2
		//strBuffer.append("SELECT  to_char(e.recorded_date_time,'dd/mm/yyyy hh24:mi') recordedDate,e.encounter_id old_encounter_id,e.enc_stage,a.OT_PRE_OPER_DIAG_YN pre_operative, a.accession_num_work_related, a.accession_num_notifiable, a.term_set_id, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");
		/*Modified the Query for ML-BRU-SCF-1655 as on 05/02/2016 */
		strBuffer.append("SELECT  NVL((select TO_CHAR (z.recorded_date_time, 'dd/mm/yyyy hh24:mi') FROM pr_diagnosis_enc_dtl z, pr_diagnosis y      WHERE z.facility_id = ?   AND  z.encounter_id = ?      AND z.term_set_id = e.term_set_id AND z.term_code = e.term_code AND z.occur_srl_no = e.occur_srl_no AND z.patient_id = y.patient_id AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code AND z.occur_srl_no = y.occur_srl_no),to_char(e.recorded_date_time,'dd/mm/yyyy hh24:mi')) recordedDate ,");
		
		strBuffer.append(" e.encounter_id old_encounter_id,e.enc_stage,a.OT_PRE_OPER_DIAG_YN pre_operative, a.accession_num_work_related, a.accession_num_notifiable, a.term_set_id,a.curr_remarks, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc ,e.remarks, a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");
		
		
		//10/17/2008
		strBuffer.append(",c.sensitive_yn");
		//10/17/2008
		//Added by Ajay for TH-KW-CRF-165.1
		//Start
		if(isDiagCatgMand){
			strBuffer.append(",e.diag_catg diag_catg_code,(select short_desc from mr_diag_category where diag_catg_code = e.diag_catg ) diag_category");
		}//End of CRF TH-KW-CRF-165.1
		strBuffer.append(",mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2')short_desc,a.TERM_CODE_SHORT_DESC ");
		strBuffer.append("term_code_desc , (SELECT mr_get_desc.mr_accuracy(a.curr_accuracy_code,'"+locale+"','2')short_desc FROM MR_ACCURACY WHERE ");
		strBuffer.append(" accuracy_code =a.curr_accuracy_code) accuracy_short_desc,"); 

		/*11/4/2008 ICN 6224  MR_ACCURACY*/
		/*strBuffer.append(" (SELECT PRACTITIONER_NAME from AM_PRACTITIONER WHERE  ");
		strBuffer.append(" PRACTITIONER_ID='"+Practitioner_Id+"') practitioner_name, ");*/
		//strBuffer.append(" a.curr_practitioner_id, am_get_desc.am_practitioner(a.curr_practitioner_id,'"+locale+"','1') PRACTITIONER_NAME,");
			
		/*Modified the Query for ML-BRU-SCF-1655 as on 05/02/2016 */
		strBuffer.append(" a.curr_practitioner_id,NVL((select am_get_desc.am_practitioner(z.practitioner_id ,'"+locale+"','1')  FROM pr_diagnosis_enc_dtl z, pr_diagnosis y  WHERE z.facility_id = ?    AND z.encounter_id = ? AND z.term_set_id = e.term_set_id  AND z.term_code = e.term_code AND z.occur_srl_no =e.occur_srl_no AND z.patient_id = y.patient_id AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code     AND z.occur_srl_no = y.occur_srl_no),am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME, " );
				
		//strBuffer.append(" a.MODIFIED_BY_ID, ");
		/*11/4/2008*/

		strBuffer.append("decode(a.curr_severity,'D','Moderate','L','Mild','S','Severe','E','Extreme')    severity, ");
		strBuffer.append("decode(a.curr_nature,'A','Actual','P','Potential','W','Wellness') ");
		//Maheshwaran K added curr_onset_type for SKR-SCF-0839 [IN:044168] as on 11/10/2013
		strBuffer.append("nature, TO_CHAR (a.onset_date,'dd/mm/yyyy') onset_date,to_number(to_char(a.onset_date,'YYYYMMDDHH24MISS')) onset_date1,a.curr_onset_type , ");  // Added by mujafar for ML-BRU-CRF-0524
		/*Thursday, March 18, 2010 , a.curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
		//strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','X','Revoked','E','In Error') status, a.curr_priority priority ,"); 
		//Maheshwaran K added for MMS-DM-SCF-0867
		if(diagRevokeStatus)
			{
			strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','E','In Error','X', decode(e.status, 'A', 'Active', 'R', 'Resolved','E', 'In Error')) status, a.curr_priority priority ,"); 	
			}
		else {
		strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','X','Revoked','E','In Error') status, a.curr_priority priority ,"); 	
		}	
	/*	strBuffer.append("NVL((select 'Y' from PR_DIAGNOSIS_STATUS ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and"); 
		strBuffer.append(" term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and "); 
		strBuffer.append(" facility_id=? and encounter_id=? and rownum=1),'N')");*/
		
		strBuffer.append(" (select count(*) from PR_DIAGNOSIS_ENC_DTL ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and"); 
		strBuffer.append(" term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and "); 
		strBuffer.append(" facility_id=? and encounter_id=?  and status in ('A','R')) curr_enc_yn ,");
		strBuffer.append("a.occur_srl_no,");
		strBuffer.append("NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id =a.patient_id "); 
		strBuffer.append(" and term_set_id=a.term_set_id and term_code  =a.term_code and ");
		strBuffer.append("occur_srl_no =a.occur_srl_no  and rownum=1),'N') support_exisist_yn_yn ");
		//<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
		/*Thursday, March 18, 2010 , a.diag_class_code added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
		//Maheshwaran K modified the Query as on 12/09/2013
	 //	strBuffer.append(" , a.anatomical_site , a.applicable_side, a.accession_num ,(select mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')short_desc FROM MR_DIAG_CLASS WHERE diag_class_code = e.diag_class_code) diag_class_short_desc,e.diag_class_code,c.DAGGER_INDEPENDENT_YN,e.NOTIFICATION_CODE,(select  z.diag_class_code||'@|#$&*'||mr_get_desc.mr_diag_class(z.diag_class_code,'en','2')short_desc FROM pr_diagnosis_enc_dtl z   WHERE  z.facility_id='"+operating_facility_id+"' and z.encounter_id="+Encounter_Id+" and z.TERM_SET_ID=e.term_set_id and z.TERM_CODE=e.term_code and   z.OCCUR_SRL_NO=e.OCCUR_SRL_NO) curr_enc_diag_class ");
	 	strBuffer.append(" , a.anatomical_site , a.applicable_side, a.accession_num ,(select mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')short_desc FROM MR_DIAG_CLASS WHERE diag_class_code = e.diag_class_code) diag_class_short_desc,e.diag_class_code,c.DAGGER_INDEPENDENT_YN,(select i.notification_code  FROM pr_diagnosis_enc_dtl i,pr_diagnosis k  WHERE i.facility_id = '"+operating_facility_id+"' AND i.encounter_id =e.encounter_id AND i.term_set_id = e.term_set_id AND i.term_code = e.term_code AND i.occur_srl_no = e.occur_srl_no   AND i.patient_id = k.patient_id AND i.term_set_id = k.term_set_id AND i.term_code = k.term_code AND i.occur_srl_no = k.occur_srl_no ) notification_code,(select  CASE WHEN z.diag_class_code IS  NULL or  z.status='E' then y.diag_class_code ELSE z.diag_class_code                   END ||'@|#$&*'||mr_get_desc.mr_diag_class(CASE WHEN z.diag_class_code IS  NULL or  z.status='E' then y.diag_class_code   ELSE z.diag_class_code  END,'en','2')short_desc FROM pr_diagnosis_enc_dtl z  ,pr_diagnosis y  WHERE  z.facility_id='"+operating_facility_id+"' and z.encounter_id="+Encounter_Id+" and z.TERM_SET_ID=e.term_set_id and z.TERM_CODE=e.term_code and   z.OCCUR_SRL_NO=e.OCCUR_SRL_NO	and z.patient_id=y.patient_id  AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code  AND z.occur_srl_no = y.occur_srl_no	) curr_enc_diag_class, ");
		//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
		strBuffer.append(" (SELECT f.eff_status FROM  MR_TERM_CODE f WHERE f.term_set_id = a.term_set_id AND f.term_code = a.term_code) term_code_status ");
		//Ends NMC-JD-SCF-0259
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
		strBuffer.append(", b.diagnosis_class_mand_yn ");
		/* end of ML-MMOH-CRF-1741 */
				
		//Maheshwaran K added "NOTIFICATION_CODE" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		strBuffer.append(" FROM PR_DIAGNOSIS a , MR_TERM_SET b, MR_TERM_CODE c, PR_DIAGNOSIS_ENC_DTL e ");
		//10/17/2008
		//strBuffer.append(" ,mr_icd_code d ");
		//10/17/2008
		strBuffer.append(" WHERE a.patient_id = ? ");

		strBuffer.append(" and a.patient_id=e.patient_id and a.term_set_id=e.term_set_id and a.occur_srl_no=e.occur_srl_no and  a.term_code  =e.term_code  and a.CURR_ENCOUNTER_ID=e.encounter_id "); //CURR_ENCOUNTER_ID added by Suji Keerthi for PAS-IP- IP Transaction - Discharge - Prepare Discharge Advice - Discharge Diagnosis
		//Maheshwaran K has Removed Facility and onset facility ID condition for ML-BRU-SCF-2132 as on 20-12-2021
		//strBuffer.append("and a.onset_facility_id=e.facility_id ");
		//Ends
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		if(diag_enc_level_yn.equals("N"))
		     strBuffer.append(" and e.status!='E' ");	
		//End TTM-SCF-0167-904499 [IN:061028]
		
		//Added condition for limit to Code Set value
		strBuffer.append(" and exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id=? and term_set_id=a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type=? and term_set_id=a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id=? and encounter_id=?) and term_set_id=a.term_set_id) and (exists (select 1 from MR_TERM_SET_FOR_PRACT ib  where practitioner_id=? and term_set_id=a.term_set_id)  or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id=?))");
		//Ended here
		/*strBuffer.append("and (a.curr_status ='A' or exists (select 1 from PR_DIAGNOSIS_STATUS ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and "); 
		strBuffer.append(" term_code  =a. term_code and occur_srl_no =a.occur_srl_no and ");
		strBuffer.append(" facility_id=? and encounter_id=? and rownum=1))*///Commented for SCR 4807
		strBuffer.append(" and b.term_set_id(+) = a.term_set_id ");
		/*Added by Maheshwaran for the SKR-CRF-0020 as on 04/05/2012*/
		/*Start*/
		strBuffer.append(" and a.curr_status !='E' ");
		/*End*/
		strBuffer.append(" and c.term_set_id(+) =a.term_set_id and c.term_code(+)=a.term_code order by   ");
		
		
			//  Added by mujafar for ML-BRU-CRF-0524 start

				if(headerVal.equals("recDateTime"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  a.added_date desc ");
					else strBuffer.append("  a.added_date asc ");
				}
				else
					if(headerVal.equals("diagProb"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  a.term_code desc ");
					else strBuffer.append("  a.term_code asc ");
				} 
				else
					if(headerVal.equals("diagProbDesc"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  term_code_desc desc ");
					else strBuffer.append("  term_code_desc asc ");
				}
				else
					if(headerVal.equals("status"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  status desc ");
					else strBuffer.append("  status asc ");
				}
				else
					if(headerVal.equals("accuracy"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  accuracy_short_desc desc ");
					else strBuffer.append("  accuracy_short_desc asc ");
				} 
				else
					if(headerVal.equals("onsetDate"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  onset_date1 desc ");
					else strBuffer.append("  onset_date1 asc ");
				}
				else
				{
					strBuffer.append("  a.added_date desc ");
				}
				//  Added by mujafar for ML-BRU-CRF-0524 end
		
		

	
		stmt = con.prepareStatement(strBuffer.toString());
		stmt.setString(1,operating_facility_id);
		stmt.setString(2,Encounter_Id);
		stmt.setString(3,operating_facility_id);
		stmt.setString(4,Encounter_Id);
		stmt.setString(5,operating_facility_id);
		stmt.setString(6,Encounter_Id);
		stmt.setString(7,Patient_Id);
		stmt.setString(8,operating_facility_id);
		stmt.setString(9,practitioner_type);
		stmt.setString(10,operating_facility_id);
		stmt.setString(11,Encounter_Id);
		stmt.setString(12,Practitioner_Id);
		stmt.setString(13,Practitioner_Id);
		//ended here
		//stmt.setString(9,operating_facility_id);
		//stmt.setString(10,Encounter_Id);//Commented for SCR 4807
		rs = stmt.executeQuery();
		probBuffer.append("select a.complaint_id, complaint_desc, a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str, am_get_desc.am_practitioner(a.added_by_id,?,'1') added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date, (SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID =a.complaint_id AND  ENCOUNTER_ID=? AND  FACILITY_ID=?) compl_count from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id=? order by a.added_date desc");
				
		stmt1 = con.prepareStatement(probBuffer.toString());
		stmt1.setString(1,locale);
		stmt1.setString(2,Encounter_Id);
		stmt1.setString(3,operating_facility_id);
		stmt1.setString(4,operating_facility_id);
		stmt1.setString(5,Encounter_Id);
		rs1 = stmt1.executeQuery();
		
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
if(isDiagCatgMand){
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);


					 
		while(rs1.next())
		{
			 complaint_id		= checkForNull(rs1.getString("complaint_id"));
			 complaint_desc		= checkForNull(rs1.getString("complaint_desc"));
			 remarks			= checkForNull(rs1.getString("remarks"));
			 onset_datetime_str = checkForNull(rs1.getString("onset_datetime_str"));
			 onset_datetime_str =DateUtils.convertDate(onset_datetime_str,"DMY","en",locale);
			 complaint_date		= checkForNull(rs1.getString("added_date"));
			 complaint_date     =DateUtils.convertDate(complaint_date,"DMYHM","en",locale);

			 comp_added_by		= checkForNull(rs1.getString("added_by_id"));


			
			
			//block commented. below query merged with the main query to get count of complaint.. for PE

			//String complaint_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID ='"+complaint_id+"' AND  ENCOUNTER_ID='"+Encounter_Id+"' AND  FACILITY_ID='"+operating_facility_id+"'";
			//st = con.createStatement();
			//rset = st.executeQuery(complaint_sql);
			//if(rset != null && rset.next()){

			// end block comment

				if(rs1.getInt("compl_count") == 0){

						if ( k%2 == 0 )
							 classValue = "QRYEVEN" ;
			            else
						    classValue = "QRYODD" ;

			

					out.println("<tr><td class='"+classValue+"'  nowrap>&nbsp;</td>");
					//Added by Jeyachitra - ML-MMOH-CRF 1742
					if(isDeceasedDiagClassDeathRegAppl){
					out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>"); 
					}
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><img src='../../eCommon/images/Problems.gif'>&nbsp;<font size='1'>"+complaint_id+"</font></td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+complaint_desc+"</font>&nbsp;</td>");
					/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					/*End  Bru-HIMS-CRF-024.2*/
					//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
					//Start
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					//End
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+comp_added_by+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+complaint_date+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+onset_datetime_str+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td></tr>");
					k++;

				}

			//}
				//if(rset != null )rset.close();
		}

				

		while(rs.next())
		{
			//11/13/2008 code add for dispaly recorded Date and time.
			recordedDate			= checkForNull(rs.getString("recordedDate"));
			if(!(recordedDate==null || recordedDate.equals("")))
				recordedDateDisp	=	DateUtils.convertDate(recordedDate,"DMYHM","en",localeName);

			term_set_desc			= checkForNull(rs.getString("TERM_SET_DESC"));
			encounter_id1			= rs.getInt("CURR_ENC_YN");
			accur_code_ind		= checkForNull(rs.getString("curr_accuracy_ind"));
			old_encounter_id		= checkForNull(rs.getString("old_encounter_id"));		
			curr_accuracy_code	= checkForNull(rs.getString("curr_accuracy_code"));
			priority						= checkForNull(rs.getString("priority"));
			notifiable_yn				= checkForNull(rs.getString("notifiable_yn"));
			sensitive_yn				= checkForNull(rs.getString("sensitive_yn"));
			curr_practitioner_name      = checkForNull(rs.getString("PRACTITIONER_NAME"));
			term_code_status				= checkForNull(rs.getString("term_code_status"));
			if(isDiagCatgMand){
			diag_category					= checkForNull(rs.getString("diag_category"));//Added by Ajay for TH-KW-CRF-165.1
			diag_category_code					= checkForNull(rs.getString("diag_catg_code"));//Added by Ajay for TH-KW-CRF-165.1
			}
			if(priority.equals("C")) priorityclass = "RED";
			else if(priority.equals("H")) priorityclass = "YELLOW";
			else if(priority.equals("N")) priorityclass = "GREEN";

			//practitioner_name = checkForNull(rs.getString("practitioner_name"));
			/*11/4/2008 ICN 6224  */
			//curr_practitioner_id = checkForNull(rs.getString("MODIFIED_BY_ID"));
			
			//block commented. below query merged with the main query to get pract name.. for PE
			/*  
				curr_practitioner_id	= checkForNull(rs.getString("curr_practitioner_id"));
			String curr_practitioner_sql = "select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME from am_practitioner where PRACTITIONER_ID='"+curr_practitioner_id+"'";
			st = con.createStatement();
			rset = st.executeQuery(curr_practitioner_sql.toString());
			if(rset != null && rset.next())
			{
				curr_practitioner_name = rset.getString("PRACTITIONER_NAME");
			}
			if(rset != null )rset.close();
			*/
			// end block comment for PE
			
			/*11/4/2008 end*/
			if(!sensitive_yn.equals("Y"))
			{
			if(!prev_term_set_id.equals(term_set_desc))
			{
	
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 ){
                classValue = "QRYEVEN" ;
			}else{
                classValue = "QRYODD" ;
			}
//			short_desc					= checkForNull(rs.getString("term_code_desc"));
			term_code					= checkForNull(rs.getString("term_code"));
			term_code_disply			= term_code ;
			diagnosis_remark            = checkForNull(rs.getString("curr_remarks")); //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 and curr_remarks is added to query by Himanshu
			
			if(term_code.equals("*OTH")){
					short_desc = checkForNull(rs.getString("term_code_desc"));
			}else{
					short_desc = checkForNull(rs.getString("short_desc"));
			}
			if(short_desc.equals("")){ 
				short_desc="&nbsp;";
			}
			//if(term_code.equals("*OTH"))
				//term_code_disply        = "" ;
			accuracy_short_desc	= checkForNull(rs.getString("accuracy_short_desc"));
			onset_nature					= checkForNull(rs.getString("nature"));
			severity				= checkForNull(rs.getString("severity"));
			if(severity.equals("")) 
				severity="&nbsp;";
			nature						= onset_nature;
			if(!(nature==null || nature.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				else if(nature.equals("Potential"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				else if(nature.equals("Wellness"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			}
			if(natureLangDesc.equals("")) 
				natureLangDesc="&nbsp;";
			encounter_stage		= checkForNull(rs.getString("ENC_STAGE"));
			if(encounter_stage.equals("")) 
				encounter_stage="&nbsp;";

			if(!(encounter_stage==null || encounter_stage.equals("&nbsp;")))
			{
				if(encounter_stage.equals("A"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				else if(encounter_stage.equals("I"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				else if(encounter_stage.equals("D"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	
			}
	
			if(nature.equals("")) 
				nature="&nbsp;";
			onset_date					=checkForNull(rs.getString("onset_date")); 
			curr_onset_type					=checkForNull(rs.getString("curr_onset_type"));//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			if(!(onset_date==null || onset_date.equals("")))
				onset_date_converted	=	DateUtils.convertDate(onset_date,"DMY","en",localeName);

			onset_status					= checkForNull(rs.getString("status")); 
			status	=onset_status;
			//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			//Start
			if(severity.equals("")) 
				severity_str="&nbsp;";
			if(!(severity==null || severity_str.equals("&nbsp;")))
			{
				if(severity.equals("Moderate"))
				severity_str="D";
				if(severity.equals("Mild"))
				severity_str="L";
				if(severity.equals("Severe"))
				severity_str="S";
				if(severity.equals("Extreme"))
				severity_str="E";
			}
			if(encounter_stage.equals("")) 
				encounter_stage_str="&nbsp;";
			if(!(encounter_stage==null || encounter_stage_str.equals("&nbsp;")))
			{
				if(encounter_stage.equals("Admission"))
				encounter_stage_str="A";
				if(encounter_stage.equals("Intermediate"))
				encounter_stage_str="I";
				if(encounter_stage.equals("Discharge"))
				encounter_stage_str="D";
			}
	
			if(nature.equals("")) 
				nature_str="&nbsp;";
			if(!(nature==null || nature_str.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
				nature_str = "A";
				if(nature.equals("Potential"))
				nature_str = "P";
				if(nature.equals("Wellness"))
				nature_str = "W";
			}
			//end
			if(status.equals("Active"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			else if(status.equals("Resolved"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
			else if(status.equals("Revoked"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels");
			else if(status.equals("In Error"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

			occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
				//11/13/2008 If the status is resolved and in error we are assign to blank as per spec.
			/*if(status.equals("Resolved")||status.equals("In Error")){
				recordedDate="&nbsp";
			}
			*/
			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="(D)";
			else
				Diff_status="";*/
////start			

					term_set_id							= checkForNull(rs.getString("term_set_id")); // Added by mujafar for ML-MMOH-CRF-1281
				if(isMultiDescAppl && term_set_id.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				short_desc = checkForNull(rs.getString("term_code_desc"));



				actual_short_desc=short_desc;// included for the SCF - SRR20056-scf-8582 
				short_desc=short_desc.replaceAll("'","''");// included for the SCF - SRR20056-scf-8582 
				if(!term_code.equals("*OTH")){
					 linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND  TERM_CODE =? and OCCUR_SRL_NO=?";
					/*Wednesday, February 10, 2010 , OCCUR_SRL_NO added for SRR20056-SCF-4238 IN019107*/
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,term_code);
					stmt2.setString(4,occur_srl_no);
				}
				else
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,short_desc);
					stmt2.setString(4,occur_srl_no);
				}
			//st = con.createStatement();
			//rset = st.executeQuery(linkviewcnt_sql);
			rset2=stmt2.executeQuery();
			if(rset2 != null && rset2.next())
			{
				//if(rset.getInt(1) == 0)
				//{
					view_cnt=rset2.getInt(1);


				//}
			}
				////end

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status			="<img src='../../eCommon/images/Differentials.gif'></img>";
			else
				Diff_status			="&nbsp;";*/

			/*
			term_set_id							= checkForNull(rs.getString("term_set_id")); commented and added above for ML-MMOH-CRF-1281
				if(isMultiDescAppl && term_set_id.equals("ICD10") )
				short_desc = checkForNull(rs.getString("term_code_desc"));
			*/
			
			preoperative= checkForNull(rs.getString("pre_operative"));// this line Added for this CRF  [PMG2012-CRF-0030]
			
			//Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related=checkForNull(rs.getString("accession_num_work_related"));
			accession_num_notifiable=checkForNull(rs.getString("accession_num_notifiable"));
			Support_exisist_yn_YN				= checkForNull(rs.getString("Support_exisist_yn_YN"));

			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				isCurrentEncounter				= "N";
			else
				isCurrentEncounter				= "Y";			
				anatomical_site					= checkForNull(rs.getString("anatomical_site"));
				applicable_side					= checkForNull(rs.getString("applicable_side"));
				pat_accession_num				= checkForNull(rs.getString("accession_num"));
				/*Thursday, March 18, 2010 ,added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				diag_class_code					= checkForNull(rs.getString("diag_class_code"));
				curr_status						= checkForNull(rs.getString("curr_status"));
				notifiable_code						= checkForNull(rs.getString("NOTIFICATION_CODE"));//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				/**/
				diag_classification				= checkForNull(rs.getString("diag_class_short_desc"));
				curr_enc_diag_class				= checkForNull(rs.getString("curr_enc_diag_class"));
				//term_code_status				= checkForNull(rs.getString("term_code_status"));

				//if(diag_enc_level_yn.equals("N")){
					if(curr_enc_diag_class.equals("@|#$&*")){
						diag_classification="";
						diag_class_code="";
					}else if(!curr_enc_diag_class.equals("")){
						
						int indx=curr_enc_diag_class.indexOf("@|#$&*");
						
						diag_class_code=curr_enc_diag_class.substring(0,indx);
						diag_classification=curr_enc_diag_class.substring(indx +6,curr_enc_diag_class.length());
					}
				//}
				dagger_independent_yn	= checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));//Added For SRR-CRF-303.2
				diagClassMandYn	= checkForNull(rs.getString("diagnosis_class_mand_yn"));//Added by Ajay Hatwate for ML-MMOH-CRF-1741
			/*
				F.Y.I
				Added For Added For SRR-CRF-303.2 on 1/27/2010.
				1.If the value of  the DAGGER_INDEPENDENT_YN =='Y' the indicatior of  the asterik will be visible.
			*/
				if(dagger_independent_yn.equals("Y")){
					disp_dagger_dep_ind	=	"display:inline";
				}else{
					disp_dagger_dep_ind	=	"display:none";
				}
				if(diag_classification.equals(""))
					diag_classification_display="&nbsp;";
				else
					diag_classification_display=diag_classification;
				if(applicable_side.equals("")) 
				applicable_side="&nbsp;";

				if(!(applicable_side==null || applicable_side.equals("&nbsp;")))
				{
				if(applicable_side.equals("L"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
				else if(applicable_side.equals("R"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
				else if(applicable_side.equals("B"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
				else if(applicable_side.equals("N"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");	
				}
			//
			out.println("<tr>");
			
			short_desc=short_desc.replaceAll("'","\\\\'");// included for the SCF - SRR20056-scf-8582 
			if(encounter_id1>0) {
			//if(encounter_id1.equals("Y")){	
				out.println("<td  nowrap class='"+classValue+"'><img src='../../eCommon/images/CurrentEncounter.gif'></td>");

			}else{	
				/*5/20/2009 Incident IN010259[1].2(reopen)*/
				/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				if(status.equals("Active")){
					//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
					if(term_code_status.equals("E"))
					{
					//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013
					String url2="<td  class='"+classValue+"' nowrap><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"','"+diag_category_code+"', '"+diagClassMandYn+"')  \">"+not_curr_enc+"</a>&nbsp;</td>";//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
					out.println(url2);
					}
					else
						{
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");	
						}
				}else{
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");
				}
			}
			//Added by Jeyachitra - ML-MMOH-CRF 1742 starts
			if(isDeceasedDiagClassDeathRegAppl)
			{
			try
			{
				
				pstmt = con.prepareStatement("select * from mr_rec_diag_audit_trial where patient_id=? and term_Set_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=?");
				pstmt.setString(1, Patient_Id);
				pstmt.setString(2, term_set_id);
				pstmt.setString(3, Encounter_Id);
				pstmt.setString(4, term_code);
				pstmt.setString(5, occur_srl_no);
				pstmt.setString(6, operating_facility_id);
				res= pstmt.executeQuery();
				
				if(res!=null && res.next())
					out.println("<td class='" + classValue + "' nowrap><font size='1'><a href='javascript:displayAuditTrial(\"" + Patient_Id + "\",\"" + term_code + "\",\"" + term_set_id + "\",\"" + Encounter_Id + "\",\"" + operating_facility_id + "\",\"" + occur_srl_no + "\")'>Audit Trail</a></font></td>");
				else
					out.println("<td class='"+classValue+"' nowrap>&nbsp;</td>");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(res!=null) res.close();
				if(pstmt!=null) pstmt.close();
			}
			}//Added by Jeyachitra - ML-MMOH-CRF 1742 end
			if(!pat_accession_num.equals("")){
				out.println("<td class='"+classValue+"'  nowrap><font color='blue' ><b><a href=\"javascript:callOHLinkedDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+Encounter_Id+"','"+pat_accession_num+"','"+oh_chart_num+"')\">C</a></font></td>");
			}else{
				out.println("<td  class='"+classValue+"' nowrap>&nbsp;</td>");
			}
			//out.println("<td width='2%' class='"+priorityclass+"'>&nbsp;</td>");
			if(status.equals("Active") && accur_code_ind.equals("U")){
				//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></td>");
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
			}
    			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+term_set_desc+"</font></td>");
				//out.println("<script>alert(\""+view_cnt+"\");</script>");
			//out.println("<script>alert(\""+term_code_disply+"\");</script>");
			if(view_cnt !=0){
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(term_code_disply));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;<font size='1'>"+term_code_disply+"</font>&nbsp;</td>");
			}
			
           /*Below line Modified for this CRF [PMG2012-CRF-0030]*/
		  //Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		  //Suresh M passed the diag_class_code in the callDetails Method
		  	//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
			if(term_code_status.equals("E"))
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"','"+status+"','"+notifiable_code+"','"+diag_class_code+"','"+p_called_from_widget+"','"+called_from_ot+"','"+diag_category_code+"')\">"+actual_short_desc+"</a>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='"+disp_dagger_dep_ind+"'>&nbsp;</font></td>");// included for the SCF - SRR20056-scf-8582  //CHL-CRF- 0008 - IN:001472 
				}
			else 
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+short_desc+"</font></td>");	
				}
			//Ends
			
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes.toString())));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(isCurrentEncounter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(old_encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(diag_classification));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);

			/*Below line added for this Bru-HIMS-CRF-024.2*/
			//Added for this CRF Bru-HIMS-CRF-024.2			
			if(!accession_num_work_related.equals("")){
				//Added by Sangeetha for ML-MMOH-CRF-0547
				if(legendChangeAsTypesOfNotiForm)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypesofNotificationReport.label","mr_labels");
				else if(notifiableLegndChgApplYn)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
				else
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WorkRelatedReport.label","mr_labels");
			}
			else
			accession_num_notifiable_display="&nbsp;"; 
						
		    out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:NotifiableReport('"+accession_num_work_related+"','"+Patient_Id+"','"+Encounter_Id+"','"+operating_facility_id+"')\">"+accession_num_notifiable_display+"</a></font></td>");  
			
			//End Bru-HIMS-CRF-024.2
			//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
			//Start
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+status_lbl+"</font></td>");
			//End
			
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started
			
			diagnosis_remark=diagnosis_remark.trim();
			if(!diagnosis_remark.equals(""))
			{
					
						diagnosis_remark = diagnosis_remark.replace("\'", "\\\'"); 
						out.println("<td  class='"+classValue+"'  style='text-align:center' nowrap><font size='1'><a href=\"javascript:showDiagnosisRemark('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+occur_srl_no+"')\">View</a></font></td>");
					
			}
			else
			{
						out.println("<td  class='"+classValue+"' nowrap><font size='1'></font></td>");

			
			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End
			
			
			/*below line Added for this CRF  [PMG2012-CRF-0030] */
			String pre_oper="";
			if(preoperative.equals("Y"))		  
                 pre_oper=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreOpreativedesc.label","mr_labels");
            else
			     pre_oper="&nbsp;";
			
		   
		    out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+pre_oper+"</font></td>");  
			// End this CRF  [PMG2012-CRF-0030]			
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+applicable_side+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+diag_classification_display+"</font></td>");
			//Added by Ajay for TH-KW-CRF-165.1
			//Start
			if(isDiagCatgMand){
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+diag_category+"</font></td>");
			}
			//End CRF TH-KW-CRF-165.1
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+curr_practitioner_name+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+recordedDateDisp+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+accuracy_short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+nature+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+encounter_stage+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+natureLangDesc+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+severity+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+onset_date_converted+"</font></td>");
			//Maheshwaran K commented below line for the SKR-CRF-0020 as on 10/07/2013
			//out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+status_lbl+"</font></td>");		
			
			if(Support_exisist_yn_YN.equals("Y"))
			{
			out.println("<td class='"+classValue+"'  nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + term_code+"','"+occur_srl_no+"','"+Patient_Id+"','"+term_set_id+"','"+(java.net.URLEncoder.encode(short_desc))+"("+term_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"'  nowrap>&nbsp<font size=1></font></td>");
			}

			out.println("</tr>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
			}
			else if(f_authorize_yn.equals("Y"))
			{
				
					if(!prev_term_set_id.equals(term_set_desc))
				{
	
	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);

			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
             else
                classValue = "QRYODD" ;

			/*short_desc					= checkForNull(rs.getString("term_code_desc"));
			if(short_desc.equals("")) 
				short_desc="&nbsp;";*/
			 //Above line commented this incident  [IN:038488]	

			term_code					= checkForNull(rs.getString("term_code"));
			term_code_disply			= term_code ; 
			 //Added Below line for this incident [IN:038488]
			if(term_code.equals("*OTH")){
					short_desc = checkForNull(rs.getString("term_code_desc"));
			}else{
			
			short_desc = checkForNull(rs.getString("short_desc")); 
			}
				 
				 term_set_id							= checkForNull(rs.getString("term_set_id"));  //  added by mujafar for ML-MMOH-CRF-1281				 
				if(isMultiDescAppl && term_set_id.equals("ICD10") ) 
				short_desc = checkForNull(rs.getString("term_code_desc"));

			if(short_desc.equals("")) 
				short_desc="&nbsp;";
			preoperative= checkForNull(rs.getString("pre_operative"));// this line Added for this CRF  [PMG2012-CRF-0030]	

           /*below line Added for this CRF  [PMG2012-CRF-0030] */
			String pre_oper="";
			if(preoperative.equals("Y"))		  
                 pre_oper=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreOpreativedesc.label","mr_labels");
            else
			     pre_oper="&nbsp;";   
			
			//Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related=checkForNull(rs.getString("accession_num_work_related"));
			accession_num_notifiable=checkForNull(rs.getString("accession_num_notifiable"));
			if(!accession_num_work_related.equals("")){
				//Added by Sangeetha for ML-MMOH-CRF-0547
				if(legendChangeAsTypesOfNotiForm)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypesofNotificationReport.label","mr_labels");
				else if(notifiableLegndChgApplYn)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
				else
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WorkRelatedReport.label","mr_labels");
			}
			else
			accession_num_notifiable_display="&nbsp;";  
			
			//if(term_code.equals("*OTH"))
				//term_code_disply        = "" ;
			accuracy_short_desc			= checkForNull(rs.getString("accuracy_short_desc"));
			onset_nature				= checkForNull(rs.getString("nature"));
			nature						=onset_nature;
			severity					= checkForNull(rs.getString("severity"));
			if(severity.equals("")) 
				severity="&nbsp;";
			
			encounter_stage				= checkForNull(rs.getString("ENC_STAGE"));
			if(encounter_stage.equals("")) 
				encounter_stage="&nbsp;";

			if(!(encounter_stage==null || encounter_stage.equals("&nbsp;")))
			{
				if(encounter_stage.equals("A"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				else if(encounter_stage.equals("I"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				else if(encounter_stage.equals("D"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	
			}
	
			if(nature.equals("")) 
				nature="&nbsp;";
			if(!(nature==null || nature.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				else if(nature.equals("Potential"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				else if(nature.equals("Wellness"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			}
			if(natureLangDesc.equals("")) 
				natureLangDesc="&nbsp;";
			onset_date					=checkForNull(rs.getString("onset_date")); 
			if(!(onset_date==null || onset_date.equals("")))
				onset_date_converted	=	DateUtils.convertDate(onset_date,"DMY","en",localeName);

			onset_status					= checkForNull(rs.getString("status")); 
			status	=onset_status;
			//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			//Start
			if(severity.equals("")) 
				severity_str="&nbsp;";
			if(!(severity==null || severity_str.equals("&nbsp;")))
			{
				if(severity.equals("Moderate"))
				severity_str="D";
				if(severity.equals("Mild"))
				severity_str="L";
				if(severity.equals("Severe"))
				severity_str="S";
				if(severity.equals("Extreme"))
				severity_str="E";
			}
			if(encounter_stage.equals("")) 
				encounter_stage_str="&nbsp;";
			if(!(encounter_stage==null || encounter_stage_str.equals("&nbsp;")))
			{
				if(encounter_stage.equals("Admission"))
				encounter_stage_str="A";
				if(encounter_stage.equals("Intermediate"))
				encounter_stage_str="I";
				if(encounter_stage.equals("Discharge"))
				encounter_stage_str="D";
			}
	
			if(nature.equals("")) 
				nature_str="&nbsp;";
			if(!(nature==null || nature_str.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
				nature_str = "A";
				if(nature.equals("Potential"))
				nature_str = "P";
				if(nature.equals("Wellness"))
				nature_str = "W";
			}
			//end
			if(status.equals("Active"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			else if(status.equals("Resolved"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
			else if(status.equals("Revoked"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels");
			else if(status.equals("In Error"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

			occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="(D)";
			else
				Diff_status="";*/

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="<img src='../../eCommon/images/Differentials.gif'></img>";
			else
				Diff_status="&nbsp;";*/
				if(!term_code.equals("*OTH"))
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE =? and OCCUR_SRL_NO=?";
					
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,term_code);
					stmt2.setString(4,occur_srl_no);
				}
				else
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,short_desc);
					stmt2.setString(4,occur_srl_no);
				}
			//st = con.createStatement();
			//rset = st.executeQuery(linkviewcnt_sql);


			rset2=stmt2.executeQuery();

			if(rset2 != null && rset2.next())
			{
				//if(rset.getInt(1) == 0)
				//{
					view_cnt=rset2.getInt(1);


				//}
			}


			term_set_id = checkForNull(rs.getString("term_set_id"));
			Support_exisist_yn_YN = checkForNull(rs.getString("Support_exisist_yn_YN"));
			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				isCurrentEncounter = "N";
			else
				isCurrentEncounter = "Y";			
			
				anatomical_site = checkForNull(rs.getString("anatomical_site"));
				applicable_side = checkForNull(rs.getString("applicable_side"));
				pat_accession_num = checkForNull(rs.getString("accession_num"));
				/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				diag_class_code = checkForNull(rs.getString("diag_class_code"));
				curr_status		= checkForNull(rs.getString("curr_status"));
				notifiable_code						= checkForNull(rs.getString("NOTIFICATION_CODE"));//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				/**/
				diag_classification = checkForNull(rs.getString("diag_class_short_desc"));
				curr_enc_diag_class				= checkForNull(rs.getString("curr_enc_diag_class"));

				//if(diag_enc_level_yn.equals("N")){
					if(curr_enc_diag_class.equals("@|#$&*")){
						diag_classification="";
						diag_class_code="";
					}else if(!curr_enc_diag_class.equals("")){
						
						int indx=curr_enc_diag_class.indexOf("@|#$&*");
						
						diag_class_code=curr_enc_diag_class.substring(0,indx);
						diag_classification=curr_enc_diag_class.substring(indx +6,curr_enc_diag_class.length());
					}
				//}

				if(diag_classification.equals(""))
					diag_classification="&nbsp";
				if(applicable_side.equals("")) 
				applicable_side="&nbsp;";

				if(!(applicable_side==null || applicable_side.equals("&nbsp;")))
				{
				if(applicable_side.equals("L"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
				else if(applicable_side.equals("R"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
				else if(applicable_side.equals("B"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
				else if(applicable_side.equals("N"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");	
				}

				
			//
			out.println("<tr>");
			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				out.println("<td nowrap class='"+classValue+"'><img src='../../eCommon/images/CurrentEncounter.gif'></td>");
			else
				{	/*5/20/2009 Incident IN010259[1].2(reopen)*/
					/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
					if(status.equals("Active"))
					{
						//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
						if(term_code_status.equals("E"))
							{
							out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc.replaceAll("'","\\\\'")+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"','"+diag_category_code+"', '"+diagClassMandYn+"')\">"+not_curr_enc+"</a>&nbsp;</td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013	
							}
						else 
							{
							out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"</td>");
							}
						//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013 Added Bru-HIMS-CRF-024.2
					//	String url="<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"')\">"+not_curr_enc+"</a>&nbsp;</td>";//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc.replaceAll("'","\\\\'")+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"')\">"+not_curr_enc+"</a>&nbsp;</td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//out.println(url);
						//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"')\">"+not_curr_enc+"</a>&nbsp;</td>");
					}
					else
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");
				}

			if(!pat_accession_num.equals(""))
				out.println("<td class='"+classValue+"' nowrap ><font color='blue' ><b><a href=\"javascript:callOHLinkedDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+Encounter_Id+"','"+pat_accession_num+"','"+oh_chart_num+"')\">C</a></font></td>");
			else
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");

			//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></td>");
			if(status.equals("Active") && accur_code_ind.equals("U"))
			{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
			else
			{
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");

			}


			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+term_set_desc+"</font></td>");
			
			//out.println("<script>alert(\""+view_cnt+"\");</script>");
			//out.println("<script>alert(\""+term_code_disply+"\");</script>");

			if(view_cnt !=0){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(term_code_disply));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
			else
			{
				out.println("<td class='"+classValue+"'  nowrap>&nbsp;<font size='1'>"+term_code_disply+"</font>&nbsp;</td>");

			}

			
			//out.println("<td width='2%' class='"+priorityclass+"'>&nbsp;</td>");
			//out.println("<td class='"+classValue+"' nowrap ><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"')\">"+short_desc+"</a></font>&nbsp;&nbsp;<font color='blue' size='1'><b></b></font></td>");
			
			//9/11/2009
			//Suresh M passed the diag_class_code in the callDetails Method
			//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
			if(term_code_status.equals("E"))
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"','"+status+"','"+notifiable_code+"','"+diag_class_code+"','"+diag_category_code+"')\">"+short_desc+"</a></font></td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				}
			else
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+short_desc+"</a></font></td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013	
				}

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes.toString())));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(isCurrentEncounter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(old_encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(diag_classification));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
        
            /*Below line added for this Bru-HIMS-CRF-024.2*/
			// String notifyreport=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
			 //out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=javascript:callNotifiableNotes()>"+accession_num_notifiable_display+"</a></font></td>"); 
			out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:NotifiableReport('"+accession_num_work_related+"','"+Patient_Id+"','"+Encounter_Id+"','"+operating_facility_id+"')\">"+accession_num_notifiable_display+"</a></font></td>");  
			//End Bru-HIMS-CRF-024.2

			//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
			//Start
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+status_lbl+"</font></td>");
			//End
			
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started (added for sensitive case)
					
			diagnosis_remark            = checkForNull(rs.getString("curr_remarks")); //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023
			diagnosis_remark=diagnosis_remark.trim();
			if(!diagnosis_remark.equals(""))
			{
						diagnosis_remark = diagnosis_remark.replace("\'", "\\\'"); 
						out.println("<td  class='"+classValue+"'  style='text-align:center' nowrap><font size='1'><a href=\"javascript:showDiagnosisRemark('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+occur_srl_no+"')\">View</a></font></td>");
					
			}else
			{
						out.println("<td  class='"+classValue+"' nowrap><font size='1'></font></td>");
			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End
			
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+pre_oper+"</font></td>"); //Added this line for this incident [IN:038488]
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+applicable_side+"</font></td>");
			
			
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+diag_classification+"</font></td>");
			/*if(practitioner_name.equals(""))
					practitioner_name="&nbsp";
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+practitioner_name+"</font></td>");*/
			
			if(curr_practitioner_name.equals(""))
					curr_practitioner_name="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+curr_practitioner_name+"</font></td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+recordedDateDisp+"</font></td>");

			if(accuracy_short_desc.equals(""))
					accuracy_short_desc="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+accuracy_short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+nature+"</font></td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+encounter_stage+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+natureLangDesc+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+severity+"</font></td>");

			if(onset_date_converted.equals(""))
					onset_date_converted="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+onset_date_converted+"</font></td>");
		//	out.println("<td class='"+classValue+"' nowrap><font size='1'>"+status_lbl+"</font></td>");		
			
			if(Support_exisist_yn_YN.equals("Y"))
			{
			out.println("<td class='"+classValue+"' nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + term_code+"','"+occur_srl_no+"','"+Patient_Id+"','"+term_set_id+"','"+short_desc.replaceAll("'","\\\\'")+"("+term_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"' nowrap>&nbsp<font size=1></font></td>");
			
			//out.println("<td width='2%' class='"+classValue+"'>&nbsp;</td>")
			}

			out.println("</tr>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
			
									
			}
		natureLangDesc="";//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013	
		}
		
		  if(rs!=null)		rs.close();
		  if(stmt!=null)    stmt.close();

      
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(headerVal));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(request.getQueryString()==null?"":request.getQueryString()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block74Bytes, _wl_block74);
            _bw.write(_wl_block75Bytes, _wl_block75);
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(diag_classification));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(diag_class_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(termCodeEffStatus));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(enableLinktoCurrEncS));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(crossChkMandFldsYn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(age));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(isCurrentEncounter));
            _bw.write(_wl_block97Bytes, _wl_block97);

}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisDescription.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreOpreative.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicableSide.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisClassification.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisCategory.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DoneBy.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.recordeddate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncounterStage.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncounterStage.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ExternalCause.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}

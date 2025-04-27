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
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationverification extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationVerification.jsp", 1734671114004L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /* \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] \n09/08/2019      IN070605\t\t prathyusha  MMS-KH-CRF-0028\n13/08/2019      IN070451\t\t Manickavasagam J  \t\tMMS-KH-CRF-1408\n13/08/2019      IN070605\t\t Devindra           MMS-KH-CRF-0028  \n10/09/2019\t  \tIN070605\t     \tprathyusha \t\t  \t\t\t\t\t\t\t\t\t MMS-KH-CRF-0028 \n29/10/2019\t\tIN071533\t\t\tShazana\t\t\tSKR-SCF-1275\n30/11/2019\t\tIN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]\n12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032\n30/11/2020\t8659\t\t\t\t\t\tShazana\t\t\t\tMMS-MD-SCF-0141 \t\n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<script>\n\t\t\tfunction CheckPatReqd(Obj){\n\t\t\t\tif(Obj.checked==true)\n\t\t\t\t\tObj.value=\"C\";\n\t\t\t\telse\n\t\t\t\t\tObj.value=\"N\";\n\t\t\t}\n\t\t</script>\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t<style> <!-- Added for MMS-KH-CRF-0013 - Start -->\n\tTD.DINTERACN{ \n\t\tBACKGROUND-COLOR:pink;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:15px;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n        } \n\t\t<!-- Added for MMS-KH-CRF-0013 - End -->\n\t\t\n\t\t\n\t\t\n\tTD.ALLERGY_REMARKS{\n\t\tBACKGROUND-COLOR:#CC0000;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 1px solid;\n  \t\tBORDER-LEFT: #663300 1px solid;\n\t\tBORDER-RIGHT:#663300 1px solid;\n\t\tBORDER-TOP: #663300 1px solid;\n\t\theight:10;\n\t\tbackground-image : url(\'../../ePH/images/red.jpg\');\n\t  }\n\t  \nTD.DOSELIMIT_REMARKS{\n\t\tBACKGROUND-COLOR:#FFCC66;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:10;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n\t        background-image : url(\'../../ePH/images/yellow.jpg\');\n        }\n\nTD.CURRENTRX_REMARKS{\n\t\tBACKGROUND-COLOR:#6699FF;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:10px;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t\tBORDER-LEFT: #663300 0px solid;\n\t\tBORDER-RIGHT: #663300 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\tbackground-image : url(\'../../ePH/images/blue.jpg\');\n\t}\n\tTD.INTARACTION_REMARKS{ \n\t\tBACKGROUND-COLOR:pink;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:15px;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n\t\t\tbackground-image : url(\'../../ePH/images/Pink.jpg\');\n        } \n\t TD.EXPIRED_ORDER{    /* Added for MOHE-CRF-0032 */\n\t\t\tBACKGROUND-COLOR:#FFA500;  //code modified for MOHE-CRF-0032\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\theight:10px;\n\t\t\tBORDER-STYLE: solid;\n\t}   \n\t/* Added for aakh-crf-0140 */\n\tTD.ABUSE_REMARKS{ \n\t\tBACKGROUND-COLOR:purple;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:15px;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n\t\t\t\n        }   \n\t\t\tTD.PATIENTMED{    /* Added for TH-KW-CRF-0002 */\n\t\t\tBACKGROUND-COLOR:#87CEEB; //code modified for MOHE-CRF-0032\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\theight:10px;\n\t\t\tBORDER-STYLE: solid;\n\t}                       \n\t</style> \n\t\t<form name=\"DispMedicationAllStages\" id=\"DispMedicationAllStages\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' align=\"center\" border=\"1\" id=\"verificationTable\">\n\t\t\t\t<tr>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n                              <td class= \"COLUMNHEADER\" width=\"4%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t   <input type=\"checkbox\" value=\"Y\" name=\"selectAll\" id=\"selectAll\" checked onClick=\"selectAllRcordsDeliver(this,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" ><!--MMS-KH-CRF-0016.1-->\n\t\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\t \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"10%\"  style=\"font-size:9px\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> <!-- 4% changed to 10% for MMS-KH-CRF-0013 --> \n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"5%\"  style=\"font-size:9px\">&nbsp;</td>\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"2%\"  style=\"font-size:9px\" >&nbsp;</td><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9px\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 end -->\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"41%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"2%\"  style=\"font-size:9px\" >&nbsp;</td>\t\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"2%\"  style=\"font-size:9px\" >&nbsp;</td>\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n                       <!-- Added for ML-BRU-CRF-0469 start -->\n                      ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n                       <td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n                       ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t   <!-- Added for ML-BRU-CRF-0469 end --> \n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;&nbsp;</td> \n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"10%\"  style=\"font-size:9px\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<td  class=\"COLUMNHEADER\" style=\"font-size:9px\" colspan=2>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' name=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\t<td> \n\t\t\t\t\t\t<input type=\"checkbox\" name=\"verifyChecked_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"verifyChecked_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onclick=\"setValue(this)\" value=\"Y\" checked >\n\t\t\t\t\t</td>\n\t\t\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="                                      <input type=\"hidden\" name=\"verifyChecked_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=\"Y\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\" >\n\t\t\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t\t\t\t\t\t\t <INPUT TYPE=\"hidden\" id=\'ALLERGY_VALUE";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' name=\'ALLERGY_VALUE";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\"Y\" /><!-- added for IN070605-->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\">&nbsp;</td><!-- 33% changed to 20% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'ALLERGY_VALUE";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" />\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t <INPUT TYPE=\"hidden\" id=\'ALLERGY_VALUE";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\"Y\" />\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td><!-- 33% changed to 20% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\"Y\" />\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\">&nbsp;</td> <!-- ceiling dose added for ML-MMOH-CRF-1408 and  ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'  name=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' value=\"Y\" />\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' width=\"20%\" style=\"cursor:pointer\" onClick=\"callActiveOrders(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\">&nbsp;</td><!-- 33% changed to 25% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td><!-- 33% changed to 25% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' value=\"Y\" /><!-- added  FOR IN070605 -->\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'id=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showDispInractionDtl(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t    \t   <td class=\"white\" width=\"20%\">&nbsp;</td> \n\t\t\t\t\t\t\t\t    \t   <INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" id=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' value=\"Y\" /><!-- added  FOR IN070605 -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t               ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'  width=\"20%\" style=\"cursor:pointer\" onClick=\"showAbuseDetails(\'\',\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\',\'clicking\')\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"   width=\"3%\" nowrap onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\')\">\n\t\t\t\t\t\t\t\t<!--<input type=\"checkbox\" name=\"hold";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"hold";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');notifyChange()\" ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" value=\"Y\"><br><label style=\"cursor:pointer;color:blue;font-size:9px;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" onClick=\"callReason(document.DispMedicationAllStages.hold";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =",\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\');notifyChange()\" id=\'hold_remarks_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>Remarks</label>\t-->\n\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9px;\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',\'V\');notifyChange()\" id=\'hold_remarks_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</label>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"drug_code";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"fromdb_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"fromdb_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"hold";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" style=\'display:none\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold_status";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"hold_status";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" width=\"2%\" >    <!-- Added for Bru-HIMS-CRF-093-DD1[IN047223]  -->\n\t\t\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 start -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\n\t\t\t\t\t\t\t\t<td style=\"background-color: #00FFFF\" >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\n\t\t\t\t\t\t\t\t<td style=\"background-color: #7CFC00\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" style=\"font-size:9px;overflow: auto;\" width=\"41%\" \n\t\t\t\t\t\t\tonMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\')\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"showDrugMasterValues(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"  ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" onclick=\"showDrugDetails(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\',\'\',\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\');\" id=\"drug_desc";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&nbsp;";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</label>  <!--  , \'patient_id\' added for [IN:035667] --><!-- Added for 41282  -->\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/AddedIngredient.gif\' height=\'15\' width=\'15\' style=\"cursor:pointer;\" title=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' onClick=\"displayConstInPPN(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\')\"></img>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\')\"> <!-- Passing UTF-8 for Drug name By Sandhya -->\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=20  width=20 onClick=\"showImage(\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\')\">\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'   title=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' onclick= \"callADRdetails(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\')\"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->\n ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\');\" >\n\t\t\t\t\t\t\t\t<label id=\'lblDiscCancelledOrders_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' title=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;<img id=\'discCancelledOrders_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' src=\"../../ePH/images/DiscCancelledIndicator.png\" onclick=\'callDiscCancelledOrders(\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\", \"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\");\'></label>\n\t        \t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</b>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=\"cursor:pointer;color:";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onclick=\"callDrugDetails(\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\',\'\');changeColor(document.frmDispQueueManagementAllocatePrescDetails,this);\" id=\"alte_drug_desc";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="&nbsp;&nbsp;</label><!-- code \'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\', removed for TTM-SCF-0096[IN048808]-->\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/uparrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\');\" valign=\"center\" title=\'Taper Dose\' style=\"cursor:pointer\"height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/downarrow.gif\"onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\');\" valign=\"center\" title=\'Taper Dose\' style=\"cursor:pointer\" height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/MultiFrequency.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\');\" valign=\"center\" title=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' style=\"cursor:pointer\" height=\'20\' width=\'20\' ></img>\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="   <!--Added for RUT-CRF-0088 [IN036978] -->\n\t\t\t\t\t\t\t\t\t<label>-";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="&nbsp;&#40;";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pat_reqd_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' id=\'pat_reqd_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" value=\'C\' disabled onclick=\"CheckPatReqd(this)\"></td>\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=pat_reqd_";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" disabled value=\'\'></td>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" valign=\'center\' name=\'pat_reqd_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' onclick=\'CheckPatReqd(this)\'>\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in displayInstructions regarding incident num:25276 ==By sandhya -->  \n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" style=\"font-size:9px\"  >\n\t\t\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" id=\'drugRemarks_";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' title=\'\' valign=\"center\"style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\',\'Y\')\" ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" ><!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar drug_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\');\n\t\t\t\t\t\t\t\teval(document.getElementById(\"drugRemarks_\"+\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\')).title= drug_remarks ;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" style=\"font-size:9px\" title=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/exceed.gif\" valign=\"center\"></td>\t\t\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" style=\"font-size:9px\" width=\"10%\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\')\">&nbsp;";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="&nbsp;(";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =")</td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" width=\"10%\" style=\"font-size:9px\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =")</td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/--->\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\t \n                                    <!-- Added for ML-BRU-CRF-0469 start -->\n                                   ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n                                    <td  class=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" id=\'gross_amount_str_";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'><center>";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</center></td>\n                                   ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n                                    <!-- Added for ML-BRU-CRF-0469 end   -->\n\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" id=\'gross_charge_amount_str_";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</center></td>\n\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" id=\'groos_pat_payable_str_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</center></td>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" id=\"override_allowed_yn_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"  value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" id=\"excl_incl_ind_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" id=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\"value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" id=\"approval_reqd_yn_";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"     value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" id=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" id=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\"   value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 start -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_amount_";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" id=\"gross_amount_";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 end -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" id=\"drug_color_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"   value=\'black\'>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" ><a href=\"javascript:callIncludeExclude(\'V\',\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\',\';\',\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\');\" id=\"include_exclude\"  style=\"font-size:9px;\">";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="?</a></td>\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =" \n                                                                       \n                                     <!-- Added for ML-BRU-CRF-0469 start-->                                \n                                     ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="                                \n                                    <td class=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" align=\"center\" id=\'gross_amount_str_";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>&nbsp;</td>\n                                    ";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n                                     <!-- Added for ML-BRU-CRF-0469 end -->\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" align=\"center\" id=\'gross_charge_amount_str_";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" align=\"center\" id=\'groos_pat_payable_str_";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\t\t\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\"><label id=\"objectaa\" style=\"cursor:pointer\" class=\"hyperlink1\" onClick=\" callverifyremarks(\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\', \'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\')\">";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</label></td>\n";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in callBatchSearchVerification regarding incident num:25276 ==By sandhya -->\n\t\t\t\t\t\t\t\t<td style=\"font-size:9px\" width=\"6%\" nowrap class=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\')\">&nbsp;\n\t\t\t\t\t\t\t\t\t<label style=\'color:blue;cursor:pointer;font-size:9px\' onClick=\"callBatchSearchVerification(\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\',\n\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</label> \t\t</td> \n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"2%\" id=\"stock";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" name=\"stock";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\')\">&nbsp;\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_line_num";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"dischargeIND";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" id=\"dischargeIND";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_id";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" id=\"order_id";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td colspan=\"14\"><label style=\"color:red;font-size: 9px;\">";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="&nbsp;&nbsp; :</label>\n\t\t\t\t\t\t\t<label style=\"font-size: 9px;\" >";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</label> </br>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\t\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id_1\" id=\"bean_id_1\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name_1\" id=\"bean_name_1\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_date_time\" id=\"ord_date_time\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ordering_facility_id\" id=\"ordering_facility_id\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n\t\t\t\t<input type=\"hidden\"  name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">\n\t\t\t\t<input type=\"hidden\"  name=\"recCount\" id=\"recCount\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\"> <!--  Added for MMS-KH-CRF-0028 [IN070605] -->\n\t\t\t\t<input type=\"hidden\"  name=\"displayGrossAmtYn\" id=\"displayGrossAmtYn\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\"><!-- added for ML-BRU-CRF-0469 -->\n";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"bl_encounter_id\" id=\"bl_encounter_id\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bl_patient_class\" id=\"bl_patient_class\" value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bl_sysdate\" id=\"bl_sysdate\" value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_gross_charge_amount\" id=\"tot_gross_charge_amount\" value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_groos_pat_payable\" id=\"tot_groos_pat_payable\" value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_gross_amount\" id=\"tot_gross_amount\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 end -->\n";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t<input type=\"hidden\" name=\"performing_pract_id\" id=\"performing_pract_id\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t\t\t<script>\n\t\t\t\t\tcallLegendsFrame(\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\',\'V\',\'\',\'\',\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\',\'N\',\'N\',\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\');  // added for ML-BRU-CRF-0469  tot_gross_amount_str \n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\t\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

System.out.println("==============in==========>DispMedicationVerification.jsp");
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


Connection con			= null;  // Added for ML-MMOH-CRF-0468
          try{
			con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
			boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
					
		    boolean displayGrossAmtYn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");// Added for ML-BRU-CRF-0469 - start
						
			boolean intractn_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 // same variable used for MMS-KH-CRF-0028 [IN070605]		        		   
			boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
			boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
				System.out.println("drug_abuse_appl"+drug_abuse_appl);
        boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
        boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
					String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";

			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			bean.loadReason();

			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
			
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			param_bean.setLanguageId(locale);

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); // Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]

			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();
			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";

			if(disp_locn_catg.equals("I")) 
				patient_class	=	"IP";
			else 
				patient_class	=	"OP";

			String disp_stage			=	bean_1.getDispStage();
			String order_type			=   bean_1.getOrderType();
			bean_1.setObject(bean);
			String patient_id			=   request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String encounter_id			=   bean_1.getEncounterID();
			String order_id				=   request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String practitioner_id		=   request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String practitioner_name	=   java.net.URLDecoder.decode(request.getParameter ("practitioner_name")==null?"":request.getParameter ("practitioner_name"),"UTF-8");
			Hashtable param_legends		=   bean_1.getLegendsFromParam();
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
			bean.setPractitionerID(practitioner_id);
			bean.setPractitionerName(practitioner_name);
			
			String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            String bean_name2		= "ePH.PrescriptionBean_1"; 
            PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End

			//Declaration starts
			ArrayList drug_interact		=	new ArrayList();
			String order_line_no		=	"";
			String drug_code			=	"";
			String drug_name			=	"", drug_name_1="";
			String dosage_dtls			=	"";
			String start_date			=	"";
			String end_date				=	"";
			String pres_qty				=	"";
			String qty_uom				=	"";
			String qty_uom_disp			=	"";
			String alt_drug_code		=	"";
			String alt_drug_desc		=	"";
			String drug_color			=	"";
			String style				=	"";
			String ord_id				=   "";	
			String form_code			=	"";
			String form_desc            = ""; // Added for MMS-KH-CRF-0013
			String hold_status			=	"";
			String remark_status		=	"";
			//String hold_text			=	"Hold";
			String 	hold_text		    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value			=   "N";
			String fromdb				=   "N";	
			String strChangedFludRmks	=	"";
			String pat_couns_reqd_yn	=	"";
			int bmscount                =    0;
			String pat_reqd				=	"";
			String pt_couns_reqd_yn		=	"";
			String dosage_unit			=	"";
			String std_dose             =   "";
			String location				=	"";
			String expired_yn			=	"";
			String pres_details			=	"";
			String iv_prep_yn			=	"";
			String dischargeIND			=	"";
			String strBMS_Include_yn ="N";// Added for [IN:045295]
			String home_med_yn = "", home_med_style="";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String disc_cancelled_orders="", disc_cancelled_orders_display="display:none;", drug_desc=""; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			HashMap IssueUOMAndBaseUOM       = new HashMap();//ML-BRU-SCF-1798
			double base_to_disp_uom_equl     = 0;//ML-BRU-SCF-1798
			String base_uom = "";//ML-BRU-SCF-1798
			String patient_brought_medn ="";


			ArrayList	colors	=	new ArrayList();
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			//Declaration ends

			String disp_level	= bean_1.getDispLevelValue();
			String disp_catg	= bean_1.getDispLocnCatg();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
			}
			if(disp_level.equals("P")) {				
				result			= bean_1.getOrders(patient_id.trim());//order lines of all orders
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR") ||(tpn_mf_label && bean_1.getCriteriaOrderType().equals("TD")))){ //TD added for ml-mmoh-crf-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {	//10 ->11 for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)	//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();

				for(int i=0;i<result.size();i=i+11) {	//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
			
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			}
			else {
				result			= bean_1.getOrders(patient_id.trim());
				for(int i=0;i<result.size();i=i+11) {		//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
				  ord_id = (String)result.get(i+1);
				  if(ord_id.equals(order_id)){
					location  = (String)result.get(i+4);
				  }
				  ord_id="";
				}
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}

			String allergy				=	"";
			String exceed_dose			=	"";	
			String generic_id			=	"";
			String generic_name			=	"";
			String dosage_details		=	"";
			String exceed_status		=	"";
			String monograph			=	"";
			String unit_dose			=	"";
			String daily_dose			=	"";
			String bms_qty				=	"";
			String duplicate_yn			=	"";
			String min_dose_dtls		=	"";
			String min_unit_dose		=	"";
			String min_daily_dose		=	"";
			String dosage_type    		=   "";
			String ext_prod_id			=	"";
			String ordered_by			=	"";
			String ord_date_time		=	"";	
			//code added for in_formulary....drugs..	
			String in_formulary_yn		=	"";	
			String source_code			=	"";
			String source_type			=	"";
			String ordering_facility_id	=	"";
			String performing_pract_id	=	"";
			//code added for drug remarks
			String drug_remarks			=	"";
			String prn_remarks			=	"";
			String pharma_remarks		=	"";		
			String pres_remarks			=	"";
			String slidingscaleremarks	=   "";
			String verificationremarks	=   "";
			String remarks_style		=	"";
			String trade_code			=   "";
			float dialog_height			=	0;
			String image_path			=   "";
			String strength				=   "";
			String strength_uom			=   "";
			String strength_uom_disp	=   "";
			String strength_value		=   "";
			String OrderDate			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderDate/Time.label","ph_labels");
			String OrderedPractitioner	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderedPractitioner.label","ph_labels");
			String OrderingLocation		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingLocation.label","common_labels");
			//ends here
			String  billing_interface_yn		=	bean.getBLInterfaceYN();//checkforbillinginterface();
			String width						=	"100%";
			String bl_encounter_id				=	bean_1.getEncounterID();
			String bl_patient_class				=   "";
			String bl_display                   =   "Y"; 
			String sysdate						=   bean_1.getTodaysDate();
			String disp_locn_code               =   bean_1.getDispLocnCode();
			float tot_gross_charge_amount		=   0;
			float tot_groos_pat_payable			=   0; 
			float  tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
			String tot_gross_charge_amount_str	=   "";
			String tot_groos_pat_payable_str	=   "";
			String tot_gross_amount_str         =	"";	// added for ML-BRU-CRF-0469
			String decimalFormatString			=   "";
			String gross_charge_amount_str		=   "";
			String groos_pat_payable_str		=   "";
			String gross_amount_str             =   ""; //added for ML-BRU-CRF-0469
			int adr_count						=   0;
			String bl_incl_excl_val             =	"";
			String alloc_qty_from_tmp			=	"";
			String bl_incl_excl_override_reason_code =	"";
			//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String billable_item_yn					=	"";
			String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
			String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
			//added for IN070605 START
			String alergy_details_remarks="",dosage_details_remarks="",duplicate_details_remarks="",intaraction_details_remarks="";
			String review_called_from="";
			String revw_aprrove_applicable_yn=bean.approvalSetting(patient_class);
			String ALLERGY_REMARKS_CLASS="";
			String DOSAGE_REMARKS_CLASS="";
			String DUPLICATE_REMARKS_CLASS="";
			String INTARACTION_REMARKS_CLASS="";
			String ALLERGY_REMARKS_YN="";
			String DOSAGE_REMARKS_YN="";
			String DUPLICATE_REMARKS_YN="";
			String INTARACTION_REMARKS_YN="";
			//added for IN070605 END
			String ABUSE_REMARKS_CLASS="";//ADDED FOR AAKH-CRF-0140
			String  ABUSE_REMARKS_YN="";//ADDED FOR AAKH-CRF-0140
			String abuse_drug_override_reason="";//added for aakh-crf-0140  
			String abuse_exists="";//added for aakh-crf-0140
			String drugIndication="";//added for jd-crf-0220	
      String	category_code="";//added for mms-dm-crf-209.1
			String	alternate_yn="";//added for mms-dm-crf-209.1	
			//String taper_order_yn, taper_order_id, taper_order_line_num, taper_disable, show_remarks;  //Commented for RUT-CRF-0088 [IN036978]
			String taper_disable, show_remarks;  //Added for RUT-CRF-0088 [IN036978] -Start
			float tot_tap=0;
			HashMap taperValues = null;
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();
			int count = 0; //Added for RUT-CRF-0088 [IN036978] -End
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			String dose_unit_desc="";//Added for Ml-MMOH-SCF-0863
			/*if(bean_1.getOrderType().equals("CO")||bean_1.getOrderType().equals("IVAA")||bean_1.getOrderType().equals("IVIA")||bean_1.getOrderType().equals("CA")||bean_1.getOrderType().equals("TA")){
					bl_display                   ="N"; 
			   
			}*/
			
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				width			=	"115%"; 
				bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id); // patient_id   added for [IN:035667] 
			}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(width));
            _bw.write(_wl_block9Bytes, _wl_block9);
	                if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block12Bytes, _wl_block12);
					
                    } //Added for MMS-KH-CRF-0028 [IN070605] - End

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(param_legends.get("V")));

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(aggred_item_app){
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 
					if(billing_interface_yn.equals("Y") && bl_display.equals("Y")){

            _bw.write(_wl_block20Bytes, _wl_block20);
if(displayGrossAmtYn){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

					}

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					if(bean_1.getStockInstalled()){

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					}

            _bw.write(_wl_block28Bytes, _wl_block28);

					String classvalue	=	"";
					int recCount		=	1;
					ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
					String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
					//String drug_type	=	"";
					String ceil_dose_unit_desc = "";//added for ML-MMOH-CRF-1408
					HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
					boolean	bDrugOrder				= true;
					System.out.println("==============in==========>DispMedicationVerification.jsp 483 orderLineDtls "+orderLineDtls);
					for(int i=0;i<orderLineDtls.size(); i++){
						
						System.out.println("==============in==========>DispMedicationVerification.jsp 486 ");
						bDrugOrder				= true;
					//added for ML-MMOH-CRF-1408 - start
						celling_dose			= null;
						min_unit_ceiling_dose = "";
						max_unit_ceiling_dose = "";
						min_daily_ceiling_dose = "";
						max_daily_ceiling_dose = "";
						dose_unit_desc="";
						ceil_dose_unit_desc = ""; //added for ML-MMOH-CRF-1408
						//added for ML-MMOH-CRF-1408 - end
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;

						pres_details		=	"";

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id			= (String)orderLineDtls.get(i);
							ordered_by			= (String)orderLineDtls.get(++i);
							location			= (String)orderLineDtls.get(++i);
							++i;
						
						}
						else{
						   ordered_by   =   practitioner_name;
						}                 
						
						allergy					= (String)orderLineDtls.get(i);
						exceed_dose				= (String)orderLineDtls.get(++i);
						i=i+1;
						//duplicate				=	(String)orderLineDtls.get(++i);
						drug_code				= (String)orderLineDtls.get(++i);				
						//drug_type				=	bean_1.getDrugType(drug_code);
						drug_name				= (String)orderLineDtls.get(++i);
						
						dosage_dtls				= (String)orderLineDtls.get(++i);
						start_date				= (String)orderLineDtls.get(++i);
						end_date				= (String)orderLineDtls.get(++i);
						pres_qty				= (String)orderLineDtls.get(++i);
						qty_uom					= (String)orderLineDtls.get(++i);
						qty_uom_disp			= (String)orderLineDtls.get(++i);
						order_line_no			= (String)orderLineDtls.get(++i);
						generic_id				= (String)orderLineDtls.get(++i);

						if(generic_id.equals("MEDICALITEM"))
							bDrugOrder				= false;

						generic_name			= (String)orderLineDtls.get(++i);
						dosage_details			= (String)orderLineDtls.get(++i);
						bms_qty					= (String)orderLineDtls.get(++i);
						source_code				= (String)orderLineDtls.get(++i);
						source_type				= (String)orderLineDtls.get(++i);
						ordering_facility_id	= (String)orderLineDtls.get(++i);
						ord_date_time			= (String)orderLineDtls.get(++i);
						performing_pract_id		= (String)orderLineDtls.get(++i);
						duplicate_yn			= (String)orderLineDtls.get(++i);
						min_dose_dtls			= (String)orderLineDtls.get(++i);               
						trade_code				= (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
						if(generic_id.equals("MEDICALITEM")){
						   drug_trade_bean.setDrugyesno("");
						}
						else{
							drug_trade_bean.setDrugyesno("Y");
						}
						image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);


						i=i+1;
						strength_value			=	(String)orderLineDtls.get(++i);
						strength_uom			=	(String)orderLineDtls.get(++i);
						strength_uom_disp		=	(String)orderLineDtls.get(++i);
						strength	="";
						if(!strength_value.equals("0"))
							strength	=	strength_value+" "+strength_uom;
						//commented during PE by naveen
						//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);
						bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
									
						if(order_type.equals("IVI") )
							strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
						else
							strChangedFludRmks ="";

						if(strChangedFludRmks != "" && strChangedFludRmks != null)
							classvalue = "FLUDCOLOR";

						//if(module_id.equals("2"))
							//stock_opt	=	(String)orderLineDtls.get(++i);				
						i=i+1;  
						ext_prod_id=(String)orderLineDtls.get(++i);

						if(ext_prod_id!=null && !ext_prod_id.equals("")) {
							drug_interact.add(ext_prod_id);
						}
						StringTokenizer dose	=	new StringTokenizer(dosage_details,":");
						//code added for in_formulary_yn ..added on 25/4/2004
						in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();
						if(in_formulary_yn.equals("N"))
							classvalue			=	"FORMULARY";
						iv_prep_yn = (String)orderLineDtls.get(++i);
						//if( (((String)orderLineDtls.get(++i)).trim()).equals("N")) {
						if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
							if(order_line_no.equals("1"))
								classvalue="IVFLUID";
							else
								classvalue="IVINGREDIENT";
						}	//ended...                
						i=i+1; 				
						bl_incl_excl_val                  =(String)orderLineDtls.get(++i);
						bl_incl_excl_override_reason_code =(String)orderLineDtls.get(++i);           
						expired_yn                        = (String)orderLineDtls.get(++i);
						i=i+5;			  // to skip the PRN and absolute YN values                 
						if(expired_yn.equals("Y"))
						{
							if(expired_order) //modified for MOHE-CRF-0032
								{
								classvalue="EXPIRED_ORDER";
								}
							else
							{
								classvalue="EXPIRED_MEDICATION";
							}
						}
											
						if(dose.hasMoreTokens())
							exceed_status	=	dose.nextToken();
						if(exceed_status.equals("Y")) {
							if(dose.hasMoreTokens())
								monograph	=	dose.nextToken();
							if(dose.hasMoreTokens())
								unit_dose	=	dose.nextToken();
							if(dose.hasMoreTokens())
								daily_dose	=	dose.nextToken();
							if(dose.hasMoreTokens())
								dosage_type =dose.nextToken();
							if(dose.hasMoreTokens())
								dosage_unit =dose.nextToken();
							if(dose.hasMoreTokens())
								std_dose   =dose.nextToken();			
						}
						if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0863 - Start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
						   ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
						      ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
							 if(dosage_unit.split("/").length>=2)
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
	 						} 
 						}// Added for ML-MMOH-SCF-0863 - End
						StringTokenizer min_dose	=	new StringTokenizer(min_dose_dtls,":");
						if(min_dose.hasMoreTokens()) {
							min_unit_dose	=	min_dose.nextToken();
						} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
						if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							min_daily_dose	=	min_dose.nextToken();
						}

						if(bean.checkHold(order_id,order_line_no)) {
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
							check_value="Y";
							//check_status="checked";
							fromdb="Y";
							remark_status	="visibility:visible";
						} 
						else {
							HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
							if (!hm.isEmpty()){
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								//check_status="checked";
								check_value="Y";
								fromdb="Y";
								remark_status	="visibility:visible";
							}
							else{
								//hold_text		="Hold";
								hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								remark_status	="visibility:hidden";
								//check_status	="";
							}
						}
						ArrayList multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
						String qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
						if(!qty.equals(""))
							hold_status			=	"disabled";
						String alt_drug			=	bean.checkMultiStrength(drug_code);
						bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
						if(multi_drugs.size() < 1)	{
							style				=	"cursor:pointer;color:blue";
							//call_function		=	"callDrugDetails('"+patient_id+"','"+order_id+"','"+drug_code+"','"+drug_name+"','"+alt_drug+"','','','','"+qty_uom+"','"+pres_qty+"')";
						}
						else	{
							style				=	"font-weight:bold";
							//call_function		=	"";
						}
						HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
						if(hm.size() > 1) {
							hold_status="checked";
							remark_status="visibility:visible";
						}
						/*-----code for displaying drug remarks---------------*/
						drug_remarks	    = "";
						prn_remarks		    = "";
						pharma_remarks	    = "";		
						pres_remarks        = "";
						slidingscaleremarks ="";
						remarks_style       = "";
						dialog_height       = 0;
						//changed during PE By Naveen  added in get order line details
						pres_remarks					=   bean.getPrescriptionInstructions(order_id);
						drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
						//IN071533 Start					
						if(iv_prep_yn!=null && !iv_prep_yn.equals("") && iv_prep_yn.equals("5")){
							drug_remarks = bean.getNonMFRfluidRemarks(order_id,order_line_no); 
						}
						//IN071533 end
						prn_remarks						=   (String)orderLineDtls.get(++i);
						pharma_remarks					=   bean.getPharmacistInstructions(order_id,order_line_no,"Y");
						slidingscaleremarks				=   (String)orderLineDtls.get(++i);
						verificationremarks				=   (String)orderLineDtls.get(++i);             
						drug_db_product_id				=	(String)orderLineDtls.get(++i);
						allergy_override_reason			=	(String)orderLineDtls.get(++i);
						dosage_limit_override_reason	=	(String)orderLineDtls.get(++i);
						duplicate_drug_override_reason	=	(String)orderLineDtls.get(++i);
						interaction_override_reason		=	(String)orderLineDtls.get(++i);		  
						contraind_override_reason		=	(String)orderLineDtls.get(++i);
						pat_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from order_line_PH
						pt_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
						billable_item_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
						dischargeIND					=	(String)orderLineDtls.get(++i);//from OR_ORDER dischargeindecator
						strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295]
						home_med_yn 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
						//added for MMS-KH-CRF-0029 - start
						food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//MODIFIED FOR MMS-MD-SCF-0141
							 disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null) //MMS-KH-CRF-0029
							lab_interaction_override_reason = "";
						if(food_interaction_override_reason==null) //MMS-KH-CRF-0029
							food_interaction_override_reason = "";
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";
						//added for MMS-KH-CRF-0029 - end
						drug_desc = (String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
						disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
						if(!disc_cancelled_orders.equals(""))
							disc_cancelled_orders_display="display:inline";
						else
							disc_cancelled_orders_display="display:none";
						i++;//Added for Bru-HIMS-CRF-080
						if(home_med_yn!=null && home_med_yn.equalsIgnoreCase("Y"))
							home_med_style = "HOME_MED";
						else
							home_med_style = "white";//Added for Bru-HIMS-CRF-093-DD1[IN047223] -End
						/*taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER   //Commented for RUT-CRF-0088 [IN036978]
						taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
							bms_qty = "0"; // added to avoid displaying qty for tapered drugs
						}
						else*/
						//added for IN070605 START
						if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){
							review_called_from="disp_medication";
						}
						else{
							review_called_from="";
						}
						 ALLERGY_REMARKS_YN="N";
						 DOSAGE_REMARKS_YN="N";
						 DUPLICATE_REMARKS_YN="N";
						 INTARACTION_REMARKS_YN="N";
						 ABUSE_REMARKS_YN="N";//added for aakh-crf-0140
						alergy_details_remarks=(String)orderLineDtls.get(++i);
						if( intractn_req_yn && !alergy_details_remarks.equals("")&& alergy_details_remarks!=null){
							ALLERGY_REMARKS_CLASS="ALLERGY_REMARKS";
							ALLERGY_REMARKS_YN="Y";
						}
						else{
							ALLERGY_REMARKS_CLASS="ALLERGY";	
						}
						dosage_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !dosage_details_remarks.equals("")&& dosage_details_remarks!=null){
							DOSAGE_REMARKS_CLASS="DOSELIMIT_REMARKS";
							DOSAGE_REMARKS_YN="Y";
								}
								else{
									DOSAGE_REMARKS_CLASS="DOSELIMIT";	
								}
						duplicate_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !duplicate_details_remarks.equals("")&& duplicate_details_remarks!=null){
							DUPLICATE_REMARKS_CLASS="CURRENTRX_REMARKS";
							DUPLICATE_REMARKS_YN="Y";
						}
						else{
							DUPLICATE_REMARKS_CLASS="CURRENTRX";	
						}
						intaraction_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !intaraction_details_remarks.equals("")&& intaraction_details_remarks!=null){
							INTARACTION_REMARKS_CLASS="INTARACTION_REMARKS";
							INTARACTION_REMARKS_YN="Y";
						}
						else{
							INTARACTION_REMARKS_CLASS="DINTERACN";	
						}
						

					    abuse_drug_override_reason=(String)orderLineDtls.get(++i);//ADDED FOR AAKH-CRF-0140
						abuse_exists=(String)orderLineDtls.get(++i);//ADDED FOR AAKH-CRF-0140
						drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
							
						if(drug_abuse_appl &&( !abuse_drug_override_reason.equals("") )){
							 ABUSE_REMARKS_CLASS="ABUSE_REMARKS";//ADDED FOR AAKH-CRF-0140
							  ABUSE_REMARKS_YN="Y";//ADDED FOR AAKH-CRF-0140
							
						}
						else{
							ABUSE_REMARKS_CLASS="";
							ABUSE_REMARKS_YN="N";
						}
						System.out.println("811 abuse_drug_override_reason"+abuse_drug_override_reason);
						
						if(disp_locn_catg.equals("I") || disp_locn_catg.equals("IAE"))//Adding start for TH-KW-CRF-0014
						  patient_brought_medn =(String)orderLineDtls.get(++i);
						  ++i;//Added for TH-KW-CRF-0008
						++i;//Added for TH-KW-CRF-0008
							category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						if(patient_brought_medn.equals("Y")){
							classvalue			=	"PATIENTMED";//Adding end for TH-KW-CRF-0002
						}
						System.err.println("822 classvalue==="+classvalue+"patient_brought_medn==="+patient_brought_medn);
						//added for IN070605 END
						
						taper_disable="";
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978]
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());
						show_remarks			= "N";
						if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){ //modified for MMS-KH-CRF-0029//disease_inter_override_reason for MMS-DM-CRF-0229
							show_remarks="Y";
						}
						drugs_remarks = new StringBuffer(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PractitionerPharmacistInstructions.label","ph_labels")+" : \n"); //code added for Bru-HIMS-CRF-416[IN045566]-- Start								
						if(!pres_remarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionInstructions.label","ph_labels")+" : "+pres_remarks.trim()+"\n");
						if(!slidingscaleremarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
						if(!allergy_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyOverrideReason.label","common_labels")+" : "+allergy_override_reason.trim()+"\n");		
						if(!duplicate_drug_override_reason.trim().equals("")){
						   if(drug_db_product_id != null  && !drug_db_product_id.equals(""))
								drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateTheraphyOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
							else
								drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateDrugOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
						}
						if(!dosage_limit_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DosageOverrideReason.label","ph_labels")+" : "+dosage_limit_override_reason.trim()+"\n");
						if(!interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DrugInteractionOverrideReason.label","ph_labels")+" : "+interaction_override_reason.trim()+"\n"); //modified for MMS-KH-CRF-0029
						//added for MMS-KH-CRF-0029 - start
						if(!lab_interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-LabInteractionOverrideReason.label","ph_labels")+" : "+lab_interaction_override_reason.trim()+"\n");
						if(!food_interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-FoodInteractionOverrideReason.label","ph_labels")+" : "+food_interaction_override_reason.trim()+"\n");
						//added for MMS-KH-CRF-0029 - end disease_inter_override_reason
						if(!disease_inter_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DiseaseOverrideReason.label","ph_labels")+" : "+disease_inter_override_reason.trim()+"\n");//MMS-DM-CRF-0229
						if(!contraind_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ContraIndicationOverrideReason.label","ph_labels")+" : "+contraind_override_reason.trim()+"\n");								
						if(!drug_remarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInstructions.label","ph_labels")+" : "+drug_remarks.trim()+"\n");
						if(!prn_remarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PRNInstructions.label","ph_labels")+" : "+prn_remarks.trim()+"\n");
						if(!pharma_remarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Pharmacist.label","ph_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Instructions.label","common_labels")+" : "+pharma_remarks.trim()+"\n");
						if(!verificationremarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");	//code added for Bru-HIMS-CRF-416[IN045566]-- End
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//!abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
									if(!abuse_drug_override_reason.trim().equals(""))
								drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
					
							if(drugIndication !=null && !drugIndication.equals("")){
							drugs_remarks.append("Drug Indications : "+drugIndication.trim()+"\n");
						}
							
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
						if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("") &&show_remarks.equals("N") && abuse_drug_override_reason.trim().equals("") && drugIndication.equals("")){
							remarks_style	=	"style='visibility:hidden'";
							drugs_remarks.setLength(0);
						} 
						else {
							System.out.println("882 drugs_remarks"+drugs_remarks);
							
							System.out.println("prathyusha sfjsef");
							strDrugsRemarks = drugs_remarks.toString();
							strDrugsRemarks=strDrugsRemarks.replaceAll(" ","%20");
							strDrugsRemarks = java.net.URLEncoder.encode(strDrugsRemarks,"UTF-8");
							strDrugsRemarks=strDrugsRemarks.replaceAll("%2520","%20");
							dialog_height = 0 ;
							if(!prn_remarks.trim().equals(""))
								dialog_height	 += 6.5;

							if(!drug_remarks.trim().equals(""))
								dialog_height	 += 6.5;
						
							if(!pres_remarks.trim().equals(""))
								dialog_height	 += 6.5;
						
							if(!pharma_remarks.trim().equals(""))
								dialog_height	 += 6.5;

							if(!slidingscaleremarks.trim().equals(""))
								dialog_height	 += 6.5;

							if(!verificationremarks.trim().equals(""))
								dialog_height	 += 6.5;

							if(show_remarks.equals("Y"))
								dialog_height	 += 13;

							remarks_style	=	"style='visibility:visible'";
							if(dialog_height>18) 
								dialog_height = dialog_height-4;
							if(dialog_height==18) 
								dialog_height = dialog_height-3;
							if(dialog_height==12) 
								dialog_height = dialog_height-1;
							
							dialog_height	 += 1.4;
							System.out.println("919 prathyusha strDrugsRemarks"+strDrugsRemarks);
						}
						adr_count			= bean.getADRCount(patient_id,drug_code);
						pres_details		= bean.getPresDetails(order_id);
						System.out.println("924 pres_details  "+pres_details);
						System.out.println("924 adr_count  "+adr_count);
						if(!exceed_dose.equals("")){ //if condition added for ML-MMOH-CRF-1408
							String repeat_value = 											bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[2];
							 System.out.println("925 prathyusha repeat_value"+repeat_value);
							 celling_dose = bean_1.getMinMaxCeilingDose(drug_code,patient_id,repeat_value,order_id,order_line_no);
							 System.out.println("927 prathyusha celling_dose"+celling_dose);
								if(celling_dose!=null && celling_dose.size()>0){
								min_unit_ceiling_dose = (String)celling_dose.get(0);
								max_unit_ceiling_dose = (String)celling_dose.get(1);
								min_daily_ceiling_dose = (String)celling_dose.get(2);
								max_daily_ceiling_dose = (String)celling_dose.get(3);
							 }
						
						}System.out.println("935 prathyusa  ");

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf("RECORD"+(recCount-1)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("RECORD"+(recCount-1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block32Bytes, _wl_block32);
				   if(intractn_req_yn && order_type.equals("NOR")){ // Added for MMS-KH-CRF-0028 [IN070605] - Start

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
                                  }
                                   else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
 	
                                   } // Added for MMS-KH-CRF-0028 [IN070605] - End

            _bw.write(_wl_block38Bytes, _wl_block38);
	
										if(allergy.equals("")) { System.out.println("955 allergy  "+allergy);

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block41Bytes, _wl_block41);
	
										}
										else{//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
										
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ALLERGY_REMARKS_CLASS));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("ALLERGY"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("ALLERGY"+(recCount)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(review_called_from));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){//if else condtion added for IN070605
										
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ALLERGY_REMARKS_YN));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
										 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } 
            _bw.write(_wl_block52Bytes, _wl_block52);
	
										}if(exceed_dose.equals("")) { 

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block54Bytes, _wl_block54);
 										}
										else{	//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(DOSAGE_REMARKS_CLASS));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("DOSELIMIT"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("DOSELIMIT"+(recCount)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(monograph)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(std_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(review_called_from));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(max_daily_ceiling_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(min_daily_ceiling_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(max_unit_ceiling_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(min_unit_ceiling_dose));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ceil_dose_unit_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){//if else condtion added for IN070605
											
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(DOSAGE_REMARKS_YN));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("DOSELIMIT_VALUE"+(recCount)));
            _bw.write(_wl_block62Bytes, _wl_block62);
} 
            _bw.write(_wl_block63Bytes, _wl_block63);
											}
										if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")  ) { 
											//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
											
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(DUPLICATE_REMARKS_CLASS));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("CURRENTRX"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("CURRENTRX"+(recCount)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(review_called_from));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn==""){//if else condtion added for IN070605 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(DUPLICATE_REMARKS_YN));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block62Bytes, _wl_block62);
} 
            _bw.write(_wl_block63Bytes, _wl_block63);

										}else{

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("CURRENTRX_VALUE"+(recCount)));
            _bw.write(_wl_block69Bytes, _wl_block69);
	
										}
									if( iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start
									pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029[IN070606]
										if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
								    	    
											form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
											form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
											//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(INTARACTION_REMARKS_CLASS));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf("INTARACTION"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("INTARACTION"+(recCount)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(form_desc,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(review_called_from));
            _bw.write(_wl_block72Bytes, _wl_block72);
if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn==""){//if else condtion added for IN070605 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(INTARACTION_REMARKS_YN));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block62Bytes, _wl_block62);
} 
            _bw.write(_wl_block1Bytes, _wl_block1);
 
							            }
								       else{	

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block69Bytes, _wl_block69);
						    	   
									   }
									}// Added for MMS-KH-CRF-0013 - End
									else{ // else Added for MMS-KH-CRF-0028 [IN070605] - Start
										
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf("INTARACTION_VALUE"+(recCount)));
            _bw.write(_wl_block75Bytes, _wl_block75);
} // else Added for MMS-KH-CRF-0028 [IN070605] - End

            _bw.write(_wl_block76Bytes, _wl_block76);
		if(drug_abuse_appl && abuse_drug_override_reason != null && abuse_drug_override_reason != "" ) { System.out.print("abuse_exists----->"+abuse_exists+"ABUSE_REMARKS_CLASS"+ABUSE_REMARKS_CLASS);
											
											
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ABUSE_REMARKS_CLASS));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);

										}else{

            _bw.write(_wl_block79Bytes, _wl_block79);
	
										}
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(remark_status));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(fromdb));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(check_value));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(home_med_style));
            _bw.write(_wl_block104Bytes, _wl_block104);

								if(aggred_item_app){
								if( category_code.equals("B")&& alternate_yn.equals("Y")){
								
            _bw.write(_wl_block105Bytes, _wl_block105);
}
								else if(category_code.equals("B")){
								
            _bw.write(_wl_block106Bytes, _wl_block106);
	}
								else{
									
            _bw.write(_wl_block107Bytes, _wl_block107);
	}}
								
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block110Bytes, _wl_block110);
 
							if(!order_type.equals("TD") && !order_type.equals("TA")) { 

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
	
							}

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(style));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strength));
            _bw.write(_wl_block122Bytes, _wl_block122);
 
							if(order_type.equals("TD")){ 

            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block125Bytes, _wl_block125);

							}
							if ((ext_prod_id!=null)&& !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block127Bytes, _wl_block127);
		
							}
							if ((image_path!=null)&& !(image_path.equals(""))){

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
     
							}
							if(adr_count>0){

            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block132Bytes, _wl_block132);

							}
							if(bDrugOrder){

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(dosage_dtls));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale)));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale)));
            _bw.write(_wl_block1Bytes, _wl_block1);

							}
							int	k	=	0;
							ArrayList alt_qty	=	new ArrayList();
							System.out.println("1121 multi_drugs "+multi_drugs);
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code	=	(String)multi_drugs.get(n);
								alt_drug_desc	=	(String)multi_drugs.get(n+1);
								form_code		=	(String)multi_drugs.get(n+2);
								drug_color		=	(String)colors.get(k++);
								qty				=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code);
								alt_qty.add(qty);

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_drug));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(n));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);

							}
							if(count>1){
								/*float tmp_tot_qty=0;  //Added for RUT-CRF-0088 [IN036978] -- begin
								if(tot_tap_qty.containsKey(drug_code))
									tmp_tot_qty=Float.parseFloat(tot_tap_qty.get(drug_code).toString());
								else
									tmp_tot_qty=0;
								tot_tap=tmp_tot_qty+Float.parseFloat(pres_qty);
								tot_tap_qty.put(drug_code,tot_tap); */ //Added for RUT-CRF-0088 [IN036978] --end
								String taper = bean.getTapervalue();
								System.out.println("1163 taper "+taper);
								if(taper.equals("UP")){

            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block149Bytes, _wl_block149);

								}
								else if(taper.equals("DOWN")){

            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
	
								}
								else{

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

								}
								if(totalTaperQtyDisplay.equals("Y")){ //added for RUT-CRF-0088 [IN036978]

            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf((int)tot_tap));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block158Bytes, _wl_block158);
				
								}
							}System.out.println("1163 bmscount "+bmscount);
							if(bmscount==0){
								if(pat_couns_reqd_yn.equals("Y")){
									pat_reqd="Checked";	

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block161Bytes, _wl_block161);

								}
								if(pat_couns_reqd_yn.equals("C")){
									pat_reqd="Checked";	
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block164Bytes, _wl_block164);

								} 
								if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
									pat_reqd="Unchecked";	
									//commented By Naveen during PE
									//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
									if(pt_couns_reqd_yn.equals("Y")){

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(pat_couns_reqd_yn));
            _bw.write(_wl_block167Bytes, _wl_block167);

									}
								}
							} 
							drug_name_1=  drug_name;  
							System.out.println("1190 drug_name ");
							//Commented By Sandhya from 705 to 709 line for incident num:24786 on 24/Nov/2010		
							/*if(!drug_name_1.equals("")&&drug_name_1!=null){
								drug_name_1=drug_name_1.replaceAll(" ","%20");
								drug_name_1=	java.net.URLEncoder.encode(drug_name_1);
								drug_name_1=drug_name_1.replaceAll("%2520","%20");
							}*/  

            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(strDrugsRemarks));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(pres_details));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block182Bytes, _wl_block182);
	
							if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	System.out.println("1212 billing_interface_yn "+billing_interface_yn);
								if(in_formulary_yn.equals("Y")&& billable_item_yn.equals("Y")){       
									float gross_charge_amount = 0;
									float groos_pat_payable   = 0;
								    float gross_amount        = 0;//Added for ML-BRU-CRF-0469
									//float net_amount          = 0;	
									gross_charge_amount_str	  =  "";
									groos_pat_payable_str	  =  "";
								    gross_amount_str =  "";//added for ML-BRU-CRF-0469
									StringBuffer gross_charge_display_str  = new StringBuffer();
									StringBuffer pat_charge_display_str    = new StringBuffer();   
									StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
									//added for ML-BRU-SCF-1798 - start

		 					IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(disp_locn_code,drug_code);
		 					System.out.println("1227 IssueUOMAndBaseUOM "+IssueUOMAndBaseUOM);
							base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")== null ? "":(String)IssueUOMAndBaseUOM.get("BASE_UOM");

							if(!base_uom.equals("")&& !base_uom.equals(qty_uom)){ System.out.println("1229 base_uom "+base_uom);
							base_to_disp_uom_equl    =	bean.getEqulValue ( drug_code, base_uom, qty_uom);					bms_qty = Math.ceil(Double.parseDouble(bms_qty)* base_to_disp_uom_equl)+"";
							}
					//added for ML-BRU-SCF-1798 - end
									HashMap chareg_det = bean.callItemChargeDtls(patient_id ,bl_encounter_id,bl_patient_class,drug_code,Double.parseDouble(bms_qty),";",sysdate,disp_locn_code,bl_incl_excl_val,bl_incl_excl_override_reason_code,order_id,order_line_no,"V",dischargeIND);//order_id,order_line_no added for MMS-DM-CRF-0126.2
									System.out.println("1234 chareg_det "+chareg_det);	
									if(chareg_det.get("error_msg").equals("")){
										decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");								
										DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);                      
										
										/*if(!chareg_det.get("grosschargeamt").equals("null")){
											 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
										}*/// Commented ML-BRU-SCF-0368 [IN:034748]
										if(!chareg_det.get("patnetamt").equals("null")){
											 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
										}
										if(!chareg_det.get("netchargeamt").equals("null")){
											// groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											 gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); // added ML-BRU-SCF-0368 [IN:034748]
										}
										//added for ML-BRU-CRF-0469 start 
										if(displayGrossAmtYn){ 
										if(!chareg_det.get("grosschargeamt").equals("null")){
											gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
										  }
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_amount_str = dfTest.format(gross_charge_amount);
										groos_pat_payable_str   = dfTest.format(groos_pat_payable);
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){ 
										gross_amount_str = dfTest.format(gross_amount);
										}//added for ML-BRU-CRF-0469 end
										gross_charge_display_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(gross_charge_amount_str).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(groos_pat_payable_str).append("</label>");	
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){ 
										gross_disply_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(gross_amount_str).append("</label>");//added for ML-BRU-SCF-0469
										}
										//added for ML-BRU-CRF-0469 end 
										tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
										tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
										//added for ML-BRU-SCF-0469 start
										if(displayGrossAmtYn){ 
										tot_gross_amount        = tot_gross_amount+gross_amount;
												
										}
									//added for ML-BRU-SCF-0469 end 
								   }
								   else{
										if(order_type.equals("TA")){
											gross_charge_display_str.append("<label>&nbsp;</label>").append("");
											pat_charge_display_str.append("<label>&nbsp;</label>").append("");	
											//added for ML-BRU-SCF-0469 start
											if(displayGrossAmtYn){ 
											gross_disply_str.append("<label>&nbsp;</label>").append("");
											}
											
								                  }//added for ML-BRU-SCF-0469 end
										else{
											gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");	
											//added for ML-BRU-SCF-0469 strt 
											if(displayGrossAmtYn){ 
											gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											}
											//added for ML-BRU-SCF-0469 end
										}
								   }

            _bw.write(_wl_block183Bytes, _wl_block183);
 if(displayGrossAmtYn){  
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(gross_disply_str));
            _bw.write(_wl_block187Bytes, _wl_block187);
 } 
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(gross_charge_display_str));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(pat_charge_display_str));
            _bw.write(_wl_block192Bytes, _wl_block192);

									if(chareg_det.get("error_msg").equals("")){System.out.println("1307 recCount ");	

            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block213Bytes, _wl_block213);
if(displayGrossAmtYn){ 
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(gross_amount+""));
            _bw.write(_wl_block216Bytes, _wl_block216);
 } 
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
System.out.println("1325 recCount ");	
									}
									else{System.out.println("1327 recCount ");	

            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block225Bytes, _wl_block225);

									}
								 }
								 else{System.out.println("1333 recCount ");	

            _bw.write(_wl_block226Bytes, _wl_block226);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
 } 
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block225Bytes, _wl_block225);

								}
							 }

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

							if(bean_1.getStockInstalled()){			 System.out.println("1350 recCount ");	

            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block245Bytes, _wl_block245);

							}

            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dischargeIND));
            _bw.write(_wl_block250Bytes, _wl_block250);
            _bw.write(_wl_block1Bytes, _wl_block1);

							if(disp_level.equals("P")) {	

            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block253Bytes, _wl_block253);

							}

            _bw.write(_wl_block254Bytes, _wl_block254);
if(Disp_drug_verify_remarks.equals("Y") && site_remarks && drug_remarks !="" && drug_remarks !=null){System.out.println("1374 Disp_drug_verify_remarks "+Disp_drug_verify_remarks); 
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(drug_remarks ));
            _bw.write(_wl_block257Bytes, _wl_block257);
} 
            _bw.write(_wl_block258Bytes, _wl_block258);
     System.out.println("1384 recCount "+recCount);
						recCount++;
					}

            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(bean_id_1));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(bean_name_1));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(bean_1.getSFunctionId()));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(displayGrossAmtYn));
            _bw.write(_wl_block277Bytes, _wl_block277);

				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){System.out.println("1408 billing_interface_yn "+billing_interface_yn);
				
				System.out.println("1408 bl_display "+bl_display);

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(bl_encounter_id));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(tot_gross_charge_amount));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(tot_groos_pat_payable));
            _bw.write(_wl_block284Bytes, _wl_block284);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(tot_gross_amount));
            _bw.write(_wl_block286Bytes, _wl_block286);
 } 
            _bw.write(_wl_block287Bytes, _wl_block287);

				}
				if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
					DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
					tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
					tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
					//added for ML-BRU-CRF-0469 start
					if(displayGrossAmtYn){ 
					tot_gross_amount_str        = dfTest.format(tot_gross_amount);
					
					}
					//added for ML-BRU-CRF-0469 end
				}

            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(performing_pract_id));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(tot_gross_amount_str));
            _bw.write(_wl_block292Bytes, _wl_block292);
	
			putObjectInBean(param_bean_id,param_bean,request);
			putObjectInBean(bean_id,bean,request);
			putObjectInBean(bean_id_1,bean_1,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
                finally{ // Added for ML-MMOH-SCF-0468 - start
          	
          	if(con != null)
          		ConnectionManager.returnConnection(con,request);	
          } // Added for ML-MMOH-crf-0468 end

            _bw.write(_wl_block293Bytes, _wl_block293);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/DosageDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQuantity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockAvailability.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Constituents.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CheckStatus.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugInstructions.label", java.lang.String .class,"key"));
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
}

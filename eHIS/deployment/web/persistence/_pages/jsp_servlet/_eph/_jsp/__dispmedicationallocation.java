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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationallocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllocation.jsp", 1735826649625L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*******************************************************************************\n * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.\n *  \n * Warning: This computer program is protected by copyright law and international treaties.\n * Unauthorized reproduction or distribution of this program, or any portion of it, \n * may result in severe civil and criminal penalties, and will be prosecuted to \n * the maximum extent possible under the law.  \n ******************************************************************************/\n/* \n------------------------------------------ --------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description  \n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n05/12/2017      [IN:064158]     Devindra    Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).\n10/01/2019\t  \tIN068344\t     \tManickavasagam \t\t  \t\t\t\t\t\t\t\tGHL-CRF-0549 [IN068344] \n05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] \n09/08/2019      IN070605\t\t prathyusha  MMS-KH-CRF-0028 \n13/08/2019      IN070451\t\t Manickavasagam J\t\t\t\t\t\tML-MMOH-CRF-1408\n26/08/2019      IN071102\t\t Manickavasagam J\t\t\t\t\t\tMMS-KH-SCF-0035\n30/08/2019\t  \tIN070894\t     \tDevindra \t\t  \t\t\t\t\tML-MMOH-SCF-1318(RF)\n04/09/2019\t  \tIN070605\t     \tprathyusha \t\t   \t\t\t\t\t\t\t\t\t MMS-KH-CRF-0028 \n10/09/2019\t  \tIN070605\t     \tprathyusha \t\t  \t\t\t\t\t\t\t\t\t MMS-KH-CRF-0028 \n29/10/2019\t\tIN071533\t\t\tShazana\t\t\t\t\t\t\t\tSKR-SCF-1275\n1/10/2019\t\tIN071555\t\t\tShazana\t\t\t\t\t\t\t\tMMS-ME-SCF-0008\n30/11/2019\t\tIN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]\n06/02/2020\t\tIN071362                Manickavasagam J                       AAKH-CRF-0117 \n29/05/2020\t\tIN:072092\t        Manickavasagam J\t\t\t     GHL-CRF-0618\n25/06/2020\t\tIN:072409\t        Manickavasagam J\t\t\t     MMS-CRF-0030\t\n17/08/2020      IN073688         Prabha                 Medical Item Screen\n15/09/2020\t\tIN:073856\t        Manickavasagam J\t\t\t     SKR-SCF-1423\t\n08/10/2020  \t\tIN074038        \tManickavasagam J                                    ML-BRU-SCF-2049\n12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032\n26/10/2020      IN074250         Prabha\t\t 26/10/2020     Manickavasagam J          ML-MMOH-SCF-1634\n29/10/2020      IN074206                      Manickavasagam J          ML-MMOH-SCF-1627\n03/11/2020\t\tIN:074297\t        Manickavasagam J\t\t\t     GHL-SCF-1527\n18/11/2020\t\tTFS:6608\t        Manickavasagam J\t\t\t     ML-BRU-SCF-2055\n30/11/2020\t\t8659\t\t\tShazana\t\t\t\tMMS-MD-SCF-0141 \t\n17/12/2020\t\tTFS:10221\t        Manickavasagam J\t\t\t     ML-BRU-SCF-2055.2\n23/04/2021      TFS-17291         Prabha\t\t 23/04/2021     Manickavasagam J          SKR-SCF-1593\n15/4/2022\t\tTFS25857\t\tShazana\t\t\t\t\t\t\t\t\t\t\t\tSKR-SCF-1646\n15/4/2022\t\tTFS25858\t\tShazana\t\t\t\t\t\t\t\t\t\t\t\tSKR-SCF-1647\n---------------------------------------------------------------------------------------------------------------\n*/ --> \n";
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t <script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction CheckPatReqd(Obj){\n\t\t\tif(Obj.checked==true)\n\t\t\t\tObj.value=\"C\";\n\t\t\telse\n\t\t\t\tObj.value=\"N\";\n\t\t}\n\t\t</script>\n\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\"> \n\t<style> <!-- Added for MMS-KH-CRF-0013 - Start -->\n\tTD.DINTERACN{ \n\t\tBACKGROUND-COLOR:pink;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:15;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n        }\n       TD.EXPIRED_ORDER{    /* Added for MOHE-CRF-0032 */\n\t\t\tBACKGROUND-COLOR:#FFA500; //code modified for MOHE-CRF-0032\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\theight:10;\n\t\t\tBORDER-STYLE: solid;\n\t}    \n\t/* Added for aakh-crf-0140 */\n\tTD.ABUSE_REMARKS{ \n\t\tBACKGROUND-COLOR:purple;\n\t\tFONT-SIZE: 8pt ;\n\t\theight:15;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #663300 0px solid;\n\t        BORDER-LEFT: #663300 0px solid;\n\t        BORDER-RIGHT: #663300 1px solid;\n\t        BORDER-TOP: #663300 1px solid;\n\t\t\t\n        }              \n\t</style>  <!-- Added for MMS-KH-CRF-0013 - End -->\n\t<script>//Adding start for TH-KW-CRF-0008\n\t\t\twindow.onload = function(){\n\t\t\t\twindow.setInterval(\"blinkImage()\",500);\n\t\t\t\twindow.setInterval(\"blinkPatExp()\",500);\n\t\t\t}\n</script><!-- Adding end for TH-KW-CRF-0008 -->\n\n\t\t<form name=\"DispMedicationAllStages\" id=\"DispMedicationAllStages\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<input type=\"hidden\" name=\"alloc_fromBarCode\" id=\"alloc_fromBarCode\" value=\"N\"> <!-- added for KDAH-CRF-0231 [IN-034551]  -->\n\t\t\t<input type=\"hidden\" id=\"barcode_scan_yn\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> <!-- Added for GHL-CRF-0463 -->\n\t\t<!--\t<input type=\"hidden\" id=\"last_scanned\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">  Added for GHL-CRF-0463  removed for mms-dm-scf-0488-->\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'align=\"center\" border=\"1\" id=\"allocationTable\">\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                              <td class= \"COLUMNHEADER\" width=\"4%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t  <input type=\"checkbox\" value=\"Y\" name=\"selectAll\" id=\"selectAll\" checked onClick=\"selectAllRcordsDeliver(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\" ><!--MMS-KH-CRF-0016.1-->\n\t\t\t\t\t\t\t </td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"4%\" style=\"font-size:9px\">Print</td><!-- GHL-CRF-0453-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\"   width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> <!-- 6% changed to 10% for MMS-KH-CRF-0013 -->\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"3%\" style=\"font-size:9px\" nowrap>&nbsp;</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<td width=\"5%\" class= \"COLUMNHEADER\" style=\"font-size:9px\" nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"2%\"  style=\"font-size:9px\" >&nbsp;</td><!-- added for GHL-CRF-0618 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9px\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 end -->\n\t\t\t\t\t<td class= \"COLUMNHEADER\"width=\"30%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9px\" width=\"3%\">&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9px\" width=\"3%\">&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t<td align=\"right\" class=\"COLUMNHEADER\" width=\"10%\" style=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                       ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<!-- //Added for TH-KW-CRF-0012 -->\n                        <td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n                       <!-- Added for ML-BRU-CRF-0469 start -->\n                       ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n                       <td class= \"COLUMNHEADER\" width=\"8%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \n\t\t\t\t\t  <!-- Added for ML-BRU-CRF-0469 end --> \n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;</td> \n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"15%\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"15%\" style=\"font-size:9px\"> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" &nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<tr ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t\t\t\t\t<td> \n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"print_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"print_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onclick=\"setValue(this)\" value=\"Y\" checked> <!--added for GHL-CRF-453 -->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" >\n\t\t\t\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'ALLERGY\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\',\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',\'\')\">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'DOSELIMIT3\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\',\'\',\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 and ceiling dose added for ML-MMOH-CRF-1408 and changed dose_unit_desc to ceil_dose_unit_desc for 1408-->\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'CURRENTRX\' width=\"20%\" style=\"cursor:pointer\" onClick=\"callActiveOrders(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'DINTERACN\' width=\"20%\" style=\"cursor:pointer\" onClick=\"showDispInractionDtl(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',\'\')\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<!--order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605-->\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t    \t   <td class=\"white\" width=\"20%\">&nbsp;</td> \n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t<td class=\'ABUSE_REMARKS\'  width=\"20%\" style=\"cursor:pointer\" onClick=\"showAbuseDetails(\'\',\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\',\'clicking\')\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"20%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"  nowrap ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\" >\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t<label style=\"color:grey;font-size:9px;\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'A\',\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\');\" id=\'hold_remarks_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</label>\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"hold";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"hold";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" style=\'display:none\'  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9px;\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\');notifyChange()\" id=\'hold_remarks_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =">\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"drug_code";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\t<!-- for worksheet -->\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"fromdb_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"fromdb_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold_status";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"hold_status";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 start -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\n\t\t\t\t\t\t\t\t<td style=\"background-color: #00FFFF\" >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\t\n\t\t\t\t\t\t\t\t<td style=\"background-color: #7CFC00\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t<!-- added for mms-dm-crf-0209.1 end -->\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>&nbsp\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostGreen.jpg\" style=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' height=\'15\' width=\'15\' >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginGreen.jpg\" style=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostRed.jpg\" style=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" height=\'15\' width=\'15\' >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginRed.jpg\" style=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCost.jpg\" style=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" height=\'15\' width=\'15\' title=\"Low Cost Item\" >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMargin.jpg\" style=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" height=\'15\' width=\'15\' title=\"High Margin Item\"  >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Innovator.jpg\" style=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"  height=\'15\' width=\'15\' > ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\t<!-- //GHL-CRF-0618 -->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" style=\"font-size:9px;\" ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\')\" nowrap>\n\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"showDrugMasterValues(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">&nbsp;+&nbsp;</label>\n\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue\" onclick=\"showDrugDetails(\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\'\',\'\', \'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',\'Y\',\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');\" id=\"drug_desc";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="&nbsp;";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</label>&nbsp;&nbsp; <!--  , \'patient_id\' added for [IN:035667]  (\'Y\',generic_id Added for JD-CRF-0198 [IN058599])-->\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\')\"></img> <!-- Passing UTF-8 to drugname By Sandhya -->\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=\'20\'  width=\'20\' onClick=\"showImage(\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\')\">\n\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_fully.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Fully Printed\')\"></img>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t         <img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  height=\'20\'  width=\'20\' title=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' onclick= \"callADRdetails(\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\')\"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\');\" >\n\t\t\t\t\t\t\t\t\t<label id=\'lblDiscCancelledOrders_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' title=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;<img id=\'discCancelledOrders_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' src=\"../../ePH/images/DiscCancelledIndicator.png\" onclick=\'callDiscCancelledOrders(\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\", \"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\");\'></label>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/uparrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\');\" valign=\"center\" title=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' style=\"cursor:pointer\"height=\'20\' width=\'20\'></img>\n\t\t  \n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/downarrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' style=\"cursor:pointer\" height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/MultiFrequency.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' style=\"cursor:pointer\" height=\'20\' width=\'20\' ></img>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t\t\t\t<label>-";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="&nbsp;&#40;";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="&#41;</label>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" \n\t    <!--<img src=\"../../ePH/images/altenate.jpg\" height=\'15\' width=\'15\' align=\'top\' onClick=\"callMultiStrength(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\',\'Alloc\',\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\',\'Y\');\" style=\'cursor:pointer\' title=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>  -->\n\t\t<img src=\"../../ePH/images/altenate.jpg\" height=\'15\' width=\'15\' align=\'top\' style=\'cursor:pointer\' onClick=\"getAlternateDrug(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\',\'Fill\',\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\')\" title=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t<!-- Y passed for MMS-KH-CRF-0030-->\n\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\" valign=\"center\"  ></img>\n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pat_reqd_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' id=\'pat_reqd_";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" value=\'C\' disabled onclick=\"CheckPatReqd(this)\">\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pat_reqd_";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" disabled value=\'\'>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' valign=\'center\' name=\'pat_reqd_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" value=\'\' onclick=\'CheckPatReqd(this)\'>\n";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="<!-- ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" Added For Bru-HIMS-CRF-082 [IN:029948]  -->\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t<!-- MMS-KH-CRF-0030 start -->\n\t\t\t\t<div id=\"alternate_";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" style=\"display:none\">\n\t\t\t\t <table cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\"center\" border=\"1\" id=\"alternate_header_";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t \n \t\t\t<!--\t<tr> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" width=\"20%\"  style=\'text-align:right;\'><font style=\'font-size:10px;vertical-align: text-top;\'>Barcode</font> <input type=\"text\" class=\'fields\' name=\"barcode_id_";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" id=\"barcode_id_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" style=\"text-align:right\"  onkeydown=\"if (event.keyCode==13) {}\" maxlength=\"50\"  >\n\t\t\t\t\t</td>\n\n\t\t\t\t\t</tr>\n\n\t\t\t\t <tr>\n\t\t\t\t\t<td class= \"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" width=\"30%\">";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td>\n\n\t\t\t\t <td class= \"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t\t\t\t<td class= \"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" width=\"5%\">";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td>\n\t\t\t\t </tr>\n\t\t\t-->\n\t\t\t\t </table>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\"center\" border=\"1\" id=\"alternate_dtl_header_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\"center\" border=\"1\" id=\"alternate_dtl_footer_";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<!-- MMS-KH-CRF-0030 end-->\n\t\t\t\t\t\t\t\t<br><label id=\"id_min_stk_label\" style=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =";\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =":</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->\n\t\t\t\t\t\t\t\t<label id=\"id_min_str_stk_";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" style=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =";";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =";\'><b>";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</b></label>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<label id=\"id_stk_rol_label_";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =":</label>\n\t\t\t\t\t\t\t\t<label  id=\"id_stk_rol_";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</b></label>&nbsp;\n\t\t\t\t\t\t\t\t<label class=\'HYPERLINK\'  name = \"request_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"  onmouseover=\"changeCursor(this);\" onclick=\"request();\" id=\"sales_req_label\" style=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 =";\' ><b>";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->\n\t\t\t\t\t\t\t\t<label class=\'HYPERLINK\'  name = \"manufacturing_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"  onmouseover=\"changeCursor(this);\" onclick=\"callManufacturingReceipt(\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\');\" id=\"manufacturing_Recpt\" style=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =";\' ><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</b></label><!--Added BRU-HIMS-CRF-080 -->\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=\'color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"showDrugMasterValues(\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">&nbsp;+&nbsp;</label><label style=\"cursor:pointer;color:";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" onclick=\"callDrugDetails(\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\',\'\');changeColor(this);\" id=\"alte_drug_desc";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- code \'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\', removed for TTM-SCF-0096[IN048808]-->\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\')\"></img> <!-- Passing UTF-8 to alt_drug_desc_1 for the incident num:25007 By Sandhya -->\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  height=\'20\'  width=\'20\' title=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t\t\t\t\t\t\t<br><label id=\"id_min_stk_label\" style=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =":</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->\n\t\t\t\t\t\t\t\t\t<label id=\"id_min_str_stk\" style=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</b></label>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t<label id=\"id_stk_rol_label\" style=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =":</label>\n\t\t\t\t\t\t\t\t\t<label  id=\"id_stk_rol\" style=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</b></label>&nbsp;\n\t\t\t\t\t\t\t\t\t<label class=\'HYPERLINK\'  name = \"request\"  onmouseover=\"changeCursor(this);\" onclick=\"request();\" id=\"sales_req_label\" style=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n                   <label style=\"color:darkred\" id=\"expiry_aler_lb_";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">&nbsp; This drug has batches which are going to expire in ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =" Days </label>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t</td>       \n\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in displayInstructions regarding incident num:25276 ==By sandhya -->\t\t\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" style=\"font-size:9px\" ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 =" >\n\t\t\t\t\t\t\t\t\t <img src=\"../../ePH/images/DrugRemarks.gif\" id=\'drugRemarks_";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' title=\'\' valign=\"center\"style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\')\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t   <script>\n\t\t\t\t\t\t\t\t\tvar drug_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\');\n\t\t\t\t\t\t\t\t\teval(document.getElementById(\"drugRemarks_\"+\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\')).title= drug_remarks ;\n\t\t\t\t\t\t\t   </script>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" style=\"font-size:9px\" title=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/exceed.gif\" valign=\"center\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\')\" >&nbsp;<label style=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="&nbsp;(";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =")</label><br>&nbsp;\n\t\t\t\t\t\t\t\t<!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</b>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\')\" ><br>\n";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =";font-size:9px\" id=\"alloc_qty";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">&nbsp;";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="<br>\n";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->\n\t\t\t\t\t\t\t\t\t</label>&nbsp;<label style=\"font-size:9px;color:black\"><b>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</b></label><input type=\"hidden\" name=\"alloc_strength";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" id=\"alloc_strength";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><br><label style=\"cursor:pointer;color:blue;font-size:9px;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\')\">";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</label></td>\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\')\" >\n\t\t\t\t\t\t\t\t\t<label class=\"label\" id=\"alloc_qty";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" style=\"font-size:9px\"><b>&nbsp;";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</b><br></label>\n";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</b><br></label>\n\t\t\t\t\t\t\t\t\t<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t\t\t\t\t<td align=\"left\" CLASS=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t\t<select onChange=\"calculateIssueUOM(this,\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\');\" name=\"issue_uom_select_";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="> <!-- // issueUomDisbYn Added for MMS-DM-SCF-0488 - Reopen Issue -->\n";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="_";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" selected>";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="</option>\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t\t\t\t\t\t</select>&nbsp;\n\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name =\"issueUOMValue_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" value = \"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n\t\t\t\t\t\t\t\t\t<label id=\"item_desc_3\" style=\"font-weight:bold\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"AllowMoreThanPresQty";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" id=\"AllowMoreThanPresQty";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\"  value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"6\" style=\"text-align:right\"  ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="   onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" name=\"alloc_qty_";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" oncopy=\"return false\" onpaste=\"return false\"  onchange=\"if(checkAllocBmsSecondStage(\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\', this)){checkValue(this); setbatchdetails(this,\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\')};\" ";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 =" > \n";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"alloc_fromBarCode\").value=\"Y\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--document.getElementById(\"alloc_qty_\")";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 =".focus(); commented for GHL-CRF-0413.1 [IN:061794] and added color for GHL-CRF-0413.1 [IN:061794]-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"alloc_qty\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 =").style.backgroundColor = \"#ADFF2F\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"6\" style=\"text-align:right\"onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =" name=\"alloc_qty_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" value=\"\" disabled>\n";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name = \"alloc_qty_hidden_";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" value =\"document.DispMedicationAllStages.alloc_qty_";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="~";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->\n\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" ><b>&nbsp;";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</b></label><br><label id=\"issue_uom_lbl";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" class=\"label\" style style=\'font-size:9px\' ><b>&nbsp;";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</b></label><br><label style=\"cursor:pointer;color:blue;font-size:9px;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\',\'N\',\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="</label> \n\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" id=\"issue_uom";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\"     value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" id=\"issue_qty_old";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" id=\"issue_uom_qty";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" id=\"issue_uom_uom";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" id=\"issue_uom_desc";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\"value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" id=\"issue_uom_equl";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"last_scanned_";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\"> <!-- Added for GHL-CRF-0463 // changed for MMS-DM-SCF-0488 -->\n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" onblur=\"includeToBms(this,\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\')\" ";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" value=\"\" onblur=\"includeToBms(this,\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\')\" disabled>\n";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" id=\"alloc_qty";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\"><b>&nbsp;";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="<script>\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"alloc_qty\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->\n\t\t\t\t\t\t\t\t\t\t\t\t<br><label style=\"cursor:pointer;color:blue;font-size:9px;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="</label>\n";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alloc_strength";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"></td>\n";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\"  style=\"font-size:9px\" ";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\')\" >&nbsp;\n\t\t\t\t\t\t\t\t\t<label class=\"label\" id=\"bms_qty_";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="&nbsp;</label><input type=\"hidden\" name=\"bms_qty";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" id=\"bms_qty";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\"><input type=\"hidden\" name=\"qty_uom";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" id=\"qty_uom";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">(";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =")<br>&nbsp;<b>";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="</b>\n\t\t\t\t\t\t\t\t\t<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_availability_check";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" id=\"stock_availability_check";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" value=\"\">\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t\t\t\t\t</td>\n ";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" id=\"override_allowed_yn_";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" id=\"excl_incl_ind_";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\" id=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" id=\"approval_reqd_yn_";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" id=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" id=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\"   value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 start-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_amount_";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\" id=\"gross_amount_";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 end-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\" id=\"drug_color_";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\"   value=\'black\'>\n";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\"  value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\"value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\"     value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_amount_";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\"   value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- added for ML-BRU-CRF-0469 end-->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\"   value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\t                     \t\t\n                           <td class=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\"><center>&nbsp;";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="</center></td>\n";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n                                       <!-- Added for ML-BRU-CRF-0469 start -->\n                                       ";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\n                                       <td  align=\"center\" class=\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="</center></td>\n                                       ";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\n                                       <!-- Added for ML-BRU-CRF-0469 end   -->\n\t\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="<center></td>\n\t\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="<center></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\" align=\"center\">&nbsp;";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" align=\"center\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\" align=\"center\">&nbsp;</td>\n";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"allocateyn_";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\" id=\"allocateyn_";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"prescribed_strength_";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" id=\"prescribed_strength_";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\"> <!--MMS-KH-CRF-0030 --> \n";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\')\">\n";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:blue;font-size:9px;font-weight:bold\" id=\"divIncludeZeroQty";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\" style=\"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type =\"checkbox\" name =\"alloc_bms_chk_";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" onclick=\"assignValue(this);setEnableDsbleCOR(this,\'";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\');\" ";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 =" />\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="                    \n\t\t\t\t\t\t\t\t\t\t\t<div id=\"divOtherEditLables";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- Passed URLEncoder,UTF-8  for drug name in callEditDetails regarding incident num:25276 ==By sandhya -->\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9px;\" id=\"edit_remarks";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"callEditDetails(this,\'";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\',\'D\',\'edit_remarks";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\');\"  ";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 =" >";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!--  added above alt_drug_flag for ML-BRU-SCF-0179 [IN:032578]-->\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:blue;cursor:pointer;font-size:9px\" id=\"alloc_detail";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\" onClick=\"if(!";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="){callAllocate(\'";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\')}\" ";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="</label>\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9px;\" id=\"fill_remarks";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\" onClick=\"callFillingRemarks(this,\'";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\',\'A\',\'fill_remarks";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="> ";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="</label>&nbsp;\n\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"divOtherEditLables";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\">\t\t\t\t\t\t\t \n";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"color:black;font-size:9px;\" id=\"edit_remarks";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;\t\t\t\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:black;font-size:9px;\" id=\"fill_remarks";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="</label>\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:blue;cursor:pointer;font-size:9px\" id=\"alloc_detail";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 =">&nbsp;";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="</label>\n\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\t\t\t\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\" >&nbsp;";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_line_num";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\" ><label style=\"color:red;font-size:9px\" id=\"result_line_status";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\'><b>";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="</b>\n\t\t\t\t\t\t</label> <input type=\'checkbox\'   name=\"CompleteOrder";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" id=\"CompleteOrder";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\"    value=\'";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\' onClick=\'setcompleteorder(this)\' style=\'visibility:hidden\'  ";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 =" >\n\t\t\t\t\t\t\t<select name=\"ComplteOrderReason";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" id=\"ComplteOrderReason";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\" onchange=\'setCheckBoxValue(this,document.DispMedicationAllStages.CompleteOrder";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 =",document.getElementById(\"hold_remarks_\")";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 =",";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 =")\' style=\'";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 =">\n\t\t\t\t\t\t\t<option value=\"\">------- ";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 =" -----</option>\n";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\n\t\t\t\t\t\t\t</select>\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"release_flag";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\" id=\"release_flag";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" value=\"N\">  \n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl_val";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\" id=\"base_to_disp_uom_equl_val";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl_val";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\" id=\"base_to_def_uom_equl_val";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"dischargeIND";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\" id=\"dischargeIND";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\">\n                         \t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\n\n\t\t\t\t\t\t<input type=\"hidden\" name=\"allow_decimals_yn";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\" id=\"allow_decimals_yn";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_line_num_";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" id=\"order_line_num_";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\"><!--added for GHL-CRF-0453 -->\n\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_id_";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\" id=\"order_id_";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\"> <!--added for GHL-CRF-0453 -->\n\t\t\t\t\t\t<input type=\"hidden\"  name=\"drug_code_";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\" id=\"drug_code_";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\"> <!--added for GHL-CRF-0453 -->\n";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\n\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_id";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\" id=\"order_id";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\n\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(eval(\'document.DispMedicationAllStages.allocateyn_\'+recCount).value = \"N\";\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\n                     <td class=\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\" nowrap>   <!--modified for AAKH-CRF-0117 --> \n\t\t\t\t\t <input type=\"text\" value=\"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\" maxlength=\"20\" onchange=\"getApprovalNumForDrug(this,";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 =")\"   name=\"approval_no_";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 =" onKeyPress=\"return KeyPressSpecCharsForApprovalNo(event)\" onBlur=\"CheckForSpecCharApprovalno(this,\'A\',";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 =")\"/> <!--MODIFIED FOR AAKH-CRF-0117  again modified for  CRF-0117-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\n\t\t\t\t\t\t<img id=\"imgForWithin_";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\" style=\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\"></img><!-- AAKH-CRF-0117 -->\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\n\t\t\t\t\t </td>\n";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\n<tr><td colspan=\"14\">\n";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\n    <label style=\"color:red;font-size: 9px;\">";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="&nbsp;&nbsp; :</label>\n    <label style=\"font-size: 9px;\" >";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="</label> </br>\n";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\n   <label style=\"color:red;font-size: 9px;\">";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="&nbsp;&nbsp; :</label>\n   <label style=\"font-size: 9px;\">";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="</label> \n";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\n</td></tr>\n";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td> \n\t\t\t\t\t\t\t\t<td class=\"data\"><label style=\"cursor:pointer;color:blue\" onclick=\"CallPreparationChargeDetails(\'";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\',";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 =",mark_up_down,bl_decimal_format_str,\'A\')\" id=\"prep_charges\">";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="(";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 =")</label></td>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td>  <td class=\"data\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\"gross_admx_prep_charge_legend\" align=\"center\">&nbsp;";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\"groos_pat_payable_admx_prep_charge_legend\" align=\"center\">&nbsp;";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td>  <td class=\"data\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td> \n\t\t\t\t\t\t\t\t<td class=\"data\"><label  id=\"prep_charges\">";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="</label></td>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\">&nbsp;</td> <td class=\"data\">&nbsp;</td>  <td class=\"data\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\"gross_admx_prep_charge_legend\" align=\"center\">&nbsp;";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"gross_admx_prep_charge\" id=\"gross_admx_prep_charge\" value=\"";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_admx_prep_charge\" id=\"groos_pat_payable_admx_prep_charge\" value=\"";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"mark_up_down\" id=\"mark_up_down\" value=\"";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"old_mark_up_down\" id=\"old_mark_up_down\" value=\"";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ItemForAdmixPrepCharges\" id=\"ItemForAdmixPrepCharges\"value=\"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bl_decimal_format_str\" id=\"bl_decimal_format_str\" value=\"";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id_1\" id=\"bean_id_1\" value=\"";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name_1\" id=\"bean_name_1\" value=\"";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\">\n\t\t\t<input type=\"hidden\" name=\"ordering_facility_id\" id=\"ordering_facility_id\" value=\"";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\">\n\t\t\t<input type=\"hidden\" name=\"ord_date_time\" id=\"ord_date_time\" value=\"";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\">\n\t\t\t<input type=\"hidden\" name=\"performing_pract_id\" id=\"performing_pract_id\" value=\"";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\">\n\t\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\">\n\t\t\t<input type=\"hidden\" name=\"allocate_status\" id=\"allocate_status\" value=\"";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\">\n\t\t\t<input type=\"hidden\" name=\"ws_type\" id=\"ws_type\" value=\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\">\n\t\t\t<input type=\"hidden\" name=\"curr_stage\" id=\"curr_stage\" value=\"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_level\" id=\"disp_level\" value=\"";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_catg\" id=\"disp_locn_catg\" value=\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\">\n\t\t\t<input type=\"hidden\" name=\"ord_type\" id=\"ord_type\" value=\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\">\n\t\t\t<input type=\"hidden\" name=\"IssueByUOM\" id=\"IssueByUOM\" value=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\">\n\t\t\t<input type=\"hidden\" name=\"IncludeZeroQty\" id=\"IncludeZeroQty\" value=\"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\">\n\t\t\t<input type=\"hidden\" name=\"EquivalentNormalOrder\" id=\"EquivalentNormalOrder\" value=\"";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\">\n\t\t\t<input type=\"hidden\" name=\"tpn_wrksheet_rcrd\" id=\"tpn_wrksheet_rcrd\" value=\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\">\n\t\t\t<!--<input type=\"hidden\" name=\"allow_yn\" id=\"allow_yn\" value=\"\">  allow_yn --> \n\t\t\t<input type=\"hidden\" name=\"pres_qty_alert\" id=\"pres_qty_alert\" value=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\"><!-- code added for AMS-CRF-0035[IN033551] -->   \n\t\t\t<input type=\"hidden\" name=\"includeBMSDefCheck_yn\" id=\"includeBMSDefCheck_yn\" value=\"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\"><!-- code added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) -->   \n\t\t\t<input type=\"hidden\" name=\"strAutoCompletePartialDisp\" id=\"strAutoCompletePartialDisp\" value=\"";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\"><!-- Added for JD-CRF-0179 [IN:41211] -->\n\t\t\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\" value=\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t<input type=\"hidden\" name=\"disp_decimal_dtls_yn\" id=\"disp_decimal_dtls_yn\" value=\"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t<input type=\"hidden\" name=\"allow_amend_alt_drug_dtl\" id=\"allow_amend_alt_drug_dtl\" value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\"> <!--  Added for JD-CRF-0198 [IN058599] -->\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\"><!-- added for GHL-CRF-0453-->\n\t\t\t<input type=\"hidden\"  name=\"displayGrossAmtYn\" id=\"displayGrossAmtYn\" value=\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\"><!-- added for ML-BRU-CRF-0469 -->\n\t\t\t<input type=\"hidden\" name=\"intractn_req_yn\" id=\"intractn_req_yn\" value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\"><!-- Added for MMS-KH-CRF-0028 [IN070605] -->\n\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\" ><!--added for mms-kh-crf-0028-->\n\t\t\t<input type=\"hidden\" name=\"approval_no_flag\" id=\"approval_no_flag\" value=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\"><!-- AAKH-CRF-0117-->\n\t\t\t<input type=\"hidden\" name=\"approval_no_app_for_patient_class\" id=\"approval_no_app_for_patient_class\" value=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\"> <!-- AAKH-CRF-0117-->\n\t\t\t<input type=\"hidden\" name=\"approval_no\" id=\"approval_no\" value=\"\"> <!-- AAKH-CRF-0117-->\n\n";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\n\t\t\t\t<input type=\"hidden\" name=\"bl_encounter_id\" id=\"bl_encounter_id\" value=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_patient_class\" id=\"bl_patient_class\" value=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_sysdate\" id=\"bl_sysdate\" value=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\">\t\n\t\t\t\t<!-- added for ML-BRU-CRF-0469 start-->\n\t\t\t\t";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\n\t\t\t\t<input type=\"hidden\" name=\"tot_gross_amount\" id=\"tot_gross_amount\" value=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\n\t\t\t\t<!-- added for ML-BRU-CRF-0469 end-->\n\t\t\t\t<input type=\"hidden\" name=\"tot_gross_charge_amount\" id=\"tot_gross_charge_amount\" value=\"";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tot_groos_pat_payable\" id=\"tot_groos_pat_payable\" value=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"admx_prep_charges_appl_yn\" id=\"admx_prep_charges_appl_yn\" value=\"";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\">\t\n";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\n\t\t</form>\n";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\n\t\t\t<script>alert(getMessage(\"PH_ITEMS_UOM_DEF_NOT_FOUND\",\"PH\"));</script>\n";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\n\t\t</body>\n\t\t<script>\n\t\t\tcallLegendsFrame(\'";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\');//added for ML-BRU-CRf-0469  tot_gross_amount_str  \n\n";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n\t\t\t\tdisableFillOrAllocate();\n";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n\t\t\tenableDisableButton(document.getElementById(\"stock_availability_check1\"));\n";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\n\t\t\t\ttry{\n\t\t\t\t\tfor(var i=1; i<";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 =";i++){\n";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\n\t\t\t\t\t\t\tif(eval(\'document.DispMedicationAllStages.alloc_qty_\'+i).value != \'\')\n\t\t\t\t\t\t\t\tcalculateIssueUOM(eval(\'document.DispMedicationAllStages.issue_uom_select_\'+i),i,eval(\'document.DispMedicationAllStages.issueUOMValue_\'+i).value,\'NO\',eval(\'document.DispMedicationAllStages.approval_no_\'+i).value); // .value added forMMS-SCF-0040 [IN:041888] and modified for AAKH-CRF-0117\n";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tcatch(exp){\n\t\t\t\t}\n";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\n\t\t</script>\n";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\n</html>\n\n";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );
	
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

 
		DecimalFormat dfToInteger = new DecimalFormat("#.####");
		private String retunFormatedInt(String sValue){
			if(sValue != null && !sValue.equals("")){
				return dfToInteger.format(Double.parseDouble(sValue));
			}
			return "";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
      
        Connection con			= null;  // Added for ML-MMOH-SCF-0356.1 - start
		try{
        con				= ConnectionManager.getConnection(request);
        boolean complete_ord_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","COMPLETE_ORD_YN");// Added for ML-MMOH-SCF-0356.1 - End
     	boolean displayGrossAmtYn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");// Added for ML-BRU-CRF-0469 
			boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP");//added for GHL-CRF-0549
			boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
			boolean intractn_req_yn = CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 
			 boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117 
			//boolean approval_flag = false;//AAKH-CRF-0117	and commented for CRF-0117		 
			boolean barcode_scan_for_alt_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BARCODE_SCAN_FOR_ALT_APP"); //MMS-KH-CRF-0030
			boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
			boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
		boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
    	String	bean_id				=	"DispMedicationAllStages" ;
			String	bean_name			=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			bean.loadReason();
			bean.setModuleId("2");

			String	bean_id_1		    =	"DispMedicationBean" ;
			String	bean_name_1		    =	"ePH.DispMedicationBean";
			String bl_install_yn		    =	 CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ;//GHL-CRF-0549
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1 , bean_name_1,request);
			bean_1.setLanguageId(locale);
			bean_1.setObject(bean);
			String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]

			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			/** Stock Bean Integration -Start ***/
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			String sDispDrugAuthYN				= "N";
			String alt_drug_flag      ="N";
			String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start
			String stSalseBean_name			    =    "eST.SalesBean";
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
			String medical_applicable="";//added for ghl-crf-0548
			//changed during PE By Naveen
			//String strIncludeZeroQty = bean_1.getStrIncludeZeroAllocQtyItems()==null?"N":bean_1.getStrIncludeZeroAllocQtyItems();
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN();  // Added for JD-CRF-0198 [IN058599]
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 	// Added for JD-CRF-0179 [IN:41211]
			String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
					try{ 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //  Added for AAKH-SCF-0113 [IN:048937] 
			st_no_of_decimals = bean.getSt_no_of_decimals(); //  Added for AAKH-SCF-0113 [IN:048937] 
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); //  Added for AAKH-SCF-0113 [IN:048937] 
			String display_list = "";
			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";

			boolean bPatientPaid	=  false;

			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";

			String strAllocBMSChkValue = "N";
			String strAllocBMSChecked = "";

			ArrayList alEditLabelPair			= new ArrayList();
			HashMap hmEditLabelValues			= new HashMap();
			boolean bEditLabelEnabled			= false;
			ArrayList listRecord				= new ArrayList();  // Added for KAUH-SCF-0094 [IN:035252] -- begin
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 		// Added for KAUH-SCF-0094 [IN:035252] -- end

			String barcode_id = "";//Added for KDAH-CRF-0231 [IN-034551]
					
			if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP";
			}
			String tpn_wrksheet_rcrd	= "N";
			String tpn_finalize = request.getParameter("TPN_FINALIZE");
			if(tpn_finalize==null)tpn_finalize = "";
			if(tpn_finalize.equals("YES")){
				bean_1.setWsStatus("C");
				tpn_wrksheet_rcrd	= "Y";
			}
			else if(tpn_finalize.equals("NO")){
				bean_1.setWsStatus("I");
				tpn_wrksheet_rcrd	= "N";
			}

				//added for AAKH-CRF-0117 - start
			String approval_no_app_for_patient_class = "N";
			if(approval_no_flag){
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass(patient_class);
			}
			//added for AAKH-CRF-0117 - end
			String allocate_status			= bean_1.getAllocatedStatus();
			Hashtable param_legends			= bean_1.getLegendsFromParam();
			String disp_stage				= bean_1.getDispStage();
			String disp_locn_code			= bean_1.getDispLocnCode();
			String order_type				= bean_1.getOrderType();
			String legend					=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
			String scope					= bean_1.getScope();
			String legend1					= "";
			String legend_text				= "";
			String complete_order_value		= "";
			String complete_order_checked	= "";
			String disable_complete_order	= "";
			String pat_reqd					="";
			String pt_couns_reqd_yn			="";
			String dischargeIND				="";
			String strBMS_Include_yn ="N";// Added for [IN:045295]
			boolean bKeepQty				= false;
			ArrayList disp_info			=	new ArrayList(2);
			int adr_count					=  0;
			double ws_tot_qty				= 0;
			float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			String order_line_status = "";   // Added for JD-CRF-198
			String pres_strength_1        = ""; //MMS-KH-CRF-0030
			String pat_paid_amt	,pat_net_charge_amt; //Added FOR ML-BRU-SCF-1281 [IN:047783] -ISSUE 1
			if(bean_1.getBarcode_Scan_YN()!=null && bean_1.getBarcode_Scan_YN().equals("Y")){// if block added for KDAH-CRF-0231 [IN-034551]
				bean_1.getBarCodeflg(facility_id,disp_locn_code);
			}
			if(scope.equals("H")){
				legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";
			}
			String disable_all  ="";
			 if(((disp_stage.equals("F") && (bean_1.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("B")  )))&&(!disp_locn_catg.equals("I")) ){
				 
				 bKeepQty = bean_1.getEditValues(); // This value should be used to load the qty values frm database if allocation is in second stage.
				if(!bKeepQty){
					 disable_all ="disabled";
					 display_list="display:none";
				}		 
			}

			String patient_id			= request.getParameter("patient_id");
			String encounter_id			= bean_1.getEncounterID();
			String order_id				= request.getParameter("order_id");
			String alt_drug_qty			= "";
			if (order_id==null){
				order_id	=	"";
			}	
			
			if (patient_id==null){
				patient_id	=	"";
			}
			String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            String bean_name2		= "ePH.PrescriptionBean_1"; 
            PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End
			//Declaration starts
			String order_line_no		=	"";
			String drug_code			=	"";
			String drug_name			=	"";
			String dosage_dtls			=	"";
			String end_date				=	"";
			String start_date           =   ""; // Added for MMS-KH-CRF-0013
			String pres_qty				=	"";
			String qty_uom				=	"";
			String alt_drug_code		=	"";
			String alt_drug_desc		=	"";
			String drug_color			=	"";
			String form_code			=	"";
			String form_desc            = ""; // Added for MMS-KH-CRF-0013
			String hold_status			=	"";
			String remark_status		=	"";
			String uom					=	"";
			String check_status			=	"";
			HashMap pack_dtls			=	null;
			String title_remarks		=	"";
			String tmp_bms_qty			=	"";
			String title				=	"";
			String pres_details			=	"";
			String pat_couns_reqd_yn	=	"";
			int bmscount                =    0;
			String visibility1			=	"";
			String visibility2			=	"";
			String strChangedFludRmks	=	"";
		//code added for drug remarks
			String drug_remarks			=	"";
			String prn_remarks			=	"";
			String pharma_remarks		=	"";		
			String pres_remarks			=	"";
			String slidingscaleremarks	=   "";
			String verificationremarks	=	"";
			String remarks_style		=	"";	
			float dialog_height			=	0;
			String admixture_yn			=  "N";
			String qty_uom_disp			=  "N";
			String strength_uom_disp	=  "N";
			//ends here
			String currentdateplusAllocatePeriod		=  	"";			//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			boolean	endDateIsbeforAllocatedate			= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			String home_med_yn = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",  disc_cancelled_orders_display="display:none;", disp_mnf_flag= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			String abuse_drug_override_reason="";//added for aakh-crf-0140  drug_abuse_appl
			String abuse_exists="";//added for aakh-crf-0140
			String drugIndication="";//added for jd-crf-0220		
			String drug_expiry_alert ="";//Added for TH-Kw-CRF-0008
			String drug_expiry_days  = "";//Added for TH-KW-CRF-0008
			String insurance_status ="";//Added for TH-KW-CRF-0012
			HashMap insuranceStatus = bean.getInsuranceStatus();//Added for TH-KW-CRF-0012
			String	category_code="";//added for mms-dm-crf-209.1
      String	alternate_yn="";//added for mms-dm-crf-209.1
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
			
			String min_stk_flag	=	"display:none;align:right";//Added for AMS-CRF-0068.1 [IN:050333] -start
			String min_stk_flag_bkg_clr	=	"background-color:none";
			String rol_flag_bkg_clr		=	"background-color:none";
			String rol_flag			=	"display:none";
			String disp_req_flag	= "display:none;color:blue";
			String FillingStatus=bean_1.getFillingStatus();
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {"", "", "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			//Declaration ends

			String disp_level	= bean_1.getDispLevelValue();
			String disp_catg	= bean_1.getDispLocnCatg();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();
			
			String iv_prep_yn = "";	
			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
				if(alOrderIds != null && alOrderIds.size()>0){
					iv_prep_yn		=   bean.getIVFlag(alOrderIds.get(0).toString());
					iv_prep_yn		=	iv_prep_yn==null?"":iv_prep_yn;
					bean_1.setWsType(iv_prep_yn);
				}
			}
			if(disp_level.equals("P")) {
				// criteria is patient wise		
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());
				if(bean_1.getOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {		//10 ->11  for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 ->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607 //Modified for RUT-CRF-0088 [IN036978]  13 ->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
				for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 ->11
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
			else {// criteria is order wise
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			String ws_type				=   bean_1.getWsType()==null?"": bean_1.getWsType();
			String allergy				=	"";
			String exceed_dose			=	"";
			String generic_id			=	"";
			String generic_name			=	"";
			String dosage_details		=	"";
			String exceed_status		=	"";
			String monograph			=	"";
			String dosage_type			=	"";
			String dosage_unit			=	"";
			String std_dose             =   "";
			String unit_dose			=	"";
			String daily_dose			=	"";
			String bms_qty				=	"";
			String source_code			=	"";
			String source_type			=	"";
			String ordering_facility_id =	"";
			String ord_date_time		=	"";
			String performing_pract_id	=   "";
			String duplicate_yn			=	"";
			String min_dose_dtls		=	"";
			String min_unit_dose		=	"";
			String min_daily_dose		=	"";
			String alloc_qty_from_tmp	=	"";
			String strength_uom			=	"";
			String strength_value		=	"";
			String module_id			=	bean.getModuleId(); 
			ArrayList stock_opt			=	new ArrayList();
			double	tot_qty				=	0;
			String image				=	"";
			//code added for in_formulary....drugs..
			String in_formulary_yn		=	"";
			String drug_class			=	"";
			String expired_yn			=	"";
			String ext_prod_id			=	"";
			ArrayList complete_reason_codes		=  (ArrayList)bean.getCompleteReasonCodes();
			String disp_delivery_chk_box_val	=   "Y";
			String billing_interface_yn			=   bean.getBLInterfaceYN();// checkforbillinginterface();
			String width						=   "100%";
			String bl_encounter_id				=	bean_1.getEncounterID();
			String bl_patient_class				=   "";
			String bl_display                   =   "Y"; 
			String ord_type						=	bean_1.getOrderType();
			String sysdate						=   bean_1.getTodaysDate();
			String gross_admx_prep_charge		=	"";
			String groos_pat_payable_admx_prep_charge	=	"";
			//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
			String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
			//ends here
			boolean bEquivalentNormalOrder		= false;
			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;
			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  ){
				display_list ="display:none" ;
			}
			float tot_gross_charge_amount		=   0;
			float tot_groos_pat_payable			=   0; 
			float  tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
			String tot_gross_charge_amount_str	=  "";
			String tot_groos_pat_payable_str	=  "";
			String tot_gross_amount_str         =  "";	// added for ML-BRU-CRF-0469
			String gross_charge_amount_str		=  "";
			String groos_pat_payable_str		=  "";
			String gross_amount_str             =  ""; //added for ML-BRU-CRF-0469
			String decimalFormatString			=  "";
			String	batch_str					=  "";
			String image_path					=  "";
			String trade_code					=  "";
			HashMap batch_data=new HashMap();//Added for KAIH-SCF-0094[Inc:35252]
			ArrayList temp=  new ArrayList();//Added for KAIH-SCF-0094[Inc:35252]
			String worksheet_id					=  bean_1.getWorksheetID();
			String admx_prep_charges_appl_yn    =  bean_1.getadmx_prep_charges_appl_yn();
			/*=================code for auto defaulting batches for normal RX===============*/
			ArrayList items						=	null;
			ArrayList alloc_drug_detail			=	null;
			HashMap batch_det					=	null;	
			ArrayList stock_det					=	null;
			HashMap	 stock						=	null;	
			String item_code					=	"";
			String store_code					=	"";
			String fill_period					=	null;
			String fill_unit					=	null;
			String item_cost					=   "";
			String issue_qty					=	"";
			double tmp_unit_qty					=	0;
			double tot_issued_qty				=	0;
			String avail_qty					=	"";
			String act_bms_qty					=	"";
			float opdispperiod					=	0;	
			String alloc_readonly				=   "";
			String billable_item_yn				=	"";
			String alt_drug_remarks_ind =  bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();//added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
			int count = 0;
			if(ord_type.equals("TA")){
					bl_display                   ="N";        
			}
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				 width="120%"; 
				 bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
			}
			if(!order_type.equals("TA")){	
				if(((bean_1.getHTWSAllocateBatches()).size()==0)&&(!worksheet_id.equals(""))){
					bean_1.setWSDrugDetails(order_id,worksheet_id);
					bean_1.setWSBatchDetails(order_id);
				}
			}
			String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551]					
			String barcodeScan = ""; // Added for GHL-CRF-0463 - Start
			String last_scanned ="";
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN();
			  // last_scanned = bean_1.getScannedBarcode_id();//removed for mms-dm-scf-0488
			}// Added for GHL-CRF-0463 - End

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(barcodeScan));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(last_scanned));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(width));
            _bw.write(_wl_block11Bytes, _wl_block11);
	                if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block14Bytes, _wl_block14);
					
                    } //Added for MMS-KH-CRF-0028 [IN070605] - End
					else{
                    
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(param_legends.get("V")));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
					if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	//GHL-CRF-0549

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

					if(formulary_billing_app){	//GHL-CRF-0618
					
            _bw.write(_wl_block21Bytes, _wl_block21);
}	 

					} 
            _bw.write(_wl_block22Bytes, _wl_block22);
if(aggred_item_app){
            _bw.write(_wl_block23Bytes, _wl_block23);
} 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 
					if(billing_interface_yn.equals("Y") && bl_display.equals("Y")){

            _bw.write(_wl_block31Bytes, _wl_block31);
if(bean.getDisplayInsStatus()){ 
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);
if(displayGrossAmtYn){
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

					}

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(legend));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(approval_no_flag){ //added for AAKH-CRF-0117 
					
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);

				String classvalue		    =	"";
				String strength			    =	"";
				String pres_strength	    =	"";
				String alt_strength_value	=	"";
				String alloc_strength		=	"";
				String bms_strength			=	"";
				String 	hold_text		    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
				String check_value          =   "N";
				String fromdb               =   "N";
				String narc_style			=	"";
				float main_pack_size		=   0;
				String tmp_bms_qty_1		=	"";
				float main_drug_pack_size   =	0;
				String main_strength_per_value_pres_uom ="";
				HashMap IssueUOMAndBaseUOM       = new HashMap();
				HashMap IssueUomQty			     = new HashMap();
				String issue_qty_value		     = "";	  
				String issue_uom_desc            = ""; 
				String dflt_issue_uom		     = "";
				String base_uom				     = "";
				String issue_uom			     = "";
				String issue_uom_equl            = "";
				double base_to_disp_uom_equl     = 0;
				double base_to_def_uom_equl      = 1;
				double issue_qty_val			 = 0;
				double conv_factor				 = 1;
				StringBuffer issue_qty_dtl       = new StringBuffer();
				boolean item_uom_definition_flag = false;
				String zero_alloc_qty_item_yn    = "N";
				String sOrderTypeFromResult      = "";
				int recCount					=	1;
				double tmp_alloc				=	0;
				int iOrderTypeCount				=	0;
				String sRepeatFreqCode		    = null;
				String sFreqCode			    = null;
				boolean bPRNOrAbsOrder		    = false;
				boolean	bDrugOrder				= true;
				Set stDrugCodes					= new HashSet();
				String disable_alloc_text_box   = "";
				HashMap OrderIDS                = new HashMap();
				//String taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;  // Commented for RUT-CRF-0088 [IN036978]
				String show_remarks, taper_disable;  //Added for RUT-CRF-0088 [IN036978]  
				HashMap Order_id_amend_yn = null;
				Hashtable ht_ws_allocated_batches = null;
				Hashtable ht_ws_alloc_qty = null;
				Hashtable ht_drug_details = null;
				String alt_drug ="", ws_item_code="", ws_drug_code="", sOrderType, sAbsOrder, nar_cnt_drug, qty, sOrigDispUnit, sOrigDispPeriod, taper ; 
				String qty_avail_from_spillage = "0";
				StringTokenizer st = null; 
				StringTokenizer dose = null; 
				StringTokenizer min_dose = null; 
				ArrayList multi_drugs = null;
				HashMap hm= null;
				HashMap issue_uom_qty_hm = null;
				ArrayList alValues = null;
				HashMap hmUOMValues = null; 
				String stk_unit_code	= "";
				String stk_unit_desc	= "";
				String stk_equval_value	= "";
				String act_stk_equval_value	= "";

				String base_to_def_uom_equl_val  ="1";
				String base_to_disp_uom_equl_val ="1";
				int	k	=	0;
				ArrayList alt_qty	=	new ArrayList();
				String 	drug_name_1=  ""; 
				String alt_external_prod_id ="";
				LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				HashMap printValue = bean_1.getPrintValue(); //GHL-CRF-453
				String print_value = "";//GHL-CRF-453
				//GHL-CRF-0549 - start
				String bl_grp_app	  = "";

				String mm_item_low_cost_yn = "";	
				String mm_item_high_margin_yn = "";
				String mm_item_Innovator_yn = "";
				boolean matched_entry_flow = false;
				String low_cost_green_style ="visibility:none";
				String high_margin_green_style ="visibility:none";
				String high_margin_red_style   ="visibility:none";
				String low_cost_red_style	="visibility:none";
				String low_cost_grey_style ="visibility:none";
				String high_margin_grey_style ="visibility:none";
				String innovator_style		="visibility:none";
				String item_type = "";
				String dose_unit_desc="";//added for ML-MMOH-CRF-1408
				String ceil_dose_unit_desc = "";//added for ML-MMOH-CRF-1408
				ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
				String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
				String allow_alternate_yn="";//added for mms-kh-crf-0028
	            String expiry_date="";//added for mms-kh-crf-0028
				String alt_called_from="";//added for MMS-KH-CRF-0028
				String approval_no_style = "visibility:hidden"; //AAKH-CRF-0117
				String issue_token_on_regn_YN = bean_1.getIssueTokenOnRegnYN(); //ML-BRU-SCF-2049 & ML-BRU-SCF-2055
				if(item_type_site_app && !encounter_id.equals(""))
				bl_grp_app = bean.getItemTypeApp(patient_id);
				//GHL-CRF-0549 - end		
				if(bl_grp_app==null || bl_grp_app.equals(""))
					bl_grp_app = "N";
				HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
				HashMap approvalNo = bean_1.getApprovalNo();//AAKH-CRF-0117
			 String approval_no="";//AAKH-CRF-0117
			//GHL-CRF-0618 - start
				String preference = "";  
				String preference_img = ""; 
				String formulary_value = "";
				String formulary_code  = "";
				String blg_grp_type = "";
				HashMap hmBlgGrp = null;

				if(formulary_billing_app){
					String blng_grp_id = bean.getBillingGrpId();
					formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
					formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
					blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
					if(!formulary_code.equals(""))
					 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id);//blng_grp_id added for GHL-SCF-1527

				}
			//GHL-CRF-0618  - end



				for(int i=0;i<orderLineDtls.size(); i++){
					bDrugOrder			= true;
					sRepeatFreqCode		= "";
					sFreqCode			= "";
					disp_delivery_chk_box_val = "Y";
					strength			=	"";	
					hold_status			=	"";
					pres_strength		=	"";
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					image				=	"";
					alloc_strength		=	"";
					tmp_alloc			=	0;
					title_remarks		=	"";
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";
					main_drug_pack_size	=    0;
					strAllocBMSChecked   ="";
					disable_complete_order	=	""; 
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

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id				=	(String)orderLineDtls.get(i);
							OrderIDS.put(order_id,order_id) ;
							++i;
							++i;
							++i;
						}
						allergy					=	(String)orderLineDtls.get(i);
						exceed_dose				=	(String)orderLineDtls.get(++i);
						++i;
						drug_code				=	(String)orderLineDtls.get(++i);
						drug_name				=	(String)orderLineDtls.get(++i);
						dosage_dtls				=	(String)orderLineDtls.get(++i);
						//++i; commented for MMS-KH-CRF-0013
						start_date              =   (String)orderLineDtls.get(++i); // added for MMS-KH-CRF-0013
						end_date				=	(String)orderLineDtls.get(++i);
						pres_qty				=	(String)orderLineDtls.get(++i);
						qty_uom					=	(String)orderLineDtls.get(++i);
						qty_uom_disp			=	(String)orderLineDtls.get(++i);
						order_line_no			=	(String)orderLineDtls.get(++i);
						generic_id				=	(String)orderLineDtls.get(++i);
						if(generic_id.equals("MEDICALITEM"))
							bDrugOrder				= false;

						generic_name			=	(String)orderLineDtls.get(++i);
						dosage_details			=	(String)orderLineDtls.get(++i);
						bms_qty					=	(String)orderLineDtls.get(++i);
						act_bms_qty             =	bms_qty;
						source_code				=   (String)orderLineDtls.get(++i);
						source_type				=   (String)orderLineDtls.get(++i);
						ordering_facility_id	=   (String)orderLineDtls.get(++i);
						ord_date_time			=   (String)orderLineDtls.get(++i);
						performing_pract_id		=   (String)orderLineDtls.get(++i);
						duplicate_yn			=   (String)orderLineDtls.get(++i);
						min_dose_dtls			=   (String)orderLineDtls.get(++i);
						alloc_qty_from_tmp		=   (String)orderLineDtls.get(++i);
						strength_value			=	(String)orderLineDtls.get(++i);
						if(end_date.length() >=10)
							end_date		=	end_date.substring(0,10);
					
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 and bean_1.getTokenNo() removed for ML-BRU-SCF-2055.1 - start
							if(issue_token_on_regn_YN!=null && issue_token_on_regn_YN.equals("Y") ){
								if(!ordering_facility_id.equals(""))
								 bean_1.setOrderingFacility(ordering_facility_id);
							}
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 - end
						currentdateplusAllocatePeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString(); 	//Added for ML-BRU-SCF-0905 [IN:041285]- Start	
						endDateIsbeforAllocatedate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusAllocatePeriod,"DMY",locale);

						if(!endDateIsbeforAllocatedate){
							end_date=currentdateplusAllocatePeriod;
						}//Added for ML-BRU-SCF-0905 [IN:041285] ended

						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1 &&Float.parseFloat(strength_value)!=0)
							strength_value = Float.parseFloat(strength_value) +"" ;

						strength_uom			=	(String)orderLineDtls.get(++i);
						strength_uom_disp		=	(String)orderLineDtls.get(++i);
						// For Multi Frequency 
						sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
						sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];
						stDrugCodes.add(drug_code); // to Add drug codes for authorization check

						trade_code				= (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
						if(generic_id.equals("MEDICALITEM")){
						   drug_trade_bean.setDrugyesno("");
						}
						else{
							drug_trade_bean.setDrugyesno("Y");
						}
						image_path				=   drug_trade_bean.getImagePath(drug_code,trade_code);				
						pack_dtls			    =	bean.getPackSize(drug_code);

						if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
							if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
								main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
							 }		
						 }
						alt_drug			=bean.checkMultiStrength(drug_code);
						//Added for KAIH-SCF-0094[Inc:35252]-Start
						batch_data= (HashMap) bean.getbatchString(patient_id,order_id,order_line_no,drug_code);
						int medi_count=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
						if(medi_count>0){
							alt_drug="Y";
						}
						if( (alt_drug.equals("N") || alt_drug.equals(""))){
							for(int j=0;j<batch_data.size();j++){
								  temp=(ArrayList)batch_data.get(order_id+order_line_no+drug_code);
									for(int k1=0;k1<temp.size();k1=k1+4){
										trade_code=(String)temp.get(k1);
								}
							}
						}//Added for KAIH-SCF-0094[Inc:35252]-End
						//pat_couns_reqd_yn     =   bean.getPatCounsReqdyn(order_id, order_line_no);
						bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
						bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
						pres_details	        =	bean.getPresDetails(order_id);
						if(order_type.equals("IVI") ||  order_type.equals("CA"))
							strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
						else
							strChangedFludRmks ="";

						if(strChangedFludRmks != "" && strChangedFludRmks != null)
							classvalue = "FLUDCOLOR";
					//GHL-CRF-0453 - start
						if(printValue!=null && printValue.size()>0){
							print_value = (String)printValue.get(order_id+order_line_no);
						}
					//GHL-CRF-0453 - end
						// Written for Worksheet (Starts)
						ws_tot_qty = 0;
						ht_ws_allocated_batches = bean_1.getHTWSAllocateBatches();
						if(ht_ws_allocated_batches.get(order_line_no) != null){
							ArrayList arr_list = (ArrayList)ht_ws_allocated_batches.get(order_line_no);	
							ht_ws_alloc_qty    = (Hashtable)bean_1.getHTWSAllocatedQty();
							ht_ws_alloc_qty = (Hashtable)ht_ws_alloc_qty.get(order_line_no);
							ws_item_code = "";
							ws_drug_code = "";
							if(arr_list.size()>1){
								ws_item_code = (String)arr_list.get(0);
								ws_drug_code = (String)arr_list.get(2);
							}
							
							if(ht_ws_alloc_qty != null && ht_ws_alloc_qty.get(ws_item_code+ws_drug_code) != null){
								ArrayList arr_list_alloc_qty = (ArrayList)ht_ws_alloc_qty.get(ws_item_code+ws_drug_code);
								for (int jj=0;jj<arr_list_alloc_qty.size();jj++){
									ws_tot_qty += Double.parseDouble((String)arr_list_alloc_qty.get(jj));
								}	
							}
							ht_drug_details	    = bean_1.getAllDrugDetails();
							ArrayList arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);
							qty_avail_from_spillage = "0";
							if(arr_list_drug_details != null)
								qty_avail_from_spillage= (String)arr_list_drug_details.get(3);

							ws_tot_qty += Double.parseDouble(qty_avail_from_spillage);
						}// Written for Worksheet ends

						if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
							if(bean.getFirstTime(order_id).trim().equals("true")) {
								HashMap drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
								ArrayList multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								ArrayList main_detail	=	(ArrayList)drug_detail.get("main_detail");
								HashMap   alt_detail	=	(HashMap)drug_detail.get("alt_detail");
								if(multi_detail.size()==0) {
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
								}
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);

									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code			    =	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}
								}
								//bean.setFirstTime(order_id,false);
							}
						}
						stock_opt =(ArrayList)bean.getStockItems(drug_code);
						
						if(module_id.equals("2") /*&& stock_opt.size()==0*/ ) {  //SKR-SCF-1646
							st	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
							while(st.hasMoreTokens()){
								stock_opt.add((String)st.nextToken());
							}
						}						
						else{
							++i;
						}
					
						 ext_prod_id  = (String)orderLineDtls.get(++i);
						//code added for in_formulary_yn ..added on 25/4/2004
						in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();

						if(in_formulary_yn.equals("N")){
							classvalue			=	"FORMULARY";
							disable_alloc_text_box ="disabled";
						}
						else{
							disable_alloc_text_box ="";
						}

						// IV_PREP_YN
						iv_prep_yn = (String)orderLineDtls.get(++i);
						//if( (((String)orderLineDtls.get(++i)).trim()).equals("N")) {
						if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
							if(order_line_no.equals("1")){
								classvalue="IVFLUID";
							}
							else{
								classvalue="IVINGREDIENT";
							}
						}	//ended...
						// Drug class
						drug_class	=	(((String)orderLineDtls.get(++i)).trim());
						i=i+2;
						expired_yn  = (String)orderLineDtls.get(++i);
						if(expired_yn.equals("Y"))
						{
							if(expired_order) // Modified for MOHE-CRF-0032
								{
								classvalue="EXPIRED_ORDER";
								}
							else
							{
								classvalue="EXPIRED_MEDICATION";
							}
						 }
						i=i+1;  // i+2 changed to i+1   // added for JD-CRF-198
						order_line_status = (((String)orderLineDtls.get(++i)).trim()); // added for JD-CRF-198
						main_strength_per_value_pres_uom =(String)orderLineDtls.get(++i);
						i++;
						sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						i++;
						sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						if(sOrderType.equals("P") || sAbsOrder.equals("N"))
							bPRNOrAbsOrder = true;
						else
							bPRNOrAbsOrder = false;
						if(drug_class.equals("C") || drug_class.equals("N")) {
							narc_style	="color:brown";
							nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
							title		= "title='"+nar_cnt_drug+"'";
						}
						bean.setStockItems(drug_code,stock_opt);
						if(!strength_value.equals("0"))
							strength	=	strength_value+" "+strength_uom;
						dose	=	new StringTokenizer(dosage_details,":");
						if(dose.hasMoreTokens()) {
							exceed_status	=	dose.nextToken();
						}
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
						if(!dosage_unit.equals("")){ //added for ML-MMOH-CRF-1408 - start
							   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
		 						ceil_dose_unit_desc = dose_unit_desc ; //added for ML-MMOH-CRF-1408
								if(dose_unit_desc==null || dose_unit_desc=="" ) {
									if(dosage_unit.indexOf("/")!=-1){//if added for ML-MMOH-SCF-1627
		 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
		 						ceil_dose_unit_desc = dose_unit_desc ; //added for ML-MMOH-CRF-1408
								  if(dosage_unit.length()>=2){
		 							 dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
		 						  }
								}
		 						} 
	 						}//added for ML-MMOH-CRF-1408 - end
						min_dose	=	new StringTokenizer(min_dose_dtls,":");
						if(min_dose.hasMoreTokens()) {//added for ml-mmoh-scf-1997
							min_unit_dose	=	min_dose.nextToken();
						} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
						if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							min_daily_dose	=	min_dose.nextToken();
						}					
						multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
						alt_drug_remarks_disp="";
						if(multi_drugs.size() >0  && (alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")) ){// Added For Bru-HIMS-CRF-082 [IN:029948]-start
							alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
							if(alt_drug_remarks_ind.equals("M"))
								alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
						}// Added For Bru-HIMS-CRF-082 [IN:029948]-end
						qty			 = "";
						if(request.getParameter("resetQty")== null)
							qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
						else
							qty				= "";
						Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
						if(Order_id_amend_yn.containsKey(order_id)){
							Order_id_amend_yn.remove(order_id);
							qty			=  "";
						}
						if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
							tot_qty				+=	Double.parseDouble(qty);

						alt_drug_qty			=	"";
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code	=	(String)multi_drugs.get(n);
							alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
							if(!alt_drug_qty.equals(""))
							break;
						}
						if(!scope.equals("H")){
							if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) ||(ws_tot_qty>0)){
								hold_status	="disabled";
							}
						}
						if(bean.checkHold(order_id,order_line_no)) {
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
							check_value="Y";
							check_status="checked";
							fromdb="Y";
							remark_status	="visibility:visible";
						} 
						else {
							hm= bean.loadHoldRemarks(order_id,order_line_no);
							if (!hm.isEmpty()){
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								check_value="Y";
								check_status="checked";
								fromdb="Y";
								remark_status	="visibility:visible";
							}
							else{
								hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								remark_status	="visibility:hidden";
								check_status	="";
							}
						}
						/*-----code for displaying drug remarks---------------*/
						drug_remarks	    = "";
						prn_remarks		    = "";
						pharma_remarks	    = "";		
						pres_remarks        = "";
						slidingscaleremarks ="";
						remarks_style       = "";
						dialog_height       = 0;
						pres_remarks					=   bean.getPrescriptionInstructions(order_id);
						drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
						//IN071533 Start					
						if(iv_prep_yn!=null && !iv_prep_yn.equals("") && iv_prep_yn.equals("5")){
							drug_remarks = bean.getNonMFRfluidRemarks(order_id,order_line_no); 
						}
						//IN071533 end
						prn_remarks						=   (String)orderLineDtls.get(++i);
						pharma_remarks					=    bean.getPharmacistInstructions(order_id,order_line_no,"Y");
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
						dischargeIND					=	(String)orderLineDtls.get(++i);//from OR_ORDER dischargindicator
						strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295] 
						home_med_yn 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
						drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
						disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
						appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);//Added for  Bru-HIMS-CRF-080 -start
						//added for MMS-KH-CRF-0029 - start
						food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//modified for mms-md-scf-0141
							 disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null) //MMS-KH-CRF-0029
							lab_interaction_override_reason = "";
						if(food_interaction_override_reason==null) //MMS-KH-CRF-0029
							food_interaction_override_reason = "";
						//added for MMS-KH-CRF-0029 - end
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";


						if("Y".equals(appl_for_compounding_rx_yn)){
							disp_mnf_flag = "display:inline;color:blue";
						} //Added for  Bru-HIMS-CRF-080 -end
						if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
							disc_cancelled_orders_display="display:inline";
						else
							disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
						//Commented for RUT-CRF-0088 [IN036978] 
						/*taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
							alloc_qty_from_tmp = "0"; // added to avoid displaying qty for tapered drugs
						}
						else*/
						 abuse_drug_override_reason=(String)orderLineDtls.get(++i);//added for aakh-crf-0140
						abuse_exists=(String)orderLineDtls.get(++i);//aakh-crf-0140
						drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
						drug_expiry_alert = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
						drug_expiry_days  = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
						if(insuranceStatus.containsKey(order_id+order_line_no))
						insurance_status  = (String)insuranceStatus.get(order_id+order_line_no);//Added for TH-KW-CRF-0012
						System.err.println("drug_expiry_alert@@@=="+drug_expiry_alert+"insurance_status=="+insurance_status);
            category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
								System.out.println("category_code"+category_code);
						
						
					/* 	if(drug_abuse_appl &&( !abuse_drug_override_reason.equals("") && abuse_exists.equals("Y"))){
							 ABUSE_REMARKS_CLASS="ABUSE_REMARKS";//ADDED FOR AAKH-CRF-0140
							  ABUSE_REMARKS_YN="Y";//ADDED FOR AAKH-CRF-0140
							
						}
						else{
							ABUSE_REMARKS_CLASS="";
							ABUSE_REMARKS_YN="N";
						} */
				System.out.println("Dispmedicationallocation abuse_drug_override_reason"+abuse_drug_override_reason);
				System.out.println("DispmedicationAllocation abuse_exists"+abuse_exists);
						taper_disable="";
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());
						show_remarks = "N";
						if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){//modified for MMS-KH-CRF-0029
							show_remarks="Y";
						}
						if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
							if(bean.getFirstTime(order_id).trim().equals("true")) {
								HashMap drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
								ArrayList multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								ArrayList main_detail	=	(ArrayList)drug_detail.get("main_detail");
								HashMap   alt_detail	=	(HashMap)drug_detail.get("alt_detail");
								if(multi_detail.size()==0) {
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
								} 
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);
									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code			    =	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}
								}
								//bean.setFirstTime(order_id,false);
							}
						}
						drugs_remarks = new StringBuffer(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PractitionerPharmacistInstructions.label","ph_labels")+" : \n"); //code added for Bru-HIMS-CRF-416[IN045566]-- Start								
						if(!pres_remarks.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionInstructions.label","ph_labels")+" : "+pres_remarks.trim()+"\n");
						if(!slidingscaleremarks.trim().equals("")){
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
							bPRNOrAbsOrder=true; // Added for ARYU-SCF-100
						}
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
						//added for MMS-KH-CRF-0029 - end
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
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");			//code added for Bru-HIMS-CRF-416[IN045566]-- End	
							//!abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(!abuse_drug_override_reason.trim().equals(""))
								drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(!abuse_drug_override_reason.trim().equals(""))
								drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
					
							if(drugIndication !=null && !drugIndication.equals("")){
							drugs_remarks.append("Drug Indications : "+drugIndication.trim()+"\n");
						}
							if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("") &&show_remarks.equals("N") && abuse_drug_override_reason.trim().equals("") && drugIndication.equals("")){
							remarks_style	=	"style='visibility:hidden'";
							drugs_remarks.setLength(0);
						} 
						else {
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
						}/*-------------------------ends------------------------*/	
						tmp_bms_qty				=	bms_qty;

						main_pack_size		=   0;
						if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
							if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
								main_pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
								tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
							}		
						}
						else{
							tmp_bms_qty_1		=   tmp_bms_qty;
						}
						adr_count = bean.getADRCount(patient_id,drug_code);
						Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));
						
					   if(ord_type.equals("NOR") || bEquivalentNormalOrder){/*==============code for getting defult batches====================================*/
							items			=  (ArrayList)bean.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							store_code	=	bean_1.getStoreCode();
							opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());
							// For Multi Frequency
							sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
							sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
							if(sRepeatFreqCode.equals("W")){
								if(sOrigDispUnit.equals("H")){
									//opdispperiod = new Float(Math.ceil((opdispperiod/(24*7)))*7); // divide by 24 to make day and divide by 7 to convert to week and ceil it. // commented for ARYU-SCF-077
								    opdispperiod = new Float(Math.ceil((opdispperiod/7)*7));//Added for ARYU-SCF-0077 removed 24 because opdispperiod already converted to day in Bean 
								}
								else if(sOrigDispUnit.equals("D")){
									//opdispperiod = new Float(Math.ceil((opdispperiod/7))*7); // commented for ARYU-SCF-0077
									 opdispperiod = new Float(Math.ceil((opdispperiod/7)*7));//Added for ARYU-SCF-0077
								}
								else if(sOrigDispUnit.equals("M"))
									opdispperiod = new Float(Integer.parseInt(sOrigDispPeriod)*4*7);
							}
							else if(sRepeatFreqCode.equals("M")){
								if(sOrigDispUnit.equals("H"))
									opdispperiod = new Float(Math.ceil((opdispperiod/(24*30)))*30);
								else if(sOrigDispUnit.equals("D"))
									opdispperiod = new Float(Math.ceil((opdispperiod/30))*30);
								else if(sOrigDispUnit.equals("W"))
									opdispperiod = new Float(Math.ceil((opdispperiod/4))*30);
							}

							if(sFreqCode.equals("H")){
								fTotalDuration = fTotalDuration/24;
							}
							else if(sFreqCode.equals("W")){
								fTotalDuration = fTotalDuration*7;
							}
							else if(sFreqCode.equals("L")){
								fTotalDuration = fTotalDuration*30;
							}
							else if(sFreqCode.equals("Y")){
								fTotalDuration = fTotalDuration*365;
							}
							//if(end_date.length() >=10)
							//	end_date		=	end_date.substring(0,10);
						}
							if(bean.checkHold(order_id,order_line_no)|| scope.equals("H")){
								alloc_readonly ="disabled";  
							}
							else{
								alloc_readonly ="";  
							}
							tot_issued_qty  =0;
							IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
							base_to_disp_uom_equl	=	0;
							base_to_def_uom_equl	=	1;
							orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
							st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937] 
							if(bKeepQty && qty.equals("")){
								alValues = bean.setIssueUOMValuesLevelTwo(order_id,order_line_no,drug_code);
								for(int iCount =0 ;iCount<alValues.size();iCount++){
									hmUOMValues = (HashMap) alValues.get(iCount);
									qty = (String)hmUOMValues.get("DISP_QTY");
									if(alValues.size()==1){ // if the returned UOM values are single, then set all the values default else set the dflt_issue_uom values
									System.err.println("@@@ inside SetIssueUOM 1353==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
									}
									if(hmUOMValues.get("UOM_CODE").toString().equals(orig_dflt_issue_uom)){
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_def_uom_equl",(String)hmUOMValues.get("DEFAULT_EQUAL"));
									}
									else{
										System.err.println("@@@ inside SetIssueUOM 1363==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_disp_uom_equl", (String)hmUOMValues.get("DEFAULT_EQUAL"));
										dflt_issue_uom = (String)hmUOMValues.get("UOM_CODE");
									}
								}
								hold_status	="disabled";
								if(!qty.equals(""))
									bms_qty = (Double.parseDouble(bms_qty) - Double.parseDouble(qty))+"";
							}
							else
								dflt_issue_uom	= "";
							/*=============code added to handle if dispense uom and default uom in item store is different and variable UOM==========*/

							issue_uom_qty_hm =  bean.getIssueUomQty();
							if(dflt_issue_uom.equals("")){
								if(issue_uom_qty_hm.size()>0){
									if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
										dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
									}
								}

								if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
							}
							base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
							base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);
							base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);
							/*=======================ends here=========================================================================================*/
							if(request.getParameter("barcode_id")!=null){ //Added for KDAH-CRF-0231 [IN-034551]
								barcode_id = request.getParameter("barcode_id");
							}
							last_scanned = bean_1.getScannedBarcode_id(order_id,order_line_no); //Added for GHL-CRF-0463 //modified for MMS-DM-SCF-0488
									String use_after_expiry="";//SKR-SCF-1647
									use_after_expiry= bean.getItemUseAfterExpiry(item_code);
							if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("") /*&& stock_opt.get(0).equals("Y")*/ &&  (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551], SKR-SCF-1646 and SKR-SCF-1647
								if(disable_all.equals("disabled")&&qty.equals("")){
									zero_alloc_qty_item_yn ="Y";
								}
								else{
									zero_alloc_qty_item_yn ="N";
									if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){
										tmp_unit_qty    =	0;
										if(bPRNOrAbsOrder)
											tmp_unit_qty = Double.parseDouble(act_bms_qty);
										else{
											fill_period	= bean_1.getFillPeriod();
											fill_unit		= bean_1.getFillUnit();
											item_cost       ="";
											issue_qty       ="";
											float per_day	=Float.parseFloat(pres_qty)/ fTotalDuration;
											if(disp_catg.equals("I")){
												if(fill_unit.equals("H") && !fill_period.equals("")) {
													tmp_unit_qty	=	new Float((opdispperiod / 24 )* per_day).doubleValue();	
												}
												else if(fill_unit.equals("D")) {
													tmp_unit_qty	=	new Float((opdispperiod * per_day)).doubleValue();
												}
											}
											else{
												if(opdispperiod!=0){
													tmp_unit_qty= new Float(Math.ceil(per_day*opdispperiod)).doubleValue();
												}
												else{
												   tmp_unit_qty=new Float(Double.parseDouble(pres_qty)).doubleValue();
												}
											}
											if(tmp_unit_qty > (Double.parseDouble(act_bms_qty))) { //  || (count>1) ) {// removed for ML-BRU-SCF-1015 [IN:043355]
												 tmp_unit_qty =Double.parseDouble(act_bms_qty);
											}
										}
										if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // condition Added for [IN:064158] - Start
											  tmp_unit_qty=0;  
										  } // condition Added for [IN:064158] -End
										/*==========code added to handle if dispense uom and default uom in item store is different=================*/
										issue_qty_val			 =  0;
										if(base_to_disp_uom_equl!=base_to_def_uom_equl){
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
											// bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); //moved from common to  specific  MMS-SCF-0040 [IN:041888] // commented for IN:6585
											issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888]
											System.err.println("@@@ inside SetIssueUOM 1446==");
											bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); // Added for IN:6585
										}
										else{
											if(qty_uom!=base_uom){   //if block and else condition added for SKR-SCF-0377 [IN:030453]
												conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
												issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											}
											else{
												issue_qty_val  = tmp_unit_qty;	
											}
											System.err.println("@@@ inside SetIssueUOM 1458==");
											bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Moved from common to specific for  MMS-SCF-0040 [IN:041888]
										}                   

										//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+"");
										//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+"");
										System.err.println("@@@ inside SetIssueUOM 1463==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+"");
										//tmp_unit_qty =issue_qty_val;  //Commented for SKR-SCF-0377 [IN:030453]
										//item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);    //Commented for SKR-SCF-0377 [IN:030453]
										HashMap params			=	new HashMap();
										if( !(trade_code.equals(""))){
											params.put("ITEM_CODE",item_code+"="+trade_code); 	
										}
										else{
											params.put("ITEM_CODE",item_code);
										}
										params.put("STORE_CODE",store_code);
										params.put("TRN_QTY",issue_qty_val+"");
										params.put("INCLUDE_SUSPENDED","FALSE");
										if(use_after_expiry!=null && use_after_expiry.equals("N")){//SKR-SCF-1646,SKR-SCF-1647
										params.put("INCLUDE_EXPIRED","FALSE");
										}else if (use_after_expiry!=null && use_after_expiry.equals("Y")){
											params.put("INCLUDE_EXPIRED","TRUE");
										}
										params.put("CUT_OFF_DATE",end_date);
										params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
										params.put("ALREADY_USED_QTY","");
										params.put("MIN_EXP_DATE",end_date);
										params.put("BARCODE_ID",barcode_id);
										if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								           stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				                         }else{
										   stock				= (HashMap)bean_2.getBatches(params);
										 }
										stock_det           = (ArrayList)stock.get("BATCH_DATA");

										if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ // Added for KAUH-SCF-0094 [IN:035252] -- begin When Trade and Stock is blank, Alternate trade should be taken 
											bean_st.setIncludeSuspendedBatches("N") ;
											bean_st.setIncludeZeroStockBatches("N") ;
											bean_st.setIncludeExpiredBatches("N") ;//modified for SKR-SCF-1647  
											bean_st.setItem_code_from(item_code.trim()) ;
											bean_st.setItem_code_to(item_code.trim()) ;
											bean_st.setStore_code_from(store_code.trim()) ;
											bean_st.setStore_code_to(store_code) ;
											bean_st.setManufacturer_code("") ;
											bean_st.setPeriod_of_expiry("") ;
											bean_st.setBatch_id("%") ;
											bean_st.setTrade_Code("%") ;
											bean_st.setItemClassFrom("") ;
											bean_st.setItemClassTo("") ;
											bean_st.setDrugType("%") ;
											bean_st.setCuttOffDate(end_date);//Added for SKR-SCF-1593
											bean_st.loadResultPage("","","");
											bean_st.setModuleId("PH") ; //Added for KDAH-SCF-0243 [IN:049577]
											listRecord					=		bean_st.getDataList();
											if(listRecord!=null && listRecord.size()>0){
												trade_code=((HashMap)listRecord.get(0)).get("TRADE_ID").toString();//Changed TRADE_NAME to TRADE_ID for IN037289
												params.remove("ITEM_CODE");
												params.put("ITEM_CODE",item_code+"="+trade_code);
												//params.put("ITEM_CODE",item_code);
												if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								                    stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				                               }else{
												    stock				= (HashMap)bean_2.getBatches(params);
											   }
												stock_det           = listRecord;
											}
										}// Added for KAUH-SCF-0094 [IN:035252] -- end
										//code for setting batch details in bean
										alloc_drug_detail	=	new ArrayList();
										
										if(stock_det.size()>0)
											disp_delivery_chk_box_val = "Y";
										else
											disp_delivery_chk_box_val = "N";
										tmp_unit_qty =issue_qty_val; //moved from down for  MMS-SCF-0040 [IN:041888]
										//if(!stock.containsKey("EXCEPTION")){//added by Ganga for ML-BRU-SCF-0905 [IN:041285] //Commented for TTM-SCF-0096 [IN:048808]
											for (int j=0;j<stock_det.size();j++){
												batch_det =(HashMap)stock_det.get(j);
												avail_qty			= (String)batch_det.get("AVAIL_QTY");
												if(Double.parseDouble(avail_qty) < 1.0)
													continue;
												avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
												alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
												alloc_drug_detail.add(batch_det.get("BATCH_ID"));
												alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));
												/*if(qty_uom!=base_uom){   //added for SKR-SCF-0377 [IN:030453] - start
													conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
													issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
													issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
												}*/ // Commented MMS-SCF-0040 [IN:041888] 
												//tmp_unit_qty =issue_qty_val; //Commented for MMS-SCF-0040 [IN:041888]
												item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
												/*if(qty_uom!=base_uom){ // Commented MMS-SCF-0040 [IN:041888] 
													conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
													avail_qty  =   retunFormatedInt(Math.floor(Double.parseDouble(avail_qty)/base_to_disp_uom_equl)+""); 
												 }
												 else{  
												   avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
												 }*/ //Added for SKR-SCF-0377 [IN:030453] - end
												if(tmp_unit_qty>Double.parseDouble(avail_qty)){
													 tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
													 issue_qty =avail_qty;
												}
												else{
													 issue_qty =tmp_unit_qty+"";    
												}
												tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
												if(base_to_disp_uom_equl!=base_to_def_uom_equl){					  
													/*int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Double.parseDouble(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
													issue_qty = alloc_qty+"";*/ //commented for  MMS-SCF-0040 [IN:041888]
													alloc_drug_detail.add(issue_qty); //moved from common to specific for  MMS-SCF-0040 [IN:041888]
													alloc_drug_detail.add(qty_uom);
												}
												else{ //else block added for  MMS-SCF-0040 [IN:041888]
													if(!qty_uom.equals(base_uom)){
														alloc_drug_detail.add(issue_qty);
														alloc_drug_detail.add(qty_uom);
													}
													else{
														alloc_drug_detail.add((String)batch_det.get("QTY"));
														alloc_drug_detail.add(base_uom);
													}
												}
												/* Commented for RUT-CRF-0088 [IN036978]  
												if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying charges for tapered drugs
													 issue_qty = "0";
												 }*/
												/*alloc_drug_detail.add(issue_qty);
												alloc_drug_detail.add(qty_uom);*/ //Commented for  MMS-SCF-0040 [IN:041888]
												alloc_drug_detail.add("");
												alloc_drug_detail.add(batch_det.get("TRADE_ID"));
												alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
												alloc_drug_detail.add(item_cost);
												alloc_drug_detail.add(base_uom); //Added for for  MMS-SCF-0040 [IN:041888]
											}
										/*}
										else{//added ElseCondition by Ganga for ML-BRU-SCF-0905 [IN:041285]
											alloc_readonly ="disabled";
										}*/ //Commented for  TTM-SCF-0096 [IN:048808]
										hold_status	="disabled"; //Commented for KAUH-SCF-0184 [IN032611] -Reopened.
										/*if(base_to_disp_uom_equl!=base_to_def_uom_equl){//if block code added to handle if dispense uom and default uom in item store is different
											int  alloc_qty = new Float(Math.ceil(((Math.ceil((Double.parseDouble((tot_issued_qty*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
											tot_issued_qty = alloc_qty;
										} *///Commeted for  MMS-SCF-0040 [IN:041888]
										/* Commented for RUT-CRF-0088 [IN036978] 
										if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying charges for tapered drugs
											tot_issued_qty = 0;
										}*/
										if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
											tot_issued_qty=0;
										} // Added for [IN:064158] - End
										if(!qty_uom.equals(base_uom)){ //if & else block added for  MMS-SCF-0040 [IN:041888]
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
										}
										else{
											tot_issued_qty			= Math.floor(tot_issued_qty);
										} //Added for MMS-SCF-0040 [IN:041888] - end
										bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
										bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);		
								   }
								   else{
									   if(!item_uom_definition_flag){
										   item_uom_definition_flag=true;
									   }
									   alloc_readonly ="disabled";  
									}
								}
								//if condition added for SKR-SCF-1423
								if(stock_opt.get(0).equals("Y") && qty.equals("") && tot_issued_qty==0 && bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals("")) //added for MMS-DM-SCF-0162
									hold_status = "";
							}
							IssueUomQty		= (HashMap)bean.getIssueUomQty();/*=====code added to handle if dispense uom and default uom in item store is different======*/
							issue_qty_dtl   =  new StringBuffer();
							if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
								issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
								issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
								issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
								issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl"); 
								System.err.println("issue_qty_value@@@=="+issue_qty_value+"issue_uom_equl==="+issue_uom_equl);
								if(bean_1.getIssueByUOM().equals("I")){
									issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
								}
							}
							if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
								rol_min		=	(HashMap)stSalseBean.getROL(drug_code,disp_locn_code);
								frm_store_min_stk_level = CommonBean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
								frm_store_reorder_level	= CommonBean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
								min_stk	= false;
                                				rol_stk	= false;
								stParameters[0] = drug_code;
								stParameters[1] = disp_locn_code;
								try{
									hmStockAvailabilityStatus = stSalseBean.getStockAvailabilityStatus(stParameters);
									avail_qty=(String)hmStockAvailabilityStatus.get("available_stock");
								}
								catch (Exception e){
									avail_qty = "0";
								}
								if(avail_qty.equals(""))
									avail_qty="0";
								if(!frm_store_min_stk_level.equals("0")){
									if (Double.parseDouble(avail_qty) <  Double.parseDouble(frm_store_min_stk_level) ){
										min_stk = true;
										if(getReq_allowed_yn)
											disp_req_flag =  "display:inline;color:blue";
										else
											disp_req_flag = "display:none";
									}
								}
								if(!frm_store_reorder_level.equals("0")){
									if (Double.parseDouble(avail_qty)  <  Double.parseDouble(frm_store_reorder_level)){
										rol_stk = true; 
										if(getReq_allowed_yn)
											disp_req_flag = "display:inline;color:blue";
										else
											disp_req_flag  = "display:none;color:blue";	
									}
								}
								if(min_stk){
									min_stk_flag=	"display:inline;align:right";
									min_stk_flag_bkg_clr="background-color:red;color:yellow";
								}
								else{
									if(!frm_store_min_stk_level.equals("0")){
										min_stk_flag=	"display:inline";
										min_stk_flag_bkg_clr="background-color:none";
									}
									else{
										min_stk_flag=	"display:none";
										min_stk_flag_bkg_clr="background-color:none";
									}
								}
								if(rol_stk){
									rol_flag_bkg_clr = "background-color:red;color:yellow";
									rol_flag =	"display:inline"; 
								}
								else{   
									if(!frm_store_reorder_level.equals("0")){
										rol_flag   =	"display:inline";
										rol_flag_bkg_clr = "background-color:none";
									}
									else{
										rol_flag   =	"display:none";
										rol_flag_bkg_clr = "background-color:none";
									}
								}
								if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn))
									disp_req_flag = "display:inline;color:blue";
								else
									disp_req_flag  = "display:none;color:blue";
							}//Added AMS-CRF-0068.1 [IN:050333] end
							if(!exceed_dose.equals("")){ //if condition added for ML-MMOH-CRF-1408 -start
							String repeat_value = 											bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[2];
							 celling_dose = bean_1.getMinMaxCeilingDose(drug_code,patient_id,repeat_value,order_id,order_line_no);
							 if(celling_dose!=null && celling_dose.size()>0){
								min_unit_ceiling_dose = (String)celling_dose.get(0);
								max_unit_ceiling_dose = (String)celling_dose.get(1);
								min_daily_ceiling_dose = (String)celling_dose.get(2);
								max_daily_ceiling_dose = (String)celling_dose.get(3);
							 }
							
							} //added for ML-MMOH-CRF-1408 -end

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
										if(allergy.equals("")) { 

            _bw.write(_wl_block50Bytes, _wl_block50);

										}
										else{ //order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block53Bytes, _wl_block53);
	
										}
										if(exceed_dose.equals("") ) { 

            _bw.write(_wl_block50Bytes, _wl_block50);

										}
										else{//order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(monograph)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(std_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(max_daily_ceiling_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(min_daily_ceiling_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(max_unit_ceiling_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(min_unit_ceiling_dose));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ceil_dose_unit_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
 
										}
										if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) { 

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block53Bytes, _wl_block53);
	
										}
										else{

            _bw.write(_wl_block50Bytes, _wl_block50);
	
										}
										if(iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start and removed intractn_req_yn && for MMS-KH-CRF-0029
										pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029	
											if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
									    	    
												form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
												form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(form_desc,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((recCount)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block59Bytes, _wl_block59);
 
							            }
								       else{	

            _bw.write(_wl_block60Bytes, _wl_block60);
						    	   
										   }
										}// Added for MMS-KH-CRF-0013 - End
										/* added for aakh-crf-0140 start */
								   	System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason);
										if(drug_abuse_appl && abuse_drug_override_reason != null && abuse_drug_override_reason != "" ) { System.out.print("abuse_exists filling----->"+abuse_exists);
									
									
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block62Bytes, _wl_block62);

								}else{
		
            _bw.write(_wl_block63Bytes, _wl_block63);
	
								}/* added for aakh-crf-0140 start */
			
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block67Bytes, _wl_block67);
 
//The following condition is for worksheet...
/*boolean hold_visible=true;
if(recCount!=1 && (!ws_type.equals("")))
	hold_visible=false;
// ends
if(hold_visible){*/
								if (hold_status.equals("disabled")){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disable_alloc_text_box));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(check_value));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(check_status));
            _bw.write(_wl_block79Bytes, _wl_block79);

								}
								else{

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_alloc_text_box));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(check_value));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(check_status));
            _bw.write(_wl_block83Bytes, _wl_block83);

								}
								//}
		
								if(ht_ws_allocated_batches.get(order_line_no) != null){	

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
	
								}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(fromdb));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block92Bytes, _wl_block92);

								if(aggred_item_app){
								if( category_code.equals("B")&& alternate_yn.equals("Y")){
								
            _bw.write(_wl_block93Bytes, _wl_block93);
}
								else if(category_code.equals("B")){
								
            _bw.write(_wl_block94Bytes, _wl_block94);
	}
								else{
									
            _bw.write(_wl_block95Bytes, _wl_block95);
	}}
								
            _bw.write(_wl_block96Bytes, _wl_block96);
  							//GHL-CRF-0549 - start
					               if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	
									
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";

									item_type= bean.getItemType(drug_code);
									mm_item_low_cost_yn = item_type.split("~")[0];
									mm_item_high_margin_yn = item_type.split("~")[1];
									mm_item_Innovator_yn = item_type.split("~")[2];
									if(!bl_grp_app.equals("N")){
									if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											if(bl_grp_app.equals("H")){
												low_cost_green_style ="visibility:hidden";
												low_cost_red_style = "visibility:visible";
												low_cost_grey_style = "visibility:hidden";
											}
										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}else{
												if(bl_grp_app.equals("L")){
													high_margin_red_style = "visibility:visible";
												}
											}
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
										}else{
											innovator_style		="visibility:hidden";		
										}
									}
								else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}

								if(formulary_billing_app){ //GHL-CRF-0618 - start
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									preference_img = "";
								
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}

									}/*else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15'/>";
									}*/
								}//GHL-CRF-0618 - end

								
									

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block98Bytes, _wl_block98);
if(!low_cost_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(low_cost_green_style));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
								if(!high_margin_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(high_margin_green_style));
            _bw.write(_wl_block102Bytes, _wl_block102);
}if(!low_cost_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(low_cost_red_style));
            _bw.write(_wl_block104Bytes, _wl_block104);
}if(!high_margin_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(high_margin_red_style));
            _bw.write(_wl_block104Bytes, _wl_block104);
} if(!low_cost_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(low_cost_grey_style));
            _bw.write(_wl_block107Bytes, _wl_block107);
} if(!high_margin_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(high_margin_grey_style));
            _bw.write(_wl_block109Bytes, _wl_block109);
}if(!innovator_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(innovator_style));
            _bw.write(_wl_block111Bytes, _wl_block111);
} 
            _bw.write(_wl_block112Bytes, _wl_block112);
if(formulary_billing_app){ 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block115Bytes, _wl_block115);
									}
								}	
								
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_status));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(strength));
            _bw.write(_wl_block125Bytes, _wl_block125);
  
								if ((ext_prod_id!=null) && !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block127Bytes, _wl_block127);
  
								}
								if ((image_path!=null)&& !(image_path.equals(""))){
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
  								}
								if(print_value.equals("1")){//GHL-CRF-0453

            _bw.write(_wl_block130Bytes, _wl_block130);
							
								}
								if(adr_count>0){

            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block133Bytes, _wl_block133);

								}
								if(bDrugOrder){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block141Bytes, _wl_block141);

								}
								if(count>1){
									taper = bean.getTapervalue();
									if(taper.equals("UP")){

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

									}
									else if(taper.equals("DOWN")){

            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
	
									}
									else{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

									}
									if(totalTaperQtyDisplay.equals("Y")){

            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf((int)tot_tap));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block152Bytes, _wl_block152);
				
									}}
									//added for mms-kh-crf-0028 start
									
									if(!strength_value.equals("")){
										  alt_drug			=	bean.checkMultiStrength(drug_code);
									}
									else if(medical_applicable.equals("Y") && medi_count>0 ){//ADDED FOR GHL-CRF-0548
										alt_drug ="Y";
									}
									else{
										alt_drug ="N";
									}
					expiry_date = bean_1.getSysdatePlusDays(fTotalDuration+"");
					alt_called_from="disp_medication_alt";
									if(item_type_site_app){
										allow_alternate_yn = bean.getAllowAlternateYN(order_id,order_line_no,iv_prep_yn);
										if(allow_alternate_yn==null || allow_alternate_yn.equals(""))
											allow_alternate_yn = "N";
									}
									//drug_name = java.net.URLEncoder.encode(drug_name,"UTF-8");//IN071555 commented for SKR-SCF-1338
									if(barcode_scan_for_alt_app && iv_prep_yn.equals("")){//changed intractn_req_yn to  barcode_scan_for_alt_app for MMS-KH-CRF-0030
					
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(allow_alternate_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(item_type_site_app));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_called_from));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(allow_alternate_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(item_type_site_app));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_called_from));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(barcodeScan));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

			}
								if(bmscount==0){
									if(pat_couns_reqd_yn.equals("Y")){
										pat_reqd="Checked";	

            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block162Bytes, _wl_block162);

									}
									if(pat_couns_reqd_yn.equals("C")){
										pat_reqd="Checked";	

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block164Bytes, _wl_block164);

									}
									if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
										pat_reqd="Unchecked";	
										//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
										if(pt_couns_reqd_yn.equals("Y")){

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block166Bytes, _wl_block166);

										}
									}
								}
								disp_info	=	bean.getLastDispense(order_id,order_line_no);

								if(bDrugOrder){
									if(disp_info.size() > 0) {				
										if( ((String)disp_info.get(1)).equals("Y")) {
											dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
										}
										dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
									}

            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(dosage_dtls));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block170Bytes, _wl_block170);
 
								}

            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(min_stk_flag_bkg_clr));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(rol_flag_bkg_clr));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(disp_req_flag));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(disp_mnf_flag));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

								k	=	0;
								alt_qty	=	new ArrayList();
								drug_name_1=  drug_name; 
								alt_external_prod_id ="";
										
								/* Commented By Sandhya frm .line num:1271 to 1276 on 24/Nov/2010 for getting Drug name into Thai onclick of PharmacistInstructions Link
								if(!drug_name_1.equals("")&&drug_name_1!=null){
									drug_name_1=drug_name_1.replaceAll(" ","%20");
									drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
									drug_name_1=drug_name_1.replaceAll("%2520","%20");
							   }*/
								for(int n=0; n<multi_drugs.size(); n+=5)	{ 
									alt_drug_code	=	(String)multi_drugs.get(n);
									alt_drug_desc	=	(String)multi_drugs.get(n+1);
									altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
									form_code		=	(String)multi_drugs.get(n+2);
									alt_strength_value		=	(String)multi_drugs.get(n+3);
									String alt_drug_desc_1	=    alt_drug_desc;
									//if else condition added for ML-BRU-SCF-0179 [IN:032578]
									if(!disable_all.equals("disabled")){	
										bEditLabelEnabled = true;
									}
									else{
										bEditLabelEnabled = false;
									}
									//Commented code from 1326 to 1330 regarding incident num:25007 on 19/Nov/2010==By Sandhya
									/*if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
										alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
										alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1);
										alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
									}*/

									pack_dtls			=	bean.getPackSize(alt_drug_code);
									if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
										form_code	=	(String)pack_dtls.get("STOCK_UOM");
									}
									if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
										alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
									}
									else{
											alt_external_prod_id	=  "";
									}
									drug_color		=	(String)colors.get(k++);
									qty				=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
									if(!qty.equals("") && !qty.equals("0")) {
										alt_qty.add(alt_drug_code);
										alt_qty.add(qty);
										alt_qty.add(form_code);
										alt_qty.add(alt_strength_value);
									}
									if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
										min_stk	= false;
										rol_stk	= false;
										if( !drug_code.equals(alt_drug_code)){
											rol_min		=	(HashMap)stSalseBean.getROL(alt_drug_code,disp_locn_code);
											frm_store_min_stk_level = CommonBean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
											frm_store_reorder_level	= CommonBean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
											stParameters[0] = alt_drug_code;
											stParameters[1] = disp_locn_code;
											try{
												hmStockAvailabilityStatus = stSalseBean.getStockAvailabilityStatus(stParameters);
												qty=(String)hmStockAvailabilityStatus.get("available_stock");
											}
											catch (Exception e){
												qty = "0";
											}
											if(qty.equals(""))
												qty="0";
											if(!frm_store_min_stk_level.equals("0")){
										         if (Double.parseDouble(qty)  <  Double.parseDouble(frm_store_min_stk_level)){
												min_stk = true;
					                         	if(getReq_allowed_yn)
												disp_req_flag =  "display:inline;color:blue";
												else
												disp_req_flag = "display:none";
											 }
										         
											}
											if(!frm_store_reorder_level.equals("0")){
												if (Double.parseDouble(qty)  <  Double.parseDouble(frm_store_reorder_level)){
													rol_stk = true; 
													if(getReq_allowed_yn)
														disp_req_flag = "display:inline;color:blue";
													else
														disp_req_flag  = "display:none;color:blue";	
												}
											}
											if(min_stk){
												min_stk_flag=	"display:inline;align:right";
												min_stk_flag_bkg_clr="background-color:red;color:yellow";
											}
											else{
												if(!frm_store_min_stk_level.equals("0")){
													min_stk_flag=	"display:inline";
													min_stk_flag_bkg_clr="background-color:none";
												}
												else{
													min_stk_flag=	"display:none";
													min_stk_flag_bkg_clr="background-color:none";
												}
											}
											if(rol_stk){
												rol_flag_bkg_clr = "background-color:red;color:yellow";
												rol_flag =	"display:inline"; 
											}
											else{
												if(!frm_store_reorder_level.equals("0")){
													rol_flag   =	"display:inline";
													rol_flag_bkg_clr = "background-color:none";
												}
												else{
													rol_flag   =	"display:none";
													rol_flag_bkg_clr = "background-color:none";
												}
											}
											if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn))
												disp_req_flag = "display:inline;color:blue";
											else
												disp_req_flag  = "display:none;color:blue";
										}
										else{
											rol_flag   =	"display:none";
											min_stk_flag=	"display:inline";
											disp_req_flag  = "display:none";	
											min_stk_flag=	"display:none";
										}
									}//Added AMS-CRF-0068.1 [IN:050333] end

            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(n));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug_desc_1));
            _bw.write(_wl_block204Bytes, _wl_block204);

									if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(alt_external_prod_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8")));
            _bw.write(_wl_block206Bytes, _wl_block206);
  
									}
									adr_count = bean.getADRCount(patient_id,alt_drug_code);
									if(adr_count>0){

            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block133Bytes, _wl_block133);

									}
									//if condition added for ML-BRU-SCF-0179 [IN:032578]
									if(bEditLabelEnabled){
										hmEditLabelValues = new HashMap();	
										hmEditLabelValues.put("order_id",order_id);
										hmEditLabelValues.put("pres_drug_code",drug_code);
										hmEditLabelValues.put("drug_code",alt_drug_code);
										hmEditLabelValues.put("order_line_no",order_line_no);
										hmEditLabelValues.put("ord_date_time",ord_date_time);
										hmEditLabelValues.put("drug_name_1",drug_name);
										hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
										hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
										hmEditLabelValues.put("pres_qty",qty);
										hmEditLabelValues.put("uom",form_code);
										hmEditLabelValues.put("alt_drug_flag","Y");
										hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+""); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
										alEditLabelPair.add(hmEditLabelValues);

										bEditLabelEnabled = false;
										bean.setSPerformPractId(performing_pract_id);
									}

            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(min_stk_flag_bkg_clr));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(rol_flag_bkg_clr));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(disp_req_flag));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

								}

            _bw.write(_wl_block1Bytes, _wl_block1);

	         if(drug_expiry_alert.equals("Yes") && !drug_expiry_days.equals("")){//Added for TH-KW-CRF-0008

            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(drug_expiry_days));
            _bw.write(_wl_block216Bytes, _wl_block216);
}
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(title));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(strDrugsRemarks));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(pres_details));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(narc_style));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(retunFormatedInt(pres_qty)));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block229Bytes, _wl_block229);

								if(order_type.equals("TA")){
									bean.setTPNPresQty(pres_qty);
								}
								if(!strength_value.equals("") && !strength_value.equals("0")) //IN073688
								{
								    pres_strength	=	retunFormatedInt(((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom))+"")+" "+strength_uom;
									pres_strength_1 = retunFormatedInt(((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom))+"")+"";
								}
								
 
								if(multi_drugs.size()>1 ) { 

            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(pres_strength));
            _bw.write(_wl_block231Bytes, _wl_block231);
	
								}

            _bw.write(_wl_block232Bytes, _wl_block232);
 		
								if(multi_drugs.size() > 1 ) {	
									if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")  && !disable_all.equals("disabled")){

            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block234Bytes, _wl_block234);
					
									}

            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block236Bytes, _wl_block236);

									int x	=	0;
									int tmp_recCount	=	recCount;
									String alternate_drug	=	"";
									float pack_size			=	1;
									float strength_per_value	=	1.0f;

									for(int l=0; l<alt_qty.size(); l+=4) { 
										alternate_drug		=	(String)alt_qty.get(l);	
										qty					=	(String)alt_qty.get(l+1);	
										uom					=	(String)alt_qty.get(l+2);	
										alt_strength_value	=	(String)alt_qty.get(l+3);	
										drug_color	=	(String)colors.get(x++);

										pack_dtls				=	bean.getPackSize(alternate_drug);
										
										IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); // Added for ML-BRU-SCF-1803 - Start
										base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
										base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
										orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
										base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom);
										medical_applicable=bean.checkMedicalItemYN(alternate_drug);//added for ghl-crf-0548
										if(!uom.equals(base_uom)){
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											//bean.setAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code,(Double.parseDouble(qty)*conv_factor)+"");//Commented for MMS-DM-SCF-0570
										} // Added for ML-BRU-SCF-1803 - End

										if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
											if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
												pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
												if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
												strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));}
											 if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // if condition Added for ML-BRU-SCF-1892 // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160
											   // qty = Math.round(Integer.parseInt(qty)/pack_size)+"";//added for ML-BRU-SCF-1443 //commneted for MMS-KH-SCF-0035
											   //|| (!uom.equals(base_uom) && !alternate_drug.equals("")) removedf or ML-MMOH-SCF-1318
												qty = Math.ceil(Float.parseFloat(qty)/pack_size)+"";//Added for 
							 //ML-BRU-SCF-1443 and removed math.round(Integer.parseInt Math.ceil(Float.parseFloat to math.ceil for MMS-KH-SCF-0035
											 }else if(!uom.equals(base_uom) && !alternate_drug.equals("")){ // else if block added for ML-MMOH-SCF-1318 - Start							
												  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
											 }
											}		
										}
										if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
										tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();
										alloc_strength	=	retunFormatedInt(tmp_alloc+"")+""+strength_uom;
										}
												float prescribed_strength=0;//modified for ghl-crf-0548
										if(!medical_applicable.equals("Y")){//added for ghl-crf-0548		
										 prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/Float.parseFloat(main_strength_per_value_pres_uom);
										}
										double balance_strength		=	prescribed_strength - tmp_alloc;	
										if(balance_strength<1)
											balance_strength		=	0;
										if(balance_strength!=0) {
											bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
										} 
										else {
											bms_qty					=	"0";
										}
										bms_qty=Math.round(((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom)))/main_pack_size))+"";
										bms_strength				=	balance_strength+"";
										if(medical_applicable.equals("Y")){ //added for ghl-crf-0548 - Start
											bms_qty = (Float.parseFloat(tmp_bms_qty)-Float.parseFloat(qty))+"";
											tmp_bms_qty = bms_qty;
											alloc_strength = "";
									    } //added for ghl-crf-0548 - End
										if(qty.equals("") || qty.equals("0")) 
											uom="";	
										else {
											uom			=	"("+bean.getUomDisplay(facility_id,uom)+")";
											tot_qty		+=	Double.parseDouble(qty);
										}
										/*==========code added to handle if dispense uom and default uom in item store is different=================*/
										issue_qty_dtl =new StringBuffer();
										if(IssueUomQty.containsKey(order_id+order_line_no+alternate_drug+"_qty")){
											issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
											issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
											issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
											issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
											if(bean_1.getIssueByUOM().equals("I")){
												issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
											}
										}/*==========ends here=========================================================================================*/

            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(uom));
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block240Bytes, _wl_block240);
	
										tmp_recCount++;
										
										if(!scope.equals("H") && scope!=null){
											if(( !qty.equals("") && !qty.equals("0")) && (Float.parseFloat(bms_qty) == 0 || !complete_ord_yn)){ //&&  Float.parseFloat(bms_qty) == 0 added forKAUH-SCF-0096 [IN:035355] // !complete_ord_yn Added for ML-MMOH-SCF-0356.1
												disable_complete_order	=	"disabled"; 
											}
											else{
												disable_complete_order	=	""; 
											}
										}
										hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
										hsh_med_plan.put("qty",qty);
										if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
											if(!alt_qty.contains(drug_code)){
												medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
												medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
											}
											arrOrderId.add(order_id+"_"+order_line_no);
											dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";
											dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
											dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,alternate_drug);
											dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,alternate_drug);
											medplan_bean.getDosageDetails(drug_code,alternate_drug, order_id, order_line_no);
											hsh_med_plan.put("drug_name",(String)altDrugName.get(alternate_drug));
											hsh_med_plan.put("drug_code",alternate_drug);
											hsh_med_plan.put("morning",dosedet[0]);
											hsh_med_plan.put("afternoon",dosedet[1]);
											hsh_med_plan.put("evening",dosedet[2]);
											hsh_med_plan.put("night",dosedet[3]);
											hsh_med_plan.put("morninglocal",dosedetlocal[0]);
											hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
											hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
											hsh_med_plan.put("nightlocal",dosedetlocal[3]);
											hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc((String)alt_qty.get(l+2),loc_lang_id)); 
											hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc((String)alt_qty.get(l+2),primary_lang_id));
											hsh_med_plan.put("curr_disp_yn","Y");
											hsh_med_plan.put("merge_yn","N");
											hsh_med_plan.put("plan_recorded","N");
											hsh_med_plan.put("pres_drug_code",drug_code);
											hsh_med_plan.put("disp_drug_code",alternate_drug);
											hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(alternate_drug)));
											hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(alternate_drug)));
											hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+alternate_drug)));
											hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(alternate_drug)));
											hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+alternate_drug)));
											dispno = medplan_bean.getDispNumber(order_id, order_line_no);
											hsh_med_plan.put("disp_no",dispno[0]);
											hsh_med_plan.put("disp_srl_no",dispno[1]);
											hsh_med_plan.put("checked","checked");
											hsh_med_plan.put("order_id",order_id);
											hsh_med_plan.put("order_line_no",order_line_no);
											medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+primary_lang_id, hsh_med_plan);
											medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+loc_lang_id, hsh_med_plan);
										}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end
									}

            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(alloc_strength));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);
	
								}
								else if(!tpn_finalize.equals("")){
									String tpn_qty=bean.getTPNQty();
									String tpn_qty_uom=bean.getTPNQtyUOM();
									if(tpn_qty.equals("0")){
										tpn_qty="";
										tpn_qty_uom="";
									}

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(tpn_qty));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,tpn_qty_uom)));
            _bw.write(_wl_block250Bytes, _wl_block250);

								}
								else if(ws_tot_qty != 0 ){								// THIS IS FOR WORKSHEET

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(ws_tot_qty));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block251Bytes, _wl_block251);

								}
								else{	
									if(qty.equals("") || qty.equals("0")) {
										qty	=	"";
										uom	=	"";	
									}
									else {
										if(!strength_value.equals("") && !strength_value.equals("0")){
											alloc_strength	=	Float.parseFloat(strength_value) * Double.parseDouble(qty)+"";
										}
										uom=qty_uom;
									}
									if(qty.equals("") && alt_drug_qty.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder)){
										if(tot_issued_qty==0){
											qty ="";
										}
										else{
											qty = tot_issued_qty+"";
										}
										uom=qty_uom;
										bms_qty = (Double.parseDouble(act_bms_qty)-tot_issued_qty)+"";
									}
								/*if(count>1){ //if block added to avoid displaying qty for tapered drugs
									qty = act_bms_qty;
									bms_qty = "0";
								}*/ //Commented for ML-BRU-SCF-1015 [IN:043355]
								/* Commented for RUT-CRF-0088 [IN036978] 
								if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty for tapered drugs
									qty = "0";
									bms_qty = "0";
								}*/
								String uom_desc = "";//Added for AAKH-SCF-0338
								String issueUomDisbYn = ""; // Added for MMS-DM-SCF-0488 - Reopen Issue - Start
								if(!last_scanned.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){
									issueUomDisbYn = "disabled";
								}  // Added for MMS-DM-SCF-0488 - End

            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id+order_line_no+drug_code+"_uom"));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(issueUomDisbYn));
            _bw.write(_wl_block255Bytes, _wl_block255);
 
									stk_units				= bean.loadStockUnit(drug_code);
									//added for AAKH-SCF-0338 - start
										if(stk_units!=null && stk_units.size()>0){
											if(!stk_units.contains(orig_dflt_issue_uom)){
												uom_desc = bean.getUOMDesc(orig_dflt_issue_uom);
												stk_units.add(orig_dflt_issue_uom);
												stk_units.add(uom_desc);
												stk_units.add("1"); 
												stk_units.add("1");
											}
										}
									//added for AAKH-SCF-0338 - end
									for(int iStkCountt=0; iStkCountt<stk_units.size();iStkCountt+=4) { 
										stk_unit_code		=	(String)stk_units.get(iStkCountt);
										stk_unit_desc		=	(String)stk_units.get(iStkCountt+1);
										stk_equval_value	=	(String)stk_units.get(iStkCountt+2);
										act_stk_equval_value	=	(String)stk_units.get(iStkCountt+3);

										if(dflt_issue_uom.equals(stk_unit_code)){

            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block259Bytes, _wl_block259);

										}
										else{

            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block259Bytes, _wl_block259);

										}	
									}
									// For Allowing more quantity than order quantity dispense based on drug setup
									HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();
									if(hmAllowMoreQty == null)
										hmAllowMoreQty = new HashMap();
  
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(order_id+order_line_no+drug_code+"_uom"));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(hmAllowMoreQty.get(drug_code)));
            _bw.write(_wl_block266Bytes, _wl_block266);

										if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
											if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))) // Added for [IN:064158] - Start
				                        		                 if(qty.equals("0.0") || qty.equals("") ||  qty.equals("0"))
				                        			               qty = "0.0";  // Added for [IN:064158] - End // "" modified to "0.0" for GHL-CRF-0463
											if( stock_opt.get(0).equals("Y")){
												 if(in_formulary_yn.equals("Y")){													 

            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(  retunFormatedInt(qty)));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(act_bms_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block272Bytes, _wl_block272);

													bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for KDAH-CRF-0231 [IN-034551]
													if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for KDAH-CRF-0231 [IN-034551] 

            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block274Bytes, _wl_block274);
 if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
}
            _bw.write(_wl_block277Bytes, _wl_block277);

														bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for KDAH-CRF-0231 [IN-034551]
													}
												}
												else{

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block280Bytes, _wl_block280);

												}

            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(act_bms_qty));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(issue_uom_equl));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(last_scanned));
            _bw.write(_wl_block304Bytes, _wl_block304);

											}
											else{ 
												if(in_formulary_yn.equals("Y")){	 

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block83Bytes, _wl_block83);

												}
												else{

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block308Bytes, _wl_block308);

												}

            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block266Bytes, _wl_block266);

											}
										}
										else{

            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block312Bytes, _wl_block312);
 if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
}
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block266Bytes, _wl_block266);
  
											if(!qty.equals("")){

            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

											}
										}
										hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
										hsh_med_plan.put("qty",qty);
										if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
											arrOrderId.add(order_id+"_"+order_line_no);
											dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
											dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,drug_code);
											dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,drug_code);
											hsh_med_plan.put("drug_name",CommonBean.checkForNull(medplan_bean.getDrug_desc(drug_code)));
											hsh_med_plan.put("drug_code",drug_code);
											hsh_med_plan.put("morning",dosedet[0]);
											hsh_med_plan.put("afternoon",dosedet[1]);
											hsh_med_plan.put("evening",dosedet[2]);
											hsh_med_plan.put("night",dosedet[3]);
											hsh_med_plan.put("morninglocal",dosedetlocal[0]);
											hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
											hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
											hsh_med_plan.put("nightlocal",dosedetlocal[3]);
											hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,loc_lang_id)); 
											hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,primary_lang_id));
											hsh_med_plan.put("curr_disp_yn","Y");
											hsh_med_plan.put("merge_yn","N");
											hsh_med_plan.put("plan_recorded","N");
											hsh_med_plan.put("pres_drug_code",drug_code);
											hsh_med_plan.put("disp_drug_code",drug_code);
											hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(drug_code)));
											hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(drug_code)));
											hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+drug_code)));
											hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(drug_code)));
											hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+drug_code)));
											dispno = medplan_bean.getDispNumber(order_id, order_line_no);
											hsh_med_plan.put("disp_no",dispno[0]);
											hsh_med_plan.put("disp_srl_no",dispno[1]);
											hsh_med_plan.put("checked","checked");
											hsh_med_plan.put("order_id",order_id);
											hsh_med_plan.put("order_line_no",order_line_no);
											medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id, hsh_med_plan);
											medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hsh_med_plan);
										}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end

            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block322Bytes, _wl_block322);
 
										if(!scope.equals("H") && scope!=null){
											if((!qty.equals("") && !qty.equals("0")) && (Float.parseFloat(bms_qty) ==0 || !complete_ord_yn) ){ //  && Float.parseFloat(bms_qty) == 0 added forKAUH-SCF-0096 [IN:035355] // !complete_ord_yn Added for ML-MMOH-SCF-0356.1
											   disable_complete_order	=	"disabled"; 
											}
											else{
												disable_complete_order	=	"";   
											}		
										}	
									}
									if(multi_drugs.size() <= 1 ) {
										if(ws_tot_qty != 0){
											bms_qty	=	Float.parseFloat(bms_qty)- ws_tot_qty +"";
										}
										else if(!qty.equals("") && !qty.equals("0")){
											if( !bean_1.getBarcode_multi_id().equals("Y"))
												bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
										}
									}
											
									if(!strength_value.equals("") && !alt_strength_value.equals("")) {
										if(bms_strength.equals(""))
										bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";

									}
									else if(!strength_value.equals("") && !strength_value.equals("0")) {
									  bms_strength		=	"";
									  strength_uom		=	"";
									}
									else {
										strength_uom	=	"";
									}
									if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
										bms_strength="";
										strength_uom="";
									}
									if(Float.parseFloat(bms_qty)<0){
										bms_qty ="0";
									}

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(title));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(retunFormatedInt(bms_qty)));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(retunFormatedInt(bms_qty)));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block331Bytes, _wl_block331);

									bms_strength="";
									strength_uom="";
									if(stock_opt.size()>0){

            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(stock_opt.get(0)));
            _bw.write(_wl_block266Bytes, _wl_block266);

									}
									else{

            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block334Bytes, _wl_block334);

									}

            _bw.write(_wl_block335Bytes, _wl_block335);

								//for billing interface coding starts
								String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
								boolean approval_flag = false;
								String disabled = "disabled";//AAKH-CRF-0117
								if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
									if(in_formulary_yn.equals("Y")){
										float gross_charge_amount =  0;
										float groos_pat_payable   =  0;
										 float gross_amount        = 0;//Added for ML-BRU-CRF-0469
										//float net_amount          =  0;
										gross_charge_amount_str	  =  "";
										groos_pat_payable_str	  =  "";
										     gross_amount_str     =  "";//added for ML-BRU-CRF-0469
										disp_delivery_chk_box_val =  "Y";
										batch_str				  =   "";

										StringBuffer gross_charge_display_str   = new StringBuffer();
										StringBuffer pat_charge_display_str     = new StringBuffer();
										StringBuffer inc_exec_display_str		= new StringBuffer();
										StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
											
										if( !qty.equals("")|| ws_tot_qty!=0 || multi_drugs.size()>1){						
											if((!qty.equals("")|| ws_tot_qty != 0) && (billable_item_yn.equals("Y"))){
												alt_drug_code			    = "";
												boolean billing_alt_flag  = false;
												if(multi_drugs.size()>1){
													for(int n=0; n<multi_drugs.size(); n+=5)	{							    
														alt_drug_code	     =	(String)multi_drugs.get(n);
														if(alt_drug_code.equals(drug_code)){
															   billing_alt_flag=true;
														}
													}
												}

												if(!billing_alt_flag){	
													HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
													if(billing_det.containsKey(drug_code)){
														HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
														if(chareg_det.get("error_msg").equals("")){
															if(chareg_det.get("pat_paid_flag") != null && !chareg_det.get("pat_paid_flag").toString().equals("")){
																if(chareg_det.get("pat_paid_flag").equals("0")||chareg_det.get("pat_paid_flag").equals("1")||chareg_det.get("pat_paid_flag").equals("2")){
																	bPatientPaid   =true;
																	if(bean_1.getPatPaidYNForZeroBill().equals("Y")){//Added FOR SKR-SCF-0979 [IN:048119] & ML-BRU-SCF-1281 [IN:047783] -ISSUE 1 -start
																		pat_paid_amt			=	(String)chareg_det.get("pat_paid_amt"); 
																		pat_net_charge_amt			=	(String)chareg_det.get("netchargeamt");
																		if((pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0) && (pat_net_charge_amt.equals("")|| Float.parseFloat(pat_net_charge_amt)==0)){ 
																			bPatientPaid   = false;
																		}
																		else if(!pat_paid_amt.equals("") && Float.parseFloat(pat_paid_amt)!=0 && !pat_net_charge_amt.equals("") && Float.parseFloat(pat_net_charge_amt)!=0){  
																			bPatientPaid   = true;
																		} 
																	}//Added FOR SKR-SCF-0979 [IN:048119] & ML-BRU-SCF-1281 [IN:047783] -ISSUE 1 -end
																}
															}
															decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
															/*if(!chareg_det.get("grosschargeamt").equals("null")){
																gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
															}*/ //Commented ML-BRU-SCF-0368 [IN:034748]
															if(!chareg_det.get("netchargeamt").equals("null")){// if block added ML-BRU-SCF-0368 [IN:034748]
																gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); 
															}

															if(!chareg_det.get("patnetamt").equals("null")){
																groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
															}
															//added for ML-BRU-CRF-0469 start 
															if(displayGrossAmtYn){
															if(!chareg_det.get("grosschargeamt").equals("null")){
																gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
															}
															}
															//added for ML-BRU-CRF-0469 end
															
															batch_str                =(String)chareg_det.get("BATCH_STRING");
															gross_charge_amount_str  = dfTest.format(gross_charge_amount);
															groos_pat_payable_str    = dfTest.format(groos_pat_payable);
															//added for ML-BRU-CRF-0469 start
															if(displayGrossAmtYn){
															gross_amount_str         = dfTest.format(gross_amount);
															}
															//added for ML-BRU-CRF-0469 end
															gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

															pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	
															//added for ML-BRU-SCF-0469 start 
															if(displayGrossAmtYn){
															gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_amount_str).append("</label>");
															}
															//added for ML-BRU-SCF-0469 end
															inc_exec_display_str.append("<a  style ='font-size:9px' href=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
															
															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															if(tot_gross_charge_amount !=tot_groos_pat_payable){//AAKH-CRF-0117
																approval_flag =true;
															}
															//added for ML-BRU-SCF-0469 strt
															if(displayGrossAmtYn){
															tot_gross_amount        = tot_gross_amount+gross_amount;
															}
															//added for ML-BRU-SCF-0469 end
															
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block353Bytes, _wl_block353);
if(displayGrossAmtYn){ 
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(gross_amount+""));
            _bw.write(_wl_block356Bytes, _wl_block356);
 } 
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block359Bytes, _wl_block359);

														}
														else{												
															gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															//added for ML-BRU-CRF-0469 strt
															if(displayGrossAmtYn){
															gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															}
															//added for ML-BRU-CRF-0469 end
															//disp_delivery_chk_box="";
															disp_delivery_chk_box_val="N";
															//disp_delivery_chk_box_disabled="disabled";
														}
													}
												}
											}
											if(multi_drugs.size()>1){
												int  added_yn =0;
												int  x		=0;
												String sModAltDrugCode = "";
												for(int n=0; n<multi_drugs.size(); n+=5)	{							    
													alt_drug_code	     =	(String)multi_drugs.get(n);
													sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");

													drug_color			 =	(String)colors.get(x++);
													HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
													if(billing_det.containsKey(alt_drug_code)){
														HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
														if(chareg_det.get("error_msg").equals("")){
															batch_str =(String)chareg_det.get("BATCH_STRING");
															decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);
														   /*if(!chareg_det.get("grosschargeamt").equals("null")){ 
																gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
														   }*/ //Commented added ML-BRU-SCF-0368 [IN:034748]
															if(!chareg_det.get("netchargeamt").equals("null")){// if block added ML-BRU-SCF-0368 [IN:034748]
																gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); 
															}
															if(!chareg_det.get("patnetamt").equals("null")){ 
																groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
															}
															if(displayGrossAmtYn){ // Added for 68194 - Start
																if(!chareg_det.get("grosschargeamt").equals("null")){
																	gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
																  }
															} // Added for 68194 - End
															gross_charge_amount_str = dfTest.format(gross_charge_amount);
															groos_pat_payable_str   = dfTest.format(groos_pat_payable);
															if(displayGrossAmtYn){ // Added for 68194 - Start
																gross_amount_str = dfTest.format(gross_amount);
															} // Added for 68194 - End
															
													   
															gross_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");

															pat_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");

															inc_exec_display_str.append("<label style='cursor:pointer;font-size:9px;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");
                                                            
															if(displayGrossAmtYn){ // Added for 68194 - Start   
																gross_disply_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_amount_str).append("</label><BR>");																								
															} // Added for 68194 - End
															
															added_yn++;
															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															if(tot_gross_charge_amount !=tot_groos_pat_payable){ //AAKH-CRF-0117
																approval_flag =true;
															}
															if(displayGrossAmtYn){ // Added for 68194 - Start
																tot_gross_amount            =tot_gross_amount+gross_amount; //added for ML-BRU-SCF-1841
															} // Added for 68194 - End
															

            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block266Bytes, _wl_block266);

														}
														else{
															gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
															pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
															// disp_delivery_chk_box    ="";
															disp_delivery_chk_box_val="N";
															// disp_delivery_chk_box_disabled="disabled";
														}
													}							  
												}
												/*if(added_yn>0){
												}*/
											}
										}	
										else{ // if its zero qty
											//added for ML-BRU-CRF-0469 start
											if(displayGrossAmtYn){
											 gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");
											}
											//added for ML-BRU-CRF-0469 end
											 gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");

											pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");	

											inc_exec_display_str.append("<a id='lblIncludeExclude"+recCount+"' style ='font-size:9px;visibility:hidden' href=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");

            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block367Bytes, _wl_block367);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block369Bytes, _wl_block369);
} 
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block359Bytes, _wl_block359);

										}
							if(bean.getDisplayInsStatus()){  //Added for TH-KW-CRF-0012

            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(insurance_status));
            _bw.write(_wl_block375Bytes, _wl_block375);
}
            _bw.write(_wl_block376Bytes, _wl_block376);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(gross_disply_str.toString()));
            _bw.write(_wl_block378Bytes, _wl_block378);
} 
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(pat_charge_display_str.toString()));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(gross_charge_display_str.toString()));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(inc_exec_display_str.toString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
  
									}
									else{
										disp_delivery_chk_box_val =  "N";				

            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block384Bytes, _wl_block384);

									}  
								}  //billing interface coding ends here  
								if(base_to_def_uom_equl == 0 && base_to_disp_uom_equl == 0 && (ord_type.equals("NOR") || bEquivalentNormalOrder) ){
									disp_delivery_chk_box_val = "N";
								}

            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(disp_delivery_chk_box_val));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(pres_strength_1));
            _bw.write(_wl_block389Bytes, _wl_block389);

								if((ws_tot_qty == 0 )&&( ws_type.equals("")||ws_type.equals("1")||ws_type.equals("3")||ws_type.equals("5")||ws_type.equals("9"))){		// THIS IS EXECUTED FOR ALLOCATE //"||ws_type.equals("9")" alone added for SRR20056-SCF-7289
									showZeroQtyCheckBox = "";
									showOtherEditLables = "";
									if(!disable_all.equals("disabled") && ((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") ||  qty.equals("0") )) )){// qty ==null || qty.equals("0") is changed to  Double.parseDouble(bms_qty) > 0 for [IN:045700]
										showZeroQtyCheckBox ="";
										showOtherEditLables ="display:none";
									}
									else{
										showZeroQtyCheckBox="display:none";
										showOtherEditLables ="";
									}
									if((qty ==null || qty.equals("0") || qty.equals("")) && (disable_all.equals("disabled") || bKeepQty ) && !hold_text.equals("On Hold")){ // && !hold_text.equals("On Hold") added for IN039007
										strAllocBMSChkValue  = "Y";
										strAllocBMSChecked	 = "checked";
										disable_complete_order ="disabled";
									}
									else{
										strAllocBMSChkValue  = "N";
										strAllocBMSChecked	 = "";
									}

									if(base_to_def_uom_equl == 0 && base_to_disp_uom_equl == 0){
										strAllocBMSChkValue  = "N";
										strAllocBMSChecked	 = "";
									}
									if( ((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") ||  qty.equals("0") || qty.equals("0.0") )) ) && !hold_text.equals("On Hold")  ){  //if block added for Bru-HIMS-CRF-281 [IN:033166]  // && !hold_text.equals("On Hold") added for IN039007//qty.equals("0.0") added for  ML-BRU-1810
										if(includeBMSDefCheck_yn.equals("Y")){ //if condition added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
											strAllocBMSChkValue  = "Y";
											strAllocBMSChecked	 = "checked";
											disable_complete_order ="disabled";
											showOtherEditLables ="display:none";//Added for ML-BRU-1810
										}
										showZeroQtyCheckBox	 = "";
										out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='Y'>");
										showOtherEditLables ="display:none";
									}
									else if(bKeepQty)
										out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='N'>");
									if(image.equals("")) {

            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block391Bytes, _wl_block391);

										//if(strIncludeZeroQty.equals("Y")){   Commented for [IN:045700]

            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(showZeroQtyCheckBox));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strAllocBMSChkValue));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(strAllocBMSChecked));
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block398Bytes, _wl_block398);

										//} Commented for [IN:045700]
										if(!disable_all.equals("disabled")){	
											bEditLabelEnabled = true;							  

            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(showOtherEditLables));
            _bw.write(_wl_block400Bytes, _wl_block400);

											if(!order_type.equals("TD") && !order_type.equals("TA")){

            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(performing_pract_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name_1,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_drug_flag));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

											}

            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(bPatientPaid));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block414Bytes, _wl_block414);

									}
									else{
										bEditLabelEnabled = false;	
										disable_complete_order ="disabled";

            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(showOtherEditLables));
            _bw.write(_wl_block416Bytes, _wl_block416);

										if(!order_type.equals("TD") && !order_type.equals("TA")){

            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

										}

            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block420Bytes, _wl_block420);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block421Bytes, _wl_block421);

									}
									if(multi_drugs.size()==0){
										if(bEditLabelEnabled){ // This block is used to store the values for showing the edit lables while open from the header
											hmEditLabelValues = new HashMap();	
											hmEditLabelValues.put("order_id",order_id);
											hmEditLabelValues.put("pres_drug_code",drug_code);
											hmEditLabelValues.put("drug_code",drug_code);
											hmEditLabelValues.put("order_line_no",order_line_no);
											hmEditLabelValues.put("ord_date_time",ord_date_time);
											hmEditLabelValues.put("drug_name_1",drug_name);
											hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
											hmEditLabelValues.put("pres_qty",pres_qty);
											hmEditLabelValues.put("uom",uom);
											hmEditLabelValues.put("alt_drug_flag","N");   //newly added for ML-BRU-SCF-0179 [IN:032578]
											hmEditLabelValues.put("alt_drug_count", "0"); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
											alEditLabelPair.add(hmEditLabelValues);
											bEditLabelEnabled = false;
											bean.setSPerformPractId(performing_pract_id);
										}
									}

            _bw.write(_wl_block422Bytes, _wl_block422);
				
							}	
							else{			

            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(image));
            _bw.write(_wl_block30Bytes, _wl_block30);

							}	
						}
						else{			// THIS IS EXECUTED FOR WORKSHEET
							if(ws_tot_qty != 0 ){
								disable_complete_order	=	"disabled"; 
							}
							else{
								disable_complete_order	=	""; 
							}

            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block426Bytes, _wl_block426);

						}

            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block266Bytes, _wl_block266);

						if(scope.equals("H")){
							legend1=bean_1.getresultlinestatus(order_id,order_line_no);
							if(legend1==null)legend1="";
							if(legend1.equals("OS")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
							}
							else if(legend1.equals("DP")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
							}
							else if(legend1.equals("RG")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");

							}
							else if(legend1.equals("AL")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
							}
							visibility1="visibility:visible";
							visibility2="visibility:hidden";
						}
						else{
							if(hold_text.equals("On Hold")||disable_all.equals("disabled")){
							   disable_complete_order	=	"disabled"; 
							}
							visibility1="visibility:hidden";
							visibility2="visibility:visible";
						}

            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(visibility1));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(legend_text));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(complete_order_value));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(disable_complete_order));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(complete_order_checked));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(visibility2));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disable_complete_order));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(complete_order_checked));
            _bw.write(_wl_block442Bytes, _wl_block442);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block443Bytes, _wl_block443);

							for(int m=0; m<complete_reason_codes.size(); m=m+2){

            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(complete_reason_codes.get(m)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(complete_reason_codes.get(m+1)));
            _bw.write(_wl_block259Bytes, _wl_block259);

							}

            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(dischargeIND));
            _bw.write(_wl_block453Bytes, _wl_block453);
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(st_allow_decimals_yn));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block462Bytes, _wl_block462);
 
						if(disp_level.equals("P")) {	

            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
	
						}
					//ML-MMOH-SCF-1634 - start
					if(patient_class.equals("OP")){
					
					if(strIncludeZeroQty.equals("N") && (iv_prep_yn==null || iv_prep_yn.equals("")) && (qty.equals("") ||  qty.equals("0") || qty.equals("0.0")) && !hold_text.equals("On Hold")){ 
            _bw.write(_wl_block465Bytes, _wl_block465);
}
					} //ML-MMOH-SCF-1634 - end
					if(approval_flag){//AAKH-CRF-0117
						disabled = "";
					}    
				    if(approval_no_flag) { //added for AAKH-CRF-0117
							if(approval_flag){//AAKH-CRF-0117
								approval_no= (String)approvalNo.get(order_id+order_line_no);
						   }
						   if(approval_no==null) //AAKH-CRF-0117
							   approval_no = "";

            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(approval_no));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block471Bytes, _wl_block471);
 //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("")){
							approval_no_style = "visibility:visible";
						}
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(approval_no_style));
            _bw.write(_wl_block474Bytes, _wl_block474);

						
					
            _bw.write(_wl_block475Bytes, _wl_block475);

					}

            _bw.write(_wl_block476Bytes, _wl_block476);

					if(multi_drugs!= null && multi_drugs.size()>0 && alt_drug_code!= null && !alt_drug_code.trim().equals("")){
						stDrugCodes.remove(drug_code);
						stDrugCodes.add(alt_drug_code);
					}

            _bw.write(_wl_block477Bytes, _wl_block477);

if(Disp_drug_verify_remarks.equals("Y") && site_remarks && drug_remarks !="" && drug_remarks !=null){ 
            _bw.write(_wl_block478Bytes, _wl_block478);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(drug_remarks ));
            _bw.write(_wl_block480Bytes, _wl_block480);
}
if(Disp_drug_verify_remarks.equals("Y") && site_remarks && verificationremarks !="" && verificationremarks !=null){ 
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(verificationremarks ));
            _bw.write(_wl_block483Bytes, _wl_block483);
}	
            _bw.write(_wl_block484Bytes, _wl_block484);


					recCount++;
				}
				/* commented for SKR-SCF-0105
				String allow_yn	=	"Y";
				if( (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("A")  ))&&(!disp_locn_catg.equals("I")) ){
						allow_yn    =   (String) bean_1.Check_applicable_orders(OrderIDS);
				 }
				*/
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")&&ws_tot_qty != 0 && admx_prep_charges_appl_yn.equals("Y")){
					String ItemForAdmixPrepCharges				=  "";
					String mark_up_down					    =	"1";
					String old_mark_up_down					=   "";
					if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("CO")){
						iv_prep_yn						=   "";
						String calc_groos_pat_payable_admx_prep_charge = "";
						String calc_gross_admx_prep_charge	=	"";	
						admixture_yn							=   "Y";
						StringBuffer gross_charge_display_str =   new StringBuffer();
					  
						HashMap	AdmxPrepChargeDetails =(HashMap)bean_1.getAdmxPrepChargeDetails(disp_locn_code,worksheet_id,ord_type);
						if(AdmxPrepChargeDetails!=null && AdmxPrepChargeDetails.size()>0){
						   ItemForAdmixPrepCharges			=  (String) AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_ITEM_CODE");
						   mark_up_down						=  (String)AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_UNITS");
						   old_mark_up_down					=  mark_up_down;
						}
						else{
							iv_prep_yn						=   bean.getIVFlag(order_id);
							ItemForAdmixPrepCharges			=   bean.getItemForAdmixPrepCharges(iv_prep_yn);
						}				  			
						HashMap charge_det=(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,bl_patient_class,ItemForAdmixPrepCharges,1.0,"",sysdate,store_code,"","",order_id,"","",dischargeIND);
						if(charge_det.get("error_msg").equals("")){ 
							decimalFormatString					=(String)charge_det.get("BL_DECIMAL_FORMAT_STRING");
							DecimalFormat dfTest				=   new DecimalFormat(decimalFormatString);

							//if(!charge_det.get("grosschargeamt").equals("null")){ //Commented for ML-BRU-SCF-0368 [IN:034748]
							if(charge_det.get("netchargeamt")!=null && !charge_det.get("netchargeamt").equals("null")){// added ML-BRU-SCF-0368 [IN:034748]
								//gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("grosschargeamt")));// Commented for ML-BRU-SCF-0368 [IN:034748]
								gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("netchargeamt")));// added ML-BRU-SCF-0368 [IN:034748]
								calc_gross_admx_prep_charge=dfTest.format( Float.parseFloat(gross_admx_prep_charge)*Float.parseFloat(mark_up_down));
							}
							if(!charge_det.get("patnetamt").equals("null")){
								groos_pat_payable_admx_prep_charge  =dfTest.format( Float.parseFloat((String)charge_det.get("patnetamt"))); 
								calc_groos_pat_payable_admx_prep_charge=dfTest.format( Float.parseFloat(groos_pat_payable_admx_prep_charge)*Float.parseFloat(mark_up_down));
							} 

            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(gross_admx_prep_charge));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(groos_pat_payable_admx_prep_charge));
            _bw.write(_wl_block487Bytes, _wl_block487);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(mark_up_down));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(calc_gross_admx_prep_charge));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(calc_groos_pat_payable_admx_prep_charge));
            _bw.write(_wl_block491Bytes, _wl_block491);
	
						}
						else{
							gross_admx_prep_charge=(gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(charge_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>")).toString();

							groos_pat_payable_admx_prep_charge=gross_admx_prep_charge;

            _bw.write(_wl_block492Bytes, _wl_block492);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(gross_admx_prep_charge));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(groos_pat_payable_admx_prep_charge));
            _bw.write(_wl_block491Bytes, _wl_block491);
	
							gross_admx_prep_charge="0";
							groos_pat_payable_admx_prep_charge="0";
						}	 
					}

            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(gross_admx_prep_charge));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(groos_pat_payable_admx_prep_charge));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(mark_up_down));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(old_mark_up_down));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(ItemForAdmixPrepCharges));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(decimalFormatString));
            _bw.write(_wl_block266Bytes, _wl_block266);

				}
				if(disp_level.equals("P") && result!=null) {
					for(int i=0;i<result.size();i=i+11) {		//10->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978]  13 ->11
						bean.setFirstTime(((String)result.get(i+1)).trim(),false);
					}
				}
				else {
					bean.setFirstTime(order_id,false);
				}

				if(stDrugCodes.size()>0){
					sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
				}	
				bean_1.setPatientPaid(bPatientPaid);

            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(bean_id_1));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(bean_name_1));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(performing_pract_id));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(allocate_status));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(ws_type));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(bean_1.getIssueByUOM()));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(strIncludeZeroQty));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(bEquivalentNormalOrder));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(bean_1.getSFunctionId()));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(tpn_wrksheet_rcrd));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(pres_qty_alert));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(includeBMSDefCheck_yn));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(strAutoCompletePartialDisp));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(st_no_of_decimals));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(st_disp_decimal_dtls_yn));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(allow_amend_alt_drug_dtl));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(displayGrossAmtYn));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(intractn_req_yn));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(approval_no_flag));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(approval_no_app_for_patient_class));
            _bw.write(_wl_block540Bytes, _wl_block540);
 
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){

            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(bl_encounter_id));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block544Bytes, _wl_block544);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(tot_gross_amount));
            _bw.write(_wl_block546Bytes, _wl_block546);
} 
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(tot_gross_charge_amount));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(tot_groos_pat_payable));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(admx_prep_charges_appl_yn));
            _bw.write(_wl_block550Bytes, _wl_block550);

			}

            _bw.write(_wl_block551Bytes, _wl_block551);
  
		if(decimalFormatString!=null && !decimalFormatString.equals("")&& billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
		   DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
		   tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
		   tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
		 //added for ML-BRU-CRF-0469 start
			if(displayGrossAmtYn){ 
			tot_gross_amount_str        = dfTest.format(tot_gross_amount);
			
			}
			//added for ML-BRU-CRF-0469 end
		}
		if(item_uom_definition_flag){
            _bw.write(_wl_block552Bytes, _wl_block552);

		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(recCount-1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tpn_finalize));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(admixture_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sDispDrugAuthYN));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tot_gross_amount_str));
            _bw.write(_wl_block554Bytes, _wl_block554);

			if(bPatientPaid){

            _bw.write(_wl_block555Bytes, _wl_block555);

			}

            _bw.write(_wl_block556Bytes, _wl_block556);
 
			if(!display_list.equals("display:none")){

            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block558Bytes, _wl_block558);
 
						if(!item_uom_definition_flag){

            _bw.write(_wl_block559Bytes, _wl_block559);
 
						}

            _bw.write(_wl_block560Bytes, _wl_block560);

			}

            _bw.write(_wl_block561Bytes, _wl_block561);

		bean.clearAlEditLabelPairValues();
		bean.setAlEditLabelPairValues(alEditLabelPair);
		medplan_bean.setMedOrderIds(arrOrderId);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
		putObjectInBean(medplan_bean_id,medplan_bean,request);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
		putObjectInBean(param_bean_id,param_bean,request);
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_1,bean_1,request);
		putObjectInBean(bean_id_2,bean_2,request);
		putObjectInBean(bean_id_st,bean_st,request); // Added for KAUH-SCF-0094 [IN:035252] 
	}
	catch(Exception e){
		e.printStackTrace();
	}
    finally{ // Added for ML-MMOH-SCF-0356.1 - start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0356.1 - start

            _bw.write(_wl_block562Bytes, _wl_block562);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ItemType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/DosageDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ISSUEUOM.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQuantity.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insurance.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalNo.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugNames.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MINLEVEL.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ROL.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CreateRequest.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Manufacturing.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MINLEVEL.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ROL.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CreateRequest.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.INCLUDE_IN_BMS.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Findings.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Findings.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugInstructions.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.VerificationRemarks.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparationCharges.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparationCharges.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }
}

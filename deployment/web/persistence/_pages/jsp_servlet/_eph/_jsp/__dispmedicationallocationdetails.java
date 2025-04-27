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

public final class __dispmedicationallocationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllocationDetails.jsp", 1709120715427L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?           created\n04/07/2017      ML-MMOH-SCF-0690  Devindra      \tUnable to select batch for alternate drug if the batch expiry is near/lesser than prescribed duration and only on batch exist for the item in the store.\n04/19/2017\tMMS-DM-SCF-0417   Manickavasagam\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\n04/19/2017\tBSP-SCF-0041\t  Mukesh\t\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\t\t\n10/01/2019\t  \tIN068344\t     \tManickavasagam \t\t  \t\t\t\t\t\t\t\tGHL-CRF-0549 [IN068344] \n10/05/2019\t  \tIN068344\t     \tManickavasagam \t\t  \t\t\t\t\t\t\t\tAMS-CRF-0204 \n13/08/2019\t  \tIN071102\t     \tManickavasagam \t\t  \t\t\t\t\t\t\t\tMMS-KH-SCF-0035 \n30/08/2019\t  \tIN070894\t     \tDevindra \t\t  \t\t\t\t\t\t\t\t\tML-MMOH-SCF-1318(RF) \n29/05/2020\t\tIN:072092\t        Manickavasagam J\t\t\t     GHL-CRF-0618\n03/11/2020\t\tIN:074297\t        Manickavasagam J\t\t\t     GHL-SCF-1527\n--------------------------------------------------------------------------------------------------------------\n -->\n\n";
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!--  Added for ML-MMOH-CRF-0690 -->\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n\t\t<form name=\"DispMedicationAllocateDetails\" id=\"DispMedicationAllocateDetails\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"3%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"3%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\"5%\" nowrap>&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostGreen.jpg\" style=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' height=\'15\' width=\'15\' title=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginGreen.jpg\" style=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" height=\'15\' width=\'15\' title=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostRed.jpg\" style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginRed.jpg\" style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCost.jpg\" title=\"Low Cost Item\"  style=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" height=\'15\' width=\'15\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMargin.jpg\" style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" height=\'15\' width=\'15\' title=\"High Margin Item\"  >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Innovator.jpg\" style=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  title=\"Innovator Item\"  height=\'15\' width=\'15\' > ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<!-- <td class=\"white\" width=\"3%\">&nbsp;&nbsp;&nbsp;&nbsp;</td> -->\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" width=\"3%\"><label style=\"cursor:pointer;color:blue;font-size:9\" onclick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'ALLOC\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'\',\'\', \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</label></td>  <!--  , \'patient_id\' added for [IN:035667] -->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" style=\"font-size:9;\" width=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"><label style=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onmouseover=\'resetQtyValue()\' onclick=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"drug_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">&nbsp;";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\"></img>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t         <img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  height=\'20\'  width=\'20\' title=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'></img>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<!-- added for  Bru-HIMS-CRF-082 [IN:029948] -->\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\t\t\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onclick=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',\'\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\"  id=\"alte_drug_desc";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;</label><!-- added alt_drug_line_no for  ML-BRU-SCF-0474[IN035407] -->\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\' height=\'20\'  width=\'20\'  title=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" width=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><br>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =";font-size:9\">&nbsp;";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="<br>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_tmp_alloc_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"alt_tmp_alloc_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"> <!-- added for  ML-BRU-SCF-0474[IN035407] -->\n  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t</label>&nbsp;\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:9;color:black\"><b>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</b></label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"allocate_qty_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" style=\"font-size:9\"><label class=\"label\">&nbsp;";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</label></td>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_qty_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"pres_qty_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bms_qty_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"bms_qty_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bms_strength";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"bms_strength";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"prescribed_strength";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"prescribed_strength";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dischargeIND";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"dischargeIND";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_drug_count_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"alt_drug_count_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"><!--added for  ML-BRU-SCF-0474[IN035407] -->\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" style=\"font-size:9\" id=\"bms_det_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"> &nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&nbsp;<b>(";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =")</b>&nbsp;";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="<br>&nbsp;<b>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</b>&nbsp;";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\"hidden\" name=\"qty_found\" id=\"qty_found\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_mode\" id=\"oper_mode\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"resetQty\" id=\"resetQty\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\n\t\t\t<input type=\"hidden\" name=\"tmp_alloc_val\" id=\"tmp_alloc_val\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\t <!--added by Manickavasagam J for SCF-6259 -->\n\n\t\t\t<input type=\"hidden\" name=\"bms_strength_val\" id=\"bms_strength_val\" >\t\t\t\t<!--added by Manickavasagam J for SCF-6259 -->\n\t\t\t<input type=\"hidden\" name=\"prescribed_bms_strength_val\" id=\"prescribed_bms_strength_val\" >  <!--added by Manickavasagam J for SCF-6259 -->\n\t\t\t<input type=\"hidden\" name=\"alt_strength_value\" id=\"alt_strength_value\">\t\t\t   <!--added by Manickavasagam J for SCF-6259 -->\t\n\t\t\t<input type=\"hidden\" name=\"alt_drug_line_no\" id=\"alt_drug_line_no\">\t\t\t   <!--added for  ML-BRU-SCF-0474[IN035407] -->\t\n\t\t\t<input type=\"hidden\" name=\"alt_drug_count\" id=\"alt_drug_count\">\t\t\t   <!--added for  ML-BRU-SCF-0474[IN035407] -->\t\n\t\t\t<input type=\"hidden\" name=\"main_drug_line_no\" id=\"main_drug_line_no\">\t\t\t   <!-- added for  ML-BRU-SCF-0474[IN035407] -->\t\n\t\t\t<input type=\"hidden\" name=\"alt_drug_remarks_ind\" id=\"alt_drug_remarks_ind\" value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\t\t\t   <!-- added for Bru-HIMS-CRF-082 [IN:029948] -->\t\n\t\t\t<input type=\"hidden\" name=\"expiry_date\" id=\"expiry_date\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'><!--added for ML-MMOH-SCF-0690 -->\t\n\t\t</form>\n\t</body>\n\t<script>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\tclickNextDrug(\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\',document,window,\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\');\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\tclickNextDrug(\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\',document,window,\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\',document,window);\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );
	
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

 
		DecimalFormat dfToInteger = new DecimalFormat("#.##");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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

Connection con			= null;  // Added for ML-MMOH-CRF-0468

		
try{

	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
	boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468
	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
	String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ; //added for AMS-CRF-204
	boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618


	String	bean_id			=	"DispMedicationAllStages" ;

			String	bean_name		=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name , request) ;
			bean.setLanguageId(locale);
			
			String	bean_id_1		=	"DispMedicationBean" ;
			String	bean_name_1		=	"ePH.DispMedicationBean";
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
		   
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String alt_drug_remarks_ind = bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]

			String patient_id		=	request.getParameter("patient_id");
			String re_load_yn		=	request.getParameter("re_load_yn")==null?"Y":request.getParameter("re_load_yn");
			String order_id			=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String chosen_drug		=	request.getParameter("chosen_drug")==null?"":request.getParameter("chosen_drug");
			String source			=	request.getParameter("source")==null?"":request.getParameter("source");
			String recno			=	request.getParameter("recno")==null?"":request.getParameter("recno");
			String resetQty			=	request.getParameter("resetQty");
			String alt_drg_no		=	request.getParameter("alt_drg_no")==null?"0":request.getParameter("alt_drg_no");
			String alt_drg_sel		=	request.getParameter("alt_drg_sel")==null?"N":request.getParameter("alt_drg_sel");
			String durationVal		=	request.getParameter("durationVal")==null?"":request.getParameter("durationVal"); // Added for ML-MMOH-SCF-0690 - Start
			String durnPrdVal		=	request.getParameter("durnPrdVal")==null?"":request.getParameter("durnPrdVal"); 
			if(!durnPrdVal.equals(""))
				durationVal = durnPrdVal; 
			String expiry_date = bean_1.getSysdatePlusDays(durationVal);// Added for ML-MMOH-SCF-0690  - End
			String encounter_id		=	bean_1.getEncounterID(); //AMS-CRF-0204
			String sPRNOrAbsOrder   =   "F";	
			String order_line_no	=	"";
			String drug_code		=	"";
			String drug_name		=	"";	
			String end_date			=	"";
			String pres_qty			=	"";
			String qty_uom			=	"";
			String qty_uom_disp		=	"";
			String alt_drug_code	=	"";
			String alt_drug_desc	=	"";
			String drug_color		=	"";
			String style			=	"";
			String call_function	=	"";
			String form_code		=	"";
			String bms_qty			=	"";
			String uom				=	""; 
			String alt_drug_qty		=	"";	
			String width_1			=	"";
			String width_2			=	"";
			String width_3			=	"";
			String gif				=	"";
			String strength_value	=	"";
			String strength_uom		=	"";
			String strength_uom_disp	=	"";
			String onClick			=	"";
			String filling_status	=	"";	
			String drug_class		=	"";
			String fractroundupyn   =   "";
			String bms_strength_1	=	"";
			String iv_prep_yn	=	"";
			boolean qty_found		=	false;
			double	tot_qty			=	0;
			long		stk_qty		=	0;
			int adr_count			=   0;
			String sOrderType = "", sAbsOrder= "", dischargeIND= "";
			String medical_applicable="";//added for ghl-crf-0548
			String allow_alternate_yn="";//added for ghl-crf-0549
			int alter_drugs_avel		=0;//added for ghl-crf-0548 
			//String allergy		=	"";
			//String exceed_dose	=	"";
			//String duplicate		=	"";
			//String generic_id		=	"";
			//String generic_name	=	"";
			//String dosage_details	=	"";
			//String dosage_dtls	=	"";
			//String start_date		=	"";
			//String duplicate_yn	=	"";
			//String min_dose_dtls	=	"";
			//String ordered_by		=	"";
			//String location		=	"";

			ArrayList	colors	    =	new ArrayList();
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			

	//GHL-CRF-549 - start
				String bl_grp_app		   = "";
				String mm_item_low_cost_yn = "";	
				String mm_item_high_margin_yn = "";
				String mm_item_Innovator_yn = "";
				String low_cost_green_style ="visibility:none";
				String high_margin_green_style ="visibility:none";
				String high_margin_red_style   ="visibility:none";
				String low_cost_red_style	="visibility:none";
				String low_cost_grey_style ="visibility:none";
				String high_margin_grey_style ="visibility:none";
				String innovator_style		="visibility:none";
				String item_type = "";
				if(item_type_site_app && !encounter_id.equals(""))
				bl_grp_app = bean.getItemTypeApp(patient_id);
				if(bl_grp_app==null || bl_grp_app.equals(""))//added for AMS-CRF-0204
					bl_grp_app = "N";
				//bl_grp_app = "L";//REMOVED  for AMS-CRF-0204
				//GHL-CRF-549 - end

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			String disp_level		=	bean_1.getDispLevelValue();

			ArrayList alOrderIds    = new ArrayList();
			ArrayList tmpResult     = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
			}
			//Declaration ends 
			if(disp_level.equals("P")) {
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR")  || ( tpn_mf_label && bean_1.getCriteriaOrderType().equals("TD")))){ //TD added for  ML-MMOH-CRF-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
				for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
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
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			String store_code		=	bean_1.getStoreCode();
			String module_id		=	bean.getModuleId();
			filling_status			=	bean_1.getFillingStatus();
			//String disp_stage		=	bean_1.getDispStage();
			
			if(module_id.equals("1")) {
				width_1	=	"50%";
				width_2	=	"25%";
				width_3	=	"25%";
			}
			else {
				width_1	=	"61%";
				width_2	=	"15%";
				width_3	=	"19%";
			}

            _bw.write(_wl_block8Bytes, _wl_block8);

				String classvalue			=	"";
				int recCount				=	1;
				ArrayList stock_opt			=	new ArrayList();
				String image				=	"";
				String alt_strength_value	=	"";
				String alloc_strength		=	"";
				String bms_strength			=	"";
				String tmp_bms_qty			=	"";
				String in_formulary			=	"";
				String tmp_drug_code		=	"";
				String tmp_order_id			=	"";
				String min_end_date			=	"";
				boolean multi_found			=	false;
				//float  prod_qty				=  0.0f;
				String alt_strength_uom		=	"";
				float tmp_alloc				=	0;
				float alt_drug_alloc_qty	=   0;  //added for  ML-BRU-SCF-0474[IN035407]
				StringTokenizer		token	=	null;
				ArrayList		multi_drugs	=	null;
				String qty					=	null;
				String alt_drug				=	null;
				ArrayList alt_qty			=	null;
				HashMap pack_dtls			=	null;
				String 	drug_name_1			=	"";
				float main_pack_size		=   0;
				String tmp_bms_qty_1		=	"";
				String bms_qty_1			=   "";
				String ext_prod_id			=   "";
				String alt_external_prod_id	=	"";
				String drug_verf_reqd_yn	=	"";
				String order_line_status	=	"";
				String main_strength_per_value_pres_uom ="";
				String disp_locn_catg		=	bean_1.getDispLocnCatg();
				String ip_scope             = bean_1.getIPScope();  // Added for ML-MMOH-CRF-0434 [IN057356]
				//String taper, taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable; //Commented for RUT-CRF-0088 [IN036978]
				float prescribed_strength	=   0; 
				//GHL-CRF-0618 - start
				String preference = "";  
				String preference_img = ""; 
				String formulary_value = "";
				String formulary_code  = "";
				String blg_grp_type = "";
				HashMap hmBlgGrp = null;

				if(formulary_billing_app){
					String blng_grp_id = bean.getBillingGrpId();
					//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
					formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
					formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
					blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
					if(!formulary_code.equals(""))
					 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id); //blng_grp_id added for GHL-SCF-1527

				}
				//GHL-CRF-0618  - end
				for(int i=0;i<orderLineDtls.size(); i++){
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
						
						stock_opt		=	new ArrayList();
						image			=	"";
						tot_qty			=	0;
						onClick			=	"";
						alloc_strength	=	"";
						bms_strength	=	"";
						tmp_alloc		=	0;
						alt_drug_remarks_disp = "";

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id		=	(String)orderLineDtls.get(i);
							//ordered_by		=	(String)orderLineDtls.get(++i);
							++i;
							++i;
							//location		=	(String)orderLineDtls.get(++i);
							++i;
						}

						//allergy			=	(String)orderLineDtls.get(i);
						//exceed_dose		=	(String)orderLineDtls.get(++i);
						++i;
						++i;
						//duplicate		=	(String)orderLineDtls.get(++i);
						drug_code		=	(String)orderLineDtls.get(++i);
						drug_name		=	(String)orderLineDtls.get(++i);
						drug_name_1		="";
						drug_name_1		=  drug_name;   
								
						if(!drug_name_1.equals("")&&drug_name_1!=null){
							drug_name_1=drug_name_1.replaceAll(" ","%20");
							drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
							drug_name_1=drug_name_1.replaceAll("%2520","%20");
						}

						//dosage_dtls		=	(String)orderLineDtls.get(++i);
						++i;
						//start_date		=	(String)orderLineDtls.get(++i);
						++i;
						end_date		=	(String)orderLineDtls.get(++i);
						pres_qty		=	(String)orderLineDtls.get(++i);
						qty_uom			=	(String)orderLineDtls.get(++i);
						qty_uom_disp	=	(String)orderLineDtls.get(++i);
						order_line_no	=	(String)orderLineDtls.get(++i);
						//generic_id		=	(String)orderLineDtls.get(++i);				
						//generic_name	=	(String)orderLineDtls.get(++i);				
						//dosage_details	=	(String)orderLineDtls.get(++i);
						i	=	i+3;
						bms_qty			=	(String)orderLineDtls.get(++i);
						i	=	i+7;
						//duplicate_yn	=	(String)orderLineDtls.get(++i);
						//min_dose_dtls	=	(String)orderLineDtls.get(++i);
						i	=	i+1;
						strength_value	=	(String)orderLineDtls.get(++i);

						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
							strength_value = Float.parseFloat(strength_value) +"" ;

						strength_uom	=	(String)orderLineDtls.get(++i);
						strength_uom_disp	=	(String)orderLineDtls.get(++i);
						if(module_id.equals("2")) {
							token	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
							while(token.hasMoreTokens()){
								stock_opt.add((String)token.nextToken());
							} 
						}
						//strength_uom	=	(String)orderLineDtls.get(++i);
						ext_prod_id  = (String)orderLineDtls.get(++i);
						in_formulary	=	((String)orderLineDtls.get(++i));
						iv_prep_yn	=	((String)orderLineDtls.get(++i));
						drug_class	=	(((String)orderLineDtls.get(++i)).trim());
						i=i+3;
						drug_verf_reqd_yn = (String)orderLineDtls.get(++i);
						order_line_status = (String)orderLineDtls.get(++i);
						main_strength_per_value_pres_uom   =(String)orderLineDtls.get(++i);
						i++;
						sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						i++;
						sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						dischargeIND = (String)orderLineDtls.get(++i); //dischargeIND
						if(sOrderType.equals("P") || sAbsOrder.equals("N"))	{
							sPRNOrAbsOrder = "T";
						}
						i=i+24;	 //12-->13 for JD-CRF-0179 [IN:041211]//canfed to 22 to 24 for mms-dm-crf-0209.1changed 13 to 14 for Bru-HIMS-CRF-093-DD1[IN047223] // 14 --> 15 for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271] --> 17 for  HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080//Changed 20 to 23 for TH-KW-CRF-0008
						/*Commented for RUT-CRF-0088 [IN036978]
						taper_order_yn 					=	(String)orderLineDtls.get(++i);// RUT-CRF-0069 ICN29607
						taper_order_id					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607
						taper_order_line_num			=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607    */
					  /* ------------- commented for TO REMOVE THE DRUG LEVEL VERIFICATION ---------------
					  if(!bean_1.getVerfCombinedWithAlloc().equals("C")&& !disp_locn_catg.equals("I")){
							if(drug_verf_reqd_yn.equals("Y")){
								if(order_line_status.equals("VF")){
									
								}else{
									continue;
								}					
							}
						}
						*/
						//if(!(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))){   //Commented for RUT-CRF-0088 [IN036978] 
							boolean stock_avl	=	bean.checkStock(drug_code,store_code,bms_qty,end_date);
							bean.setStockItems(drug_code,stock_opt);
							if(stock_opt!=null && stock_opt.size()>0 && !stock_opt.get(0).equals("Y")) //if block added for MMS-QF-SCF-0454 [IN:052404]
								stock_avl = false;

							if(end_date.length() >=10)
							end_date		=	end_date.substring(0,10);

							if(strength_value.equals("0")||strength_value.equals("0.0")) {
								strength_value	=	"";
								strength_uom	=	"";
							}	
							if(!chosen_drug.equals("") && !chosen_drug.equals(drug_code))
								continue;
							if(bean.checkHold(order_id,order_line_no)) 
								continue;

							if(in_formulary.equals("N"))
								continue;

							adr_count	=	bean.getADRCount(patient_id,drug_code);
							multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);

							if(multi_drugs.size() >= 1) {
								multi_found		=	true;
								bean.setMultiFound(multi_found);
								//bean.checkBMS(patient_id,order_id,order_line_no,alt_drug_code);
							}

							qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
							if(stock_opt!=null && stock_opt.size()>0 && !stock_opt.get(0).equals("Y")){ //if block added for MMS-SCF-SCF-0417 and BSP-SCF-0041
								qty = "";
							}
							if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
								tot_qty				+=	Double.parseDouble(qty);
							medical_applicable=bean.checkMedicalItemYN(drug_code);//added for ghl-crf-0548
							alter_drugs_avel=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
							if(!strength_value.equals("")){
								  alt_drug			=	bean.checkMultiStrength(drug_code);
							}
							else if(medical_applicable.equals("Y") && alter_drugs_avel>0 ){//ADDED FOR GHL-CRF-0548
								alt_drug ="Y";
							}
							else{
								alt_drug ="N";
							}
							alt_drug_qty		=	"";

							if(source.equals("Fill")) {
								if(disp_level.equals("O") && filling_status.equals("A")) {
									if(multi_drugs.size()>0){
										for(int n=0; n<multi_drugs.size(); n+=5)	{ 

											alt_drug_code	=	(String)multi_drugs.get(n);
											alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
											if(!alt_drug_qty.equals(""))
											break;
										}
										//if(qty.equals("") && alt_drug_qty.equals(""))
										 // continue; 
									}
								}
							}
							else  if(source.equals("Alloc")) {
								if(bean.getFilling(patient_id,order_id,order_line_no))
									continue;
							}

							if(!order_id.equals(tmp_order_id) && !drug_code.equals(tmp_drug_code) ) {
								stk_qty	= Long.parseLong(bms_qty);	
								tmp_order_id	=	order_id;
								tmp_drug_code	=	drug_code;
								min_end_date	=	end_date;
							} 
							else {
								stk_qty	+= Long.parseLong(bms_qty);		
							}

							if(multi_drugs.size() < 1)	{
								style				=	"cursor:pointer;color:blue";
								
								if(module_id.equals("2")) {
									call_function	  =	"callStockEntry('"+patient_id+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+drug_name_1+"','"+alt_drug+"','','','','"+strength_uom+"','"+bms_qty+"','"+source+"','"+recCount+"','"+strength_value+"','"+alt_strength_value+"','"+end_date+"','"+qty_uom+"','"+drug_class+"','" +stk_qty+"','"+min_end_date+"','"+main_strength_per_value_pres_uom+"','"+sPRNOrAbsOrder+"','"+alt_drg_no+"','"+alt_strength_uom+"','','"+facility_id+"','"+bean_1.getDispLocnCode()+"');changeRowColor('"+recCount+"');"; //added one argument(last) for  ML-BRU-SCF-0474[IN035407]
								}
								else{
									call_function	  =	"callDrugEntry('"+patient_id+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+drug_name_1+"','"+alt_drug+"','','','','"+qty_uom+"','"+bms_qty+"','"+source+"','"+sPRNOrAbsOrder+"');changeRowColor('"+recCount+"');";
								}
							}
							else{
								style				=	"font-weight:bold";
								call_function		=	"";
								if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){ //if block Added for Bru-HIMS-CRF-082 [IN:029948]
									alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
									if(alt_drug_remarks_ind.equals("M"))
										alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
								}
							}
							tmp_bms_qty				=	bms_qty;
							//drug_code

							pack_dtls				=	bean.getPackSize(drug_code);
							main_pack_size		=   0;
							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									 main_pack_size	    =	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
									tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
									bms_qty_1			=   Float.parseFloat(bms_qty)*main_pack_size+"";
								}		
							}
							else{
								tmp_bms_qty_1		=   tmp_bms_qty;
								bms_qty_1			=	bms_qty;
						   }
							if((bean.loadHoldRemarks(order_id,order_line_no).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A"))) {   // if condition Added for ML-MMOH-CRF-0434 [IN057356] - Start

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block10Bytes, _wl_block10);

							if(module_id.equals("2")) { 
								//if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
								if(!stock_avl) {
									image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
								}
								else {
									image		=	"";
								}
								if(alt_drug.equals("Y") && alt_drug !=null) {//modified for ghl-crf-0548 	
								//GHL-CRF-0549 - start
									if(item_type_site_app){
										allow_alternate_yn = bean.getAllowAlternateYN(order_id,order_line_no,iv_prep_yn);
										if(allow_alternate_yn==null || allow_alternate_yn.equals(""))
											allow_alternate_yn = "N";
									}

									gif	=	"<img src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' onClick=\"callMultiStrength('"+drug_code+"','"+drug_name_1+"','"+patient_id+"','"+order_id+"','"+order_line_no+"','"+source+"','"+store_code+"','"+pres_qty+"','"+end_date+"','"+strength_uom+"','"+recCount+"','"+alt_drug_remarks_ind+"','"+expiry_date+"','"+disp_locn_catg+"','"+allow_alternate_yn+"','"+item_type_site_app+"','"+strength_value+"','"+iv_prep_yn+"');\" style='cursor:pointer' title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AlternateDrugs.label","ph_labels")+"'>"; // '"+expiry_date+"' Added for ML-MMOH-0690 								//disp_locn_catg,allow_alternate_yn,item_type_site_app passed for GHL-CRF-0549 strength_value added for ghl-crf-0548
								}			
								else {
									gif	=	"";
								}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(image));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gif));
            _bw.write(_wl_block13Bytes, _wl_block13);
							//added for AMS-CRF-204 - start
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
							if(formulary_billing_app){//GHL-CRF-0618 - start
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
									//System.err.println("drug_code=========>"+drug_code+"==hmBlgGrp===>"+hmBlgGrp);
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}

									}
								} //GHL-CRF-0618 - end


								//System.err.println("DispMedicationFilling.jsp====low_cost_green_style==>"+low_cost_green_style+"==high_margin_green_style==>"+high_margin_green_style+"==low_cost_red_style==>"+low_cost_red_style+"==high_margin_red_style==>"+high_margin_red_style);
								
									

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(!low_cost_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(low_cost_green_style));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
								if(!high_margin_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(high_margin_green_style));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}if(!low_cost_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(low_cost_red_style));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}if(!high_margin_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(high_margin_red_style));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
} if(!low_cost_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(low_cost_grey_style));
            _bw.write(_wl_block25Bytes, _wl_block25);
} if(!high_margin_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(high_margin_grey_style));
            _bw.write(_wl_block27Bytes, _wl_block27);
}if(!innovator_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(innovator_style));
            _bw.write(_wl_block29Bytes, _wl_block29);
} 
            _bw.write(_wl_block30Bytes, _wl_block30);
if(formulary_billing_app){ //GHL-CRF-0618 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block33Bytes, _wl_block33);
									}
								}	
								
            _bw.write(_wl_block34Bytes, _wl_block34);
		//added for AMS-CRF-204 - End
								
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean_1.getDispLocnCode()));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

							}	
							if( !image.equals("")) {
								style				=	"font-weight:bold";
								call_function		=	"";
							}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(width_1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(style));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block49Bytes, _wl_block49);
 
							if ((ext_prod_id!=null)&& !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block51Bytes, _wl_block51);

							}
							if(adr_count>0){

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

							}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block55Bytes, _wl_block55);

							if(module_id.equals("1")) 
								onClick="callDrugEntry";
							else
								onClick="callStockEntry";

							int	k	=	0;
							int alt_drug_count = 0; //added for  ML-BRU-SCF-0474[IN035407]
							alt_qty	=	new ArrayList();
							int alt_drug_line_no=1;  //added for  ML-BRU-SCF-0474[IN035407]
							String alt_drug_desc_1 = "";
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code			=	(String)multi_drugs.get(n);
								alt_drug_desc			=	(String)multi_drugs.get(n+1);
								alt_drug_desc_1	=    alt_drug_desc;
								if(alt_drug_desc_1!=null && !alt_drug_desc_1.equals("")){
									alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
									//alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1);
									alt_drug_desc_1  =	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8");
									alt_drug_desc_1  = alt_drug_desc_1.replaceAll("%2520","%20");
								}
								form_code				=	(String)multi_drugs.get(n+2);
								alt_strength_value		=	(String)multi_drugs.get(n+3);
								alt_strength_uom		=	(String)multi_drugs.get(n+4);
								drug_color				=	(String)colors.get(k++);
								pack_dtls				=	bean.getPackSize(alt_drug_code);
								fractroundupyn          =   bean.getFractRoundupYN(alt_drug_code);
								//!medical_applicable.equals("Y") added for ghl-crf-0548 
								if(!medical_applicable.equals("Y") && Float.parseFloat(alt_strength_value)<1  )
									alt_strength_value =( Float.parseFloat(alt_strength_value))+"";

								if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
									form_code	=	(String)pack_dtls.get("STOCK_UOM");
								}

								if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
									alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
								}
								else{
									alt_external_prod_id	= "";
								}
								qty		=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
								if(!qty.equals("") && !qty.equals("0")) {
									alt_qty.add(alt_drug_code);
									alt_qty.add(qty);
									alt_qty.add(form_code);
									alt_qty.add(alt_strength_value);
								}
								adr_count = bean.getADRCount(patient_id,alt_drug_code);
								/*
								if(!strength_value.equals("") && !alt_strength_value.equals("")) {
									prod_qty			=	Float.parseFloat(strength_value) / Float.parseFloat(alt_strength_value);
									bms_qty				=	new Float(prod_qty  * Float.parseFloat(bms_qty))+"";
								} */

								/*ArrayList link_reqd		=	bean.getAlternateDrugLinkReqd(patient_id,order_id,order_line_no,new Float(bms_qty).intValue());

								if(link_reqd.size() >=1) {
										if(link_reqd.contains(alt_drug_code)) {
												style		=	"cursor:pointer;color:"+drug_color;
										}
										else {
												style		="font-weight:bold";
												onClick		=	"";
										}
								}
								else { */
								style		="cursor:pointer;color:"+drug_color;
								//}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(style));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(onClick));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_desc_1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tmp_bms_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(source));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_strength_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(stk_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(min_end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(main_strength_per_value_pres_uom));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_drg_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_strength_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_line_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean_1.getDispLocnCode()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(n));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_strength_value));
            out.print( String.valueOf(bean.getUomDisplay(facility_id,alt_strength_uom)));
            _bw.write(_wl_block62Bytes, _wl_block62);

								if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(alt_external_prod_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_desc_1));
            _bw.write(_wl_block51Bytes, _wl_block51);

								}
								if(adr_count>0){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

								}
								alt_drug_count=alt_drug_line_no; //added for  ML-BRU-SCF-0474[IN035407]
								alt_drug_line_no++; //added for  ML-BRU-SCF-0474[IN035407]
							}

            _bw.write(_wl_block65Bytes, _wl_block65);

							if(multi_drugs.size() > 1 ) {

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(width_2));
            _bw.write(_wl_block68Bytes, _wl_block68);

								int x			=	0;
								String alternate_drug		=	"";
								float pack_size				=	1;
								float strength_per_value	=	1.0f;
								prescribed_strength	=0;
								int alt_assign_drug_line_no=1; // added for  ML-BRU-SCF-0474[IN035407]
								HashMap IssueUOMAndBaseUOM       = new HashMap(); // added for ML-BRU-SCF-1892 - Start
								String base_uom				     = "";	
								String orig_dflt_issue_uom		= "";
								double base_to_disp_uom_equl     = 0;
								double base_to_def_uom_equl      = 1; // added for ML-BRU-SCF-1892 - End
								for(int l=0; l<alt_qty.size(); l+=4) { 
									alt_drug_alloc_qty = 0;		//added for  ML-BRU-SCF-0474[IN035407]
									alternate_drug		=	(String)alt_qty.get(l);	
									qty					=	(String)alt_qty.get(l+1);	
									uom					=	(String)alt_qty.get(l+2);	
									alt_strength_value	=	(String)alt_qty.get(l+3);	
									drug_color			=	(String)colors.get(x++);
									pack_dtls			=	bean.getPackSize(alternate_drug);
									
									IssueUOMAndBaseUOM.clear(); // added for ML-BRU-SCF-1892 - Start
									IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); 
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
									base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
									orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom); // added for ML-BRU-SCF-1892 - End
									
									if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
										if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
											pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
											if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
											strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
											  if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // if condition Added for ML-BRU-SCF-1892 // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160					
												//|| (!uom.equals(base_uom) && !alternate_drug.equals("")) commented for ML-MMOH-SCF-1318
											     qty = Math.ceil(Float.parseFloat(qty)/pack_size)+"";//Added for ML-BRU-SCF-1443 and removed math.round(Integer.parseInt Math.ceil(Float.parseFloat to math.ceil for MMS-KH-SCF-0035
												 
											  }else if(!uom.equals(base_uom) && !alternate_drug.equals("") ){ // else if block added for ML-MMOH-SCF-1318 - Start							
												  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
											  }
											  }
										}		
									}
									if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
									tmp_alloc	+=	 ((Float.parseFloat(alt_strength_value)) * Float.parseFloat(qty)*pack_size)/strength_per_value ;//Changed Integer.parseInt to Float.parseFloat for MMS-KH-SCF-0115 
									alt_drug_alloc_qty = ((Float.parseFloat(alt_strength_value)) * Float.parseFloat(qty)*pack_size)/strength_per_value ;  //added for  ML-BRU-SCF-0474[IN035407]//Changed Integer.parseInt to Float.parseFloat for MMS-KH-SCF-0115 
									}
									if(fractroundupyn.equals("N")) {
										alloc_strength	=	tmp_alloc+""+strength_uom;
									}
									else{
										alloc_strength	=  "";
									}
									//pres_qty		=	bms_qty;
									prescribed_strength	=   0;
									if(strength_value.equals(""))
										strength_value	=	"0";
									prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/Float.parseFloat(main_strength_per_value_pres_uom);

									if(strength_value.equals("0"))
										strength_value	=	"";

									float balance_strength		=	prescribed_strength - tmp_alloc;
									if(balance_strength<1)
										balance_strength		=	0;
										if(fractroundupyn.equals("N")||fractroundupyn.equals("")) {
											if(balance_strength!=0) {
												bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
											} 
											else {
												//bms_qty	+=	bms_qty+(Float.parseFloat(pres_qty)- Float.parseFloat(qty)) +"";
												if(!medical_applicable.equals("Y"))//added for ghl-crf-0548
												bms_qty						=	"0";
											}
										}
										else{
											// bms_qty             =   bms_qty;
											 if(strength_value.equals(""))
												 strength_value="0";
												 bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
											if(strength_value.equals("0"))
												strength_value="";
										} 
										bms_qty=Math.round((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom))/main_pack_size))+"";
										bms_strength				=	balance_strength+"";

										if(!qty.equals("") && !qty.equals("0")) {
											tot_qty		+=	Double.parseDouble(qty);
											// tot_qty     =	tot_qty*pack_size;
											qty_found	=	true;
										}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_assign_drug_line_no));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_assign_drug_line_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(alt_drug_alloc_qty));
            _bw.write(_wl_block74Bytes, _wl_block74);
 
										alt_assign_drug_line_no++ ;// added for  ML-BRU-SCF-0474[IN035407]
									}
									/*if(!alt_strength_value.equals("")) {
									alloc_strength	=	Integer.parseInt(alt_strength_value) * tot_qty+"";
									alloc_strength	=	(Integer.parseInt(alloc_strength)==0)?"":alloc_strength+" "+strength_uom;
									} */

            _bw.write(_wl_block75Bytes, _wl_block75);
if(!alloc_strength.equals("0.0") && !alloc_strength.equals("")){ //added for ghl-crf-0548
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(alloc_strength));
            _bw.write(_wl_block77Bytes, _wl_block77);
} 
            _bw.write(_wl_block78Bytes, _wl_block78);

								}
								else	{	
									if(qty.equals("") || qty.equals("0")) { 
										uom	=	"";	
										qty	=	"";
									}
									else 
										uom=qty_uom;

									if(!qty.equals("") && !qty.equals("0")) {
										qty_found	=	true;

										if(!strength_value.equals("") )
											alloc_strength	=	Float.parseFloat(strength_value) * Double.parseDouble(qty)+" "+strength_uom;
									}

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(width_2));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tmp_bms_qty));
            _bw.write(_wl_block86Bytes, _wl_block86);
	
								}
								if(multi_drugs.size() > 1 ) { 
									/* if(fractroundupyn.equals("Y")){
									   bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									 }*/
									//if(tot_qty > 0) {
									//}
									/*
									if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
										if(tot_qty > 0)
											bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
										else 
											bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
										}
										else {
											if(tot_qty!=0){
												bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
											}
										} */
										if(medical_applicable.equals("Y")){
										if((Float.parseFloat(bms_qty)- tot_qty)>0)
										bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									else{
										bms_qty="0";
									}
										}
										
								}
								else {
									if(!qty.equals("") && !qty.equals("0")){
										bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									}
								}
										
								if(!strength_value.equals("") && !alt_strength_value.equals("")) {
									if(bms_strength.equals(""))
										bms_strength		=	Float.parseFloat(bms_qty_1) * Float.parseFloat(strength_value)+"";	
										//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";

								}
								else if(!strength_value.equals("")) {
									//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)+"";
									bms_strength		=	"";
									strength_uom		=	"";
								}
								else 
									strength_uom	=	"";

								if(bms_qty.indexOf(".")!=-1) {
									int pos	=	bms_qty.indexOf(".");
									if(bms_qty.length() > (pos+3) )
										bms_qty	=	bms_qty.substring(0,(pos+3));
								}

								if(fractroundupyn.equals("Y")) {
									bms_strength_1="";
									strength_uom="";  
								}
								else{
									bms_strength_1=bms_strength;
								}
								//bms_strength_1 =(Float.parseFloat(bms_strength_1)/main_pack_size)+"";
								if(!bms_strength.equals("") && !bms_strength.equals("0.0")){//added for ghl-crf-0548
									 bms_strength =Float.parseFloat(bms_strength)/(Float.parseFloat(main_strength_per_value_pres_uom))+"";
								}
								else
								bms_strength_1="";

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prescribed_strength));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(dischargeIND));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(alt_drug_count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(width_3));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(retunFormatedInt(bms_qty)));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bms_strength_1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strength_uom_disp));
            _bw.write(_wl_block102Bytes, _wl_block102);

						//}  //Commented for RUT-CRF-0088 [IN036978]
					recCount++;
			} // Added for ML-MMOH-CRF-0434 [IN057356] - End
					}

				if(!multi_found) {
					bean.setMultiFound(multi_found);
				}

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(qty_found));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(resetQty));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(tmp_alloc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
            _bw.write(_wl_block1Bytes, _wl_block1);

		if(!alt_drg_sel.equals("Y")){
			int rno	=	0;
			if(!recno.equals(""))
				rno		=	Integer.parseInt(recno);
			++rno;	

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rno));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(source));
            _bw.write(_wl_block116Bytes, _wl_block116);

		}
		else{
			if(re_load_yn.equals("Y")){

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alt_drg_no));
            _bw.write(_wl_block116Bytes, _wl_block116);

			}
			else{

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block119Bytes, _wl_block119);

			}
		}

            _bw.write(_wl_block120Bytes, _wl_block120);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
}

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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationallstages_july extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllStages_JULY.jsp", 1709244927139L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?           created\n04/19/2017\tMMS-DM-SCF-0417   Manickavasagam\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\n04/19/2017\tBSP-SCF-0041\t  Mukesh\t\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\t\t\n05/12/2017\t[IN:064158]\t  Devindra\t\tChange in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).\t\t\n--------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction CheckPatReqd(Obj){\n\t\t\tif(Obj.checked==true)\n\t\t\t\tObj.value=\"C\";\n\t\t\telse\n\t\t\tObj.value=\"N\";\n\t\t}\n\t\t</script>\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"DispMedicationAllStages\" id=\"DispMedicationAllStages\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<input type=\"hidden\" name=\"alloc_fromBarCode\" id=\"alloc_fromBarCode\" value=\"N\"> <!-- added for KDAH-CRF-0231 [IN-034551]  -->\n\t\t\t<input type=\"hidden\" id=\"barcode_scan_yn\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> <!-- Added for GHL-CRF-0463 -->\n\t\t\t<input type=\"hidden\" id=\"last_scanned\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> <!-- Added for GHL-CRF-0463 -->\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' align=\"center\" border=\"1\"  id=\"verificationTable\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"6%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"3%\" style=\"font-size:9\">&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"41%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"9%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t<td align=\"right\" class=\"COLUMNHEADER\" width=\"9%\" style=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"9%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"9%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;&nbsp;</td>  \n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"8%\" style=\"font-size:9\" align=\"center\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\t\t\t\t\t<td class=\"white\" width=\"6%\">\n\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"33%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<td class=\'ALLERGY\' width=\"33%\" style=\"cursor:pointer\" onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">&nbsp;</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<td class=\'DOSELIMIT3\' width=\"33%\" style=\"cursor:pointer\" onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<td class=\'CURRENTRX\' width=\"33%\" style=\"cursor:pointer\" onClick=\"callActiveOrders(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"   width=\"3%\" nowrap ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\" >\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<!-- <label style=\"color:black;font-size:9;\" id=\'hold_remarks_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</label> -->\n                         <label style=\"color:black;font-size:9;\" onMouseOver = \"showToolTipsForChnFldRmks(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'AS\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" id=\'hold_remarks_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"hold";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"hold";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" style=\'display:none\'  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =">\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9;\" onClick=\"callReason(this,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');notifyChange()\" id=\'hold_remarks_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\'display:none\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"drug_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stock_yn";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"stock_yn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"fromdb_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"fromdb_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"hold_status";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"hold_status";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" style=\"font-size:9;\" width=\"41%\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\" nowrap>\n\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"showDrugMasterValues(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">&nbsp;+&nbsp;</label>\n\t\t\t\t\t\t<label style=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' onclick=\"showDrugDetails(\'OP\',\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',\'\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\',\'\',\'\', \'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\',\'Y\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\" id=\"drug_desc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</label>&nbsp;&nbsp; <!--  , \'patient_id\' added for [IN:035667] --><!-- Added for \'\',\'\', Inc No : 41282  (\'Y\',generic_id, order_line_status Added for JD-CRF-0198 [IN058599]) -->\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/uparrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" valign=\"center\" title=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' style=\"cursor:pointer\"height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/downarrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' style=\"cursor:pointer\" height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/MultiFrequency.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' style=\"cursor:pointer\" height=\'20\' width=\'20\' ></img>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="   <!--Added for RUT-CRF-0088 [IN036978] -->\n\t\t\t\t\t\t\t\t<label>-";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;&#40;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\" valign=\"center\"  ></img>\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'pat_reqd_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'pat_reqd_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" disabled value=\'C\' onclick=\"CheckPatReqd(this)\">\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'pat_reqd_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" disabled value=\'\'>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\"  ></img>\n\t\t\t\t\t\t\t<input type=\'checkbox\' valign=\'center\' name=\'pat_reqd_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" value=\'\' onclick=\'CheckPatReqd(this)\'>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\')\">\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=20  width=20 onClick=\"showImage(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  height=\'20\'  width=\'20\' title=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' onclick= \"callADRdetails(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\')\"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\');\" >\n\t\t\t\t\t<label id=\'lblDiscCancelledOrders_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' title=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;<img id=\'discCancelledOrders_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' src=\"../../ePH/images/DiscCancelledIndicator.png\" onclick=\'callDiscCancelledOrders(\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\", \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\");\'></label>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="<!-- ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" added for  Bru-HIMS-CRF-082 [IN:029948] -->\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<br><label id=\"id_min_stk_label\" style=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =";\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =":</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->\n\t\t\t\t<label id=\"id_min_str_stk_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" style=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =";";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'><b>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</b></label>&nbsp;&nbsp;\n\t\t\t\t<label id=\"id_stk_rol_label_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =":</label>\n\t\t\t\t<label  id=\"id_stk_rol_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</b></label>&nbsp;\n\t\t\t\t<label class=\'HYPERLINK\'  name = \"request_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"  onmouseover=\"changeCursor(this);\" onclick=\"request();\" id=\"sales_req_label\" style=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' ><b>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->\n\t\t\t\t<label class=\'HYPERLINK\'  name = \"manufacturing_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"  onmouseover=\"changeCursor(this);\" onclick=\"callManufacturingReceipt(\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\');\" id=\"manufacturing_Recpt\" style=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =";\' ><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</b></label><!--Added BRU-HIMS-CRF-080 -->\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\t\n\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER\' onclick=\"showDrugMasterValues(\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">&nbsp;+&nbsp;</label>\n\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"  id=\"alte_drug_desc";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</label>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\')\"></img>\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t                <img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  height=\'20\'  width=\'20\' title=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\n\t\t\t\t\t<br><label id=\"id_min_stk_label\" style=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =":</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->\n\t\t\t\t\t<label id=\"id_min_str_stk\" style=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</b></label>&nbsp;&nbsp;\n\t\t\t\t\t<label id=\"id_stk_rol_label\" style=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =":</label>\n\t\t\t\t\t<label  id=\"id_stk_rol\" style=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =";\'><b>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</b></label>&nbsp;\n\t\t\t\t\t<label class=\'HYPERLINK\'  name = \"request\"  onmouseover=\"changeCursor(this);\" onclick=\"request();\" id=\"sales_req_label\" style=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =";\' ><b>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" style=\"font-size:9\"  >\n\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" id=\'drugRemarks_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' title=\'\' valign=\"center\"style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\')\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="> <!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] --> \t\t\n\t\t\t\t   <script>\n\t\t\t\t\t\tvar drug_remarks = decodeURIComponent(\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\');\n\t\t\t\t\t\teval(document.getElementById(\"drugRemarks_\"+\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\')).title= drug_remarks ;\n\t\t\t\t   </script>\n\t\t\t\t</td> \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" style=\"font-size:9\" title=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t<img src=\"../../ePH/images/exceed.gif\" valign=\"center\">\n\t\t\t\t\t\t \n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" style=\"font-size:9\" width=\"10%\" ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\')\" >&nbsp;<label style=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="&nbsp;(";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =")</label><br>\n\t\t\t\t<!---/*/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t&nbsp;\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</b>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" width=\"10%\" ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\')\" ><br>\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =";font-size:9\" id=\"alloc_qty";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">&nbsp;";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="&nbsp;";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="<br>\n\t\t\t\t\t\t\t<!--  <input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"issue_uom";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" id=\"issue_qty_old";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" id=\"issue_uom_qty";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" id=\"issue_uom_uom";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" id=\"issue_uom_desc";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" id=\"issue_uom_equl";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"> -->\n\t\t\t\t\t\t\t<!-- <input type=\"hidden\" name=\"alloc_strength";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" id=\"alloc_strength";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"> -->\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t<!--  added alloc_strength for ML-BRU-SCF-0866 IN040255 -->\n\t\t\t\t\t\t</label>&nbsp;<label style=\"font-size:9;color:black\"><b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</b></label><input type=\"hidden\" name=\"alloc_strength";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"><br><label style=\"cursor:pointer;color:blue;font-size:9;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\')\">";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</label></td>\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"  style=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>&nbsp;\n\t\t\t\t\t<select onChange=\"calculateIssueUOM(this,\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\');\" name=\"issue_uom_select_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" selected>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</option>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t</select>&nbsp;\n\t\t\t\t\t<label id=\"item_desc_3\" style=\"font-weight:bold\"></label>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\')\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"AllowMoreThanPresQty";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" id=\"AllowMoreThanPresQty";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"6\" style=\"text-align:right\"  ";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="   onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" name=\"alloc_qty_";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" oncopy=\"return false\" onpaste=\"return false\"  onchange=\" if(checkAllocBmsSecondStage(\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\', this)){checkValue(this); setbatchdetails(this,\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\')};\" ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" > \n";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"alloc_qty_\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =").style.backgroundColor = \"#ADFF2F\";//changed for 62327\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"alloc_fromBarCode\").value=\"Y\";\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"6\" style=\"text-align:right\" ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="    onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" name=\"alloc_qty_";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" value=\"\" disabled>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t\t\t<input type =\"hidden\" name = \"alloc_qty_hidden_";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" value =\"document.DispMedicationAllStages.alloc_qty_";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="~";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t\t\t\t\t\t\t<label class=\"label\" ><b>&nbsp;";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</b></label>&nbsp;&nbsp;<label id=\"issue_uom_lbl";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" class=\"label\" style style=\'font-size:9\' ><b>&nbsp;";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="</b></label><br><label style=\"cursor:pointer;color:blue;font-size:9;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\',\'N\',\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</label>\n\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"     value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"6\" style=\"text-align:right\" ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =" onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" name=\"alloc_qty_";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" onblur=\"includeToBms(this,\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\')\" ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="  onKeyPress=\"return allowValidNumber(this,event,6,0);\"  maxlength=\"5\" name=\"alloc_qty_";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\"  disabled>\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"     value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\"value=\"\">\n";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t\t\t<label class=\"label\" id=\"alloc_qty";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\"><b>&nbsp;";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</b></label><br><label id=\"issue_uom_lbl";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</b></label>&nbsp;&nbsp;<label style=\"cursor:pointer;color:blue;font-size:9;\"  onClick=\"javascript:callbatchdetails(\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</label></td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alloc_strength";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" width=\"10%\" style=\"font-size:9\" ";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\')\" >&nbsp;<label class=\"label\" id=\"bms_qty_";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="&nbsp;</label>&nbsp;(";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =")<br>&nbsp;<b>";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</b><input type=\"hidden\" name=\"bms_qty";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" id=\"bms_qty";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\"><input type=\"hidden\" name=\"bms_strength";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" id=\"bms_strength";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\"></td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" id=\"override_allowed_yn_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" id=\"excl_incl_ind_";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" id=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" id=\"approval_reqd_yn_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" id=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" id=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\"   value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" id=\"drug_color_";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\"   value=\'black\'>\n";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_color_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\t   \n\t\t\t<td class=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\"><center>&nbsp;";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="</center></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="</center></td>\n";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n\t\t\t     <td class=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" align=\"center\">&nbsp;</td>\n\t\t\t     <td class=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" align=\"center\">&nbsp;</td>\n\t\t\t\t\n";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\n\t\t\t<input type=\"hidden\"  name=\"allocateyn_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" id=\"allocateyn_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\">   <!--  Added for MO-GN-5434 [IN:043669]  -->\n";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" width=\"8%\"  ";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\')\" >&nbsp;\n";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n\t\t\t\t\t<div style=\"color:blue;font-size:9;font-weight:bold\" id=\"divIncludeZeroQty";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" style=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n\t\t\t\t\t\t<input type =\"checkbox\" name =\"alloc_bms_chk_";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" onclick=\"assignValue(this);setEnableDsbleCOR(this,\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\');\" ";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =" />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n\t\t\t\t\t<div id=\"divOtherEditLables";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\t\n";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t\t<label style=\'color:blue;cursor:pointer;font-size:9\' id=\'detail\"+recCount+\"\' onClick=\"callEditDetails(this,\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\',\'D\',\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="</label><br>\n";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 =" -->\n\t\t\t\t\t<input type=\'checkbox\'   name=\'del_detail";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\' id=\'del_detail";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\'  style=\'visibility:visible\' ";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="  value=\'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\' onClick=\'updateValue(this)\'>\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 =" -->\n\t\t\t\t\t</div><!-- //Added for MO-GN-5434 [IN:043669] -->\n\t\t\t\t\t<br>\n\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9;\" id=\"fill_remarks";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" onClick=\"callFillingRemarks(this,\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\',\'D\',\'fill_remarks";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\');\"> ";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="</label>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 =" </td>\n";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t\t";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\n\t\t\t\t\t<input type=\"hidden\"  name=\"order_line_num";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t\t\t\t<input type=\"hidden\"  name=\"pres_qty";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" id=\"pres_qty";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t\t\t\t\t<input type=\"hidden\"  name=\"order_id";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" id=\"order_id";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\"  ><label style=\"color:red;font-size:9\" id=\"result_line_status";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\"style=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\"><b>";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="</b></label>  \n\t\t\t\t\t<input type=\'checkbox\'   name=\"CompleteOrder";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" id=\"CompleteOrder";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" value=\'N\' onClick=\'setcompleteorder(this)\'\tstyle=\'visibility:hidden\' ";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="   >\n\t\t\t\t\t<select name=\"ComplteOrderReason";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" id=\"ComplteOrderReason";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" onchange=\'setCheckBoxValueInAllStages(this,document.DispMedicationAllStages.CompleteOrder";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 =",document.getElementById(\"hold_remarks_\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="),";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =")\'  ";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 =">\n\t\t\t\t\t<option value=\"\">------- ";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 =" -----</option>\n";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n\t\t\t\t\t</select>\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name=\"release_flag";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" id=\"release_flag";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" value=\"N\">  \n\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl_val";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" id=\"base_to_disp_uom_equl_val";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl_val";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" id=\"base_to_def_uom_equl_val";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dischargeIND";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\" id=\"dischargeIND";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"allow_decimals_yn";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\" id=\"allow_decimals_yn";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id_1\" id=\"bean_id_1\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name_1\" id=\"bean_name_1\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\">\n\t\t\t<input type=\"hidden\" name=\"recCount\" id=\"recCount\" value=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\">\n\t\t\t<input type=\"hidden\" name=\"filling_status\" id=\"filling_status\" value=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\n\t\t\t<input type=\"hidden\" name=\"del_data\" id=\"del_data\" value=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n\t\t\t<input type=\"hidden\" name=\"ordering_facility_id\" id=\"ordering_facility_id\" value=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t<input type=\"hidden\" name=\"ord_date_time\" id=\"ord_date_time\" value=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t<input type=\"hidden\" name=\"performing_pract_id\" id=\"performing_pract_id\" value=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t<input type=\"hidden\" name=\"curr_stage\" id=\"curr_stage\" value=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_level\" id=\"disp_level\" value=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_catg\" id=\"disp_locn_catg\" value=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\">\n\t\t\t<input type=\"hidden\" name=\"ord_type\" id=\"ord_type\" value=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\">\n\t\t\t<input type=\"hidden\" name=\"IssueByUOM\" id=\"IssueByUOM\" value=\"";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\">\n\t\t\t<input type=\"hidden\" name=\"EquivalentNormalOrder\" id=\"EquivalentNormalOrder\" value=\"";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\t\t\t<input type=\"hidden\"  name=\"delivery_reqd\" id=\"delivery_reqd\" value=\"";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n\t\t\t<input type=\"hidden\" name=\"IncludeZeroQty\" id=\"IncludeZeroQty\" value=\"";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\"><!-- Added for MO-GN-5434 [IN:043669]  -->\n\t\t\t<input type=\"hidden\" name=\"pres_qty_alert\" id=\"pres_qty_alert\" value=\"";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\"><!-- code added for AMS-CRF-0035[IN033551] --> \n\t\t\t<input type=\"hidden\" name=\"includeBMSDefCheck_yn\" id=\"includeBMSDefCheck_yn\" value=\"";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\"><!-- code added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) -->   \n\t\t\t<input type=\"hidden\" name=\"strAutoCompletePartialDisp\" id=\"strAutoCompletePartialDisp\" value=\"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\"><!-- Added for JD-CRF-0179 [IN:41211] -->   \n\t\t\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\" value=\"";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t<input type=\"hidden\" name=\"disp_decimal_dtls_yn\" id=\"disp_decimal_dtls_yn\" value=\"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_amend_alt_drug_dtl\" id=\"allow_amend_alt_drug_dtl\" value=\"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\"> <!-- Added for JD-CRF-0198 [IN058599] -->\n\t\t\t\n";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\n\t\t\t\t<input type=\"hidden\" name=\"bl_encounter_id\" id=\"bl_encounter_id\" value=\"";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_patient_class\" id=\"bl_patient_class\" value=\"";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_sysdate\" id=\"bl_sysdate\" value=\"";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"tot_gross_charge_amount\" id=\"tot_gross_charge_amount\" value=\"";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tot_groos_pat_payable\" id=\"tot_groos_pat_payable\" value=\"";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t\t</form>\n";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\n   \n\t\t\t<script>alert(getMessage(\"PH_ITEMS_UOM_DEF_NOT_FOUND\",\"PH\"));</script>\n";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\n\t</body>\n\t<script>\n";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\n\t\t\tcontrolAllocFillingButtons();\n";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\t\n\t\t\tcontrolAllocButton();\n";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\n\t\t//\tcontrolFillingButton(document.DispMedicationAllStages);\n";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\n\t\t//callLegendsFrame(\'";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\',\'AS\',\'\',\'\',\'";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\');\n\t\tcallLegendsFrame(\'";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\');\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
	
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String patient_id						= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String encounter_id						= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String order_id							= request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String pract_id							= request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String pract_name						= request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
			String filling_status					=	"";
			String check_status						=	"";
			String filling_reqd						=	"";
			String delivery_reqd					=	"";
			String stage							=	"";
			String display_seq						=	"";
			String allocation_reqd					=	"";
			String filling_det						=	"";
			String del_data							=	"";
			String ext_prod_id						=	"";
			String order_line_no					=	"";
			String drug_code						=	"";
			String drug_name						=	"";
			String dosage_dtls						=	"";
			String end_date							=	"";
			String pres_qty							=	"";
			String qty_uom							=	"";
			String qty_uom_disp						=	"";
			String alt_drug_code					=	"";
			String alt_drug_desc					=	"", alt_drug_desc_1="";
			String drug_color						=	"";
			String form_code						=	"";
			String hold_status						=	"";
			String remark_status					=	"";
			String uom								=	"";
			String del_style						=	"";
			String hold_text						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value						=	"N";
			String fromdb							=	"N";
			String allergy							=	"";
			String exceed_dose						=	"";
			String generic_id						=	"";
			String generic_name						=	"";
			String dosage_details					=	"";
			String exceed_status					=	"";
			String monograph						=	"";
			String unit_dose						=	"";
			String daily_dose						=	"";
			String bms_qty							=	"";
			String allocate_button					=	"";
			String filling_button					=	"";
			String alloc_empty_det					=	"";
			String alloc_det						=	"";
			String source_code						=	"";
			String source_type						=	"";
			String ordering_facility_id				=	"";
			String ord_date_time					=	"";
			String performing_pract_id				=	"";
			String filling_empty_det				=	"";
			String alt_drug_qty						=	"";
			String duplicate_yn						=	"";
			String min_dose_dtls					=	"";
			String min_unit_dose					=	"";
			String min_daily_dose					=	"";
			ArrayList stock_opt						=	new ArrayList();
			String hold_value						=	"";
			String alloc_qty_from_tmp				=	"";
			String strength_value					=	"";
			String strength_uom						=	"";
			int		tot_qty							=	0;
			String classvalue						=	"";
			String pres_strength					=	"";
			String alt_strength_value				=	"";
			String alloc_strength					=	"";
			String bms_strength						=	"";
			String in_formulary_yn					=	"";
			String drug_class						=	"";
			String tmp_bms_qty						=	"";
			String title							=	"";
			String narc_style						=	"";
			String pat_couns_reqd_yn				=   "";
			int bmscount							=    0;
			String  scope							=   "";
			String legend1                          =   "";  
			String legend_text                      =   "";
			String disable_complete_order			=	"";
			String strChangedFludRmks				=	"";
			String pat_reqd							=	"";
			String pt_couns_reqd_yn					=	"";	
			String dosage_type						=   "";
			String dosage_unit						=   "";
			String std_dose                         =   "";
			String drug_remarks						=	"";
			String prn_remarks						=	"";
			String pharma_remarks					=	"";		
			String pres_remarks						=	"";
			String remarks_style					=	"";
			String slidingscaleremarks				=   "";
			String verificationremarks				=	"";
			String title_remarks					=	"";
			String pres_details						=	"";
			String drug_verf_reqd_yn				=	"N";
			String order_line_status				=	"";
			String drug_style						=	"";
			String alt_external_prod_id				=   "";
			String expired_yn			            =	"";
			String tmp_bms_qty_1					=	"";
			String alt_drug							=	"";
			String qty								=	null;
			String main_strength_per_value_pres_uom =   "";
			String sDispDrugAuthYN				= "N";
			String home_med_yn = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String barcode_id = "";//Added for KDAH-CRF-0231 [IN-034551] 
			String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",disc_cancelled_orders_display="display:none;", disp_mnf_flag	= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080

		/*==================code for variable UOM==============================*/
			HashMap IssueUOMAndBaseUOM     = new HashMap();
			HashMap IssueUomQty			   = new HashMap();
			HashMap hmEditLabelValues      = new HashMap();
			ArrayList alEditLabelPair	   = new ArrayList();

			String issue_qty_value		   = "";	  
			String issue_uom_desc          = ""; 
			String dflt_issue_uom		   = "";
			String base_uom				   = "";
			String issue_uom			   = "";
			String issue_uom_equl          = "";
			String strength_uom_disp        = "";
			double base_to_disp_uom_equl   = 0;
			double base_to_def_uom_equl    = 1;
			double issue_qty_val		   = 0;
			double conv_factor			   = 1;
			StringBuffer issue_qty_dtl     = new StringBuffer();

		/*=====================================================================*/
			StringTokenizer		token				=	null;
			ArrayList disp_info						=	new ArrayList(2);
			float dialog_height						=	0;	
			float main_pack_size					=   0;
			float		main_drug_pack_size			=	0;	
			int recCount							=	1;
			double tmp_alloc						=	0;
			HashMap drug_detail						=	null;
			ArrayList multi_detail					=	null;
			ArrayList main_detail					=	null;
			HashMap   alt_detail					=	null;
			ArrayList alt_drug_detail				=	null;
			ArrayList multi_drugs					=	null;
			HashMap hm								=	null;
			ArrayList alt_qty						=	null;
			ArrayList	colors						=	new ArrayList();
			ArrayList tmp							=	null;
			HashMap pack_dtls						=	null;
			float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			String currentdateplusAllocatePeriod		=  	"";			//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			boolean	endDateIsbeforAllocatedate			= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]


			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
		//Declaration ends

			String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);
			bean_1.setLanguageId(locale);

			String disp_stage					=	bean_1.getDispStage();
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			ArrayList listRecord				= new ArrayList();  // Added for KAUH-SCF-0094 [IN:035252] -- begin
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			
			String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start
			String stSalseBean_name			    =    "eST.SalesBean";
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
			String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 		// Added for KAUH-SCF-0094 [IN:035252] -- end
			String alt_drug_remarks_ind =bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();//added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
			int count=0;
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();//Added for MO-GN-5434 [IN:043669]
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN();  // Added for JD-CRF-0198 [IN058599]
			String strAllocBMSChkValue = "N";//Added for MO-GN-5434 [IN:043669]
			String strAllocBMSChecked = "";//Added for MO-GN-5434 [IN:043669]		
		    String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 	// Added for JD-CRF-0179 [IN:41211]
			/** Stock Bean Integration -Start ***/
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //Added for AAKH-SCF-0113 [IN:048937] start
			st_no_of_decimals = bean.getSt_no_of_decimals();
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); // Added for AAKH-SCF-0113 [IN:048937] -end

			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";
			int adr_count			=   0;
			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";

			/*if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP";
			}*/
			bean.loadReason();
			bean.setModuleId("2");
			bean.setPractitionerID(pract_id);
			bean.setPractitionerName(pract_name);
			
			String module_id			=	bean.getModuleId();
			Hashtable param_legends		=	bean_1.getLegendsFromParam();
			//String issue_token			=	bean_1.getIssueTokenOnRegnYN();
			String stages				=	bean_1.getStageDisplaySequence();
			String curr_stage			=	bean_1.getDispStage();
			String disp_level			=	bean_1.getDispLevelValue();
			String order_type			=   bean_1.getOrderType();
			ArrayList	delivery_det	=	bean_1.getDeliveryDetails();
			String legend               =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
				   scope				=	bean_1.getScope();
			String visibility1          =   "visibility:hiiden";
			String visibility2          =   "visibility:hiiden";
			if(scope.equals("H")){
				legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";
				visibility2          =   "visibility:hiiden";
				visibility1          =   "visibility:visible";
			}
			else{
				visibility1          =   "visibility:hiiden";
				visibility2          =   "visibility:visible";
			}

			if(delivery_det!=null && delivery_det.size() > 1) {
				//butt_status			=	"disabled";
				del_data			=	"found";
			}

			token = new StringTokenizer(stages,":");
			while(token.hasMoreTokens()){
				stage	=	(String)token.nextToken();
				if( stage.equals("F")) 
					filling_reqd = "Y";
				else if( stage.equals("D")) 
					delivery_reqd = "Y";
				else if( stage.equals("A")) 
					allocation_reqd = "Y";
				//else if( stage.equals("V")) 
					//verification_reqd = "Y";
			}

			filling_status				=	bean_1.getFillingStatus();
			if(filling_status.equals("A")) 
				display_seq	=	"A";
			else if(filling_status.equals("B"))
				display_seq	=	"F";

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null)
				alOrderIds = bean_1.getAlTrxOrderIds();
			
			if(disp_level.equals("P")){
				//order lines of all orders
				result			=	bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0)	{
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  // //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)	//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}

				tmp				=	new ArrayList();
				
				for(int i=0;i<result.size();i=i+11){		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0){
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else{
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			ArrayList complete_reason_codes = (ArrayList)bean.getCompleteReasonCodes();

			String disp_delivery_chk_box			=   "checked";
			String disp_delivery_chk_box_val		=   "Y";
			String disp_delivery_chk_box_disabled	=   "";
			String  billing_interface_yn			=   bean.getBLInterfaceYN();//checkforbillinginterface();
			String width							=   "100%";
			String bl_encounter_id					=   bean_1.getEncounterID();
			String bl_display                       =   "Y"; 
			String ord_type						    =	bean_1.getOrderType();
			String sysdate							=   bean_1.getTodaysDate();
			String disp_locn_code			        =   bean_1.getDispLocnCode();
			float tot_gross_charge_amount			=   0;
			float tot_groos_pat_payable				=   0; 
			String tot_gross_charge_amount_str		=  "";
			String tot_groos_pat_payable_str		=  "";
			String gross_charge_amount_str			=  "";
			String groos_pat_payable_str			=  "";
			String decimalFormatString				=  "";
			String	batch_str						=  "";
			String image_path					    =  "";
			String trade_code					    =  "";
		//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String dischargeIND		=	"";	
			String strBMS_Include_yn ="N";// Added for [IN:045295]
		//ends here
		/*=================code for auto defaulting batches for normal RX===============*/
			String min_stk_flag	=	"display:none;align:right";//Added for AMS-CRF-0068.1 [IN:050333] -start
			String min_stk_flag_bkg_clr	=		"background-color:none";
			String rol_flag_bkg_clr		=		"background-color:none";
			String rol_flag			=		"display:none";
			String disp_req_flag	= "display:none;color:blue";
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {alt_drug_code, disp_locn_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end
			boolean bEquivalentNormalOrder		= false;

			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;

			String display_list = "";

			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  ){
				display_list ="display:none" ;
			}

			ArrayList items					=	null;
			ArrayList alloc_drug_detail		=	null;
			HashMap batch_det				=	null;	
			ArrayList stock_det				=	null;
			HashMap	 stock					=	null;	
			String item_code				=	"";
			String store_code				=	"";
			String fill_period				=	null;
			String fill_unit				=	null;
			String item_cost				=   "";
			String issue_qty				=	"";
			String batch_issue_qty				=	""; //MMS-40
			double tmp_unit_qty				=	0;
			double tot_issued_qty			=	0;
			String avail_qty				=	"";
			String act_bms_qty				=	"";
			float opdispperiod				=	0;	
			String alloc_readonly			=   "";
			boolean item_uom_definition_flag = false;
			String billable_item_yn			=	"";
			//String  taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;
			String show_remarks, taper_disable; //Added for RUT-CRF-0088 [IN036978]
			LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]

			if(ord_type.equals("CO")||ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")){
				bl_display      =   "N";        
			}
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				width			=   "115%"; 
				patient_class   =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
			}
			String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551] 
			String barcodeScan = ""; // Added for GHL-CRF-0463 - Start
			String last_scanned   ="";
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN(); 
			   last_scanned = bean_1.getScannedBarcode_id();
			}// Added for GHL-CRF-0463 - End

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(barcodeScan));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(last_scanned));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(width));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(param_legends.get("V")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 		
					if(billing_interface_yn.equals("Y") &&bl_display.equals("Y")){

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

					}      
					if(delivery_reqd.equals("Y")) { 

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param_legends.get("D")));
            _bw.write(_wl_block24Bytes, _wl_block24);

					}

					allocate_button = "<td class= 'COLUMNHEADER' width='10%' style='font-size:9' align='center'>"+param_legends.get("A")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>";
					filling_button	="<td class= 'COLUMNHEADER' width='8%' style='font-size:9' align='center'>"+param_legends.get("F")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>";

					if(display_seq.equals("A")) { 
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
						if(filling_reqd.equals("Y")) 
							out.println(filling_button);
					} 
					else	{ 
						if(filling_reqd.equals("Y"))  
							out.println(filling_button);
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
					}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(legend));
            _bw.write(_wl_block26Bytes, _wl_block26);

				String sRepeatFreqCode		   = null;
				String sFreqCode			   = null;
				boolean bPRNOrAbsOrder		   = false;
				boolean bDrugOrder			   = true;
				String disable_alloc_text_box  =  "";
				String iv_prep_yn  =  "";

				Set stDrugCodes				= new HashSet();
				for(int i=0;i<orderLineDtls.size(); i++){
					bDrugOrder			= true;
					sRepeatFreqCode		= "";
					sFreqCode			= "";
					if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
					else
					classvalue = "QRYEVEN" ;

					hold_value			=	"";
					title_remarks		=	"";
					hold_status			=	"";
					pres_strength		=	"";
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					alloc_strength		=	"";
					tmp_alloc			=	0;
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";

					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id			=	(String)orderLineDtls.get(i);
						//ordered_by	=	(String)orderLineDtls.get(++i);
						++i;
						//location		=	(String)orderLineDtls.get(++i);
						++i;
						++i;
					}

					allergy					=	(String)orderLineDtls.get(i);
					exceed_dose				=	(String)orderLineDtls.get(++i);
					++i;
					drug_code				=	(String)orderLineDtls.get(++i);
					drug_name				=	(String)orderLineDtls.get(++i);
					dosage_dtls				=	(String)orderLineDtls.get(++i);
					++i;
					end_date				=	(String)orderLineDtls.get(++i);
					pres_qty				=	(String)orderLineDtls.get(++i);
					qty_uom					=	(String)orderLineDtls.get(++i);
					qty_uom_disp			=	(String)orderLineDtls.get(++i);
					order_line_no			=	(String)orderLineDtls.get(++i);
					generic_id				=	(String)orderLineDtls.get(++i);

					if(generic_id.equals("MEDICALITEM"))
						bDrugOrder			= false;

					generic_name			=	(String)orderLineDtls.get(++i);
					dosage_details			=	(String)orderLineDtls.get(++i);
					bms_qty					=	(String)orderLineDtls.get(++i);
					act_bms_qty				=   bms_qty;
					source_code				=	(String)orderLineDtls.get(++i);
					source_type				=	(String)orderLineDtls.get(++i);
					ordering_facility_id	=	(String)orderLineDtls.get(++i);
					ord_date_time			=	(String)orderLineDtls.get(++i);
					performing_pract_id		=	(String)orderLineDtls.get(++i);
					duplicate_yn			=	(String)orderLineDtls.get(++i);
					min_dose_dtls			=	(String)orderLineDtls.get(++i);
					alloc_qty_from_tmp		=	(String)orderLineDtls.get(++i);
					strength_value			=	(String)orderLineDtls.get(++i);
					strength_uom			=	(String)orderLineDtls.get(++i);
					strength_uom_disp		=	(String)orderLineDtls.get(++i);
					trade_code				=	(String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);

					currentdateplusAllocatePeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();  //Added for ML-BRU-SCF-0905 [IN:041285] -Start
					if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);
					endDateIsbeforAllocatedate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusAllocatePeriod,"DMY",locale);
					if(!endDateIsbeforAllocatedate){
						end_date=currentdateplusAllocatePeriod;
					}//Added for ML-BRU-SCF-0905 [IN:041285]ended
					// For Multi Frequency 

					sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
					sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

					stDrugCodes.add(drug_code); // to Add drug codes for authorization check
					bean.setStockItems(drug_code,stock_opt); //MMS-SCF-417 and BSP-SCF-0041
					if(generic_id.equals("MEDICALITEM")){
						drug_trade_bean.setDrugyesno("");
					}
					else{
						drug_trade_bean.setDrugyesno("Y");
					}
					image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);
					pack_dtls			    =	bean.getPackSize(drug_code);
					main_drug_pack_size = 0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
						}		
					}
					bean.setOrderDetails(order_id+order_line_no,end_date);

					alt_drug				=	bean.checkMultiStrength(drug_code);
					//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);
					bmscount                =   bean.CheckBMSYN(order_id, order_line_no);

					bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
					pres_details			=	bean.getPresDetails(order_id);
					if(order_type.equals("IVI") || order_type.equals("CA"))
						strChangedFludRmks =	bean.getChngdFluidRemarks(order_id,order_line_no);
					else
						strChangedFludRmks =	"";

					if(strChangedFludRmks != "" && strChangedFludRmks != null)
						classvalue = "FLUDCOLOR";
					stock_opt =(ArrayList)bean.getStockItems(drug_code);
					if(module_id.equals("2")&&stock_opt.size()==0) {
						token	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
						while(token.hasMoreTokens()){
							stock_opt.add((String)token.nextToken());
						}
					}
					else{
						++i;
					}

					ext_prod_id=(String)orderLineDtls.get(++i);
					bean.setStockItems(drug_code,stock_opt);

					/*if(!strength_value.equals("0"))
					strength	=	strength_value+" "+strength_uom;*/

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
					}

					//ended...

					// Drug class
					drug_class	=	(((String)orderLineDtls.get(++i)).trim());
					i=i+2;

					expired_yn  = (String)orderLineDtls.get(++i);

					if(expired_yn.equals("Y"))
						classvalue="EXPIRED_MEDICATION";
					drug_verf_reqd_yn = (String)orderLineDtls.get(++i);
					order_line_status = (String)orderLineDtls.get(++i);
					main_strength_per_value_pres_uom = (String)orderLineDtls.get(++i);

					i++;
					String sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
					i++;
					String sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();

					if(sOrderType.equals("P") || sAbsOrder.equals("N"))
						bPRNOrAbsOrder = true;
					else
						bPRNOrAbsOrder = false;

					drug_style        = "cursor:pointer;color:blue";
					String current_order_line_status = order_line_status;//for 61540
					order_line_status ="VF";
					if(!bean_1.getVerfCombinedWithAlloc().equals("C")){
						if(drug_verf_reqd_yn.equals("Y")){
							if(order_line_status.equals("VF")){
								disp_delivery_chk_box_disabled  ="";
								disp_delivery_chk_box_val		="Y";
								disp_delivery_chk_box			="checked";
							}
							else{
								disp_delivery_chk_box_disabled  ="disabled";
								disp_delivery_chk_box_val		="N";
								disp_delivery_chk_box			="";
								drug_style="color:red;FONT-WEIGHT: BOLDER";
							}					
						}
						else{
							disp_delivery_chk_box_disabled  ="";
							disp_delivery_chk_box_val		="Y";
							disp_delivery_chk_box			="checked";
						}
					}
					if(drug_class.equals("C") || drug_class.equals("N")) {
						narc_style	="color:brown";
						//title		= "title='Narcotic/Controlled Drugs'";
						String nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
						title		= "title='"+nar_cnt_drug+"'";
					}

					token	=	new StringTokenizer(dosage_details,":");

					if(token.hasMoreTokens()) {
						exceed_status	=	token.nextToken();
					}
					if(exceed_status.equals("Y")) {
						if(token.hasMoreTokens())
							monograph	=	token.nextToken();
						if(token.hasMoreTokens())
							unit_dose	=	token.nextToken();
						if(token.hasMoreTokens())
							daily_dose	=	token.nextToken();
						if(token.hasMoreTokens())
							dosage_type =token.nextToken();
						if(token.hasMoreTokens())
							dosage_unit =token.nextToken();
						if(token.hasMoreTokens())
							std_dose   =token.nextToken();
					}
					token	=	new StringTokenizer(min_dose_dtls,":");
					if(token.hasMoreTokens()) {
						min_unit_dose	=	token.nextToken();
						min_daily_dose	=	token.nextToken();
					}

					if(bean.checkHold(order_id,order_line_no)) {
						hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
						check_value				="Y";
						check_status			="checked";
						fromdb					="Y";
						remark_status			="visibility:visible";
					} 
					else {
						hm		= bean.loadHoldRemarks(order_id,order_line_no);
						if (!hm.isEmpty()){
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");

							check_value		="Y";
							check_status	="checked";
							fromdb			="Y";
							remark_status	="visibility:visible";
						}
						else{
							hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
							remark_status	="visibility:hidden";
							check_status	="";
						}
					}
					multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
					alt_drug_remarks_disp="";
					if(multi_drugs.size()>0){
						if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){//if block added for  Bru-HIMS-CRF-082 [IN:029948]
							alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
							if(alt_drug_remarks_ind.equals("M"))
								alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
						}
					}
					if(request.getParameter("resetQty")== null)
						qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					else
						qty				= "";
					//				qty			=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					HashMap Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
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
					if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) )
						hold_status	="disabled";

					/*if(verification_reqd.equals("")) {
					hold_status			=	"disabled";
					hold_value			=	"E";
					}*/


					/*-----code for displaying drug remarks---------------*/
					/* drug_remarks	    = "";
					prn_remarks		    = "";
					pharma_remarks	    = "";		
					pres_remarks        = "";
					slidingscaleremarks ="";
					remarks_style       = "";
					dialog_height       = 0;

					pres_remarks		= bean.getPrescriptionInstructions(order_id);
					drug_remarks		= bean.getDrugInstructions(order_id,order_line_no);
					prn_remarks			= bean.getPRNInstructions(order_id,order_line_no);
					pharma_remarks		= bean.getPharmacistInstructions(order_id,order_line_no,"Y");
					slidingscaleremarks	= bean.getSlidingScaleRemarks(order_id,order_line_no);
					verificationremarks	= bean.getVerificationRemarks(order_id,order_line_no);
					HashMap overridereason =(HashMap)bean.getOverrideremarks(order_id,order_line_no);
					String	show_remarks = "N";
					if(drug_db_interface_yn.equals("Y") && overridereason.containsKey("DRUG_DB_PRODUCT_ID")){
					if(overridereason.size()>1){
					show_remarks="Y";
					}			
					}else{
					if(overridereason.size()>0){
					show_remarks="Y";
					}
					}
					*/
					pres_remarks					=   bean.getPrescriptionInstructions(order_id);
					drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
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
					dischargeIND		        =	(String)orderLineDtls.get(++i);//from OR_ORDER
					strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295]
					home_med_yn 					= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
					drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
					disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
					appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);//Added for  Bru-HIMS-CRF-080
					if("Y".equals(appl_for_compounding_rx_yn)){
						disp_mnf_flag = "display:inline;color:blue";
					}
					if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
						disc_cancelled_orders_display="display:inline";
					else
						disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
					/*Commented for RUT-CRF-0088 [IN036978] 
					taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
						taper_disable = "disabled";
						alloc_qty_from_tmp="0"; //added to avoid displaying qty for tapered drugs
					}
					else*/
						taper_disable="";

					show_remarks = "N";
					if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
						if(bean.getFirstTime(order_id).trim().equals("true")) {
							drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
							multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
							main_detail		=	(ArrayList)drug_detail.get("main_detail");
							alt_detail		=	(HashMap)drug_detail.get("alt_detail");
							if(multi_detail.size()==0) {
								bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
								bean.setDrugQuantity(patient_id,order_id,order_line_no,Integer.parseInt(alloc_qty_from_tmp));
							} 
							else if(multi_detail.size()!=0) {
								bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);	
								for(int no=0; no<multi_detail.size(); no+=5) {
									alt_drug_code		=	(String)multi_detail.get(no);
									alt_drug_detail		=	(ArrayList)alt_detail.get(alt_drug_code);
									bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
								}							
							}
							bean.setFirstTime(order_id,false);
						}
					}

					if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("")){
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
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInteractionOverrideReason.label","ph_labels")+" : "+interaction_override_reason.trim()+"\n");	
					if(!contraind_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ContraIndicationOverrideReason.label","ph_labels")+" : "+contraind_override_reason.trim()+"\n");								
					if(!drug_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInstructions.label","ph_labels")+" : "+drug_remarks.trim()+"\n");
					if(!prn_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PRNInstructions.label","ph_labels")+" : "+prn_remarks.trim()+"\n");						
					if(!pharma_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Pharmacist.label","ph_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Instructions.label","common_labels")+" : "+pharma_remarks.trim()+"\n");
					if(!verificationremarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");		//code added for Bru-HIMS-CRF-416[IN045566]-- End
		
					if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&& show_remarks.equals("N")){
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
					}
					/*-------------------------ends------------------------*/	

					tmp_bms_qty				=	bms_qty;
					main_pack_size			=   0;
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
					/*==============code for getting defult batches====================================*/

					items			=  (ArrayList)bean.loadItems(drug_code);
					if(items.size()>0){
						item_code     =   (String)items.get(0);
					}
					store_code	=	bean_1.getStoreCode();

					/*if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);*/
					Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));
					//opdispperiod  =  bean_1.getopdispperiod( disp_locn_code);
					opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());

					// For Multi Frequency
					String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
					String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
					if(sRepeatFreqCode.equals("W")){
						if(sOrigDispUnit.equals("H"))
							opdispperiod = new Float(Math.ceil((opdispperiod/(24*7)))*7); // divide by 24 to make day and divide by 7 to convert to week and ceil it.
						else if(sOrigDispUnit.equals("D"))
							opdispperiod = new Float(Math.ceil((opdispperiod/7))*7);
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

					if(sFreqCode.equals("H"))
						fTotalDuration = fTotalDuration/24;
					else if(sFreqCode.equals("W"))
						fTotalDuration = fTotalDuration*7;
					else if(sFreqCode.equals("L"))
						fTotalDuration = fTotalDuration*30;
					else if(sFreqCode.equals("Y"))
						fTotalDuration = fTotalDuration*365;

					if(bean.checkHold(order_id,order_line_no)|| scope.equals("H")){
						alloc_readonly ="disabled";  
					}
					else{
						alloc_readonly ="";  
					}
					tot_issued_qty  =0;
					/*=============code added to handle if dispense uom and default uom in item store is different and variable UOM==========*/
					IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
					base_to_disp_uom_equl	 =	0;
					base_to_def_uom_equl	 =	1;

					HashMap issue_uom_qty_hm =  bean.getIssueUomQty();

					dflt_issue_uom = "";
					if(issue_uom_qty_hm.size()>0){
						if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
							dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
						}
					}
					if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
						dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");

					base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
					base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);

					orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
					st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937] 
					base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);

					/*=======================ends here=========================================================================================*/
					if(request.getParameter("barcode_id")!=null){ //Added for KDAH-CRF-0231 [IN-034551]
						barcode_id = request.getParameter("barcode_id");
					}

					if(alt_drug_qty.equals("")&& ord_type.equals("NOR") && alloc_readonly.equals("")&& stock_opt.get(0).equals("N") && (!item_code.equals("")) && barcode_id.equals("")){//MMS-SCF-417 and BSP-SCF-0041
						qty = "";
					}
					if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("")&& stock_opt.get(0).equals("Y") && (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551]
						if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){
							tmp_unit_qty    =	0;
							if(bPRNOrAbsOrder){
								tmp_unit_qty = Double.parseDouble(act_bms_qty);
							}
							else{
								fill_period	= bean_1.getFillPeriod();
								fill_unit		= bean_1.getFillUnit();
								item_cost       ="";
								//tot_issued_qty  =0;
								issue_qty       ="";

								float per_day	=Integer.parseInt(pres_qty)/ fTotalDuration;
								//if(per_day < 1)  
								//	     per_day	=	1;

								if(disp_locn_catg.equals("I")){
									if(fill_unit.equals("H") && !fill_period.equals("")) {
										//					tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) / 24 )* per_day).intValue();				
										tmp_unit_qty	=	new Float((opdispperiod / 24 )* per_day).doubleValue();	
									}
									else if(fill_unit.equals("D")) {
										//tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) * per_day)).intValue();
										tmp_unit_qty	=	new Float((opdispperiod * per_day)).doubleValue();
									}
								}
								else{
									if(opdispperiod!=0){
										tmp_unit_qty= new Float(Math.ceil(per_day*opdispperiod)).doubleValue();
									}
									else{
										tmp_unit_qty=new Float(Integer.parseInt(pres_qty)).doubleValue();
									}
								}
								if(tmp_unit_qty > Double.parseDouble(act_bms_qty) ){
									tmp_unit_qty =Double.parseDouble(act_bms_qty);
								}
							}
							/*==========code added to handle if dispense uom and default uom in item store is different=================*/
							 if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // condition Added for [IN:064158] - Start
								  tmp_unit_qty=0;  
							  } // condition Added for [IN:064158] -End

							issue_qty_val			 =  0;
							if(base_to_disp_uom_equl!=base_to_def_uom_equl){
								conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
								//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); //moved from common to  specific  MMS-SCF-0040 [IN:041888] // commented for IN:6585
								issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888] 
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
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Moved from common to specific for  MMS-SCF-0040 [IN:041888]
							}                   

							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Commented for  MMS-SCF-0040 [IN:041888]
							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+"");//Commented for  MMS-SCF-0040 [IN:041888]
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+"");

							//item_cost				=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
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
							params.put("INCLUDE_EXPIRED","FALSE");
							params.put("CUT_OFF_DATE",end_date);
							params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
							params.put("ALREADY_USED_QTY","");
							params.put("MIN_EXP_DATE",end_date);
							stock				= (HashMap)bean_2.getBatches(params);
							if(stock.size()>0){
								stock_det           = (ArrayList)stock.get("BATCH_DATA");
								if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ // Added for KAUH-SCF-0094 [IN:035252] -- begin When Trade and Stock is blank, Alternate trade should be taken 
									bean_st.setIncludeSuspendedBatches("N") ;
									bean_st.setIncludeZeroStockBatches("N") ;
									bean_st.setIncludeExpiredBatches("N") ;
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
									bean_st.loadResultPage("","","");
									bean_st.setModuleId("PH") ; //Added for KDAH-SCF-0243 [IN:049577]
									listRecord			=		bean_st.getDataList();
									if(listRecord!=null && listRecord.size()>0){
										trade_code=((HashMap)listRecord.get(0)).get("TRADE_NAME").toString();
										params.remove("ITEM_CODE");
										params.put("ITEM_CODE",item_code+"="+trade_code);
										//params.put("ITEM_CODE",item_code);
										stock				= (HashMap)bean_2.getBatches(params);
										stock_det           = listRecord;
									}
								}
								// Added for KAUH-SCF-0094 [IN:035252] -- end
								//code for setting batch details in bean
								alloc_drug_detail	=	new ArrayList();
								tmp_unit_qty =issue_qty_val; //Added for  MMS-SCF-0040 [IN:041888]
								//if(!stock.containsKey("EXCEPTION")){//if condition added for ML-BRU-SCF-0905 [IN:041285]- Ganga //Commented for TTM-SCF-0096 [IN:048808]
									for (int j=0;j<stock_det.size();j++){
										batch_det =(HashMap)stock_det.get(j);
										avail_qty			= (String)batch_det.get("AVAIL_QTY");
										if(Double.parseDouble(avail_qty) < 1.0)
											continue;

										alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
										alloc_drug_detail.add(batch_det.get("BATCH_ID"));
										alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));

										/*if(qty_uom!=base_uom){   //added for SKR-SCF-0377 [IN:030453] - start
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
										}*/// Commented MMS-SCF-0040 [IN:041888] 
										item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
										/*if(qty_uom!=base_uom){ //Commented for  MMS-SCF-0040 [IN:041888]
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											avail_qty  =   retunFormatedInt(Math.floor(Double.parseDouble(avail_qty)/base_to_disp_uom_equl)+""); 
										}
										else{
											avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										}*/ //Added for SKR-SCF-0377 [IN:030453] - end
										avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										if(tmp_unit_qty>Double.parseDouble(avail_qty)){
											tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
											issue_qty =avail_qty;
										}
										else{
											issue_qty =tmp_unit_qty+"";    
										}
										batch_issue_qty =  (String)batch_det.get("QTY"); //Added for  MMS-SCF-0040 [IN:041888]
										tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
									
										if(base_to_disp_uom_equl!=base_to_def_uom_equl){					  
											// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
											//int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Double.parseDouble(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  //Added for  MMS-SCF-0040 [IN:041888]
											//issue_qty = alloc_qty+""; //Commented for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(issue_qty); //moved from common to specific for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(qty_uom);
										} 
										else{ //else block added for  MMS-SCF-0040 [IN:041888]
											if(!qty_uom.equals(base_uom)){
												alloc_drug_detail.add(issue_qty);
												alloc_drug_detail.add(qty_uom);
											}
											else{
												alloc_drug_detail.add(batch_issue_qty);
												alloc_drug_detail.add(base_uom);
											}
										}
									
										//alloc_drug_detail.add(issue_qty);
										//alloc_drug_detail.add(base_uom);
										//alloc_drug_detail.add(qty_uom);
										alloc_drug_detail.add("");
										alloc_drug_detail.add(batch_det.get("TRADE_ID"));
										alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
										alloc_drug_detail.add(item_cost);
										alloc_drug_detail.add(base_uom);  //Added for for  MMS-SCF-0040 [IN:041888]
									}
								/*}
								else{//added ElseCondition by Ganga for ML-BRU-SCF-0905 [IN:041285]	
									alloc_readonly ="disabled";
								}*///Commented for  TTM-SCF-0096 [IN:048808]
									hold_status	="disabled";
									/*==========code added to handle if dispense uom and default uom in item store is different=================*/
									/*if(base_to_disp_uom_equl!=base_to_def_uom_equl){ //Commeted for  MMS-SCF-0040 [IN:041888]

										// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((tot_issued_qty*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
										int  alloc_qty = new Float(Math.ceil(((Math.ceil((Double.parseDouble((tot_issued_qty*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
										tot_issued_qty = alloc_qty;
									} */
									if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
										tot_issued_qty=0;
									} // Added for [IN:064158] - End
									if(!qty_uom.equals(base_uom)){ //if & else block added for  MMS-SCF-0040 [IN:041888]
										conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
										tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
									}
									else{
										tot_issued_qty			= Math.floor(tot_issued_qty);
									} //Added for SKR-SCF-0377 [IN:030453] - end
									bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);
								}	
							}
							else{
								if(!item_uom_definition_flag){
								item_uom_definition_flag=true;
							}
							alloc_readonly ="disabled"; 
						}
					}
					/*==========code added to handle if dispense uom and default uom in item store is different=================*/
					IssueUomQty		= (HashMap)bean.getIssueUomQty();
					issue_qty_dtl   =  new StringBuffer();
					if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
						issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
						issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
						issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
						issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl");

						if(bean_1.getIssueByUOM().equals("I")){ 
							issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
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
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_min_stk_level)){
								min_stk = true;
								if(getReq_allowed_yn)
									disp_req_flag =  "display:inline;color:blue";
								else
									disp_req_flag = "display:none";
							}
						}
						if(!frm_store_reorder_level.equals("0")){
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_reorder_level)){
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
								rol_flag_bkg_clr = "style='background-color:none'";
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

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf("RECORD"+(recCount-1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf("RECORD"+(recCount-1)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
							if(allergy.equals("")) { 

            _bw.write(_wl_block31Bytes, _wl_block31);
	
							}
							else{ 

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
							}	
							if(exceed_dose.equals("")) {

            _bw.write(_wl_block31Bytes, _wl_block31);
 
							}
							else{	

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(monograph)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(std_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
							}	
							if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) { 

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
							}	
							else{	

            _bw.write(_wl_block31Bytes, _wl_block31);
	
							}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block40Bytes, _wl_block40);
 
					if (hold_status.equals("disabled")){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_alloc_text_box));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(check_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(check_status));
            _bw.write(_wl_block51Bytes, _wl_block51);

					}	
					else{

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_alloc_text_box));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(hold_text));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(check_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(check_status));
            _bw.write(_wl_block51Bytes, _wl_block51);

					}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(stock_opt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(fromdb));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(hold_status));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(drug_style));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean_1.getDispLocnCode()));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(current_order_line_status));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block76Bytes, _wl_block76);

						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978] 		
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());	
						if(count>1){
							String taper = bean.getTapervalue();
							if(taper.equals("UP")){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

							}
							else if(taper.equals("DOWN")){

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
 
							}
							else{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

							}
							if(totalTaperQtyDisplay.equals("Y")){ //Added for RUT-CRF-0088 [IN036978]

            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf((int)tot_tap));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block87Bytes, _wl_block87);
				
							}
						}
						if(bmscount==0){
							if(pat_couns_reqd_yn.equals("Y")){
								pat_reqd="Checked"; 

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block90Bytes, _wl_block90);

					}
					if(pat_couns_reqd_yn.equals("C")){
						pat_reqd="Checked";	

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block92Bytes, _wl_block92);

					} 
					if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
						pat_reqd="Unchecked";	
						//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
						if(pt_couns_reqd_yn.equals("Y")){

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block94Bytes, _wl_block94);

						}
					}
				}
				String drug_name_1=  drug_name;   
							
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1);
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}

				if ((ext_prod_id!=null)&& !(ext_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block96Bytes, _wl_block96);

				}
				if ((image_path!=null)&& !(image_path.equals(""))){

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
  
				}
				if(adr_count>0){

            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block100Bytes, _wl_block100);

				}
				if(bDrugOrder){

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block108Bytes, _wl_block108);

					// if((bean_1.getDispLocnCatg()).equals("I")) {
					 disp_info	=	bean.getLastDispense(order_id,order_line_no);
					 if(disp_info.size() > 0) {				

						if( ((String)disp_info.get(1)).equals("Y")) {
							dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
						}
						dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
					}
					//}	

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dosage_dtls));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block112Bytes, _wl_block112);
 
				}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(min_stk_flag_bkg_clr));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rol_flag_bkg_clr));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(disp_req_flag));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(disp_mnf_flag));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

				int	k	=	0;
				alt_qty	=	new ArrayList();
				for(int n=0; n<multi_drugs.size(); n+=5)	{ 
					alt_drug_code		=	(String)multi_drugs.get(n);
					alt_drug_desc		=	(String)multi_drugs.get(n+1);
					altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					form_code			=	(String)multi_drugs.get(n+2);
					alt_strength_value	=	(String)multi_drugs.get(n+3);
					//alt_strength_uom	=	(String)multi_drugs.get(n+4);
					alt_drug_desc_1	=    alt_drug_desc;
					if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
						alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
						alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8"); //Passed UTF-8 to alt_drug_desc_1 for the incident 25007==By Sandhya
						alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
					}
				
					drug_color			=	(String)colors.get(k++);
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

					qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 

					if(!qty.equals("") && !qty.equals("0")) {
						alt_qty.add(alt_drug_code);
						alt_qty.add(qty);
						alt_qty.add(form_code);
						alt_qty.add(alt_strength_value);
					}
					if(Min_Rol_yn ){ ///Added AMS-CRF-0068.1 [IN:050333] start
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
								if ( Double.parseDouble(qty)  <  Double.parseDouble(frm_store_min_stk_level)){
									min_stk = true;
									if(getReq_allowed_yn)
										disp_req_flag =  "display:inline;color:blue";
									else
										disp_req_flag = "display:none";
								}
							}
							if(!frm_store_reorder_level.equals("0")){
								if ( Double.parseDouble(qty)   <  Double.parseDouble(frm_store_reorder_level)){
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
							
							if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn)){
								disp_req_flag = "display:inline;color:blue";
							}
							else{
								disp_req_flag  = "display:none;color:blue";
							}
						}
						else{
							rol_flag   =	"display:none";
							min_stk_flag=	"display:inline";
							disp_req_flag  = "display:none";	
							min_stk_flag=	"display:none";
						}
					}//Added AMS-CRF-0068.1 [IN:050333] end

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(n));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block132Bytes, _wl_block132);

					if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(alt_external_prod_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_drug_desc_1));
            _bw.write(_wl_block134Bytes, _wl_block134);

					} 
                    adr_count = bean.getADRCount(patient_id,alt_drug_code);
					if(adr_count>0){

            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block100Bytes, _wl_block100);

					}

            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(min_stk_flag_bkg_clr));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(rol_flag_bkg_clr));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(disp_req_flag));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

				}	
				drug_name_1=  drug_name;   
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(strDrugsRemarks));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(pres_details));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(narc_style));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(retunFormatedInt(pres_qty)));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block156Bytes, _wl_block156);

				if(!strength_value.equals("") && !strength_value.equals("0"))
					pres_strength	=	retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))/(Float.parseFloat(main_strength_per_value_pres_uom)))*(main_drug_pack_size))+"")+" "+strength_uom;

            _bw.write(_wl_block157Bytes, _wl_block157);
 
					if(multi_drugs.size()>1 ) { 

            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(pres_strength));
            _bw.write(_wl_block159Bytes, _wl_block159);
	
					}

            _bw.write(_wl_block160Bytes, _wl_block160);
 			
					if(multi_drugs.size() > 1 ) {	

						if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);

						}

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block165Bytes, _wl_block165);
 
						int x	=	0;
						int tmp_recCount	=	recCount;
						String alternate_drug	=	"";
						float pack_size	=	1;
						float strength_per_value	=	1.0f;

						for(int l=0; l<alt_qty.size(); l+=4) { 
							alternate_drug			=	(String)alt_qty.get(l);	
							qty					=	(String)alt_qty.get(l+1);	
							uom					=	(String)alt_qty.get(l+2);	
							alt_strength_value	=	(String)alt_qty.get(l+3);	
							drug_color			=	(String)colors.get(x++);

							pack_dtls				=	bean.getPackSize(alternate_drug);

							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
									strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
								}		
							}

							tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();

							alloc_strength	=	retunFormatedInt(tmp_alloc+"")+""+strength_uom;
							//pres_qty		=	bms_qty;
							float prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/(Float.parseFloat(main_strength_per_value_pres_uom));
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

							if(qty.equals("") || qty.equals("0")) 
								uom="";	
							else {
								//uom=qty_uom;
								tot_qty		+=	Integer.parseInt(qty);
								//uom			=	"("+uom+")";  // Commented and brackets added below for ML-BRU-SCF-0866 IN040255								
							}

							issue_qty_dtl =new StringBuffer();/*code added to handle if dispense uom and default uom in item store is different==Start*/
							if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")){
								issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
								issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
								issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
								issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
								if(bean_1.getIssueByUOM().equals("I")){
									issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
								}
							}/*code added to handle if dispense uom and default uom in item store is different==End*/

            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf("("+bean.getUomDisplay(facility_id,uom)+")"));
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_equl));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block185Bytes, _wl_block185);

							tmp_recCount++;
							hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
							hsh_med_plan.put("qty",qty);
							if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
								if(!alt_qty.contains(drug_code)){
									medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
									medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
								}
								arrOrderId.add(order_id+"_"+order_line_no);
								dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
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
								hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
								hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
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
						/*if(!alt_strength_value.equals("")) {
							alloc_strength	=	Integer.parseInt(alt_strength_value) * tot_qty+"";
							alloc_strength	=	(Integer.parseInt(alloc_strength)==0)?"":alloc_strength+" "+strength_uom;
						}*/

            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(alloc_strength));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

					}
					else{	
						if(qty.equals("") || qty.equals("0")) {
							qty	=	"";
							uom	=	"";	
						}
						else {
							if(!strength_value.equals("") && !strength_value.equals("0"))
								alloc_strength	=	Float.parseFloat(strength_value) * Float.parseFloat(qty)+"";
							//uom="("+qty_uom+")";
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
						}*/ //Commented for ML-BRU-SCF-1015 [IN:04335
						/*Commented for RUT-CRF-0088 [IN036978] 
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty for tapered drugs
							qty = "0";
							bms_qty = "0";
						}*/

            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id+order_line_no+drug_code+"_uom"));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block195Bytes, _wl_block195);
 
					String stk_unit_code	= "";
					String stk_unit_desc	= "";
					String stk_equval_value	= "";
					String act_stk_equval_value	= "";
					
					stk_units				= bean.loadStockUnit(drug_code);
					String base_to_def_uom_equl_val  ="1";
					String base_to_disp_uom_equl_val ="1";

					for(int iStkCountt=0; iStkCountt<stk_units.size();iStkCountt+=4) { 
						stk_unit_code		=	(String)stk_units.get(iStkCountt);
						stk_unit_desc		=	(String)stk_units.get(iStkCountt+1);
						stk_equval_value	=	(String)stk_units.get(iStkCountt+2);
						act_stk_equval_value	=	(String)stk_units.get(iStkCountt+3);

						if(dflt_issue_uom.equals(stk_unit_code)){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block199Bytes, _wl_block199);

						}
						else{

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block199Bytes, _wl_block199);

						}	
					}

					// For Allowing more quantity than order quantity dispense based on drug setup
					HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();

					if(hmAllowMoreQty == null)
						hmAllowMoreQty = new HashMap();

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(hmAllowMoreQty.get(drug_code)));
            _bw.write(_wl_block195Bytes, _wl_block195);

					if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
						if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))){ // Added for [IN:064158] - Start
                 		                  if(qty.equals("0.0") || qty.equals("") || qty.equals("0"))
                 			            qty = "0.0"; // "" modified to "0.0" for GHL-CRF-0463 
						} // Added for [IN:064158] - End
						if(stock_opt.get(0).equals("Y")&& disp_delivery_chk_box_val.equals("Y")){
							if(in_formulary_yn.equals("Y")){

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(  retunFormatedInt(qty)));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(act_bms_qty));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block209Bytes, _wl_block209);

								if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for KDAH-CRF-0231 [IN-034551] 

            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
					    
								}
							}
							else{

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block214Bytes, _wl_block214);

							}

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(act_bms_qty));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_equl));
            _bw.write(_wl_block195Bytes, _wl_block195);

						}
						else{
							if(in_formulary_yn.equals("Y")){//Added for MO-GN-5434 [IN:043669]

            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block51Bytes, _wl_block51);

							}else{//Added for MO-GN-5434 [IN:043669]

            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(alloc_readonly));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block230Bytes, _wl_block230);

							}//Added for MO-GN-5434 [IN:043669]

            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);

						}
					}
					else{

            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(retunFormatedInt(qty)));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_qty_value));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_desc));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(issue_uom_equl));
            _bw.write(_wl_block195Bytes, _wl_block195);

					}
				}	
		  
				if(multi_drugs.size() > 1 ) {
					/*if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
						if(tot_qty > 0)
							bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
						else 
							bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
					} else {
							if(!qty.equals("") && !qty.equals("0")){
								bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
							}
						}*/
				}
				else {
					if(!qty.equals("") && !qty.equals("0")){
						if(!bean_1.getBarcode_multi_id().equals("Y"))
							bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
					}
				}
						
				if(!strength_value.equals("") && !alt_strength_value.equals("")) {
					if(bms_strength.equals(""))
					bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";
					//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";
				}
				else if(!strength_value.equals("") && !strength_value.equals("0")) {
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
				if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
					bms_strength="";
					strength_uom="";
				}
				if(Float.parseFloat(bms_qty)<0){
					bms_qty ="0";
				}
				hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
				hsh_med_plan.put("qty",qty);
				if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
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
					hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
					hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
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


            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(retunFormatedInt(bms_qty)));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(retunFormatedInt(bms_qty)));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block258Bytes, _wl_block258);

				String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
				//for billing interface coding starts
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
					if(in_formulary_yn.equals("Y")){ 

						float gross_charge_amount =0;
						float groos_pat_payable   =0;
						//float net_amount          =0;

						disp_delivery_chk_box     = "checked";
						disp_delivery_chk_box_val = "Y";
						disp_delivery_chk_box_disabled= "";

						gross_charge_amount_str	  =  "";
						groos_pat_payable_str	  =  "";
						 batch_str				  =  "";

						StringBuffer gross_charge_display_str  = new StringBuffer();
						StringBuffer pat_charge_display_str    = new StringBuffer();
						StringBuffer inc_exec_display_str      = new StringBuffer();
						if(!qty.equals("") && billable_item_yn.equals("Y")){
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
							HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator
							if(billing_det.containsKey(drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
								if(chareg_det.get("error_msg").equals("")){
									decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){
										 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/
									if(!chareg_det.get("patnetamt").equals("null")){
										 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									} //Commented added ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}

									batch_str                =(String)chareg_det.get("BATCH_STRING");
									gross_charge_amount_str  = dfTest.format(gross_charge_amount);
									groos_pat_payable_str    = dfTest.format(groos_pat_payable);

									gross_charge_display_str.append("<label style='font-size:9;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

									pat_charge_display_str.append("<label style='font-size:9;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	

									inc_exec_display_str.append("<a  style ='font-size:9' href=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
								
									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;	

            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(strModDrugCode));
            _bw.write(_wl_block278Bytes, _wl_block278);
 
								}
								else{                                        
									gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									disp_delivery_chk_box="";
									disp_delivery_chk_box_val="N";
									disp_delivery_chk_box_disabled="disabled";
											
								}
							}
						}
					}
					if(multi_drugs.size()>1){
						int  added_yn =0;
						int  x		=0;
						String sModAltDrugCode = "";
						HashMap billing_det = null;
						for(int n=0; n<multi_drugs.size(); n+=5)	{							    
							alt_drug_code	     =	(String)multi_drugs.get(n);
							sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
							drug_color			 =	(String)colors.get(x++);
							billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator);
							if(billing_det.containsKey(alt_drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
								if(chareg_det.get("error_msg").equals("")){

									batch_str =(String)chareg_det.get("BATCH_STRING");
									decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){ 
										gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/ //commented for  ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("patnetamt").equals("null")){ 
										groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									}
									 if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}
							   
									gross_charge_amount_str = dfTest.format(gross_charge_amount);
									groos_pat_payable_str   = dfTest.format(groos_pat_payable);
									   
									gross_charge_display_str.append("<label style='font-size:9;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");

									pat_charge_display_str.append("<label style='font-size:9;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");

								   inc_exec_display_str.append("<label style='cursor:pointer;font-size:9;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");

									added_yn++;

									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;

            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(order_id));
            out.print( String.valueOf(order_line_no));
            out.print( String.valueOf(sModAltDrugCode));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block195Bytes, _wl_block195);
 
									}
									else{
										  gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
								          pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
										  disp_delivery_chk_box    ="";
								          disp_delivery_chk_box_val="N";
										  disp_delivery_chk_box_disabled="disabled";
									   }
								  }							  
						}
						/*if(added_yn>0){
							//gross_charge_display_str.append("</label>");
							//pat_charge_display_str.append("</label>");
						}*/
				}		
			
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(pat_charge_display_str.toString()));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(gross_charge_display_str.toString()));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(inc_exec_display_str.toString()));
            _bw.write(_wl_block291Bytes, _wl_block291);
 
			}
			else{

            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block294Bytes, _wl_block294);

			   }			
			//billing interface coding ends here
			} 

            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disp_delivery_chk_box_val));
            _bw.write(_wl_block297Bytes, _wl_block297);

		if(delivery_reqd.equals("Y")) { 
			if(delivery_det!=null && delivery_det.size() > 1) {
				//Ifcondition added and the block moved from below "if(!order_type.equals("TD") && !order_type.equals("TA")){" for SRR20056-SCF-7289
		    if(!ord_type.equals("IVAA")&& !ord_type.equals("IVIA")&& !ord_type.equals("CA")&& !ord_type.equals("TA")&&!ord_type.equals("TD")&& !ord_type.equals("CO")){
				hmEditLabelValues = new HashMap();	
				hmEditLabelValues.put("order_id",order_id);
				hmEditLabelValues.put("pres_drug_code",drug_code);
				if( (multi_drugs.size()!=0)){//added if condition for alternate drugs in edit label ML-BRU-SCF-1528 [IN:053217]
					hmEditLabelValues.put("drug_code",alt_drug_code);
					hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
					hmEditLabelValues.put("alt_drug_flag","Y");
				}
				else
					hmEditLabelValues.put("drug_code",drug_code);
				hmEditLabelValues.put("order_line_no",order_line_no);
				hmEditLabelValues.put("ord_date_time",ord_date_time);
				hmEditLabelValues.put("drug_name_1",drug_name);
				hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
				hmEditLabelValues.put("pres_qty",pres_qty);
				hmEditLabelValues.put("uom",uom);
				if(multi_drugs.size()>1)//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -start
					hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+""); 
				else
					hmEditLabelValues.put("alt_drug_count", "0"); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -end
				alEditLabelPair.add(hmEditLabelValues);
				bean.setSPerformPractId(performing_pract_id);
			}
			strAllocBMSChkValue  = "";
			strAllocBMSChecked	 = "";
			showZeroQtyCheckBox="";
			showOtherEditLables ="";
		    
			if((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") || qty.equals("0") )) ){//Added for MO-GN-5434 [IN:043669] start //(qty ==null || qty.equals("0")) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211] //Added || (Double.parseDouble(qty)==0 && strIncludeZeroQty.equals("Y")) for [IN:045700]
				showZeroQtyCheckBox ="";
				showOtherEditLables ="display:none";
				if(includeBMSDefCheck_yn.equals("Y") && strBMS_Include_yn.equals("Y")){ //if condition added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) //Added && strBMS_Include_yn.equals("Y") for [IN:045700]
					strAllocBMSChkValue  = "Y";
					strAllocBMSChecked	 = "checked";
				}
			}
			else{
				showZeroQtyCheckBox="display:none";
				showOtherEditLables ="";
			}
			//Added for MO-GN-5434 [IN:043669] end
			if(!qty.equals("") ){

            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block299Bytes, _wl_block299);

				//if(strIncludeZeroQty.equals("Y")){//Added for MO-GN-5434 [IN:043669] start Commented for [IN:045700]

            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(showZeroQtyCheckBox));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strAllocBMSChkValue));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(strAllocBMSChecked));
            _bw.write(_wl_block305Bytes, _wl_block305);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block306Bytes, _wl_block306);

				//} Commented for [IN:045700]

            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(showOtherEditLables));
            _bw.write(_wl_block308Bytes, _wl_block308);
//Added for MO-GN-5434 [IN:043669] end
					if(!order_type.equals("TD") && !order_type.equals("TA")){

            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

					}

            _bw.write(_wl_block312Bytes, _wl_block312);
	
					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:visible' checked value='Y' onClick='updateValue(this)'>"; 
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(disp_delivery_chk_box));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_delivery_chk_box_disabled));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(disp_delivery_chk_box_val));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(del_style));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block322Bytes, _wl_block322);

				}		
				else{

            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block299Bytes, _wl_block299);

					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(del_style));
            _bw.write(_wl_block324Bytes, _wl_block324);

				}
			}
			else{

            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(title));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strChangedFludRmks));
            _bw.write(_wl_block299Bytes, _wl_block299);

				del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 

            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(del_style));
            _bw.write(_wl_block324Bytes, _wl_block324);

			}
		}	

	        bms_strength="";
			strength_uom="";
			
					if(!scope.equals("H") && scope!=null){	
						if(bms_qty.equals("") || Double.parseDouble(bms_qty)==0){  // bms_qty.equals("0.0") ) changed to bms_qty.equals("") || Double.parseDouble(bms_qty)==0 for KAUH-SCF-0096 [IN:035355]
							disable_complete_order	=	"disabled";
					   }
					   else{
							disable_complete_order	=	"";
					   }
					}
					
					
					/*if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
						image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
					}
					else {
						image		=	"";
					}*/
				
					alloc_empty_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='alloc_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value=''></td>";
					
					if(!qty.equals("") && bean.getFilling(patient_id,order_id,order_line_no)) {
						alloc_det	=	"<td class="+classvalue+" width='10%' align='center'>&nbsp;<img src='../../eCommon/images/enabled.gif'><label id='alloc_detail"+recCount+"' style='visibility:hidden'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Det.label","ph_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";

					}
					else {
					 
						alloc_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='alloc_detail"+recCount+"' onClick='callAllocate(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"A\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";
					}

					filling_empty_det	="<td class="+classvalue+" width='8%'>&nbsp;<label id='fill_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value=''></td>";
					
					filling_det			="<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='fill_detail"+recCount+"' onClick='callFilling(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"F\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value='P'></td>";


					if(display_seq.equals("A")) {  
						if(allocation_reqd.equals("Y")) {
						  if(qty.equals("") && alt_qty.size() < 1) 	
							out.println(alloc_empty_det);
						  else	
							out.println(alloc_det);
						}

						if(filling_reqd.equals("Y")) { 
							if(qty.equals("") && alt_qty.size() < 1)
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) && bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						}	
					}
					else{	
						if(filling_reqd.equals("Y")) { 
							if(qty.equals(""))
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) &&  bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						} 
					 
						if(allocation_reqd.equals("Y")) {
							if(qty.equals("") && alt_qty.size() < 1) {	
								out.println(alloc_empty_det);
							}
							else{	
								out.println(alloc_det);
							}	
						}
					}

            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block195Bytes, _wl_block195);

					if(disp_level.equals("P")) {	

            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block195Bytes, _wl_block195);
	
					}	
					if(scope.equals("H")){
						legend1=bean_1.getresultlinestatus(order_id,order_line_no);
				 
						if(legend1==null)
							legend1="";
						if(legend1.equals("OS"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
						else if(legend1.equals("DP"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
						else if(legend1.equals("RG"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
						else if(legend1.equals("AL"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
					
						visibility1="visibility:visible";
						visibility2="visibility:hidden";
					}
					else{
						if(hold_text.equals("On Hold")){
							disable_complete_order	=	"disabled"; 
						}
						visibility1="visibility:hidden";
						visibility2="visibility:visible";
					}

            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(visibility1));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(legend_text));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(disable_complete_order));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(visibility2));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(disable_complete_order));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_alloc_text_box));
            _bw.write(_wl_block344Bytes, _wl_block344);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block345Bytes, _wl_block345);

				       for(int m=0; m<complete_reason_codes.size(); m=m+2){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(complete_reason_codes.get(m)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(complete_reason_codes.get(m+1)));
            _bw.write(_wl_block199Bytes, _wl_block199);

					   }

            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dischargeIND));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(st_allow_decimals_yn));
            _bw.write(_wl_block356Bytes, _wl_block356);
            _bw.write(_wl_block357Bytes, _wl_block357);

				if(multi_drugs!= null && multi_drugs.size()>0 && alt_drug_code!= null && !alt_drug_code.trim().equals("")){
					stDrugCodes.remove(drug_code);
					stDrugCodes.add(alt_drug_code);
				}
				recCount++;
			}

			if(stDrugCodes.size()>0){
				sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
			}    

            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(bean_id_1));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(bean_name_1));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(filling_status));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(del_data));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(performing_pract_id));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(curr_stage));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(bean_1.getIssueByUOM()));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(bEquivalentNormalOrder));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(bean_1.getSFunctionId()));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(delivery_reqd));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(strIncludeZeroQty));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(pres_qty_alert));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(includeBMSDefCheck_yn));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(strAutoCompletePartialDisp));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(st_no_of_decimals));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(st_disp_decimal_dtls_yn));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(allow_amend_alt_drug_dtl));
            _bw.write(_wl_block396Bytes, _wl_block396);

			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){

            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(bl_encounter_id));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(tot_gross_charge_amount));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(tot_groos_pat_payable));
            _bw.write(_wl_block195Bytes, _wl_block195);

			}

            _bw.write(_wl_block402Bytes, _wl_block402);

		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
		}

		if(item_uom_definition_flag){
            _bw.write(_wl_block403Bytes, _wl_block403);

		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block404Bytes, _wl_block404);
 
		if(allocation_reqd.equals("Y") && filling_reqd.equals("Y"))  { 

            _bw.write(_wl_block405Bytes, _wl_block405);

		}
		else if(allocation_reqd.equals("Y") && delivery_reqd.equals("Y")) { 

            _bw.write(_wl_block406Bytes, _wl_block406);
	
		}
		else if(filling_reqd.equals("Y") && delivery_reqd.equals("Y") ) { 

            _bw.write(_wl_block407Bytes, _wl_block407);
	
		}

            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sDispDrugAuthYN));
            _bw.write(_wl_block411Bytes, _wl_block411);

	bean.clearAlEditLabelPairValues();
	bean.setAlEditLabelPairValues(alEditLabelPair);
	medplan_bean.setMedOrderIds(arrOrderId);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(medplan_bean_id,medplan_bean,request);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
	putObjectInBean(bean_id_2,bean_2,request);
	putObjectInBean(bean_id_st,bean_st,request); // Added for KAUH-SCF-0094 [IN:035252] 

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/DosageDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ISSUEUOM.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQuantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TaperDose.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MINLEVEL.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ROL.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CreateRequest.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Manufacturing.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MINLEVEL.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ROL.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CreateRequest.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Trades.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.INCLUDE_IN_BMS.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Findings.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}

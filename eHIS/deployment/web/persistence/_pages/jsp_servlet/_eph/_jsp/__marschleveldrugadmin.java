package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __marschleveldrugadmin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MARSchLevelDrugAdmin.jsp", 1740542420244L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" <!-- java.sql.*,webbeans.eCommon.* Added for AAKH-CRF-0084 [IN060429] -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t<head>\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n\t\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t\t</head>\n\t\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"MedicationAdministrationFTDrugDetails\" id=\"MedicationAdministrationFTDrugDetails\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"non_iv_administration_table\">\n\t\t\t\t\t\t\t<tr id=\"non_iv_admin_table_row2\">\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"28%\"><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"4%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"9%\"><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"9%\"><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"12%\"><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"10%\"><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td> <!-- 13 changed to 10  for AAKH-CRF-0084 [IN060429]  -->\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"2%\"><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</B></td><!--Modified for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"8%\"><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"8%\"><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</B></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"   width=\"5%\"><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr id=\"non_iv_admin_table_row1\" >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"14\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"modified_date_time_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"modified_date_time_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_status_flag_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"non_iv_status_flag_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_seq_no_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"non_iv_dosage_seq_no_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_code_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"non_iv_drug_code_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_item_code_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"non_iv_item_code_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_id_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"non_iv_order_id_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_store_code_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"non_iv_store_code_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_end_date_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"non_iv_end_date_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_class";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"non_iv_drug_class";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" value=\"N\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"medn_admn_dtl_reqd";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"medn_admn_dtl_reqd";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn_forNONIV";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"iv_prep_yn_forNONIV";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"\">\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Remarks";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"Remarks";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\"N\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_pract_id_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"order_pract_id_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"future_or_late_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"future_or_late_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"> <!--  Added for GHL-CRF-0482 --> \n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" style=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\" id=\"drug_mast_det_1\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t<label name=\"lbl_drug_desc\" style=\"font-size:10;\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&nbsp;&nbsp;\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\',\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\')\" title=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"></img>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' onclick = \"callADRdetails(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');\"></img>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/AddedIngredient.gif\' width=\'17\' height=\'15\' onclick = \"openPPNDisplay(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\')\" onmouseover=\"changeCursor(this);\">\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\t\t\t\t\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t<img  id=\"alternate_image_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" src=\'../../ePH/images/altenate.jpg\' style=\"cursor:pointer;";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" height=\'15\' width=\'15\' onClick=\"callAlternateDrugWindow(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\',\'N\');\" title=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'></img><!-- //Added for Bru-HIMS-CRF-399 [IN:043767] -->\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t<br><label id=\"id_dispdrugdesc_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"  style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" </label><!-- //Added for Bru-HIMS-CRF-399 [IN:043767] -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t<br><label id=\'link_vaccine_label_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' style=\"font-size:10;\" title=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'> ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" <input type=\'text\' size=10 name=\'link_vaccine_desc_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'link_vaccine_desc_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' disabled><input type=button  class=\'button\' value=\'?\' name=\'btn_link_vaccine_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'btn_link_vaccine_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' onClick=\"linkVaccine(\'noniv\',\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\"></label>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"link_vaccine_code_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"link_vaccine_code_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'  >&nbsp;</td>\n\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" width=\"50%\" height=\"60%\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\',\'N\')\" title=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showTPNDetails(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\');\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</label>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',\'\',\'MAR\',\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\'N\');\">";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" \n\t\t\t\t\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\',\'MAR\',\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" style=\"\">\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_sliding_range_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" id=\"non_iv_sliding_range_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\"  onBlur=\"CheckNum(this);findValuesRange(this,";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =")\" value=\"\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="><label style=\"font-size:10;";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" ><b>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</b></label>\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\" onBlur=\"CheckNum(this)\" value=\"\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</b></label> \n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_range_uom_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"non_iv_range_uom_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_ranges_from_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"sliding_scale_ranges_from_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_ranges_to_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"sliding_scale_ranges_to_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_adm_qty_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"sliding_scale_adm_qty_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_srl_no_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"sliding_scale_srl_no_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" id=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onopy=\"return false\" onpaste=\"return false\"   onBlur=\"CheckNum(this);updateNonIvAdminQuantity(this,\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\',\'noniv\',\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'); \" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="><label id=\"id_dosage_uom_new_MAR_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" style=\"font-size:10;";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</b></label> \n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" id = \"bal_qty_";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="&nbsp;";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" id=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom1_";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"non_iv_admin_qty_uom1_";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" id=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom1_";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return\tallowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\"    onBlur=\"CheckNum(this);    makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\');\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" style=\"font-size:10;\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</b></label>\t\t \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" style=\'color:";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =";background-color:";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =";font-size:10;\'><label style=\"font-size:10;\"> ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</label></td>\n";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" ><label style=\"font-size:9;font-weight;color:black\">&nbsp;</label></td>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" id=\"non_iv_MFR_status_column_";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="<label name=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" id=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openMFRDetails(\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\',\'NotAdmin\',\'\',\'\',\'\',\'\',\'\',\'\',\'Y\');\">";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =" <br>";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</label>&nbsp;&nbsp;&nbsp;&nbsp <a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\',\'Y\');\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>&nbsp;&nbsp;&nbsp;<font color=\"red\"><b>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</b></font></a>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_mfrRemarks";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" id=\"non_iv_mfrRemarks";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" ><label style=\"font-size:9;font-weight;color:black\">";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =" </label></td>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="<!--  TTM-SCF-0171-907901-->\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_sch_date_time_";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" id=\"non_iv_sch_date_time_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_time_";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" id=\"non_iv_time_";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" size=\"15\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" onBlur=\"validateAdminDateTime(\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\', this,\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\');\" style=\"font-size:11;";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =";";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"><input type=\'checkbox\'\tname=\"pat_brought_med_";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" id=\"pat_brought_med_";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" onclick=\"enableDisableTextbox(\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\',\'NOT\',\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\');\"\tdisabled></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" id=\"non_iv_batch_id_";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\"  size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"  disabled > \n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" id=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" id=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" id=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" id=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"> <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" id=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"><!-- GHL-CRF-0482-->\n\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" ><input type=\'checkbox\' name=\"pat_brought_med_";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\');\"></td> <!-- verify_adm_drug added for Added for AAKH-CRF-0084 [IN060429] -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\' id=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\' title=\'Shared Drug\' value=\"N\" onclick=\"chkShrdDrug(this,\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\')\" style=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\' ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 =" > \n";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" size=\"7\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\"  style=\"font-size:11;";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" disabled> \n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" id=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =" onClick=\"calcQuantityInDispensingUOM(\'NONIV\',\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\');callMednBatchSearch(\'non_iv_batch_id_";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\',\'non_iv_expiry_date_";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\',\'non_iv_trade_name_";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\',\'non_iv_trade_id_";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\',\'non_iv_bin_code_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\',document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 =".value,\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\',\'non_iv_time_";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\',\'NONIV\',\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\')\" style=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n\t\t\t\t\t\t\t\t\t \t        <img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" name=\"batch_id_mand_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" style=\"visibility:hidden;\"></img> <!-- Added for AAKH-CRF-0084 [IN060429] -->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"Newly_administerderd_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" id=\"Newly_administerderd_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" value=\'NONIV_Y\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\"><!-- GHL-CRF-0482-->\n\n\t\t\t\t\t\t\t\t\t\t\t<script>//Added for Bru-HIMS-CRF-399 [IN:043767] \n\t\t\t\t\t\t\t\t\t\t\t\tif(document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 =".value ==\'\'){\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"id_dispdrugdesc_\"+";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =").innerHTML = \'\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 =".value = \'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>//Added for Bru-HIMS-CRF-399 [IN:043767]\n\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"alternate_image_\"+";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 =").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"><input type=\'checkbox\' name=\"pat_brought_med_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\',\'N\',\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\');\" disabled></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' value=\"N\"><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\" disabled style=\"font-size:11;\"><input type=\"button\" class=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\" value=\"?\"  ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\"><input type=checkbox name=\"pat_brought_med_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" size=\"9\" maxlength=\"10\" value=\"\" disabled style=\"font-size:11;\"><input type=\"button\" class=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\"><!-- GHL-CRF-0482-->\n";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 =").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" ><input type=checkbox name=\"pat_brought_med_";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\');\" disabled></td> <!-- verify_adm_drug added for AAKH-CRF-0084 disabled added for GHL-CRF-0482-->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\' value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" style=\"font-size:11;";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" onChange=\"assignBatchDetails(\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\',\'NON_IV\',this,\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\',\'NOT_MFR\',\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\')\"> <!-- NOT_MFR Added for AAKH-SCF-0276 --><!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="---</option>\n";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option  selected value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option  value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="</option>\n";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</select>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" name=\"batch_id_mand_";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" style=\"visibility:hidden;\"></img> <!-- Added for AAKH-CRF-0084 [IN060429] -->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\" value=\"\"> <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" value=\"\"><!-- GHL-CRF-0482-->\n";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_barcode_id_";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" id=\"non_iv_barcode_id_";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"non_iv_alt_drug_code_";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" id=\"non_iv_alt_drug_code_";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"non_iv_batch_id_alt_";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" id=\"non_iv_batch_id_alt_";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">  <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\"> <!-- GHL-CRF-0482-->\n\n";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" id=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" size=\"7\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" disabled style=\"font-size:11;";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\' onClick=\" showCalendar(\'non_iv_expiry_date_";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\');\" style=\"visibility:hidden;display:none\" > \n\t\t\t\t\t\t\t\t\t\t        <img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" name=\"exp_dt_mand_";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" style=\"visibility:hidden;\" > <!-- Added for AAKH-CRF-0084 [IN060429] -->\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\');\"></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" size=\"9\" maxlength=\"10\" value=\"\"  style=\"font-size:11;";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\" disabled><input type=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" class=\"button\" value=\"?\" disabled \n\t\t\t\t\t\t\t\t\t\tonClick=\"\" style=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" size=\"9\" maxlength=\"10\"  value=\"\" disabled onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\');\" style=\"visibility:hidden;display:none\" >\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" checked disabled></td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\"><input type=\"button\" class=\"button\" value=\"?\" disabled onClick=\"\" style=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\"  name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\" style=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\" size=\"9\" maxlength=\"10\"  value=\"\" onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\');\">\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" style=\"display:none\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_trade_id_";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\" id=\"non_iv_trade_id_";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_bin_code_";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\" id=\"non_iv_bin_code_";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" value=\"\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_trade_name_";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\" id=\"non_iv_trade_name_";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" size=\"21\" maxlength=\"40\" disabled value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 =">\n";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t\t\t\t\t\t<label name=\"non_iv_remarks_";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\',\'SCH\',\'\',\'\',\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 =",  \'\',\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\',\'\', true, \'\', \'\', \'\' , \'";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\' );\" style=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="</label>\n\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"drug_remarks_mand_id_";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\"  ";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="></img>\n";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<script>mandSymbolDisplayForOncology(\'ONLOAD\',\'";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\')</script>\n";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_non_iv_select_";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\" id=\"chk_non_iv_select_";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" value=\"E\" checked style=\'display:none;\'>\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_chk_";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\" id=\"non_iv_chk_";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\" value=\"E\" checked style=\'display:none;\'>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\n\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" id=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\"  value=\"";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\" onclick=\"PatientStockCheck(this,\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\',\'Y\',\'";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\')\" ";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 =" style=\"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 =" >\n\t\t\t\t\t\t\t\t</td> <!-- GHL-CRF-0482 end-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_mand_symbol_";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\" id=\"non_iv_mand_symbol_";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\t\t\t\t\n";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\n\t\t\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" style=\"background:#CC99CC\" width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" style=\"color:#CC99CC\" color=\"#CC99CC\" class=\"";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">&nbsp;&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="</b>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_drug_code_";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\" id=\"alt_drug_code_";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"main_drug_code_";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\" id=\"main_drug_code_";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_dosage_seq_no_";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\" id=\"alt_dosage_seq_no_";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_item_code_";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\" id=\"alt_item_code_";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_order_id_";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\" id=\"alt_order_id_";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_order_line_num_";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\" id=\"alt_order_line_num_";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\">&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_admin_qty_";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\" id=\"alt_admin_qty_";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\" size=\"1\" maxlength=\"4\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\',\'alt\',\'";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" class=\"NUMBER\" style=\"font-size:11\"><label style=\"font-size:10\" id=\"\"><b>";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="</b></label> \n\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_alt_admin_qty_";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\" id=\"h_alt_admin_qty_";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_admin_qty_uom_";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\" id=\"alt_admin_qty_uom_";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_store_code_";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\" id=\"alt_store_code_";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_end_date_";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\" id=\"alt_end_date_";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_admin_chng_dtls_req_";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\" id=\"alt_admin_chng_dtls_req_";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" style=\"color:";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 =";font-size:10;\"><label style=\"font-size:10;\"> ";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="</label></td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_schedule_time_";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\" id=\"alt_schedule_time_";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\" size=\"5\" maxlength=\"5\" value=\"\" readOnly style=\"font-size:11;text-align:right\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_schedule_date_time_";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\" id=\"alt_schedule_date_time_";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_time_";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\" id=\"alt_time_";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" onBlur=\"validateAdminDateTime(\'";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\');\" style=\"font-size:11\" onBlur=\"\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'alt_shared_drug_";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\' id=\'alt_shared_drug_";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\'><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_batch_id_";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\" id=\"alt_batch_id_";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" style=\"font-size:11\" disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" onClick=\"calcQuantityInDispensingUOM(\'ALT\',\'";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\');callMednBatchSearch(\'alt_batch_id_";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\',\'alt_expiry_date_";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\',\'alt_trade_name_";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\',\'alt_trade_id_";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\',\'alt_bin_code_";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\',\'alt_time_";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\',\'ALT\',\'";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\')\" >\n";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'alt_shared_drug_";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\' value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"alt_batch_id_";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\" style=\"font-size:11;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\t\t\t\t\t\n";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"alt_shared_drug_";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\" id=\"alt_shared_drug_";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\" value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"alt_batch_id_";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\" style=\"font-size:11;\" onChange=\"assignBatchDetails(\'";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\',\'ALT_NON_IV\',this,\'";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\',\'\',\'";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option selected value=\"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\t\t\t\t\t\n";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_expiry_date_";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" id=\"alt_expiry_date_";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\" size=\"9\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\" disabled style=\"font-size:11\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\" style=\"display:none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_trade_name_";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\" id=\"alt_trade_name_";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\" style=\"font-size:11\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_trade_id_";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\" id=\"alt_trade_id_";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_bin_code_";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\" id=\"alt_bin_code_";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\" value=\"\" >\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<label name=\"alt_remarks_";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\',\'\',\'\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\', document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 =",\'\',\'";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 =",\'\', true, \'\', \'\',\'\' , \'";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\' )\">";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"alt_drug_remarks_mand_id_";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\" ></img>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_mand_symbol_";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\" id=\"alt_mand_symbol_";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\" value=\"style=\'display:inline\'\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_alt_non_iv_select_";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\" id=\"chk_alt_non_iv_select_";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\" value=\"E\" checked style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_scanned_batch_yn_";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\" id=\"non_iv_scanned_batch_yn_";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" value=\"\"><!--added for MMS-DM-SCF-0447 -->\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_brgt_medn_";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" id=\"patient_brgt_medn_";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\"><!-- added for GHL-CRF-0482-->\n\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\t</table><input type=\"hidden\" name=\"isSite_spec_patient_stock\" id=\"isSite_spec_patient_stock\" value = \"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\"  noresize>\n\t\t\t\t\t\t\t\t<tr id=\"iv_admin_table_row1\">\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\"  width=\"28%\"><B>";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"4%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"9%\"><B>";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\"><B>";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"10%\"><B>";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"7%\"><B>";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"11%\"><B>";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="</B></td><!--Modified for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"9%\"><B>";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"12%\"><B>";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="</B></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\"16\"   style=\"font-size:10\"><b>";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="</b></td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\n\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"2%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" title=\"";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" id=\"iv_modified_date_time_";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" id=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\" id=\"iv_drug_code_";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" id=\"iv_item_code_";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\" id=\"iv_order_id_";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" id=\"iv_order_line_no_";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_store_code_";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\" id=\"iv_store_code_";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\" id=\"iv_end_date_";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\"   value=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\" id=\"next_schd_date_";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\" id=\"iv_drug_class";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\" id=\"iv_dtls_yn";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\" id=\"iv_Remarks";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\" id=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\" value=\"\">\n";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\n\t\t\t\t\t\t\t\t\t\t<label  id=\"drug_mast_det_1";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\">&nbsp;</label>\n";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\');\" id=\"drug_mast_det_1";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;align:center\">";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n\t\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\n\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\n\t\t\t\t\t\t\t\t\t\t\t<br> <label id=\'iv_link_vaccine_label_";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 =" <input type=\'text\' size=10 name=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\' id=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\' disabled><input type=\'button\'  class=\'button\' value=\'?\' name=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\' id=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\' onClick=\"linkVaccine(\'iv\',\'";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\')\"></label>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\" id=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="></img>\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 =" \n\t\t\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\"><label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\n\t\t\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\n\t\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\" id=\"iv_admin_qty_";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\" id=\"iv_qty_uom_";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\" id=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\" id=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\"  >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\" size=\"1\" maxlength=\"4\" value=\"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 =" class=\"number\" style=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="font-size:11;\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this);changeDisplay(this,\'";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\');getHrsMinStr(\'TAKE\',\'";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\',\'iv\',\'";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\');\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;\" ><b>";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\">[<b>";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="/";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="</b>]</label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\"  >&nbsp;</td>\n";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td style=\'background-color:";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 =";\'><label style=\"font-size:10;color:";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 =";\"> ";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="</label>";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="<br><div id=\"orderctl";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\" onClick=\"displayToolTipSFR(\'";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\')\" onMouseOver=\"hideToolTip(\'";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\')\"><label style=\"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\"><b>";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="<b><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\' name=\'imgArrow";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\'></label></div>";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="</td>\n";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\" colspan=6 id=\"MFR_status_column_";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="<label name=\"iv_MFR_dtls_";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\',\'NotAdmin\',\'\');\">";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\" style=\"font-size:10;color:black;align:center;\" onClick=\"\">";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\" id=\"iv_admin_date_time_";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\" id=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\" id=\"iv_flow_rate_";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\" value=\"0\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\" id=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\" id=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\"> <!-- added for SKR-SCF-0215 [IN:029303] -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\" id=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\" id=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\" value=\"\">\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\" id=\"iv_infusion_period_";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\" id=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="\" id=\"previous_batch_id_";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 ="\" id=\"previous_exp_date_";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="\" id=\"previous_trade_id_";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\" id=\"iv_expiry_date_";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_mfrRemarks";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\" id=\"iv_mfrRemarks";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\">\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="\" id=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\"><!-- added for SKR-SCF-1240-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\" id=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\"> <!-- SKR-SCF-1240-->\n";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\"><label  style=\"font-size:9;color:black\" >";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 ="\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="\" size=\"13\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\" style=\"font-size:11;\" onBlur=\" validateAdminDateTime(\'";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\');\" ";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\">\t<!-- added for SCF-7528-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\" size=\"2\" maxlength=\"9\" value=\"";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="\" class=\"number\" style=\"font-size:11;color:blue\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this);changeDisplay(this,\'";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 =">\n\t\t\t\t\t\t\t<label style=\"font-size:10;\" style=\"";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="</b>\n\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\"> <!-- added for SKR-SCF-0215 [IN:029303]-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );

    private final static java.lang.String  _wl_block668 ="\" size=\"1\" maxlength=\"6\" value=\"\" style=\"font-size:11;\" disabled class=\"number\" style=\"";
    private final static byte[]  _wl_block668Bytes = _getBytes( _wl_block668 );

    private final static java.lang.String  _wl_block669 ="\">\n\t\t\t\t\t\t\t<label style=\"font-size:10;\" style=\"";
    private final static byte[]  _wl_block669Bytes = _getBytes( _wl_block669 );

    private final static java.lang.String  _wl_block670 ="<div id=\"sch_inf_per_";
    private final static byte[]  _wl_block670Bytes = _getBytes( _wl_block670 );

    private final static java.lang.String  _wl_block671 ="\">&nbsp;</div></b></label>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block671Bytes = _getBytes( _wl_block671 );

    private final static java.lang.String  _wl_block672 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block672Bytes = _getBytes( _wl_block672 );

    private final static java.lang.String  _wl_block673 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block673Bytes = _getBytes( _wl_block673 );

    private final static java.lang.String  _wl_block674 ="\"><!-- added for SKR-SCF-1240-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block674Bytes = _getBytes( _wl_block674 );

    private final static java.lang.String  _wl_block675 ="\"><!-- SKR-SCF-1240-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td nowrap class=\"";
    private final static byte[]  _wl_block675Bytes = _getBytes( _wl_block675 );

    private final static java.lang.String  _wl_block676 ="\"><!--Modified for HSA-CRF-0090[IN041241]-->\n";
    private final static byte[]  _wl_block676Bytes = _getBytes( _wl_block676 );

    private final static java.lang.String  _wl_block677 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block677Bytes = _getBytes( _wl_block677 );

    private final static java.lang.String  _wl_block678 ="\' id=\'iv_shared_drug_";
    private final static byte[]  _wl_block678Bytes = _getBytes( _wl_block678 );

    private final static java.lang.String  _wl_block679 ="\' value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block679Bytes = _getBytes( _wl_block679 );

    private final static java.lang.String  _wl_block680 ="\"  disabled >\t   \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block680Bytes = _getBytes( _wl_block680 );

    private final static java.lang.String  _wl_block681 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block681Bytes = _getBytes( _wl_block681 );

    private final static java.lang.String  _wl_block682 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block682Bytes = _getBytes( _wl_block682 );

    private final static java.lang.String  _wl_block683 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block683Bytes = _getBytes( _wl_block683 );

    private final static java.lang.String  _wl_block684 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block684Bytes = _getBytes( _wl_block684 );

    private final static java.lang.String  _wl_block685 ="\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block685Bytes = _getBytes( _wl_block685 );

    private final static java.lang.String  _wl_block686 ="  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block686Bytes = _getBytes( _wl_block686 );

    private final static java.lang.String  _wl_block687 ="\');callMednBatchSearch(\'iv_batch_id_";
    private final static byte[]  _wl_block687Bytes = _getBytes( _wl_block687 );

    private final static java.lang.String  _wl_block688 ="\',\'iv_expiry_date_";
    private final static byte[]  _wl_block688Bytes = _getBytes( _wl_block688 );

    private final static java.lang.String  _wl_block689 ="\',\'iv_trade_name_";
    private final static byte[]  _wl_block689Bytes = _getBytes( _wl_block689 );

    private final static java.lang.String  _wl_block690 ="\',\'iv_trade_id_";
    private final static byte[]  _wl_block690Bytes = _getBytes( _wl_block690 );

    private final static java.lang.String  _wl_block691 ="\',\'iv_bin_code_";
    private final static byte[]  _wl_block691Bytes = _getBytes( _wl_block691 );

    private final static java.lang.String  _wl_block692 ="\',\'iv_infusion_period_";
    private final static byte[]  _wl_block692Bytes = _getBytes( _wl_block692 );

    private final static java.lang.String  _wl_block693 ="\',\'IV\',\'";
    private final static byte[]  _wl_block693Bytes = _getBytes( _wl_block693 );

    private final static java.lang.String  _wl_block694 ="\')\" id=\"iv_batch_id_but_";
    private final static byte[]  _wl_block694Bytes = _getBytes( _wl_block694 );

    private final static java.lang.String  _wl_block695 ="\" name=\"iv_batch_id_but_";
    private final static byte[]  _wl_block695Bytes = _getBytes( _wl_block695 );

    private final static java.lang.String  _wl_block696 ="\" >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block696Bytes = _getBytes( _wl_block696 );

    private final static java.lang.String  _wl_block697 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block697Bytes = _getBytes( _wl_block697 );

    private final static java.lang.String  _wl_block698 ="\" id=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block698Bytes = _getBytes( _wl_block698 );

    private final static java.lang.String  _wl_block699 ="\" value=\'IV_Y\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block699Bytes = _getBytes( _wl_block699 );

    private final static java.lang.String  _wl_block700 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block700Bytes = _getBytes( _wl_block700 );

    private final static java.lang.String  _wl_block701 ="\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block701Bytes = _getBytes( _wl_block701 );

    private final static java.lang.String  _wl_block702 ="\' value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block702Bytes = _getBytes( _wl_block702 );

    private final static java.lang.String  _wl_block703 ="\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\"  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block703Bytes = _getBytes( _wl_block703 );

    private final static java.lang.String  _wl_block704 =" disabled id=\"iv_batch_id_but_";
    private final static byte[]  _wl_block704Bytes = _getBytes( _wl_block704 );

    private final static java.lang.String  _wl_block705 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block705Bytes = _getBytes( _wl_block705 );

    private final static java.lang.String  _wl_block706 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block706Bytes = _getBytes( _wl_block706 );

    private final static java.lang.String  _wl_block707 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block707Bytes = _getBytes( _wl_block707 );

    private final static java.lang.String  _wl_block708 ="\' value=\"N\"><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block708Bytes = _getBytes( _wl_block708 );

    private final static java.lang.String  _wl_block709 ="\" size=\"9\" maxlength=\"10\" value=\"\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\"  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block709Bytes = _getBytes( _wl_block709 );

    private final static java.lang.String  _wl_block710 ="\' value=\"N\" ><!--Added for HSA-CRF-0090[IN041241]-->\n\t\t\t\t\t\t\t\t\t\t<select name=\"iv_batch_id_";
    private final static byte[]  _wl_block710Bytes = _getBytes( _wl_block710 );

    private final static java.lang.String  _wl_block711 ="\',\'IV\',this,\'";
    private final static byte[]  _wl_block711Bytes = _getBytes( _wl_block711 );

    private final static java.lang.String  _wl_block712 ="\')\">\n\t\t\t\t\t\t\t\t\t\t<!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block712Bytes = _getBytes( _wl_block712 );

    private final static java.lang.String  _wl_block713 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option selected value=\"";
    private final static byte[]  _wl_block713Bytes = _getBytes( _wl_block713 );

    private final static java.lang.String  _wl_block714 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block714Bytes = _getBytes( _wl_block714 );

    private final static java.lang.String  _wl_block715 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block715Bytes = _getBytes( _wl_block715 );

    private final static java.lang.String  _wl_block716 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block716Bytes = _getBytes( _wl_block716 );

    private final static java.lang.String  _wl_block717 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block717Bytes = _getBytes( _wl_block717 );

    private final static java.lang.String  _wl_block718 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block718Bytes = _getBytes( _wl_block718 );

    private final static java.lang.String  _wl_block719 ="\n\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block719Bytes = _getBytes( _wl_block719 );

    private final static java.lang.String  _wl_block720 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block720Bytes = _getBytes( _wl_block720 );

    private final static java.lang.String  _wl_block721 ="\" size=\"9\" maxlength=\"10\" disabled value=\"";
    private final static byte[]  _wl_block721Bytes = _getBytes( _wl_block721 );

    private final static java.lang.String  _wl_block722 ="\" style=\"font-size:11;\">\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block722Bytes = _getBytes( _wl_block722 );

    private final static java.lang.String  _wl_block723 ="\" style=\"display:none\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block723Bytes = _getBytes( _wl_block723 );

    private final static java.lang.String  _wl_block724 ="\" id=\"iv_trade_name_";
    private final static byte[]  _wl_block724Bytes = _getBytes( _wl_block724 );

    private final static java.lang.String  _wl_block725 ="\" style=\"font-size:11;\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block725Bytes = _getBytes( _wl_block725 );

    private final static java.lang.String  _wl_block726 ="\" id=\"iv_trade_id_";
    private final static byte[]  _wl_block726Bytes = _getBytes( _wl_block726 );

    private final static java.lang.String  _wl_block727 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block727Bytes = _getBytes( _wl_block727 );

    private final static java.lang.String  _wl_block728 ="\" id=\"iv_bin_code_";
    private final static byte[]  _wl_block728Bytes = _getBytes( _wl_block728 );

    private final static java.lang.String  _wl_block729 ="\" value=\"\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block729Bytes = _getBytes( _wl_block729 );

    private final static java.lang.String  _wl_block730 ="\t\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"iv_chk_complete_";
    private final static byte[]  _wl_block730Bytes = _getBytes( _wl_block730 );

    private final static java.lang.String  _wl_block731 ="\" id=\"iv_chk_complete_";
    private final static byte[]  _wl_block731Bytes = _getBytes( _wl_block731 );

    private final static java.lang.String  _wl_block732 ="\" value=\"E\" checked onClick=\"clearDrgRemarks(this,\'";
    private final static byte[]  _wl_block732Bytes = _getBytes( _wl_block732 );

    private final static java.lang.String  _wl_block733 ="\',\'IV\')\" style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t<label name=\"iv_lbl_dtls_";
    private final static byte[]  _wl_block733Bytes = _getBytes( _wl_block733 );

    private final static java.lang.String  _wl_block734 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block734Bytes = _getBytes( _wl_block734 );

    private final static java.lang.String  _wl_block735 ="\',\'IV\',\'A\',\'";
    private final static byte[]  _wl_block735Bytes = _getBytes( _wl_block735 );

    private final static java.lang.String  _wl_block736 ="\',iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block736Bytes = _getBytes( _wl_block736 );

    private final static java.lang.String  _wl_block737 =",\'";
    private final static byte[]  _wl_block737Bytes = _getBytes( _wl_block737 );

    private final static java.lang.String  _wl_block738 ="\',true,\'\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block738Bytes = _getBytes( _wl_block738 );

    private final static java.lang.String  _wl_block739 ="\')\">";
    private final static byte[]  _wl_block739Bytes = _getBytes( _wl_block739 );

    private final static java.lang.String  _wl_block740 ="</label>\n\t\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"iv_remarks_mand_id_";
    private final static byte[]  _wl_block740Bytes = _getBytes( _wl_block740 );

    private final static java.lang.String  _wl_block741 ="\" style=\"display:visible\"></img>\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/return.gif\" id=\"nxt_adm_";
    private final static byte[]  _wl_block741Bytes = _getBytes( _wl_block741 );

    private final static java.lang.String  _wl_block742 ="\" style=\"display:none\">\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block742Bytes = _getBytes( _wl_block742 );

    private final static java.lang.String  _wl_block743 ="\n\t\t\t\t\t\t\t\t\t&nbsp;\n";
    private final static byte[]  _wl_block743Bytes = _getBytes( _wl_block743 );

    private final static java.lang.String  _wl_block744 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_mand_symbol_";
    private final static byte[]  _wl_block744Bytes = _getBytes( _wl_block744 );

    private final static java.lang.String  _wl_block745 ="\" id=\"iv_mand_symbol_";
    private final static byte[]  _wl_block745Bytes = _getBytes( _wl_block745 );

    private final static java.lang.String  _wl_block746 ="\" value=\"style=\'display:inline\'\">\n";
    private final static byte[]  _wl_block746Bytes = _getBytes( _wl_block746 );

    private final static java.lang.String  _wl_block747 ="\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openAuditLogWindow(\'";
    private final static byte[]  _wl_block747Bytes = _getBytes( _wl_block747 );

    private final static java.lang.String  _wl_block748 ="\',\'SFR\');\">";
    private final static byte[]  _wl_block748Bytes = _getBytes( _wl_block748 );

    private final static java.lang.String  _wl_block749 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_iv_select_";
    private final static byte[]  _wl_block749Bytes = _getBytes( _wl_block749 );

    private final static java.lang.String  _wl_block750 ="\" id=\"chk_iv_select_";
    private final static byte[]  _wl_block750Bytes = _getBytes( _wl_block750 );

    private final static java.lang.String  _wl_block751 ="\" value=\"E\" checked style=\'display:none;\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block751Bytes = _getBytes( _wl_block751 );

    private final static java.lang.String  _wl_block752 ="\" id=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block752Bytes = _getBytes( _wl_block752 );

    private final static java.lang.String  _wl_block753 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block753Bytes = _getBytes( _wl_block753 );

    private final static java.lang.String  _wl_block754 ="\" id=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block754Bytes = _getBytes( _wl_block754 );

    private final static java.lang.String  _wl_block755 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block755Bytes = _getBytes( _wl_block755 );

    private final static java.lang.String  _wl_block756 ="\" id=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block756Bytes = _getBytes( _wl_block756 );

    private final static java.lang.String  _wl_block757 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block757Bytes = _getBytes( _wl_block757 );

    private final static java.lang.String  _wl_block758 ="\" id=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block758Bytes = _getBytes( _wl_block758 );

    private final static java.lang.String  _wl_block759 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block759Bytes = _getBytes( _wl_block759 );

    private final static java.lang.String  _wl_block760 ="\" id=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block760Bytes = _getBytes( _wl_block760 );

    private final static java.lang.String  _wl_block761 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block761Bytes = _getBytes( _wl_block761 );

    private final static java.lang.String  _wl_block762 ="\" id=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block762Bytes = _getBytes( _wl_block762 );

    private final static java.lang.String  _wl_block763 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block763Bytes = _getBytes( _wl_block763 );

    private final static java.lang.String  _wl_block764 ="\" id=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block764Bytes = _getBytes( _wl_block764 );

    private final static java.lang.String  _wl_block765 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block765Bytes = _getBytes( _wl_block765 );

    private final static java.lang.String  _wl_block766 ="\" id=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block766Bytes = _getBytes( _wl_block766 );

    private final static java.lang.String  _wl_block767 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_desc";
    private final static byte[]  _wl_block767Bytes = _getBytes( _wl_block767 );

    private final static java.lang.String  _wl_block768 ="\" id=\"iv_drug_desc";
    private final static byte[]  _wl_block768Bytes = _getBytes( _wl_block768 );

    private final static java.lang.String  _wl_block769 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block769Bytes = _getBytes( _wl_block769 );

    private final static java.lang.String  _wl_block770 ="\" id=\"inf_prd_hrs";
    private final static byte[]  _wl_block770Bytes = _getBytes( _wl_block770 );

    private final static java.lang.String  _wl_block771 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block771Bytes = _getBytes( _wl_block771 );

    private final static java.lang.String  _wl_block772 ="\" id=\"inf_prd_min";
    private final static byte[]  _wl_block772Bytes = _getBytes( _wl_block772 );

    private final static java.lang.String  _wl_block773 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block773Bytes = _getBytes( _wl_block773 );

    private final static java.lang.String  _wl_block774 ="\" id=\"iv_dosage_type_";
    private final static byte[]  _wl_block774Bytes = _getBytes( _wl_block774 );

    private final static java.lang.String  _wl_block775 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block775Bytes = _getBytes( _wl_block775 );

    private final static java.lang.String  _wl_block776 ="\" id=\"completedMinutes";
    private final static byte[]  _wl_block776Bytes = _getBytes( _wl_block776 );

    private final static java.lang.String  _wl_block777 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block777Bytes = _getBytes( _wl_block777 );

    private final static java.lang.String  _wl_block778 ="\" id=\"completedFlow";
    private final static byte[]  _wl_block778Bytes = _getBytes( _wl_block778 );

    private final static java.lang.String  _wl_block779 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block779Bytes = _getBytes( _wl_block779 );

    private final static java.lang.String  _wl_block780 ="\" id=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block780Bytes = _getBytes( _wl_block780 );

    private final static java.lang.String  _wl_block781 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_pract_id_";
    private final static byte[]  _wl_block781Bytes = _getBytes( _wl_block781 );

    private final static java.lang.String  _wl_block782 ="\" id=\"iv_order_pract_id_";
    private final static byte[]  _wl_block782Bytes = _getBytes( _wl_block782 );

    private final static java.lang.String  _wl_block783 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn";
    private final static byte[]  _wl_block783Bytes = _getBytes( _wl_block783 );

    private final static java.lang.String  _wl_block784 ="\" id=\"iv_prep_yn";
    private final static byte[]  _wl_block784Bytes = _getBytes( _wl_block784 );

    private final static java.lang.String  _wl_block785 ="\">\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block785Bytes = _getBytes( _wl_block785 );

    private final static java.lang.String  _wl_block786 ="\n\t\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\t\t\tgetHrsMinStr(\'TAKE\',\'";
    private final static byte[]  _wl_block786Bytes = _getBytes( _wl_block786 );

    private final static java.lang.String  _wl_block787 ="\')\n\t\t\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block787Bytes = _getBytes( _wl_block787 );

    private final static java.lang.String  _wl_block788 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_by\" id=\"iv_admin_by\" value=\"";
    private final static byte[]  _wl_block788Bytes = _getBytes( _wl_block788 );

    private final static java.lang.String  _wl_block789 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_audit\" id=\"iv_admin_date_time_audit\" value=\"";
    private final static byte[]  _wl_block789Bytes = _getBytes( _wl_block789 );

    private final static java.lang.String  _wl_block790 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_remarks\" id=\"iv_admin_remarks\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no\" id=\"iv_dosage_seq_no\" value=\"";
    private final static byte[]  _wl_block790Bytes = _getBytes( _wl_block790 );

    private final static java.lang.String  _wl_block791 ="\">\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:15%;visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\" height=\"100%\" align=\"center\">\n\t\t\t\t\t\t\t\t<tr><td id=\"t\"></td></tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block791Bytes = _getBytes( _wl_block791 );

    private final static java.lang.String  _wl_block792 ="\t\n\t\t\t\t<br>\n\t\t\t\t<br>\n\t\t\t\t<br>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\" >\n\t\t\t\t\t<tr align=\"right\">\n\t\t\t\t\t\t<td  class=\"button\"   width=\'50%\'>\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"cancel\" id=\"cancel\" value=\'";
    private final static byte[]  _wl_block792Bytes = _getBytes( _wl_block792 );

    private final static java.lang.String  _wl_block793 ="\' onclick=\"callCancel()\">\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"record\" id=\"record\" value=\'";
    private final static byte[]  _wl_block793Bytes = _getBytes( _wl_block793 );

    private final static java.lang.String  _wl_block794 ="\' onclick=\"callSchrecord(this,\'";
    private final static byte[]  _wl_block794Bytes = _getBytes( _wl_block794 );

    private final static java.lang.String  _wl_block795 ="\')\">&nbsp;&nbsp;  <!-- recCount,iv_prep_yn  added for AAKH-CRF-0084 and patient_class_ord added for ICN66152-->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' width=\'50%\'>\n\t\t\t\t\t\t\t<label style=\'";
    private final static byte[]  _wl_block795Bytes = _getBytes( _wl_block795 );

    private final static java.lang.String  _wl_block796 ="\'>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block796Bytes = _getBytes( _wl_block796 );

    private final static java.lang.String  _wl_block797 ="&nbsp&nbsp;<label>\n\t\t\t\t\t\t\t<select name=\'selfAdminByType\' id=\'selfAdminByType\' onchange=\'changeAdminbyType(this)\' style=\'";
    private final static byte[]  _wl_block797Bytes = _getBytes( _wl_block797 );

    private final static java.lang.String  _wl_block798 ="\'>\n\t\t\t\t\t\t\t\t<option value=\'P\' selected>";
    private final static byte[]  _wl_block798Bytes = _getBytes( _wl_block798 );

    private final static java.lang.String  _wl_block799 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block799Bytes = _getBytes( _wl_block799 );

    private final static java.lang.String  _wl_block800 ="</option>\n\t\t\t\t\t\t\t</select>&nbsp&nbsp;\n\t\t\t\t\t\t\t<label style=\'display:none;\' id=\'selfAdminNamelbl\'>";
    private final static byte[]  _wl_block800Bytes = _getBytes( _wl_block800 );

    private final static java.lang.String  _wl_block801 ="&nbsp&nbsp;<label>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'selfAdminBy\' id=\'selfAdminBy\' value=\'";
    private final static byte[]  _wl_block801Bytes = _getBytes( _wl_block801 );

    private final static java.lang.String  _wl_block802 ="\' maxlength=\'30\' size=\'20\' style=\'display:none;\'>\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"  id=\"selfAdminByMand\"  style=\'display:none;\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"adminByType\" id=\"adminByType\"\tvalue=\"";
    private final static byte[]  _wl_block802Bytes = _getBytes( _wl_block802 );

    private final static java.lang.String  _wl_block803 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"current_date_time\" id=\"current_date_time\"\tvalue=\"";
    private final static byte[]  _wl_block803Bytes = _getBytes( _wl_block803 );

    private final static java.lang.String  _wl_block804 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"from_time\" id=\"from_time\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block804Bytes = _getBytes( _wl_block804 );

    private final static java.lang.String  _wl_block805 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block805Bytes = _getBytes( _wl_block805 );

    private final static java.lang.String  _wl_block806 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block806Bytes = _getBytes( _wl_block806 );

    private final static java.lang.String  _wl_block807 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\"\t\tvalue=\"";
    private final static byte[]  _wl_block807Bytes = _getBytes( _wl_block807 );

    private final static java.lang.String  _wl_block808 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id_selected\" id=\"patient_id_selected\" value=\"";
    private final static byte[]  _wl_block808Bytes = _getBytes( _wl_block808 );

    private final static java.lang.String  _wl_block809 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block809Bytes = _getBytes( _wl_block809 );

    private final static java.lang.String  _wl_block810 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block810Bytes = _getBytes( _wl_block810 );

    private final static java.lang.String  _wl_block811 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_line_num\" id=\"order_line_num\"\t\tvalue=\"";
    private final static byte[]  _wl_block811Bytes = _getBytes( _wl_block811 );

    private final static java.lang.String  _wl_block812 ="\">\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block812Bytes = _getBytes( _wl_block812 );

    private final static java.lang.String  _wl_block813 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block813Bytes = _getBytes( _wl_block813 );

    private final static java.lang.String  _wl_block814 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block814Bytes = _getBytes( _wl_block814 );

    private final static java.lang.String  _wl_block815 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"tot_no_of_records\" id=\"tot_no_of_records\"\tvalue=\"1\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_records\" id=\"non_iv_records\"\t\tvalue=\"";
    private final static byte[]  _wl_block815Bytes = _getBytes( _wl_block815 );

    private final static java.lang.String  _wl_block816 ="\"><!--changed 1 to tot_rec for ML-MMOH-CRF-1014 -->\n\t\t\t\t<input type=\"hidden\" name=\"new_non_iv_records\" id=\"new_non_iv_records\"\tvalue=\"";
    private final static byte[]  _wl_block816Bytes = _getBytes( _wl_block816 );

    private final static java.lang.String  _wl_block817 ="\"><!--changed 1 to tot_rec for ML-MMOH-CRF-1014 -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_non_iv_records\" id=\"alt_non_iv_records\"\tvalue=\"";
    private final static byte[]  _wl_block817Bytes = _getBytes( _wl_block817 );

    private final static java.lang.String  _wl_block818 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_records\" id=\"iv_records\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block818Bytes = _getBytes( _wl_block818 );

    private final static java.lang.String  _wl_block819 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"func_mode\" id=\"func_mode\"\t\t\tvalue=\"CP\">\n\t\t\t\t<input type=\"hidden\" name=\"drugCode\" id=\"drugCode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block819Bytes = _getBytes( _wl_block819 );

    private final static java.lang.String  _wl_block820 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"selDateTime\" id=\"selDateTime\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block820Bytes = _getBytes( _wl_block820 );

    private final static java.lang.String  _wl_block821 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"adr_recorded\" id=\"adr_recorded\"\t\tvalue=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"admin_recorded\" id=\"admin_recorded\"\t\tvalue=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block821Bytes = _getBytes( _wl_block821 );

    private final static java.lang.String  _wl_block822 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block822Bytes = _getBytes( _wl_block822 );

    private final static java.lang.String  _wl_block823 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"userAuthPINYN\" id=\"userAuthPINYN\"\t\tvalue=\"";
    private final static byte[]  _wl_block823Bytes = _getBytes( _wl_block823 );

    private final static java.lang.String  _wl_block824 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"admin_discontinue\" id=\"admin_discontinue\"\tvalue=\"";
    private final static byte[]  _wl_block824Bytes = _getBytes( _wl_block824 );

    private final static java.lang.String  _wl_block825 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\"\tvalue=\"";
    private final static byte[]  _wl_block825Bytes = _getBytes( _wl_block825 );

    private final static java.lang.String  _wl_block826 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"verify_adm_drug\" id=\"verify_adm_drug\" value=\"";
    private final static byte[]  _wl_block826Bytes = _getBytes( _wl_block826 );

    private final static java.lang.String  _wl_block827 ="\"> <!--  Added for AAKH-CRF-0084 [IN060429] -->\n\t\t\t\t<input type=\"hidden\" name=\"allowed_yn_";
    private final static byte[]  _wl_block827Bytes = _getBytes( _wl_block827 );

    private final static java.lang.String  _wl_block828 ="\" id=\"allowed_yn_";
    private final static byte[]  _wl_block828Bytes = _getBytes( _wl_block828 );

    private final static java.lang.String  _wl_block829 ="\" value = \"\"><!--added for GHL-CRF-0458 and recCount added for IN066062-->\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block829Bytes = _getBytes( _wl_block829 );

    private final static java.lang.String  _wl_block830 ="\t\n</html>\n\n";
    private final static byte[]  _wl_block830Bytes = _getBytes( _wl_block830 );
	
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


	public String roundDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 2){
					bb=a.substring(0,a.indexOf(".")+2);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
	}


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

/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date 		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
03/02/2017		IN061410		Chithra		01/02/2017	Manickkam 		TTM-SCF-0171
15/09/2020		IN:073832	        Manickavasagam J			     SKR-SCF-1421
24/12/2020		11726		        Manickavasagam J			     SKR-SCF-1534
31/12/2020      	10309         		Sai Teja P   			31/12/2020  Manickavasagam J    ML-MMOH-SCF-1674  
31/1/2021		6771		        Manickavasagam J			     SKR-SCF-1429
22/02/2021		9596		        Manickavasagam J			     ML-MMOH-SCF-1674
26/04/2021		16605		        Manickavasagam J			     ML-MMOH-SCF-1767
29/12/2021		TFS-26100           Prabha							 MMS-MD-SCF-0179
26/04/2022                  Chandrashekar raju A                    ML-MMOH-SCF-1964
-------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

System.out.println("==============in==========>MARSchLevelDrugAdmin.jsp");
     Connection con			= null; // Added for AAKH-CRF-0084 [IN060429] - start
     con				= ConnectionManager.getConnection(request);
     boolean verify_adm_drug = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VERIFY_ADM_DRUG");// Added for AAKH-CRF-0084 [IN060429] - End
	
	try{
 		request.setCharacterEncoding("UTF-8");
 		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
 		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
 		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
 		//ends
 		
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_id			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String mode				        =	 request.getParameter("mode");	
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String order_id			=	 request.getParameter("order_id");
		String order_line_num			= request.getParameter("order_line_num")==null?"0":request.getParameter("order_line_num");
		String shedule_date_time			= request.getParameter("p_start_date_time");
		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String drugCode			= request.getParameter("p_ord_drug_code")==null?"":request.getParameter("p_ord_drug_code");
		String recCount			= request.getParameter("recCount")==null?"0":request.getParameter("recCount");
		String adminOption			= request.getParameter("adminOption")==null?"AD":request.getParameter("adminOption");
		String userAuthPINYN=request.getParameter("userAuthPINYN")==null?"":request.getParameter("userAuthPINYN");
		String callFrom=request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String hold_discontinue_yn=request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String admin_from_date=request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
		String admin_to_date=request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String admin_discontinue=request.getParameter("admin_discontinue")==null?"":request.getParameter("admin_discontinue");
		String sch_date=request.getParameter("sch_date")==null?"":request.getParameter("sch_date");
		String adminByType = "U", selfAdminBy="", admin_disc_classValue="",dispense_drug_code="",generic_id="",dispensed_drug_desc="",disp_drugs="",alt_drug_display="";
		ArrayList arrAltDrugs = new ArrayList();//Added for Bru-HIMS-CRF-399 [IN:043767]
		String adminOptionDisplay="display:none;";
		String mfr_yn			 = request.getParameter("mfr_yn")==null?"":request.getParameter("mfr_yn");//ML-MMOH-CRF-1014
		String user_id= (String) session.getValue("login_user");
		String future_admin = request.getParameter("future_admin")==null?"":request.getParameter("future_admin"); // Added for GHL-SCF-0482
		String onco_iv_prep_yn = request.getParameter("onco_iv_prep_yn")==null?"":request.getParameter("onco_iv_prep_yn");//MMS-KH-CRF-0017.1
		if(adminOption.equals("SAD")){
			adminOptionDisplay ="display:inline;"; 
			adminByType = "P";
			selfAdminBy = "Patient";
		}
		int iRecCount = Integer.parseInt(recCount);
		recCount = "1";
		float ret_qty=0;
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;
		String start_date_time="";

		DecimalFormat dfTest = new DecimalFormat("0.########");

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
				String selDateTime				=    "";
				String flag						=    "";
						
				if(mode!=null && mode.equals("NOTIME")){
					drugCode					=	request.getParameter("drug_code");
					selDateTime					=	request.getParameter("selDateTime");
				}
				if(function_from.equals("SCH")){
					drugCode					=	request.getParameter("p_ord_drug_code");
					mode						=	"SCH";
				}
				String bean_id_all_stages				= "DispMedicationAllStages" ;
				String bean_name_all_stages				= "ePH.DispMedicationAllStages";
				DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
				bean_all_stages.setLanguageId(locale);
				bean_all_stages.setModuleId("1");
				ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id,patient_id,order_line_num);	
				String bean_id							= "MedicationAdministrationFTBean";
				String bean_name						= "ePH.MedicationAdministrationFTBean";
				MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
				bean.setLanguageId(locale);
				bean.setCurrentTimeAndAdminWithinHRS();
				boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203
	//			isSiteSpecMARPrint = true;
				String drug_search_bean_id				= "DrugSearchBean";
				String drug_search_bean_name			= "ePH.DrugSearchBean";
				DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
				drug_bean.setLanguageId(locale);
				HashMap drug_details					= new HashMap();					
		
				ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
				String current_date_time				= (String)result.get(0);
				String AdminBackLogTime					= "";
				AdminBackLogTime					= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));		
				String adminFromDateTime		= bean.getFromDateTime(current_date_time);
			//	String adminToTime	=current_date_time; removed for IN062053
				String adminToTime			= bean.getAdiminWindowToDateTime(current_date_time);	
				String title				   =	"";
				ArrayList admin_drug_details = null;
				String admin_bean_id						=	  "MedicationAdministrationBean";
				String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
				MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
				admin_bean.setLanguageId(locale);
				String allow_mar_alternate_drug_yn = admin_bean.getAllow_auto_disp_alt_drug_mar();//Added for Bru-HIMS-CRF-399 [IN:043767]
				String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
				String shared_drug_disp = "";
				if(allowMAR_share_drug==null || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
					shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
				HashMap defaultValues				=	new HashMap();
				String	defaultDate					=	"";
				String  defaultBatch				=	"";
				String	defaultTradeId				=	"";
				String	defaultExpiryDate			=	"";
				String schedule_uom_desc			=   "";
				String schedule_uom_code			=   "";
				int no_of_alt_drus_selected			=   0;	
				String stat_style					=   "";
				String classvalue					=   "";		String store_code	  =	"";
				String drug_class					=   "";		String drug_class_ind = "";
				String  short_desc					=   "";	
				String  drug_code					=   "";
				String  disp_drug_code				=   "";
				String  uom_code					=   "";
				String  drug_desc					=   "";		String  qty			  = "";
				String encode_drug_desc				=   "";
				String ordered_qty					=   "";		String  batch_id	  = ""; 
				String  expiry_date					=   "";		String  tradename	  =	"";	                     
				String  item_code					=   "";		
				ArrayList batch_ids   = new ArrayList(); 
				String sch_date_time				=   "";		String dosage_seq_no  = "";
				String trade_id						=   "";		String dis_continued  = "";
				String hold							=   "";		String administered   = "";
				String admin_recorded_yn			=   "";		String remarks		  =	"";
				String admindrugdetails				=   "";
				String admin_drug_code				=   "";		String admin_drug_desc=	"";
				String Store_locn_code				=	"";
				String Storelocn_code				=	"";
				String iv_incred					=	"";
				String iv_incred1					=	"";
				String iv_incred2					=	"";
				String route_desc					=	"";
				String pres_catg_code				=   "";
				String pres_base_uom				 =  "";		//added for SKR-SCF-0304
				boolean auth_reqd					=   false;
				boolean alt_flag					=   false;
				boolean disp_with_alt				=   false;//BRU-CRF-399.1
				String auth_reqd_script				=	"";
				StringTokenizer stadmindrugdetails	=	null;
				StringTokenizer stiv_incred			=	null;	
				String admin_by_name				=	"";		String auth_by_name					=	"";
				String end_date_time				=	"";		String freq_code					=	"";
				String next_schd_date				=	"";		String AdUOM						=	"";
				String pract_id						=	"";		String against_sch_date				=	"";
				String adr_reason					=	"";		String adr_remarks					=	"";
				String adr_record_time				=	"";		String adr_recorded_by				=	"";
				String img_path						=	"";		String adr_details					=	"";
				String freq_nature					=	"";		String stat_title					=	"";
				String mand_display					=	"";		String drug_remarks					=	"";
				String prn_remarks					=	"";		String slidingscaleremarks	        =   "";
				String pharma_remarks				=	"";		String verificationremarks			=	"";
				String pres_remarks					=	"";		String remarks_style				=	"";	
				String select_status				=	"";		String dtl_style					=	"";	
				String pres_dosage					=	"";		String pres_unit					=	"";	
				String medn_admn_dtl_reqd_yn		=	"";	    String select_status_1				=   "";
				String ext_prod_id					=   "";		String show_remarks					=	"N";
				String imageFileURL					=	"";		String patient_brgt_medn			=	"N";
				String trade_code					=	"";     String sliding_scale_applicable		=   "N";
				String strength_value_prn			=	"";     String sch_strength_value_prn		=	"";
				String sch_strength_uom_prn			=	"";     String sch_strength_uom_desc_prn	=	"";
				String dosage_uom_code				=	"";     String dosage_uom_desc				=	"";
				String dosage_type					=	"";     String dosage						=	"";
				String adminsted_pat_brought_medn	=	"N";    String content_in_pres_base_uom		=	"1";
				String tempDosage					=	"";     String onco_direct_drug_count		=	"1";
				String demostring					=  "\\\'\'";String linkVacScheduleCode			=	"";
				String admn_dose_chng_reason_code   =	"";		String linkVacScheduleDesc			=	"";
				String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
				String performingDeptLocCode		=	"";		String nonMfrFluidRemarks			=	"";
				String strength_per_value_pres_uom = "1";
				String route_color 	=   "";   
				String fntColor                     =   "#OOOOOO";
				String backGrndColor                =   "#FFFFFF"; 
				String order_pract_id 	=   ""; 
				String displayStyle		=	"";
				String statusFlag		=	"YES";
				String addDisplayStyle	=	"";
				String checked			=	"";
				String verbalOrder="", showAlt="", alt_drug="";	
				String administred_batch_id	 =	"";
				String disp_batch_id		 =	"";
				String disp_exp_dt			 =	"";
				String disp_trade_id		 =	"";		
				String admin_dose_prn		 =  "", Auto_Admin="";
				HashMap  administred_batch  = null;
				String linkVacScheduleCode1	="";			
				String[] vacScheduleDetails;
				int adr_count =0;
				float tot_alt_qty       = 0.0f;
				String rangeUOM = "", sl_srl_no="", sl_rg_fro="", sl_rg_to="", sl_adm_qty="", modified_date_time = "", admin_date_time = "",  showTitle="", non_iv_admin_quaty="", temp ="";
				String auto_Admin_dis="", bat_id_lookbutton_enabled="";	
				ArrayList totQty = null;
				ArrayList WardReturnQty = null;
				
				String pin_value=bean.getPinNumber();
//				DecimalFormat dfToInteger = new DecimalFormat("####.##");
				ArrayList work_sheet_batch_det1		=	new ArrayList();
				ArrayList sliding_scale_details		=	new ArrayList();
			/*	int temp1                           =   0;
				int temp2                           =   0;		
				int temp3                           =   0;		
				int inc								=   0; */
				float dialog_height					=	0;
				HashMap overridereason				=	new HashMap();
				int ppn_count						=   0;
//				int tot_records						=   0;		
				int altRecCount						=   0;		//int newRecCount		 = 0;
				int ivRecCount						=   1;
				ArrayList alreadyEnteredValues = null;
				ArrayList hmAdmin_drug_details = null;
				String customer_id = bean.getCustomerID(); //added MMS-DM-SCF-0442
				String patient_class_ord = "";//GHL-CRF-0458

				String mfrRemarks		 = "";
		//added for GHL-CRF-0482 - start
				String patient_stock_yn = "";
				String patient_stock_required = "";
				String patient_stock_completed	= "";
				String patient_stock_checked    = "";
				String patient_stock_disabled	= "";
				String patient_stock_check_display = "";
				HashMap batchIdforOrders = null; //GHL-CRF-0482
				String onco_order_drug_count ="";
				String sch_date_time_drug    = "";
				String split_dose_yn = "N"; //ML-MMOH-SCF-1439
		//added for GHL-CRF-0482 - end
		
				bean.setIvprepYN(iv_prep_yn); //added for MMS-MD-SCF-0179
				
				int tot_rec = 1;
				if(callFrom.equals("adminNONIV")){
					//MMS-KH-CRF-0017.1 - start
					if(onco_iv_prep_yn.equals("9")){
						onco_order_drug_count = request.getParameter("onco_direct_drug_count");

						if(onco_order_drug_count==null || onco_order_drug_count.equals("")){
							onco_order_drug_count = "1";
						}else{
							tot_rec = Integer.parseInt(onco_order_drug_count) ;
						}
					}
					//MMS-KH-CRF-0017.1 - end
					if(mfr_yn.equals("Y")){
						tot_rec=2;
					}
				}
		
				boolean mfrCompletedStatus		=	false;
				if(callFrom.equals("adminNONIV")){
					boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
	//				isSite_spec_patient_stock = true;
					drug_details		  =	(HashMap) bean.getDrugDetails();
					String onco_dosage_seq_no = ""; //JD-CRF-0200
					String onco_modified_date_time = "";//JD-CRF-0200
System.err.println("drug_details=====293===>"+drug_details);
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
						title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
					else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
						title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
					else
						title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
					LinkedHashMap	non_iv_drug_details = null;
					if(drug_details!=null){
						non_iv_drug_details				=	 (LinkedHashMap) drug_details.get("NON_IV");
						if(non_iv_drug_details!=null && non_iv_drug_details.containsKey(order_id+"_"+order_line_num)){
							hmAdmin_drug_details = (ArrayList)non_iv_drug_details.get(order_id+"_"+order_line_num);
							admin_drug_details = (ArrayList)hmAdmin_drug_details.get(iRecCount);
						}
					}
					defaultValues						=	admin_bean.getNONIVDrugDetails();
					if (defaultValues.containsKey(selDateTime)){
						try{
							alreadyEnteredValues=(ArrayList)defaultValues.get(selDateTime);
							defaultDate			=	(String)alreadyEnteredValues.get(2)==null?"":(String)alreadyEnteredValues.get(2);
							defaultBatch		=	(String)alreadyEnteredValues.get(9)==null?"":(String)alreadyEnteredValues.get(9);
							defaultExpiryDate	=	(String)alreadyEnteredValues.get(10)==null?"":(String)alreadyEnteredValues.get(10);
							defaultTradeId		=	(String)alreadyEnteredValues.get(11)==null?"":(String)alreadyEnteredValues.get(11);
						}
						catch (Exception e){
							defaultDate			="";
							defaultBatch		="";
							defaultExpiryDate	="";
							defaultTradeId		="";
						}
					} 
					if(admin_drug_details!=null && admin_drug_details.size()>0){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
								if(isSite_spec_patient_stock){ //added for GHL-CRF-0482

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

								}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(title));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

							for(int i=0;i<tot_rec;i++){//ML-MMOH-CRF-1014 - start
						
							if(i==1){
								admin_drug_details = null;
								hmAdmin_drug_details = null;
								hmAdmin_drug_details = (ArrayList)non_iv_drug_details.get(order_id+"_2");
								admin_drug_details = (ArrayList)hmAdmin_drug_details.get(0);
								iRecCount++;
								recCount= "2";
								order_line_num = recCount;
							}//ML-MMOH-CRF-1014
							ppn_count = 0;
							linkVacScheduleCode="";
							linkVacScheduleYN ="N";
							iv_prep_yn			= (String)admin_drug_details.get(44);
							iv_incred			= (String)admin_drug_details.get(53);
							route_desc			= (String)admin_drug_details.get(54);
							pres_catg_code		= (String)admin_drug_details.get(55);							
							medn_admn_dtl_reqd_yn	= admin_drug_details.get(45)==null?"":(String)admin_drug_details.get(45);

							prn_remarks			= (String)admin_drug_details.get(46);				
							slidingscaleremarks	= (String)admin_drug_details.get(47);
							ext_prod_id			= (String)admin_drug_details.get(50);
							trade_code			= (String)admin_drug_details.get(51);
							imageFileURL		= (String)admin_drug_details.get(52);
							schedule_uom_desc	= (String)admin_drug_details.get(56);
							schedule_uom_code	= (String)admin_drug_details.get(57);
							patient_brgt_medn	= (String)admin_drug_details.get(58);
							sliding_scale_applicable	= (String)admin_drug_details.get(59);
							strength_value_prn	= (String)admin_drug_details.get(60)==null?"":(String)admin_drug_details.get(60);
							sch_strength_value_prn	= (String)admin_drug_details.get(61)==null?"":(String)admin_drug_details.get(61);
							adminsted_pat_brought_medn	= (String)admin_drug_details.get(62);	
							dosage_type			= (String)admin_drug_details.get(63);
							dosage				= (String)admin_drug_details.get(64);
							dosage_uom_code		= (String)admin_drug_details.get(65);
							dosage_uom_desc		= (String)admin_drug_details.get(66);
							content_in_pres_base_uom= (String)admin_drug_details.get(67);
							sch_strength_uom_prn	= (String)admin_drug_details.get(68)==null?"":(String)admin_drug_details.get(68);
							sch_strength_uom_desc_prn	= (String)admin_drug_details.get(69)==null?"":(String)admin_drug_details.get(69);	
							admn_dose_chng_reason_code	= (String) admin_drug_details.get(70)==null?"":(String)admin_drug_details.get(70);	
							onco_direct_drug_count		= (String)admin_drug_details.get(71);
							linkVacScheduleCode			= (String)admin_drug_details.get(72);
							performingDeptLocCode		= (String)admin_drug_details.get(73)==null?"":(String)admin_drug_details.get(73);
							pres_base_uom				= (String)admin_drug_details.get(3);
							adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
							verificationremarks	= bean_all_stages.getVerificationRemarks((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							overridereason		= (HashMap)bean_all_stages.getOverrideremarks((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							pres_remarks		= bean.getPrescriptionInstructions((String)admin_drug_details.get(13));
							drug_remarks		= bean.getDrugInstructions((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							pharma_remarks		= bean.getPharmacistInstructions((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							show_remarks		= "N";
							order_pract_id  =(String)admin_drug_details.get(76)==null?"":(String)admin_drug_details.get(76);
							start_date_time	= (String)admin_drug_details.get(77);
							route_color                 = (String)admin_drug_details.get(75)==null?"":(String)admin_drug_details.get(75);	
							if(route_color != "" && route_color != null && route_color.length()==12){
								fntColor = route_color.substring(0, 6);
								backGrndColor = route_color.substring(6, 12);
							}
							if(ext_prod_id!=null && !ext_prod_id.equals("")){
								if(overridereason.size()>1){
									show_remarks="Y";
								}			
							}
							else{
								if(overridereason.size()>0){
									show_remarks="Y";
								}
							}
							if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
								linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);						
								if(!linkVacScheduleCode1.equals("NO DEFAULT")){
									try{
										linkVacScheduleYN="Y";
										vacScheduleDetails=linkVacScheduleCode.split("~");
										if(vacScheduleDetails.length>0){
											linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
											linkVacScheduleDescToolTip=vacScheduleDetails[3];
											linkVacScheduleDesc=vacScheduleDetails[4];
										}
									}
									catch(Exception execu){
										execu.printStackTrace();
									}
								}
								else{
									linkVacScheduleYN="Y";
									linkVacScheduleDescToolTip="";
									linkVacScheduleDesc="";
									vacScheduleDetails=linkVacScheduleCode.split("~");
									if(vacScheduleDetails.length>0){
										linkVacScheduleCode=vacScheduleDetails[1];
									}
								}
							}
							else{
								linkVacScheduleYN="N";
								linkVacScheduleDescToolTip="";
								linkVacScheduleDesc="";
							}
							tempDosage				=	dosage;
							strength_value_prn		=	strength_value_prn.trim();
							sch_strength_value_prn	=	sch_strength_value_prn.trim();
							if(iv_prep_yn == null){
								iv_prep_yn="";
							}
							if(pres_catg_code == null){
								pres_catg_code="";
							}
							if(route_desc==null)
								route_desc="";
							iv_incred2="";
							if(iv_incred != null){
								stiv_incred = new StringTokenizer(iv_incred,"|");
								while(stiv_incred.hasMoreTokens()){
									iv_incred1 = stiv_incred.nextToken();
									if(stiv_incred.hasMoreTokens())
										iv_incred2 = stiv_incred.nextToken();						
								}
							} 

							auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);												
							if(auth_reqd){							
								if(pin_value.equals(""))
									auth_reqd_script=";pinAuthentication(this,'NP');";
								else
									auth_reqd_script=";pinAuthentication(this,'YP');";
							}
							
							if ( (iRecCount+1) % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;						
							flag="Y";
							disp_drug_code	= (String)admin_drug_details.get(0);
							drug_code		= (String)admin_drug_details.get(28);
							dispensed_drug_desc	= (String)admin_drug_details.get(86);
							disp_drugs = (String)admin_drug_details.get(87);
							dispense_drug_code = (String)admin_drug_details.get(88);
							generic_id = (String)admin_drug_details.get(89);
							split_dose_yn = (String)admin_drug_details.get(82);//ML-MMOH-SCF-1439
							if(dispense_drug_code.equals(""))
								dispense_drug_code = drug_code;
							store_code		= (String)admin_drug_details.get(29);	
							drug_class		= admin_drug_details.get(30)==null?"":(String)admin_drug_details.get(30);
							end_date_time	= (String)admin_drug_details.get(32);
							drug_desc		= (String)admin_drug_details.get(1);	
							
							encode_drug_desc= drug_desc.replaceAll(" ","%20");
							encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
							encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");

							adr_count	= bean.getADRCount(patient_id,drug_code);
							qty				= (String)admin_drug_details.get(2);
							ordered_qty		= (String)admin_drug_details.get(2);
							if(ordered_qty.equals(""))
								ordered_qty	="0";							
							short_desc		= (String)admin_drug_details.get(3);
							batch_id		= (String)admin_drug_details.get(4)==null?"":(String)admin_drug_details.get(4);
							expiry_date		= (String)admin_drug_details.get(5)==null?"":(String)admin_drug_details.get(5); 
							tradename		= (String)admin_drug_details.get(6)==null?"":(String)admin_drug_details.get(6);
							item_code		= (String)admin_drug_details.get(7);
							order_id	    = (String)admin_drug_details.get(13);
							order_line_num  = (String)admin_drug_details.get(14);
							patient_id	    = (String)admin_drug_details.get(15);
							sch_date_time   = (String)admin_drug_details.get(16);
							uom_code		= (String)admin_drug_details.get(43);
							
							//added for MMS-KH-CRF-0017.1 - start
							if(sch_date_time_drug.equals(""))
								sch_date_time_drug=sch_date_time;

							if(iv_prep_yn.equals("9") && order_line_num.equals("2"))
								sch_date_time = sch_date_time_drug;

							//added for MMS-KH-CRF-0017.1 - end
							patient_class_ord = bean.getOrderPatientClass(order_id);
							//GHL-CRF-0482 - start
							if(iv_prep_yn.equals("")){
								patient_stock_required = (String)admin_drug_details.get(93)==null?"N":(String)admin_drug_details.get(93);
								patient_stock_completed = (String)admin_drug_details.get(94)==null?"N":(String)admin_drug_details.get(94);
								patient_stock_yn = (String)admin_drug_details.get(95)==null?"N":(String)admin_drug_details.get(95);
							}
							
							if(!iv_prep_yn.equals(""))
								patient_stock_disabled="disabled";
							if(patient_brgt_medn.equals("Y"))
								patient_stock_disabled="disabled";
						
							if(patient_stock_completed.equals("Y"))
								patient_stock_checked = "checked";
							else
								patient_stock_checked = "";

							if(patient_stock_required!=null && patient_stock_required.equals("Y")) 
								patient_stock_check_display	=	"display:inline"; 
							else
								patient_stock_check_display	=	"display:none";

							//GHL-CRF-0482-end
							if(patient_class_ord==null)
								patient_class_ord = "";

							if(iv_prep_yn.equals("9") &&  Integer.parseInt(onco_direct_drug_count)>1 && order_line_num.equals("1"))
								classvalue="IVFLUID1";
							if(iv_prep_yn !=null && iv_prep_yn.equals("7"))
								   ppn_count = bean.getPPNIOrderValues(order_id, patient_id);

							if(!locale.equals("en"))
								expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date, "DMY",locale,"en");

							Store_locn_code	= performingDeptLocCode;
							Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);

							if(!Storelocn_code.equals("")){
								admin_drug_details.set(29,Storelocn_code);
								store_code		= Storelocn_code;
							}
							if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")){	
								work_sheet_batch_det1  =(ArrayList)bean.getProductName(order_id,order_line_num);								
								batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);
								expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
								drug_code	= "FINAL PRODUCT";															
							}
							else if(iv_prep_yn.equals("8")){
								work_sheet_batch_det1  =(ArrayList)bean.getTPNProductName(order_id,order_line_num);
								batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);								
								expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
								drug_code	= "FINAL PRODUCT";
							}

							Auto_Admin					 =  bean.getAutoAdminValue(facility_id,Store_locn_code);
							administred_batch   =  bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);						
							disp_batch_id				 =  "";
							administred_batch_id		 =  "";
							disp_exp_dt					 =  "";
							administred_batch_id         =administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");
										
							disp_batch_id		 = administred_batch.get("DISP_BATCH_ID")==null?"":(String)administred_batch.get("DISP_BATCH_ID");					
							disp_exp_dt			 = administred_batch.get("DISP_EXPIRY_DATE")==null?"":(String)administred_batch.get("DISP_EXPIRY_DATE");
										
							if(!locale.equals("en"))
								disp_exp_dt = com.ehis.util.DateUtils.convertDate(disp_exp_dt, "DMY",locale,"en");

							disp_trade_id		 = (String)administred_batch.get("DISP_TRADE_ID")==null?"":(String)administred_batch.get("DISP_TRADE_ID");
							dosage_seq_no		= (String)admin_drug_details.get(17);
							trade_id			= (String)admin_drug_details.get(18);			
							dis_continued		= (String)admin_drug_details.get(19);
							hold				= (String)admin_drug_details.get(20);
							administered		= (String)admin_drug_details.get(21);
							admin_recorded_yn   = (String)admin_drug_details.get(22); 	
							remarks				= (String)admin_drug_details.get(23);
							admindrugdetails	= (String)admin_drug_details.get(24);
							pract_id			= (String)admin_drug_details.get(36);
							against_sch_date	= (String)admin_drug_details.get(37);
							if(!locale.equals("en"))
							   against_sch_date = com.ehis.util.DateUtils.convertDate(against_sch_date, "DMYHM",locale,"en");
							adr_reason			= admin_drug_details.get(38)==null?"":(String)admin_drug_details.get(38);
							adr_remarks			= admin_drug_details.get(39)==null?"":(String)admin_drug_details.get(39);
							adr_record_time		= admin_drug_details.get(40)==null?"":(String)admin_drug_details.get(40);
							adr_recorded_by		= admin_drug_details.get(41)==null?"":(String)admin_drug_details.get(41);
							pres_dosage			= admin_drug_details.get(42)==null?"":(String)admin_drug_details.get(42);
							pres_unit			= admin_drug_details.get(43)==null?"":(String)admin_drug_details.get(43);
							admin_drug_code	    =  "";
							admin_drug_desc 	=  "";
										
							if( (bean.getPractitionerType(pract_id)).equals("NS")){
								tradename = bean.getTradeNameForNewEntry(encounter_id,sch_date_time,drug_code);
							}
							if(admindrugdetails != null){
								stadmindrugdetails = new StringTokenizer(admindrugdetails,":");
								while(stadmindrugdetails.hasMoreTokens()){
									admin_drug_code = stadmindrugdetails.nextToken();
									if(stadmindrugdetails.hasMoreTokens())
										admin_drug_desc = stadmindrugdetails.nextToken();
									if(stadmindrugdetails.hasMoreTokens())
										admin_dose_prn  = stadmindrugdetails.nextToken();	 
									if(stadmindrugdetails.hasMoreTokens())
										stadmindrugdetails.nextToken();
								}
							}
							if(remarks==null){
								remarks="Not Entered";
							}
							admin_by_name = (String)admin_drug_details.get(25);
							auth_by_name  = (String)admin_drug_details.get(31);
							freq_code	  = (String)admin_drug_details.get(33);
							freq_nature	  = (String)admin_drug_details.get(34)==null?"":(String)admin_drug_details.get(34);
							/*if(!locale.equals("en")){ 
								//sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");//Commented ofr SKR-SCF-0997 [IN:048677]
								current_date_time = com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM","en",locale);//Added ofr SKR-SCF-0997 [IN:048677]  
							//} */ // Commented for TTM-SCF-0185-974750 [IN:066489]
							//|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DD") ,("DE") ADDED FOR MMS-KH-CRF-0014
							if(!customer_id.equals("ALMO") && verify_adm_drug && iv_prep_yn.equals("") && (admin_bean.gethold_discontinue(order_id, order_line_num).equals("DF") || admin_bean.gethold_discontinue(order_id, order_line_num).equals("DP")|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DD")|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DE"))){  // Added for AAKH-CRF-0084 [IN060429] and //added && !customer_id.equals("AMOL") for MMS-DM-SCF-0442
							     if(!customer_id.equals("ALNA"))//Added if condition Alone for NMC-JD-SCF-0325
						 		    medn_admn_dtl_reqd_yn = "Y";
						    }
							if (admin_bean.compareDates(sch_date_time,adminFromDateTime) && !(freq_nature.equals("P")))
								medn_admn_dtl_reqd_yn = "Y";
							
							if(defaultDate.equals("") && freq_nature.equals("P")){ //&& !sch_date.equals(""))
								defaultDate = sch_date_time;
								if(com.ehis.util.DateUtils.isBefore( AdminBackLogTime, start_date_time,  "DMYHM", locale))
									AdminBackLogTime = start_date_time;
								if(com.ehis.util.DateUtils.isBefore( AdminBackLogTime, sch_date+" 00:00",  "DMYHM", locale))
									AdminBackLogTime = sch_date+" 00:00";
								//if(com.ehis.util.DateUtils.isAfter( current_date_time, sch_date+" 23:59", "DMYHM", locale))
								current_date_time = sch_date+" 23:59";
								if(com.ehis.util.DateUtils.isBefore( current_date_time, sch_date+" 00:00", "DMYHM", locale))
									current_date_time = sch_date+" 23:59";
								if(com.ehis.util.DateUtils.isAfter( current_date_time, adminToTime, "DMYHM", locale))
									current_date_time = adminToTime;
								//defaultDate = sch_date+ current_date_time.substring(current_date_time.indexOf(" "), current_date_time.length());
							}
							showTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name;
							if(auth_by_name!=null && !auth_by_name.equals("")){
								showTitle =showTitle + "\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name ;
							}

							admin_date_time = "";
							if(admin_drug_details.get(26)!= null){
								admin_date_time = (String)admin_drug_details.get(26);
								if(!locale.equals("en"))
									admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
							}
								
							modified_date_time = "";
							if(admin_drug_details.get(27)!= null){
								modified_date_time = (String)admin_drug_details.get(27);
							}
							if(iv_prep_yn.equals("9") && i==0){ //JD-CRF-0200 - start
							 onco_modified_date_time = modified_date_time;
							 onco_dosage_seq_no = dosage_seq_no;
							}
							if(iv_prep_yn.equals("9") && i==1){
								 modified_date_time = onco_modified_date_time ;
								 dosage_seq_no = onco_dosage_seq_no;
							} ////JD-CRF-0200 -end
							if( freq_nature.equals("O")) 
								stat_style	=	"background-color:#CE00CE";
							else if( freq_nature.equals("P"))
								stat_style	=	"background-color:#804040";
							else 
								stat_style	=	"";

							expiry_date = expiry_date.trim();

							alt_drug			=	bean_all_stages.checkMultiStrength(drug_code);
							bean_all_stages.addDrugs(patient_id,patient_id,drug_code,alt_drug,order_line_num);	

							tot_alt_qty       = 0.0f;
							for(int n=0; n<multi_drugs.size(); n+=5){ 
								tot_alt_qty += Float.parseFloat((String)multi_drugs.get(n+3));
							}

							displayStyle		=	"";
							statusFlag		=	"YES";
							addDisplayStyle	=	"";
							checked			=	"";
							select_status_1			=   "";

							if(admin_discontinue.equals("Y")){
								admin_disc_classValue = "background-color:#ffa8a8";
								medn_admn_dtl_reqd_yn = "Y";
							}
						   if(future_admin.equals("F") && adminOption.equals("AD")){ // Added for GHL-CRF-0482 - Start
							    medn_admn_dtl_reqd_yn = "Y";
						   }
						   else if(future_admin.equals("F") && !adminOption.equals("AD")){
						    	future_admin = "";
						    } // Added for GHL-CRF-0482 - End

							if(medn_admn_dtl_reqd_yn.equals("Y")) 
								mand_display	=	"style='display:inline'";
							else
								mand_display	=	"style='display:none'";

							select_status	=	"";
							dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
							if(freq_code!=null && freq_code.equals("STAT")) {
								displayStyle	=	"background-color:#CE00CE;";
							}
							else if(dis_continued.equals("Y")){
								displayStyle = "BACKGROUND-COLOR:red;";
							}
							else if(hold.equals("Y")){
								displayStyle = "BACKGROUND-COLOR:yellow;";
							}
							else if(admin_recorded_yn.equals("Y")){
								if(administered.equals("N")) {
									displayStyle = "BACKGROUND-COLOR:#000000;";
								} 
								else{  
									displayStyle = "BACKGROUND-COLOR:green;";
									batch_ids	= new ArrayList();
								}
							}
							verbalOrder="";	
							if((bean.getPractitionerType(pract_id)).equals("NS")){
								verbalOrder="<b>V<b>";
							}
							showAlt = "";
							if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
								showAlt	 = ("Ordered Drug : "+drug_desc+"\n");
								showTitle = showAlt + showTitle;
								displayStyle = "BACKGROUND-COLOR:#CC99CC;";
							}

							if( drug_class.equals("N")){
								drug_class_ind = "background:#66FFFF";
							}
							else if( drug_class.equals("C")){
								drug_class_ind = "background:#CCFFCC";
							}
							else if(iv_prep_yn.equals("6")){
								drug_class_ind = "background:#E4CAFF";
							}
							else{
								drug_class_ind = "";
							}

							adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
										
							adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;									

							if(!admin_date_time.equals("")){
								img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
							}

							if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N")){
								remarks_style	=	"style='visibility:hidden'";
							}
							else{
								dialog_height = 0 ;
								if(!prn_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!drug_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!pres_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!slidingscaleremarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!verificationremarks.trim().equals(""))
									dialog_height	 += 6.5;
					
								if(show_remarks.equals("Y"))
									dialog_height	 += 13;
					
								remarks_style	=	"style='visibility:visible'";
								dialog_height	 += 1.4;
							}												
							if(sliding_scale_applicable.equals("Y")){
								sliding_scale_details=bean.getSlidingScaleTemplateDetails(order_id,order_line_num);
								AdUOM="";
								if(sliding_scale_details.size()>0){
									AdUOM=(String)sliding_scale_details.get(6);
								}
							}
							//added for GHL-CRF-0482 - start	
							if(patient_stock_required!=null && patient_stock_required.equals("Y") && iv_prep_yn.equals("")){
								//HashMap drugMap = bean.getOrderIdListForSameDrug();
								//ArrayList orderIdList = (ArrayList)drugMap.get(disp_drug_code);
					
							//if(patient_stock_yn.equals("Y")){
//								batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,disp_drug_code);
							//}else{
								batchIdforOrders = bean.getBatchIdForOrders();
								if(batchIdforOrders!=null && batchIdforOrders.containsKey(disp_drug_code)){
									int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);

									if(rec_count>0 || patient_stock_yn.equals("Y"))
										batch_ids = (ArrayList)batchIdforOrders.get(disp_drug_code);
									else
										batch_ids = new ArrayList();
									//System.err.println("MARSchLevelDrugAdmin.jsp=======batch_ids====1425===>"+batch_ids);
								}else{
									int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);

									if(rec_count>0 || patient_stock_yn.equals("Y"))
										batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,disp_drug_code);
									else
										batch_ids = new ArrayList();
									}
							//	}
							}else{	
								batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");	
							}
							//added for GHL-CRF-0482 - end
							alt_drug_display="display:none";						//Added for Bru-HIMS-CRF-399 [IN:043767] start
							arrAltDrugs = bean_all_stages.getAlternateDrugs(drug_code,generic_id);
							if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){
								alt_drug_display="display:inline";					//Added for Bru-HIMS-CRF-399 [IN:043767] end
								alt_flag = true;
							}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(statusFlag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Auto_Admin));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_pract_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(future_admin));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);

								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {


            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block74Bytes, _wl_block74);

								}

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
				
								if(ext_prod_id!=null && !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1))&& !(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block80Bytes, _wl_block80);

								}
								if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block82Bytes, _wl_block82);

								}
								if(adr_count>0){

            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block85Bytes, _wl_block85);

								} 
								if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
						
								}
								if(iv_prep_yn.equals("7") && ppn_count >0){

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
	
								}

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(alt_drug_display));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
								if(dispensed_drug_desc==null || dispensed_drug_desc.equals(""))//Added for Bru-HIMS-CRF-399 [IN:043767]
									disp_drugs="";

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block72Bytes, _wl_block72);

								if(linkVacScheduleYN.equals("Y")){ 
									if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block110Bytes, _wl_block110);

									}
								}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
  
								if(iv_prep_yn.equals("8")){ 

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

								}
								if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){	

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

								}
								else if(iv_prep_yn.equals("6")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

								}
								else if(!iv_prep_yn.equals("8")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

								}

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block125Bytes, _wl_block125);
								
								if(sliding_scale_applicable.equals("Y") && sliding_scale_details.size()>0){								
									rangeUOM=(String)sliding_scale_details.get(5);

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rangeUOM));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(AdUOM));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(AdUOM));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rangeUOM));
            _bw.write(_wl_block72Bytes, _wl_block72);

									for(int sl=0;sl<sliding_scale_details.size();sl+=7){
										sl_srl_no=(String)sliding_scale_details.get(sl+1);
										sl_rg_fro=(String)sliding_scale_details.get(sl+2);
										sl_rg_to=(String)sliding_scale_details.get(sl+3);
										sl_adm_qty=(String)sliding_scale_details.get(sl+4);

            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sl_rg_fro));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sl_rg_to));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sl_adm_qty));
            _bw.write(_wl_block72Bytes, _wl_block72);

									}

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block72Bytes, _wl_block72);

								}
								else{
									if(dosage==null || dosage.equals(""))
										dosage = "0";
									if(!split_dose_yn.equals("Y") && !freq_nature.equals("P") ){ //added for ML-MMOH-SCF-1439 and !freq_nature.equals("P") added for SKR-SCF-1534
									if(Float.parseFloat(qty)!=Float.parseFloat(dosage))
										qty = dosage;

									}else{
										if(split_dose_yn.equals("Y")){
										qty = bean.getSplitDosage(order_id,order_line_num,sch_date_time.split(" ")[1]);
										}
									}
									if(freq_nature.equals("P")){													
										if(!dosage_seq_no.equals("2")){ 
											dosage=sch_strength_value_prn;
											dosage_uom_code=sch_strength_uom_prn;
											dosage_uom_desc=dosage_uom_desc;
										}	
										if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){
											ArrayList listArray=bean.getAlternateDrugsEqualQuantity(dosage,drug_code,disp_drug_code);
											if(listArray!=null && !alt_flag){
								
												dosage=(String)listArray.get(0);
												dosage_uom_desc=(String)listArray.get(1);
											}
										}
										
										non_iv_admin_quaty="";
										if(dosage_type.equals("S")){
											strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
											non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
											if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
												non_iv_admin_quaty=qty;
											}
											dosage = pres_dosage;
										}
										else{
											non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
											if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
												non_iv_admin_quaty=qty;
											}
											dosage = pres_dosage;
										}
										if(Float.parseFloat(dosage) < 1.0){
											dosage = Float.parseFloat(dosage)+"";
										}//BRU-CRF-0399.1 - start	
								if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9 && !alt_flag){//changed 7 to 9 for GHL-CRF-0482 and !alt_flag added for ML-MMOH-SCF-1761
									String alt_dos_detail1= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
									if(alt_dos_detail1.indexOf("~")!=-1){
								if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 & { added for ML-MMOH-SCF-1767
									dosage = alt_dos_detail1.split("~")[0];
									dosage_uom_code = alt_dos_detail1.split("~")[1];
									dosage_uom_desc = alt_dos_detail1.split("~")[2];
								}
									disp_with_alt= true;
								} //BRU-CRF-0399.1 - end
										}	

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strength_value_prn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(content_in_pres_base_uom));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp_with_alt));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);

										String sch_dosage_qty	= (String)admin_drug_details.get(85);//Added for ML-MMOH-SCF-1964
										/*if(qty!=null && !qty.equals("") && freq_nature.equals("P")){//Commented for ML-MMOH-SCF-1964
											qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
										    }*/
											//Adding start for ML-MMOH-SCF-1964
										if(sch_dosage_qty!=null && !sch_dosage_qty.equals("") && freq_nature.equals("P")){
											 qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));
										}else if(qty!=null && !qty.equals("") && freq_nature.equals("P")){
											 qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
										}//Adding end for ML-MMOH-SCF-1964
											int len= qty.length();
											if( len > 0 ){
												temp = qty;
												int point= temp.indexOf(".")+1;
												if(temp.charAt(point)=='0')
													qty = qty.substring(0,point-1);
												else{//added for SKR-SCF-1429 - start
													if(Float.parseFloat(qty)>1){ 
													if(temp.charAt(point)=='6' || temp.charAt(point)=='7' || temp.charAt(point)=='8' || temp.charAt(point)=='9'){
													 qty = Math.ceil(Float.parseFloat(qty))+"";
													}
													}
												} //added for SKR-SCF-1429 - end
											}
											if(dosage_type.equals("S")){ 

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(qty));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block72Bytes, _wl_block72);

										}
										else{

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(qty));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block72Bytes, _wl_block72);
										
										}	
									} 
									else{ 
										if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){
											ArrayList listArray = bean.getAlternateDrugsEqualQuantity(qty,drug_code,disp_drug_code);				//System.err.println("MARSchLevelDrugAdmin.jsp=960===>"+listArray);		
											
													if(listArray!=null && !alt_flag){
														qty=(String)listArray.get(0);
														short_desc=(String)listArray.get(1);
													}
										}
										  if(Float.parseFloat(qty) < 1.0){
												//qty = dfTest.format(Float.parseFloat(qty)); //commented for ML-MMOH-SCF-1674
												 if(qty.indexOf(".")!=-1){ //added for ML-MMOH-SCF-1674
													String f_qty = qty.substring(qty.indexOf("."),qty.length());
													if(f_qty.length()>8)
														qty = dfTest.format(Float.parseFloat(qty));
													   
													 qty =Float.parseFloat(qty)+"";
													}					 //ended for ML-MMOH-SCF-1674
										}
										if(admin_recorded_yn.equals("Y") && administered.equals("N"))
											qty = dosage;
										//BRU-CRF-0399.1 - start	
										if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9 && !alt_flag){//changed 7 to 9 for GHL-CRF-0482 and !alt_flag added for ML-MMOH-SCF-1761
											String alt_dos_detail= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
											if(alt_dos_detail.indexOf("~")!=-1){
											if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 { added for ML-MMOH-SCF-1767
												qty = alt_dos_detail.split("~")[0];
										
											uom_code = alt_dos_detail.split("~")[1];
											short_desc = alt_dos_detail.split("~")[2];
											}
											}
										}//BRU-CRF-0399.1 - end

            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block72Bytes, _wl_block72);

									}								
								}				

            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block196Bytes, _wl_block196);

								if(freq_nature.equals("P")){

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block198Bytes, _wl_block198);

								}
								else{
								if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
								ArrayList Mfr_Details=bean.getStatusOfMAR(order_id,"");
								String statusString = "";
							if(Mfr_Details.size()>0){
								statusString=(String)Mfr_Details.get(0);
								mfrCompletedStatus=new Boolean((String)Mfr_Details.get(1)).booleanValue();														
							}
							if(!mfrCompletedStatus ){// if added for ml-mmoh-crf-1014
								select_status="disabled";
							}
							
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(order_line_num.equals("1")){
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
}else{
            _bw.write(_wl_block210Bytes, _wl_block210);
}
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block72Bytes, _wl_block72);
						}else{//ML-MMOH-CRF-1014- end

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block214Bytes, _wl_block214);

					}
								}

            _bw.write(_wl_block215Bytes, _wl_block215);
 AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time);  
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(admin_disc_classValue));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(admin_disc_classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            _bw.write(_wl_block226Bytes, _wl_block226);
							
								if(!patient_brgt_medn.equals("Y")){										
									if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0)){		
										if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")||iv_prep_yn.equals("8")){

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(1)));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(1)));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(2)));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block246Bytes, _wl_block246);
					
										}
										else if(batch_ids.size()==0){
												
											if(Storelocn_code.equals(""))
												Storelocn_code=Store_locn_code;
											if(Auto_Admin.equals("N"))
												auto_Admin_dis="disabled";
											else 
												auto_Admin_dis="";
											bat_id_lookbutton_enabled="Y";
											if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled")){
												bat_id_lookbutton_enabled="N";
											}
											if(iv_prep_yn.trim().length()!=0)
												shared_drug_disp = "display:none";

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bat_id_lookbutton_enabled));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(verify_adm_drug));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block125Bytes, _wl_block125);
                                          
                                            if(verify_adm_drug){ // if,else Added for AAKH-CRF-0084 [IN060429] 

            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(verify_adm_drug));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(shared_drug_disp));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block255Bytes, _wl_block255);
                                          
                                            } else{ 

            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(shared_drug_disp));
            _bw.write(_wl_block110Bytes, _wl_block110);

                                            } 

            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Storelocn_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block281Bytes, _wl_block281);

										}
										else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482
											expiry_date = (String)batch_ids.get(1);
											trade_id    = (String)batch_ids.get(2);
											tradename   = (String)batch_ids.get(3);
											select_status="disabled";

            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block283Bytes, _wl_block283);
											
											totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,adminFromDateTime,adminToTime,order_id,order_line_num);
											for(int j=0;j<totQty.size();j=j+4){
												returned_qty = (Float)totQty.get(j+2);
												tot_administered_qty=  (Float)totQty.get(j+3);
											} 
											WardReturnQty =(ArrayList)bean.getWardRetrunQty(patient_id,order_id,performingDeptLocCode,facility_id);
											
											for(int k=0;k<WardReturnQty.size();k=k+2){
												disp_qty =(Float)WardReturnQty.get(k);
												ward_return_qty =(Float)WardReturnQty.get(k+1);
											}
											ret_qty=disp_qty-(returned_qty+ward_return_qty+tot_administered_qty);
											if(ret_qty<=0){

            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);
 
											}
											else{
												expiry_date="";
												select_status="";

            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);

											} 
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(7)));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(8)));
            _bw.write(_wl_block300Bytes, _wl_block300);
										}
										else{

            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(verify_adm_drug));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block310Bytes, _wl_block310);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

											for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482
												if (defaultBatch.equals((String)batch_ids.get(kk))){

            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);

												}
												else{

            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block317Bytes, _wl_block317);

												}
											}

            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block321Bytes, _wl_block321);

										}
											int mm=1;
						//added for BRU-CRF-399.1 - start
						for(int kk=0;kk<batch_ids.size();kk=kk+9){ //6 to 7 for GHL-CRF-0458 //changed 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk+5)));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk+4)));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk+7)));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)batch_ids.get(kk+8)));
            _bw.write(_wl_block330Bytes, _wl_block330);
							mm++;//CRF-399.1

					

						}

            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block339Bytes, _wl_block339);

									} 
									else{

            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block349Bytes, _wl_block349);

									}
								}
								else{								

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block357Bytes, _wl_block357);

								}

            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(defaultTradeId.equals("")?tradename:defaultTradeId));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block366Bytes, _wl_block366);

								if(!stat_style.equals("") && freq_nature.equals("O")){
									stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.STATDose.label", "ph_labels")+"'";
								}
								else if(!stat_style.equals("") && freq_nature.equals("P")){
									stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PRNDose.label", "ph_labels")+"'";
								}
								else{
									stat_title	=	"";
								}
								if(patient_brgt_medn.equals("Y")){
									mand_display="style='display:inline'";	
								}

            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(stat_style));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(stat_title));
            _bw.write(_wl_block367Bytes, _wl_block367);

								if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(dtl_style));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(admin_discontinue));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(mand_display));
            _bw.write(_wl_block378Bytes, _wl_block378);

								}
								else{ 	
									if(mand_display.equals("style='display:inline'")){

            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block380Bytes, _wl_block380);

									}
								}

            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block385Bytes, _wl_block385);

							//added for GHL-CRF-0482 - start
									if(isSite_spec_patient_stock){
								
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(patient_stock_completed));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(patient_stock_checked));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(patient_stock_check_display));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(patient_stock_disabled));
            _bw.write(_wl_block394Bytes, _wl_block394);
}
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mand_display));
            _bw.write(_wl_block397Bytes, _wl_block397);

								if(sliding_scale_applicable.equals("Y") && batch_ids.size()==0){	
									select_status_1="disabled";
								}
								String fieldname="non_iv_admin_qty_"+recCount;
								String short_desc1=short_desc;
								if(freq_nature.equals("P")){
									fieldname   = "non_iv_admin_qty1_"+recCount;
									short_desc1 = schedule_uom_desc; 
									pres_dosage = tempDosage;
								}

            _bw.write(_wl_block398Bytes, _wl_block398);

								altRecCount=0;
								if( multi_drugs.size()>0){
									no_of_alt_drus_selected ++;
								if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
									shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
								else
									shared_drug_disp = "";
									for(int n=0; n<multi_drugs.size(); n+=5){ 
										altRecCount++;
										String alt_drug_code			=	(String)multi_drugs.get(n);
										String alt_drug_desc			=   (String)multi_drugs.get(n+1);
										String alt_qty=(String)multi_drugs.get(n+3);
										String alt_qty_uom =(String)multi_drugs.get(n+4);
										ArrayList alt_batch_ids = bean.getAllBatchIDS(order_id,order_line_num,"N");
										String alt_expiry_date = "";
										String alt_trade_id	   = "";
										String alt_trade_name  = "";

            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(alt_qty_uom));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_qty_uom));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);

											if(alt_batch_ids.size()==0){

            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(shared_drug_disp));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultBatch));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block455Bytes, _wl_block455);

											}
											else if(alt_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8//changed 7 to 9 for GHL-CRF-0482
												alt_expiry_date = (String)alt_batch_ids.get(1);
												alt_trade_id    = (String)alt_batch_ids.get(2);
												alt_trade_name  = (String)alt_batch_ids.get(3);

            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf((String)alt_batch_ids.get(0)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)alt_batch_ids.get(0)));
            _bw.write(_wl_block459Bytes, _wl_block459);

											}
											else{

            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block466Bytes, _wl_block466);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

												for(int kk=0;kk<alt_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8//changed 7 to 9 for GHL-CRF-0482
													if (defaultBatch.equals((String)alt_batch_ids.get(kk))){

            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block317Bytes, _wl_block317);

													}
													else{

            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block317Bytes, _wl_block317);

													}
												}

            _bw.write(_wl_block469Bytes, _wl_block469);

											}

            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(alt_expiry_date));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(alt_trade_name));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_trade_id));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(admin_discontinue));
            _bw.write(_wl_block488Bytes, _wl_block488);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block494Bytes, _wl_block494);
	
									}
								}

            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block499Bytes, _wl_block499);

						}

            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(isSite_spec_patient_stock));
            _bw.write(_wl_block72Bytes, _wl_block72);
						}
					}
					else if(callFrom.equals("adminIV")){
						drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,drugCode,hold_discontinue_yn,"","IVRx","","","",patient_id,"");
						ArrayList iv_drug_details = null;
						if(drug_details!=null){
							iv_drug_details =	 (ArrayList) drug_details.get("IV");
						}
						if(iv_drug_details!=null && iv_drug_details.size()>0){

            _bw.write(_wl_block501Bytes, _wl_block501);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block502Bytes, _wl_block502);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block503Bytes, _wl_block503);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block505Bytes, _wl_block505);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block506Bytes, _wl_block506);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block507Bytes, _wl_block507);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block507Bytes, _wl_block507);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block508Bytes, _wl_block508);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block509Bytes, _wl_block509);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block511Bytes, _wl_block511);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block512Bytes, _wl_block512);

								String sch_infusion_rate        =   "";
								String sch_infusion_vol_str_unit=   "";
								String sch_infusion_vol_str_unit_desc =   "";
								String sch_infusion_per_unit    =   "";
								String sch_infusion_per_unit_table_date = "";
								String trade_name               =   "";
								String qty_uom					=   "";
								String sch_infusion_period		=   "";
								String sch_infusion_period_unit =   "";
								String sch_infusion_period_unit_label =   "";
								classvalue						=	"";
								String unit_dose				=   "";
								String no_of_doses				=   "";
								dosage_seq_no			        =   "";
								String hide_ingredient_dtls		=   "";
								iv_prep_yn						=	"";
								String prod_name				=	"";
								String cmp_flag                 =   "";
								String sch_infusion_in_min      =   "";
								String tol_title                =   "";
								String iv_no_of_drug_per_order  =   "1";
								String MfrYN					=	"N";
								String sfrFLOW_STATUS			=	"";
								String sfrHOLD_DATE_TIME		=	"";
								String sfrHOLD_DURN_IN_MINS		=	"";
								String sfrRESUME_DATE_TIME		=	"";
								String sfrACT_START_DATE_TIME	=	"";
								String sfrACT_END_DATE_TIME		=	"";
//								String mfrRemarks				=	"";
								String completedMinutes			=	"0";
								String completedFlow			=	"0";
								String iv_order_pract_id        =""; 
										dosage_type				=	"";
								String sch_dosage_uom_code		= "";//SKR-SCF-1240
		//						boolean mfrCompletedStatus		=	false;
								ArrayList MfrDetails			=	new ArrayList();
//								ArrayList arr_list_remarks		=   new ArrayList();
								ArrayList work_sheet_batch_det	=   new ArrayList();
								String could_not_administer="";
								ArrayList iv_batch_ids = new ArrayList();
								for(int i=0;i<iv_drug_details.size();i+=74){//Changed from 69 to 70 for SKR-SCF-0832[Inc : 44110] 73 CHANGED TO 74
									iv_order_pract_id  =  (String)iv_drug_details.get(i+68)==null?"":(String)iv_drug_details.get(i+68); 
									linkVacScheduleCode			="";
									dosage_seq_no	= iv_drug_details.get(i+36)==null?"":(String)iv_drug_details.get(i+36); 
									pres_catg_code =iv_drug_details.get(i+49)==null?"":(String)iv_drug_details.get(i+49); 
									auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
									auth_reqd_script="";
									if(auth_reqd){
										if(pin_value.equals(""))
											auth_reqd_script=";pinAuthentication(this,'NP');";
										else
											auth_reqd_script=";pinAuthentication(this,'YP');";
									}
									pract_id					= (String)iv_drug_details.get(i+37);
									against_sch_date			= (String)iv_drug_details.get(i+38);
									adr_reason					= (String)iv_drug_details.get(i+39);
									adr_remarks					= (String)iv_drug_details.get(i+40);
									adr_record_time				= (String)iv_drug_details.get(i+41);
									adr_recorded_by				= (String)iv_drug_details.get(i+42);
									iv_prep_yn					= (String)iv_drug_details.get(i+43);	
									freq_nature					= (String)iv_drug_details.get(i+35);
									flag						=	"Y";
									sch_infusion_rate			= (String)iv_drug_details.get(i+1);
									if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
										if(Float.parseFloat(sch_infusion_rate) < 1.0){ //added for IN25540 --20/12/2010-- priya
											sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
										}
									}
									sch_infusion_vol_str_unit	= (String)iv_drug_details.get(i+2)==null?"":(String)iv_drug_details.get(i+2);
									sch_infusion_vol_str_unit_desc = (String)iv_drug_details.get(i+66)==null?"":(String)iv_drug_details.get(i+66);
									sch_infusion_per_unit		= (String)iv_drug_details.get(i+3)==null?"":(String)iv_drug_details.get(i+3);																	if(adr_remarks ==null)
										adr_remarks ="";						
									route_desc					= (String)iv_drug_details.get(i+48);
									route_color                 = (String)iv_drug_details.get(i+67);//COde Check for ROute COlor
									if(route_color != "" && route_color != null && route_color.length()==12){
										fntColor = route_color.substring(0, 6);
										backGrndColor = route_color.substring(6, 12);
									}//Code Addd For RUT-CRF-0034 End
									patient_id					= (String)iv_drug_details.get(i+9);
									sch_infusion_per_unit_table_date = sch_infusion_per_unit;
														
									if(sch_infusion_per_unit.equals("H")){
										sch_infusion_per_unit = "Hrs";
										if(sch_infusion_rate!=null && !(sch_infusion_rate.equals(""))){												
											sch_infusion_in_min=roundDigits(Float.parseFloat(sch_infusion_rate)/60.0+"");
										}
										tol_title=sch_infusion_in_min+"&nbsp;ML/Minute"; 
									}
									else{
										sch_infusion_per_unit = "Mins";
										tol_title="";
									}
									batch_id                 =   (String)iv_drug_details.get(i+4)==null?"":(String)iv_drug_details.get(i+4);
									expiry_date              =   (String)iv_drug_details.get(i+5)==null?"":(String)iv_drug_details.get(i+5);
									trade_id                 =   (String)iv_drug_details.get(i+6)==null?"":(String)iv_drug_details.get(i+6);
									trade_name               =   (String)iv_drug_details.get(i+7)==null?"":(String)iv_drug_details.get(i+7);
									item_code                =   (String)iv_drug_details.get(i+8);
									drug_code                =   (String)iv_drug_details.get(i+10);
									drug_desc                =   (String)iv_drug_details.get(i+11);
									sch_date_time            =   (String)iv_drug_details.get(i+12);
									dosage_seq_no            =   (String)iv_drug_details.get(i+13);
									order_id                 =   (String)iv_drug_details.get(i+14);
									order_line_num           =   (String)iv_drug_details.get(i+15);
									qty						 =	 (String)iv_drug_details.get(i+16);
									if(Float.parseFloat(qty) < 1)
										qty="0"+qty; 
									qty_uom					 =	 (String)iv_drug_details.get(i+17);
									dis_continued			 =	 (String)iv_drug_details.get(i+18);
									hold					 =	 (String)iv_drug_details.get(i+19);
									sch_infusion_period		 =	 (String)iv_drug_details.get(i+20)==null?"":(String)iv_drug_details.get(i+20);	
									sch_infusion_period_unit =	 (String)iv_drug_details.get(i+21)==null?"":(String)iv_drug_details.get(i+21);
									administered			 =	 (String)iv_drug_details.get(i+22)==null?"N":(String)iv_drug_details.get(i+22);
									store_code				 =   (String)iv_drug_details.get(i+30);
									end_date_time 			 =   (String)iv_drug_details.get(i+33);
									freq_code				 =   (String)iv_drug_details.get(i+34);				
									
								if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_num.equals("1")))) //SKR-SCF-1397 and iv_prep_yn.equals("1") added for SKR-SCF-1421
									no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num,iv_prep_yn,drug_code);
								else
									no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num);
									encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
									encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
									encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
									ext_prod_id              =   (String)iv_drug_details.get(i+44);
									iv_no_of_drug_per_order  =   (String)iv_drug_details.get(i+45);
									trade_code			     =   (String)iv_drug_details.get(i+46);
									imageFileURL			 =   (String)iv_drug_details.get(i+47);
									admn_dose_chng_reason_code = (String)iv_drug_details.get(i+52);
									sch_dosage_uom_code		 =	 (String)iv_drug_details.get(i+51); //SKR-SCF-1240
									Store_locn_code			 =	(String)iv_drug_details.get(i+65)==null?"":(String)iv_drug_details.get(i+65);
									 String iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
									cmp_flag				 =   bean.syscomp(end_date_time,order_id,order_line_num);
									next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
									linkVacScheduleCode		 =	(String)iv_drug_details.get(i+53);
									MfrYN					 =	(String)iv_drug_details.get(i+54)==null?"N":(String)iv_drug_details.get(i+54);
									sfrFLOW_STATUS			 =	(String)iv_drug_details.get(i+55)==null?"NS":(String)iv_drug_details.get(i+55);
									sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(i+56)==null?"":(String)iv_drug_details.get(i+56);
									sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(i+57)==null?"0":(String)iv_drug_details.get(i+57);
									sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(i+58)==null?"":(String)iv_drug_details.get(i+58);
									sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(i+59)==null?"":(String)iv_drug_details.get(i+59);
									//Added IF-Condition for converting date on 8/10/2010 regarding incident num:24067.==By Sandhya
									dispense_drug_code			= (String)iv_drug_details.get(i+72); //added for SKR-SCF-1240
									if(dispense_drug_code.equals("")) //added for SKR-SCF-1240
										dispense_drug_code = drug_code;
									if(!(sfrACT_START_DATE_TIME.equals(""))){
										sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
									} //Ends
									if(sfrACT_START_DATE_TIME.equals("")){
										sfrACT_START_DATE_TIME=current_date_time;
									
									}
									sfrACT_END_DATE_TIME	 =	(String)iv_drug_details.get(i+60)==null?"":(String)iv_drug_details.get(i+60);
									dosage_type				 =	(String)iv_drug_details.get(i+61)==null?"":(String)iv_drug_details.get(i+61);
									mfrRemarks				 =	(String)iv_drug_details.get(i+62)==null?"":(String)iv_drug_details.get(i+62);
									completedMinutes		 =	(String)iv_drug_details.get(i+63)==null?"0":(String)iv_drug_details.get(i+63);
									completedFlow			 =	(String)iv_drug_details.get(i+64)==null?"0":(String)iv_drug_details.get(i+64);
									adr_count			= bean.getADRCount(patient_id,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 

									if(!mfrRemarks.equals(""))
										mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
									String sfrFLOW_STATUS_String="";
									String sfrFLOW_STATUS_disable="";
									String sfrFLOW_STATUS_style="";

									if(sfrFLOW_STATUS.equals("NS")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NOTSTARTED.label","ph_labels");
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("ST")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("HO")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOLD.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";

									}
									else if(sfrFLOW_STATUS.equals("RE")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("CO")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.COMPLETED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:black;align:center;cursor:pointer;";
									}
									if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
										linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
										if(!linkVacScheduleCode1.equals("NO DEFAULT")){
											try{
												linkVacScheduleYN="Y";
												vacScheduleDetails=linkVacScheduleCode.split("~",6);
												if(vacScheduleDetails.length>0){
													linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
													linkVacScheduleDescToolTip=vacScheduleDetails[3];
													linkVacScheduleDesc=vacScheduleDetails[4];
												}
											}
											catch(Exception execu){
												execu.printStackTrace();
											}
										}
										else{
											linkVacScheduleYN="Y";
											linkVacScheduleDescToolTip="";
											linkVacScheduleDesc="";
											vacScheduleDetails=linkVacScheduleCode.split("~");
											if(vacScheduleDetails.length>0){
												linkVacScheduleCode=vacScheduleDetails[1];
											}										
										}
									}
									else{
										linkVacScheduleYN="N";
										linkVacScheduleDescToolTip="";
										linkVacScheduleDesc="";
									}			
									select_status	=	"";
									dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";

									if(order_line_num != null && !order_line_num.equals("1"))
										hide_ingredient_dtls = "visibility:hidden;";
									else
										hide_ingredient_dtls = "";

									if(freq_nature!=null && freq_nature.equals("C")){
										if(!qty.equals("") && no_of_doses!= null && !no_of_doses.equals(""))
											unit_dose			 =  ((int)(Float.parseFloat(qty)/Float.parseFloat(no_of_doses)))+"";
									}

									if(freq_nature!=null && freq_nature.equals("O")) 
										stat_style	=	"background-color:#CE00CE";
									else
										stat_style	=	"";

									if(unit_dose!=null && unit_dose.equals("0"))
										unit_dose = "1";

									admin_recorded_yn		 = "Y";
									if(iv_drug_details.get(i+23)==null)
										admin_recorded_yn = "N";
									remarks = (String)iv_drug_details.get(i+24);				
									if(remarks==null)
										remarks="Not Entered";

									admin_by_name   = (String)iv_drug_details.get(i+26);
									auth_by_name    = (String)iv_drug_details.get(i+32);
									showTitle       = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"  : "+admin_by_name;
									if(auth_by_name!=null && !auth_by_name.equals(""))
										showTitle = showTitle + "\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name;
									admin_date_time = "";
									if(iv_drug_details.get(i+27)!= null)
										admin_date_time = (String)iv_drug_details.get(i+27);
									modified_date_time = "";
									if(iv_drug_details.get(i+28)!= null)
										modified_date_time = (String)iv_drug_details.get(i+28);				
									drug_class = (String)iv_drug_details.get(i+31);
									if(drug_class!=null && drug_class.equals("N"))
										drug_class_ind = "background:#66FFFF";
									else if(drug_class!=null && drug_class.equals("C"))
										drug_class_ind = "background:#CCFFCC";
									else
										drug_class_ind = "";
									if(sch_infusion_period_unit.equals("H"))
										sch_infusion_period_unit_label = "Hrs";
									else if(sch_infusion_period_unit.equals("M"))
										sch_infusion_period_unit_label = "Mins";
									displayStyle = "";
									if(freq_code!=null && freq_code.equals("STAT")) //added by abdul for SCF# 5899
										displayStyle	=	"background-color:#CE00CE;";
									else if(dis_continued.equals("Y"))
										displayStyle = "BACKGROUND-COLOR:red;";
									else if(hold.equals("Y"))
										displayStyle = "BACKGROUND-COLOR:yellow;";
									else if(admin_recorded_yn.equals("Y")){
										if(administered.equals("N")){
											displayStyle = "BACKGROUND-COLOR:#000000;cursor:pointer;";//added for AAKH-CRF-0024 [IN:038260]
											could_not_administer = "Y";//added for AAKH-CRF-0024 [IN:038260]
										}
										else{
											displayStyle = "BACKGROUND-COLOR:green;";
											could_not_administer="";//added for AAKH-CRF-0024 [IN:038260]
										}
									}
									administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);
									administred_batch_id = administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");						
									disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID");	
									if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){	
										work_sheet_batch_det  =(ArrayList)bean.getProductName(order_id,order_line_num);
										prod_name	=	(String)work_sheet_batch_det.get(0);
										batch_id	=	(String)work_sheet_batch_det.get(1);								
										expiry_date	=	(String)work_sheet_batch_det.get(2);
										drug_code	= "FINAL PRODUCT";
									}
									else{
										prod_name	=	"";
										expiry_date=expiry_date.trim();
									 }
									adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
									adr_details	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+": " + com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+": "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+": "+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;

									if(!admin_date_time.equals("")){
										img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
									}
											
									pres_remarks			= bean.getPrescriptionInstructions(order_id);
									drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
									prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
									pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
									slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
									verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);							
									nonMfrFluidRemarks		= "";
									if(iv_prep_yn.equals("5")){
										nonMfrFluidRemarks		= bean_all_stages.getNonMFRfluidRemarks(order_id,order_line_num);
									}
									overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
									show_remarks			= "N";
									if(ext_prod_id!=null && !ext_prod_id.equals("")){										
										if(overridereason.size()>1)
										   show_remarks="Y";
									}
									else{									
										if(overridereason.size()>0)
											   show_remarks="Y";
									}
									
									int pres_size = pres_remarks.length();
									int pres_col=2;
									if(pres_size >239)
										pres_col = pres_size/120;
										
									int pharm_size = pharma_remarks.length();
									int pharm_col=2;
									if(pharm_size >239)
										pharm_col = pharm_size/120;
														
									if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N") && nonMfrFluidRemarks.equals("")){
										remarks_style	=	"style='visibility:hidden'";
									}
									else {
										dialog_height = 0 ;
										if(!prn_remarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!drug_remarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!pres_remarks.trim().equals(""))
											dialog_height	 +=6.5;
										if(!slidingscaleremarks.trim().equals(""))
											dialog_height	 +=6.5;
										if(!pharma_remarks.trim().equals(""))
											dialog_height	 += 1.6*pharm_col;
										if(!verificationremarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!nonMfrFluidRemarks.trim().equals(""))
											dialog_height	 += 7.0;
										if(show_remarks.equals("Y"))
											dialog_height	 += 13;
										remarks_style	=	"style='visibility:visible'";
										if(dialog_height==18) 
											dialog_height = dialog_height-2;
										if(dialog_height==11)
											dialog_height = dialog_height-1;
										if(dialog_height==12)
											dialog_height = dialog_height-1;
										if(dialog_height>18) 
											dialog_height = dialog_height-2;
							
										dialog_height	 += 1.4;
									} 
									iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
									if(order_line_num.equals("1"))
										classvalue="IVFLUID1";
									else
										classvalue="IVINGREDIENT1";

            _bw.write(_wl_block513Bytes, _wl_block513);
 
									if(order_line_num.equals("1")) {

            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block515Bytes, _wl_block515);

									}
									else {

            _bw.write(_wl_block516Bytes, _wl_block516);

									}	

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block545Bytes, _wl_block545);

									if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block547Bytes, _wl_block547);

									}
									else{

            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block550Bytes, _wl_block550);

									}

            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block552Bytes, _wl_block552);

									if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block80Bytes, _wl_block80);

									}
									if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block82Bytes, _wl_block82);

									}			
									if(adr_count>0){// added for RUT-SCF-0144 [IN:033371]  -- start

            _bw.write(_wl_block555Bytes, _wl_block555);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block85Bytes, _wl_block85);

									} // added for RUT-SCF-0144 [IN:033371]  -- end
									if(prod_name.length()==0){
										if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
															
										}
									}

            _bw.write(_wl_block557Bytes, _wl_block557);

									if(linkVacScheduleYN.equals("Y")){ 
										if(order_line_num.equals("1")){

            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block110Bytes, _wl_block110);

										}
									}

            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block568Bytes, _wl_block568);
   
									if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){	

            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
					
									}
									else{

            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
                 
									}
									if(freq_code.equals("STAT"))
										displayStyle="";
									if(Float.parseFloat(qty) < 1.0)
										qty = Float.parseFloat(qty)+""; //to prefix a zero
									if(MfrYN.equals("Y") && order_line_num.equals("1")){

            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block582Bytes, _wl_block582);

									}
									else{
										if((hold.equals("Y")) || dis_continued.equals("Y")){
											sfrFLOW_STATUS_disable="disabled";
										}
										if(!dis_continued.equals("Y"))
											displayStyle="";

            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block592Bytes, _wl_block592);

										if(freq_nature!=null && freq_nature.equals("C")){

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block596Bytes, _wl_block596);

										}
										else{

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block597Bytes, _wl_block597);

										}
									}
									if(order_line_num.equals("1")){   

            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block601Bytes, _wl_block601);
 if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(sfrFLOW_STATUS_style));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(sfrFLOW_STATUS_String));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block609Bytes, _wl_block609);
}
            _bw.write(_wl_block610Bytes, _wl_block610);

										backGrndColor="";
										fntColor ="";
									}
									else{

            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block515Bytes, _wl_block515);

									}
									if(MfrYN.equals("Y") && order_line_num.equals("1")){
										MfrDetails=bean.getStatusOfMAR(order_id,"");
										String statusString="";
										if(MfrDetails.size()>0){
											statusString=(String)MfrDetails.get(0);
											mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();														
										}
										if(!(hold.equals("Y")) && !(dis_continued.equals("Y"))){													

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(order_line_num.equals("1")){
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block614Bytes, _wl_block614);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
}
            _bw.write(_wl_block610Bytes, _wl_block610);

										} 
										else {
											mfrCompletedStatus=false;

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(order_line_num.equals("1")){
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block615Bytes, _wl_block615);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block601Bytes, _wl_block601);
}
            _bw.write(_wl_block610Bytes, _wl_block610);

										}

            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block625Bytes, _wl_block625);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block638Bytes, _wl_block638);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block640Bytes, _wl_block640);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block642Bytes, _wl_block642);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block644Bytes, _wl_block644);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block645Bytes, _wl_block645);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block646Bytes, _wl_block646);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block647Bytes, _wl_block647);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_dosage_uom_code));
            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block650Bytes, _wl_block650);

									}
									else{
										if(MfrYN.equals("Y") && !(order_line_num.equals("1"))){
											if(sch_infusion_rate==null || sch_infusion_rate.equals("null"))
												sch_infusion_rate="0";
											if(!(sch_infusion_rate.equals("")) && Float.parseFloat(sch_infusion_rate) < 1.0)
												sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block515Bytes, _wl_block515);

										}
										else{

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block651Bytes, _wl_block651);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block196Bytes, _wl_block196);

										}

            _bw.write(_wl_block652Bytes, _wl_block652);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block654Bytes, _wl_block654);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block655Bytes, _wl_block655);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block658Bytes, _wl_block658);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block660Bytes, _wl_block660);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block661Bytes, _wl_block661);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block662Bytes, _wl_block662);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block664Bytes, _wl_block664);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block625Bytes, _wl_block625);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block665Bytes, _wl_block665);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block666Bytes, _wl_block666);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block667Bytes, _wl_block667);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(sch_infusion_period_unit_label));
            _bw.write(_wl_block670Bytes, _wl_block670);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block671Bytes, _wl_block671);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block672Bytes, _wl_block672);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block673Bytes, _wl_block673);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block647Bytes, _wl_block647);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sch_dosage_uom_code));
            _bw.write(_wl_block674Bytes, _wl_block674);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block675Bytes, _wl_block675);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block676Bytes, _wl_block676);

							if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){

            _bw.write(_wl_block677Bytes, _wl_block677);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block679Bytes, _wl_block679);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block680Bytes, _wl_block680);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block681Bytes, _wl_block681);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)work_sheet_batch_det.get(2)));
            _bw.write(_wl_block682Bytes, _wl_block682);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block545Bytes, _wl_block545);
	
							}
							else{
								auto_Admin_dis="";						
								if(iv_batch_ids.size()==0){	
									if(iv_Auto_Admin.equals("N")||(hold.equals("Y")) || dis_continued.equals("Y"))
										auto_Admin_dis="disabled";
									else 
										auto_Admin_dis="";

            _bw.write(_wl_block683Bytes, _wl_block683);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block684Bytes, _wl_block684);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block685Bytes, _wl_block685);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block686Bytes, _wl_block686);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block694Bytes, _wl_block694);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block696Bytes, _wl_block696);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block697Bytes, _wl_block697);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block698Bytes, _wl_block698);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block699Bytes, _wl_block699);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block700Bytes, _wl_block700);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);

								}
								else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482

									expiry_date = (String)iv_batch_ids.get(1);
									trade_id	= (String)iv_batch_ids.get(2);
									trade_name  = (String)iv_batch_ids.get(3);
									auto_Admin_dis="disabled";
									totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
									for(int j=0;j<totQty.size();j=j+4){
										returned_qty = (Float)totQty.get(j+2);
										tot_administered_qty=  (Float)totQty.get(j+3);
										ret_qty=returned_qty-tot_administered_qty;							 
									}
									if(ret_qty<=0){					

            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block702Bytes, _wl_block702);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block703Bytes, _wl_block703);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block704Bytes, _wl_block704);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block705Bytes, _wl_block705);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block706Bytes, _wl_block706);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block707Bytes, _wl_block707);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);

									}
									else{
										expiry_date="";
										select_status_1="";

            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block708Bytes, _wl_block708);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block709Bytes, _wl_block709);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block704Bytes, _wl_block704);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block72Bytes, _wl_block72);

										}
									} 
									else{

            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block710Bytes, _wl_block710);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block711Bytes, _wl_block711);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block712Bytes, _wl_block712);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

										for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){ //changed 7 to 9 for GHL-CRF-0482
											if (defaultBatch.equals((String)iv_batch_ids.get(kk))){

            _bw.write(_wl_block713Bytes, _wl_block713);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block714Bytes, _wl_block714);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block715Bytes, _wl_block715);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block716Bytes, _wl_block716);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block72Bytes, _wl_block72);

											}
											else{

            _bw.write(_wl_block717Bytes, _wl_block717);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block317Bytes, _wl_block317);

											}
										} 

            _bw.write(_wl_block718Bytes, _wl_block718);

										} 
									} 										

            _bw.write(_wl_block719Bytes, _wl_block719);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block720Bytes, _wl_block720);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block721Bytes, _wl_block721);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block722Bytes, _wl_block722);

								}

            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block723Bytes, _wl_block723);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block724Bytes, _wl_block724);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block725Bytes, _wl_block725);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block726Bytes, _wl_block726);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block727Bytes, _wl_block727);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block728Bytes, _wl_block728);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block729Bytes, _wl_block729);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block69Bytes, _wl_block69);
 
								String md_admn_req ="";
								if(bean.isWitnessedbyRequiredForIV(order_id)){
									md_admn_req="Y";
								}
								if(order_line_num.equals("1") && !((hold.equals("Y")) || dis_continued.equals("Y"))){

            _bw.write(_wl_block730Bytes, _wl_block730);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block731Bytes, _wl_block731);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block732Bytes, _wl_block732);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block733Bytes, _wl_block733);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block734Bytes, _wl_block734);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block735Bytes, _wl_block735);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(md_admn_req));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block736Bytes, _wl_block736);
            out.print( String.valueOf((ivRecCount-Integer.parseInt(order_line_num)+1)));
            _bw.write(_wl_block737Bytes, _wl_block737);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block738Bytes, _wl_block738);
            out.print( String.valueOf(admin_discontinue));
            _bw.write(_wl_block739Bytes, _wl_block739);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block740Bytes, _wl_block740);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block741Bytes, _wl_block741);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block742Bytes, _wl_block742);

								}
								else{

            _bw.write(_wl_block743Bytes, _wl_block743);

								}

            _bw.write(_wl_block744Bytes, _wl_block744);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block745Bytes, _wl_block745);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block746Bytes, _wl_block746);

								if(order_line_num.equals("1") && (!MfrYN.equals("Y"))) { 

            _bw.write(_wl_block747Bytes, _wl_block747);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block748Bytes, _wl_block748);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

								}				

            _bw.write(_wl_block749Bytes, _wl_block749);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block750Bytes, _wl_block750);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block751Bytes, _wl_block751);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block752Bytes, _wl_block752);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block753Bytes, _wl_block753);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block754Bytes, _wl_block754);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block755Bytes, _wl_block755);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block756Bytes, _wl_block756);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block757Bytes, _wl_block757);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block758Bytes, _wl_block758);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block759Bytes, _wl_block759);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block760Bytes, _wl_block760);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block761Bytes, _wl_block761);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block762Bytes, _wl_block762);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block763Bytes, _wl_block763);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block764Bytes, _wl_block764);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block765Bytes, _wl_block765);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block766Bytes, _wl_block766);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block767Bytes, _wl_block767);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block768Bytes, _wl_block768);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block769Bytes, _wl_block769);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block770Bytes, _wl_block770);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block771Bytes, _wl_block771);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block772Bytes, _wl_block772);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block773Bytes, _wl_block773);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block774Bytes, _wl_block774);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block775Bytes, _wl_block775);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block776Bytes, _wl_block776);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block777Bytes, _wl_block777);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block778Bytes, _wl_block778);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block779Bytes, _wl_block779);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block780Bytes, _wl_block780);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_Auto_Admin));
            _bw.write(_wl_block781Bytes, _wl_block781);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block782Bytes, _wl_block782);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_order_pract_id));
            _bw.write(_wl_block783Bytes, _wl_block783);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block784Bytes, _wl_block784);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block785Bytes, _wl_block785);

							if(!MfrYN.equals("Y")){

            _bw.write(_wl_block786Bytes, _wl_block786);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block787Bytes, _wl_block787);

							}
							ivRecCount++;
						} 

            _bw.write(_wl_block788Bytes, _wl_block788);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block789Bytes, _wl_block789);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block790Bytes, _wl_block790);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block791Bytes, _wl_block791);

					}
				}

            _bw.write(_wl_block792Bytes, _wl_block792);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block793Bytes, _wl_block793);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block794Bytes, _wl_block794);
            out.print( String.valueOf(adminOption));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(isSiteSpecMARPrint));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_class_ord));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_stock_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block795Bytes, _wl_block795);
            out.print( String.valueOf(adminOptionDisplay));
            _bw.write(_wl_block796Bytes, _wl_block796);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block797Bytes, _wl_block797);
            out.print( String.valueOf(adminOptionDisplay));
            _bw.write(_wl_block798Bytes, _wl_block798);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block799Bytes, _wl_block799);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block800Bytes, _wl_block800);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block801Bytes, _wl_block801);
            out.print( String.valueOf(selfAdminBy));
            _bw.write(_wl_block802Bytes, _wl_block802);
            out.print( String.valueOf(adminByType));
            _bw.write(_wl_block803Bytes, _wl_block803);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block804Bytes, _wl_block804);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block805Bytes, _wl_block805);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block806Bytes, _wl_block806);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block807Bytes, _wl_block807);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block808Bytes, _wl_block808);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block809Bytes, _wl_block809);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block810Bytes, _wl_block810);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block811Bytes, _wl_block811);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block812Bytes, _wl_block812);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block813Bytes, _wl_block813);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block814Bytes, _wl_block814);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_INSERT" )));
            _bw.write(_wl_block815Bytes, _wl_block815);
            out.print( String.valueOf(tot_rec));
            _bw.write(_wl_block816Bytes, _wl_block816);
            out.print( String.valueOf(tot_rec));
            _bw.write(_wl_block817Bytes, _wl_block817);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block818Bytes, _wl_block818);
            out.print( String.valueOf(ivRecCount-1));
            _bw.write(_wl_block819Bytes, _wl_block819);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block820Bytes, _wl_block820);
            out.print( String.valueOf(selDateTime));
            _bw.write(_wl_block821Bytes, _wl_block821);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block822Bytes, _wl_block822);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block823Bytes, _wl_block823);
            out.print( String.valueOf(userAuthPINYN));
            _bw.write(_wl_block824Bytes, _wl_block824);
            out.print( String.valueOf(admin_discontinue));
            _bw.write(_wl_block825Bytes, _wl_block825);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block826Bytes, _wl_block826);
            out.print( String.valueOf(verify_adm_drug));
            _bw.write(_wl_block827Bytes, _wl_block827);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block828Bytes, _wl_block828);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block829Bytes, _wl_block829);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_all_stages,bean_all_stages,request);
		putObjectInBean(drug_search_bean_id,drug_bean,request);
		putObjectInBean(admin_bean_id,admin_bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ // Added for AAKH-CRF-0084 - Start
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for AAKH-CRF-0084 - End

            _bw.write(_wl_block830Bytes, _wl_block830);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicationAdministration.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drugs.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDose.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RouteOfAdministration.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduledTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDate/Time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BroughtByPatient.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientStockCompleted.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Bal.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Bal.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid/Ingrediant.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDose.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitDose.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RouteOfAdministration.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SchTime.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionDate/Time.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionPeriod.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVAdministration.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.adminby.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.patientsRelative.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }
}

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
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __reissuemedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReissueMedResult.jsp", 1731574910388L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" <!-- modified for AAKH-CRF-0117-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t    <!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t<!--\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n-->\t\t<script language=\"JavaScript\" src=\"../js/ReissueMed.js\"></script>\n\t    <script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t </head>\n\t<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->\n\t<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"FormReissueMedicationResult\" id=\"FormReissueMedicationResult\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<table  cellpadding=0 cellspacing=0 width=\"100%\"  align=\"center\" border=\"0\" id=\"disptab\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\"data\" colspan=\"2\">&nbsp&nbsp";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t<td class=\"data\" >&nbsp&nbsp";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\"  name=\"loc_code\" id=\"loc_code\"      value =";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\t\t<input type=\"hidden\"  name=\"patient_class\" id=\"patient_class\" value =";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t\t\t\t\t<input type=\"hidden\"  name=\"order_id\" id=\"order_id\"      value =";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t\t\t\t\t<input type=\"hidden\"  name=\"fill_period\" id=\"fill_period\"   value =";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t\t<input type=\"hidden\"  name=\"fill_unit\" id=\"fill_unit\"     value =";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"     value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"Disp_date_from\" id=\"Disp_date_from\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"Disp_date_to\" id=\"Disp_date_to\"   value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t<table width=\'100%\' border=\"1\" id=\"Tdispensingdetails\" name=\"Tdispensingdetails\" id=\"Tdispensingdetails\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"10\" align=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th> <!-- modified for AAKH-CRF-0117-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th width=\"15%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th> \n                      <th width=\"15%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th> <!-- Added for FD-BRU-CRF-092 -->\n                        <th width=\"10%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th> <!-- Added for FD-BRU-CRF-092 -->\n\t\t\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>  <!-- Re-issuedQuantity changed to IssuedQuantity for  HSA-SCF-019 [IN:048416] -->\n\t\t\t\t\t\t<th width=\"5%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="? </th>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\t\t\t\t\t\t\t<th width=\"5%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="?</th>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t\t\t\t<th width=\"13%\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<th width=\"15%\" nowrap> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" &nbsp;&nbsp;&nbsp;&nbsp;</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<tr id=\"row_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onmouseover=\"changeCursor(this);\" >\n\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\'  id=\"drug_name";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  onclick=\"callBatchDetails(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',document.FormReissueMedicationResult.durg_name";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =")\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font></td>\n                                     <!-- ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" added for passing Disp_facility_id -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drugcode_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"drugcode_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" value =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"OrderId";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"OrderId";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'><!-- Modified for ICN_ADHOC_016 -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"OrderLine_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"OrderLine_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"DispLocCode_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"DispLocCode_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"end_date_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"end_date_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Uom_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"Uom_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"UnitCost_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"UnitCost_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"encounter_id_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_no";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"disp_no";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reissuableqty";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"reissuableqty";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discharge_ind";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"discharge_ind";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"durg_name";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"durg_name";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' > <!-- added for ML-BRU-SCF-1073 by Ganga -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reissue_type_ind";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"reissue_type_ind";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"\t   value =\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reissue_count_by_ind";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"reissue_count_by_ind";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reissue_count";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"reissue_count";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' ><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_cau_instrn1_eng";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"label_cau_instrn1_eng";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' ><!--Added for [IN:052983] start-->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_cau_instrn2_eng";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"label_cau_instrn2_eng";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_spl_instrn1_eng";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"label_spl_instrn1_eng";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_spl_instrn2_eng";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"label_spl_instrn2_eng";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_pat_instrn1_eng";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"label_pat_instrn1_eng";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_cau_instrn1_loc";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"label_cau_instrn1_loc";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_cau_instrn2_loc";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"label_cau_instrn2_loc";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_spl_instrn1_loc";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"label_spl_instrn1_loc";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_spl_instrn2_loc";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"label_spl_instrn2_loc";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"label_pat_instrn1_loc";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"label_pat_instrn1_loc";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' ><!--Added for [IN:052983] end-->\n\n                                   <input type=\"hidden\" name=\"batch_ids_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"batch_ids_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" value =\'\' >\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"binlocation_codes_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"binlocation_codes_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" value =\'\' >\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"expiary_dates_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"expiary_dates_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" value =\'\' >\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"issued_qty_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"issued_qty_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" value =\'\' >\n                                     <td class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" align=\"left\">";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" </td> <!-- Added for FD-BRU-CRF-092 -->\n                                     <td class=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td> <!-- Added for FD-BRU-CRF-092 -->\n\t\t\t\t\t\t\t\t\t<!-- <td class=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="/\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td><!-- Modified for Issuee 11510 commented on 8/10/09--> \n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;&nbsp;  \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td><!-- Modified for Issuee 11510 -->\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<label id=\"reissueqty_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">&nbsp;</label>\n\t\t\t\t\t\t\t\t\t\t<label id=\"reissueunit_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">&nbsp;</label>\n\t\t\t\t\t\t\t\t\t\t&nbsp;<input style=\'text-align:right;\' type=\'checkbox\' id=\"reissue_vis_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"reissue_vis_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" onClick=\"updateRecords(this,\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\')\">\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n                                         <td class=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\'gross_charge_amount_display_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' ><label ></label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\'groos_pat_payable_display_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'><label ></label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\'inc_exec_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'><label ></label>&nbsp;</td>   \n\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"   value=\"\">\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" align=\"center\">&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t<select name=\'reasons";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\'reasons";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'  onChange = \"updateReason(this,\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\');\">\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" >";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</option>\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\t</select>&nbsp;<img name=\"PhysicalLocMandatory\" src=\"../../eCommon/images/mandatory.gif\">\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" >";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drugcode_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' >\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" align=\"center\">";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_no";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" ><label id=\"reissueqty_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"></label> &nbsp;&nbsp<label id=\"reissueunit_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"></label></td>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' ><label ></label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t     <td class=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'><label ></label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'><label ></label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"   value=\"\">\t\t\t\t\t \n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n                                   <input type=\"hidden\" name=\"batch_ids_";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" value =\'\' >\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"reissue_type_ind";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"reissue_count_by_ind";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"  value =\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\t\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"reissue_count";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\t\t   value =\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' ><!--Added for Bru-HIMS-CRF-405[IN 044830] -->\n\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<select name=\'reasons";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t<option selected value=\"\">&nbsp;&nbsp;---";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="---&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\t\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" nowrap>    \n\t\t\t\t\t <input type=\"text\" value=\"\" maxlength=\"20\"  name=\"approval_no_";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" id=\"approval_no_";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" onchange=\"getApprovalNumForDrug(this,";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =")\" onKeyPress=\"return KeyPressSpecCharsForApprovalNo(event)\" onBlur=\"CheckForSpecCharApprovalno(this,\'R\',";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =")\"/> <!--MODIFIED FOR AAKH-CRF-0117 -->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t<img id=\"imgForWithin\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\" style=\"visibility:visible\"></img>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t <input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" id=\"order_id_";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' ><!-- AAKH-CRF-0117 modified again for AAKH-CRF-0117-->\n\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" id=\"order_line_no_";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' ><!-- AAKH-CRF-0117 modified again for AAKH-CRF-0117-->\n\t\t\t\t\t<input type=\"hidden\" name=\"approval_no_app_for_patient_class_";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" id=\"approval_no_app_for_patient_class_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"> <!-- AAKH-CRF-0117-->\n\t\t\t\t\t\n\t\t\t\t\t </td> \n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_gross_charge_amount\" id=\"tot_gross_charge_amount\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_groos_pat_payable\" id=\"tot_groos_pat_payable\"   value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\"   value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\"Common\")); \n\t\t//window.close();\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"                value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"              value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\"                   VALUE=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"querytext\" id=\"querytext\"              VALUE=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\"        value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_cash_coll_stage\" id=\"disp_cash_coll_stage\"   value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"approval_no_flag\" id=\"approval_no_flag\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"><!-- AAKH-CRF-0117-->\n\t\t\t\t<input type=\"hidden\" name=\"approval_no_app_for_patient_class\" id=\"approval_no_app_for_patient_class\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"> <!-- AAKH-CRF-0117-->\n\t\t\t</table>\n\t\t</form>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t</body>\n</html>\n\t<script>\n\t\tif(document.getElementById(\"drug_name0\")){\n\t\t\tdocument.getElementById(\"drug_name0\").click();\n\t\t\tfor(var i=0;i<document.getElementById(\"row_0\").cells.length;i++)\n\t\t\t\tdocument.getElementById(\"row_0\").cells[i].style.backgroundColor\t= \"#fde6d0\";\n\t\t}\n</script>\n\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			Connection con			= null; //AAKH-CRF-0117
try{		
			con				= ConnectionManager.getConnection(request);//AAKH-CRF-0117
			String bean_id			= request.getParameter("bean_id");
			String bean_name		= request.getParameter("bean_name");	
			String Patientid		= request.getParameter("PatientId");
			String DrugCode			= request.getParameter("DrugCode");
			String Disp_date_from	= request.getParameter("Disp_date_from");
			String Disp_date_to		= request.getParameter("Disp_date_to");		
			String ordering_facility_id	= request.getParameter("ordering_facility_id");		
			String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
			String facility_id		= (String) session.getValue("facility_id");
			String reissue_type_ind  ="";//Added for Bru-HIMS-CRF-405[IN 044830]
			String reissue_count_by_ind = "";//Added for Bru-HIMS-CRF-405[IN 044830]
			String reissue_count    = "";//Added for Bru-HIMS-CRF-405[IN 044830]
			HashMap result = new HashMap();
			ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(locale);
			bean.clear() ;
			bean.getTokenSeries();
			bean.setBillingParams(); //added for SRR20056-SCF-7639 ICN027720 -start
            bean.setOrderingFacilityID(ordering_facility_id);
			String disp_cash_coll_stage =bean.getDispCashCollStage();
			String bl_interface_yn  = bean.checkforbillinginterface();
   			result = bean.getReissueResult(DrugCode,Disp_date_from,Disp_date_to,Patientid);
			//AAKH-CRF-0117 - start
			boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117

		  	String approval_no_app_for_patient_class = "N";
			/*if(approval_no_flag){ //commented and moved to down for AAKH-CRF-0117
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass((String)othdetails.get(16));
			} //AAKH-CRF-0117 - end */
			if(result.size() > 0){
				ArrayList Reasons = new ArrayList();
				ArrayList othdetails = new ArrayList();
				Reasons = (ArrayList)result.get("REASON");
				othdetails = (ArrayList)result.get("DETAIL");
				if (othdetails.size() > 0  ) {
					bean.setPatientClass((String)othdetails.get(16));
					String colval = ((String)othdetails.get(5));
					String gender_String="";
					String clval="";
					StringBuffer sb=new StringBuffer();
					String comp_str ="";
					java.util.StringTokenizer st = new java.util.StringTokenizer(colval,",");
					while( st.hasMoreTokens()) {
						comp_str = st.nextToken();
						if((! (comp_str.trim().equals("female") || comp_str.trim().equals("male") || comp_str.trim().equals("unknown") )))
							sb.append(comp_str.trim()+" ");
						if(comp_str.trim().equals("female"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						if(comp_str.trim().equals("male"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						if(comp_str.trim().equals("unknown"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						clval=sb.toString()+" "+gender_String;
					}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clval));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(othdetails.get(0)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(othdetails.get(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(othdetails.get(16)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(othdetails.get(12)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(othdetails.get(17)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(othdetails.get(18)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Disp_date_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Disp_date_to));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if(bl_interface_yn.equals("Y")){
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
if(approval_no_flag){ //added for AAKH-CRF-0117 
					
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);

					String classvalue="";
					int j=0;
					boolean approval_flag = false; //AAKH-CRF-0117
					String	disabled	  = "disabled"; //AAKH-CRF-0117
					for(int recCount=0; recCount<othdetails.size()-1; recCount+=37){//27 to 37 for [IN052983]//Increase size from 24 to 27 for Bru-HIMS-CRF-405[IN 044830]
						if ( j % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;
						reissue_type_ind	 =(String)othdetails.get( recCount+24)==null?"":(String)othdetails.get( recCount+24);//Added for Bru-HIMS-CRF-405[IN 044830]
						reissue_count_by_ind=(String)othdetails.get( recCount+25)==null?"":(String)othdetails.get( recCount+25);//Added for Bru-HIMS-CRF-405[IN 044830]
						reissue_count      =(String)othdetails.get( recCount+26)==null?"":(String)othdetails.get( recCount+26);//Added for Bru-HIMS-CRF-405[IN 044830]
						approval_no_app_for_patient_class = "N";
						if(approval_no_flag){
					  approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass((String)othdetails.get(recCount+16));
					} //AAKH-CRF-0117

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
								
								if(  ((String)othdetails.get( recCount+11)).equals("Y")){	

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)othdetails.get( recCount+9)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+10)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+8 )));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Patientid));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+12)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+13)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+6)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+14)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+2)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+22)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)othdetails.get( recCount+7)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)othdetails.get( recCount+22)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+6)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+12)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+13)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+1)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+14)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+15)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+19)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(j));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+20)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(j));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+2)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+8)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+21)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)othdetails.get( recCount+7),"UTF-8")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(reissue_type_ind));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(reissue_count_by_ind));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(reissue_count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+27)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+28)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+29)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+30)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(j));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+31)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+32)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+33)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+34)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(j));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+35)));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(j));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get(recCount+36)));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(j));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(j));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(j));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(j));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf((String)othdetails.get(recCount+23) ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf((String)othdetails.get(recCount)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( (String)othdetails.get( recCount+8 )));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf((String)othdetails.get( recCount+15)));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( (String)othdetails.get( recCount+8 )));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,othdetails.get(recCount+15).toString())));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(j));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(j));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(j));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(j));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)othdetails.get( recCount+6)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)othdetails.get( recCount+2)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block120Bytes, _wl_block120);

									if(bl_interface_yn.equals("Y")){

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(j));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(j));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(j));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(j));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(j));
            _bw.write(_wl_block131Bytes, _wl_block131);

									}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(j));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(j));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(j));
            _bw.write(_wl_block135Bytes, _wl_block135);
 
											for(int i=0; i < Reasons.size();i+=2){	

            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(Reasons.get(i)));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(Reasons.get(i+1)));
            _bw.write(_wl_block138Bytes, _wl_block138);
  
											}

            _bw.write(_wl_block139Bytes, _wl_block139);

									}
									else{ 

            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf((String)othdetails.get( recCount+7)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+6)));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)othdetails.get( recCount+3)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(j));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)othdetails.get( recCount+2)));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(j));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(j));
            _bw.write(_wl_block148Bytes, _wl_block148);

										if(bl_interface_yn.equals("Y")){

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(j));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(j));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(j));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(j));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(j));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(j));
            _bw.write(_wl_block154Bytes, _wl_block154);

										}

            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(j));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(j));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(j));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(j));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(reissue_type_ind));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(reissue_count_by_ind));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(reissue_count));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(j));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(j));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

									}
						 
						if(approval_no_flag) { //added for AAKH-CRF-0117

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(j));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(j));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(j));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(j));
            _bw.write(_wl_block171Bytes, _wl_block171);
 //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y")){ 
            _bw.write(_wl_block172Bytes, _wl_block172);
}
						
					
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(j));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(othdetails.get(recCount+12)));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(j));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(othdetails.get(recCount+13)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(j));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(j));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(approval_no_app_for_patient_class));
            _bw.write(_wl_block180Bytes, _wl_block180);

					} 
            _bw.write(_wl_block181Bytes, _wl_block181);

							j=j+1;
						}
						// if(bl_interface_yn.equals("Y")){

            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(j));
            _bw.write(_wl_block183Bytes, _wl_block183);
						//}	
}
					else{

            _bw.write(_wl_block184Bytes, _wl_block184);

					}
				}

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(disp_cash_coll_stage));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(approval_no_flag));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(approval_no_app_for_patient_class));
            _bw.write(_wl_block192Bytes, _wl_block192);

	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{  //AAKH-CRF-0117
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}

            _bw.write(_wl_block193Bytes, _wl_block193);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedAt.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IssuedDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDrug.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dispensedfacility.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedLocation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IssuedQuantity/UOM.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Reissue.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReissueReason.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalNo.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}

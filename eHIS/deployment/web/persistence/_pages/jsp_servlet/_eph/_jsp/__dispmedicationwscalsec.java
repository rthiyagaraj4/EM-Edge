package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.DecimalFormat;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationwscalsec extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationWSCalSec.jsp", 1709120751754L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\"frmDispMedicationWSCalSec\" id=\"frmDispMedicationWSCalSec\">\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t<tr>\n\t\t<td colspan=\"3\">\n \t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\" align=\"left\">\n\t\t\t<td  class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\"><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<b></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"45%\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\" align=\"left\">\n \t\t\t<td  class=\"COLUMNHEADER\" colspan=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2>&nbsp;<input type=\"text\" size=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" maxlength=\"60\" disabled style=\"font-size:12\" name=\"drug_name\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></td>\n\t\t\t</tr>\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td width=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">&nbsp;<input type=\"text\" name=\"drug_qty_as_per_order\" id=\"drug_qty_as_per_order\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" maxlength=\"4\" size=\"6\" style=\"font-size:12\" class=\"NUMBER\" disabled ></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td >&nbsp;<input type=\"text\" name=\"drug_qty_preparation\" id=\"drug_qty_preparation\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" maxlength=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=\"6\" style=\"font-size:12\" class=\"NUMBER\"  onKeyPress=\"return allowValidNumber(this,event,4,";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\" onBlur=\"if(validateNumbers(this,4,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')){validateDrugPreQty(this,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');}\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td >&nbsp;<input type=\"text\" name=\"drug_qty_spillage\" id=\"drug_qty_spillage\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" size=\"6\" style=\"font-size:12\" class=\"NUMBER\" onKeyPress=\"return allowValidNumber(this,event,4,";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =")\"  onBlur=\"if(validateNumbers(this,4,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')){validateDrugSpillage(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ></td>\n\t\t\t</tr>\n                \n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td >&nbsp;<input type=\"text\" name=\"drug_qty_drawn\" id=\"drug_qty_drawn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" maxlength=\"4\" size=\"6\" style=\"font-size:12\" class=\"NUMBER\" disabled>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<br>\n\t\t\t\t\t<label id=\"lblDrugShowBatches\" style=\"color:black;font-size:9\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</label>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<br>\t\t\t\t     \n                    <label id=\"lblDrugShowBatches\" style=\"color:blue;cursor:pointer;font-size:9\" onClick=\"showWSBatches(\'D\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</label>  \n\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t</table>\n\t\t</td>\n\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<td width=\"2%\">\n \t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  border=\"0\" align=\"left\">\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td HEIGHT=\"21\" STYLE=\"background:white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t\n\t\t<td width=\"53%\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  border=\"0\" align=\"left\">\n\t\t\t<input type=\"hidden\" name=\"SQL_PH_DISP_MEDICATION_SELECT38\" id=\"SQL_PH_DISP_MEDICATION_SELECT38\" value=\"SELECT   a.rf_id code, rf_name description FROM ph_reconst_fluid a, PH_RECONST_FLUID_FOR_DRUG b WHERE a.rf_id = b.rf_id and drug_code = \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' and a.rf_id LIKE ? AND a.rf_name LIKE ? ORDER BY 2\">\n\t\t\t<td  class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"rf_name\" id=\"rf_name\" size=\"30\" maxlength=\"60\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" style=\"font-size:12\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="><input type=\"button\" name=\"btnReconFluidName\" id=\"btnReconFluidName\" value=\"?\" class=\"button\" onClick=\"ReconstituentFluidLookup(rf_name)\">\n\t \t\t\t\t<input type=\"button\" name=\"btnStabilityInfo\" id=\"btnStabilityInfo\" value=\"Info\" class=\"button\" onClick=\"callStabilityInfo()\">\n\t\t\t\t\t<input type=\"hidden\" name=\"rf_id\" id=\"rf_id\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\"  onKeyPress=\"return allowValidNumber(this,event,4,0)\" name=\"fluid_qty_as_per_order\" id=\"fluid_qty_as_per_order\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" maxlength=\"4\" size=\"3\" style=\"font-size:12\" class=\"NUMBER\" disabled>&nbsp;<b><label id=\"uom_1\" class=\"label\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label></b>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\"  onKeyPress=\"return allowValidNumber(this,event,4,0)\" name=\"fluid_qty_preparation\" id=\"fluid_qty_preparation\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" maxlength=\"4\" size=\"3\" style=\"font-size:12\" class=\"NUMBER\"  disabled>&nbsp;<b><label id=\"uom_2\" class=\"label\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label></b>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"fluid_qty_spillage\" id=\"fluid_qty_spillage\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" maxlength=\"4\" size=\"3\" style=\"font-size:12\" onKeyPress=\"return allowValidNumber(this,event,4,0)\" class=\"NUMBER\" onBlur=\"if(validateNumbers(this,4,\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')){validateFluidSpillage(this);}\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =">&nbsp;<b><label id=\"uom_3\" class=\"label\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label></b>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"fluid_qty_drawn\" id=\"fluid_qty_drawn\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" maxlength=\"4\" size=\"3\" style=\"font-size:12\" class=\"NUMBER\" disabled>\n\t\t\t\t\t<input type=\"hidden\" name=\"stock_qty\" id=\"stock_qty\" value=\"\">&nbsp;<b><label id=\"uom_4\" class=\"label\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</label></b>&nbsp;\n\t\t\t\t\t<label id=\"lbl_stock_qty\" style=\"font-size:10;font-weight:bold;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</label>\n\t\t\t\t\t&nbsp;&nbsp;<label id=\"lbl_stock_qty_uom\" style=\"font-size:10;font-weight:bold;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" </label>\n\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t    <label id=\"lblFluidShowBatches\" style=\"color:black;font-size:10\" >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n                        <label id=\"lblFluidShowBatches\" style=\"color:blue;cursor:pointer;font-size:10\" onClick=\"showWSBatches(\'F\',rf_id.value,\'\')\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</label>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\n\t\t\t</table>\n\t\t</td>\n       ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t</tr>\n\t<tr>\n\t\t<td class=\"white\" colspan=\"3\">&nbsp;</td>\n\t</tr>\n\t<tr>\t\t\n\t\t<td  class=\"white\" colspan=\"3\"> \n\t\t\t<input type=\"button\" name=\"btnStockAvailability\" id=\"btnStockAvailability\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' class=\"button\" onClick=\"callWSBatchSearch(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =">\n\t\t\t<input type=\"button\" name=\"btnCancel\" id=\"btnCancel\" class=\"button\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' onClick=\"clearCalSection()\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t</td>\n\t</tr>\n\t</table>\n\t\n\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"drug_form\" id=\"drug_form\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\t\n\t<input type=\"hidden\" name=\"multi_strength\" id=\"multi_strength\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\t\n\t<input type=\"hidden\" name=\"stability_info\" id=\"stability_info\" value=\"\">\t\n\t<input type=\"hidden\" name=\"rf_qty\" id=\"rf_qty\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"hidden\" name=\"order_qty\" id=\"order_qty\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\t\n\t<input type=\"hidden\" name=\"tot_num_of_drugs\" id=\"tot_num_of_drugs\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"tot_disp_qty\" id=\"tot_disp_qty\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\n</form>\n<script language=\"Javascript\">\n//makeQtyAsReadOnly();\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );
	
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
	private String retunFormatedInt(String sValue)
	{
		if(sValue != null && !sValue.equals(""))
		{
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

    
	String drug_name		= request.getParameter("drug_name");
	String drug_code		= request.getParameter("drug_code");
	String qty				= request.getParameter("qty");
	String drug_form		= request.getParameter("drug_form");
	String patient_id		= request.getParameter("patient_id");
	String order_id			= request.getParameter("order_id");
	String order_line_no	= request.getParameter("order_line_no");
	String qty_uom			= request.getParameter("qty_uom");
	String tot_num_of_drugs = request.getParameter("tot_num_of_drugs");
	String width_legend		= "";
	String width_text		= "";
	String colspan			= "";
	String drug_name_size	= "";
	String rf_qty			= "";
	String drug_qty			= "";
	String rf_qty_uom		= "";
	String facility_id		= (String)session.getValue( "facility_id" );
    String status           =  "";
	String sIngredientsType	= request.getParameter("IngType");
	StringBuffer sbRatioPercentLegend = new StringBuffer();

	if(sIngredientsType!=null && !sIngredientsType.equals("") && !sIngredientsType.equals("S"))
	{
		sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Concentration.label","ph_labels.resources.Labels"));
		if(sIngredientsType.equals("P"))
		{
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"Common.by.label","common_labels.resources.Labels"));
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Percentage.label","ph_labels.resources.Labels"));	
		}
		else if	(sIngredientsType.equals("R"))
		{
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"Common.by.label","common_labels.resources.Labels"));
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Ratio.label","ph_labels.resources.Labels"));	
		}
	}


	int tot_disp_qty        =0;
	if(drug_form.equals("P")){
		width_legend="30%";
		width_text="25%";
		colspan = "3";
		drug_name_size="48";
	}else{
		width_legend="30%";
		width_text="70%";
		colspan = "5";
		drug_name_size="60";
	}		

	String bean_id					= "DispMedicationBean" ;
	String bean_name				= "ePH.DispMedicationBean";
	DispMedicationBean bean			= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String store_code				= bean.getStoreCode();
	//String spill_qty_yn				= bean.getSpillQtyYN(bean.getDispLocnCatg());
	String spill_qty_yn				= bean.getSpillQtyYN();
	String trade_code				= (String)bean.gettrade_codes(order_id,order_line_no,drug_code);
    String allowchangetradenameyn	= bean.getDispChangeTradeNameYN();
	String allowmultitradeyn	    = bean.getDispAllowMultiTradesYN();
	String allow_short_expiry_drugs_yn =bean.getAllow_short_expiry_drugs_yn();


	String disable_spill_qty="";
	if(spill_qty_yn.equals("N")){
		disable_spill_qty	=	"disabled";
	}
	String bean_id_1				= "DispMedicationAllStages" ;
	String bean_name_1				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_1  = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;

	int iNoOfDecimals				= 0;

	boolean bDecimalAllowed			= bean_1.getDecimalAllowedYN(drug_code);
	if(bDecimalAllowed)
		iNoOfDecimals = bean_1.getINoOfDecimals();

	int iMaxLength					= 5+iNoOfDecimals;

	String multi_strength			= bean_1.checkMultiStrength(drug_code);
	String strDisabled = "";
	if(drug_form.equals("P")){	
		strDisabled = "disabled";
	}
	HashMap rf_fluid_details	  = new HashMap();
	String qty_required_per_order = qty;
	String prepartion_qty		  = qty;
	String qty_avail_from_spillage= "0";
	String qty_drawn_from_stock	  = qty;
	String worksheet_id           = bean.getWorksheetID();	
	String patient_class          = bean.getDispLocnCatg();
	String fluid_qty_as_per_order = "";
	String fluid_qty_preparation  = "";
	String fluid_qty_spillage	  = "0";
	String fluid_qty_drawn		  = "";
	Hashtable ht_drug_details	  = bean.getAllDrugDetails();
	String rf_id				  = "";
	String rf_name				  = "";
	String lbl_stock_qty		  = "";
	String lbl_stock_qty_uom	  = "";
	String display				  = "display:none";
	String rf_name_disabled	      = "";
	String finalised_yn			  ="Y";
	ArrayList un_finalised_val    = new ArrayList();

    ArrayList dosage_dtls		  =	new ArrayList();
	dosage_dtls					  =	bean.getDosageDtls(order_id,order_line_no);		
	String end_date		          =	(String)dosage_dtls.get(2);

	ArrayList arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);
	if(drug_form.equals("P") && (arr_list_drug_details == null))
	{
	
		  rf_fluid_details	  = new HashMap();
          rf_fluid_details=bean.getRFFluidDetails(drug_code);
		  if(rf_fluid_details!=null )
			{
			  rf_id					=(String)rf_fluid_details.get("RF_ID");
			  rf_name				= bean.getRFName(rf_id);
			  rf_qty				=(String)rf_fluid_details.get("RF_QTY");
			  drug_qty				=(String)rf_fluid_details.get("DRUG_QTY");

			  if(drug_qty.equals("0"))
                  drug_qty="1";
	              if(!rf_qty.equals("0")&&!drug_qty.equals("0")&&!qty.equals("0")&&!rf_qty.equals("")&&!drug_qty.equals("")&&!qty.equals("")){
			             fluid_qty_as_per_order=(((Double.parseDouble(rf_qty)/Double.parseDouble(drug_qty))*Double.parseDouble(qty))+"");
                  }
//out.println("~~~ fluid_qty_as_per_order == "+fluid_qty_as_per_order+"  ==rf_qty== "+rf_qty+" ==drug_qty== "+drug_qty +" ==qty== "+qty);
			  fluid_qty_preparation	=fluid_qty_as_per_order;
			  fluid_qty_drawn		=fluid_qty_as_per_order;
			  rf_qty_uom			=(String)rf_fluid_details.get("RF_QTY_UOM");
			  bean.setStockQtyUOM(fluid_qty_drawn,rf_id);
		      lbl_stock_qty			= bean.getStockQty();
		      lbl_stock_qty_uom		= bean.getStockQtyUOM();
			  display				= "";
			 }
	}
	
	if(arr_list_drug_details != null){
		if(arr_list_drug_details.size()==5){
			qty_required_per_order = (String)arr_list_drug_details.get(1);
			prepartion_qty		   = (String)arr_list_drug_details.get(2);
			qty_avail_from_spillage= (String)arr_list_drug_details.get(3);
			qty_drawn_from_stock   = (String)arr_list_drug_details.get(4);


		}else if(arr_list_drug_details.size()==10){
			qty_required_per_order = (String)arr_list_drug_details.get(1);
			prepartion_qty		   = (String)arr_list_drug_details.get(2);
			qty_avail_from_spillage= (String)arr_list_drug_details.get(3);
			qty_drawn_from_stock   = (String)arr_list_drug_details.get(4);

			rf_id				   =(String)arr_list_drug_details.get(5);
			fluid_qty_as_per_order =(String)arr_list_drug_details.get(6);
			fluid_qty_preparation  =(String)arr_list_drug_details.get(7); 
			fluid_qty_spillage     =(String)arr_list_drug_details.get(8); 

			rf_fluid_details=bean.getRFFluidDetails(drug_code);
			if(rf_fluid_details!=null ){
               rf_qty_uom			=(String)rf_fluid_details.get("RF_QTY_UOM");
			}

			if(fluid_qty_preparation != null && !fluid_qty_preparation.equals("") && fluid_qty_spillage != null && !fluid_qty_spillage.equals(""))
				fluid_qty_drawn=(Double.parseDouble(fluid_qty_preparation)-Double.parseDouble(fluid_qty_spillage))+""; 
			else
				fluid_qty_drawn = "";
	
			//fluid_qty_drawn =(String)arr_list_drug_details.get(9); 
			bean.setStockQtyUOM(fluid_qty_drawn,rf_id);
			lbl_stock_qty     = bean.getStockQty();
			lbl_stock_qty_uom = bean.getStockQtyUOM();
			display			  = "";
			rf_name			  = bean.getRFName(rf_id);
			strDisabled		  = "";
			rf_name_disabled  = "disabled";

			
		}
//CODE WRITTEN TO HANDLE REGULAR PRESCRIPTIONS TOTAL DISP QTY
		
		}

	String first_time_yn ="Y";
	 HashMap ws_first_time_yn =(HashMap)bean.getWSFirstYN();
     //if(worksheet_id!=null && !worksheet_id.equals("")){
       if(ws_first_time_yn.containsKey(order_line_no+drug_code)) {
           first_time_yn =(String)ws_first_time_yn.get(order_line_no+drug_code);
	   }
	// }

	finalised_yn = bean.getWorksheetFinalisedYN(worksheet_id,bean.getDispLocnCode(),facility_id);
		tot_disp_qty           =   bean.getTotalDispQtyForWorkSheet(order_id,order_line_no,facility_id);

		if(!finalised_yn.equals("N")&&patient_class.equals("I")&&first_time_yn.equals("Y")){
			  qty_required_per_order =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
		 }
         if(first_time_yn.equals("Y")){
				
				if(patient_class.equals("I")){
					if(worksheet_id!=null && !worksheet_id.equals("")){	

						if(finalised_yn.equals("Y")){	
								
								HashMap ht_ws_allocated_drugs  =  bean.getAllAllocatedDrugs();
								if(!ht_ws_allocated_drugs.containsKey(drug_code)){

									if(!prepartion_qty.equals("")){
										//prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
										prepartion_qty			= qty_required_per_order;
										qty_drawn_from_stock	=  prepartion_qty;
										qty_avail_from_spillage = "0";
									}
								}				
					   }
					   else{			   
							un_finalised_val = null;
							un_finalised_val = bean.getDataForUnFinalisedWorksheets(worksheet_id,bean.getDispLocnCode(),order_line_no,facility_id);
							prepartion_qty		   = (String)un_finalised_val.get(0);
							qty_avail_from_spillage= (String)un_finalised_val.get(1);
							qty_drawn_from_stock   = (String)un_finalised_val.get(2);

							 qty_required_per_order =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
						  
						}
					 }
					 else{
						 bean.setFinalized_yn("Y");
						 if(tot_disp_qty>0){						
								prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
								qty_drawn_from_stock	=  prepartion_qty;
								qty_avail_from_spillage = "0";									
						 }


					 }	
				}else {
					if(worksheet_id!=null && !worksheet_id.equals("")){	
						//finalised_yn = bean.getWorksheetFinalisedYN(worksheet_id,bean.getDispLocnCode(),facility_id);
						if((bean.getDispStage().equals("F") && (bean.getFillingStatus().equals("A")  ))|| (bean.getDispStage().equals("A") && (bean.getFillingStatus().equals("B")  ))){			
							finalised_yn ="N";

						}else{
							tot_disp_qty        =   bean.getTotalDispQtyForWorkSheet(order_id,order_line_no,facility_id);
							if(tot_disp_qty>0){
							   finalised_yn ="Y";
							} 

						}	
					    //qty_required_per_order  =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";

						if(finalised_yn.equals("Y")){	
							
								HashMap ht_ws_allocated_drugs  =  bean.getAllAllocatedDrugs();
								if(!ht_ws_allocated_drugs.containsKey(drug_code)){
									if(!prepartion_qty.equals("")){
										//prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
										prepartion_qty			= qty_required_per_order;
										qty_drawn_from_stock	=  prepartion_qty;
										qty_avail_from_spillage = "0";
									}
								}				
					   }else{	
						   
								un_finalised_val = null;
								un_finalised_val = bean.getDataForUnFinalisedWorksheets(worksheet_id,bean.getDispLocnCode(),order_line_no,facility_id);
								prepartion_qty		   = (String)un_finalised_val.get(0);
								qty_avail_from_spillage= (String)un_finalised_val.get(1);
								qty_drawn_from_stock   = (String)un_finalised_val.get(2);
						}
					 }
					 else{
						 bean.setFinalized_yn("Y");
						  if(tot_disp_qty>0){	
							    qty_required_per_order  =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
								prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
								qty_drawn_from_stock	=  prepartion_qty;
								qty_avail_from_spillage = "0";									
						 }
					 }		
				}
		 }

         if(finalised_yn.equals("N")&&!patient_class.equals("I")) {
			 status="disabled";
		 } 


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sbRatioPercentLegend.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_name_size));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(width_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(width_text));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qty_required_per_order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(prepartion_qty));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(prepartion_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qty_required_per_order));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(status));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(qty_avail_from_spillage));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(qty_required_per_order));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(prepartion_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_spill_qty));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(qty_drawn_from_stock));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(status.equals("disabled")){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);

		if(drug_form.equals("P")){

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rf_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rf_name_disabled));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rf_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fluid_qty_as_per_order));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,rf_qty_uom)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fluid_qty_preparation));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,rf_qty_uom)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(retunFormatedInt(fluid_qty_spillage)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_spill_qty));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,rf_qty_uom)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(retunFormatedInt(fluid_qty_drawn)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,rf_qty_uom)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(display));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(lbl_stock_qty));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(display));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,lbl_stock_qty_uom)));
            _bw.write(_wl_block58Bytes, _wl_block58);
if(status.equals("disabled")){
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
 } 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allowchangetradenameyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allowmultitradeyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allow_short_expiry_drugs_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(status));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_form));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(multi_strength));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rf_qty));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(tot_num_of_drugs));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tot_disp_qty));
            _bw.write(_wl_block83Bytes, _wl_block83);
            _bw.write(_wl_block2Bytes, _wl_block2);

putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculationSection.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyRequiredasperorder.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparationQuantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyAvailablefromLeftOver.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyTobedrawnfromStock.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocBatches.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocBatches.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReconstituentFluid.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocBatches.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocBatches.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ShowBatches.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}

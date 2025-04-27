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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationadministrationftdrugdtlsiv extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationFTDrugDtlsIV.jsp", 1740542464773L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t <head>\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n\t\t<style>\n\t\t.descFont{\n\t\t\tfont-size:9;\n\t\t\tfont-weight:bold;\n\t\t\tcolor:black;\n\t\t}\n\t\t</style>\n\t </head>\n\t <body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t<img id=\"ball\" src=\"/images/ball.png\" style=\"visibility:hidden\" height=\"5\"/>\n\t\t<div id=\"headStart2\" >  \n\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\"  noresize>\n\t\t<tr id=\"iv_admin_table_row1\">\n\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\"  width=\"28%\"><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\" width=\"4%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"9%\"><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"8%\"><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"10%\"><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"7%\"><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</B></td>\n\t\t<td nowrap class=\"TDSTYLE\" width=\"11%\"><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td><!-- Modified for HSA-CRF-0090[IN041241] -->\n\t\t<td class=\"TDSTYLE\" width=\"9%\"><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n\t\t<td class=\"TDSTYLE\" width=\"12%\"><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</B></td>\n\t\t<td class=\"TDSTYLE\"><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\'  colspan=\"16\"   style=\"font-size:10\"><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td id = \'medAdminIV";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  onclick=\"\">&nbsp;</td>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  onclick=\"enableIVAdmin(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">&nbsp;</td>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' class=\"white\" width=\"2%\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"\">\n\t\t\t\t<td id = \'drugIndi";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" style=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<label id=\'drug_mast_det_old";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' style=\"font-size:9;font-weight:bold;color:black;display:inline\" title=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" &nbsp;&nbsp;</label>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<label  id=\"drug_mast_det_1";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">&nbsp;</label>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<label id=\"drug_mast_det_1";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;display:none\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" >&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<label id=\'drug_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' style =\"display:none\" class=\'descFont\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;&nbsp;</label>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\" title=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></img>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' onclick = \"callADRdetails(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\"></img>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<img src=\'../../eCA/images/HI_RecordAllergies.gif\' width=\'17\' height=\'15\' onclick = \"showAllergyDetails(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t<br><label style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </label>\n\t\t\t\t\t<input type=\"hidden\" name=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t</label>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" width=\"2%\"><img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" width=\"2%\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td> \n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" width=\"2%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" width=\"50%\" height=\"60%\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\',\'N\')\" title=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="></img>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="                            \n\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"><label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\',\'\',\'MAR\',\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',\'N\',\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\');\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</label></td>\n ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\',\'MAR\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</label></td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t<label id=\'qty_old";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' style=\"font-size:10\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t</label>\n\t\t\t\t\t\t<input type=\"text\" id=\"iv_admin_qty_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" size=\"1\" maxlength=\"4\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"  ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" class=\"number\" style=\"display:none;font-size:11;\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this);changeDisplay(this,\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\');getHrsMinStr(\'TAKE\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\',\'iv\',\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\');\">\n\t\t\t\t\t\t<label id=\'qty_uom_old";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' style=\"font-size:10;align:center\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</label>\n\t\t\t\t\t\t<label id= \'qty_uom";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' style=\"font-size:10;display:none;\" ><b>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</b></label>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' style=\"font-size:10;\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</label>\n\t\t\t\t\t\t<input type=\"text\" id=\"iv_admin_qty_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' style=\"font-size:10;align:center;\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</label>\n\t\t\t\t\t\t<label id = \'qty_uom";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t<img src=\"../images/changeddosageindicator.gif\" align=\"center\" id=\"chng_dose_ind\" title=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="-----------";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"iv_qty_uom_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"  >\n\t\t\t\t\t\t<label style=\"font-size:10;";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >[<b>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="/";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</b>]</label>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"iv_modified_date_time_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"iv_infusion_period_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"could_not_administer_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" id=\"could_not_administer_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"><!-- added for SKR-SCF-1240-->\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t<td style=\'background-color:";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =";\'><label style=\"font-size:10;color:";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =";\"> ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</label>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="<br><div id=\"orderctl";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" onClick=\"\"><label id=\"orderctllink";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="display:none\"><b>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="<b><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'></label></div>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" onClick=\"displayToolTipSFR(\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\')\" onMouseOver=\"hideToolTip(\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\')\"><label id=\"orderctllink";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="<b><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' name=\'imgArrow";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"  >\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t<label style=\"font-size:10;\" >";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</label>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\t\t\t\t\n\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t\t<label id=\'admin_date_time_old";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' style=\"font-size:10;";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" title=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" :";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</label>\n\t\t\t\t\t<input type=\"text\" id=\'iv_infusion_st_time_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" size=\"13\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" style=\"font-size:11;\" onBlur=\" validateAdminDateTime(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\', this,\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\');\" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" style=\"display:none\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t\t<label id=\"iv_flow_rate_old";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"  style=\"font-size:10;align:center;";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</label>\n\t\t\t\t\t<label id=\"iv_flow_rate_desc_old";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" style=\"font-size:10;align:center;";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</label>\n\t\t\t\t\t<input type=\"text\" id=\"iv_flow_rate_";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" size=\"2\" maxlength=\"9\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" class=\"number\" style=\"font-size:11;color:blue\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this);changeDisplay(this,\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\')\" style=\"display:none\" ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =">\n\t\t\t\t\t<label id=\"iv_flow_rate_desc";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" style=\"font-size:10;\" style=\"display:none\"><b>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</b>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t\t<label id=\"iv_infusion_period_txt_old";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" style=\"font-size:10;\"><script language=\"javascript\">document.write(getHrsMinStrForAdminYES(";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =",\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'));</script></label>\n\t\t\t\t\t<label id=\"sch_inf_per_old";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" style=\"font-size:10;\">";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</label>\n\t\t\t\t\t<input type=\"text\" id=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" name=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" size=\"1\" maxlength=\"6\" value=\"\" style=\"font-size:11;display:none\" disabled class=\"number\">\n\t\t\t\t\t<label id=\"sch_inf_per_desc";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" style=\"font-size:10;display:none\"><b>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="<div id=\"sch_inf_per_";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">&nbsp;</div></b></label>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t\t<label id=\"iv_batch_id_old";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" style=\"font-size:10;\">&nbsp;";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t<input type=\"text\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" style=\'display:none\' name=\"iv_batch_id_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"  disabled >\t   \n\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" id=\"previous_batch_id_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" id=\"previous_exp_date_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" id=\"previous_trade_id_";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" value=\"\">\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t\t<input type=\"text\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" style=\"font-size:11;\" disabled >\n\t\t\t\t\t\t\t<input type=\"button\" style=\'display:none\' class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\');callMednBatchSearch(\'iv_batch_id_";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\',\'iv_expiry_date_";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\',\'iv_trade_name_";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\',\'iv_trade_id_";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\',\'iv_bin_code_";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\',\'iv_infusion_period_";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\',\'IV\',\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\')\" id=\"iv_batch_id_but_";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" name=\"iv_batch_id_but_";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" >\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" id=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" value=\'IV_Y\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" style=\"font-size:11;\" disabled >\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" style=\'display:none\' onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\')\" ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" disabled id=\"iv_batch_id_but_";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t\t\t\t<!-- code added for recording batch_id in ph_medn_admin_dtl -->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" size=\"9\" maxlength=\"10\" value=\"\" style=\"font-size:11;\" disabled >\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" style=\'display:none\' onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\t\t<select id=\"iv_batch_id_";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" style=\"font-size:11;\" onChange=\"assignBatchDetails(\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\',\'IV\',this,\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\')\">\n\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="---</option>\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t\t\t\t\t<option selected value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</option>\n\t\t\t\t\t\t\t\t\t<!-- code added for recording batch_id in ph_medn_admin_dtl -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</option>\n";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" id=\"iv_Remarks";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" value=\"N\">\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t\t\t<label id=\"iv_expiry_date_old";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" name=\"iv_expiry_date_old";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</label>\n\t\t\t\t\t<input type=\"text\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" id=\"iv_expiry_date_";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" size=\"9\" maxlength=\"10\" disabled value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" style=\"font-size:11;display:none\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" style=\"display:none\">\n\t\t\t\t\t<label style=\"font-size:10;\">&nbsp;";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</label>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" colspan=6 id=\"MFR_status_column_";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="<label name=\"iv_MFR_dtls_";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" id=\"iv_MFR_dtls_";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openMFRDetails(\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\',\'Admin\',\'\');\">";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" <br>";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" >\n\t\t\t\t\t\t<input type=\"checkbox\" style=\'display:none\' name=\"iv_chk_complete_";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" id=\"iv_chk_complete_";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" value=\"E\" checked onClick=\"clearDrgRemarks(this,\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\',\'IV\')\">\n\t\t\t\t\t\t<label id=\"iv_lb_dtls_old";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" style=\"font-size:10;color:black;\" title=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="</label>\n\t\t\t\t\t\t<label id=\"iv_lbl_dtls_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" name=\"iv_lbl_dtls_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;display:none;\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\',\'IV\',\'A\',\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\',iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\')\">";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</label>\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"iv_remarks_mand_id_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" style=\"display:visible\"></img>\n";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t\t\t\t\t<br><label id =\"iv_lb_dtls_";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openAuditLogWindow(\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\',\'SFR\');\">";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" >\n\t\t\t\t\t\t<!--added for AAKH-CRF-0024 [IN:038260] start-->\n\t\t\t\t\t\t<input type=\"checkbox\" style=\'display:none\' id=\"iv_chk_complete_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" name=\"iv_chk_complete_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\',\'IV\')\">\n\t\t\t\t\t\t<label id =\"iv_lb_dtls_old";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" name=\"iv_lb_dtls_";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" style=\"font-size:10;color:black;align:center;\" title=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" >";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;display:none\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" style=\"display:none\"></img>\n\t\t\t\t\t\t<img src=\"../../ePH/images/return.gif\" id=\"nxt_adm_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" style=\"display:none\"><!--added for AAKH-CRF-0024 [IN:038260] Ends-->\n";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" >&nbsp;\n\t\t\t\t\t<label id=\"iv_lbl_dtls_";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" style=\"display:none\"></img>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\t\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" id=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"><!--added for AAKH-CRF-0024 [IN:038260] start-->\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" id=\"iv_drug_code_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" id=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" id=\"iv_item_code_";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\" id=\"iv_prep_yn";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\"  value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" id=\"iv_order_id_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" id=\"iv_order_line_no_";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_store_code_";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" id=\"iv_store_code_";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" id=\"iv_end_date_";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\"   value=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" id=\"next_schd_date_";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" id=\"iv_drug_class";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" id=\"iv_admin_date_time_";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" id=\"iv_dtls_yn";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" value=\"Y\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_pract_id_";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" id=\"iv_order_pract_id_";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\" id=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" id=\"iv_trade_name_";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" size=\"21\" maxlength=\"40\" disabled value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" style=\"font-size:11;\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" id=\"iv_trade_id_";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" id=\"iv_bin_code_";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" value=\"\">\t\t\t<!--added for AAKH-CRF-0024 [IN:038260] End-->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n\t\t\t\t<label id =\'chk_iv_select_old";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\' style=\"font-size:10;\">&nbsp;</label>\n";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t\t\t<input id=\"chk_iv_select_";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" style=\'display:none\' type=\"checkbox\" name=\"chk_iv_select_";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" value=\"E\"  onClick=\"checkIVGroup(\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\',this,\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\')";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" ";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 =">\n       ";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n       <img src=\"../../ePH/images/cancelAdmin.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel Admin\" onclick=\"cancelAdminstration(\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\')\"></img></td>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" value=\"E\"  disabled>\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" id=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_drug_desc";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" id=\"iv_drug_desc";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" id=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\" id=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\" id=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" id=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" id=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" id=\"inf_prd_hrs";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\" id=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\" id=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\" id=\"iv_dosage_type_";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\" id=\"inf_prd_min";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\" id=\"completedMinutes";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\" id=\"completedFlow";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\"><!--added for AAKH-CRF-0024 [IN:038260] ends-->\n\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\n\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\tgetHrsMinStr(\'TAKE\',\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\')\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t\t\t\t\t<td class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\n\t\t\t\t\t<td class=\"white\" width=\"2%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\">\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"iv_store_code_";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\');\" id=\"drug_mast_det_1";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\n\t\t\t\t<label style=\"font-size:10;align:center\">";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n\t\t\t\t</label>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\')\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n\t\t\t\t\t\t<br> <label id=\'iv_link_vaccine_label_";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\' style=\"font-size:10;\" title=\'";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\'> ";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 =" <input type=\'text\' size=10 name=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\' id=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\' value=\'";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\' disabled><input type=\'button\'  class=\'button\' value=\'?\' name=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\' id=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\' onClick=\"linkVaccine(\'iv\',\'";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\')\"></label>\n\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\" id=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" value=\'";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\'>\n";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\">&nbsp;</td>\n\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 =" \n\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\n\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\" id=\"iv_admin_qty_";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\"  >&nbsp;</td>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 =" class=\"number\" style=\"";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="font-size:11;\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this);changeDisplay(this,\'";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\');\">  \t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\" value=\"N\">\n\t\t\t\t\t<label style=\"font-size:10;\" ><b>";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="</b></label>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\" >\n";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\">[<b>";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="</b>]</label>\n";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\n\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t\t\t\t\t\t\t\t\t\t<td style=\'background-color:";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\" onClick=\"\"><label style=\"";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\"><b>";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td style=\'background-color:";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\')\"><label style=\"";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\',\'NotAdmin\',\'\');\">";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="</label>&nbsp;&nbsp;&nbsp;&nbsp <a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\',\'Y\');\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\'>&nbsp;&nbsp;&nbsp;<font color=\"red\"><b>";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="</b></font></a>";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" style=\"font-size:10;color:black;align:center;\" onClick=\"\">";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\" id=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\" id=\"iv_flow_rate_";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" value=\"0\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\" id=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\"> <!-- added for SKR-SCF-0215 [IN:029303] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_dosage_uom_code_";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\"><!-- added for SKR-SCF-1240-->\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\" id=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" value=\"\">\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\" id=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_mfrRemarks";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\" id=\"iv_mfrRemarks";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\">\t\t\n";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\"><label  style=\"font-size:9;color:black\" >";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 =" style=\"";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\">\t<!-- added for SCF-7528-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\')\" style=\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 =">\n\t\t\t\t\t<label style=\"font-size:10;\" style=\"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="</b>\n\t\t\t\t\t</label>\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\"> <!-- added for SKR-SCF-0215 [IN:029303]-->\n\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\"><!-- added for SKR-SCF-1240-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"iv_infusion_period_txt";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" size=\"1\" maxlength=\"6\" value=\"\" style=\"font-size:11;\" disabled class=\"number\" style=\"";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\">\n\t\t\t\t\t<label style=\"font-size:10;\" style=\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\">&nbsp;</div></b></label>\n\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td nowrap class=\"";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\"><!-- Modified for HSA-CRF-0090[IN041241] -->\n";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\' id=\'iv_shared_drug_";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090 -->\n\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\"  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\" size=\"9\" maxlength=\"10\" value=\"\" style=\"font-size:11;\" disabled ><input type=\"button\" class=\"button\" value=\"?\"  onClick=\"calcQuantityInDispensingUOM(\'IV\',\'";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_barcode_id_";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\" id=\"iv_barcode_id_";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\"><!-- CRF-413.8-->\n";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\t\t\t\t\t\t\t<input type=\'hidden\' name=\'iv_shared_drug_";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t<select name=\"iv_batch_id_";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_barcode_id_";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="_";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"barcode_check_";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" id=\"barcode_check_";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" onclick=\"openBarcodeSFRWidow(\'";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\')\"><!-- for CRF-413.8--> \n";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\n\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\" style=\"font-size:11;\">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\" style=\"display:none\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" style=\"font-size:11;\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\" value=\"\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\t\n\t\t\t\t\t<input type=\"checkbox\" name=\"iv_chk_complete_";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\',\'IV\')\">\n\t\t\t\t\t<label name=\"iv_lbl_dtls_";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</label><!-- ";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 =" passed to this method enterRemarks() for SCF-7528 -->\n\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"iv_remarks_mand_id_";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" style=\"display:visible\"></img><!-- made display:visible for IN26641 --23/02/2011-- priya -->\n\t\t\t\t\t<img src=\"../../ePH/images/return.gif\" id=\"nxt_adm_";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\" style=\"display:none\">\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\n\t\t\t\t&nbsp;<input type=\"hidden\" name=\"iv_mand_symbol_";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" id=\"iv_mand_symbol_";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\" value=\"style=\'display:inline\'\">\n";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\n\t\t\t\t\t<label style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openAuditLogWindow(\'";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"chk_iv_select_";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\" id=\"chk_iv_select_";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 =">\n";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" id=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_order_pract_id_";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\"> <!-- //Added for [IN:040149]-->\n\t\t\t\t<input type=\"hidden\" name=\"drug_count_";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\" id=\"drug_count_";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\"><!-- CRF-413.8-->\n\t\t\t\t<input type=\"hidden\" name=\"iv_batch_ids_";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\" id=\"iv_batch_ids_";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\"><!-- CRF-413.8-->\n\t\t\t\t<input type=\"hidden\" name=\"iv_sch_date_time_";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\" id=\"iv_sch_date_time_";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\"><!-- CRF-413.8-->\n\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t\n";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\t\t\t\t\t<script>\n\t\t\t\t\tif(eval(document.getElementById(\"orderctl\"+\'";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\'))){\n\t\t\t\t\t\teval(document.getElementById(\"orderctl\"+\'";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\')).style.display =\"none\";\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(document.getElementById(\"iv_MFR_dtls_\"+\'";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\')))\n\t\t\t\t\teval(document.getElementById(\"iv_MFR_dtls_\"+\'";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\')).style.display = \"none\";\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\')\n\t\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\t\t\n\t\t</table></div>\n";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\n<input type=\"hidden\" name=\"iv_records_iv\" id=\"iv_records_iv\"\tvalue=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\"/>\n<script>\ndocument.forms[0].iv_records.value=document.forms[0].iv_records_iv.value;\n</script>\n";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );
	
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
--------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name		   Rev.Date   	 Rev.By 	   Description
07/03/2019    IN067953         Devindra       ?           ?            MMS-KH-CRF-0014 
07/07/2019             Manickavasagam       ?           ?            SKR-SCF-1240 
19/08/2019		IN071056		Manickavasagam				 		SKR-SCF-1264
23/06/2020    IN073263        Prabha								  SKR-SCF-1375
09/10/2020    IN74073        Manickavasagam J								  SKR-SCF-1440
31/01/2021    TFS:12662	     Manickavasagam J			     MMS-KH-CRF-0039
*/ 

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	 request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

	 String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String locale = (String) session.getAttribute("LOCALE");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String str_row_no				=	 request.getParameter("row_no")==null?"0":request.getParameter("row_no");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String Auto_Admin				=    "";
		String admin_from_date			=	 request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
		String admin_to_date			=	 request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		if(!locale.equals("en") && (function_from.equals("CP") || function_from.equals("CA"))){ //function_from Added for RUT-SCF-0323 [IN:044818]
			admin_from_date = com.ehis.util.DateUtils.convertDate(admin_from_date, "DMYHM",locale,"en");
			admin_to_date = com.ehis.util.DateUtils.convertDate(admin_to_date, "DMYHM",locale,"en");
			from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMYHM",locale,"en");
			to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMYHM",locale,"en");
		}
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");
		String callFrom					=	 request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String  recCount1 					=  request.getParameter("recCount")==null?"":request.getParameter("recCount");
		int recCount =Integer.parseInt(recCount1);
		boolean boolAllergy_icon		=	false;	//Added for RUT-CRF-0065.1 [IN:43255]
		String 	strAllergyreason =	"",generic_id="",generic_name="";//Added for RUT-CRF-0065.1 [IN:43255]
		String disp_schedule_uom_desc="", admin_uom_desc = "";
		float ret_qty=0;//added below Variables  for incident NO:33194
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;// adding end
		DecimalFormat dfTest = new DecimalFormat("0.########");
		if(route_admin.equals("undefined")){
			route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			admin_route_categ="";
		}
		String drugCode					=    "";
		String selDateTime				=    "";
		String flag						=    "";
				
		String ward_ack_yn = "";//GHL-CRF-0458
		String patient_class_ord = "";//GHL-CRF-0458
		if(mode!=null && mode.equals("NOTIME")){
			drugCode					=	request.getParameter("drug_code");
			selDateTime					=	request.getParameter("selDateTime");
		}
		if(function_from.equals("CP")){
			drugCode					=	request.getParameter("p_ord_drug_code");
			mode						=	"CP";
		}
		int row_no								= Integer.parseInt(str_row_no);
		String bean_id_all_stages				= "DispMedicationAllStages" ;
		String bean_name_all_stages				= "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
		bean_all_stages.setLanguageId(locale);
		bean_all_stages.setModuleId("1");
		ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
		String bean_id							= "MedicationAdministrationFTBean";
		String bean_name						= "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
		bean.setLanguageId(locale);
		bean.setCurrentTimeAndAdminWithinHRS();
		//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]		
		boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
		boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
		String drug_search_bean_id				= "DrugSearchBean";
		String drug_search_bean_name			= "ePH.DrugSearchBean";
		DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
		drug_bean.setLanguageId(locale);
		ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
		String current_date_time				= (String)result.get(0);
		String AdminBackLogTime					= "";
		if(admin_from_date.equals(""))	
			AdminBackLogTime					= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));		
		else
			AdminBackLogTime					= admin_from_date;
		HashMap drug_details					= new HashMap();					
		String order_id							= "";
		String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
		String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
		String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
				String cancel_recorded_yn="N";//added for jd-crf-0200
		userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 
		if(!callFrom.equals("RELOADTAPER"))
			bean.clearDrugDetails();
		if(bean.getDrugDetails_Added() == null ){   //Added for RUT-CRF-0088 [IN036978]
			if(mode!=null && (mode.equals("NOTIME") || mode.equals("CP"))){
				String shedule_date_time			= request.getParameter("shedule_date_time");
				order_id							= request.getParameter("order_id");
				if(function_from.equals("CP")){	
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					shedule_date_time				 =	request.getParameter("p_start_date_time");
					order_id					     =	request.getParameter("order_id");
				} // Function from CP loop ends	
				drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,"",hold_discontinue_yn,administration_status,order_type,display_order_by,route_admin,admin_route_categ,patient_id_test,"");// added	patient_id_test and "" string for the incident IN037217 and removed drugcode for SKR-SCF-1172		 
				bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
			}	// Mode from CP loop ends
			else{	 
				drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,admin_from_date,admin_to_date,hold_discontinue_yn,administration_status,order_type,to_time,from_time,display_order_by,route_admin,admin_route_categ);
				bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
			}   
		}
		else{   //Added for RUT-CRF-0088 [IN036978]
			drug_details		  = bean.getDrugDetails_Added();
		}	
		String iv_prep_yn			   =	"";
		String title				   =	"";
		if(!order_type.equals("A")){
			iv_prep_yn				=  drug_details.get("iv_prep_yn")==null?"":(String)drug_details.get("iv_prep_yn");
			if(function_from.equals("CP"))
				iv_prep_yn	=	bean.IVType(order_id);
			if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
				title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
			else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
				title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
			else
				title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
		} //if ends 
		ArrayList iv_drug_details				    =	 (ArrayList) drug_details.get("IV");
		String admin_bean_id						=	  "MedicationAdministrationBean";
		String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
		MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		admin_bean.setLanguageId(locale);
		String totalTaperQtyDisplay = admin_bean.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
		String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
		String shared_drug_disp = "";
		if(allowMAR_share_drug==null || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
			shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end

		admin_bean.setNursingUnit(nursing_unit);
		admin_bean.setPatientId(patient_id_test);
		admin_bean.setEncounterId(encounter_id);
		admin_bean.setBedNo(assign_bed_num);
		HashMap defaultValues				=	new HashMap();
		defaultValues						=	admin_bean.getNONIVDrugDetails();
		String	defaultDate					=	"";
		String  defaultBatch				=	"";
		String	defaultTradeId				=	"";
		String	defaultExpiryDate			=	"";
		String schedule_uom_desc			=   "";
		String schedule_uom_code			=   "";
		if (defaultValues.containsKey(selDateTime)){
			try{
				ArrayList alreadyEnteredValues=(ArrayList)defaultValues.get(selDateTime);
				defaultDate				=	(String)alreadyEnteredValues.get(2)==null?"":(String)alreadyEnteredValues.get(2);
				defaultBatch			=	(String)alreadyEnteredValues.get(9)==null?"":(String)alreadyEnteredValues.get(9);
				defaultExpiryDate		=	(String)alreadyEnteredValues.get(10)==null?"":(String)alreadyEnteredValues.get(10);
				defaultTradeId			=	(String)alreadyEnteredValues.get(11)==null?"":(String)alreadyEnteredValues.get(11);
			}
			catch (Exception e){
				defaultDate			="";
				defaultBatch		="";
				defaultExpiryDate	="";
				defaultTradeId		="";
			}
		} 
		int tot_records						=   0;		
		int altRecCount						=   0;		int newRecCount		 = 0;
		int ivRecCount						=   0;		
		String patient_id					=   "";
		int no_of_alt_drus_selected			=   0;	
		String stat_style					=   "";
		String store_code	  =	"";
		String drug_class					=   "";		String drug_class_ind = "";
		String  short_desc					=   "";	
		String  drug_code					=   "";
		String  disp_drug_code				=   "";
		String  uom_code					=   "";
		String  drug_desc					=   "";		String  qty			  = "";
		String encode_drug_desc				=   "";
		String ordered_qty					=   "";		String  batch_id	  = ""; 
		String  expiry_date					=   "";		String  tradename	  =	"";	                     
		String  item_code					=   "";		order_id		      = "";
		String order_line_num				=   "";		ArrayList batch_ids   = new ArrayList(); 
		String sch_date_time				=   "";		
		String trade_id						=   "";		String dis_continued  = "";
		String hold							=   "";		String administered   = "";
		String could_not_administer ="";//Added for AAKH-CRF-0024 [IN:038260]
		String admin_recorded_yn			=   "";		String remarks		  =	"";
		String admindrugdetails				=   "";
		String admin_drug_code				=   "";		String admin_drug_desc=	"";
		String Store_locn_code				=	"";
		String sch_date_time_in_locale		=	"";
		String Storelocn_code				=	"";
		String iv_incred					=	"";
		String iv_incred1					=	"";
		String iv_incred2					=	"";
		String route_desc					=	"";
		String pres_catg_code				=   "";
		String pres_base_uom				 =  "";		//added for SKR-SCF-0304
		boolean auth_reqd					=   false;
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
		String route_color 	=   "";   // Code Added For RUT-CRF-0034 Start
		String fntColor                     =   "#OOOOOO";
		String backGrndColor                =   "#FFFFFF";   // Code Added For RUT-CRF-0034 End
		String order_pract_id 	=   "";  //Added for [IN:040149]
		String bat_id_lookbutton_enabled="Y", auto_Admin_dis="", verbalOrder="";
		String pin_value=bean.getPinNumber();
		DecimalFormat dfToInteger = new DecimalFormat("####.##");
		ArrayList work_sheet_batch_det1		=	new ArrayList();
		ArrayList sliding_scale_details		=	new ArrayList();
		int temp1                           =   0;
		int temp2                           =   0;		
		int temp3                           =   0;		
		int inc								=   0;
		float dialog_height					=	0;
		HashMap overridereason				=	new HashMap();
		int ppn_count						=   0;
		String taper_yn	=	 "N", addedTaperSch="";  //Added for RUT-CRF-0088 [IN036978]
		ArrayList totQty =null,  WardReturnQty= null;
		String dispensed_drug_desc="", disp_drugs="", dispense_drug_code="";
		
	if(iv_drug_details.size()>0){

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
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
		String admin_date_time			=	"";
		String modified_date_time		=	"";
		String showTitle				=	""; 
		String displayStyle				=   "";
		String classvalue						=	"";
		String unit_dose				=   "";
		String no_of_doses				=   "";
		String dosage_seq_no			        =   "";
		String hide_ingredient_dtls		=   "";
		String prod_name				=	"";
		String cmp_flag                 =   "";
		String sch_infusion_in_min      =   "";
		String tol_title                =   "";
		String administred_batch_id     =   "";
		String disp_batch_id		    =   "";
		String iv_no_of_drug_per_order  =   "1";
		String MfrYN					=	"N";
		String sfrFLOW_STATUS			=	"";//single flow rate
		String sfrHOLD_DATE_TIME		=	"";
		String sfrHOLD_DURN_IN_MINS		=	"";
		String sfrRESUME_DATE_TIME		=	"";
		String sfrACT_START_DATE_TIME	=	"";
		String sfrACT_END_DATE_TIME		=	"";
		String mfrRemarks				=	"";
		String completedMinutes			=	"0";
		String completedFlow			=	"0";
		String iv_order_pract_id        =""; //Added for [IN:040149]
		String sch_dosage_uom_code	    = ""; //SKR-SCF-1240
		boolean mfrCompletedStatus		=	false;
		ArrayList MfrDetails			=	new ArrayList();
		ArrayList work_sheet_batch_det	=   new ArrayList();
		String drug_count = "1";
		for(int i=0;i<iv_drug_details.size();i+=74){//73 changed to 74 for JD-CRF-0200
			iv_order_pract_id  =  (String)iv_drug_details.get(i+68)==null?"":(String)iv_drug_details.get(i+68); //Added for [IN:040149]
			generic_id = (String)iv_drug_details.get(i+69)==null?"":(String)iv_drug_details.get(i+69); // Added for RUT-CRF-0065.1 [IN:43255]
			linkVacScheduleCode			="";
			dosage_seq_no				= iv_drug_details.get(i+36)==null?"":(String)iv_drug_details.get(i+36);
			pres_catg_code =iv_drug_details.get(i+49)==null?"":(String)iv_drug_details.get(i+49);
			auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
			auth_reqd_script="";
			could_not_administer = "";//added for SKR-SCF-1264
			if(auth_reqd){
				if(pin_value.equals(""))
					auth_reqd_script=";pinAuthentication(this,'NP');";
				else
					auth_reqd_script=";pinAuthentication(this,'YP');";
			}
			pract_id					= (String)iv_drug_details.get(i+37);
			against_sch_date			= (String)iv_drug_details.get(i+38);
			adr_reason					= (String)iv_drug_details.get(i+39);
			adr_remarks					= iv_drug_details.get(i+40)==null?"":(String)iv_drug_details.get(i+40);
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
			sch_infusion_per_unit		= (String)iv_drug_details.get(i+3)==null?"":(String)iv_drug_details.get(i+3);
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
			drug_code                =   (String)iv_drug_details.get(i+29);//pres_drug_code
			dispense_drug_code       =   (String)iv_drug_details.get(i+72);
			if(dispense_drug_code.equals(""))
				dispense_drug_code = drug_code;
			dispensed_drug_desc	     =   (String)iv_drug_details.get(i+70);	
			disp_drugs			     =   (String)iv_drug_details.get(i+71);	
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
			administered			 =	 (String)iv_drug_details.get(i+22);
			store_code				 =   (String)iv_drug_details.get(i+30);
			end_date_time 			 =   (String)iv_drug_details.get(i+33);
			freq_code				 =   iv_drug_details.get(i+34)==null?"":(String)iv_drug_details.get(i+34);		
			
			if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_num.equals("1")))){//SKR-SCF-1397 and iv_prep_yn and order_line_num added for SKR-SCF-1421
				no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num,iv_prep_yn,drug_code);
			}else{
				no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num);
			}
			encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
			encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
			ext_prod_id              =   (String)iv_drug_details.get(i+44);
			iv_no_of_drug_per_order  =   (String)iv_drug_details.get(i+45);
			trade_code			     =   (String)iv_drug_details.get(i+46);
			imageFileURL			 =   (String)iv_drug_details.get(i+47);
			sch_dosage_uom_code	     =   (String)iv_drug_details.get(i+51); //SKR-SCF-1240
			admn_dose_chng_reason_code = (String)iv_drug_details.get(i+52);
			Store_locn_code			 =	(String)iv_drug_details.get(i+65)==null?"":(String)iv_drug_details.get(i+65);
			 String iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
			cmp_flag				 =   bean.syscomp(com.ehis.util.DateUtils.convertDate(end_date_time,"DMYHM",locale,"en"),order_id,order_line_num);
			next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
			linkVacScheduleCode		 =	(String)iv_drug_details.get(i+53);
			MfrYN					 =	(String)iv_drug_details.get(i+54)==null?"N":(String)iv_drug_details.get(i+54);
			sfrFLOW_STATUS			 =	(String)iv_drug_details.get(i+55)==null?"NS":(String)iv_drug_details.get(i+55);
			sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(i+56)==null?"":(String)iv_drug_details.get(i+56);
			sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(i+57)==null?"0":(String)iv_drug_details.get(i+57);
			sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(i+58)==null?"":(String)iv_drug_details.get(i+58);
			sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(i+59)==null?"":(String)iv_drug_details.get(i+59);
			cancel_recorded_yn=(String)iv_drug_details.get(i+73)==null?"N":(String)iv_drug_details.get(i+73);//added for jd-crf-0200
			//Added IF-Condition for converting date on 8/10/2010 regarding incident num:24067.==By Sandhya
			if(!(sfrACT_START_DATE_TIME.equals(""))){
				sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
			} //Ends
			if(sfrACT_START_DATE_TIME.equals("")){
				sfrACT_START_DATE_TIME=current_date_time;
			
			}
			//added for GHL-CRF-0458 - start
			if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){// isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for 
			patient_class_ord = bean.getOrderPatientClass(order_id);
			if(patient_class_ord==null)
				patient_class_ord = "";
			}
			//added for GHL-CRF-0458 - end
			sfrACT_END_DATE_TIME	 =	(String)iv_drug_details.get(i+60)==null?"":(String)iv_drug_details.get(i+60);
			dosage_type				 =	(String)iv_drug_details.get(i+61)==null?"":(String)iv_drug_details.get(i+61);
			mfrRemarks				 =	(String)iv_drug_details.get(i+62)==null?"":(String)iv_drug_details.get(i+62);
			completedMinutes		 =	(String)iv_drug_details.get(i+63)==null?"0":(String)iv_drug_details.get(i+63);
			completedFlow			 =	(String)iv_drug_details.get(i+64)==null?"0":(String)iv_drug_details.get(i+64);
			int adr_count			= bean.getADRCount(patient_id_test,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 

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
				String linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
				if(!linkVacScheduleCode1.equals("NO DEFAULT")){
					try{
						String[] vacScheduleDetails;
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
					String[] vacScheduleDetails;
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
			if(freq_nature.equals("P") || bean.enableSelect(com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en"), admin_from_date,admin_to_date) || function_from.equals("CP")) {
				select_status	=	"";
				dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
			}
			else{
				select_status	=	"disabled";
				dtl_style		=	"visibility:hidden";
				mand_display	=	"style='display:none'";
			}

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
			remarks = iv_drug_details.get(i+24)==null?"Not Entered":(String)iv_drug_details.get(i+24);				
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
			if( freq_code.equals("STAT")) //added by abdul for SCF# 5899
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
			ArrayList iv_batch_ids = new ArrayList();
			HashMap  administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id, sch_date_time ,drug_code);
			administred_batch_id = (String)administred_batch.get("BATCH_ID");						
			if(administred_batch_id == null)administred_batch_id="";
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
			boolAllergy_icon = false;// Added for RUT-CRF-0065.1 [IN:43255]
			if(ext_prod_id!=null && !ext_prod_id.equals("")){										
				if(overridereason.size()>1)
				   show_remarks="Y";
				strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
				if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
					boolAllergy_icon = true;
			}
			else{									
				if(overridereason.size()>0)
					   show_remarks="Y";
				strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
				if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
					boolAllergy_icon = true;
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
			} // end else 
			if(admin_recorded_yn.equals("Y")){
				if(order_line_num.equals("1"))
					classvalue="IVFLUID1";
				else
					classvalue="IVINGREDIENT1";
				
				//added for SKR-SCF-1375
				if(could_not_administer.equals("Y")){ // added for SKR-SCF-1431
				iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"Y");
				if(iv_batch_ids!=null && iv_batch_ids.size()>0)
					batch_id = (String)iv_batch_ids.get(0);
				} 
				//added for SKR-SCF-1375

            _bw.write(_wl_block24Bytes, _wl_block24);
 
                if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
	                  select_status="disabled";
	                   displayStyle = "";	
	                   sfrFLOW_STATUS_style ="font-size:8;align:center;";
                } // Added for KH-SCF-0010 - End
				if(order_line_num.equals("1")) { 
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block27Bytes, _wl_block27);
                  } // Added for KH-SCF-0010 - End
					else{
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
				} 
				else{	

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);

				if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
				else{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
//added for AAKH-CRF-0024 [IN:038260] Ends
				if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);

				}
				if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
				if(adr_count>0){// added for RUT-SCF-0144 [IN:033371] -- start

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block56Bytes, _wl_block56);

				} // added for RUT-SCF-0144 [IN:033371]  -- end
				 if(prod_name.length()==0){
					if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
													
					}
				}
				if(boolAllergy_icon){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
				if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block63Bytes, _wl_block63);

				}

            _bw.write(_wl_block64Bytes, _wl_block64);

				if(order_line_num.equals("1")) {
					if(adr_reason!=null && !adr_reason.equals("")){

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block51Bytes, _wl_block51);

					}
					else if(!admin_date_time.equals("") && administered.equals("Y")){

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(img_path));
            _bw.write(_wl_block68Bytes, _wl_block68);
														
					}
					else{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block69Bytes, _wl_block69);

					}
				}
				else{	

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block69Bytes, _wl_block69);

				}	

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block75Bytes, _wl_block75);
   
				if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
						
				}
				else{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
                    
				}

				if(could_not_administer.equals("Y")){ //if condition added for SKR-SCF-1264
				qty = "0";
				}
				if(!(MfrYN.equals("Y") && order_line_num.equals("1"))){

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block63Bytes, _wl_block63);

					if(Float.parseFloat(qty) < 1.0){//to prefix a zero

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block86Bytes, _wl_block86);

						if(!qty.equals("0")){ //if condition added for SKR-SCF-1264 - start
						
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block87Bytes, _wl_block87);
}else{ 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block87Bytes, _wl_block87);

						}// added for SKR-SCF-1264 - end
						
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block101Bytes, _wl_block101);

					}
					else{

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block101Bytes, _wl_block101);

					}
					if(!(admn_dose_chng_reason_code.equals(""))){						
						String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(admn_dose_chng_reason_code);

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf("\n"+admn_chng_dose_reason_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);

					}

            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block110Bytes, _wl_block110);
											
					if(freq_nature!=null && freq_nature.equals("C")){

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block114Bytes, _wl_block114);

					}
					else{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);

					}
				}
				else{

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);

				}

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(could_not_administer));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_dosage_uom_code));
            _bw.write(_wl_block132Bytes, _wl_block132);

				if(order_line_num.equals("1")){					
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sfrFLOW_STATUS_style));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(sfrFLOW_STATUS_String));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
				
					} // Added for KH-SCF-0010 - End
					else{
					
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sfrFLOW_STATUS_style));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(sfrFLOW_STATUS_String));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block148Bytes, _wl_block148);
}
				}
				else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block149Bytes, _wl_block149);
				
				}
				if(!(MfrYN.equals("Y") && order_line_num.equals("1"))){

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block150Bytes, _wl_block150);

					if(!(MfrYN.equals("Y") && !(order_line_num.equals("1")))){

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block152Bytes, _wl_block152);

					}

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(sch_infusion_period_unit_label));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(sch_infusion_period_unit_label));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block152Bytes, _wl_block152);

					if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){// added for AAKH-CRF-0024 [IN:038260] Starts

            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)work_sheet_batch_det.get(2)));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block199Bytes, _wl_block199);
	
					}
					else{
						auto_Admin_dis="";						
						if(iv_batch_ids.size()==0){	
							if(iv_Auto_Admin.equals("N")||(hold.equals("Y")) || dis_continued.equals("Y"))
							auto_Admin_dis="disabled";
							else 
							auto_Admin_dis="";

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);

						}
						else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
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
							if(ret_qty<=0){//adding end							

            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);

							}
							else{ //added below condition for incident NO:33194
								expiry_date="";
								select_status_1="";

            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block63Bytes, _wl_block63);

							}

            _bw.write(_wl_block3Bytes, _wl_block3);
						} 
						else{

            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);

							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
								if (defaultBatch.equals((String)iv_batch_ids.get(kk))){

            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
								else{

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block235Bytes, _wl_block235);

								}
							} 

            _bw.write(_wl_block236Bytes, _wl_block236);

						} 
					} 

            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block247Bytes, _wl_block247);

				}
				else{
					MfrDetails=bean.getStatusOfMAR(order_id, "");
					String statusString="";
					if(MfrDetails.size()>0)
					{
						statusString=(String)MfrDetails.get(0);												
					}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(order_line_num.equals("1")){
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
				}
				String md_admn_req ="";
				if(bean.isWitnessedbyRequiredForIV(order_id)){
					md_admn_req="Y";
				}
				if(order_line_num.equals("1")) {
					if(!cmp_flag.equals("N")){	 

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(showTitle));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(md_admn_req));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf((ivRecCount-Integer.parseInt(order_line_num)+1)));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
 
						if(!MfrYN.equals("Y")){

            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

						}

            _bw.write(_wl_block271Bytes, _wl_block271);

					}
					else{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(showTitle));
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(md_admn_req));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block280Bytes, _wl_block280);

						if(!MfrYN.equals("Y")){

            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

						}

            _bw.write(_wl_block271Bytes, _wl_block271);
														
					} // end else on line no.1969
				} // end if(order_line_num.equals("1")) on line no.1957
				else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(md_admn_req));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block282Bytes, _wl_block282);

				}	

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_order_pract_id));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block324Bytes, _wl_block324);

                   if(marForDisPatNotReqYN && dischargedYN){
	                      select_status= "disabled";
	                      displayStyle = "";	
	                      sfrFLOW_STATUS_style ="font-size:8;align:center;";
                    }
                   if(order_line_num.equals("1")){		//added for AAKH-CRF-0024 [IN:038260] start
					select_status=""; 
					if(MfrYN.equals("Y") && !mfrCompletedStatus ){
						select_status="disabled";
					}
					else if(((!MfrYN.equals("Y"))&&(sfrFLOW_STATUS.equals("ST")||sfrFLOW_STATUS.equals("HO")||sfrFLOW_STATUS.equals("RE")))||((hold.equals("Y")) || dis_continued.equals("Y"))){
						select_status="disabled";
					}

            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block331Bytes, _wl_block331);
if(cancelYn.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block333Bytes, _wl_block333);
}
				} 
				else{ 

            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block334Bytes, _wl_block334);

				}

            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block363Bytes, _wl_block363);

				if(!MfrYN.equals("Y")){//added for AAKH-CRF-0024 [IN:038260]

            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block365Bytes, _wl_block365);

				}				
				ivRecCount++;//added for AAKH-CRF-0024 [IN:038260] Ends
			} // end	if(admin_recorded_yn.equals("Y")) on line no. 1827
			else{
					//CRF-413.8
				
				 if(order_line_num.equals("1") && MfrYN!=null && !MfrYN.equals("Y")){
						drug_count = bean.getDrugCount(order_id);
				 }
				iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
				if(ivRecCount==0)
					ivRecCount=1;
				if(order_line_num.equals("1"))
					classvalue="IVFLUID1";
				else
					classvalue="IVINGREDIENT1";

            _bw.write(_wl_block24Bytes, _wl_block24);
              if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
	                 select_status="disabled";
	                 displayStyle = "";	   
	                 sfrFLOW_STATUS_style ="font-size:8;align:center;";
                } // Added for KH-SCF-0010 - End
				if(order_line_num.equals("1")) {					

            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block149Bytes, _wl_block149);

				}
				else {

            _bw.write(_wl_block367Bytes, _wl_block367);

				}	

            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block199Bytes, _wl_block199);

				if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
				else{

            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block386Bytes, _wl_block386);

				}

            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block388Bytes, _wl_block388);

				if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);

				}
				if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}			
				if(adr_count>0){// added for RUT-SCF-0144 [IN:033371]  -- start

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block56Bytes, _wl_block56);

				} // added for RUT-SCF-0144 [IN:033371]  -- end
				if(prod_name.length()==0){
					if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
															
					}
				}

            _bw.write(_wl_block389Bytes, _wl_block389);
if(cancel_recorded_yn.equals("Y") && order_line_num.equals("1")){
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block391Bytes, _wl_block391);
}
            _bw.write(_wl_block1Bytes, _wl_block1);

				if(linkVacScheduleYN.equals("Y")){ 
					if(order_line_num.equals("1")){

            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block394Bytes, _wl_block394);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block404Bytes, _wl_block404);

					}
				}
				if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block63Bytes, _wl_block63);

				}

            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block75Bytes, _wl_block75);
   
				if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){	

            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
					
				}
				else{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
                 
				}
				if(freq_code.equals("STAT"))
					displayStyle="";
				if(Float.parseFloat(qty) < 1.0)
					qty = Float.parseFloat(qty)+""; //to prefix a zero
				if(MfrYN.equals("Y") && order_line_num.equals("1")){

            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);

				}
				else{
					if((hold.equals("Y")) || dis_continued.equals("Y")){
						sfrFLOW_STATUS_disable="disabled";
					}

            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block422Bytes, _wl_block422);

					if(freq_nature!=null && freq_nature.equals("C")){

            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block425Bytes, _wl_block425);

					}

            _bw.write(_wl_block426Bytes, _wl_block426);

				}
				if(order_line_num.equals("1")){ 
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start

            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(sfrFLOW_STATUS_style));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(sfrFLOW_STATUS_String));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
				
					} // Added for KH-SCF-0010 - End
					else{

            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(sfrFLOW_STATUS_style));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(sfrFLOW_STATUS_String));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
                  }
					backGrndColor="";
					fntColor ="";
				}
				else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block149Bytes, _wl_block149);

				}
				if(MfrYN.equals("Y") && order_line_num.equals("1")){
					MfrDetails=bean.getStatusOfMAR(order_id,"");
					String statusString="";
					if(MfrDetails.size()>0){
						statusString=(String)MfrDetails.get(0);
						mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();														
					}
					if(!(hold.equals("Y")) && !(dis_continued.equals("Y"))){													

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(order_line_num.equals("1")){
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block432Bytes, _wl_block432);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block435Bytes, _wl_block435);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);
}
            _bw.write(_wl_block142Bytes, _wl_block142);

					} 
					else {
						mfrCompletedStatus=false;

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(order_line_num.equals("1")){
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block437Bytes, _wl_block437);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block142Bytes, _wl_block142);

					}

            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block460Bytes, _wl_block460);

				}
				else{
					if(MfrYN.equals("Y") && !(order_line_num.equals("1"))){
						if(sch_infusion_rate==null || sch_infusion_rate.equals("null"))
							sch_infusion_rate="0";
						if(!(sch_infusion_rate.equals("")) && Float.parseFloat(sch_infusion_rate) < 1.0)
							sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block149Bytes, _wl_block149);
					}
					else{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block84Bytes, _wl_block84);

					}

            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(sfrFLOW_STATUS_disable));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_dosage_uom_code));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(hide_ingredient_dtls));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(sch_infusion_period_unit_label));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block476Bytes, _wl_block476);
				
					if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){

            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)work_sheet_batch_det.get(1)));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)work_sheet_batch_det.get(2)));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block199Bytes, _wl_block199);
	
					}
					else{
						auto_Admin_dis="";						
						if(iv_batch_ids.size()==0){	
							if(iv_Auto_Admin.equals("N")||(hold.equals("Y")) || dis_continued.equals("Y"))
								auto_Admin_dis="disabled";
							else 
								auto_Admin_dis="";

            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")) //GHL-CRF-0458 //isSiteSpecMARPrint && WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
							} // Added for KH-SCF-0010 - End
						}
						else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
							expiry_date = (String)iv_batch_ids.get(1);
							trade_id	= (String)iv_batch_ids.get(2);
							trade_name  = (String)iv_batch_ids.get(3);
							//added for GHL-CRF-0458 - start
							ward_ack_yn = (String)iv_batch_ids.get(6)==null?"":(String)iv_batch_ids.get(6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";	
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
							} // Added for KH-SCF-0010 - End
							//added for GHL-CRF-0458 - end
							auto_Admin_dis="disabled";
							totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
							for(int j=0;j<totQty.size();j=j+4){
								returned_qty = (Float)totQty.get(j+2);
								tot_administered_qty=  (Float)totQty.get(j+3);
								ret_qty=returned_qty-tot_administered_qty;							 
							}
							if(ret_qty<=0){//adding end							

            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)iv_batch_ids.get(0)));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
								else{ //added below condition for incident NO:33194
									expiry_date="";
									select_status_1="";

            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block63Bytes, _wl_block63);

							}

            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_batch_ids.get(5)));
            _bw.write(_wl_block491Bytes, _wl_block491);
						} // end 	else if(iv_batch_ids.size()==4) on line no.2180
						else{

            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);

								int mm=1;
							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
								if (defaultBatch.equals((String)iv_batch_ids.get(kk))){

            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
								else{

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block235Bytes, _wl_block235);

								}
							} 

            _bw.write(_wl_block236Bytes, _wl_block236);

						for(int kk=0;kk<iv_batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							

            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)iv_batch_ids.get(kk+5)));
            _bw.write(_wl_block63Bytes, _wl_block63);
						mm++;//CRF-413.8
						}
						//added for GHL-CRF-0458 - start
						for(int kk=0;kk<iv_batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							ward_ack_yn = (String)iv_batch_ids.get(kk+6)==null?"":(String)iv_batch_ids.get(kk+6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
								break;
							}
							//added for GHL-CRF-0458 - end
							 if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";	
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
								break;
							} // Added for KH-SCF-0010 - End
						}

						} // end else on line no. 2205

            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(drug_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block499Bytes, _wl_block499);
					} // end else on line no.2163												

            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block502Bytes, _wl_block502);

				} // ending of if MfrYN.equals("Y")
						//added for MMS-KH-CRF-0039 - start
						if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && (iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6"))){
						 ward_ack_yn = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn);
					
						 if(ward_ack_yn==null)
							 ward_ack_yn="";
						
						 if(!ward_ack_yn.equals("A"))
						   select_status="disabled";
						}
						//added for MMS-KH-CRF-0039 - end

            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
				String md_admn_req ="";
				if(bean.isWitnessedbyRequiredForIV(order_id)){
					md_admn_req="Y";
				}
				if(order_line_num.equals("1") && !((hold.equals("Y")) || dis_continued.equals("Y"))){

            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(no_of_doses));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(md_admn_req));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf((ivRecCount-Integer.parseInt(order_line_num)+1)));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block513Bytes, _wl_block513);
				}

            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block516Bytes, _wl_block516);

				if(order_line_num.equals("1") && (!MfrYN.equals("Y"))) { 

            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

				}				

            _bw.write(_wl_block518Bytes, _wl_block518);
 
				if(order_line_num.equals("1")){		
					if(!WardAckMarRequiredYn.equalsIgnoreCase("Y"))//GHL-CRF-0458 // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
					select_status=""; //added for IN24023 --12/11/2010-- priya
					if(MfrYN.equals("Y") && !mfrCompletedStatus ){
						select_status="disabled";
					}
					else if(((!MfrYN.equals("Y"))&&(sfrFLOW_STATUS.equals("ST")||sfrFLOW_STATUS.equals("HO")||sfrFLOW_STATUS.equals("RE")))||((hold.equals("Y")) || dis_continued.equals("Y"))){
						select_status="disabled";
					}
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
						select_status="disabled";
						displayStyle = "";		
						sfrFLOW_STATUS_style ="font-size:8;align:center;";
					} // Added for KH-SCF-0010 - End

            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block521Bytes, _wl_block521);

				} 
				else{ 

            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block334Bytes, _wl_block334);

				}	

            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_Auto_Admin));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_order_pract_id));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_count));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iv_batch_ids.size()));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block540Bytes, _wl_block540);
			
				if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ //added for GHL-CRF-0458 - start // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]

            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block545Bytes, _wl_block545);
				} //added for GHL-CRF-0458 - end
				if(!MfrYN.equals("Y")){

            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block546Bytes, _wl_block546);

				}
				ivRecCount++;//added for AAKH-CRF-0024 [IN:038260] Ends
			} // end else on line no. 2010
		} // end for(int i=0;i<iv_drug_details.size();i=i+54)
		

            _bw.write(_wl_block547Bytes, _wl_block547);

	} // end if(iv_drug_details.size()>0)

            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(ivRecCount));
            _bw.write(_wl_block549Bytes, _wl_block549);
            _bw.write(_wl_block550Bytes, _wl_block550);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid/Ingrediant.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitDose.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RouteOfAdministration.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SchTime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionDate/Time.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionPeriod.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVAdministration.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
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
}
